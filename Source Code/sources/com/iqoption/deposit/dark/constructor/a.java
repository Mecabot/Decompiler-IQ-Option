package com.iqoption.deposit.dark.constructor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.a.e;
import com.iqoption.deposit.a.y;
import com.iqoption.deposit.constructor.c;
import com.iqoption.deposit.r.g;
import java.util.HashMap;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J0\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0014J(\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J(\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006/"}, aXE = {"Lcom/iqoption/deposit/dark/constructor/ConstructorDarkFragment;", "Lcom/iqoption/deposit/constructor/BaseConstructorFragment;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentPaymentFieldsBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentPaymentFieldsBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentPaymentFieldsBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "contentContainer", "Landroid/widget/LinearLayout;", "createSelectorIntegerMenuEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "params", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "createSelectorStringMenuEntry", "Lcom/iqoption/deposit/constructor/selector/string/SelectorStringMenuParams;", "fieldsContainer", "fieldsNoInput", "Landroid/widget/TextView;", "inflateEditFieldHolder", "Lcom/iqoption/deposit/constructor/BaseEditFieldHolder;", "name", "", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "container", "Landroid/view/ViewGroup;", "isRequired", "", "isLastField", "inflateSelectIntegerFieldHolder", "Lcom/iqoption/deposit/constructor/BaseSelectIntegerFieldHolder;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;", "inflateSelectStringFieldHolder", "Lcom/iqoption/deposit/constructor/BaseSelectStringFieldHolder;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "deposit_release"})
/* compiled from: ConstructorDarkFragment.kt */
public final class a extends com.iqoption.deposit.constructor.a {
    private static final String TAG = "com.iqoption.deposit.dark.constructor.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentPaymentFieldsBinding;"))};
    public static final a bXR = new a();
    private HashMap atz;
    private final d bXo = kotlin.e.a.euA.aYg();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/dark/constructor/ConstructorDarkFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "deposit_release"})
    /* compiled from: ConstructorDarkFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return a.TAG;
        }

        public final h abt() {
            return new h(Ll(), a.class, null, 0, 0, 0, 0, 124, null);
        }
    }

    private final void a(y yVar) {
        this.bXo.a(this, apP[0], yVar);
    }

    private final y acN() {
        return (y) this.bXo.b(this, apP[0]);
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
        a((y) com.iqoption.core.ext.a.a((Fragment) this, g.fragment_payment_fields, viewGroup, false, 4, null));
        return acN().getRoot();
    }

    /* renamed from: acO */
    protected LinearLayout abR() {
        return acN().bZy;
    }

    /* renamed from: acE */
    protected LinearLayout abe() {
        return acN().bZy;
    }

    protected TextView abS() {
        return acN().bZz;
    }

    protected c b(String str, ExtraParamProperty extraParamProperty, ViewGroup viewGroup, boolean z, boolean z2) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(extraParamProperty, "property");
        kotlin.jvm.internal.h.e(viewGroup, "container");
        return new b((e) com.iqoption.core.ext.a.a(viewGroup, g.constructor_text_edit_field, null, false, 6, null), extraParamProperty, str, z);
    }

    protected com.iqoption.deposit.constructor.d b(String str, com.iqoption.core.microservices.billing.response.extraparams.a aVar, ViewGroup viewGroup, boolean z) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(aVar, "property");
        kotlin.jvm.internal.h.e(viewGroup, "container");
        return new c((com.iqoption.deposit.a.a) com.iqoption.core.ext.a.a(viewGroup, g.constructor_spinner_field, null, false, 6, null), aVar, str, z);
    }

    protected com.iqoption.deposit.constructor.e b(String str, com.iqoption.core.microservices.billing.response.extraparams.c cVar, ViewGroup viewGroup, boolean z) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(cVar, "property");
        kotlin.jvm.internal.h.e(viewGroup, "container");
        return new d((com.iqoption.deposit.a.a) com.iqoption.core.ext.a.a(viewGroup, g.constructor_spinner_field, null, false, 6, null), cVar, str, z);
    }

    protected h a(com.iqoption.deposit.constructor.selector.integer.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "params");
        return com.iqoption.deposit.dark.constructor.selector.integer.c.bYa.b(cVar);
    }

    protected h a(com.iqoption.deposit.constructor.selector.string.d dVar) {
        kotlin.jvm.internal.h.e(dVar, "params");
        return com.iqoption.deposit.dark.constructor.selector.string.c.bYf.b(dVar);
    }
}
