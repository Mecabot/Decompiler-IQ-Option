package com.iqoption.fragment.cashbox;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.s;
import com.iqoption.app.managers.feature.a;
import com.iqoption.core.i;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.core.microservices.billing.response.deposit.h;
import com.iqoption.d.hf;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import io.card.payment.CardType;

/* compiled from: PaymentMethodsAdapter */
public class m extends BaseAdapter {
    private static final String TAG = "com.iqoption.fragment.cashbox.m";
    private static final j<g> cya = n.$instance;
    private final LayoutInflater aDN;
    private final ImmutableList<PayMethod> cyb;
    private final int cyc;
    private final int cyd;

    public boolean hasStableIds() {
        return false;
    }

    public m(Context context, b bVar, boolean z) {
        this.aDN = (LayoutInflater) context.getSystemService("layout_inflater");
        if (z) {
            this.cyb = ImmutableList.sO().f(s.a(bVar.UG(), h.aTY)).f(s.a(bVar.UH(), cya)).sP();
        } else {
            this.cyb = ImmutableList.sO().f(bVar.UG()).f(bVar.UH()).sP();
        }
        this.cyc = ContextCompat.getColor(context, R.color.deposit_constructor_field_text);
        this.cyd = ContextCompat.getColor(context, R.color.deposit_constructor_field_text_disabled);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PaymentMethodsAdapter init: ");
        stringBuilder.append(bVar);
        i.d(str, stringBuilder.toString());
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return super.getDropDownView(i, view, viewGroup);
    }

    public int getCount() {
        return this.cyb.size();
    }

    /* renamed from: eR */
    public PayMethod getItem(int i) {
        return (PayMethod) this.cyb.get(i);
    }

    public long getItemId(int i) {
        return ((PayMethod) this.cyb.get(i)).UQ();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        hf hfVar;
        View root;
        if (view == null) {
            hfVar = (hf) DataBindingUtil.inflate(this.aDN, R.layout.deposit_payment_method_item, viewGroup, false);
            root = hfVar.getRoot();
            root.setTag(hfVar);
        } else {
            root = view;
            hfVar = (hf) view.getTag();
        }
        PayMethod eR = getItem(i);
        hfVar.boX.setText(eR.getName());
        if (a.eW("kyc-deposit-limit") && eR.UU()) {
            hfVar.bqS.setVisibility(0);
            hfVar.boX.setTextColor(this.cyd);
        } else {
            hfVar.bqS.setVisibility(8);
            hfVar.boX.setTextColor(this.cyc);
        }
        Context context = root.getContext();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getView, name=");
        stringBuilder.append(eR.getName());
        i.v(str, stringBuilder.toString());
        Picasso with = Picasso.with(context);
        str = o(eR);
        ImageView imageView = hfVar.bqT;
        if (str != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("withdrawal-");
            stringBuilder2.append(str);
            com.iqoption.core.util.h.a(with, stringBuilder2.toString()).resizeDimen(R.dimen.payment_method_icon_width, R.dimen.payment_method_icon_height).onlyScaleDown().placeholder((int) R.drawable.payment_placeholder).error((int) R.drawable.payment_placeholder).centerInside().into(imageView);
        } else {
            a(with, imageView, eR);
        }
        return root;
    }

    private String o(@NonNull PayMethod payMethod) {
        String str = null;
        if (payMethod instanceof h) {
            CardType gV = com.iqoption.core.util.a.gV(((h) payMethod).Vg());
            if (gV != null) {
                str = gV.name.toLowerCase();
            }
            return str;
        } else if (payMethod instanceof g) {
            return ((g) payMethod).UY();
        } else {
            return null;
        }
    }

    private void a(@NonNull Picasso picasso, @NonNull ImageView imageView, @NonNull PayMethod payMethod) {
        picasso.load(payMethod.US()).placeholder((int) R.drawable.payment_placeholder).resizeDimen(R.dimen.payment_method_icon_width, R.dimen.payment_method_icon_height).centerInside().onlyScaleDown().error((int) R.drawable.payment_placeholder).into(imageView);
    }
}
