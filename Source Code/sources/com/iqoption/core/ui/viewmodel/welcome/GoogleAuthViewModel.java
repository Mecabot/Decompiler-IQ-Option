package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.GoogleApiAvailability;
import com.iqoption.core.f;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J4\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/GoogleAuthViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "RC_SIGN_IN", "", "googleAuthLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleAuth", "Landroid/arch/lifecycle/LiveData;", "googleLogin", "", "fragment", "Landroid/support/v4/app/Fragment;", "googleLogout", "handleSignInResult", "result", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onError", "onSuccessful", "revokeAccess", "sendGoogleTokenToServer", "gmail", "", "name", "surname", "googleId", "accessToken", "Companion", "core_release"})
/* compiled from: GoogleAuthViewModel.kt */
public final class GoogleAuthViewModel extends ViewModel {
    private static final String TAG = "GoogleAuthViewModel";
    public static final a bcy = new a();
    private final int bcv = 9001;
    private GoogleSignInClient bcw;
    private final MutableLiveData<Boolean> bcx = new MutableLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/GoogleAuthViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "checkPlayServices", "", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/GoogleAuthViewModel;", "f", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/support/v4/app/FragmentActivity;", "core_release"})
    /* compiled from: GoogleAuthViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final boolean Zd() {
            boolean z = false;
            try {
                if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(f.RR()) == 0) {
                    z = true;
                }
            } catch (Exception unused) {
                return z;
            }
        }
    }

    public GoogleAuthViewModel() {
        if (!f.RQ().Dp().DP() && bcy.Zd()) {
            this.bcw = GoogleSignIn.getClient(f.RR(), new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build());
        }
    }
}
