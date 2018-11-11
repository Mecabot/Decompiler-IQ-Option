package com.iqoption.util;

import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/* compiled from: Gsons */
public final class ah {
    private static final n<Gson> dvO = Suppliers.a(ai.ajD);
    private static final n<JsonParser> dvP = Suppliers.a(aj.ajD);
    private static final n<Gson> dvQ = Suppliers.a(ak.ajD);

    public static Gson aGg() {
        return (Gson) dvQ.get();
    }

    public static Gson aGh() {
        return (Gson) dvO.get();
    }

    public static JsonParser aGi() {
        return (JsonParser) dvP.get();
    }
}
