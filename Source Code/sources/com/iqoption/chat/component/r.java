package com.iqoption.chat.component;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.databinding.ViewDataBinding;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.graphics.a.e;
import com.iqoption.core.graphics.animation.d;
import com.iqoption.core.graphics.animation.j;
import com.iqoption.d.dc;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\b"}, aXE = {"Lcom/iqoption/chat/component/ImagePreviewTransition;", "Lcom/iqoption/core/graphics/animation/transition/TemplateTransition;", "Lcom/iqoption/chat/component/ImagePreviewTransitionInfo;", "info", "(Lcom/iqoption/chat/component/ImagePreviewTransitionInfo;)V", "Diff", "FloatDiff", "Transformation", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ImagePreviewTransition.kt */
public final class r extends com.iqoption.core.graphics.animation.a.c<s> {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR&\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000@BX\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000@BX\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, aXE = {"Lcom/iqoption/chat/component/ImagePreviewTransition$Diff;", "T", "", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)V", "<set-?>", "getFrom", "()Ljava/lang/Object;", "setFrom", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getTo", "setTo", "reverse", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewTransition.kt */
    private static final class a<T> {
        private T aDl;
        private T aDm;

        public a(T t, T t2) {
            this.aDl = t;
            this.aDm = t2;
        }

        public final T OC() {
            return this.aDl;
        }

        public final T OD() {
            return this.aDm;
        }

        public final void reverse() {
            Object obj = this.aDl;
            this.aDl = this.aDm;
            this.aDm = obj;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u000f"}, aXE = {"Lcom/iqoption/chat/component/ImagePreviewTransition$FloatDiff;", "", "from", "", "to", "(FF)V", "<set-?>", "getFrom", "()F", "setFrom", "(F)V", "getTo", "setTo", "reverse", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewTransition.kt */
    private static final class b {
        private float aDn;
        private float aDo;

        public b(float f, float f2) {
            this.aDn = f;
            this.aDo = f2;
        }

        public final float OE() {
            return this.aDn;
        }

        public final float OF() {
            return this.aDo;
        }

        public final void reverse() {
            float f = this.aDn;
            this.aDn = this.aDo;
            this.aDo = f;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0000R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/component/ImagePreviewTransition$Transformation;", "", "matrixDiff", "Lcom/iqoption/chat/component/ImagePreviewTransition$Diff;", "Landroid/graphics/Matrix;", "viewSxDiff", "Lcom/iqoption/chat/component/ImagePreviewTransition$FloatDiff;", "viewSyDiff", "viewDxDiff", "viewDyDiff", "(Lcom/iqoption/chat/component/ImagePreviewTransition$Diff;Lcom/iqoption/chat/component/ImagePreviewTransition$FloatDiff;Lcom/iqoption/chat/component/ImagePreviewTransition$FloatDiff;Lcom/iqoption/chat/component/ImagePreviewTransition$FloatDiff;Lcom/iqoption/chat/component/ImagePreviewTransition$FloatDiff;)V", "getMatrixDiff", "()Lcom/iqoption/chat/component/ImagePreviewTransition$Diff;", "getViewDxDiff", "()Lcom/iqoption/chat/component/ImagePreviewTransition$FloatDiff;", "getViewDyDiff", "getViewSxDiff", "getViewSyDiff", "reverse", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewTransition.kt */
    private static final class c {
        private final a<Matrix> aDp;
        private final b aDq;
        private final b aDr;
        private final b aDs;
        private final b aDt;

        public c(a<Matrix> aVar, b bVar, b bVar2, b bVar3, b bVar4) {
            h.e(bVar, "viewSxDiff");
            h.e(bVar2, "viewSyDiff");
            h.e(bVar3, "viewDxDiff");
            h.e(bVar4, "viewDyDiff");
            this.aDp = aVar;
            this.aDq = bVar;
            this.aDr = bVar2;
            this.aDs = bVar3;
            this.aDt = bVar4;
        }

        public final a<Matrix> OH() {
            return this.aDp;
        }

        public final b OI() {
            return this.aDq;
        }

        public final b OJ() {
            return this.aDr;
        }

        public final b OK() {
            return this.aDs;
        }

        public final b OL() {
            return this.aDt;
        }

        public final c OG() {
            a aVar = this.aDp;
            if (aVar != null) {
                aVar.reverse();
            }
            this.aDq.reverse();
            this.aDr.reverse();
            this.aDs.reverse();
            this.aDt.reverse();
            return this;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\fH\u0002JH\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J(\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"com/iqoption/chat/component/ImagePreviewTransition$1", "Lcom/iqoption/core/graphics/animation/transition/AnimatorFactory;", "Lcom/iqoption/chat/component/ImagePreviewTransitionInfo;", "dx", "", "endImageRect", "Landroid/graphics/Rect;", "endSelectorRect", "animateImageTransformation", "", "Landroid/animation/Animator;", "view", "Landroid/widget/ImageView;", "t", "Lcom/iqoption/chat/component/ImagePreviewTransition$Transformation;", "animateSelectorTransformation", "animateSharedElementsEnter", "srcImageView", "dstImageView", "srcSelectorView", "dstSelectorView", "animateSharedElementsExit", "createEnterAnimators", "info", "createExitAnimators", "createImageTransformation", "srcView", "dstView", "createSelectorTransformation", "getCenterCropMatrix", "Landroid/graphics/Matrix;", "srcWidth", "srcHeight", "dstViewWidth", "dstViewHeight", "dstWidth", "dstHeight", "dstViewScaleX", "dstViewScaleY", "getCenterInsideMatrix", "vWidth", "vHeight", "iWidth", "iHeight", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ImagePreviewTransition.kt */
    /* renamed from: com.iqoption.chat.component.r$1 */
    public static final class AnonymousClass1 implements com.iqoption.core.graphics.animation.a.a<s> {
        private final float aDh;
        private Rect aDi = new Rect();
        private Rect aDj = new Rect();
        final /* synthetic */ s aDk;

        AnonymousClass1(s sVar) {
            this.aDk = sVar;
            this.aDh = com.iqoption.core.ext.a.b((ViewDataBinding) sVar.OQ(), (int) R.dimen.dp24);
        }

        private final c a(ImageView imageView, ImageView imageView2) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) {
                return null;
            }
            Drawable drawable2 = imageView2.getDrawable();
            if (drawable2 == null) {
                return null;
            }
            float width = (float) imageView2.getWidth();
            float height = (float) imageView2.getHeight();
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            float intrinsicWidth2 = (float) drawable2.getIntrinsicWidth();
            float intrinsicHeight2 = (float) drawable2.getIntrinsicHeight();
            Rect J = com.iqoption.core.ext.a.J(imageView);
            float width2 = ((float) J.width()) / ((float) this.aDi.width());
            float height2 = ((float) J.height()) / ((float) this.aDi.height());
            return new c(new a(a(intrinsicWidth, intrinsicHeight, width, height, intrinsicWidth2, intrinsicHeight2, width2, height2), b(width, height, intrinsicWidth2, intrinsicHeight2)), new b(width2, 1.0f), new b(height2, 1.0f), new b((float) (J.centerX() - this.aDi.centerX()), 0.0f), new b((float) (J.centerY() - this.aDi.centerY()), 0.0f));
        }

        private final Matrix a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            f2 = f5 > f6 ? f2 / f6 : f / f5;
            Matrix matrix = new Matrix();
            f7 = f2 / f7;
            f2 /= f8;
            matrix.postScale(f7, f2);
            matrix.postTranslate((float) c.ae((f3 - (f5 * f7)) * 0.5f), (float) c.ae((f4 - (f6 * f2)) * 0.5f));
            return matrix;
        }

        private final Matrix b(float f, float f2, float f3, float f4) {
            float min = (f3 > f || f4 > f2) ? Math.min(f / f3, f2 / f4) : 1.0f;
            f = (f - (f3 * min)) * 0.5f;
            f2 = (f2 - (f4 * min)) * 0.5f;
            Matrix matrix = new Matrix();
            matrix.setScale(min, min);
            matrix.postTranslate(f, f2);
            return matrix;
        }

        private final c b(ImageView imageView) {
            Rect J = com.iqoption.core.ext.a.J(imageView);
            return new c(null, new b(((float) J.width()) / ((float) this.aDj.width()), 1.0f), new b(((float) J.height()) / ((float) this.aDj.height()), 1.0f), new b((float) (J.centerX() - this.aDj.centerX()), 0.0f), new b((float) (J.centerY() - this.aDj.centerY()), 0.0f));
        }

        private final List<Animator> a(ImageView imageView, c cVar) {
            List<Animator> arrayList = new ArrayList();
            d.aQO.c(imageView);
            if (cVar.OH() != null) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(imageView, com.iqoption.core.graphics.animation.h.aQT.TH(), new j(), new Matrix[]{(Matrix) r1.OC(), (Matrix) r1.OD()});
                d dVar = d.aQO;
                h.d(ofObject, "it");
                dVar.a(imageView, (Animator) ofObject);
                h.d(ofObject, "ObjectAnimator.ofObject(…it)\n                    }");
                arrayList.add(ofObject);
            }
            r1 = new PropertyValuesHolder[4];
            r1[0] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{cVar.OI().OE(), cVar.OI().OF()});
            r1[1] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{cVar.OJ().OE(), cVar.OJ().OF()});
            r1[2] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{cVar.OK().OE(), cVar.OK().OF()});
            r1[3] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{cVar.OL().OE(), cVar.OL().OF()});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, r1);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…f.from, t.viewDyDiff.to))");
            arrayList.add(ofPropertyValuesHolder);
            return arrayList;
        }

        private final List<Animator> b(ImageView imageView, c cVar) {
            List<Animator> arrayList = new ArrayList();
            r1 = new PropertyValuesHolder[4];
            r1[0] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{cVar.OI().OE(), cVar.OI().OF()});
            r1[1] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{cVar.OJ().OE(), cVar.OJ().OF()});
            r1[2] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{cVar.OK().OE(), cVar.OK().OF()});
            r1[3] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{cVar.OL().OE(), cVar.OL().OF()});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, r1);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…f.from, t.viewDyDiff.to))");
            arrayList.add(ofPropertyValuesHolder);
            return arrayList;
        }

        private final List<Animator> a(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
            ObjectAnimator ofFloat;
            List<Animator> arrayList = new ArrayList();
            if (imageView != null) {
                if (this.aDi.isEmpty()) {
                    this.aDi.set(com.iqoption.core.ext.a.J(imageView2));
                }
                c a = a(imageView, imageView2);
                if (a != null) {
                    arrayList.addAll(a(imageView2, a));
                } else {
                    ofFloat = ObjectAnimator.ofFloat(imageView2, View.ALPHA, new float[]{0.0f, 1.0f});
                    h.d(ofFloat, "ObjectAnimator.ofFloat(d…View, View.ALPHA, 0f, 1f)");
                    arrayList.add(ofFloat);
                }
            } else {
                ofFloat = ObjectAnimator.ofFloat(imageView2, View.ALPHA, new float[]{0.0f, 1.0f});
                h.d(ofFloat, "ObjectAnimator.ofFloat(d…View, View.ALPHA, 0f, 1f)");
                arrayList.add(ofFloat);
            }
            if (imageView3 != null) {
                if (this.aDj.isEmpty()) {
                    this.aDj.set(com.iqoption.core.ext.a.J(imageView4));
                }
                arrayList.addAll(b(imageView4, b(imageView3)));
            } else {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
                propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
                propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.aDh, 0.0f});
                ofFloat = ObjectAnimator.ofPropertyValuesHolder(imageView4, propertyValuesHolderArr);
                h.d(ofFloat, "ObjectAnimator.ofPropert…w.TRANSLATION_X, dx, 0f))");
                arrayList.add(ofFloat);
            }
            return arrayList;
        }

        /* renamed from: a */
        public List<Animator> bc(s sVar) {
            ImageView imageView;
            PropertyValuesHolder[] propertyValuesHolderArr;
            ObjectAnimator ofPropertyValuesHolder;
            h.e(sVar, "info");
            List<Animator> arrayList = new ArrayList();
            dc OQ = sVar.OQ();
            View root = OQ.getRoot();
            h.d(root, "root");
            Drawable background = root.getBackground();
            if (!(background instanceof e)) {
                background = null;
            }
            e eVar = (e) background;
            if (eVar != null) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(eVar, com.iqoption.core.graphics.animation.b.aQM.TD(), new int[]{0, 255});
                h.d(ofInt, "ObjectAnimator.ofInt(it, Drawables.ALPHA, 0, 255)");
                arrayList.add(ofInt);
            }
            if (((Boolean) sVar.OP().invoke()).booleanValue()) {
                imageView = OQ.blZ;
                propertyValuesHolderArr = new PropertyValuesHolder[2];
                propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
                propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.aDh, 0.0f});
                ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolderArr);
                h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…w.TRANSLATION_X, dx, 0f))");
                arrayList.add(ofPropertyValuesHolder);
                ofPropertyValuesHolder = ObjectAnimator.ofFloat(OQ.bmI, View.ALPHA, new float[]{0.0f, 1.0f});
                h.d(ofPropertyValuesHolder, "ObjectAnimator.ofFloat(pager, View.ALPHA, 0f, 1f)");
                arrayList.add(ofPropertyValuesHolder);
            } else {
                ImageView imageView2 = (ImageView) sVar.OM().invoke();
                ImageView imageView3 = (ImageView) sVar.ON().invoke();
                imageView = (ImageView) sVar.OO().invoke();
                ImageView imageView4 = OQ.blZ;
                h.d(imageView4, "selector");
                arrayList.addAll(a(imageView2, imageView3, imageView, imageView4));
            }
            TextView textView = OQ.agA;
            propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f, 1.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{-this.aDh, 0.0f, 0.0f});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, propertyValuesHolderArr);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…NSLATION_X, -dx, 0f, 0f))");
            arrayList.add(ofPropertyValuesHolder);
            imageView = OQ.bmG;
            propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f, 1.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.aDh, 0.0f, 0.0f});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolderArr);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…ANSLATION_X, dx, 0f, 0f))");
            arrayList.add(ofPropertyValuesHolder);
            textView = OQ.bmH;
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[2];
            propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f, 1.0f});
            propertyValuesHolderArr2[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.aDh, 0.0f, 0.0f});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, propertyValuesHolderArr2);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…ANSLATION_X, dx, 0f, 0f))");
            arrayList.add(ofPropertyValuesHolder);
            return arrayList;
        }

        private final List<Animator> b(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
            ObjectAnimator ofFloat;
            List<Animator> arrayList = new ArrayList();
            if (imageView != null) {
                if (this.aDi.isEmpty()) {
                    this.aDi.set(com.iqoption.core.ext.a.J(imageView2));
                }
                c a = a(imageView, imageView2);
                if (a != null) {
                    arrayList.addAll(a(imageView2, a.OG()));
                } else {
                    ofFloat = ObjectAnimator.ofFloat(imageView2, View.ALPHA, new float[]{1.0f, 0.0f});
                    h.d(ofFloat, "ObjectAnimator.ofFloat(d…View, View.ALPHA, 1f, 0f)");
                    arrayList.add(ofFloat);
                }
            } else {
                ofFloat = ObjectAnimator.ofFloat(imageView2, View.ALPHA, new float[]{1.0f, 0.0f});
                h.d(ofFloat, "ObjectAnimator.ofFloat(d…View, View.ALPHA, 1f, 0f)");
                arrayList.add(ofFloat);
            }
            if (imageView3 != null) {
                if (this.aDj.isEmpty()) {
                    this.aDj.set(com.iqoption.core.ext.a.J(imageView4));
                }
                arrayList.addAll(b(imageView4, b(imageView3).OG()));
            } else {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
                propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
                propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f, this.aDh});
                ofFloat = ObjectAnimator.ofPropertyValuesHolder(imageView4, propertyValuesHolderArr);
                h.d(ofFloat, "ObjectAnimator.ofPropert…w.TRANSLATION_X, 0f, dx))");
                arrayList.add(ofFloat);
            }
            return arrayList;
        }

        /* renamed from: b */
        public List<Animator> bd(s sVar) {
            ImageView imageView;
            PropertyValuesHolder[] propertyValuesHolderArr;
            ObjectAnimator ofPropertyValuesHolder;
            h.e(sVar, "info");
            List<Animator> arrayList = new ArrayList();
            dc OQ = sVar.OQ();
            View root = OQ.getRoot();
            h.d(root, "root");
            Drawable background = root.getBackground();
            if (!(background instanceof e)) {
                background = null;
            }
            e eVar = (e) background;
            if (eVar != null) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(eVar, com.iqoption.core.graphics.animation.b.aQM.TD(), new int[]{255, 0});
                h.d(ofInt, "ObjectAnimator.ofInt(it, Drawables.ALPHA, 255, 0)");
                arrayList.add(ofInt);
            }
            if (((Boolean) sVar.OP().invoke()).booleanValue()) {
                imageView = OQ.blZ;
                propertyValuesHolderArr = new PropertyValuesHolder[2];
                propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
                propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f, this.aDh});
                ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolderArr);
                h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…w.TRANSLATION_X, 0f, dx))");
                arrayList.add(ofPropertyValuesHolder);
                ofPropertyValuesHolder = ObjectAnimator.ofFloat(OQ.bmI, View.ALPHA, new float[]{1.0f, 0.0f});
                h.d(ofPropertyValuesHolder, "ObjectAnimator.ofFloat(pager, View.ALPHA, 1f, 0f)");
                arrayList.add(ofPropertyValuesHolder);
            } else {
                ImageView imageView2 = (ImageView) sVar.OM().invoke();
                ImageView imageView3 = (ImageView) sVar.ON().invoke();
                imageView = (ImageView) sVar.OO().invoke();
                ImageView imageView4 = OQ.blZ;
                h.d(imageView4, "selector");
                arrayList.addAll(b(imageView2, imageView3, imageView, imageView4));
            }
            TextView textView = OQ.agA;
            propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f, 0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f, -this.aDh, -this.aDh});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, propertyValuesHolderArr);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…SLATION_X, 0f, -dx, -dx))");
            arrayList.add(ofPropertyValuesHolder);
            imageView = OQ.bmG;
            propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f, 0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f, this.aDh, this.aDh});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolderArr);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…ANSLATION_X, 0f, dx, dx))");
            arrayList.add(ofPropertyValuesHolder);
            textView = OQ.bmH;
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[2];
            propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f, 0.0f});
            propertyValuesHolderArr2[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f, this.aDh, this.aDh});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, propertyValuesHolderArr2);
            h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…ANSLATION_X, 0f, dx, dx))");
            arrayList.add(ofPropertyValuesHolder);
            return arrayList;
        }
    }

    public r(s sVar) {
        h.e(sVar, "info");
        super(sVar);
        a((com.iqoption.core.graphics.animation.a.a) new AnonymousClass1(sVar));
    }
}
