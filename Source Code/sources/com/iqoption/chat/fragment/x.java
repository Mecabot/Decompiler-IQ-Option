package com.iqoption.chat.fragment;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.chat.component.ac;
import com.iqoption.chat.component.aw;
import com.iqoption.chat.component.y;
import com.iqoption.chat.viewmodel.InteractionViewModel;
import com.iqoption.chat.viewmodel.RoomViewModel;
import com.iqoption.d.rz;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.util.be;
import com.iqoption.util.bg;
import com.iqoption.util.t;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002IJB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020\u0014H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\bH\u0016J\b\u0010,\u001a\u00020\bH\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020(H\u0016J\b\u00106\u001a\u00020(H\u0016J\b\u00107\u001a\u00020(H\u0016J-\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:2\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0<2\u0006\u0010=\u001a\u00020>H\u0016¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u000204H\u0016J\b\u0010B\u001a\u00020(H\u0016J\u001a\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010E\u001a\u00020(H\u0002J\b\u0010F\u001a\u00020(H\u0002J)\u0010G\u001a\u00020\b*\u00020\u001b2\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0<2\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010HR\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000¨\u0006K"}, aXE = {"Lcom/iqoption/chat/fragment/RoomFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "adapter", "Lcom/iqoption/chat/component/MessagesAdapter;", "animationFinished", "Landroid/arch/lifecycle/MutableLiveData;", "", "binding", "Lcom/iqoption/databinding/FragmentRoomBinding;", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "interactionListener", "Lcom/iqoption/chat/fragment/RoomFragment$InteractionListener;", "interactionViewModel", "Lcom/iqoption/chat/viewmodel/InteractionViewModel;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "rateSupportLastHandledTime", "", "readMessageCommand", "Lcom/iqoption/util/DelayedCommand;", "resourcer", "Lcom/iqoption/chat/Resourcer;", "roomId", "Lkotlin/Lazy;", "", "kotlin.jvm.PlatformType", "roomType", "Lcom/iqoption/microservice/chat/ChatRoomType;", "scrollToFirst", "sendLayoutDelegate", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate;", "topBarDelegate", "Lcom/iqoption/chat/fragment/RoomTopBarDelegate;", "viewModel", "Lcom/iqoption/chat/viewmodel/RoomViewModel;", "getAnimationDuration", "onAttach", "", "context", "Landroid/content/Context;", "onBackPressed", "onClose", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDetach", "onHideAnimation", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSaveInstanceState", "outState", "onShowAnimation", "onViewCreated", "view", "pickAttachments", "scrollToEnd", "isGranted", "(Ljava/lang/String;[Ljava/lang/String;[I)Z", "Companion", "InteractionListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomFragment.kt */
public final class x extends com.iqoption.fragment.base.b implements com.iqoption.view.e.a {
    private static final String TAG = "com.iqoption.chat.fragment.x";
    public static final a aIp = new a();
    private g aHK;
    private ac aHa;
    private final kotlin.d<String> aIb = g.f(new RoomFragment$roomId$1(this));
    private final kotlin.d<ChatRoomType> aIc = g.f(new RoomFragment$roomType$1(this));
    private b aId;
    private com.iqoption.chat.d aIe;
    private RoomViewModel aIf;
    private InteractionViewModel aIg;
    private rz aIh;
    private LinearLayoutManager aIi;
    private y aIj;
    private u aIk;
    private boolean aIl;
    private final t aIm = new t(new q(this));
    private long aIn;
    private final MutableLiveData<Boolean> aIo = new MutableLiveData();
    private HashMap atz;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, aXE = {"Lcom/iqoption/chat/fragment/RoomFragment$Companion;", "", "()V", "ARG_CHAT_ROOM_ID", "", "ARG_CHAT_ROOM_TYPE", "KEY_RATE_SUPPORT_LAST_HANDLED_TIME", "KEY_SEND_LAYOUT_DELEGATE", "OPTION_COPY", "OPTION_DOWNLOAD", "OPTION_REPLY", "OPTION_REPLY_WITH_TEXT", "REQUEST_PERMISSION_ATTACHMENTS", "", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/chat/fragment/RoomFragment;", "roomId", "type", "Lcom/iqoption/microservice/chat/ChatRoomType;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return x.TAG;
        }

        public final x a(String str, ChatRoomType chatRoomType) {
            x xVar = new x();
            Bundle bundle = new Bundle();
            if (str == null || chatRoomType == null) {
                bundle.putString("arg.chatRoomType", ChatRoomType.SUPPORT.name());
            } else {
                bundle.putString("arg.chatRoomId", str);
                bundle.putString("arg.chatRoomType", chatRoomType.name());
            }
            xVar.setArguments(bundle);
            return xVar;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: RoomFragment.kt */
    static final class d implements Runnable {
        final /* synthetic */ x this$0;

        d(x xVar) {
            this.this$0 = xVar;
        }

        public final void run() {
            this.this$0.aIo.postValue(Boolean.valueOf(true));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$10$1"})
    /* compiled from: RoomFragment.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ x this$0;

        f(x xVar, FragmentActivity fragmentActivity) {
            this.this$0 = xVar;
            this.$activity$inlined = fragmentActivity;
        }

        public final void onClick(View view) {
            this.$activity$inlined.onBackPressed();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$10$2"})
    /* compiled from: RoomFragment.kt */
    static final class g implements OnClickListener {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ x this$0;

        g(x xVar, FragmentActivity fragmentActivity) {
            this.this$0 = xVar;
            this.$activity$inlined = fragmentActivity;
        }

        public final void onClick(View view) {
            this.this$0.Ql();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"com/iqoption/chat/fragment/RoomFragment$onViewCreated$10$BadgeController", "", "badge", "Landroid/view/View;", "(Landroid/view/View;)V", "getBadge", "()Landroid/view/View;", "handler", "Landroid/os/Handler;", "hideCommand", "Ljava/lang/Runnable;", "shown", "", "hide", "", "show", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class l {
        private final Runnable aIr = new a(this);
        private final View aIs;
        private boolean aeP;
        private final Handler handler = new Handler();

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: RoomFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ l aIt;

            a(l lVar) {
                this.aIt = lVar;
            }

            public final void run() {
                this.aIt.Qo().animate().alpha(0.0f).setDuration(100).start();
            }
        }

        public l(View view) {
            kotlin.jvm.internal.h.e(view, "badge");
            this.aIs = view;
            this.aeP = this.aIs.getAlpha() == 1.0f;
        }

        public final View Qo() {
            return this.aIs;
        }

        public final void show() {
            if (!this.aeP) {
                this.aeP = true;
                this.aIs.animate().alpha(1.0f).setDuration(100).start();
                this.handler.removeCallbacks(this.aIr);
            }
        }

        public final void hide() {
            if (this.aeP) {
                this.aeP = false;
                this.handler.removeCallbacks(this.aIr);
                this.handler.postDelayed(this.aIr, 500);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: RoomFragment.kt */
    static final class q implements Runnable {
        final /* synthetic */ x this$0;

        q(x xVar) {
            this.this$0 = xVar;
        }

        public final void run() {
            x.c(this.this$0).Rk();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, aXE = {"Lcom/iqoption/chat/fragment/RoomFragment$InteractionListener;", "Lcom/iqoption/view/BackController;", "onCloseChat", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public interface b extends com.iqoption.view.e {
        void Op();
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$messageInteractor$1", "Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;", "Lcom/iqoption/microservice/chat/ChatMessage;", "onOptionClick", "", "name", "", "label", "arg", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class e implements com.iqoption.chat.fragment.o.b<com.iqoption.microservice.chat.g> {
        final /* synthetic */ ac receiver$0;
        final /* synthetic */ x this$0;

        e(ac acVar, x xVar) {
            this.receiver$0 = acVar;
            this.this$0 = xVar;
        }

        public void a(String str, String str2, com.iqoption.microservice.chat.g gVar) {
            kotlin.jvm.internal.h.e(str, "name");
            kotlin.jvm.internal.h.e(str2, PlusShare.KEY_CALL_TO_ACTION_LABEL);
            kotlin.jvm.internal.h.e(gVar, "arg");
            int hashCode = str.hashCode();
            u g;
            if (hashCode != -461908380) {
                if (hashCode != -404201138) {
                    if (hashCode == 368221233 && str.equals("option.reply")) {
                        g = this.this$0.aIk;
                        if (g != null) {
                            g.a(gVar, false);
                        }
                    }
                } else if (str.equals("option.copy") && be.ag("Message", gVar.getText())) {
                    com.iqoption.app.a.b.eP(this.receiver$0.getString(R.string.message_copied, new Object[0]));
                }
            } else if (str.equals("option.replyWithText")) {
                g = this.this$0.aIk;
                if (g != null) {
                    g.a(gVar, true);
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/RoomFragment$onViewCreated$10$4", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class h extends OnScrollListener {
        final /* synthetic */ FragmentActivity $activity$inlined;
        final /* synthetic */ x this$0;

        h(x xVar, FragmentActivity fragmentActivity) {
            this.this$0 = xVar;
            this.$activity$inlined = fragmentActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            kotlin.jvm.internal.h.e(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
            this.this$0.aIl = x.o(this.this$0).findFirstVisibleItemPosition() == 0;
            if (x.j(this.this$0).getItemCount() > 0 && x.c(this.this$0).Rf()) {
                if ((x.j(this.this$0).getItemCount() - 1) - recyclerView.getChildAdapterPosition(recyclerView.findChildViewUnder(0.0f, 0.0f)) <= 5) {
                    x.c(this.this$0).Rl();
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$attachmentInteractor$1", "Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;", "Lkotlin/Pair;", "Lcom/iqoption/microservice/chat/ChatMessage;", "Lcom/iqoption/microservice/chat/ChatAttachment;", "onOptionClick", "", "name", "", "label", "arg", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class i implements com.iqoption.chat.fragment.o.b<Pair<? extends com.iqoption.microservice.chat.g, ? extends com.iqoption.microservice.chat.a>> {
        final /* synthetic */ ac receiver$0;
        final /* synthetic */ x this$0;

        i(ac acVar, x xVar) {
            this.receiver$0 = acVar;
            this.this$0 = xVar;
        }

        public void a(String str, String str2, Pair<com.iqoption.microservice.chat.g, com.iqoption.microservice.chat.a> pair) {
            kotlin.jvm.internal.h.e(str, "name");
            kotlin.jvm.internal.h.e(str2, PlusShare.KEY_CALL_TO_ACTION_LABEL);
            kotlin.jvm.internal.h.e(pair, "arg");
            int hashCode = str.hashCode();
            if (hashCode != -2105154079) {
                if (hashCode == 368221233 && str.equals("option.reply")) {
                    u g = this.this$0.aIk;
                    if (g != null) {
                        g.a((com.iqoption.microservice.chat.g) pair.getFirst(), false);
                    }
                }
            } else if (str.equals("option.download")) {
                Object systemService = this.receiver$0.getContext().getSystemService("download");
                if (systemService == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
                }
                DownloadManager downloadManager = (DownloadManager) systemService;
                Uri parse = Uri.parse(((com.iqoption.microservice.chat.a) pair.aXF()).getUrl());
                Request request = new Request(parse);
                request.setNotificationVisibility(1);
                Context context = this.receiver$0.getContext();
                String str3 = Environment.DIRECTORY_DOWNLOADS;
                kotlin.jvm.internal.h.d(parse, "uri");
                request.setDestinationInExternalFilesDir(context, str3, parse.getLastPathSegment());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ssid=");
                RequestManager atO = RequestManager.atO();
                kotlin.jvm.internal.h.d(atO, "RequestManager.getInstance()");
                stringBuilder.append(atO.atS());
                request.addRequestHeader("Cookie", stringBuilder.toString());
                downloadManager.enqueue(request);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$4", "Lcom/iqoption/chat/component/MessagesAdapter$RatingChangeListener;", "onRatingChanged", "", "rating", "", "message", "Lcom/iqoption/microservice/chat/ChatMessage;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class j implements com.iqoption.chat.component.ac.b {
        final /* synthetic */ x this$0;

        j(x xVar) {
            this.this$0 = xVar;
        }

        public void a(int i, com.iqoption.microservice.chat.g gVar) {
            kotlin.jvm.internal.h.e(gVar, "message");
            Object obj = gVar.arh().arD() > 0 ? 1 : null;
            if (obj != null && i == 0) {
                x.j(this.this$0).fJ(gVar.getId());
            } else if (obj != null || i == 5) {
                RoomViewModel.a(x.c(this.this$0), gVar.getId(), i, null, 4, null);
            } else {
                FragmentManager p = com.iqoption.core.ext.a.p(this.this$0);
                FragmentTransaction beginTransaction = p.beginTransaction();
                kotlin.jvm.internal.h.d(beginTransaction, "ft");
                beginTransaction.add(R.id.dialogLayer, j.aGf.a(i, new RoomFragment$onViewCreated$$inlined$apply$lambda$6$1(this, i, gVar), new RoomFragment$onViewCreated$$inlined$apply$lambda$6$2(this, i, gVar)), j.aGf.Ll());
                beginTransaction.addToBackStack(j.aGf.Ll());
                beginTransaction.commitAllowingStateLoss();
                p.executePendingTransactions();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, aXE = {"com/iqoption/chat/fragment/RoomFragment$onViewCreated$10$5", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class k extends OnScrollListener {
        final /* synthetic */ l aIq;

        k(l lVar) {
            this.aIq = lVar;
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i2 != 0) {
                this.aIq.show();
            }
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                this.aIq.hide();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: RoomFragment.kt */
    static final class m<T> implements Observer<Boolean> {
        final /* synthetic */ x this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "room", "Lcom/iqoption/microservice/chat/ChatRoom;", "call"})
        /* compiled from: RoomFragment.kt */
        /* renamed from: com.iqoption.chat.fragment.x$m$2 */
        static final class AnonymousClass2<T> implements com.iqoption.util.ag.e<V> {
            final /* synthetic */ m aIv;

            AnonymousClass2(m mVar) {
                this.aIv = mVar;
            }

            /* renamed from: h */
            public final void aU(final com.iqoption.microservice.chat.n nVar) {
                kotlin.jvm.internal.h.e(nVar, "room");
                com.iqoption.core.d.a.aSe.execute(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 aIw;

                    public final void run() {
                        x.c(this.aIw.aIv.this$0).b(nVar.getId(), nVar.Qh());
                        x.c(this.aIw.aIv.this$0).Rn();
                    }
                });
            }
        }

        m(x xVar) {
            this.this$0 = xVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (!kotlin.jvm.internal.h.E(bool, Boolean.valueOf(true))) {
                return;
            }
            if (kotlin.jvm.internal.h.E((String) this.this$0.aIb.getValue(), "unknown")) {
                ag.a(ag.a(com.iqoption.chat.repository.c.aJA.Qq(), (com.google.common.base.d) AnonymousClass1.aIu), (com.iqoption.util.ag.e) new AnonymousClass2(this));
                return;
            }
            RoomViewModel c = x.c(this.this$0);
            Object value = this.this$0.aIb.getValue();
            kotlin.jvm.internal.h.d(value, "roomId.value");
            c.b((String) value, (ChatRoomType) this.this$0.aIc.getValue());
            x.c(this.this$0).Rn();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "chatState", "Lcom/iqoption/microservice/chat/ChatState;", "onChanged"})
    /* compiled from: RoomFragment.kt */
    static final class n<T> implements Observer<com.iqoption.microservice.chat.o> {
        final /* synthetic */ Bundle aIy;
        final /* synthetic */ x this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "core_release"})
        /* compiled from: AndroidExtensions.kt */
        public static final class a implements OnPreDrawListener {
            final /* synthetic */ View aGz;
            final /* synthetic */ int aIA;
            final /* synthetic */ n aIz;

            public a(View view, n nVar, int i) {
                this.aGz = view;
                this.aIz = nVar;
                this.aIA = i;
            }

            public boolean onPreDraw() {
                this.aGz.getViewTreeObserver().removeOnPreDrawListener(this);
                FrameLayout frameLayout = x.b(this.aIz.this$0).bBO;
                kotlin.jvm.internal.h.d(frameLayout, "binding.bottomBarLayout");
                int height = frameLayout.getHeight();
                if (this.aIA == height) {
                    return false;
                }
                RecyclerView recyclerView = x.b(this.aIz.this$0).bBQ;
                recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), com.iqoption.core.ext.a.f(recyclerView, R.dimen.dp8) + height);
                recyclerView.requestLayout();
                return true;
            }
        }

        n(x xVar, Bundle bundle) {
            this.this$0 = xVar;
            this.aIy = bundle;
        }

        /* JADX WARNING: Missing block: B:3:0x000e, code:
            if (r1 != null) goto L_0x002b;
     */
        /* renamed from: b */
        public final void onChanged(com.iqoption.microservice.chat.o r6) {
            /*
            r5 = this;
            r0 = r5.this$0;
            r1 = r5.this$0;
            r1 = r1.aIk;
            if (r1 == 0) goto L_0x0011;
        L_0x000a:
            r1 = r1.a(r6);
            if (r1 == 0) goto L_0x0011;
        L_0x0010:
            goto L_0x002b;
        L_0x0011:
            r1 = com.iqoption.chat.fragment.u.aHW;
            r2 = r5.this$0;
            r2 = com.iqoption.chat.fragment.x.h(r2);
            r3 = r5.this$0;
            r3 = r3.aIc;
            r3 = r3.getValue();
            r3 = (com.iqoption.microservice.chat.ChatRoomType) r3;
            r4 = r5.aIy;
            r1 = r1.a(r2, r3, r6, r4);
        L_0x002b:
            r0.aIk = r1;
            r6 = r5.this$0;
            r6 = com.iqoption.chat.fragment.x.b(r6);
            r6 = r6.bBO;
            r0 = "binding.bottomBarLayout";
            kotlin.jvm.internal.h.d(r6, r0);
            r6 = r6.getHeight();
            r0 = r5.this$0;
            r0 = com.iqoption.chat.fragment.x.b(r0);
            r0 = r0.bBO;
            r1 = "binding.bottomBarLayout";
            kotlin.jvm.internal.h.d(r0, r1);
            r0 = (android.view.View) r0;
            r1 = r0.getViewTreeObserver();
            r2 = new com.iqoption.chat.fragment.x$n$a;
            r2.<init>(r0, r5, r6);
            r2 = (android.view.ViewTreeObserver.OnPreDrawListener) r2;
            r1.addOnPreDrawListener(r2);
            r6 = r5.this$0;
            r6 = r6.getResources();
            r6 = com.iqoption.util.be.a(r6);
            if (r6 == 0) goto L_0x0071;
        L_0x0068:
            r6 = r5.this$0;
            r6 = com.iqoption.chat.fragment.x.h(r6);
            r6.PD();
        L_0x0071:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.fragment.x.n.b(com.iqoption.microservice.chat.o):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatRoom;", "onChanged"})
    /* compiled from: RoomFragment.kt */
    static final class o<T> implements Observer<com.iqoption.microservice.chat.n> {
        final /* synthetic */ x this$0;

        o(x xVar) {
            this.this$0 = xVar;
        }

        /* renamed from: i */
        public final void onChanged(com.iqoption.microservice.chat.n nVar) {
            x.i(this.this$0).g(nVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lcom/iqoption/chat/component/MessageAdapterItem;", "Landroid/support/v7/util/DiffUtil$DiffResult;", "onChanged"})
    /* compiled from: RoomFragment.kt */
    static final class p<T> implements Observer<Pair<? extends List<? extends y>, ? extends DiffResult>> {
        final /* synthetic */ AtomicBoolean aIB;
        final /* synthetic */ x this$0;

        p(x xVar, AtomicBoolean atomicBoolean) {
            this.this$0 = xVar;
            this.aIB = atomicBoolean;
        }

        /* renamed from: a */
        public final void onChanged(Pair<? extends List<? extends y>, ? extends DiffResult> pair) {
            if (pair != null) {
                x.j(this.this$0).setLoading(false);
                x.j(this.this$0).b((List) pair.getFirst(), (DiffResult) pair.aXF());
                x.b(this.this$0).bBQ.invalidateItemDecorations();
                if (this.aIB.get()) {
                    this.this$0.aIm.ch(2000);
                    this.aIB.set(false);
                } else if (this.this$0.aIl) {
                    x.b(this.this$0).bBQ.b(0);
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, aXE = {"com/iqoption/chat/fragment/RoomFragment$onAttach$2", "Lcom/iqoption/chat/fragment/DelegateContext;", "activity", "Landroid/support/v4/app/FragmentActivity;", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "bottomBarLayout", "Landroid/widget/FrameLayout;", "getBottomBarLayout", "()Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getInflater", "()Landroid/view/LayoutInflater;", "topBarLayout", "getTopBarLayout", "viewModel", "Lcom/iqoption/chat/viewmodel/RoomViewModel;", "getViewModel", "()Lcom/iqoption/chat/viewmodel/RoomViewModel;", "getLifecycle", "Landroid/arch/lifecycle/Lifecycle;", "hideKeyboard", "", "openAttachmentPicker", "openCantSendReasonDialog", "message", "", "showKeyboard", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomFragment.kt */
    public static final class c implements g {
        final /* synthetic */ x this$0;

        c(x xVar) {
            this.this$0 = xVar;
        }

        public String a(@PluralsRes int i, int i2, Object... objArr) {
            kotlin.jvm.internal.h.e(objArr, "formatArgs");
            return com.iqoption.chat.fragment.g.a.a(this, i, i2, objArr);
        }

        public int dr(@DimenRes int i) {
            return com.iqoption.chat.fragment.g.a.a(this, i);
        }

        public float ds(@DimenRes int i) {
            return com.iqoption.chat.fragment.g.a.b(this, i);
        }

        public int getColor(@ColorRes int i) {
            return com.iqoption.chat.fragment.g.a.c(this, i);
        }

        public Drawable getDrawable(@DrawableRes int i) {
            return com.iqoption.chat.fragment.g.a.d(this, i);
        }

        public String getString(@StringRes int i, Object... objArr) {
            kotlin.jvm.internal.h.e(objArr, "formatArgs");
            return com.iqoption.chat.fragment.g.a.a(this, i, objArr);
        }

        public Context getContext() {
            return com.iqoption.core.ext.a.m(this.this$0);
        }

        public FragmentActivity getActivity() {
            return com.iqoption.core.ext.a.n(this.this$0);
        }

        /* renamed from: Qm */
        public FrameLayout PA() {
            return x.b(this.this$0).bBS;
        }

        /* renamed from: Qn */
        public FrameLayout PB() {
            return x.b(this.this$0).bBO;
        }

        public RoomViewModel PC() {
            return x.c(this.this$0);
        }

        public Lifecycle getLifecycle() {
            return this.this$0.getLifecycle();
        }

        public void G(View view) {
            kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
            am.b((Context) getActivity(), view);
        }

        public void PD() {
            am.n(getActivity());
        }

        public void n(CharSequence charSequence) {
            kotlin.jvm.internal.h.e(charSequence, "message");
            FragmentManager p = com.iqoption.core.ext.a.p(this.this$0);
            p.beginTransaction().add(R.id.dialogLayer, d.aFG.m(charSequence), d.aFG.Ll()).addToBackStack(d.aFG.Ll()).commit();
            p.executePendingTransactions();
        }

        public void PE() {
            if (com.iqoption.core.ext.a.go("android.permission.READ_EXTERNAL_STORAGE")) {
                this.this$0.Qk();
            } else {
                this.this$0.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public long getAnimationDuration() {
        return 300;
    }

    public static final /* synthetic */ rz b(x xVar) {
        rz rzVar = xVar.aIh;
        if (rzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return rzVar;
    }

    public static final /* synthetic */ RoomViewModel c(x xVar) {
        RoomViewModel roomViewModel = xVar.aIf;
        if (roomViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return roomViewModel;
    }

    public static final /* synthetic */ g h(x xVar) {
        g gVar = xVar.aHK;
        if (gVar == null) {
            kotlin.jvm.internal.h.lS("delegateContext");
        }
        return gVar;
    }

    public static final /* synthetic */ y i(x xVar) {
        y yVar = xVar.aIj;
        if (yVar == null) {
            kotlin.jvm.internal.h.lS("topBarDelegate");
        }
        return yVar;
    }

    public static final /* synthetic */ ac j(x xVar) {
        ac acVar = xVar.aHa;
        if (acVar == null) {
            kotlin.jvm.internal.h.lS("adapter");
        }
        return acVar;
    }

    public static final /* synthetic */ LinearLayoutManager o(x xVar) {
        LinearLayoutManager linearLayoutManager = xVar.aIi;
        if (linearLayoutManager == null) {
            kotlin.jvm.internal.h.lS("layoutManager");
        }
        return linearLayoutManager;
    }

    static {
        kotlin.jvm.internal.h.d(x.class.getName(), "RoomFragment::class.java.name");
    }

    public void ND() {
        rz rzVar = this.aIh;
        if (rzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View root = rzVar.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.root");
        root.setAlpha(0.0f);
        rzVar = this.aIh;
        if (rzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        root = rzVar.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.root");
        root.setTranslationX(eN(R.dimen.dp24));
        rzVar = this.aIh;
        if (rzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        rzVar.getRoot().animate().translationX(0.0f).alpha(1.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).withEndAction(new d(this)).start();
    }

    public void NE() {
        rz rzVar = this.aIh;
        if (rzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        rzVar.getRoot().animate().translationX(eN(R.dimen.dp24)).alpha(0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).start();
    }

    public void onAttach(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        super.onAttach(context);
        b bVar = (b) context;
        bVar.a(this);
        this.aId = bVar;
        this.aIe = com.iqoption.chat.d.aCK.ba(context);
        this.aHK = new c(this);
    }

    public void onDetach() {
        super.onDetach();
        b bVar = this.aId;
        if (bVar != null) {
            bVar.b(this);
        }
        this.aId = (b) null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        rz rzVar = (rz) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_room, viewGroup, false, 4, null);
        this.aIh = rzVar;
        return rzVar.getRoot();
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        String str = "key.sendLayoutDelegate";
        u uVar = this.aIk;
        bundle.putParcelable(str, uVar != null ? uVar.Qe() : null);
        bundle.putLong("key.rateSupportLastHandledTime", this.aIn);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity n = com.iqoption.core.ext.a.n(this);
        n.getWindow().setSoftInputMode(16);
        if (be.a(getResources())) {
            g gVar = this.aHK;
            if (gVar == null) {
                kotlin.jvm.internal.h.lS("delegateContext");
            }
            gVar.PD();
        }
        if (bundle != null) {
            this.aIn = bundle.getLong("key.rateSupportLastHandledTime");
            this.aIo.setValue(Boolean.valueOf(true));
        }
        InteractionViewModel e = InteractionViewModel.aKE.e(com.iqoption.core.ext.a.n(this));
        e.QV();
        kotlin.jvm.internal.h.d(e, "InteractionViewModel.get(act).apply { openRoom() }");
        this.aIg = e;
        RoomViewModel j = RoomViewModel.aLo.j(this);
        kotlin.jvm.internal.h.d(j, "RoomViewModel.get(this)");
        this.aIf = j;
        this.aIo.observe(this, new m(this));
        x xVar = this;
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        RoomViewModel roomViewModel = this.aIf;
        if (roomViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = xVar;
        roomViewModel.Qs().observe(lifecycleOwner, new n(this, bundle));
        RoomViewModel roomViewModel2 = this.aIf;
        if (roomViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        roomViewModel2.Ra().observe(lifecycleOwner, new o(this));
        roomViewModel2 = this.aIf;
        if (roomViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        roomViewModel2.Rb().observe(lifecycleOwner, new p(this, atomicBoolean));
        roomViewModel2 = this.aIf;
        if (roomViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        roomViewModel2.Rd().observe(lifecycleOwner, new aw(new RoomFragment$onViewCreated$7(this), new RoomFragment$onViewCreated$8(this)));
        com.iqoption.chat.fragment.y.a aVar = y.aIM;
        ChatRoomType chatRoomType = (ChatRoomType) this.aIc.getValue();
        g gVar2 = this.aHK;
        if (gVar2 == null) {
            kotlin.jvm.internal.h.lS("delegateContext");
        }
        this.aIj = aVar.a(chatRoomType, gVar2);
        com.iqoption.chat.d dVar = this.aIe;
        if (dVar == null) {
            kotlin.jvm.internal.h.lS("resourcer");
        }
        ac acVar = new ac(dVar);
        String string = ((ChatRoomType) this.aIc.getValue()) == ChatRoomType.SUPPORT ? acVar.getString(R.string.any_questions_feel_free_to_ask_and_we_ll, new Object[0]) : ((ChatRoomType) this.aIc.getValue()) == ChatRoomType.FEEDBACK ? acVar.getString(R.string.please_leave_your_feedback_or_suggestion_here, new Object[0]) : "";
        acVar.fI(string);
        e eVar = new e(acVar, this);
        i iVar = new i(acVar, this);
        RoomFragment$onViewCreated$$inlined$apply$lambda$3 roomFragment$onViewCreated$$inlined$apply$lambda$3 = new RoomFragment$onViewCreated$$inlined$apply$lambda$3(this);
        acVar.a((kotlin.jvm.a.b) new RoomFragment$onViewCreated$$inlined$apply$lambda$4(acVar, roomFragment$onViewCreated$$inlined$apply$lambda$3, eVar, this));
        if (((ChatRoomType) this.aIc.getValue()) == ChatRoomType.GLOBAL) {
            acVar.b((kotlin.jvm.a.b) new RoomFragment$onViewCreated$$inlined$apply$lambda$5(this));
        }
        acVar.a((com.iqoption.chat.component.ac.b) new j(this));
        acVar.a((kotlin.jvm.a.m) new RoomFragment$onViewCreated$$inlined$apply$lambda$8(acVar, new RoomFragment$onViewCreated$$inlined$apply$lambda$7(this), new RoomFragment$onViewCreated$9$6(new SimpleDateFormat(acVar.getString(R.string.d_MMM_at_HH_mm, new Object[0]), Locale.US)), roomFragment$onViewCreated$$inlined$apply$lambda$3, iVar, this));
        acVar.b((kotlin.jvm.a.m) new RoomFragment$onViewCreated$$inlined$apply$lambda$9(this));
        acVar.c(new RoomFragment$onViewCreated$$inlined$apply$lambda$10(this));
        acVar.d(new RoomFragment$onViewCreated$$inlined$apply$lambda$11(this));
        this.aHa = acVar;
        rz rzVar = this.aIh;
        if (rzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        rzVar.awN.setOnClickListener(new f(this, n));
        rzVar.bBP.setOnClickListener(new g(this, n));
        com.iqoption.core.l lVar = new com.iqoption.core.l(n);
        e eVar2 = new e();
        com.iqoption.core.k kVar = lVar;
        rzVar.aHb.a(kVar, eVar2);
        rzVar.bBQ.setHasFixedSize(true);
        RecyclerView recyclerView = rzVar.bBQ;
        ac acVar2 = this.aHa;
        if (acVar2 == null) {
            kotlin.jvm.internal.h.lS("adapter");
        }
        BadgeView badgeView = rzVar.aHb;
        kotlin.jvm.internal.h.d(badgeView, "dateBadge");
        recyclerView.addItemDecoration(new n(kVar, eVar2, acVar2, badgeView));
        RecyclerView recyclerView2 = rzVar.bBQ;
        kotlin.jvm.internal.h.d(recyclerView2, "messageList");
        ac acVar3 = this.aHa;
        if (acVar3 == null) {
            kotlin.jvm.internal.h.lS("adapter");
        }
        recyclerView2.setAdapter(acVar3);
        recyclerView2 = rzVar.bBQ;
        kotlin.jvm.internal.h.d(recyclerView2, "messageList");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.aIi = linearLayoutManager;
        linearLayoutManager.setReverseLayout(true);
        recyclerView2.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = rzVar.bBQ;
        kotlin.jvm.internal.h.d(recyclerView3, "messageList");
        recyclerView3.setItemAnimator((ItemAnimator) null);
        rzVar.bBQ.addOnScrollListener(new h(this, n));
        BadgeView badgeView2 = rzVar.aHb;
        kotlin.jvm.internal.h.d(badgeView2, "dateBadge");
        rzVar.bBQ.addOnScrollListener(new k(new l(badgeView2)));
        RecyclerView recyclerView4 = rzVar.bBQ;
        rz rzVar2 = this.aIh;
        if (rzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        FrameLayout frameLayout = rzVar2.bBP;
        kotlin.jvm.internal.h.d(frameLayout, "binding.btnReturn");
        recyclerView4.addOnScrollListener(new t(frameLayout));
        FrameLayout frameLayout2 = rzVar.bBO;
        kotlin.jvm.internal.h.d(frameLayout2, "bottomBarLayout");
        frameLayout2.setLayoutTransition(bg.aGE());
    }

    /* JADX WARNING: Missing block: B:8:0x002d, code:
            if (r2 != null) goto L_0x0032;
     */
    private final void Qk() {
        /*
        r5 = this;
        r0 = com.iqoption.core.ext.a.p(r5);
        r1 = r0.beginTransaction();
        r2 = "ft";
        kotlin.jvm.internal.h.d(r1, r2);
        r2 = r5.aIf;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r3 = "viewModel";
        kotlin.jvm.internal.h.lS(r3);
    L_0x0017:
        r2 = r2.Ra();
        r2 = r2.getValue();
        r2 = (com.iqoption.microservice.chat.n) r2;
        if (r2 == 0) goto L_0x0030;
    L_0x0023:
        r2 = r2.getName();
        if (r2 == 0) goto L_0x0030;
    L_0x0029:
        r2 = com.iqoption.core.util.LocalizationUtil.translate(r2);
        if (r2 == 0) goto L_0x0030;
    L_0x002f:
        goto L_0x0032;
    L_0x0030:
        r2 = "";
    L_0x0032:
        r3 = com.iqoption.chat.fragment.a.aFt;
        r4 = "chatName";
        kotlin.jvm.internal.h.d(r2, r4);
        r4 = new com.iqoption.chat.fragment.RoomFragment$pickAttachments$$inlined$commitNow$lambda$1;
        r4.<init>(r5);
        r4 = (kotlin.jvm.a.b) r4;
        r2 = r3.b(r2, r4);
        r3 = com.iqoption.chat.fragment.a.aFt;
        r3 = r3.Ll();
        r4 = 2131362643; // 0x7f0a0353 float:1.8345072E38 double:1.0530330607E-314;
        r2 = (android.support.v4.app.Fragment) r2;
        r1.add(r4, r2, r3);
        r1.addToBackStack(r3);
        r1.commitAllowingStateLoss();
        r0.executePendingTransactions();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.fragment.x.Qk():void");
    }

    private final void Ql() {
        rz rzVar = this.aIh;
        if (rzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        rzVar.bBQ.b(0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        com.iqoption.core.ext.a.n(this).getWindow().setSoftInputMode(32);
        this.aIm.cancel();
        InteractionViewModel interactionViewModel = this.aIg;
        if (interactionViewModel == null) {
            kotlin.jvm.internal.h.lS("interactionViewModel");
        }
        interactionViewModel.QW();
        KH();
    }

    public boolean onBackPressed() {
        FragmentManager p = com.iqoption.core.ext.a.p(this);
        Object obj = null;
        if ((p.getBackStackEntryCount() > 0 ? 1 : null) == null) {
            p = null;
        }
        if (p != null) {
            BackStackEntry backStackEntryAt = p.getBackStackEntryAt(p.getBackStackEntryCount() - 1);
            if (backStackEntryAt != null) {
                obj = backStackEntryAt.getName();
            }
        }
        if (kotlin.jvm.internal.h.E(obj, TAG)) {
            return onClose();
        }
        return false;
    }

    public boolean onClose() {
        this.aIm.execute();
        InteractionViewModel interactionViewModel = this.aIg;
        if (interactionViewModel == null) {
            kotlin.jvm.internal.h.lS("interactionViewModel");
        }
        Object value = this.aIb.getValue();
        kotlin.jvm.internal.h.d(value, "roomId.value");
        interactionViewModel.fP((String) value);
        b bVar = this.aId;
        if (bVar != null) {
            bVar.Op();
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        kotlin.jvm.internal.h.e(strArr, "permissions");
        kotlin.jvm.internal.h.e(iArr, "grantResults");
        if (i != 1) {
            return;
        }
        if (a("android.permission.READ_EXTERNAL_STORAGE", strArr, iArr)) {
            Qk();
        } else if (!shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE")) {
            com.iqoption.app.a.b.eQ(getString(R.string.please_grant_permission_external_storage));
        }
    }

    private final boolean a(String str, String[] strArr, int[] iArr) {
        int indexOf = i.indexOf(strArr, str);
        boolean z = false;
        if (indexOf == -1) {
            return false;
        }
        if (iArr[indexOf] == 0) {
            z = true;
        }
        return z;
    }
}
