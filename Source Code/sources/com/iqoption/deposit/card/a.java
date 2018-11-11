package com.iqoption.deposit.card;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.ui.navigation.j;
import com.iqoption.core.util.p;
import com.iqoption.core.util.r;
import com.iqoption.deposit.card.ScanViewModel.ScanItem;
import com.iqoption.deposit.q;
import io.card.payment.CardIOActivity;
import io.card.payment.CardType;
import io.card.payment.CreditCard;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\b\b&\u0018\u0000 P2\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H&J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\u001c\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0019H&J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H&J\b\u0010$\u001a\u00020\u001cH&J\b\u0010%\u001a\u00020&H\u0004J\b\u0010'\u001a\u00020&H\u0004J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0#H\u0004J\u0012\u0010)\u001a\u00020&2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0004J\b\u0010*\u001a\u00020&H\u0004J\b\u0010+\u001a\u00020\u001cH&J\"\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020\u00152\b\u00103\u001a\u0004\u0018\u000104H\u0016J-\u00105\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.2\u000e\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0019072\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0002\u0010:J\u001a\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020\u0015H\u0002J\b\u0010@\u001a\u00020\u0015H\u0002J\b\u0010A\u001a\u00020BH\u0016J\u0018\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u0019H\u0004J\b\u0010F\u001a\u00020=H&J\b\u0010G\u001a\u00020HH&J\u0010\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u000bH\u0002J\u0010\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020&H&J\b\u0010M\u001a\u00020\u0015H\u0002J\u0010\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020BH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006Q"}, aXE = {"Lcom/iqoption/deposit/card/BaseCardPaymentFragment;", "Lcom/iqoption/deposit/PayFieldsContainerFragment;", "()V", "cardNumberValidator", "Lcom/iqoption/deposit/card/CardNumberValidator;", "cardType", "Lio/card/payment/CardType;", "cardTypeWatcher", "com/iqoption/deposit/card/BaseCardPaymentFragment$cardTypeWatcher$1", "Lcom/iqoption/deposit/card/BaseCardPaymentFragment$cardTypeWatcher$1;", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "getPayMethod", "()Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "setPayMethod", "(Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;)V", "viewModel", "Lcom/iqoption/deposit/card/CardPaymentViewModel;", "cardTypeIcon", "Landroid/widget/ImageView;", "clearFocus", "", "()Lkotlin/Unit;", "collectParams", "", "", "", "cvvEditText", "Landroid/widget/EditText;", "fieldsContainer", "Landroid/view/ViewGroup;", "fillMonthAndYear", "month", "year", "getMonthAndYear", "Lkotlin/Pair;", "holderEditText", "isCvvValid", "", "isHolderValid", "isMonthAndYearValid", "isNewCard", "isNumberValid", "numberEditText", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "Landroid/view/View;", "openScan", "openScanCard", "openScanNfc", "paymentMethodId", "", "reportEventOnFocusOn", "editText", "event", "scanCardView", "scanFragmentNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "setCard", "source", "setMonthAndYearEnabled", "enabled", "updateScanCardButtonVisibility", "vibrate", "milliseconds", "Companion", "deposit_release"})
/* compiled from: BaseCardPaymentFragment.kt */
public abstract class a extends q {
    private static final String TAG = "com.iqoption.deposit.card.a";
    private static final Pattern bVU = Pattern.compile("^[a-zA-Z0-9\\s\\.\\-]{2,}$");
    private static final Pattern bVV = Pattern.compile("^[0-9]{3,4}$");
    public static final a bVW = new a();
    private HashMap atz;
    private final c bVP = new c();
    private PayMethod bVQ;
    private CardPaymentViewModel bVR;
    private CardType bVS = CardType.UNKNOWN;
    private final b bVT = new b(this);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, aXE = {"Lcom/iqoption/deposit/card/BaseCardPaymentFragment$Companion;", "", "()V", "CARDHOLDER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CARD_CVV", "MAX_YEAR_PERIOD", "", "PERMISSION_REQUEST_CODE", "SCAN_REQUEST_CODE", "TAG", "", "getTAG", "()Ljava/lang/String;", "deposit_release"})
    /* compiled from: BaseCardPaymentFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "focused", "", "onFocusChange"})
    /* compiled from: BaseCardPaymentFragment.kt */
    static final class g implements OnFocusChangeListener {
        final /* synthetic */ String bVY;

        g(String str) {
            this.bVY = str;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                com.iqoption.core.f.RQ().Ds().b(this.bVY, 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/deposit/card/BaseCardPaymentFragment$cardTypeWatcher$1", "Lcom/iqoption/core/util/TextWatcherAdapter;", "afterTextChanged", "", "source", "Landroid/text/Editable;", "deposit_release"})
    /* compiled from: BaseCardPaymentFragment.kt */
    public static final class b extends r {
        final /* synthetic */ a bVX;

        b(a aVar) {
            this.bVX = aVar;
        }

        public void afterTextChanged(Editable editable) {
            h.e(editable, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
            super.afterTextChanged(editable);
            CardType gV = com.iqoption.core.util.a.gV(p.v(editable.toString()));
            if (gV == null) {
                gV = CardType.UNKNOWN;
            }
            if (gV != this.bVX.bVS) {
                Drawable d;
                Integer a = com.iqoption.deposit.c.a.a(gV);
                if (a != null) {
                    d = com.iqoption.core.ext.a.d(this.bVX, a.intValue());
                } else {
                    d = null;
                }
                ImageView abh = this.bVX.abh();
                if (d == null) {
                    abh.setVisibility(8);
                } else {
                    abh.setImageDrawable(d);
                    abh.setVisibility(0);
                }
                this.bVX.aaX();
                this.bVX.bVS = gV;
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends com.iqoption.core.ext.g {
        final /* synthetic */ a bVX;

        public c(a aVar) {
            this.bVX = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.bVX.abc();
            if (NfcAdapter.getDefaultAdapter(com.iqoption.core.ext.a.m(this.bVX)) == null) {
                this.bVX.aaV();
            } else {
                j.b(com.iqoption.deposit.navigator.b.cbG.G(this.bVX), this.bVX.abd(), false, 2, null);
            }
            com.iqoption.core.f.RQ().Ds().a("deposit-page_scan-card-number", 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "method", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onChanged"})
    /* compiled from: BaseCardPaymentFragment.kt */
    static final class d<T> implements Observer<PayMethod> {
        final /* synthetic */ a bVX;

        d(a aVar) {
            this.bVX = aVar;
        }

        /* renamed from: h */
        public final void onChanged(PayMethod payMethod) {
            if (payMethod != null) {
                a aVar = this.bVX;
                h.d(payMethod, "it");
                aVar.g(payMethod);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "scanItem", "Lcom/iqoption/deposit/card/ScanViewModel$ScanItem;", "onChanged"})
    /* compiled from: BaseCardPaymentFragment.kt */
    static final class e<T> implements Observer<ScanItem> {
        final /* synthetic */ a bVX;

        e(a aVar) {
            this.bVX = aVar;
        }

        /* renamed from: b */
        public final void onChanged(ScanItem scanItem) {
            if (scanItem != null) {
                switch (scanItem) {
                    case CAMERA:
                        this.bVX.aaV();
                        return;
                    case NFC:
                        this.bVX.aaU();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "nfcCard", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "onChanged"})
    /* compiled from: BaseCardPaymentFragment.kt */
    static final class f<T> implements Observer<com.iqoption.deposit.card.d.a> {
        final /* synthetic */ a bVX;

        f(a aVar) {
            this.bVX = aVar;
        }

        /* renamed from: b */
        public final void onChanged(com.iqoption.deposit.card.d.a aVar) {
            if (aVar != null) {
                this.bVX.vibrate(50);
                this.bVX.abf().setText(aVar.Vg());
                if (!(aVar.abm() == null || aVar.abn() == null)) {
                    this.bVX.ah(aVar.abm(), aVar.abn());
                }
                String abo = aVar.abo();
                if (abo != null) {
                    this.bVX.abi().setText(abo);
                }
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public abstract com.iqoption.core.ui.navigation.h abd();

    public abstract ViewGroup abe();

    public abstract EditText abf();

    public abstract View abg();

    public abstract ImageView abh();

    public abstract EditText abi();

    public abstract EditText abj();

    public abstract Pair<String, String> abk();

    public abstract void ah(String str, String str2);

    public abstract void cs(boolean z);

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
            h.aXZ();
        }
    }

    protected final PayMethod aaT() {
        return this.bVQ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bVR = CardPaymentViewModel.bWe.v(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        abf().addTextChangedListener(this.bVT);
        abg().setOnClickListener(new c(this));
        CardPaymentViewModel cardPaymentViewModel = this.bVR;
        if (cardPaymentViewModel == null) {
            h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        cardPaymentViewModel.aaJ().observe(lifecycleOwner, new d(this));
        cardPaymentViewModel = this.bVR;
        if (cardPaymentViewModel == null) {
            h.lS("viewModel");
        }
        cardPaymentViewModel.aaN().observe(lifecycleOwner, new e(this));
        cardPaymentViewModel = this.bVR;
        if (cardPaymentViewModel == null) {
            h.lS("viewModel");
        }
        cardPaymentViewModel.aaO().observe(lifecycleOwner, new f(this));
    }

    private final void aaU() {
        j.b(com.iqoption.deposit.navigator.b.cbG.G(this), e.bWr.abt(), false, 2, null);
    }

    private final void aaV() {
        if (ContextCompat.checkSelfPermission(com.iqoption.core.ext.a.m(this), "android.permission.CAMERA") == 0) {
            aaW();
        } else {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 255);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        h.e(strArr, "permissions");
        h.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 255) {
            if (((iArr.length == 0 ? 1 : 0) ^ 1) == 0 || iArr[0] != 0) {
                aaW();
            } else {
                aaW();
            }
        }
    }

    private final void aaW() {
        Intent intent = new Intent(com.iqoption.core.ext.a.m(this), CardIOActivity.class);
        intent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true);
        intent.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, true);
        intent.putExtra(CardIOActivity.EXTRA_HIDE_CARDIO_LOGO, true);
        startActivityForResult(intent, 128);
    }

    private final void g(PayMethod payMethod) {
        if (!h.E(this.bVQ, payMethod)) {
            this.bVQ = payMethod;
            if (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.h) {
                abf().removeTextChangedListener(this.bVP);
                com.iqoption.core.ext.a.M(abe());
            } else if (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g) {
                com.iqoption.core.ext.a.L(abe());
                abf().removeTextChangedListener(this.bVP);
                abf().addTextChangedListener(this.bVP);
                CharSequence charSequence = null;
                abf().setText(charSequence);
                if (com.iqoption.core.microservices.billing.response.deposit.e.c(payMethod)) {
                    com.iqoption.core.ext.a.M(abi());
                } else {
                    com.iqoption.core.ext.a.L(abi());
                }
                abi().setText(charSequence);
                ah(null, null);
                abj().setText(charSequence);
                aaX();
                abf().setEnabled(true);
                abi().setEnabled(true);
                cs(true);
                abj().setEnabled(true);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case: ");
                stringBuilder.append(payMethod);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private final void aaX() {
        if (com.iqoption.core.ext.a.I(abh())) {
            com.iqoption.core.ext.a.M(abg());
            return;
        }
        PayMethod payMethod = this.bVQ;
        if (payMethod == null || !com.iqoption.core.microservices.billing.response.deposit.e.d(payMethod)) {
            com.iqoption.core.ext.a.L(abg());
        } else {
            com.iqoption.core.ext.a.M(abg());
        }
    }

    public Map<String, Object> aaR() {
        PayMethod payMethod = this.bVQ;
        Long UR = payMethod != null ? payMethod.UR() : null;
        if (UR != null) {
            return com.iqoption.core.microservices.billing.a.aSZ.aW(UR.longValue());
        }
        String obj = abj().getText().toString();
        Editable text = abf().getText();
        h.d(text, "numberEditText().text");
        String v = p.v(text);
        Pair abk = abk();
        String str = (String) abk.getFirst();
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        int s = com.iqoption.core.ext.c.s(v.trim(str).toString());
        String str2 = (String) abk.aXF();
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        int s2 = com.iqoption.core.ext.c.s(v.trim(str2).toString());
        String obj2 = abi().getText().toString();
        if (s2 < 100) {
            s2 += 2000;
        }
        return com.iqoption.core.microservices.billing.a.aSZ.a(v, obj2, s, s2, obj);
    }

    protected final boolean aaY() {
        return this.bVP.isValid();
    }

    protected final boolean aaZ() {
        boolean z = true;
        if (!com.iqoption.core.ext.a.I(abi())) {
            return true;
        }
        String obj = abi().getText().toString();
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        CharSequence obj2 = v.trim(obj).toString();
        if (TextUtils.isEmpty(obj2) || !bVU.matcher(obj2).matches()) {
            z = false;
        }
        return z;
    }

    protected final Pair<Boolean, Boolean> aba() {
        Pair abk = abk();
        int i = -1;
        int s;
        boolean z;
        try {
            String str = (String) abk.getFirst();
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            s = com.iqoption.core.ext.c.s(v.trim(str).toString());
            z = true;
            boolean z2;
            try {
                String str2 = (String) abk.aXF();
                if (str2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                i = com.iqoption.core.ext.c.s(v.trim(str2).toString());
                z2 = true;
                if (!z || !z2) {
                    return new Pair(Boolean.valueOf(z), Boolean.valueOf(z2));
                }
                if (1 > s || s > 12) {
                    z = false;
                }
                if (i < 100) {
                    i += 2000;
                }
                int i2 = Calendar.getInstance().get(1);
                int i3 = Calendar.getInstance().get(2) + 1;
                if (i == i2 && s < i3) {
                    z2 = false;
                    z = false;
                }
                if (i < i2 || i > i2 + 20) {
                    z2 = false;
                }
                return new Pair(Boolean.valueOf(z), Boolean.valueOf(z2));
            } catch (Exception unused) {
                z2 = false;
            }
        } catch (Exception unused2) {
            z = false;
            s = -1;
        }
    }

    protected final boolean abb() {
        CharSequence obj = abj().getText().toString();
        return !TextUtils.isEmpty(obj) && bVV.matcher(obj).matches();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 128 && intent != null && intent.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
            Parcelable parcelableExtra = intent.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
            h.d(parcelableExtra, "data.getParcelableExtra(…tivity.EXTRA_SCAN_RESULT)");
            CreditCard creditCard = (CreditCard) parcelableExtra;
            abf().setText(creditCard.cardNumber);
            if (creditCard.isExpiryValid()) {
                ah(String.valueOf(creditCard.expiryMonth), String.valueOf(creditCard.expiryYear));
            }
            if (creditCard.cardholderName != null) {
                abi().setText(creditCard.cardholderName);
            }
        }
    }

    private final void vibrate(long j) {
        Object systemService = com.iqoption.core.ext.a.m(this).getSystemService("vibrator");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
        }
        ((Vibrator) systemService).vibrate(j);
    }

    public long aaS() {
        PayMethod payMethod = this.bVQ;
        if (payMethod == null) {
            h.aXZ();
        }
        return (!a(payMethod) || payMethod.UW() == -1) ? payMethod.UQ() : payMethod.UW();
    }

    protected final boolean a(PayMethod payMethod) {
        return payMethod == null || (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g);
    }

    protected final void a(EditText editText, String str) {
        h.e(editText, "editText");
        h.e(str, "event");
        editText.setOnFocusChangeListener(new g(str));
    }

    private final l abc() {
        View view = getView();
        if (view != null) {
            view = view.findFocus();
            if (view != null) {
                view.clearFocus();
                return l.etX;
            }
        }
        return null;
    }
}
