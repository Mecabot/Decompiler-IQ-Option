package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.internal.b;
import com.facebook.h;
import com.facebook.internal.w;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* compiled from: AppEventStore */
class d {
    private static final String TAG = "com.facebook.appevents.d";

    /* compiled from: AppEventStore */
    private static class a extends ObjectInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        protected ObjectStreamClass readClassDescriptor() {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(SerializationProxyV1.class);
            }
            return readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(SerializationProxyV1.class) : readClassDescriptor;
        }
    }

    d() {
    }

    public static synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, f fVar) {
        synchronized (d.class) {
            b.kV();
            PersistedEvents ki = ki();
            if (ki.d(accessTokenAppIdPair)) {
                ki.c(accessTokenAppIdPair).addAll(fVar.kr());
            } else {
                ki.a(accessTokenAppIdPair, fVar.kr());
            }
            b(ki);
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (d.class) {
            b.kV();
            PersistedEvents ki = ki();
            for (AccessTokenAppIdPair accessTokenAppIdPair : bVar.keySet()) {
                ki.a(accessTokenAppIdPair, bVar.a(accessTokenAppIdPair).kr());
            }
            b(ki);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x008a A:{Catch:{ Exception -> 0x002e }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008a A:{Catch:{ Exception -> 0x002e }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008a A:{Catch:{ Exception -> 0x002e }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008a A:{Catch:{ Exception -> 0x002e }} */
    public static synchronized com.facebook.appevents.PersistedEvents ki() {
        /*
        r0 = com.facebook.appevents.d.class;
        monitor-enter(r0);
        com.facebook.appevents.internal.b.kV();	 Catch:{ all -> 0x0091 }
        r1 = com.facebook.h.getApplicationContext();	 Catch:{ all -> 0x0091 }
        r2 = 0;
        r3 = "AppEventsLogger.persistedevents";
        r3 = r1.openFileInput(r3);	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r4 = new com.facebook.appevents.d$a;	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r5 = new java.io.BufferedInputStream;	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r5.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r3 = r4.readObject();	 Catch:{ FileNotFoundException -> 0x0075, Exception -> 0x0038 }
        r3 = (com.facebook.appevents.PersistedEvents) r3;	 Catch:{ FileNotFoundException -> 0x0075, Exception -> 0x0038 }
        com.facebook.internal.w.closeQuietly(r4);	 Catch:{ all -> 0x0091 }
        r2 = "AppEventsLogger.persistedevents";
        r1 = r1.getFileStreamPath(r2);	 Catch:{ Exception -> 0x002e }
        r1.delete();	 Catch:{ Exception -> 0x002e }
        goto L_0x0036;
    L_0x002e:
        r1 = move-exception;
        r2 = TAG;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";
        android.util.Log.w(r2, r4, r1);	 Catch:{ all -> 0x0091 }
    L_0x0036:
        r2 = r3;
        goto L_0x0088;
    L_0x0038:
        r3 = move-exception;
        goto L_0x003e;
    L_0x003a:
        r3 = move-exception;
        goto L_0x005e;
    L_0x003c:
        r3 = move-exception;
        r4 = r2;
    L_0x003e:
        r5 = TAG;	 Catch:{ all -> 0x005b }
        r6 = "Got unexpected exception while reading events: ";
        android.util.Log.w(r5, r6, r3);	 Catch:{ all -> 0x005b }
        com.facebook.internal.w.closeQuietly(r4);	 Catch:{ all -> 0x0091 }
        r3 = "AppEventsLogger.persistedevents";
        r1 = r1.getFileStreamPath(r3);	 Catch:{ Exception -> 0x0052 }
        r1.delete();	 Catch:{ Exception -> 0x0052 }
        goto L_0x0088;
    L_0x0052:
        r1 = move-exception;
        r3 = TAG;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";
    L_0x0057:
        android.util.Log.w(r3, r4, r1);	 Catch:{ all -> 0x0091 }
        goto L_0x0088;
    L_0x005b:
        r2 = move-exception;
        r3 = r2;
        r2 = r4;
    L_0x005e:
        com.facebook.internal.w.closeQuietly(r2);	 Catch:{ all -> 0x0091 }
        r2 = "AppEventsLogger.persistedevents";
        r1 = r1.getFileStreamPath(r2);	 Catch:{ Exception -> 0x006b }
        r1.delete();	 Catch:{ Exception -> 0x006b }
        goto L_0x0073;
    L_0x006b:
        r1 = move-exception;
        r2 = TAG;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";
        android.util.Log.w(r2, r4, r1);	 Catch:{ all -> 0x0091 }
    L_0x0073:
        throw r3;	 Catch:{ all -> 0x0091 }
    L_0x0074:
        r4 = r2;
    L_0x0075:
        com.facebook.internal.w.closeQuietly(r4);	 Catch:{ all -> 0x0091 }
        r3 = "AppEventsLogger.persistedevents";
        r1 = r1.getFileStreamPath(r3);	 Catch:{ Exception -> 0x0082 }
        r1.delete();	 Catch:{ Exception -> 0x0082 }
        goto L_0x0088;
    L_0x0082:
        r1 = move-exception;
        r3 = TAG;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";
        goto L_0x0057;
    L_0x0088:
        if (r2 != 0) goto L_0x008f;
    L_0x008a:
        r2 = new com.facebook.appevents.PersistedEvents;	 Catch:{ all -> 0x0091 }
        r2.<init>();	 Catch:{ all -> 0x0091 }
    L_0x008f:
        monitor-exit(r0);
        return r2;
    L_0x0091:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.d.ki():com.facebook.appevents.PersistedEvents");
    }

    private static void b(PersistedEvents persistedEvents) {
        Throwable e;
        Context applicationContext = h.getApplicationContext();
        Closeable closeable = null;
        try {
            Closeable objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                objectOutputStream.writeObject(persistedEvents);
                w.closeQuietly(objectOutputStream);
            } catch (Exception e2) {
                e = e2;
                closeable = objectOutputStream;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", e);
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception unused) {
                        w.closeQuietly(closeable);
                    }
                } catch (Throwable th) {
                    e = th;
                    w.closeQuietly(closeable);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                closeable = objectOutputStream;
                w.closeQuietly(closeable);
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            Log.w(TAG, "Got unexpected exception while persisting events: ", e);
            applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
        }
    }
}
