package com.google.common.collect;

import com.google.common.base.i;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> Tb = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] QT;
    private final transient int[] Tc;
    private final transient int size;

    static class EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
        private final transient Object[] QT;
        private final transient int Td;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        boolean sK() {
            return true;
        }

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.QT = objArr;
            this.Td = i;
            this.size = i2;
        }

        /* renamed from: sI */
        public aj<Entry<K, V>> iterator() {
            return sJ().iterator();
        }

        ImmutableList<Entry<K, V>> tr() {
            return new ImmutableList<Entry<K, V>>() {
                public boolean sK() {
                    return true;
                }

                /* renamed from: aV */
                public Entry<K, V> get(int i) {
                    i.s(i, EntrySet.this.size);
                    i *= 2;
                    return new SimpleImmutableEntry(EntrySet.this.QT[EntrySet.this.Td + i], EntrySet.this.QT[i + (EntrySet.this.Td ^ 1)]);
                }

                public int size() {
                    return EntrySet.this.size;
                }
            };
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            obj = entry.getValue();
            if (obj != null && obj.equals(this.map.get(key))) {
                z = true;
            }
            return z;
        }

        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> Te;
        private final transient ImmutableMap<K, ?> map;

        boolean sK() {
            return true;
        }

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.Te = immutableList;
        }

        /* renamed from: sI */
        public aj<K> iterator() {
            return sJ().iterator();
        }

        public ImmutableList<K> sJ() {
            return this.Te;
        }

        public boolean contains(Object obj) {
            return this.map.get(obj) != null;
        }

        public int size() {
            return this.map.size();
        }
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] QT;
        private final transient int offset;
        private final transient int size;

        boolean sK() {
            return true;
        }

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.QT = objArr;
            this.offset = i;
            this.size = i2;
        }

        public Object get(int i) {
            i.s(i, this.size);
            return this.QT[(i * 2) + this.offset];
        }

        public int size() {
            return this.size;
        }
    }

    boolean sK() {
        return false;
    }

    static <K, V> RegularImmutableMap<K, V> c(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) Tb;
        }
        if (i == 1) {
            g.n(objArr[0], objArr[1]);
            return new RegularImmutableMap(null, objArr, 1);
        }
        i.t(i, objArr.length >> 1);
        return new RegularImmutableMap(b(objArr, i, ImmutableSet.aU(i), 0), objArr, i);
    }

    /* JADX WARNING: Missing block: B:9:0x0034, code:
            r12[r7] = r5;
            r3 = r3 + 1;
     */
    static int[] b(java.lang.Object[] r10, int r11, int r12, int r13) {
        /*
        r0 = 1;
        if (r11 != r0) goto L_0x000e;
    L_0x0003:
        r11 = r10[r13];
        r12 = r13 ^ 1;
        r10 = r10[r12];
        com.google.common.collect.g.n(r11, r10);
        r10 = 0;
        return r10;
    L_0x000e:
        r1 = r12 + -1;
        r12 = new int[r12];
        r2 = -1;
        java.util.Arrays.fill(r12, r2);
        r3 = 0;
    L_0x0017:
        if (r3 >= r11) goto L_0x0079;
    L_0x0019:
        r4 = r3 * 2;
        r5 = r4 + r13;
        r6 = r10[r5];
        r7 = r13 ^ 1;
        r4 = r4 + r7;
        r4 = r10[r4];
        com.google.common.collect.g.n(r6, r4);
        r7 = r6.hashCode();
        r7 = com.google.common.collect.r.aO(r7);
    L_0x002f:
        r7 = r7 & r1;
        r8 = r12[r7];
        if (r8 != r2) goto L_0x0039;
    L_0x0034:
        r12[r7] = r5;
        r3 = r3 + 1;
        goto L_0x0017;
    L_0x0039:
        r9 = r10[r8];
        r9 = r9.equals(r6);
        if (r9 == 0) goto L_0x0076;
    L_0x0041:
        r11 = new java.lang.IllegalArgumentException;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = "Multiple entries with same key: ";
        r12.append(r13);
        r12.append(r6);
        r13 = "=";
        r12.append(r13);
        r12.append(r4);
        r13 = " and ";
        r12.append(r13);
        r13 = r10[r8];
        r12.append(r13);
        r13 = "=";
        r12.append(r13);
        r13 = r8 ^ 1;
        r10 = r10[r13];
        r12.append(r10);
        r10 = r12.toString();
        r11.<init>(r10);
        throw r11;
    L_0x0076:
        r7 = r7 + 1;
        goto L_0x002f;
    L_0x0079:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.b(java.lang.Object[], int, int, int):int[]");
    }

    private RegularImmutableMap(int[] iArr, Object[] objArr, int i) {
        this.Tc = iArr;
        this.QT = objArr;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    public V get(Object obj) {
        return a(this.Tc, this.QT, this.size, 0, obj);
    }

    static Object a(int[] iArr, Object[] objArr, int i, int i2, Object obj) {
        Object obj2 = null;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                obj2 = objArr[i2 ^ 1];
            }
            return obj2;
        } else if (iArr == null) {
            return null;
        } else {
            i = iArr.length - 1;
            i2 = r.aO(obj.hashCode());
            while (true) {
                i2 &= i;
                int i3 = iArr[i2];
                if (i3 == -1) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return objArr[i3 ^ 1];
                }
                i2++;
            }
        }
    }

    ImmutableSet<Entry<K, V>> sW() {
        return new EntrySet(this, this.QT, 0, this.size);
    }

    ImmutableSet<K> sY() {
        return new KeySet(this, new KeysOrValuesAsList(this.QT, 0, this.size));
    }

    ImmutableCollection<V> ta() {
        return new KeysOrValuesAsList(this.QT, 1, this.size);
    }
}
