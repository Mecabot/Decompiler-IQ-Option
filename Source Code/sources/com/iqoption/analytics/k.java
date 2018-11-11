package com.iqoption.analytics;

import android.support.v4.app.NotificationCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.app.a;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.portfolio.b;
import com.iqoption.portfolio.component.b.j;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.util.i;

/* compiled from: PortfolioEventHelper */
public class k {
    public static void Bv() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-open-deals").build());
    }

    public static void Bw() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-closed-deals").build());
    }

    public static void Bx() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-instruments-filter").build());
    }

    public static void cF(int i) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("filter_key", new JsonPrimitive(Integer.valueOf(i)));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_choose-instrument-filter").setParameters(jsonObject).build());
    }

    public static void a(b bVar) {
        JsonElement jsonObject = new JsonObject();
        InstrumentType instrumentType = bVar.getInstrumentType();
        jsonObject.add("instrument_type", new JsonPrimitive(instrumentType != null ? instrumentType.getServerValue() : ""));
        if (bVar.avT() == 1) {
            Object avS = bVar.avS();
            if (!i.H(avS)) {
                jsonObject.add("instrument_direction", new JsonPrimitive(((e) avS.get(0)).isCall() ? NotificationCompat.CATEGORY_CALL : "put"));
            }
        }
        jsonObject.add("close_time ", new JsonPrimitive(Long.valueOf(bVar.getCloseTime())));
        jsonObject.add("pnl ", new JsonPrimitive(Double.valueOf(bVar.avU().getSellPnl())));
        jsonObject.add("balance_type_id", new JsonPrimitive(a.Cw().getBalanceId()));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-closed-deal-details").setValue(Double.valueOf(bVar.avU().getValue())).setParameters(jsonObject).build());
    }

    public static void a(InstrumentType instrumentType) {
        JsonElement jsonObject = new JsonObject();
        if (instrumentType != null) {
            jsonObject.add("instrument_type", new JsonPrimitive(instrumentType.getServerValue()));
        }
        jsonObject.add("balance_type_id", new JsonPrimitive(a.Cw().getBalanceId()));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_close-closed-deal-details").setParameters(jsonObject).build());
    }

    public static void a(j jVar, boolean z) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("instrument_type ", new JsonPrimitive(g.a(jVar)));
        jsonObject.add("balance_type_id", new JsonPrimitive(a.Cw().getBalanceId()));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-open-deal-details").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(jsonObject).build());
    }

    public static void b(j jVar) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("instrument_type ", new JsonPrimitive(g.a(jVar)));
        jsonObject.add("instrument_direction", new JsonPrimitive(jVar.isCall() ? NotificationCompat.CATEGORY_CALL : "put"));
        jsonObject.add("close_time", new JsonPrimitive(Long.valueOf(af.Hu().Hw())));
        jsonObject.add("pnl", new JsonPrimitive(Double.valueOf(jVar.avU().getSellPnl())));
        jsonObject.add("balance_type_id", new JsonPrimitive(a.Cw().getBalanceId()));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_sell-open-deal").setValue(Double.valueOf(jVar.avU().getValue())).setParameters(jsonObject).build());
    }

    public static void By() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_extend-potfolio").build());
    }

    public static void Bz() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_rollup-extended-portfolio").build());
    }

    public static void b(j jVar, boolean z) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("instrument_type ", new JsonPrimitive(g.a(jVar)));
        jsonObject.add("balance_type_id", new JsonPrimitive(a.Cw().getBalanceId()));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-open-deal-details-ext").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(jsonObject).build());
    }

    public static void c(j jVar) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("instrument_type ", new JsonPrimitive(g.a(jVar)));
        jsonObject.add("instrument_direction", new JsonPrimitive(jVar.isCall() ? NotificationCompat.CATEGORY_CALL : "put"));
        jsonObject.add("close_time", new JsonPrimitive(Long.valueOf(af.Hu().Hw())));
        jsonObject.add("pnl", new JsonPrimitive(Double.valueOf(jVar.avU().getSellPnl())));
        jsonObject.add("balance_type_id", new JsonPrimitive(a.Cw().getBalanceId()));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_sell-open-deal-ext").setValue(Double.valueOf(jVar.avU().getValue())).setParameters(jsonObject).build());
    }

    public static void BA() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_open-tpsl-limits-settings").build());
    }

    public static void BB() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-pending-deals").build());
    }

    public static void a(m mVar, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_pending-deal-details").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", mVar.Jg().getInstrumentType()).l("balance_type_id", a.Cw().getBalanceId()).aab()).build());
    }

    public static void b(m mVar, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_show-pending-deal-details-ext").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", mVar.Jg().getInstrumentType()).l("balance_type_id", a.Cw().getBalanceId()).aab()).build());
    }

    public static void a(m mVar) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_cancel-pending-deal").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", mVar.Jg().getInstrumentType()).l("balance_type_id", a.Cw().getBalanceId()).aab()).build());
    }

    public static void b(m mVar) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_cancel-pending-deal-ext").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", mVar.Jg().getInstrumentType()).l("balance_type_id", a.Cw().getBalanceId()).aab()).build());
    }

    public static Builder BC() {
        return Event.Builder(Event.CATEGORY_POPUP_SERVED, "portfolio_confirm-pending-cancellation");
    }

    public static void ay(boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "portfolio_confirm-pending-cancellation-option").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
    }
}
