package com.iqoption.chat.component;

import android.widget.ImageView;
import com.iqoption.core.graphics.animation.a.b;
import com.iqoption.core.graphics.animation.a.d;
import com.iqoption.d.dc;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BI\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/component/ImagePreviewTransitionInfo;", "Lcom/iqoption/core/graphics/animation/transition/TransitionInfo;", "getImageSource", "Lkotlin/Function0;", "Landroid/widget/ImageView;", "getImageDest", "getSelectorSource", "skipSharedElements", "", "binding", "Lcom/iqoption/databinding/ChatFragmentImagePreviewSliderBinding;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/iqoption/databinding/ChatFragmentImagePreviewSliderBinding;)V", "getBinding", "()Lcom/iqoption/databinding/ChatFragmentImagePreviewSliderBinding;", "getGetImageDest", "()Lkotlin/jvm/functions/Function0;", "getGetImageSource", "getGetSelectorSource", "getSkipSharedElements", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ImagePreviewTransition.kt */
public final class s extends d {
    private final a<ImageView> aDu;
    private final a<ImageView> aDv;
    private final a<ImageView> aDw;
    private final a<Boolean> aDx;
    private final dc aDy;

    public final a<ImageView> OM() {
        return this.aDu;
    }

    public final a<ImageView> ON() {
        return this.aDv;
    }

    public final a<ImageView> OO() {
        return this.aDw;
    }

    public final a<Boolean> OP() {
        return this.aDx;
    }

    public s(a<? extends ImageView> aVar, a<? extends ImageView> aVar2, a<? extends ImageView> aVar3, a<Boolean> aVar4, dc dcVar) {
        h.e(aVar, "getImageSource");
        h.e(aVar2, "getImageDest");
        h.e(aVar3, "getSelectorSource");
        h.e(aVar4, "skipSharedElements");
        h.e(dcVar, "binding");
        super(new b(500));
        this.aDu = aVar;
        this.aDv = aVar2;
        this.aDw = aVar3;
        this.aDx = aVar4;
        this.aDy = dcVar;
    }

    public final dc OQ() {
        return this.aDy;
    }
}
