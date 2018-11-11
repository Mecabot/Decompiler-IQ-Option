package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    public void onCreate(Bundle bundle) {
        String valueOf;
        String str;
        try {
            super.onCreate(bundle);
            zzdj.zzcy("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzq(data)) {
                valueOf = String.valueOf(data);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 73);
                stringBuilder.append("Cannot preview the app with the uri: ");
                stringBuilder.append(valueOf);
                stringBuilder.append(". Launching current version instead.");
                CharSequence stringBuilder2 = stringBuilder.toString();
                zzdj.zzcz(stringBuilder2);
                AlertDialog create = new Builder(this).create();
                create.setTitle("Preview failure");
                create.setMessage(stringBuilder2);
                create.setButton(-1, "Continue", new zzeh(this));
                create.show();
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                str = "Invoke the launch activity for package name: ";
                String valueOf2 = String.valueOf(getPackageName());
                zzdj.zzcy(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                startActivity(launchIntentForPackage);
                return;
            }
            valueOf = "No launch activity found for package name: ";
            str = String.valueOf(getPackageName());
            zzdj.zzcy(str.length() != 0 ? valueOf.concat(str) : new String(valueOf));
        } catch (Exception e) {
            str = "Calling preview threw an exception: ";
            valueOf = String.valueOf(e.getMessage());
            zzdj.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
