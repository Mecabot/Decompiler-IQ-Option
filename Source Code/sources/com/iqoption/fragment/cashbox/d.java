package com.iqoption.fragment.cashbox;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.collect.ImmutableList;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.d.gg;
import com.iqoption.x.R;

/* compiled from: DepositCurrencyAdapter */
public class d extends BaseAdapter {
    private static final String TAG = "com.iqoption.fragment.cashbox.d";
    private final LayoutInflater aDN;
    private final ImmutableList<c> cwz;

    public boolean hasStableIds() {
        return false;
    }

    public d(Context context, b bVar) {
        this.aDN = (LayoutInflater) context.getSystemService("layout_inflater");
        this.cwz = ImmutableList.sO().f(bVar.Td()).sP();
    }

    public int getCount() {
        return this.cwz.size();
    }

    /* renamed from: eO */
    public c getItem(int i) {
        return (c) this.cwz.get(i);
    }

    public long getItemId(int i) {
        return ((c) this.cwz.get(i)).getId();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        gg ggVar;
        View root;
        if (view == null) {
            ggVar = (gg) DataBindingUtil.inflate(this.aDN, R.layout.deposit_currency_item, viewGroup, false);
            root = ggVar.getRoot();
            root.setTag(ggVar);
        } else {
            root = view;
            ggVar = (gg) view.getTag();
        }
        c eO = getItem(i);
        ggVar.boY.setText(eO.getSymbol());
        ggVar.boZ.setText(eO.getName());
        return root;
    }
}
