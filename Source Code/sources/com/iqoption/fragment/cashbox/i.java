package com.iqoption.fragment.cashbox;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatSpinner2.OnSpinnerEventsListener;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.e;
import com.iqoption.core.microservices.billing.response.deposit.h;
import com.iqoption.core.util.p;
import com.iqoption.d.fu;
import com.iqoption.d.fw;
import com.iqoption.d.fy;
import com.iqoption.d.ga;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.f;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.util.am;
import com.iqoption.view.text.x;
import com.iqoption.widget.helper.ErrorBubbleHelper;
import com.iqoption.widget.helper.ErrorBubbleHelper.BubbleGravity;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* compiled from: DepositNativePaymentFragment */
public class i extends f {
    public static final String TAG = "com.iqoption.fragment.cashbox.i";
    private String aTJ;
    @NonNull
    private PayMethod bVQ;
    private fw boS;
    private String currency;
    private double cwW;
    private boolean cwX;
    private int cwY;
    private int cwZ;
    private String cwq;
    private int cxa;
    private fy cxb;
    private ga cxc;
    private boolean cxd;
    private fu cxe;
    private Builder cxf;
    private o cxg;
    private o cxh;
    private o cxi;
    private ErrorBubbleHelper cxj;

    /* compiled from: DepositNativePaymentFragment */
    public interface a {
        void a(com.iqoption.mobbtech.connect.response.i iVar);

        void aay();
    }

    /* compiled from: DepositNativePaymentFragment */
    private static class b extends com.iqoption.system.c.b<i, com.iqoption.mobbtech.connect.response.i> {
        public b(i iVar) {
            super((Object) iVar);
        }

        /* renamed from: a */
        public void z(i iVar, com.iqoption.mobbtech.connect.response.i iVar2) {
            iVar.cxc.boU.f(false, false);
            a a = iVar.akx();
            if (a != null) {
                a.a(iVar2);
            }
        }

        /* renamed from: a */
        public void c(i iVar, Throwable th) {
            iVar.cxc.boU.f(false, false);
            a a = iVar.akx();
            com.iqoption.mobbtech.connect.response.i iVar2 = (com.iqoption.mobbtech.connect.response.i) MobbErrorException.a(com.iqoption.mobbtech.connect.response.i.class, th);
            if (a != null) {
                a.a(iVar2);
            }
        }
    }

    public static i a(@NonNull PayMethod payMethod, String str, String str2, double d, String str3, boolean z) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_PAY_METHOD", payMethod);
        bundle.putString("ARG_CURRENCY", str);
        bundle.putString("ARG_CURRENCY_SYMBOL", str2);
        bundle.putDouble("ARG_DEPOSIT", d);
        bundle.putString("ARG_BONUS_CODE", str3);
        bundle.putBoolean("ARG_3DS_PAYMENT", z);
        iVar.setArguments(bundle);
        return iVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.bVQ = (PayMethod) bundle.getParcelable("ARG_PAY_METHOD");
            this.currency = bundle.getString("ARG_CURRENCY", "");
            this.cwq = bundle.getString("ARG_CURRENCY_SYMBOL", "");
            this.cwW = bundle.getDouble("ARG_DEPOSIT");
            this.aTJ = bundle.getString("ARG_BONUS_CODE", "");
            this.cwX = bundle.getBoolean("ARG_3DS_PAYMENT");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cxb = (fy) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_card_processing_page, viewGroup, false);
        this.cxj = new ErrorBubbleHelper(getContext(), getLayoutInflater(null));
        this.cxb.boF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                com.iqoption.activity.b ajV = i.this.ajV();
                if (ajV == null || !ajV.zN()) {
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deposit-by-card_back").build());
                    a a = i.this.akx();
                    if (a != null) {
                        a.aay();
                    }
                    return;
                }
                am.a(i.this.zzakw(), view);
            }
        });
        this.cxc = (ga) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_card_view, this.cxb.boE, true);
        this.cxc.boT.setText(getContext().getString(R.string.in_total_card_processing, new Object[]{w(this.cwW)}));
        this.cxc.boU.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!i.this.cxd) {
                    i.this.akv();
                }
            }
        });
        this.cxe = this.cxc.boK;
        this.boS = this.cxc.boS;
        this.cxe.boi.setPreventCornerOverlap(false);
        this.boS.bou.setPreventCornerOverlap(false);
        this.boS.bor.setKeyListener(DigitsKeyListener.getInstance("0123456789 "));
        this.boS.bor.setInputType(3);
        this.boS.bor.addTextChangedListener(new com.iqoption.view.text.f() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                super.beforeTextChanged(charSequence, i, i2, i3);
                i.this.aX(i.this.boS.bor);
            }
        });
        this.boS.bon.addTextChangedListener(new x() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                super.beforeTextChanged(charSequence, i, i2, i3);
                i.this.aX(i.this.boS.bon);
            }
        });
        int dimension = (int) (getContext().getResources().getDimension(R.dimen.deposit_card_item_height) * 4.6f);
        this.cxa = Calendar.getInstance().get(2) + 1;
        SpinnerAdapter eP = eP(1);
        this.boS.boz.setMaxHeight(dimension);
        this.boS.boz.setAdapter(eP);
        this.boS.boz.setOnSpinnerEventsListener(new OnSpinnerEventsListener() {
            public void onSpinnerClosed() {
            }

            public void onSpinnerOpened() {
                i.this.aX(i.this.boS.boz);
            }
        });
        this.boS.boz.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "deposit-by-card_expiry-month").build());
            }
        });
        this.cwY = Calendar.getInstance().get(1);
        this.cwZ = this.cwY;
        eP = eQ(this.cwY);
        this.boS.boD.setMaxHeight(dimension);
        this.boS.boD.setAdapter(eP);
        this.boS.boD.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "deposit-by-card_expiry-year").build());
                int intValue = Integer.valueOf(adapterView.getItemAtPosition(i).toString()).intValue();
                int e = i.this.akt();
                if (i.this.cwZ != intValue) {
                    if (i.this.cwZ == i.this.cwY || intValue == i.this.cwY) {
                        SpinnerAdapter a = i.this.eP(1);
                        e = intValue == i.this.cwY ? e < i.this.cxa ? 0 : e - i.this.cxa : e - 1;
                        i.this.boS.boz.setAdapter(a);
                        i.this.boS.boz.setSelection(e);
                    }
                    i.this.cwZ = intValue;
                }
            }
        });
        this.cxe.bol.addTextChangedListener(new x() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                super.beforeTextChanged(charSequence, i, i2, i3);
                i.this.aX(i.this.cxe.bol);
            }

            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                CharSequence obj = editable.toString();
                CharSequence v = p.v(obj);
                if (!v.equals(obj)) {
                    editable.replace(0, editable.length(), v);
                }
            }
        });
        CharSequence string = getString(R.string.card_details_are_protected_pci_dss);
        Object obj = "PCI DSS";
        CharSequence spannableString = new SpannableString(string);
        dimension = TextUtils.indexOf(string, obj);
        if (dimension != -1) {
            spannableString.setSpan(new StyleSpan(1), dimension, obj.length() + dimension, 33);
        }
        this.cxc.boN.setText(spannableString);
        String string2 = getString(R.string.secure_credit_card_payment_ssl);
        int indexOf = TextUtils.indexOf(string2, "\n");
        if (indexOf != -1) {
            string = string2.substring(0, indexOf);
            CharSequence spannableString2 = new SpannableString(string2.replace(string, string.toUpperCase()));
            spannableString2.setSpan(new StyleSpan(1), 0, indexOf, 33);
            this.cxc.boO.setText(spannableString2);
        } else {
            this.cxc.boO.setText(R.string.secure_credit_card_payment_ssl);
        }
        this.cxg = new o(this.boS.bor, "deposit-by-card_card-number");
        this.cxh = new o(this.boS.bon, "deposit-by-card_cardholder");
        this.cxi = new o(this.cxe.bol, "deposit-by-card_cvv");
        this.cxb.boE.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                i.this.akr();
                return false;
            }
        });
        this.cxc.boP.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                i.this.akr();
            }
        });
        this.cxc.boQ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                am.n(i.this.zzakw());
            }
        });
        akp();
        return this.cxb.getRoot();
    }

    private void akp() {
        h akq = akq();
        if (akq != null) {
            if (!TextUtils.isEmpty(akq.getName())) {
                this.boS.bos.setText(akq.getName());
                this.boS.bos.setVisibility(0);
                this.boS.bor.setVisibility(4);
            }
            if (akq.Vc() != -1) {
                this.boS.boy.setText(String.valueOf(akq.Vc()));
                this.boS.boy.setVisibility(0);
                this.boS.boz.setVisibility(4);
            }
            if (akq.Vd() != -1) {
                this.boS.boC.setText(String.valueOf(akq.Vd()));
                this.boS.boC.setVisibility(0);
                this.boS.boD.setVisibility(4);
            }
            if (!TextUtils.isEmpty(akq.Ve())) {
                this.boS.boo.setText(akq.Ve());
                this.boS.boo.setVisibility(0);
                this.boS.bon.setVisibility(4);
            }
            this.cxe.bol.setBackgroundResource(R.drawable.deposit_card_green_border);
            this.cxe.bol.requestFocus();
        } else {
            this.boS.bor.setVisibility(0);
            this.boS.boz.setVisibility(0);
            this.boS.boD.setVisibility(0);
            this.boS.bos.setVisibility(8);
            this.boS.boy.setVisibility(8);
            this.boS.boC.setVisibility(8);
            this.boS.boo.setVisibility(8);
            this.cxe.bol.setBackgroundResource(R.drawable.deposit_card_white_border);
            if (e.c(this.bVQ)) {
                this.boS.bop.setVisibility(4);
                this.boS.bon.setVisibility(4);
            } else {
                this.boS.bop.setVisibility(0);
                this.boS.bon.setVisibility(0);
            }
        }
        if (this.cwX) {
            this.cxc.boU.setButtonText(R.string.pay_with_3ds);
            this.cxc.boU.setButtonLeftImageSrc(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lock_card_pay, getContext().getTheme()));
        } else {
            this.cxc.boU.setButtonText(R.string.pay);
            this.cxc.boU.setButtonLeftImageSrc(null);
        }
        if (this.cwX && akq == null) {
            this.cxc.boR.setVisibility(0);
        } else {
            this.cxc.boR.setVisibility(8);
        }
    }

    @Nullable
    private h akq() {
        return this.bVQ instanceof h ? (h) this.bVQ : null;
    }

    public boolean onBackPressed() {
        com.iqoption.activity.b ajV = ajV();
        if (ajV == null || !ajV.zN()) {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deposit-by-card_back").build());
            a akx = akx();
            if (akx != null) {
                akx.aay();
            }
            return super.aN();
        }
        am.a(zzakw(), aks().getRoot());
        return true;
    }

    public void onResume() {
        super.onResume();
        this.cxf = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "deposit-by-card");
    }

    public void onPause() {
        super.onPause();
        this.cxe.bol.setText("");
        akr();
        EventManager.Bm().a(this.cxf.calcDuration().build());
    }

    private void akr() {
        this.cxj.akr();
        this.cxc.boP.setVisibility(8);
    }

    fy aks() {
        return this.cxb;
    }

    private void aX(View view) {
        if (Boolean.TRUE.equals(view.getTag(R.id.errorTag))) {
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundResource(this.bVQ instanceof h ? R.drawable.deposit_card_green_border : R.drawable.deposit_card_white_border);
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            view.setTag(R.id.errorTag, Boolean.valueOf(false));
        }
    }

    private int akt() {
        return Integer.valueOf(this.boS.boz.getSelectedItem().toString()).intValue();
    }

    private int aku() {
        return Integer.valueOf(this.boS.boD.getSelectedItem().toString()).intValue();
    }

    @NonNull
    private ArrayAdapter<String> eP(int i) {
        List arrayList = new ArrayList();
        while (i <= 12) {
            arrayList.add(String.format(Locale.US, "%02d", new Object[]{Integer.valueOf(i)}));
            i++;
        }
        return new ArrayAdapter(getContext(), R.layout.deposit_month_item, arrayList);
    }

    @NonNull
    private ArrayAdapter<String> eQ(int i) {
        List arrayList = new ArrayList();
        for (int i2 = i; i2 <= i + 20; i2++) {
            arrayList.add(Integer.toString(i2));
        }
        return new ArrayAdapter(getContext(), R.layout.deposit_year_item, arrayList);
    }

    private void akv() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deposit-by-card_pay").build());
        this.cxd = true;
        if (akw()) {
            this.cxc.boU.f(true, false);
            try {
                int akt;
                int aku;
                String v;
                final h akq = akq();
                if (akq == null || akq.Vc() == -1) {
                    akt = akt();
                } else {
                    akt = akq.Vc();
                }
                final int i = akt;
                if (akq == null || akq.Vd() == -1) {
                    aku = aku();
                } else {
                    aku = akq.Vd();
                }
                final int i2 = aku;
                final String obj = this.cxe.bol.getText().toString();
                if (akq == null || TextUtils.isEmpty(akq.getName())) {
                    v = p.v(this.boS.bor.getText());
                } else {
                    v = akq.getName();
                }
                final String str = v;
                if (akq == null || TextUtils.isEmpty(akq.Ve())) {
                    v = this.boS.bon.getText().toString();
                } else {
                    v = akq.Ve();
                }
                final String str2 = v;
                o.a(o.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM("DepositNativePaymentFragment, deposit by card pay processing"), new g<com.iqoption.core.microservices.billing.response.b.a, com.iqoption.mobbtech.connect.response.i>() {
                    /* renamed from: d */
                    public s<com.iqoption.mobbtech.connect.response.i> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
                        String str = i.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("process: ");
                        stringBuilder.append(i.this.cwW);
                        stringBuilder.append(i.this.currency);
                        stringBuilder.append(" date:");
                        stringBuilder.append(i);
                        stringBuilder.append(" ");
                        stringBuilder.append(i);
                        stringBuilder.append(" ");
                        stringBuilder.append(str2);
                        com.iqoption.core.i.v(str, stringBuilder.toString());
                        return com.iqoption.mobbtech.connect.request.api.b.a(i.this.getContext(), aVar.getHost(), aVar.Uy(), i.this.bVQ.UQ(), i.this.currency, Double.valueOf(i.this.cwW), i.this.aTJ, i, i2, obj, str, str2, i.this.cwX ? akq.Vf() : -1);
                    }
                }), new b(this), com.iqoption.core.d.a.aSe);
            } catch (Throwable e) {
                com.iqoption.core.i.e(TAG, "process error", e);
                this.cxc.boU.f(false, false);
            } catch (Throwable th) {
                this.cxd = false;
            }
            this.cxd = false;
            return;
        }
        this.cxd = false;
    }

    private boolean akw() {
        int paddingLeft;
        int paddingTop;
        int paddingRight;
        int paddingBottom;
        boolean hL = hL(this.cxe.bol.getText().toString());
        if (this.boS.bos.getVisibility() != 0) {
            String v = p.v(this.boS.bor.getText());
            if (v.length() < 12 || v.length() > 19 || !b.hJ(v)) {
                paddingLeft = this.boS.bor.getPaddingLeft();
                paddingTop = this.boS.bor.getPaddingTop();
                paddingRight = this.boS.bor.getPaddingRight();
                paddingBottom = this.boS.bor.getPaddingBottom();
                this.boS.bor.setBackgroundResource(R.drawable.deposit_card_red_border);
                this.boS.bor.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                this.boS.bor.setTag(R.id.errorTag, Boolean.valueOf(true));
                if (hL) {
                    this.cxj.a(this.boS.bor, BubbleGravity.right);
                    this.cxc.boP.setVisibility(0);
                }
                hL = false;
            }
        }
        if (this.boS.boy.getVisibility() != 0) {
            paddingLeft = akt();
            if (aku() == this.cwY && paddingLeft < this.cxa) {
                this.boS.boz.setBackgroundResource(R.drawable.deposit_card_red_border);
                this.boS.boz.setTag(R.id.errorTag, Boolean.valueOf(true));
                if (hL) {
                    this.cxj.a(this.boS.boz, BubbleGravity.right);
                    this.cxc.boP.setVisibility(0);
                }
                hL = false;
            }
        }
        if (this.boS.bon.getVisibility() != 0) {
            return hL;
        }
        CharSequence obj = this.boS.bon.getText().toString();
        if (!TextUtils.isEmpty(obj) && b.bVU.matcher(obj).matches()) {
            return hL;
        }
        paddingLeft = this.boS.bon.getPaddingLeft();
        paddingTop = this.boS.bon.getPaddingTop();
        paddingRight = this.boS.bon.getPaddingRight();
        paddingBottom = this.boS.bon.getPaddingBottom();
        this.boS.bon.setBackgroundResource(R.drawable.deposit_card_red_border);
        this.boS.bon.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        this.boS.bon.setTag(R.id.errorTag, Boolean.valueOf(true));
        if (hL) {
            this.cxj.a(this.boS.bon, BubbleGravity.right);
            this.cxc.boP.setVisibility(0);
        }
        return false;
    }

    private boolean hL(String str) {
        if (!TextUtils.isEmpty(str) && b.bVV.matcher(str).matches()) {
            return true;
        }
        this.cxe.bol.setBackgroundResource(R.drawable.deposit_card_red_border);
        this.cxe.bol.setTag(R.id.errorTag, Boolean.valueOf(true));
        this.cxj.a(this.cxe.bol, BubbleGravity.left);
        this.cxc.boP.setVisibility(0);
        return false;
    }

    private String w(double d) {
        return String.format(Locale.US, "%s%s", new Object[]{this.cwq, b.h(Double.valueOf(d))});
    }

    private a akx() {
        if (getContext() instanceof a) {
            return (a) getContext();
        }
        return getTargetFragment() instanceof a ? (a) getTargetFragment() : null;
    }
}
