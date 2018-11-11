package com.iqoption.quiz;

import android.app.Activity;
import java.util.WeakHashMap;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"trackerMap", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Lcom/iqoption/quiz/KeyboardTracker;", "getKeyboardTracker", "activity", "quiz_release"})
/* compiled from: KeyboardTracker.kt */
public final class h {
    private static final WeakHashMap<Activity, g> deM = new WeakHashMap();

    public static final g r(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
        g gVar = (g) deM.get(activity);
        if (gVar != null) {
            return gVar;
        }
        gVar = new g(activity);
        deM.put(activity, gVar);
        return gVar;
    }
}
