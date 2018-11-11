package com.iqoption.welcomeonboarding.registration.currency.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.d.wb;
import com.iqoption.dto.Currencies.Currency;

/* compiled from: CurrencySelectionViewHolder */
public class b extends ViewHolder {
    private wb dNC;

    /* compiled from: CurrencySelectionViewHolder */
    public interface a {
        void hv(int i);
    }

    public b(wb wbVar) {
        super(wbVar.getRoot());
        this.dNC = wbVar;
    }

    public void a(Currency currency, final a aVar) {
        this.dNC.bJk.setText(currency.name);
        this.dNC.getRoot().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.hv(b.this.getAdapterPosition());
                }
            }
        });
    }
}
