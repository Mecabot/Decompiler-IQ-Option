package com.iqoption.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.sh;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.x.R;

/* compiled from: TechnicalLogFragment */
public class cm extends Fragment {
    public static final String TAG = "com.iqoption.fragment.cm";
    private Builder ajG;
    private sh crd;
    private String cre;

    public static cm hA(String str) {
        cm cmVar = new cm();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_LOG", str);
        cmVar.setArguments(bundle);
        return cmVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cre = bundle.getString("ARG_LOG");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.crd = (sh) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_technical_log, viewGroup, false);
        this.crd.buI.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.crd.buI.setText(this.cre);
        this.crd.bCc.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                cm.this.getFragmentManager().popBackStack();
            }
        });
        return this.crd.getRoot();
    }

    public void onResume() {
        super.onResume();
        this.ajG = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "technical-log");
    }

    public void onPause() {
        super.onPause();
        if (this.ajG != null) {
            EventManager.Bm().a(this.ajG.calcDuration().build());
        }
    }
}
