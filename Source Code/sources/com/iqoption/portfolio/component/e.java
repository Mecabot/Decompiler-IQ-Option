package com.iqoption.portfolio.component;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.abc;
import com.iqoption.portfolio.component.a.a;
import com.iqoption.portfolio.f;
import com.iqoption.x.R;
import java.util.Arrays;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;

@i(aXC = {1, 1, 11}, aXD = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010&\u001a\u00020\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, aXE = {"Lcom/iqoption/portfolio/component/MicroTotalPagerAdapter;", "Landroid/support/v4/view/PagerAdapter;", "context", "Landroid/content/Context;", "uiConfig", "Lcom/iqoption/portfolio/component/UIConfig;", "portfolio", "Lcom/iqoption/portfolio/Portfolio;", "binder", "Lcom/iqoption/portfolio/component/binder/CalculationBinder;", "(Landroid/content/Context;Lcom/iqoption/portfolio/component/UIConfig;Lcom/iqoption/portfolio/Portfolio;Lcom/iqoption/portfolio/component/binder/CalculationBinder;)V", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "pnlOrProfitPage", "Lcom/iqoption/databinding/MicroPortfolioTotalPagerPageBinding;", "resources", "Landroid/content/res/Resources;", "valuePage", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getBinding", "parent", "getCount", "getLabel", "", "resId", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "updateCalculation", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MicroTotalPagerAdapter.kt */
public final class e extends PagerAdapter {
    private final LayoutInflater aDN;
    private final Resources aMx;
    private final f cYB;
    private abc cYU;
    private abc cYV;
    private final o cYW;
    private final a cYX;

    public int getCount() {
        return 2;
    }

    public e(Context context, o oVar, f fVar, a aVar) {
        h.e(context, "context");
        h.e(oVar, "uiConfig");
        h.e(fVar, "portfolio");
        h.e(aVar, "binder");
        this.cYW = oVar;
        this.cYB = fVar;
        this.cYX = aVar;
        this.aMx = context.getResources();
        this.aDN = LayoutInflater.from(context);
    }

    private final abc o(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.aDN;
        h.d(layoutInflater, "inflater");
        return (abc) com.iqoption.core.ext.a.a(layoutInflater, (int) R.layout.micro_portfolio_total_pager_page, viewGroup, false, 4, null);
    }

    public boolean isViewFromObject(View view, Object obj) {
        h.e(view, Promotion.ACTION_VIEW);
        h.e(obj, "object");
        return h.E(view, obj);
    }

    private final String getLabel(int i) {
        m mVar = m.euz;
        String str = this.cYW.cZQ;
        h.d(str, "uiConfig.totalLabelMask");
        Object[] objArr = new Object[]{this.aMx.getString(i)};
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "container");
        abc o = o(viewGroup);
        if (i == 0) {
            this.cYU = o;
        } else {
            this.cYV = o;
        }
        awC();
        viewGroup.addView(o.getRoot());
        View root = o.getRoot();
        h.d(root, "page.root");
        return root;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        h.e(viewGroup, "container");
        h.e(obj, "object");
        if (i == 0) {
            this.cYU = (abc) null;
        } else {
            this.cYV = (abc) null;
        }
        viewGroup.removeView((View) obj);
    }

    public final void awC() {
        TextView textView;
        com.iqoption.portfolio.a awc = this.cYB.awc();
        abc abc = this.cYU;
        if (abc != null) {
            textView = abc.avo;
            h.d(textView, "it.label");
            textView.setText(getLabel(R.string.total_value));
            this.cYX.b(abc.bns, awc);
        }
        abc = this.cYV;
        if (abc != null) {
            switch (this.cYB.avX()) {
                case 0:
                case 2:
                case 4:
                case 5:
                case 6:
                    textView = abc.avo;
                    h.d(textView, "it.label");
                    textView.setText(getLabel(R.string.total_pnl));
                    this.cYX.a(abc.bns, awc);
                    return;
                case 1:
                case 3:
                case 7:
                case 8:
                    textView = abc.avo;
                    h.d(textView, "it.label");
                    textView.setText(getLabel(R.string.total_exp_profit));
                    this.cYX.c(abc.bns, awc);
                    return;
                default:
                    return;
            }
        }
    }
}
