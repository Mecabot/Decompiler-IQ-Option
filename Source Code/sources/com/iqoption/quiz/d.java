package com.iqoption.quiz;

import android.app.Activity;
import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.quiz.ae.e;
import com.iqoption.quiz.b.m;
import com.iqoption.quiz.widget.CountDownProgressBar;
import com.iqoption.quiz.widget.CountDownProgressBar.b;

/* compiled from: FinishDialog */
public class d extends Fragment implements i {
    public static final String TAG = "com.iqoption.quiz.d";
    private String deu;
    private boolean dev;
    private double dew;
    private m dex;
    private a dey;
    private com.iqoption.core.a.d dez;
    private int tag;
    private String text;
    private String title;

    /* compiled from: FinishDialog */
    public interface a {
        void gh(int i);

        void gi(int i);
    }

    public boolean onBackPressed() {
        return true;
    }

    public static d a(String str, String str2, String str3, boolean z, int i, double d) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("param_title", str);
        bundle.putString("param_text", str2);
        bundle.putString("param_button_text", str3);
        bundle.putBoolean("param_show_timer", z);
        bundle.putInt("param_tag", i);
        bundle.putDouble("param_win_amount", d);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.title = bundle.getString("param_title");
            this.text = bundle.getString("param_text");
            this.deu = bundle.getString("param_button_text");
            this.dev = bundle.getBoolean("param_show_timer", false);
            this.tag = bundle.getInt("param_tag", 0);
            this.dew = bundle.getDouble("param_win_amount", 0.0d);
        }
        switch (this.tag) {
            case 1:
                this.dez = com.iqoption.quiz.a.a.did.azI();
                return;
            case 2:
                this.dez = com.iqoption.quiz.a.a.did.azJ();
                return;
            case 3:
                this.dez = com.iqoption.quiz.a.a.did.D(this.dew);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dex = (m) DataBindingUtil.inflate(layoutInflater, e.question_dialog_layout, viewGroup, false);
        if (this.dev) {
            this.dex.dkQ.setVisibility(0);
            this.dex.dkQ.setCountDownFinishListener(new b() {
                public void a(CountDownProgressBar countDownProgressBar) {
                    d.this.dey.gh(d.this.tag);
                    countDownProgressBar.post(new e(this));
                }

                final /* synthetic */ void ayH() {
                    d.this.getFragmentManager().popBackStack();
                }
            });
            this.dex.dkQ.start();
        } else {
            this.dex.dkQ.setVisibility(8);
        }
        this.dex.agA.setText(this.title);
        this.dex.aip.setText(this.text);
        this.dex.dkP.setText(this.deu);
        this.dex.dkP.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                switch (d.this.tag) {
                    case 1:
                        com.iqoption.quiz.a.a.did.azS();
                        break;
                    case 2:
                        com.iqoption.quiz.a.a.did.azT();
                        break;
                    case 3:
                        com.iqoption.quiz.a.a.did.azU();
                        break;
                }
                d.this.dey.gi(d.this.tag);
                view.post(new f(this));
            }

            final /* synthetic */ void ayI() {
                d.this.getFragmentManager().popBackStack();
            }
        });
        return this.dex.getRoot();
    }

    public void onDestroyView() {
        if (this.dez != null) {
            this.dez.Bs();
        }
        super.onDestroyView();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.dey = (a) activity;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.dey = null;
    }
}
