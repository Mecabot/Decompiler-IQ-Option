package com.rd;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.rd.animation.type.AnimationType;
import com.rd.b.c;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.RtlMode;
import com.rd.draw.data.a;
import com.rd.draw.data.b;

public class PageIndicatorView extends View implements OnAdapterChangeListener, OnPageChangeListener, a {
    private ViewPager bGy;
    private a ehh;
    private DataSetObserver ehi;
    private boolean ehj;

    public PageIndicatorView(Context context) {
        super(context);
        init(null);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    @TargetApi(21)
    public PageIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(getParent());
    }

    protected void onDetachedFromWindow() {
        aSt();
        super.onDetachedFromWindow();
    }

    public Parcelable onSaveInstanceState() {
        a aSn = this.ehh.aSn();
        Parcelable bVar = new b(super.onSaveInstanceState());
        bVar.cD(aSn.aTe());
        bVar.iC(aSn.aTf());
        bVar.iD(aSn.aTg());
        return bVar;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof b) {
            a aSn = this.ehh.aSn();
            b bVar = (b) parcelable;
            aSn.cD(bVar.aTe());
            aSn.iC(bVar.aTf());
            aSn.iD(bVar.aTg());
            super.onRestoreInstanceState(bVar.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onMeasure(int i, int i2) {
        Pair aQ = this.ehh.aSo().aQ(i, i2);
        setMeasuredDimension(((Integer) aQ.first).intValue(), ((Integer) aQ.second).intValue());
    }

    protected void onDraw(Canvas canvas) {
        this.ehh.aSo().draw(canvas);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.ehh.aSo().d(motionEvent);
        return true;
    }

    public void aSp() {
        invalidate();
    }

    public void onPageScrolled(int i, float f, int i2) {
        f(i, f);
    }

    public void onPageSelected(int i) {
        ip(i);
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            this.ehh.aSn().setInteractiveAnimation(this.ehj);
        }
    }

    public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
        axR();
    }

    public void setCount(int i) {
        if (i >= 0 && this.ehh.aSn().getCount() != i) {
            this.ehh.aSn().setCount(i);
            aSu();
            requestLayout();
        }
    }

    public int getCount() {
        return this.ehh.aSn().getCount();
    }

    public void setDynamicCount(boolean z) {
        this.ehh.aSn().setDynamicCount(z);
        if (z) {
            aSs();
        } else {
            aSt();
        }
    }

    public void setRadius(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ehh.aSn().setRadius(com.rd.b.b.dpToPx(i));
        invalidate();
    }

    public void setRadius(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.ehh.aSn().setRadius((int) f);
        invalidate();
    }

    public int getRadius() {
        return this.ehh.aSn().getRadius();
    }

    public void setPadding(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ehh.aSn().setPadding(com.rd.b.b.dpToPx(i));
        invalidate();
    }

    public void setPadding(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.ehh.aSn().setPadding((int) f);
        invalidate();
    }

    public int getPadding() {
        return this.ehh.aSn().getPadding();
    }

    public void setScaleFactor(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.3f) {
            f = 0.3f;
        }
        this.ehh.aSn().setScaleFactor(f);
    }

    public float getScaleFactor() {
        return this.ehh.aSn().getScaleFactor();
    }

    public void setStrokeWidth(float f) {
        int radius = this.ehh.aSn().getRadius();
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            float f2 = (float) radius;
            if (f > f2) {
                f = f2;
            }
        }
        this.ehh.aSn().it((int) f);
        invalidate();
    }

    public void setStrokeWidth(int i) {
        i = com.rd.b.b.dpToPx(i);
        int radius = this.ehh.aSn().getRadius();
        if (i < 0) {
            i = 0;
        } else if (i > radius) {
            i = radius;
        }
        this.ehh.aSn().it(i);
        invalidate();
    }

    public int getStrokeWidth() {
        return this.ehh.aSn().aSS();
    }

    public void setSelectedColor(int i) {
        this.ehh.aSn().setSelectedColor(i);
        invalidate();
    }

    public int getSelectedColor() {
        return this.ehh.aSn().getSelectedColor();
    }

    public void setUnselectedColor(int i) {
        this.ehh.aSn().setUnselectedColor(i);
        invalidate();
    }

    public int getUnselectedColor() {
        return this.ehh.aSn().getUnselectedColor();
    }

    public void setAutoVisibility(boolean z) {
        if (!z) {
            setVisibility(0);
        }
        this.ehh.aSn().setAutoVisibility(z);
        aSu();
    }

    public void setOrientation(@Nullable Orientation orientation) {
        if (orientation != null) {
            this.ehh.aSn().setOrientation(orientation);
            requestLayout();
        }
    }

    public void setAnimationDuration(long j) {
        this.ehh.aSn().setAnimationDuration(j);
    }

    public long getAnimationDuration() {
        return this.ehh.aSn().getAnimationDuration();
    }

    public void setAnimationType(@Nullable AnimationType animationType) {
        this.ehh.a(null);
        if (animationType != null) {
            this.ehh.aSn().setAnimationType(animationType);
        } else {
            this.ehh.aSn().setAnimationType(AnimationType.NONE);
        }
        invalidate();
    }

    public void setInteractiveAnimation(boolean z) {
        this.ehh.aSn().setInteractiveAnimation(z);
        this.ehj = z;
    }

    public void setViewPager(@Nullable ViewPager viewPager) {
        aSq();
        if (viewPager != null) {
            this.bGy = viewPager;
            this.bGy.addOnPageChangeListener(this);
            this.bGy.addOnAdapterChangeListener(this);
            this.ehh.aSn().iE(this.bGy.getId());
            setDynamicCount(this.ehh.aSn().aTd());
            axR();
        }
    }

    public void aSq() {
        if (this.bGy != null) {
            this.bGy.removeOnPageChangeListener(this);
            this.bGy = null;
        }
    }

    public void setRtlMode(@Nullable RtlMode rtlMode) {
        a aSn = this.ehh.aSn();
        if (rtlMode == null) {
            aSn.setRtlMode(RtlMode.Off);
        } else {
            aSn.setRtlMode(rtlMode);
        }
        if (this.bGy != null) {
            int aTe = aSn.aTe();
            if (isRtl()) {
                aTe = (aSn.getCount() - 1) - aTe;
            } else if (this.bGy != null) {
                aTe = this.bGy.getCurrentItem();
            }
            aSn.iD(aTe);
            aSn.iC(aTe);
            aSn.cD(aTe);
            invalidate();
        }
    }

    public int getSelection() {
        return this.ehh.aSn().aTe();
    }

    public void setSelection(int i) {
        a aSn = this.ehh.aSn();
        i = iq(i);
        if (i != aSn.aTe() && i != aSn.aTf()) {
            aSn.setInteractiveAnimation(false);
            aSn.iD(aSn.aTe());
            aSn.iC(i);
            aSn.cD(i);
            this.ehh.aSm().aSw();
        }
    }

    public void setSelected(int i) {
        a aSn = this.ehh.aSn();
        AnimationType aTi = aSn.aTi();
        aSn.setAnimationType(AnimationType.NONE);
        setSelection(i);
        aSn.setAnimationType(aTi);
    }

    public void e(int i, float f) {
        a aSn = this.ehh.aSn();
        if (aSn.aTb()) {
            int count = aSn.getCount();
            if (count <= 0 || i < 0) {
                i = 0;
            } else {
                count--;
                if (i > count) {
                    i = count;
                }
            }
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            if (f == 1.0f) {
                aSn.iD(aSn.aTe());
                aSn.cD(i);
            }
            aSn.iC(i);
            this.ehh.aSm().V(f);
        }
    }

    public void setClickListener(@Nullable com.rd.draw.a.b.a aVar) {
        this.ehh.aSo().setClickListener(aVar);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        aSr();
        h(attributeSet);
    }

    private void aSr() {
        if (getId() == -1) {
            setId(c.generateViewId());
        }
    }

    private void h(@Nullable AttributeSet attributeSet) {
        this.ehh = new a(this);
        this.ehh.aSo().b(getContext(), attributeSet);
        a aSn = this.ehh.aSn();
        aSn.setPaddingLeft(getPaddingLeft());
        aSn.setPaddingTop(getPaddingTop());
        aSn.setPaddingRight(getPaddingRight());
        aSn.setPaddingBottom(getPaddingBottom());
        this.ehj = aSn.aTb();
    }

    private void aSs() {
        if (this.ehi == null && this.bGy != null && this.bGy.getAdapter() != null) {
            this.ehi = new DataSetObserver() {
                public void onChanged() {
                    PageIndicatorView.this.axR();
                }
            };
            try {
                this.bGy.getAdapter().registerDataSetObserver(this.ehi);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    private void aSt() {
        if (this.ehi != null && this.bGy != null && this.bGy.getAdapter() != null) {
            try {
                this.bGy.getAdapter().unregisterDataSetObserver(this.ehi);
                this.ehi = null;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    private void axR() {
        if (this.bGy != null && this.bGy.getAdapter() != null) {
            int count = this.bGy.getAdapter().getCount();
            int currentItem = isRtl() ? (count - 1) - this.bGy.getCurrentItem() : this.bGy.getCurrentItem();
            this.ehh.aSn().cD(currentItem);
            this.ehh.aSn().iC(currentItem);
            this.ehh.aSn().iD(currentItem);
            this.ehh.aSn().setCount(count);
            this.ehh.aSm().end();
            aSu();
            requestLayout();
        }
    }

    private void aSu() {
        if (this.ehh.aSn().aTc()) {
            int count = this.ehh.aSn().getCount();
            int visibility = getVisibility();
            if (visibility != 0 && count > 1) {
                setVisibility(0);
            } else if (visibility != 4 && count <= 1) {
                setVisibility(4);
            }
        }
    }

    private void ip(int i) {
        a aSn = this.ehh.aSn();
        boolean aSv = aSv();
        int count = aSn.getCount();
        if (aSv) {
            if (isRtl()) {
                i = (count - 1) - i;
            }
            setSelection(i);
        }
    }

    private void f(int i, float f) {
        a aSn = this.ehh.aSn();
        Object obj = (aSv() && aSn.aTb() && aSn.aTi() != AnimationType.NONE) ? 1 : null;
        if (obj != null) {
            Pair a = com.rd.b.a.a(aSn, i, f, isRtl());
            e(((Integer) a.first).intValue(), ((Float) a.second).floatValue());
        }
    }

    private boolean isRtl() {
        boolean z = true;
        switch (this.ehh.aSn().aTj()) {
            case On:
                return true;
            case Off:
                return false;
            case Auto:
                if (TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) != 1) {
                    z = false;
                }
                return z;
            default:
                return false;
        }
    }

    private boolean aSv() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    private void a(@Nullable ViewParent viewParent) {
        Object obj = (viewParent == null || !(viewParent instanceof ViewGroup) || ((ViewGroup) viewParent).getChildCount() <= 0) ? null : 1;
        if (obj != null) {
            ViewPager ai = ai((ViewGroup) viewParent, this.ehh.aSn().aTk());
            if (ai != null) {
                setViewPager(ai);
            } else {
                a(viewParent.getParent());
            }
        }
    }

    @Nullable
    private ViewPager ai(@NonNull ViewGroup viewGroup, int i) {
        if (viewGroup.getChildCount() <= 0) {
            return null;
        }
        View findViewById = viewGroup.findViewById(i);
        if (findViewById == null || !(findViewById instanceof ViewPager)) {
            return null;
        }
        return (ViewPager) findViewById;
    }

    private int iq(int i) {
        int count = this.ehh.aSn().getCount() - 1;
        if (i < 0) {
            return 0;
        }
        return i > count ? count : i;
    }
}
