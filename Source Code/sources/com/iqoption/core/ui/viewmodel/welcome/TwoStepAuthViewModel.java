package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.CountDownTimer;
import com.iqoption.core.data.b.c;
import com.iqoption.core.f;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/TwoStepAuthViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isProgressShown", "Landroid/arch/lifecycle/LiveData;", "", "()Landroid/arch/lifecycle/LiveData;", "isProgressShownData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "resendTimeout", "", "getResendTimeout", "resendTimeoutData", "Landroid/arch/lifecycle/MutableLiveData;", "resendTimeoutTimer", "Lcom/iqoption/core/ui/viewmodel/welcome/TwoStepAuthViewModel$ResendTimeoutTimer;", "toastMessage", "getToastMessage", "toastMessageData", "login", "", "email", "password", "code", "resendCode", "Companion", "ResendTimeoutTimer", "core_release"})
/* compiled from: TwoStepAuthViewModel.kt */
public final class TwoStepAuthViewModel extends ViewModel {
    private static final String TAG = "TwoStepAuthViewModel";
    private static final long bdf = (f.Dp().DJ() ? 5000 : 300000);
    public static final a bdg = new a();
    private final LiveData<Boolean> bcA = this.bcz;
    private final MutableLiveData<String> bcB = new MutableLiveData();
    private final LiveData<String> bcC = this.bcB;
    private final c<Boolean> bcz = new c(Boolean.valueOf(false));
    private final MutableLiveData<String> bdc = new MutableLiveData();
    private final LiveData<String> bdd = this.bdc;
    private b bde = new b(this.bdc);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/TwoStepAuthViewModel$Companion;", "", "()V", "CONFIRM_CODE_LENGTH", "", "RESEND_TIMEOUT", "", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/TwoStepAuthViewModel;", "f", "Landroid/support/v4/app/Fragment;", "getResentTimeout", "core_release"})
    /* compiled from: TwoStepAuthViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final long Zj() {
            long ER = com.iqoption.core.data.d.a.aOz.ER();
            if (ER == 0) {
                return 0;
            }
            return Math.max((ER + TwoStepAuthViewModel.bdf) - System.currentTimeMillis(), 0);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/TwoStepAuthViewModel$ResendTimeoutTimer;", "Landroid/os/CountDownTimer;", "liveData", "Landroid/arch/lifecycle/MutableLiveData;", "", "(Landroid/arch/lifecycle/MutableLiveData;)V", "formatter", "Ljava/text/SimpleDateFormat;", "getLiveData", "()Landroid/arch/lifecycle/MutableLiveData;", "onFinish", "", "onTick", "millisUntilFinished", "", "core_release"})
    /* compiled from: TwoStepAuthViewModel.kt */
    private static final class b extends CountDownTimer {
        private final SimpleDateFormat bdh = new SimpleDateFormat("mm:ss", Locale.getDefault());
        private final MutableLiveData<String> bdi;

        public b(MutableLiveData<String> mutableLiveData) {
            h.e(mutableLiveData, "liveData");
            super(TwoStepAuthViewModel.bdg.Zj(), 1000);
            this.bdi = mutableLiveData;
        }

        public void onFinish() {
            this.bdi.setValue(null);
        }

        public void onTick(long j) {
            this.bdi.setValue(this.bdh.format(Long.valueOf(j)));
        }
    }

    public TwoStepAuthViewModel() {
        this.bde.start();
    }
}
