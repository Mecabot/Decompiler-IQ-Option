package com.iqoption.tutorial.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.iqoption.tutorial.utils.DialogOrientation;
import com.iqoption.tutorial.utils.PointerRotation;
import com.iqoption.tutorial.utils.b;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, aXE = {"Lcom/iqoption/tutorial/strategy/ChooseAssetStrategy;", "Lcom/iqoption/tutorial/strategy/TutorialStrategy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculatePosition", "Lcom/iqoption/tutorial/utils/TrainingPosition;", "activity", "Landroid/app/Activity;", "pointer", "Landroid/view/View;", "dialog", "dialogOrientation", "Lcom/iqoption/tutorial/utils/DialogOrientation;", "endDelay", "", "message", "", "movingDuration", "pointerRotation", "Lcom/iqoption/tutorial/utils/PointerRotation;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChooseAssetStrategy.kt */
public final class e extends j {
    protected long aFN() {
        return 0;
    }

    protected long aFO() {
        return 1500;
    }

    public e(Context context) {
        h.e(context, "context");
        super(context);
    }

    public DialogOrientation aFL() {
        return DialogOrientation.CHECK_MARK_RIGHT;
    }

    public PointerRotation aFM() {
        return PointerRotation.RIGHT_TO_LEFT;
    }

    public String message() {
        String string = getContext().getString(R.string.pick_an_asset_from_the_list);
        if (string == null) {
            h.aXZ();
        }
        return string;
    }

    public b a(Activity activity, View view, View view2) {
        h.e(activity, "activity");
        h.e(view, "pointer");
        h.e(view2, "dialog");
        View a = a(activity, R.id.assetList);
        if (a == null) {
            return null;
        }
        Point bQ = bQ(a);
        Resources resources = getContext().getResources();
        ViewParent parent = view2.getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        int width;
        float y;
        ViewGroup viewGroup = (ViewGroup) parent;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.dp4);
        int width2 = (bQ.x + a.getWidth()) - dimensionPixelOffset;
        float height = ((float) view.getHeight()) * 0.44f;
        float dimensionPixelOffset2 = ((float) (bQ.y + resources.getDimensionPixelOffset(R.dimen.dp10))) - height;
        int height2 = viewGroup.getHeight() - view.getHeight();
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.dp4);
        if (((view.getWidth() + width2) + dimensionPixelOffset3) + view2.getWidth() > viewGroup.getWidth()) {
            width = (viewGroup.getWidth() - view2.getWidth()) - dimensionPixelOffset3;
        } else {
            width = view.getWidth() + width2;
        }
        if ((dimensionPixelOffset2 - ((float) (dimensionPixelOffset3 * 2))) - ((float) view2.getHeight()) < ((float) 0)) {
            y = viewGroup.getY() + ((float) dimensionPixelOffset3);
        } else {
            y = (dimensionPixelOffset2 - ((float) view2.getHeight())) - ((float) dimensionPixelOffset3);
        }
        return new b(new Point(width2, (int) dimensionPixelOffset2), new Point(width2, height2), new Point(width, (int) y));
    }
}
