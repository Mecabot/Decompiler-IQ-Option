package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.iqoption.core.ui.c;
import com.iqoption.quiz.api.b;
import com.iqoption.quiz.m;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import retrofit2.HttpException;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/quiz/model/TriviaSplashViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "splash", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/SplashResponse;", "getSplash", "()Landroid/arch/lifecycle/LiveData;", "splash$delegate", "Lkotlin/Lazy;", "triviaApi", "Lcom/iqoption/quiz/api/TriviaApi;", "error", "", "throwable", "", "tag", "", "Companion", "quiz_release"})
/* compiled from: TriviaSplashViewModel.kt */
public final class TriviaSplashViewModel extends ViewModel {
    private static final String TAG = "com.iqoption.quiz.model.TriviaSplashViewModel";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSplashViewModel.class), "splash", "getSplash()Landroid/arch/lifecycle/LiveData;"))};
    private static final String dnl = "";
    public static final a dnm = new a();
    private final b dgP;
    private final d dmj = g.f(new TriviaSplashViewModel$splash$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/quiz/model/TriviaSplashViewModel$Companion;", "", "()V", "NO_SESSION", "", "TAG", "kotlin.jvm.PlatformType", "create", "Lcom/iqoption/quiz/model/TriviaSplashViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "quiz_release"})
    /* compiled from: TriviaSplashViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final TriviaSplashViewModel y(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(TriviaSplashViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…ashViewModel::class.java)");
            return (TriviaSplashViewModel) h;
        }
    }

    public final LiveData<c<com.iqoption.quiz.api.response.i>> aBE() {
        d dVar = this.dmj;
        j jVar = apP[0];
        return (LiveData) dVar.getValue();
    }

    public TriviaSplashViewModel() {
        b azi = m.ayY().azi();
        h.d(azi, "Providers.instance().quizApi()");
        this.dgP = azi;
    }

    private final void a(Throwable th, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(th.toString());
        Log.e(str2, stringBuilder.toString(), th);
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            if (httpException.code() != 500) {
                int code = httpException.code();
            }
        }
    }
}
