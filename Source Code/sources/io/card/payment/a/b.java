package io.card.payment.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;

/* compiled from: Appearance */
public class b {
    public static final int[] elA = new int[]{16842908};
    public static final int elB = Color.parseColor("#003087");
    public static final int elC = Color.parseColor("#009CDE");
    public static final int elD = Color.parseColor("#aa009CDE");
    public static final Drawable elE = new ColorDrawable(Color.parseColor("#717074"));
    public static final int elF = Color.parseColor("#f5f5f5");
    public static final int elG = elC;
    public static final int elH = elD;
    public static final int elI = elB;
    public static final int elJ = Color.parseColor("#c5ddeb");
    public static final int elK = Color.parseColor("#717074");
    public static final int elL = Color.parseColor("#aa717074");
    public static final int elM = Color.parseColor("#5a5a5d");
    public static final int elN = Color.parseColor("#f5f5f5");
    public static final int elO = Color.parseColor("#515151");
    public static final int elP = Color.parseColor("#b32317");
    public static final int elQ = elO;
    public static final Typeface elR = aUb();
    public static final int[] elx = new int[]{16842919, 16842910};
    public static final int[] ely = new int[]{16842910};
    public static final int[] elz = new int[]{-16842910};

    public static Drawable cm(Context context) {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(elx, new ColorDrawable(elI));
        stateListDrawable.addState(elz, new ColorDrawable(elJ));
        stateListDrawable.addState(elA, cp(context));
        stateListDrawable.addState(ely, co(context));
        return stateListDrawable;
    }

    private static float cn(Context context) {
        return (c.g("4dip", context) / 2.0f) * context.getResources().getDisplayMetrics().density;
    }

    private static Drawable co(Context context) {
        return g(elG, cn(context));
    }

    private static Drawable cp(Context context) {
        return b(elG, elH, cn(context));
    }

    public static Drawable cq(Context context) {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(elx, new ColorDrawable(elM));
        stateListDrawable.addState(elz, new ColorDrawable(elN));
        stateListDrawable.addState(elA, cs(context));
        stateListDrawable.addState(ely, cr(context));
        return stateListDrawable;
    }

    private static Drawable cr(Context context) {
        return g(elK, cn(context));
    }

    private static Drawable cs(Context context) {
        return b(elK, elL, cn(context));
    }

    private static Drawable g(int i, float f) {
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = new ColorDrawable(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(f * 2.0f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(elF);
        drawableArr[1] = shapeDrawable;
        return new LayerDrawable(drawableArr);
    }

    private static Drawable b(int i, int i2, float f) {
        Drawable[] drawableArr = new Drawable[3];
        drawableArr[0] = new ColorDrawable(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(2.0f * f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(elF);
        drawableArr[1] = shapeDrawable;
        shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(i2);
        drawableArr[2] = shapeDrawable;
        return new LayerDrawable(drawableArr);
    }

    private static Typeface aUb() {
        return Typeface.create("sans-serif-light", 0);
    }
}
