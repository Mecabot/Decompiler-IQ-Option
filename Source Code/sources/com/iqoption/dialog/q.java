package com.iqoption.dialog;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.util.a;
import com.iqoption.x.R;

/* compiled from: ReloginDialog */
public class q extends Dialog {
    private TradeRoomActivity cfy;

    public q(final TradeRoomActivity tradeRoomActivity) {
        super(tradeRoomActivity, 16973840);
        this.cfy = tradeRoomActivity;
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.relogin_dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        findViewById(R.id.relogin).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                tradeRoomActivity.zC();
                a.t(tradeRoomActivity);
                q.this.dismiss();
            }
        });
        findViewById(R.id.logout).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                tradeRoomActivity.zZ();
                q.this.dismiss();
            }
        });
    }
}
