package com.iqoption.quiz;

import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.d.qv;
import com.iqoption.quiz.model.e;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bR+\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, aXE = {"Lcom/iqoption/quiz/QuizInsightsViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/FragmentQuizInsightsItemBinding;", "onClick", "Lkotlin/Function1;", "Lcom/iqoption/quiz/model/QuizInsightItem;", "", "(Lcom/iqoption/databinding/FragmentQuizInsightsItemBinding;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "bound", "getBound", "()Lcom/iqoption/quiz/model/QuizInsightItem;", "setBound", "(Lcom/iqoption/quiz/model/QuizInsightItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizInsightsViewHolder.kt */
public final class v extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(v.class), "bound", "getBound()Lcom/iqoption/quiz/model/QuizInsightItem;"))};
    @ColorInt
    private static Integer dgF;
    @ColorInt
    private static Integer dgG;
    public static final b dgH = new b();
    private final d bXV;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0010"}, aXE = {"Lcom/iqoption/quiz/QuizInsightsViewHolder$Companion;", "", "()V", "colorDown", "", "Ljava/lang/Integer;", "colorUp", "bind", "", "binding", "Lcom/iqoption/databinding/FragmentQuizInsightsItemBinding;", "item", "Lcom/iqoption/quiz/model/QuizInsightItem;", "bindIcon", "image", "Landroid/widget/ImageView;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizInsightsViewHolder.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        /* JADX WARNING: Missing block: B:3:0x0062, code:
            if (r1 == null) goto L_0x0064;
     */
        /* JADX WARNING: Missing block: B:7:0x0070, code:
            if (r1 == null) goto L_0x0064;
     */
        private final void a(com.iqoption.d.qv r7, com.iqoption.quiz.model.e r8) {
            /*
            r6 = this;
            r0 = r7.afV;
            r1 = "activeTitle";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = r8.getActiveName();
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r7.bAW;
            r1 = "price";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = kotlin.jvm.internal.m.euz;
            r1 = java.util.Locale.US;
            r2 = "Locale.US";
            kotlin.jvm.internal.h.d(r1, r2);
            r2 = "%s = %s";
            r3 = 2;
            r3 = new java.lang.Object[r3];
            r4 = r8.Xg();
            r5 = 0;
            r3[r5] = r4;
            r4 = r8.aBo();
            r5 = 1;
            r3[r5] = r4;
            r4 = r3.length;
            r3 = java.util.Arrays.copyOf(r3, r4);
            r1 = java.lang.String.format(r1, r2, r3);
            r2 = "java.lang.String.format(locale, format, *args)";
            kotlin.jvm.internal.h.d(r1, r2);
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r7.bAX;
            r1 = "priceDiff";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = r8.aBp();
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r7.bAX;
            r1 = r8.aBq();
            if (r1 == 0) goto L_0x006c;
        L_0x005e:
            r1 = com.iqoption.quiz.v.dgG;
            if (r1 != 0) goto L_0x0067;
        L_0x0064:
            kotlin.jvm.internal.h.aXZ();
        L_0x0067:
            r1 = r1.intValue();
            goto L_0x0073;
        L_0x006c:
            r1 = com.iqoption.quiz.v.dgF;
            if (r1 != 0) goto L_0x0067;
        L_0x0072:
            goto L_0x0064;
        L_0x0073:
            r0.setTextColor(r1);
            r0 = r7.axy;
            r1 = "description";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = r8.getDescription();
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = com.iqoption.quiz.v.dgH;
            r7 = r7.bmu;
            r1 = "icon";
            kotlin.jvm.internal.h.d(r7, r1);
            r0.a(r7, r8);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.v.b.a(com.iqoption.d.qv, com.iqoption.quiz.model.e):void");
        }

        private final void a(ImageView imageView, e eVar) {
            Picasso azl = m.ayY().azl();
            azl.cancelRequest(imageView);
            String awV = eVar.awV();
            if (awV != null) {
                if ((((CharSequence) awV).length() > 0 ? 1 : 0) == 1) {
                    azl.load(eVar.awV()).fit().into(imageView);
                    return;
                }
            }
            imageView.setImageDrawable(null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ v dgI;
        final /* synthetic */ kotlin.jvm.a.b dgJ;

        public a(v vVar, kotlin.jvm.a.b bVar) {
            this.dgI = vVar;
            this.dgJ = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.dgJ.invoke(this.dgI.aze());
        }
    }

    public final e aze() {
        return (e) this.bXV.b(this, apP[0]);
    }

    public final void c(e eVar) {
        h.e(eVar, "<set-?>");
        this.bXV.a(this, apP[0], eVar);
    }

    public v(qv qvVar, kotlin.jvm.a.b<? super e, l> bVar) {
        h.e(qvVar, "binding");
        h.e(bVar, "onClick");
        super(qvVar.getRoot());
        if (dgF == null) {
            View root = qvVar.getRoot();
            h.d(root, "binding.root");
            dgF = Integer.valueOf(ContextCompat.getColor(root.getContext(), R.color.green));
            root = qvVar.getRoot();
            h.d(root, "binding.root");
            dgG = Integer.valueOf(ContextCompat.getColor(root.getContext(), R.color.red));
        }
        TextView textView = qvVar.bAV;
        h.d(textView, "binding.openButton");
        textView.setOnClickListener(new a(this, bVar));
        this.bXV = c.h(new QuizInsightsViewHolder$$special$$inlined$bindable$1(qvVar, qvVar));
    }
}
