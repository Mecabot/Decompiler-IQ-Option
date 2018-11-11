package org.threeten.bp.zone;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.threeten.bp.a.d;

/* compiled from: TzdbZoneRulesProvider */
public final class a extends c {
    private List<String> fgS;
    private final ConcurrentNavigableMap<String, a> fgT = new ConcurrentSkipListMap();
    private Set<String> fgU = new CopyOnWriteArraySet();

    /* compiled from: TzdbZoneRulesProvider */
    static class a {
        private final String fgV;
        private final String[] fgW;
        private final short[] fgX;
        private final AtomicReferenceArray<Object> fgY;

        a(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.fgY = atomicReferenceArray;
            this.fgV = str;
            this.fgW = strArr;
            this.fgX = sArr;
        }

        ZoneRules nS(String str) {
            int binarySearch = Arrays.binarySearch(this.fgW, str);
            if (binarySearch < 0) {
                return null;
            }
            try {
                return f(this.fgX[binarySearch]);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid binary time-zone data: TZDB:");
                stringBuilder.append(str);
                stringBuilder.append(", version: ");
                stringBuilder.append(this.fgV);
                throw new ZoneRulesException(stringBuilder.toString(), e);
            }
        }

        ZoneRules f(short s) {
            Object obj = this.fgY.get(s);
            if (obj instanceof byte[]) {
                obj = Ser.i(new DataInputStream(new ByteArrayInputStream((byte[]) obj)));
                this.fgY.set(s, obj);
            }
            return (ZoneRules) obj;
        }

        public String toString() {
            return this.fgV;
        }
    }

    public String toString() {
        return "TZDB";
    }

    public a() {
        if (!c(c.class.getClassLoader())) {
            throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
        }
    }

    public a(InputStream inputStream) {
        try {
            t(inputStream);
        } catch (Throwable e) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", e);
        }
    }

    protected Set<String> provideZoneIds() {
        return new HashSet(this.fgS);
    }

    protected ZoneRules D(String str, boolean z) {
        d.requireNonNull(str, "zoneId");
        ZoneRules nS = ((a) this.fgT.lastEntry().getValue()).nS(str);
        if (nS != null) {
            return nS;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown time-zone ID: ");
        stringBuilder.append(str);
        throw new ZoneRulesException(stringBuilder.toString());
    }

    private boolean c(ClassLoader classLoader) {
        Throwable e;
        Object obj = null;
        try {
            Enumeration resources = classLoader.getResources("org/threeten/bp/TZDB.dat");
            boolean z = false;
            while (resources.hasMoreElements()) {
                URL url = (URL) resources.nextElement();
                try {
                    z |= c(url);
                    URL url2 = url;
                } catch (Exception e2) {
                    e = e2;
                    obj = url;
                }
            }
            return z;
        } catch (Exception e3) {
            e = e3;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to load TZDB time-zone rules: ");
            stringBuilder.append(obj);
            throw new ZoneRulesException(stringBuilder.toString(), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    private boolean c(java.net.URL r4) {
        /*
        r3 = this;
        r0 = r3.fgU;
        r1 = r4.toExternalForm();
        r0 = r0.add(r1);
        r1 = 0;
        if (r0 == 0) goto L_0x0029;
    L_0x000d:
        r0 = 0;
        r4 = r4.openStream();	 Catch:{ all -> 0x0022 }
        r0 = r3.t(r4);	 Catch:{ all -> 0x001d }
        r1 = r1 | r0;
        if (r4 == 0) goto L_0x0029;
    L_0x0019:
        r4.close();
        goto L_0x0029;
    L_0x001d:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x0023;
    L_0x0022:
        r4 = move-exception;
    L_0x0023:
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0.close();
    L_0x0028:
        throw r4;
    L_0x0029:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.a.c(java.net.URL):boolean");
    }

    private boolean t(InputStream inputStream) {
        boolean z = false;
        for (a aVar : u(inputStream)) {
            a aVar2 = (a) this.fgT.putIfAbsent(aVar.fgV, aVar);
            if (aVar2 == null || aVar2.fgV.equals(aVar.fgV)) {
                z = true;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Data already loaded for TZDB time-zone rules version: ");
                stringBuilder.append(aVar.fgV);
                throw new ZoneRulesException(stringBuilder.toString());
            }
        }
        return z;
    }

    private Iterable<a> u(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != (byte) 1) {
            throw new StreamCorruptedException("File format not recognised");
        }
        if ("TZDB".equals(dataInputStream.readUTF())) {
            short s;
            short s2;
            short readShort = dataInputStream.readShort();
            String[] strArr = new String[readShort];
            for (s = (short) 0; s < readShort; s++) {
                strArr[s] = dataInputStream.readUTF();
            }
            s = dataInputStream.readShort();
            String[] strArr2 = new String[s];
            for (short s3 = (short) 0; s3 < s; s3++) {
                strArr2[s3] = dataInputStream.readUTF();
            }
            this.fgS = Arrays.asList(strArr2);
            s = dataInputStream.readShort();
            Object[] objArr = new Object[s];
            for (s2 = (short) 0; s2 < s; s2++) {
                byte[] bArr = new byte[dataInputStream.readShort()];
                dataInputStream.readFully(bArr);
                objArr[s2] = bArr;
            }
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
            Iterable hashSet = new HashSet(readShort);
            for (s2 = (short) 0; s2 < readShort; s2++) {
                short readShort2 = dataInputStream.readShort();
                String[] strArr3 = new String[readShort2];
                short[] sArr = new short[readShort2];
                for (short s4 = (short) 0; s4 < readShort2; s4++) {
                    strArr3[s4] = strArr2[dataInputStream.readShort()];
                    sArr[s4] = dataInputStream.readShort();
                }
                hashSet.add(new a(strArr[s2], strArr3, sArr, atomicReferenceArray));
            }
            return hashSet;
        }
        throw new StreamCorruptedException("File format not recognised");
    }
}
