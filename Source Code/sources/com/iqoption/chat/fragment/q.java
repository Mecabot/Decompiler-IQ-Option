package com.iqoption.chat.fragment;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.iqoption.chat.ChatActivity;
import com.iqoption.chat.component.aj;
import com.iqoption.chat.viewmodel.InteractionViewModel;
import com.iqoption.chat.viewmodel.LastMessagesViewModel;
import com.iqoption.chat.viewmodel.RoomsViewModel;
import com.iqoption.chat.viewmodel.SupportRoomViewModel;
import com.iqoption.chat.viewmodel.WebSocketViewModel;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.viewmodel.AnimViewModel;
import com.iqoption.d.op;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.n;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/chat/fragment/MicroRoomListFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "adapter", "Lcom/iqoption/chat/component/RoomsAdapter;", "binding", "Lcom/iqoption/databinding/FragmentMicroRoomListBinding;", "isCustomAnimationsEnabled", "", "()Z", "itemAnimator", "Landroid/support/v7/widget/RecyclerView$ItemAnimator;", "lastMessagesViewModel", "Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "roomsViewModel", "Lcom/iqoption/chat/viewmodel/RoomsViewModel;", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MicroRoomListFragment.kt */
public final class q extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = "com.iqoption.chat.fragment.q";
    public static final a aHC = new a();
    private RoomsViewModel aHA;
    private LastMessagesViewModel aHB;
    private op aHx;
    private ItemAnimator aHy;
    private aj aHz;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R$\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, aXE = {"Lcom/iqoption/chat/fragment/MicroRoomListFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/MicroRoomListFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MicroRoomListFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return q.TAG;
        }

        public final q Qa() {
            return new q();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ q this$0;

        public b(q qVar, FragmentActivity fragmentActivity) {
            this.this$0 = qVar;
            this.$activity$inlined = fragmentActivity;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            ChatActivity.aCF.aZ(com.iqoption.core.ext.a.m(this.this$0));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$3"})
    /* compiled from: LiveDatas.kt */
    public static final class c<T> implements Observer<T> {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ q aHD;
        final /* synthetic */ SupportRoomViewModel aHE;
        final /* synthetic */ q this$0;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000®\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$2", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$3$lambda$1"})
        /* compiled from: LiveDatas.kt */
        /* renamed from: com.iqoption.chat.fragment.q$c$1 */
        public static final class AnonymousClass1<T> implements Observer<T> {
            final /* synthetic */ c aHF;

            @i(aXC = {1, 1, 11}, aXD = {"\u0000ª\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$2$lambda$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$3$lambda$1$1"})
            /* compiled from: LiveDatas.kt */
            /* renamed from: com.iqoption.chat.fragment.q$c$1$1 */
            public static final class AnonymousClass1<T> implements Observer<T> {
                final /* synthetic */ AnonymousClass1 aHG;

                public AnonymousClass1(AnonymousClass1 anonymousClass1) {
                    this.aHG = anonymousClass1;
                }

                public final void onChanged(T t) {
                    if (t != null) {
                        List list = (List) t;
                        q.a(this.aHG.aHF.this$0).Rp();
                        q.b(this.aHG.aHF.this$0).W(list);
                        for (Object next : list) {
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
                            this.aHG.aHF.aHE.fX(nVar.getId());
                        }
                        q.c(this.aHG.aHF.this$0).N(list);
                    }
                }
            }

            public AnonymousClass1(c cVar) {
                this.aHF = cVar;
            }

            public final void onChanged(T t) {
                if (t == null) {
                    return;
                }
                if (((Boolean) t).booleanValue()) {
                    q.a(this.aHF.this$0).Ro().observe(this.aHF.aHD, new AnonymousClass1(this));
                    return;
                }
                q.a(this.aHF.this$0).Rq();
                q.b(this.aHF.this$0).X((List) q.a(this.aHF.this$0).Ro().getValue());
            }
        }

        public c(q qVar, SupportRoomViewModel supportRoomViewModel, q qVar2, FragmentActivity fragmentActivity) {
            this.aHD = qVar;
            this.aHE = supportRoomViewModel;
            this.this$0 = qVar2;
            this.$activity$inlined = fragmentActivity;
        }

        public final void onChanged(T t) {
            if (t != null && !((Boolean) t).booleanValue()) {
                WebSocketViewModel.aMd.h(this.$activity$inlined).RH().observe(this.aHD, new AnonymousClass1(this));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000®\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$4", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$let$lambda$1"})
    /* compiled from: LiveDatas.kt */
    public static final class d<T> implements Observer<T> {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ q aHD;
        final /* synthetic */ InteractionViewModel aHH;
        final /* synthetic */ q this$0;

        public d(InteractionViewModel interactionViewModel, q qVar, q qVar2, FragmentActivity fragmentActivity) {
            this.aHH = interactionViewModel;
            this.aHD = qVar;
            this.this$0 = qVar2;
            this.$activity$inlined = fragmentActivity;
        }

        public final void onChanged(T t) {
            if (t != null && ((Boolean) t).booleanValue()) {
                q.c(this.this$0).notifyDataSetChanged();
                this.aHH.QT();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000®\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$5", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$let$lambda$2"})
    /* compiled from: LiveDatas.kt */
    public static final class e<T> implements Observer<T> {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ q aHD;
        final /* synthetic */ InteractionViewModel aHH;
        final /* synthetic */ q this$0;

        public e(InteractionViewModel interactionViewModel, q qVar, q qVar2, FragmentActivity fragmentActivity) {
            this.aHH = interactionViewModel;
            this.aHD = qVar;
            this.this$0 = qVar2;
            this.$activity$inlined = fragmentActivity;
        }

        public final void onChanged(T t) {
            if (t != null) {
                Pair pair = (Pair) t;
                if (((Boolean) pair.getFirst()).booleanValue()) {
                    int fL = q.c(this.this$0).fL((String) pair.aXF());
                    if (fL > -1) {
                        q.c(this.this$0).notifyItemChanged(fL);
                        this.aHH.QU();
                    }
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000®\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$observe$6", "com/iqoption/chat/fragment/MicroRoomListFragment$$special$$inlined$let$lambda$3"})
    /* compiled from: LiveDatas.kt */
    public static final class f<T> implements Observer<T> {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ q aHD;
        final /* synthetic */ q this$0;

        public f(q qVar, q qVar2, FragmentActivity fragmentActivity) {
            this.aHD = qVar;
            this.this$0 = qVar2;
            this.$activity$inlined = fragmentActivity;
        }

        public final void onChanged(T t) {
            if (t != null) {
                boolean booleanValue = ((Boolean) t).booleanValue();
                RecyclerView recyclerView = q.d(this.this$0).bzb;
                h.d(recyclerView, "binding.chatList");
                recyclerView.setItemAnimator(booleanValue ? null : q.e(this.this$0));
            }
        }
    }

    public boolean KE() {
        return true;
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ RoomsViewModel a(q qVar) {
        RoomsViewModel roomsViewModel = qVar.aHA;
        if (roomsViewModel == null) {
            h.lS("roomsViewModel");
        }
        return roomsViewModel;
    }

    public static final /* synthetic */ LastMessagesViewModel b(q qVar) {
        LastMessagesViewModel lastMessagesViewModel = qVar.aHB;
        if (lastMessagesViewModel == null) {
            h.lS("lastMessagesViewModel");
        }
        return lastMessagesViewModel;
    }

    public static final /* synthetic */ aj c(q qVar) {
        aj ajVar = qVar.aHz;
        if (ajVar == null) {
            h.lS("adapter");
        }
        return ajVar;
    }

    public static final /* synthetic */ op d(q qVar) {
        op opVar = qVar.aHx;
        if (opVar == null) {
            h.lS("binding");
        }
        return opVar;
    }

    public static final /* synthetic */ ItemAnimator e(q qVar) {
        ItemAnimator itemAnimator = qVar.aHy;
        if (itemAnimator == null) {
            h.lS("itemAnimator");
        }
        return itemAnimator;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.aHx = (op) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_micro_room_list, viewGroup, false, 4, null);
        FragmentActivity n = com.iqoption.core.ext.a.n(this);
        this.aHA = RoomsViewModel.aLC.Rs();
        this.aHB = LastMessagesViewModel.aKN.QY();
        op opVar = this.aHx;
        if (opVar == null) {
            h.lS("binding");
        }
        ImageView imageView = opVar.axz;
        h.d(imageView, "btnExpand");
        imageView.setOnClickListener(new b(this, n));
        SupportRoomViewModel RD = SupportRoomViewModel.aLR.RD();
        q qVar = this;
        LifecycleOwner lifecycleOwner = qVar;
        AnimViewModel.bcm.s(qVar).YZ().observe(lifecycleOwner, new c(qVar, RD, this, n));
        InteractionViewModel e = InteractionViewModel.aKE.e(com.iqoption.core.ext.a.n(this));
        e.QQ().observe(lifecycleOwner, new d(e, qVar, this, n));
        e.QR().observe(lifecycleOwner, new e(e, qVar, this, n));
        e.QS().observe(lifecycleOwner, new f(qVar, this, n));
        com.iqoption.chat.d ba = com.iqoption.chat.d.aCK.ba(n);
        kotlin.jvm.a.b microRoomListFragment$onCreateView$$inlined$apply$lambda$6 = new MicroRoomListFragment$onCreateView$$inlined$apply$lambda$6(this, n);
        LastMessagesViewModel lastMessagesViewModel = this.aHB;
        if (lastMessagesViewModel == null) {
            h.lS("lastMessagesViewModel");
        }
        this.aHz = new aj(ba, lifecycleOwner, microRoomListFragment$onCreateView$$inlined$apply$lambda$6, RD, lastMessagesViewModel, new MicroRoomListFragment$onCreateView$$inlined$apply$lambda$7(this, n));
        aj ajVar = this.aHz;
        if (ajVar == null) {
            h.lS("adapter");
        }
        ajVar.c((m) new MicroRoomListFragment$onCreateView$$inlined$apply$lambda$8(this, n));
        opVar.bzb.setHasFixedSize(true);
        opVar.bzb.addItemDecoration(new com.iqoption.widget.h(com.iqoption.core.ext.a.c((ViewDataBinding) opVar, (int) R.dimen.dp8)));
        RecyclerView recyclerView = opVar.bzb;
        h.d(recyclerView, "chatList");
        ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        itemAnimator.setAddDuration(100);
        itemAnimator.setRemoveDuration(100);
        itemAnimator.setMoveDuration(150);
        if (itemAnimator == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.DefaultItemAnimator");
        }
        ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        h.d(itemAnimator, "chatList.itemAnimator.ap…ons = false\n            }");
        this.aHy = itemAnimator;
        op opVar2 = this.aHx;
        if (opVar2 == null) {
            h.lS("binding");
        }
        return opVar2.getRoot();
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        Animation onCreateAnimation = super.onCreateAnimation(i, z, i2);
        if (onCreateAnimation != null && z) {
            AnimViewModel.bcm.s(this).a(onCreateAnimation);
        }
        return onCreateAnimation;
    }
}
