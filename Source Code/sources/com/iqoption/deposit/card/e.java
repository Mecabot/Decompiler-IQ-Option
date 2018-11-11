package com.iqoption.deposit.card;

import android.app.PendingIntent;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.g;
import com.airbnb.lottie.r;
import com.iqoption.core.f;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.a.ce;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"Lcom/iqoption/deposit/card/NfcScanFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "Lcom/iqoption/core/ui/fragment/FragmentNewIntent;", "()V", "adapter", "Landroid/nfc/NfcAdapter;", "binding", "Lcom/iqoption/deposit/databinding/NfcScanFragmentBinding;", "navigator", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "getNavigator", "()Lcom/iqoption/core/ui/navigation/StackNavigator;", "navigator$delegate", "Lkotlin/Lazy;", "scanViewModel", "Lcom/iqoption/deposit/card/ScanViewModel;", "scanner", "Lcom/iqoption/deposit/card/NfcCardScanner;", "initViews", "", "loadAnim", "path", "", "loadCallback", "Lkotlin/Function1;", "Lcom/airbnb/lottie/LottieComposition;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFirstAnimationComplete", "onNewIntent", "", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showNfcSettingsDialog", "Companion", "deposit_release"})
/* compiled from: NfcScanFragment.kt */
public final class e extends com.iqoption.core.ui.fragment.b implements com.iqoption.core.ui.fragment.a {
    private static final String TAG = "com.iqoption.deposit.card.e";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "navigator", "getNavigator()Lcom/iqoption/core/ui/navigation/StackNavigator;"))};
    public static final a bWr = new a();
    private HashMap atz;
    private NfcAdapter bWm;
    private ScanViewModel bWn;
    private ce bWo;
    private final d bWp = new d();
    private final kotlin.d bWq = g.f(new NfcScanFragment$navigator$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, aXE = {"Lcom/iqoption/deposit/card/NfcScanFragment$Companion;", "", "()V", "FIRST_ANIM_PATH", "", "SECOND_ANIM_PATH", "TAG", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "deposit_release"})
    /* compiled from: NfcScanFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return e.TAG;
        }

        public final h abt() {
            return new h(Ll(), e.class, null, 0, 0, 0, 0, 124, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "onCompositionLoaded"})
    /* compiled from: NfcScanFragment.kt */
    static final class b implements r {
        final /* synthetic */ kotlin.jvm.a.b bWv;

        b(kotlin.jvm.a.b bVar) {
            this.bWv = bVar;
        }

        public final void a(g gVar) {
            if (gVar != null) {
                kotlin.jvm.a.b bVar = this.bWv;
                kotlin.jvm.internal.h.d(gVar, "it");
                bVar.invoke(gVar);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "nfcCardResource", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "onChanged"})
    /* compiled from: NfcScanFragment.kt */
    static final class c<T> implements Observer<com.iqoption.core.ui.c<com.iqoption.deposit.card.d.a>> {
        final /* synthetic */ e this$0;

        c(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<com.iqoption.deposit.card.d.a> cVar) {
            if (cVar != null) {
                switch (cVar.Yt()) {
                    case LOADING:
                        return;
                    case ERROR:
                        f.a(com.iqoption.deposit.r.h.unknown_error_occurred, 0, 2, null);
                        this.this$0.YT().pop();
                        return;
                    case SUCCESS:
                        if (cVar.getData() != null) {
                            ScanViewModel b = e.b(this.this$0);
                            Object data = cVar.getData();
                            if (data == null) {
                                kotlin.jvm.internal.h.aXZ();
                            }
                            b.d((com.iqoption.deposit.card.d.a) data);
                        } else {
                            f.a(com.iqoption.deposit.r.h.unknown_error_occurred, 0, 2, null);
                        }
                        this.this$0.YT().pop();
                        return;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, aXE = {"com/iqoption/deposit/card/NfcScanFragment$showNfcSettingsDialog$dialog$1", "Lcom/iqoption/dialogs/SimpleDialog$Config;", "actionConfig1", "Lcom/iqoption/dialogs/SimpleDialog$ActionConfig;", "getActionConfig1", "()Lcom/iqoption/dialogs/SimpleDialog$ActionConfig;", "actionConfig2", "getActionConfig2", "text", "", "getText", "()Ljava/lang/CharSequence;", "title", "getTitle", "deposit_release"})
    /* compiled from: NfcScanFragment.kt */
    public static final class d implements com.iqoption.dialogs.e.c {
        final /* synthetic */ e this$0;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, aXE = {"com/iqoption/deposit/card/NfcScanFragment$showNfcSettingsDialog$dialog$1$actionConfig1$1", "Lcom/iqoption/dialogs/SimpleDialog$ActionConfig;", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "onClick", "", "dialog", "Lcom/iqoption/dialogs/SimpleDialog;", "deposit_release"})
        /* compiled from: NfcScanFragment.kt */
        public static final class a implements com.iqoption.dialogs.e.a {
            final /* synthetic */ d bWw;

            a(d dVar) {
                this.bWw = dVar;
            }

            public CharSequence getLabel() {
                String string = this.bWw.this$0.getString(com.iqoption.deposit.r.h.ok);
                kotlin.jvm.internal.h.d(string, "getString(R.string.ok)");
                return string;
            }

            public void a(com.iqoption.dialogs.e eVar) {
                kotlin.jvm.internal.h.e(eVar, "dialog");
                FragmentActivity activity = this.bWw.this$0.zzakw();
                if (activity != null) {
                    activity.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                }
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, aXE = {"com/iqoption/deposit/card/NfcScanFragment$showNfcSettingsDialog$dialog$1$actionConfig2$1", "Lcom/iqoption/dialogs/SimpleDialog$ActionConfig;", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "onClick", "", "dialog", "Lcom/iqoption/dialogs/SimpleDialog;", "deposit_release"})
        /* compiled from: NfcScanFragment.kt */
        public static final class b implements com.iqoption.dialogs.e.a {
            final /* synthetic */ d bWw;

            b(d dVar) {
                this.bWw = dVar;
            }

            public CharSequence getLabel() {
                String string = this.bWw.this$0.getString(com.iqoption.deposit.r.h.cancel);
                kotlin.jvm.internal.h.d(string, "getString(R.string.cancel)");
                return string;
            }

            public void a(com.iqoption.dialogs.e eVar) {
                kotlin.jvm.internal.h.e(eVar, "dialog");
                if (this.bWw.this$0.isAdded()) {
                    this.bWw.this$0.YT().pop();
                }
            }
        }

        d(e eVar) {
            this.this$0 = eVar;
        }

        public CharSequence abx() {
            return com.iqoption.dialogs.e.c.a.b(this);
        }

        public void onDismiss() {
            com.iqoption.dialogs.e.c.a.c(this);
        }

        public CharSequence getTitle() {
            String string = this.this$0.getString(com.iqoption.deposit.r.h.nfc_disabled);
            kotlin.jvm.internal.h.d(string, "getString(R.string.nfc_disabled)");
            return string;
        }

        public CharSequence getText() {
            String string = this.this$0.getString(com.iqoption.deposit.r.h.please_turn_on_nfc);
            kotlin.jvm.internal.h.d(string, "getString(R.string.please_turn_on_nfc)");
            return string;
        }

        public com.iqoption.dialogs.e.a abv() {
            return new a(this);
        }

        public com.iqoption.dialogs.e.a abw() {
            return new b(this);
        }
    }

    private final com.iqoption.core.ui.navigation.j YT() {
        kotlin.d dVar = this.bWq;
        j jVar = apP[0];
        return (com.iqoption.core.ui.navigation.j) dVar.getValue();
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

    public static final /* synthetic */ ScanViewModel b(e eVar) {
        ScanViewModel scanViewModel = eVar.bWn;
        if (scanViewModel == null) {
            kotlin.jvm.internal.h.lS("scanViewModel");
        }
        return scanViewModel;
    }

    public static final /* synthetic */ ce c(e eVar) {
        ce ceVar = eVar.bWo;
        if (ceVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return ceVar;
    }

    static {
        if (e.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bWm = NfcAdapter.getDefaultAdapter(getContext());
        this.bWn = ScanViewModel.bWx.w(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        if (this.bWm == null) {
            YT().pop();
        }
        this.bWo = (ce) com.iqoption.core.ext.a.a((Fragment) this, com.iqoption.deposit.r.g.nfc_scan_fragment, viewGroup, false, 4, null);
        abr();
        ce ceVar = this.bWo;
        if (ceVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return ceVar.getRoot();
    }

    public void onResume() {
        super.onResume();
        NfcAdapter nfcAdapter = this.bWm;
        if (nfcAdapter == null) {
            return;
        }
        if (nfcAdapter.isEnabled()) {
            IntentFilter[] intentFilterArr = new IntentFilter[]{new IntentFilter("android.nfc.action.TECH_DISCOVERED"), new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
            String[][] strArr = new String[1][];
            strArr[0] = new String[]{NfcA.class.getName(), IsoDep.class.getName(), NfcB.class.getName()};
            strArr = strArr;
            nfcAdapter.enableForegroundDispatch(zzakw(), PendingIntent.getActivity(com.iqoption.core.ext.a.n(this), 0, new Intent(com.iqoption.core.ext.a.n(this), com.iqoption.core.ext.a.n(this).getClass()).addFlags(536870912), 0), intentFilterArr, strArr);
            return;
        }
        abq();
    }

    public void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = this.bWm;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(zzakw());
        }
    }

    public boolean r(Intent intent) {
        kotlin.jvm.internal.h.e(intent, "intent");
        if (!this.bWp.s(intent)) {
            return false;
        }
        this.bWp.t(intent).observe(this, new c(this));
        return true;
    }

    private final void abq() {
        com.iqoption.core.ext.a.p(this).beginTransaction().add(com.iqoption.deposit.r.f.nfcScanTitle, com.iqoption.dialogs.e.ckL.a(new d(this)), com.iqoption.dialogs.e.ckL.Ll()).commitAllowingStateLoss();
    }

    private final void abr() {
        String string = getString(com.iqoption.deposit.r.h.tip);
        String string2 = getString(com.iqoption.deposit.r.h.tip_nfc_n1, string);
        CharSequence charSequence = string2;
        SpannableString spannableString = new SpannableString(charSequence);
        StyleSpan styleSpan = new StyleSpan(1);
        kotlin.jvm.internal.h.d(string2, "fullString");
        kotlin.jvm.internal.h.d(string, "tipString");
        spannableString.setSpan(styleSpan, v.a(charSequence, string, 0, false, 6, null), string.length(), 17);
        ce ceVar = this.bWo;
        if (ceVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView = ceVar.caz;
        kotlin.jvm.internal.h.d(textView, "binding.tipText");
        textView.setText(spannableString);
        e("lottie/nfc/nfc_1.json", new NfcScanFragment$initViews$1(this));
    }

    private final void abs() {
        ce ceVar = this.bWo;
        if (ceVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ViewCompat.animate(ceVar.caz).alpha(1.0f).setDuration(200).start();
        e("lottie/nfc/nfc_2.json", new NfcScanFragment$onFirstAnimationComplete$1(this));
    }

    private final void e(String str, kotlin.jvm.a.b<? super g, l> bVar) {
        com.airbnb.lottie.g.a.a(getContext(), str, (r) new b(bVar));
    }
}
