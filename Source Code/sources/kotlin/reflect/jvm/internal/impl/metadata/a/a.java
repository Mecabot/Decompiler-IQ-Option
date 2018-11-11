package kotlin.reflect.jvm.internal.impl.metadata.a;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.h;

/* compiled from: BinaryVersion.kt */
public abstract class a {
    public static final a eLf = new a();
    private final int eLc;
    private final List<Integer> eLd;
    private final int[] eLe;
    private final int major;
    private final int minor;

    /* compiled from: BinaryVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public a(int... iArr) {
        h.e(iArr, "numbers");
        this.eLe = iArr;
        Integer f = i.f(this.eLe, 0);
        int i = -1;
        this.major = f != null ? f.intValue() : -1;
        f = i.f(this.eLe, 1);
        this.minor = f != null ? f.intValue() : -1;
        f = i.f(this.eLe, 2);
        if (f != null) {
            i = f.intValue();
        }
        this.eLc = i;
        this.eLd = this.eLe.length > 3 ? u.W(h.q(this.eLe).subList(3, this.eLe.length)) : m.emptyList();
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int[] toArray() {
        return this.eLe;
    }

    public String toString() {
        int[] toArray = toArray();
        ArrayList arrayList = new ArrayList();
        for (int i : toArray) {
            if ((i != -1 ? 1 : null) == null) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        List list = arrayList;
        return list.isEmpty() ? "unknown" : u.a(list, ".", null, null, 0, null, null, 62, null);
    }

    public boolean equals(Object obj) {
        if (obj != null && h.E(getClass(), obj.getClass())) {
            a aVar = (a) obj;
            if (this.major == aVar.major && this.minor == aVar.minor && this.eLc == aVar.eLc && h.E(this.eLd, aVar.eLd)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.major;
        i += (i * 31) + this.minor;
        i += (i * 31) + this.eLc;
        return i + ((i * 31) + this.eLd.hashCode());
    }
}
