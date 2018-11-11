package com.iqoption.chat.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
/* compiled from: ImagePreviewSliderFragment.kt */
final class ImagePreviewSliderFragment$getDestPreview$1 extends Lambda implements a<ImageView> {
    final /* synthetic */ m this$0;

    ImagePreviewSliderFragment$getDestPreview$1(m mVar) {
        this.this$0 = mVar;
        super(0);
    }

    /* renamed from: PR */
    public final ImageView invoke() {
        ViewPager viewPager = m.l(this.this$0).bmI;
        View findViewWithTag = viewPager.findViewWithTag(this.this$0.aGC.get(viewPager.getCurrentItem()));
        if (findViewWithTag != null) {
            return (ImageView) findViewWithTag;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
    }
}
