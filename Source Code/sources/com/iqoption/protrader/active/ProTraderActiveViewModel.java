package com.iqoption.protrader.active;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import com.iqoption.app.af;
import com.iqoption.protrader.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, aXE = {"Lcom/iqoption/protrader/active/ProTraderActiveViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getPreferences", "Landroid/content/SharedPreferences;", "setProTraderActiveHidden", "", "shouldShowProTraderActive", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderActiveViewModel.kt */
public final class ProTraderActiveViewModel extends AndroidViewModel {
    public static final a ddZ = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/protrader/active/ProTraderActiveViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/protrader/active/ProTraderActiveViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderActiveViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final ProTraderActiveViewModel t(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (ProTraderActiveViewModel) ViewModelProviders.b(fragmentActivity).h(ProTraderActiveViewModel.class);
        }
    }

    public ProTraderActiveViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    public final boolean ayC() {
        if (alQ().getBoolean("pro_trader_active_hidden", false)) {
            return false;
        }
        Application application = getApplication();
        h.d(application, "getApplication()");
        if (f.a(application, null, 2, null)) {
            return true;
        }
        return false;
    }

    public final void ayD() {
        alQ().edit().putBoolean("pro_trader_active_hidden", true).apply();
    }

    private final SharedPreferences alQ() {
        SharedPreferences Z = af.aR((Context) getApplication()).Z(com.iqoption.app.a.Cw().getUserId());
        h.d(Z, "Preferences.getInstance(…utUserPreferences(userId)");
        return Z;
    }
}
