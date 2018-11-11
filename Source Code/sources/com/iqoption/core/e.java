package com.iqoption.core;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\r\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u001f\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R$\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\u000eR$\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\u000e¨\u0006+"}, aXE = {"Lcom/iqoption/core/DebugConsole;", "", "()V", "INT", "", "getINT", "()Ljava/lang/String;", "PROD", "getPROD", "SANDBOX", "getSANDBOX", "aff", "getAff", "setAff", "(Ljava/lang/String;)V", "afftrack", "getAfftrack", "setAfftrack", "isAff", "", "()Z", "(Z)V", "isAfftrack", "isCustomCoockie", "setCustomCoockie", "isCustomCoockieKey", "setCustomCoockieKey", "isCustomCoockieValue", "setCustomCoockieValue", "isDebugMode", "isStaging", "isWsRoute", "value", "staging", "getStaging", "setStaging", "wsRoute", "getWsRoute", "setWsRoute", "applyHost", "", "newHost", "changeHost", "core_release"})
/* compiled from: DebugConsole.kt */
public final class e {
    private static final String aMh = "https://iqoption.com/";
    private static final String aMi = "https://int.iqoption.com/";
    private static final String aMj = "http://build.sandbox3.mobbtech.com/";
    private static String aMk = "";
    private static String aMl = "";
    private static String aMm = "";
    private static String aMn = "";
    private static String aMo = "";
    private static String aMp = "";
    private static final boolean aMq = false;
    public static final e aMr = new e();

    private e() {
    }

    public final String RJ() {
        return aMh;
    }

    public final String RK() {
        return aMi;
    }

    public final boolean RL() {
        return h.E(aMk, "") ^ 1;
    }

    public final String RM() {
        return aMk;
    }

    public final boolean RN() {
        return h.E(aMl, "") ^ 1;
    }

    public final String RO() {
        return aMl;
    }

    public final boolean RP() {
        return aMq;
    }
}
