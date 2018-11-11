package com.iqoption.core.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.iqoption.core.i;
import com.iqoption.core.j.c;
import com.iqoption.core.j.g;

public final class StarBar extends View {
    private static final String TAG = "com.iqoption.core.ui.widget.StarBar";
    private int bel;
    private Drawable bem;
    private Drawable ben;
    private float beo;
    private final int bep = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    private boolean beq = false;
    private float ber;
    private int bes;
    private int bet = -1;
    private b beu;

    private static final class a {
        final Drawable bem;
        final Drawable ben;
        final float beo;
        final int bet;
        final int bev;
        final int bew;
        final int bex;
        final int bey;

        a(Context context, @Nullable AttributeSet attributeSet) {
            if (attributeSet == null) {
                this.bem = new ColorDrawable(0);
                this.ben = this.bem;
                this.beo = 0.0f;
                this.bex = 0;
                this.bet = 0;
                this.bey = 0;
                this.bev = 0;
                this.bew = 0;
                return;
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.StarBar);
            this.bem = AppCompatResources.getDrawable(context, obtainStyledAttributes.getResourceId(g.StarBar_starFull, c.ic_star_black_24dp));
            this.ben = AppCompatResources.getDrawable(context, obtainStyledAttributes.getResourceId(g.StarBar_starEmpty, c.ic_star_black_24dp));
            this.beo = obtainStyledAttributes.getDimension(g.StarBar_starOffset, 0.0f);
            this.bex = obtainStyledAttributes.getInt(g.StarBar_starNum, 0);
            this.bet = obtainStyledAttributes.getDimensionPixelSize(g.StarBar_starWidth, 0);
            this.bey = obtainStyledAttributes.getDimensionPixelSize(g.StarBar_starHeight, 0);
            this.bev = obtainStyledAttributes.getColor(g.StarBar_starFullTint, 0);
            this.bew = obtainStyledAttributes.getColor(g.StarBar_starEmptyTint, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public interface b {
        void dv(int i);
    }

    public StarBar(Context context) {
        super(context);
        a(new a(context, null));
    }

    public StarBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(new a(context, attributeSet));
    }

    public StarBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(new a(context, attributeSet));
    }

    @TargetApi(21)
    public StarBar(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(new a(context, attributeSet));
    }

    public void setStars(int i) {
        if (this.bel != i) {
            this.bel = i;
            invalidate();
        }
    }

    public int getStars() {
        return this.bel;
    }

    public void setOnStarsChangedListener(b bVar) {
        this.beu = bVar;
    }

    private static Drawable c(Drawable drawable, int i) {
        drawable = DrawableCompat.wrap(drawable.mutate());
        if (i == 0) {
            return drawable;
        }
        DrawableCompat.setTint(drawable, i);
        return drawable;
    }

    private void a(@NonNull a aVar) {
        Rect rect;
        this.bem = c(aVar.bem, aVar.bev);
        this.ben = c(aVar.ben, aVar.bew);
        this.beo = aVar.beo;
        this.bel = aVar.bex;
        if (aVar.bet == 0 || aVar.bey == 0) {
            rect = new Rect(0, 0, this.bem.getIntrinsicWidth(), this.bem.getIntrinsicHeight());
        } else {
            rect = new Rect(0, 0, aVar.bet, aVar.bey);
        }
        this.bem.setBounds(rect);
        this.ben.setBounds(rect);
        this.bet = this.bem.getBounds().width();
    }

    protected void onMeasure(int i, int i2) {
        i2 = 0;
        if (this.bem != null) {
            Rect bounds = this.bem.getBounds();
            i2 = bounds.width();
            i = bounds.height();
        } else {
            i = 0;
        }
        setMeasuredDimension((int) (((((float) (i2 * 5)) + (this.beo * 4.0f)) + ((float) ViewCompat.getPaddingStart(this))) + ((float) ViewCompat.getPaddingEnd(this))), (i + getPaddingTop()) + getPaddingBottom());
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.bem.setAlpha(255);
            this.ben.setAlpha(255);
            return;
        }
        this.bem.setAlpha(100);
        this.ben.setAlpha(100);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate((float) ViewCompat.getPaddingStart(this), (float) getPaddingTop());
        int i = 0;
        while (i < 5) {
            Drawable drawable;
            i++;
            if (this.bel >= i) {
                drawable = this.bem;
            } else {
                drawable = this.ben;
            }
            drawable.draw(canvas);
            canvas.translate(((float) drawable.getBounds().width()) + this.beo, 0.0f);
        }
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        boolean z = true;
        int b;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.ber = motionEvent.getX();
                this.bes = getStars();
                break;
            case 1:
                int stars = getStars();
                b = b(motionEvent);
                if (this.bes != stars) {
                    if (this.beu != null) {
                        this.beu.dv(b);
                    }
                } else if (stars != b) {
                    setStars(b);
                    if (this.beu != null) {
                        this.beu.dv(b);
                    }
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                this.beq = false;
                break;
            case 2:
                if (!this.beq && Math.abs(motionEvent.getX() - this.ber) > ((float) this.bep)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.beq = true;
                }
                if (this.beq) {
                    b = b(motionEvent);
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("current star: ");
                    stringBuilder.append(b);
                    i.d(str, stringBuilder.toString());
                    setStars(b);
                    break;
                }
                return false;
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                this.beq = false;
                break;
        }
        z = false;
        return z;
    }

    private int b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float paddingStart = (float) ViewCompat.getPaddingStart(this);
        if (x <= paddingStart) {
            return 0;
        }
        x -= paddingStart;
        int i = 1;
        while (i < 5 && x > ((float) this.bet) + this.beo) {
            x -= ((float) this.bet) + this.beo;
            i++;
        }
        return i;
    }
}
