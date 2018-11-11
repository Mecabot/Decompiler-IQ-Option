package com.iqoption.portfolio.component;

import android.databinding.ViewDataBinding;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: BindingPagerAdapter */
public final class a extends PagerAdapter {
    private final a cYR;
    private final List<ViewDataBinding> cYS;

    /* compiled from: BindingPagerAdapter */
    public interface a {
        CharSequence fL(int i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public a(a aVar, List<ViewDataBinding> list) {
        this.cYR = aVar;
        this.cYS = list;
    }

    public int getCount() {
        return this.cYS.size();
    }

    public CharSequence getPageTitle(int i) {
        return this.cYR.fL(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View root = ((ViewDataBinding) this.cYS.get(i)).getRoot();
        viewGroup.addView(root);
        return root;
    }
}
