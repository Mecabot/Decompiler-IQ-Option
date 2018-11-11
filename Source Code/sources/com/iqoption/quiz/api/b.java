package com.iqoption.quiz.api;

import android.support.annotation.NonNull;
import com.iqoption.quiz.api.response.StatType;
import com.iqoption.quiz.api.response.a;
import com.iqoption.quiz.api.response.d;
import com.iqoption.quiz.api.response.f;
import com.iqoption.quiz.api.response.g;
import com.iqoption.quiz.api.response.h;
import com.iqoption.quiz.api.response.i;
import com.iqoption.quiz.api.response.j;
import com.iqoption.quiz.api.response.k;
import com.iqoption.quiz.api.response.m;
import com.iqoption.quiz.api.response.n;
import com.iqoption.quiz.api.response.o;
import com.iqoption.quiz.api.response.q;
import io.reactivex.e;
import java.util.List;

/* compiled from: TriviaApi */
public interface b {
    e<Object> a(f fVar);

    e<o> a(g gVar);

    e<Object> a(m mVar);

    e<h> a(n nVar);

    io.reactivex.o<List<j>> a(@NonNull StatType statType);

    io.reactivex.o<Object> aAc();

    e<List<com.iqoption.quiz.api.response.b>> aAd();

    e<d> jg(String str);

    e<com.iqoption.quiz.api.response.e> jh(String str);

    e<a> ji(String str);

    e<o> jj(String str);

    e<i> jk(String str);

    e<q> jl(String str);

    e<k> jm(String str);
}
