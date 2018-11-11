package com.iqoption.welcomeonboarding.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.login.j;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.util.p;
import com.iqoption.d.ub;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.Feature;
import com.iqoption.microservice.authorization.AuthException;
import com.iqoption.system.c.b;
import com.iqoption.util.am;
import com.iqoption.util.be;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.Collections;

/* compiled from: LoginFragment */
public class c extends Fragment implements i, com.iqoption.welcomeonboarding.c.a {
    public static final String TAG = "com.iqoption.welcomeonboarding.b.c";
    private ub dLU;
    private com.iqoption.welcomeonboarding.a dLV;
    private a dLW;

    /* compiled from: LoginFragment */
    private static class a extends b<c, Boolean> {
        a(c cVar) {
            super((Object) cVar);
        }

        /* renamed from: a */
        public void z(@NonNull c cVar, Boolean bool) {
            if (cVar.isAdded()) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_login").setValue(Double.valueOf(1.0d)).build());
                af.aR(IQApp.Dk()).ag(0);
                if (cVar.zzakw().getRequestedOrientation() == 7) {
                    cVar.zzakw().setRequestedOrientation(6);
                }
                if (cVar.dLV != null) {
                    cVar.dLV.aKB();
                }
                cVar.aKU();
            }
        }

        /* renamed from: a */
        public void c(@NonNull c cVar, Throwable th) {
            if (cVar.isAdded()) {
                if (th instanceof AuthException) {
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_login").setValue(Double.valueOf(0.0d)).build());
                    AuthException authException = (AuthException) th;
                    if ((authException.status == 100 || authException.status == 101) && cVar.dLV != null) {
                        cVar.dLV.j(authException.email, authException.password, authException.phoneMask);
                    }
                }
                cVar.aKU();
            }
        }
    }

    public static c aKN() {
        return new c();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.iqoption.welcomeonboarding.a) {
            this.dLV = (com.iqoption.welcomeonboarding.a) context;
            this.dLV.a(this);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dLU = (ub) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_welcome_login, viewGroup, false);
        this.dLU.a(this);
        if (getResources().getConfiguration().orientation == 1) {
            this.dLW = new j(this.dLU);
        } else {
            this.dLW = new b(this.dLU);
        }
        return this.dLU.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        if (bundle == null) {
            this.dLU.bxq.setText(af.aR(getContext()).EH());
        }
        if (bundle != null) {
            aKP();
        }
        this.dLU.bEP.setOnEditorActionListener(new d(this));
        TextWatcher anonymousClass1 = new x() {
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (c.this.dLU.bnn.getVisibility() != 0) {
                    int length = c.this.dLU.bxq.getText().toString().trim().length();
                    int length2 = c.this.dLU.bEP.getText().toString().trim().length();
                    TextView textView = c.this.dLU.bnd;
                    boolean z = length > 0 && length2 > 0;
                    textView.setEnabled(z);
                }
            }
        };
        this.dLU.bxq.addTextChangedListener(anonymousClass1);
        this.dLU.bEP.addTextChangedListener(anonymousClass1);
        this.dLU.bxq.post(new e(this, anonymousClass1));
        aKO();
        this.dLU.bER.setOnClickListener(new f(this));
    }

    final /* synthetic */ boolean b(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        login();
        return true;
    }

    final /* synthetic */ void cs(View view) {
        cu(this.dLU.bER.isChecked());
    }

    private void aKO() {
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("show-social-login");
        Object obj = fd != null ? fd.status : null;
        if (obj == null) {
            obj = "enabled";
        }
        if ("disabled".equals(obj)) {
            this.dLU.bGj.bKq.setVisibility(8);
            return;
        }
        this.dLU.bGj.bKq.setVisibility(0);
        if (com.iqoption.core.ext.c.b(obj, "enabled", "google")) {
            this.dLU.bGj.bKp.setVisibility(0);
            this.dLU.bGj.bKp.setOnTouchListener(new com.iqoption.view.d.c());
            this.dLU.bGj.bKp.setOnClickListener(new g(this));
        } else {
            this.dLU.bGj.bKp.setVisibility(8);
        }
        if (com.iqoption.core.ext.c.b(obj, "enabled", "fb")) {
            this.dLU.bGj.bKo.setVisibility(0);
            this.dLU.bGj.bKo.setOnTouchListener(new com.iqoption.view.d.c());
            this.dLU.bGj.bKo.setOnClickListener(new h(this));
            return;
        }
        this.dLU.bGj.bKo.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        cu(this.dLU.bER.isChecked());
    }

    private void aKP() {
        if (isAdded() && !isDetached()) {
            Resources resources = getResources();
            if (resources == null || be.a(resources)) {
                this.dLU.agA.requestFocus();
            } else {
                View aKQ = aKQ();
                aKQ.requestFocus();
                am.b(getContext(), aKQ);
            }
        }
    }

    private View aKQ() {
        if (this.dLU.bxq.length() == 0) {
            return this.dLU.bxq;
        }
        return this.dLU.bEP;
    }

    private void cu(boolean z) {
        TransformationMethod instance;
        TextInputEditText textInputEditText = this.dLU.bEP;
        int selectionStart = textInputEditText.getSelectionStart();
        int selectionEnd = textInputEditText.getSelectionEnd();
        if (z) {
            instance = HideReturnsTransformationMethod.getInstance();
        } else {
            instance = PasswordTransformationMethod.getInstance();
        }
        textInputEditText.setTransformationMethod(instance);
        textInputEditText.setSelection(selectionStart, selectionEnd);
    }

    public void onDetach() {
        if (this.dLV != null) {
            this.dLV.b(this);
        }
        super.onDetach();
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        if (!z) {
            return this.dLW.aKJ();
        }
        Animator aKI = this.dLW.aKI();
        aKI.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.aKP();
            }
        });
        return aKI;
    }

    public void co(View view) {
        login();
    }

    private void login() {
        String trim = this.dLU.bxq.getText().toString().trim();
        String obj = this.dLU.bEP.getText().toString();
        if (aD(trim, obj)) {
            am.n(zzakw());
            aKT();
            o.a(com.iqoption.c.a.Jw().a(trim, obj, null, false, false, 0), new a(this), com.iqoption.core.d.a.aSe);
            return;
        }
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_login").setValue(Double.valueOf(0.0d)).build());
    }

    public void cp(View view) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_forgot-pass").build());
        if (this.dLV != null) {
            this.dLV.aKC();
        }
    }

    private void aKR() {
        j.nB().a((Fragment) this, Collections.singletonList("email"));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_facebook").build());
    }

    private void aKS() {
        if (this.dLV != null) {
            this.dLV.zE();
        }
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "login_google").build());
    }

    public void cm(View view) {
        if (this.dLV != null) {
            this.dLV.aKD();
        }
        am.n(zzakw());
    }

    private void aKT() {
        this.dLU.bnd.setEnabled(false);
        this.dLU.bnd.setText(null);
        this.dLU.bnn.show();
        this.dLU.bxq.setEnabled(false);
        this.dLU.bEP.setEnabled(false);
    }

    private void aKU() {
        this.dLU.bnd.setEnabled(true);
        this.dLU.bnd.setText(R.string.login);
        this.dLU.bnn.hide();
        this.dLU.bxq.setEnabled(true);
        this.dLU.bEP.setEnabled(true);
    }

    private boolean aD(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.iqoption.app.a.b.eO(getString(R.string.please_enter_your_email));
            return false;
        } else if (!p.u(str)) {
            com.iqoption.app.a.b.eO(getString(R.string.please_enter_valid_email));
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            return true;
        } else {
            com.iqoption.app.a.b.eO(getString(R.string.please_enter_password));
            return false;
        }
    }
}
