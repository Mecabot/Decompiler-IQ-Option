package com.iqoption.fragment.leftpanel;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import com.iqoption.core.graphics.a.a.d;
import com.iqoption.core.graphics.c;
import com.iqoption.core.k;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a8\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H\u0002\u001a\u000e\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000e"}, aXE = {"getChatsDrawable", "Lcom/iqoption/core/graphics/drawable/DecoratedPathDrawable;", "res", "Lcom/iqoption/core/Resourcer;", "getDrawable", "staticResId", "", "circleColor", "centerOffsetX", "centerOffsetY", "getPortfolioDrawable", "getQuizInsightsDrawable", "getQuizUpdateDrawable", "getVideoEducationDrawable", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeftPanelDrawables.kt */
public final class a {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, aXE = {"com/iqoption/fragment/leftpanel/LeftPanelDrawablesKt$getDrawable$1", "Lcom/iqoption/core/graphics/drawable/DecoratedPathDrawable$Decoration;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "path", "Landroid/graphics/Path;", "progress", "", "onDrawOver", "onSetupPath", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelDrawables.kt */
    public static final class a implements d {
        final /* synthetic */ c cDh;
        final /* synthetic */ Path cDi;
        final /* synthetic */ float cDj;
        final /* synthetic */ float cDk;
        final /* synthetic */ float cDl;
        final /* synthetic */ float cDm;
        final /* synthetic */ Paint cDn;

        public void a(Canvas canvas, Path path, float f) {
            h.e(canvas, "canvas");
            h.e(path, "path");
        }

        a(c cVar, Path path, float f, float f2, float f3, float f4, Paint paint) {
            this.cDh = cVar;
            this.cDi = path;
            this.cDj = f;
            this.cDk = f2;
            this.cDl = f3;
            this.cDm = f4;
            this.cDn = paint;
        }

        public void a(Path path, float f) {
            h.e(path, "path");
            path.reset();
            path.addRect(0.0f, 0.0f, this.cDh.getWidth(), this.cDh.getHeight(), Direction.CW);
            if (f > ((float) 0)) {
                this.cDi.reset();
                this.cDi.addCircle(this.cDj, this.cDk, this.cDl * f, Direction.CW);
                path.op(this.cDi, Op.DIFFERENCE);
            }
        }

        public void b(Canvas canvas, Path path, float f) {
            h.e(canvas, "canvas");
            h.e(path, "path");
            canvas.drawCircle(this.cDj, this.cDk, this.cDm * f, this.cDn);
        }
    }

    public static final com.iqoption.core.graphics.a.a a(k kVar) {
        h.e(kVar, "res");
        return a(kVar, R.drawable.ic_portfolio, -1, R.dimen.dp0, R.dimen.dp5);
    }

    public static final com.iqoption.core.graphics.a.a b(k kVar) {
        h.e(kVar, "res");
        return a(kVar, R.drawable.ic_video_education, kVar.getColor(R.color.green), R.dimen.dp2, R.dimen.dp2);
    }

    public static final com.iqoption.core.graphics.a.a c(k kVar) {
        h.e(kVar, "res");
        return a(kVar, R.drawable.ic_chat, kVar.getColor(R.color.green), R.dimen.dp2, R.dimen.dp2);
    }

    public static final com.iqoption.core.graphics.a.a d(k kVar) {
        h.e(kVar, "res");
        return a(kVar, R.drawable.ic_quiz_left_panel_white_30dp, kVar.getColor(R.color.red), R.dimen.dp2, R.dimen.dp2);
    }

    public static final com.iqoption.core.graphics.a.a e(k kVar) {
        h.e(kVar, "res");
        return a(kVar, R.drawable.ic_quiz_left_panel_white_30dp, -1, R.dimen.dp2, R.dimen.dp2);
    }

    private static final com.iqoption.core.graphics.a.a a(k kVar, @DrawableRes int i, @ColorInt int i2, @DimenRes int i3, @DimenRes int i4) {
        Drawable a = com.iqoption.core.ext.a.a(kVar.getDrawable(i), kVar.dx(R.color.left_bar_icon_tint));
        c cVar = new c((float) a.getIntrinsicWidth(), (float) a.getIntrinsicHeight());
        Paint paint = new Paint(1);
        paint.setColor(i2);
        float dy = kVar.dy(R.dimen.dp3) + kVar.dy(R.dimen.dp0.5);
        return new com.iqoption.core.graphics.a.a(a, new a(cVar, new Path(), (cVar.getWidth() - dy) - kVar.dy(i3), dy + kVar.dy(i4), kVar.dy(R.dimen.dp6), dy, paint));
    }
}
