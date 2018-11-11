package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.e;
import com.facebook.g;
import com.facebook.i.c;
import com.facebook.login.j;
import com.facebook.login.l;
import kotlin.i;
import kotlin.jvm.internal.h;
import org.json.JSONObject;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/FacebookAuthViewModel;", "Landroid/arch/lifecycle/ViewModel;", "callbackManager", "Lcom/facebook/CallbackManager;", "(Lcom/facebook/CallbackManager;)V", "facebookAuthLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "", "authFacebook", "", "accessToken", "Lcom/facebook/AccessToken;", "facebookLoginError", "facebookLogintSuccessful", "getFacebookAuth", "Landroid/arch/lifecycle/LiveData;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onFacebookButtonClick", "fragment", "Landroid/support/v4/app/Fragment;", "Companion", "core_release"})
/* compiled from: FacebookAuthViewModel.kt */
public final class FacebookAuthViewModel extends ViewModel {
    private static final String TAG = "FacebookAuthViewModel";
    public static final a bct = new a();
    private final MutableLiveData<Boolean> bcr;
    private final e bcs;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/FacebookAuthViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "facebookLogout", "", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/FacebookAuthViewModel;", "f", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/support/v4/app/FragmentActivity;", "core_release"})
    /* compiled from: FacebookAuthViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void Zc() {
            j.nB().nC();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, aXE = {"com/iqoption/core/ui/viewmodel/welcome/FacebookAuthViewModel$1", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "clear", "", "onCancel", "onError", "exception", "Lcom/facebook/FacebookException;", "onSuccess", "loginResult", "core_release"})
    /* compiled from: FacebookAuthViewModel.kt */
    /* renamed from: com.iqoption.core.ui.viewmodel.welcome.FacebookAuthViewModel$1 */
    public static final class AnonymousClass1 implements g<l> {
        final /* synthetic */ FacebookAuthViewModel bcu;

        AnonymousClass1(FacebookAuthViewModel facebookAuthViewModel) {
            this.bcu = facebookAuthViewModel;
        }

        /* renamed from: a */
        public void onSuccess(l lVar) {
            h.e(lVar, "loginResult");
            this.bcu.f(lVar.jo());
        }

        public void onCancel() {
            clear();
        }

        public void b(FacebookException facebookException) {
            h.e(facebookException, "exception");
            clear();
        }

        private final void clear() {
            this.bcu.Za();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "user", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "response", "Lcom/facebook/GraphResponse;", "onCompleted"})
    /* compiled from: FacebookAuthViewModel.kt */
    static final class b implements c {
        final /* synthetic */ FacebookAuthViewModel bcu;

        b(FacebookAuthViewModel facebookAuthViewModel) {
            this.bcu = facebookAuthViewModel;
        }

        public final void a(JSONObject jSONObject, com.facebook.l lVar) {
            if (jSONObject == null) {
                this.bcu.Za();
            } else if (TextUtils.isEmpty(jSONObject.optString("email"))) {
                this.bcu.Za();
            } else {
                jSONObject.optString("first_name");
                jSONObject.optString("last_name");
                jSONObject.optString("id");
                this.bcu.Zb();
            }
        }
    }

    public FacebookAuthViewModel() {
        this(null, 1, null);
    }

    public static final void Zc() {
        bct.Zc();
    }

    public FacebookAuthViewModel(e eVar) {
        h.e(eVar, "callbackManager");
        this.bcs = eVar;
        this.bcr = new MutableLiveData();
        j.nB().a(this.bcs, (g) new AnonymousClass1(this));
    }

    public /* synthetic */ FacebookAuthViewModel(e eVar, int i, f fVar) {
        if ((i & 1) != 0) {
            eVar = com.facebook.e.a.iL();
            h.d(eVar, "CallbackManager.Factory.create()");
        }
        this(eVar);
    }

    private final void Za() {
        bct.Zc();
        this.bcr.postValue(Boolean.valueOf(false));
    }

    private final void Zb() {
        this.bcr.postValue(Boolean.valueOf(true));
    }

    private final void f(com.facebook.a aVar) {
        com.iqoption.core.i.v(TAG, "authFacebook");
        if (aVar != null) {
            com.facebook.i a = com.facebook.i.a(aVar, (c) new b(this));
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,first_name,last_name,email");
            h.d(a, "request");
            a.setParameters(bundle);
            a.jr();
        }
    }
}
