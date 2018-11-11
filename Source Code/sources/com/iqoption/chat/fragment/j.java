package com.iqoption.chat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeFrameLayout;
import com.iqoption.d.cc;
import com.iqoption.util.am;
import com.iqoption.view.e;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00062"}, aXE = {"Lcom/iqoption/chat/fragment/FeedbackDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "animationController", "Lcom/iqoption/chat/fragment/DialogAnimationController;", "binding", "Lcom/iqoption/databinding/ChatDialogFeedbackBinding;", "onCancel", "Lkotlin/Function0;", "", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "setOnCancel", "(Lkotlin/jvm/functions/Function0;)V", "onClose", "Landroid/view/View$OnClickListener;", "onSend", "Lkotlin/Function1;", "", "getOnSend", "()Lkotlin/jvm/functions/Function1;", "setOnSend", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "rating", "getRating", "()I", "setRating", "(I)V", "getAnimationDuration", "", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onHideAnimation", "onShowAnimation", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FeedbackDialog.kt */
public final class j extends com.iqoption.fragment.base.b implements com.iqoption.view.e.a {
    private static final String TAG = "j";
    public static final a aGf = new a();
    private h aFD;
    private kotlin.jvm.a.b<? super String, l> aFq;
    private kotlin.jvm.a.a<l> aGc;
    private final OnClickListener aGd = new b(this);
    private cc aGe;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, aXE = {"Lcom/iqoption/chat/fragment/FeedbackDialog$Companion;", "", "()V", "ARG_RATING", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/FeedbackDialog;", "rating", "", "onSend", "Lkotlin/Function1;", "", "onCancel", "Lkotlin/Function0;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedbackDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return j.TAG;
        }

        public final j a(int i, kotlin.jvm.a.b<? super String, l> bVar, kotlin.jvm.a.a<l> aVar) {
            h.e(bVar, "onSend");
            h.e(aVar, "onCancel");
            j jVar = new j();
            jVar.setArguments(new Bundle());
            jVar.setRating(i);
            jVar.e(bVar);
            jVar.a(aVar);
            return jVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: FeedbackDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ j aGg;

        b(j jVar) {
            this.aGg = jVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.a PI = this.aGg.PI();
            if (PI != null) {
                l lVar = (l) PI.invoke();
            }
            am.n(this.aGg.zzakw());
            com.iqoption.core.ext.a.p(this.aGg).popBackStack();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/FeedbackDialog$onCreateView$1$2"})
    /* compiled from: FeedbackDialog.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ j aGg;
        final /* synthetic */ cc aGh;

        c(cc ccVar, j jVar) {
            this.aGh = ccVar;
            this.aGg = jVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b PH = this.aGg.PH();
            if (PH != null) {
                TextInputEditText textInputEditText = this.aGh.bmd;
                h.d(textInputEditText, "commentInput");
                Editable text = textInputEditText.getText();
                h.d(text, "commentInput.text");
                l lVar = (l) PH.invoke(v.trim(text).toString());
            }
            am.n(this.aGg.zzakw());
            com.iqoption.core.ext.a.p(this.aGg).popBackStack();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, aXE = {"com/iqoption/chat/fragment/FeedbackDialog$onCreateView$1$1", "Lcom/iqoption/view/text/TextWatcherAdapter;", "onTextChanged", "", "s", "", "start", "", "before", "count", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedbackDialog.kt */
    public static final class d extends x {
        final /* synthetic */ cc aGh;
        final /* synthetic */ int aGi;

        d(cc ccVar, int i) {
            this.aGh = ccVar;
            this.aGi = i;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            h.e(charSequence, "s");
            TextView textView = this.aGh.bmf;
            h.d(textView, "counter");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(charSequence.length());
            stringBuilder.append('/');
            stringBuilder.append(this.aGi);
            textView.setText(stringBuilder.toString());
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

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public final kotlin.jvm.a.b<String, l> PH() {
        return this.aFq;
    }

    public final void e(kotlin.jvm.a.b<? super String, l> bVar) {
        this.aFq = bVar;
    }

    public final kotlin.jvm.a.a<l> PI() {
        return this.aGc;
    }

    public final void a(kotlin.jvm.a.a<l> aVar) {
        this.aGc = aVar;
    }

    public final int getRating() {
        return com.iqoption.core.ext.a.o(this).getInt("arg.rating");
    }

    public final void setRating(int i) {
        com.iqoption.core.ext.a.o(this).putInt("arg.rating", i);
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
        if (this.aFq == null || this.aGc == null) {
            com.iqoption.core.ext.a.p(this).popBackStack();
            return null;
        }
        cc ccVar = (cc) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_dialog_feedback, viewGroup, false, 4, null);
        am.n(zzakw());
        this.aGe = ccVar;
        com.iqoption.fragment.base.b bVar = this;
        View root = ccVar.getRoot();
        h.d(root, "root");
        MaxSizeFrameLayout maxSizeFrameLayout = ccVar.bmg;
        h.d(maxSizeFrameLayout, "frame");
        this.aFD = new h(bVar, root, maxSizeFrameLayout);
        TextView textView = ccVar.bmh;
        h.d(textView, "note");
        textView.setText(getString(getRating() > 3 ? R.string.good_but_not_good_enough : R.string.we_are_sorry_to_see_you_unhappy));
        TextInputEditText textInputEditText = ccVar.bmd;
        h.d(textInputEditText, "commentInput");
        textInputEditText.setFilters((InputFilter[]) new LengthFilter[]{new LengthFilter(240)});
        ccVar.bmd.addTextChangedListener(new d(ccVar, 240));
        ccVar.awS.setOnClickListener(this.aGd);
        ccVar.blE.setOnClickListener(this.aGd);
        ccVar.bmc.setOnClickListener(new c(ccVar, this));
        return ccVar.getRoot();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof e)) {
            context = null;
        }
        e eVar = (e) context;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public void onDetach() {
        super.onDetach();
        Context context = getContext();
        if (!(context instanceof e)) {
            context = null;
        }
        e eVar = (e) context;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    public boolean onBackPressed() {
        this.aGd.onClick(null);
        return true;
    }
}
