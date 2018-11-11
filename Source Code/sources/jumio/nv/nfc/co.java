package jumio.nv.nfc;

/* compiled from: EntropyDecoder */
public abstract class co extends ef implements dj {
    private static final String[][] b = new String[][]{new String[]{"Cer", "<error detection [on|off]>", "", "on"}};
    protected cm a;

    public co(cm cmVar) {
        super(cmVar);
        this.a = cmVar;
    }

    public eg e(int i, int i2) {
        return this.a.e(i, i2);
    }

    public static String[][] a() {
        return b;
    }
}
