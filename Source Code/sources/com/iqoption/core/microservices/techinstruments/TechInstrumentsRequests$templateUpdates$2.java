package com.iqoption.core.microservices.techinstruments;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import com.iqoption.core.microservices.techinstruments.a.c;
import io.reactivex.e;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/techinstruments/response/ModifiedTemplates;", "invoke"})
/* compiled from: TechInstrumentsRequests.kt */
final class TechInstrumentsRequests$templateUpdates$2 extends Lambda implements kotlin.jvm.a.a<e<c>> {
    public static final TechInstrumentsRequests$templateUpdates$2 aXW = new TechInstrumentsRequests$templateUpdates$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/techinstruments/TechInstrumentsRequests$templateUpdates$2$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<c> {
    }

    TechInstrumentsRequests$templateUpdates$2() {
        super(0);
    }

    /* renamed from: Jr */
    public final e<c> invoke() {
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DT().b("modified-templates", type).Hr();
    }
}
