package com.iqoption.core.microservices.configuration;

import com.iqoption.core.ext.d;
import com.iqoption.core.microservices.configuration.a.c;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/configuration/response/Country;", "it", "", "invoke"})
/* compiled from: ConfigurationRequests.kt */
final class ConfigurationRequests$getCountriesHttp$1 extends Lambda implements b<String, List<? extends c>> {
    public static final ConfigurationRequests$getCountriesHttp$1 aUM = new ConfigurationRequests$getCountriesHttp$1();

    ConfigurationRequests$getCountriesHttp$1() {
        super(1);
    }

    /* renamed from: gA */
    public final List<c> invoke(String str) {
        h.e(str, "it");
        return ((com.iqoption.core.microservices.configuration.a.b) d.b(str, com.iqoption.core.microservices.configuration.a.b.class, null, 2, null)).getCountries();
    }
}
