package com.iqoption.quiz.model;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import com.iqoption.quiz.aj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref.BooleanRef;
import retrofit2.HttpException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0004H\u0002J\u0012\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u0004J\u0006\u0010c\u001a\u00020dJ\b\u0010\u0016\u001a\u00020dH\u0002J\u0018\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0019H\u0002J\u0010\u0010i\u001a\u0004\u0018\u00010\u00192\u0006\u0010j\u001a\u00020kJ\u0012\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0004J\n\u0010m\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010n\u001a\u0004\u0018\u00010\u0019J\u0006\u0010o\u001a\u00020\u0013J\u0006\u0010p\u001a\u00020dJ\b\u0010q\u001a\u00020dH\u0014J\b\u0010r\u001a\u00020dH\u0002J\u0006\u0010s\u001a\u00020dJ\u0016\u0010t\u001a\u00020d2\u0006\u0010u\u001a\u00020+2\u0006\u0010v\u001a\u00020+J&\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010x\u001a\u00020\u00192\u0006\u0010y\u001a\u00020\u00132\b\u0010z\u001a\u0004\u0018\u00010\u0019J\u0018\u0010{\u001a\u00020d2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010|\u001a\u0004\u0018\u00010\u0019J\u0010\u0010}\u001a\u00020d2\u0006\u0010~\u001a\u00020+H\u0002J\u0010\u0010\u001a\u00020d2\b\u0010\u0001\u001a\u00030\u0001J\u001b\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00042\u0006\u0010F\u001a\u00020\u0019J\u001e\u0010\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00012\u0006\u0010F\u001a\u00020\u0019H\u0002R'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00048BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0010\u0010\bR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR'\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b\"\u0010\bR\u0011\u0010$\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR'\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b%\u0010\bR\u0011\u0010'\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b'\u0010\u001eR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R'\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR\u001a\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00050\u0017X\u0004¢\u0006\u0002\n\u0000R!\u00102\u001a\b\u0012\u0004\u0012\u00020\u00190\u00048FX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR'\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b7\u0010\n\u001a\u0004\b6\u0010\bR\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R'\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b>\u0010\bR\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R'\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00050\u00048FX\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010\bR'\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00048FX\u0002¢\u0006\f\n\u0004\bH\u0010\n\u001a\u0004\bG\u0010\bR\u000e\u0010I\u001a\u00020JX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\n N*\u0004\u0018\u00010M0MX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\bR\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00130RX\u0004¢\u0006\u0002\n\u0000R'\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00048FX\u0002¢\u0006\f\n\u0004\bU\u0010\n\u001a\u0004\bT\u0010\bR'\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\u00050\u00048FX\u0002¢\u0006\f\n\u0004\bY\u0010\n\u001a\u0004\bX\u0010\bR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00190\u00048FX\u0002¢\u0006\f\n\u0004\b\\\u0010\n\u001a\u0004\b[\u0010\bR-\u0010]\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020^0\u000e0\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b`\u0010\n\u001a\u0004\b_\u0010\b¨\u0006\u0001"}, aXE = {"Lcom/iqoption/quiz/model/TriviaSocketViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "answerResult", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/model/AnswerInfo;", "getAnswerResult", "()Landroid/arch/lifecycle/LiveData;", "answerResult$delegate", "Lkotlin/Lazy;", "chatApi", "Lcom/iqoption/quiz/api/ChatApi;", "chatItemsLazy", "", "Lcom/iqoption/quiz/chat/ChatItem;", "getChatItemsLazy", "chatItemsLazy$delegate", "connectionState", "", "getConnectionState", "connectionState$delegate", "disablePromoCode", "Landroid/arch/lifecycle/MutableLiveData;", "email", "", "getEmail", "()Ljava/lang/String;", "fullScreenQuiz", "getFullScreenQuiz", "()Z", "setFullScreenQuiz", "(Z)V", "isAppOpenFromLanding", "isOnAir", "isOnAir$delegate", "isOnAirLastState", "isOnError", "isOnError$delegate", "isOnErrorLastState", "isOpenFromLanding", "isPromoCodeDisabled", "lastAnswerNumber", "", "lastQuestionNumber", "lifeCount", "Lcom/iqoption/quiz/api/response/LifeResponse;", "getLifeCount", "lifeCount$delegate", "lifeCountLiveData", "menuCountDownTime", "getMenuCountDownTime", "menuCountDownTime$delegate", "online", "getOnline", "online$delegate", "onlinePing", "", "getOnlinePing", "()Landroid/arch/lifecycle/MutableLiveData;", "question", "Lcom/iqoption/quiz/model/QuestionInfo;", "getQuestion", "question$delegate", "quizApi", "Lcom/iqoption/quiz/api/TriviaApi;", "quizStatus", "Lcom/iqoption/quiz/api/response/StatusResponse;", "getQuizStatus", "quizStatus$delegate", "referralCode", "getReferralCode", "referralCode$delegate", "scheduler", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "sendChatMessageResult", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "shouldShowQuestionLocalLangNotification", "getShouldShowQuestionLocalLangNotification", "shouldShowQuestionLocalLangNotificationData", "Landroid/arch/lifecycle/MediatorLiveData;", "showRules", "getShowRules", "showRules$delegate", "splash", "Lcom/iqoption/quiz/api/response/SplashResponse;", "getSplash", "splash$delegate", "splashCountDownTime", "getSplashCountDownTime", "splashCountDownTime$delegate", "winnerInfo", "Lcom/iqoption/quiz/winners/WinnerInfo;", "getWinnerInfo", "winnerInfo$delegate", "chatMessages", "checkReferral", "deleteLife", "", "error", "throwable", "", "tag", "getChatAvatar", "context", "Landroid/content/Context;", "getChatItems", "getFlagAvatar", "getInstallReferralCode", "isInstallReferralCodeUsed", "markShowQuestionLocalLangNotificationShown", "onCleared", "ping", "resetOpeningFromLanding", "sendAnswer", "questionNumber", "answerNumber", "sendChatMessage", "text", "isLargeText", "avatarUrl", "setEmail", "promocode", "setLastQuestionNumber", "n", "updateApp", "activity", "Landroid/app/Activity;", "useReferral", "userReferralImpl", "Lio/reactivex/Flowable;", "Companion", "CountDownTimeLiveData", "quiz_release"})
/* compiled from: TriviaSocketViewModel.kt */
public final class TriviaSocketViewModel extends ViewModel {
    private static final String TAG = "com.iqoption.quiz.model.TriviaSocketViewModel";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "chatItemsLazy", "getChatItemsLazy()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "online", "getOnline()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "question", "getQuestion()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "answerResult", "getAnswerResult()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "splash", "getSplash()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "menuCountDownTime", "getMenuCountDownTime()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "splashCountDownTime", "getSplashCountDownTime()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "winnerInfo", "getWinnerInfo()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "isOnAir", "isOnAir()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "isOnError", "isOnError()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "showRules", "getShowRules()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "lifeCount", "getLifeCount()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "quizStatus", "getQuizStatus()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "referralCode", "getReferralCode()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(TriviaSocketViewModel.class), "connectionState", "getConnectionState()Landroid/arch/lifecycle/LiveData;"))};
    public static final c dmB = new c();
    private final com.iqoption.quiz.api.a dgS;
    private final ScheduledThreadPoolExecutor dlZ = new ScheduledThreadPoolExecutor(1);
    private final com.iqoption.quiz.api.b dli;
    private final kotlin.d dmA;
    private int dma;
    private int dmb;
    private final MutableLiveData<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>> dmc;
    private final kotlin.d dmd;
    private final MutableLiveData<String> dme;
    private final MutableLiveData<Object> dmf;
    private final kotlin.d dmg;
    private final kotlin.d dmh;
    private final kotlin.d dmi;
    private final kotlin.d dmj;
    private final kotlin.d dmk;
    private final kotlin.d dml;
    private final kotlin.d dmm;
    private final kotlin.d dmn;
    private final kotlin.d dmo;
    private final kotlin.d dmp;
    private final kotlin.d dmq;
    private final kotlin.d dmr;
    private final kotlin.d dms;
    private final MutableLiveData<Boolean> dmt;
    private final MutableLiveData<Boolean> dmu;
    private final LiveData<Boolean> dmv;
    private final LiveData<Boolean> dmw;
    private boolean dmx;
    private final MediatorLiveData<Boolean> dmy;
    private final LiveData<Boolean> dmz;
    private final SharedPreferences wv;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TriviaSocketViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSocketViewModel$1 */
    static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ TriviaSocketViewModel this$0;

        AnonymousClass1(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        public final void run() {
            this.this$0.aCb();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/quiz/model/TriviaSocketViewModel$Companion;", "", "()V", "NO_SESSION", "", "TAG", "kotlin.jvm.PlatformType", "create", "Lcom/iqoption/quiz/model/TriviaSocketViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "quiz_release"})
    /* compiled from: TriviaSocketViewModel.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }

        public final TriviaSocketViewModel x(FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(TriviaSocketViewModel.class);
            kotlin.jvm.internal.h.d(h, "ViewModelProviders.of(ac…ketViewModel::class.java)");
            return (TriviaSocketViewModel) h;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "", "onChanged", "com/iqoption/quiz/model/TriviaSocketViewModel$shouldShowQuestionLocalLangNotificationData$1$onAirObserver$1"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class a<T> implements Observer<com.iqoption.core.ui.c<Boolean>> {
        final /* synthetic */ BooleanRef $isOnAirState;
        final /* synthetic */ TriviaSocketViewModel$$special$$inlined$apply$lambda$1 dmC;

        a(BooleanRef booleanRef, TriviaSocketViewModel$$special$$inlined$apply$lambda$1 triviaSocketViewModel$$special$$inlined$apply$lambda$1) {
            this.$isOnAirState = booleanRef;
            this.dmC = triviaSocketViewModel$$special$$inlined$apply$lambda$1;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<Boolean> cVar) {
            BooleanRef booleanRef = this.$isOnAirState;
            boolean z = false;
            if (cVar != null) {
                Boolean bool = (Boolean) cVar.bl(Boolean.valueOf(false));
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            booleanRef.element = z;
            this.dmC.invoke();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/model/QuestionInfo;", "onChanged", "com/iqoption/quiz/model/TriviaSocketViewModel$shouldShowQuestionLocalLangNotificationData$1$questionObserver$1"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class b<T> implements Observer<com.iqoption.core.ui.c<c>> {
        final /* synthetic */ BooleanRef $isQuestionReceived;
        final /* synthetic */ TriviaSocketViewModel$$special$$inlined$apply$lambda$1 dmC;

        b(BooleanRef booleanRef, TriviaSocketViewModel$$special$$inlined$apply$lambda$1 triviaSocketViewModel$$special$$inlined$apply$lambda$1) {
            this.$isQuestionReceived = booleanRef;
            this.dmC = triviaSocketViewModel$$special$$inlined$apply$lambda$1;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<c> cVar) {
            boolean z;
            BooleanRef booleanRef = this.$isQuestionReceived;
            if ((cVar != null ? (c) cVar.getData() : null) != null) {
                c cVar2 = (c) cVar.getData();
                if (cVar2 == null || cVar2.aBf() != com.iqoption.quiz.api.response.e.dio.number) {
                    z = true;
                    booleanRef.element = z;
                    this.dmC.invoke();
                }
            }
            z = false;
            booleanRef.element = z;
            this.dmC.invoke();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/iqoption/quiz/chat/ChatItem;", "response", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        public static final e dmM = new e();

        e() {
        }

        /* renamed from: bb */
        public final ArrayList<com.iqoption.quiz.chat.b> apply(List<? extends com.iqoption.quiz.api.response.a.b> list) {
            kotlin.jvm.internal.h.e(list, "response");
            ArrayList<com.iqoption.quiz.chat.b> arrayList = new ArrayList();
            for (com.iqoption.quiz.api.response.a.b bVar : s.bS(list.subList(list.size() - Math.min(100, list.size()), list.size()))) {
                String valueOf = String.valueOf(bVar.getId().longValue());
                String userId = bVar.getUserId();
                kotlin.jvm.internal.h.d(userId, "responseItem.userId");
                String aAN = bVar.aAN();
                kotlin.jvm.internal.h.d(aAN, "responseItem.userAvatar");
                if ((((CharSequence) aAN).length() > 0 ? 1 : null) != null) {
                    aAN = bVar.aAN();
                    kotlin.jvm.internal.h.d(aAN, "responseItem.userAvatar");
                } else {
                    aAN = com.iqoption.core.util.f.bgP.aA(bVar.getFlag());
                    if (aAN == null) {
                        aAN = "";
                    }
                }
                String str = aAN;
                aj ajVar = aj.dhZ;
                String aAM = bVar.aAM();
                kotlin.jvm.internal.h.d(aAM, "responseItem.userDisplayName");
                com.iqoption.quiz.aj.a jd = ajVar.jd(aAM);
                String initials = jd.getInitials();
                String fullName = jd.getFullName();
                int jD = com.iqoption.quiz.c.a.jD(fullName);
                String text = bVar.getText();
                kotlin.jvm.internal.h.d(text, "responseItem.text");
                Boolean aAO = bVar.aAO();
                if (aAO == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                arrayList.add(new com.iqoption.quiz.chat.b(valueOf, userId, str, initials, jD, fullName, text, aAO.booleanValue()));
            }
            return arrayList;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/chat/ChatItem;", "kotlin.jvm.PlatformType", "", "t", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class f<T, R> implements io.reactivex.c.f<Throwable, List<? extends com.iqoption.quiz.chat.b>> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        f(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        /* renamed from: G */
        public final List<com.iqoption.quiz.chat.b> apply(Throwable th) {
            kotlin.jvm.internal.h.e(th, "t");
            this.this$0.a(th, "chatMessages");
            return Collections.emptyList();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/api/response/UserResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class g<T> implements io.reactivex.c.e<com.iqoption.quiz.api.response.o> {
        public static final g dmO = new g();

        g() {
        }

        /* renamed from: b */
        public final void accept(com.iqoption.quiz.api.response.o oVar) {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class h<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        h(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            TriviaSocketViewModel triviaSocketViewModel = this.this$0;
            kotlin.jvm.internal.h.d(th, "it");
            triviaSocketViewModel.a(th, "useLife");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "t", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class j<T, R> implements io.reactivex.c.f<Throwable, Object> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        j(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        public /* synthetic */ Object apply(Object obj) {
            I((Throwable) obj);
            return kotlin.l.etX;
        }

        public final void I(Throwable th) {
            kotlin.jvm.internal.h.e(th, "t");
            this.this$0.a(th, "ping");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class k<T> implements io.reactivex.c.e<Object> {
        public static final k dnc = new k();

        k() {
        }

        public final void accept(Object obj) {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class l<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        l(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            TriviaSocketViewModel triviaSocketViewModel = this.this$0;
            kotlin.jvm.internal.h.d(th, "it");
            triviaSocketViewModel.a(th, "sendAnswer");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "response", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class m<T> implements io.reactivex.c.e<com.iqoption.quiz.api.response.a.b> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        m(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        /* renamed from: a */
        public final void accept(com.iqoption.quiz.api.response.a.b bVar) {
            MutableLiveData c = this.this$0.dme;
            kotlin.jvm.internal.h.d(bVar, "response");
            c.setValue(bVar.getText());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "throwable", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class n<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        n(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            Log.e(TriviaSocketViewModel.TAG, th.toString());
            this.this$0.dme.setValue("");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class o<T> implements io.reactivex.c.e<com.iqoption.core.ui.c<String>> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        o(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        /* renamed from: f */
        public final void accept(com.iqoption.core.ui.c<String> cVar) {
            if (cVar.isSuccess()) {
                this.this$0.aBZ();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "", "it", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class p<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ String dnh;

        p(String str) {
            this.dnh = str;
        }

        /* renamed from: bA */
        public final com.iqoption.core.ui.c<String> apply(Object obj) {
            kotlin.jvm.internal.h.e(obj, "it");
            com.iqoption.quiz.m.ayY().azk().edit().putBoolean("PREF_REFCODE_WAS_USED", true).putString("QUIZ_REFCODE_WHEN_INSTALL", "").apply();
            return com.iqoption.core.ui.c.baY.bm(this.dnh);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "", "it", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    static final class q<T, R> implements io.reactivex.c.f<Throwable, com.iqoption.core.ui.c<String>> {
        public static final q dni = new q();

        q() {
        }

        /* JADX WARNING: Missing block: B:6:0x002f, code:
            if (r0 != null) goto L_0x0034;
     */
        /* renamed from: t */
        public final com.iqoption.core.ui.c<java.lang.String> apply(java.lang.Throwable r8) {
            /*
            r7 = this;
            r0 = "it";
            kotlin.jvm.internal.h.e(r8, r0);
            r0 = com.iqoption.quiz.m.ayY();
            r0 = r0.azk();
            r0 = r0.edit();
            r1 = "QUIZ_REFCODE_WHEN_INSTALL";
            r2 = "";
            r0 = r0.putString(r1, r2);
            r0.apply();
            r1 = com.iqoption.core.ui.c.baY;
            r0 = r8.getCause();
            r2 = r0 instanceof com.iqoption.core.connect.m;
            if (r2 != 0) goto L_0x0027;
        L_0x0026:
            r0 = 0;
        L_0x0027:
            r0 = (com.iqoption.core.connect.m) r0;
            if (r0 == 0) goto L_0x0032;
        L_0x002b:
            r0 = r0.getMessage();
            if (r0 == 0) goto L_0x0032;
        L_0x0031:
            goto L_0x0034;
        L_0x0032:
            r0 = "";
        L_0x0034:
            r3 = r0;
            r4 = 0;
            r5 = 4;
            r6 = 0;
            r2 = r8;
            r8 = com.iqoption.core.ui.c.a.a(r1, r2, r3, r4, r5, r6);
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.model.TriviaSocketViewModel.q.t(java.lang.Throwable):com.iqoption.core.ui.c<java.lang.String>");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, aXE = {"com/iqoption/quiz/model/TriviaSocketViewModel$onlinePing$1", "Landroid/arch/lifecycle/MutableLiveData;", "", "onActive", "", "quiz_release"})
    /* compiled from: TriviaSocketViewModel.kt */
    public static final class i extends MutableLiveData<Object> {
        final /* synthetic */ TriviaSocketViewModel this$0;

        i(TriviaSocketViewModel triviaSocketViewModel) {
            this.this$0 = triviaSocketViewModel;
        }

        protected void onActive() {
            super.onActive();
            this.this$0.aCb();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/quiz/model/TriviaSocketViewModel$CountDownTimeLiveData;", "Landroid/arch/lifecycle/MediatorLiveData;", "", "countDownTimeMs", "", "timeFormatter", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lcom/iqoption/quiz/model/TriviaSocketViewModel;JLkotlin/jvm/functions/Function1;)V", "getCountDownTimeMs", "()J", "scheduleAtFixedRate", "Ljava/util/concurrent/ScheduledFuture;", "getScheduleAtFixedRate", "()Ljava/util/concurrent/ScheduledFuture;", "setScheduleAtFixedRate", "(Ljava/util/concurrent/ScheduledFuture;)V", "timestamp", "quiz_release"})
    /* compiled from: TriviaSocketViewModel.kt */
    private final class d extends MediatorLiveData<String> {
        private ScheduledFuture<?> dmD;
        private final long dmE;
        final /* synthetic */ TriviaSocketViewModel this$0;
        private volatile long timestamp;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/api/response/SplashResponse;", "apply"})
        /* compiled from: TriviaSocketViewModel.kt */
        static final class a<T, R> implements io.reactivex.c.f<T, R> {
            public static final a dmJ = new a();

            a() {
            }

            public /* synthetic */ Object apply(Object obj) {
                return Long.valueOf(a((com.iqoption.quiz.api.response.i) obj));
            }

            public final long a(com.iqoption.quiz.api.response.i iVar) {
                kotlin.jvm.internal.h.e(iVar, "it");
                Long l = iVar.div;
                return l != null ? l.longValue() : 0;
            }
        }

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "t", "", "apply"})
        /* compiled from: TriviaSocketViewModel.kt */
        static final class b<T, R> implements io.reactivex.c.f<Throwable, Long> {
            final /* synthetic */ d dmF;

            b(d dVar) {
                this.dmF = dVar;
            }

            public /* synthetic */ Object apply(Object obj) {
                return Long.valueOf(H((Throwable) obj));
            }

            public final long H(Throwable th) {
                kotlin.jvm.internal.h.e(th, "t");
                this.dmF.this$0.a(th, "countDown");
                return 0;
            }
        }

        public d(TriviaSocketViewModel triviaSocketViewModel, long j, final kotlin.jvm.a.b<? super Long, String> bVar) {
            kotlin.jvm.internal.h.e(bVar, "timeFormatter");
            this.this$0 = triviaSocketViewModel;
            this.dmE = j;
            a(LiveDataReactiveStreams.a(triviaSocketViewModel.dli.jk("").d((io.reactivex.c.f) a.dmJ).f(new b(this)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp())), new Observer<Long>(this) {
                final /* synthetic */ d dmF;

                /* renamed from: B */
                public final void onChanged(Long l) {
                    String Ki = TriviaSocketViewModel.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("splash timestamp update: ");
                    stringBuilder.append(this.dmF.timestamp);
                    com.iqoption.core.i.v(Ki, stringBuilder.toString());
                    if (l != null) {
                        if (l.longValue() != this.dmF.timestamp) {
                            this.dmF.timestamp = l.longValue();
                            ScheduledFuture aCg = this.dmF.aCg();
                            if (aCg != null) {
                                aCg.cancel(true);
                            }
                            if (this.dmF.timestamp == 0) {
                                this.dmF.postValue("");
                                return;
                            }
                            final long a = this.dmF.timestamp * ((long) 1000);
                            if (!com.iqoption.core.ext.c.aS(a)) {
                                long max = Math.max(0, com.iqoption.core.ext.c.aT(a) - this.dmF.aCh());
                                String Ki2 = TriviaSocketViewModel.TAG;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("schedule timestamp UI update, delay= ");
                                stringBuilder2.append(max);
                                com.iqoption.core.i.v(Ki2, stringBuilder2.toString());
                                this.dmF.c(this.dmF.this$0.dlZ.scheduleAtFixedRate(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 dmH;

                                    public final void run() {
                                        long aT = com.iqoption.core.ext.c.aT(a);
                                        String str = (0 <= aT && this.dmH.dmF.aCh() >= aT) ? (String) bVar.invoke(Long.valueOf(aT)) : "";
                                        String Ki = TriviaSocketViewModel.TAG;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("update UI timestamp ");
                                        stringBuilder.append(str);
                                        com.iqoption.core.i.v(Ki, stringBuilder.toString());
                                        this.dmH.dmF.postValue(str);
                                    }
                                }, max, 1000, TimeUnit.MILLISECONDS));
                            }
                        }
                    }
                }
            });
        }

        public final long aCh() {
            return this.dmE;
        }

        public final ScheduledFuture<?> aCg() {
            return this.dmD;
        }

        public final void c(ScheduledFuture<?> scheduledFuture) {
            this.dmD = scheduledFuture;
        }
    }

    private final LiveData<List<com.iqoption.quiz.chat.b>> aBz() {
        kotlin.d dVar = this.dmd;
        kotlin.reflect.j jVar = apP[0];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<Integer>> aBB() {
        kotlin.d dVar = this.dmg;
        kotlin.reflect.j jVar = apP[1];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<c>> aBC() {
        kotlin.d dVar = this.dmh;
        kotlin.reflect.j jVar = apP[2];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<a>> aBD() {
        kotlin.d dVar = this.dmi;
        kotlin.reflect.j jVar = apP[3];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.i>> aBE() {
        kotlin.d dVar = this.dmj;
        kotlin.reflect.j jVar = apP[4];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<String> aBF() {
        kotlin.d dVar = this.dmk;
        kotlin.reflect.j jVar = apP[5];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<String> aBG() {
        kotlin.d dVar = this.dml;
        kotlin.reflect.j jVar = apP[6];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<List<com.iqoption.quiz.d.b>>> aBH() {
        kotlin.d dVar = this.dmm;
        kotlin.reflect.j jVar = apP[7];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<Boolean>> aBI() {
        kotlin.d dVar = this.dmn;
        kotlin.reflect.j jVar = apP[8];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<Boolean>> aBK() {
        kotlin.d dVar = this.dmo;
        kotlin.reflect.j jVar = apP[9];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<Boolean>> aBM() {
        kotlin.d dVar = this.dmp;
        kotlin.reflect.j jVar = apP[10];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>> aBN() {
        kotlin.d dVar = this.dmq;
        kotlin.reflect.j jVar = apP[11];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.k>> aBO() {
        kotlin.d dVar = this.dmr;
        kotlin.reflect.j jVar = apP[12];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<com.iqoption.core.ui.c<String>> aBS() {
        kotlin.d dVar = this.dms;
        kotlin.reflect.j jVar = apP[13];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<Boolean> aCf() {
        kotlin.d dVar = this.dmA;
        kotlin.reflect.j jVar = apP[14];
        return (LiveData) dVar.getValue();
    }

    /* JADX WARNING: Missing block: B:8:0x01ca, code:
            if (r1.equals("zh") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:10:0x01d4, code:
            if (r1.equals("tr") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:12:0x01dd, code:
            if (r1.equals("ru") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:14:0x01e6, code:
            if (r1.equals("pt") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:16:0x01ef, code:
            if (r1.equals("ko") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:18:0x01f8, code:
            if (r1.equals("it") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:20:0x0201, code:
            if (r1.equals("in") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:22:0x020a, code:
            if (r1.equals("id") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:24:0x0213, code:
            if (r1.equals("fr") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:26:0x021c, code:
            if (r1.equals("es") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:28:0x0225, code:
            if (r1.equals("de") != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:29:0x0227, code:
            r0.a(aBI(), r5);
            r0.a(aBC(), r2);
     */
    public TriviaSocketViewModel() {
        /*
        r9 = this;
        r9.<init>();
        r0 = new java.util.concurrent.ScheduledThreadPoolExecutor;
        r1 = 1;
        r0.<init>(r1);
        r9.dlZ = r0;
        r0 = com.iqoption.quiz.m.ayY();
        r0 = r0.azi();
        r1 = "Providers.instance().quizApi()";
        kotlin.jvm.internal.h.d(r0, r1);
        r9.dli = r0;
        r0 = com.iqoption.quiz.m.ayY();
        r0 = r0.azj();
        r1 = "Providers.instance().chatApi()";
        kotlin.jvm.internal.h.d(r0, r1);
        r9.dgS = r0;
        r0 = -1;
        r9.dma = r0;
        r9.dmb = r0;
        r1 = com.iqoption.quiz.m.ayY();
        r1 = r1.azk();
        r9.wv = r1;
        r1 = new android.arch.lifecycle.MutableLiveData;
        r1.<init>();
        r9.dmc = r1;
        r1 = new com.iqoption.quiz.model.TriviaSocketViewModel$chatItemsLazy$2;
        r1.<init>(r9);
        r1 = (kotlin.jvm.a.a) r1;
        r1 = kotlin.g.f(r1);
        r9.dmd = r1;
        r1 = new android.arch.lifecycle.MutableLiveData;
        r1.<init>();
        r9.dme = r1;
        r1 = r9.wv;
        r2 = "c5982358759cafa";
        r1 = r1.getInt(r2, r0);
        r9.dma = r1;
        r9.dmb = r0;
        r2 = r9.dlZ;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$1;
        r0.<init>(r9);
        r3 = r0;
        r3 = (java.lang.Runnable) r3;
        r8 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r4 = 0;
        r6 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r2.scheduleWithFixedDelay(r3, r4, r6, r8);
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$i;
        r0.<init>(r9);
        r0 = (android.arch.lifecycle.MutableLiveData) r0;
        r9.dmf = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$online$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmg = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$question$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmh = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$answerResult$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmi = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$splash$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmj = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$menuCountDownTime$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmk = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$splashCountDownTime$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dml = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$winnerInfo$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmm = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$isOnAir$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmn = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$isOnError$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmo = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$showRules$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmp = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$lifeCount$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmq = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$quizStatus$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmr = r0;
        r0 = new com.iqoption.quiz.model.TriviaSocketViewModel$referralCode$2;
        r0.<init>(r9);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dms = r0;
        r0 = new android.arch.lifecycle.MutableLiveData;
        r0.<init>();
        r1 = com.iqoption.quiz.m.ayY();
        r1 = r1.azk();
        r2 = "QUIZ_OPEN_FROM_LANDING";
        r3 = 0;
        r1 = r1.getBoolean(r2, r3);
        r1 = java.lang.Boolean.valueOf(r1);
        r0.setValue(r1);
        r9.dmt = r0;
        r0 = new android.arch.lifecycle.MutableLiveData;
        r0.<init>();
        r1 = com.iqoption.quiz.m.ayY();
        r1 = r1.azk();
        r2 = "PREF_QUIZ_DISABLE_PROMO_CODE";
        r1 = r1.getBoolean(r2, r3);
        r1 = java.lang.Boolean.valueOf(r1);
        r0.setValue(r1);
        r9.dmu = r0;
        r0 = r9.dmt;
        r0 = (android.arch.lifecycle.LiveData) r0;
        r9.dmv = r0;
        r0 = r9.dmu;
        r0 = (android.arch.lifecycle.LiveData) r0;
        r9.dmw = r0;
        r0 = new android.arch.lifecycle.MediatorLiveData;
        r0.<init>();
        r1 = com.iqoption.quiz.m.ayY();
        r1 = r1.azk();
        r2 = "QUESTION_LOCAL_LANG_NOTIFICATION_WAS_SHOWN";
        r1 = r1.getBoolean(r2, r3);
        if (r1 == 0) goto L_0x0188;
    L_0x017f:
        r1 = java.lang.Boolean.valueOf(r3);
        r0.setValue(r1);
        goto L_0x023d;
    L_0x0188:
        r1 = new kotlin.jvm.internal.Ref$BooleanRef;
        r1.<init>();
        r1.element = r3;
        r2 = new kotlin.jvm.internal.Ref$BooleanRef;
        r2.<init>();
        r2.element = r3;
        r4 = new com.iqoption.quiz.model.TriviaSocketViewModel$$special$$inlined$apply$lambda$1;
        r4.<init>(r0, r2, r1, r9);
        r5 = new com.iqoption.quiz.model.TriviaSocketViewModel$a;
        r5.<init>(r2, r4);
        r5 = (android.arch.lifecycle.Observer) r5;
        r2 = new com.iqoption.quiz.model.TriviaSocketViewModel$b;
        r2.<init>(r1, r4);
        r2 = (android.arch.lifecycle.Observer) r2;
        r1 = java.util.Locale.getDefault();
        r4 = "Locale.getDefault()";
        kotlin.jvm.internal.h.d(r1, r4);
        r1 = r1.getLanguage();
        if (r1 != 0) goto L_0x01ba;
    L_0x01b8:
        goto L_0x0236;
    L_0x01ba:
        r4 = r1.hashCode();
        switch(r4) {
            case 3201: goto L_0x021f;
            case 3246: goto L_0x0216;
            case 3276: goto L_0x020d;
            case 3355: goto L_0x0204;
            case 3365: goto L_0x01fb;
            case 3371: goto L_0x01f2;
            case 3428: goto L_0x01e9;
            case 3588: goto L_0x01e0;
            case 3651: goto L_0x01d7;
            case 3710: goto L_0x01cd;
            case 3886: goto L_0x01c3;
            default: goto L_0x01c1;
        };
    L_0x01c1:
        goto L_0x0236;
    L_0x01c3:
        r4 = "zh";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x01cc:
        goto L_0x0227;
    L_0x01cd:
        r4 = "tr";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x01d6:
        goto L_0x0227;
    L_0x01d7:
        r4 = "ru";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x01df:
        goto L_0x0227;
    L_0x01e0:
        r4 = "pt";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x01e8:
        goto L_0x0227;
    L_0x01e9:
        r4 = "ko";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x01f1:
        goto L_0x0227;
    L_0x01f2:
        r4 = "it";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x01fa:
        goto L_0x0227;
    L_0x01fb:
        r4 = "in";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x0203:
        goto L_0x0227;
    L_0x0204:
        r4 = "id";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x020c:
        goto L_0x0227;
    L_0x020d:
        r4 = "fr";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x0215:
        goto L_0x0227;
    L_0x0216:
        r4 = "es";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x021e:
        goto L_0x0227;
    L_0x021f:
        r4 = "de";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0236;
    L_0x0227:
        r1 = r9.aBI();
        r0.a(r1, r5);
        r1 = r9.aBC();
        r0.a(r1, r2);
        goto L_0x023d;
    L_0x0236:
        r1 = java.lang.Boolean.valueOf(r3);
        r0.setValue(r1);
    L_0x023d:
        r9.dmy = r0;
        r0 = r9.dmy;
        r0 = (android.arch.lifecycle.LiveData) r0;
        r9.dmz = r0;
        r0 = com.iqoption.quiz.model.TriviaSocketViewModel$connectionState$2.dmN;
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.g.f(r0);
        r9.dmA = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.model.TriviaSocketViewModel.<init>():void");
    }

    public final MutableLiveData<Object> aBA() {
        return this.dmf;
    }

    public final boolean aBJ() {
        com.iqoption.core.ui.c cVar = (com.iqoption.core.ui.c) aBO().getValue();
        if (cVar != null) {
            com.iqoption.quiz.api.response.k kVar = (com.iqoption.quiz.api.response.k) cVar.getData();
            if (kVar != null && kVar.aAv()) {
                return true;
            }
        }
        return false;
    }

    public final boolean aBL() {
        com.iqoption.core.ui.c cVar = (com.iqoption.core.ui.c) aBO().getValue();
        if (cVar != null) {
            com.iqoption.quiz.api.response.k kVar = (com.iqoption.quiz.api.response.k) cVar.getData();
            if (kVar != null && kVar.aAw()) {
                return true;
            }
        }
        return false;
    }

    protected void onCleared() {
        this.dlZ.shutdownNow();
        super.onCleared();
    }

    public final void aA(int i, int i2) {
        gr(i);
        this.dli.a(new com.iqoption.quiz.api.response.m(i2)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) k.dnc, (io.reactivex.c.e) new l(this));
    }

    public final void ax(String str, String str2) {
        kotlin.jvm.internal.h.e(str, "email");
        throw new NotImplementedError("email is not used in the socket version");
    }

    private final LiveData<List<com.iqoption.quiz.chat.b>> aBP() {
        LiveData<List<com.iqoption.quiz.chat.b>> a = LiveDataReactiveStreams.a(this.dgS.aAb().d((io.reactivex.c.f) e.dmM).f(new f(this)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()));
        kotlin.jvm.internal.h.d(a, "LiveDataReactiveStreams.… .observeOn(ui)\n        )");
        return a;
    }

    public final LiveData<List<com.iqoption.quiz.chat.b>> aBQ() {
        return aBz();
    }

    public final LiveData<String> b(String str, boolean z, String str2) {
        Object obj;
        kotlin.jvm.internal.h.e(str, "text");
        com.iqoption.quiz.api.response.a.c cVar = new com.iqoption.quiz.api.response.a.c();
        cVar.setText(str);
        cVar.setUserId(String.valueOf(com.iqoption.core.f.Dr().getUserId()));
        str = com.iqoption.core.f.Dr().getFirstName();
        if (com.iqoption.core.f.Dr().getLastName() == null) {
            obj = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" ");
            String lastName = com.iqoption.core.f.Dr().getLastName();
            if (lastName != null) {
                Character Q = x.Q(lastName);
                if (Q != null) {
                    char charValue = Q.charValue();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(String.valueOf(charValue));
                    stringBuilder2.append(".");
                    lastName = stringBuilder2.toString();
                    stringBuilder.append(lastName);
                    obj = stringBuilder.toString();
                }
            }
            lastName = null;
            stringBuilder.append(lastName);
            obj = stringBuilder.toString();
        }
        cVar.jr(kotlin.jvm.internal.h.p(str, obj));
        cVar.s(Boolean.valueOf(z));
        cVar.js(aj.dhZ.jc(str2));
        this.dgS.a(cVar).d(io.reactivex.e.a.aXt()).c(io.reactivex.a.b.a.aWm()).a((io.reactivex.c.e) new m(this), (io.reactivex.c.e) new n(this));
        return this.dme;
    }

    public final String bK(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.iqoption.quiz.ae.a.quiz_chat_avatar_size);
        com.iqoption.core.microservices.avatar.a avatar = com.iqoption.core.f.Dr().getAvatar();
        if (avatar != null) {
            com.iqoption.core.microservices.avatar.d ai = avatar.ai(dimensionPixelSize, dimensionPixelSize);
            if (ai != null) {
                String url = ai.getUrl();
                if (url != null) {
                    return url;
                }
            }
        }
        return aBR();
    }

    private final String aBR() {
        return com.iqoption.core.util.f.bgP.aA(com.iqoption.core.f.Dr().getCountryCode());
    }

    public final void aBT() {
        this.dli.a(null).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) g.dmO, (io.reactivex.c.e) new h(this));
    }

    public final String aBU() {
        return com.iqoption.quiz.m.ayY().azk().getString("QUIZ_REFCODE_WHEN_INSTALL", null);
    }

    public final boolean aBV() {
        return com.iqoption.quiz.m.ayY().azk().getBoolean("PREF_REFCODE_WAS_USED", false);
    }

    public final LiveData<Boolean> aBW() {
        return this.dmv;
    }

    public final LiveData<Boolean> aBX() {
        return this.dmw;
    }

    public final void aBY() {
        com.iqoption.quiz.m.ayY().azk().edit().putBoolean("QUIZ_OPEN_FROM_LANDING", false).apply();
        this.dmt.postValue(Boolean.valueOf(false));
    }

    private final void aBZ() {
        com.iqoption.quiz.m.ayY().azk().edit().putBoolean("PREF_QUIZ_DISABLE_PROMO_CODE", true).apply();
        this.dmu.postValue(Boolean.valueOf(true));
    }

    public final LiveData<com.iqoption.core.ui.c<String>> jv(String str) {
        kotlin.jvm.internal.h.e(str, "referralCode");
        LiveData<com.iqoption.core.ui.c<String>> a = LiveDataReactiveStreams.a(jw(str).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new o(this)));
        kotlin.jvm.internal.h.d(a, "LiveDataReactiveStreams.…     }\n                })");
        return a;
    }

    private final io.reactivex.e<com.iqoption.core.ui.c<String>> jw(String str) {
        io.reactivex.e<com.iqoption.core.ui.c<String>> f = this.dli.a(new com.iqoption.quiz.api.response.f(str)).d((io.reactivex.c.f) new p(str)).f(q.dni);
        kotlin.jvm.internal.h.d(f, "quizApi.useReferral(Refe… ?: \"\")\n                }");
        return f;
    }

    public final LiveData<com.iqoption.core.ui.c<String>> aCa() {
        String aBU = aBU();
        if (aBV() || TextUtils.isEmpty(aBU)) {
            MutableLiveData mutableLiveData = new MutableLiveData();
            mutableLiveData.setValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, null, null, null, 7, null));
            return mutableLiveData;
        }
        com.iqoption.quiz.a.a aVar = com.iqoption.quiz.a.a.did;
        if (aBU == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        aVar.s(aBU, false);
        LiveData<com.iqoption.core.ui.c<String>> a = LiveDataReactiveStreams.a(jw(aBU).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()));
        kotlin.jvm.internal.h.d(a, "LiveDataReactiveStreams.…ribeOn(bg).observeOn(ui))");
        return a;
    }

    private final void aCb() {
        if (this.dmf.hasActiveObservers()) {
            this.dli.aAc().h(com.iqoption.core.h.i.Yo()).o(new j(this)).aVS();
        }
    }

    private final void gr(int i) {
        this.dma = i;
        this.wv.edit().putInt("c5982358759cafa", i).apply();
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

    public final String getEmail() {
        return com.iqoption.core.f.Dr().getEmail();
    }

    public final boolean aCc() {
        return this.dmx;
    }

    public final void eM(boolean z) {
        this.dmx = z;
    }

    public final LiveData<Boolean> aCd() {
        return this.dmz;
    }

    public final void aCe() {
        this.dmy.setValue(Boolean.valueOf(false));
        com.iqoption.quiz.m.ayY().azk().edit().putBoolean("QUESTION_LOCAL_LANG_NOTIFICATION_WAS_SHOWN", true).apply();
    }

    public final void m(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
        com.iqoption.quiz.m.ayY().azo().m(activity);
    }
}
