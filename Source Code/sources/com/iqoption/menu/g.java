package com.iqoption.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.analytics.EventManager;
import com.iqoption.dto.Event;

final /* synthetic */ class g implements OnClickListener {
    static final OnClickListener cni = new g();

    private g() {
    }

    public void onClick(View view) {
        EventManager.Bm().a(new Event(Event.CATEGORY_TEXT_CHANGED, "new-support-dialog_text"));
    }
}
