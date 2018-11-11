package com.iqoption.feed;

import android.os.Parcelable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "invoke"})
/* compiled from: FeedWebViewActivity.kt */
final class FeedWebViewActivity$item$2 extends Lambda implements a<com.iqoption.core.microservices.feed.response.a> {
    final /* synthetic */ FeedWebViewActivity this$0;

    FeedWebViewActivity$item$2(FeedWebViewActivity feedWebViewActivity) {
        this.this$0 = feedWebViewActivity;
        super(0);
    }

    /* renamed from: afS */
    public final com.iqoption.core.microservices.feed.response.a invoke() {
        Parcelable parcelableExtra = this.this$0.getIntent().getParcelableExtra("EXTRA_WEB_BUTTON_ITEM");
        if (parcelableExtra != null) {
            return (com.iqoption.core.microservices.feed.response.a) parcelableExtra;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.microservices.feed.response.CommonFeedItem");
    }
}
