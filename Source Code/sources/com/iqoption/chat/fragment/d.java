package com.iqoption.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.d.ca;
import com.iqoption.dto.Event.Builder;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/chat/fragment/CantSendReasonDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "animationController", "Lcom/iqoption/chat/fragment/DialogAnimationController;", "binding", "Lcom/iqoption/databinding/ChatDialogCantSendReasonBinding;", "eventBuilder", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "getAnimationDuration", "", "onClose", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CantSendReasonDialog.kt */
public final class d extends com.iqoption.fragment.base.b {
    private static final String TAG = "d";
    private static final String aFF = "arg.message";
    public static final a aFG = new a();
    private ca aFC;
    private h aFD;
    private Builder aFE;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, aXE = {"Lcom/iqoption/chat/fragment/CantSendReasonDialog$Companion;", "", "()V", "ARG_MESSAGE", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/chat/fragment/CantSendReasonDialog;", "message", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CantSendReasonDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return d.TAG;
        }

        public final d m(CharSequence charSequence) {
            h.e(charSequence, "message");
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putCharSequence(d.aFF, charSequence);
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/CantSendReasonDialog$onCreateView$1$1"})
    /* compiled from: CantSendReasonDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ d aFH;
        final /* synthetic */ CharSequence aFI;

        b(d dVar, CharSequence charSequence) {
            this.aFH = dVar;
            this.aFI = charSequence;
        }

        public final void onClick(View view) {
            this.aFH.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/CantSendReasonDialog$onCreateView$1$2"})
    /* compiled from: CantSendReasonDialog.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ d aFH;
        final /* synthetic */ CharSequence aFI;

        c(d dVar, CharSequence charSequence) {
            this.aFH = dVar;
            this.aFI = charSequence;
        }

        public final void onClick(View view) {
            this.aFH.onClose();
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public long getAnimationDuration() {
        return 250;
    }

    public void ND() {
        h hVar = this.aFD;
        if (hVar == null) {
            h.lS("animationController");
        }
        hVar.PF();
    }

    public void NE() {
        h hVar = this.aFD;
        if (hVar == null) {
            h.lS("animationController");
        }
        hVar.PG();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        CharSequence charSequence = arguments != null ? arguments.getCharSequence(aFF) : null;
        if (charSequence == null) {
            com.iqoption.core.i.w(TAG, "Message is null");
            onClose();
            return null;
        }
        ca caVar = (ca) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_dialog_cant_send_reason, viewGroup, false, 4, null);
        am.n(zzakw());
        this.aFC = caVar;
        com.iqoption.fragment.base.b bVar = this;
        View root = caVar.getRoot();
        h.d(root, "root");
        MaxSizeCardViewLayout maxSizeCardViewLayout = caVar.bmb;
        h.d(maxSizeCardViewLayout, "frame");
        this.aFD = new h(bVar, root, maxSizeCardViewLayout);
        caVar.awS.setOnClickListener(new b(this, charSequence));
        TextView textView = caVar.aip;
        h.d(textView, "text");
        textView.setText(charSequence);
        caVar.bma.setOnClickListener(new c(this, charSequence));
        ca caVar2 = this.aFC;
        if (caVar2 == null) {
            h.lS("binding");
        }
        return caVar2.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.aFE = com.iqoption.analytics.b.aiV.Bj();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Builder builder = this.aFE;
        if (builder != null) {
            com.iqoption.analytics.b.aiV.b(builder);
        }
        KH();
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        return true;
    }
}
