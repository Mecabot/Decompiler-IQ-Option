package com.iqoption.quiz;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "invoke"})
/* compiled from: PrimaryContentDelegate.kt */
final class PrimaryContentDelegate$1 extends Lambda implements b<Boolean, l> {
    final /* synthetic */ View $content;

    PrimaryContentDelegate$1(View view) {
        this.$content = view;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        eo(((Boolean) obj).booleanValue());
        return l.etX;
    }

    public final void eo(final boolean z) {
        this.$content.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ PrimaryContentDelegate$1 dfJ;

            public boolean onPreDraw() {
                this.dfJ.$content.getViewTreeObserver().removeOnPreDrawListener(this);
                if (z) {
                    this.dfJ.$content.setVisibility(8);
                } else {
                    this.dfJ.$content.setVisibility(0);
                }
                return false;
            }
        });
    }
}
