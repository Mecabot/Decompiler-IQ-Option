package com.iqoption.chat.fragment;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.chat.viewmodel.SearchRoomViewModel;
import com.iqoption.d.de;
import com.iqoption.util.am;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002%&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006'"}, aXE = {"Lcom/iqoption/chat/fragment/SearchRoomFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "binding", "Lcom/iqoption/databinding/ChatFragmentSearchRoomBinding;", "interactionListener", "Lcom/iqoption/chat/fragment/SearchRoomFragment$InteractionListener;", "isSearchStarted", "", "searchSwitcher", "Lcom/iqoption/chat/LottieStateSwitcher;", "transition", "Landroid/support/transition/TransitionSet;", "viewModel", "Lcom/iqoption/chat/viewmodel/SearchRoomViewModel;", "onAttach", "", "context", "Landroid/content/Context;", "onBackPressed", "onClose", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onHideAnimation", "onSaveInstanceState", "outState", "onShowAnimation", "setSearchStarted", "started", "Companion", "InteractionListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SearchRoomFragment.kt */
public final class ab extends com.iqoption.fragment.base.b implements com.iqoption.view.e.a {
    private static final String TAG = "com.iqoption.chat.fragment.ab";
    public static final a aIT = new a();
    private b aIN;
    private de aIO;
    private com.iqoption.chat.b aIP;
    private SearchRoomViewModel aIQ;
    private final TransitionSet aIR = new AutoTransition().setOrdering(0).setDuration(300);
    private boolean aIS;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, aXE = {"Lcom/iqoption/chat/fragment/SearchRoomFragment$Companion;", "", "()V", "STATE_IS_SEARCHING", "", "STATE_SEARCH_TEXT", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SearchRoomFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return ab.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/SearchRoomFragment$onCreateView$1$3"})
    /* compiled from: SearchRoomFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ ab aIU;

        d(ab abVar, Bundle bundle) {
            this.aIU = abVar;
            this.$savedInstanceState$inlined = bundle;
        }

        public final void onClick(View view) {
            if (!this.aIU.aIS) {
                com.iqoption.analytics.b.aiV.Bg();
            }
            this.aIU.onBackPressed();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, aXE = {"Lcom/iqoption/chat/fragment/SearchRoomFragment$InteractionListener;", "Lcom/iqoption/view/BackController;", "onCloseChats", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SearchRoomFragment.kt */
    public interface b extends com.iqoption.view.e {
        void Oo();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "com/iqoption/chat/fragment/SearchRoomFragment$onCreateView$1$1"})
    /* compiled from: SearchRoomFragment.kt */
    static final class c<T> implements Observer<CharSequence> {
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ ab aIU;

        c(ab abVar, Bundle bundle) {
            this.aIU = abVar;
            this.$savedInstanceState$inlined = bundle;
        }

        /* renamed from: o */
        public final void onChanged(CharSequence charSequence) {
            this.aIU.cb(charSequence != null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/SearchRoomFragment$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class e extends com.iqoption.core.ext.g {
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ ab aIU;

        public e(ab abVar, Bundle bundle) {
            this.aIU = abVar;
            this.$savedInstanceState$inlined = bundle;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            if (!this.aIU.aIS) {
                com.iqoption.analytics.b.aiV.Bh();
                ab.c(this.aIU).Rv();
            } else if (ab.b(this.aIU).bmL.length() == 0) {
                ab.c(this.aIU).stopSearch();
            } else {
                EditText editText = ab.b(this.aIU).bmL;
                h.d(editText, "binding.searchInput");
                editText.setText((CharSequence) null);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onPerformSearch", "com/iqoption/chat/fragment/SearchRoomFragment$onCreateView$1$debouncer$1"})
    /* compiled from: SearchRoomFragment.kt */
    static final class f implements com.iqoption.videoeducation.c.a {
        final /* synthetic */ Bundle $savedInstanceState$inlined;
        final /* synthetic */ ab aIU;

        f(ab abVar, Bundle bundle) {
            this.aIU = abVar;
            this.$savedInstanceState$inlined = bundle;
        }

        public final void p(CharSequence charSequence) {
            if (this.aIU.aIS) {
                SearchRoomViewModel c = ab.c(this.aIU);
                h.d(charSequence, "it");
                c.r(charSequence);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"com/iqoption/chat/fragment/SearchRoomFragment$onCreateView$1$5", "Lcom/iqoption/view/text/TextWatcherAdapter;", "prev", "", "afterTextChanged", "", "s", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SearchRoomFragment.kt */
    public static final class g extends x {
        private String aIV;
        final /* synthetic */ com.iqoption.videoeducation.c aIW;

        g(com.iqoption.videoeducation.c cVar) {
            this.aIW = cVar;
        }

        public void afterTextChanged(Editable editable) {
            h.e(editable, "s");
            super.afterTextChanged(editable);
            if (this.aIV == null || !TextUtils.equals(this.aIV, editable.toString())) {
                this.aIW.a(editable, 150);
                this.aIV = editable.toString();
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public void ND() {
    }

    public void NE() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ de b(ab abVar) {
        de deVar = abVar.aIO;
        if (deVar == null) {
            h.lS("binding");
        }
        return deVar;
    }

    public static final /* synthetic */ SearchRoomViewModel c(ab abVar) {
        SearchRoomViewModel searchRoomViewModel = abVar.aIQ;
        if (searchRoomViewModel == null) {
            h.lS("viewModel");
        }
        return searchRoomViewModel;
    }

    public void onAttach(Context context) {
        h.e(context, "context");
        super.onAttach(context);
        if (!(context instanceof b)) {
            context = null;
        }
        b bVar = (b) context;
        if (bVar != null) {
            this.aIN = bVar;
            bVar.a(this);
        }
    }

    public void onDetach() {
        super.onDetach();
        b bVar = this.aIN;
        if (bVar != null) {
            bVar.b(this);
        }
        this.aIN = (b) null;
    }

    private final void cb(boolean z) {
        if (this.aIS == z) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Search already ");
            stringBuilder.append(z ? "started" : "stopped");
            com.iqoption.core.i.d(str, stringBuilder.toString());
            return;
        }
        this.aIS = z;
        de deVar = this.aIO;
        if (deVar == null) {
            h.lS("binding");
        }
        TransitionManager.beginDelayedTransition(deVar.bmK, this.aIR);
        de deVar2;
        EditText editText;
        TextView textView;
        if (z) {
            deVar2 = this.aIO;
            if (deVar2 == null) {
                h.lS("binding");
            }
            editText = deVar2.bmL;
            h.d(editText, "binding.searchInput");
            editText.setVisibility(0);
            deVar2 = this.aIO;
            if (deVar2 == null) {
                h.lS("binding");
            }
            deVar2.bmL.requestFocus();
            deVar2 = this.aIO;
            if (deVar2 == null) {
                h.lS("binding");
            }
            textView = deVar2.agA;
            h.d(textView, "binding.title");
            textView.setVisibility(8);
            Context context = getContext();
            deVar = this.aIO;
            if (deVar == null) {
                h.lS("binding");
            }
            am.b(context, (View) deVar.bmL);
        } else {
            deVar2 = this.aIO;
            if (deVar2 == null) {
                h.lS("binding");
            }
            editText = deVar2.bmL;
            h.d(editText, "binding.searchInput");
            editText.setVisibility(8);
            deVar2 = this.aIO;
            if (deVar2 == null) {
                h.lS("binding");
            }
            editText = deVar2.bmL;
            h.d(editText, "binding.searchInput");
            editText.setText((CharSequence) null);
            deVar2 = this.aIO;
            if (deVar2 == null) {
                h.lS("binding");
            }
            textView = deVar2.agA;
            h.d(textView, "binding.title");
            textView.setVisibility(0);
            am.n(zzakw());
        }
        com.iqoption.chat.b bVar = this.aIP;
        if (bVar == null) {
            h.lS("searchSwitcher");
        }
        if (!bVar.Ot()) {
            bVar = this.aIP;
            if (bVar == null) {
                h.lS("searchSwitcher");
            }
            bVar.reset();
        }
        bVar = this.aIP;
        if (bVar == null) {
            h.lS("searchSwitcher");
        }
        bVar.Or();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        de deVar = (de) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_fragment_search_room, viewGroup, false, 4, null);
        am.n(zzakw());
        this.aIO = deVar;
        SearchRoomViewModel f = SearchRoomViewModel.aLG.f(com.iqoption.core.ext.a.n(this));
        h.d(f, "SearchRoomViewModel.get(act)");
        this.aIQ = f;
        f = this.aIQ;
        if (f == null) {
            h.lS("viewModel");
        }
        f.Ru().observe(this, new c(this, bundle));
        if (bundle != null) {
            this.aIS = bundle.getBoolean("state.isSearching");
            if (this.aIS) {
                f = this.aIQ;
                if (f == null) {
                    h.lS("viewModel");
                }
                CharSequence charSequence = bundle.getCharSequence("state.searchText");
                h.d(charSequence, "it.getCharSequence(STATE_SEARCH_TEXT)");
                f.r(charSequence);
            }
        }
        deVar.awN.setOnClickListener(new d(this, bundle));
        LottieAnimationView lottieAnimationView = deVar.bmJ;
        h.d(lottieAnimationView, "btnSearch");
        lottieAnimationView.setOnClickListener(new e(this, bundle));
        lottieAnimationView = deVar.bmJ;
        h.d(lottieAnimationView, "btnSearch");
        lottieAnimationView.setSpeed(2.0f);
        LottieAnimationView lottieAnimationView2 = deVar.bmJ;
        h.d(lottieAnimationView2, "btnSearch");
        this.aIP = new com.iqoption.chat.c(lottieAnimationView2, new float[]{0.0f, 0.5f, 1.0f});
        deVar.bmL.addTextChangedListener(new g(new com.iqoption.videoeducation.c(new f(this, bundle))));
        View root = deVar.getRoot();
        h.d(root, "inflateBinding<ChatFragm…        })\n        }.root");
        return root;
    }

    public boolean onBackPressed() {
        if (!this.aIS) {
            return onClose();
        }
        SearchRoomViewModel searchRoomViewModel = this.aIQ;
        if (searchRoomViewModel == null) {
            h.lS("viewModel");
        }
        searchRoomViewModel.stopSearch();
        return true;
    }

    public boolean onClose() {
        b bVar = this.aIN;
        if (bVar != null) {
            bVar.Oo();
        }
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("state.isSearching", this.aIS);
        String str = "state.searchText";
        SearchRoomViewModel searchRoomViewModel = this.aIQ;
        if (searchRoomViewModel == null) {
            h.lS("viewModel");
        }
        bundle.putCharSequence(str, (CharSequence) searchRoomViewModel.Ru().getValue());
    }
}
