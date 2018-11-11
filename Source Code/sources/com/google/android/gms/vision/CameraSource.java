package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CameraSource {
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private int zzcma;
    private final Object zzlew;
    private Camera zzlex;
    private int zzley;
    private Size zzlez;
    private float zzlfa;
    private int zzlfb;
    private int zzlfc;
    private boolean zzlfd;
    private SurfaceTexture zzlfe;
    private boolean zzlff;
    private Thread zzlfg;
    private zzb zzlfh;
    private Map<byte[], ByteBuffer> zzlfi;

    public static class Builder {
        private final Detector<?> zzlfj;
        private CameraSource zzlfk = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            } else {
                this.zzlfj = detector;
                this.zzlfk.mContext = context;
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzlfk;
            CameraSource cameraSource2 = this.zzlfk;
            cameraSource2.getClass();
            cameraSource.zzlfh = new zzb(this.zzlfj);
            return this.zzlfk;
        }

        public Builder setAutoFocusEnabled(boolean z) {
            this.zzlfk.zzlfd = z;
            return this;
        }

        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                this.zzlfk.zzley = i;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder(27);
            stringBuilder.append("Invalid camera: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public Builder setRequestedFps(float f) {
            if (f <= 0.0f) {
                StringBuilder stringBuilder = new StringBuilder(28);
                stringBuilder.append("Invalid fps: ");
                stringBuilder.append(f);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.zzlfk.zzlfa = f;
            return this;
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Invalid preview size: ");
                stringBuilder.append(i);
                stringBuilder.append("x");
                stringBuilder.append(i2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.zzlfk.zzlfb = i;
            this.zzlfk.zzlfc = i2;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    class zza implements PreviewCallback {
        private zza() {
        }

        /* synthetic */ zza(CameraSource cameraSource, zza zza) {
            this();
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.zzlfh.zza(bArr, camera);
        }
    }

    class zzb implements Runnable {
        private boolean mActive = true;
        private final Object mLock = new Object();
        private long zzebf = SystemClock.elapsedRealtime();
        private Detector<?> zzlfj;
        private long zzlfm;
        private int zzlfn = 0;
        private ByteBuffer zzlfo;

        zzb(Detector<?> detector) {
            this.zzlfj = detector;
        }

        @SuppressLint({"Assert"})
        final void release() {
            this.zzlfj.release();
            this.zzlfj = null;
        }

        /* JADX WARNING: Missing block: B:22:?, code:
            r6.zzlfj.receiveFrame(r1);
     */
        /* JADX WARNING: Missing block: B:25:0x0077, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:27:?, code:
            android.util.Log.e("CameraSource", "Exception thrown from receiver.", r0);
     */
        /* JADX WARNING: Missing block: B:28:0x0080, code:
            com.google.android.gms.vision.CameraSource.zzb(r6.zzlfl).addCallbackBuffer(r2.array());
     */
        @android.annotation.SuppressLint({"InlinedApi"})
        public final void run() {
            /*
            r6 = this;
        L_0x0000:
            r0 = r6.mLock;
            monitor-enter(r0);
        L_0x0003:
            r1 = r6.mActive;	 Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x001b;
        L_0x0007:
            r1 = r6.zzlfo;	 Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x001b;
        L_0x000b:
            r1 = r6.mLock;	 Catch:{ InterruptedException -> 0x0011 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0011 }
            goto L_0x0003;
        L_0x0011:
            r1 = move-exception;
            r2 = "CameraSource";
            r3 = "Frame processing loop terminated.";
            android.util.Log.d(r2, r3, r1);	 Catch:{ all -> 0x008e }
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            return;
        L_0x001b:
            r1 = r6.mActive;	 Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0021;
        L_0x001f:
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            return;
        L_0x0021:
            r1 = new com.google.android.gms.vision.Frame$Builder;	 Catch:{ all -> 0x008e }
            r1.<init>();	 Catch:{ all -> 0x008e }
            r2 = r6.zzlfo;	 Catch:{ all -> 0x008e }
            r3 = com.google.android.gms.vision.CameraSource.this;	 Catch:{ all -> 0x008e }
            r3 = r3.zzlez;	 Catch:{ all -> 0x008e }
            r3 = r3.getWidth();	 Catch:{ all -> 0x008e }
            r4 = com.google.android.gms.vision.CameraSource.this;	 Catch:{ all -> 0x008e }
            r4 = r4.zzlez;	 Catch:{ all -> 0x008e }
            r4 = r4.getHeight();	 Catch:{ all -> 0x008e }
            r5 = 17;
            r1 = r1.setImageData(r2, r3, r4, r5);	 Catch:{ all -> 0x008e }
            r2 = r6.zzlfn;	 Catch:{ all -> 0x008e }
            r1 = r1.setId(r2);	 Catch:{ all -> 0x008e }
            r2 = r6.zzlfm;	 Catch:{ all -> 0x008e }
            r1 = r1.setTimestampMillis(r2);	 Catch:{ all -> 0x008e }
            r2 = com.google.android.gms.vision.CameraSource.this;	 Catch:{ all -> 0x008e }
            r2 = r2.zzcma;	 Catch:{ all -> 0x008e }
            r1 = r1.setRotation(r2);	 Catch:{ all -> 0x008e }
            r1 = r1.build();	 Catch:{ all -> 0x008e }
            r2 = r6.zzlfo;	 Catch:{ all -> 0x008e }
            r3 = 0;
            r6.zzlfo = r3;	 Catch:{ all -> 0x008e }
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            r0 = r6.zzlfj;	 Catch:{ Throwable -> 0x0077 }
            r0.receiveFrame(r1);	 Catch:{ Throwable -> 0x0077 }
        L_0x0067:
            r0 = com.google.android.gms.vision.CameraSource.this;
            r0 = r0.zzlex;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x0075:
            r0 = move-exception;
            goto L_0x0080;
        L_0x0077:
            r0 = move-exception;
            r1 = "CameraSource";
            r3 = "Exception thrown from receiver.";
            android.util.Log.e(r1, r3, r0);	 Catch:{ all -> 0x0075 }
            goto L_0x0067;
        L_0x0080:
            r1 = com.google.android.gms.vision.CameraSource.this;
            r1 = r1.zzlex;
            r2 = r2.array();
            r1.addCallbackBuffer(r2);
            throw r0;
        L_0x008e:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        final void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        final void zza(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                if (this.zzlfo != null) {
                    camera.addCallbackBuffer(this.zzlfo.array());
                    this.zzlfo = null;
                }
                if (CameraSource.this.zzlfi.containsKey(bArr)) {
                    this.zzlfm = SystemClock.elapsedRealtime() - this.zzebf;
                    this.zzlfn++;
                    this.zzlfo = (ByteBuffer) CameraSource.this.zzlfi.get(bArr);
                    this.mLock.notifyAll();
                    return;
                }
                Log.d("CameraSource", "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
            }
        }
    }

    class zzc implements android.hardware.Camera.PictureCallback {
        private PictureCallback zzlfp;

        private zzc() {
        }

        /* synthetic */ zzc(CameraSource cameraSource, zza zza) {
            this();
        }

        public final void onPictureTaken(byte[] bArr, Camera camera) {
            if (this.zzlfp != null) {
                this.zzlfp.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.zzlew) {
                if (CameraSource.this.zzlex != null) {
                    CameraSource.this.zzlex.startPreview();
                }
            }
        }
    }

    static class zzd implements android.hardware.Camera.ShutterCallback {
        private ShutterCallback zzlfq;

        private zzd() {
        }

        /* synthetic */ zzd(zza zza) {
            this();
        }

        public final void onShutter() {
            if (this.zzlfq != null) {
                this.zzlfq.onShutter();
            }
        }
    }

    static class zze {
        private Size zzlfr;
        private Size zzlfs;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzlfr = new Size(size.width, size.height);
            if (size2 != null) {
                this.zzlfs = new Size(size2.width, size2.height);
            }
        }

        public final Size zzbli() {
            return this.zzlfr;
        }

        public final Size zzblj() {
            return this.zzlfs;
        }
    }

    private CameraSource() {
        this.zzlew = new Object();
        this.zzley = 0;
        this.zzlfa = 30.0f;
        this.zzlfb = 1024;
        this.zzlfc = 768;
        this.zzlfd = false;
        this.zzlfi = new HashMap();
    }

    /* synthetic */ CameraSource(zza zza) {
        this();
    }

    private static zze zza(Camera camera, int i, int i2) {
        Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        List arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = ((float) size.width) / ((float) size.height);
            for (Camera.Size size2 : supportedPictureSizes) {
                if (Math.abs(f - (((float) size2.width) / ((float) size2.height))) < 0.01f) {
                    arrayList.add(new zze(size, size2));
                    break;
                }
            }
        }
        zze zze = null;
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size zze2 : supportedPreviewSizes) {
                arrayList.add(new zze(zze2, null));
            }
        }
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size3 = arrayList2.size();
        int i4 = 0;
        while (i4 < size3) {
            Object obj = arrayList2.get(i4);
            i4++;
            zze zze3 = (zze) obj;
            Size zzbli = zze3.zzbli();
            int abs = Math.abs(zzbli.getWidth() - i) + Math.abs(zzbli.getHeight() - i2);
            if (abs < i3) {
                zze = zze3;
                i3 = abs;
            }
        }
        return zze;
    }

    @SuppressLint({"InlinedApi"})
    private final byte[] zza(Size size) {
        Object obj = new byte[(((int) Math.ceil(((double) ((long) ((size.getHeight() * size.getWidth()) * ImageFormat.getBitsPerPixel(17)))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(obj);
        if (wrap.hasArray() && wrap.array() == obj) {
            this.zzlfi.put(obj, wrap);
            return obj;
        }
        throw new IllegalStateException("Failed to create valid buffer for camera source.");
    }

    @SuppressLint({"InlinedApi"})
    private static int[] zza(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                iArr = iArr2;
                i2 = abs;
            }
        }
        return iArr;
    }

    @SuppressLint({"InlinedApi"})
    private final Camera zzblh() {
        int i = this.zzley;
        CameraInfo cameraInfo = new CameraInfo();
        int i2 = 0;
        int i3 = 0;
        while (i3 < Camera.getNumberOfCameras()) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == i) {
                break;
            }
            i3++;
        }
        i3 = -1;
        if (i3 == -1) {
            throw new IOException("Could not find requested camera.");
        }
        Camera open = Camera.open(i3);
        zze zza = zza(open, this.zzlfb, this.zzlfc);
        if (zza == null) {
            throw new IOException("Could not find suitable preview size.");
        }
        Size zzblj = zza.zzblj();
        this.zzlez = zza.zzbli();
        int[] zza2 = zza(open, this.zzlfa);
        if (zza2 == null) {
            throw new IOException("Could not find suitable preview frames per second range.");
        }
        Parameters parameters = open.getParameters();
        if (zzblj != null) {
            parameters.setPictureSize(zzblj.getWidth(), zzblj.getHeight());
        }
        parameters.setPreviewSize(this.zzlez.getWidth(), this.zzlez.getHeight());
        parameters.setPreviewFpsRange(zza2[0], zza2[1]);
        parameters.setPreviewFormat(17);
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Bad rotation value: ");
                stringBuilder.append(rotation);
                Log.e("CameraSource", stringBuilder.toString());
                break;
        }
        cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i3, cameraInfo);
        if (cameraInfo.facing == 1) {
            rotation = (cameraInfo.orientation + i2) % 360;
            i2 = (360 - rotation) % 360;
        } else {
            rotation = ((cameraInfo.orientation - i2) + 360) % 360;
            i2 = rotation;
        }
        this.zzcma = rotation / 90;
        open.setDisplayOrientation(i2);
        parameters.setRotation(rotation);
        if (this.zzlfd) {
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else {
                Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
        }
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new zza(this, null));
        open.addCallbackBuffer(zza(this.zzlez));
        open.addCallbackBuffer(zza(this.zzlez));
        open.addCallbackBuffer(zza(this.zzlez));
        open.addCallbackBuffer(zza(this.zzlez));
        return open;
    }

    public int getCameraFacing() {
        return this.zzley;
    }

    public Size getPreviewSize() {
        return this.zzlez;
    }

    public void release() {
        synchronized (this.zzlew) {
            stop();
            this.zzlfh.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() {
        synchronized (this.zzlew) {
            if (this.zzlex != null) {
                return this;
            }
            this.zzlex = zzblh();
            this.zzlfe = new SurfaceTexture(100);
            this.zzlex.setPreviewTexture(this.zzlfe);
            this.zzlff = true;
            this.zzlex.startPreview();
            this.zzlfg = new Thread(this.zzlfh);
            this.zzlfh.setActive(true);
            this.zzlfg.start();
            return this;
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) {
        synchronized (this.zzlew) {
            if (this.zzlex != null) {
                return this;
            }
            this.zzlex = zzblh();
            this.zzlex.setPreviewDisplay(surfaceHolder);
            this.zzlex.startPreview();
            this.zzlfg = new Thread(this.zzlfh);
            this.zzlfh.setActive(true);
            this.zzlfg.start();
            this.zzlff = false;
            return this;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A:{Catch:{ InterruptedException -> 0x0014 }} */
    public void stop() {
        /*
        r6 = this;
        r0 = r6.zzlew;
        monitor-enter(r0);
        r1 = r6.zzlfh;	 Catch:{ all -> 0x006e }
        r2 = 0;
        r1.setActive(r2);	 Catch:{ all -> 0x006e }
        r1 = r6.zzlfg;	 Catch:{ all -> 0x006e }
        r2 = 0;
        if (r1 == 0) goto L_0x001d;
    L_0x000e:
        r1 = r6.zzlfg;	 Catch:{ InterruptedException -> 0x0014 }
        r1.join();	 Catch:{ InterruptedException -> 0x0014 }
        goto L_0x001b;
    L_0x0014:
        r1 = "CameraSource";
        r3 = "Frame processing thread interrupted on release.";
        android.util.Log.d(r1, r3);	 Catch:{ all -> 0x006e }
    L_0x001b:
        r6.zzlfg = r2;	 Catch:{ all -> 0x006e }
    L_0x001d:
        r1 = r6.zzlex;	 Catch:{ all -> 0x006e }
        if (r1 == 0) goto L_0x0067;
    L_0x0021:
        r1 = r6.zzlex;	 Catch:{ all -> 0x006e }
        r1.stopPreview();	 Catch:{ all -> 0x006e }
        r1 = r6.zzlex;	 Catch:{ all -> 0x006e }
        r1.setPreviewCallbackWithBuffer(r2);	 Catch:{ all -> 0x006e }
        r1 = r6.zzlff;	 Catch:{ Exception -> 0x003b }
        if (r1 == 0) goto L_0x0035;
    L_0x002f:
        r1 = r6.zzlex;	 Catch:{ Exception -> 0x003b }
        r1.setPreviewTexture(r2);	 Catch:{ Exception -> 0x003b }
        goto L_0x0060;
    L_0x0035:
        r1 = r6.zzlex;	 Catch:{ Exception -> 0x003b }
        r1.setPreviewDisplay(r2);	 Catch:{ Exception -> 0x003b }
        goto L_0x0060;
    L_0x003b:
        r1 = move-exception;
        r3 = "CameraSource";
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x006e }
        r4 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x006e }
        r4 = r4.length();	 Catch:{ all -> 0x006e }
        r4 = r4 + 32;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006e }
        r5.<init>(r4);	 Catch:{ all -> 0x006e }
        r4 = "Failed to clear camera preview: ";
        r5.append(r4);	 Catch:{ all -> 0x006e }
        r5.append(r1);	 Catch:{ all -> 0x006e }
        r1 = r5.toString();	 Catch:{ all -> 0x006e }
        android.util.Log.e(r3, r1);	 Catch:{ all -> 0x006e }
    L_0x0060:
        r1 = r6.zzlex;	 Catch:{ all -> 0x006e }
        r1.release();	 Catch:{ all -> 0x006e }
        r6.zzlex = r2;	 Catch:{ all -> 0x006e }
    L_0x0067:
        r1 = r6.zzlfi;	 Catch:{ all -> 0x006e }
        r1.clear();	 Catch:{ all -> 0x006e }
        monitor-exit(r0);	 Catch:{ all -> 0x006e }
        return;
    L_0x006e:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x006e }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.stop():void");
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.zzlew) {
            if (this.zzlex != null) {
                android.hardware.Camera.ShutterCallback zzd = new zzd();
                zzd.zzlfq = shutterCallback;
                android.hardware.Camera.PictureCallback zzc = new zzc(this, null);
                zzc.zzlfp = pictureCallback;
                this.zzlex.takePicture(zzd, null, null, zzc);
            }
        }
    }
}
