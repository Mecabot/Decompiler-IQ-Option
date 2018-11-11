package com.iqoption.widget.a;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.PopupWindowCompat;
import android.view.View;
import android.widget.PopupWindow;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/widget/window/OptionsWindow;", "", "()V", "isPrepared", "", "()Z", "isShowing", "window", "Landroid/widget/PopupWindow;", "dismiss", "", "prepare", "content", "Landroid/view/View;", "width", "", "height", "show", "anchor", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OptionsWindow.kt */
public final class a {
    private static final String TAG = "com.iqoption.widget.a.a";
    public static final a dPI = new a();
    private PopupWindow dPH;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/widget/window/OptionsWindow$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OptionsWindow.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final boolean isShowing() {
        PopupWindow popupWindow = this.dPH;
        return popupWindow != null ? popupWindow.isShowing() : false;
    }

    public final void g(View view, int i, int i2) {
        h.e(view, b.CONTENT);
        PopupWindow popupWindow = this.dPH;
        if (popupWindow == null) {
            popupWindow = new PopupWindow(view, i, i2, true);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            Drawable background = view.getBackground();
            if (background != null) {
                popupWindow.setBackgroundDrawable(background);
                view.setBackground((Drawable) null);
            } else {
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            }
            PopupWindowCompat.setOverlapAnchor(popupWindow, true);
            this.dPH = popupWindow;
            return;
        }
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        popupWindow.setContentView(view);
        popupWindow.setWidth(i);
        popupWindow.setHeight(i2);
    }

    public final void L(View view) {
        h.e(view, "anchor");
        PopupWindow popupWindow = this.dPH;
        if (popupWindow == null) {
            throw new IllegalStateException("Window is not prepared to be shown");
        }
        popupWindow.showAsDropDown(view);
    }

    public final void dismiss() {
        PopupWindow popupWindow = this.dPH;
        if (popupWindow == null) {
            com.iqoption.core.i.w(TAG, "Window is not prepared to be dismissed");
        } else {
            popupWindow.dismiss();
        }
    }
}
