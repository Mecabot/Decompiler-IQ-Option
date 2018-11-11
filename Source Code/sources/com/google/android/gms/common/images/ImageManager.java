package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzgdb = new Object();
    private static HashSet<Uri> zzgdc = new HashSet();
    private static ImageManager zzgdd;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzgde = Executors.newFixedThreadPool(4);
    private final zza zzgdf = null;
    private final zzbgk zzgdg = new zzbgk();
    private final Map<zza, ImageReceiver> zzgdh = new HashMap();
    private final Map<Uri, ImageReceiver> zzgdi = new HashMap();
    private final Map<Uri, Long> zzgdj = new HashMap();

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzgdk = new ArrayList();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zzgde.execute(new zzb(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zzalm() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public final void zzb(zza zza) {
            com.google.android.gms.common.internal.zzc.zzgn("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzgdk.add(zza);
        }

        public final void zzc(zza zza) {
            com.google.android.gms.common.internal.zzc.zzgn("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzgdk.remove(zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    final class zzb implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzgdm;

        public zzb(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzgdm = parcelFileDescriptor;
        }

        public final void run() {
            String str = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                String valueOf = String.valueOf(Thread.currentThread());
                String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length());
                stringBuilder.append("checkNotMainThread: current thread ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" IS the main thread ");
                stringBuilder.append(valueOf2);
                stringBuilder.append("!");
                Log.e("Asserts", stringBuilder.toString());
                throw new IllegalStateException(str);
            }
            boolean z;
            Bitmap bitmap;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (this.zzgdm != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(this.zzgdm.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf3 = String.valueOf(this.mUri);
                    StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(valueOf3).length() + 34);
                    stringBuilder2.append("OOM while loading bitmap for uri: ");
                    stringBuilder2.append(valueOf3);
                    Log.e("ImageManager", stringBuilder2.toString(), e);
                    z2 = true;
                }
                try {
                    this.zzgdm.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zzd(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf4 = String.valueOf(this.mUri);
                StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(valueOf4).length() + 32);
                stringBuilder3.append("Latch interrupted while posting ");
                stringBuilder3.append(valueOf4);
                Log.w("ImageManager", stringBuilder3.toString());
            }
        }
    }

    final class zzc implements Runnable {
        private final zza zzgdn;

        public zzc(zza zza) {
            this.zzgdn = zza;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzgn("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzgdh.get(this.zzgdn);
            if (imageReceiver != null) {
                ImageManager.this.zzgdh.remove(this.zzgdn);
                imageReceiver.zzc(this.zzgdn);
            }
            zzb zzb = this.zzgdn.zzgdp;
            if (zzb.uri == null) {
                this.zzgdn.zza(ImageManager.this.mContext, ImageManager.this.zzgdg, true);
                return;
            }
            Bitmap zza = ImageManager.this.zza(zzb);
            if (zza != null) {
                this.zzgdn.zza(ImageManager.this.mContext, zza, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzgdj.get(zzb.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzgdn.zza(ImageManager.this.mContext, ImageManager.this.zzgdg, true);
                    return;
                }
                ImageManager.this.zzgdj.remove(zzb.uri);
            }
            this.zzgdn.zza(ImageManager.this.mContext, ImageManager.this.zzgdg);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzgdi.get(zzb.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zzb.uri);
                ImageManager.this.zzgdi.put(zzb.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzgdn);
            if (!(this.zzgdn instanceof zzd)) {
                ImageManager.this.zzgdh.put(this.zzgdn, imageReceiver2);
            }
            synchronized (ImageManager.zzgdb) {
                if (!ImageManager.zzgdc.contains(zzb.uri)) {
                    ImageManager.zzgdc.add(zzb.uri);
                    imageReceiver2.zzalm();
                }
            }
        }
    }

    final class zzd implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzapc;
        private boolean zzgdo;

        public zzd(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzgdo = z;
            this.zzapc = countDownLatch;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzgn("OnBitmapLoadedRunnable must be executed in the main thread");
            Object obj = this.mBitmap != null ? 1 : null;
            if (ImageManager.this.zzgdf != null) {
                if (this.zzgdo) {
                    ImageManager.this.zzgdf.evictAll();
                    System.gc();
                    this.zzgdo = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (obj != null) {
                    ImageManager.this.zzgdf.put(new zzb(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzgdi.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList zza = imageReceiver.zzgdk;
                int size = zza.size();
                for (int i = 0; i < size; i++) {
                    zza zza2 = (zza) zza.get(i);
                    if (obj != null) {
                        zza2.zza(ImageManager.this.mContext, this.mBitmap, false);
                    } else {
                        ImageManager.this.zzgdj.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        zza2.zza(ImageManager.this.mContext, ImageManager.this.zzgdg, false);
                    }
                    if (!(zza2 instanceof zzd)) {
                        ImageManager.this.zzgdh.remove(zza2);
                    }
                }
            }
            this.zzapc.countDown();
            synchronized (ImageManager.zzgdb) {
                ImageManager.zzgdc.remove(this.mUri);
            }
        }
    }

    static final class zza extends LruCache<zzb, Bitmap> {
        protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
    }

    public static ImageManager create(Context context) {
        if (zzgdd == null) {
            zzgdd = new ImageManager(context, false);
        }
        return zzgdd;
    }

    private final Bitmap zza(zzb zzb) {
        return this.zzgdf == null ? null : (Bitmap) this.zzgdf.get(zzb);
    }

    @Hide
    private final void zza(zza zza) {
        com.google.android.gms.common.internal.zzc.zzgn("ImageManager.loadImage() must be called in the main thread");
        new zzc(zza).run();
    }

    public final void loadImage(ImageView imageView, int i) {
        zza(new zzc(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zza(new zzc(imageView, uri));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zza zzc = new zzc(imageView, uri);
        zzc.zzgdr = i;
        zza(zzc);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zzd(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza zzd = new zzd(onImageLoadedListener, uri);
        zzd.zzgdr = i;
        zza(zzd);
    }
}
