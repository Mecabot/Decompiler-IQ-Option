package com.iqoption.feed.feedlist;

import android.content.Context;
import android.widget.ImageView;
import com.iqoption.core.ext.c;
import com.iqoption.core.microservices.feed.response.FeedPriority;
import com.iqoption.core.microservices.feed.response.a;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u0013"}, aXE = {"Lcom/iqoption/feed/feedlist/FeedHolderUtils;", "", "()V", "getPreviewMaxTextLines", "", "context", "Landroid/content/Context;", "item", "Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "isMacro", "", "getSourceTextSize", "", "getSourceTitle", "", "loadServiceIcon", "", "imageView", "Landroid/widget/ImageView;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FeedHolderUtils.kt */
public final class h {
    public static final h cmH = new h();

    private h() {
    }

    public static final void a(ImageView imageView, a aVar) {
        kotlin.jvm.internal.h.e(imageView, "imageView");
        kotlin.jvm.internal.h.e(aVar, "item");
        Picasso with = Picasso.with(imageView.getContext());
        if (aVar.VR() == FeedPriority.BREAKING_NEWS) {
            with.load((int) R.drawable.ic_fire).into(imageView);
        } else if (aVar.VR() == FeedPriority.PROMOTED) {
            with.load((int) R.drawable.ic_promo).into(imageView);
        } else {
            with.load((String) u.bX(aVar.VO())).into(imageView);
        }
    }

    public static final String a(Context context, a aVar) {
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(aVar, "item");
        String string;
        if (aVar.VR() == FeedPriority.BREAKING_NEWS) {
            string = context.getString(R.string.urgent_news);
            kotlin.jvm.internal.h.d(string, "context.getString(R.string.urgent_news)");
            return string;
        } else if (aVar.VR() != FeedPriority.PROMOTED) {
            return aVar.getSource();
        } else {
            string = context.getString(R.string.promoted_news);
            kotlin.jvm.internal.h.d(string, "context.getString(R.string.promoted_news)");
            return string;
        }
    }

    public static final float a(Context context, a aVar, boolean z) {
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(aVar, "item");
        Object VR = aVar.VR();
        int i = 0;
        if (VR != null) {
            if (c.b(VR, FeedPriority.PROMOTED, FeedPriority.BREAKING_NEWS)) {
                i = 1;
            }
        }
        int i2 = (i == 0 || !z) ? (i == 0 || z) ? R.dimen.sp12 : R.dimen.sp14 : R.dimen.sp18;
        return context.getResources().getDimension(i2);
    }

    public static final int b(Context context, a aVar, boolean z) {
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(aVar, "item");
        if ((aVar.VR() == FeedPriority.BREAKING_NEWS ? 1 : null) != null) {
            return 5;
        }
        return z ? 2 : 3;
    }
}
