package com.iqoption.dialogs;

import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.core.ui.widget.MaxSizeConstraintLayout;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "invoke"})
/* compiled from: RateUsDialog.kt */
final class RateUsDialog$animatorFactory$2 extends Lambda implements a<com.iqoption.core.ui.d.a> {
    final /* synthetic */ d this$0;

    RateUsDialog$animatorFactory$2(d dVar) {
        this.this$0 = dVar;
        super(0);
    }

    /* renamed from: afE */
    public final com.iqoption.core.ui.d.a invoke() {
        FrameLayout frameLayout = d.d(this.this$0).awS;
        h.d(frameLayout, "binding.outside");
        View view = frameLayout;
        MaxSizeConstraintLayout maxSizeConstraintLayout = d.d(this.this$0).btF;
        h.d(maxSizeConstraintLayout, "binding.frame");
        return new com.iqoption.core.ui.d.a(view, maxSizeConstraintLayout);
    }
}
