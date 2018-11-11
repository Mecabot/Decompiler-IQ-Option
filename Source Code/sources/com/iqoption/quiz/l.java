package com.iqoption.quiz;

import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/quiz/PrimaryContentDelegate;", "", "activity", "Lcom/iqoption/quiz/QuizActivity;", "content", "Landroid/view/View;", "(Lcom/iqoption/quiz/QuizActivity;Landroid/view/View;)V", "quiz_release"})
/* compiled from: PrimaryContentDelegate.kt */
public final class l {
    public l(QuizActivity quizActivity, View view) {
        h.e(quizActivity, "activity");
        h.e(view, b.CONTENT);
        h.r(quizActivity).l(new PrimaryContentDelegate$1(view));
    }
}
