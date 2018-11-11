package com.iqoption.quiz;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.k;
import com.iqoption.core.l;
import com.iqoption.d.qt;
import com.iqoption.fragment.leftpanel.LeftPanelViewModel;
import com.iqoption.fragment.leftpanel.b.d;
import com.iqoption.quiz.model.QuizInsightsViewModel;
import com.iqoption.quiz.model.e;
import com.iqoption.quiz.model.f;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001J\u0011\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001J\u0011\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001J\u0011\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001J\u0011\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001J*\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)H\u0001¢\u0006\u0002\u0010*J\t\u0010+\u001a\u00020,H\u0001J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0011\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020#H\u0001R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, aXE = {"Lcom/iqoption/quiz/InsightsQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "TAG", "", "kotlin.jvm.PlatformType", "adapter", "Lcom/iqoption/quiz/QuizInsightsAdapter;", "binding", "Lcom/iqoption/databinding/FragmentQuizInsightsDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizInsightsDelegateBinding;", "leftPanelViewModel", "Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewModel", "Lcom/iqoption/quiz/model/QuizInsightsViewModel;", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getPixels", "", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "openAsset", "", "item", "Lcom/iqoption/quiz/model/QuizInsightItem;", "toPixels", "dp", "IqOption-5.5.1_optionXRelease"})
/* compiled from: InsightsQuizDelegate.kt */
public final class InsightsQuizDelegate extends QuizDelegate implements k {
    private final String TAG = InsightsQuizDelegate.class.getSimpleName();
    private final qt deD;
    private final QuizInsightsViewModel deE;
    private final LeftPanelViewModel deF;
    private final u deG;
    private final /* synthetic */ l det;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, aXE = {"com/iqoption/quiz/InsightsQuizDelegate$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: InsightsQuizDelegate.kt */
    /* renamed from: com.iqoption.quiz.InsightsQuizDelegate$1 */
    public static final class AnonymousClass1 implements OnPageChangeListener {
        final /* synthetic */ InsightsQuizDelegate this$0;

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }

        AnonymousClass1(InsightsQuizDelegate insightsQuizDelegate) {
            this.this$0 = insightsQuizDelegate;
        }

        public void onPageScrollStateChanged(int i) {
            TextView textView;
            if (i == 0) {
                textView = this.this$0.ayJ().agA;
                h.d(textView, "binding.title");
                com.iqoption.core.ext.a.L(textView);
                return;
            }
            textView = this.this$0.ayJ().agA;
            h.d(textView, "binding.title");
            com.iqoption.core.ext.a.hide(textView);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "onChanged", "com/iqoption/quiz/InsightsQuizDelegate$2$1"})
    /* compiled from: InsightsQuizDelegate.kt */
    static final class a<T> implements Observer<List<? extends f>> {
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ InsightsQuizDelegate this$0;

        a(InsightsQuizDelegate insightsQuizDelegate, QuizFragment quizFragment) {
            this.this$0 = insightsQuizDelegate;
            this.deH = quizFragment;
        }

        /* renamed from: L */
        public final void onChanged(List<? extends f> list) {
            if (list != null) {
                String a = this.this$0.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("insights: ");
                stringBuilder.append(list);
                com.iqoption.core.i.d(a, stringBuilder.toString());
                this.this$0.deG.setItems(list);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, aXE = {"com/iqoption/quiz/InsightsQuizDelegate$dividerItemDecoration$1", "Lcom/iqoption/widget/SimpleDividerItemDecoration;", "spacingPx", "", "getSpacingPx", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "isSkipDraw", "", "child", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: InsightsQuizDelegate.kt */
    public static final class b extends com.iqoption.widget.f {
        private final int bgg;
        final /* synthetic */ QuizFragment deI;
        final /* synthetic */ InsightsQuizDelegate this$0;

        b(InsightsQuizDelegate insightsQuizDelegate, QuizFragment quizFragment, Context context, int i, boolean z, boolean z2) {
            this.this$0 = insightsQuizDelegate;
            this.deI = quizFragment;
            super(context, i, z, z2);
            this.bgg = insightsQuizDelegate.dz(R.dimen.dp13);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            h.e(rect, "outRect");
            h.e(view, Promotion.ACTION_VIEW);
            h.e(recyclerView, "parent");
            super.getItemOffsets(rect, view, recyclerView, state);
            if (!a(recyclerView, view) && this.bgg > 0 && recyclerView.getChildAdapterPosition(view) > 1) {
                rect.top = this.bgg;
            }
        }

        protected boolean a(RecyclerView recyclerView, View view) {
            h.e(recyclerView, "parent");
            h.e(view, "child");
            return !(recyclerView.getChildViewHolder(view) instanceof v);
        }
    }

    public CharSequence dA(int i) {
        return this.det.dA(i);
    }

    public ColorStateList dx(int i) {
        return this.det.dx(i);
    }

    public float dy(int i) {
        return this.det.dy(i);
    }

    public int dz(int i) {
        return this.det.dz(i);
    }

    public int getColor(int i) {
        return this.det.getColor(i);
    }

    public Drawable getDrawable(int i) {
        return this.det.getDrawable(i);
    }

    public Typeface getFont(int i) {
        return this.det.getFont(i);
    }

    public InsightsQuizDelegate(QuizFragment quizFragment, ViewGroup viewGroup) {
        h.e(quizFragment, "f");
        h.e(viewGroup, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        h.d(context, "root.context");
        this.det = new l(context);
        Fragment fragment = quizFragment;
        this.deD = (qt) com.iqoption.core.ext.a.a(fragment, (int) R.layout.fragment_quiz_insights_delegate, viewGroup, false, 4, null);
        View root = this.deD.getRoot();
        h.d(root, "binding.root");
        this.view = root;
        this.deE = QuizInsightsViewModel.dlH.w(com.iqoption.core.ext.a.n(fragment));
        this.deF = LeftPanelViewModel.cEc.l(com.iqoption.core.ext.a.n(fragment));
        this.deG = new u(new InsightsQuizDelegate$adapter$1(this));
        this.deD.axw.addItemDecoration(new b(this, quizFragment, quizFragment.getContext(), R.drawable.line_divider_grey_blur_10, true, true));
        this.deD.axw.setHasFixedSize(true);
        this.deD.axw.addOnScrollListener(com.iqoption.quiz.a.a.did.azM());
        if (viewGroup instanceof ViewPager) {
            ((ViewPager) viewGroup).addOnPageChangeListener(new AnonymousClass1(this));
        }
        qt qtVar = this.deD;
        qtVar.axw.setHasFixedSize(true);
        RecyclerView recyclerView = qtVar.axw;
        h.d(recyclerView, "list");
        recyclerView.setAdapter(this.deG);
        RecyclerView recyclerView2 = qtVar.axw;
        h.d(recyclerView2, "list");
        com.iqoption.core.ext.a.b(recyclerView2);
        this.deE.aBr().observe(quizFragment, new a(this, quizFragment));
    }

    public final qt ayJ() {
        return this.deD;
    }

    public View getView() {
        return this.view;
    }

    private final void a(e eVar) {
        com.iqoption.quiz.a.a.did.i(eVar.getActiveId(), eVar.getOptionType().name());
        com.iqoption.app.managers.tab.a.Il().a(eVar.getActiveId(), eVar.getOptionType(), true);
        this.deF.d(d.cDQ);
    }
}
