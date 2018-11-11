package com.iqoption.deposit.dark.c;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.a.ac;
import com.iqoption.deposit.p;
import com.iqoption.deposit.r.c;
import com.iqoption.deposit.r.g;
import com.iqoption.dto.ChartTimeInterval;
import java.util.HashMap;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001c"}, aXE = {"Lcom/iqoption/deposit/dark/web/RedirectWebPaymentDarkFragment;", "Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentRedirectWebPaymentBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentRedirectWebPaymentBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentRedirectWebPaymentBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "toolbarClose", "Landroid/widget/ImageView;", "webView", "Landroid/webkit/WebView;", "Companion", "deposit_release"})
/* compiled from: RedirectWebPaymentDarkFragment.kt */
public final class a extends com.iqoption.deposit.web.a {
    private static final String TAG = "com.iqoption.deposit.dark.c.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentRedirectWebPaymentBinding;"))};
    public static final a bYs = new a();
    private HashMap atz;
    private final d bXo = kotlin.e.a.euA.aYg();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, aXE = {"Lcom/iqoption/deposit/dark/web/RedirectWebPaymentDarkFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "redirectUrl", "redirectParams", "Ljava/util/HashMap;", "isPost", "", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "deposit_release"})
    /* compiled from: RedirectWebPaymentDarkFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return a.TAG;
        }

        public final h a(String str, HashMap<String, String> hashMap, boolean z, p pVar) {
            kotlin.jvm.internal.h.e(str, "redirectUrl");
            kotlin.jvm.internal.h.e(hashMap, "redirectParams");
            kotlin.jvm.internal.h.e(pVar, "depositParams");
            Bundle bundle = new Bundle();
            bundle.putString("ARG_REDIRECT_URL", str);
            bundle.putSerializable("ARG_REDIRECT_PARAMS", hashMap);
            bundle.putBoolean("ARG_REDIRECT_METHOD_IS_POST", z);
            bundle.putParcelable("ARG_DEPOSIT_PARAMS", pVar);
            return new h(Ll(), a.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    private final void a(ac acVar) {
        this.bXo.a(this, apP[0], acVar);
    }

    private final ac adb() {
        return (ac) this.bXo.b(this, apP[0]);
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
        if (a.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((ac) com.iqoption.core.ext.a.a((Fragment) this, g.fragment_redirect_web_payment, viewGroup, false));
        return adb().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ade().setBackgroundColor(com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), c.dark_blue));
    }

    /* renamed from: adc */
    protected ImageView add() {
        return adb().bTH;
    }

    protected WebView ade() {
        return adb().bqN;
    }
}
