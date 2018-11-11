package com.iqoption.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.iqoption.util.be;

public class RadioGroupNested extends LinearLayout {
    private int dOO = -1;
    private OnCheckedChangeListener dOP;
    private boolean dOQ = false;
    private c dOR;
    private d dOS;

    private class a implements OnCheckedChangeListener {
        private a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!RadioGroupNested.this.dOQ) {
                RadioGroupNested.this.dOQ = true;
                if (RadioGroupNested.this.dOO != -1) {
                    RadioGroupNested.this.v(RadioGroupNested.this.dOO, false);
                }
                RadioGroupNested.this.dOQ = false;
                RadioGroupNested.this.setCheckedId(compoundButton.getId());
            }
        }
    }

    public static class b extends LayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                this.width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                this.width = -2;
            }
            if (typedArray.hasValue(i2)) {
                this.height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    public interface c {
        void b(RadioGroupNested radioGroupNested, @IdRes int i);
    }

    private class d implements OnHierarchyChangeListener {
        private OnHierarchyChangeListener mOnHierarchyChangeListener;

        private d() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == RadioGroupNested.this && !cz(view2) && (view2 instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int i = 0;
                while (i < viewGroup.getChildCount() && !cz(viewGroup.getChildAt(i))) {
                    i++;
                }
            }
            if (this.mOnHierarchyChangeListener != null) {
                this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        private boolean cz(View view) {
            if (!(view instanceof RadioButton)) {
                return false;
            }
            if (view.getId() == -1) {
                int generateViewId;
                if (VERSION.SDK_INT >= 17) {
                    generateViewId = View.generateViewId();
                } else {
                    generateViewId = Long.valueOf(be.aGA()).hashCode();
                }
                view.setId(generateViewId);
            }
            ((RadioButton) view).setOnCheckedChangeListener(RadioGroupNested.this.dOP);
            return true;
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == RadioGroupNested.this && !cA(view2) && (view2 instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int i = 0;
                while (i < viewGroup.getChildCount() && !cA(viewGroup.getChildAt(i))) {
                    i++;
                }
            }
            if (this.mOnHierarchyChangeListener != null) {
                this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        private boolean cA(View view) {
            if (!(view instanceof RadioButton)) {
                return false;
            }
            ((RadioButton) view).setOnCheckedChangeListener(null);
            return true;
        }
    }

    public RadioGroupNested(Context context) {
        super(context);
        setOrientation(1);
        init();
    }

    public RadioGroupNested(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        init();
    }

    private void init() {
        this.dOP = new a();
        this.dOS = new d();
        super.setOnHierarchyChangeListener(this.dOS);
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.dOS.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.dOO != -1) {
            this.dOQ = true;
            v(this.dOO, true);
            this.dOQ = false;
            setCheckedId(this.dOO);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!cy(view) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            while (i2 < viewGroup.getChildCount() && !cy(viewGroup.getChildAt(i2))) {
                i2++;
            }
        }
        super.addView(view, i, layoutParams);
    }

    private boolean cy(View view) {
        if (!(view instanceof RadioButton)) {
            return false;
        }
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.dOQ = true;
            if (this.dOO != -1) {
                v(this.dOO, false);
            }
            this.dOQ = false;
            setCheckedId(radioButton.getId());
        }
        return true;
    }

    private void setCheckedId(@IdRes int i) {
        this.dOO = i;
        if (this.dOR != null) {
            this.dOR.b(this, this.dOO);
        }
    }

    private void v(int i, boolean z) {
        View hx = hx(i);
        if (hx != null && (hx instanceof RadioButton)) {
            ((RadioButton) hx).setChecked(z);
        }
    }

    public View hx(@IdRes int i) {
        if (i == getId()) {
            return this;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View findViewById = getChildAt(i2).findViewById(i);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }

    @IdRes
    public int getCheckedRadioButtonId() {
        return this.dOO;
    }

    public void setOnCheckedChangeListener(c cVar) {
        this.dOR = cVar;
    }

    /* renamed from: g */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof RadioGroup.LayoutParams;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    public CharSequence getAccessibilityClassName() {
        return RadioGroup.class.getName();
    }
}
