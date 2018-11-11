package com.iqoption.deposit.dark.a;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod.PayMethodType;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.r;
import com.iqoption.deposit.r.g;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020*H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006."}, aXE = {"Lcom/iqoption/deposit/dark/card/CardPaymentDarkFragment;", "Lcom/iqoption/deposit/card/BaseCardPaymentFragment;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentCardPaymentBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentCardPaymentBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentCardPaymentBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "cardTypeIcon", "Landroid/widget/ImageView;", "cvvEditText", "Landroid/support/design/widget/TextInputEditText;", "fieldsContainer", "Landroid/widget/LinearLayout;", "fillMonthAndYear", "", "month", "", "year", "getMonthAndYear", "Lkotlin/Pair;", "holderEditText", "numberEditText", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "scanCardView", "scanFragmentNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "setFieldsEnabled", "enabled", "", "setMonthAndYearEnabled", "validate", "Companion", "deposit_release"})
/* compiled from: CardPaymentDarkFragment.kt */
public final class a extends com.iqoption.deposit.card.a {
    private static final String TAG;
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentCardPaymentBinding;"))};
    public static final a bXN = new a();
    private HashMap atz;
    private final d bXo = kotlin.e.a.euA.aYg();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/dark/card/CardPaymentDarkFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "deposit_release"})
    /* compiled from: CardPaymentDarkFragment.kt */
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

    private final void a(com.iqoption.deposit.a.i iVar) {
        this.bXo.a(this, apP[0], iVar);
    }

    private final com.iqoption.deposit.a.i acD() {
        return (com.iqoption.deposit.a.i) this.bXo.b(this, apP[0]);
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
        String name = com.iqoption.deposit.card.a.class.getName();
        if (name == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        TAG = name;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((com.iqoption.deposit.a.i) com.iqoption.core.ext.a.a((Fragment) this, g.fragment_card_payment, viewGroup, false, 4, null));
        return acD().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        TextInputEditText textInputEditText = acD().bYD;
        TextInputLayout textInputLayout = acD().bYE;
        kotlin.jvm.internal.h.d(textInputLayout, "binding.cardNumberInput");
        textInputEditText.addTextChangedListener(new b(textInputLayout));
        textInputEditText = acD().bYB;
        textInputLayout = acD().bYA;
        kotlin.jvm.internal.h.d(textInputLayout, "binding.cardHolderInput");
        textInputEditText.addTextChangedListener(new b(textInputLayout));
        textInputEditText = acD().bYI;
        textInputLayout = acD().bYC;
        kotlin.jvm.internal.h.d(textInputLayout, "binding.cardMonthInput");
        textInputEditText.addTextChangedListener(new b(textInputLayout));
        textInputEditText = acD().bYL;
        textInputLayout = acD().bYH;
        kotlin.jvm.internal.h.d(textInputLayout, "binding.cardYearInput");
        textInputEditText.addTextChangedListener(new b(textInputLayout));
        textInputEditText = acD().bYK;
        textInputLayout = acD().bYG;
        kotlin.jvm.internal.h.d(textInputLayout, "binding.cardVnInput");
        textInputEditText.addTextChangedListener(new b(textInputLayout));
        textInputEditText = acD().bYD;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.cardNumber");
        a((EditText) textInputEditText, "deposit-page_card-number");
        textInputEditText = acD().bYB;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.cardHolderName");
        a((EditText) textInputEditText, "deposit-page_card-holder");
        textInputEditText = acD().bYI;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.month");
        a((EditText) textInputEditText, "deposit-page_expiry-month");
        textInputEditText = acD().bYL;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.year");
        a((EditText) textInputEditText, "deposit-page_expiry-year");
        textInputEditText = acD().bYK;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.vn");
        a((EditText) textInputEditText, "deposit-page_cvv");
    }

    public boolean validate() {
        if (aaT() == null) {
            return false;
        }
        PayMethod aaT = aaT();
        if ((aaT != null ? aaT.UT() : null) == PayMethodType.UserCard) {
            return true;
        }
        TextInputLayout textInputLayout;
        if (a(aaT())) {
            if (aaY()) {
                textInputLayout = acD().bYE;
                kotlin.jvm.internal.h.d(textInputLayout, "binding.cardNumberInput");
                CharSequence charSequence = (CharSequence) null;
                textInputLayout.setError(charSequence);
                if (aaZ()) {
                    TextInputLayout textInputLayout2;
                    textInputLayout = acD().bYA;
                    kotlin.jvm.internal.h.d(textInputLayout, "binding.cardHolderInput");
                    textInputLayout.setError(charSequence);
                    Pair aba = aba();
                    if (((Boolean) aba.getFirst()).booleanValue()) {
                        textInputLayout2 = acD().bYC;
                        kotlin.jvm.internal.h.d(textInputLayout2, "binding.cardMonthInput");
                        textInputLayout2.setError(charSequence);
                    } else {
                        textInputLayout2 = acD().bYC;
                        kotlin.jvm.internal.h.d(textInputLayout2, "binding.cardMonthInput");
                        textInputLayout2.setError(getString(r.h.incorrect_month));
                    }
                    if (((Boolean) aba.aXF()).booleanValue()) {
                        textInputLayout2 = acD().bYH;
                        kotlin.jvm.internal.h.d(textInputLayout2, "binding.cardYearInput");
                        textInputLayout2.setError(charSequence);
                    } else {
                        TextInputLayout textInputLayout3 = acD().bYH;
                        kotlin.jvm.internal.h.d(textInputLayout3, "binding.cardYearInput");
                        textInputLayout3.setError(getString(r.h.incorrect_year));
                    }
                    if (!(((Boolean) aba.getFirst()).booleanValue() && ((Boolean) aba.aXF()).booleanValue())) {
                        return false;
                    }
                }
                textInputLayout = acD().bYA;
                kotlin.jvm.internal.h.d(textInputLayout, "binding.cardHolderInput");
                textInputLayout.setError(getString(r.h.incorrect_card_holder));
                return false;
            }
            textInputLayout = acD().bYE;
            kotlin.jvm.internal.h.d(textInputLayout, "binding.cardNumberInput");
            textInputLayout.setError(getString(r.h.incorrect_card_number));
            return false;
        }
        if (abb()) {
            textInputLayout = acD().bYG;
            kotlin.jvm.internal.h.d(textInputLayout, "binding.cardVnInput");
            textInputLayout.setError((CharSequence) null);
            return true;
        }
        textInputLayout = acD().bYG;
        kotlin.jvm.internal.h.d(textInputLayout, "binding.cardVnInput");
        textInputLayout.setError(getString(r.h.incorrect_cvv_code));
        return false;
    }

    public h abd() {
        return com.iqoption.deposit.dark.menu.scan.d.bYr.ada();
    }

    /* renamed from: acE */
    public LinearLayout abe() {
        return acD().bYz;
    }

    /* renamed from: acF */
    public TextInputEditText abf() {
        return acD().bYD;
    }

    /* renamed from: acG */
    public ImageView abg() {
        return acD().bYJ;
    }

    public ImageView abh() {
        return acD().bYF;
    }

    /* renamed from: acH */
    public TextInputEditText abi() {
        return acD().bYB;
    }

    /* renamed from: acI */
    public TextInputEditText abj() {
        return acD().bYK;
    }

    public void ah(String str, String str2) {
        acD().bYI.setText(str);
        acD().bYL.setText(str2);
    }

    public void cs(boolean z) {
        TextInputEditText textInputEditText = acD().bYI;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.month");
        textInputEditText.setEnabled(z);
        textInputEditText = acD().bYL;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.year");
        textInputEditText.setEnabled(z);
    }

    public Pair<String, String> abk() {
        TextInputEditText textInputEditText = acD().bYI;
        kotlin.jvm.internal.h.d(textInputEditText, "binding.month");
        String obj = textInputEditText.getText().toString();
        TextInputEditText textInputEditText2 = acD().bYL;
        kotlin.jvm.internal.h.d(textInputEditText2, "binding.year");
        return new Pair(obj, textInputEditText2.getText().toString());
    }
}
