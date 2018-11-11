package com.iqoption.welcomeonboarding.registration.currency.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.d.wb;
import com.iqoption.dto.Currencies.Currency;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CurrencySelectionAdapter */
public class a extends Adapter<b> {
    private List<Currency> aVv = new ArrayList();
    private com.iqoption.welcomeonboarding.registration.currency.a.b.a dNA = new com.iqoption.welcomeonboarding.registration.currency.a.b.a() {
        public void hv(int i) {
            if (a.this.dNz != null && i >= 0 && i < a.this.aVv.size()) {
                a.this.dNz.c((Currency) a.this.aVv.get(i));
            }
        }
    };
    private List<Currency> dNx = new ArrayList();
    private LayoutInflater dNy;
    private a dNz;

    /* compiled from: CurrencySelectionAdapter */
    public interface a {
        void c(Currency currency);
    }

    public a(Context context, a aVar) {
        this.dNy = (LayoutInflater) context.getSystemService("layout_inflater");
        this.dNz = aVar;
    }

    /* renamed from: af */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b((wb) DataBindingUtil.inflate(this.dNy, R.layout.item_currency_selection, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        bVar.a((Currency) this.aVv.get(i), this.dNA);
    }

    public int getItemCount() {
        return this.aVv.size();
    }

    public void bA(List<Currency> list) {
        this.dNx.clear();
        this.dNx.addAll(list);
        this.aVv.clear();
        this.aVv.addAll(list);
    }

    public void cD(int i) {
        if (this.dNx != null && this.dNx.size() != 0) {
            Currency currency = (Currency) this.dNx.get(0);
            Currency currency2 = (Currency) this.dNx.get(i);
            this.aVv.clear();
            this.aVv.addAll(this.dNx);
            this.aVv.set(0, currency2);
            this.aVv.set(i, currency);
        }
    }
}
