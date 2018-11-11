package com.iqoption.charttools.tools.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.graphics.animation.k;
import com.iqoption.x.R;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0015\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\u001e\u001a\u00020\u0004*\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0002¨\u0006%"}, aXE = {"Lcom/iqoption/charttools/tools/transition/CardPanelTransition;", "Landroid/support/transition/Transition;", "()V", "captureEndValues", "", "transitionValues", "Landroid/support/transition/TransitionValues;", "captureStartValues", "captureValues", "createAnimator", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "endValues", "createAppearAnimator", "target", "Landroid/view/View;", "createChangeAnimator", "fromBounds", "Landroid/graphics/Rect;", "toBounds", "createDisappearAnimator", "bounds", "getTransitionProperties", "", "", "()[Ljava/lang/String;", "isTransitionRequired", "", "setBounds", "l", "", "t", "r", "b", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CardPanelTransition.kt */
public final class a extends Transition {
    private static final String[] aCp = new String[]{"cardpaneltransition:card:bounds"};
    private static final b aCq = new b(Rect.class, "viewBounds");
    public static final a aCr = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u000b\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/charttools/tools/transition/CardPanelTransition$Companion;", "", "()V", "END_DOWNSCALE", "", "MARK_CARD", "", "MARK_ID_BOUNDS", "", "MARK_ID_CARD", "PROPERTY_VIEW_BOUNDS", "com/iqoption/charttools/tools/transition/CardPanelTransition$Companion$PROPERTY_VIEW_BOUNDS$1", "Lcom/iqoption/charttools/tools/transition/CardPanelTransition$Companion$PROPERTY_VIEW_BOUNDS$1;", "PROPNAMES", "", "[Ljava/lang/String;", "PROPNAME_CARD_BOUNDS", "START_UPSCALE", "markCard", "", "view", "Landroid/view/View;", "isMarkedCard", "", "ViewBounds", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CardPanelTransition.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/tools/transition/CardPanelTransition$Companion$ViewBounds;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "get", "", "bounds", "Landroid/graphics/Rect;", "set", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: CardPanelTransition.kt */
        private static final class a {
            private final View view;

            public a(View view) {
                h.e(view, Promotion.ACTION_VIEW);
                this.view = view;
            }

            public final void set(Rect rect) {
                h.e(rect, "bounds");
                this.view.setLeft(rect.left);
                this.view.setTop(rect.top);
                this.view.setRight(rect.right);
                this.view.setBottom(rect.bottom);
            }

            public final void a(Rect rect) {
                h.e(rect, "bounds");
                rect.set(this.view.getLeft(), this.view.getTop(), this.view.getRight(), this.view.getBottom());
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void E(View view) {
            h.e(view, Promotion.ACTION_VIEW);
            view.setTag(R.id.mark_card, "cardpaneltransition:mark:card");
        }

        private final boolean F(View view) {
            return h.E(view.getTag(R.id.mark_card), "cardpaneltransition:mark:card");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u001d\u0010\u0007\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"com/iqoption/charttools/tools/transition/CardPanelTransition$Companion$PROPERTY_VIEW_BOUNDS$1", "Landroid/util/Property;", "Lcom/iqoption/charttools/tools/transition/CardPanelTransition$Companion$ViewBounds;", "Landroid/graphics/Rect;", "rect", "get", "object", "set", "", "value", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CardPanelTransition.kt */
    public static final class b extends Property<a, Rect> {
        private final Rect rect = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(a aVar) {
            if (aVar != null) {
                aVar.a(this.rect);
            }
            return this.rect;
        }

        /* renamed from: a */
        public void set(a aVar, Rect rect) {
            if (rect != null && aVar != null) {
                aVar.set(rect);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/tools/transition/CardPanelTransition$createAppearAnimator$2$1", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CardPanelTransition.kt */
    public static final class c extends AnimatorListenerAdapter {
        private boolean JF;
        final /* synthetic */ View aCs;

        c(View view) {
            this.aCs = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.JF = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.JF) {
                View view = this.aCs;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/tools/transition/CardPanelTransition$createDisappearAnimator$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CardPanelTransition.kt */
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ View aCs;
        final /* synthetic */ ViewGroup aCt;

        d(ViewGroup viewGroup, View view) {
            this.aCt = viewGroup;
            this.aCs = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.aCt.getOverlay().remove(this.aCs);
        }
    }

    public String[] getTransitionProperties() {
        return aCp;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        return h.E(transitionValues, transitionValues2) ^ 1;
    }

    public void captureStartValues(TransitionValues transitionValues) {
        h.e(transitionValues, "transitionValues");
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        h.e(transitionValues, "transitionValues");
        captureValues(transitionValues);
    }

    private final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        a aVar = aCr;
        h.d(view, Promotion.ACTION_VIEW);
        if (aVar.F(view)) {
            Map map = transitionValues.values;
            h.d(map, "transitionValues.values");
            map.put("cardpaneltransition:card:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        }
    }

    /* JADX WARNING: Missing block: B:5:0x0012, code:
            if (com.iqoption.charttools.tools.b.a.a.a(aCr, r1) == false) goto L_0x0022;
     */
    /* JADX WARNING: Missing block: B:10:0x0020, code:
            if (com.iqoption.charttools.tools.b.a.a.a(aCr, r1) == false) goto L_0x0022;
     */
    /* JADX WARNING: Missing block: B:11:0x0022, code:
            return null;
     */
    public android.animation.Animator createAnimator(android.view.ViewGroup r4, android.support.transition.TransitionValues r5, android.support.transition.TransitionValues r6) {
        /*
        r3 = this;
        r0 = "sceneRoot";
        kotlin.jvm.internal.h.e(r4, r0);
        r0 = 0;
        if (r5 == 0) goto L_0x0014;
    L_0x0008:
        r1 = r5.view;
        if (r1 == 0) goto L_0x0014;
    L_0x000c:
        r2 = aCr;
        r1 = r2.F(r1);
        if (r1 == 0) goto L_0x0022;
    L_0x0014:
        if (r6 == 0) goto L_0x0023;
    L_0x0016:
        r1 = r6.view;
        if (r1 == 0) goto L_0x0023;
    L_0x001a:
        r2 = aCr;
        r1 = r2.F(r1);
        if (r1 != 0) goto L_0x0023;
    L_0x0022:
        return r0;
    L_0x0023:
        if (r5 == 0) goto L_0x004c;
    L_0x0025:
        if (r6 == 0) goto L_0x004c;
    L_0x0027:
        r4 = r6.view;
        r5 = r5.values;
        r1 = "cardpaneltransition:card:bounds";
        r5 = r5.get(r1);
        r5 = (android.graphics.Rect) r5;
        r6 = r6.values;
        r1 = "cardpaneltransition:card:bounds";
        r6 = r6.get(r1);
        r6 = (android.graphics.Rect) r6;
        if (r5 == 0) goto L_0x0079;
    L_0x003f:
        if (r6 == 0) goto L_0x0079;
    L_0x0041:
        r0 = "view";
        kotlin.jvm.internal.h.d(r4, r0);
        r0 = r3.a(r4, r5, r6);
        goto L_0x0079;
    L_0x004c:
        if (r5 != 0) goto L_0x005d;
    L_0x004e:
        if (r6 == 0) goto L_0x005d;
    L_0x0050:
        r4 = r6.view;
        r5 = "view";
        kotlin.jvm.internal.h.d(r4, r5);
        r0 = r3.D(r4);
        goto L_0x0079;
    L_0x005d:
        if (r5 == 0) goto L_0x0079;
    L_0x005f:
        if (r6 != 0) goto L_0x0079;
    L_0x0061:
        r6 = r5.view;
        r5 = r5.values;
        r1 = "cardpaneltransition:card:bounds";
        r5 = r5.get(r1);
        r5 = (android.graphics.Rect) r5;
        if (r5 == 0) goto L_0x0079;
    L_0x006f:
        r0 = "view";
        kotlin.jvm.internal.h.d(r6, r0);
        r0 = r3.a(r4, r6, r5);
    L_0x0079:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.tools.b.a.createAnimator(android.view.ViewGroup, android.support.transition.TransitionValues, android.support.transition.TransitionValues):android.animation.Animator");
    }

    private final Animator a(View view, Rect rect, Rect rect2) {
        a aVar = new a(view);
        view.setTag(R.id.mark_bounds, aVar);
        aVar.set(rect);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(aVar, aCq, k.aRl.TN(), new Rect[]{rect, rect2});
        h.d(ofObject, "ObjectAnimator.ofObject(…ce, fromBounds, toBounds)");
        return ofObject;
    }

    private final void a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }

    private final Animator D(View view) {
        view.setAlpha(0.0f);
        float e = com.iqoption.core.ext.a.e(view, (int) R.dimen.dp12);
        view.setTranslationX(-e);
        view.setTranslationY(e);
        view.setScaleX(0.3f);
        view.setScaleY(0.3f);
        view.setPivotX(0.0f);
        view.setPivotY((float) view.getHeight());
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[5];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
        propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
        propertyValuesHolderArr[3] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f});
        propertyValuesHolderArr[4] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        ofPropertyValuesHolder.addListener(new c(view));
        h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…\n            })\n        }");
        return ofPropertyValuesHolder;
    }

    private final Animator a(ViewGroup viewGroup, View view, Rect rect) {
        a(view, rect.left, rect.top, rect.right, rect.bottom);
        viewGroup.getOverlay().add(view);
        r9 = new PropertyValuesHolder[3];
        r9[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        r9[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{view.getScaleX() * 0.7f});
        r9[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{view.getScaleY() * 0.7f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, r9);
        ofPropertyValuesHolder.addListener(new d(viewGroup, view));
        h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…\n            })\n        }");
        return ofPropertyValuesHolder;
    }
}
