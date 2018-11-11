package com.iqoption.chat.fragment;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"getSize", "Lcom/iqoption/chat/fragment/ImagePreviewSliderFragment$Size;", "invoke"})
/* compiled from: ImagePreviewSliderFragment.kt */
final class ImagePreviewSliderFragment$getDisplayer$1 extends Lambda implements a<c> {
    final /* synthetic */ float $scale;
    final /* synthetic */ ObjectRef $size;
    final /* synthetic */ m this$0;

    ImagePreviewSliderFragment$getDisplayer$1(m mVar, ObjectRef objectRef, float f) {
        this.this$0 = mVar;
        this.$size = objectRef;
        this.$scale = f;
        super(0);
    }

    /* renamed from: PS */
    public final c invoke() {
        c cVar = (c) this.$size.element;
        if (cVar != null) {
            return cVar;
        }
        Resources resources = this.this$0.getResources();
        h.d(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        c cVar2 = new c(c.ae(((float) displayMetrics.widthPixels) * this.$scale), c.ae(((float) displayMetrics.heightPixels) * this.$scale));
        this.$size.element = cVar2;
        return cVar2;
    }
}
