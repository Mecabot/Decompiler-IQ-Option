package androidx.work;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Data {
    public static final Data dS = new a().aR();
    Map<String, Object> dT;

    public static final class a {
        private Map<String, Object> dT = new HashMap();

        @NonNull
        public a f(@NonNull String str, String str2) {
            this.dT.put(str, str2);
            return this;
        }

        @NonNull
        public a b(@NonNull Data data) {
            b(data.dT);
            return this;
        }

        @NonNull
        public a b(@NonNull Map<String, Object> map) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    this.dT.put(str, null);
                } else {
                    Class cls = value.getClass();
                    if (cls == Boolean.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                        this.dT.put(str, value);
                    } else if (cls == boolean[].class) {
                        this.dT.put(str, Data.a((boolean[]) value));
                    } else if (cls == int[].class) {
                        this.dT.put(str, Data.e((int[]) value));
                    } else if (cls == long[].class) {
                        this.dT.put(str, Data.b((long[]) value));
                    } else if (cls == float[].class) {
                        this.dT.put(str, Data.a((float[]) value));
                    } else if (cls == double[].class) {
                        this.dT.put(str, Data.a((double[]) value));
                    } else {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                    }
                }
            }
            return this;
        }

        @NonNull
        public Data aR() {
            return new Data(this.dT);
        }
    }

    Data() {
    }

    public Data(@NonNull Data data) {
        this.dT = new HashMap(data.dT);
    }

    Data(Map<String, ?> map) {
        this.dT = new HashMap(map);
    }

    @Nullable
    public String getString(@NonNull String str) {
        Object obj = this.dT.get(str);
        return obj instanceof String ? (String) obj : null;
    }

    @NonNull
    public Map<String, Object> aQ() {
        return Collections.unmodifiableMap(this.dT);
    }

    @VisibleForTesting
    public int size() {
        return this.dT.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c A:{SYNTHETIC, Splitter: B:40:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A:{SYNTHETIC, Splitter: B:25:0x0055} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @android.support.annotation.NonNull
    public static byte[] a(@android.support.annotation.NonNull androidx.work.Data r4) {
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x004f }
        r2.<init>(r0);	 Catch:{ IOException -> 0x004f }
        r1 = r4.size();	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r2.writeInt(r1);	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r4 = r4.dT;	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r4 = r4.entrySet();	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r4 = r4.iterator();	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
    L_0x001c:
        r1 = r4.hasNext();	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        if (r1 == 0) goto L_0x0039;
    L_0x0022:
        r1 = r4.next();	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r3 = r1.getKey();	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r3 = (java.lang.String) r3;	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r2.writeUTF(r3);	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r1 = r1.getValue();	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        r2.writeObject(r1);	 Catch:{ IOException -> 0x0049, all -> 0x0047 }
        goto L_0x001c;
    L_0x0039:
        if (r2 == 0) goto L_0x0043;
    L_0x003b:
        r2.close();	 Catch:{ IOException -> 0x003f }
        goto L_0x0043;
    L_0x003f:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0043:
        r0.close();	 Catch:{ IOException -> 0x0061 }
        goto L_0x0065;
    L_0x0047:
        r4 = move-exception;
        goto L_0x007a;
    L_0x0049:
        r4 = move-exception;
        r1 = r2;
        goto L_0x0050;
    L_0x004c:
        r4 = move-exception;
        r2 = r1;
        goto L_0x007a;
    L_0x004f:
        r4 = move-exception;
    L_0x0050:
        r4.printStackTrace();	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x005d;
    L_0x0055:
        r1.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005d;
    L_0x0059:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x005d:
        r0.close();	 Catch:{ IOException -> 0x0061 }
        goto L_0x0065;
    L_0x0061:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0065:
        r4 = r0.size();
        r1 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        if (r4 <= r1) goto L_0x0075;
    L_0x006d:
        r4 = new java.lang.IllegalStateException;
        r0 = "Data cannot occupy more than 10240KB when serialized";
        r4.<init>(r0);
        throw r4;
    L_0x0075:
        r4 = r0.toByteArray();
        return r4;
    L_0x007a:
        if (r2 == 0) goto L_0x0084;
    L_0x007c:
        r2.close();	 Catch:{ IOException -> 0x0080 }
        goto L_0x0084;
    L_0x0080:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0084:
        r0.close();	 Catch:{ IOException -> 0x0088 }
        goto L_0x008c;
    L_0x0088:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x008c:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.a(androidx.work.Data):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A:{Splitter: B:7:0x001d, ExcHandler: java.io.IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A:{SYNTHETIC, Splitter: B:27:0x004e} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A:{Splitter: B:5:0x0018, ExcHandler: java.io.IOException (r2_2 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0067 A:{SYNTHETIC, Splitter: B:39:0x0067} */
    /* JADX WARNING: Missing block: B:19:0x003f, code:
            r6 = e;
     */
    /* JADX WARNING: Missing block: B:22:0x0045, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0046, code:
            r5 = r2;
            r2 = null;
            r6 = r5;
     */
    /* JADX WARNING: Missing block: B:25:?, code:
            r6.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:26:0x004c, code:
            if (r2 != null) goto L_0x004e;
     */
    /* JADX WARNING: Missing block: B:28:?, code:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:29:0x0052, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:30:0x0053, code:
            r6.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:37:0x0064, code:
            r6 = th;
     */
    /* JADX WARNING: Missing block: B:40:?, code:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:41:0x006b, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x006c, code:
            r0.printStackTrace();
     */
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @android.support.annotation.NonNull
    public static androidx.work.Data d(@android.support.annotation.NonNull byte[] r6) {
        /*
        r0 = r6.length;
        r1 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        if (r0 <= r1) goto L_0x000d;
    L_0x0005:
        r6 = new java.lang.IllegalStateException;
        r0 = "Data cannot occupy more than 10240KB when serialized";
        r6.<init>(r0);
        throw r6;
    L_0x000d:
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = new java.io.ByteArrayInputStream;
        r1.<init>(r6);
        r6 = 0;
        r2 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x0045, IOException -> 0x0045, all -> 0x0041 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x0045, IOException -> 0x0045, all -> 0x0041 }
        r6 = r2.readInt();	 Catch:{ IOException -> 0x003f, IOException -> 0x003f }
    L_0x0021:
        if (r6 <= 0) goto L_0x0031;
    L_0x0023:
        r3 = r2.readUTF();	 Catch:{ IOException -> 0x003f, IOException -> 0x003f }
        r4 = r2.readObject();	 Catch:{ IOException -> 0x003f, IOException -> 0x003f }
        r0.put(r3, r4);	 Catch:{ IOException -> 0x003f, IOException -> 0x003f }
        r6 = r6 + -1;
        goto L_0x0021;
    L_0x0031:
        if (r2 == 0) goto L_0x003b;
    L_0x0033:
        r2.close();	 Catch:{ IOException -> 0x0037 }
        goto L_0x003b;
    L_0x0037:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x003b:
        r1.close();	 Catch:{ IOException -> 0x005a }
        goto L_0x005e;
    L_0x003f:
        r6 = move-exception;
        goto L_0x0049;
    L_0x0041:
        r0 = move-exception;
        r2 = r6;
        r6 = r0;
        goto L_0x0065;
    L_0x0045:
        r2 = move-exception;
        r5 = r2;
        r2 = r6;
        r6 = r5;
    L_0x0049:
        r6.printStackTrace();	 Catch:{ all -> 0x0064 }
        if (r2 == 0) goto L_0x0056;
    L_0x004e:
        r2.close();	 Catch:{ IOException -> 0x0052 }
        goto L_0x0056;
    L_0x0052:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0056:
        r1.close();	 Catch:{ IOException -> 0x005a }
        goto L_0x005e;
    L_0x005a:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x005e:
        r6 = new androidx.work.Data;
        r6.<init>(r0);
        return r6;
    L_0x0064:
        r6 = move-exception;
    L_0x0065:
        if (r2 == 0) goto L_0x006f;
    L_0x0067:
        r2.close();	 Catch:{ IOException -> 0x006b }
        goto L_0x006f;
    L_0x006b:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x006f:
        r1.close();	 Catch:{ IOException -> 0x0073 }
        goto L_0x0077;
    L_0x0073:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0077:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.d(byte[]):androidx.work.Data");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.dT.equals(((Data) obj).dT);
    }

    public int hashCode() {
        return this.dT.hashCode() * 31;
    }

    static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    static Long[] b(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    static Float[] a(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    static Double[] a(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }
}
