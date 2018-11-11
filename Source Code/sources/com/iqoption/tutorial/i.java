package com.iqoption.tutorial;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import com.iqoption.dto.IconSettings;
import com.iqoption.dto.ToastEntity;
import com.iqoption.x.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, aXE = {"createToast", "Lcom/iqoption/dto/ToastEntity;", "context", "Landroid/content/Context;", "toastType", "Lcom/iqoption/tutorial/ToastType;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialToasts.kt */
public final class i {
    public static final ToastEntity a(Context context, ToastType toastType) {
        int i;
        int i2;
        h.e(context, "context");
        h.e(toastType, "toastType");
        switch (j.aoS[toastType.ordinal()]) {
            case 1:
                i = R.string.well_done_thumbs_up;
                break;
            case 2:
                i = R.string.you_are_all_set_smile;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        switch (j.auk[toastType.ordinal()]) {
            case 1:
                i2 = R.drawable.thumbs_up;
                break;
            case 2:
                i2 = R.drawable.smiling_face_with_smiling_eyes;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Resources resources = context.getResources();
        return new ToastEntity(R.drawable.local_toast_type_indicator_green, (long) i, "", context.getString(i, new Object[]{Integer.valueOf(i2)}), (long) ToastEntity.TOAST_DURATION, null, Integer.valueOf(R.style.TutorialToastTextAppearance), new IconSettings(i2, new Point(resources.getDimensionPixelSize(R.dimen.dp32), resources.getDimensionPixelSize(R.dimen.dp32))));
    }
}
