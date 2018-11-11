package com.iqoption.quiz;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.ext.g;
import com.iqoption.core.k;
import com.iqoption.core.l;
import com.iqoption.d.rn;
import com.iqoption.d.rr;
import com.iqoption.dto.Event;
import com.iqoption.fragment.leftmenu.LeftMenuViewModel;
import com.iqoption.quiz.b.q;
import com.iqoption.quiz.chat.e;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.view.TextureVideoView;
import com.iqoption.welcomeonboarding.registration.f;
import com.iqoption.x.R;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0001J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0013H\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0001J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001J\u0011\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0001J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001J*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"H\u0001¢\u0006\u0002\u0010#J\t\u0010$\u001a\u00020%H\u0001J\u0011\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, aXE = {"Lcom/iqoption/quiz/OnAirQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "binding", "Lcom/iqoption/databinding/FragmentQuizOnAirDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizOnAirDelegateBinding;", "isScrollToEndAllowed", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getPixels", "", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "toPixels", "dp", "OpenQuizClickListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OnAirQuizDelegate.kt */
public final class OnAirQuizDelegate extends QuizDelegate implements k {
    private final /* synthetic */ l det;
    private final rn dfw;
    private boolean dfx;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: OnAirQuizDelegate.kt */
    static final class d implements Runnable {
        final /* synthetic */ OnAirQuizDelegate dfz;

        d(OnAirQuizDelegate onAirQuizDelegate) {
            this.dfz = onAirQuizDelegate;
        }

        public final void run() {
            this.dfz.ayS().bzb.smoothScrollToPosition(0);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "", "onChanged"})
    /* compiled from: OnAirQuizDelegate.kt */
    /* renamed from: com.iqoption.quiz.OnAirQuizDelegate$3 */
    static final class AnonymousClass3<T> implements Observer<com.iqoption.core.ui.c<Integer>> {
        final /* synthetic */ OnAirQuizDelegate dfz;

        AnonymousClass3(OnAirQuizDelegate onAirQuizDelegate) {
            this.dfz = onAirQuizDelegate;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<Integer> cVar) {
            com.iqoption.core.ui.c cVar2;
            Object obj = (cVar2 == null || !cVar2.isSuccess()) ? null : 1;
            Integer num = null;
            if (obj == null) {
                cVar2 = null;
            }
            if (cVar2 != null) {
                num = (Integer) cVar2.getData();
            }
            if (num != null) {
                TextView textView = this.dfz.ayS().bBB;
                h.d(textView, "binding.viewersCount");
                textView.setText(aj.dhZ.gm(num.intValue()));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/LifeResponse;", "onChanged"})
    /* compiled from: OnAirQuizDelegate.kt */
    /* renamed from: com.iqoption.quiz.OnAirQuizDelegate$4 */
    static final class AnonymousClass4<T> implements Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c>> {
        final /* synthetic */ OnAirQuizDelegate dfz;

        AnonymousClass4(OnAirQuizDelegate onAirQuizDelegate) {
            this.dfz = onAirQuizDelegate;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<com.iqoption.quiz.api.response.c> cVar) {
            com.iqoption.core.ui.c cVar2;
            Object obj = (cVar2 == null || !cVar2.isSuccess()) ? null : 1;
            com.iqoption.quiz.api.response.c cVar3 = null;
            if (obj == null) {
                cVar2 = null;
            }
            if (cVar2 != null) {
                cVar3 = (com.iqoption.quiz.api.response.c) cVar2.getData();
            }
            if (cVar3 != null) {
                TextView textView = this.dfz.ayS().bBx;
                h.d(textView, "binding.lifesCount");
                textView.setText(String.valueOf(cVar3.count));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"com/iqoption/quiz/OnAirQuizDelegate$4", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OnAirQuizDelegate.kt */
    /* renamed from: com.iqoption.quiz.OnAirQuizDelegate$6 */
    public static final class AnonymousClass6 extends ItemDecoration {
        final /* synthetic */ OnAirQuizDelegate dfz;
        private final int space;

        AnonymousClass6(OnAirQuizDelegate onAirQuizDelegate) {
            this.dfz = onAirQuizDelegate;
            this.space = onAirQuizDelegate.dz(R.dimen.dp8);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            h.e(rect, "outRect");
            h.e(view, Promotion.ACTION_VIEW);
            h.e(recyclerView, "parent");
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            Adapter adapter = recyclerView.getAdapter();
            if (childAdapterPosition != (adapter != null ? adapter.getItemCount() : -1)) {
                rect.top = this.space;
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ QuizVideoStreamer dfy;

        public a(QuizVideoStreamer quizVideoStreamer) {
            this.dfy = quizVideoStreamer;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.dfy.setMuted(this.dfy.isMuted() ^ 1);
            com.iqoption.quiz.a.a.did.ez(this.dfy.isMuted() ^ 1);
            view.setActivated(view.isActivated() ^ 1);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/quiz/OnAirQuizDelegate$OpenQuizClickListener;", "Lcom/iqoption/core/ext/OnDelayClickListener;", "analyticsEvent", "Lkotlin/Function0;", "", "(Lcom/iqoption/quiz/OnAirQuizDelegate;Lkotlin/jvm/functions/Function0;)V", "onDelayClick", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OnAirQuizDelegate.kt */
    public final class b extends g {
        private final kotlin.jvm.a.a<kotlin.l> dfG;
        final /* synthetic */ OnAirQuizDelegate dfz;

        public b(OnAirQuizDelegate onAirQuizDelegate, kotlin.jvm.a.a<kotlin.l> aVar) {
            h.e(aVar, "analyticsEvent");
            this.dfz = onAirQuizDelegate;
            super(0, 1, null);
            this.dfG = aVar;
        }

        public void q(View view) {
            h.e(view, "v");
            FragmentActivity n = com.iqoption.core.ext.a.n(this.dfz.azc());
            this.dfG.invoke();
            if (com.iqoption.app.a.Cw().CZ()) {
                com.iqoption.welcomeonboarding.registration.f.a aVar = f.dNb;
                FragmentManager supportFragmentManager = n.getSupportFragmentManager();
                h.d(supportFragmentManager, "activity.supportFragmentManager");
                aVar.a(n, supportFragmentManager);
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_open-account").build());
                return;
            }
            n.startActivity(new Intent(n, QuizActivity.class));
            LeftMenuViewModel.cCO.k(n).close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0005¨\u0006\u000e"}, aXE = {"com/iqoption/quiz/OnAirQuizDelegate$chatItemsAdapter$1", "Lcom/iqoption/quiz/chat/ChatStyles;", "avatarSize", "", "getAvatarSize", "()I", "largeTextSize", "", "getLargeTextSize", "()F", "smallTextSize", "getSmallTextSize", "textColor", "getTextColor", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OnAirQuizDelegate.kt */
    public static final class c implements com.iqoption.quiz.chat.f {
        private final int aDI;
        private final float dfH;
        private final float dfI;
        final /* synthetic */ OnAirQuizDelegate dfz;
        private final int textColor;

        c(OnAirQuizDelegate onAirQuizDelegate) {
            this.dfz = onAirQuizDelegate;
            this.aDI = onAirQuizDelegate.dz(R.dimen.dp16);
            this.dfH = onAirQuizDelegate.dy(R.dimen.sp10);
            this.dfI = onAirQuizDelegate.dy(R.dimen.sp10);
            this.textColor = onAirQuizDelegate.getColor(R.color.white);
        }

        public void a(q qVar) {
            h.e(qVar, "binding");
            com.iqoption.quiz.chat.f.a.a(this, qVar);
        }

        public /* synthetic */ Object invoke(Object obj) {
            a((q) obj);
            return kotlin.l.etX;
        }

        public int ayT() {
            return this.aDI;
        }

        public float ayU() {
            return this.dfH;
        }

        public float ayV() {
            return this.dfI;
        }

        public int getTextColor() {
            return this.textColor;
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

    public OnAirQuizDelegate(final QuizFragment quizFragment, ViewGroup viewGroup) {
        h.e(quizFragment, "f");
        h.e(viewGroup, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        h.d(context, "root.context");
        this.det = new l(context);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        h.d(from, "LayoutInflater.from(root.context)");
        this.dfw = (rn) com.iqoption.core.ext.a.a(from, (int) R.layout.fragment_quiz_on_air_delegate, viewGroup, false, 4, null);
        View root = this.dfw.getRoot();
        h.d(root, "binding.root");
        this.view = root;
        this.dfw.axz.setOnClickListener(new b(this, new kotlin.jvm.a.a<kotlin.l>(com.iqoption.quiz.a.a.did) {
            public final kotlin.reflect.d Py() {
                return j.F(com.iqoption.quiz.a.a.class);
            }

            public final String getName() {
                return "expand";
            }

            public final String getSignature() {
                return "expand()V";
            }

            public final void invoke() {
                ((com.iqoption.quiz.a.a) this.receiver).expand();
            }
        }));
        this.dfw.bBt.setOnClickListener(new b(this, new kotlin.jvm.a.a<kotlin.l>(com.iqoption.quiz.a.a.did) {
            public final kotlin.reflect.d Py() {
                return j.F(com.iqoption.quiz.a.a.class);
            }

            public final String getName() {
                return "join";
            }

            public final String getSignature() {
                return "join()V";
            }

            public final void invoke() {
                ((com.iqoption.quiz.a.a) this.receiver).join();
            }
        }));
        final com.iqoption.quiz.chat.d dVar = new com.iqoption.quiz.chat.d(new c(this));
        com.iqoption.core.h.i.Yp().b(new Runnable(this) {
            final /* synthetic */ OnAirQuizDelegate dfz;

            public final void run() {
                if (quizFragment.isAdded()) {
                    this.dfz.ayS().bBt.startAnimation(AnimationUtils.loadAnimation(quizFragment.getContext(), R.anim.join_quiz_scale_anim));
                }
            }
        }, 500, TimeUnit.MILLISECONDS);
        RecyclerView recyclerView = this.dfw.bzb;
        h.d(recyclerView, "binding.chatList");
        recyclerView.setAdapter(dVar);
        this.dfw.bzb.setHasFixedSize(true);
        this.dfw.bzb.addItemDecoration(new AnonymousClass6(this));
        if (VERSION.SDK_INT >= 21) {
            this.dfw.bzb.addItemDecoration(new e());
        }
        recyclerView = this.dfw.bzb;
        h.d(recyclerView, "binding.chatList");
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        RecyclerView recyclerView2 = this.dfw.bzb;
        h.d(recyclerView2, "binding.chatList");
        recyclerView2.setItemAnimator((ItemAnimator) null);
        this.dfw.bzb.addOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ OnAirQuizDelegate dfz;

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                this.dfz.dfx = linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0;
            }
        });
        final TriviaSocketViewModel x = TriviaSocketViewModel.dmB.x(com.iqoption.core.ext.a.n(quizFragment));
        final Runnable dVar2 = new d(this);
        LifecycleOwner lifecycleOwner = this;
        x.aBQ().observe(lifecycleOwner, new Observer<List<? extends com.iqoption.quiz.chat.b>>(this) {
            final /* synthetic */ OnAirQuizDelegate dfz;

            /* renamed from: L */
            public final void onChanged(List<com.iqoption.quiz.chat.b> list) {
                if (list != null) {
                    com.iqoption.quiz.chat.b bVar = (com.iqoption.quiz.chat.b) u.bV(dVar.getItems());
                    com.iqoption.quiz.chat.b bVar2 = (com.iqoption.quiz.chat.b) u.bV(list);
                    dVar.setItems(list);
                    if (this.dfz.dfx && (h.E(bVar, bVar2) ^ 1) != 0) {
                        this.dfz.ayS().bzb.postOnAnimation(dVar2);
                    }
                }
            }
        });
        TextureVideoView textureVideoView = this.dfw.bBA;
        h.d(textureVideoView, "binding.video");
        final QuizVideoStreamer quizVideoStreamer = new QuizVideoStreamer(textureVideoView);
        ImageView imageView = this.dfw.bBv;
        h.d(imageView, "binding.btnMute");
        imageView.setOnClickListener(new a(quizVideoStreamer));
        x.aCd().observe(lifecycleOwner, new Observer<Boolean>(this) {
            final /* synthetic */ OnAirQuizDelegate dfz;

            @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
            /* compiled from: AndroidExtensions.kt */
            public static final class a extends g {
                final /* synthetic */ AnonymousClass9 dfE;

                public a(AnonymousClass9 anonymousClass9) {
                    this.dfE = anonymousClass9;
                    super(0, 1, null);
                }

                public void q(View view) {
                    h.e(view, "v");
                    com.iqoption.quiz.a.a.did.azW();
                    x.aCe();
                }
            }

            /* renamed from: k */
            public final void onChanged(Boolean bool) {
                rr rrVar;
                View root;
                if (h.E(bool, Boolean.valueOf(true))) {
                    com.iqoption.quiz.a.a.did.eE(false);
                    rrVar = this.dfz.ayS().bBy;
                    h.d(rrVar, "binding.questionLanguage");
                    root = rrVar.getRoot();
                    h.d(root, "binding.questionLanguage.root");
                    root.setVisibility(0);
                    ImageView imageView = this.dfz.ayS().bBy.bBI;
                    h.d(imageView, "binding.questionLanguage.close");
                    imageView.setOnClickListener(new a(this));
                } else if (h.E(bool, Boolean.valueOf(false))) {
                    rrVar = this.dfz.ayS().bBy;
                    h.d(rrVar, "binding.questionLanguage");
                    root = rrVar.getRoot();
                    h.d(root, "binding.questionLanguage.root");
                    root.setVisibility(8);
                }
            }
        });
        x.aBO().observe(lifecycleOwner, new Observer<com.iqoption.core.ui.c<com.iqoption.quiz.api.response.k>>() {
            /* renamed from: a */
            public final void onChanged(com.iqoption.core.ui.c<com.iqoption.quiz.api.response.k> cVar) {
                com.iqoption.core.ui.c cVar2;
                Object obj = (cVar2 == null || !cVar2.isSuccess()) ? null : 1;
                com.iqoption.quiz.api.response.k kVar = null;
                if (obj == null) {
                    cVar2 = null;
                }
                if (cVar2 != null) {
                    kVar = (com.iqoption.quiz.api.response.k) cVar2.getData();
                }
                if (kVar != null) {
                    QuizVideoStreamer quizVideoStreamer = quizVideoStreamer;
                    String aAA = kVar.aAA();
                    h.d(aAA, "data.streamUrl");
                    quizVideoStreamer.jb(aAA);
                    quizVideoStreamer.ep(kVar.aAv());
                }
            }
        });
        x.aBB().observe(lifecycleOwner, new AnonymousClass3(this));
        x.aBN().observe(lifecycleOwner, new AnonymousClass4(this));
        getLifecycle().a(quizVideoStreamer);
    }

    public final rn ayS() {
        return this.dfw;
    }

    public View getView() {
        return this.view;
    }
}
