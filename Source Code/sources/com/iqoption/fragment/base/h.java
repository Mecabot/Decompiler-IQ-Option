package com.iqoption.fragment.base;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.iqoption.activity.b;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.av;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: IQSmartDialogFragment */
public abstract class h extends b {
    private static final String TAG = "com.iqoption.fragment.base.h";
    protected Builder adT;
    private av cvR;

    public abstract View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public abstract String gF();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cvR = (av) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.base_smart_dialog_fragment, viewGroup, false);
        this.cvR.a(this);
        this.cvR.blc.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                b ajV = h.this.ajV();
                if (ajV != null && ajV.zN()) {
                    am.a(h.this.zzakw(), view);
                }
                return true;
            }
        });
        this.cvR.ble.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b ajV = h.this.ajV();
                if (ajV != null && ajV.zN()) {
                    am.a(h.this.zzakw(), view);
                }
            }
        });
        this.cvR.blc.addView(a(layoutInflater, this.cvR.blc, bundle));
        return this.cvR.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, gF());
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }
}
