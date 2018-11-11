package com.iqoption.charttools.tools;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonObject;
import com.iqoption.core.f;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\n\u0010\u0007\u001a\u00060\bR\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fJ\u0016\u0010*\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e¨\u0006-"}, aXE = {"Lcom/iqoption/charttools/tools/ToolsAnalyticsHelper;", "", "()V", "attachTemplateNameChangedHelper", "", "input", "Landroid/widget/EditText;", "createTemplateSettings", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "sendAcceptInstrumentSettings", "isLine", "", "type", "", "sendDefaultInstrumentSettings", "sendDragLine", "sendSettingToggled", "name", "enabled", "sendShowActiveIndicators", "sendShowChartInstruments", "sendShowIndicators", "sendShowTemplates", "sendTemplateApply", "indicatorsCount", "", "figuresCount", "sendTemplateChartSettings", "sendTemplateClose", "sendTemplateDelete", "sendTemplateEdit", "sendTemplateSave", "sendTemplateSettingAutoScaling", "sendTemplateSettingHeikinAshi", "sendTemplateSettingLiveDeals", "sendTemplateSettingTradersMood", "sendTemplateSettingVolume", "sendTemplatesCreate", "sendToggleApplyToAllAssets", "sendToggleTradersMood", "sendToggleVolume", "sentTemplateIndicatorHide", "hidden", "sentTemplateIndicatorRemove", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ToolsAnalyticsHelper.kt */
public final class d {
    public static final d aAz = new d();

    private d() {
    }

    public final void Np() {
        f.RQ().Ds().dV("tranderoom_show-chart-instruments");
    }

    public final void Nq() {
        f.RQ().Ds().dV("chart-instruments_show-indicators");
    }

    public final void Nr() {
        f.RQ().Ds().dV("chart-instruments_show-active-indicators");
    }

    public final void bV(boolean z) {
        f.RQ().Ds().b("chart-instruments_traders-mood", z ? 1.0d : 0.0d);
    }

    public final void bW(boolean z) {
        f.RQ().Ds().b("chart-instruments_indicators-to-all-assets", z ? 1.0d : 0.0d);
    }

    public final void bX(boolean z) {
        f.RQ().Ds().b("chart-instruments_volune", z ? 1.0d : 0.0d);
    }

    public final void fG(String str) {
        h.e(str, Param.TYPE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("line_type", str);
        f.RQ().Ds().b("chart_drag-line", jsonObject);
    }

    public final void Ns() {
        f.RQ().Ds().dV("chart-instruments_show-templates");
    }

    public final Builder Nt() {
        Builder Builder = Event.Builder(Event.CATEGORY_POPUP_SERVED, "chart-instruments_templates-settings");
        h.d(Builder, "Event.Builder(Event.CATE…ents_templates-settings\")");
        return Builder;
    }

    public final void Z(int i, int i2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("indicators_count", (Number) Integer.valueOf(i));
        jsonObject.addProperty("lines_count", (Number) Integer.valueOf(i2));
        f.RQ().Ds().a("chart-instruments_templates-apply", jsonObject);
    }

    public final void Y(int i, int i2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("indicators_count", (Number) Integer.valueOf(i));
        jsonObject.addProperty("lines_count", (Number) Integer.valueOf(i2));
        f.RQ().Ds().a("chart-instruments_templates-delete", jsonObject);
    }

    public final void aa(int i, int i2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("indicators_count", (Number) Integer.valueOf(i));
        jsonObject.addProperty("lines_count", (Number) Integer.valueOf(i2));
        f.RQ().Ds().a("chart-instruments_templates-edit", jsonObject);
    }
}
