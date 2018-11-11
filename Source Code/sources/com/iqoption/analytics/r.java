package com.iqoption.analytics;

import com.iqoption.core.a.d;
import com.iqoption.core.a.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010!\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/analytics/VipManagerEventHelper;", "", "()V", "analyticsEvent", "Lcom/iqoption/core/analytics/IQAnalytics;", "aboutCall", "", "aboutClose", "callCancel", "callClose", "callRequest", "success", "", "callSetTime", "chooseTimeCancel", "chooseTimeClose", "chooseTimeSelect", "chooseTimeTapTime", "createAboutShowEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "createCallShowEvent", "createEducationShowEvent", "createTimeShowEvent", "createTrainingSessionOpenEvent", "educationClose", "educationTapQuestion", "categoryId", "", "sessionId", "educationTapSection", "trainingSessionCancel", "trainingSessionClose", "trainingSessionSchedule", "trainingSessionSetTime", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipManagerEventHelper.kt */
public final class r {
    private static final e ajn;
    public static final r ajo = new r();

    static {
        f Br = f.Br();
        h.d(Br, "EventUtils.instance()");
        ajn = Br;
    }

    private r() {
    }

    public final d BN() {
        d dY = ajn.dY("vip-manager-about_show");
        h.d(dY, "analyticsEvent.createPop…\"vip-manager-about_show\")");
        return dY;
    }

    public final d BO() {
        d dY = ajn.dY("vip-manager-call_show");
        h.d(dY, "analyticsEvent.createPop…(\"vip-manager-call_show\")");
        return dY;
    }

    public final d BP() {
        d dY = ajn.dY("choose-time_show");
        h.d(dY, "analyticsEvent.createPop…Event(\"choose-time_show\")");
        return dY;
    }

    public final d BQ() {
        d dY = ajn.dY("vip-manager-education_show");
        h.d(dY, "analyticsEvent.createPop…-manager-education_show\")");
        return dY;
    }

    public final d BR() {
        d dY = ajn.dY("training-session_open");
        h.d(dY, "analyticsEvent.createPop…(\"training-session_open\")");
        return dY;
    }

    public final void BS() {
        ajn.dV("vip-manager-about_close");
    }

    public final void BT() {
        ajn.dV("vip-manager-about_call");
    }

    public final void BU() {
        ajn.dV("vip-manager-call_close");
    }

    public final void BV() {
        ajn.dV("vip-manager-call_cancel");
    }

    public final void aB(boolean z) {
        ajn.b("vip-manager-call_request-call", z ? 1.0d : 0.0d);
    }

    public final void BW() {
        ajn.dV("vip-manager-call_set-time");
    }

    public final void BX() {
        ajn.dV("choose-time_close");
    }

    public final void BY() {
        ajn.dV("choose-time_tap-time");
    }

    public final void BZ() {
        ajn.dV("choose-time_select");
    }

    public final void Ca() {
        ajn.dV("choose-time_cancel");
    }

    public final void U(long j) {
        ajn.a("vip-manager-education_tap-section", 0.0d, com.iqoption.core.util.i.ZZ().l("section_id", Long.valueOf(j)).aab());
    }

    public final void j(long j, long j2) {
        ajn.a("vip-manager-education_tap-question", 0.0d, com.iqoption.core.util.i.ZZ().l("section_id", Long.valueOf(j)).l("question_id", Long.valueOf(j2)).aab());
    }

    public final void Cb() {
        ajn.dV("vip-manager-education_close");
    }

    public final void Cc() {
        ajn.dV("training-session_close");
    }

    public final void Cd() {
        ajn.dV("training-session_cancel");
    }

    public final void aC(boolean z) {
        ajn.b("training-session_schedule-session", z ? 1.0d : 0.0d);
    }

    public final void Ce() {
        ajn.dV("training-session_set-time");
    }
}
