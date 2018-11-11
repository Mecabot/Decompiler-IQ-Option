package com.jumio.persistence;

import android.content.Context;
import com.jumio.commons.log.Log;
import java.io.Serializable;

public class DataAccess {
    private static final String TAG = "DataAccess";

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0049 A:{Splitter: B:4:0x0007, ExcHandler: com.jumio.persistence.PersistenceException (r7_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:10:0x0049, code:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:?, code:
            com.jumio.commons.log.Log.w(TAG, java.lang.String.format("Error loading %s", new java.lang.Object[]{r8.getName()}), r7);
     */
    /* JADX WARNING: Missing block: B:13:0x005f, code:
            r7 = null;
     */
    @android.support.annotation.Nullable
    public static synchronized <T extends java.io.Serializable> T load(android.content.Context r7, java.lang.Class<T> r8) {
        /*
        r0 = com.jumio.persistence.DataAccess.class;
        monitor-enter(r0);
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0062 }
        r3 = new com.jumio.persistence.Persistor;	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r3.<init>(r7, r8);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r7 = r3.restoreFromBlob();	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r5 = 0;
        r5 = r3 - r1;
        r1 = "DataAccess";
        r2 = new java.lang.StringBuilder;	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r2.<init>();	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r3 = "loading ";
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r3 = r8.getSimpleName();	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r3 = " took ";
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r2.append(r5);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r3 = " ms";
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        if (r7 != 0) goto L_0x003c;
    L_0x0039:
        r3 = " (was null)";
        goto L_0x003e;
    L_0x003c:
        r3 = "";
    L_0x003e:
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        r2 = r2.toString();	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        com.jumio.commons.log.Log.v(r1, r2);	 Catch:{ PersistenceException -> 0x0049, PersistenceException -> 0x0049 }
        goto L_0x0060;
    L_0x0049:
        r7 = move-exception;
        r1 = "DataAccess";
        r2 = "Error loading %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0062 }
        r4 = 0;
        r8 = r8.getName();	 Catch:{ all -> 0x0062 }
        r3[r4] = r8;	 Catch:{ all -> 0x0062 }
        r8 = java.lang.String.format(r2, r3);	 Catch:{ all -> 0x0062 }
        com.jumio.commons.log.Log.w(r1, r8, r7);	 Catch:{ all -> 0x0062 }
        r7 = 0;
    L_0x0060:
        monitor-exit(r0);
        return r7;
    L_0x0062:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.persistence.DataAccess.load(android.content.Context, java.lang.Class):T");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045 A:{Splitter: B:4:0x0007, ExcHandler: com.jumio.persistence.PersistenceException (r7_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:10:0x0045, code:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:?, code:
            com.jumio.commons.log.Log.w(TAG, java.lang.String.format("Error loading %s", new java.lang.Object[]{r8}), r7);
     */
    /* JADX WARNING: Missing block: B:13:0x0057, code:
            r7 = null;
     */
    @android.support.annotation.Nullable
    public static synchronized <T extends java.io.Serializable> T load(android.content.Context r7, java.lang.String r8) {
        /*
        r0 = com.jumio.persistence.DataAccess.class;
        monitor-enter(r0);
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x005a }
        r3 = new com.jumio.persistence.Persistor;	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r3.<init>(r7, r8);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r7 = r3.restoreFromBlob();	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r5 = 0;
        r5 = r3 - r1;
        r1 = "DataAccess";
        r2 = new java.lang.StringBuilder;	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r2.<init>();	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r3 = "loading ";
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r2.append(r8);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r3 = " took ";
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r2.append(r5);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r3 = " ms";
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        if (r7 != 0) goto L_0x0038;
    L_0x0035:
        r3 = " (was null)";
        goto L_0x003a;
    L_0x0038:
        r3 = "";
    L_0x003a:
        r2.append(r3);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        r2 = r2.toString();	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        com.jumio.commons.log.Log.v(r1, r2);	 Catch:{ PersistenceException -> 0x0045, PersistenceException -> 0x0045 }
        goto L_0x0058;
    L_0x0045:
        r7 = move-exception;
        r1 = "DataAccess";
        r2 = "Error loading %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x005a }
        r4 = 0;
        r3[r4] = r8;	 Catch:{ all -> 0x005a }
        r8 = java.lang.String.format(r2, r3);	 Catch:{ all -> 0x005a }
        com.jumio.commons.log.Log.w(r1, r8, r7);	 Catch:{ all -> 0x005a }
        r7 = 0;
    L_0x0058:
        monitor-exit(r0);
        return r7;
    L_0x005a:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.persistence.DataAccess.load(android.content.Context, java.lang.String):T");
    }

    @Deprecated
    public static synchronized <T extends Serializable> void store(Context context, Class<T> cls, T t) {
        synchronized (DataAccess.class) {
            update(context, (Class) cls, (Serializable) t);
        }
    }

    @Deprecated
    public static synchronized <T extends Serializable> void store(Context context, String str, T t) {
        synchronized (DataAccess.class) {
            update(context, str, (Serializable) t);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004b A:{Splitter: B:7:0x000b, ExcHandler: com.jumio.persistence.PersistenceException (r7_3 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:9:0x004b, code:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:?, code:
            com.jumio.commons.log.Log.w(TAG, java.lang.String.format("Error persisting %s", new java.lang.Object[]{r8.getName()}), r7);
     */
    /* JADX WARNING: Missing block: B:13:0x0062, code:
            return;
     */
    public static synchronized <T extends java.io.Serializable> void update(android.content.Context r7, java.lang.Class<T> r8, T r9) {
        /*
        r0 = com.jumio.persistence.DataAccess.class;
        monitor-enter(r0);
        if (r9 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r0);
        return;
    L_0x0007:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0063 }
        r3 = new com.jumio.persistence.Persistor;	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r3.<init>(r7, r8);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r3.delete();	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r3.storeAsBlob(r9);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r7 = 0;
        r5 = r3 - r1;
        r7 = "DataAccess";
        r1 = new java.lang.StringBuilder;	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r1.<init>();	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r2 = "storing ";
        r1.append(r2);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r9 = r9.getClass();	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r9 = r9.getSimpleName();	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r1.append(r9);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r9 = "took ";
        r1.append(r9);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r1.append(r5);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r9 = " ms";
        r1.append(r9);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        r9 = r1.toString();	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        com.jumio.commons.log.Log.v(r7, r9);	 Catch:{ PersistenceException -> 0x004b, PersistenceException -> 0x004b }
        goto L_0x0061;
    L_0x004b:
        r7 = move-exception;
        r9 = "DataAccess";
        r1 = "Error persisting %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0063 }
        r3 = 0;
        r8 = r8.getName();	 Catch:{ all -> 0x0063 }
        r2[r3] = r8;	 Catch:{ all -> 0x0063 }
        r8 = java.lang.String.format(r1, r2);	 Catch:{ all -> 0x0063 }
        com.jumio.commons.log.Log.w(r9, r8, r7);	 Catch:{ all -> 0x0063 }
    L_0x0061:
        monitor-exit(r0);
        return;
    L_0x0063:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.persistence.DataAccess.update(android.content.Context, java.lang.Class, java.io.Serializable):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043 A:{Splitter: B:7:0x000b, ExcHandler: com.jumio.persistence.PersistenceException (r7_3 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:9:0x0043, code:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:?, code:
            com.jumio.commons.log.Log.w(TAG, java.lang.String.format("Error persisting %s", new java.lang.Object[]{r8}), r7);
     */
    /* JADX WARNING: Missing block: B:13:0x0056, code:
            return;
     */
    public static synchronized <T extends java.io.Serializable> void update(android.content.Context r7, java.lang.String r8, T r9) {
        /*
        r0 = com.jumio.persistence.DataAccess.class;
        monitor-enter(r0);
        if (r9 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r0);
        return;
    L_0x0007:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0057 }
        r3 = new com.jumio.persistence.Persistor;	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r3.<init>(r7, r8);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r3.delete();	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r3.storeAsBlob(r9);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r7 = 0;
        r5 = r3 - r1;
        r7 = "DataAccess";
        r9 = new java.lang.StringBuilder;	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r9.<init>();	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r1 = "storing ";
        r9.append(r1);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r9.append(r8);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r1 = "took ";
        r9.append(r1);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r9.append(r5);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r1 = " ms";
        r9.append(r1);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        r9 = r9.toString();	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        com.jumio.commons.log.Log.v(r7, r9);	 Catch:{ PersistenceException -> 0x0043, PersistenceException -> 0x0043 }
        goto L_0x0055;
    L_0x0043:
        r7 = move-exception;
        r9 = "DataAccess";
        r1 = "Error persisting %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0057 }
        r3 = 0;
        r2[r3] = r8;	 Catch:{ all -> 0x0057 }
        r8 = java.lang.String.format(r1, r2);	 Catch:{ all -> 0x0057 }
        com.jumio.commons.log.Log.w(r9, r8, r7);	 Catch:{ all -> 0x0057 }
    L_0x0055:
        monitor-exit(r0);
        return;
    L_0x0057:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.persistence.DataAccess.update(android.content.Context, java.lang.String, java.io.Serializable):void");
    }

    public static synchronized <T extends Serializable> void delete(Context context, Class<T> cls) {
        synchronized (DataAccess.class) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                new Persistor(context, (Class) cls).delete();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deleting ");
                stringBuilder.append(cls.getSimpleName());
                stringBuilder.append("took ");
                stringBuilder.append(currentTimeMillis2);
                stringBuilder.append(" ms");
                Log.v(str, stringBuilder.toString());
            } catch (Throwable e) {
                Log.w(TAG, String.format("Error deleting %s", new Object[]{cls.getName()}), e);
            }
        }
        return;
    }

    public static synchronized <T extends Serializable> void delete(Context context, String str) {
        synchronized (DataAccess.class) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                new Persistor(context, str).delete();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deleting ");
                stringBuilder.append(str);
                stringBuilder.append("took ");
                stringBuilder.append(currentTimeMillis2);
                stringBuilder.append(" ms");
                Log.v(str2, stringBuilder.toString());
            } catch (Throwable e) {
                Log.w(TAG, String.format("Error deleting %s", new Object[]{str}), e);
            }
        }
        return;
    }
}
