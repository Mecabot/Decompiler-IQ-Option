package com.iqoption.quiz;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.iqoption.core.a.d;
import com.iqoption.core.ui.c;
import com.iqoption.core.util.q;
import com.iqoption.dto.ToastEntity;
import com.iqoption.quiz.ae.e;
import com.iqoption.quiz.d.f;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.quiz.widget.CountDownProgressBar;
import io.reactivex.disposables.b;
import java.lang.ref.WeakReference;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity implements com.iqoption.quiz.d.a, j {
    public static final String TAG = "com.iqoption.quiz.QuizActivity";
    private static final CookieManager dfQ = new CookieManager();
    private boolean adF = false;
    @Nullable
    private MediaPlayer dfR;
    private d dfS;
    private com.iqoption.quiz.b.a dfT;
    private af dfU;
    private com.iqoption.quiz.chat.a dfV;
    private f dfW;
    private l dfX;
    private TriviaSocketViewModel dfY;
    private Observer<c<com.iqoption.quiz.api.response.c>> dfZ = new Observer<c<com.iqoption.quiz.api.response.c>>() {
        /* renamed from: a */
        public void onChanged(c<com.iqoption.quiz.api.response.c> cVar) {
            QuizActivity.this.dfY.aBN().removeObserver(QuizActivity.this.dfZ);
            if (((com.iqoption.quiz.api.response.c) cVar.bl(com.iqoption.quiz.api.response.c.dim)).count > 0) {
                QuizActivity.this.dfU.azz();
            } else {
                QuizActivity.this.dfU.azA();
            }
        }
    };
    @Nullable
    private b dga;
    private String dgb = com.iqoption.quiz.model.d.dlw;
    private final Observer<Object> dgc = n.dgg;
    private final Observer<c<Boolean>> dgd = new Observer<c<Boolean>>() {
        /* renamed from: a */
        public void onChanged(c<Boolean> cVar) {
            if (!cVar.isSuccess() || cVar.getData() != Boolean.TRUE) {
                QuizActivity.this.dfU.azC();
                QuizActivity.this.dfU.eq(false);
                QuizActivity.this.ayZ();
            } else if (QuizActivity.this.dfT.dkj.isPlaying()) {
                QuizActivity.this.dfU.azD();
            } else {
                QuizActivity.this.aza();
                io.reactivex.a.b.a.aWm().b(new Runnable() {
                    public void run() {
                        if (QuizActivity.this.dfY.aBJ()) {
                            QuizActivity.this.dfU.azD();
                        }
                    }
                }, 3000, TimeUnit.MILLISECONDS);
            }
        }
    };
    private final Observer<c<Boolean>> dge = new Observer<c<Boolean>>() {
        /* renamed from: a */
        public void onChanged(c<Boolean> cVar) {
            if (!cVar.isSuccess() || cVar.getData() == Boolean.TRUE) {
                QuizActivity.this.dfU.ev(true);
                QuizActivity.this.ayZ();
            } else if (QuizActivity.this.dfT.dkj.isPlaying() || !QuizActivity.this.dfY.aBJ()) {
                QuizActivity.this.dfU.ev(false);
            } else {
                QuizActivity.this.aza();
                io.reactivex.a.b.a.aWm().b(new Runnable() {
                    public void run() {
                        if (!QuizActivity.this.dfY.aBL()) {
                            QuizActivity.this.dfU.ev(false);
                        }
                    }
                }, 3000, TimeUnit.MILLISECONDS);
            }
        }
    };
    private final Observer<c<Boolean>> dgf = new Observer<c<Boolean>>() {
        /* renamed from: a */
        public void onChanged(c<Boolean> cVar) {
            if (((Boolean) cVar.bl(Boolean.valueOf(false))).booleanValue()) {
                QuizActivity.this.dfU.ew(true);
            } else {
                QuizActivity.this.dfU.ew(false);
            }
        }
    };

    private static class a implements Runnable {
        private final WeakReference<QuizActivity> dgr;

        a(QuizActivity quizActivity) {
            this.dgr = new WeakReference(quizActivity);
        }

        public void run() {
            QuizActivity quizActivity = (QuizActivity) this.dgr.get();
            if (quizActivity != null && quizActivity.adF && quizActivity.dfY.aBJ()) {
                quizActivity.aza();
            }
        }
    }

    static final /* synthetic */ void bz(Object obj) {
    }

    public void gh(int i) {
    }

    static {
        dfQ.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CookieHandler.getDefault() != dfQ) {
            CookieHandler.setDefault(dfQ);
        }
        this.dfT = (com.iqoption.quiz.b.a) DataBindingUtil.setContentView(this, e.activity_quiz);
        this.dfT.dkj.setDimensions(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
        this.dfT.dkg.setOnTouchListener(o.ckx);
        this.dfT.dkj.requestLayout();
        this.dfT.dkg.setForeground(new com.iqoption.quiz.widget.d(this, com.iqoption.quiz.ae.a.dp12));
        alZ();
        this.dfY.aCa();
    }

    private void alZ() {
        this.dfY = TriviaSocketViewModel.dmB.x(this);
        this.dfU = new af(this, this.dfT);
        this.dfV = new com.iqoption.quiz.chat.a(this, this.dfT.djT);
        this.dfW = new f(this, this.dfT.dkk);
        this.dfX = new l(this, this.dfT.dkb);
        this.dfY.aBA().removeObserver(this.dgc);
        this.dfY.aBA().observe(this, this.dgc);
        if (TextUtils.isEmpty(this.dfY.getEmail())) {
            this.dfU.a(new i() {
                public boolean onBackPressed() {
                    QuizActivity.this.finish();
                    return false;
                }
            }, new k() {
                public void aw(String str, String str2) {
                    QuizActivity.this.dfY.ax(str, str2);
                }
            });
        }
        this.dfU.azw();
        this.dfY.aBC().removeObservers(this);
        this.dfY.aBC().observe(this, new Observer<c<com.iqoption.quiz.model.c>>() {
            /* renamed from: a */
            public void onChanged(c<com.iqoption.quiz.model.c> cVar) {
                final com.iqoption.quiz.model.c cVar2 = (com.iqoption.quiz.model.c) cVar.getData();
                if (cVar.isSuccess() && cVar2.aBf() >= 0) {
                    QuizActivity.this.dfU.a(cVar2, new CountDownProgressBar.b() {
                        public void a(CountDownProgressBar countDownProgressBar) {
                            Log.d(QuizActivity.TAG, "countdown finish");
                            QuizActivity.this.dfU.azw();
                        }
                    }, new a() {
                        public void az(int i, int i2) {
                            String str = QuizActivity.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(String.valueOf(i));
                            stringBuilder.append(':');
                            stringBuilder.append(i2);
                            Log.d(str, stringBuilder.toString());
                            com.iqoption.quiz.a.a.did.b(cVar2.aBj(), i2, i);
                            QuizActivity.this.dfY.aA(i, i2);
                        }
                    });
                }
            }
        });
        this.dfY.aBD().removeObservers(this);
        this.dfY.aBD().observe(this, new Observer<c<com.iqoption.quiz.model.a>>() {
            /* renamed from: a */
            public void onChanged(c<com.iqoption.quiz.model.a> cVar) {
                if (cVar.isSuccess()) {
                    final com.iqoption.quiz.model.a aVar = (com.iqoption.quiz.model.a) cVar.getData();
                    if (!com.iqoption.quiz.model.a.dlh.equals(aVar)) {
                        QuizActivity.this.dfU.a(aVar, new CountDownProgressBar.b() {
                            public void a(CountDownProgressBar countDownProgressBar) {
                                if (!aVar.aBj() && aVar.aBh() != aVar.aBf()) {
                                    QuizActivity.this.dfU.azw();
                                } else if (aVar.aBk()) {
                                    if (aVar.aBe()) {
                                        QuizActivity.this.dfU.azy();
                                        QuizActivity.this.dfY.aBH().observe(QuizActivity.this, new Observer<c<List<com.iqoption.quiz.d.b>>>() {
                                            /* renamed from: a */
                                            public void onChanged(@Nullable c<List<com.iqoption.quiz.d.b>> cVar) {
                                                if (cVar != null && cVar.getData() != null && !((List) cVar.getData()).isEmpty()) {
                                                    QuizActivity.this.dfY.aBH().removeObserver(this);
                                                    com.iqoption.quiz.d.b bVar = (com.iqoption.quiz.d.b) ((List) cVar.getData()).get(0);
                                                    QuizActivity.this.dfU.b(bVar.Sz(), Double.valueOf(bVar.aDh()));
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    QuizActivity.this.dfU.azA();
                                } else if (aVar.aBe()) {
                                    QuizActivity.this.dfU.azw();
                                } else {
                                    LiveData aBN = QuizActivity.this.dfY.aBN();
                                    aBN.removeObserver(QuizActivity.this.dfZ);
                                    aBN.observe(QuizActivity.this, QuizActivity.this.dfZ);
                                }
                            }
                        });
                    }
                }
            }
        });
        this.dfY.aBO().observe(this, new p(this));
        this.dfY.aCf().observe(this, new q(this));
        this.dfY.aCd().observe(this, new Observer<Boolean>() {
            /* renamed from: k */
            public void onChanged(@Nullable Boolean bool) {
                com.iqoption.quiz.a.a.did.eE(true);
                View root = QuizActivity.this.dfT.dkc.getRoot();
                int i = (bool == null || !bool.booleanValue()) ? 8 : 0;
                root.setVisibility(i);
            }
        });
    }

    final /* synthetic */ void r(Boolean bool) {
        af afVar = this.dfU;
        boolean z = bool == null || !bool.booleanValue();
        afVar.es(z);
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    protected void onStart() {
        com.iqoption.core.f.RQ().aX(q.br(this));
        this.dfY.eM(true);
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        this.dfS = com.iqoption.quiz.a.a.did.azH();
        this.adF = true;
        this.dfU.et(false);
        this.dfU.er(false);
        this.dfY.aBI().removeObserver(this.dgd);
        this.dfY.aBI().observe(this, this.dgd);
        this.dfY.aBK().removeObserver(this.dge);
        this.dfY.aBK().observe(this, this.dge);
        this.dfY.aBM().removeObserver(this.dgf);
        this.dfY.aBM().observe(this, this.dgf);
    }

    public void onPause() {
        super.onPause();
        if (this.dfS != null) {
            this.dfS.Bs();
        }
        this.adF = false;
    }

    protected void onStop() {
        ayZ();
        if (this.dga != null) {
            this.dga.dispose();
        }
        this.dfY.eM(false);
        super.onStop();
        com.iqoption.core.f.RQ().m(q.br(this), ToastEntity.ACTION_TOAST_DURATION);
    }

    public void onDestroy() {
        ayZ();
        if (this.dfU != null) {
            this.dfU.destroy();
        }
        super.onDestroy();
    }

    private void ayZ() {
        if (this.dfT.dkj.isPlaying()) {
            this.dfT.dkj.stopPlayback();
        }
        this.dfU.er(false);
        this.dfR = null;
    }

    private void aza() {
        if (this.dfT.dkj.isPlaying()) {
            ayZ();
        }
        Log.d(TAG, "start play");
        this.dfT.dkj.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                QuizActivity.this.dfR = mediaPlayer;
                QuizActivity.this.dfU.er(false);
                mediaPlayer.setOnInfoListener(new OnInfoListener() {
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                        String str = QuizActivity.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("player warning ");
                        stringBuilder.append(i);
                        stringBuilder.append('/');
                        stringBuilder.append(i2);
                        Log.e(str, stringBuilder.toString());
                        if (i == 701) {
                            QuizActivity.this.dfU.er(true);
                            QuizActivity.this.azb();
                        }
                        return false;
                    }
                });
            }
        });
        this.dfT.dkj.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String str = QuizActivity.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("player error ");
                stringBuilder.append(i);
                Log.e(str, stringBuilder.toString());
                QuizActivity.this.azb();
                return true;
            }
        });
        this.dfT.dkj.setVideoURI(Uri.parse(this.dgb));
        this.dfT.dkj.start();
    }

    private void azb() {
        io.reactivex.a.b.a.aWm().b(new a(this), 3000, TimeUnit.MILLISECONDS);
    }

    public void gi(int i) {
        switch (i) {
            case 1:
                this.dfY.aBT();
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName());
            if (findFragmentByTag != null && (findFragmentByTag instanceof i) && ((i) findFragmentByTag).onBackPressed()) {
                return;
            }
        }
        for (Fragment fragment : supportFragmentManager.getFragments()) {
            if (fragment.isVisible() && (fragment instanceof i) && ((i) fragment).onBackPressed()) {
                return;
            }
        }
        super.onBackPressed();
    }

    public void ayW() {
        LiveData aBS = this.dfY.aBS();
        this.dfU.et(true);
        aBS.removeObservers(this);
        aBS.observe(this, new r(this, aBS));
    }

    private void ja(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dfU.et(true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://iqoption.onelink.me/2398275754?pid=share&af_dp=iqoption%3A%2F%2Fquiz%2F%3Fcode%3D");
            stringBuilder.append(str);
            af.a((Activity) this, stringBuilder.toString(), str);
        }
    }
}
