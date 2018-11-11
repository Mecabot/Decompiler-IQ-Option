package com.iqoption.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: SimplePagerAdapter */
public class l extends PagerAdapter {
    private List<View> dDL;

    public l(List<View> list) {
        this.dDL = list;
    }

    public int getCount() {
        return this.dDL.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.dDL.get(i));
        return this.dDL.get(i);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
