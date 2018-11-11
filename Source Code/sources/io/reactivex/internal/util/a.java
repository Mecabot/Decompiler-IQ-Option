package io.reactivex.internal.util;

import io.reactivex.c.k;
import org.a.c;

/* compiled from: AppendOnlyLinkedArrayList */
public class a<T> {
    final int capacity;
    final Object[] esU;
    Object[] esV = this.esU;
    int offset;

    /* compiled from: AppendOnlyLinkedArrayList */
    public interface a<T> extends k<T> {
        boolean test(T t);
    }

    public a(int i) {
        this.capacity = i;
        this.esU = new Object[(i + 1)];
    }

    public void add(T t) {
        int i = this.capacity;
        int i2 = this.offset;
        if (i2 == i) {
            Object[] objArr = new Object[(i + 1)];
            this.esV[i] = objArr;
            this.esV = objArr;
            i2 = 0;
        }
        this.esV[i2] = t;
        this.offset = i2 + 1;
    }

    public void ck(T t) {
        this.esU[0] = t;
    }

    public void a(a<? super T> aVar) {
        int i = this.capacity;
        for (Object[] objArr = this.esU; objArr != null; objArr = (Object[]) objArr[i]) {
            int i2 = 0;
            while (i2 < i) {
                Object obj = objArr[i2];
                if (obj == null) {
                    continue;
                    break;
                } else if (!aVar.test(obj)) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public <U> boolean c(c<? super U> cVar) {
        Object[] objArr = this.esU;
        int i = this.capacity;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object obj = objArr[i2];
                if (obj == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull(obj, (c) cVar)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = (Object[]) objArr[i];
        }
    }
}
