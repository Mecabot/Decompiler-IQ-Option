package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.iqoption.core.data.b.c;
import com.iqoption.core.microservices.core.a.d;
import io.reactivex.c.e;
import io.reactivex.disposables.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0014J.\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020*R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/RegistrationViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "currenciesList", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/core/microservices/core/response/RegistrationCurrency;", "getCurrenciesList", "()Landroid/arch/lifecycle/LiveData;", "currenciesListData", "Landroid/arch/lifecycle/MutableLiveData;", "disposables", "Lio/reactivex/disposables/Disposable;", "isProgressShown", "", "isProgressShownData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "route", "Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeScreen;", "getRoute", "routeData", "selectedCurrency", "getSelectedCurrency", "selectedCurrencyData", "toastMessage", "", "getToastMessage", "toastMessageData", "getCurrentCurrencyPosition", "", "onCleared", "", "register", "email", "password", "name", "surname", "isGdpr", "registerTrial", "selectCurrency", "currency", "termsUrl", "Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;", "Companion", "core_release"})
/* compiled from: RegistrationViewModel.kt */
public final class RegistrationViewModel extends ViewModel {
    private static final String TAG = "RegistrationViewModel";
    public static final a bcN = new a();
    private final LiveData<Boolean> bcA = this.bcz;
    private final MutableLiveData<String> bcB = new MutableLiveData();
    private final LiveData<String> bcC = this.bcB;
    private final MutableLiveData<c> bcD = new MutableLiveData();
    private final LiveData<c> bcE = this.bcD;
    private final MutableLiveData<List<d>> bcI = new MutableLiveData();
    private final LiveData<List<d>> bcJ = this.bcI;
    private final MutableLiveData<d> bcK = new MutableLiveData();
    private final LiveData<d> bcL = this.bcK;
    private b bcM;
    private final c<Boolean> bcz = new c(Boolean.valueOf(false));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/RegistrationViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/RegistrationViewModel;", "f", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/support/v4/app/FragmentActivity;", "core_release"})
    /* compiled from: RegistrationViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/core/response/RegistrationCurrenciesResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: RegistrationViewModel.kt */
    /* renamed from: com.iqoption.core.ui.viewmodel.welcome.RegistrationViewModel$1 */
    static final class AnonymousClass1<T> implements e<com.iqoption.core.microservices.core.a.c> {
        final /* synthetic */ RegistrationViewModel bcO;

        AnonymousClass1(RegistrationViewModel registrationViewModel) {
            this.bcO = registrationViewModel;
        }

        /* renamed from: a */
        public final void accept(com.iqoption.core.microservices.core.a.c cVar) {
            Object next;
            Collection arrayList = new ArrayList();
            Iterator it = cVar.vn().iterator();
            while (true) {
                Object obj = null;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
                if (((d) next).VK()) {
                    obj = 1;
                }
                if (obj != null) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            for (Object next2 : list) {
                Object obj2;
                if (((d) next2).isDefault()) {
                    obj2 = 1;
                    continue;
                } else {
                    obj2 = null;
                    continue;
                }
                if (obj2 != null) {
                    break;
                }
            }
            next2 = null;
            next2 = (d) next2;
            if (next2 == null) {
                next2 = (d) u.bU(list);
            }
            this.bcO.bcI.postValue(list);
            this.bcO.bcK.postValue(next2);
        }
    }

    public RegistrationViewModel() {
        b bVar = this.bcM;
        if (bVar != null) {
            bVar.dispose();
        }
        this.bcM = com.iqoption.core.microservices.core.a.aVw.VH().h(com.iqoption.core.h.i.Yo()).a((e) new AnonymousClass1(this), (e) AnonymousClass2.bcP);
    }

    protected void onCleared() {
        super.onCleared();
        b bVar = this.bcM;
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
