package com.iqoption.welcomeonboarding.registration.currency.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import com.iqoption.d.adk;
import com.iqoption.dto.Currencies.Currency;
import com.iqoption.welcomeonboarding.registration.currency.a.a.a;
import com.iqoption.x.R;
import java.util.List;

/* compiled from: SelectCurrencyWindow */
public class c extends PopupWindow {
    private a dNF;
    private adk dNG;
    private int dNH;

    public c(Context context, a aVar, List<Currency> list, int i) {
        a(context, aVar, list, i);
    }

    private void a(Context context, a aVar, List<Currency> list, int i) {
        this.dNG = adk.aj((LayoutInflater) context.getSystemService("layout_inflater"), null, false);
        LayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.dNF = new a(context, aVar);
        this.dNF.bA(list);
        this.dNG.bOM.setLayoutManager(linearLayoutManager);
        this.dNG.bOM.setAdapter(this.dNF);
        this.dNH = context.getResources().getDimensionPixelSize(R.dimen.dp8);
        setContentView(this.dNG.getRoot());
        setWidth(i);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setAnimationStyle(R.style.CurrencyWindowAnimationStyle);
    }

    public void cD(int i) {
        this.dNF.cD(i);
        this.dNF.notifyDataSetChanged();
    }

    public int getXOffset() {
        return (-this.dNG.bOL.getPaddingLeft()) - this.dNH;
    }

    public int getYOffset() {
        return -this.dNG.bOL.getPaddingTop();
    }
}
