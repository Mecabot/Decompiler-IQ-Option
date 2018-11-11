package jumio.nv.nfc;

import jumio.nv.nfc.y.a;
import jumio.nv.nfc.y.c;

/* compiled from: ColorSpecificationBox */
public final class ag extends aj {
    private c a = null;
    private a b = null;
    private byte[] c = null;

    static {
        i = 1668246642;
    }

    public ag(df dfVar, int i) {
        super(dfVar, i);
        d();
    }

    private void d() {
        byte[] bArr = new byte[256];
        this.k.a(this.n);
        this.k.a(bArr, 0, 11);
        switch (bArr[0]) {
            case (byte) 1:
                this.a = y.e;
                switch (an.e(bArr, 3)) {
                    case 16:
                        this.b = y.f;
                        return;
                    case 17:
                        this.b = y.g;
                        return;
                    case 18:
                        this.b = y.h;
                        return;
                    default:
                        this.b = y.j;
                        return;
                }
            case (byte) 2:
                this.a = y.d;
                int e = an.e(bArr, 3);
                this.c = new byte[e];
                this.k.a(this.n + 3);
                this.k.a(this.c, 0, e);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bad specification method (");
                stringBuilder.append(bArr[0]);
                stringBuilder.append(") in ");
                stringBuilder.append(this);
                throw new z(stringBuilder.toString());
        }
    }

    public c a() {
        return this.a;
    }

    public a b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }
}
