package com.iqoption.core.microservices.d;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import com.iqoption.core.microservices.d.a.b;
import com.iqoption.core.util.q;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/microservices/resources/ResourceRequests;", "", "()V", "CMD_GET_RESOURCES", "", "RESOLUTION_HDPI", "RESOLUTION_MDPI", "RESOLUTION_XHDPI", "RESOLUTION_XXHDPI", "RESOLUTION_XXXHDPI", "getResolution", "getResources", "Lio/reactivex/Single;", "", "Lcom/iqoption/core/microservices/resources/responses/ResourceElement;", "id", "resolution", "core_release"})
/* compiled from: ResourceRequests.kt */
public final class a {
    public static final a aXm = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/resources/ResourceRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<List<? extends b>> {
    }

    private a() {
    }

    public final String WA() {
        String bi = q.bi(f.RR());
        if (bi != null) {
            int hashCode = bi.hashCode();
            if (hashCode != -1619189395) {
                if (hashCode != -745448715) {
                    if (hashCode != 3197941) {
                        if (hashCode == 114020461 && bi.equals("xhdpi")) {
                            return "2";
                        }
                    } else if (bi.equals("hdpi")) {
                        return "1.5";
                    }
                } else if (bi.equals("xxhdpi")) {
                    return "3";
                }
            } else if (bi.equals("xxxhdpi")) {
                return "4";
            }
        }
        return "1";
    }

    public static /* synthetic */ o a(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = (String) null;
        }
        if ((i & 2) != 0) {
            str2 = aVar.WA();
        }
        return aVar.ad(str, str2);
    }

    public final o<List<b>> ad(String str, String str2) {
        h.e(str2, "resolution");
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-resources", type).gb("1.0").j("resolution", str2).j("platform_id", Integer.valueOf(f.Dp().DM())).j("locale", Locale.getDefault()).j("id", str).Sb();
    }
}
