package com.iqoption.quiz;

import android.app.Activity;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import io.reactivex.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, aXE = {"Lcom/iqoption/quiz/QuizUtils;", "", "connectionState", "Lio/reactivex/Flowable;", "", "getActiveName", "", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getActiveShortName", "updateApp", "", "activity", "Landroid/app/Activity;", "quiz_release"})
/* compiled from: QuizUtils.kt */
public interface ad {
    e<Boolean> DH();

    String b(a aVar);

    String c(a aVar);

    void m(Activity activity);
}
