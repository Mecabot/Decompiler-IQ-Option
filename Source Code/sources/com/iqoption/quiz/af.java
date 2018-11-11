package com.iqoption.quiz;

import android.app.Activity;
import android.app.FragmentManager;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import com.iqoption.core.a.d;
import com.iqoption.core.f;
import com.iqoption.quiz.ae.b;
import com.iqoption.quiz.ae.g;
import com.iqoption.quiz.ae.h;
import com.iqoption.quiz.api.response.k;
import com.iqoption.quiz.b.c;
import com.iqoption.quiz.b.o;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.quiz.widget.CountDownProgressBar;
import java.util.List;
import java.util.Locale;

/* compiled from: TriviaScreenManager */
public class af {
    private static final String TAG = "com.iqoption.quiz.af";
    private final FragmentActivity csX;
    private final TriviaSocketViewModel dfY;
    private final o dhA;
    private final c dhB;
    private final int dhC;
    private MediaPlayer dhD;
    private MediaPlayer dhE;
    private d dhF;
    private final Observer<com.iqoption.core.ui.c<Integer>> dhG = new Observer<com.iqoption.core.ui.c<Integer>>() {
        /* renamed from: a */
        public void onChanged(@Nullable com.iqoption.core.ui.c<Integer> cVar) {
            int intValue = ((Integer) cVar.bl(Integer.valueOf(-1))).intValue();
            if (intValue >= 0) {
                af.this.dhz.dka.dky.setText(aj.dhZ.gm(intValue));
            }
        }
    };
    private final Observer<com.iqoption.core.ui.c<k>> dhH = new Observer<com.iqoption.core.ui.c<k>>() {
        /* renamed from: a */
        public void onChanged(@Nullable com.iqoption.core.ui.c<k> cVar) {
            if (cVar == null || ((k) cVar.bl(k.diB)).aAu() < 0) {
                af.this.dhz.dka.dkK.setVisibility(0);
                af.this.dhz.dka.dkM.setVisibility(8);
                return;
            }
            af.this.dhz.dka.dkK.setVisibility(4);
            af.this.dhz.dka.dkM.setVisibility(0);
        }
    };
    private final Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>> dhI = new Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>>() {
        /* renamed from: a */
        public void onChanged(com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c> cVar) {
            af.this.dhz.dka.dkN.setText(String.valueOf(((com.iqoption.quiz.api.response.c) cVar.bl(com.iqoption.quiz.api.response.c.dim)).count));
        }
    };
    private Observer<com.iqoption.core.ui.c<Integer>> dhJ = new Observer<com.iqoption.core.ui.c<Integer>>() {
        /* renamed from: a */
        public void onChanged(com.iqoption.core.ui.c<Integer> cVar) {
            int intValue = ((Integer) cVar.bl(Integer.valueOf(-1))).intValue();
            if (intValue >= 0) {
                af.this.dhA.dky.setText(aj.dhZ.gm(intValue));
            }
        }
    };
    private Observer<com.iqoption.core.ui.c<Integer>> dhK = new Observer<com.iqoption.core.ui.c<Integer>>() {
        /* renamed from: a */
        public void onChanged(com.iqoption.core.ui.c<Integer> cVar) {
            int intValue = ((Integer) cVar.bl(Integer.valueOf(-1))).intValue();
            if (intValue >= 0) {
                af.this.dhB.dky.setText(aj.dhZ.gm(intValue));
            }
        }
    };
    private Observer<com.iqoption.core.ui.c<Integer>> dhL = new Observer<com.iqoption.core.ui.c<Integer>>() {
        /* renamed from: a */
        public void onChanged(com.iqoption.core.ui.c<Integer> cVar) {
            int intValue = ((Integer) cVar.bl(Integer.valueOf(-1))).intValue();
            if (intValue >= 0) {
                af.this.dhz.dkh.dky.setText(aj.dhZ.gm(intValue));
            }
        }
    };
    private Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>> dhM = new Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>>() {
        /* renamed from: a */
        public void onChanged(com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c> cVar) {
            af.this.dhz.dkh.dkN.setText(af.this.gl(((com.iqoption.quiz.api.response.c) cVar.bl(com.iqoption.quiz.api.response.c.dim)).total));
        }
    };
    private Drawable dhN;
    private Drawable dhO;
    private final com.iqoption.quiz.b.a dhz;

    /* compiled from: TriviaScreenManager */
    private class a extends com.iqoption.quiz.widget.c {
        private final boolean dhW;

        /* synthetic */ a(af afVar, boolean z, AnonymousClass1 anonymousClass1) {
            this(z);
        }

        private a(boolean z) {
            this.dhW = z;
        }

        public void q(View view) {
            if (af.this.csX instanceof j) {
                if (this.dhW) {
                    com.iqoption.quiz.a.a.did.azQ();
                } else {
                    com.iqoption.quiz.a.a.did.azR();
                }
                ((j) af.this.csX).ayW();
            }
        }
    }

    public af(FragmentActivity fragmentActivity, com.iqoption.quiz.b.a aVar) {
        this.csX = fragmentActivity;
        this.dhz = aVar;
        this.dhA = this.dhz.dkd;
        this.dhB = this.dhz.djQ;
        this.dfY = TriviaSocketViewModel.dmB.x(fragmentActivity);
        this.dhC = fragmentActivity.getResources().getInteger(ae.d.quiz_q_time);
        this.dhz.djQ.dkv.setCompoundDrawablesWithIntrinsicBounds(b.ic_check_white_20dp, 0, 0, 0);
        this.dhz.djQ.dkx.setCompoundDrawablesWithIntrinsicBounds(b.ic_close_white_20dp, 0, 0, 0);
        this.dhz.dka.dkK.setCompoundDrawablesWithIntrinsicBounds(0, 0, b.ic_heart_dp16, 0);
        this.dhD = MediaPlayer.create(fragmentActivity, g.final_question_12_sec_countdown_mp3);
        this.dhE = MediaPlayer.create(fragmentActivity, g.answer_12_sec_left_countdown_mp3);
    }

    public void destroy() {
        if (this.dhF != null) {
            this.dhF.Bs();
            this.dhF = null;
        }
        this.dfY.aBB().removeObservers(this.csX);
        this.dfY.aBN().removeObservers(this.csX);
    }

    public void azw() {
        ex(false);
        this.dhA.getRoot().setVisibility(8);
        this.dhB.getRoot().setVisibility(8);
        this.dhz.dka.getRoot().setVisibility(0);
        this.dhz.dka.dkK.setOnClickListener(new a(this, false, null));
        this.dfY.aBO().removeObserver(this.dhH);
        this.dfY.aBO().observe(this.csX, this.dhH);
        this.dfY.aBB().removeObserver(this.dhG);
        this.dfY.aBB().observe(this.csX, this.dhG);
        this.dfY.aBN().removeObserver(this.dhI);
        this.dfY.aBN().observe(this.csX, this.dhI);
    }

    public void a(final com.iqoption.quiz.model.c cVar, CountDownProgressBar.b bVar, final a aVar) {
        com.iqoption.quiz.a.a.did.e(cVar.aBj(), cVar.aBf());
        ex(true);
        azB();
        if (cVar.aBk()) {
            this.dhE.seekTo(0);
            this.dhE.start();
        } else {
            this.dhD.seekTo(0);
            this.dhD.start();
        }
        List asA = cVar.asA();
        CharSequence aBi = cVar.aBi();
        int aBg = cVar.aBg();
        final int aBf = cVar.aBf();
        if (asA.size() != 3) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid answers size ");
            stringBuilder.append(asA.size());
            Log.e(str, stringBuilder.toString());
            return;
        }
        this.dhB.getRoot().setVisibility(8);
        this.dhz.dka.getRoot().setVisibility(8);
        this.dhA.getRoot().setVisibility(0);
        this.dhA.dkw.setVisibility(0);
        this.dhA.dky.setVisibility(0);
        this.dfY.aBB().removeObserver(this.dhJ);
        this.dfY.aBB().observe(this.csX, this.dhJ);
        this.dhA.dkR.setVisibility(0);
        this.dhA.dkR.reset();
        this.dhA.dkR.start();
        this.dhA.dkR.setCountDownFinishListener(bVar);
        this.dhA.dkz.setText(this.csX.getString(h.question_n_of_m, new Object[]{Integer.toString(aBf + 1), Integer.toString(aBg)}));
        this.dhA.dkA.setText(aBi);
        azx();
        this.dhA.dkl.setText((CharSequence) asA.get(0));
        this.dhA.dkl.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view.performHapticFeedback(1);
                af.this.azx();
                view.setSelected(true);
                com.iqoption.quiz.a.a.did.c(cVar.aBj(), 0, aBf);
                aVar.az(aBf, 0);
            }
        });
        this.dhA.dkm.setText((CharSequence) asA.get(1));
        this.dhA.dkm.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view.performHapticFeedback(1);
                af.this.azx();
                view.setSelected(true);
                com.iqoption.quiz.a.a.did.c(cVar.aBj(), 1, aBf);
                aVar.az(aBf, 1);
            }
        });
        this.dhA.dkn.setText((CharSequence) asA.get(2));
        this.dhA.dkn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view.performHapticFeedback(1);
                af.this.azx();
                view.setSelected(true);
                com.iqoption.quiz.a.a.did.c(cVar.aBj(), 2, aBf);
                aVar.az(aBf, 2);
            }
        });
        if (!cVar.aBj()) {
            azx();
        }
    }

    private void azx() {
        this.dhA.dkl.setSelected(false);
        this.dhA.dkm.setSelected(false);
        this.dhA.dkn.setSelected(false);
        this.dhA.dkl.setOnClickListener(null);
        this.dhA.dkm.setOnClickListener(null);
        this.dhA.dkn.setOnClickListener(null);
    }

    public void a(com.iqoption.quiz.model.a aVar, CountDownProgressBar.b bVar) {
        com.iqoption.quiz.a.a.did.c(aVar.aBj(), aVar.aBc(), aVar.aBf());
        ex(true);
        azB();
        List asA = aVar.asA();
        List aAe = aVar.aAe();
        CharSequence aBi = aVar.aBi();
        int aBf = aVar.aBf();
        int aBd = aVar.aBd();
        int aBb = aVar.aBb();
        int aBc = aVar.aBc();
        int aBg = aVar.aBg();
        String str;
        StringBuilder stringBuilder;
        if (asA.size() != 3) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("invalid answers size (r) ");
            stringBuilder.append(asA.size());
            Log.e(str, stringBuilder.toString());
        } else if (aAe.size() != 3) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("invalid counters size ");
            stringBuilder.append(aAe.size());
            Log.e(str, stringBuilder.toString());
        } else {
            this.dhA.getRoot().setVisibility(8);
            this.dhz.dka.getRoot().setVisibility(8);
            this.dhB.getRoot().setVisibility(0);
            this.dhB.dkw.setVisibility(0);
            this.dhB.dky.setVisibility(0);
            this.dfY.aBB().removeObserver(this.dhK);
            this.dfY.aBB().observe(this.csX, this.dhK);
            this.dhB.dkr.reset();
            this.dhB.dkr.start();
            this.dhB.dkr.setCountDownFinishListener(bVar);
            this.dhB.dkz.setText(this.csX.getString(h.question_n_of_m, new Object[]{Integer.toString(aBf + 1), Integer.toString(aBg)}));
            this.dhB.dkA.setText(aBi);
            this.dhB.dko.setText(((Integer) aAe.get(0)).toString());
            this.dhB.dkl.setText((CharSequence) asA.get(0));
            int i = aBd;
            int i2 = aBb;
            int i3 = aBc;
            a(this.dhB.dks, ((Integer) aAe.get(0)).intValue(), 0, i, i2, i3);
            this.dhB.dkp.setText(((Integer) aAe.get(1)).toString());
            this.dhB.dkm.setText((CharSequence) asA.get(1));
            a(this.dhB.dkt, ((Integer) aAe.get(1)).intValue(), 1, i, i2, i3);
            this.dhB.dkq.setText(((Integer) aAe.get(2)).toString());
            this.dhB.dkn.setText((CharSequence) asA.get(2));
            a(this.dhB.dku, ((Integer) aAe.get(2)).intValue(), 2, i, i2, i3);
            if (aBc == -1) {
                this.dhB.dkv.setVisibility(8);
                this.dhB.dkx.setVisibility(8);
            } else if (aBc == aBb) {
                this.dhB.dkv.setVisibility(0);
                this.dhB.dkx.setVisibility(8);
            } else {
                this.dhB.dkx.setVisibility(0);
                this.dhB.dkv.setVisibility(8);
            }
        }
    }

    public void azy() {
        this.dhB.getRoot().setVisibility(8);
    }

    private void a(ProgressBar progressBar, int i, int i2, int i3, int i4, int i5) {
        progressBar.setMax(i3);
        if (VERSION.SDK_INT >= 24) {
            progressBar.setProgress(i, true);
        } else {
            progressBar.setProgress(i);
        }
        if (i2 == i5) {
            if (i5 == i4) {
                progressBar.setProgressDrawable(ContextCompat.getDrawable(this.csX, b.answer_green_progress));
            } else {
                progressBar.setProgressDrawable(ContextCompat.getDrawable(this.csX, b.answer_red_progress));
            }
        } else if (i2 == i4) {
            progressBar.setProgressDrawable(ContextCompat.getDrawable(this.csX, b.answer_green_progress_over));
        } else {
            progressBar.setProgressDrawable(ContextCompat.getDrawable(this.csX, b.answer_gray_progress));
        }
    }

    public void azz() {
        azw();
        this.dhz.djX.setVisibility(0);
        FragmentManager fragmentManager = this.csX.getFragmentManager();
        fragmentManager.beginTransaction().add(ae.c.dialogContainer, d.a(this.csX.getString(h.use_an_extra_life_to_continue), this.csX.getString(h.repay_life_and_continue_to_play), this.csX.getString(h.repay_life), true, 1, 0.0d), d.TAG).setCustomAnimations(17498112, 17498113).addToBackStack(d.TAG).commitAllowingStateLoss();
    }

    public void azA() {
        azw();
        this.dhz.djX.setVisibility(0);
        FragmentManager fragmentManager = this.csX.getFragmentManager();
        fragmentManager.beginTransaction().add(ae.c.dialogContainer, d.a(this.csX.getString(h.you_are_out_of_the_game), this.csX.getString(h.continue_to_watch_live), this.csX.getString(h.continue_), false, 2, 0.0d), d.TAG).setCustomAnimations(17498112, 17498113).addToBackStack(d.TAG).commitAllowingStateLoss();
    }

    public void b(String str, Double d) {
        FragmentActivity fragmentActivity;
        int i;
        Object[] objArr;
        FragmentActivity fragmentActivity2;
        int i2;
        azB();
        azw();
        this.dhz.djX.setVisibility(0);
        boolean Dh = f.Dr().Dh();
        FragmentManager fragmentManager = this.csX.getFragmentManager();
        if (Dh) {
            fragmentActivity = this.csX;
            i = h.congratulations_you_won_n_points;
            objArr = new Object[]{str};
        } else {
            fragmentActivity = this.csX;
            i = h.congratulations_you_won_n;
            objArr = new Object[]{str};
        }
        String string = fragmentActivity.getString(i, objArr);
        if (Dh) {
            fragmentActivity2 = this.csX;
            i2 = h.hold_on_to_your_points_as_you_will_need_them_soon;
        } else {
            fragmentActivity2 = this.csX;
            i2 = h.we_will_deposit_them_to_your_iq_account;
        }
        fragmentManager.beginTransaction().add(ae.c.dialogContainer, d.a(string, fragmentActivity2.getString(i2), this.csX.getString(h.quiz_close), false, 3, d.doubleValue()), d.TAG).setCustomAnimations(17498112, 17498113).addToBackStack(d.TAG).commitAllowingStateLoss();
    }

    public void a(i iVar, k kVar) {
        this.dhz.djY.getRoot().setVisibility(0);
        this.dhz.djY.dkG.setOnClickListener(new ag(this, iVar));
        this.dhz.djY.dkH.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (aj.dhZ.z(af.this.dhz.djY.dkH.getText().toString().trim())) {
                    af.this.dhz.djY.bQB.setEnabled(true);
                } else {
                    af.this.dhz.djY.bQB.setEnabled(false);
                }
            }
        });
        this.dhz.djY.bQB.setOnClickListener(new ah(this, kVar));
    }

    private void R(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.csX.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void azB() {
        R(this.dhz.djT.dkD);
    }

    private String gl(int i) {
        return this.csX.getResources().getQuantityString(ae.f.n_lives, i, new Object[]{String.valueOf(i)});
    }

    public void azC() {
        com.iqoption.core.ui.c cVar = (com.iqoption.core.ui.c) this.dfY.aBI().getValue();
        if (cVar == null || !((Boolean) cVar.bl(Boolean.valueOf(false))).booleanValue()) {
            View root = this.dhz.dkh.getRoot();
            if (root.getVisibility() != 0) {
                com.iqoption.quiz.a.a.did.eB(true);
                this.dhF = com.iqoption.quiz.a.a.did.ey(true);
                azB();
                root.setVisibility(0);
                this.dfY.aBB().removeObserver(this.dhL);
                this.dfY.aBB().observe(this.csX, this.dhL);
                this.dfY.aBE().observe(this.csX, new ai(this));
                this.dhz.dkh.dky.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(1)}));
                this.dfY.aBN().removeObserver(this.dhM);
                this.dfY.aBN().observe(this.csX, this.dhM);
                this.dhz.dkh.dkZ.setOnClickListener(new a(this, true, null));
            }
        }
    }

    public void azD() {
        View root = this.dhz.dkh.getRoot();
        if (root.getVisibility() != 8) {
            if (this.dhF != null) {
                this.dhF.Bs();
                this.dhF = null;
            }
            com.iqoption.quiz.a.a.did.eC(true);
            root.setVisibility(8);
        }
    }

    public void eq(boolean z) {
        View root = this.dhz.dkk.getRoot();
        int visibility = root.getVisibility();
        if (z && visibility == 8) {
            azB();
            root.setVisibility(0);
        } else if (!z && visibility == 0) {
            root.setVisibility(8);
        }
    }

    public void er(boolean z) {
        if (z) {
            if (this.dhz.djR.getVisibility() != 0) {
                this.dhz.djR.setAlpha(0.0f);
                this.dhz.djR.setVisibility(0);
                this.dhz.djR.animate().alpha(1.0f);
            }
        } else if (this.dhz.djR.getVisibility() != 8) {
            this.dhz.djR.setVisibility(8);
        }
    }

    public void es(boolean z) {
        if (z) {
            if (this.dhz.djU.getVisibility() != 0) {
                this.dhz.djU.setAlpha(0.0f);
                this.dhz.djU.setVisibility(0);
                this.dhz.djU.animate().alpha(1.0f);
            }
        } else if (this.dhz.djU.getVisibility() != 8) {
            this.dhz.djU.setVisibility(8);
        }
    }

    public void et(boolean z) {
        if (z && this.dhz.bqo.getVisibility() != 0) {
            this.dhz.bqo.setVisibility(0);
        } else if (!z && this.dhz.bqo.getVisibility() != 8) {
            this.dhz.bqo.setVisibility(8);
        }
    }

    public void eu(boolean z) {
        if (z && this.dhz.djS.getVisibility() != 0) {
            this.dhz.djS.setVisibility(0);
        } else if (!z && this.dhz.djS.getVisibility() != 8) {
            this.dhz.djS.setVisibility(8);
        }
    }

    public void ev(boolean z) {
        View root = this.dhz.djZ.getRoot();
        if (z && root.getVisibility() != 0) {
            com.iqoption.quiz.a.a.did.eA(true);
            root.setVisibility(0);
        } else if (!z && root.getVisibility() != 8) {
            root.setVisibility(8);
        }
    }

    public void ew(boolean z) {
        View root = this.dhz.dke.getRoot();
        if (z && root.getVisibility() != 0) {
            com.iqoption.quiz.a.a.did.eD(true);
            root.setVisibility(0);
        } else if (!z && root.getVisibility() != 8) {
            com.iqoption.quiz.a.a.did.eD(false);
            root.setVisibility(8);
        }
    }

    public static void a(Activity activity, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            str = String.format(Locale.US, "%s\n%s. %s: %s", new Object[]{activity.getString(h.share_referral_code_link), str, activity.getString(h.promo_code), str2});
            str2 = activity.getString(h.share_referral_code_link_title);
            CharSequence string = activity.getString(h.invite_friend);
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType("text/plain");
            activity.startActivity(Intent.createChooser(intent, string));
        }
    }

    private void ex(boolean z) {
        if (this.dhN == null) {
            this.dhN = this.dhz.dkg.getForeground();
        }
        if (this.dhO == null) {
            this.dhO = new LayerDrawable(new Drawable[]{this.dhN, ContextCompat.getDrawable(this.csX, b.bg_questions)});
        }
        if (z) {
            this.dhz.dkg.setForeground(this.dhO);
        } else {
            this.dhz.dkg.setForeground(this.dhN);
        }
    }
}
