package jumio.nv.nfc;

import android.util.SparseArray;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.jmrtd.lds.icao.DG11File;

/* compiled from: MrtdPersonalDetails */
public class m implements Serializable {
    public final String a;
    public final String b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final String f;
    public final String g;
    public final List<String> h;
    public final String i;
    public final byte[] j;
    public final String k;
    public final String l;
    public Date m;

    public m(DG11File dG11File) {
        this.a = dG11File.bBm();
        try {
            this.m = new SimpleDateFormat("yyyyMMdd").parse(dG11File.bBe());
        } catch (Exception unused) {
            this.b = dG11File.bBc();
            List bBd = dG11File.bBd();
            if (bBd != null && bBd.size() == 0) {
                bBd = null;
            }
            this.c = bBd;
            this.d = dG11File.bBl();
            this.e = dG11File.bBg();
            this.f = dG11File.getPersonalNumber();
            this.g = dG11File.bBj();
            this.h = dG11File.bBf();
            this.i = dG11File.bBi();
            this.j = dG11File.bBk();
            this.k = dG11File.bBh();
            this.l = dG11File.getTitle();
        }
    }

    public String toString() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        StringBuilder stringBuilder3 = new StringBuilder();
        if (this.a != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.m != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.m.toString());
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.b != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.c != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a(this.c));
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.d != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a(this.d));
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.e != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a(this.e));
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.f != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.g != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.g);
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.h != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a(this.h));
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.i != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.i);
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.j != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Arrays.toString(this.j));
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.k != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.k);
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        if (this.l != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.l);
            stringBuilder.append("\n");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = "";
        }
        stringBuilder3.append(stringBuilder2);
        return stringBuilder3.toString();
    }

    private String a(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : list) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(", ");
            stringBuilder.append(stringBuilder2.toString());
        }
        return stringBuilder.toString();
    }

    public SparseArray<Object> a() {
        SparseArray<Object> sparseArray = new SparseArray();
        sparseArray.put(0, this.a);
        sparseArray.put(1, this.m);
        sparseArray.put(2, this.b);
        sparseArray.put(3, this.c);
        sparseArray.put(4, this.d);
        sparseArray.put(5, this.e);
        sparseArray.put(6, this.f);
        sparseArray.put(7, this.g);
        sparseArray.put(8, this.h);
        sparseArray.put(9, this.i);
        sparseArray.put(10, this.j);
        sparseArray.put(11, this.k);
        sparseArray.put(12, this.l);
        return sparseArray;
    }
}
