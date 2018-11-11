package com.iqoption.util;

import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.activity.TradeRoomActivity;

final /* synthetic */ class x implements OnClickListener {
    private final TradeRoomActivity aeB;
    private final String afd;
    private final boolean ajB;
    private final AlertDialog dvi;

    x(TradeRoomActivity tradeRoomActivity, String str, boolean z, AlertDialog alertDialog) {
        this.aeB = tradeRoomActivity;
        this.afd = str;
        this.ajB = z;
        this.dvi = alertDialog;
    }

    public void onClick(View view) {
        v.a(this.aeB, this.afd, this.ajB, this.dvi, view);
    }
}
