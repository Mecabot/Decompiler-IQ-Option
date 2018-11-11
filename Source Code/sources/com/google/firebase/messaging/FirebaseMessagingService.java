package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.firebase.iid.ac;
import com.google.firebase.iid.f;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class FirebaseMessagingService extends f {
    private static final Queue<String> Ze = new ArrayDeque(10);

    static void M(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    static boolean N(Bundle bundle) {
        return bundle == null ? false : "1".equals(bundle.getString("google.c.a.e"));
    }

    @WorkerThread
    public void a(b bVar) {
    }

    @WorkerThread
    public void b(String str, Exception exception) {
    }

    @WorkerThread
    public void da(String str) {
    }

    @Hide
    protected final Intent m(Intent intent) {
        return ac.wP().wQ();
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Missing block: B:56:0x00e0, code:
            if (r1.equals("send_error") != false) goto L_0x00f8;
     */
    @com.google.android.gms.common.internal.Hide
    public final void n(android.content.Intent r10) {
        /*
        r9 = this;
        r0 = r10.getAction();
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = "";
    L_0x0008:
        r1 = r0.hashCode();
        r2 = 75300319; // 0x47cfddf float:2.973903E-36 double:3.72033007E-316;
        r3 = -1;
        r4 = 1;
        r5 = 0;
        if (r1 == r2) goto L_0x0024;
    L_0x0014:
        r2 = 366519424; // 0x15d8a480 float:8.750124E-26 double:1.81084656E-315;
        if (r1 == r2) goto L_0x001a;
    L_0x0019:
        goto L_0x002e;
    L_0x001a:
        r1 = "com.google.android.c2dm.intent.RECEIVE";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x002e;
    L_0x0022:
        r0 = 0;
        goto L_0x002f;
    L_0x0024:
        r1 = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x002e;
    L_0x002c:
        r0 = 1;
        goto L_0x002f;
    L_0x002e:
        r0 = -1;
    L_0x002f:
        switch(r0) {
            case 0: goto L_0x0058;
            case 1: goto L_0x004a;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = "FirebaseMessaging";
        r1 = "Unknown intent action: ";
        r10 = r10.getAction();
        r10 = java.lang.String.valueOf(r10);
        r2 = r10.length();
        if (r2 == 0) goto L_0x0199;
    L_0x0044:
        r10 = r1.concat(r10);
        goto L_0x019e;
    L_0x004a:
        r0 = r10.getExtras();
        r0 = N(r0);
        if (r0 == 0) goto L_0x01a1;
    L_0x0054:
        com.google.firebase.messaging.f.i(r9, r10);
        return;
    L_0x0058:
        r0 = "google.message_id";
        r0 = r10.getStringExtra(r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 3;
        if (r1 == 0) goto L_0x0067;
    L_0x0065:
        r1 = 0;
        goto L_0x00aa;
    L_0x0067:
        r1 = Ze;
        r1 = r1.contains(r0);
        if (r1 == 0) goto L_0x0095;
    L_0x006f:
        r1 = "FirebaseMessaging";
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0093;
    L_0x0077:
        r1 = "FirebaseMessaging";
        r6 = "Received duplicate message: ";
        r7 = java.lang.String.valueOf(r0);
        r8 = r7.length();
        if (r8 == 0) goto L_0x008a;
    L_0x0085:
        r6 = r6.concat(r7);
        goto L_0x0090;
    L_0x008a:
        r7 = new java.lang.String;
        r7.<init>(r6);
        r6 = r7;
    L_0x0090:
        android.util.Log.d(r1, r6);
    L_0x0093:
        r1 = 1;
        goto L_0x00aa;
    L_0x0095:
        r1 = Ze;
        r1 = r1.size();
        r6 = 10;
        if (r1 < r6) goto L_0x00a4;
    L_0x009f:
        r1 = Ze;
        r1.remove();
    L_0x00a4:
        r1 = Ze;
        r1.add(r0);
        goto L_0x0065;
    L_0x00aa:
        r6 = 2;
        if (r1 != 0) goto L_0x0181;
    L_0x00ad:
        r1 = "message_type";
        r1 = r10.getStringExtra(r1);
        if (r1 != 0) goto L_0x00b7;
    L_0x00b5:
        r1 = "gcm";
    L_0x00b7:
        r7 = r1.hashCode();
        r8 = -2062414158; // 0xffffffff85120eb2 float:-6.867586E-36 double:NaN;
        if (r7 == r8) goto L_0x00ed;
    L_0x00c0:
        r4 = 102161; // 0x18f11 float:1.43158E-40 double:5.0474E-319;
        if (r7 == r4) goto L_0x00e3;
    L_0x00c5:
        r4 = 814694033; // 0x308f3e91 float:1.0422402E-9 double:4.025123336E-315;
        if (r7 == r4) goto L_0x00da;
    L_0x00ca:
        r2 = 814800675; // 0x3090df23 float:1.0540798E-9 double:4.025650217E-315;
        if (r7 == r2) goto L_0x00d0;
    L_0x00cf:
        goto L_0x00f7;
    L_0x00d0:
        r2 = "send_event";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x00f7;
    L_0x00d8:
        r2 = 2;
        goto L_0x00f8;
    L_0x00da:
        r4 = "send_error";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x00f7;
    L_0x00e2:
        goto L_0x00f8;
    L_0x00e3:
        r2 = "gcm";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x00f7;
    L_0x00eb:
        r2 = 0;
        goto L_0x00f8;
    L_0x00ed:
        r2 = "deleted_messages";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x00f7;
    L_0x00f5:
        r2 = 1;
        goto L_0x00f8;
    L_0x00f7:
        r2 = -1;
    L_0x00f8:
        switch(r2) {
            case 0: goto L_0x013a;
            case 1: goto L_0x0136;
            case 2: goto L_0x012c;
            case 3: goto L_0x010f;
            default: goto L_0x00fb;
        };
    L_0x00fb:
        r10 = "FirebaseMessaging";
        r2 = "Received message with unknown type: ";
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0179;
    L_0x0109:
        r1 = r2.concat(r1);
        goto L_0x017e;
    L_0x010f:
        r1 = "google.message_id";
        r1 = r10.getStringExtra(r1);
        if (r1 != 0) goto L_0x011d;
    L_0x0117:
        r1 = "message_id";
        r1 = r10.getStringExtra(r1);
    L_0x011d:
        r2 = new com.google.firebase.messaging.SendException;
        r3 = "error";
        r10 = r10.getStringExtra(r3);
        r2.<init>(r10);
        r9.b(r1, r2);
        goto L_0x0181;
    L_0x012c:
        r1 = "google.message_id";
        r10 = r10.getStringExtra(r1);
        r9.da(r10);
        goto L_0x0181;
    L_0x0136:
        r9.wS();
        goto L_0x0181;
    L_0x013a:
        r1 = r10.getExtras();
        r1 = N(r1);
        if (r1 == 0) goto L_0x0147;
    L_0x0144:
        com.google.firebase.messaging.f.g(r9, r10);
    L_0x0147:
        r1 = r10.getExtras();
        if (r1 != 0) goto L_0x0152;
    L_0x014d:
        r1 = new android.os.Bundle;
        r1.<init>();
    L_0x0152:
        r2 = "android.support.content.wakelockid";
        r1.remove(r2);
        r2 = com.google.firebase.messaging.c.O(r1);
        if (r2 == 0) goto L_0x0170;
    L_0x015d:
        r2 = com.google.firebase.messaging.c.aD(r9);
        r2 = r2.Q(r1);
        if (r2 != 0) goto L_0x0181;
    L_0x0167:
        r2 = N(r1);
        if (r2 == 0) goto L_0x0170;
    L_0x016d:
        com.google.firebase.messaging.f.j(r9, r10);
    L_0x0170:
        r10 = new com.google.firebase.messaging.b;
        r10.<init>(r1);
        r9.a(r10);
        goto L_0x0181;
    L_0x0179:
        r1 = new java.lang.String;
        r1.<init>(r2);
    L_0x017e:
        android.util.Log.w(r10, r1);
    L_0x0181:
        r10 = android.text.TextUtils.isEmpty(r0);
        if (r10 != 0) goto L_0x0198;
    L_0x0187:
        r10 = new android.os.Bundle;
        r10.<init>();
        r1 = "google.message_id";
        r10.putString(r1, r0);
        r0 = com.google.firebase.iid.o.aB(r9);
        r0.a(r6, r10);
    L_0x0198:
        return;
    L_0x0199:
        r10 = new java.lang.String;
        r10.<init>(r1);
    L_0x019e:
        android.util.Log.d(r0, r10);
    L_0x01a1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.n(android.content.Intent):void");
    }

    @Hide
    public final boolean p(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (N(intent.getExtras())) {
            f.h(this, intent);
        }
        return true;
    }

    @WorkerThread
    public void wS() {
    }
}
