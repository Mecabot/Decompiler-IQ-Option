package com.iqoption.feed;

import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.feed.response.FeedItem;
import com.iqoption.core.microservices.feed.response.a;
import com.iqoption.core.microservices.feed.response.c;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/data/model/InstrumentType;", "it", "Lcom/iqoption/core/microservices/feed/response/FeedItem;", "invoke"})
/* compiled from: FeedRepository.kt */
final class FeedRepository$collectInstrumentTypes$1 extends Lambda implements b<FeedItem, InstrumentType> {
    public static final FeedRepository$collectInstrumentTypes$1 clg = new FeedRepository$collectInstrumentTypes$1();

    FeedRepository$collectInstrumentTypes$1() {
        super(1);
    }

    /* renamed from: b */
    public final InstrumentType invoke(FeedItem feedItem) {
        h.e(feedItem, "it");
        if (!(feedItem instanceof a)) {
            feedItem = null;
        }
        a aVar = (a) feedItem;
        if (aVar == null) {
            return null;
        }
        c VT = aVar.VT();
        return VT != null ? VT.getInstrumentType() : null;
    }
}
