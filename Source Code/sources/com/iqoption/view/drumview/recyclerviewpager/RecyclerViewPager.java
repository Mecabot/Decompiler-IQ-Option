package com.iqoption.view.drumview.recyclerviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.iqoption.b.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewPager extends RecyclerView {
    private float dFO;
    private float dFP;
    private float dFQ;
    private List<a> dFR;
    private int dFS;
    private int dFT;
    boolean dFU;
    int dFV;
    int dFW;
    View dFX;
    int dFY;
    int dFZ;
    int dGa;
    int dGb;
    int dGc;

    public interface a {
        void an(int i, int i2);
    }

    public RecyclerViewPager(Context context) {
        this(context, null);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dFO = 0.31f;
        this.dFP = 1.0f;
        this.dFS = -1;
        this.dFT = -1;
        this.dFY = Integer.MIN_VALUE;
        this.dFZ = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.dGa = Integer.MIN_VALUE;
        this.dGb = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.dGc = 0;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.RecyclerViewPager, i, 0);
        this.dFP = obtainStyledAttributes.getFloat(0, this.dFP);
        this.dFO = obtainStyledAttributes.getFloat(2, this.dFO);
        obtainStyledAttributes.recycle();
    }

    public int getMinPosition() {
        return this.dGc;
    }

    public void setMinPosition(int i) {
        this.dGc = i;
    }

    public void setFlingFactor(float f) {
        this.dFP = f;
    }

    public float getFlingFactor() {
        return this.dFP;
    }

    public void setTriggerOffset(float f) {
        this.dFO = f;
    }

    public float getTriggerOffset() {
        return this.dFO;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        try {
            Field declaredField = parcelable.getClass().getDeclaredField("mLayoutState");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(parcelable);
            Field declaredField2 = obj.getClass().getDeclaredField("mAnchorOffset");
            Field declaredField3 = obj.getClass().getDeclaredField("mAnchorPosition");
            declaredField3.setAccessible(true);
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) > 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) - 1));
            } else {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) + 1));
            }
            declaredField2.setInt(obj, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onRestoreInstanceState(parcelable);
    }

    public boolean fling(int i, int i2) {
        boolean fling = super.fling((int) (((float) i) * this.dFP), (int) (((float) i2) * this.dFP));
        if (fling) {
            if (getLayoutManager().canScrollHorizontally()) {
                hb(i);
            } else {
                hc(i2);
            }
        }
        return fling;
    }

    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
        this.dFS = i;
        if (this.dFR != null) {
            for (a aVar : this.dFR) {
                if (aVar != null) {
                    aVar.an(this.dFT, this.dFS);
                }
            }
        }
    }

    public int getCurrentPosition() {
        return getLayoutManager().canScrollHorizontally() ? a.k(this) : a.m(this);
    }

    public int getTargetPosition() {
        return this.dFS;
    }

    protected void hb(int i) {
        if (getChildCount() > 0) {
            int k = a.k(this);
            i = Math.min(Math.max(((int) ((((float) i) * this.dFP) / ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())))) + k, this.dGc), getAdapter().getItemCount() - 1);
            if (i == k) {
                View j = a.j(this);
                if (j != null) {
                    if (this.dFQ > ((float) j.getWidth()) * this.dFO && i > this.dGc) {
                        i--;
                    } else if (this.dFQ < ((float) j.getWidth()) * (-this.dFO) && i != getAdapter().getItemCount() - 1) {
                        i++;
                    }
                }
            }
            smoothScrollToPosition(aD(i, getAdapter().getItemCount()));
        }
    }

    protected void hc(int i) {
        if (getChildCount() > 0) {
            int m = a.m(this);
            i = Math.min(Math.max(((int) ((((float) i) * this.dFP) / ((float) ((getHeight() - getPaddingTop()) - getPaddingBottom())))) + m, this.dGc), getAdapter().getItemCount() - 1);
            if (i == m) {
                View l = a.l(this);
                if (l != null) {
                    if (this.dFQ > ((float) l.getHeight()) * this.dFO && i > this.dGc) {
                        i--;
                    } else if (this.dFQ < ((float) l.getHeight()) * (-this.dFO) && i != getAdapter().getItemCount() - 1) {
                        i++;
                    }
                }
            }
            smoothScrollToPosition(aD(i, getAdapter().getItemCount()));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.dFX != null) {
            this.dFY = Math.max(this.dFX.getLeft(), this.dFY);
            this.dGa = Math.max(this.dFX.getTop(), this.dGa);
            this.dFZ = Math.min(this.dFX.getLeft(), this.dFZ);
            this.dGb = Math.min(this.dFX.getTop(), this.dGb);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 1) {
            this.dFU = true;
            this.dFX = getLayoutManager().canScrollHorizontally() ? a.j(this) : a.l(this);
            if (this.dFX != null) {
                this.dFT = getChildLayoutPosition(this.dFX);
                this.dFV = this.dFX.getLeft();
                this.dFW = this.dFX.getTop();
            } else {
                this.dFT = -1;
            }
            this.dFQ = 0.0f;
        } else if (i == 2) {
            this.dFU = false;
            if (this.dFX == null) {
                this.dFQ = 0.0f;
            } else if (getLayoutManager().canScrollHorizontally()) {
                this.dFQ = (float) (this.dFX.getLeft() - this.dFV);
            } else {
                this.dFQ = (float) (this.dFX.getTop() - this.dFW);
            }
            this.dFX = null;
        } else if (i == 0) {
            if (this.dFU) {
                if (getLayoutManager().canScrollHorizontally()) {
                    i = a.k(this);
                } else {
                    i = a.m(this);
                }
                if (this.dFX != null) {
                    i = getChildAdapterPosition(this.dFX);
                    float left;
                    if (getLayoutManager().canScrollHorizontally()) {
                        left = (float) (this.dFX.getLeft() - this.dFV);
                        if (left > ((float) this.dFX.getWidth()) * this.dFO && this.dFX.getLeft() >= this.dFY) {
                            i--;
                        } else if (left < ((float) this.dFX.getWidth()) * (-this.dFO) && this.dFX.getLeft() <= this.dFZ) {
                            i++;
                        }
                    } else {
                        left = (float) (this.dFX.getTop() - this.dFW);
                        if (left > ((float) this.dFX.getHeight()) * this.dFO && this.dFX.getTop() >= this.dGa) {
                            i--;
                        } else if (left < ((float) this.dFX.getHeight()) * (-this.dFO) && this.dFX.getTop() <= this.dGb) {
                            i++;
                        }
                    }
                }
                smoothScrollToPosition(aD(i, getAdapter().getItemCount()));
                this.dFX = null;
            } else if (this.dFS != this.dFT) {
                if (this.dFR != null) {
                    for (a aVar : this.dFR) {
                        if (aVar != null) {
                            aVar.an(this.dFT, this.dFS);
                        }
                    }
                }
                this.dFT = this.dFS;
                smoothScrollToPosition(aD(this.dFS, getAdapter().getItemCount()));
            } else {
                smoothScrollToPosition(aD(this.dFT, getAdapter().getItemCount()));
            }
            this.dFY = Integer.MIN_VALUE;
            this.dFZ = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.dGa = Integer.MIN_VALUE;
            this.dGb = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public int aD(int i, int i2) {
        if (i < this.dGc) {
            return this.dGc;
        }
        return i >= i2 ? i2 - 1 : i;
    }

    public void a(a aVar) {
        if (this.dFR == null) {
            this.dFR = new ArrayList();
        }
        this.dFR.add(aVar);
    }
}
