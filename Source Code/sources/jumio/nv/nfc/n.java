package jumio.nv.nfc;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jmrtd.lds.icao.MRZInfo;

/* compiled from: PassportDataDetails */
public class n implements Serializable {
    private MRZInfo a;
    private l b;
    private m c;

    public void a(l lVar) {
        this.b = lVar;
    }

    public void a(m mVar) {
        this.c = mVar;
    }

    public void a(MRZInfo mRZInfo) {
        this.a = mRZInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Additional document details: \n");
        stringBuilder.append(this.c != null ? this.c.toString() : "");
        stringBuilder.append(this.b != null ? this.b.toString() : "");
        return stringBuilder.toString();
    }

    @Nullable
    public l a() {
        return this.b;
    }

    @Nullable
    public m b() {
        return this.c;
    }

    public MRZInfo c() {
        return this.a;
    }

    public int[] d() {
        int i = 0;
        if (b() == null && a() == null) {
            return new int[0];
        }
        SparseArray a;
        int i2;
        List arrayList = new ArrayList();
        if (b() != null) {
            a = b().a();
            for (i2 = 0; i2 < a.size(); i2++) {
                if (a.valueAt(i2) != null) {
                    arrayList.add(Integer.valueOf(a.keyAt(i2)));
                }
            }
        }
        if (a() != null) {
            a = a().a();
            for (i2 = 0; i2 < a.size(); i2++) {
                if (a.valueAt(i2) != null) {
                    arrayList.add(Integer.valueOf(a.keyAt(i2)));
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        while (i < arrayList.size()) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
            i++;
        }
        return iArr;
    }
}
