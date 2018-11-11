package com.iqoption.tutorial.a;

import android.content.Context;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.tutorial.dictionary.TutorialAction;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, aXE = {"Lcom/iqoption/tutorial/strategy/TutorialStrategyFactory;", "", "()V", "createStrategy", "Lcom/iqoption/tutorial/strategy/TutorialStrategy;", "context", "Landroid/content/Context;", "type", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialStrategyFactory.kt */
public final class k {
    public final j a(Context context, TutorialAction tutorialAction) {
        h.e(context, "context");
        h.e(tutorialAction, Param.TYPE);
        switch (l.aoS[tutorialAction.ordinal()]) {
            case 1:
                return new h(context);
            case 2:
                return new i(context);
            case 3:
                return new c(context);
            case 4:
                return new b(context);
            case 5:
                return new a(context);
            case 6:
                return new f(context);
            case 7:
                return new e(context);
            case 8:
                return new d(context);
            case 9:
                return new g(context);
            default:
                return null;
        }
    }
}
