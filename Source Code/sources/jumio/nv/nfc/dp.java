package jumio.nv.nfc;

/* compiled from: ROIDeScaler */
public class dp extends ef implements dj {
    private static final String[][] b = new String[][]{new String[]{"Rno_roi", null, "", null}};
    private do a;
    private dj c;

    public dp(dj djVar, do doVar) {
        super(djVar);
        this.c = djVar;
        this.a = doVar;
    }

    public eg e(int i, int i2) {
        return this.c.e(i, i2);
    }

    public static String[][] a() {
        return b;
    }

    public cv a(int i, int i2, int i3, eg egVar, cv cvVar) {
        return b(i, i2, i3, egVar, cvVar);
    }

    public cv b(int i, int i2, int i3, eg egVar, cv cvVar) {
        cv b = this.c.b(i, i2, i3, egVar, cvVar);
        Object obj = (this.a == null || this.a.a(d(), i) == null) ? 1 : null;
        if (obj != null || b == null) {
            return b;
        }
        int[] iArr = (int[]) b.b();
        int i4 = b.a;
        i4 = b.b;
        i4 = b.c;
        int i5 = b.d;
        i = ((Integer) this.a.a(d(), i)).intValue();
        int i6 = ((1 << egVar.r) - 1) << (31 - egVar.r);
        int i7 = (i6 ^ -1) & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i8 = b.f - i4;
        int i9 = ((b.e + (b.f * (i5 - 1))) + i4) - 1;
        while (i5 > 0) {
            int i10 = i9;
            i9 = i4;
            while (i9 > 0) {
                int i11 = iArr[i10];
                if ((i11 & i6) == 0) {
                    iArr[i10] = (i11 << i) | (Integer.MIN_VALUE & i11);
                } else if ((i11 & i7) != 0) {
                    iArr[i10] = (i11 & (i7 ^ -1)) | (1 << (30 - egVar.r));
                }
                i9--;
                i10--;
            }
            i9 = i10 - i8;
            i5--;
        }
        return b;
    }

    public static dp a(dj djVar, dt dtVar, cg cgVar) {
        dtVar.a('R', dt.a(b));
        if (dtVar.a("Rno_roi") != null || cgVar.b == null) {
            return new dp(djVar, null);
        }
        return new dp(djVar, cgVar.b);
    }
}
