package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class Picasso {
    static final Handler HANDLER = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                List list;
                if (i == 8) {
                    list = (List) message.obj;
                    i = list.size();
                    while (i2 < i) {
                        BitmapHunter bitmapHunter = (BitmapHunter) list.get(i2);
                        bitmapHunter.picasso.complete(bitmapHunter);
                        i2++;
                    }
                    return;
                } else if (i != 13) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown handler message received: ");
                    stringBuilder.append(message.what);
                    throw new AssertionError(stringBuilder.toString());
                } else {
                    list = (List) message.obj;
                    i = list.size();
                    while (i2 < i) {
                        Action action = (Action) list.get(i2);
                        action.picasso.resumeAction(action);
                        i2++;
                    }
                    return;
                }
            }
            Action action2 = (Action) message.obj;
            if (action2.getPicasso().loggingEnabled) {
                Utils.log("Main", "canceled", action2.request.logId(), "target got garbage collected");
            }
            action2.picasso.cancelExistingRequest(action2.getTarget());
        }
    };
    static final String TAG = "Picasso";
    static volatile Picasso singleton;
    final Cache cache;
    private final CleanupThread cleanupThread;
    final Context context;
    final Config defaultBitmapConfig;
    final Dispatcher dispatcher;
    boolean indicatorsEnabled;
    private final Listener listener;
    volatile boolean loggingEnabled;
    final ReferenceQueue<Object> referenceQueue;
    private final List<RequestHandler> requestHandlers;
    private final RequestTransformer requestTransformer;
    boolean shutdown;
    final Stats stats;
    final Map<Object, Action> targetToAction;
    final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator;

    public static class Builder {
        private Cache cache;
        private final Context context;
        private Config defaultBitmapConfig;
        private Downloader downloader;
        private boolean indicatorsEnabled;
        private Listener listener;
        private boolean loggingEnabled;
        private List<RequestHandler> requestHandlers;
        private ExecutorService service;
        private RequestTransformer transformer;

        public Builder(@NonNull Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context.getApplicationContext();
        }

        public Builder defaultBitmapConfig(@NonNull Config config) {
            if (config == null) {
                throw new IllegalArgumentException("Bitmap config must not be null.");
            }
            this.defaultBitmapConfig = config;
            return this;
        }

        public Builder downloader(@NonNull Downloader downloader) {
            if (downloader == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            } else if (this.downloader != null) {
                throw new IllegalStateException("Downloader already set.");
            } else {
                this.downloader = downloader;
                return this;
            }
        }

        public Builder executor(@NonNull ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            } else if (this.service != null) {
                throw new IllegalStateException("Executor service already set.");
            } else {
                this.service = executorService;
                return this;
            }
        }

        public Builder memoryCache(@NonNull Cache cache) {
            if (cache == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            } else if (this.cache != null) {
                throw new IllegalStateException("Memory cache already set.");
            } else {
                this.cache = cache;
                return this;
            }
        }

        public Builder listener(@NonNull Listener listener) {
            if (listener == null) {
                throw new IllegalArgumentException("Listener must not be null.");
            } else if (this.listener != null) {
                throw new IllegalStateException("Listener already set.");
            } else {
                this.listener = listener;
                return this;
            }
        }

        public Builder requestTransformer(@NonNull RequestTransformer requestTransformer) {
            if (requestTransformer == null) {
                throw new IllegalArgumentException("Transformer must not be null.");
            } else if (this.transformer != null) {
                throw new IllegalStateException("Transformer already set.");
            } else {
                this.transformer = requestTransformer;
                return this;
            }
        }

        public Builder addRequestHandler(@NonNull RequestHandler requestHandler) {
            if (requestHandler == null) {
                throw new IllegalArgumentException("RequestHandler must not be null.");
            }
            if (this.requestHandlers == null) {
                this.requestHandlers = new ArrayList();
            }
            if (this.requestHandlers.contains(requestHandler)) {
                throw new IllegalStateException("RequestHandler already registered.");
            }
            this.requestHandlers.add(requestHandler);
            return this;
        }

        @Deprecated
        public Builder debugging(boolean z) {
            return indicatorsEnabled(z);
        }

        public Builder indicatorsEnabled(boolean z) {
            this.indicatorsEnabled = z;
            return this;
        }

        public Builder loggingEnabled(boolean z) {
            this.loggingEnabled = z;
            return this;
        }

        public Picasso build() {
            Context context = this.context;
            if (this.downloader == null) {
                this.downloader = Utils.createDefaultDownloader(context);
            }
            if (this.cache == null) {
                this.cache = new LruCache(context);
            }
            if (this.service == null) {
                this.service = new PicassoExecutorService();
            }
            if (this.transformer == null) {
                this.transformer = RequestTransformer.IDENTITY;
            }
            Stats stats = new Stats(this.cache);
            Context context2 = context;
            return new Picasso(context2, new Dispatcher(context2, this.service, Picasso.HANDLER, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, this.requestHandlers, stats, this.defaultBitmapConfig, this.indicatorsEnabled, this.loggingEnabled);
        }
    }

    private static class CleanupThread extends Thread {
        private final Handler handler;
        private final ReferenceQueue<Object> referenceQueue;

        CleanupThread(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.referenceQueue = referenceQueue;
            this.handler = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    RequestWeakReference requestWeakReference = (RequestWeakReference) this.referenceQueue.remove(1000);
                    Message obtainMessage = this.handler.obtainMessage();
                    if (requestWeakReference != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = requestWeakReference.action;
                        this.handler.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (final Exception e) {
                    this.handler.post(new Runnable() {
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        }

        void shutdown() {
            interrupt();
        }
    }

    public interface Listener {
        void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception);
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);
        
        final int debugColor;

        private LoadedFrom(int i) {
            this.debugColor = i;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    public interface RequestTransformer {
        public static final RequestTransformer IDENTITY = new RequestTransformer() {
            public Request transformRequest(Request request) {
                return request;
            }
        };

        Request transformRequest(Request request);
    }

    Picasso(Context context, Dispatcher dispatcher, Cache cache, Listener listener, RequestTransformer requestTransformer, List<RequestHandler> list, Stats stats, Config config, boolean z, boolean z2) {
        this.context = context;
        this.dispatcher = dispatcher;
        this.cache = cache;
        this.listener = listener;
        this.requestTransformer = requestTransformer;
        this.defaultBitmapConfig = config;
        List arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ResourceRequestHandler(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new ContactsPhotoRequestHandler(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new ContentStreamRequestHandler(context));
        arrayList.add(new AssetRequestHandler(context));
        arrayList.add(new FileRequestHandler(context));
        arrayList.add(new NetworkRequestHandler(dispatcher.downloader, stats));
        this.requestHandlers = Collections.unmodifiableList(arrayList);
        this.stats = stats;
        this.targetToAction = new WeakHashMap();
        this.targetToDeferredRequestCreator = new WeakHashMap();
        this.indicatorsEnabled = z;
        this.loggingEnabled = z2;
        this.referenceQueue = new ReferenceQueue();
        this.cleanupThread = new CleanupThread(this.referenceQueue, HANDLER);
        this.cleanupThread.start();
    }

    public void cancelRequest(@NonNull ImageView imageView) {
        if (imageView == null) {
            throw new IllegalArgumentException("view cannot be null.");
        }
        cancelExistingRequest(imageView);
    }

    public void cancelRequest(@NonNull Target target) {
        if (target == null) {
            throw new IllegalArgumentException("target cannot be null.");
        }
        cancelExistingRequest(target);
    }

    public void cancelRequest(@NonNull RemoteViews remoteViews, @IdRes int i) {
        if (remoteViews == null) {
            throw new IllegalArgumentException("remoteViews cannot be null.");
        }
        cancelExistingRequest(new RemoteViewsTarget(remoteViews, i));
    }

    public void cancelTag(@NonNull Object obj) {
        Utils.checkMain();
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancel requests with null tag.");
        }
        List arrayList = new ArrayList(this.targetToAction.values());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Action action = (Action) arrayList.get(i);
            if (obj.equals(action.getTag())) {
                cancelExistingRequest(action.getTarget());
            }
        }
        arrayList = new ArrayList(this.targetToDeferredRequestCreator.values());
        size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) arrayList.get(i2);
            if (obj.equals(deferredRequestCreator.getTag())) {
                deferredRequestCreator.cancel();
            }
        }
    }

    public void pauseTag(@NonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("tag == null");
        }
        this.dispatcher.dispatchPauseTag(obj);
    }

    public void resumeTag(@NonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("tag == null");
        }
        this.dispatcher.dispatchResumeTag(obj);
    }

    public RequestCreator load(@Nullable Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    public RequestCreator load(@Nullable String str) {
        if (str == null) {
            return new RequestCreator(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return load(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public RequestCreator load(@NonNull File file) {
        if (file == null) {
            return new RequestCreator(this, null, 0);
        }
        return load(Uri.fromFile(file));
    }

    public RequestCreator load(@DrawableRes int i) {
        if (i != 0) {
            return new RequestCreator(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public void invalidate(@Nullable Uri uri) {
        if (uri != null) {
            this.cache.clearKeyUri(uri.toString());
        }
    }

    public void invalidate(@Nullable String str) {
        if (str != null) {
            invalidate(Uri.parse(str));
        }
    }

    public void invalidate(@NonNull File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        invalidate(Uri.fromFile(file));
    }

    @Deprecated
    public boolean isDebugging() {
        return areIndicatorsEnabled() && isLoggingEnabled();
    }

    @Deprecated
    public void setDebugging(boolean z) {
        setIndicatorsEnabled(z);
    }

    public void setIndicatorsEnabled(boolean z) {
        this.indicatorsEnabled = z;
    }

    public boolean areIndicatorsEnabled() {
        return this.indicatorsEnabled;
    }

    public void setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public StatsSnapshot getSnapshot() {
        return this.stats.createSnapshot();
    }

    public void shutdown() {
        if (this == singleton) {
            throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
        } else if (!this.shutdown) {
            this.cache.clear();
            this.cleanupThread.shutdown();
            this.stats.shutdown();
            this.dispatcher.shutdown();
            for (DeferredRequestCreator cancel : this.targetToDeferredRequestCreator.values()) {
                cancel.cancel();
            }
            this.targetToDeferredRequestCreator.clear();
            this.shutdown = true;
        }
    }

    List<RequestHandler> getRequestHandlers() {
        return this.requestHandlers;
    }

    Request transformRequest(Request request) {
        Request transformRequest = this.requestTransformer.transformRequest(request);
        if (transformRequest != null) {
            return transformRequest;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request transformer ");
        stringBuilder.append(this.requestTransformer.getClass().getCanonicalName());
        stringBuilder.append(" returned null for ");
        stringBuilder.append(request);
        throw new IllegalStateException(stringBuilder.toString());
    }

    void defer(ImageView imageView, DeferredRequestCreator deferredRequestCreator) {
        if (this.targetToDeferredRequestCreator.containsKey(imageView)) {
            cancelExistingRequest(imageView);
        }
        this.targetToDeferredRequestCreator.put(imageView, deferredRequestCreator);
    }

    void enqueueAndSubmit(Action action) {
        Object target = action.getTarget();
        if (!(target == null || this.targetToAction.get(target) == action)) {
            cancelExistingRequest(target);
            this.targetToAction.put(target, action);
        }
        submit(action);
    }

    void submit(Action action) {
        this.dispatcher.dispatchSubmit(action);
    }

    Bitmap quickMemoryCacheCheck(String str) {
        Bitmap bitmap = this.cache.get(str);
        if (bitmap != null) {
            this.stats.dispatchCacheHit();
        } else {
            this.stats.dispatchCacheMiss();
        }
        return bitmap;
    }

    void complete(BitmapHunter bitmapHunter) {
        Action action = bitmapHunter.getAction();
        List actions = bitmapHunter.getActions();
        Object obj = 1;
        Object obj2 = (actions == null || actions.isEmpty()) ? null : 1;
        if (action == null && obj2 == null) {
            obj = null;
        }
        if (obj != null) {
            Uri uri = bitmapHunter.getData().uri;
            Exception exception = bitmapHunter.getException();
            Bitmap result = bitmapHunter.getResult();
            LoadedFrom loadedFrom = bitmapHunter.getLoadedFrom();
            if (action != null) {
                deliverAction(result, loadedFrom, action);
            }
            if (obj2 != null) {
                int size = actions.size();
                for (int i = 0; i < size; i++) {
                    deliverAction(result, loadedFrom, (Action) actions.get(i));
                }
            }
            if (!(this.listener == null || exception == null)) {
                this.listener.onImageLoadFailed(this, uri, exception);
            }
        }
    }

    void resumeAction(Action action) {
        Bitmap quickMemoryCacheCheck = MemoryPolicy.shouldReadFromMemoryCache(action.memoryPolicy) ? quickMemoryCacheCheck(action.getKey()) : null;
        if (quickMemoryCacheCheck != null) {
            deliverAction(quickMemoryCacheCheck, LoadedFrom.MEMORY, action);
            if (this.loggingEnabled) {
                String logId = action.request.logId();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("from ");
                stringBuilder.append(LoadedFrom.MEMORY);
                Utils.log("Main", "completed", logId, stringBuilder.toString());
                return;
            }
            return;
        }
        enqueueAndSubmit(action);
        if (this.loggingEnabled) {
            Utils.log("Main", "resumed", action.request.logId());
        }
    }

    private void deliverAction(Bitmap bitmap, LoadedFrom loadedFrom, Action action) {
        if (!action.isCancelled()) {
            if (!action.willReplay()) {
                this.targetToAction.remove(action.getTarget());
            }
            if (bitmap == null) {
                action.error();
                if (this.loggingEnabled) {
                    Utils.log("Main", "errored", action.request.logId());
                }
            } else if (loadedFrom == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                action.complete(bitmap, loadedFrom);
                if (this.loggingEnabled) {
                    String logId = action.request.logId();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("from ");
                    stringBuilder.append(loadedFrom);
                    Utils.log("Main", "completed", logId, stringBuilder.toString());
                }
            }
        }
    }

    private void cancelExistingRequest(Object obj) {
        Utils.checkMain();
        Action action = (Action) this.targetToAction.remove(obj);
        if (action != null) {
            action.cancel();
            this.dispatcher.dispatchCancel(action);
        }
        if (obj instanceof ImageView) {
            DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) this.targetToDeferredRequestCreator.remove((ImageView) obj);
            if (deferredRequestCreator != null) {
                deferredRequestCreator.cancel();
            }
        }
    }

    public static Picasso with(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        if (singleton == null) {
            synchronized (Picasso.class) {
                if (singleton == null) {
                    singleton = new Builder(context).build();
                }
            }
        }
        return singleton;
    }

    public static void setSingletonInstance(@NonNull Picasso picasso) {
        if (picasso == null) {
            throw new IllegalArgumentException("Picasso must not be null.");
        }
        synchronized (Picasso.class) {
            if (singleton != null) {
                throw new IllegalStateException("Singleton instance already exists.");
            }
            singleton = picasso;
        }
    }
}
