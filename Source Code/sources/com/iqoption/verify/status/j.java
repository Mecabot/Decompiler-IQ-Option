package com.iqoption.verify.status;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.alc;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/verify/status/VerifyHintBottomSheetFragment;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/databinding/VerifySideHintBinding;", "()V", "cardHintData", "Lcom/iqoption/verify/status/CardHintData;", "getCardHintData", "()Lcom/iqoption/verify/status/CardHintData;", "cardHintData$delegate", "Lkotlin/Lazy;", "cardSideToMakePhotoOnClose", "Lcom/iqoption/verify/status/CardSide;", "onBottomSheetClosed", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "OnMakePhotoListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyHintBottomSheetFragment.kt */
public final class j extends com.iqoption.bottomsheet.a<alc> {
    private static final String TAG = "com.iqoption.verify.status.j";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(j.class), "cardHintData", "getCardHintData()Lcom/iqoption/verify/status/CardHintData;"))};
    public static final a dyv = new a();
    private HashMap atz;
    private final kotlin.d dyt = g.f(new VerifyHintBottomSheetFragment$cardHintData$2(this));
    private CardSide dyu;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, aXE = {"Lcom/iqoption/verify/status/VerifyHintBottomSheetFragment$Companion;", "", "()V", "ARG_CARD_HINT_DATA", "", "BACK_SIDE_IMAGE_RESOURCE_ID", "FRONT_SIDE_IMAGE_RESOURCE_ID", "TAG", "getTAG", "()Ljava/lang/String;", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "containerViewId", "", "data", "Lcom/iqoption/verify/status/CardHintData;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyHintBottomSheetFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return j.TAG;
        }

        public final void a(FragmentManager fragmentManager, @IdRes int i, e eVar) {
            h.e(fragmentManager, "fm");
            h.e(eVar, "data");
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            j jVar = new j();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_CARD_HINT_DATA", eVar);
            jVar.setArguments(bundle);
            a aVar = this;
            beginTransaction.add(i, jVar, aVar.Ll()).addToBackStack(aVar.Ll()).commit();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/verify/status/VerifyHintBottomSheetFragment$OnMakePhotoListener;", "", "onMakePhotoClick", "", "cardSide", "Lcom/iqoption/verify/status/CardSide;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyHintBottomSheetFragment.kt */
    public interface b {
        void a(CardSide cardSide);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyHintBottomSheetFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ j this$0;

        c(j jVar) {
            this.this$0 = jVar;
        }

        public final void onClick(View view) {
            this.this$0.JK();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyHintBottomSheetFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ CardSide dyw;
        final /* synthetic */ j this$0;

        d(j jVar, CardSide cardSide) {
            this.this$0 = jVar;
            this.dyw = cardSide;
        }

        public final void onClick(View view) {
            this.this$0.dyu = this.dyw;
            this.this$0.JK();
        }
    }

    private final e aHo() {
        kotlin.d dVar = this.dyt;
        kotlin.reflect.j jVar = apP[0];
        return (e) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (j.class.getName() == null) {
            h.aXZ();
        }
    }

    /* renamed from: r */
    public alc e(ViewGroup viewGroup) {
        h.e(viewGroup, "container");
        alc g = alc.g(LayoutInflater.from(getContext()));
        if (g == null) {
            h.aXZ();
        }
        return g;
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        StringBuilder stringBuilder;
        String str;
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        CardSide aHg = aHo().aHg();
        switch (aHg) {
            case FRONT:
                i = R.string.front_side;
                break;
            case BACK:
                i = R.string.back_side;
                break;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case: ");
                stringBuilder.append(aHg);
                throw new IllegalStateException(stringBuilder.toString());
        }
        TextView textView = ((alc) getBinding()).bTX;
        h.d(textView, "binding.verifyHintTitle");
        textView.setText(getString(i));
        switch (aHg) {
            case FRONT:
                str = "verify_card_front_side";
                break;
            case BACK:
                str = "verify_card_back_side";
                break;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case: ");
                stringBuilder.append(aHg);
                throw new IllegalStateException(stringBuilder.toString());
        }
        Picasso with = Picasso.with(com.iqoption.core.ext.a.m(this));
        h.d(with, "Picasso.with(ctx)");
        com.iqoption.core.util.h.a(with, str).into(((alc) getBinding()).bTV);
        ((alc) getBinding()).bTU.setOnClickListener(new c(this));
        ((alc) getBinding()).bTW.setOnClickListener(new d(this, aHg));
    }

    public void JP() {
        super.JP();
        CardSide cardSide = this.dyu;
        if (cardSide != null) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.verify.status.VerifyHintBottomSheetFragment.OnMakePhotoListener");
            }
            ((b) parentFragment).a(cardSide);
        }
        this.dyu = (CardSide) null;
        com.iqoption.core.ext.a.p(this).popBackStack();
    }
}
