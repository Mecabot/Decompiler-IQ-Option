package com.iqoption.welcomeonboarding.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
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
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.util.p;
import com.iqoption.d.tf;
import com.iqoption.dto.Event;
import com.iqoption.microservice.authorization.AuthException;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.util.be;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: TwoStepAuthFragment */
public class b extends Fragment implements g {
    public static final String TAG = "com.iqoption.welcomeonboarding.d.b";
    private com.iqoption.fragment.account.security.sms.a cuL;
    private tf dNI;
    private a dNJ;
    private a dNK;
    private CountDownTimer dNL;

    /* compiled from: TwoStepAuthFragment */
    public interface a extends com.iqoption.welcomeonboarding.b {
        void aKG();
    }

    public static b aMC() {
        return new b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.dNJ = (a) context;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dNI = (tf) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_two_step_auth, viewGroup, false);
        this.dNI.a(this);
        this.dNK = new a(this.dNI);
        return this.dNI.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.cuL = new com.iqoption.fragment.account.security.sms.a(getContext());
        this.dNL = cB(ajx());
        this.dNL.start();
        String ha = p.ha(af.aR(getContext()).EU());
        this.dNI.bFg.setText(getString(R.string.verification_code_has_just_been_sent_to_number, ha));
        this.dNI.bFc.requestFocus();
        if (bundle != null) {
            am.b(getContext(), this.dNI.bFc);
        }
        this.dNI.bFc.setOnEditorActionListener(new c(this));
        TextWatcher anonymousClass1 = new x() {
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (b.this.dNI.bnn.getVisibility() != 0) {
                    b.this.dNI.bnd.setEnabled(b.this.dNI.bFc.getText().toString().trim().length() > 0);
                }
            }
        };
        this.dNI.bFc.addTextChangedListener(anonymousClass1);
        this.dNI.bFc.post(new d(this, anonymousClass1));
    }

    final /* synthetic */ boolean c(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        login();
        return true;
    }

    final /* synthetic */ void d(TextWatcher textWatcher) {
        textWatcher.afterTextChanged(this.dNI.bFc.getText());
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        if (!z) {
            return this.dNK.aKJ();
        }
        Animator aKI = this.dNK.aKI();
        aKI.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.isAdded()) {
                    am.b(b.this.getContext(), b.this.dNI.bFc);
                }
            }
        });
        return aKI;
    }

    public void co(View view) {
        login();
    }

    public void cv(View view) {
        String ES = af.aR(getContext()).ES();
        String ET = af.aR(getContext()).ET();
        this.dNI.bFe.setEnabled(false);
        g(null, ES, ET, true);
        aMD();
    }

    public void cm(View view) {
        if (this.dNJ != null) {
            this.dNJ.aKD();
        }
    }

    private void aMD() {
        this.dNI.bnd.setEnabled(this.dNI.bFc.length() >= 6);
    }

    private void aKT() {
        this.dNI.bnd.setEnabled(false);
        this.dNI.bnd.setText(null);
        this.dNI.bnn.show();
        this.dNI.bFc.setEnabled(false);
    }

    private void aKU() {
        this.dNI.bnd.setEnabled(true);
        this.dNI.bnd.setText(R.string.login);
        this.dNI.bnn.hide();
        this.dNI.bFc.setEnabled(true);
    }

    private void login() {
        Object trim = this.dNI.bFc.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            com.iqoption.app.a.b.eO(getString(R.string.please_enter_verification_code));
            return;
        }
        String ES = af.aR(getContext()).ES();
        String ET = af.aR(getContext()).ET();
        am.n(zzakw());
        aME();
        g(trim, ES, ET, false);
        aKT();
    }

    private void g(String str, String str2, String str3, boolean z) {
        aME();
        s a = com.iqoption.c.a.Jw().a(str2, str3, str, z, true, 0);
        WeakReference weakReference = new WeakReference(this);
        ag.a(a, new e(weakReference), new f(weakReference));
    }

    static final /* synthetic */ void a(WeakReference weakReference, Boolean bool) {
        b bVar = (b) weakReference.get();
        if (bVar != null && bVar.isAdded()) {
            if (!be.a(bVar.getResources())) {
                bVar.zzakw().setRequestedOrientation(6);
            }
            af.aR(IQApp.Dk()).ag(0);
            if (bVar.dNJ != null) {
                bVar.dNJ.aKG();
            }
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_login").setValue(Double.valueOf(1.0d)).build());
        }
    }

    static final /* synthetic */ void c(WeakReference weakReference, Throwable th) {
        b bVar = (b) weakReference.get();
        if (bVar != null && bVar.isAdded() && (th instanceof AuthException)) {
            AuthException authException = (AuthException) th;
            if (authException.status == 100 || authException.status == 101) {
                af.aR(IQApp.Dk()).ag(System.currentTimeMillis());
                bVar.dNL = bVar.cB((long) bVar.cuL.ajB());
                bVar.dNL.start();
            }
            bVar.aKU();
        }
    }

    @NonNull
    private CountDownTimer cB(long j) {
        return new CountDownTimer(j, 1000) {
            public void onTick(long j) {
                if (b.this.dNI.bFh.getVisibility() == 8) {
                    b.this.dNI.bFh.setVisibility(0);
                    b.this.dNI.bFe.setVisibility(8);
                    b.this.dNI.bFf.setText(R.string.you_can_resend_the_code_in_countdown);
                    b.this.dNI.bFe.setPaintFlags(8 ^ b.this.dNI.bFe.getPaintFlags());
                }
                b.this.dNI.bFh.setText(bA(j));
            }

            public void onFinish() {
                b.this.aME();
            }

            private String bA(long j) {
                return String.format(Locale.US, "%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))});
            }
        };
    }

    private void aME() {
        if (this.dNL != null) {
            this.dNL.cancel();
            this.dNL = null;
        }
        if (this.dNI.bFh != null) {
            this.dNI.bFh.setVisibility(8);
            this.dNI.bFe.setEnabled(true);
            this.dNI.bFe.setVisibility(0);
            this.dNI.bFe.setPaintFlags(8 | this.dNI.bFe.getPaintFlags());
            this.dNI.bFf.setText(R.string.haven_t_received_the_code_yet);
            this.dNI.bFc.setText("");
        }
    }

    private long ajx() {
        if (this.cuL == null) {
            return 0;
        }
        return this.cuL.bl(af.aR(getContext()).ER());
    }
}
