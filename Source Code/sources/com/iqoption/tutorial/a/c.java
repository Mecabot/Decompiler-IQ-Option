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
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, aXE = {"Lcom/iqoption/tutorial/strategy/CallPutStrategy;", "Lcom/iqoption/tutorial/strategy/TutorialStrategy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculatePosition", "Lcom/iqoption/tutorial/utils/TrainingPosition;", "activity", "Landroid/app/Activity;", "pointer", "Landroid/view/View;", "dialog", "dialogOrientation", "Lcom/iqoption/tutorial/utils/DialogOrientation;", "message", "", "pointerRotation", "Lcom/iqoption/tutorial/utils/PointerRotation;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CallPutStrategy.kt */
public class c extends j {
    public c(Context context) {
        h.e(context, "context");
        super(context);
    }

    public DialogOrientation aFL() {
        return DialogOrientation.CHECK_MARK_LEFT;
    }

    public PointerRotation aFM() {
        return PointerRotation.LEFT_TO_RIGHT;
    }

    public String message() {
        String string = getContext().getString(R.string.make_a_trade_based_on_trend);
        if (string == null) {
            h.aXZ();
        }
        return string;
    }

    public b a(Activity activity, View view, View view2) {
        h.e(activity, "activity");
        h.e(view, "pointer");
        h.e(view2, "dialog");
        View a = a(activity, R.id.buttonCall);
        if (a == null) {
            return null;
        }
        View a2 = a(activity, R.id.buttonPut);
        if (a2 == null) {
            return null;
        }
        Point bQ = bQ(a);
        Point bQ2 = bQ(a2);
        int height = a.getHeight();
        int height2 = a2.getHeight();
        float height3 = ((float) view.getHeight()) * 0.44f;
        int width = bQ.x - view.getWidth();
        float f = (((float) bQ2.y) + ((float) (height2 / 2))) - height3;
        int i = (((bQ2.y + height2) - bQ.y) / 2) + bQ.y;
        return new b(new Point(width, (int) (((float) (bQ.y + (height / 2))) - height3)), new Point(width, (int) f), new Point(((bQ.x - view2.getWidth()) - view.getWidth()) - getContext().getResources().getDimensionPixelOffset(R.dimen.dp4), i - (view2.getHeight() / 2)));
    }
}
