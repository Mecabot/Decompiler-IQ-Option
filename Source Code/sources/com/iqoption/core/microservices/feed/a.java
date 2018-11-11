package com.iqoption.core.microservices.feed;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import com.iqoption.core.microservices.feed.response.e;
import io.reactivex.o;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0004J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/core/microservices/feed/FeedRequests;", "", "()V", "ALL_SENDER_NAME", "", "CLICK", "", "CMD_GET_NEWS_FEED", "CMD_SEND_NEWS_FEEDBACK", "DEFAULT_COUNT", "DISLIKE", "EVENT_FEED_ITEM_INFO_UPDATE", "HIDE_FROM_FEED", "LIKE", "getFeeds", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/feed/response/FeedListResponse;", "from", "count", "msSenderName", "sendFeedBack", "Lio/reactivex/Completable;", "id", "type", "action", "core_release"})
/* compiled from: FeedRequests.kt */
public final class a {
    public static final a aVN = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/feed/FeedRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<e> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/feed/FeedRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<Object> {
    }

    private a() {
    }

    public static /* synthetic */ o a(a aVar, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 100;
        }
        if ((i3 & 4) != 0) {
            str = "smart-feed";
        }
        return aVar.e(i, i2, str);
    }

    public final o<e> e(int i, int i2, String str) {
        h.e(str, "msSenderName");
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-news-feed", type).j("from", Integer.valueOf(i)).j("n", Integer.valueOf(i2)).j("ms_sender_name", str).gb("2.0").Sb();
    }

    public final io.reactivex.a a(int i, String str, int i2) {
        h.e(str, Param.TYPE);
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        io.reactivex.a aWj = f.DS().a("send-news-feedback", type).j("user_id", Long.valueOf(f.RQ().Dr().getUserId())).j(Param.TYPE, str).j("actions", l.cr(f.RQ().Dq().toJsonTree(new b(i, i2)))).j("ms_name", "smart-feed").gb("2.0").Sb().aWj();
        h.d(aWj, "requestBuilderFactory.cr…         .ignoreElement()");
        return aWj;
    }
}
