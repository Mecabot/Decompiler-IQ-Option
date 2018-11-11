package com.iqoption.deposit;

import android.content.Context;
import com.airbnb.lottie.a;
import com.airbnb.lottie.g;
import com.airbnb.lottie.r;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/deposit/CurrencyAnimation;", "", "path", "", "(Ljava/lang/String;)V", "load", "Lcom/airbnb/lottie/Cancellable;", "context", "Landroid/content/Context;", "loadedListener", "Lkotlin/Function1;", "Lcom/airbnb/lottie/LottieComposition;", "", "deposit_release"})
/* compiled from: CurrencyProgressAnimations.kt */
public final class b {
    private final String path;

    public b(String str) {
        h.e(str, "path");
        this.path = str;
    }

    public final a a(Context context, kotlin.jvm.a.b<? super g, l> bVar) {
        h.e(context, "context");
        h.e(bVar, "loadedListener");
        a a;
        if (u.a(this.path, "lottie/completion", false, 2, null)) {
            a = g.a.a(context, this.path, (r) new d(bVar));
            h.d(a, "LottieComposition.Factor…xt, path, loadedListener)");
            return a;
        }
        a = g.a.a((InputStream) new FileInputStream(this.path), (r) new d(bVar));
        h.d(a, "LottieComposition.Factor…am(path), loadedListener)");
        return a;
    }
}
