package com.iqoption.withdrawal.crypto.barcode.camera;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.images.Size;
import com.iqoption.core.i;

public class CameraSourcePreview extends ViewGroup {
    private SurfaceView dSC;
    private boolean dSD = false;
    private boolean dSE = false;
    private b dSF;
    private a dSa;
    private Context mContext;

    private class a implements Callback {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private a() {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.dSE = true;
            try {
                CameraSourcePreview.this.aOh();
            } catch (Throwable e) {
                Log.e("CameraSourcePreview", "Do not have permission to start the camera", e);
            } catch (Throwable e2) {
                i.e("CameraSourcePreview", "Could not start camera source.", e2);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.dSE = false;
        }
    }

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.dSC = new SurfaceView(context);
        this.dSC.setLayoutParams(new LayoutParams(-1, -1));
        this.dSC.getHolder().addCallback(new a());
        addView(this.dSC);
    }

    @RequiresPermission("android.permission.CAMERA")
    public void g(a aVar) {
        if (aVar == null) {
            stop();
        }
        this.dSa = aVar;
        if (this.dSa != null) {
            this.dSD = true;
            aOh();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public void a(a aVar, b bVar) {
        this.dSF = bVar;
        g(aVar);
    }

    public void stop() {
        if (this.dSa != null) {
            this.dSa.stop();
        }
    }

    public void release() {
        if (this.dSa != null) {
            this.dSa.release();
            this.dSa = null;
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    private void aOh() {
        if (this.dSD && this.dSE) {
            this.dSa.a(this.dSC.getHolder());
            if (this.dSF != null) {
                Size previewSize = this.dSa.getPreviewSize();
                int min = Math.min(previewSize.getWidth(), previewSize.getHeight());
                int max = Math.max(previewSize.getWidth(), previewSize.getHeight());
                if (aOi()) {
                    this.dSF.u(min, max, this.dSa.getCameraFacing());
                } else {
                    this.dSF.u(max, min, this.dSa.getCameraFacing());
                }
                this.dSF.clear();
            }
            this.dSD = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A:{LOOP_END, LOOP:0: B:13:0x0044->B:15:0x004a} */
    protected void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        /*
        r6 = this;
        r7 = r6.dSa;
        if (r7 == 0) goto L_0x0015;
    L_0x0004:
        r7 = r6.dSa;
        r7 = r7.getPreviewSize();
        if (r7 == 0) goto L_0x0015;
    L_0x000c:
        r0 = r7.getWidth();
        r7 = r7.getHeight();
        goto L_0x0019;
    L_0x0015:
        r0 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r7 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
    L_0x0019:
        r1 = r6.aOi();
        if (r1 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0023;
    L_0x0020:
        r5 = r0;
        r0 = r7;
        r7 = r5;
    L_0x0023:
        r10 = r10 - r8;
        r11 = r11 - r9;
        r8 = (float) r10;
        r7 = (float) r7;
        r8 = r8 / r7;
        r9 = (float) r11;
        r0 = (float) r0;
        r9 = r9 / r0;
        r1 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1));
        r2 = 0;
        if (r1 <= 0) goto L_0x003c;
    L_0x0030:
        r0 = r0 * r8;
        r7 = (int) r0;
        r8 = r7 - r11;
        r8 = r8 / 2;
        r11 = r7;
        r9 = r8;
        r7 = r10;
        r8 = 0;
        goto L_0x0044;
    L_0x003c:
        r7 = r7 * r9;
        r7 = (int) r7;
        r8 = r7 - r10;
        r8 = r8 / 2;
        r9 = 0;
    L_0x0044:
        r10 = r6.getChildCount();
        if (r2 >= r10) goto L_0x005c;
    L_0x004a:
        r10 = r6.getChildAt(r2);
        r0 = r8 * -1;
        r1 = r9 * -1;
        r3 = r7 - r8;
        r4 = r11 - r9;
        r10.layout(r0, r1, r3, r4);
        r2 = r2 + 1;
        goto L_0x0044;
    L_0x005c:
        r6.aOh();	 Catch:{ SecurityException -> 0x0069, IOException -> 0x0060 }
        goto L_0x0071;
    L_0x0060:
        r7 = move-exception;
        r8 = "CameraSourcePreview";
        r9 = "Could not start camera source.";
        com.iqoption.core.i.e(r8, r9, r7);
        goto L_0x0071;
    L_0x0069:
        r7 = move-exception;
        r8 = "CameraSourcePreview";
        r9 = "Do not have permission to start the camera";
        com.iqoption.core.i.e(r8, r9, r7);
    L_0x0071:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.crypto.barcode.camera.CameraSourcePreview.onLayout(boolean, int, int, int, int):void");
    }

    private boolean aOi() {
        int i = this.mContext.getResources().getConfiguration().orientation;
        if (i == 2) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        i.d("CameraSourcePreview", "isPortraitMode returning false by default");
        return false;
    }
}
