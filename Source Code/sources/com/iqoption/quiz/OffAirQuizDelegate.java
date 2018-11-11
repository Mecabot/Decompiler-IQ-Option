package com.iqoption.quiz;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ext.g;
import com.iqoption.core.k;
import com.iqoption.core.l;
import com.iqoption.d.rj;
import com.iqoption.d.rl;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001J*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 H\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#H\u0001J\u0011\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, aXE = {"Lcom/iqoption/quiz/OffAirQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "binding", "Lcom/iqoption/databinding/FragmentQuizOffAirDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizOffAirDelegateBinding;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getPixels", "", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "toPixels", "dp", "HeartsDrawable", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OffAirQuizDelegate.kt */
public final class OffAirQuizDelegate extends QuizDelegate implements k {
    private final /* synthetic */ l det;
    private final rj dfj;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/quiz/OffAirQuizDelegate$HeartsDrawable;", "Landroid/graphics/drawable/Drawable;", "heart", "offset", "", "count", "", "(Landroid/graphics/drawable/Drawable;FI)V", "heartHeight", "heartWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setCount", "value", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OffAirQuizDelegate.kt */
    public static final class e extends Drawable {
        private final int count;
        private final int dft;
        private final int dfu;
        private final Drawable dfv;
        private final float offset;

        public int getOpacity() {
            return -3;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        public /* synthetic */ e(Drawable drawable, float f, int i, int i2, f fVar) {
            if ((i2 & 4) != 0) {
                i = 1;
            }
            this(drawable, f, i);
        }

        public e(Drawable drawable, float f, int i) {
            h.e(drawable, "heart");
            this.dfv = drawable;
            this.offset = f;
            this.count = i;
            this.dft = this.dfv.getIntrinsicWidth();
            this.dfu = this.dfv.getIntrinsicHeight();
            this.dfv.setBounds(0, 0, this.dft, this.dfu);
        }

        public int getIntrinsicWidth() {
            return c.ae(((float) (this.count * this.dft)) + (((float) (this.count - 1)) * this.offset));
        }

        public int getIntrinsicHeight() {
            return this.dfu;
        }

        public final e gj(int i) {
            return this.count != i ? new e(this.dfv, this.offset, i) : this;
        }

        public void draw(Canvas canvas) {
            h.e(canvas, "canvas");
            canvas.save();
            int i = this.count;
            for (int i2 = 0; i2 < i; i2++) {
                this.dfv.draw(canvas);
                canvas.translate(((float) this.dft) + this.offset, 0.0f);
            }
            canvas.restore();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, aXE = {"com/iqoption/quiz/OffAirQuizDelegate$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OffAirQuizDelegate.kt */
    /* renamed from: com.iqoption.quiz.OffAirQuizDelegate$1 */
    public static final class AnonymousClass1 implements OnPageChangeListener {
        final /* synthetic */ OffAirQuizDelegate dfm;

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }

        AnonymousClass1(OffAirQuizDelegate offAirQuizDelegate) {
            this.dfm = offAirQuizDelegate;
        }

        public void onPageScrollStateChanged(int i) {
            rl rlVar = this.dfm.ayR().bBq;
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
            Context m = com.iqoption.core.ext.a.m(this.deH);
            Intent intent = new Intent();
            Object obj = null;
            if ((VERSION.SDK_INT >= 26 ? 1 : null) != null) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("condition", m.getPackageName(), null));
            } else {
                if ((VERSION.SDK_INT >= 24 ? 1 : null) != null) {
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("app_package", m.getPackageName());
                } else {
                    if (VERSION.SDK_INT >= 21) {
                        obj = 1;
                    }
                    if (obj != null) {
                        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                        intent.putExtra("app_package", m.getPackageName());
                        intent.putExtra("app_uid", m.getApplicationInfo().uid);
                    } else {
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addCategory("android.intent.category.DEFAULT");
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("package:");
                        stringBuilder.append(m.getPackageName());
                        intent.setData(Uri.parse(stringBuilder.toString()));
                    }
                }
            }
            m.startActivity(intent);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends g {
        final /* synthetic */ QuizFragment deH;

        public c(QuizFragment quizFragment) {
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
    public static final class d extends g {
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ OffAirQuizDelegate dfm;
        final /* synthetic */ TriviaSocketViewModel dfn;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/quiz/OffAirQuizDelegate$$special$$inlined$observe$2"})
        /* compiled from: LiveDatas.kt */
        public static final class a<T> implements Observer<T> {
            final /* synthetic */ LiveData dfo;
            final /* synthetic */ d dfp;

            public a(LiveData liveData, d dVar) {
                this.dfo = liveData;
                this.dfp = dVar;
            }

            public final void onChanged(T t) {
                if (t != null) {
                    String str = (String) ((com.iqoption.core.ui.c) t).bl("");
                    Activity n = com.iqoption.core.ext.a.n(this.dfp.deH);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("https://iqoption.onelink.me/2398275754?pid=share&af_dp=iqoption%3A%2F%2Fquiz%2F%3Fcode%3D");
                    stringBuilder.append(str);
                    af.a(n, stringBuilder.toString(), str);
                    this.dfo.removeObservers(this.dfp.dfm);
                }
            }
        }

        public d(OffAirQuizDelegate offAirQuizDelegate, TriviaSocketViewModel triviaSocketViewModel, QuizFragment quizFragment) {
            this.dfm = offAirQuizDelegate;
            this.dfn = triviaSocketViewModel;
            this.deH = quizFragment;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            com.iqoption.quiz.a.a.did.azQ();
            LiveData aBS = this.dfn.aBS();
            aBS.removeObservers(this.dfm);
            aBS.observe(this.dfm, new a(aBS, this));
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

    public OffAirQuizDelegate(final QuizFragment quizFragment, ViewGroup viewGroup) {
        h.e(quizFragment, "f");
        h.e(viewGroup, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        h.d(context, "root.context");
        this.det = new l(context);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        h.d(from, "LayoutInflater.from(root.context)");
        this.dfj = (rj) com.iqoption.core.ext.a.a(from, (int) R.layout.fragment_quiz_off_air_delegate, viewGroup, false, 4, null);
        View root = this.dfj.getRoot();
        h.d(root, "binding.root");
        this.view = root;
        final e eVar = new e(com.iqoption.core.ext.a.a(getDrawable(R.drawable.ic_heart_dp16), getColor(R.color.white)), dy(R.dimen.dp2), 0, 4, null);
        this.dfj.bBj.setImageDrawable(eVar);
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
            final /* synthetic */ OffAirQuizDelegate dfm;

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
                    TextView textView = this.dfm.ayR().bBm;
                    h.d(textView, "binding.nextGameLabel");
                    textView.setText(iVar.aAi());
                    textView = this.dfm.ayR().bBl;
                    h.d(textView, "binding.nextGameDate");
                    textView.setText(iVar.aAj());
                    textView = this.dfm.ayR().bBn;
                    h.d(textView, "binding.nextGameTime");
                    textView.setText(iVar.aAk());
                    textView = this.dfm.ayR().bBp;
                    h.d(textView, "binding.prizeFundLabel");
                    textView.setText(iVar.aAl());
                    textView = this.dfm.ayR().bBo;
                    h.d(textView, "binding.prizeFund");
                    textView.setText(iVar.aAm());
                    if (iVar.aAn()) {
                        objectRef.element = this.dfm.ayR().bBm;
                        objectRef2.element = iVar.aAi();
                    } else if (iVar.aAo()) {
                        objectRef.element = this.dfm.ayR().bBl;
                        objectRef2.element = iVar.aAj();
                    } else if (iVar.aAp()) {
                        objectRef.element = this.dfm.ayR().bBn;
                        objectRef2.element = iVar.aAk();
                    } else if (iVar.aAq()) {
                        objectRef.element = this.dfm.ayR().bBp;
                        objectRef2.element = iVar.aAl();
                    } else if (iVar.aAr()) {
                        objectRef.element = this.dfm.ayR().bBo;
                        objectRef2.element = iVar.aAm();
                    }
                }
            }
        });
        x.aBN().observe(lifecycleOwner, new Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>>(this) {
            final /* synthetic */ OffAirQuizDelegate dfm;

            /* renamed from: a */
            public final void onChanged(com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c> cVar) {
                com.iqoption.quiz.api.response.c cVar2 = cVar != null ? (com.iqoption.quiz.api.response.c) cVar.getData() : null;
                if (cVar2 != null) {
                    int i = 3;
                    if (cVar2.total == 0) {
                        i = 1;
                    } else if (cVar2.total <= 3) {
                        i = cVar2.total;
                    }
                    this.dfm.ayR().bBj.setImageDrawable(eVar.gj(i));
                    TextView textView = this.dfm.ayR().bBk;
                    h.d(textView, "binding.heartsCount");
                    textView.setText(String.valueOf(cVar2.total));
                }
            }
        });
        x.aBG().observe(lifecycleOwner, new a(objectRef, objectRef2));
        ImageView imageView = this.dfj.bBh;
        h.d(imageView, "binding.btnNotifications");
        imageView.setOnClickListener(new b(quizFragment));
        imageView = this.dfj.bBq.bBr;
        h.d(imageView, "binding.title.infoIcon");
        imageView.setOnClickListener(new c(quizFragment));
        TextView textView = this.dfj.bBg;
        h.d(textView, "binding.btnInvite");
        textView.setOnClickListener(new d(this, x, quizFragment));
        getLifecycle().a(new LifecycleObserver(this) {
            final /* synthetic */ OffAirQuizDelegate dfm;

            @OnLifecycleEvent(R = Event.ON_START)
            public final void setupNotificationsButton() {
                ImageView imageView;
                if (NotificationManagerCompat.from(com.iqoption.core.ext.a.m(quizFragment)).areNotificationsEnabled()) {
                    imageView = this.dfm.ayR().bBh;
                    h.d(imageView, "binding.btnNotifications");
                    com.iqoption.core.ext.a.M(imageView);
                    return;
                }
                imageView = this.dfm.ayR().bBh;
                h.d(imageView, "binding.btnNotifications");
                com.iqoption.core.ext.a.L(imageView);
            }
        });
    }

    public final rj ayR() {
        return this.dfj;
    }

    public View getView() {
        return this.view;
    }
}
