package com.iqoption.quiz;

import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.d.rf;
import com.iqoption.quiz.model.l;
import com.iqoption.x.R;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bR+\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, aXE = {"Lcom/iqoption/quiz/QuizLeaderBoardViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/FragmentQuizLeaderboardYouItemBinding;", "onClick", "Lkotlin/Function1;", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "", "(Lcom/iqoption/databinding/FragmentQuizLeaderboardYouItemBinding;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "bound", "getBound", "()Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "setBound", "(Lcom/iqoption/quiz/model/QuizLeaderBoardItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizLeaderBoardViewHolder.kt */
public final class x extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(x.class), "bound", "getBound()Lcom/iqoption/quiz/model/QuizLeaderBoardItem;"))};
    public static final b dgN = new b();
    private final d bXV;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, aXE = {"Lcom/iqoption/quiz/QuizLeaderBoardViewHolder$Companion;", "", "()V", "bind", "", "binding", "Lcom/iqoption/databinding/FragmentQuizLeaderboardYouItemBinding;", "item", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizLeaderBoardViewHolder.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final void a(rf rfVar, l lVar) {
            TextView textView;
            h.e(rfVar, "binding");
            h.e(lVar, "item");
            ImageView imageView;
            if (lVar.aBx() == null) {
                textView = rfVar.bBd;
                h.d(textView, "position");
                textView.setText(String.valueOf(lVar.getPosition()));
                textView = rfVar.bBd;
                h.d(textView, "position");
                textView.setVisibility(0);
                imageView = rfVar.bBc;
                h.d(imageView, "placeIcon");
                imageView.setVisibility(8);
            } else {
                imageView = rfVar.bBc;
                Integer aBx = lVar.aBx();
                if (aBx == null) {
                    h.aXZ();
                }
                imageView.setImageResource(aBx.intValue());
                imageView = rfVar.bBc;
                h.d(imageView, "placeIcon");
                imageView.setVisibility(0);
                textView = rfVar.bBd;
                h.d(textView, "position");
                textView.setVisibility(8);
            }
            textView = rfVar.aig;
            h.d(textView, "name");
            textView.setText(lVar.getDisplayName());
            View root;
            if (lVar.aBw()) {
                textView = rfVar.bBf;
                h.d(textView, "you");
                com.iqoption.core.ext.a.L(textView);
                root = rfVar.getRoot();
                h.d(root, "root");
                root.setBackground(com.iqoption.core.ext.a.e((ViewDataBinding) rfVar, (int) R.color.quiz_leaderboard_you_item_bg));
            } else {
                textView = rfVar.bBf;
                h.d(textView, "you");
                com.iqoption.core.ext.a.M(textView);
                root = rfVar.getRoot();
                h.d(root, "root");
                root.setBackground((Drawable) null);
            }
            TextView textView2 = rfVar.bBe;
            h.d(textView2, com.google.firebase.analytics.FirebaseAnalytics.b.SCORE);
            textView2.setText(lVar.aBy());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ kotlin.jvm.a.b dgJ;
        final /* synthetic */ x dgO;

        public a(x xVar, kotlin.jvm.a.b bVar) {
            this.dgO = xVar;
            this.dgJ = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.dgJ.invoke(this.dgO.azh());
        }
    }

    public final l azh() {
        return (l) this.bXV.b(this, apP[0]);
    }

    public final void c(l lVar) {
        h.e(lVar, "<set-?>");
        this.bXV.a(this, apP[0], lVar);
    }

    public x(rf rfVar, kotlin.jvm.a.b<? super l, kotlin.l> bVar) {
        h.e(rfVar, "binding");
        h.e(bVar, "onClick");
        super(rfVar.getRoot());
        View root = rfVar.getRoot();
        h.d(root, "binding.root");
        root.setOnClickListener(new a(this, bVar));
        this.bXV = c.h(new QuizLeaderBoardViewHolder$$special$$inlined$bindable$1(rfVar, rfVar));
    }
}
