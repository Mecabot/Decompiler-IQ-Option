package com.iqoption.deposit.card;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.deposit.DepositSelectionViewModel;
import com.iqoption.deposit.r.h;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/deposit/card/ScanViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "depositSelectionViewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "setNfcScanCard", "", "data", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "Companion", "ScanItem", "deposit_release"})
/* compiled from: ScanViewModel.kt */
public final class ScanViewModel extends ViewModel {
    public static final a bWx = new a();
    private DepositSelectionViewModel bWd;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/card/ScanViewModel$ScanItem;", "", "titleRes", "", "(Ljava/lang/String;II)V", "getTitleRes", "()I", "CAMERA", "NFC", "deposit_release"})
    /* compiled from: ScanViewModel.kt */
    public enum ScanItem {
        CAMERA(h.scan_by_camera),
        NFC(h.scan_by_nfc);
        
        private final int titleRes;

        protected ScanItem(int i) {
            this.titleRes = i;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/card/ScanViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/card/ScanViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: ScanViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final ScanViewModel w(Fragment fragment) {
            kotlin.jvm.internal.h.e(fragment, "fragment");
            ScanViewModel scanViewModel = (ScanViewModel) ViewModelProviders.d(fragment).h(ScanViewModel.class);
            scanViewModel.bWd = DepositSelectionViewModel.bVO.u(fragment);
            kotlin.jvm.internal.h.d(scanViewModel, "viewModel");
            return scanViewModel;
        }
    }

    public final void d(com.iqoption.deposit.card.d.a aVar) {
        kotlin.jvm.internal.h.e(aVar, "data");
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            kotlin.jvm.internal.h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.a(aVar);
    }
}
