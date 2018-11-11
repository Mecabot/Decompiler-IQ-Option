package com.iqoption.quiz.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.iqoption.quiz.aj;
import com.iqoption.quiz.api.a;
import com.iqoption.quiz.api.b;
import com.iqoption.quiz.api.response.c;
import com.iqoption.quiz.api.response.e;
import com.iqoption.quiz.api.response.h;
import com.iqoption.quiz.api.response.i;
import com.iqoption.quiz.api.response.k;
import com.iqoption.quiz.api.response.n;
import com.iqoption.quiz.api.response.o;
import com.iqoption.quiz.api.response.q;
import com.iqoption.quiz.m;
import com.jumio.commons.remote.exception.UnexpectedResponseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import retrofit2.HttpException;

public class TriviaViewModel extends ViewModel {
    private static final String TAG = "com.iqoption.quiz.model.TriviaViewModel";
    private static int dnD = -1;
    private static int dnE = 12;
    private static volatile String uQ = "";
    private final b dgP;
    private final a dgS;
    private int dma;
    private int dmb;
    private MutableLiveData<String> dme;
    private MutableLiveData<k> dnA;
    private MutableLiveData<String> dnB;
    private int dnC;
    private MutableLiveData<String> dnp;
    private MutableLiveData<Integer> dnq;
    private MutableLiveData<c> dnr;
    private MutableLiveData<a> dnt;
    private MutableLiveData<c> dnu;
    private MutableLiveData<List<com.iqoption.quiz.api.response.a.b>> dnv;
    private MutableLiveData<List<com.iqoption.quiz.chat.b>> dnw;
    private MutableLiveData<i> dnx;
    private MutableLiveData<q> dny;
    private MutableLiveData<List<com.iqoption.quiz.d.b>> dnz;
    private Random random;
    private ScheduledExecutorService scheduler;
    private final SharedPreferences wv;

    static final /* synthetic */ void aCv() {
    }

    @NonNull
    public static String getEmail() {
        return m.ayY().azk().getString("c575837759cafa", "");
    }

    public TriviaViewModel() {
        this.scheduler = new ScheduledThreadPoolExecutor(1);
        this.random = new Random();
        this.wv = m.ayY().azk();
        this.dnp = new MutableLiveData();
        this.dnq = new MutableLiveData();
        this.dnr = new MutableLiveData();
        this.dnt = new MutableLiveData();
        this.dnu = new MutableLiveData();
        this.dnv = new MutableLiveData();
        this.dnw = new MutableLiveData();
        this.dnx = new MutableLiveData();
        this.dny = new MutableLiveData();
        this.dnz = new MutableLiveData();
        this.dnA = new MutableLiveData();
        this.dnB = new MutableLiveData();
        this.dme = new MutableLiveData();
        this.dnC = 0;
        this.dma = -1;
        this.dmb = -1;
        this.dgP = m.ayY().azi();
        this.dgS = m.ayY().azj();
        this.dma = this.wv.getInt("c5982358759cafa", -1);
        this.dmb = -1;
        this.dnA.setValue(new k().eG(this.wv.getBoolean("c5c7ew7593423a", false)));
        aCl();
        this.scheduler.scheduleWithFixedDelay(new n(this), 0, 1000, TimeUnit.MILLISECONDS);
        this.scheduler.scheduleWithFixedDelay(new o(this), 0, 2000, TimeUnit.MILLISECONDS);
        this.scheduler.scheduleWithFixedDelay(x.alc, 0, 10000, TimeUnit.MILLISECONDS);
    }

    final /* synthetic */ void aCx() {
        aCm();
        aCr();
        aCs();
        aCn();
        aCp();
        aCq();
        aCo();
        aCu();
    }

    protected void onCleared() {
        this.scheduler.shutdownNow();
        super.onCleared();
    }

    private void aCl() {
        if (uQ.isEmpty()) {
            Object email = getEmail();
            if (!TextUtils.isEmpty(email)) {
                this.dgP.a(new n(email, "")).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a(new p(this), new q(this));
            }
        }
    }

    final /* synthetic */ void a(h hVar) {
        Log.d(TAG, hVar.toString());
        uQ = hVar.FC();
        m.ayY().azk().edit().putString("c5c77759cafa", uQ).apply();
        this.dnp.postValue(uQ);
    }

    private void error(Throwable th) {
        Log.e(TAG, th.toString(), th);
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            if ((httpException.code() == 500 || httpException.code() == UnexpectedResponseException.STATUS_CODE_UNAUTHORIZED) && this.dnC == 0) {
                uQ = "";
                this.dnC = 1;
                aCl();
            }
        }
    }

    private void aCm() {
        if (!uQ.isEmpty() && this.dnq.hasActiveObservers()) {
            this.dgP.jg(uQ).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a(new r(this), new s(this));
        }
    }

    private void aCn() {
        if (!uQ.isEmpty()) {
            this.dgP.jj(uQ).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a(new t(this), new u(this));
        }
    }

    final /* synthetic */ void e(o oVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("userResponse ");
        stringBuilder.append(oVar);
        Log.v(str, stringBuilder.toString());
        c cVar = new c();
        cVar.count = oVar.aAE();
        cVar.total = oVar.aAF();
        this.dnu.setValue(cVar);
    }

    private void aCo() {
        if (!uQ.isEmpty() && this.dnq.hasActiveObservers()) {
            this.dgP.jk(uQ).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a(new v(this), new w(this));
        }
    }

    private void aCp() {
        if (!uQ.isEmpty()) {
            if (this.dny.hasActiveObservers()) {
                this.dgP.jl(uQ).d(io.reactivex.e.a.aXt()).d(y.dnG).c(io.reactivex.a.b.a.aWm()).a(new z(this), new aa(this));
            }
            if (this.dnz.hasActiveObservers()) {
                this.dgP.jl(uQ).d(io.reactivex.e.a.aXt()).d(ab.dnG).c(io.reactivex.a.b.a.aWm()).a(new ac(this), new ad(this));
            }
        }
    }

    final /* synthetic */ void bg(List list) {
        this.dnz.postValue(list);
    }

    private void aCq() {
        if (!uQ.isEmpty()) {
            if (this.dnq.hasActiveObservers() || this.dnA.hasActiveObservers()) {
                this.dgP.jm(uQ).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a(new ae(this), new af(this));
            }
        }
    }

    private void aCr() {
        if (!uQ.isEmpty() && this.dnr.hasActiveObservers()) {
            this.dgP.jh(uQ).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).bX(e.dio).a(new ag(this), new ah(this));
        }
    }

    private void gr(int i) {
        this.dma = i;
        this.wv.edit().putInt("c5982358759cafa", i).apply();
    }

    private void aCs() {
        if (!uQ.isEmpty() && this.dnr.hasActiveObservers()) {
            this.dgP.ji(uQ).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).bX(com.iqoption.quiz.api.response.a.die).a(new ai(this), new aj(this));
        }
    }

    private void aCt() {
        if (!uQ.isEmpty()) {
            if (this.dnv.hasActiveObservers()) {
                this.dgS.aAb().d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).d(ak.dnG).a(new al(this), new am(this));
            }
            if (this.dnw.hasActiveObservers()) {
                this.dgS.aAb().d(an.dnG).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a(new ao(this), new ap(this));
            }
        }
    }

    final /* synthetic */ void be(List list) {
        this.dnv.postValue(list);
    }

    static final /* synthetic */ List bd(List list) {
        List arrayList = new ArrayList();
        Collections.reverse(list);
        for (com.iqoption.quiz.api.response.a.b bVar : list.subList(0, Math.min(100, list.size()))) {
            String valueOf = String.valueOf(bVar.getId());
            String userId = bVar.getUserId();
            String aAN = bVar.aAN();
            aj.a jd = aj.dhZ.jd(bVar.aAM());
            String initials = jd.getInitials();
            String fullName = jd.getFullName();
            arrayList.add(new com.iqoption.quiz.chat.b(valueOf, userId, aAN, initials, com.iqoption.quiz.c.a.jD(fullName), fullName, bVar.getText(), bVar.aAO().booleanValue()));
        }
        return arrayList;
    }

    final /* synthetic */ void bc(List list) {
        this.dnw.setValue(list);
    }

    private void aCu() {
        if (!uQ.isEmpty()) {
            if (this.dnq.hasActiveObservers() || this.dnB.hasActiveObservers()) {
                this.dgP.jj(uQ).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a(new aq(this), new ar(this));
            }
        }
    }
}
