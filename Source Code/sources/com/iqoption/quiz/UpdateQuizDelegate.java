package com.iqoption.quiz;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ext.g;
import com.iqoption.core.k;
import com.iqoption.core.l;
import com.iqoption.d.rl;
import com.iqoption.d.rv;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.x.R;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 H\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#H\u0001J\u0011\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, aXE = {"Lcom/iqoption/quiz/UpdateQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "binding", "Lcom/iqoption/databinding/FragmentQuizUpdateDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizUpdateDelegateBinding;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getPixels", "", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "toPixels", "dp", "IqOption-5.5.1_optionXRelease"})
/* compiled from: UpdateQuizDelegate.kt */
public final class UpdateQuizDelegate extends QuizDelegate implements k {
    private final /* synthetic */ l det;
    private final rv dhX;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, aXE = {"com/iqoption/quiz/UpdateQuizDelegate$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: UpdateQuizDelegate.kt */
    /* renamed from: com.iqoption.quiz.UpdateQuizDelegate$1 */
    public static final class AnonymousClass1 implements OnPageChangeListener {
        final /* synthetic */ UpdateQuizDelegate dhY;

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }

        AnonymousClass1(UpdateQuizDelegate updateQuizDelegate) {
            this.dhY = updateQuizDelegate;
        }

        public void onPageScrollStateChanged(int i) {
            rl rlVar = this.dhY.azE().bBq;
            h.d(rlVar, "binding.title");
            View root = rlVar.getRoot();
            h.d(root, "binding.title.root");
            root.setVisibility(i == 0 ? 0 : 8);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class a<T> implements Observer<T> {
        final /* synthetic */ ObjectRef dfk;
        final /* synthetic */ ObjectRef dfl;

        public a(ObjectRef objectRef, ObjectRef objectRef2) {
            this.dfk = objectRef;
            this.dfl = objectRef2;
        }

        public final void onChanged(T t) {
            if (t != null) {
                String str = (String) t;
                if (h.E(str, "")) {
                    TextView textView = (TextView) this.dfk.element;
                    if (textView != null) {
                        textView.setText((String) this.dfl.element);
                        return;
                    }
                    return;
                }
                TextView textView2 = (TextView) this.dfk.element;
                if (textView2 != null) {
                    textView2.setText(str);
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ QuizFragment deH;

        public b(QuizFragment quizFragment) {
            this.deH = quizFragment;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            QuizDelegate.dgu.v(com.iqoption.core.ext.a.n(this.deH));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends g {
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ TriviaSocketViewModel dfn;

        public c(TriviaSocketViewModel triviaSocketViewModel, QuizFragment quizFragment) {
            this.dfn = triviaSocketViewModel;
            this.deH = quizFragment;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            com.iqoption.quiz.a.a.did.azZ();
            this.dfn.m(com.iqoption.core.ext.a.n(this.deH));
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

    public UpdateQuizDelegate(final QuizFragment quizFragment, ViewGroup viewGroup) {
        h.e(quizFragment, "f");
        h.e(viewGroup, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        h.d(context, "root.context");
        this.det = new l(context);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        h.d(from, "LayoutInflater.from(root.context)");
        this.dhX = (rv) com.iqoption.core.ext.a.a(from, (int) R.layout.fragment_quiz_update_delegate, viewGroup, false, 4, null);
        View root = this.dhX.getRoot();
        h.d(root, "binding.root");
        this.view = root;
        TriviaSocketViewModel x = TriviaSocketViewModel.dmB.x(com.iqoption.core.ext.a.n(quizFragment));
        final ObjectRef objectRef = new ObjectRef();
        objectRef.element = (TextView) null;
        final ObjectRef objectRef2 = new ObjectRef();
        objectRef2.element = (String) null;
        if (viewGroup instanceof ViewPager) {
            ((ViewPager) viewGroup).addOnPageChangeListener(new AnonymousClass1(this));
        }
        LifecycleOwner lifecycleOwner = this;
        x.aBE().observe(lifecycleOwner, new Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.i>>(this) {
            final /* synthetic */ UpdateQuizDelegate dhY;

            /* renamed from: a */
            public final void onChanged(com.iqoption.core.ui.c<com.iqoption.quiz.api.response.i> cVar) {
                com.iqoption.core.ui.c cVar2;
                Object obj = (cVar2 == null || !cVar2.isSuccess()) ? null : 1;
                com.iqoption.quiz.api.response.i iVar = null;
                if (obj == null) {
                    cVar2 = null;
                }
                if (cVar2 != null) {
                    iVar = (com.iqoption.quiz.api.response.i) cVar2.getData();
                }
                if (iVar != null) {
                    TextView textView = this.dhY.azE().bBm;
                    h.d(textView, "binding.nextGameLabel");
                    m mVar = m.euz;
                    Locale locale = Locale.US;
                    h.d(locale, "Locale.US");
                    Object[] objArr = new Object[]{iVar.aAi()};
                    String format = String.format(locale, "%s:", Arrays.copyOf(objArr, objArr.length));
                    h.d(format, "java.lang.String.format(locale, format, *args)");
                    textView.setText(format);
                    textView = this.dhY.azE().bBl;
                    h.d(textView, "binding.nextGameDate");
                    textView.setText(iVar.aAj());
                    textView = this.dhY.azE().bBn;
                    h.d(textView, "binding.nextGameTime");
                    textView.setText(iVar.aAk());
                    textView = this.dhY.azE().bBp;
                    h.d(textView, "binding.prizeFundLabel");
                    mVar = m.euz;
                    locale = Locale.US;
                    h.d(locale, "Locale.US");
                    Object[] objArr2 = new Object[]{iVar.aAl()};
                    String format2 = String.format(locale, "%s:", Arrays.copyOf(objArr2, objArr2.length));
                    h.d(format2, "java.lang.String.format(locale, format, *args)");
                    textView.setText(format2);
                    textView = this.dhY.azE().bBo;
                    h.d(textView, "binding.prizeFund");
                    textView.setText(iVar.aAm());
                    if (iVar.aAn()) {
                        objectRef.element = this.dhY.azE().bBm;
                        objectRef2.element = iVar.aAi();
                    } else if (iVar.aAo()) {
                        objectRef.element = this.dhY.azE().bBl;
                        objectRef2.element = iVar.aAj();
                    } else if (iVar.aAp()) {
                        objectRef.element = this.dhY.azE().bBn;
                        objectRef2.element = iVar.aAk();
                    } else if (iVar.aAq()) {
                        objectRef.element = this.dhY.azE().bBp;
                        objectRef2.element = iVar.aAl();
                    } else if (iVar.aAr()) {
                        objectRef.element = this.dhY.azE().bBo;
                        objectRef2.element = iVar.aAm();
                    }
                }
            }
        });
        x.aBG().observe(lifecycleOwner, new a(objectRef, objectRef2));
        ImageView imageView = this.dhX.bBq.bBr;
        h.d(imageView, "binding.title.infoIcon");
        imageView.setOnClickListener(new b(quizFragment));
        com.iqoption.core.h.i.Yp().b(new Runnable(this) {
            final /* synthetic */ UpdateQuizDelegate dhY;

            public final void run() {
                if (quizFragment.isAdded()) {
                    this.dhY.azE().bBK.startAnimation(AnimationUtils.loadAnimation(quizFragment.getContext(), R.anim.join_quiz_scale_anim));
                }
            }
        }, 500, TimeUnit.MILLISECONDS);
        TextView textView = this.dhX.bBK;
        h.d(textView, "binding.btnUpdate");
        textView.setOnClickListener(new c(x, quizFragment));
    }

    public final rv azE() {
        return this.dhX;
    }

    public View getView() {
        return this.view;
    }
}
