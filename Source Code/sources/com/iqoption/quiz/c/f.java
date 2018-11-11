package com.iqoption.quiz.c;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/quiz/util/KeyboardController;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "hideKeyboard", "", "view", "Landroid/view/View;", "showKeyboard", "quiz_release"})
/* compiled from: KeyboardController.kt */
public final class f {
    private final Activity Cj;

    public f(Activity activity) {
        h.e(activity, "activity");
        this.Cj = activity;
    }

    public final void G(View view) {
        h.e(view, Promotion.ACTION_VIEW);
        Object systemService = this.Cj.getSystemService("input_method");
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }
}
