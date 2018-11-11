package com.iqoption.newsandupdates;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.s;
import com.iqoption.core.microservices.busapi.response.b;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000f"}, aXE = {"Lcom/iqoption/newsandupdates/NewsAndUpdatesViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getSettings", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/newsandupdates/NewsAndUpdatesItem;", "setPersonalDataPolicy", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "policy", "Lcom/iqoption/core/microservices/busapi/response/PersonalDataPolicy;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NewsAndUpdatesViewModel.kt */
public final class NewsAndUpdatesViewModel extends AndroidViewModel {
    public static final a cXg = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/newsandupdates/NewsAndUpdatesViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/newsandupdates/NewsAndUpdatesViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NewsAndUpdatesViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final NewsAndUpdatesViewModel r(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(NewsAndUpdatesViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…tesViewModel::class.java]");
            return (NewsAndUpdatesViewModel) h;
        }
    }

    public NewsAndUpdatesViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    public final LiveData<List<f>> avq() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        com.iqoption.app.a aL = com.iqoption.app.a.aL((Context) getApplication());
        h.d(aL, "IQAccount.getInstance(getApplication())");
        b CS = aL.CS();
        f[] fVarArr = new f[4];
        Type type = Type.EMAIL;
        Boolean Vv = CS.Vv();
        boolean z = true;
        fVarArr[0] = new f(type, R.string.email_notifications, R.string.email_notifications_description, Vv != null ? Vv.booleanValue() : true);
        type = Type.PUSH;
        Boolean Vw = CS.Vw();
        fVarArr[1] = new f(type, R.string.push_notifications, R.string.news_and_updates_push_notifications_description, Vw != null ? Vw.booleanValue() : true);
        Type type2 = Type.CALL;
        Boolean Vx = CS.Vx();
        fVarArr[2] = new f(type2, R.string.phone_calls, R.string.phone_calls_description, Vx != null ? Vx.booleanValue() : true);
        type2 = Type.THIRD_PARTY;
        Boolean Vy = CS.Vy();
        if (Vy != null) {
            z = Vy.booleanValue();
        }
        fVarArr[3] = new f(type2, R.string.partners, R.string.i_let_iq_option_share, z);
        mutableLiveData.setValue(m.listOf(fVarArr));
        return mutableLiveData;
    }

    public final s<Void> b(b bVar) {
        h.e(bVar, "policy");
        return com.iqoption.core.microservices.busapi.a.aUn.b(bVar);
    }
}
