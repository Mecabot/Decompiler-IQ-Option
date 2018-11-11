package com.iqoption.welcomeonboarding.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.util.p;
import com.iqoption.d.ls;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.request.e;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.util.am;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import org.json.JSONException;

/* compiled from: ForgotPasswordFragment */
public class b extends Fragment implements f {
    public static final String TAG = "com.iqoption.welcomeonboarding.a.b";
    private ls dLN;
    private a dLO;
    private a dLP;

    /* compiled from: ForgotPasswordFragment */
    public interface a extends com.iqoption.welcomeonboarding.b {
        void kj(String str);
    }

    /* compiled from: ForgotPasswordFragment */
    private static class b implements com.iqoption.mobbtech.connect.a.a {
        private WeakReference<b> dLT;

        public b(b bVar) {
            this.dLT = new WeakReference(bVar);
        }

        /* renamed from: a */
        public void onSuccess(h hVar) {
            b bVar = (b) this.dLT.get();
            if (!(bVar == null || !bVar.isAdded() || bVar.dLO == null)) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "forgot-pass_send").setValue(Double.valueOf(1.0d)).build());
                try {
                    bVar.dLO.kj(hVar.auV().getJSONArray("message").getString(0));
                } catch (JSONException unused) {
                }
            }
        }

        public void a(g gVar) {
            b bVar = (b) this.dLT.get();
            if (bVar != null && bVar.isAdded()) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "forgot-pass_send").setValue(Double.valueOf(0.0d)).build());
                bVar.aKM();
                try {
                    gVar.bG(bVar.getContext());
                } catch (Exception unused) {
                }
            }
        }
    }

    public static b aKK() {
        return new b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.dLO = (a) context;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dLN = (ls) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_forgot_password, viewGroup, false);
        this.dLN.a(this);
        this.dLP = new a(this.dLN);
        return this.dLN.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.dLN.bxq.setOnClickListener(c.cni);
        this.dLN.bxq.requestFocus();
        if (bundle != null) {
            am.b(getContext(), this.dLN.bxq);
        }
        this.dLN.bxq.setOnEditorActionListener(new d(this));
        TextWatcher anonymousClass1 = new x() {
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (b.this.dLN.bnn.getVisibility() != 0) {
                    b.this.dLN.bnd.setEnabled(b.this.dLN.bxq.getText().toString().trim().length() > 0);
                }
            }
        };
        this.dLN.bxq.addTextChangedListener(anonymousClass1);
        this.dLN.bxq.post(new e(this, anonymousClass1));
    }

    final /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        aKL();
        return true;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        if (!z) {
            return this.dLP.aKJ();
        }
        Animator aKI = this.dLP.aKI();
        aKI.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.isAdded()) {
                    am.b(b.this.getContext(), b.this.dLN.bxq);
                }
            }
        });
        return aKI;
    }

    public void cl(View view) {
        aKL();
    }

    public void cm(View view) {
        if (this.dLO != null) {
            this.dLO.aKD();
        }
    }

    private void aKL() {
        Object obj = this.dLN.bxq.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            com.iqoption.app.a.b.b(getContext().getString(R.string.please_enter_your_email), getContext());
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "forgot-pass_send").setValue(Double.valueOf(0.0d)).build());
        } else if (p.u(obj)) {
            am.n(zzakw());
            arc();
            new e().a(getContext(), obj, new b(this));
        } else {
            com.iqoption.app.a.b.b(getContext().getString(R.string.please_enter_valid_email), getContext());
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "forgot-pass_send").setValue(Double.valueOf(0.0d)).build());
        }
    }

    private void arc() {
        this.dLN.bnd.setEnabled(false);
        this.dLN.bnd.setText(null);
        this.dLN.bnn.show();
        this.dLN.bxq.setEnabled(false);
    }

    private void aKM() {
        this.dLN.bnd.setEnabled(true);
        this.dLN.bnd.setText(R.string.send);
        this.dLN.bnn.hide();
        this.dLN.bxq.setEnabled(true);
    }
}
