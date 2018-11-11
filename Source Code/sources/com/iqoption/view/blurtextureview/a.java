package com.iqoption.view.blurtextureview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.iqoption.util.e;
import java.lang.ref.WeakReference;

/* compiled from: BlurRenderDynamicImpl */
public class a extends b {
    private WeakReference<com.iqoption.view.b.a> dER = null;
    private volatile Bitmap dES = null;
    private a dET = null;

    /* compiled from: BlurRenderDynamicImpl */
    private class a extends Thread {
        private volatile boolean mRunning;

        private a() {
            this.mRunning = true;
        }

        public void run() {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(((com.iqoption.view.b.a) a.this.dER.get()).getWidth() / a.this.dEY, ((com.iqoption.view.b.a) a.this.dER.get()).getHeight() / a.this.dEY, Config.ARGB_8888);
                a.this.dEZ = Bitmap.createBitmap(a.this.dES.getWidth(), a.this.dES.getHeight(), Config.ARGB_8888);
                Bitmap createBitmap2 = Bitmap.createBitmap(a.this.dES.getWidth(), a.this.dES.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap2);
                e eVar = new e(createBitmap2);
                while (this.mRunning && !Thread.interrupted()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (createBitmap2) {
                        com.iqoption.view.b.a aVar = (com.iqoption.view.b.a) a.this.dER.get();
                        if (aVar == null) {
                            throw new NullPointerException();
                        }
                        aVar.requestRender();
                        aVar.getBitmap(createBitmap);
                        canvas.drawColor(0, Mode.CLEAR);
                        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, null);
                        canvas.drawBitmap(a.this.dES, 0.0f, 0.0f, null);
                        eVar.a(createBitmap2, a.this.dEZ, (int) a.this.dEX);
                    }
                    ViewCompat.postInvalidateOnAnimation(a.this.mView);
                    currentTimeMillis = 50 - (System.currentTimeMillis() - currentTimeMillis);
                    if (currentTimeMillis > 0) {
                        sleep(currentTimeMillis);
                    } else {
                        yield();
                    }
                }
            } catch (InterruptedException unused) {
                aIO();
            } catch (Throwable th) {
                aIO();
            }
            aIO();
        }

        public void aIO() {
            interrupt();
            this.mRunning = false;
        }
    }

    public a(View view, Bitmap bitmap, com.iqoption.view.b.a aVar) {
        super(view);
        this.dER = new WeakReference(aVar);
        this.dES = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / this.dEY, bitmap.getHeight() / this.dEY, false);
        if (this.dET == null && this.dES != null && this.dER != null) {
            gV(0);
            this.dET = new a();
            this.dET.start();
        }
    }

    public void destroy() {
        if (this.dET != null) {
            this.dET.aIO();
            gV(1);
        }
    }

    private void gV(int i) {
        com.iqoption.view.b.a aVar = (com.iqoption.view.b.a) this.dER.get();
        if (aVar != null) {
            aVar.setRenderMode(i);
        }
    }
}
