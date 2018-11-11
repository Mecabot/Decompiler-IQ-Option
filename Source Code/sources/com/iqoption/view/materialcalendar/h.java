package com.iqoption.view.materialcalendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.text.SpannableString;
import android.text.Spanned;
import com.iqoption.util.ax;
import com.iqoption.view.materialcalendar.a.e;
import com.iqoption.x.R;

@SuppressLint({"ViewConstructor"})
/* compiled from: DayView */
class h extends AppCompatCheckedTextView {
    private int dGF = 4;
    private b dGU;
    private int dGV;
    private final int dGW = getResources().getDimensionPixelSize(R.dimen.dp2);
    private final int dGX = 200;
    private Drawable dGY = null;
    private Drawable dGZ;
    private Drawable dHa;
    private e dHb = e.dIc;
    private boolean dHc = true;
    private boolean dHd = true;
    private boolean dHe = false;
    private final Rect dHf = new Rect();

    void a(j jVar) {
    }

    public h(Context context, b bVar) {
        super(context);
        setGravity(17);
        setTextAlignment(4);
        f(bVar);
    }

    public void f(b bVar) {
        this.dGU = bVar;
        setText(getLabel());
    }

    public void setDayFormatter(e eVar) {
        if (eVar == null) {
            eVar = e.dIc;
        }
        this.dHb = eVar;
        CharSequence text = getText();
        Object[] objArr = null;
        if (text instanceof Spanned) {
            objArr = ((Spanned) text).getSpans(0, text.length(), Object.class);
        }
        text = new SpannableString(getLabel());
        if (objArr != null) {
            for (Object span : objArr) {
                text.setSpan(span, 0, text.length(), 33);
            }
        }
        setText(text);
    }

    @NonNull
    public String getLabel() {
        return this.dHb.n(this.dGU);
    }

    public void setSelectionColor(int i) {
        this.dGV = i;
        aJo();
    }

    public b aJm() {
        return this.dGU;
    }

    private void aJn() {
        int i = 0;
        int i2 = (this.dHd && this.dHc && !this.dHe) ? 1 : 0;
        boolean z = this.dHc && !this.dHe;
        super.setEnabled(z);
        z = MaterialCalendarView.hh(this.dGF);
        Object obj = (MaterialCalendarView.hi(this.dGF) || z) ? 1 : null;
        boolean hj = MaterialCalendarView.hj(this.dGF);
        if (!this.dHd && z) {
            i2 = 1;
        }
        if (!(this.dHc || obj == null)) {
            i2 |= this.dHd;
        }
        if (this.dHe && hj) {
            int i3 = (this.dHd && this.dHc) ? 1 : 0;
            i2 |= i3;
        }
        if (!(this.dHd || i2 == 0)) {
            setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
        }
        if (i2 == 0) {
            i = 4;
        }
        setVisibility(i);
    }

    protected void b(int i, boolean z, boolean z2) {
        this.dGF = i;
        this.dHd = z2;
        this.dHc = z;
        aJn();
    }

    protected void onDraw(@NonNull Canvas canvas) {
        if (this.dGY != null) {
            this.dGY.setState(getDrawableState());
            this.dGY.draw(canvas);
        }
        if (this.dHa != null) {
            this.dHa.setBounds(this.dHf);
        }
        super.onDraw(canvas);
    }

    private void aJo() {
        if (this.dGZ != null) {
            setBackground(this.dGZ);
            return;
        }
        this.dHa = a(this.dGV, 200, this.dHf);
        setBackground(this.dHa);
    }

    private static Drawable a(int i, int i2, Rect rect) {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(i2);
        stateListDrawable.addState(new int[]{16842912}, hg(i));
        stateListDrawable.addState(new int[]{16842919}, hg(i));
        stateListDrawable.addState(new int[0], hg(0));
        return stateListDrawable;
    }

    private static Drawable hg(int i) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        aE(i3 - i, i4 - i2);
    }

    private void aE(int i, int i2) {
        int min = Math.min(i2, i) - this.dGW;
        i = Math.abs(i - min) / 2;
        i2 = Math.abs(i2 - min) / 2;
        if (ax.dwr) {
            i /= 2;
        }
        if (ax.dwr) {
            i2 /= 2;
        }
        this.dHf.set(i, i2, min + i, min + i2);
    }
}
