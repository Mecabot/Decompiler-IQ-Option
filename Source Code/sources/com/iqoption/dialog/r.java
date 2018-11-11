package com.iqoption.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.app.a;
import com.iqoption.app.af;
import com.iqoption.util.am;
import com.iqoption.welcomeonboarding.registration.f;
import com.iqoption.x.R;

/* compiled from: RetargetDialog */
public class r extends Dialog {
    private String cfB;
    private TradeRoomActivity cfy;
    private String message;

    public r(final TradeRoomActivity tradeRoomActivity, String str, String str2) {
        super(tradeRoomActivity, 16973840);
        this.cfy = tradeRoomActivity;
        this.message = str;
        this.cfB = str2;
        setContentView(R.layout.retarget_dialog);
        getWindow().setFlags(1024, 1024);
        aep();
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                af.aR(tradeRoomActivity).ev("");
                af.aR(tradeRoomActivity).eu("");
            }
        });
    }

    public void show() {
        getWindow().setFlags(8, 8);
        super.show();
        getWindow().clearFlags(8);
        am.bS(getWindow().getDecorView());
    }

    private void aep() {
        findViewById(R.id.layout).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                r.this.dismiss();
            }
        });
        findViewById(R.id.deposit).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (a.aL(r.this.getContext()).CZ()) {
                    f.a(r.this.cfy, r.this.cfy.getSupportFragmentManager());
                } else {
                    r.this.cfy.Aq();
                }
                r.this.dismiss();
            }
        });
        ((TextView) findViewById(R.id.retargetMessage)).setText(this.message);
    }
}
