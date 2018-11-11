package com.google.common.cache;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

final class LongAdder extends Striped64 implements f, Serializable {
    private static final long serialVersionUID = 7249069246863182397L;

    final long d(long j, long j2) {
        return j + j2;
    }

    public void add(long j) {
        a[] aVarArr = this.Pj;
        if (aVarArr == null) {
            long j2 = this.Pk;
            if (e(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = (int[]) Pg.get();
        boolean z = true;
        if (!(iArr == null || aVarArr == null)) {
            int length = aVarArr.length;
            if (length >= 1) {
                a aVar = aVarArr[(length - 1) & iArr[0]];
                if (aVar != null) {
                    long j3 = aVar.value;
                    z = aVar.f(j3, j3 + j);
                    if (z) {
                        return;
                    }
                }
            }
        }
        a(j, iArr, z);
    }

    public void increment() {
        add(1);
    }

    public long sum() {
        long j = this.Pk;
        a[] aVarArr = this.Pj;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    j += aVar.value;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(sum());
    }

    public long longValue() {
        return sum();
    }

    public int intValue() {
        return (int) sum();
    }

    public float floatValue() {
        return (float) sum();
    }

    public double doubleValue() {
        return (double) sum();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.Pl = 0;
        this.Pj = null;
        this.Pk = objectInputStream.readLong();
    }
}
