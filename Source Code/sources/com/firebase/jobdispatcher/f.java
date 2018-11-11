package com.firebase.jobdispatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;

/* compiled from: GooglePlayCallbackExtractor */
final class f {
    private static Boolean JR;

    f() {
    }

    public Pair<o, Bundle> y(@Nullable Bundle bundle) {
        if (bundle != null) {
            return z(bundle);
        }
        Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
        return null;
    }

    @Nullable
    @SuppressLint({"ParcelClassLoader"})
    private static Pair<o, Bundle> z(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Parcel A = A(bundle);
        try {
            Pair<o, Bundle> pair = null;
            if (A.readInt() <= 0) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                return pair;
            } else if (A.readInt() != 1279544898) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                A.recycle();
                return pair;
            } else {
                int readInt = A.readInt();
                Object obj = pair;
                for (int i = 0; i < readInt; i++) {
                    String C = C(A);
                    if (C != null) {
                        if (obj != null || !"callback".equals(C)) {
                            Object readValue = A.readValue(pair);
                            if (readValue instanceof String) {
                                bundle2.putString(C, (String) readValue);
                            } else if (readValue instanceof Boolean) {
                                bundle2.putBoolean(C, ((Boolean) readValue).booleanValue());
                            } else if (readValue instanceof Integer) {
                                bundle2.putInt(C, ((Integer) readValue).intValue());
                            } else if (readValue instanceof ArrayList) {
                                bundle2.putParcelableArrayList(C, (ArrayList) readValue);
                            } else if (readValue instanceof Bundle) {
                                bundle2.putBundle(C, (Bundle) readValue);
                            } else if (readValue instanceof Parcelable) {
                                bundle2.putParcelable(C, (Parcelable) readValue);
                            }
                        } else if (A.readInt() != 4) {
                            Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                            A.recycle();
                            return pair;
                        } else {
                            if ("com.google.android.gms.gcm.PendingCallback".equals(A.readString())) {
                                obj = new h(A.readStrongBinder());
                            } else {
                                Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                                A.recycle();
                                return pair;
                            }
                        }
                    }
                }
                if (obj == null) {
                    Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                    A.recycle();
                    return pair;
                }
                Pair<o, Bundle> create = Pair.create(obj, bundle2);
                A.recycle();
                return create;
            }
        } finally {
            A.recycle();
        }
    }

    private static Parcel A(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }

    private static String C(Parcel parcel) {
        if (oB()) {
            return parcel.readString();
        }
        Object readValue = parcel.readValue(null);
        if (readValue instanceof String) {
            return (String) readValue;
        }
        Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
        return null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:23:?, code:
            JR = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Missing block: B:25:?, code:
            r1.recycle();
     */
    private static synchronized boolean oB() {
        /*
        r0 = com.firebase.jobdispatcher.f.class;
        monitor-enter(r0);
        r1 = JR;	 Catch:{ all -> 0x0065 }
        if (r1 != 0) goto L_0x005d;
    L_0x0007:
        r1 = new android.os.Bundle;	 Catch:{ all -> 0x0065 }
        r1.<init>();	 Catch:{ all -> 0x0065 }
        r2 = "key";
        r3 = "value";
        r1.putString(r2, r3);	 Catch:{ all -> 0x0065 }
        r1 = A(r1);	 Catch:{ all -> 0x0065 }
        r2 = r1.readInt();	 Catch:{ RuntimeException -> 0x0054 }
        r3 = 0;
        r4 = 1;
        if (r2 <= 0) goto L_0x0021;
    L_0x001f:
        r2 = 1;
        goto L_0x0022;
    L_0x0021:
        r2 = 0;
    L_0x0022:
        U(r2);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = r1.readInt();	 Catch:{ RuntimeException -> 0x0054 }
        r5 = 1279544898; // 0x4c444e42 float:5.146036E7 double:6.321791764E-315;
        if (r2 != r5) goto L_0x0030;
    L_0x002e:
        r2 = 1;
        goto L_0x0031;
    L_0x0030:
        r2 = 0;
    L_0x0031:
        U(r2);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = r1.readInt();	 Catch:{ RuntimeException -> 0x0054 }
        if (r2 != r4) goto L_0x003b;
    L_0x003a:
        r3 = 1;
    L_0x003b:
        U(r3);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = "key";
        r3 = r1.readString();	 Catch:{ RuntimeException -> 0x0054 }
        r2 = r2.equals(r3);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ RuntimeException -> 0x0054 }
        JR = r2;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x004e:
        r1.recycle();	 Catch:{ all -> 0x0065 }
        goto L_0x005d;
    L_0x0052:
        r2 = move-exception;
        goto L_0x0059;
    L_0x0054:
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0052 }
        JR = r2;	 Catch:{ all -> 0x0052 }
        goto L_0x004e;
    L_0x0059:
        r1.recycle();	 Catch:{ all -> 0x0065 }
        throw r2;	 Catch:{ all -> 0x0065 }
    L_0x005d:
        r1 = JR;	 Catch:{ all -> 0x0065 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0065 }
        monitor-exit(r0);
        return r1;
    L_0x0065:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.f.oB():boolean");
    }

    private static void U(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
