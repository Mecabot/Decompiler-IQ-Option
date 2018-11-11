package com.jumio.gui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.widget.Button;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.CompatibilityLayer;
import com.jumio.core.environment.Environment;

public class Drawables {
    public static final int DEFAULT_BUTTON_TEXT_COLOR = -419430401;
    public static final int DEFAULT_BUTTON_TEXT_COLOR_DISABLED = -1711276033;
    public static final int DEFAULT_BUTTON_TEXT_COLOR_PRESSED = -419430401;
    public static final int DEFAULT_LIST_ROW_COLOR = 0;
    public static final int DEFAULT_LIST_ROW_COLOR_DISABLED = 0;
    public static final int DEFAULT_LIST_ROW_COLOR_PRESSED = -3355444;
    public static final int GREEN_BUTTON_COLOR = -6832627;
    public static final int GREEN_BUTTON_COLOR_DISABLED = 1301790221;
    public static final int GREEN_BUTTON_COLOR_PRESSED = -9401334;
    public static final int LIGHTGRAY_BUTTON_COLOR = -10000537;
    public static final int LIGHTGRAY_BUTTON_COLOR_DISABLED = 1298622311;
    public static final int LIGHTGRAY_BUTTON_COLOR_PRESSED = -13421773;
    public static final int RED_BUTTON_COLOR = -4322035;
    public static final int RED_BUTTON_COLOR_DISABLED = 1304300813;
    public static final int RED_BUTTON_COLOR_PRESSED = -7665142;

    public static class ButtonColor {
        public ColorStateList background;
        public Drawable image;
        public ColorStateList text;
    }

    public static void styleButton(Context context, Button button, ButtonColor buttonColor) {
        Drawable drawable;
        if (buttonColor.image != null) {
            drawable = buttonColor.image;
        } else if (Environment.isLollipop()) {
            drawable = createRippleDrawable(context, buttonColor.background.getDefaultColor());
        } else {
            drawable = customButton(context, buttonColor.background);
        }
        CompatibilityLayer.setBackground(button, drawable);
        button.setTextColor(buttonColor.text);
    }

    public static ButtonColor parseButtonColor(Context context, int i, ColorStateList colorStateList, int i2, ColorStateList colorStateList2) {
        ButtonColor buttonColor = new ButtonColor();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i, i2});
        buttonColor.text = obtainStyledAttributes.getColorStateList(0);
        if (buttonColor.text == null) {
            i = obtainStyledAttributes.getColor(0, 0);
            if (i != 0) {
                buttonColor.text = ColorStateList.valueOf(i);
            } else {
                buttonColor.text = colorStateList;
            }
        }
        try {
            buttonColor.image = obtainStyledAttributes.getDrawable(i2);
        } catch (Exception unused) {
            buttonColor.image = null;
        }
        if (buttonColor.image == null) {
            buttonColor.background = obtainStyledAttributes.getColorStateList(i2);
            if (buttonColor.background == null) {
                i = obtainStyledAttributes.getColor(i2, 0);
                if (i != 0) {
                    buttonColor.background = ColorStateList.valueOf(i);
                } else {
                    buttonColor.background = colorStateList2;
                }
            }
        }
        obtainStyledAttributes.recycle();
        return buttonColor;
    }

    public static ColorStateList getDefaultTextColor() {
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842919};
        iArr[1] = new int[]{16842908};
        iArr[2] = new int[]{-16842910};
        iArr[3] = new int[0];
        return new ColorStateList(iArr, new int[]{-419430401, -419430401, DEFAULT_BUTTON_TEXT_COLOR_DISABLED, -419430401});
    }

    public static ColorStateList getGreenButtonColor() {
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842919};
        iArr[1] = new int[]{16842908};
        iArr[2] = new int[]{-16842910};
        iArr[3] = new int[0];
        return new ColorStateList(iArr, new int[]{GREEN_BUTTON_COLOR_PRESSED, GREEN_BUTTON_COLOR_PRESSED, GREEN_BUTTON_COLOR_DISABLED, -6832627});
    }

    public static ColorStateList getLightGreyButtonColor() {
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842919};
        iArr[1] = new int[]{16842908};
        iArr[2] = new int[]{-16842910};
        iArr[3] = new int[0];
        return new ColorStateList(iArr, new int[]{LIGHTGRAY_BUTTON_COLOR_PRESSED, LIGHTGRAY_BUTTON_COLOR_PRESSED, LIGHTGRAY_BUTTON_COLOR_DISABLED, LIGHTGRAY_BUTTON_COLOR});
    }

    public static ColorStateList getRedButtonColor() {
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842919};
        iArr[1] = new int[]{16842908};
        iArr[2] = new int[]{-16842910};
        iArr[3] = new int[0];
        return new ColorStateList(iArr, new int[]{RED_BUTTON_COLOR_PRESSED, RED_BUTTON_COLOR_PRESSED, RED_BUTTON_COLOR_DISABLED, RED_BUTTON_COLOR});
    }

    public static ColorStateList getDefaultListRowColor() {
        r1 = new int[3][];
        r1[0] = new int[]{16842919};
        r1[1] = new int[]{-16842910};
        r1[2] = new int[0];
        return new ColorStateList(r1, new int[]{DEFAULT_LIST_ROW_COLOR_PRESSED, 0, 0});
    }

    public static StateListDrawable customListRow(Context context, ColorStateList colorStateList) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = new int[]{16842919};
        Drawable generateRectDrawable = generateRectDrawable(context, colorStateList.getColorForState(iArr, DEFAULT_LIST_ROW_COLOR_PRESSED));
        stateListDrawable.addState(iArr, generateRectDrawable);
        stateListDrawable.addState(new int[]{16842908}, generateRectDrawable);
        int[] iArr2 = new int[]{-16842910};
        stateListDrawable.addState(iArr2, generateRectDrawable(context, colorStateList.getColorForState(iArr2, 0)));
        stateListDrawable.addState(new int[0], generateRectDrawable(context, colorStateList.getDefaultColor()));
        return stateListDrawable;
    }

    public static StateListDrawable customButton(Context context, ColorStateList colorStateList) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = new int[]{16842919};
        Drawable generateButtonDrawable = generateButtonDrawable(context, colorStateList.getColorForState(iArr, GREEN_BUTTON_COLOR_PRESSED));
        stateListDrawable.addState(iArr, generateButtonDrawable);
        stateListDrawable.addState(new int[]{16842908}, generateButtonDrawable);
        int[] iArr2 = new int[]{-16842910};
        stateListDrawable.addState(iArr2, generateButtonDrawable(context, colorStateList.getColorForState(iArr2, GREEN_BUTTON_COLOR_DISABLED)));
        stateListDrawable.addState(new int[0], generateButtonDrawable(context, colorStateList.getDefaultColor()));
        return stateListDrawable;
    }

    public static Drawable generateButtonDrawable(Context context, int i) {
        float dipToPx = ScreenUtil.dipToPx(context, 1.0f);
        float dipToPx2 = ScreenUtil.dipToPx(context, 2.0f);
        int dipToPx3 = (int) ScreenUtil.dipToPx(context, 10.0f);
        Shape roundRectShape = new RoundRectShape(new float[]{dipToPx2, dipToPx2, dipToPx2, dipToPx2, dipToPx2, dipToPx2, dipToPx2, dipToPx2}, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.setPadding(dipToPx3, dipToPx3, dipToPx3, dipToPx3);
        shapeDrawable.getPaint().setStyle(Style.FILL);
        shapeDrawable.getPaint().setColor(i);
        new ShapeDrawable(roundRectShape).getPaint().setColor(1073741824);
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{r13, shapeDrawable});
        dipToPx3 = (int) dipToPx;
        Drawable drawable = layerDrawable;
        drawable.setLayerInset(0, 0, dipToPx3, 0, 0);
        drawable.setLayerInset(1, 0, 0, 0, dipToPx3);
        return layerDrawable;
    }

    public static Drawable generateRectDrawable(Context context, int i) {
        int dipToPx = (int) ScreenUtil.dipToPx(context, 10.0f);
        Drawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.setPadding(dipToPx, dipToPx, dipToPx, dipToPx);
        shapeDrawable.getPaint().setStyle(Style.FILL);
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static Drawable Button_Help_Background(Context context, int i) {
        Drawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setStrokeWidth(ScreenUtil.dipToPx(context, 1.0f));
        return shapeDrawable;
    }

    public static Drawable createRippleDrawable(Context context, int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16843534});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return new LayerDrawable(new Drawable[]{colorDrawable, drawable});
    }
}
