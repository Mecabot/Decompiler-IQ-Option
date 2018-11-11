package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private static boolean zzeod = false;
    private boolean zzeoe = false;
    @VisibleForTesting
    private SignInConfiguration zzeof;
    private boolean zzeog;
    private int zzeoh;
    private Intent zzeoi;

    class zza implements LoaderCallbacks<Void> {
        private zza() {
        }

        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzc(SignInHubActivity.this, GoogleApiClient.zzahz());
        }

        public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            SignInHubActivity.this.setResult(SignInHubActivity.this.zzeoh, SignInHubActivity.this.zzeoi);
            SignInHubActivity.this.finish();
        }

        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    private final void zzacw() {
        getSupportLoaderManager().initLoader(0, null, new zza());
        zzeod = false;
    }

    private final void zzaz(int i) {
        Parcelable status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zzeod = false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.zzeoe) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                        Parcelable googleSignInAccount = signInAccount.getGoogleSignInAccount();
                        zzp.zzbq(this).zza(this.zzeof.zzacv(), googleSignInAccount);
                        intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.zzeog = true;
                        this.zzeoh = i2;
                        this.zzeoi = intent;
                        zzacw();
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        zzaz(intent.getIntExtra("errorCode", 8));
                        return;
                    }
                }
                zzaz(8);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zzaz(GoogleSignInStatusCodes.SIGN_IN_FAILED);
        } else if (zzeod) {
            setResult(0);
            zzaz(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
        } else {
            zzeod = true;
            if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
                this.zzeof = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
                if (this.zzeof == null) {
                    Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                    setResult(0);
                    finish();
                    return;
                } else if (bundle == null) {
                    Intent intent2 = new Intent(action);
                    intent2.setPackage(action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") ? "com.google.android.gms" : getPackageName());
                    intent2.putExtra("config", this.zzeof);
                    try {
                        startActivityForResult(intent2, 40962);
                        return;
                    } catch (ActivityNotFoundException unused) {
                        this.zzeoe = true;
                        Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                        zzaz(17);
                        return;
                    }
                } else {
                    this.zzeog = bundle.getBoolean("signingInGoogleApiClients");
                    if (this.zzeog) {
                        this.zzeoh = bundle.getInt("signInResultCode");
                        this.zzeoi = (Intent) bundle.getParcelable("signInResultData");
                        zzacw();
                    }
                    return;
                }
            }
            String str = "AuthSignInClient";
            action = "Unknown action: ";
            String valueOf = String.valueOf(intent.getAction());
            Log.e(str, valueOf.length() != 0 ? action.concat(valueOf) : new String(action));
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zzeog);
        if (this.zzeog) {
            bundle.putInt("signInResultCode", this.zzeoh);
            bundle.putParcelable("signInResultData", this.zzeoi);
        }
    }
}
