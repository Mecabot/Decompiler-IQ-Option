package com.iqoption.quiz.chat;

import android.arch.lifecycle.Observer;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.quiz.b.e;
import com.iqoption.quiz.c.f;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010\u001d\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/quiz/chat/ChatDelegate;", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "b", "Lcom/iqoption/quiz/databinding/ChatLayoutBinding;", "(Landroid/support/v4/app/FragmentActivity;Lcom/iqoption/quiz/databinding/ChatLayoutBinding;)V", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "adapter", "Lcom/iqoption/quiz/chat/ChatItemsAdapter;", "getB", "()Lcom/iqoption/quiz/databinding/ChatLayoutBinding;", "isScrollToEndAllowed", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "recentButtonController", "Lcom/iqoption/quiz/chat/RecentButtonController;", "viewModel", "Lcom/iqoption/quiz/model/TriviaSocketViewModel;", "showOrHideRecentButton", "", "tryScrollToEnd", "oldFirstItem", "Lcom/iqoption/quiz/chat/ChatItem;", "newFirstItem", "scrollToEndCommand", "Ljava/lang/Runnable;", "tryShowOrHideRecentButton", "quiz_release"})
/* compiled from: ChatDelegate.kt */
public final class a {
    private final LinearLayoutManager aIi;
    private final FragmentActivity csX;
    private final TriviaSocketViewModel dfY = TriviaSocketViewModel.dmB.x(this.csX);
    private boolean dfx;
    private final d djl;
    private final h djm;
    private final e djn;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, aXE = {"com/iqoption/quiz/chat/ChatDelegate$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "quiz_release"})
    /* compiled from: ChatDelegate.kt */
    /* renamed from: com.iqoption.quiz.chat.a$1 */
    public static final class AnonymousClass1 implements TextWatcher {
        final /* synthetic */ a this$0;

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass1(a aVar) {
            this.this$0 = aVar;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ImageView imageView = this.this$0.aAU().bmG;
            h.d(imageView, "b.btnSend");
            EditText editText = this.this$0.aAU().dkD;
            h.d(editText, "b.message");
            boolean z = false;
            if ((((CharSequence) editText.getText().toString()).length() > 0 ? 1 : 0) == 1) {
                z = true;
            }
            imageView.setEnabled(z);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ChatDelegate.kt */
    /* renamed from: com.iqoption.quiz.chat.a$4 */
    static final class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ a this$0;

        AnonymousClass4(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.aAU().dkE.smoothScrollToPosition(0);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ChatDelegate.kt */
    static final class a implements Runnable {
        final /* synthetic */ a this$0;

        a(a aVar) {
            this.this$0 = aVar;
        }

        public final void run() {
            this.this$0.aAU().dkE.smoothScrollToPosition(0);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"com/iqoption/quiz/chat/ChatDelegate$7", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "quiz_release"})
    /* compiled from: ChatDelegate.kt */
    /* renamed from: com.iqoption.quiz.chat.a$5 */
    public static final class AnonymousClass5 extends ItemDecoration {
        private final int space;
        final /* synthetic */ a this$0;

        AnonymousClass5(a aVar) {
            this.this$0 = aVar;
            this.space = aVar.getActivity().getResources().getDimensionPixelSize(com.iqoption.quiz.ae.a.dp8);
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

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, aXE = {"com/iqoption/quiz/chat/ChatDelegate$8", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "quiz_release"})
    /* compiled from: ChatDelegate.kt */
    /* renamed from: com.iqoption.quiz.chat.a$6 */
    public static final class AnonymousClass6 extends OnScrollListener {
        final /* synthetic */ a this$0;

        AnonymousClass6(a aVar) {
            this.this$0 = aVar;
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            this.this$0.dfx = this.this$0.aIi.findFirstCompletelyVisibleItemPosition() == 0;
            this.this$0.aAT();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "onChanged"})
    /* compiled from: ChatDelegate.kt */
    static final class b<T> implements Observer<String> {
        final /* synthetic */ a this$0;

        b(a aVar) {
            this.this$0 = aVar;
        }

        /* renamed from: fz */
        public final void onChanged(String str) {
            this.this$0.aAU().dkD.setText("");
            EditText editText = this.this$0.aAU().dkD;
            h.d(editText, "b.message");
            editText.setEnabled(true);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0005J\t\u0010\u000b\u001a\u00020\u0004H\u0002J\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, aXE = {"com/iqoption/quiz/chat/ChatDelegate$sender$1", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lkotlin/Function0;", "", "Lkotlin/Function1;", "", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "invoke", "isLarge", "onClick", "v", "Landroid/view/View;", "onLongClick", "quiz_release"})
    /* compiled from: ChatDelegate.kt */
    public static final class c implements OnClickListener, OnLongClickListener, kotlin.jvm.a.a<l>, kotlin.jvm.a.b<Boolean, l> {
        private final String avatarUrl;
        final /* synthetic */ Observer djq;
        final /* synthetic */ a this$0;

        c(a aVar, Observer observer) {
            this.this$0 = aVar;
            this.djq = observer;
            this.avatarUrl = aVar.dfY.bK(aVar.getActivity());
        }

        public /* synthetic */ Object invoke(Object obj) {
            eo(((Boolean) obj).booleanValue());
            return l.etX;
        }

        public void onClick(View view) {
            invoke();
        }

        public boolean onLongClick(View view) {
            eo(true);
            return true;
        }

        public void invoke() {
            eo(false);
        }

        public void eo(boolean z) {
            EditText editText = this.this$0.aAU().dkD;
            h.d(editText, "b.message");
            boolean z2 = false;
            editText.setEnabled(false);
            ImageView imageView = this.this$0.aAU().bmG;
            h.d(imageView, "b.btnSend");
            imageView.setEnabled(false);
            editText = this.this$0.aAU().dkD;
            h.d(editText, "b.message");
            String obj = editText.getText().toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            obj = v.trim(obj).toString();
            if (obj.length() > 0) {
                z2 = true;
            }
            if (z2) {
                com.iqoption.quiz.a.a.did.sendMessage();
                this.this$0.dfY.b(obj, z, this.avatarUrl).observe(this.this$0.getActivity(), this.djq);
                return;
            }
            EditText editText2 = this.this$0.aAU().dkD;
            h.d(editText2, "b.message");
            editText2.setEnabled(true);
            ImageView imageView2 = this.this$0.aAU().bmG;
            h.d(imageView2, "b.btnSend");
            imageView2.setEnabled(true);
        }
    }

    public a(FragmentActivity fragmentActivity, e eVar) {
        h.e(fragmentActivity, "activity");
        h.e(eVar, com.iqoption.fragment.cashbox.deppage.b.TAG);
        this.csX = fragmentActivity;
        this.djn = eVar;
        ImageView imageView = this.djn.dkB;
        h.d(imageView, "b.btnRecent");
        this.djm = new h(imageView);
        Observer bVar = new b(this);
        this.djn.dkD.addTextChangedListener(new AnonymousClass1(this));
        final c cVar = new c(this, bVar);
        this.djn.dkD.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                cVar.invoke();
                return true;
            }
        });
        final ChatDelegate$3 chatDelegate$3 = new ChatDelegate$3(this, new AtomicBoolean());
        final f fVar = new f(this.csX);
        this.djn.dkC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a this$0;

            public final void onClick(View view) {
                chatDelegate$3.eo(true);
                this.this$0.aAU().dkD.requestFocus();
                f fVar = fVar;
                EditText editText = this.this$0.aAU().dkD;
                h.d(editText, "b.message");
                fVar.G(editText);
            }
        });
        this.djn.dkB.setOnClickListener(new AnonymousClass4(this));
        com.iqoption.quiz.h.r(this.csX).l(new ChatDelegate$6(chatDelegate$3));
        this.djn.bmG.setOnClickListener(cVar);
        this.djn.bmG.setOnLongClickListener(cVar);
        View root = this.djn.getRoot();
        h.d(root, "b.root");
        Resources resources = root.getResources();
        h.d(resources, "b.root.resources");
        this.djl = new d(new g(resources));
        RecyclerView recyclerView = this.djn.dkE;
        h.d(recyclerView, "b.recycleView");
        recyclerView.setAdapter(this.djl);
        this.djn.dkE.setHasFixedSize(true);
        this.djn.dkE.addItemDecoration(new AnonymousClass5(this));
        if (VERSION.SDK_INT >= 21) {
            this.djn.dkE.addItemDecoration(new e());
        }
        recyclerView = this.djn.dkE;
        h.d(recyclerView, "b.recycleView");
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        this.aIi = (LinearLayoutManager) layoutManager;
        recyclerView = this.djn.dkE;
        h.d(recyclerView, "b.recycleView");
        recyclerView.setItemAnimator((ItemAnimator) null);
        this.djn.dkE.addOnScrollListener(new AnonymousClass6(this));
        final Runnable aVar = new a(this);
        this.dfY.aBQ().observe(this.csX, new Observer<List<? extends b>>(this) {
            final /* synthetic */ a this$0;

            /* renamed from: L */
            public final void onChanged(List<b> list) {
                if (list != null) {
                    b bVar = (b) u.bV(this.this$0.djl.getItems());
                    b bVar2 = (b) u.bV(list);
                    this.this$0.djl.setItems(list);
                    this.this$0.a(bVar, bVar2, aVar);
                    this.this$0.a(bVar, bVar2);
                }
            }
        });
    }

    public final e aAU() {
        return this.djn;
    }

    public final FragmentActivity getActivity() {
        return this.csX;
    }

    private final void a(b bVar, b bVar2, Runnable runnable) {
        if (this.dfx && (h.E(bVar, bVar2) ^ 1) != 0) {
            this.djn.dkE.postOnAnimation(runnable);
        }
    }

    private final void a(b bVar, b bVar2) {
        if ((h.E(bVar, bVar2) ^ 1) != 0) {
            aAT();
        }
    }

    private final void aAT() {
        h hVar = this.djm;
        boolean z = (this.djl.getItemCount() == 0 || this.aIi.findFirstVisibleItemPosition() == 0) ? false : true;
        hVar.ar(z);
    }
}
