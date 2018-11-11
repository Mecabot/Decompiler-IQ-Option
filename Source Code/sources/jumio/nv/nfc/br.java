package jumio.nv.nfc;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Hashtable;

/* compiled from: ModuleSpec */
public class br implements Cloneable {
    protected int b;
    protected int c = 0;
    protected int d = 0;
    protected byte[][] e;
    protected Object f = null;
    protected Object[] g = null;
    protected Object[] h = null;
    protected Hashtable i;

    protected Object clone() {
        try {
            br brVar = (br) super.clone();
            brVar.e = (byte[][]) Array.newInstance(byte.class, new int[]{this.c, this.d});
            for (int i = 0; i < this.c; i++) {
                for (int i2 = 0; i2 < this.d; i2++) {
                    brVar.e[i][i2] = this.e[i][i2];
                }
            }
            if (this.h != null) {
                brVar.h = new Object[this.c];
                for (int i3 = 0; i3 < this.c; i3++) {
                    brVar.h[i3] = this.h[i3];
                }
            }
            if (this.i != null) {
                brVar.i = new Hashtable();
                Enumeration keys = this.i.keys();
                while (keys.hasMoreElements()) {
                    String str = (String) keys.nextElement();
                    brVar.i.put(str, this.i.get(str));
                }
            }
            return brVar;
        } catch (CloneNotSupportedException unused) {
            throw new Error("Error when cloning ModuleSpec instance");
        }
    }

    public br(int i, int i2, byte b) {
        this.c = i;
        this.d = i2;
        this.e = (byte[][]) Array.newInstance(byte.class, new int[]{i, i2});
        switch (b) {
            case (byte) 0:
                this.b = 0;
                return;
            case (byte) 1:
                this.b = 1;
                return;
            case (byte) 2:
                this.b = 2;
                return;
            default:
                return;
        }
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public Object b() {
        return this.f;
    }

    public void a(int i, Object obj) {
        if (this.b == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Option whose value is '");
            stringBuilder.append(obj);
            stringBuilder.append("' cannot be ");
            stringBuilder.append("specified for components as it is a 'tile only' specific ");
            stringBuilder.append("option");
            throw new Error(stringBuilder.toString());
        }
        if (this.g == null) {
            this.g = new Object[this.d];
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            if (this.e[i2][i] < (byte) 1) {
                this.e[i2][i] = (byte) 1;
            }
        }
        this.g[i] = obj;
    }

    public Object c(int i) {
        if (this.b == 1) {
            throw new Error("Illegal use of ModuleSpec class");
        } else if (this.g == null || this.g[i] == null) {
            return b();
        } else {
            return this.g[i];
        }
    }

    public void b(int i, Object obj) {
        if (this.b == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Option whose value is '");
            stringBuilder.append(obj);
            stringBuilder.append("' cannot be ");
            stringBuilder.append("specified for tiles as it is a 'component only' specific ");
            stringBuilder.append("option");
            throw new Error(stringBuilder.toString());
        }
        if (this.h == null) {
            this.h = new Object[this.c];
        }
        for (int i2 = 0; i2 < this.d; i2++) {
            if (this.e[i][i2] < (byte) 2) {
                this.e[i][i2] = (byte) 2;
            }
        }
        this.h[i] = obj;
    }

    public Object d(int i) {
        if (this.b == 0) {
            throw new Error("Illegal use of ModuleSpec class");
        } else if (this.h == null || this.h[i] == null) {
            return b();
        } else {
            return this.h[i];
        }
    }

    public void a(int i, int i2, Object obj) {
        if (this.b != 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Option whose value is '");
            stringBuilder.append(obj);
            stringBuilder.append("' cannot be ");
            stringBuilder.append("specified for ");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3;
            switch (this.b) {
                case 0:
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append("tiles as it is a 'component only' specific option");
                    stringBuilder2 = stringBuilder3.toString();
                    break;
                case 1:
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append("components as it is a 'tile only' specific option");
                    stringBuilder2 = stringBuilder3.toString();
                    break;
            }
            throw new Error(stringBuilder2);
        }
        if (this.i == null) {
            this.i = new Hashtable();
        }
        this.e[i][i2] = (byte) 3;
        Hashtable hashtable = this.i;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("t");
        stringBuilder4.append(i);
        stringBuilder4.append("c");
        stringBuilder4.append(i2);
        hashtable.put(stringBuilder4.toString(), obj);
    }

    public Object a(int i, int i2) {
        if (this.b == 2) {
            return b(i, i2);
        }
        throw new Error("Illegal use of ModuleSpec class");
    }

    protected Object b(int i, int i2) {
        switch (this.e[i][i2]) {
            case (byte) 0:
                return b();
            case (byte) 1:
                return c(i2);
            case (byte) 2:
                return d(i);
            case (byte) 3:
                Hashtable hashtable = this.i;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("t");
                stringBuilder.append(i);
                stringBuilder.append("c");
                stringBuilder.append(i2);
                return hashtable.get(stringBuilder.toString());
            default:
                throw new IllegalArgumentException("Not recognized spec type");
        }
    }
}
