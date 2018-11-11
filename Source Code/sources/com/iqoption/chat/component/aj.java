package com.iqoption.chat.component;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Filter;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.iqoption.a.t;
import com.iqoption.chat.viewmodel.LastMessagesViewModel;
import com.iqoption.chat.viewmodel.SupportRoomViewModel;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.n;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.l;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001qBG\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\u0018\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020(H\u0002J*\u0010@\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020(2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020;H\u0002J\u0018\u0010D\u001a\u00020\u00112\u0006\u0010?\u001a\u00020(2\u0006\u0010>\u001a\u00020\nH\u0002J\u0018\u0010E\u001a\u00020\u00112\u0006\u0010?\u001a\u00020(2\u0006\u0010>\u001a\u00020\nH\u0002J\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010F\u001a\u00020%J\u0019\u0010G\u001a\u0004\u0018\u0001012\b\u0010H\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010JJ\u0010\u0010K\u001a\u0002012\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010L\u001a\u0002012\u0006\u0010A\u001a\u00020BH\u0002J\u0013\u0010M\u001a\u00020\u00142\b\b\u0001\u0010N\u001a\u00020\u0014H\u0001J\u0015\u0010O\u001a\u0004\u0018\u00010P2\b\b\u0001\u0010N\u001a\u00020\u0014H\u0001J\b\u0010Q\u001a\u00020\u0014H\u0016J\u0010\u0010R\u001a\u00020I2\u0006\u0010S\u001a\u00020\u0014H\u0016J\u0010\u0010T\u001a\u0002012\u0006\u0010U\u001a\u000201H\u0002J%\u0010V\u001a\u00020%2\b\b\u0001\u0010N\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u00142\b\b\u0002\u0010X\u001a\u00020;H\u0001J<\u0010Y\u001a\n 4*\u0004\u0018\u000101012\b\b\u0001\u0010N\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u00142\u0012\u0010Z\u001a\n\u0012\u0006\b\u0001\u0012\u00020\\0[\"\u00020\\H\u0001¢\u0006\u0002\u0010]J\u000e\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u000201J\u0013\u0010`\u001a\u00020a2\b\b\u0001\u0010N\u001a\u00020\u0014H\u0001J\u0013\u0010b\u001a\u00020\u00142\b\b\u0001\u0010N\u001a\u00020\u0014H\u0001J0\u0010c\u001a\u0002012\b\b\u0001\u0010N\u001a\u00020\u00142\u0016\u0010Z\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\\0[\"\u0004\u0018\u00010\\H\u0001¢\u0006\u0002\u0010dJ\u0014\u0010e\u001a\u00020\u00112\f\u0010f\u001a\b\u0012\u0004\u0012\u00020(0'J\u0010\u0010g\u001a\u00020\u00112\u0006\u0010h\u001a\u00020iH\u0016J\u0018\u0010j\u001a\u00020\u00112\u0006\u0010k\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\u0014H\u0016J\u0018\u0010l\u001a\u00020\u00022\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u0014H\u0016J\u000e\u0010o\u001a\u00020\u00112\u0006\u0010A\u001a\u00020BJ\u0018\u0010p\u001a\u00020\u00112\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u001cX\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\"\u0010&\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'\u0012\u0004\u0012\u00020\u0011\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R2\u00102\u001a&\u0012\f\u0012\n 4*\u0004\u0018\u00010(0( 4*\u0012\u0012\f\u0012\n 4*\u0004\u0018\u00010(0(\u0018\u00010303X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020109X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, aXE = {"Lcom/iqoption/chat/component/RoomsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/chat/component/RoomViewHolder;", "Lcom/iqoption/chat/Resourcer;", "resourcer", "lifecycleOwner", "Landroid/arch/lifecycle/LifecycleOwner;", "roomBindingFactory", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lcom/iqoption/chat/component/RoomBinding;", "supportRoomViewModel", "Lcom/iqoption/chat/viewmodel/SupportRoomViewModel;", "messagesViewModel", "Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "animationCallback", "Lkotlin/Function0;", "", "(Lcom/iqoption/chat/Resourcer;Landroid/arch/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lcom/iqoption/chat/viewmodel/SupportRoomViewModel;Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;Lkotlin/jvm/functions/Function0;)V", "avatarSize", "", "avatarTransformation", "Lcom/iqoption/core/ui/picasso/PathTransformation;", "getAvatarTransformation", "()Lcom/iqoption/core/ui/picasso/PathTransformation;", "avatarTransformation$delegate", "Lkotlin/Lazy;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dateYearFormat", "filter", "Landroid/widget/Filter;", "filterConstraint", "", "filterListener", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "listener", "Lkotlin/Function2;", "getListener", "()Lkotlin/jvm/functions/Function2;", "setListener", "(Lkotlin/jvm/functions/Function2;)V", "loadedMessages", "", "", "ordering", "Lcom/google/common/collect/Ordering;", "kotlin.jvm.PlatformType", "picasso", "Lcom/squareup/picasso/Picasso;", "rooms", "translations", "", "updateOnMessageLoaded", "", "weekDayFormat", "bind", "binding", "room", "bindMessage", "message", "Lcom/iqoption/microservice/chat/ChatMessage;", "loading", "bindRoomImage", "bindSupportImage", "constraint", "formatDate", "date", "", "(Ljava/lang/Long;)Ljava/lang/String;", "formatLastMessage", "formatLastMessageContents", "getColor", "id", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getItemCount", "getItemId", "position", "getLocalizedTitle", "key", "getPlural", "quantity", "formatQuantity", "getPluralFormat", "formatArgs", "", "", "(II[Ljava/lang/Object;)Ljava/lang/String;", "getPositionByRoomId", "roomId", "getPxFloat", "", "getPxInt", "getString", "(I[Ljava/lang/Object;)Ljava/lang/String;", "initFilter", "list", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "viewType", "setMessage", "setRooms", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomsAdapter.kt */
public final class aj extends Adapter<ai> implements com.iqoption.chat.d {
    private static final String TAG = "aj";
    private static final t aDz = new t();
    private static final List<ChatRoomType> aEQ = m.listOf(ChatRoomType.VIP, ChatRoomType.SUPPORT, ChatRoomType.GLOBAL, ChatRoomType.FEEDBACK, ChatRoomType.NOTIFICATION, ChatRoomType.MODERATION);
    private static final kotlin.jvm.a.b<n, Integer> aER = RoomsAdapter$Companion$PRIORITY_RESOLVER$1.aEV;
    private static final m<LastMessagesViewModel, n, Long> aES = RoomsAdapter$Companion$DATE_RESOLVER$1.aEU;
    public static final a aET = new a();
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(aj.class), "avatarTransformation", "getAvatarTransformation()Lcom/iqoption/core/ui/picasso/PathTransformation;"))};
    private final LifecycleOwner aCg;
    private final int aDI = dr(R.dimen.dp40);
    private final /* synthetic */ com.iqoption.chat.d aDY;
    private boolean aEB;
    private kotlin.jvm.a.b<? super List<n>, l> aEC;
    private final Map<String, String> aED = new LinkedHashMap();
    private final SimpleDateFormat aEE = new SimpleDateFormat("EEE", Locale.getDefault());
    private final SimpleDateFormat aEF = new SimpleDateFormat("d MMM yyyy", Locale.getDefault());
    private final Set<String> aEG = new LinkedHashSet();
    private List<n> aEH = m.emptyList();
    private CharSequence aEI = "";
    private Filter aEJ;
    private final kotlin.d aEK = g.f(new RoomsAdapter$avatarTransformation$2(this));
    private m<? super n, ? super Integer, l> aEL;
    private final kotlin.jvm.a.b<ViewGroup, ah> aEM;
    private final SupportRoomViewModel aEN;
    private final LastMessagesViewModel aEO;
    private final kotlin.jvm.a.a<l> aEP;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM", Locale.getDefault());
    private final Ordering<n> ordering = Ordering.from((Comparator) i.aFh).compound((Comparator) new j(this)).compound((Comparator) Ordering.natural().onResultOf(new k(this)));
    private Picasso picasso;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/chat/component/RoomsAdapter$Companion;", "", "()V", "DATE_RESOLVER", "Lkotlin/Function2;", "Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "Lcom/iqoption/microservice/chat/ChatRoom;", "", "PRIORITY_RESOLVER", "Lkotlin/Function1;", "", "ROOM_TYPE_PRIORITY", "", "Lcom/iqoption/microservice/chat/ChatRoomType;", "SORTING_DELAY", "STABLE_ID_STORE", "Lcom/iqoption/adapter/StableIdStore;", "TAG", "", "kotlin.jvm.PlatformType", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/chat/component/RoomsAdapter$bind$3$1"})
    /* compiled from: RoomsAdapter.kt */
    static final class b implements Runnable {
        final /* synthetic */ LiveData aEW;
        final /* synthetic */ ah aEX;
        final /* synthetic */ String aEY;
        final /* synthetic */ aj this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatMessage;", "onChanged", "com/iqoption/chat/component/RoomsAdapter$bind$3$1$1"})
        /* compiled from: RoomsAdapter.kt */
        /* renamed from: com.iqoption.chat.component.aj$b$1 */
        static final class AnonymousClass1<T> implements Observer<com.iqoption.microservice.chat.g> {
            final /* synthetic */ b aEZ;

            AnonymousClass1(b bVar) {
                this.aEZ = bVar;
            }

            /* renamed from: d */
            public final void onChanged(com.iqoption.microservice.chat.g gVar) {
                this.aEZ.this$0.aEG.add(this.aEZ.aEY);
                if (gVar != null) {
                    aj ajVar = this.aEZ.this$0;
                    kotlin.jvm.internal.h.d(gVar, "it");
                    ajVar.a(gVar);
                }
            }
        }

        b(LiveData liveData, aj ajVar, ah ahVar, String str) {
            this.aEW = liveData;
            this.this$0 = ajVar;
            this.aEX = ahVar;
            this.aEY = str;
        }

        public final void run() {
            this.aEW.observe(this.this$0.aCg, new AnonymousClass1(this));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: RoomsAdapter.kt */
    static final class c implements Runnable {
        final /* synthetic */ aj this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "onChanged"})
        /* compiled from: RoomsAdapter.kt */
        /* renamed from: com.iqoption.chat.component.aj$c$1 */
        static final class AnonymousClass1<T> implements Observer<String> {
            final /* synthetic */ c aFa;

            AnonymousClass1(c cVar) {
                this.aFa = cVar;
            }

            /* renamed from: fz */
            public final void onChanged(String str) {
                aj ajVar = this.aFa.this$0;
                int i = 0;
                for (n Qh : this.aFa.this$0.aEH) {
                    if ((Qh.Qh() == ChatRoomType.SUPPORT ? 1 : null) != null) {
                        break;
                    }
                    i++;
                }
                i = -1;
                ajVar.notifyItemChanged(i);
            }
        }

        c(aj ajVar) {
            this.this$0 = ajVar;
        }

        public final void run() {
            this.this$0.aEN.Rz().observe(this.this$0.aCg, new AnonymousClass1(this));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, aXE = {"com/iqoption/chat/component/RoomsAdapter$onAttachedToRecyclerView$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomsAdapter.kt */
    public static final class g implements AnimationListener {
        final /* synthetic */ RecyclerView aFe;
        final /* synthetic */ aj this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/chat/component/RoomsAdapter$onAttachedToRecyclerView$1$1$onAnimationEnd$1"})
        /* compiled from: RoomsAdapter.kt */
        /* renamed from: com.iqoption.chat.component.aj$g$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ g aFf;

            AnonymousClass1(g gVar) {
                this.aFf = gVar;
            }

            public final void run() {
                this.aFf.this$0.aEB = true;
                this.aFf.this$0.O(this.aFf.this$0.aEH);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        g(aj ajVar, RecyclerView recyclerView) {
            this.this$0 = ajVar;
            this.aFe = recyclerView;
        }

        public void onAnimationEnd(Animation animation) {
            this.aFe.setLayoutAnimationListener((AnimationListener) null);
            com.iqoption.core.d.a.aSe.postDelayed(new AnonymousClass1(this), 1000);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "o1", "Lcom/iqoption/microservice/chat/ChatRoom;", "kotlin.jvm.PlatformType", "o2", "compare"})
    /* compiled from: RoomsAdapter.kt */
    static final class i<T> implements Comparator<n> {
        public static final i aFh = new i();

        i() {
        }

        /* renamed from: a */
        public final int compare(n nVar, n nVar2) {
            kotlin.jvm.a.b Pm = aj.aER;
            kotlin.jvm.internal.h.d(nVar, "o1");
            int intValue = ((Number) Pm.invoke(nVar)).intValue();
            Pm = aj.aER;
            kotlin.jvm.internal.h.d(nVar2, "o2");
            return Ints.compare(intValue, ((Number) Pm.invoke(nVar2)).intValue());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "o1", "Lcom/iqoption/microservice/chat/ChatRoom;", "kotlin.jvm.PlatformType", "o2", "compare"})
    /* compiled from: RoomsAdapter.kt */
    static final class j<T> implements Comparator<n> {
        final /* synthetic */ aj this$0;

        j(aj ajVar) {
            this.this$0 = ajVar;
        }

        /* renamed from: a */
        public final int compare(n nVar, n nVar2) {
            m Pn = aj.aES;
            LastMessagesViewModel f = this.this$0.aEO;
            kotlin.jvm.internal.h.d(nVar2, "o2");
            long longValue = ((Number) Pn.B(f, nVar2)).longValue();
            m Pn2 = aj.aES;
            LastMessagesViewModel f2 = this.this$0.aEO;
            kotlin.jvm.internal.h.d(nVar, "o1");
            return Longs.compare(longValue, ((Number) Pn2.B(f2, nVar)).longValue());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b¨\u0006\t"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "data", "Lcom/google/common/collect/ImmutableList;", "Lcom/iqoption/microservice/chat/ChatRoom;", "onFiltered", "com/iqoption/chat/component/RoomsAdapter$initFilter$1$1"})
    /* compiled from: RoomsAdapter.kt */
    static final class d<T> implements com.iqoption.a.m.b<n> {
        final /* synthetic */ List aFb;
        final /* synthetic */ aj this$0;

        d(aj ajVar, List list) {
            this.this$0 = ajVar;
            this.aFb = list;
        }

        public final void a(CharSequence charSequence, ImmutableList<n> immutableList) {
            this.this$0.O(immutableList);
            kotlin.jvm.a.b e = this.this$0.aEC;
            if (e != null) {
                kotlin.jvm.internal.h.d(immutableList, "data");
                l lVar = (l) e.invoke(immutableList);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u000126\u0010\u0004\u001a2\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007 \u0003*\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, aXE = {"<anonymous>", "Lcom/google/common/collect/ImmutableList;", "Lcom/iqoption/microservice/chat/ChatRoom;", "kotlin.jvm.PlatformType", "index", "", "", "", "constraint", "", "performFilter", "com/iqoption/chat/component/RoomsAdapter$initFilter$1$3"})
    /* compiled from: RoomsAdapter.kt */
    static final class e<T, I> implements com.iqoption.a.m.c<n, Map<Character, ? extends List<? extends n>>> {
        final /* synthetic */ List aFb;
        final /* synthetic */ aj this$0;

        e(aj ajVar, List list) {
            this.this$0 = ajVar;
            this.aFb = list;
        }

        public final ImmutableList<n> a(Map<Character, ? extends List<n>> map, CharSequence charSequence) {
            List list;
            if (TextUtils.isEmpty(charSequence)) {
                list = (List) map.get(null);
                if (list == null) {
                    list = m.emptyList();
                }
                return ImmutableList.m(list);
            }
            String obj = charSequence.toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            obj = v.trim(obj).toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            obj = obj.toLowerCase();
            kotlin.jvm.internal.h.d(obj, "(this as java.lang.String).toLowerCase()");
            list = (List) map.get(Character.valueOf(obj.charAt(0)));
            if (list == null) {
                list = m.emptyList();
            }
            Collection arrayList = new ArrayList();
            for (Object next : r8) {
                String a = this.this$0.fK(((n) next).getName());
                if (a == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                if (a == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                a = a.toLowerCase();
                kotlin.jvm.internal.h.d(a, "(this as java.lang.String).toLowerCase()");
                if (v.b((CharSequence) a, (CharSequence) obj, false, 2, null)) {
                    arrayList.add(next);
                }
            }
            return ImmutableList.m((List) arrayList);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0000\n\u0002\u0010%\n\u0002\u0010\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001az\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012(\u0012&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00060\u0004 \u0003*<\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012(\u0012&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00060\u0004\u0018\u00010\u00070\u00012*\u0010\b\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, aXE = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "", "", "it", "Lcom/google/common/collect/ImmutableList;", "onCreateIndex"})
    /* compiled from: RoomsAdapter.kt */
    static final class f<T, I> implements com.iqoption.a.m.d<n, Map<Character, ? extends List<? extends n>>> {
        public static final f aFc = new f();

        f() {
        }

        /* renamed from: j */
        public final Map<Character, List<n>> a(ImmutableList<n> immutableList) {
            return com.iqoption.a.m.a(immutableList, AnonymousClass1.aFd);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/component/RoomsAdapter$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class h extends com.iqoption.core.ext.g {
        final /* synthetic */ ai aFg;
        final /* synthetic */ aj this$0;

        public h(ai aiVar, aj ajVar) {
            this.this$0 = ajVar;
            this.aFg = aiVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            n Ph = this.aFg.Ph();
            if (Ph != null) {
                m Pk = this.this$0.Pk();
                if (Pk != null) {
                    l lVar = (l) Pk.B(Ph, Integer.valueOf(this.aFg.getAdapterPosition()));
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatRoom;", "apply"})
    /* compiled from: RoomsAdapter.kt */
    static final class k<F, T> implements com.google.common.base.d<F, T> {
        final /* synthetic */ aj this$0;

        k(aj ajVar) {
            this.this$0 = ajVar;
        }

        /* renamed from: f */
        public final String apply(n nVar) {
            if (nVar != null) {
                String name = nVar.getName();
                if (name != null) {
                    return this.this$0.fK(name);
                }
            }
            return null;
        }
    }

    private final com.iqoption.core.ui.picasso.b Pj() {
        kotlin.d dVar = this.aEK;
        kotlin.reflect.j jVar = apP[0];
        return (com.iqoption.core.ui.picasso.b) dVar.getValue();
    }

    public String a(@PluralsRes int i, int i2, Object... objArr) {
        kotlin.jvm.internal.h.e(objArr, "formatArgs");
        return this.aDY.a(i, i2, objArr);
    }

    public int dr(@DimenRes int i) {
        return this.aDY.dr(i);
    }

    public float ds(@DimenRes int i) {
        return this.aDY.ds(i);
    }

    public int getColor(@ColorRes int i) {
        return this.aDY.getColor(i);
    }

    public Context getContext() {
        return this.aDY.getContext();
    }

    public Drawable getDrawable(@DrawableRes int i) {
        return this.aDY.getDrawable(i);
    }

    public String getString(@StringRes int i, Object... objArr) {
        kotlin.jvm.internal.h.e(objArr, "formatArgs");
        return this.aDY.getString(i, objArr);
    }

    public aj(com.iqoption.chat.d dVar, LifecycleOwner lifecycleOwner, kotlin.jvm.a.b<? super ViewGroup, ? extends ah> bVar, SupportRoomViewModel supportRoomViewModel, LastMessagesViewModel lastMessagesViewModel, kotlin.jvm.a.a<l> aVar) {
        kotlin.jvm.internal.h.e(dVar, "resourcer");
        kotlin.jvm.internal.h.e(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.h.e(bVar, "roomBindingFactory");
        kotlin.jvm.internal.h.e(supportRoomViewModel, "supportRoomViewModel");
        kotlin.jvm.internal.h.e(lastMessagesViewModel, "messagesViewModel");
        kotlin.jvm.internal.h.e(aVar, "animationCallback");
        this.aDY = dVar;
        this.aCg = lifecycleOwner;
        this.aEM = bVar;
        this.aEN = supportRoomViewModel;
        this.aEO = lastMessagesViewModel;
        this.aEP = aVar;
        setHasStableIds(true);
    }

    public final m<n, Integer, l> Pk() {
        return this.aEL;
    }

    public final void c(m<? super n, ? super Integer, l> mVar) {
        this.aEL = mVar;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.h.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Picasso with = Picasso.with(recyclerView.getContext());
        kotlin.jvm.internal.h.d(with, "Picasso.with(context)");
        this.picasso = with;
        recyclerView.setLayoutAnimationListener(new g(this, recyclerView));
    }

    public long getItemId(int i) {
        return aDz.dU(((n) this.aEH.get(i)).getId());
    }

    public int getItemCount() {
        return this.aEH.size();
    }

    /* renamed from: m */
    public ai onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        ai aiVar = new ai((ah) this.aEM.invoke(viewGroup));
        aiVar.Pi().getRoot().setOnClickListener(new h(aiVar, this));
        return aiVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(ai aiVar, int i) {
        kotlin.jvm.internal.h.e(aiVar, "holder");
        n nVar = (n) this.aEH.get(i);
        aiVar.d(nVar);
        a(aiVar.Pi(), nVar);
    }

    private final void a(ah ahVar, n nVar) {
        if (nVar.Qh() == ChatRoomType.SUPPORT) {
            a(nVar, ahVar);
            TextView Pa = ahVar.Pa();
            Pa.setTextColor(com.iqoption.core.ext.a.c((View) Pa, (int) R.attr.colorAccent));
        } else {
            b(nVar, ahVar);
            ahVar.Pa().setTextColor(getColor(R.color.chat_room_title));
        }
        ahVar.Pa().setText(fK(nVar.getName()));
        String id = nVar.getId();
        com.iqoption.microservice.chat.g fQ = this.aEO.fQ(id);
        LiveData fR = this.aEO.fR(id);
        if (!fR.hasObservers()) {
            ahVar.getRoot().post(new b(fR, this, ahVar, id));
        }
        a(ahVar, nVar, fQ, this.aEO.fT(id));
    }

    private final void a(n nVar, ah ahVar) {
        String str = (String) this.aEN.Rz().getValue();
        Picasso picasso = this.picasso;
        if (picasso == null) {
            kotlin.jvm.internal.h.lS("picasso");
        }
        picasso.cancelRequest(ahVar.OZ());
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            ahVar.OZ().setImageDrawable(null);
            if (!this.aEN.RA()) {
                this.aEN.RB();
            }
            ahVar.getRoot().post(new c(this));
        } else if (!kotlin.jvm.internal.h.E(str, "no_avatar")) {
            Picasso picasso2 = this.picasso;
            if (picasso2 == null) {
                kotlin.jvm.internal.h.lS("picasso");
            }
            picasso2.load(str).resize(this.aDI, this.aDI).centerCrop().transform((Transformation) Pj()).into(ahVar.OZ());
        } else if (TextUtils.isEmpty(nVar.arK())) {
            ahVar.OZ().setImageResource(R.drawable.chat_room_support);
        } else {
            Picasso picasso3 = this.picasso;
            if (picasso3 == null) {
                kotlin.jvm.internal.h.lS("picasso");
            }
            picasso3.load(nVar.arK()).into(ahVar.OZ());
        }
    }

    private final void b(n nVar, ah ahVar) {
        if (TextUtils.isEmpty(nVar.arK())) {
            ahVar.OZ().setImageResource(R.drawable.chat_room_icon_placeholder);
            return;
        }
        Picasso picasso = this.picasso;
        if (picasso == null) {
            kotlin.jvm.internal.h.lS("picasso");
        }
        picasso.load(nVar.arK()).into(ahVar.OZ());
    }

    private final String fK(String str) {
        String str2 = (String) this.aED.get(str);
        if (str2 == null) {
            str2 = LocalizationUtil.translate(str);
            if (str2 == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            Map map = this.aED;
            kotlin.jvm.internal.h.d(str2, "this");
            map.put(str, str2);
            kotlin.jvm.internal.h.d(str2, "LocalizationUtil.transla…ranslations[key] = this }");
        }
        return str2;
    }

    private final void a(ah ahVar, n nVar, com.iqoption.microservice.chat.g gVar, boolean z) {
        if (gVar != null) {
            ahVar.Pb().setText(b(gVar));
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("is last message of chat: ");
            stringBuilder.append(nVar.getId());
            stringBuilder.append(" seen: ");
            stringBuilder.append(nVar.il(gVar.getId()));
            com.iqoption.core.i.d(str, stringBuilder.toString());
            if (gVar.arg() || nVar.il(gVar.getId())) {
                ahVar.Pb().setTextColor(getColor(R.color.chat_room_message_read));
                ahVar.Pd().setVisibility(4);
            } else {
                ahVar.Pb().setTextColor(getColor(R.color.chat_room_message_unread));
                ahVar.Pd().setVisibility(0);
            }
            ahVar.Pc().setText(l(Long.valueOf(gVar.getDate())));
            return;
        }
        if (!z || this.aEG.contains(nVar.getId())) {
            CharSequence string;
            TextView Pb = ahVar.Pb();
            switch (nVar.Qh()) {
                case SUPPORT:
                    string = getString(R.string.any_questions_feel_free_to_ask_and_we_ll, new Object[0]);
                    break;
                case FEEDBACK:
                    string = getString(R.string.please_leave_your_feedback_or_suggestion_here, new Object[0]);
                    break;
                default:
                    string = null;
                    break;
            }
            Pb.setText(string);
        } else {
            ahVar.Pb().setText((CharSequence) null);
        }
        ahVar.Pc().setText((CharSequence) null);
        ahVar.Pd().setVisibility(4);
    }

    private final String l(Long l) {
        if (l == null) {
            return null;
        }
        if (com.iqoption.util.m.aQ(l.longValue())) {
            return com.iqoption.util.m.aR(l.longValue());
        }
        if (com.iqoption.util.m.aK(l.longValue())) {
            return getString(R.string.yesterday, new Object[0]);
        }
        if (com.iqoption.util.m.cf(l.longValue())) {
            return this.aEE.format(l);
        }
        if (com.iqoption.util.m.aL(l.longValue())) {
            return this.dateFormat.format(l);
        }
        return this.aEF.format(l);
    }

    private final String b(com.iqoption.microservice.chat.g gVar) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        if (gVar.arg()) {
            str = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(gVar.arn());
            stringBuilder2.append(": ");
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(c(gVar));
        return stringBuilder.toString();
    }

    private final String c(com.iqoption.microservice.chat.g gVar) {
        if (gVar.getText() != null) {
            if ((((CharSequence) gVar.getText()).length() > 0 ? 1 : null) != null) {
                return gVar.getText();
            }
        }
        if (gVar.getAttachments() == null || (gVar.getAttachments().isEmpty() ^ 1) == 0) {
            return "";
        }
        if (((com.iqoption.microservice.chat.a) u.bW(gVar.getAttachments())).arf()) {
            return getString(R.string.image, new Object[0]);
        }
        return getString(R.string.file, new Object[0]);
    }

    public final void N(List<n> list) {
        kotlin.jvm.internal.h.e(list, "list");
        if (this.aEJ == null) {
            this.aEJ = com.iqoption.a.m.w(list).a((com.iqoption.a.m.b) new d(this, list)).a((com.iqoption.a.m.d) f.aFc).a((com.iqoption.a.m.c) new e(this, list)).AW();
        }
        Pl();
    }

    public final void filter(CharSequence charSequence) {
        kotlin.jvm.internal.h.e(charSequence, "constraint");
        if (!kotlin.jvm.internal.h.E(charSequence, this.aEI)) {
            this.aEI = charSequence;
            Pl();
        }
    }

    public final void Pl() {
        Filter filter = this.aEJ;
        if (filter != null) {
            filter.filter(this.aEI);
        }
    }

    private final void O(List<n> list) {
        List list2;
        Object obj = null;
        if ((list2 != null ? list2.isEmpty() ^ 1 : 0) != 0 && this.aEH.isEmpty()) {
            obj = 1;
        }
        if (list2 == null) {
            list2 = m.emptyList();
        }
        this.aEH = list2;
        Iterable iterable = this.aEH;
        Ordering ordering = this.ordering;
        kotlin.jvm.internal.h.d(ordering, "ordering");
        this.aEH = u.a(iterable, (Comparator) ordering);
        notifyDataSetChanged();
        if ((this.aEH.isEmpty() ^ 1) != 0 && obj != null) {
            this.aEP.invoke();
        }
    }

    public final void a(com.iqoption.microservice.chat.g gVar) {
        kotlin.jvm.internal.h.e(gVar, "message");
        Object obj = null;
        int i = 0;
        for (n id : this.aEH) {
            if (kotlin.jvm.internal.h.E(id.getId(), gVar.Re())) {
                break;
            }
            i++;
        }
        i = -1;
        Integer valueOf = Integer.valueOf(i);
        if (valueOf.intValue() != -1) {
            obj = 1;
        }
        if (obj == null) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.intValue();
            if (this.aEB) {
                O(this.aEH);
            }
        }
    }

    public final int fL(String str) {
        kotlin.jvm.internal.h.e(str, "roomId");
        int i = 0;
        for (n id : this.aEH) {
            if (kotlin.jvm.internal.h.E(id.getId(), str)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
