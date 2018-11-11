package com.iqoption.fragment.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import com.google.common.b.e;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.b.d.b;
import com.iqoption.core.i;
import com.iqoption.fragment.cm;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.widget.helper.SplashLogHelper;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

/* compiled from: ParametersFragment */
public class g extends Fragment {
    private static final String TAG = "com.iqoption.fragment.a.g";
    private EditText czC;
    private EditText czD;
    private EditText czE;
    private Switch czF;
    private Switch czG;
    private Switch czH;
    private TextView czI;
    private a czJ = new a(this, null);
    private EditText czK;
    private EditText czL;

    /* compiled from: ParametersFragment */
    private static class a {
        private final WeakReference<g> ckC;

        /* synthetic */ a(g gVar, AnonymousClass1 anonymousClass1) {
            this(gVar);
        }

        private a(g gVar) {
            this.ckC = new WeakReference(gVar);
        }

        @e
        public void onFcmToken(b bVar) {
            String AQ = g.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=");
            stringBuilder.append(bVar);
            i.d(AQ, stringBuilder.toString());
            g gVar = (g) this.ckC.get();
            if (gVar != null && gVar.isAdded() && gVar.czI != null) {
                gVar.czI.setText((CharSequence) bVar.getValue());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.debug_console_parameters, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        IQApp.Dn().aD(this.czJ);
        af aR = af.aR(getContext());
        Switch switchR = (Switch) view.findViewById(R.id.debugWebSocketLog);
        switchR.setChecked(aR.FB());
        switchR.setOnCheckedChangeListener(new h(aR));
        this.czC = (EditText) view.findViewById(R.id.editTextStaging);
        this.czC.setText(a.aMk);
        this.czD = (EditText) view.findViewById(R.id.editTextAff);
        this.czD.setText(a.aMm);
        this.czE = (EditText) view.findViewById(R.id.editTextAfftrack);
        this.czE.setText(a.aMn);
        this.czI = (TextView) view.findViewById(R.id.fcmTokenText);
        this.czI.setText(aR.EJ());
        this.czF = (Switch) view.findViewById(R.id.switchStaging);
        this.czF.setChecked(a.czo);
        this.czF.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.czo = z;
                a.aMk = g.this.czC.getText().toString();
            }
        });
        this.czG = (Switch) view.findViewById(R.id.switchAff);
        this.czG.setChecked(a.czp);
        this.czG.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.czp = z;
                a.aMm = g.this.czD.getText().toString();
            }
        });
        this.czH = (Switch) view.findViewById(R.id.switchAfftrack);
        this.czH.setChecked(a.czq);
        this.czH.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.czq = z;
                a.aMn = g.this.czE.getText().toString();
            }
        });
        this.czK = (EditText) view.findViewById(R.id.editTextCoockiesKey);
        this.czL = (EditText) view.findViewById(R.id.editTextCoockiesValue);
        view.findViewById(R.id.coockies).setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                Object obj = g.this.czK.getText().toString();
                Object obj2 = g.this.czL.getText().toString();
                if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                    RequestManager.atO().is(a.aMo);
                    a.czr = false;
                    a.aMo = "";
                    a.aMp = "";
                    return;
                }
                a.czr = true;
                a.aMo = obj;
                a.aMp = obj2;
            }
        });
        view.findViewById(R.id.buttonResetDemo).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                af.aR(g.this.zzakw()).aW(false);
                com.iqoption.app.a.b.b("Demo reseted!!!!", g.this.getContext());
            }
        });
        view = view.findViewById(R.id.buttonTechnicalLog);
        if (SplashLogHelper.aMJ()) {
            view.setVisibility(0);
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    g.this.zzakw().getSupportFragmentManager().beginTransaction().add(R.id.topFrame, cm.hA(SplashLogHelper.cf(g.this.getContext())), cm.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(cm.TAG).commit();
                }
            });
            return;
        }
        view.setVisibility(8);
    }

    static final /* synthetic */ void a(af afVar, CompoundButton compoundButton, boolean z) {
        afVar.br(z);
        IQApp.Dn().aE(new com.iqoption.app.b.d.a().setValue(Boolean.valueOf(z)));
    }

    public void onDestroyView() {
        super.onDestroyView();
        IQApp.Dn().unregister(this.czJ);
    }
}
