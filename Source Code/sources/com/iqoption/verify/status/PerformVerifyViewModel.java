package com.iqoption.verify.status;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.dto.entity.iqbus.VerifyInitData;
import com.iqoption.mobbtech.connect.request.api.d;
import com.iqoption.mobbtech.connect.request.p;
import com.iqoption.util.af;
import com.jumio.MobileSDK;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.dv.DocumentVerificationSDK;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/verify/status/PerformVerifyViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "initLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/verify/status/PerformVerifyData;", "jumioSdk", "Lcom/jumio/dv/DocumentVerificationSDK;", "destroySdk", "", "getJumioSDK", "activity", "Landroid/app/Activity;", "verifyState", "Lcom/iqoption/verify/status/VerifyState;", "loadPerformVerifyData", "Landroid/arch/lifecycle/LiveData;", "userId", "", "cardId", "setVerifyCardUploaded", "Lcom/google/common/util/concurrent/ListenableFuture;", "uuid", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PerformVerifyViewModel.kt */
public final class PerformVerifyViewModel extends AndroidViewModel {
    private static final String TAG = "com.iqoption.verify.status.PerformVerifyViewModel";
    public static final a dyr = new a();
    private MutableLiveData<f> dyo = new MutableLiveData();
    private DocumentVerificationSDK dyp;
    private final Application dyq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/verify/status/PerformVerifyViewModel$Companion;", "", "()V", "TAG", "", "create", "Lcom/iqoption/verify/status/PerformVerifyViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PerformVerifyViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final PerformVerifyViewModel ab(Fragment fragment) {
            h.e(fragment, "fragment");
            ViewModel h = ViewModelProviders.d(fragment).h(PerformVerifyViewModel.class);
            h.d(h, "ViewModelProviders.of(fr…ifyViewModel::class.java]");
            return (PerformVerifyViewModel) h;
        }
    }

    public PerformVerifyViewModel(Application application) {
        h.e(application, "app");
        super(application);
        this.dyq = application;
    }

    static {
        if (PerformVerifyViewModel.class.getName() == null) {
            h.aXZ();
        }
    }

    public final LiveData<f> v(long j, long j2) {
        if (this.dyo.getValue() == null) {
            s q = com.iqoption.verify.a.dxq.q(j, j2);
            s by = d.by(com.iqoption.app.a.aL((Context) this.dyq).Db());
            s a = o.a(q, by);
            h.d(a, "configAndCountryFeature");
            af.a(a, new PerformVerifyViewModel$loadPerformVerifyData$1(this), new PerformVerifyViewModel$loadPerformVerifyData$2(this), null, 4, null);
        }
        return this.dyo;
    }

    public final DocumentVerificationSDK a(Activity activity, l lVar) {
        h.e(activity, "activity");
        h.e(lVar, "verifyState");
        if (this.dyp != null) {
            return this.dyp;
        }
        try {
            DocumentVerificationSDK.isSupportedPlatform(this.dyq);
            if (MobileSDK.isRooted(this.dyq)) {
                com.iqoption.core.i.w(TAG, "Device is rooted");
            }
            VerifyInitData decrypt = lVar.aHq().decrypt();
            if (decrypt == null) {
                com.iqoption.core.i.w(TAG, "Unable to decrypt init result");
                return null;
            }
            DocumentVerificationSDK create = DocumentVerificationSDK.create(activity, decrypt.getToken(), decrypt.getSecret(), JumioDataCenter.EU);
            create.setType("CC");
            create.setCountry(lVar.aHr());
            create.setCallbackUrl(decrypt.getCallbackUrl());
            create.setMerchantScanReference(decrypt.getUuid());
            create.setCustomerId(String.valueOf(lVar.getUserId()));
            this.dyp = create;
            return create;
        } catch (Exception e) {
            com.iqoption.core.i.e(TAG, "DocumentVerificationSDK initialization error", e);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Jumio DocumentVerificationSDK initialization error: ");
            stringBuilder.append(e);
            com.crashlytics.android.a.log(stringBuilder.toString());
            return null;
        }
    }

    public final void aHn() {
        DocumentVerificationSDK documentVerificationSDK = this.dyp;
        if (documentVerificationSDK != null) {
            documentVerificationSDK.destroy();
        }
    }

    public final s<l> iu(String str) {
        h.e(str, "uuid");
        return p.cUB.iu(str);
    }
}
