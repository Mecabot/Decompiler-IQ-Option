package com.iqoption.welcomeonboarding.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.analytics.EventManager;
import com.iqoption.dto.Event;

final /* synthetic */ class c implements OnClickListener {
    static final OnClickListener cni = new c();

    private c() {
    }

    public void onClick(View view) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_TEXT_CHANGED, "forgot-pass_email").build());
    }
}
