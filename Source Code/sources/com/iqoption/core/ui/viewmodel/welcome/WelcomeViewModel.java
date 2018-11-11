package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import java.util.Stack;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "activeScreen", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeViewModel$Transition;", "getActiveScreen", "()Landroid/arch/lifecycle/LiveData;", "activeScreenData", "Landroid/arch/lifecycle/MutableLiveData;", "screens", "Ljava/util/Stack;", "Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeScreen;", "back", "", "next", "", "screen", "Companion", "Transition", "core_release"})
/* compiled from: WelcomeViewModel.kt */
public final class WelcomeViewModel extends ViewModel {
    private static final String TAG = "WelcomeViewModel";
    public static final a bdm = new a();
    private final Stack<c> bdj = new Stack();
    private final MutableLiveData<b> bdk = new MutableLiveData();
    private final LiveData<b> bdl = this.bdk;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeViewModel;", "f", "Landroid/support/v4/app/Fragment;", "core_release"})
    /* compiled from: WelcomeViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeViewModel$Transition;", "", "screen", "Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeScreen;", "isForward", "", "(Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeScreen;Z)V", "()Z", "getScreen", "()Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeScreen;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "core_release"})
    /* compiled from: WelcomeViewModel.kt */
    public static final class b {
        private final c bdn;
        private final boolean bdo;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (h.E(this.bdn, bVar.bdn)) {
                    if ((this.bdo == bVar.bdo ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            c cVar = this.bdn;
            int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
            int i = this.bdo;
            if (i != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Transition(screen=");
            stringBuilder.append(this.bdn);
            stringBuilder.append(", isForward=");
            stringBuilder.append(this.bdo);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public b(c cVar, boolean z) {
            h.e(cVar, "screen");
            this.bdn = cVar;
            this.bdo = z;
        }

        public final c Zk() {
            return this.bdn;
        }
    }

    public WelcomeViewModel() {
        a(new b(WelcomeScreenFeature.welcome1));
    }

    public final void a(c cVar) {
        h.e(cVar, "screen");
        b bVar = (b) this.bdl.getValue();
        if ((h.E(bVar != null ? bVar.Zk() : null, cVar) ^ 1) != 0) {
            this.bdk.setValue(new b(cVar, true));
            this.bdj.push(cVar);
        }
    }
}
