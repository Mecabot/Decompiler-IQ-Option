package com.iqoption.chat.fragment;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
/* compiled from: ImagePreviewSliderFragment.kt */
final class ImagePreviewSliderFragment$getSourcePreview$1 extends Lambda implements a<ImageView> {
    final /* synthetic */ m this$0;

    ImagePreviewSliderFragment$getSourcePreview$1(m mVar) {
        this.this$0 = mVar;
        super(0);
    }

    /* renamed from: PR */
    public final ImageView invoke() {
        b n = this.this$0.aGE;
        if (n == null) {
            return null;
        }
        List d = this.this$0.aGC;
        ViewPager viewPager = m.l(this.this$0).bmI;
        h.d(viewPager, "binding.pager");
        return (ImageView) n.invoke(d.get(viewPager.getCurrentItem()));
    }
}
