package com.iqoption.deposit.light.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.core.util.r;
import com.iqoption.deposit.a.k;
import com.iqoption.deposit.r.g;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\u001a\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020+H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u00061"}, aXE = {"Lcom/iqoption/deposit/light/card/CardPaymentLightFragment;", "Lcom/iqoption/deposit/card/BaseCardPaymentFragment;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentCardPaymentLightBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentCardPaymentLightBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentCardPaymentLightBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "cardTypeIcon", "Landroid/widget/ImageView;", "cvvEditText", "Landroid/widget/EditText;", "fieldsContainer", "Landroid/widget/LinearLayout;", "fillMonthAndYear", "", "month", "", "year", "getMonthAndYear", "Lkotlin/Pair;", "holderEditText", "numberEditText", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "scanCardView", "scanFragmentNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "setFieldsEnabled", "enabled", "", "setMonthAndYearEnabled", "updatePassTransformationMethod", "show", "validate", "Companion", "deposit_release"})
/* compiled from: CardPaymentLightFragment.kt */
public final class a extends com.iqoption.deposit.card.a {
    private static final String TAG;
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentCardPaymentLightBinding;"))};
    public static final a caB = new a();
    private HashMap atz;
    private final d bXo = kotlin.e.a.euA.aYg();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/light/card/CardPaymentLightFragment$Companion;", "", "()V", "DATE_SEPARATOR", "", "MONTH_LENGTH", "", "TAG", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "deposit_release"})
    /* compiled from: CardPaymentLightFragment.kt */
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

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: CardPaymentLightFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ a caC;

        b(a aVar) {
            this.caC = aVar;
        }

        public final void onClick(View view) {
            a aVar = this.caC;
            ToggleButton toggleButton = this.caC.adg().bER;
            kotlin.jvm.internal.h.d(toggleButton, "binding.passwordToggle");
            aVar.cu(toggleButton.isChecked());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"com/iqoption/deposit/light/card/CardPaymentLightFragment$onViewCreated$2", "Lcom/iqoption/core/util/TextWatcherAdapter;", "wasDeleting", "", "afterTextChanged", "", "source", "Landroid/text/Editable;", "onTextChanged", "s", "", "start", "", "before", "count", "setTextWithoutCallback", "text", "", "deposit_release"})
    /* compiled from: CardPaymentLightFragment.kt */
    public static final class c extends r {
        private boolean caD;
        final /* synthetic */ EditText caE;

        c(EditText editText) {
            this.caE = editText;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            kotlin.jvm.internal.h.e(charSequence, "s");
            super.onTextChanged(charSequence, i, i2, i3);
            boolean z = i3 == 0 && i2 > 0;
            this.caD = z;
        }

        public void afterTextChanged(Editable editable) {
            int length;
            String substring;
            kotlin.jvm.internal.h.e(editable, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
            super.afterTextChanged(editable);
            int length2 = "/".length();
            CharSequence charSequence = editable;
            if ((charSequence.length() == 0 ? 1 : null) == null) {
                StringBuilder stringBuilder;
                if (kotlin.jvm.internal.h.E(editable.toString(), "/")) {
                    hi(null);
                } else if (this.caD && editable.length() == 2) {
                    String obj = editable.toString();
                    length = editable.length() - 1;
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    substring = obj.substring(0, length);
                    kotlin.jvm.internal.h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(substring);
                    stringBuilder.append("/");
                    hi(stringBuilder.toString());
                } else if (v.a(charSequence, "/", 0, false, 6, null) < 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(editable.toString());
                    stringBuilder.append("/");
                    hi(stringBuilder.toString());
                }
            }
            EditText editText = this.caE;
            kotlin.jvm.internal.h.d(editText, "dateEditText");
            substring = editText.getText().toString();
            EditText editText2 = this.caE;
            kotlin.jvm.internal.h.d(editText2, "dateEditText");
            int selectionStart = editText2.getSelectionStart();
            editText2 = this.caE;
            kotlin.jvm.internal.h.d(editText2, "dateEditText");
            int selectionEnd = editText2.getSelectionEnd();
            if (substring.length() > length2 && selectionStart == selectionEnd) {
                selectionEnd = u.a(substring, "/", "", false, 4, null).length();
                length = substring.length();
                length2 = length - length2;
                if (selectionEnd < 2) {
                    this.caE.setSelection(length2, length2);
                } else if (selectionStart == length2) {
                    this.caE.setSelection(length, length);
                }
            }
        }

        private final void hi(String str) {
            TextWatcher textWatcher = this;
            this.caE.removeTextChangedListener(textWatcher);
            EditText editText = this.caE;
            if (str == null) {
                str = "";
            }
            editText.setText(str);
            this.caE.addTextChangedListener(textWatcher);
        }
    }

    private final void a(k kVar) {
        this.bXo.a(this, apP[0], kVar);
    }

    private final k adg() {
        return (k) this.bXo.b(this, apP[0]);
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
        a((k) com.iqoption.core.ext.a.a((Fragment) this, g.fragment_card_payment_light, viewGroup, false, 4, null));
        return adg().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        adg().bER.setOnClickListener(new b(this));
        EditText editText = adg().bYN;
        editText.addTextChangedListener(new c(editText));
        editText = adg().bYO;
        EditText editText2 = adg().bYO;
        kotlin.jvm.internal.h.d(editText2, "binding.cardNumber");
        editText.addTextChangedListener(new b(editText2));
        editText = adg().bon;
        editText2 = adg().bon;
        kotlin.jvm.internal.h.d(editText2, "binding.cardHolderName");
        editText.addTextChangedListener(new b(editText2));
        editText = adg().bYN;
        editText2 = adg().bYN;
        kotlin.jvm.internal.h.d(editText2, "binding.cardMonthAndYear");
        editText.addTextChangedListener(new b(editText2));
        editText = adg().bYM;
        editText2 = adg().bYM;
        kotlin.jvm.internal.h.d(editText2, "binding.cardCvv");
        editText.addTextChangedListener(new b(editText2));
        editText = adg().bYO;
        kotlin.jvm.internal.h.d(editText, "binding.cardNumber");
        a(editText, "deposit-page_card-number");
        editText = adg().bon;
        kotlin.jvm.internal.h.d(editText, "binding.cardHolderName");
        a(editText, "deposit-page_card-holder");
        editText = adg().bYN;
        kotlin.jvm.internal.h.d(editText, "binding.cardMonthAndYear");
        a(editText, "deposit-page_expiry-date");
        editText = adg().bYM;
        kotlin.jvm.internal.h.d(editText, "binding.cardCvv");
        a(editText, "deposit-page_cvv");
    }

    public void onResume() {
        super.onResume();
        ToggleButton toggleButton = adg().bER;
        kotlin.jvm.internal.h.d(toggleButton, "binding.passwordToggle");
        cu(toggleButton.isChecked());
    }

    private final void cu(boolean z) {
        TransformationMethod instance;
        EditText editText = adg().bYM;
        kotlin.jvm.internal.h.d(editText, "binding.cardCvv");
        int selectionStart = editText.getSelectionStart();
        EditText editText2 = adg().bYM;
        kotlin.jvm.internal.h.d(editText2, "binding.cardCvv");
        int selectionEnd = editText2.getSelectionEnd();
        if (z) {
            instance = HideReturnsTransformationMethod.getInstance();
        } else {
            instance = PasswordTransformationMethod.getInstance();
        }
        EditText editText3 = adg().bYM;
        kotlin.jvm.internal.h.d(editText3, "binding.cardCvv");
        editText3.setTransformationMethod(instance);
        adg().bYM.setSelection(selectionStart, selectionEnd);
    }

    public boolean validate() {
        if (aaT() == null) {
            return false;
        }
        if (aaT() instanceof com.iqoption.core.microservices.billing.response.deposit.h) {
            return true;
        }
        EditText editText;
        if (a(aaT())) {
            if (aaY()) {
                editText = adg().bYO;
                kotlin.jvm.internal.h.d(editText, "binding.cardNumber");
                com.iqoption.deposit.light.a.b(editText, null);
                if (aaZ()) {
                    editText = adg().bon;
                    kotlin.jvm.internal.h.d(editText, "binding.cardHolderName");
                    com.iqoption.deposit.light.a.b(editText, null);
                    Pair aba = aba();
                    if (((Boolean) aba.getFirst()).booleanValue() && ((Boolean) aba.aXF()).booleanValue()) {
                        EditText editText2 = adg().bYN;
                        kotlin.jvm.internal.h.d(editText2, "binding.cardMonthAndYear");
                        com.iqoption.deposit.light.a.b(editText2, null);
                    } else if (!((Boolean) aba.getFirst()).booleanValue()) {
                        kotlin.jvm.internal.h.d(getString(com.iqoption.deposit.r.h.incorrect_month), "getString(R.string.incorrect_month)");
                    } else if (!((Boolean) aba.aXF()).booleanValue()) {
                        kotlin.jvm.internal.h.d(getString(com.iqoption.deposit.r.h.incorrect_year), "getString(R.string.incorrect_year)");
                    }
                    if (!(((Boolean) aba.getFirst()).booleanValue() && ((Boolean) aba.aXF()).booleanValue())) {
                        return false;
                    }
                }
                editText = adg().bon;
                kotlin.jvm.internal.h.d(editText, "binding.cardHolderName");
                com.iqoption.deposit.light.a.b(editText, getString(com.iqoption.deposit.r.h.incorrect_card_holder));
                return false;
            }
            editText = adg().bYO;
            kotlin.jvm.internal.h.d(editText, "binding.cardNumber");
            com.iqoption.deposit.light.a.b(editText, getString(com.iqoption.deposit.r.h.incorrect_card_number));
            return false;
        }
        if (abb()) {
            editText = adg().bYM;
            kotlin.jvm.internal.h.d(editText, "binding.cardCvv");
            com.iqoption.deposit.light.a.b(editText, null);
            return true;
        }
        editText = adg().bYM;
        kotlin.jvm.internal.h.d(editText, "binding.cardCvv");
        com.iqoption.deposit.light.a.b(editText, getString(com.iqoption.deposit.r.h.incorrect_cvv_code));
        return false;
    }

    public h abd() {
        return com.iqoption.deposit.light.menu.scan.d.caS.ada();
    }

    /* renamed from: acE */
    public LinearLayout abe() {
        return adg().bYz;
    }

    public EditText abf() {
        return adg().bYO;
    }

    /* renamed from: acG */
    public ImageView abg() {
        return adg().bYJ;
    }

    public ImageView abh() {
        return adg().bYF;
    }

    public EditText abi() {
        return adg().bon;
    }

    public EditText abj() {
        return adg().bYM;
    }

    public void ah(String str, String str2) {
        if (str == null && str2 == null) {
            adg().bYN.setText("");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        stringBuilder.append("/");
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        adg().bYN.setText(stringBuilder);
    }

    public void cs(boolean z) {
        EditText editText = adg().bYN;
        kotlin.jvm.internal.h.d(editText, "binding.cardMonthAndYear");
        editText.setEnabled(z);
    }

    public Pair<String, String> abk() {
        EditText editText = adg().bYN;
        kotlin.jvm.internal.h.d(editText, "binding.cardMonthAndYear");
        Editable text = editText.getText();
        kotlin.jvm.internal.h.d(text, "binding.cardMonthAndYear.text");
        List b = v.b((CharSequence) text, new String[]{"/"}, false, 0, 6, null);
        if (b.size() < 2) {
            return new Pair("", "");
        }
        return new Pair(b.get(0), b.get(1));
    }
}
