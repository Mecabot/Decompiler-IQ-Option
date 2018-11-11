package com.iqoption.chat.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.chat.d;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.g;
import com.iqoption.microservice.chat.o;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 02\u00020\u0001:\u000201B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0001J\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0001J%\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001J<\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a2\b\b\u0001\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d\"\u00020\u001eH\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0001J\u0013\u0010\"\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0001J0\u0010#\u001a\u00020\u001a2\b\b\u0001\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001e0\u001d\"\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0018H\u0016J\u0012\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010-H&J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u00062"}, aXE = {"Lcom/iqoption/chat/fragment/RoomBottomBarDelegate;", "Lcom/iqoption/chat/Resourcer;", "params", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;", "(Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "getDelegateContext", "()Lcom/iqoption/chat/fragment/DelegateContext;", "getParams", "()Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;", "getColor", "", "id", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getPlural", "", "quantity", "formatQuantity", "", "getPluralFormat", "", "kotlin.jvm.PlatformType", "formatArgs", "", "", "(II[Ljava/lang/Object;)Ljava/lang/String;", "getPxFloat", "", "getPxInt", "getString", "(I[Ljava/lang/Object;)Ljava/lang/String;", "isMessageInteractionsAvailable", "onReplyMessage", "", "message", "Lcom/iqoption/microservice/chat/ChatMessage;", "withText", "onStateChanged", "state", "Lcom/iqoption/microservice/chat/ChatState;", "save", "Landroid/os/Bundle;", "Companion", "Params", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomBottomBarDelegates.kt */
public abstract class u implements d {
    public static final a aHW = new a();
    private final g aHK = this.aHV.Qd();
    private final b aHV;
    private final /* synthetic */ g aHX;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Companion;", "", "()V", "create", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate;", "context", "Lcom/iqoption/chat/fragment/DelegateContext;", "type", "Lcom/iqoption/microservice/chat/ChatRoomType;", "state", "Lcom/iqoption/microservice/chat/ChatState;", "savedState", "Landroid/os/Bundle;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomBottomBarDelegates.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final u a(g gVar, ChatRoomType chatRoomType, o oVar, Bundle bundle) {
            h.e(gVar, "context");
            h.e(chatRoomType, Param.TYPE);
            b bVar = new b(gVar, chatRoomType, oVar, bundle);
            if (oVar == null) {
                return new i(bVar);
            }
            u acVar;
            switch (chatRoomType) {
                case GLOBAL:
                    if (!oVar.arO()) {
                        if (oVar.arP() >= oVar.arQ()) {
                            acVar = new ac(bVar);
                            break;
                        }
                        acVar = new b(bVar, w.a(gVar, oVar));
                        break;
                    }
                    acVar = new b(bVar, gVar.getString(R.string.you_have_been_banned, new Object[0]));
                    break;
                case FEEDBACK:
                    if (!oVar.arO()) {
                        acVar = new ac(bVar);
                        break;
                    }
                    acVar = new b(bVar, gVar.getString(R.string.you_have_been_banned, new Object[0]));
                    break;
                case SUPPORT:
                case VIP:
                case MODERATION:
                    acVar = new ac(bVar);
                    break;
                default:
                    acVar = new i(bVar);
                    break;
            }
            return acVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;", "", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "type", "Lcom/iqoption/microservice/chat/ChatRoomType;", "state", "Lcom/iqoption/microservice/chat/ChatState;", "savedState", "Landroid/os/Bundle;", "(Lcom/iqoption/chat/fragment/DelegateContext;Lcom/iqoption/microservice/chat/ChatRoomType;Lcom/iqoption/microservice/chat/ChatState;Landroid/os/Bundle;)V", "getDelegateContext", "()Lcom/iqoption/chat/fragment/DelegateContext;", "getSavedState", "()Landroid/os/Bundle;", "getState", "()Lcom/iqoption/microservice/chat/ChatState;", "getType", "()Lcom/iqoption/microservice/chat/ChatRoomType;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomBottomBarDelegates.kt */
    public static final class b {
        private final g aHK;
        private final ChatRoomType aHY;
        private final o aHZ;
        private final Bundle aIa;

        public b(g gVar, ChatRoomType chatRoomType, o oVar, Bundle bundle) {
            h.e(gVar, "delegateContext");
            h.e(chatRoomType, Param.TYPE);
            this.aHK = gVar;
            this.aHY = chatRoomType;
            this.aHZ = oVar;
            this.aIa = bundle;
        }

        public final g Qd() {
            return this.aHK;
        }

        public final ChatRoomType Qh() {
            return this.aHY;
        }

        public final o Qi() {
            return this.aHZ;
        }

        public final Bundle Qj() {
            return this.aIa;
        }
    }

    public Bundle Qe() {
        return null;
    }

    public boolean Qf() {
        return false;
    }

    public abstract u a(o oVar);

    public String a(@PluralsRes int i, int i2, Object... objArr) {
        h.e(objArr, "formatArgs");
        return this.aHX.a(i, i2, objArr);
    }

    public int dr(@DimenRes int i) {
        return this.aHX.dr(i);
    }

    public float ds(@DimenRes int i) {
        return this.aHX.ds(i);
    }

    public int getColor(@ColorRes int i) {
        return this.aHX.getColor(i);
    }

    public Context getContext() {
        return this.aHX.getContext();
    }

    public Drawable getDrawable(@DrawableRes int i) {
        return this.aHX.getDrawable(i);
    }

    public String getString(@StringRes int i, Object... objArr) {
        h.e(objArr, "formatArgs");
        return this.aHX.getString(i, objArr);
    }

    protected u(b bVar) {
        h.e(bVar, "params");
        this.aHX = bVar.Qd();
        this.aHV = bVar;
    }

    public final b Qg() {
        return this.aHV;
    }

    protected final g Qd() {
        return this.aHK;
    }

    public void a(g gVar, boolean z) {
        h.e(gVar, "message");
        throw new UnsupportedOperationException();
    }
}
