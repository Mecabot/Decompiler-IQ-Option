package com.iqoption.charttools.tools;

import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
/* compiled from: ToolsFragment.kt */
final class ToolsFragment$parentView$2 extends Lambda implements a<FrameLayout> {
    final /* synthetic */ e this$0;

    ToolsFragment$parentView$2(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    /* renamed from: NK */
    public final FrameLayout invoke() {
        FrameLayout frameLayout = new FrameLayout(com.iqoption.core.ext.a.m(this.this$0));
        frameLayout.setId(R.id.card);
        View view = frameLayout;
        com.iqoption.charttools.tools.b.a.aCr.E(view);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.iqoption.core.ext.a.b(view, (int) R.color.bg_dialog));
        gradientDrawable.setCornerRadius(com.iqoption.core.ext.a.e(view, (int) R.dimen.dp8));
        frameLayout.setBackground(gradientDrawable);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.startToEnd = R.id.mainContent;
        layoutParams.bottomToBottom = R.id.mainContent;
        frameLayout.setLayoutParams(layoutParams);
        ViewCompat.setElevation(view, com.iqoption.core.ext.a.a(view, 14.0f));
        return frameLayout;
    }
}
