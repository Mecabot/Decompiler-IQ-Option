package com.iqoption.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.app.IQApp;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.HashMap;

/* compiled from: RateTicketDialog */
public class e extends com.iqoption.fragment.base.e {
    private ImageView[] ait = new ImageView[5];
    private EditText ceY;
    private View ceZ;
    private ProgressBar cfa;
    private int cfb = 0;

    /* compiled from: RateTicketDialog */
    private class a implements OnClickListener {
        private int cff;

        public a(int i) {
            this.cff = i;
        }

        public void onClick(View view) {
            for (int i = 0; i < e.this.ait.length; i++) {
                if (i <= this.cff) {
                    e.this.ait[i].setImageResource(R.drawable.rate_star_on);
                } else {
                    e.this.ait[i].setImageResource(R.drawable.rate_star_off);
                }
            }
            if (this.cff <= 2) {
                e.this.ceY.setVisibility(0);
            } else {
                e.this.ceY.setVisibility(8);
            }
            e.this.cfb = this.cff + 1;
            if (e.this.cfb > 3 || !TextUtils.isEmpty(e.this.ceY.getText().toString())) {
                e.this.ceZ.setEnabled(true);
            } else {
                e.this.ceZ.setEnabled(false);
            }
        }
    }

    public static e bg(long j) {
        e eVar = new e();
        eVar.setStyle(2, 16973937);
        Bundle bundle = new Bundle();
        bundle.putLong("idTicket", j);
        eVar.setArguments(bundle);
        return eVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setFlags(8, 8);
        getDialog().setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                e.this.getDialog().getWindow().clearFlags(8);
                am.bS(e.this.getDialog().getWindow().getDecorView());
            }
        });
        return layoutInflater.inflate(R.layout.rate_ticket_dialog, viewGroup, true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final long j = getArguments().getLong("idTicket");
        this.ait[0] = (ImageView) view.findViewById(R.id.star1);
        this.ait[1] = (ImageView) view.findViewById(R.id.star2);
        this.ait[2] = (ImageView) view.findViewById(R.id.star3);
        this.ait[3] = (ImageView) view.findViewById(R.id.star4);
        this.ait[4] = (ImageView) view.findViewById(R.id.star5);
        for (int i = 0; i < this.ait.length; i++) {
            this.ait[i].setOnClickListener(new a(i));
        }
        this.cfa = (ProgressBar) view.findViewById(R.id.rateProgress);
        this.ceY = (EditText) view.findViewById(R.id.comment);
        this.ceY.setHorizontallyScrolling(false);
        this.ceY.setMaxLines(100);
        this.ceY.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (e.this.cfb > 3 || !TextUtils.isEmpty(e.this.ceY.getText().toString())) {
                    e.this.ceZ.setEnabled(true);
                } else {
                    e.this.ceZ.setEnabled(false);
                }
            }
        });
        this.ceZ = view.findViewById(R.id.confirm);
        this.ceZ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                e.this.ceZ.setVisibility(4);
                e.this.cfa.setVisibility(0);
                HashMap hashMap = new HashMap();
                hashMap.put("id", String.valueOf(j));
                hashMap.put("mark", String.valueOf(e.this.cfb));
                hashMap.put("mark_comment", e.this.ceY.getText().toString());
                String clusterApi = IQApp.Dl().getClusterApi();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(clusterApi);
                stringBuilder.append("api/ticket/rate");
                new com.iqoption.mobbtech.connect.request.a.a.a(RequestManager.b(stringBuilder.toString(), hashMap, e.this.zzakw()), new com.iqoption.mobbtech.connect.a.a() {
                    /* renamed from: a */
                    public void onSuccess(h hVar) {
                        ((TradeRoomActivity) e.this.zzakw()).b(j, e.this.cfb);
                        e.this.dismiss();
                    }

                    public void a(g gVar) {
                        e.this.ceZ.setVisibility(0);
                        e.this.cfa.setVisibility(8);
                    }
                }, "api/ticket/rate").auG();
            }
        });
        this.ceZ.setEnabled(false);
        view.findViewById(R.id.cancel).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
    }
}
