package com.iqoption.core.ui.navigation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"BS\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013¨\u0006#"}, aXE = {"Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "", "name", "", "fClass", "Ljava/lang/Class;", "Landroid/support/v4/app/Fragment;", "fArgs", "Landroid/os/Bundle;", "enterAnim", "", "exitAnim", "popEnterAnim", "popExitAnim", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Bundle;IIII)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;IIII)V", "getEnterAnim", "()I", "setEnterAnim", "(I)V", "getExitAnim", "setExitAnim", "getFArgs", "()Landroid/os/Bundle;", "getFClass", "()Ljava/lang/String;", "getName", "getPopEnterAnim", "setPopEnterAnim", "getPopExitAnim", "setPopExitAnim", "getFragment", "context", "Landroid/content/Context;", "Companion", "core_release"})
/* compiled from: NavigatorEntry.kt */
public class h {
    public static final a bbR = new a();
    private final String bbP;
    private final Bundle bbQ;
    private int enterAnim;
    private int exitAnim;
    private final String name;
    private int popEnterAnim;
    private int popExitAnim;

    @i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006H\bJ.\u0010\u0003\u001a\u00020\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\bJ\"\u0010\u0003\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\t¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/ui/navigation/NavigatorEntry$Companion;", "", "()V", "from", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "Cls", "Landroid/support/v4/app/Fragment;", "args", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "Lkotlin/ExtensionFunctionType;", "cls", "Ljava/lang/Class;", "core_release"})
    /* compiled from: NavigatorEntry.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public h(String str, String str2, Bundle bundle, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(str2, "fClass");
        this.name = str;
        this.bbP = str2;
        this.bbQ = bundle;
        this.enterAnim = i;
        this.exitAnim = i2;
        this.popEnterAnim = i3;
        this.popExitAnim = i4;
    }

    public final String getName() {
        return this.name;
    }

    public final int YV() {
        return this.enterAnim;
    }

    public final int YW() {
        return this.exitAnim;
    }

    public final int YX() {
        return this.popEnterAnim;
    }

    public final int YY() {
        return this.popExitAnim;
    }

    public /* synthetic */ h(String str, Class cls, Bundle bundle, int i, int i2, int i3, int i4, int i5, f fVar) {
        this(str, cls, (i5 & 4) != 0 ? (Bundle) null : bundle, (i5 & 8) != 0 ? -1 : i, (i5 & 16) != 0 ? -1 : i2, (i5 & 32) != 0 ? -1 : i3, (i5 & 64) != 0 ? -1 : i4);
    }

    public h(String str, Class<? extends Fragment> cls, Bundle bundle, int i, int i2, int i3, int i4) {
        String str2 = str;
        kotlin.jvm.internal.h.e(str2, "name");
        Class<? extends Fragment> cls2 = cls;
        kotlin.jvm.internal.h.e(cls2, "fClass");
        String name = cls2.getName();
        kotlin.jvm.internal.h.d(name, "fClass.name");
        this(str2, name, bundle, i, i2, i3, i4);
    }

    public final Fragment bf(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        Fragment instantiate;
        if (this.bbQ != null) {
            instantiate = Fragment.instantiate(context, this.bbP, this.bbQ);
            kotlin.jvm.internal.h.d(instantiate, "Fragment.instantiate(context, fClass, fArgs)");
            return instantiate;
        }
        instantiate = Fragment.instantiate(context, this.bbP);
        kotlin.jvm.internal.h.d(instantiate, "Fragment.instantiate(context, fClass)");
        return instantiate;
    }
}
