package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zzs;
import com.google.firebase.a;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Hide
public final class z {
    private String YL;
    private String YM;
    private int YN;
    private int YO = 0;
    private final Context zzaiq;

    public z(Context context) {
        this.zzaiq = context;
    }

    public static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public static String b(a aVar) {
        String wi = aVar.wd().wi();
        if (wi != null) {
            return wi;
        }
        String it = aVar.wd().it();
        if (!it.startsWith("1:")) {
            return it;
        }
        String[] split = it.split(":");
        if (split.length < 2) {
            return null;
        }
        it = split[1];
        return it.isEmpty() ? null : it;
    }

    private final PackageInfo cY(String str) {
        try {
            return this.zzaiq.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 23);
            stringBuilder.append("Failed to find package ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    private final synchronized void wN() {
        PackageInfo cY = cY(this.zzaiq.getPackageName());
        if (cY != null) {
            this.YL = Integer.toString(cY.versionCode);
            this.YM = cY.versionName;
        }
    }

    public final synchronized int wJ() {
        if (this.YO != 0) {
            return this.YO;
        }
        PackageManager packageManager = this.zzaiq.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        Intent intent;
        if (!zzs.isAtLeastO()) {
            intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.YO = 1;
                return this.YO;
            }
        }
        intent = new Intent("com.google.iid.TOKEN_REQUEST");
        intent.setPackage("com.google.android.gms");
        List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (zzs.isAtLeastO()) {
                this.YO = 2;
            } else {
                this.YO = 1;
            }
            return this.YO;
        }
        this.YO = 2;
        return this.YO;
    }

    public final synchronized String wK() {
        if (this.YL == null) {
            wN();
        }
        return this.YL;
    }

    public final synchronized String wL() {
        if (this.YM == null) {
            wN();
        }
        return this.YM;
    }

    public final synchronized int wM() {
        if (this.YN == 0) {
            PackageInfo cY = cY("com.google.android.gms");
            if (cY != null) {
                this.YN = cY.versionCode;
            }
        }
        return this.YN;
    }
}
