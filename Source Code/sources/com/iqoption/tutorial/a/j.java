package com.iqoption.tutorial.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.tutorial.utils.DialogOrientation;
import com.iqoption.tutorial.utils.PointerRotation;
import com.iqoption.tutorial.utils.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0004J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0015H\u0014J\b\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\u0015H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, aXE = {"Lcom/iqoption/tutorial/strategy/TutorialStrategy;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "coordinates", "", "calculatePosition", "Lcom/iqoption/tutorial/utils/TrainingPosition;", "activity", "Landroid/app/Activity;", "pointer", "Landroid/view/View;", "dialog", "dialogOrientation", "Lcom/iqoption/tutorial/utils/DialogOrientation;", "durations", "Lcom/iqoption/tutorial/utils/AnimDurations;", "endDelay", "", "findView", "viewId", "", "getViewPosition", "Landroid/graphics/Point;", "view", "message", "", "movingDuration", "pointerRotation", "Lcom/iqoption/tutorial/utils/PointerRotation;", "startDelay", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialStrategy.kt */
public abstract class j {
    public static final a duC = new a();
    private final Context context;
    private final int[] duB = new int[2];

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/tutorial/strategy/TutorialStrategy$Companion;", "", "()V", "COMMON_DELAY", "", "DURATION_LONG", "DURATION_MEDIUM", "FINGER_RATIO", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialStrategy.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public abstract b a(Activity activity, View view, View view2);

    public abstract DialogOrientation aFL();

    public abstract PointerRotation aFM();

    protected long aFN() {
        return 200;
    }

    protected long aFO() {
        return 1000;
    }

    protected long aFQ() {
        return 200;
    }

    public abstract String message();

    public j(Context context) {
        h.e(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    protected final Point bQ(View view) {
        h.e(view, Promotion.ACTION_VIEW);
        view.getLocationOnScreen(this.duB);
        return new Point(this.duB[0], this.duB[1]);
    }

    protected final View a(Activity activity, int i) {
        h.e(activity, "activity");
        return activity.findViewById(i);
    }

    public final com.iqoption.tutorial.utils.a aFP() {
        return new com.iqoption.tutorial.utils.a(aFO(), aFQ(), aFN());
    }
}
