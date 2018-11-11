package com.iqoption.deposit.constructor;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty.PropertyType;
import com.iqoption.core.util.r;
import com.iqoption.deposit.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b&\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H$J2\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH$J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001fH$J\b\u0010 \u001a\u00020\u0014H$J\b\u0010!\u001a\u00020\"H$J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020\fH\u0002J0\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H$J(\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0006H$J(\u0010-\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0006H$J\b\u00100\u001a\u00020\u0006H\u0002J\u001a\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u00104\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u00020\f2\u0006\u00108\u001a\u0002092\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010:\u001a\u00020;H\u0016J0\u0010<\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J(\u0010=\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0006H\u0002J(\u0010>\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0010\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020,H\u0002J\u0010\u0010D\u001a\u00020\f2\u0006\u00102\u001a\u00020.H\u0002J\b\u0010E\u001a\u00020\u0006H\u0016J\u0018\u0010F\u001a\u00020\u00062\u0006\u00102\u001a\u00020$2\u0006\u0010G\u001a\u00020\u0006H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006I"}, aXE = {"Lcom/iqoption/deposit/constructor/BaseConstructorFragment;", "Lcom/iqoption/deposit/PayFieldsContainerFragment;", "()V", "fieldsValidationMap", "", "", "", "paymentMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod;", "viewModel", "Lcom/iqoption/deposit/constructor/PaymentMethodFieldsViewModel;", "applyImeOptions", "", "edit", "Landroid/widget/EditText;", "isLastField", "collectParams", "", "", "contentContainer", "Landroid/view/ViewGroup;", "createFieldView", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "name", "container", "createSelectorIntegerMenuEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "params", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "createSelectorStringMenuEntry", "Lcom/iqoption/deposit/constructor/selector/string/SelectorStringMenuParams;", "fieldsContainer", "fieldsNoInput", "Landroid/widget/TextView;", "findHolderByName", "Lcom/iqoption/deposit/constructor/FieldHolder;", "fieldName", "hideKeyboardIfOpened", "inflateEditFieldHolder", "Lcom/iqoption/deposit/constructor/BaseEditFieldHolder;", "isRequired", "inflateSelectIntegerFieldHolder", "Lcom/iqoption/deposit/constructor/BaseSelectIntegerFieldHolder;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;", "inflateSelectStringFieldHolder", "Lcom/iqoption/deposit/constructor/BaseSelectStringFieldHolder;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty;", "isKycLimitEnabled", "isValidField", "holder", "value", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "paymentMethodId", "", "prepareEditFieldHolder", "prepareSelectIntegerFieldHolder", "prepareSelectStringFieldHolder", "setFieldsEnabled", "enabled", "setPaymentMethod", "showSelectIntegerMenu", "editText", "showSelectStringMenu", "validate", "validateField", "showError", "Companion", "deposit_release"})
/* compiled from: BaseConstructorFragment.kt */
public abstract class a extends q {
    private static final String TAG = "com.iqoption.deposit.constructor.a";
    public static final a bWS = new a();
    private com.iqoption.core.microservices.billing.response.deposit.g aTK;
    private HashMap atz;
    private PaymentMethodFieldsViewModel bWQ;
    private final Map<String, Boolean> bWR = new LinkedHashMap();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/constructor/BaseConstructorFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "deposit_release"})
    /* compiled from: BaseConstructorFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"})
    /* compiled from: BaseConstructorFragment.kt */
    static final class b implements OnEditorActionListener {
        final /* synthetic */ a bWT;

        b(a aVar) {
            this.bWT = aVar;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.bWT.abP();
            return true;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "focused", "", "onFocusChange", "com/iqoption/deposit/constructor/BaseConstructorFragment$prepareEditFieldHolder$1$2"})
    /* compiled from: BaseConstructorFragment.kt */
    static final class g implements OnFocusChangeListener {
        final /* synthetic */ a bWT;
        final /* synthetic */ c bWU;
        final /* synthetic */ boolean bWV;
        final /* synthetic */ ExtraParamProperty bWW;
        final /* synthetic */ String bWX;

        g(a aVar, c cVar, boolean z, ExtraParamProperty extraParamProperty, String str) {
            this.bWT = aVar;
            this.bWU = cVar;
            this.bWV = z;
            this.bWW = extraParamProperty;
            this.bWX = str;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                JsonObject aeh = com.iqoption.deposit.c.c.ceC.aeh();
                aeh.add("field_name", new JsonPrimitive(this.bWX));
                com.iqoption.core.microservices.billing.response.deposit.g a = this.bWT.aTK;
                com.iqoption.core.f.RQ().Ds().b("deposit-page_field", a != null ? (double) a.getId() : 0.0d, aeh);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange", "com/iqoption/deposit/constructor/BaseConstructorFragment$prepareSelectIntegerFieldHolder$1$2"})
    /* compiled from: BaseConstructorFragment.kt */
    static final class i implements OnFocusChangeListener {
        final /* synthetic */ a bWT;
        final /* synthetic */ String bWX;
        final /* synthetic */ d bWY;
        final /* synthetic */ com.iqoption.core.microservices.billing.response.extraparams.a bWZ;

        i(a aVar, d dVar, String str, com.iqoption.core.microservices.billing.response.extraparams.a aVar2) {
            this.bWT = aVar;
            this.bWY = dVar;
            this.bWX = str;
            this.bWZ = aVar2;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                this.bWT.a(this.bWY.aca(), this.bWX, this.bWZ);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange", "com/iqoption/deposit/constructor/BaseConstructorFragment$prepareSelectStringFieldHolder$1$2"})
    /* compiled from: BaseConstructorFragment.kt */
    static final class k implements OnFocusChangeListener {
        final /* synthetic */ a bWT;
        final /* synthetic */ e bXa;

        k(a aVar, e eVar) {
            this.bWT = aVar;
            this.bXa = eVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                this.bWT.a(this.bXa);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onChanged"})
    /* compiled from: BaseConstructorFragment.kt */
    static final class c<T> implements Observer<PayMethod> {
        final /* synthetic */ a bWT;

        c(a aVar) {
            this.bWT = aVar;
        }

        /* renamed from: h */
        public final void onChanged(PayMethod payMethod) {
            if (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g) {
                this.bWT.a((com.iqoption.core.microservices.billing.response.deposit.g) payMethod);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "item", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "onChanged"})
    /* compiled from: BaseConstructorFragment.kt */
    static final class d<T> implements Observer<com.iqoption.deposit.constructor.selector.integer.b> {
        final /* synthetic */ a bWT;

        d(a aVar) {
            this.bWT = aVar;
        }

        /* renamed from: b */
        public final void onChanged(com.iqoption.deposit.constructor.selector.integer.b bVar) {
            if (bVar != null) {
                f a = this.bWT.hf(bVar.getFieldName());
                if (!(a instanceof d)) {
                    a = null;
                }
                d dVar = (d) a;
                if (dVar != null) {
                    dVar.hh(null);
                    dVar.aca().setText(String.valueOf(bVar.getValue()));
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "item", "Lcom/iqoption/deposit/constructor/selector/string/SelectorStringItem;", "onChanged"})
    /* compiled from: BaseConstructorFragment.kt */
    static final class e<T> implements Observer<com.iqoption.deposit.constructor.selector.string.c> {
        final /* synthetic */ a bWT;

        e(a aVar) {
            this.bWT = aVar;
        }

        /* renamed from: b */
        public final void onChanged(com.iqoption.deposit.constructor.selector.string.c cVar) {
            if (cVar != null) {
                f a = this.bWT.hf(cVar.getFieldName());
                if (!(a instanceof e)) {
                    a = null;
                }
                e eVar = (e) a;
                if (eVar != null) {
                    eVar.hh(null);
                    EditText aca = eVar.aca();
                    eVar.setValue(cVar.getValue());
                    aca.setText(cVar.getDescription());
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/deposit/constructor/BaseConstructorFragment$prepareEditFieldHolder$1$1", "Lcom/iqoption/core/util/TextWatcherAdapter;", "afterTextChanged", "", "text", "Landroid/text/Editable;", "deposit_release"})
    /* compiled from: BaseConstructorFragment.kt */
    public static final class f extends r {
        final /* synthetic */ a bWT;
        final /* synthetic */ c bWU;
        final /* synthetic */ boolean bWV;
        final /* synthetic */ ExtraParamProperty bWW;
        final /* synthetic */ String bWX;

        f(a aVar, c cVar, boolean z, ExtraParamProperty extraParamProperty, String str) {
            this.bWT = aVar;
            this.bWU = cVar;
            this.bWV = z;
            this.bWW = extraParamProperty;
            this.bWX = str;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.h.e(editable, "text");
            super.afterTextChanged(editable);
            this.bWT.a((f) this.bWU, false);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/deposit/constructor/BaseConstructorFragment$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class h extends com.iqoption.core.ext.g {
        final /* synthetic */ a bWT;
        final /* synthetic */ String bWX;
        final /* synthetic */ d bWY;
        final /* synthetic */ com.iqoption.core.microservices.billing.response.extraparams.a bWZ;

        public h(a aVar, d dVar, String str, com.iqoption.core.microservices.billing.response.extraparams.a aVar2) {
            this.bWT = aVar;
            this.bWY = dVar;
            this.bWX = str;
            this.bWZ = aVar2;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.bWT.a(this.bWY.aca(), this.bWX, this.bWZ);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/deposit/constructor/BaseConstructorFragment$$special$$inlined$setOnDelayedClickListener$2"})
    /* compiled from: AndroidExtensions.kt */
    public static final class j extends com.iqoption.core.ext.g {
        final /* synthetic */ a bWT;
        final /* synthetic */ e bXa;

        public j(a aVar, e eVar) {
            this.bWT = aVar;
            this.bXa = eVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.bWT.a(this.bXa);
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    protected abstract com.iqoption.core.ui.navigation.h a(com.iqoption.deposit.constructor.selector.integer.c cVar);

    protected abstract com.iqoption.core.ui.navigation.h a(com.iqoption.deposit.constructor.selector.string.d dVar);

    protected abstract ViewGroup abR();

    protected abstract TextView abS();

    protected abstract ViewGroup abe();

    protected abstract c b(String str, ExtraParamProperty extraParamProperty, ViewGroup viewGroup, boolean z, boolean z2);

    protected abstract d b(String str, com.iqoption.core.microservices.billing.response.extraparams.a aVar, ViewGroup viewGroup, boolean z);

    protected abstract e b(String str, com.iqoption.core.microservices.billing.response.extraparams.c cVar, ViewGroup viewGroup, boolean z);

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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bWQ = PaymentMethodFieldsViewModel.bXf.y(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        PaymentMethodFieldsViewModel paymentMethodFieldsViewModel = this.bWQ;
        if (paymentMethodFieldsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        paymentMethodFieldsViewModel.acb().observe(lifecycleOwner, new c(this));
        paymentMethodFieldsViewModel = this.bWQ;
        if (paymentMethodFieldsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        paymentMethodFieldsViewModel.acc().observe(lifecycleOwner, new d(this));
        paymentMethodFieldsViewModel = this.bWQ;
        if (paymentMethodFieldsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        paymentMethodFieldsViewModel.aaQ().observe(lifecycleOwner, new e(this));
    }

    private final f hf(String str) {
        ViewGroup abe = abe();
        int childCount = abe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = abe.getChildAt(i);
            kotlin.jvm.internal.h.d(childAt, "container.getChildAt(i)");
            Object tag = childAt.getTag();
            if (tag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.deposit.constructor.FieldHolder");
            }
            f fVar = (f) tag;
            if (kotlin.jvm.internal.h.E(fVar.getName(), str)) {
                return fVar;
            }
        }
        return null;
    }

    private final void a(com.iqoption.core.microservices.billing.response.deposit.g gVar) {
        com.iqoption.core.microservices.billing.response.deposit.g gVar2 = gVar;
        this.aTK = gVar2;
        this.bWR.clear();
        ViewGroup abe = abe();
        abe.removeAllViews();
        com.iqoption.core.microservices.billing.response.extraparams.e Va = gVar.Va();
        HashMap Vo = Va != null ? Va.Vo() : null;
        if (Vo != null) {
            int i;
            String str;
            ExtraParamProperty extraParamProperty;
            int size = Vo.size();
            ArrayList Vn = Va.Vn();
            if (Vn != null) {
                Iterator it = Vn.iterator();
                i = 0;
                while (it.hasNext()) {
                    str = (String) it.next();
                    HashMap Vo2 = Va.Vo();
                    if (Vo2 == null) {
                        kotlin.jvm.internal.h.aXZ();
                    }
                    extraParamProperty = (ExtraParamProperty) Vo2.get(str);
                    if (extraParamProperty != null) {
                        int i2 = i + 1;
                        kotlin.jvm.internal.h.d(str, "name");
                        int i3 = i2;
                        a(gVar2, extraParamProperty, str, i2 == size, abe);
                        i = i3;
                    }
                }
            } else {
                i = 0;
            }
            for (Entry entry : Vo.entrySet()) {
                str = (String) entry.getKey();
                extraParamProperty = (ExtraParamProperty) entry.getValue();
                if (Vn == null || !Vn.contains(str)) {
                    int i4 = i + 1;
                    a(gVar2, extraParamProperty, str, i4 == size, abe);
                    i = i4;
                }
            }
        }
        ViewGroup abR = abR();
        if (abQ() && gVar.UU()) {
            com.iqoption.core.ext.a.M(abR);
            com.iqoption.core.ext.a.L(abS());
            String string = getString(com.iqoption.deposit.r.h.unavailable_for_the_non_verified_accounts);
            com.iqoption.deposit.k kVar = com.iqoption.deposit.k.bVt;
            Fragment fragment = this;
            TextView abS = abS();
            kotlin.jvm.internal.h.d(string, "message");
            kVar.a(fragment, abS, string, false);
        } else if (abe.getChildCount() == 0) {
            com.iqoption.core.ext.a.M(abR);
            com.iqoption.core.ext.a.L(abS());
            abS().setText(com.iqoption.deposit.r.h.you_will_be_redirected_to_payment_gate);
        } else {
            com.iqoption.core.ext.a.L(abR);
            com.iqoption.core.ext.a.M(abS());
        }
    }

    private final void a(com.iqoption.core.microservices.billing.response.deposit.g gVar, ExtraParamProperty extraParamProperty, String str, boolean z, ViewGroup viewGroup) {
        if (extraParamProperty != null) {
            f a;
            com.iqoption.core.microservices.billing.response.extraparams.e Va = gVar.Va();
            if (Va == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            ArrayList Vn = Va.Vn();
            if (Vn == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            boolean contains = Vn.contains(str);
            switch (extraParamProperty.Vh()) {
                case enumType:
                    a = a(str, (com.iqoption.core.microservices.billing.response.extraparams.a) extraParamProperty, viewGroup, contains);
                    break;
                case selectType:
                    a = a(str, (com.iqoption.core.microservices.billing.response.extraparams.c) extraParamProperty, viewGroup, contains);
                    break;
                default:
                    a = a(str, extraParamProperty, viewGroup, contains, z);
                    break;
            }
            View abZ = a.abZ();
            abZ.setTag(a);
            viewGroup.addView(abZ);
            this.bWR.put(str, Boolean.valueOf(a(a, false)));
        }
    }

    private final f a(String str, ExtraParamProperty extraParamProperty, ViewGroup viewGroup, boolean z, boolean z2) {
        c b = b(str, extraParamProperty, viewGroup, z, z2);
        if (extraParamProperty instanceof com.iqoption.core.microservices.billing.response.extraparams.d) {
            com.iqoption.core.microservices.billing.response.extraparams.d dVar = (com.iqoption.core.microservices.billing.response.extraparams.d) extraParamProperty;
            if (dVar.Vm() != null) {
                Object filters = b.aca().getFilters();
                EditText aca = b.aca();
                kotlin.jvm.internal.h.d(filters, "filters");
                Integer Vm = dVar.Vm();
                if (Vm == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                aca.setFilters((InputFilter[]) h.a((Object[]) filters, (Object) new LengthFilter(Vm.intValue())));
            }
        }
        b.hg(extraParamProperty.getTitle());
        EditText aca2 = b.aca();
        aca2.addTextChangedListener(new f(this, b, z2, extraParamProperty, str));
        a(aca2, z2);
        aca2.setSingleLine(true);
        if (extraParamProperty.Vh() == PropertyType.integerType) {
            aca2.setInputType(8194);
            aca2.setKeyListener(DigitsKeyListener.getInstance(false, true));
        }
        aca2.setOnFocusChangeListener(new g(this, b, z2, extraParamProperty, str));
        return b;
    }

    private final f a(String str, com.iqoption.core.microservices.billing.response.extraparams.a aVar, ViewGroup viewGroup, boolean z) {
        d b = b(str, aVar, viewGroup, z);
        b.hg(aVar.getTitle());
        EditText aca = b.aca();
        aca.setInputType(0);
        aca.setOnClickListener(new h(this, b, str, aVar));
        aca.setOnFocusChangeListener(new i(this, b, str, aVar));
        return b;
    }

    private final void a(EditText editText, String str, com.iqoption.core.microservices.billing.response.extraparams.a aVar) {
        CharSequence obj = editText.getText().toString();
        Integer valueOf = (obj.length() == 0 ? 1 : null) != null ? null : Integer.valueOf(com.iqoption.core.ext.c.s(obj));
        List Vi = aVar.Vi();
        if (Vi == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        com.iqoption.core.ui.navigation.j.b(com.iqoption.deposit.navigator.b.cbG.G(this), a(new com.iqoption.deposit.constructor.selector.integer.c(str, Vi, valueOf)), false, 2, null);
    }

    private final f a(String str, com.iqoption.core.microservices.billing.response.extraparams.c cVar, ViewGroup viewGroup, boolean z) {
        e b = b(str, cVar, viewGroup, z);
        b.hg(cVar.getTitle());
        EditText aca = b.aca();
        aca.setInputType(0);
        aca.setOnClickListener(new j(this, b));
        aca.setOnFocusChangeListener(new k(this, b));
        return b;
    }

    private final void a(e eVar) {
        Object tag = eVar.aca().getTag();
        if (!(tag instanceof String)) {
            tag = null;
        }
        String str = (String) tag;
        Map Vk = eVar.abY().Vk();
        if (Vk == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        Iterable<Entry> entrySet = Vk.entrySet();
        Collection arrayList = new ArrayList(n.e(entrySet, 10));
        for (Entry entry : entrySet) {
            arrayList.add(new com.iqoption.deposit.constructor.selector.string.c(eVar.getName(), (String) entry.getKey(), (String) entry.getValue()));
        }
        com.iqoption.core.ui.navigation.j.b(com.iqoption.deposit.navigator.b.cbG.G(this), a(new com.iqoption.deposit.constructor.selector.string.d((List) arrayList, str)), false, 2, null);
    }

    public boolean validate() {
        ViewGroup abe = abe();
        int childCount = abe.getChildCount();
        if (childCount == 0) {
            return true;
        }
        int i = 0;
        while (i < childCount) {
            View childAt = abe.getChildAt(i);
            kotlin.jvm.internal.h.d(childAt, "child");
            Object tag = childAt.getTag();
            if (tag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.deposit.constructor.FieldHolder");
            } else if (!a((f) tag, true)) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }

    private final boolean a(f fVar, boolean z) {
        boolean z2 = true;
        int a = a(fVar, fVar.value()) ^ 1;
        if (a == 0 || !z) {
            fVar.hh(null);
        } else {
            fVar.hh(getString(com.iqoption.deposit.r.h.incorrect_value));
        }
        if (a != 0) {
            z2 = false;
        }
        this.bWR.put(fVar.getName(), Boolean.valueOf(z2));
        return z2;
    }

    private final boolean a(f fVar, String str) {
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        Object obj2 = (obj == null || fVar.isRequired()) ? null : 1;
        ExtraParamProperty abT = fVar.abT();
        if (obj == null && (abT instanceof com.iqoption.core.microservices.billing.response.extraparams.d)) {
            com.iqoption.core.microservices.billing.response.extraparams.d dVar = (com.iqoption.core.microservices.billing.response.extraparams.d) abT;
            CharSequence pattern = dVar.getPattern();
            Object obj3 = (pattern == null || pattern.length() == 0) ? 1 : null;
            if (obj3 == null) {
                return Pattern.matches(dVar.getPattern(), charSequence);
            }
        }
        if (obj == null || obj2 != null) {
            return true;
        }
        return false;
    }

    public Map<String, Object> aaR() {
        ViewGroup abe = abe();
        int childCount = abe.getChildCount();
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < childCount; i++) {
            View childAt = abe.getChildAt(i);
            kotlin.jvm.internal.h.d(childAt, "child");
            Object tag = childAt.getTag();
            if (tag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.deposit.constructor.FieldHolder");
            }
            f fVar = (f) tag;
            linkedHashMap.put(fVar.getName(), fVar.value());
        }
        return linkedHashMap;
    }

    public long aaS() {
        com.iqoption.core.microservices.billing.response.deposit.g gVar = this.aTK;
        if (gVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return gVar.getId();
    }

    private final void a(EditText editText, boolean z) {
        if (z) {
            editText.setImeOptions(268435462);
            editText.setOnEditorActionListener(new b(this));
            return;
        }
        editText.setImeOptions(268435461);
    }

    private final void abP() {
        Context n = com.iqoption.core.ext.a.n(this);
        View view = getView();
        if (view == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        com.iqoption.core.util.j.a(n, view);
    }

    private final boolean abQ() {
        return com.iqoption.deposit.navigator.b.cbG.J(this);
    }
}
