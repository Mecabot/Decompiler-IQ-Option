package com.iqoption.chat.fragment;

import com.iqoption.chat.viewmodel.a;
import com.squareup.picasso.RequestCreator;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<no name provided>", "Lcom/squareup/picasso/RequestCreator;", "preview", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "invoke"})
/* compiled from: ImagePreviewSliderFragment.kt */
final class ImagePreviewSliderFragment$getDisplayer$3 extends Lambda implements b<a, RequestCreator> {
    final /* synthetic */ ImagePreviewSliderFragment$getDisplayer$1 $getSize$1;
    final /* synthetic */ ImagePreviewSliderFragment$getDisplayer$2 $getTransformation$2;
    final /* synthetic */ float $scale;
    final /* synthetic */ m this$0;

    ImagePreviewSliderFragment$getDisplayer$3(m mVar, ImagePreviewSliderFragment$getDisplayer$1 imagePreviewSliderFragment$getDisplayer$1, float f, ImagePreviewSliderFragment$getDisplayer$2 imagePreviewSliderFragment$getDisplayer$2) {
        this.this$0 = mVar;
        this.$getSize$1 = imagePreviewSliderFragment$getDisplayer$1;
        this.$scale = f;
        this.$getTransformation$2 = imagePreviewSliderFragment$getDisplayer$2;
        super(1);
    }

    /* renamed from: f */
    public final RequestCreator invoke(a aVar) {
        h.e(aVar, "preview");
        c PS = this.$getSize$1.invoke();
        RequestCreator centerInside = this.this$0.getPicasso().load(aVar.getFile()).resize(PS.PP(), PS.PQ()).centerInside();
        if (this.$scale != 1.0f) {
            centerInside.transform(this.$getTransformation$2.invoke());
        }
        h.d(centerInside, "creator");
        return centerInside;
    }
}
