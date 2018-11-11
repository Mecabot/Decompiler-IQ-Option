package com.iqoption.fragment.cashbox.deppage;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner2;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.d.gt;
import com.iqoption.d.hl;
import com.iqoption.dto.Event;
import com.iqoption.fragment.cashbox.d;
import com.iqoption.fragment.cashbox.f;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;
import java.util.ArrayList;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"onSuccess", "", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "invoke"})
/* compiled from: DepositPageFundsFragment.kt */
final class DepositPageFundsFragment$initCurrencies$2 extends Lambda implements m<d, b, l> {
    public static final DepositPageFundsFragment$initCurrencies$2 cyW = new DepositPageFundsFragment$initCurrencies$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u00032\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\u000e¸\u0006\u0000"}, aXE = {"com/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$initCurrencies$2$1$2", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "v", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "adapterView", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageFundsFragment.kt */
    public static final class a implements OnItemSelectedListener {
        final /* synthetic */ d cyX;
        final /* synthetic */ d cyY;
        final /* synthetic */ b cyZ;

        public void onNothingSelected(AdapterView<?> adapterView) {
            h.e(adapterView, "adapterView");
        }

        a(d dVar, d dVar2, b bVar) {
            this.cyX = dVar;
            this.cyY = dVar2;
            this.cyZ = bVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            h.e(adapterView, "parent");
            h.e(view, "v");
            c eO = this.cyX.getItem(i);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "deposit-page_currency-changed").setValue(Double.valueOf((double) eO.getId())).build());
            if (this.cyY.cxy != null) {
                f a = this.cyY.cxy;
                if (a == null) {
                    h.aXZ();
                }
                a.s(Long.valueOf(eO.getId()));
            }
        }
    }

    DepositPageFundsFragment$initCurrencies$2() {
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        b((d) obj, (b) obj2);
        return l.etX;
    }

    public final void b(d dVar, b bVar) {
        h.e(dVar, "$receiver");
        h.e(bVar, "cashboxCounting");
        if (dVar.isAdded()) {
            dVar.aTd = bVar;
            gt b = d.b(dVar);
            ArrayList Td = bVar.Td();
            if (Td == null) {
                h.aXZ();
            }
            Object obj = 1;
            if (Td.size() <= 1) {
                obj = null;
            }
            int i = 8;
            if (obj != null) {
                ConfirmButtonView confirmButtonView = b.bpo;
                h.d(confirmButtonView, "depositButtonSmall");
                confirmButtonView.setVisibility(8);
                AppCompatSpinner2 appCompatSpinner2 = b.bpj;
                h.d(appCompatSpinner2, "currencySpinner");
                appCompatSpinner2.setVisibility(0);
                hl hlVar = b.bqe;
                if (hlVar != null) {
                    TextView textView = hlVar.brc;
                    h.d(textView, "termsText");
                    textView.setText(dVar.akA());
                    LinearLayout linearLayout = hlVar.bra;
                    h.d(linearLayout, "terms");
                    af DX = af.DX();
                    h.d(DX, "Preferences.instance()");
                    linearLayout.setVisibility(DX.Dh() ? 0 : 8);
                    AppCompatCheckBox appCompatCheckBox = hlVar.brb;
                    h.d(appCompatCheckBox, "termsCheckBox");
                    if (!com.iqoption.app.managers.feature.a.eW("hide-deposit-check")) {
                        i = 0;
                    }
                    appCompatCheckBox.setVisibility(i);
                }
                ConfirmButtonView confirmButtonView2 = b.bpI;
                h.d(confirmButtonView2, "depositButton");
                confirmButtonView2.setVisibility(0);
                TextView textView2 = b.bpk;
                h.d(textView2, "currencyTextView");
                textView2.setVisibility(0);
                ImageView imageView = b.bpi;
                h.d(imageView, "currencyCheck");
                imageView.setVisibility(0);
                AppCompatSpinner2 appCompatSpinner22 = b.bpj;
                i = (int) (com.iqoption.core.ext.a.m(dVar).getResources().getDimension(R.dimen.deposit_currency_item_height) * 5.5f);
                h.d(appCompatSpinner22, "spinner");
                appCompatSpinner22.setMaxHeight(i);
                d dVar2 = new d(appCompatSpinner22.getContext(), bVar);
                appCompatSpinner22.setAdapter((SpinnerAdapter) dVar2);
                DepositPageFundsFragment$initCurrencies$1.cyV.a(bVar, appCompatSpinner22, dVar2);
                appCompatSpinner22.setOnItemSelectedListener(new a(dVar2, dVar, bVar));
            } else {
                ConfirmButtonView confirmButtonView3 = b.bpo;
                h.d(confirmButtonView3, "depositButtonSmall");
                confirmButtonView3.setVisibility(0);
                AppCompatSpinner2 appCompatSpinner23 = b.bpj;
                h.d(appCompatSpinner23, "currencySpinner");
                appCompatSpinner23.setVisibility(8);
                hl hlVar2 = b.bqe;
                if (hlVar2 != null) {
                    LinearLayout linearLayout2 = hlVar2.bra;
                    h.d(linearLayout2, "terms");
                    linearLayout2.setVisibility(8);
                }
                confirmButtonView3 = b.bpI;
                h.d(confirmButtonView3, "depositButton");
                confirmButtonView3.setVisibility(8);
                TextView textView3 = b.bpk;
                h.d(textView3, "currencyTextView");
                textView3.setVisibility(8);
                ImageView imageView2 = b.bpi;
                h.d(imageView2, "currencyCheck");
                imageView2.setVisibility(8);
            }
        }
    }
}
