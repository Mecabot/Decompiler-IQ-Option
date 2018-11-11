package com.iqoption.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.core.ext.a;
import com.iqoption.dialogs.a.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Landroid/animation/AnimatorSet;", "<anonymous parameter 0>", "Landroid/view/View;", "isEnter", "", "invoke"})
/* compiled from: BottomSheetFragment.kt */
final class BottomSheetFragment$onCreateTransitionProvider$1 extends Lambda implements m<View, Boolean, AnimatorSet> {
    final /* synthetic */ c this$0;

    BottomSheetFragment$onCreateTransitionProvider$1(c cVar) {
        this.this$0 = cVar;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return a((View) obj, ((Boolean) obj2).booleanValue());
    }

    public final AnimatorSet a(View view, boolean z) {
        h.e(view, "<anonymous parameter 0>");
        e a = c.a(this.this$0);
        AnimatorSet animatorSet = new AnimatorSet();
        List arrayList = new ArrayList();
        ObjectAnimator ofFloat;
        FrameLayout frameLayout;
        ObjectAnimator ofFloat2;
        if (z) {
            float height;
            View view2 = a.bqo;
            h.d(view2, "veil");
            view2.setAlpha(0.0f);
            ofFloat = ObjectAnimator.ofFloat(a.bqo, View.ALPHA, new float[]{1.0f});
            h.d(ofFloat, "ObjectAnimator.ofFloat(veil, ALPHA, 1f)");
            arrayList.add(ofFloat);
            frameLayout = a.ckT;
            h.d(frameLayout, "contentViewContainer");
            FrameLayout frameLayout2;
            if (c.b(this.this$0).getSkipCollapsed()) {
                frameLayout2 = a.ckT;
                h.d(frameLayout2, "contentViewContainer");
                height = (float) frameLayout2.getHeight();
            } else {
                frameLayout2 = a.ckT;
                h.d(frameLayout2, "contentViewContainer");
                height = ((float) frameLayout2.getHeight()) - ((float) this.this$0.JM());
            }
            frameLayout.setTranslationY(height);
            ofFloat2 = ObjectAnimator.ofFloat(a.ckT, View.TRANSLATION_Y, new float[]{0.0f});
            h.d(ofFloat2, "ObjectAnimator.ofFloat(c…ainer, TRANSLATION_Y, 0f)");
            arrayList.add(ofFloat2);
        } else {
            ofFloat = ObjectAnimator.ofFloat(a.bqo, View.ALPHA, new float[]{0.0f});
            h.d(ofFloat, "ObjectAnimator.ofFloat(veil, ALPHA, 0f)");
            arrayList.add(ofFloat);
            frameLayout = a.ckT;
            Property property = View.TRANSLATION_Y;
            float[] fArr = new float[1];
            FrameLayout frameLayout3 = a.ckT;
            h.d(frameLayout3, "contentViewContainer");
            fArr[0] = (float) frameLayout3.getHeight();
            ofFloat2 = ObjectAnimator.ofFloat(frameLayout, property, fArr);
            h.d(ofFloat2, "ObjectAnimator.ofFloat(c…ntainer.height.toFloat())");
            arrayList.add(ofFloat2);
        }
        animatorSet.playTogether(arrayList);
        a.a((Animator) animatorSet, 400);
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        return animatorSet;
    }
}
