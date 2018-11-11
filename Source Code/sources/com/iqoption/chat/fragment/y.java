package com.iqoption.chat.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.chat.d;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.n;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0001J\u0015\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0001J%\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0001J<\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0001J0\u0010\u001d\u001a\u00020\u00142\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H&R\u0012\u0010\u0005\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006$"}, aXE = {"Lcom/iqoption/chat/fragment/RoomTopBarDelegate;", "Lcom/iqoption/chat/Resourcer;", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "(Lcom/iqoption/chat/fragment/DelegateContext;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getColor", "", "id", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getPlural", "", "quantity", "formatQuantity", "", "getPluralFormat", "", "kotlin.jvm.PlatformType", "formatArgs", "", "", "(II[Ljava/lang/Object;)Ljava/lang/String;", "getPxFloat", "", "getPxInt", "getString", "(I[Ljava/lang/Object;)Ljava/lang/String;", "onRoomLoaded", "", "room", "Lcom/iqoption/microservice/chat/ChatRoom;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomTopBarDelegates.kt */
public abstract class y implements d {
    public static final a aIM = new a();
    private final /* synthetic */ g aHX;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, aXE = {"Lcom/iqoption/chat/fragment/RoomTopBarDelegate$Companion;", "", "()V", "create", "Lcom/iqoption/chat/fragment/RoomTopBarDelegate;", "type", "Lcom/iqoption/microservice/chat/ChatRoomType;", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomTopBarDelegates.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final y a(ChatRoomType chatRoomType, g gVar) {
            h.e(chatRoomType, Param.TYPE);
            h.e(gVar, "delegateContext");
            switch (chatRoomType) {
                case GLOBAL:
                    return new s(gVar);
                case SUPPORT:
                case VIP:
                    return new ae(gVar, chatRoomType == ChatRoomType.SUPPORT);
                default:
                    return new r(gVar);
            }
        }
    }

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

    public abstract void g(n nVar);

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

    public y(g gVar) {
        h.e(gVar, "delegateContext");
        this.aHX = gVar;
    }
}
