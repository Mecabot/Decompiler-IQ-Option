package jumio.nv.nfc;

import android.graphics.Bitmap;

/* compiled from: ImgWriterBitmap */
public abstract class dc {
    protected cs a;
    protected int b;
    protected int c;

    public abstract Bitmap a();

    public abstract void b();

    public void c() {
        cu a = this.a.a(null);
        for (int i = 0; i < a.b; i++) {
            for (int i2 = 0; i2 < a.a; i2++) {
                this.a.c(i2, i);
                b();
            }
        }
    }
}
