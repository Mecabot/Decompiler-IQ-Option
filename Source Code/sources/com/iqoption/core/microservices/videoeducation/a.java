package com.iqoption.core.microservices.videoeducation;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import com.iqoption.core.microservices.videoeducation.response.g;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0007J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/microservices/videoeducation/VideoEducationRequests;", "", "()V", "CMD_GET_VIDEOS", "", "CMD_GET_VIDEO_CATEGORIES", "CMD_SET_VIDEO_WATCHED", "getVideoCategories", "Lio/reactivex/Single;", "", "Lcom/iqoption/core/microservices/videoeducation/response/Category;", "getVideos", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "setVideoWatched", "Lio/reactivex/Completable;", "videoId", "", "core_release"})
/* compiled from: VideoEducationRequests.kt */
public final class a {
    public static final a aZA = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/videoeducation/VideoEducationRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<List<? extends com.iqoption.core.microservices.videoeducation.response.a>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/videoeducation/VideoEducationRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<List<? extends g>> {
    }

    private a() {
    }

    public static final o<List<com.iqoption.core.microservices.videoeducation.response.a>> XO() {
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-video-categories", type).cd(false).j("locale", Locale.getDefault().toString()).j("platform", "mobile").Sb();
    }

    public static final o<List<g>> XP() {
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-videos", type).cd(false).j("locale", Locale.getDefault().toString()).j("platform", "mobile").Sb();
    }

    public static final io.reactivex.a bc(long j) {
        io.reactivex.a aWj = f.DS().a("set-video-watched", com.iqoption.core.connect.b.RX()).cd(false).j("video_id", Long.valueOf(j)).Sb().aWj();
        h.d(aWj, "requestBuilderFactory\n  …         .ignoreElement()");
        return aWj;
    }
}
