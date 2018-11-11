package com.iqoption.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.dto.entity.BackCall;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.a;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: BackCallDialog */
public class b extends Dialog {
    public b(Context context, BackCall backCall) {
        super(context, 16973840);
        setContentView(R.layout.callbackme_dialog);
        getWindow().setFlags(1024, 1024);
        b(backCall);
    }

    public void show() {
        getWindow().setFlags(8, 8);
        super.show();
        getWindow().clearFlags(8);
        am.bS(getWindow().getDecorView());
    }

    private void b(BackCall backCall) {
        TextView textView = (TextView) findViewById(R.id.baseText);
        TextView textView2 = (TextView) findViewById(R.id.vipManagerName);
        TextView textView3 = (TextView) findViewById(R.id.vipManagerPhone);
        if (backCall.result.hasVipManager != null && backCall.result.hasVipManager.booleanValue()) {
            textView.setText(R.string.your_personal_manager);
            if (!(backCall.result.managerName == null || backCall.result.managerName.equals("false"))) {
                textView2.setText(backCall.result.managerName);
            }
            if (!(backCall.result.managerPhone == null || backCall.result.managerPhone.equals("false"))) {
                textView3.setText(backCall.result.managerPhone);
            }
            textView2.setVisibility(0);
            textView3.setVisibility(0);
        } else {
            textView.setText(R.string.callback_base_text_standart);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
        }
        findViewById(R.id.callbackButton).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.aeq();
                b.this.dismiss();
            }
        });
        findViewById(R.id.emptyView).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
    }

    private void aeq() {
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/callbackme");
        new a(RequestManager.e(stringBuilder.toString(), getContext()), new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
            }

            public void a(g gVar) {
                gVar.bG(b.this.getContext());
            }
        }, "api/callbackme").auG();
    }
}
