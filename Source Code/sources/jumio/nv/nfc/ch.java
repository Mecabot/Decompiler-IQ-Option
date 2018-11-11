package jumio.nv.nfc;

/* compiled from: CBlkSizeSpec */
public class ch extends br {
    private int a = 0;
    private int j = 0;

    public ch(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public int a() {
        return this.a;
    }

    public int c() {
        return this.j;
    }

    public int a(byte b, int i, int i2) {
        Integer[] numArr;
        switch (b) {
            case (byte) 0:
                numArr = (Integer[]) b();
                break;
            case (byte) 1:
                numArr = (Integer[]) c(i2);
                break;
            case (byte) 2:
                numArr = (Integer[]) d(i);
                break;
            case (byte) 3:
                numArr = (Integer[]) a(i, i2);
                break;
            default:
                numArr = null;
                break;
        }
        return numArr[0].intValue();
    }

    public int b(byte b, int i, int i2) {
        Integer[] numArr;
        switch (b) {
            case (byte) 0:
                numArr = (Integer[]) b();
                break;
            case (byte) 1:
                numArr = (Integer[]) c(i2);
                break;
            case (byte) 2:
                numArr = (Integer[]) d(i);
                break;
            case (byte) 3:
                numArr = (Integer[]) a(i, i2);
                break;
            default:
                numArr = null;
                break;
        }
        return numArr[1].intValue();
    }

    public void a(Object obj) {
        super.a(obj);
        a((Integer[]) obj);
    }

    public void b(int i, Object obj) {
        super.b(i, obj);
        a((Integer[]) obj);
    }

    public void a(int i, Object obj) {
        super.a(i, obj);
        a((Integer[]) obj);
    }

    public void a(int i, int i2, Object obj) {
        super.a(i, i2, obj);
        a((Integer[]) obj);
    }

    private void a(Integer[] numArr) {
        if (numArr[0].intValue() > this.a) {
            this.a = numArr[0].intValue();
        }
        if (numArr[1].intValue() > this.j) {
            this.j = numArr[1].intValue();
        }
    }
}
