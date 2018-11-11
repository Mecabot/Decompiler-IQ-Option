package com.iqoption.tutorial.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.iqoption.tutorial.utils.DialogOrientation;
import com.iqoption.tutorial.utils.PointerRotation;
import com.iqoption.tutorial.utils.b;
import com.iqoption.x.R;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, aXE = {"Lcom/iqoption/tutorial/strategy/PracticeBalanceStrategy;", "Lcom/iqoption/tutorial/strategy/TutorialStrategy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculatePosition", "Lcom/iqoption/tutorial/utils/TrainingPosition;", "activity", "Landroid/app/Activity;", "pointer", "Landroid/view/View;", "dialog", "dialogOrientation", "Lcom/iqoption/tutorial/utils/DialogOrientation;", "message", "", "pointerRotation", "Lcom/iqoption/tutorial/utils/PointerRotation;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PracticeBalanceStrategy.kt */
public final class h extends j {
    public h(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        super(context);
    }

    public DialogOrientation aFL() {
        return DialogOrientation.CHECK_MARK_LEFT;
    }

    public PointerRotation aFM() {
        return PointerRotation.BOTTOM_TO_TOP;
    }

    public String message() {
        String string = getContext().getString(R.string.go_to_the_practice_balance);
        if (string == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return string;
    }

    public b a(Activity activity, View view, View view2) {
        kotlin.jvm.internal.h.e(activity, "activity");
        kotlin.jvm.internal.h.e(view, "pointer");
        kotlin.jvm.internal.h.e(view2, "dialog");
        View a = a(activity, R.id.totalBalanceTitle);
        if (a == null) {
            return null;
        }
        Point bQ = bQ(a);
        float width = (((float) bQ.x) + (((float) a.getWidth()) * 0.5f)) - (((float) view.getWidth()) * 0.44f);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.dp10);
        int height = (bQ.y + a.getHeight()) - dimensionPixelOffset;
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.dp30) + height;
        float width2 = (width - ((float) view2.getWidth())) + ((float) view.getWidth());
        int i = (int) width;
        return new b(new Point(i, height), new Point(i, dimensionPixelOffset2), new Point((int) width2, (view.getHeight() + dimensionPixelOffset2) - dimensionPixelOffset));
    }
}
