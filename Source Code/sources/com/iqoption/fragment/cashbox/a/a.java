package com.iqoption.fragment.cashbox.a;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty;
import com.iqoption.core.microservices.billing.response.extraparams.c;
import com.iqoption.core.microservices.billing.response.extraparams.d;
import com.iqoption.d.fy;
import com.iqoption.d.gc;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.f;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.mobbtech.connect.response.i;
import com.iqoption.util.am;
import com.iqoption.util.k;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: DepositPaymentConstructorFragment */
public class a extends f {
    public static final String TAG = "com.iqoption.fragment.cashbox.a.a";
    private String aTJ;
    private g aTK;
    private boolean adF;
    @Nullable
    private ConfirmButtonView boU;
    private String currency;
    private double cwW;
    private fy cxb;
    private boolean cxd;
    @Nullable
    private Builder cxf;
    private gc cye;
    private ArrayList<h> cyf = new ArrayList();
    private int cyg;
    private String cyh = "";

    /* compiled from: DepositPaymentConstructorFragment */
    public interface a {
        void aaz();

        void b(i iVar);
    }

    /* compiled from: DepositPaymentConstructorFragment */
    private static class b extends com.iqoption.system.c.b<a, i> {
        private final String currency;
        private final String paymentMethod;

        public b(a aVar, String str, String str2) {
            super((Object) aVar);
            this.paymentMethod = str;
            this.currency = str2;
        }

        /* renamed from: a */
        public void z(a aVar, i iVar) {
            if (aVar.boU != null) {
                aVar.boU.f(false, false);
            }
            a b = aVar.akE();
            if (b != null) {
                b.b(iVar);
            }
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error during processing the card payment paymentMethod=");
            stringBuilder.append(this.paymentMethod);
            stringBuilder.append(", currency=");
            stringBuilder.append(this.currency);
            com.crashlytics.android.a.log(stringBuilder.toString());
            k.c(th);
            if (aVar.boU != null) {
                aVar.boU.f(false, false);
            }
            if (!b(aVar, th)) {
                a b = aVar.akE();
                if (b != null) {
                    b.b(null);
                }
            }
        }

        private boolean b(a aVar, Throwable th) {
            if (aVar.adF && (th instanceof MobbErrorException)) {
                MobbErrorException mobbErrorException = (MobbErrorException) th;
                if (mobbErrorException.auU() != null && (mobbErrorException.auU().auT() instanceof i)) {
                    i iVar = (i) mobbErrorException.auU().auT();
                    if (!(iVar.cVR == null || iVar.cVR.cVT == null || iVar.cVR.cVT.aTl == null)) {
                        aVar.c(iVar.cVR.cVT.aTl);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static a a(g gVar, String str, double d, String str2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_PAYMENT_METHOD", gVar);
        bundle.putString("ARG_CURRENCY", str);
        bundle.putDouble("ARG_DEPOSIT", d);
        bundle.putString("ARG_BONUS_CODE", str2);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.aTK = (g) getArguments().getParcelable("ARG_PAYMENT_METHOD");
            this.currency = getArguments().getString("ARG_CURRENCY", "");
            this.cwW = getArguments().getDouble("ARG_DEPOSIT");
            this.aTJ = getArguments().getString("ARG_BONUS_CODE", "");
            this.cyh = b(this.aTK);
        }
    }

    @Nullable
    private static String b(g gVar) {
        String name = gVar.getName();
        return name != null ? name.trim().toLowerCase().replaceAll("[ \\/]", "-") : name;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cyg = (int) getContext().getResources().getDimension(R.dimen.deposit_payment_constructor_gap);
        this.cxb = (fy) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_card_processing_page, viewGroup, false);
        this.cxb.boF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EventManager Bm = EventManager.Bm();
                String str = Event.CATEGORY_BUTTON_PRESSED;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deposit-by-");
                stringBuilder.append(a.this.cyh);
                stringBuilder.append("_back");
                Bm.a(Event.Builder(str, stringBuilder.toString()).build());
                a b = a.this.akE();
                if (b != null) {
                    b.aaz();
                }
            }
        });
        boolean z = true;
        this.cye = (gc) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_constructor_view, this.cxb.boE, true);
        String name = this.aTK.getName();
        this.cye.boX.setText(name);
        Object obj = (name == null || !name.toLowerCase().contains("neteller")) ? null : 1;
        if (name == null || !name.toLowerCase().contains("qiwi")) {
            z = false;
        }
        this.cxb.boE.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a.this.akr();
                return false;
            }
        });
        this.cye.boW.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.akr();
            }
        });
        this.cye.boQ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                am.n(a.this.zzakw());
            }
        });
        if (!(this.aTK.Va() == null || this.aTK.Va().Vo() == null)) {
            Iterator it;
            String str;
            String str2;
            StringBuilder stringBuilder;
            if (this.aTK.Va().Vn() != null) {
                it = this.aTK.Va().Vn().iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    ExtraParamProperty extraParamProperty = (ExtraParamProperty) this.aTK.Va().Vo().get(str);
                    if (extraParamProperty == null) {
                        str2 = TAG;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("required property is not found, property name: ");
                        stringBuilder.append(str);
                        com.iqoption.core.i.e(str2, stringBuilder.toString(), new Throwable());
                    } else {
                        h a = a(extraParamProperty, str);
                        if (a == null) {
                            str2 = TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("cannot create property, property name: ");
                            stringBuilder.append(str);
                            com.iqoption.core.i.e(str2, stringBuilder.toString(), new Throwable());
                        } else {
                            this.cyf.add(a);
                        }
                    }
                }
            }
            for (Entry entry : this.aTK.Va().Vo().entrySet()) {
                str2 = (String) entry.getKey();
                if (this.aTK.Va().Vn() == null || !this.aTK.Va().Vn().contains(str2)) {
                    h a2 = a((ExtraParamProperty) entry.getValue(), str2);
                    if (a2 == null) {
                        str = TAG;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("cannot create property, property name: ");
                        stringBuilder.append(str2);
                        com.iqoption.core.i.e(str, stringBuilder.toString(), new Throwable());
                    } else {
                        this.cyf.add(a2);
                    }
                }
            }
        }
        viewGroup = this.cye.boV;
        TextView textView;
        if (obj != null) {
            textView = (TextView) layoutInflater.inflate(R.layout.constructor_text_view_field_old, viewGroup, false);
            textView.setText(R.string.to_continue_the_payment_please_fill_all_fields);
            viewGroup.addView(textView);
        } else if (z) {
            textView = (TextView) layoutInflater.inflate(R.layout.constructor_text_view_field_old, viewGroup, false);
            textView.setText(R.string.to_continue_the_payment_please_enter_your_phone_number);
            viewGroup.addView(textView);
        }
        for (int i = 0; i < this.cyf.size(); i++) {
            if (i != 0) {
                View view = new View(getContext());
                view.setLayoutParams(new LayoutParams(-1, this.cyg));
                viewGroup.addView(view);
            }
            viewGroup.addView((View) ((h) this.cyf.get(i)));
        }
        this.boU = (ConfirmButtonView) layoutInflater.inflate(R.layout.constructor_pay_button, viewGroup, false);
        viewGroup.addView(this.boU);
        this.boU.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!a.this.cxd) {
                    a.this.akv();
                }
            }
        });
        return this.cxb.getRoot();
    }

    private h a(ExtraParamProperty extraParamProperty, String str) {
        h hVar = null;
        if (extraParamProperty == null) {
            return null;
        }
        boolean contains = this.aTK.Va().Vn().contains(str);
        h gVar;
        switch (extraParamProperty.Vh()) {
            case stringType:
                gVar = new g(getContext(), str, (d) extraParamProperty, contains, this.cyh);
                break;
            case integerType:
                gVar = new d(getContext(), str, (com.iqoption.core.microservices.billing.response.extraparams.b) extraParamProperty, contains, this.cyh);
                break;
            case enumType:
                hVar = new c(getContext(), str, (com.iqoption.core.microservices.billing.response.extraparams.a) extraParamProperty);
                break;
            case selectType:
                hVar = new e(getContext(), str, (c) extraParamProperty);
                break;
            default:
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unsupported property ");
                stringBuilder.append(str);
                com.iqoption.core.i.e(str2, stringBuilder.toString());
                break;
        }
        return hVar;
    }

    public boolean onBackPressed() {
        EventManager Bm = EventManager.Bm();
        String str = Event.CATEGORY_BUTTON_PRESSED;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deposit-by-");
        stringBuilder.append(this.cyh);
        stringBuilder.append("_back");
        Bm.a(Event.Builder(str, stringBuilder.toString()).build());
        a akE = akE();
        if (akE != null) {
            akE.aaz();
        }
        return super.aN();
    }

    public void onResume() {
        super.onResume();
        this.adF = true;
        String str = Event.CATEGORY_SCREEN_OPENED;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deposit-by-");
        stringBuilder.append(this.cyh);
        this.cxf = Event.Builder(str, stringBuilder.toString());
    }

    public void onPause() {
        super.onPause();
        akr();
        if (this.cxf != null) {
            EventManager.Bm().a(this.cxf.calcDuration().build());
        }
        this.adF = false;
    }

    private a akE() {
        if (getContext() instanceof a) {
            return (a) getContext();
        }
        return getTargetFragment() instanceof a ? (a) getTargetFragment() : null;
    }

    private void akr() {
        Iterator it = this.cyf.iterator();
        while (it.hasNext()) {
            ((h) it.next()).f(false, null);
        }
        this.cye.boW.setVisibility(8);
    }

    private void akv() {
        EventManager Bm = EventManager.Bm();
        String str = Event.CATEGORY_BUTTON_PRESSED;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deposit-by-");
        stringBuilder.append(this.cyh);
        stringBuilder.append("_pay");
        Bm.a(Event.Builder(str, stringBuilder.toString()).build());
        this.cxd = true;
        if (akF()) {
            final HashMap hashMap = new HashMap();
            Iterator it = this.cyf.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                String str2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("payProcessing add extra param ");
                stringBuilder2.append(hVar.getExtraParamName());
                stringBuilder2.append(", value = ");
                stringBuilder2.append(hVar.getExtraParamValue());
                com.iqoption.core.i.v(str2, stringBuilder2.toString());
                hashMap.put(hVar.getExtraParamName(), hVar.getExtraParamValue());
            }
            if (this.boU != null) {
                this.boU.f(true, false);
            }
            try {
                o.a(o.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM("DepositPaymentConstructorFragment, payProcessing"), new com.google.common.util.concurrent.g<com.iqoption.core.microservices.billing.response.b.a, i>() {
                    /* renamed from: d */
                    public s<i> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
                        String str = a.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("process: ");
                        stringBuilder.append(a.this.cwW);
                        stringBuilder.append(a.this.currency);
                        com.iqoption.core.i.v(str, stringBuilder.toString());
                        return com.iqoption.mobbtech.connect.request.api.b.a(a.this.getContext(), aVar.getHost(), aVar.Uy(), a.this.aTK.getId(), a.this.currency, Double.valueOf(a.this.cwW), a.this.aTJ, false, hashMap);
                    }
                }), new b(this, this.aTK.getName(), this.currency), com.iqoption.core.d.a.aSe);
            } catch (Throwable e) {
                com.iqoption.core.i.e(TAG, "process error", e);
                com.crashlytics.android.a.log("NumberFormatException during processing the card payment");
                k.c(e);
            } catch (Throwable th) {
                this.cxd = false;
            }
            this.cxd = false;
            return;
        }
        this.cxd = false;
    }

    private boolean akF() {
        Iterator it = this.cyf.iterator();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (!hVar.isValid()) {
                hVar.dj(true);
                if (!z) {
                    z = hVar.f(true, null);
                }
                i2 = 1;
            }
        }
        View view = this.cye.boW;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return i2 ^ 1;
    }

    private boolean c(HashMap<String, ArrayList<String>> hashMap) {
        Set keySet = hashMap.keySet();
        Iterator it = this.cyf.iterator();
        int i = 0;
        Object obj = null;
        int i2 = 0;
        boolean z = false;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            String extraParamName = hVar.getExtraParamName();
            if (keySet.contains(extraParamName)) {
                hVar.dj(true);
                if (!(z || ((ArrayList) hashMap.get(extraParamName)).isEmpty())) {
                    obj = (String) ((ArrayList) hashMap.get(extraParamName)).get(0);
                    z = hVar.f(true, obj);
                }
                i2 = 1;
            }
        }
        if (!(i2 == 0 || z || TextUtils.isEmpty(obj))) {
            com.iqoption.app.a.b.b(obj, getContext());
        }
        View view = this.cye.boW;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return i2 ^ 1;
    }
}
