package com.iqoption.view.blurtextureview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.iqoption.util.e;

/* compiled from: BlurRenderStaticImpl */
public class d extends b {
    a dFb;

    /* compiled from: BlurRenderStaticImpl */
    private class a extends Thread {
        private Bitmap dFc;
        private Bitmap dFd;

        public a(Bitmap bitmap, Bitmap bitmap2) {
            this.dFc = bitmap;
            this.dFd = bitmap2;
        }

        public void run() {
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.dFd, this.dFd.getWidth() / d.this.dEY, this.dFd.getHeight() / d.this.dEY, false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap.getWidth(), createScaledBitmap.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(0, Mode.CLEAR);
                canvas.drawBitmap(this.dFc, 0.0f, 0.0f, null);
                canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, null);
                d.this.dEZ = e.a(createBitmap, (int) d.this.dEX);
                ViewCompat.postInvalidateOnAnimation(d.this.mView);
            } catch (Exception unused) {
                aIO();
            }
        }

        public void aIO() {
            interrupt();
        }
    }

    public d(View view, Bitmap bitmap, com.iqoption.view.b.a aVar) {
        super(view);
        if (bitmap != null && aVar != null) {
            aVar.setRenderMode(0);
            Bitmap createBitmap = Bitmap.createBitmap(aVar.getWidth() / this.dEY, aVar.getHeight() / this.dEY, Config.ARGB_8888);
            aVar.getBitmap(createBitmap);
            if (this.dFb == null) {
                this.dFb = new a(createBitmap, bitmap);
                this.dFb.start();
            }
            aVar.setRenderMode(1);
        }
    }

    public void destroy() {
        if (this.dFb != null) {
            this.dFb.aIO();
        }
    }
}
