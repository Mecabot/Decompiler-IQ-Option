package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/chat/viewmodel/TransitionViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "event", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/chat/viewmodel/TransitionViewModel$Event;", "getEvent", "()Landroid/arch/lifecycle/LiveData;", "eventData", "Landroid/arch/lifecycle/MutableLiveData;", "hideSource", "", "preview", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "showSource", "Companion", "Event", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TransitionViewModel.kt */
public final class TransitionViewModel extends ViewModel {
    private static final String TAG = "TransitionViewModel";
    public static final a aLW = new a();
    private final MutableLiveData<b> aLU = new MutableLiveData();
    private final LiveData<b> aLV = this.aLU;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, aXE = {"Lcom/iqoption/chat/viewmodel/TransitionViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/chat/viewmodel/TransitionViewModel;", "f", "Landroid/support/v4/app/Fragment;", "a", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TransitionViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final TransitionViewModel k(Fragment fragment) {
            h.e(fragment, "f");
            return (TransitionViewModel) ViewModelProviders.b(fragment.requireActivity()).h(TransitionViewModel.class);
        }

        public final TransitionViewModel g(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, com.iqoption.fragment.cashbox.deppage.a.TAG);
            return (TransitionViewModel) ViewModelProviders.b(fragmentActivity).h(TransitionViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/viewmodel/TransitionViewModel$Event;", "", "preview", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "isHidden", "", "(Lcom/iqoption/chat/viewmodel/AttachmentPreview;Z)V", "()Z", "getPreview", "()Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TransitionViewModel.kt */
    public static final class b {
        private final a aLH;
        private final boolean aye;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (h.E(this.aLH, bVar.aLH)) {
                    if ((this.aye == bVar.aye ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            a aVar = this.aLH;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            int i = this.aye;
            if (i != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Event(preview=");
            stringBuilder.append(this.aLH);
            stringBuilder.append(", isHidden=");
            stringBuilder.append(this.aye);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public b(a aVar, boolean z) {
            h.e(aVar, "preview");
            this.aLH = aVar;
            this.aye = z;
        }

        public final a Rw() {
            return this.aLH;
        }

        public final boolean isHidden() {
            return this.aye;
        }
    }

    public final LiveData<b> RF() {
        return this.aLV;
    }

    public final void h(a aVar) {
        h.e(aVar, "preview");
        this.aLU.setValue(new b(aVar, true));
    }

    public final void i(a aVar) {
        h.e(aVar, "preview");
        this.aLU.setValue(new b(aVar, false));
    }
}
