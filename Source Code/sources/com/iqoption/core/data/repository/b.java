package com.iqoption.core.data.repository;

import com.iqoption.core.microservices.core.a.a;
import io.reactivex.o;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/core/data/repository/CoreRepository;", "", "()V", "DEFAULT_API_KEY", "", "getMyCountry", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/core/response/MyCountryResponse;", "apiKey", "core_release"})
/* compiled from: CoreRepository.kt */
public final class b {
    public static final b aOJ = new b();

    private b() {
    }

    public static /* synthetic */ o a(b bVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = (String) null;
        }
        return bVar.gn(str);
    }

    public final o<a> gn(String str) {
        com.iqoption.core.microservices.core.a aVar = com.iqoption.core.microservices.core.a.aVw;
        if (str == null) {
            str = "6BV5V9N9NVBB8N0VB89NbN483VB";
        }
        return aVar.gn(str);
    }
}
