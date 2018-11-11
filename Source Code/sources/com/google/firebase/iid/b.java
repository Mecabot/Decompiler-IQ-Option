package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;

final class b {
    private SharedPreferences XW;
    private Context zzaiq;

    public b(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private b(Context context, String str) {
        this.zzaiq = context;
        this.XW = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        str = String.valueOf("-no-backup");
        File file = new File(zzx.getNoBackupFilesDir(this.zzaiq), str.length() != 0 ? valueOf.concat(str) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    wy();
                    FirebaseInstanceId.wj().wr();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    str = "FirebaseInstanceId";
                    String str2 = "Error creating file in no backup dir: ";
                    valueOf = String.valueOf(e.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    private static String Q(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("|S|");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private static String e(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append("|T|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    private final synchronized boolean isEmpty() {
        return this.XW.getAll().isEmpty();
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        str4 = c.a(str4, str5, System.currentTimeMillis());
        if (str4 != null) {
            Editor edit = this.XW.edit();
            edit.putString(e(str, str2, str3), str4);
            edit.commit();
        }
    }

    public final synchronized void cO(String str) {
        String string = this.XW.getString("topic_operaion_queue", "");
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(string).length() + 1) + String.valueOf(str).length());
        stringBuilder.append(string);
        stringBuilder.append(",");
        stringBuilder.append(str);
        this.XW.edit().putString("topic_operaion_queue", stringBuilder.toString()).apply();
    }

    public final synchronized boolean cR(String str) {
        boolean z;
        String string = this.XW.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            valueOf = String.valueOf(",");
            str = String.valueOf(str);
            this.XW.edit().putString("topic_operaion_queue", string.substring((str.length() != 0 ? valueOf.concat(str) : new String(valueOf)).length())).apply();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    final synchronized KeyPair cS(String str) {
        KeyPair ww;
        ww = a.ww();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.XW.edit();
        edit.putString(Q(str, "|P|"), Base64.encodeToString(ww.getPublic().getEncoded(), 11));
        edit.putString(Q(str, "|K|"), Base64.encodeToString(ww.getPrivate().getEncoded(), 11));
        edit.putString(Q(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return ww;
    }

    public final synchronized void cT(String str) {
        str = String.valueOf(str).concat("|T|");
        Editor edit = this.XW.edit();
        for (String str2 : this.XW.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0048 A:{Splitter: B:6:0x0021, ExcHandler: java.security.spec.InvalidKeySpecException (r5_5 'e' java.security.spec.InvalidKeySpecException)} */
    /* JADX WARNING: Missing block: B:10:0x0048, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:?, code:
            r5 = java.lang.String.valueOf(r5);
            r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 19);
            r3.append("Invalid key stored ");
            r3.append(r5);
            android.util.Log.w("FirebaseInstanceId", r3.toString());
            com.google.firebase.iid.FirebaseInstanceId.wj().wr();
     */
    /* JADX WARNING: Missing block: B:14:0x0075, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:16:0x0077, code:
            return null;
     */
    public final synchronized java.security.KeyPair cU(java.lang.String r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.XW;	 Catch:{ all -> 0x0078 }
        r1 = "|P|";
        r1 = Q(r5, r1);	 Catch:{ all -> 0x0078 }
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ all -> 0x0078 }
        r1 = r4.XW;	 Catch:{ all -> 0x0078 }
        r3 = "|K|";
        r5 = Q(r5, r3);	 Catch:{ all -> 0x0078 }
        r5 = r1.getString(r5, r2);	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0076;
    L_0x001c:
        if (r5 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0076;
    L_0x001f:
        r1 = 8;
        r0 = android.util.Base64.decode(r0, r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r5 = android.util.Base64.decode(r5, r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1 = "RSA";
        r1 = java.security.KeyFactory.getInstance(r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3.<init>(r0);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r0 = r1.generatePublic(r3);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3 = new java.security.spec.PKCS8EncodedKeySpec;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3.<init>(r5);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r5 = r1.generatePrivate(r3);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1 = new java.security.KeyPair;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1.<init>(r0, r5);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        monitor-exit(r4);
        return r1;
    L_0x0048:
        r5 = move-exception;
        r0 = "FirebaseInstanceId";
        r5 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0078 }
        r1 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0078 }
        r1 = r1.length();	 Catch:{ all -> 0x0078 }
        r1 = r1 + 19;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0078 }
        r3.<init>(r1);	 Catch:{ all -> 0x0078 }
        r1 = "Invalid key stored ";
        r3.append(r1);	 Catch:{ all -> 0x0078 }
        r3.append(r5);	 Catch:{ all -> 0x0078 }
        r5 = r3.toString();	 Catch:{ all -> 0x0078 }
        android.util.Log.w(r0, r5);	 Catch:{ all -> 0x0078 }
        r5 = com.google.firebase.iid.FirebaseInstanceId.wj();	 Catch:{ all -> 0x0078 }
        r5.wr();	 Catch:{ all -> 0x0078 }
        monitor-exit(r4);
        return r2;
    L_0x0076:
        monitor-exit(r4);
        return r2;
    L_0x0078:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.b.cU(java.lang.String):java.security.KeyPair");
    }

    public final synchronized c f(String str, String str2, String str3) {
        return c.cV(this.XW.getString(e(str, str2, str3), null));
    }

    /* JADX WARNING: Missing block: B:12:0x0023, code:
            return null;
     */
    @android.support.annotation.Nullable
    public final synchronized java.lang.String wx() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.XW;	 Catch:{ all -> 0x0024 }
        r1 = "topic_operaion_queue";
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0022;
    L_0x000c:
        r1 = ",";
        r0 = r0.split(r1);	 Catch:{ all -> 0x0024 }
        r1 = r0.length;	 Catch:{ all -> 0x0024 }
        r3 = 1;
        if (r1 <= r3) goto L_0x0022;
    L_0x0016:
        r1 = r0[r3];	 Catch:{ all -> 0x0024 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0024 }
        if (r1 != 0) goto L_0x0022;
    L_0x001e:
        r0 = r0[r3];	 Catch:{ all -> 0x0024 }
        monitor-exit(r4);
        return r0;
    L_0x0022:
        monitor-exit(r4);
        return r2;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.b.wx():java.lang.String");
    }

    public final synchronized void wy() {
        this.XW.edit().clear().commit();
    }
}
