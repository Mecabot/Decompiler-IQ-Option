package com.iqoption.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;
import com.iqoption.app.IQApp;
import com.iqoption.app.a.b;
import com.iqoption.core.i;

/* compiled from: GoogleAuthActivity */
public abstract class a extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener {
    private static final String TAG = "com.iqoption.activity.a";
    private boolean adA;
    private boolean adB;
    private ConnectionResult adC;
    private GoogleApiClient adz;

    protected abstract void b(String str, String str2, String str3, String str4, String str5);

    public abstract void zB();

    public abstract void zC();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.adz = new Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN).build();
    }

    protected void onStart() {
        super.onStart();
        if (aH(this)) {
            this.adz.connect();
        }
    }

    protected void onStop() {
        super.onStop();
        if (aH(this) && this.adz.isConnected()) {
            this.adz.disconnect();
        }
    }

    public void onConnected(Bundle bundle) {
        if (com.iqoption.app.a.aL(IQApp.Dk()).CG() || this.adB) {
            zC();
            this.adB = false;
            zx();
            return;
        }
        zF();
    }

    private void zx() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.GET_ACCOUNTS") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.GET_ACCOUNTS"}, 2);
        } else {
            new AsyncTask<Void, Void, String>() {
                /* renamed from: c */
                protected String doInBackground(Void... voidArr) {
                    try {
                        return GoogleAuthUtil.getToken(a.this, Plus.AccountApi.getAccountName(a.this.adz), "oauth2:https://www.googleapis.com/auth/plus.login");
                    } catch (Exception unused) {
                        a.this.zy();
                        return null;
                    }
                }

                /* renamed from: dO */
                protected void onPostExecute(String str) {
                    if (a.this.adz == null || !a.this.adz.isConnected()) {
                        a.this.zy();
                    } else {
                        a.this.dN(str);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 2) {
            return;
        }
        if (iArr.length == 1 && iArr[0] == 0) {
            zx();
        } else {
            zy();
        }
    }

    /* JADX WARNING: Missing block: B:12:?, code:
            zy();
     */
    /* JADX WARNING: Missing block: B:13:0x005e, code:
            zy();
     */
    /* JADX WARNING: Missing block: B:14:0x0061, code:
            return;
     */
    /* JADX WARNING: Missing block: B:15:0x0062, code:
            zy();
     */
    /* JADX WARNING: Missing block: B:16:0x0065, code:
            return;
     */
    private void dN(java.lang.String r9) {
        /*
        r8 = this;
        r0 = com.google.android.gms.plus.Plus.AccountApi;	 Catch:{ NullPointerException -> 0x005b }
        r1 = r8.adz;	 Catch:{ NullPointerException -> 0x005b }
        r3 = r0.getAccountName(r1);	 Catch:{ NullPointerException -> 0x005b }
        r0 = com.google.android.gms.plus.Plus.PeopleApi;	 Catch:{ NullPointerException -> 0x005b }
        r1 = r8.adz;	 Catch:{ NullPointerException -> 0x005b }
        r0 = r0.getCurrentPerson(r1);	 Catch:{ NullPointerException -> 0x005b }
        if (r0 != 0) goto L_0x0016;
    L_0x0012:
        r8.zy();
        return;
    L_0x0016:
        r1 = "";
        r2 = "";
        r4 = "";
        r5 = r0.getName();
        if (r5 == 0) goto L_0x0052;
    L_0x0022:
        r1 = r0.getName();
        r1 = r1.getGivenName();
        r2 = "";
        r1 = com.google.common.base.e.h(r1, r2);
        r1 = (java.lang.String) r1;
        r2 = r0.getName();
        r2 = r2.getFamilyName();
        r4 = "";
        r2 = com.google.common.base.e.h(r2, r4);
        r2 = (java.lang.String) r2;
        r0 = r0.getId();
        r4 = "";
        r0 = com.google.common.base.e.h(r0, r4);
        r0 = (java.lang.String) r0;
        r6 = r0;
        r4 = r1;
        r5 = r2;
        goto L_0x0055;
    L_0x0052:
        r5 = r2;
        r6 = r4;
        r4 = r1;
    L_0x0055:
        r2 = r8;
        r7 = r9;
        r2.b(r3, r4, r5, r6, r7);
        return;
    L_0x005b:
        r8.zy();	 Catch:{ all -> 0x0062 }
        r8.zy();
        return;
    L_0x0062:
        r8.zy();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.activity.a.dN(java.lang.String):void");
    }

    private void zy() {
        com.iqoption.core.d.a.aSe.post(new Runnable() {
            public void run() {
                a.this.zz();
                b.aT(a.this);
            }
        });
    }

    public void zz() {
        zB();
    }

    public void zA() {
        zB();
    }

    public void onConnectionSuspended(int i) {
        this.adz.connect();
    }

    private void zD() {
        if (this.adC == null || !this.adC.hasResolution()) {
            zF();
            zy();
            return;
        }
        try {
            this.adA = true;
            this.adC.startResolutionForResult(this, 0);
        } catch (SendIntentException unused) {
            this.adA = false;
            this.adz.connect();
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Google onConnectionFailed: ");
        stringBuilder.append(connectionResult);
        i.e(str, stringBuilder.toString());
        if (!this.adA) {
            this.adC = connectionResult;
            if (this.adB) {
                zD();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (i2 != -1) {
                this.adB = false;
            }
            if (i2 == 0) {
                zA();
            }
            this.adA = false;
            if (!this.adz.isConnecting()) {
                this.adz.connect();
            }
        }
    }

    public void zE() {
        if (aH(this)) {
            this.adB = true;
            zD();
        }
    }

    public void zF() {
        if (aH(this) && this.adz.isConnected()) {
            Plus.AccountApi.clearDefaultAccount(this.adz);
        }
    }

    public static boolean aH(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }
}
