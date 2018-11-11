package com.iqoption.fragment.account.security.touchId;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.d.kb;
import com.iqoption.d.kh;
import com.iqoption.d.ld;
import com.iqoption.widget.DialpadDot;
import com.iqoption.widget.DialpadDot.State;
import com.iqoption.x.R;

public class PasscodeFragment extends Fragment {
    public static final String TAG = "com.iqoption.fragment.account.security.touchId.PasscodeFragment";
    private static final String adO;
    public static int cvl = 600000;
    public static int cvm = DialpadDot.cvm;
    private static int cvp = -1;
    private static int cvq = 6;
    private long adS;
    private com.iqoption.system.b.c cvn;
    private boolean cvo;
    private int cvr;
    private PasscodeScreen cvs;
    private ld cvt;
    private boolean cvu;
    private ViewFactory cvw = new ViewFactory() {
        public View makeView() {
            return PasscodeFragment.this.getLayoutInflater(null).inflate(R.layout.passcode_title_text, (ViewGroup) PasscodeFragment.this.cvt.getRoot(), false);
        }
    };

    public enum PasscodeScreen {
        passcode,
        repeatPasscode,
        newPasscode,
        repeatNewPasscode,
        oldPasscode,
        passcodeToTurnTouchIdOff,
        passcodeVerificationOnLogin
    }

    private class a implements OnClickListener {
        private final int value;

        /* synthetic */ a(PasscodeFragment passcodeFragment, int i, AnonymousClass1 anonymousClass1) {
            this(i);
        }

        private a(int i) {
            this.value = i;
        }

        public void onClick(View view) {
            PasscodeFragment.this.en(this.value);
        }
    }

    public interface b {
        boolean a(PasscodeFragment passcodeFragment, PasscodeScreen passcodeScreen, long j);

        void zt();

        void zu();
    }

    private class c extends com.iqoption.system.b.b {
        private c() {
        }

        /* synthetic */ c(PasscodeFragment passcodeFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void ajK() {
            PasscodeFragment.this.dg(false);
            if (VERSION.SDK_INT >= 21) {
                b(PasscodeFragment.this.cvt.bwv);
            } else {
                ajL();
            }
        }

        public void onAuthenticationError(int i, CharSequence charSequence) {
            super.onAuthenticationError(i, charSequence);
            com.iqoption.app.a.b.b(charSequence.toString(), PasscodeFragment.this.getContext());
        }

        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            kb kbVar = PasscodeFragment.this.cvt.bwv;
            if (VERSION.SDK_INT >= 21) {
                c(kbVar);
            } else {
                PasscodeFragment.this.a(kbVar);
            }
        }

        @TargetApi(21)
        private void b(kb kbVar) {
            Drawable drawable = PasscodeFragment.this.getContext().getDrawable(R.drawable.lockscreen_fingerprint_draw_off_animation);
            kbVar.buO.bvd.setImageDrawable(drawable);
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
                com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                    public void run() {
                        b e = PasscodeFragment.this.ajI();
                        if (e != null) {
                            e.zt();
                        }
                    }
                }, 320);
            }
        }

        private void ajL() {
            kb kbVar = PasscodeFragment.this.cvt.bwv;
            kbVar.buO.bvd.setVisibility(8);
            kbVar.buO.bvg.setVisibility(8);
            kbVar.buO.bvh.setVisibility(0);
            kbVar.buO.bvd.animate().alpha(0.0f);
            kbVar.buO.bvg.animate().alpha(0.0f);
            kbVar.buO.bvh.setScaleX(0.2f);
            kbVar.buO.bvh.setScaleY(0.2f);
            kbVar.buO.bvh.animate().scaleX(1.0f).alpha(1.0f).setInterpolator(new OvershootInterpolator(1.5f));
            kbVar.buO.bvh.animate().scaleY(1.0f).alpha(1.0f).setInterpolator(new OvershootInterpolator(1.5f)).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    b e = PasscodeFragment.this.ajI();
                    if (e != null) {
                        e.zt();
                    }
                }
            });
        }

        @TargetApi(21)
        private void c(final kb kbVar) {
            Drawable drawable = PasscodeFragment.this.getContext().getDrawable(R.drawable.lockscreen_fingerprint_fp_to_error_state_animation);
            kbVar.buO.bvd.setImageDrawable(drawable);
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
                com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                    public void run() {
                        Drawable drawable = PasscodeFragment.this.getContext().getDrawable(R.drawable.lockscreen_fingerprint_error_state_to_fp_animation);
                        kbVar.buO.bvd.setImageDrawable(drawable);
                        if (drawable instanceof AnimatedVectorDrawable) {
                            ((AnimatedVectorDrawable) drawable).start();
                        }
                    }
                }, 1200);
            }
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_PASSCODE_SCREEN");
        adO = stringBuilder.toString();
    }

    public static boolean b(Context context, long j) {
        return j >= 0 && af.aR(context).EP() == j;
    }

    public static void bn(Context context) {
        if (af.aR(context).EP() >= 0) {
            af.aR(context).af(System.currentTimeMillis() + ((long) cvl));
        }
    }

    public static PasscodeFragment a(PasscodeScreen passcodeScreen) {
        PasscodeFragment passcodeFragment = new PasscodeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(adO, passcodeScreen.name());
        passcodeFragment.setArguments(bundle);
        return passcodeFragment;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onStart() {
        super.onStart();
        if (this.cvn != null) {
            this.cvn.startListening();
        }
    }

    public void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            Drawable drawable = this.cvt.bwv.buO.bvd.getDrawable();
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            Drawable drawable = this.cvt.bwv.buO.bvd.getDrawable();
            if (drawable instanceof AnimatedVectorDrawable) {
                drawable.setVisible(false, false);
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (this.cvn != null) {
            this.cvn.stopListening();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cvt = (ld) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account_security_passcode, viewGroup, false);
        this.cvt.a(this);
        PasscodeScreen passcodeScreen = PasscodeScreen.newPasscode;
        Bundle arguments = getArguments();
        if (arguments != null) {
            passcodeScreen = PasscodeScreen.valueOf(arguments.getString(adO, passcodeScreen.name()));
        }
        this.cvt.bwE.setFactory(this.cvw);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_short);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out_short);
        this.cvt.bwE.setInAnimation(loadAnimation);
        this.cvt.bwE.setOutAnimation(loadAnimation2);
        if (passcodeScreen == PasscodeScreen.passcodeVerificationOnLogin) {
            this.cvn = new com.iqoption.system.b.c(getContext(), new c(this, null));
        }
        ajG();
        dh(false);
        b(getContext(), passcodeScreen);
        if (!((getTargetFragment() instanceof b) || (zzakw() instanceof b))) {
            Log.e(TAG, "OnFragmentInteractionListener is not implemented by target fragment or activity");
        }
        return this.cvt.getRoot();
    }

    private void ajG() {
        kb kbVar = this.cvt.bwv;
        boolean z = true;
        a(kbVar.buT, 1, "");
        a(kbVar.buX, 2, "ABC");
        a(kbVar.buW, 3, "DEF");
        a(kbVar.buQ, 4, "GHI");
        a(kbVar.buP, 5, "JKL");
        a(kbVar.buV, 6, "MNO");
        a(kbVar.buU, 7, "PQRS");
        a(kbVar.buN, 8, "TUV");
        a(kbVar.buS, 9, "WXYZ");
        kbVar.buY.getRoot().setOnClickListener(new a(this, 0, null));
        kbVar.buL.getRoot().setOnClickListener(new a(this, cvp, null));
        if (this.cvn == null || !this.cvn.aEt()) {
            z = false;
        }
        this.cvo = z;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isFingerprintEnabled=");
        stringBuilder.append(this.cvo);
        i.d(str, stringBuilder.toString());
        if (this.cvo) {
            kbVar.buO.getRoot().setVisibility(0);
            if (VERSION.SDK_INT >= 21) {
                Drawable drawable = getContext().getDrawable(R.drawable.lockscreen_fingerprint_draw_on_animation);
                drawable.setVisible(false, false);
                kbVar.buO.bvd.setImageDrawable(drawable);
            }
            kbVar.buO.bvd.setVisibility(0);
        } else {
            kbVar.buO.getRoot().setVisibility(4);
        }
        ajH();
    }

    private void a(kh khVar, int i, String str) {
        khVar.bvf.setText(String.valueOf(i));
        khVar.bve.setText(str);
        khVar.getRoot().setOnClickListener(new a(this, i, null));
    }

    private void dg(boolean z) {
        boolean z2 = z ^ 1;
        State state = z ? State.error : State.success;
        if (z || this.cvs == PasscodeScreen.passcodeToTurnTouchIdOff || (this.cvs == PasscodeScreen.passcodeVerificationOnLogin && !this.cvo)) {
            this.cvt.bww.bvc.a(state, z2);
            this.cvt.bwx.bvc.a(state, z2);
            this.cvt.bwy.bvc.a(state, z2);
            this.cvt.bwz.bvc.a(state, z2);
            this.cvt.bwA.bvc.a(state, z2);
            this.cvt.bwB.bvc.a(state, z2);
        }
        if (z && this.cvs != PasscodeScreen.repeatPasscode && this.cvs != PasscodeScreen.repeatNewPasscode) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.shake);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    PasscodeFragment.this.reinitialize();
                }
            });
            this.cvt.bwd.startAnimation(loadAnimation);
        }
    }

    private void dh(boolean z) {
        this.cvt.bww.bvc.a(this.cvr > 0 ? State.enabled : State.disabled, z);
        this.cvt.bwx.bvc.a(this.cvr > 1 ? State.enabled : State.disabled, z);
        this.cvt.bwy.bvc.a(this.cvr > 2 ? State.enabled : State.disabled, z);
        this.cvt.bwz.bvc.a(this.cvr > 3 ? State.enabled : State.disabled, z);
        this.cvt.bwA.bvc.a(this.cvr > 4 ? State.enabled : State.disabled, z);
        this.cvt.bwB.bvc.a(this.cvr > 5 ? State.enabled : State.disabled, z);
    }

    private void ajH() {
        kb kbVar = this.cvt.bwv;
        boolean z = false;
        boolean z2 = this.cvr < cvq;
        if (this.cvr > 0) {
            z = true;
        }
        kbVar.buT.getRoot().setEnabled(z2);
        kbVar.buX.getRoot().setEnabled(z2);
        kbVar.buW.getRoot().setEnabled(z2);
        kbVar.buQ.getRoot().setEnabled(z2);
        kbVar.buP.getRoot().setEnabled(z2);
        kbVar.buV.getRoot().setEnabled(z2);
        kbVar.buU.getRoot().setEnabled(z2);
        kbVar.buN.getRoot().setEnabled(z2);
        kbVar.buS.getRoot().setEnabled(z2);
        kbVar.buY.getRoot().setEnabled(z2);
        kbVar.buL.getRoot().setEnabled(z);
        kbVar.buT.bvf.setEnabled(z2);
        kbVar.buX.bvf.setEnabled(z2);
        kbVar.buW.bvf.setEnabled(z2);
        kbVar.buQ.bvf.setEnabled(z2);
        kbVar.buP.bvf.setEnabled(z2);
        kbVar.buV.bvf.setEnabled(z2);
        kbVar.buU.bvf.setEnabled(z2);
        kbVar.buN.bvf.setEnabled(z2);
        kbVar.buS.bvf.setEnabled(z2);
        kbVar.buY.bvf.setEnabled(z2);
        kbVar.buL.bvd.setEnabled(z);
    }

    public void b(Context context, PasscodeScreen passcodeScreen) {
        if (this.cvs != passcodeScreen) {
            boolean z = this.cvs == null;
            this.cvs = passcodeScreen;
            reinitialize();
            this.cvt.bwD.setVisibility(0);
            this.cvt.bwu.setVisibility(0);
            this.cvt.bwF.setVisibility(8);
            switch (passcodeScreen) {
                case passcode:
                    a(context, (int) R.string.setup_password_title, z);
                    break;
                case repeatPasscode:
                    a(context, (int) R.string.confirm_password_title, z);
                    break;
                case newPasscode:
                    a(context, (int) R.string.setup_password_title, z);
                    break;
                case repeatNewPasscode:
                    a(context, (int) R.string.confirm_password_title, z);
                    break;
                case oldPasscode:
                    a(context, (int) R.string.current_password_title, z);
                    break;
                case passcodeToTurnTouchIdOff:
                    a(context, (int) R.string.current_password_title, z);
                    break;
                case passcodeVerificationOnLogin:
                    this.cvt.bwD.setVisibility(8);
                    this.cvt.bwu.setVisibility(8);
                    this.cvt.bwF.setVisibility(0);
                    this.cvt.bwC.setText(this.cvo ? R.string.enter_passcode_or_use_touchid : R.string.enter_passcode);
                    break;
                default:
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown screen:");
                    stringBuilder.append(passcodeScreen);
                    Log.w(str, stringBuilder.toString());
                    a(context, (int) R.string.setup_password_title, z);
                    break;
            }
        }
    }

    private void a(Context context, @StringRes int i, boolean z) {
        if (z) {
            this.cvt.bwE.setCurrentText(context.getString(i));
        } else {
            this.cvt.bwE.setText(context.getString(i));
        }
    }

    private void reinitialize() {
        this.adS = 0;
        this.cvr = 0;
        this.cvu = false;
        dh(false);
        ajH();
    }

    public void ahJ() {
        this.cvu = false;
        b ajI = ajI();
        if (ajI != null) {
            ajI.zu();
        }
    }

    public void onBackPressed() {
        ahJ();
    }

    private void en(int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onKeyPressed() value=");
        stringBuilder.append(i);
        i.v(str, stringBuilder.toString());
        String str2;
        StringBuilder stringBuilder2;
        if (i == cvp) {
            if (this.cvu) {
                reinitialize();
            } else {
                this.cvr = Math.max(0, this.cvr - 1);
                this.adS /= 10;
                ajH();
                dh(true);
            }
            str2 = TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("passcode=");
            stringBuilder2.append(this.adS);
            i.v(str2, stringBuilder2.toString());
        } else if (this.cvr < cvq) {
            this.adS = (this.adS * 10) + ((long) i);
            this.cvr++;
            dh(true);
            ajH();
            str2 = TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("passcode=");
            stringBuilder2.append(this.adS);
            i.v(str2, stringBuilder2.toString());
            if (this.cvr == cvq) {
                com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                    public void run() {
                        if (PasscodeFragment.this.cvr == PasscodeFragment.cvq) {
                            b e = PasscodeFragment.this.ajI();
                            if (e != null) {
                                PasscodeFragment.this.cvu = e.a(PasscodeFragment.this, PasscodeFragment.this.cvs, PasscodeFragment.this.adS) ^ 1;
                                PasscodeFragment.this.dg(PasscodeFragment.this.cvu);
                            }
                        }
                    }
                }, (long) cvm);
            }
        }
    }

    private b ajI() {
        Fragment targetFragment = getTargetFragment();
        if (zzakw() instanceof b) {
            return (b) zzakw();
        }
        return targetFragment instanceof b ? (b) targetFragment : null;
    }

    private void a(kb kbVar) {
        final kb kbVar2 = kbVar;
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe.ofFloat(0.05f, 0.0f).setInterpolator(new DecelerateInterpolator(1.5f));
        Keyframe ofFloat2 = Keyframe.ofFloat(0.9f, 0.0f);
        Keyframe.ofFloat(1.0f, 1.0f).setInterpolator(new AccelerateInterpolator(1.5f));
        ImageView imageView = kbVar2.buO.bvd;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat, r4, ofFloat2, r8});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolderArr);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe.ofFloat(0.1f, 1.0f).setInterpolator(new OvershootInterpolator(2.0f));
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.9f, 1.0f);
        Keyframe.ofFloat(1.0f, 0.0f).setInterpolator(new DecelerateInterpolator(1.5f));
        ImageView imageView2 = kbVar2.buO.bvg;
        r6 = new PropertyValuesHolder[3];
        r6[0] = PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[]{ofFloat3, r9, ofFloat4});
        r6[1] = PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[]{ofFloat3, r9, ofFloat4});
        r6[2] = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat3, r9, ofFloat5, r1});
        ObjectAnimator.ofPropertyValuesHolder(imageView2, r6).addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                kbVar2.buO.bvg.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                kbVar2.buO.bvg.setVisibility(8);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, r1});
        com.iqoption.util.b.a(animatorSet, 1500);
        animatorSet.start();
    }
}
