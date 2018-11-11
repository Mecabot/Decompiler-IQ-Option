package com.iqoption.welcomeonboarding.registration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.ToggleButton;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.common.collect.ImmutableList;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.ae;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.Currency;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.authorization.AuthException;
import com.iqoption.microservice.authorization.RegistrationException;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003rstB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010&\u001a\u00020'H$J\b\u0010(\u001a\u00020'H$J\b\u0010)\u001a\u00020*H$J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020\u0006H\u0004J\b\u00101\u001a\u00020*H$J\b\u00102\u001a\u000203H$J\b\u00104\u001a\u000205H$J\b\u00106\u001a\u00020*H$J\b\u00107\u001a\u00020*H$J\b\u00108\u001a\u00020*H$J\b\u00109\u001a\u00020*H$J\b\u0010:\u001a\u00020;H$J\b\u0010<\u001a\u000203H$J\b\u0010=\u001a\u00020,H\u0014J\b\u0010\f\u001a\u00020,H\u0002J\b\u0010>\u001a\u00020,H\u0002J\b\u0010?\u001a\u00020,H\u0002J\b\u0010@\u001a\u00020.H\u0002J\b\u0010A\u001a\u00020.H\u0002J\b\u0010B\u001a\u00020\u0006H\u0002J\b\u0010C\u001a\u00020\u0006H\u0002J\b\u0010D\u001a\u00020\u0006H$J\b\u0010E\u001a\u00020\u0006H\u0002J\b\u0010F\u001a\u00020,H\u0002J\u0012\u0010G\u001a\u00020,2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020\u0006H\u0016J\u0010\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020#H\u0002J\u0012\u0010M\u001a\u00020,2\b\u0010N\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010O\u001a\u00020,2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020,H&J\b\u0010S\u001a\u00020,H\u0016J\b\u0010T\u001a\u00020,H\u0016J\u0010\u0010U\u001a\u00020,2\u0006\u0010V\u001a\u00020QH\u0016J\u001a\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020*2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010Y\u001a\u000203H$J\b\u0010Z\u001a\u00020[H$J\b\u0010\\\u001a\u00020;H$J\b\u0010]\u001a\u00020,H\u0002J\b\u0010^\u001a\u00020;H$J\b\u0010_\u001a\u00020`H%J\b\u0010a\u001a\u00020*H$J\b\u0010b\u001a\u00020`H$J\u0018\u0010c\u001a\u00020,2\u0006\u0010N\u001a\u00020#2\u0006\u0010d\u001a\u00020\u0006H\u0002J\b\u0010e\u001a\u00020,H\u0002J\b\u0010f\u001a\u00020\u0006H\u0002J\b\u0010g\u001a\u00020,H\u0002J\b\u0010h\u001a\u00020*H$J\b\u0010i\u001a\u00020,H\u0002J\u0010\u0010j\u001a\u00020,2\u0006\u0010k\u001a\u00020lH\u0002J\u0012\u0010m\u001a\u00020,2\b\u0010n\u001a\u0004\u0018\u00010\u000bH\u0004J\u0010\u0010o\u001a\u00020,2\u0006\u0010p\u001a\u00020\u0006H\u0002J\b\u0010q\u001a\u00020,H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000¨\u0006u"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "Lcom/iqoption/welcomeonboarding/registration/country/OnCountrySelectionListener;", "()V", "callGdpr", "", "checkGdpr", "countriesLoaded", "currencies", "", "Lcom/iqoption/dto/Currencies$Currency;", "getCurrencies", "()Ljava/util/List;", "setCurrencies", "(Ljava/util/List;)V", "currentCurrency", "getCurrentCurrency", "()Lcom/iqoption/dto/Currencies$Currency;", "setCurrentCurrency", "(Lcom/iqoption/dto/Currencies$Currency;)V", "event", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "getEvent", "()Lcom/iqoption/dto/Event$Builder;", "setEvent", "(Lcom/iqoption/dto/Event$Builder;)V", "eventsFragmentListener", "Lcom/iqoption/welcomeonboarding/AuthFragmentEventsListener;", "getEventsFragmentListener", "()Lcom/iqoption/welcomeonboarding/AuthFragmentEventsListener;", "setEventsFragmentListener", "(Lcom/iqoption/welcomeonboarding/AuthFragmentEventsListener;)V", "selectedCountry", "Lcom/iqoption/core/microservices/configuration/response/Country;", "viewModel", "Lcom/iqoption/welcomeonboarding/registration/RegistrationViewModel;", "acceptTermsCheck", "Landroid/widget/CheckBox;", "ageCheckBox", "ageLayout", "Landroid/view/View;", "checkAuth", "", "email", "", "password", "closeKeyboardIfNeeded", "countryContainer", "countryEdit", "Landroid/widget/EditText;", "countryInput", "Landroid/support/design/widget/TextInputLayout;", "countryLocationButton", "countryLocationError", "countryProgress", "currencyContainer", "currencySpinnerTitle", "Landroid/widget/TextView;", "emailEdit", "forceClose", "handelCurrenciesRequestError", "hideRegistrationProgress", "inputEmail", "inputPassword", "isGdprCheckboxEnabled", "isRegulated", "isTrialUser", "isValid", "loadCountries", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "onCountriesLoaded", "myCountry", "onCountryResult", "country", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCurrencyContainerClick", "onDestroyView", "onResume", "onSaveInstanceState", "outState", "onViewCreated", "view", "passwordEdit", "passwordToggle", "Landroid/widget/ToggleButton;", "policyTextView", "register", "registerButton", "registerButtonText", "", "registerProgress", "searchCountriesContainerId", "setSelectedCountry", "animate", "showCountriesFragment", "showGdprLink", "showRegistrationProgress", "titleView", "updateButtonValidation", "updateCurrencies", "currenciesResponse", "Lcom/iqoption/dto/Currencies;", "updateCurrencyContainer", "currency", "updatePassTransformationMethod", "show", "updatePolicy", "AuthCallback", "Companion", "CurrenciesRequestCallback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BaseRegistrationFragment.kt */
public abstract class b extends com.iqoption.core.ui.fragment.b implements com.iqoption.view.e.a, com.iqoption.welcomeonboarding.registration.country.f {
    private static final String TAG = "com.iqoption.welcomeonboarding.registration.b";
    public static final b dMy = new b();
    private List<? extends Currency> aVv;
    private Builder ajG;
    private HashMap atz;
    private com.iqoption.welcomeonboarding.a dLV;
    private Currency dMs;
    private boolean dMt;
    private boolean dMu;
    private RegistrationViewModel dMv;
    private boolean dMw;
    private com.iqoption.core.microservices.configuration.a.c dMx;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment$Companion;", "", "()V", "STATE_COUNTRY", "", "STATE_CURRENCY", "TAG", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: BaseRegistrationFragment.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class f implements OnGlobalLayoutListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ b dMA;

        public f(View view, b bVar) {
            this.aGz = view;
            this.dMA = bVar;
        }

        public void onGlobalLayout() {
            this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.dMA.aLA().requestFocus();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "focused", "", "onFocusChange"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class g implements OnFocusChangeListener {
        final /* synthetic */ b dMA;

        g(b bVar) {
            this.dMA = bVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (!this.dMA.isAdded() || !z) {
                return;
            }
            if (this.dMA.dMw) {
                this.dMA.aLl();
            } else {
                this.dMA.aLk();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class h implements Runnable {
        final /* synthetic */ b dMA;
        final /* synthetic */ s dMB;

        h(b bVar, s sVar) {
            this.dMA = bVar;
            this.dMB = sVar;
        }

        public final void run() {
            s sVar = this.dMB;
            Editable text = this.dMA.aLB().getText();
            kotlin.jvm.internal.h.d(text, "emailEdit().text");
            sVar.afterTextChanged(text);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onCheckedChanged"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class i implements OnCheckedChangeListener {
        final /* synthetic */ b dMA;

        i(b bVar) {
            this.dMA = bVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.dMA.aLo();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class k implements OnClickListener {
        final /* synthetic */ b dMA;

        k(b bVar) {
            this.dMA = bVar;
        }

        public final void onClick(View view) {
            this.dMA.register();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class l implements OnClickListener {
        final /* synthetic */ b dMA;

        l(b bVar) {
            this.dMA = bVar;
        }

        public final void onClick(View view) {
            this.dMA.aLn();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class m implements OnClickListener {
        final /* synthetic */ b dMA;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "country", "Lcom/iqoption/core/microservices/configuration/response/Country;", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: BaseRegistrationFragment.kt */
        /* renamed from: com.iqoption.welcomeonboarding.registration.b$m$1 */
        static final class AnonymousClass1<T> implements io.reactivex.c.e<com.iqoption.core.microservices.configuration.a.c> {
            final /* synthetic */ m dMC;

            AnonymousClass1(m mVar) {
                this.dMC = mVar;
            }

            /* renamed from: e */
            public final void accept(com.iqoption.core.microservices.configuration.a.c cVar) {
                b bVar = this.dMC.dMA;
                kotlin.jvm.internal.h.d(cVar, "country");
                bVar.a(cVar, true);
            }
        }

        m(b bVar) {
            this.dMA = bVar;
        }

        public final void onClick(View view) {
            b.d(this.dMA).fv(this.dMA.aLy()).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new AnonymousClass1(this), (io.reactivex.c.e) AnonymousClass2.dMD);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class n implements OnCheckedChangeListener {
        public static final n dME = new n();

        n() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "registration_is-old-enough").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class o implements OnClickListener {
        final /* synthetic */ b dMA;

        o(b bVar) {
            this.dMA = bVar;
        }

        public final void onClick(View view) {
            this.dMA.aLN().toggle();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class p implements OnEditorActionListener {
        final /* synthetic */ b dMA;

        p(b bVar) {
            this.dMA = bVar;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            am.n(this.dMA.zzakw());
            this.dMA.aLQ().requestFocus();
            return true;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class q implements OnClickListener {
        final /* synthetic */ b dMA;

        q(b bVar) {
            this.dMA = bVar;
        }

        public final void onClick(View view) {
            this.dMA.cu(this.dMA.aLD().isChecked());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class r implements OnClickListener {
        final /* synthetic */ b dMA;

        r(b bVar) {
            this.dMA = bVar;
        }

        public final void onClick(View view) {
            this.dMA.aLk();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class w implements Runnable {
        final /* synthetic */ b dMA;

        w(b bVar) {
            this.dMA = bVar;
        }

        public final void run() {
            this.dMA.aLE().setVisibility(4);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onCheckedChanged"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class x implements OnCheckedChangeListener {
        final /* synthetic */ b dMA;

        x(b bVar) {
            this.dMA = bVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.dMA.aLo();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment$CurrenciesRequestCallback;", "Lcom/iqoption/mobbtech/connect/callback/RequestCallbackT;", "Lcom/iqoption/dto/Currencies;", "registrationFragment", "Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;", "(Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;)V", "welcomeFragmentRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onError", "", "error", "Lcom/iqoption/mobbtech/connect/response/MobbError;", "onSuccess", "currenciesResponse", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: BaseRegistrationFragment.kt */
    private static final class c implements com.iqoption.mobbtech.connect.a.b<Currencies> {
        private final WeakReference<b> dMz;

        public c(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "registrationFragment");
            this.dMz = new WeakReference(bVar);
        }

        /* renamed from: b */
        public void onSuccess(Currencies currencies) {
            kotlin.jvm.internal.h.e(currencies, "currenciesResponse");
            b bVar = (b) this.dMz.get();
            if (bVar == null || !bVar.isAdded()) {
                com.iqoption.core.i.w(b.TAG, "currencies response is not handled, WelcomeFragment is not exist");
                return;
            }
            com.iqoption.core.i.d(b.TAG, "currencies update");
            bVar.a(currencies);
        }

        public void a(com.iqoption.mobbtech.connect.response.g gVar) {
            kotlin.jvm.internal.h.e(gVar, "error");
            String Ki = b.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to get currencies, message: ");
            stringBuilder.append(gVar.getMessage());
            Log.e(Ki, stringBuilder.toString());
            b bVar = (b) this.dMz.get();
            if (bVar != null && bVar.isAdded()) {
                bVar.aLq();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/configuration/response/Country;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class d<T> implements io.reactivex.c.e<com.iqoption.core.microservices.configuration.a.c> {
        final /* synthetic */ b dMA;

        d(b bVar) {
            this.dMA = bVar;
        }

        /* renamed from: e */
        public final void accept(com.iqoption.core.microservices.configuration.a.c cVar) {
            b bVar = this.dMA;
            kotlin.jvm.internal.h.d(cVar, "it");
            bVar.f(cVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ b dMA;

        e(b bVar) {
            this.dMA = bVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.dMA.aLG().setEnabled(true);
            this.dMA.aLH().setVisibility(8);
            this.dMA.aLI().setVisibility(0);
            this.dMA.aLJ().setVisibility(8);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/mobbtech/connect/response/RegulationResponse;", "call"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class j<T> implements com.iqoption.util.ag.e<com.iqoption.mobbtech.connect.response.k> {
        final /* synthetic */ WeakReference aJr;

        j(WeakReference weakReference) {
            this.aJr = weakReference;
        }

        /* renamed from: e */
        public final void aU(com.iqoption.mobbtech.connect.response.k kVar) {
            kotlin.jvm.internal.h.e(kVar, "it");
            b bVar = (b) this.aJr.get();
            if (bVar != null && bVar.isAdded()) {
                bVar.aLm();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/welcomeonboarding/registration/BaseRegistrationFragment$onViewCreated$watcher$1", "Lcom/iqoption/view/text/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: BaseRegistrationFragment.kt */
    public static final class s extends com.iqoption.view.text.x {
        final /* synthetic */ b dMA;

        s(b bVar) {
            this.dMA = bVar;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.h.e(editable, "s");
            super.afterTextChanged(editable);
            if (this.dMA.aLR().getVisibility() != 0) {
                this.dMA.aLo();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class t<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ b dMA;
        final /* synthetic */ WeakReference dMF;

        t(b bVar, WeakReference weakReference) {
            this.dMA = bVar;
            this.dMF = weakReference;
        }

        public /* synthetic */ void aU(Object obj) {
            cc(((Boolean) obj).booleanValue());
        }

        public final void cc(boolean z) {
            b bVar = (b) this.dMF.get();
            if (bVar != null && bVar.isAdded()) {
                String str;
                if (bVar.aLi() == null) {
                    str = null;
                } else {
                    Currency aLi = bVar.aLi();
                    if (aLi == null) {
                        kotlin.jvm.internal.h.aXZ();
                    }
                    str = aLi.name;
                }
                FragmentActivity activity = this.dMA.zzakw();
                if (bVar.aLj() != null) {
                    com.iqoption.welcomeonboarding.a aLj = bVar.aLj();
                    if (aLj == null) {
                        kotlin.jvm.internal.h.aXZ();
                    }
                    aLj.ki(str);
                } else if (activity instanceof TradeRoomActivity) {
                    bVar.aiM();
                    TradeRoomActivity tradeRoomActivity = (TradeRoomActivity) activity;
                    tradeRoomActivity.aeh.alE();
                    tradeRoomActivity.zC();
                    final WeakReference weakReference = new WeakReference(activity);
                    com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                        public final void run() {
                            TradeRoomActivity tradeRoomActivity = (TradeRoomActivity) weakReference.get();
                            if (tradeRoomActivity != null) {
                                tradeRoomActivity.b(str, null);
                            }
                        }
                    }, 1000);
                }
                af aR = af.aR((Context) IQApp.Dk());
                kotlin.jvm.internal.h.d(aR, "Preferences.getInstance(IQApp.instance())");
                if (!aR.EC()) {
                    ae.d(IQApp.Dk(), 4);
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "throwable", "", "call"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class u implements com.iqoption.util.ag.a {
        final /* synthetic */ b dMA;
        final /* synthetic */ WeakReference dMF;
        final /* synthetic */ String dMH;
        final /* synthetic */ String dMI;

        u(b bVar, WeakReference weakReference, String str, String str2) {
            this.dMA = bVar;
            this.dMF = weakReference;
            this.dMH = str;
            this.dMI = str2;
        }

        public final void n(Throwable th) {
            kotlin.jvm.internal.h.e(th, "throwable");
            b bVar = (b) this.dMF.get();
            if (bVar != null && bVar.isAdded()) {
                if ((th instanceof RegistrationException) && ((RegistrationException) th).code == RegistrationException.cPo) {
                    this.dMA.aE(this.dMH, this.dMI);
                } else {
                    bVar.aLs();
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "kotlin.jvm.PlatformType", "it", "Lcom/iqoption/appsflayer/AppsFlyerListener$AppsflyerInstallResult;", "apply"})
    /* compiled from: BaseRegistrationFragment.kt */
    static final class v<I, O> implements com.google.common.util.concurrent.g<I, O> {
        final /* synthetic */ String $name;
        final /* synthetic */ b dMA;
        final /* synthetic */ String dMH;
        final /* synthetic */ String dMI;
        final /* synthetic */ String dMJ;
        final /* synthetic */ Integer dMK;
        final /* synthetic */ Long dML;

        v(b bVar, String str, String str2, String str3, String str4, Integer num, Long l) {
            this.dMA = bVar;
            this.$name = str;
            this.dMJ = str2;
            this.dMI = str3;
            this.dMH = str4;
            this.dMK = num;
            this.dML = l;
        }

        /* renamed from: b */
        public final com.google.common.util.concurrent.s<Boolean> aP(com.iqoption.b.b.a aVar) {
            return com.iqoption.c.a.Jw().a(this.dMA.dMu, this.$name, this.dMJ, this.dMI, this.dMH, this.dMK, this.dML);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment$AuthCallback;", "Lcom/iqoption/system/future/ReferenceFutureCallback;", "Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;", "", "referent", "(Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;)V", "onFailure", "", "fragment", "throwable", "", "onSuccess", "result", "(Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;Ljava/lang/Boolean;)V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: BaseRegistrationFragment.kt */
    private static final class a extends com.iqoption.system.c.b<b, Boolean> {
        public a(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "referent");
            super((Object) bVar);
        }

        /* renamed from: a */
        public void z(b bVar, Boolean bool) {
            kotlin.jvm.internal.h.e(bVar, "fragment");
            if (bVar.isAdded()) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_login").setValue(Double.valueOf(1.0d)).build());
                af aR = af.aR((Context) IQApp.Dk());
                kotlin.jvm.internal.h.d(aR, "Preferences.getInstance(IQApp.instance())");
                aR.ag(0);
                Fragment fragment = bVar;
                if (com.iqoption.core.ext.a.n(fragment).getRequestedOrientation() == 7) {
                    com.iqoption.core.ext.a.n(fragment).setRequestedOrientation(6);
                }
                if (bVar.aLj() != null) {
                    com.iqoption.welcomeonboarding.a aLj = bVar.aLj();
                    if (aLj == null) {
                        kotlin.jvm.internal.h.aXZ();
                    }
                    aLj.aKB();
                }
                bVar.aLs();
            }
        }

        /* renamed from: a */
        public void c(b bVar, Throwable th) {
            kotlin.jvm.internal.h.e(bVar, "fragment");
            kotlin.jvm.internal.h.e(th, "throwable");
            if (bVar.isAdded()) {
                if (th instanceof AuthException) {
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_login").setValue(Double.valueOf(0.0d)).build());
                    AuthException authException = (AuthException) th;
                    if ((authException.status == 100 || authException.status == 101) && bVar.aLj() != null) {
                        com.iqoption.welcomeonboarding.a aLj = bVar.aLj();
                        if (aLj == null) {
                            kotlin.jvm.internal.h.aXZ();
                        }
                        aLj.j(authException.email, authException.password, authException.phoneMask);
                    }
                }
                bVar.aLs();
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    protected abstract View aLA();

    protected abstract EditText aLB();

    protected abstract EditText aLC();

    protected abstract ToggleButton aLD();

    protected abstract View aLE();

    protected abstract TextInputLayout aLF();

    protected abstract EditText aLG();

    protected abstract View aLH();

    protected abstract View aLI();

    protected abstract View aLJ();

    protected abstract View aLK();

    protected abstract TextView aLL();

    protected abstract View aLM();

    protected abstract CheckBox aLN();

    protected abstract TextView aLO();

    protected abstract CheckBox aLP();

    protected abstract TextView aLQ();

    protected abstract View aLR();

    @StringRes
    protected abstract int aLS();

    public abstract void aLn();

    protected abstract boolean aLy();

    protected abstract int aLz();

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

    public b() {
        ImmutableList sL = ImmutableList.sL();
        kotlin.jvm.internal.h.d(sL, "ImmutableList.of()");
        this.aVv = sL;
    }

    public static final /* synthetic */ RegistrationViewModel d(b bVar) {
        RegistrationViewModel registrationViewModel = bVar.dMv;
        if (registrationViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return registrationViewModel;
    }

    static {
        if (b.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    protected final List<Currency> VF() {
        return this.aVv;
    }

    protected final Currency aLi() {
        return this.dMs;
    }

    protected final com.iqoption.welcomeonboarding.a aLj() {
        return this.dLV;
    }

    protected final void j(Builder builder) {
        this.ajG = builder;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.iqoption.welcomeonboarding.a) {
            this.dLV = (com.iqoption.welcomeonboarding.a) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            if (bundle.containsKey("STATE_CURRENCY")) {
                this.dMs = (Currency) bundle.getParcelable("STATE_CURRENCY");
            }
            if (bundle.containsKey("STATE_COUNTRY")) {
                this.dMx = (com.iqoption.core.microservices.configuration.a.c) bundle.getParcelable("STATE_COUNTRY");
            }
        }
        this.dMv = RegistrationViewModel.dMZ.ac(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        aLQ().setText(aLS());
        aLp();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new f(view, this));
        aLQ().setOnClickListener(new k(this));
        aLK().setOnClickListener(new l(this));
        aLJ().setOnClickListener(new m(this));
        aLN().setOnCheckedChangeListener(n.dME);
        aLM().setOnClickListener(new o(this));
        aLC().setOnEditorActionListener(new p(this));
        aLD().setOnClickListener(new q(this));
        if (com.iqoption.app.managers.feature.a.eW("select-registration-country")) {
            aLE().setVisibility(0);
            aLI().setOnClickListener(new r(this));
            aLG().setOnFocusChangeListener(new g(this));
            aLk();
        } else {
            aLE().setVisibility(8);
        }
        s sVar = new s(this);
        TextWatcher textWatcher = sVar;
        aLB().addTextChangedListener(textWatcher);
        aLC().addTextChangedListener(textWatcher);
        aLB().post(new h(this, sVar));
        aLN().setOnCheckedChangeListener(new i(this));
        aLm();
        af aR = af.aR(getContext());
        kotlin.jvm.internal.h.d(aR, "Preferences.getInstance(context)");
        if (!aR.EB()) {
            ag.a(com.iqoption.mobbtech.connect.request.h.aul(), (com.iqoption.util.ag.e) new j(new WeakReference(this)), (Executor) com.iqoption.core.d.a.aSe);
        }
    }

    private final void aLk() {
        aLG().setEnabled(false);
        aLH().setVisibility(0);
        aLI().setVisibility(8);
        aLJ().setVisibility(8);
        RegistrationViewModel registrationViewModel = this.dMv;
        if (registrationViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        io.reactivex.disposables.b a = registrationViewModel.fv(aLy()).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new d(this), (io.reactivex.c.e) new e(this));
        kotlin.jvm.internal.h.d(a, "viewModel.getMyCountry(i…      }\n                )");
        a(a);
    }

    private final void f(com.iqoption.core.microservices.configuration.a.c cVar) {
        a(cVar, true);
        this.dMw = true;
        aLG().setEnabled(true);
        aLH().setVisibility(8);
        aLI().setVisibility(8);
        aLJ().setVisibility(0);
    }

    private final void aLl() {
        com.iqoption.core.ui.navigation.h a = com.iqoption.welcomeonboarding.registration.country.d.dNj.a(com.iqoption.core.ext.a.K(aLF()), aLG().getText().toString(), aLy());
        Context context = getContext();
        if (context == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(context, "context!!");
        getChildFragmentManager().beginTransaction().add(aLz(), a.bf(context), a.getName()).addToBackStack(a.getName()).commitAllowingStateLoss();
        View view = getView();
        view = view != null ? view.findFocus() : null;
        if (view != null) {
            view.clearFocus();
        }
        aLE().post(new w(this));
    }

    public void onResume() {
        super.onResume();
        cu(aLD().isChecked());
    }

    private final void cu(boolean z) {
        TransformationMethod instance;
        int selectionStart = aLC().getSelectionStart();
        int selectionEnd = aLC().getSelectionEnd();
        if (z) {
            instance = HideReturnsTransformationMethod.getInstance();
        } else {
            instance = PasswordTransformationMethod.getInstance();
        }
        aLC().setTransformationMethod(instance);
        aLC().setSelection(selectionStart, selectionEnd);
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.e(bundle, "outState");
        if (this.dMs != null) {
            bundle.putParcelable("STATE_CURRENCY", this.dMs);
        }
        if (this.dMx != null) {
            bundle.putParcelable("STATE_COUNTRY", this.dMx);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.ajG != null) {
            EventManager Bm = EventManager.Bm();
            Builder builder = this.ajG;
            if (builder == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            Bm.a(builder.calcDuration().build());
        }
        KH();
    }

    private final void aLm() {
        Context context = getContext();
        if (context != null) {
            String string = getString(R.string.terms_and_conditions);
            kotlin.jvm.internal.h.d(string, "getString(R.string.terms_and_conditions)");
            CharSequence charSequence = string;
            kotlin.jvm.internal.h.d(context, "context");
            com.iqoption.view.text.l lVar = new com.iqoption.view.text.l(charSequence, com.iqoption.view.text.q.bZ(context));
            String string2 = getString(R.string.privacy_policy);
            kotlin.jvm.internal.h.d(string2, "getString(R.string.privacy_policy)");
            com.iqoption.view.text.l lVar2 = new com.iqoption.view.text.l(string2, com.iqoption.view.text.q.ca(context));
            if (aLw()) {
                this.dMt = true;
                aLP().setVisibility(0);
                aLP().setOnCheckedChangeListener(new x(this));
            } else {
                this.dMt = false;
                aLP().setVisibility(8);
            }
            String string3;
            if (aLv()) {
                this.dMu = true;
                string3 = getString(R.string.by_clicking_open_account_you_confirm_p1_and_p2, lVar.getText(), lVar2.getText());
                TextView aLO = aLO();
                kotlin.jvm.internal.h.d(string3, "text");
                com.iqoption.view.text.l[] lVarArr = new com.iqoption.view.text.l[]{lVar, lVar2};
                com.iqoption.view.text.p pVar = r7;
                com.iqoption.view.text.p pVar2 = new com.iqoption.view.text.p(lVarArr, aLO, string3, 0, 0, null, 56, null);
                com.iqoption.view.text.o.a(pVar);
            } else {
                this.dMu = false;
                string3 = getString(R.string.by_clicking_open_account_you_confirm_p1, lVar.getText());
                TextView aLO2 = aLO();
                kotlin.jvm.internal.h.d(string3, "text");
                com.iqoption.view.text.l[] lVarArr2 = new com.iqoption.view.text.l[]{lVar};
                com.iqoption.view.text.o.a(new com.iqoption.view.text.p(lVarArr2, aLO2, string3, 0, 0, null, 56, null));
            }
        }
    }

    private final void aLo() {
        aLQ().setEnabled(isValid());
    }

    private final void register() {
        String aLt = aLt();
        String aLu = aLu();
        if (com.iqoption.core.util.p.u(aLt)) {
            Integer num;
            Long id;
            am.n(zzakw());
            aLr();
            if (this.dMs == null) {
                num = null;
            } else {
                Currency currency = this.dMs;
                if (currency == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                num = currency.id;
            }
            Context context = getContext();
            if (context == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            String string = context.getString(R.string.name);
            context = getContext();
            if (context == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            String string2 = context.getString(R.string.surname);
            if (this.dMx != null) {
                com.iqoption.core.microservices.configuration.a.c cVar = this.dMx;
                if (cVar == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                id = cVar.Jf();
            } else {
                id = null;
            }
            com.google.common.util.concurrent.s a = ag.a(((com.iqoption.b.a) IQApp.Dk().akP.get()).Jc(), (com.google.common.util.concurrent.g) new v(this, string, string2, aLu, aLt, num, id));
            WeakReference weakReference = new WeakReference(this);
            ag.a(a, (com.iqoption.util.ag.e) new t(this, weakReference), (com.iqoption.util.ag.a) new u(this, weakReference, aLt, aLu));
            return;
        }
        com.iqoption.app.a.b.eO(getString(R.string.please_enter_valid_email));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "registration_error").setParameters(com.iqoption.core.util.i.ZZ().l("error_name", getResources().getResourceName(R.string.please_enter_valid_email)).aab()).build());
    }

    private final void aE(String str, String str2) {
        com.google.common.util.concurrent.o.a(com.iqoption.c.a.Jw().a(str, str2, null, false, false, 0), new a(this), com.iqoption.core.d.a.aSe);
    }

    protected final void a(Currency currency) {
        String str;
        this.dMs = currency;
        TextView aLL = aLL();
        if (this.dMs == null) {
            str = "";
        } else {
            Currency currency2 = this.dMs;
            if (currency2 == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            str = currency2.name;
        }
        aLL.setText(str);
    }

    private final void aLp() {
        String in = IQApp.Dl().in("api/v2/currencies");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(in);
        stringBuilder.append("api/v2/currencies");
        new com.iqoption.mobbtech.connect.request.a.a.h(Currencies.class, RequestManager.a(stringBuilder.toString(), null, (Context) zzakw()), new c(this), "api/v2/currencies").auF();
    }

    private final void a(Currencies currencies) {
        Boolean bool = currencies.isSuccessful;
        kotlin.jvm.internal.h.d(bool, "currenciesResponse.isSuccessful");
        if (!bool.booleanValue() || currencies.result == null) {
            aLq();
            return;
        }
        ImmutableList sA = com.google.common.collect.i.c((Iterable) currencies.result).c(Currencies.isRegistration).sA();
        kotlin.jvm.internal.h.d(sA, "FluentIterable.from(curr….isRegistration).toList()");
        this.aVv = sA;
        Currency currency = currencies.getDefault();
        Currency currency2 = this.dMs;
        if (currency2 != null) {
            a(currency2);
        } else if (currency != null) {
            a(currency);
        }
    }

    private final void aLq() {
        com.iqoption.app.a.b.aT(getContext());
    }

    private final void aLr() {
        aLQ().setEnabled(false);
        aLQ().setText((CharSequence) null);
        com.iqoption.core.ext.a.L(aLR());
        aLB().setEnabled(false);
        aLC().setEnabled(false);
    }

    private final void aLs() {
        aLQ().setEnabled(isValid());
        aLQ().setText(aLS());
        com.iqoption.core.ext.a.hide(aLR());
        aLB().setEnabled(true);
        aLC().setEnabled(true);
    }

    public boolean onBackPressed() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.h.d(childFragmentManager, "fm");
        boolean z = false;
        if (childFragmentManager.getBackStackEntryCount() <= 0) {
            return false;
        }
        BackStackEntry backStackEntryAt = childFragmentManager.getBackStackEntryAt(childFragmentManager.getBackStackEntryCount() - 1);
        kotlin.jvm.internal.h.d(backStackEntryAt, "fm.getBackStackEntryAt(fm.backStackEntryCount - 1)");
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(backStackEntryAt.getName());
        if (findFragmentByTag != null && (findFragmentByTag instanceof com.iqoption.view.e.a) && ((com.iqoption.view.e.a) findFragmentByTag).onBackPressed()) {
            z = true;
        }
        return z;
    }

    private final boolean isValid() {
        if ((((CharSequence) aLt()).length() == 0 ? 1 : null) != null) {
            return false;
        }
        if ((((CharSequence) aLu()).length() == 0 ? 1 : null) != null || !aLN().isChecked()) {
            return false;
        }
        if (!this.dMt || aLP().isChecked()) {
            return true;
        }
        return false;
    }

    private final String aLt() {
        CharSequence obj = aLB().getText().toString();
        int length = obj.length() - 1;
        int i = 0;
        Object obj2 = null;
        while (i <= length) {
            Object obj3 = obj.charAt(obj2 == null ? i : length) <= ' ' ? 1 : null;
            if (obj2 == null) {
                if (obj3 == null) {
                    obj2 = 1;
                } else {
                    i++;
                }
            } else if (obj3 == null) {
                break;
            } else {
                length--;
            }
        }
        return obj.subSequence(i, length + 1).toString();
    }

    private final String aLu() {
        return aLC().getText().toString();
    }

    public void g(com.iqoption.core.microservices.configuration.a.c cVar) {
        if (aLE().getVisibility() != 0) {
            aLE().setVisibility(0);
        }
        if (cVar != null) {
            a(cVar, false);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "registration_country").setValue(Double.valueOf((double) cVar.Jf().longValue())).build());
        }
        am.n(zzakw());
    }

    private final void a(com.iqoption.core.microservices.configuration.a.c cVar, boolean z) {
        this.dMx = cVar;
        if (!z) {
            aLF().setHintAnimationEnabled(false);
        }
        aLG().setText(cVar.getName());
        aLF().setHintAnimationEnabled(true);
        aLG().setTag(Long.valueOf(cVar.Jf().longValue()));
        aLm();
    }

    private final boolean aLv() {
        return Dh();
    }

    private final boolean aLw() {
        return com.iqoption.app.managers.feature.a.eW("sign-up-show-gdpr-checkbox") && Dh();
    }

    private final boolean Dh() {
        if (this.dMx != null) {
            com.iqoption.core.microservices.configuration.a.c cVar = this.dMx;
            if (cVar == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            return cVar.Dh();
        }
        af DX = af.DX();
        kotlin.jvm.internal.h.d(DX, "Preferences.instance()");
        return DX.Dh();
    }

    protected final boolean aLx() {
        FragmentActivity activity = zzakw();
        if (!(activity instanceof com.iqoption.activity.b)) {
            activity = null;
        }
        com.iqoption.activity.b bVar = (com.iqoption.activity.b) activity;
        if (bVar == null || !bVar.zN()) {
            return false;
        }
        am.a(com.iqoption.core.ext.a.n(this), getView());
        return true;
    }

    protected void aiM() {
        aLx();
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.popBackStack();
        }
    }
}
