package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class BitmapHunter implements Runnable {
    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request request) {
            return true;
        }

        public Result load(Request request, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unrecognized type of request: ");
            stringBuilder.append(request);
            throw new IllegalStateException(stringBuilder.toString());
        }
    };
    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
        protected StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    Action action;
    List<Action> actions;
    final Cache cache;
    final Request data;
    final Dispatcher dispatcher;
    Exception exception;
    int exifOrientation;
    Future<?> future;
    final String key;
    LoadedFrom loadedFrom;
    final int memoryPolicy;
    int networkPolicy;
    final Picasso picasso;
    Priority priority;
    final RequestHandler requestHandler;
    Bitmap result;
    int retryCount;
    final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
    final Stats stats;

    static int getExifRotation(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    static int getExifTranslation(int i) {
        if (!(i == 2 || i == 7)) {
            switch (i) {
                case 4:
                case 5:
                    break;
                default:
                    return 1;
            }
        }
        return -1;
    }

    private static boolean shouldResize(boolean z, int i, int i2, int i3, int i4) {
        return !z || ((i3 != 0 && i > i3) || (i4 != 0 && i2 > i4));
    }

    BitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, RequestHandler requestHandler) {
        this.picasso = picasso;
        this.dispatcher = dispatcher;
        this.cache = cache;
        this.stats = stats;
        this.action = action;
        this.key = action.getKey();
        this.data = action.getRequest();
        this.priority = action.getPriority();
        this.memoryPolicy = action.getMemoryPolicy();
        this.networkPolicy = action.getNetworkPolicy();
        this.requestHandler = requestHandler;
        this.retryCount = requestHandler.getRetryCount();
    }

    static Bitmap decodeStream(InputStream inputStream, Request request) {
        InputStream markableInputStream = new MarkableInputStream(inputStream);
        markableInputStream.allowMarksToExpire(false);
        long savePosition = markableInputStream.savePosition(1024);
        Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
        boolean requiresInSampleSize = RequestHandler.requiresInSampleSize(createBitmapOptions);
        boolean isWebPFile = Utils.isWebPFile(markableInputStream);
        Object obj = (!request.purgeable || VERSION.SDK_INT >= 21) ? null : 1;
        markableInputStream.reset(savePosition);
        if (isWebPFile || obj != null) {
            byte[] toByteArray = Utils.toByteArray(markableInputStream);
            if (requiresInSampleSize) {
                BitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length, createBitmapOptions);
                RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
            }
            return BitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length, createBitmapOptions);
        }
        if (requiresInSampleSize) {
            BitmapFactory.decodeStream(markableInputStream, null, createBitmapOptions);
            RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
            markableInputStream.reset(savePosition);
        }
        markableInputStream.allowMarksToExpire(true);
        Bitmap decodeStream = BitmapFactory.decodeStream(markableInputStream, null, createBitmapOptions);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public void run() {
        try {
            updateThreadName(this.data);
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
            }
            this.result = hunt();
            if (this.result == null) {
                this.dispatcher.dispatchFailed(this);
            } else {
                this.dispatcher.dispatchComplete(this);
            }
        } catch (Exception e) {
            if (!(e.localCacheOnly && e.responseCode == 504)) {
                this.exception = e;
            }
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e2) {
            this.exception = e2;
            this.dispatcher.dispatchRetry(this);
        } catch (Exception e22) {
            this.exception = e22;
            this.dispatcher.dispatchRetry(this);
        } catch (Throwable e3) {
            Writer stringWriter = new StringWriter();
            this.stats.createSnapshot().dump(new PrintWriter(stringWriter));
            this.exception = new RuntimeException(stringWriter.toString(), e3);
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e222) {
            this.exception = e222;
            this.dispatcher.dispatchFailed(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    Bitmap hunt() {
        Bitmap bitmap;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
            bitmap = this.cache.get(this.key);
            if (bitmap != null) {
                this.stats.dispatchCacheHit();
                this.loadedFrom = LoadedFrom.MEMORY;
                if (this.picasso.loggingEnabled) {
                    Utils.log("Hunter", "decoded", this.data.logId(), "from cache");
                }
                return bitmap;
            }
        }
        bitmap = null;
        this.data.networkPolicy = this.retryCount == 0 ? NetworkPolicy.OFFLINE.index : this.networkPolicy;
        Result load = this.requestHandler.load(this.data, this.networkPolicy);
        if (load != null) {
            this.loadedFrom = load.getLoadedFrom();
            this.exifOrientation = load.getExifOrientation();
            bitmap = load.getBitmap();
            if (bitmap == null) {
                InputStream stream = load.getStream();
                try {
                    Bitmap decodeStream = decodeStream(stream, this.data);
                    bitmap = decodeStream;
                } finally {
                    Utils.closeQuietly(stream);
                }
            }
        }
        if (bitmap != null) {
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "decoded", this.data.logId());
            }
            this.stats.dispatchBitmapDecoded(bitmap);
            if (this.data.needsTransformation() || this.exifOrientation != 0) {
                synchronized (DECODE_LOCK) {
                    if (this.data.needsMatrixTransform() || this.exifOrientation != 0) {
                        bitmap = transformResult(this.data, bitmap, this.exifOrientation);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId());
                        }
                    }
                    if (this.data.hasCustomTransformations()) {
                        bitmap = applyCustomTransformations(this.data.transformations, bitmap);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.stats.dispatchBitmapTransformed(bitmap);
                }
            }
        }
        return bitmap;
    }

    void attach(Action action) {
        boolean z = this.picasso.loggingEnabled;
        Request request = action.request;
        if (this.action == null) {
            this.action = action;
            if (z) {
                if (this.actions == null || this.actions.isEmpty()) {
                    Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
                } else {
                    Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
                }
            }
            return;
        }
        if (this.actions == null) {
            this.actions = new ArrayList(3);
        }
        this.actions.add(action);
        if (z) {
            Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
        }
        Priority priority = action.getPriority();
        if (priority.ordinal() > this.priority.ordinal()) {
            this.priority = priority;
        }
    }

    void detach(Action action) {
        boolean z;
        if (this.action == action) {
            this.action = null;
            z = true;
        } else {
            z = this.actions != null ? this.actions.remove(action) : false;
        }
        if (z && action.getPriority() == this.priority) {
            this.priority = computeNewPriority();
        }
        if (this.picasso.loggingEnabled) {
            Utils.log("Hunter", "removed", action.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
    }

    private Priority computeNewPriority() {
        Priority priority = Priority.LOW;
        Object obj = 1;
        Object obj2 = (this.actions == null || this.actions.isEmpty()) ? null : 1;
        if (this.action == null && obj2 == null) {
            obj = null;
        }
        if (obj == null) {
            return priority;
        }
        if (this.action != null) {
            priority = this.action.getPriority();
        }
        if (obj2 != null) {
            int size = this.actions.size();
            for (int i = 0; i < size; i++) {
                Priority priority2 = ((Action) this.actions.get(i)).getPriority();
                if (priority2.ordinal() > priority.ordinal()) {
                    priority = priority2;
                }
            }
        }
        return priority;
    }

    boolean cancel() {
        if (this.action != null) {
            return false;
        }
        if ((this.actions == null || this.actions.isEmpty()) && this.future != null && this.future.cancel(false)) {
            return true;
        }
        return false;
    }

    boolean isCancelled() {
        return this.future != null && this.future.isCancelled();
    }

    boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        if ((this.retryCount > 0 ? 1 : null) == null) {
            return false;
        }
        this.retryCount--;
        return this.requestHandler.shouldRetry(z, networkInfo);
    }

    boolean supportsReplay() {
        return this.requestHandler.supportsReplay();
    }

    Bitmap getResult() {
        return this.result;
    }

    String getKey() {
        return this.key;
    }

    int getMemoryPolicy() {
        return this.memoryPolicy;
    }

    Request getData() {
        return this.data;
    }

    Action getAction() {
        return this.action;
    }

    Picasso getPicasso() {
        return this.picasso;
    }

    List<Action> getActions() {
        return this.actions;
    }

    Exception getException() {
        return this.exception;
    }

    LoadedFrom getLoadedFrom() {
        return this.loadedFrom;
    }

    Priority getPriority() {
        return this.priority;
    }

    static void updateThreadName(Request request) {
        String name = request.getName();
        StringBuilder stringBuilder = (StringBuilder) NAME_BUILDER.get();
        stringBuilder.ensureCapacity("Picasso-".length() + name.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), name);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    static BitmapHunter forRequest(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        Request request = action.getRequest();
        List requestHandlers = picasso.getRequestHandlers();
        int size = requestHandlers.size();
        for (int i = 0; i < size; i++) {
            RequestHandler requestHandler = (RequestHandler) requestHandlers.get(i);
            if (requestHandler.canHandleRequest(request)) {
                return new BitmapHunter(picasso, dispatcher, cache, stats, action, requestHandler);
            }
        }
        return new BitmapHunter(picasso, dispatcher, cache, stats, action, ERRORING_HANDLER);
    }

    static Bitmap applyCustomTransformations(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final Transformation transformation = (Transformation) list.get(i);
            try {
                Bitmap transform = transformation.transform(bitmap);
                if (transform == null) {
                    final StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Transformation ");
                    stringBuilder.append(transformation.key());
                    stringBuilder.append(" returned null after ");
                    stringBuilder.append(i);
                    stringBuilder.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation key : list) {
                        stringBuilder.append(key.key());
                        stringBuilder.append(10);
                    }
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(stringBuilder.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Transformation ");
                            stringBuilder.append(transformation.key());
                            stringBuilder.append(" returned input Bitmap but recycled it.");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i++;
                    bitmap = transform;
                } else {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Transformation ");
                            stringBuilder.append(transformation.key());
                            stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    });
                    return null;
                }
            } catch (final RuntimeException e) {
                Picasso.HANDLER.post(new Runnable() {
                    public void run() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Transformation ");
                        stringBuilder.append(transformation.key());
                        stringBuilder.append(" crashed with exception.");
                        throw new RuntimeException(stringBuilder.toString(), e);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0281  */
    static android.graphics.Bitmap transformResult(com.squareup.picasso.Request r31, android.graphics.Bitmap r32, int r33) {
        /*
        r0 = r31;
        r2 = r32.getWidth();
        r3 = r32.getHeight();
        r4 = r0.onlyScaleDown;
        r10 = new android.graphics.Matrix;
        r10.<init>();
        r5 = r31.needsMatrixTransform();
        if (r5 != 0) goto L_0x001f;
    L_0x0017:
        if (r33 == 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001f;
    L_0x001a:
        r4 = r3;
        r1 = r10;
        r3 = r2;
        goto L_0x0271;
    L_0x001f:
        r5 = r0.targetWidth;
        r7 = r0.targetHeight;
        r8 = r0.rotationDegrees;
        r9 = 0;
        r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1));
        if (r9 == 0) goto L_0x015d;
    L_0x002a:
        r11 = (double) r8;
        r13 = java.lang.Math.toRadians(r11);
        r13 = java.lang.Math.cos(r13);
        r11 = java.lang.Math.toRadians(r11);
        r11 = java.lang.Math.sin(r11);
        r5 = r0.hasRotationPivot;
        if (r5 == 0) goto L_0x00e4;
    L_0x003f:
        r5 = r0.rotationPivotX;
        r7 = r0.rotationPivotY;
        r10.setRotate(r8, r5, r7);
        r5 = r0.rotationPivotX;
        r7 = (double) r5;
        r15 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r15 = r15 - r13;
        r7 = r7 * r15;
        r5 = r0.rotationPivotY;
        r5 = (double) r5;
        r5 = r5 * r11;
        r7 = r7 + r5;
        r5 = r0.rotationPivotY;
        r5 = (double) r5;
        r5 = r5 * r15;
        r9 = r0.rotationPivotX;
        r18 = r3;
        r19 = r4;
        r3 = (double) r9;
        r3 = r3 * r11;
        r5 = r5 - r3;
        r3 = r0.targetWidth;
        r3 = (double) r3;
        r3 = r3 * r13;
        r3 = r3 + r7;
        r9 = r0.targetWidth;
        r20 = r2;
        r1 = (double) r9;
        r1 = r1 * r11;
        r1 = r1 + r5;
        r9 = r0.targetWidth;
        r21 = r10;
        r9 = (double) r9;
        r9 = r9 * r13;
        r9 = r9 + r7;
        r15 = r0.targetHeight;
        r22 = r1;
        r1 = (double) r15;
        r1 = r1 * r11;
        r9 = r9 - r1;
        r1 = r0.targetWidth;
        r1 = (double) r1;
        r1 = r1 * r11;
        r1 = r1 + r5;
        r15 = r0.targetHeight;
        r24 = r9;
        r9 = (double) r15;
        r9 = r9 * r13;
        r1 = r1 + r9;
        r9 = r0.targetHeight;
        r9 = (double) r9;
        r9 = r9 * r11;
        r9 = r7 - r9;
        r11 = r0.targetHeight;
        r11 = (double) r11;
        r11 = r11 * r13;
        r11 = r11 + r5;
        r13 = java.lang.Math.max(r7, r3);
        r26 = r11;
        r11 = r24;
        r13 = java.lang.Math.max(r11, r13);
        r13 = java.lang.Math.max(r9, r13);
        r3 = java.lang.Math.min(r7, r3);
        r3 = java.lang.Math.min(r11, r3);
        r3 = java.lang.Math.min(r9, r3);
        r7 = r22;
        r9 = java.lang.Math.max(r5, r7);
        r9 = java.lang.Math.max(r1, r9);
        r11 = r26;
        r9 = java.lang.Math.max(r11, r9);
        r5 = java.lang.Math.min(r5, r7);
        r1 = java.lang.Math.min(r1, r5);
        r1 = java.lang.Math.min(r11, r1);
        r13 = r13 - r3;
        r3 = java.lang.Math.floor(r13);
        r5 = (int) r3;
        r9 = r9 - r1;
        r1 = java.lang.Math.floor(r9);
        r7 = (int) r1;
        r1 = r21;
        goto L_0x0164;
    L_0x00e4:
        r20 = r2;
        r18 = r3;
        r19 = r4;
        r1 = r10;
        r1.setRotate(r8);
        r2 = r0.targetWidth;
        r2 = (double) r2;
        r2 = r2 * r13;
        r4 = r0.targetWidth;
        r4 = (double) r4;
        r4 = r4 * r11;
        r6 = r0.targetWidth;
        r6 = (double) r6;
        r6 = r6 * r13;
        r8 = r0.targetHeight;
        r8 = (double) r8;
        r8 = r8 * r11;
        r6 = r6 - r8;
        r8 = r0.targetWidth;
        r8 = (double) r8;
        r8 = r8 * r11;
        r10 = r0.targetHeight;
        r28 = r4;
        r4 = (double) r10;
        r4 = r4 * r13;
        r8 = r8 + r4;
        r4 = r0.targetHeight;
        r4 = (double) r4;
        r4 = r4 * r11;
        r4 = -r4;
        r10 = r0.targetHeight;
        r10 = (double) r10;
        r10 = r10 * r13;
        r12 = 0;
        r14 = java.lang.Math.max(r12, r2);
        r14 = java.lang.Math.max(r6, r14);
        r14 = java.lang.Math.max(r4, r14);
        r2 = java.lang.Math.min(r12, r2);
        r2 = java.lang.Math.min(r6, r2);
        r2 = java.lang.Math.min(r4, r2);
        r4 = r28;
        r6 = java.lang.Math.max(r12, r4);
        r6 = java.lang.Math.max(r8, r6);
        r6 = java.lang.Math.max(r10, r6);
        r4 = java.lang.Math.min(r12, r4);
        r4 = java.lang.Math.min(r8, r4);
        r4 = java.lang.Math.min(r10, r4);
        r14 = r14 - r2;
        r2 = java.lang.Math.floor(r14);
        r2 = (int) r2;
        r6 = r6 - r4;
        r3 = java.lang.Math.floor(r6);
        r7 = (int) r3;
        r5 = r2;
        goto L_0x0164;
    L_0x015d:
        r20 = r2;
        r18 = r3;
        r19 = r4;
        r1 = r10;
    L_0x0164:
        if (r33 == 0) goto L_0x018a;
    L_0x0166:
        r3 = getExifRotation(r33);
        r2 = getExifTranslation(r33);
        if (r3 == 0) goto L_0x0181;
    L_0x0170:
        r4 = (float) r3;
        r1.preRotate(r4);
        r4 = 90;
        if (r3 == r4) goto L_0x017c;
    L_0x0178:
        r4 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        if (r3 != r4) goto L_0x0181;
    L_0x017c:
        r30 = r7;
        r7 = r5;
        r5 = r30;
    L_0x0181:
        r3 = 1;
        if (r2 == r3) goto L_0x018a;
    L_0x0184:
        r2 = (float) r2;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.postScale(r2, r3);
    L_0x018a:
        r2 = r0.centerCrop;
        if (r2 == 0) goto L_0x0222;
    L_0x018e:
        if (r5 == 0) goto L_0x0198;
    L_0x0190:
        r2 = (float) r5;
        r3 = r20;
        r4 = (float) r3;
        r2 = r2 / r4;
        r4 = r18;
        goto L_0x019f;
    L_0x0198:
        r3 = r20;
        r2 = (float) r7;
        r4 = r18;
        r6 = (float) r4;
        r2 = r2 / r6;
    L_0x019f:
        if (r7 == 0) goto L_0x01a5;
    L_0x01a1:
        r6 = (float) r7;
        r8 = (float) r4;
    L_0x01a3:
        r6 = r6 / r8;
        goto L_0x01a8;
    L_0x01a5:
        r6 = (float) r5;
        r8 = (float) r3;
        goto L_0x01a3;
    L_0x01a8:
        r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r8 <= 0) goto L_0x01d8;
    L_0x01ac:
        r8 = (float) r4;
        r6 = r6 / r2;
        r8 = r8 * r6;
        r8 = (double) r8;
        r8 = java.lang.Math.ceil(r8);
        r6 = (int) r8;
        r8 = r0.centerCropGravity;
        r9 = 48;
        r8 = r8 & r9;
        if (r8 != r9) goto L_0x01bf;
    L_0x01bd:
        r0 = 0;
        goto L_0x01cd;
    L_0x01bf:
        r0 = r0.centerCropGravity;
        r8 = 80;
        r0 = r0 & r8;
        if (r0 != r8) goto L_0x01c9;
    L_0x01c6:
        r0 = r4 - r6;
        goto L_0x01cd;
    L_0x01c9:
        r0 = r4 - r6;
        r0 = r0 / 2;
    L_0x01cd:
        r8 = (float) r7;
        r9 = (float) r6;
        r8 = r8 / r9;
        r9 = r3;
        r10 = r6;
        r17 = 0;
        r6 = r2;
        r2 = r19;
        goto L_0x0213;
    L_0x01d8:
        r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r8 >= 0) goto L_0x020b;
    L_0x01dc:
        r8 = (float) r3;
        r2 = r2 / r6;
        r8 = r8 * r2;
        r8 = (double) r8;
        r8 = java.lang.Math.ceil(r8);
        r2 = (int) r8;
        r8 = r0.centerCropGravity;
        r9 = 3;
        r8 = r8 & r9;
        if (r8 != r9) goto L_0x01ee;
    L_0x01ec:
        r0 = 0;
        goto L_0x01fb;
    L_0x01ee:
        r0 = r0.centerCropGravity;
        r8 = 5;
        r0 = r0 & r8;
        if (r0 != r8) goto L_0x01f7;
    L_0x01f4:
        r0 = r3 - r2;
        goto L_0x01fb;
    L_0x01f7:
        r0 = r3 - r2;
        r0 = r0 / 2;
    L_0x01fb:
        r8 = (float) r5;
        r9 = (float) r2;
        r8 = r8 / r9;
        r17 = r0;
        r9 = r2;
        r10 = r4;
        r2 = r19;
        r0 = 0;
        r30 = r8;
        r8 = r6;
        r6 = r30;
        goto L_0x0213;
    L_0x020b:
        r9 = r3;
        r10 = r4;
        r8 = r6;
        r2 = r19;
        r0 = 0;
        r17 = 0;
    L_0x0213:
        r2 = shouldResize(r2, r3, r4, r5, r7);
        if (r2 == 0) goto L_0x021c;
    L_0x0219:
        r1.preScale(r6, r8);
    L_0x021c:
        r7 = r0;
        r8 = r9;
        r9 = r10;
        r6 = r17;
        goto L_0x0275;
    L_0x0222:
        r4 = r18;
        r2 = r19;
        r3 = r20;
        r0 = r0.centerInside;
        if (r0 == 0) goto L_0x024e;
    L_0x022c:
        if (r5 == 0) goto L_0x0232;
    L_0x022e:
        r0 = (float) r5;
        r6 = (float) r3;
    L_0x0230:
        r0 = r0 / r6;
        goto L_0x0235;
    L_0x0232:
        r0 = (float) r7;
        r6 = (float) r4;
        goto L_0x0230;
    L_0x0235:
        if (r7 == 0) goto L_0x023b;
    L_0x0237:
        r6 = (float) r7;
        r8 = (float) r4;
    L_0x0239:
        r6 = r6 / r8;
        goto L_0x023e;
    L_0x023b:
        r6 = (float) r5;
        r8 = (float) r3;
        goto L_0x0239;
    L_0x023e:
        r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r8 >= 0) goto L_0x0243;
    L_0x0242:
        goto L_0x0244;
    L_0x0243:
        r0 = r6;
    L_0x0244:
        r2 = shouldResize(r2, r3, r4, r5, r7);
        if (r2 == 0) goto L_0x0271;
    L_0x024a:
        r1.preScale(r0, r0);
        goto L_0x0271;
    L_0x024e:
        if (r5 != 0) goto L_0x0252;
    L_0x0250:
        if (r7 == 0) goto L_0x0271;
    L_0x0252:
        if (r5 != r3) goto L_0x0256;
    L_0x0254:
        if (r7 == r4) goto L_0x0271;
    L_0x0256:
        if (r5 == 0) goto L_0x025c;
    L_0x0258:
        r0 = (float) r5;
        r6 = (float) r3;
    L_0x025a:
        r0 = r0 / r6;
        goto L_0x025f;
    L_0x025c:
        r0 = (float) r7;
        r6 = (float) r4;
        goto L_0x025a;
    L_0x025f:
        if (r7 == 0) goto L_0x0265;
    L_0x0261:
        r6 = (float) r7;
        r8 = (float) r4;
    L_0x0263:
        r6 = r6 / r8;
        goto L_0x0268;
    L_0x0265:
        r6 = (float) r5;
        r8 = (float) r3;
        goto L_0x0263;
    L_0x0268:
        r2 = shouldResize(r2, r3, r4, r5, r7);
        if (r2 == 0) goto L_0x0271;
    L_0x026e:
        r1.preScale(r0, r6);
    L_0x0271:
        r8 = r3;
        r9 = r4;
        r6 = 0;
        r7 = 0;
    L_0x0275:
        r11 = 1;
        r5 = r32;
        r10 = r1;
        r0 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11);
        r1 = r32;
        if (r0 == r1) goto L_0x0285;
    L_0x0281:
        r32.recycle();
        goto L_0x0286;
    L_0x0285:
        r0 = r1;
    L_0x0286:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.transformResult(com.squareup.picasso.Request, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
