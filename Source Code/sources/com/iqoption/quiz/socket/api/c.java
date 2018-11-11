package com.iqoption.quiz.socket.api;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.reflect.TypeToken;
import com.iqoption.quiz.api.response.StatType;
import com.iqoption.quiz.api.response.o;
import com.iqoption.quiz.api.response.q;
import io.reactivex.processors.PublishProcessor;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u0001:\u0001NB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0002J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0002J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J.\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020\u00192\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\"H\u0002J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\bH\u0002J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\bH\u0016J\u0014\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\bH\u0002J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\bH\u0002J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\bH\u0002J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\bH\u0002J\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\bH\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\bH\u0002J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020/0\bH\u0002J\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030$022\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\b\u0012\u0004\u0012\u0002070\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u0002070\bH\u0002J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002070\bH\u0002J\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0002J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0002J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\bH\u0002J\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\bH\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020A02H\u0016J\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\b2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0018\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\b2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\b\u0010C\u001a\u0004\u0018\u00010JH\u0016J\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020A0\b2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R?\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, aXE = {"Lcom/iqoption/quiz/socket/api/TriviaApiSocket;", "Lcom/iqoption/quiz/api/TriviaApi;", "connect", "Lcom/iqoption/core/IQConnect;", "(Lcom/iqoption/core/IQConnect;)V", "eventBuilder", "Lcom/iqoption/core/connect/EventBuilderFactory;", "isConnectedStream", "Lio/reactivex/Flowable;", "", "kotlin.jvm.PlatformType", "()Lio/reactivex/Flowable;", "isConnectedStream$delegate", "Lkotlin/Lazy;", "requestBuilder", "Lcom/iqoption/core/connect/RequestBuilderFactory;", "userData", "Lcom/iqoption/quiz/api/response/UserResponse;", "getUserData", "userData$delegate", "userSubject", "Lio/reactivex/processors/FlowableProcessor;", "getAnswer", "Lcom/iqoption/quiz/api/response/AnswerResponse;", "sessionId", "", "getAnswerUpdates", "getEmail", "Lcom/iqoption/quiz/api/response/EmailResponse;", "getEventBuilder", "Lcom/iqoption/core/connect/EventBuilder;", "T", "name", "cls", "Ljava/lang/Class;", "getInsightUpdates", "", "Lcom/iqoption/quiz/api/response/InsightResponse;", "getInsights", "getInsightsDirect", "getOnline", "Lcom/iqoption/quiz/api/response/OnlineResponse;", "getOnlineUpdates", "getQuestion", "Lcom/iqoption/quiz/api/response/QuestionResponse;", "getQuestionUpdates", "getSplash", "Lcom/iqoption/quiz/api/response/SplashResponse;", "getSplashUpdates", "getStat", "Lio/reactivex/Single;", "Lcom/iqoption/quiz/api/response/StatResponse;", "type", "Lcom/iqoption/quiz/api/response/StatType;", "getStatus", "Lcom/iqoption/quiz/api/response/StatusResponse;", "getStatusDirect", "getStatusUpdates", "getUser", "getUserDirect", "getUserUpdates", "getWinners", "Lcom/iqoption/quiz/api/response/WinnersResponse;", "getWinnersUpdates", "ping", "", "sendAnswer", "userAnswer", "Lcom/iqoption/quiz/api/response/UserAnswer;", "setEmail", "Lcom/iqoption/quiz/api/response/SessionResponse;", "email", "Lcom/iqoption/quiz/api/response/UserEmail;", "useLife", "Lcom/iqoption/quiz/api/response/SessionId;", "useReferral", "referralCode", "Lcom/iqoption/quiz/api/response/ReferralCode;", "Companion", "quiz_release"})
/* compiled from: TriviaApiSocket.kt */
public final class c implements com.iqoption.quiz.api.b {
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "isConnectedStream", "isConnectedStream()Lio/reactivex/Flowable;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "userData", "getUserData()Lio/reactivex/Flowable;"))};
    public static final a dod = new a();
    private final kotlin.d aqs = g.f(TriviaApiSocket$isConnectedStream$2.dol);
    private final com.iqoption.core.connect.l dnV;
    private final com.iqoption.core.connect.e dnW;
    private final io.reactivex.processors.a<o> doa;
    private final kotlin.d doc;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/quiz/socket/api/TriviaApiSocket$Companion;", "", "()V", "ANSWERS_SHOWN", "", "CHANGE_REFERRAL", "CMD_GET_INSIGHTS", "CMD_GET_STAT", "GET_ANSWER", "GET_ONLINE", "GET_QUESTION", "GET_SPLASH", "GET_STATUS", "GET_USER", "GET_WINNERS", "INSIGHTS_CHANGED", "ONLINE_CHANGED", "PING", "QUESTION_SHOWN", "QUIZ_MICROSERVICE", "SEND_ANSWER", "SPLASH_CHANGED", "STATUS_CHANGED", "USER_CHANGED", "USE_LIFE", "WINNERS_CHANGED", "quiz_release"})
    /* compiled from: TriviaApiSocket.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/quiz/api/response/AnswerResponse;", "it", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class b<T, R> implements io.reactivex.c.f<T, org.a.b<? extends R>> {
        final /* synthetic */ c this$0;

        b(c cVar) {
            this.this$0 = cVar;
        }

        /* renamed from: c */
        public final io.reactivex.e<com.iqoption.quiz.api.response.a> apply(com.iqoption.quiz.api.response.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "it");
            return this.this$0.aCK();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/api/response/AnswerResponse;", "kotlin.jvm.PlatformType", "it", "", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class c<T, R> implements io.reactivex.c.f<Throwable, com.iqoption.quiz.api.response.a> {
        public static final c doe = new c();

        c() {
        }

        /* renamed from: K */
        public final com.iqoption.quiz.api.response.a apply(Throwable th) {
            kotlin.jvm.internal.h.e(th, "it");
            return com.iqoption.quiz.api.response.a.die;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/api/response/AnswerResponse;", "kotlin.jvm.PlatformType", "it", "", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class d<T, R> implements io.reactivex.c.f<T, R> {
        public static final d dof = new d();

        d() {
        }

        /* renamed from: bB */
        public final com.iqoption.quiz.api.response.a apply(Object obj) {
            kotlin.jvm.internal.h.e(obj, "it");
            return com.iqoption.quiz.api.response.a.die;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/quiz/api/response/InsightResponse;", "it", "", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, org.a.b<? extends R>> {
        final /* synthetic */ c this$0;

        e(c cVar) {
            this.this$0 = cVar;
        }

        /* renamed from: bk */
        public final io.reactivex.e<List<com.iqoption.quiz.api.response.b>> apply(Object obj) {
            kotlin.jvm.internal.h.e(obj, "it");
            return this.this$0.aCP();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class f extends TypeToken<List<? extends com.iqoption.quiz.api.response.b>> {
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/api/response/InsightResponse;", "it", "", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class g<T, R> implements io.reactivex.c.f<Throwable, List<? extends com.iqoption.quiz.api.response.b>> {
        public static final g dog = new g();

        g() {
        }

        /* renamed from: G */
        public final List<com.iqoption.quiz.api.response.b> apply(Throwable th) {
            kotlin.jvm.internal.h.e(th, "it");
            return m.emptyList();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/quiz/api/response/QuestionResponse;", "it", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class h<T, R> implements io.reactivex.c.f<T, org.a.b<? extends R>> {
        final /* synthetic */ c this$0;

        h(c cVar) {
            this.this$0 = cVar;
        }

        /* renamed from: d */
        public final io.reactivex.e<com.iqoption.quiz.api.response.e> apply(com.iqoption.quiz.api.response.e eVar) {
            kotlin.jvm.internal.h.e(eVar, "it");
            return this.this$0.aCI();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/api/response/QuestionResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaApiSocket.kt */
    static final class i<T> implements io.reactivex.c.e<com.iqoption.quiz.api.response.e> {
        public static final i doh = new i();

        i() {
        }

        /* renamed from: e */
        public final void accept(com.iqoption.quiz.api.response.e eVar) {
            com.iqoption.quiz.a.a.did.gp(0);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/api/response/QuestionResponse;", "kotlin.jvm.PlatformType", "it", "", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class j<T, R> implements io.reactivex.c.f<Throwable, com.iqoption.quiz.api.response.e> {
        public static final j doi = new j();

        j() {
        }

        /* renamed from: L */
        public final com.iqoption.quiz.api.response.e apply(Throwable th) {
            kotlin.jvm.internal.h.e(th, "it");
            return com.iqoption.quiz.api.response.e.dio;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/api/response/QuestionResponse;", "kotlin.jvm.PlatformType", "it", "", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class k<T, R> implements io.reactivex.c.f<T, R> {
        public static final k doj = new k();

        k() {
        }

        /* renamed from: bC */
        public final com.iqoption.quiz.api.response.e apply(Object obj) {
            kotlin.jvm.internal.h.e(obj, "it");
            com.iqoption.quiz.a.a.did.gn(1);
            return com.iqoption.quiz.api.response.e.dio;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class l extends TypeToken<List<? extends com.iqoption.quiz.api.response.j>> {
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/api/response/StatusResponse;", "kotlin.jvm.PlatformType", "it", "", "apply"})
    /* compiled from: TriviaApiSocket.kt */
    static final class m<T, R> implements io.reactivex.c.f<Throwable, com.iqoption.quiz.api.response.k> {
        public static final m dok = new m();

        m() {
        }

        /* renamed from: M */
        public final com.iqoption.quiz.api.response.k apply(Throwable th) {
            kotlin.jvm.internal.h.e(th, "it");
            return com.iqoption.quiz.api.response.k.diB;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/api/response/UserResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TriviaApiSocket.kt */
    static final class n<T> implements io.reactivex.c.e<o> {
        final /* synthetic */ c this$0;

        n(c cVar) {
            this.this$0 = cVar;
        }

        /* renamed from: b */
        public final void accept(o oVar) {
            this.this$0.doa.e(oVar);
        }
    }

    private final io.reactivex.e<Boolean> Jq() {
        kotlin.d dVar = this.aqs;
        kotlin.reflect.j jVar = apP[0];
        return (io.reactivex.e) dVar.getValue();
    }

    private final io.reactivex.e<o> aCM() {
        kotlin.d dVar = this.doc;
        kotlin.reflect.j jVar = apP[1];
        return (io.reactivex.e) dVar.getValue();
    }

    public c(com.iqoption.core.h hVar) {
        kotlin.jvm.internal.h.e(hVar, "connect");
        this.dnV = hVar.DS();
        this.dnW = hVar.DT();
        io.reactivex.processors.a aXp = PublishProcessor.aXq().aXp();
        kotlin.jvm.internal.h.d(aXp, "PublishProcessor.create<…esponse>().toSerialized()");
        this.doa = aXp;
        this.doc = g.f(new TriviaApiSocket$userData$2(this));
    }

    public io.reactivex.e<com.iqoption.quiz.api.response.h> a(com.iqoption.quiz.api.response.n nVar) {
        throw new NotImplementedError("not used in the socket version");
    }

    public io.reactivex.e<com.iqoption.quiz.api.response.k> jm(String str) {
        io.reactivex.e c = aCA().c((org.a.b) aCB());
        kotlin.jvm.internal.h.d(c, "getStatusDirect()\n      …tWith(getStatusUpdates())");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-status", 2, null);
        io.reactivex.e Jq = Jq();
        kotlin.jvm.internal.h.d(Jq, "isConnectedStream");
        return eVar.c(Jq).Yg();
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.k> aCA() {
        io.reactivex.e<com.iqoption.quiz.api.response.k> f = this.dnV.b("get-status", com.iqoption.quiz.api.response.k.class).cd(false).Sb().aWk().f(m.dok);
        kotlin.jvm.internal.h.d(f, "requestBuilder\n         …e.EMPTY_STATUS_RESPONSE }");
        return f;
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.k> aCB() {
        return d("status-changed", com.iqoption.quiz.api.response.k.class).Hr();
    }

    public io.reactivex.e<q> jl(String str) {
        io.reactivex.e c = aCC().c((org.a.b) aCD());
        kotlin.jvm.internal.h.d(c, "getWinners()\n           …With(getWinnersUpdates())");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-winners", 2, null);
        io.reactivex.e Jq = Jq();
        kotlin.jvm.internal.h.d(Jq, "isConnectedStream");
        return eVar.c(Jq).Yg();
    }

    private final io.reactivex.e<q> aCC() {
        io.reactivex.e<q> aWk = this.dnV.b("get-winners", q.class).cd(false).Sb().aWk();
        kotlin.jvm.internal.h.d(aWk, "requestBuilder\n         …            .toFlowable()");
        return aWk;
    }

    private final io.reactivex.e<q> aCD() {
        return d("winners-changed", q.class).Hr();
    }

    public io.reactivex.e<com.iqoption.quiz.api.response.d> jg(String str) {
        io.reactivex.e c = aCE().c((org.a.b) aCF());
        kotlin.jvm.internal.h.d(c, "getOnline()\n            …tWith(getOnlineUpdates())");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-online", 2, null);
        io.reactivex.e Jq = Jq();
        kotlin.jvm.internal.h.d(Jq, "isConnectedStream");
        return eVar.c(Jq).Yg();
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.d> aCE() {
        io.reactivex.e<com.iqoption.quiz.api.response.d> aWk = this.dnV.b("get-online", com.iqoption.quiz.api.response.d.class).cd(false).Sb().aWk();
        kotlin.jvm.internal.h.d(aWk, "requestBuilder\n         …            .toFlowable()");
        return aWk;
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.d> aCF() {
        return d("online-changed", com.iqoption.quiz.api.response.d.class).Hr();
    }

    public io.reactivex.e<com.iqoption.quiz.api.response.i> jk(String str) {
        io.reactivex.e c = aCG().c((org.a.b) aCH());
        kotlin.jvm.internal.h.d(c, "getSplash()\n            …tWith(getSplashUpdates())");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-splash", 2, null);
        io.reactivex.e Jq = Jq();
        kotlin.jvm.internal.h.d(Jq, "isConnectedStream");
        return eVar.c(Jq).Yg();
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.i> aCG() {
        io.reactivex.e<com.iqoption.quiz.api.response.i> aWk = this.dnV.b("get-splash", com.iqoption.quiz.api.response.i.class).cd(false).Sb().aWk();
        kotlin.jvm.internal.h.d(aWk, "requestBuilder\n         …            .toFlowable()");
        return aWk;
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.i> aCH() {
        return d("splash-changed", com.iqoption.quiz.api.response.i.class).Hr();
    }

    public io.reactivex.e<com.iqoption.quiz.api.response.e> jh(String str) {
        io.reactivex.e c = aCI().c((org.a.b) aCJ().a((io.reactivex.c.f) new h(this)));
        kotlin.jvm.internal.h.d(c, "getQuestion()\n          …latMap { getQuestion() })");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-question", 2, null);
        io.reactivex.e Jq = Jq();
        kotlin.jvm.internal.h.d(Jq, "isConnectedStream");
        return eVar.c(Jq).Yg();
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.e> aCI() {
        com.iqoption.quiz.a.a.did.go(0);
        io.reactivex.e<com.iqoption.quiz.api.response.e> f = this.dnV.b("get-question", com.iqoption.quiz.api.response.e.class).cd(false).Sb().aWk().a((io.reactivex.c.e) i.doh).f(j.doi);
        kotlin.jvm.internal.h.d(f, "requestBuilder\n         …EMPTY_QUESTION_RESPONSE }");
        return f;
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.e> aCJ() {
        io.reactivex.e<com.iqoption.quiz.api.response.e> d = d("question-shown", Object.class).Hr().d((io.reactivex.c.f) k.doj);
        kotlin.jvm.internal.h.d(d, "getEventBuilder(QUESTION…ESPONSE\n                }");
        return d;
    }

    public io.reactivex.e<com.iqoption.quiz.api.response.a> ji(String str) {
        io.reactivex.e c = aCK().c((org.a.b) aCL().a((io.reactivex.c.f) new b(this)));
        kotlin.jvm.internal.h.d(c, "getAnswer()\n            ….flatMap { getAnswer() })");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-answer", 2, null);
        io.reactivex.e Jq = Jq();
        kotlin.jvm.internal.h.d(Jq, "isConnectedStream");
        return eVar.c(Jq).Yg();
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.a> aCK() {
        io.reactivex.e<com.iqoption.quiz.api.response.a> f = this.dnV.b("get-answer", com.iqoption.quiz.api.response.a.class).cd(false).Sb().aWk().f(c.doe);
        kotlin.jvm.internal.h.d(f, "requestBuilder\n         …e.EMPTY_ANSWER_RESPONSE }");
        return f;
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.a> aCL() {
        io.reactivex.e<com.iqoption.quiz.api.response.a> d = d("answers-shown", Object.class).Hr().d((io.reactivex.c.f) d.dof);
        kotlin.jvm.internal.h.d(d, "getEventBuilder(ANSWERS_…e.EMPTY_ANSWER_RESPONSE }");
        return d;
    }

    public io.reactivex.e<Object> a(com.iqoption.quiz.api.response.m mVar) {
        io.reactivex.e<Object> bW;
        if (mVar == null) {
            bW = io.reactivex.e.bW(new Object());
            kotlin.jvm.internal.h.d(bW, "Flowable.just(Any())");
            return bW;
        }
        bW = this.dnV.b("send-answer", Object.class).j("answer", Integer.valueOf(mVar.aAD())).Sb().aWk();
        kotlin.jvm.internal.h.d(bW, "requestBuilder\n         …            .toFlowable()");
        return bW;
    }

    public io.reactivex.e<o> jj(String str) {
        return aCM();
    }

    private final io.reactivex.e<o> aCN() {
        io.reactivex.e<o> aWk = this.dnV.b("get-user", o.class).cd(false).Sb().aWk();
        kotlin.jvm.internal.h.d(aWk, "requestBuilder\n         …            .toFlowable()");
        return aWk;
    }

    private final io.reactivex.e<o> aCO() {
        return d("user-changed", o.class).h("user_id", Long.valueOf(com.iqoption.core.f.Dr().getUserId())).Hr();
    }

    public io.reactivex.e<Object> a(com.iqoption.quiz.api.response.f fVar) {
        io.reactivex.e<Object> R;
        if (fVar == null) {
            R = io.reactivex.e.R(new RuntimeException("invalid code"));
            kotlin.jvm.internal.h.d(R, "Flowable.error(RuntimeException(\"invalid code\"))");
            return R;
        }
        R = this.dnV.b("change-referral", Object.class).cd(false).j("code", fVar.getCode()).Sb().aWk();
        kotlin.jvm.internal.h.d(R, "requestBuilder\n         …            .toFlowable()");
        return R;
    }

    public io.reactivex.e<o> a(com.iqoption.quiz.api.response.g gVar) {
        io.reactivex.e<o> a = this.dnV.b("use-life", o.class).cd(false).Sb().aWk().a((io.reactivex.c.e) new n(this));
        kotlin.jvm.internal.h.d(a, "requestBuilder\n         … userSubject.onNext(it) }");
        return a;
    }

    public io.reactivex.o<Object> aAc() {
        return this.dnV.b("quiz", Object.class).cd(false).ga("ping").Sb();
    }

    public io.reactivex.o<List<com.iqoption.quiz.api.response.j>> a(StatType statType) {
        kotlin.jvm.internal.h.e(statType, Param.TYPE);
        Type type = new l().getType();
        kotlin.jvm.internal.h.d(type, "object : TypeToken<T>() {}.type");
        com.iqoption.core.connect.k a = this.dnV.a("get-stat", type);
        String str = Param.TYPE;
        String name = statType.name();
        if (name == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        name = name.toLowerCase();
        kotlin.jvm.internal.h.d(name, "(this as java.lang.String).toLowerCase()");
        return a.j(str, name).dF(0).Sb();
    }

    public io.reactivex.e<List<com.iqoption.quiz.api.response.b>> aAd() {
        io.reactivex.e c = aCP().c((org.a.b) aCQ());
        kotlin.jvm.internal.h.d(c, "getInsightsDirect()\n    …With(getInsightUpdates())");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-insight", 2, null);
        io.reactivex.e Jq = Jq();
        kotlin.jvm.internal.h.d(Jq, "isConnectedStream");
        return eVar.c(Jq).Yg();
    }

    private final io.reactivex.e<List<com.iqoption.quiz.api.response.b>> aCP() {
        Type type = new f().getType();
        kotlin.jvm.internal.h.d(type, "object : TypeToken<T>() {}.type");
        io.reactivex.e<List<com.iqoption.quiz.api.response.b>> f = this.dnV.a("get-insight", type).dF(3).Sb().aWk().f(g.dog);
        kotlin.jvm.internal.h.d(f, "requestBuilder\n         …nErrorReturn { listOf() }");
        return f;
    }

    private final io.reactivex.e<List<com.iqoption.quiz.api.response.b>> aCQ() {
        io.reactivex.e<List<com.iqoption.quiz.api.response.b>> a = d("insight-changed", Object.class).Hr().a((io.reactivex.c.f) new e(this));
        kotlin.jvm.internal.h.d(a, "getEventBuilder(INSIGHTS…p { getInsightsDirect() }");
        return a;
    }

    private final <T> com.iqoption.core.connect.d<T> d(String str, Class<T> cls) {
        if (cls != null) {
            com.iqoption.core.connect.d<T> c = this.dnW.c(str, cls);
            c.h("quiz", Integer.valueOf(com.iqoption.core.f.Dr().Dh()));
            return c;
        }
        throw new IllegalArgumentException("Class and default value must not be null both");
    }
}
