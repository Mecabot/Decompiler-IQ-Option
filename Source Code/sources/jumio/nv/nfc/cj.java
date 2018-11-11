package jumio.nv.nfc;

import java.util.Vector;

/* compiled from: PrecinctSizeSpec */
public class cj extends br {
    private bq a;

    public cj(int i, int i2, byte b, bq bqVar) {
        super(i, i2, b);
        this.a = bqVar;
    }

    public int a(int i, int i2, int i3) {
        int intValue;
        Vector[] vectorArr;
        Object obj = i != -1 ? 1 : null;
        Object obj2 = i2 != -1 ? 1 : null;
        if (obj != null && obj2 != null) {
            intValue = ((Integer) this.a.a(i, i2)).intValue();
            vectorArr = (Vector[]) a(i, i2);
        } else if (obj != null && obj2 == null) {
            intValue = ((Integer) this.a.d(i)).intValue();
            vectorArr = (Vector[]) d(i);
        } else if (obj != null || obj2 == null) {
            intValue = ((Integer) this.a.b()).intValue();
            vectorArr = (Vector[]) b();
        } else {
            intValue = ((Integer) this.a.c(i2)).intValue();
            vectorArr = (Vector[]) c(i2);
        }
        intValue -= i3;
        if (vectorArr[0].size() > intValue) {
            return ((Integer) vectorArr[0].elementAt(intValue)).intValue();
        }
        return ((Integer) vectorArr[0].elementAt(vectorArr[0].size() - 1)).intValue();
    }

    public int b(int i, int i2, int i3) {
        int intValue;
        Vector[] vectorArr;
        Object obj = null;
        Object obj2 = i != -1 ? 1 : null;
        if (i2 != -1) {
            obj = 1;
        }
        if (obj2 != null && obj != null) {
            intValue = ((Integer) this.a.a(i, i2)).intValue();
            vectorArr = (Vector[]) a(i, i2);
        } else if (obj2 != null && obj == null) {
            intValue = ((Integer) this.a.d(i)).intValue();
            vectorArr = (Vector[]) d(i);
        } else if (obj2 != null || obj == null) {
            intValue = ((Integer) this.a.b()).intValue();
            vectorArr = (Vector[]) b();
        } else {
            intValue = ((Integer) this.a.c(i2)).intValue();
            vectorArr = (Vector[]) c(i2);
        }
        intValue -= i3;
        if (vectorArr[1].size() > intValue) {
            return ((Integer) vectorArr[1].elementAt(intValue)).intValue();
        }
        return ((Integer) vectorArr[1].elementAt(vectorArr[1].size() - 1)).intValue();
    }
}
