package com.iqoption.quiz.a;

import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.core.a.c;
import com.iqoption.core.a.d;
import com.iqoption.core.a.e;
import com.iqoption.core.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u00120\u0012J\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\n \u0018*\u0004\u0018\u00010\u00120\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\u0016\u0010\u001c\u001a\n \u0018*\u0004\u0018\u00010\u00120\u00122\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\n \u0018*\u0004\u0018\u00010\u00120\u0012J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000fJ\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u0006J\u0006\u0010'\u001a\u00020\u0006J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020\u0006J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rJ\u0006\u0010.\u001a\u00020\u0006J\u0016\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\nJ\u0016\u00103\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u00104\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u00105\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rJ\u0006\u00106\u001a\u00020\u0006J\u0006\u00107\u001a\u00020\u0006J\u000e\u00108\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000fJ\u000e\u00109\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000fJ\u0016\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\nJ\u0006\u0010=\u001a\u00020\u0006J\u0016\u0010>\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010?\u001a\u00020\rJ\u000e\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\rJ\u001e\u0010B\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010C\u001a\u00020\u0006J\u000e\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\rJ\u0006\u0010F\u001a\u00020\u0006J\u0006\u0010G\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, aXE = {"Lcom/iqoption/quiz/analytics/QuizEventHelper;", "", "()V", "analytics", "Lcom/iqoption/core/analytics/IQAnalytics;", "addFriend", "", "appLaunchByQuizLanding", "appLaunchByQuizRef", "refCode", "", "chooseAnswer", "canAnswer", "", "answer", "", "question", "createExtraLiveShowEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "createGameInsightsShow", "createInsightsScrollEventHelper", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "createLeaderBoardScrollEventHelper", "createLeaderBoardShow", "kotlin.jvm.PlatformType", "createOutOfQuizShowEvent", "createPromoCodeShown", "createQuizShowEvent", "createSplashShow", "fullScreen", "createUpdateQuizShown", "createWinnerPopupShowEvent", "wanAmount", "", "errorShown", "eventQuestionShownReceived", "step", "expand", "getLife", "info", "insightsOpen", "assetId", "type", "join", "languageTipCloseByUser", "languageTipShow", "leaderBoardPositionShow", "leaderBoardTapPosition", "positionId", "", "winAmount", "newQuestion", "offAirShown", "onAirShown", "outOfQuizGotIt", "outWinnerGotIt", "questionReceived", "questionRequested", "questionSubscribe", "isRegulated", "msg", "questionUnSubscribe", "refCodeUsed", "isHandInputted", "rulesShown", "show", "sendAnswer", "sendMessage", "sound", "isOn", "updateApp", "useExtraLive", "quiz_release"})
/* compiled from: QuizEventHelper.kt */
public final class a {
    private static final e aMD = f.RQ().Ds();
    public static final a did = new a();

    private a() {
    }

    public final d azH() {
        d dZ = aMD.dZ("iq-quiz_show");
        h.d(dZ, "analytics.createScreenOpenedEvent(\"iq-quiz_show\")");
        return dZ;
    }

    public final d azI() {
        d dY = aMD.dY("iq-quiz_extra-live-show");
        h.d(dY, "analytics.createPopupSer…iq-quiz_extra-live-show\")");
        return dY;
    }

    public final d azJ() {
        d dY = aMD.dY("iq-quiz_out-of-quiz-show");
        h.d(dY, "analytics.createPopupSer…q-quiz_out-of-quiz-show\")");
        return dY;
    }

    public final d D(double d) {
        d c = aMD.c("iq-quiz_winner-popup-show", d);
        h.d(c, "analytics.createPopupSer…r-popup-show\", wanAmount)");
        return c;
    }

    public final d azK() {
        d d = aMD.d("iq-quiz_game-insights-show", 0.0d);
        h.d(d, "analytics.createScreenOp…game-insights-show\", 0.0)");
        return d;
    }

    public final OnScrollListener azL() {
        return new c(aMD, "iq-quiz_leaderboard-scroll", 10);
    }

    public final OnScrollListener azM() {
        return new c(aMD, "iq-quiz_game-insights-scroll", 1);
    }

    public final d azN() {
        return aMD.dZ("iq-quiz_leaderboard-show");
    }

    public final d ey(boolean z) {
        return aMD.d("iq-quiz_splash-show", z ? 1.0d : 0.0d);
    }

    public final d azO() {
        return aMD.dZ("iq-quiz_update-show");
    }

    public final d azP() {
        return aMD.dZ("iq-quiz_promo-code-show");
    }

    public final void azQ() {
        aMD.dV("iq-quiz_add-friend");
    }

    public final void azR() {
        aMD.dV("iq-quiz_get-life");
    }

    public final void ez(boolean z) {
        aMD.b("iq-quiz_sound", z ? 1.0d : 0.0d);
    }

    public final void join() {
        aMD.dV("iq-quiz_join");
    }

    public final void expand() {
        aMD.dV("iq-quiz_expand");
    }

    public final void e(boolean z, int i) {
        aMD.a("iq-quiz_new-question", z ? 1.0d : 0.0d, com.iqoption.core.util.i.ZZ().l("question_id", Integer.valueOf(i)).aab());
    }

    public final void b(boolean z, int i, int i2) {
        aMD.a("iq-quiz_send-answer", z ? 1.0d : 0.0d, com.iqoption.core.util.i.ZZ().l("answer_id", Integer.valueOf(i)).l("question_id", Integer.valueOf(i2)).aab());
    }

    public final void c(boolean z, int i, int i2) {
        aMD.a("iq-quiz_choose-answer", z ? 1.0d : 0.0d, com.iqoption.core.util.i.ZZ().l("answer_id", Integer.valueOf(i)).l("question_id", Integer.valueOf(i2)).aab());
    }

    public final void s(String str, boolean z) {
        h.e(str, "refCode");
        aMD.a("iq-quiz_ref-code-used", z ? 1.0d : 0.0d, com.iqoption.core.util.i.ZZ().l("ref_code", str).aab(), false);
    }

    public final void azS() {
        aMD.dV("iq-quiz_use-extra-live");
    }

    public final void azT() {
        aMD.dV("iq-quiz_out-of-quiz-got-it");
    }

    public final void azU() {
        aMD.dV("iq-quiz_winner-got-it");
    }

    public final void sendMessage() {
        aMD.dV("iq-quiz_send-message");
    }

    public final void azV() {
        aMD.dV("iq-quiz_info");
    }

    public final void eA(boolean z) {
        aMD.d("iq-quiz_quiz-error", z ? 1.0d : 0.0d).Bs();
    }

    public final void eB(boolean z) {
        aMD.d("iq-quiz_off-air-show", z ? 1.0d : 0.0d).Bs();
    }

    public final void eC(boolean z) {
        aMD.d("iq-quiz_on-air-show", z ? 1.0d : 0.0d).Bs();
    }

    public final void eD(boolean z) {
        aMD.d("iq-quiz_quiz-rules-show", z ? 1.0d : 0.0d).Bs();
    }

    public final void eE(boolean z) {
        aMD.c("iq-quiz_language-tip-show", z ? 1.0d : 0.0d).Bs();
    }

    public final void azW() {
        aMD.dV("iq-quiz_language-tip-close");
    }

    public final void jf(String str) {
        h.e(str, "refCode");
        aMD.a("app_launch-ref-code-quiz", 0.0d, com.iqoption.core.util.i.ZZ().l("ref_code", str).aab(), false);
    }

    public final void azX() {
        aMD.g("app_launch-landing-quiz", false);
    }

    public final void azY() {
        aMD.dY("iq-quiz_leaderboard-position-show").Bs();
    }

    public final void h(long j, String str) {
        h.e(str, "winAmount");
        aMD.a("iq-quiz_leaderboard-tap-position", (double) j, com.iqoption.core.util.i.ZZ().l("win_amount", str).aab());
    }

    public final void i(int i, String str) {
        h.e(str, Param.TYPE);
        aMD.a("iq-quiz_game-insights-open", 0.0d, com.iqoption.core.util.i.ZZ().l("asset_id", Integer.valueOf(i)).l(Param.TYPE, str).aab());
    }

    public final void azZ() {
        aMD.dV("iq-quiz_update-app");
    }

    public final void gn(int i) {
        aMD.a("iq-quiz_event-question-shown-received", (double) i, false);
    }

    public final void go(int i) {
        aMD.a("iq-quiz_question-requested", (double) i, false);
    }

    public final void gp(int i) {
        aMD.a("iq-quiz_question-received", (double) i, false);
    }

    public final void i(boolean z, String str) {
        h.e(str, NotificationCompat.CATEGORY_MESSAGE);
        aMD.a("iq-quiz_question-subscribe", z ? 1.0d : 0.0d, com.iqoption.core.util.i.ZZ().l(NotificationCompat.CATEGORY_MESSAGE, str).aab(), false);
    }

    public final void aAa() {
        aMD.g("iq-quiz_question-unsubscribe", false);
    }
}
