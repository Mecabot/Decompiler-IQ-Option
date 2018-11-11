package com.iqoption.chat;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.support.v4.content.res.ResourcesCompat;
import java.util.Arrays;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0016J;\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00112\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0014\"\u00020\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\n \u0012*\u0004\u0018\u00010\u001a0\u001aH\u0002J/\u0010\u001b\u001a\u00020\u00112\b\b\u0001\u0010\b\u001a\u00020\u00072\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0014\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0012 \u0012*\b\u0018\u00010\u001eR\u00020\u001a0\u001eR\u00020\u001aH\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, aXE = {"Lcom/iqoption/chat/Resourcer;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getColor", "", "id", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getPlural", "", "quantity", "formatQuantity", "", "getPluralFormat", "", "kotlin.jvm.PlatformType", "formatArgs", "", "(II[Ljava/lang/Object;)Ljava/lang/String;", "getPxFloat", "", "getPxInt", "getRes", "Landroid/content/res/Resources;", "getString", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getTheme", "Landroid/content/res/Resources$Theme;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChatUtils.kt */
public interface d {
    public static final a aCK = a.aCL;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/chat/Resourcer$Companion;", "", "()V", "create", "Lcom/iqoption/chat/Resourcer;", "context", "Landroid/content/Context;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatUtils.kt */
    public static final class a {
        static final /* synthetic */ a aCL = new a();

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"com/iqoption/chat/Resourcer$Companion$create$1", "Lcom/iqoption/chat/Resourcer;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: ChatUtils.kt */
        public static final class a implements d {
            final /* synthetic */ Context aCM;
            private final Context context;

            a(Context context) {
                this.aCM = context;
                this.context = context;
            }

            public String a(@PluralsRes int i, int i2, Object... objArr) {
                h.e(objArr, "formatArgs");
                return b.a(this, i, i2, objArr);
            }

            public int dr(@DimenRes int i) {
                return b.a(this, i);
            }

            public float ds(@DimenRes int i) {
                return b.b(this, i);
            }

            public int getColor(@ColorRes int i) {
                return b.c(this, i);
            }

            public Drawable getDrawable(@DrawableRes int i) {
                return b.d(this, i);
            }

            public String getString(@StringRes int i, Object... objArr) {
                h.e(objArr, "formatArgs");
                return b.a(this, i, objArr);
            }

            public Context getContext() {
                return this.context;
            }
        }

        private a() {
        }

        public final d ba(Context context) {
            h.e(context, "context");
            return new a(context);
        }
    }

    @i(aXC = {1, 1, 11})
    /* compiled from: ChatUtils.kt */
    public static final class b {
        private static Resources a(d dVar) {
            return dVar.getContext().getResources();
        }

        private static Theme b(d dVar) {
            return dVar.getContext().getTheme();
        }

        public static String a(d dVar, @StringRes int i, Object... objArr) {
            h.e(objArr, "formatArgs");
            String string = a(dVar).getString(i, Arrays.copyOf(objArr, objArr.length));
            h.d(string, "getRes().getString(id, *formatArgs)");
            return string;
        }

        public static int a(d dVar, @DimenRes int i) {
            return a(dVar).getDimensionPixelSize(i);
        }

        public static float b(d dVar, @DimenRes int i) {
            return a(dVar).getDimension(i);
        }

        public static int c(d dVar, @ColorRes int i) {
            return ResourcesCompat.getColor(a(dVar), i, b(dVar));
        }

        public static Drawable d(d dVar, @DrawableRes int i) {
            return ResourcesCompat.getDrawable(a(dVar), i, b(dVar));
        }

        public static String a(d dVar, @PluralsRes int i, int i2, Object... objArr) {
            h.e(objArr, "formatArgs");
            return a(dVar).getQuantityString(i, i2, Arrays.copyOf(objArr, objArr.length));
        }
    }

    String a(@PluralsRes int i, int i2, Object... objArr);

    int dr(@DimenRes int i);

    float ds(@DimenRes int i);

    int getColor(@ColorRes int i);

    Context getContext();

    Drawable getDrawable(@DrawableRes int i);

    String getString(@StringRes int i, Object... objArr);
}
