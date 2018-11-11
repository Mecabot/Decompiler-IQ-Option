package com.iqoption.kyc.a;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.util.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;

/* compiled from: KycAnalyticsEventUtils */
public final class a {
    private static JsonObject h(String str, String str2, boolean z) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).l("stage_name", str).l("screen_name", str2).aab();
    }

    private static JsonObject dS(boolean z) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).aab();
    }

    private static JsonObject b(String str, String str2, String str3, boolean z) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).l("stage_name", str).l("screen_name", str2).l("field_name", str3).aab();
    }

    private static JsonObject c(String str, String str2, String str3, boolean z) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).l("stage_name", str).l("screen_name", str2).l("screen_name_to_return", str3).aab();
    }

    private static JsonObject q(String str, boolean z) {
        if (str == null) {
            return dS(z);
        }
        return i.ZZ().l("error_response", str).l("is_regulated", Boolean.valueOf(z)).aab();
    }

    private static JsonObject d(String str, String str2, String str3, boolean z) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).l("stage_name", str).l("screen_name", str2).l("screen_name_to_continue", str3).aab();
    }

    private static JsonObject a(String str, String str2, String str3, int i, ImmutableList<Integer> immutableList, ImmutableList<String> immutableList2) {
        String join = Joiner.e(';').join((Iterable) immutableList);
        return i.ZZ().l("stage_name", str).l("screen_name", str2).l("question_text", str3).l("question_id", Integer.valueOf(i)).l("answers_ids", join).l("answer_texts", Joiner.e(';').join((Iterable) immutableList2)).aab();
    }

    private static JsonObject e(String str, String str2, String str3, boolean z) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).l("stage_name", str).l("screen_name", str2).l("warning_text", str3).aab();
    }

    private static JsonObject f(String str, String str2, String str3, boolean z) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).l("stage_name", str).l("screen_name", str2).l("warning_text", str3).aab();
    }

    private static JsonObject a(String str, String str2, boolean z, String str3) {
        return i.ZZ().l("is_regulated", Boolean.valueOf(z)).l("stage_name", str).l("screen_name", str2).l("country_name", str3).aab();
    }

    public static Builder apP() {
        return Event.Builder(Event.CATEGORY_SCREEN_OPENED, "kyc_new-screen");
    }

    public static Builder apQ() {
        return Event.Builder(Event.CATEGORY_SCREEN_OPENED, "kyc_traderoom-blocked");
    }

    public static void a(Context context, Builder builder, String str, String str2, boolean z) {
        JsonElement dS;
        if ("TraderoomBlocked".equals(str)) {
            dS = dS(z);
        } else {
            dS = h(str, str2, z);
        }
        EventManager.Bm().a(builder.calcDuration().setParameters(dS).build());
    }

    public static void a(Context context, String str, String str2, String str3, int i, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_TEXT_CHANGED, "kyc_focus-on-field").setValue(Double.valueOf((double) i)).setParameters(b(str, str2, str3, z)).build());
    }

    public static void a(Context context, String str, String str2, String str3, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_return").setParameters(c(str, str2, str3, z)).build());
    }

    public static void b(Context context, String str, String str2, String str3, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_continue").setParameters(d(str, str2, str3, z)).build());
    }

    public static void a(Context context, String str, String str2, String str3, int i, ImmutableList<Integer> immutableList, ImmutableList<String> immutableList2) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_choose-answer").setParameters(a(str, str2, str3, i, (ImmutableList) immutableList, (ImmutableList) immutableList2)).build());
    }

    public static void c(Context context, String str, String str2, String str3, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "kyc_warning").setParameters(e(str, str2, str3, z)).build());
    }

    public static void a(Context context, String str, String str2, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_done").setParameters(h(str, str2, z)).build());
    }

    public static void b(Context context, String str, String str2, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_risk-disclosure").setParameters(h(str, str2, z)).build());
    }

    public static void c(Context context, String str, String str2, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_risk-disclosure-done").setParameters(h(str, str2, z)).build());
    }

    public static void e(Context context, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "kyc_jumio-open").setParameters(dS(z)).build());
    }

    public static void a(Context context, boolean z, @Nullable String str, boolean z2) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "kyc_jumio-response").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(q(str, z2)).build());
    }

    public static void a(Context context, @Nullable String str, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "kyc_upload-document-error").setParameters(q(str, z)).build());
    }

    public static void a(Context context, boolean z, String str, String str2, boolean z2) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_attach-doc-later").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(h(str, str2, z2)).build());
    }

    public static void a(Context context, boolean z, String str, String str2, String str3, boolean z2) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_is-citizen").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(f(str, str2, str3, z2)).build());
    }

    public static void b(Context context, boolean z, @Nullable String str, boolean z2) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "kyc_save-profile").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(q(str, z2)).build());
    }

    public static void b(Context context, boolean z, String str, String str2, boolean z2) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_choose-sex").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(h(str, str2, z2)).build());
    }

    public static void c(Context context, boolean z, String str, String str2, boolean z2) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_choose-us-reportable").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(h(str, str2, z2)).build());
    }

    public static void a(Context context, String str, String str2, boolean z, String str3) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "kyc_choose-country").setParameters(a(str, str2, z, str3)).build());
    }

    public static void z(Context context, String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "compliance_failed").setParameters(i.ZZ().l("error_response", str).aab()).build());
    }
}
