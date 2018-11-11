package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: SpreadBuilder */
public class l {
    private final ArrayList<Object> euy;

    public l(int i) {
        this.euy = new ArrayList(i);
    }

    public void cw(Object obj) {
        if (obj != null) {
            Iterator it;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    this.euy.ensureCapacity(this.euy.size() + objArr.length);
                    for (Object add : objArr) {
                        this.euy.add(add);
                    }
                }
            } else if (obj instanceof Collection) {
                this.euy.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add2 : (Iterable) obj) {
                    this.euy.add(add2);
                }
            } else if (obj instanceof Iterator) {
                it = (Iterator) obj;
                while (it.hasNext()) {
                    this.euy.add(it.next());
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Don't know how to spread ");
                stringBuilder.append(obj.getClass());
                throw new UnsupportedOperationException(stringBuilder.toString());
            }
        }
    }

    public int size() {
        return this.euy.size();
    }

    public void add(Object obj) {
        this.euy.add(obj);
    }

    public Object[] toArray(Object[] objArr) {
        return this.euy.toArray(objArr);
    }
}
