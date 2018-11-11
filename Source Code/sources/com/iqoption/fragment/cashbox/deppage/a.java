package com.iqoption.fragment.cashbox.deppage;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.ge;
import com.iqoption.d.gx;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.entity.billing.CryptoPaymentMethod;
import com.iqoption.util.be;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/DepositPageCryptoBinding;", "hostCallback", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment$HostCallback;", "getHostCallback", "()Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment$HostCallback;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "HostCallback", "PaymentMethodAdapter", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DepositPageCryptoFragment.kt */
public final class a extends com.iqoption.fragment.base.f {
    public static final String TAG = "a";
    public static final a cyG = new a();
    private HashMap atz;
    private gx cyF;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment$Companion;", "", "()V", "MAX_VISIBLE_DROPDOWN_ITEMS", "", "TAG", "", "kotlin.jvm.PlatformType", "fixCryptoName", "name", "get", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageCryptoFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a akK() {
            return new a();
        }

        private final String hM(String str) {
            str = v.b(str, "crypto-", null, 2, null);
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            str = x.b(str, j.bd(1, str.length()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(toUpperCase));
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment$HostCallback;", "", "currency", "", "getCurrency", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageCryptoFragment.kt */
    public interface b {
        String getCurrency();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment$PaymentMethodAdapter;", "Landroid/widget/BaseAdapter;", "layoutInflater", "Landroid/view/LayoutInflater;", "paymentMethods", "", "Lcom/iqoption/dto/entity/billing/CryptoPaymentMethod;", "(Landroid/view/LayoutInflater;Ljava/util/List;)V", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageCryptoFragment.kt */
    public static final class c extends BaseAdapter {
        private final List<CryptoPaymentMethod> cbz;
        private final LayoutInflater layoutInflater;

        public c(LayoutInflater layoutInflater, List<CryptoPaymentMethod> list) {
            h.e(layoutInflater, "layoutInflater");
            h.e(list, "paymentMethods");
            this.layoutInflater = layoutInflater;
            this.cbz = list;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ge j;
            View root;
            h.e(viewGroup, "parent");
            if (view == null) {
                j = ge.j(this.layoutInflater, viewGroup, false);
            } else {
                ViewDataBinding findBinding = DataBindingUtil.findBinding(view);
                if (findBinding == null) {
                    h.aXZ();
                }
                j = (ge) findBinding;
            }
            String a = a.cyG.hM(getItem(i).getName());
            TextView textView = j.aig;
            h.d(textView, "binding.name");
            textView.setText(a);
            int hashCode = a.hashCode();
            if (hashCode != -1354722281) {
                if (hashCode != 78601) {
                    if (hashCode == 1561949438 && a.equals("Bitcoin")) {
                        j.bmu.setImageResource(R.drawable.ic_btc_19_deposit);
                        h.d(j, "binding");
                        root = j.getRoot();
                        h.d(root, "binding.root");
                        return root;
                    }
                } else if (a.equals(Currencies.OTN_CURRENCY)) {
                    j.bmu.setImageResource(R.drawable.ic_otn_19_deposit);
                    h.d(j, "binding");
                    root = j.getRoot();
                    h.d(root, "binding.root");
                    return root;
                }
            } else if (a.equals("Ethereum")) {
                j.bmu.setImageResource(R.drawable.ic_eth_19_deposit);
                h.d(j, "binding");
                root = j.getRoot();
                h.d(root, "binding.root");
                return root;
            }
            j.bmu.setImageResource(R.drawable.ic_iq_19);
            h.d(j, "binding");
            root = j.getRoot();
            h.d(root, "binding.root");
            return root;
        }

        /* renamed from: eS */
        public CryptoPaymentMethod getItem(int i) {
            return (CryptoPaymentMethod) this.cbz.get(i);
        }

        public long getItemId(int i) {
            return ((CryptoPaymentMethod) this.cbz.get(i)).getId();
        }

        public int getCount() {
            return this.cbz.size();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: DepositPageCryptoFragment.kt */
    static final class g implements OnClickListener {
        final /* synthetic */ a cyH;

        g(a aVar) {
            this.cyH = aVar;
        }

        public final void onClick(View view) {
            RobotoTextView robotoTextView = a.a(this.cyH).bqu;
            h.d(robotoTextView, "binding.address");
            String obj = robotoTextView.getText().toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            obj = v.trim(obj).toString();
            if ((((CharSequence) obj).length() > 0 ? 1 : null) != null) {
                be.ag("Address", obj);
                com.iqoption.app.a.b.eP(this.cyH.getString(R.string.address_copied));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/dto/entity/billing/CryptoPaymentMethod;", "onChanged"})
    /* compiled from: DepositPageCryptoFragment.kt */
    static final class d<T> implements Observer<List<? extends CryptoPaymentMethod>> {
        final /* synthetic */ a cyH;
        final /* synthetic */ CryptoViewModel cyI;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\r"}, aXE = {"com/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment$onViewCreated$1$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "adapterView", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: DepositPageCryptoFragment.kt */
        /* renamed from: com.iqoption.fragment.cashbox.deppage.a$d$1 */
        public static final class AnonymousClass1 implements OnItemSelectedListener {
            final /* synthetic */ d cyJ;

            public void onNothingSelected(AdapterView<?> adapterView) {
                h.e(adapterView, "adapterView");
            }

            AnonymousClass1(d dVar) {
                this.cyJ = dVar;
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                h.e(adapterView, "adapterView");
                h.e(view, Promotion.ACTION_VIEW);
                this.cyJ.cyI.bo(j);
            }
        }

        d(a aVar, CryptoViewModel cryptoViewModel) {
            this.cyH = aVar;
            this.cyI = cryptoViewModel;
        }

        /* renamed from: L */
        public final void onChanged(List<CryptoPaymentMethod> list) {
            AppCompatSpinner2 appCompatSpinner2 = a.a(this.cyH).bqx;
            int ef = (int) (((double) this.cyH.ef(R.dimen.dp35)) * 5.5d);
            h.d(appCompatSpinner2, "spinner");
            appCompatSpinner2.setMaxHeight(ef);
            LayoutInflater layoutInflater = this.cyH.getLayoutInflater();
            h.d(layoutInflater, "layoutInflater");
            appCompatSpinner2.setAdapter((SpinnerAdapter) new c(layoutInflater, list != null ? list : m.emptyList()));
            appCompatSpinner2.setOnItemSelectedListener(new AnonymousClass1(this));
            ef = 0;
            if (list != null) {
                for (CryptoPaymentMethod currency : list) {
                    if (currency.getCurrency().equals(this.cyH.akJ().getCurrency())) {
                        break;
                    }
                    ef++;
                }
                ef = -1;
            }
            appCompatSpinner2.setSelection(ef);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/dto/entity/billing/CryptoPaymentMethod;", "onChanged"})
    /* compiled from: DepositPageCryptoFragment.kt */
    static final class e<T> implements Observer<CryptoPaymentMethod> {
        final /* synthetic */ a cyH;
        final /* synthetic */ CryptoViewModel cyI;

        e(a aVar, CryptoViewModel cryptoViewModel) {
            this.cyH = aVar;
            this.cyI = cryptoViewModel;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0110  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0110  */
        /* renamed from: a */
        public final void onChanged(com.iqoption.dto.entity.billing.CryptoPaymentMethod r10) {
            /*
            r9 = this;
            if (r10 != 0) goto L_0x0003;
        L_0x0002:
            return;
        L_0x0003:
            r0 = com.iqoption.fragment.cashbox.deppage.a.cyG;
            r1 = r10.getName();
            r0 = r0.hM(r1);
            r1 = r9.cyH;
            r1 = com.iqoption.fragment.cashbox.deppage.a.a(r1);
            r1 = r1.bqu;
            r2 = "binding.address";
            kotlin.jvm.internal.h.d(r1, r2);
            r2 = r10.getAddress();
            r2 = (java.lang.CharSequence) r2;
            r1.setText(r2);
            r1 = r9.cyH;
            r1 = com.iqoption.fragment.cashbox.deppage.a.a(r1);
            r1 = r1.bqD;
            r2 = "binding.yourCryptoAccount";
            kotlin.jvm.internal.h.d(r1, r2);
            r2 = r9.cyH;
            r3 = 2131822932; // 0x7f110954 float:1.927865E38 double:1.0532604737E-314;
            r4 = 1;
            r5 = new java.lang.Object[r4];
            r6 = r10.getCurrency();
            r7 = 0;
            r5[r7] = r6;
            r2 = r2.getString(r3, r5);
            r2 = (java.lang.CharSequence) r2;
            r1.setText(r2);
            r1 = r9.cyH;
            r1 = com.iqoption.fragment.cashbox.deppage.a.a(r1);
            r1 = r1.agA;
            r2 = "binding.title";
            kotlin.jvm.internal.h.d(r1, r2);
            r2 = r9.cyH;
            r3 = 2131821907; // 0x7f110553 float:1.927657E38 double:1.0532599673E-314;
            r5 = 2;
            r6 = new java.lang.Object[r5];
            r6[r7] = r0;
            r8 = r10.getCurrency();
            r6[r4] = r8;
            r2 = r2.getString(r3, r6);
            r2 = (java.lang.CharSequence) r2;
            r1.setText(r2);
            r1 = r9.cyH;
            r1 = com.iqoption.fragment.cashbox.deppage.a.a(r1);
            r1 = r1.bqC;
            r2 = "binding.warning";
            kotlin.jvm.internal.h.d(r1, r2);
            r2 = r0.hashCode();
            r3 = -1354722281; // 0xffffffffaf409417 float:-1.751491E-10 double:NaN;
            r6 = 2131820722; // 0x7f1100b2 float:1.9274167E38 double:1.053259382E-314;
            if (r2 == r3) goto L_0x00a4;
        L_0x0087:
            r3 = 1561949438; // 0x5d1974fe float:6.9110889E17 double:7.71705558E-315;
            if (r2 == r3) goto L_0x008d;
        L_0x008c:
            goto L_0x00bb;
        L_0x008d:
            r2 = "Bitcoin";
            r2 = r0.equals(r2);
            if (r2 == 0) goto L_0x00bb;
        L_0x0095:
            r2 = r9.cyH;
            r3 = new java.lang.Object[r4];
            r8 = "Bitcoin Cash & Bitcoin Gold";
            r3[r7] = r8;
            r2 = r2.getString(r6, r3);
            r2 = (java.lang.CharSequence) r2;
            goto L_0x00c7;
        L_0x00a4:
            r2 = "Ethereum";
            r2 = r0.equals(r2);
            if (r2 == 0) goto L_0x00bb;
        L_0x00ac:
            r2 = r9.cyH;
            r3 = new java.lang.Object[r4];
            r8 = "Ethereum Classic";
            r3[r7] = r8;
            r2 = r2.getString(r6, r3);
            r2 = (java.lang.CharSequence) r2;
            goto L_0x00c7;
        L_0x00bb:
            r2 = r9.cyH;
            r3 = new java.lang.Object[r4];
            r3[r7] = r0;
            r2 = r2.getString(r6, r3);
            r2 = (java.lang.CharSequence) r2;
        L_0x00c7:
            r1.setText(r2);
            r1 = r9.cyH;
            r1 = com.iqoption.fragment.cashbox.deppage.a.a(r1);
            r1 = r1.bqz;
            r2 = "binding.instruction";
            kotlin.jvm.internal.h.d(r1, r2);
            r2 = r9.cyH;
            r3 = 2131822500; // 0x7f1107a4 float:1.9277773E38 double:1.0532602603E-314;
            r5 = new java.lang.Object[r5];
            r5[r7] = r0;
            r0 = r10.getCurrency();
            r5[r4] = r0;
            r0 = r2.getString(r3, r5);
            r0 = (java.lang.CharSequence) r0;
            r1.setText(r0);
            r0 = r10.getAddress();
            r1 = r9.cyI;
            r1 = r1.akI();
            r1 = r1.getValue();
            r1 = (kotlin.Pair) r1;
            if (r1 == 0) goto L_0x0108;
        L_0x0101:
            r1 = r1.getFirst();
            r1 = (java.lang.String) r1;
            goto L_0x0109;
        L_0x0108:
            r1 = 0;
        L_0x0109:
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            r0 = r0 ^ r4;
            if (r0 == 0) goto L_0x0122;
        L_0x0110:
            r0 = r9.cyI;
            r10 = r10.getAddress();
            r1 = r9.cyH;
            r2 = 2131166159; // 0x7f0703cf float:1.7946555E38 double:1.0529359847E-314;
            r1 = r1.ef(r2);
            r0.K(r10, r1);
        L_0x0122:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.cashbox.deppage.a.e.a(com.iqoption.dto.entity.billing.CryptoPaymentMethod):void");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "onChanged"})
    /* compiled from: DepositPageCryptoFragment.kt */
    static final class f<T> implements Observer<Pair<? extends String, ? extends Bitmap>> {
        final /* synthetic */ a cyH;

        f(a aVar) {
            this.cyH = aVar;
        }

        /* renamed from: a */
        public final void onChanged(Pair<String, Bitmap> pair) {
            a.a(this.cyH).bqA.setImageBitmap(pair != null ? (Bitmap) pair.aXF() : null);
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ gx a(a aVar) {
        gx gxVar = aVar.cyF;
        if (gxVar == null) {
            h.lS("binding");
        }
        return gxVar;
    }

    private final b akJ() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return (b) parentFragment;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.fragment.cashbox.deppage.DepositPageCryptoFragment.HostCallback");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        gx m = gx.m(layoutInflater, viewGroup, false);
        h.d(m, "this");
        this.cyF = m;
        h.d(m, "DepositPageCryptoBinding….apply { binding = this }");
        return m.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        CryptoViewModel cryptoViewModel = (CryptoViewModel) ViewModelProviders.d(com.iqoption.core.ext.a.r(this)).h(CryptoViewModel.class);
        LifecycleOwner lifecycleOwner = this;
        cryptoViewModel.akG().observe(lifecycleOwner, new d(this, cryptoViewModel));
        cryptoViewModel.akH().observe(lifecycleOwner, new e(this, cryptoViewModel));
        cryptoViewModel.akI().observe(lifecycleOwner, new f(this));
        gx gxVar = this.cyF;
        if (gxVar == null) {
            h.lS("binding");
        }
        gxVar.bqu.setOnClickListener(new g(this));
    }
}
