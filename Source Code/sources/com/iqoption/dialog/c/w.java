package com.iqoption.dialog.c;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.analytics.EventManager;
import com.iqoption.dto.Event;

/* compiled from: TpslEventHelper */
public class w {
    public static void aft() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl-limits_add-profit-limits").build());
    }

    public static void afu() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl-limits_delete-profit-limits").build());
    }

    public static void afv() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl-limits_switch-percentage-amount").build());
    }

    public static void hp(String str) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("button_value ", new JsonPrimitive(str));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl-limits_keyboard-button").setParameters(jsonObject).build());
    }

    public static void afw() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl-limits_keyboard-button-delete").build());
    }

    public static void a(String str, boolean z, double d) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("value_type ", new JsonPrimitive(str));
        jsonObject.add("is_error ", new JsonPrimitive(Boolean.valueOf(z)));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl-limits_keyboard-button-done").setValue(Double.valueOf(d)).setParameters(jsonObject).build());
    }

    public static void afx() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, " tpsl-limits_error").build());
    }

    public static void a(String str, int i, String str2, boolean z, double d) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.add("limit_type ", new JsonPrimitive(str));
        jsonObject.add("modification_type ", new JsonPrimitive(Integer.valueOf(i)));
        jsonObject.add("value_type ", new JsonPrimitive(str2));
        jsonObject.add("is_error ", new JsonPrimitive(Boolean.valueOf(z)));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl-limits_change-limits").setValue(Double.valueOf(d)).setParameters(jsonObject).build());
    }

    public static void afy() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "tpsl-limits_cancel").build());
    }

    public static void afz() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "tpsl-limits_save").build());
    }

    public static void cK(boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tpsl_enable-margin-add-on").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
    }
}
