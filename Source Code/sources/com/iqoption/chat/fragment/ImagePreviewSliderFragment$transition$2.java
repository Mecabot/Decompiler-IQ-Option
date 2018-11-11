package com.iqoption.chat.fragment;

import com.iqoption.chat.component.r;
import com.iqoption.chat.component.s;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/chat/component/ImagePreviewTransition;", "invoke"})
/* compiled from: ImagePreviewSliderFragment.kt */
final class ImagePreviewSliderFragment$transition$2 extends Lambda implements a<r> {
    final /* synthetic */ m this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
    /* compiled from: ImagePreviewSliderFragment.kt */
    /* renamed from: com.iqoption.chat.fragment.ImagePreviewSliderFragment$transition$2$1 */
    static final class AnonymousClass1 extends Lambda implements a<Boolean> {
        final /* synthetic */ ImagePreviewSliderFragment$transition$2 this$0;

        AnonymousClass1(ImagePreviewSliderFragment$transition$2 imagePreviewSliderFragment$transition$2) {
            this.this$0 = imagePreviewSliderFragment$transition$2;
            super(0);
        }

        public final boolean invoke() {
            return this.this$0.this$0.aGJ;
        }
    }

    ImagePreviewSliderFragment$transition$2(m mVar) {
        this.this$0 = mVar;
        super(0);
    }

    /* renamed from: PU */
    public final r invoke() {
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = null;
        ObjectRef objectRef2 = new ObjectRef();
        objectRef2.element = null;
        r rVar = new r(new s(this.this$0.aGG, this.this$0.aGH, this.this$0.aGI, new AnonymousClass1(this), m.l(this.this$0)));
        rVar.c((a) new ImagePreviewSliderFragment$transition$2$$special$$inlined$apply$lambda$1(this, objectRef, objectRef2));
        rVar.d(new ImagePreviewSliderFragment$transition$2$$special$$inlined$apply$lambda$2(this, objectRef, objectRef2));
        rVar.e(new ImagePreviewSliderFragment$transition$2$$special$$inlined$apply$lambda$3(this, objectRef, objectRef2));
        return rVar;
    }
}
