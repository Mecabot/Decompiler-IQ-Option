package com.iqoption.chat.fragment;

import com.squareup.picasso.Picasso;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lcom/squareup/picasso/Picasso;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: ImagePreviewFragment.kt */
final class ImagePreviewFragment$picasso$2 extends Lambda implements a<Picasso> {
    final /* synthetic */ l this$0;

    ImagePreviewFragment$picasso$2(l lVar) {
        this.this$0 = lVar;
        super(0);
    }

    /* renamed from: PL */
    public final Picasso invoke() {
        return Picasso.with(com.iqoption.core.ext.a.m(this.this$0));
    }
}
