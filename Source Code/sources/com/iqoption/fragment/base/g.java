package com.iqoption.fragment.base;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.at;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: IQMenuFragment */
public abstract class g extends b {
    protected Builder adT;
    private at cvO;
    private View cvP;

    public abstract String gF();

    public abstract View getContentView();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cvO = (at) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.base_menu_fragment, viewGroup, false);
        this.cvO.a(this);
        this.cvO.blc.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cvP = getContentView();
        this.cvO.blc.addView(this.cvP);
        return this.cvO.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onResume() {
        super.onResume();
        String gF = gF();
        if (gF() != null) {
            this.adT = Event.Builder(Event.CATEGORY_SCREEN_OPENED, gF);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onBackPressed() {
        return onClose();
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        return true;
    }

    public void NE() {
        this.cvO.blc.animate().alpha(0.0f).setDuration(400).setInterpolator(d.dEM).start();
    }

    public void ND() {
        this.cvO.blc.setAlpha(0.0f);
        this.cvO.blc.animate().alpha(1.0f).setDuration(400).setInterpolator(new LinearOutSlowInInterpolator()).start();
    }
}
