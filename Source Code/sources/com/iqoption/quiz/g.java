package com.iqoption.quiz;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0006\u0010\u0015\u001a\u00020\u000eJ\u001a\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/quiz/KeyboardTracker;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "content", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isFix", "", "isKeyboardVisible", "listeners", "", "Lkotlin/Function1;", "", "addListener", "l", "computeUsableHeight", "", "notifyListeners", "onGlobalLayout", "release", "removeListener", "Companion", "quiz_release"})
/* compiled from: KeyboardTracker.kt */
public final class g implements OnGlobalLayoutListener {
    private static final Rect deK = new Rect();
    public static final a deL = new a();
    private final View awQ;
    private boolean deJ;
    private final Set<b<Boolean, l>> oE = new LinkedHashSet();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/quiz/KeyboardTracker$Companion;", "", "()V", "TEMP_RECT", "Landroid/graphics/Rect;", "quiz_release"})
    /* compiled from: KeyboardTracker.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public g(Activity activity) {
        h.e(activity, "activity");
        this.awQ = activity.findViewById(16908290);
        View view = this.awQ;
        h.d(view, FirebaseAnalytics.b.CONTENT);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        if (this.awQ != null) {
            int aad = aad();
            View rootView = this.awQ.getRootView();
            h.d(rootView, "content.rootView");
            int height = rootView.getHeight();
            if (height - aad > height / 4) {
                if (!this.deJ) {
                    this.deJ = true;
                    notifyListeners();
                }
            } else if (this.deJ) {
                this.deJ = false;
                notifyListeners();
            }
        }
    }

    private final int aad() {
        this.awQ.getWindowVisibleDisplayFrame(deK);
        Rect rect = deK;
        return rect.bottom - rect.top;
    }

    private final void notifyListeners() {
        for (b invoke : this.oE) {
            invoke.invoke(Boolean.valueOf(this.deJ));
        }
    }

    public final void l(b<? super Boolean, l> bVar) {
        h.e(bVar, "l");
        this.oE.add(bVar);
    }
}
