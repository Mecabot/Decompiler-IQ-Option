package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: MetadataManager */
final class e {
    static final d aae = new d() {
        public InputStream dj(String str) {
            return e.class.getResourceAsStream(str);
        }
    };
    private static final ConcurrentHashMap<Integer, PhoneMetadata> aaf = new ConcurrentHashMap();
    private static final ConcurrentHashMap<String, PhoneMetadata> aag = new ConcurrentHashMap();
    private static final Set<Integer> aah = a.xa();
    private static final Set<String> aai = h.yr();
    private static final Logger logger = Logger.getLogger(e.class.getName());

    private e() {
    }

    static <T> PhoneMetadata a(T t, ConcurrentHashMap<T, PhoneMetadata> concurrentHashMap, String str, d dVar) {
        PhoneMetadata phoneMetadata = (PhoneMetadata) concurrentHashMap.get(t);
        if (phoneMetadata != null) {
            return phoneMetadata;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_");
        stringBuilder.append(t);
        str = stringBuilder.toString();
        List a = a(str, dVar);
        if (a.size() > 1) {
            Logger logger = logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("more than one metadata in file ");
            stringBuilder2.append(str);
            logger.log(level, stringBuilder2.toString());
        }
        PhoneMetadata phoneMetadata2 = (PhoneMetadata) a.get(0);
        PhoneMetadata phoneMetadata3 = (PhoneMetadata) concurrentHashMap.putIfAbsent(t, phoneMetadata2);
        if (phoneMetadata3 == null) {
            phoneMetadata3 = phoneMetadata2;
        }
        return phoneMetadata3;
    }

    private static List<PhoneMetadata> a(String str, d dVar) {
        InputStream dj = dVar.dj(str);
        StringBuilder stringBuilder;
        if (dj == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("missing metadata: ");
            stringBuilder.append(str);
            throw new IllegalStateException(stringBuilder.toString());
        }
        List<PhoneMetadata> xT = d(dj).xT();
        if (xT.size() != 0) {
            return xT;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("empty metadata: ");
        stringBuilder.append(str);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0045 A:{Catch:{ IOException -> 0x0043 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003f A:{SYNTHETIC, Splitter: B:26:0x003f} */
    private static com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection d(java.io.InputStream r5) {
        /*
        r0 = 0;
        r1 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x0034 }
        r1.<init>(r5);	 Catch:{ IOException -> 0x0034 }
        r0 = new com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection;	 Catch:{ all -> 0x002d }
        r0.<init>();	 Catch:{ all -> 0x002d }
        r0.readExternal(r1);	 Catch:{ IOException -> 0x0024 }
        if (r1 == 0) goto L_0x0016;
    L_0x0010:
        r1.close();	 Catch:{ IOException -> 0x0014 }
        goto L_0x0023;
    L_0x0014:
        r5 = move-exception;
        goto L_0x001a;
    L_0x0016:
        r5.close();	 Catch:{ IOException -> 0x0014 }
        goto L_0x0023;
    L_0x001a:
        r1 = logger;
        r2 = java.util.logging.Level.WARNING;
        r3 = "error closing input stream (ignored)";
        r1.log(r2, r3, r5);
    L_0x0023:
        return r0;
    L_0x0024:
        r0 = move-exception;
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x002d }
        r3 = "cannot load/parse metadata";
        r2.<init>(r3, r0);	 Catch:{ all -> 0x002d }
        throw r2;	 Catch:{ all -> 0x002d }
    L_0x002d:
        r0 = move-exception;
        goto L_0x003d;
    L_0x002f:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x003d;
    L_0x0034:
        r1 = move-exception;
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x002f }
        r3 = "cannot load/parse metadata";
        r2.<init>(r3, r1);	 Catch:{ all -> 0x002f }
        throw r2;	 Catch:{ all -> 0x002f }
    L_0x003d:
        if (r1 == 0) goto L_0x0045;
    L_0x003f:
        r1.close();	 Catch:{ IOException -> 0x0043 }
        goto L_0x0052;
    L_0x0043:
        r5 = move-exception;
        goto L_0x0049;
    L_0x0045:
        r5.close();	 Catch:{ IOException -> 0x0043 }
        goto L_0x0052;
    L_0x0049:
        r1 = logger;
        r2 = java.util.logging.Level.WARNING;
        r3 = "error closing input stream (ignored)";
        r1.log(r2, r3, r5);
    L_0x0052:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.e.d(java.io.InputStream):com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection");
    }
}
