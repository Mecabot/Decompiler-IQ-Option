package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.iid.m.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class aa {
    private static int YI;
    private static PendingIntent YP;
    private final z XO;
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> YQ = new SimpleArrayMap();
    private Messenger YR;
    private Messenger YS;
    private m YU;
    private final Context zzaiq;

    public aa(Context context, z zVar) {
        this.zzaiq = context;
        this.XO = zVar;
        this.YR = new Messenger(new ab(this, Looper.getMainLooper()));
    }

    private final Bundle K(Bundle bundle) {
        Bundle L = L(bundle);
        if (L == null || !L.containsKey("google.messenger")) {
            return L;
        }
        L = L(bundle);
        return (L == null || !L.containsKey("google.messenger")) ? L : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f4 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0107 A:{Catch:{ InterruptedException -> 0x0107, InterruptedException -> 0x0107, ExecutionException -> 0x0100, all -> 0x00fe }, Splitter: B:34:0x00e3, ExcHandler: java.lang.InterruptedException (unused java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:50:0x0107, code:
            android.util.Log.w("FirebaseInstanceId", "No response");
     */
    /* JADX WARNING: Missing block: B:51:0x0115, code:
            throw new java.io.IOException("TIMEOUT");
     */
    private final android.os.Bundle L(android.os.Bundle r9) {
        /*
        r8 = this;
        r0 = wO();
        r1 = new com.google.android.gms.tasks.TaskCompletionSource;
        r1.<init>();
        r2 = r8.YQ;
        monitor-enter(r2);
        r3 = r8.YQ;	 Catch:{ all -> 0x0123 }
        r3.put(r0, r1);	 Catch:{ all -> 0x0123 }
        monitor-exit(r2);	 Catch:{ all -> 0x0123 }
        r2 = r8.XO;
        r2 = r2.wJ();
        if (r2 != 0) goto L_0x0022;
    L_0x001a:
        r9 = new java.io.IOException;
        r0 = "MISSING_INSTANCEID_SERVICE";
        r9.<init>(r0);
        throw r9;
    L_0x0022:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "com.google.android.gms";
        r2.setPackage(r3);
        r3 = r8.XO;
        r3 = r3.wJ();
        r4 = 2;
        if (r3 != r4) goto L_0x003b;
    L_0x0035:
        r3 = "com.google.iid.TOKEN_REQUEST";
    L_0x0037:
        r2.setAction(r3);
        goto L_0x003e;
    L_0x003b:
        r3 = "com.google.android.c2dm.intent.REGISTER";
        goto L_0x0037;
    L_0x003e:
        r2.putExtras(r9);
        r9 = r8.zzaiq;
        e(r9, r2);
        r9 = "kid";
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r3 = r3 + 5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r3);
        r3 = "|ID|";
        r5.append(r3);
        r5.append(r0);
        r3 = "|";
        r5.append(r3);
        r3 = r5.toString();
        r2.putExtra(r9, r3);
        r9 = "FirebaseInstanceId";
        r3 = 3;
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x009c;
    L_0x0074:
        r9 = "FirebaseInstanceId";
        r5 = r2.getExtras();
        r5 = java.lang.String.valueOf(r5);
        r6 = java.lang.String.valueOf(r5);
        r6 = r6.length();
        r6 = r6 + 8;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Sending ";
        r7.append(r6);
        r7.append(r5);
        r5 = r7.toString();
        android.util.Log.d(r9, r5);
    L_0x009c:
        r9 = "google.messenger";
        r5 = r8.YR;
        r2.putExtra(r9, r5);
        r9 = r8.YS;
        if (r9 != 0) goto L_0x00ab;
    L_0x00a7:
        r9 = r8.YU;
        if (r9 == 0) goto L_0x00d0;
    L_0x00ab:
        r9 = android.os.Message.obtain();
        r9.obj = r2;
        r5 = r8.YS;	 Catch:{ RemoteException -> 0x00c1 }
        if (r5 == 0) goto L_0x00bb;
    L_0x00b5:
        r5 = r8.YS;	 Catch:{ RemoteException -> 0x00c1 }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00c1 }
        goto L_0x00e3;
    L_0x00bb:
        r5 = r8.YU;	 Catch:{ RemoteException -> 0x00c1 }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00c1 }
        goto L_0x00e3;
    L_0x00c1:
        r9 = "FirebaseInstanceId";
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x00d0;
    L_0x00c9:
        r9 = "FirebaseInstanceId";
        r3 = "Messenger failed, fallback to startService";
        android.util.Log.d(r9, r3);
    L_0x00d0:
        r9 = r8.XO;
        r9 = r9.wJ();
        if (r9 != r4) goto L_0x00de;
    L_0x00d8:
        r9 = r8.zzaiq;
        r9.sendBroadcast(r2);
        goto L_0x00e3;
    L_0x00de:
        r9 = r8.zzaiq;
        r9.startService(r2);
    L_0x00e3:
        r9 = r1.getTask();	 Catch:{ InterruptedException -> 0x0107, InterruptedException -> 0x0107, ExecutionException -> 0x0100 }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0107, InterruptedException -> 0x0107, ExecutionException -> 0x0100 }
        r9 = com.google.android.gms.tasks.Tasks.await(r9, r1, r3);	 Catch:{ InterruptedException -> 0x0107, InterruptedException -> 0x0107, ExecutionException -> 0x0100 }
        r9 = (android.os.Bundle) r9;	 Catch:{ InterruptedException -> 0x0107, InterruptedException -> 0x0107, ExecutionException -> 0x0100 }
        r1 = r8.YQ;
        monitor-enter(r1);
        r2 = r8.YQ;	 Catch:{ all -> 0x00fb }
        r2.remove(r0);	 Catch:{ all -> 0x00fb }
        monitor-exit(r1);	 Catch:{ all -> 0x00fb }
        return r9;
    L_0x00fb:
        r9 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00fb }
        throw r9;
    L_0x00fe:
        r9 = move-exception;
        goto L_0x0116;
    L_0x0100:
        r9 = move-exception;
        r1 = new java.io.IOException;	 Catch:{ all -> 0x00fe }
        r1.<init>(r9);	 Catch:{ all -> 0x00fe }
        throw r1;	 Catch:{ all -> 0x00fe }
    L_0x0107:
        r9 = "FirebaseInstanceId";
        r1 = "No response";
        android.util.Log.w(r9, r1);	 Catch:{ all -> 0x00fe }
        r9 = new java.io.IOException;	 Catch:{ all -> 0x00fe }
        r1 = "TIMEOUT";
        r9.<init>(r1);	 Catch:{ all -> 0x00fe }
        throw r9;	 Catch:{ all -> 0x00fe }
    L_0x0116:
        r1 = r8.YQ;
        monitor-enter(r1);
        r2 = r8.YQ;	 Catch:{ all -> 0x0120 }
        r2.remove(r0);	 Catch:{ all -> 0x0120 }
        monitor-exit(r1);	 Catch:{ all -> 0x0120 }
        throw r9;
    L_0x0120:
        r9 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0120 }
        throw r9;
    L_0x0123:
        r9 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0123 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.aa.L(android.os.Bundle):android.os.Bundle");
    }

    private final void d(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new a());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof m) {
                this.YU = (m) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.YS = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        String group;
        String str;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            CharSequence stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                q(intent2);
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                action = matcher.group(1);
                group = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group);
                d(action, extras);
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                str = "FirebaseInstanceId";
                group = "Unexpected response string: ";
                action = String.valueOf(stringExtra);
                Log.d(str, action.length() != 0 ? group.concat(action) : new String(group));
            }
            return;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            str = "FirebaseInstanceId";
            group = "Unexpected response action: ";
            action = String.valueOf(action);
            Log.d(str, action.length() != 0 ? group.concat(action) : new String(group));
        }
    }

    private final void d(String str, Bundle bundle) {
        synchronized (this.YQ) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.YQ.remove(str);
            if (taskCompletionSource == null) {
                String str2 = "FirebaseInstanceId";
                String str3 = "Missing callback for ";
                str = String.valueOf(str);
                Log.w(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
                return;
            }
            taskCompletionSource.setResult(bundle);
        }
    }

    @Hide
    private static synchronized void e(Context context, Intent intent) {
        synchronized (aa.class) {
            if (YP == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                YP = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", YP);
        }
    }

    private final void q(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        String valueOf;
        if (stringExtra == null) {
            valueOf = String.valueOf(intent.getExtras());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 49);
            stringBuilder.append("Unexpected response, no error or registration id ");
            stringBuilder.append(valueOf);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return;
        }
        String str;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            str = "FirebaseInstanceId";
            String str2 = "Received InstanceID error ";
            String valueOf2 = String.valueOf(stringExtra);
            Log.d(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (split.length <= 2 || !"ID".equals(split[1])) {
                valueOf = "FirebaseInstanceId";
                str = "Unexpected structured response ";
                stringExtra = String.valueOf(stringExtra);
                Log.w(valueOf, stringExtra.length() != 0 ? str.concat(stringExtra) : new String(str));
                return;
            }
            stringExtra = split[2];
            str = split[3];
            if (str.startsWith(":")) {
                str = str.substring(1);
            }
            d(stringExtra, intent.putExtra("error", str).getExtras());
            return;
        }
        synchronized (this.YQ) {
            for (int i = 0; i < this.YQ.size(); i++) {
                d((String) this.YQ.keyAt(i), intent.getExtras());
            }
        }
    }

    private static synchronized String wO() {
        String num;
        synchronized (aa.class) {
            int i = YI;
            YI = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001d A:{Splitter: B:3:0x0016, ExcHandler: java.lang.InterruptedException (r0_7 'e' java.lang.Exception)} */
    /* JADX WARNING: Missing block: B:6:0x001d, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x0025, code:
            if (android.util.Log.isLoggable("FirebaseInstanceId", 3) != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:9:0x0027, code:
            r2 = java.lang.String.valueOf(r0);
            r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 22);
            r4.append("Error making request: ");
            r4.append(r2);
            android.util.Log.d("FirebaseInstanceId", r4.toString());
     */
    /* JADX WARNING: Missing block: B:11:0x0051, code:
            if ((r0.getCause() instanceof com.google.firebase.iid.zzu) == false) goto L_0x0065;
     */
    /* JADX WARNING: Missing block: B:15:0x0064, code:
            return K(r6);
     */
    /* JADX WARNING: Missing block: B:17:0x0066, code:
            return null;
     */
    final android.os.Bundle J(android.os.Bundle r6) {
        /*
        r5 = this;
        r0 = r5.XO;
        r0 = r0.wM();
        r1 = 12000000; // 0xb71b00 float:1.6815582E-38 double:5.9287878E-317;
        if (r0 < r1) goto L_0x0067;
    L_0x000b:
        r0 = r5.zzaiq;
        r0 = com.google.firebase.iid.o.aB(r0);
        r1 = 1;
        r0 = r0.b(r1, r6);
        r0 = com.google.android.gms.tasks.Tasks.await(r0);	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        r0 = (android.os.Bundle) r0;	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        return r0;
    L_0x001d:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x004b;
    L_0x0027:
        r1 = "FirebaseInstanceId";
        r2 = java.lang.String.valueOf(r0);
        r3 = java.lang.String.valueOf(r2);
        r3 = r3.length();
        r3 = r3 + 22;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Error making request: ";
        r4.append(r3);
        r4.append(r2);
        r2 = r4.toString();
        android.util.Log.d(r1, r2);
    L_0x004b:
        r1 = r0.getCause();
        r1 = r1 instanceof com.google.firebase.iid.zzu;
        if (r1 == 0) goto L_0x0065;
    L_0x0053:
        r0 = r0.getCause();
        r0 = (com.google.firebase.iid.zzu) r0;
        r0 = r0.getErrorCode();
        r1 = 4;
        if (r0 != r1) goto L_0x0065;
    L_0x0060:
        r6 = r5.K(r6);
        return r6;
    L_0x0065:
        r6 = 0;
        return r6;
    L_0x0067:
        r6 = r5.K(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.aa.J(android.os.Bundle):android.os.Bundle");
    }
}
