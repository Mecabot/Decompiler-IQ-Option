package com.iqoption.quiz;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.iqoption.core.c;
import com.iqoption.core.f;
import com.iqoption.quiz.api.a;
import com.iqoption.quiz.api.b;
import com.squareup.picasso.Picasso;

/* compiled from: QuizProvidersSocket */
public class z implements y {
    private b dgP;
    private s dgQ;
    private ad dgR;
    private a dgS;
    private Gson gson;
    private Picasso picasso;
    private SharedPreferences wv;

    public static y a(Context context, s sVar, ad adVar) {
        y zVar = new z();
        zVar.b(context, sVar, adVar);
        return zVar;
    }

    private void b(Context context, s sVar, ad adVar) {
        c RQ = f.RQ();
        this.dgP = new com.iqoption.quiz.socket.api.c(RQ.Dt());
        this.dgS = new com.iqoption.quiz.socket.api.a(RQ.Dt());
        this.wv = context.getSharedPreferences("iqtrivia", 0);
        this.picasso = Picasso.with(context);
        this.gson = RQ.Dq();
        this.dgQ = sVar;
        this.dgR = adVar;
    }

    public b azi() {
        return this.dgP;
    }

    public a azj() {
        return this.dgS;
    }

    public SharedPreferences azk() {
        return this.wv;
    }

    public Picasso azl() {
        return this.picasso;
    }

    public Gson azm() {
        return this.gson;
    }

    public s azn() {
        return this.dgQ;
    }

    public ad azo() {
        return this.dgR;
    }
}
