package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.google.gson.JsonObject;
import com.iqoption.core.f;
import io.reactivex.c.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "disposables", "Lio/reactivex/disposables/Disposable;", "termsBody", "Landroid/arch/lifecycle/MutableLiveData;", "", "termsHeader", "getTermsBodyLiveData", "Landroid/arch/lifecycle/LiveData;", "getTermsHeaderLiveData", "loadTerms", "", "termsArg", "Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;", "onCleared", "Companion", "TERMS", "core_release"})
/* compiled from: TermsViewModel.kt */
public final class TermsViewModel extends ViewModel {
    private static final String TAG = "TermsViewModel";
    public static final a bcZ = new a();
    private io.reactivex.disposables.b bcM;
    private final MutableLiveData<String> bcX = new MutableLiveData();
    private final MutableLiveData<String> bcY = new MutableLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BONUS", "CONDITIONS", "REGULATED", "REGULATED_PRACTICE", "RISK_DISCLOSURE", "core_release"})
    /* compiled from: TermsViewModel.kt */
    public enum TERMS {
        BONUS("bonus-terms-and-conditions"),
        CONDITIONS("terms-conditions"),
        REGULATED("terms-regulated"),
        REGULATED_PRACTICE("practice-account-terms"),
        RISK_DISCLOSURE("risk-disclosure");
        
        private final String value;

        protected TERMS(String str) {
            h.e(str, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel;", "f", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/support/v4/app/FragmentActivity;", "core_release"})
    /* compiled from: TermsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final TermsViewModel t(Fragment fragment) {
            h.e(fragment, "f");
            return (TermsViewModel) ViewModelProviders.d(fragment).h(TermsViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/google/gson/JsonObject;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TermsViewModel.kt */
    static final class b<T> implements e<JsonObject> {
        final /* synthetic */ TermsViewModel bda;

        b(TermsViewModel termsViewModel) {
            this.bda = termsViewModel;
        }

        /* renamed from: f */
        public final void accept(JsonObject jsonObject) {
            jsonObject = jsonObject.getAsJsonObject("result").getAsJsonObject(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT).getAsJsonObject(f.getLocale());
            String i = com.iqoption.core.util.i.i(jsonObject.get("header"));
            String i2 = com.iqoption.core.util.i.i(jsonObject.get("text"));
            this.bda.bcX.postValue(i);
            this.bda.bcY.postValue(i2);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TermsViewModel.kt */
    static final class c<T> implements e<Throwable> {
        public static final c bdb = new c();

        c() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(TermsViewModel.TAG, th);
        }
    }

    public final LiveData<String> Zg() {
        return this.bcX;
    }

    public final LiveData<String> Zh() {
        return this.bcY;
    }

    public final void b(TERMS terms) {
        h.e(terms, "termsArg");
        io.reactivex.disposables.b bVar = this.bcM;
        if (bVar != null) {
            bVar.dispose();
        }
        this.bcM = com.iqoption.core.microservices.core.a.aVw.gB(terms.getValue()).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((e) new b(this), (e) c.bdb);
    }

    protected void onCleared() {
        super.onCleared();
        io.reactivex.disposables.b bVar = this.bcM;
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
