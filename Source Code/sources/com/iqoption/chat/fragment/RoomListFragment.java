package com.iqoption.chat.fragment;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.chat.component.aj;
import com.iqoption.chat.viewmodel.InteractionViewModel;
import com.iqoption.chat.viewmodel.LastMessagesViewModel;
import com.iqoption.chat.viewmodel.RoomsViewModel;
import com.iqoption.chat.viewmodel.SearchRoomViewModel;
import com.iqoption.chat.viewmodel.SupportRoomViewModel;
import com.iqoption.chat.viewmodel.WebSocketViewModel;
import com.iqoption.d.sb;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.n;
import com.iqoption.util.ar;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.m;

@i(aXC = {1, 1, 11}, aXD = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006$"}, aXE = {"Lcom/iqoption/chat/fragment/RoomListFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "adapter", "Lcom/iqoption/chat/component/RoomsAdapter;", "binding", "Lcom/iqoption/databinding/FragmentRoomListBinding;", "eventBuilder", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "interactionListener", "Lcom/iqoption/chat/fragment/RoomListFragment$InteractionListener;", "itemAnimator", "Landroid/support/v7/widget/RecyclerView$ItemAnimator;", "lastMessagesViewModel", "Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "roomsViewModel", "Lcom/iqoption/chat/viewmodel/RoomsViewModel;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDetach", "onHideAnimation", "onShowAnimation", "Companion", "InteractionListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomListFragment.kt */
public final class RoomListFragment extends com.iqoption.fragment.base.b {
    private static final String TAG = "RoomListFragment";
    public static final a aIE = new a();
    private Builder aFE;
    private RoomsViewModel aHA;
    private LastMessagesViewModel aHB;
    private ItemAnimator aHy;
    private aj aHz;
    private b aIC;
    private sb aID;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/chat/fragment/RoomListFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/RoomListFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomListFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/chat/fragment/RoomListFragment$InteractionListener;", "", "onOpenChat", "", "chat", "Lcom/iqoption/microservice/chat/ChatRoom;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomListFragment.kt */
    public interface b {
        void c(n nVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$1"})
    /* compiled from: RoomListFragment.kt */
    static final class c<T> implements Observer<Boolean> {
        final /* synthetic */ RoomListFragment aIF;
        final /* synthetic */ SupportRoomViewModel aIG;
        final /* synthetic */ RoomListFragment this$0;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "onChanged", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$1$1"})
        /* compiled from: RoomListFragment.kt */
        /* renamed from: com.iqoption.chat.fragment.RoomListFragment$c$1 */
        static final class AnonymousClass1<T> implements Observer<List<? extends n>> {
            final /* synthetic */ c aIH;

            AnonymousClass1(c cVar) {
                this.aIH = cVar;
            }

            /* renamed from: L */
            public final void onChanged(List<n> list) {
                List list2;
                if (list2 != null) {
                    RoomListFragment.a(this.aIH.this$0).Rp();
                    RoomListFragment.b(this.aIH.this$0).W(list2);
                    for (Object next : list2) {
                        Object obj;
                        if (((n) next).Qh() == ChatRoomType.SUPPORT) {
                            obj = 1;
                            continue;
                        } else {
                            obj = null;
                            continue;
                        }
                        if (obj != null) {
                            break;
                        }
                    }
                    Object next2 = null;
                    n nVar = (n) next2;
                    if (nVar != null) {
                        this.aIH.aIG.fX(nVar.getId());
                    }
                }
                aj c = RoomListFragment.c(this.aIH.this$0);
                if (list2 == null) {
                    list2 = m.emptyList();
                }
                c.N(list2);
            }
        }

        c(RoomListFragment roomListFragment, SupportRoomViewModel supportRoomViewModel, RoomListFragment roomListFragment2) {
            this.aIF = roomListFragment;
            this.aIG = supportRoomViewModel;
            this.this$0 = roomListFragment2;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (kotlin.jvm.internal.h.E(bool, Boolean.valueOf(true))) {
                ar.a(RoomListFragment.a(this.this$0).Ro(), (com.iqoption.util.fragmentstack.e) this.aIF, (Observer) new AnonymousClass1(this));
                return;
            }
            RoomListFragment.a(this.this$0).Rq();
            RoomListFragment.b(this.this$0).X((List) RoomListFragment.a(this.this$0).Ro().getValue());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$2"})
    /* compiled from: RoomListFragment.kt */
    static final class d<T> implements Observer<CharSequence> {
        final /* synthetic */ RoomListFragment this$0;

        d(RoomListFragment roomListFragment) {
            this.this$0 = roomListFragment;
        }

        /* renamed from: o */
        public final void onChanged(CharSequence charSequence) {
            aj c = RoomListFragment.c(this.this$0);
            if (charSequence == null) {
                charSequence = "";
            }
            c.filter(charSequence);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$3$1", "com/iqoption/chat/fragment/RoomListFragment$$special$$inlined$let$lambda$1"})
    /* compiled from: RoomListFragment.kt */
    static final class e<T> implements Observer<Boolean> {
        final /* synthetic */ InteractionViewModel aII;
        final /* synthetic */ RoomListFragment aIJ;
        final /* synthetic */ RoomListFragment this$0;

        e(InteractionViewModel interactionViewModel, RoomListFragment roomListFragment, RoomListFragment roomListFragment2) {
            this.aII = interactionViewModel;
            this.aIJ = roomListFragment;
            this.this$0 = roomListFragment2;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (kotlin.jvm.internal.h.E(bool, Boolean.valueOf(true))) {
                RoomListFragment.c(this.this$0).notifyDataSetChanged();
                this.aII.QT();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, aXE = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "onChanged", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$3$2", "com/iqoption/chat/fragment/RoomListFragment$$special$$inlined$let$lambda$2"})
    /* compiled from: RoomListFragment.kt */
    static final class f<T> implements Observer<Pair<? extends Boolean, ? extends String>> {
        final /* synthetic */ InteractionViewModel aII;
        final /* synthetic */ RoomListFragment aIJ;
        final /* synthetic */ RoomListFragment this$0;

        f(InteractionViewModel interactionViewModel, RoomListFragment roomListFragment, RoomListFragment roomListFragment2) {
            this.aII = interactionViewModel;
            this.aIJ = roomListFragment;
            this.this$0 = roomListFragment2;
        }

        /* renamed from: a */
        public final void onChanged(Pair<Boolean, String> pair) {
            if (pair != null && ((Boolean) pair.getFirst()).booleanValue()) {
                int fL = RoomListFragment.c(this.this$0).fL((String) pair.aXF());
                if (fL > -1) {
                    RoomListFragment.c(this.this$0).notifyItemChanged(fL);
                    this.aII.QU();
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$3$3", "com/iqoption/chat/fragment/RoomListFragment$$special$$inlined$let$lambda$3"})
    /* compiled from: RoomListFragment.kt */
    static final class g<T> implements Observer<Boolean> {
        final /* synthetic */ RoomListFragment aIJ;
        final /* synthetic */ RoomListFragment this$0;

        g(RoomListFragment roomListFragment, RoomListFragment roomListFragment2) {
            this.aIJ = roomListFragment;
            this.this$0 = roomListFragment2;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            RecyclerView recyclerView = RoomListFragment.d(this.this$0).bzb;
            kotlin.jvm.internal.h.d(recyclerView, "binding.chatList");
            recyclerView.setItemAnimator(kotlin.jvm.internal.h.E(bool, Boolean.valueOf(false)) ? RoomListFragment.e(this.this$0) : null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, aXE = {"com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$7", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "lineWidth", "", "getLineWidth", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomListFragment.kt */
    public static final class h extends ItemDecoration {
        private final int aIK = com.iqoption.core.ext.a.c((ViewDataBinding) this.aIL, (int) R.dimen.chat_room_divider_height);
        final /* synthetic */ sb aIL;
        private final Paint kx;

        h(sb sbVar) {
            this.aIL = sbVar;
            Paint paint = new Paint(1);
            paint.setColor(com.iqoption.core.ext.a.a((ViewDataBinding) this.aIL, (int) R.color.chat_room_divider));
            this.kx = paint;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            kotlin.jvm.internal.h.e(rect, "outRect");
            kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(recyclerView, "parent");
            if (recyclerView.getChildAdapterPosition(view) != 0) {
                rect.top = this.aIK;
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            kotlin.jvm.internal.h.e(canvas, "c");
            kotlin.jvm.internal.h.e(recyclerView, "parent");
            kotlin.jvm.internal.h.e(state, "state");
            ViewGroup viewGroup = recyclerView;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                kotlin.jvm.internal.h.d(childAt, "getChildAt(index)");
                if (recyclerView.getChildAdapterPosition(childAt) != 0) {
                    canvas.drawRect(0.0f, ((float) childAt.getTop()) - ((float) this.aIK), (float) recyclerView.getWidth(), (float) childAt.getTop(), this.kx);
                }
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public void ND() {
    }

    public void NE() {
    }

    public static final /* synthetic */ RoomsViewModel a(RoomListFragment roomListFragment) {
        RoomsViewModel roomsViewModel = roomListFragment.aHA;
        if (roomsViewModel == null) {
            kotlin.jvm.internal.h.lS("roomsViewModel");
        }
        return roomsViewModel;
    }

    public static final /* synthetic */ LastMessagesViewModel b(RoomListFragment roomListFragment) {
        LastMessagesViewModel lastMessagesViewModel = roomListFragment.aHB;
        if (lastMessagesViewModel == null) {
            kotlin.jvm.internal.h.lS("lastMessagesViewModel");
        }
        return lastMessagesViewModel;
    }

    public static final /* synthetic */ aj c(RoomListFragment roomListFragment) {
        aj ajVar = roomListFragment.aHz;
        if (ajVar == null) {
            kotlin.jvm.internal.h.lS("adapter");
        }
        return ajVar;
    }

    public static final /* synthetic */ sb d(RoomListFragment roomListFragment) {
        sb sbVar = roomListFragment.aID;
        if (sbVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return sbVar;
    }

    public static final /* synthetic */ ItemAnimator e(RoomListFragment roomListFragment) {
        ItemAnimator itemAnimator = roomListFragment.aHy;
        if (itemAnimator == null) {
            kotlin.jvm.internal.h.lS("itemAnimator");
        }
        return itemAnimator;
    }

    static {
        kotlin.jvm.internal.h.d(RoomListFragment.class.getSimpleName(), "RoomListFragment::class.java.simpleName");
    }

    public void onAttach(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof b)) {
            parentFragment = null;
        }
        b bVar = (b) parentFragment;
        if (bVar == null) {
            if (!(context instanceof b)) {
                context = null;
            }
            bVar = (b) context;
        }
        this.aIC = bVar;
    }

    public void onDetach() {
        super.onDetach();
        this.aIC = (b) null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        sb sbVar = (sb) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_room_list, viewGroup, false, 4, null);
        this.aID = sbVar;
        this.aFE = com.iqoption.analytics.b.aiV.Bf();
        FragmentActivity requireActivity = requireActivity();
        this.aHA = RoomsViewModel.aLC.Rs();
        this.aHB = LastMessagesViewModel.aKN.QY();
        SupportRoomViewModel RD = SupportRoomViewModel.aLR.RD();
        com.iqoption.chat.viewmodel.SearchRoomViewModel.a aVar = SearchRoomViewModel.aLG;
        kotlin.jvm.internal.h.d(requireActivity, "activity");
        SearchRoomViewModel f = aVar.f(requireActivity);
        RoomListFragment roomListFragment = this;
        LifecycleOwner lifecycleOwner = roomListFragment;
        WebSocketViewModel.aMd.h(requireActivity).RH().observe(lifecycleOwner, new c(roomListFragment, RD, this));
        com.iqoption.util.fragmentstack.e eVar = roomListFragment;
        ar.a(f.Ru(), eVar, (Observer) new d(this));
        InteractionViewModel e = InteractionViewModel.aKE.e(com.iqoption.core.ext.a.n(this));
        ar.a(e.QQ(), eVar, (Observer) new e(e, roomListFragment, this));
        ar.a(e.QR(), eVar, (Observer) new f(e, roomListFragment, this));
        ar.a(e.QS(), eVar, (Observer) new g(roomListFragment, this));
        com.iqoption.chat.d ba = com.iqoption.chat.d.aCK.ba(requireActivity);
        kotlin.jvm.a.b roomListFragment$onCreateView$$inlined$apply$lambda$6 = new RoomListFragment$onCreateView$$inlined$apply$lambda$6(this);
        LastMessagesViewModel lastMessagesViewModel = this.aHB;
        if (lastMessagesViewModel == null) {
            kotlin.jvm.internal.h.lS("lastMessagesViewModel");
        }
        this.aHz = new aj(ba, lifecycleOwner, roomListFragment$onCreateView$$inlined$apply$lambda$6, RD, lastMessagesViewModel, new RoomListFragment$onCreateView$$inlined$apply$lambda$7(this));
        aj ajVar = this.aHz;
        if (ajVar == null) {
            kotlin.jvm.internal.h.lS("adapter");
        }
        ajVar.c((m) new RoomListFragment$onCreateView$$inlined$apply$lambda$8(this));
        sbVar.bzb.setHasFixedSize(true);
        sbVar.bzb.addItemDecoration(new h(sbVar));
        RecyclerView recyclerView = sbVar.bzb;
        kotlin.jvm.internal.h.d(recyclerView, "chatList");
        ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        itemAnimator.setAddDuration(100);
        itemAnimator.setRemoveDuration(100);
        itemAnimator.setMoveDuration(150);
        if (itemAnimator == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.DefaultItemAnimator");
        }
        ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        kotlin.jvm.internal.h.d(itemAnimator, "chatList.itemAnimator.ap…ons = false\n            }");
        this.aHy = itemAnimator;
        return sbVar.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Builder builder = this.aFE;
        if (builder != null) {
            com.iqoption.analytics.b.aiV.a(builder);
        }
        RoomsViewModel roomsViewModel = this.aHA;
        if (roomsViewModel == null) {
            kotlin.jvm.internal.h.lS("roomsViewModel");
        }
        roomsViewModel.Rq();
        LastMessagesViewModel lastMessagesViewModel = this.aHB;
        if (lastMessagesViewModel == null) {
            kotlin.jvm.internal.h.lS("lastMessagesViewModel");
        }
        RoomsViewModel roomsViewModel2 = this.aHA;
        if (roomsViewModel2 == null) {
            kotlin.jvm.internal.h.lS("roomsViewModel");
        }
        lastMessagesViewModel.X((List) roomsViewModel2.Ro().getValue());
        KH();
    }
}
