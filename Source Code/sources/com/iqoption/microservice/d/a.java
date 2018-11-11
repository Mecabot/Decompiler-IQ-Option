package com.iqoption.microservice.d;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.b;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.d.a.c;
import com.iqoption.microservice.d.a.e;
import java.util.concurrent.TimeUnit;

/* compiled from: OtnTokenRequests */
public final class a {
    private static b<String, com.iqoption.microservice.d.a.a> aJR = CacheBuilder.qh().A(1000).a(1, TimeUnit.MINUTES).qw();

    public static s<e> asK() {
        return new com.iqoption.mobbtech.connect.request.a.a.b.a(e.class).ga("get-operations").cd(false).Sa();
    }

    public static s<c> asL() {
        return new com.iqoption.mobbtech.connect.request.a.a.b.a(c.class).ga("get-emission-summary").cd(false).Sa();
    }

    public static s<com.iqoption.microservice.d.a.a> asM() {
        return new com.iqoption.mobbtech.connect.request.a.a.b.a(com.iqoption.microservice.d.a.a.class).ga("get-coin-balance").cd(false).Sa();
    }

    public static s<com.iqoption.microservice.d.a.b> asN() {
        return new com.iqoption.mobbtech.connect.request.a.a.b.a(com.iqoption.microservice.d.a.b.class).ga("get-emission-history").cd(false).Sa();
    }
}
