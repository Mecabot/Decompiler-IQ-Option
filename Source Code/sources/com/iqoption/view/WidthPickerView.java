package com.iqoption.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.iqoption.a.d.b;
import com.iqoption.charttools.model.indicator.i;
import com.iqoption.util.bg;
import com.iqoption.view.d.d;
import com.iqoption.x.R;

public class WidthPickerView extends FrameLayout implements OnClickListener {
    public static float[] dEx;
    private int dAJ;
    private PopupWindow dAL;
    private View dAM;
    private int dAS = 0;
    private RectF dEA;
    private float dEB = 28.0f;
    private a dEC;
    private RecyclerView dEy;
    private b dEz;
    private int mDirection = 0;
    private Paint mPaint;

    public interface a {
        void dl(int i);
    }

    public void setOnWidthChangeListener(a aVar) {
        this.dEC = aVar;
    }

    public int getSelectedWidth() {
        return i.ayh[this.dAS];
    }

    public void setSelectedWidth(int i) {
        float a = com.iqoption.core.ext.a.a((View) this, (float) i);
        for (int i2 = 0; i2 < dEx.length; i2++) {
            if (a == dEx[i2]) {
                gM(i2);
                break;
            }
        }
        invalidate();
    }

    public WidthPickerView(Context context) {
        super(context);
        bW(context);
        aId();
    }

    public WidthPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bW(context);
        f(context, attributeSet);
        aId();
    }

    public WidthPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bW(context);
        f(context, attributeSet);
        aId();
    }

    private static void bW(Context context) {
        if (dEx == null) {
            dEx = new float[i.ayh.length];
            for (int i = 0; i < dEx.length; i++) {
                dEx[i] = com.iqoption.core.ext.a.a(context, (float) i.ayh[i]);
            }
        }
    }

    private void f(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            new int[1][0] = R.attr.selectableItemBackground;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.iqoption.b.b.WidthPickerView);
            this.dEB = obtainStyledAttributes.getDimension(2, 28.0f);
            this.dAS = gN(obtainStyledAttributes.getInt(0, 0));
            this.mDirection = obtainStyledAttributes.getInt(1, 0);
            setFocusable(true);
            setClickable(true);
            obtainStyledAttributes.recycle();
        }
    }

    private void aId() {
        aIe();
        this.dEA = new RectF(0.0f, 0.0f, this.dEB, this.dEB);
        this.mPaint = new Paint(5);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(dEx[this.dAS]);
        this.dAJ = getResources().getDimensionPixelOffset(R.dimen.dp180);
        this.dAM = LayoutInflater.from(getContext()).inflate(R.layout.picker_popup, null);
        this.dAL = new PopupWindow(this.dAM, this.dAJ, this.dAJ / 4);
        this.dAL.setAnimationStyle(R.style.PickerPopup);
        this.dAL.setSplitTouchEnabled(false);
        this.dAL.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_tools_dialog));
        if (VERSION.SDK_INT >= 21) {
            this.dAL.setElevation((float) getResources().getDimensionPixelOffset(R.dimen.dp12));
        }
        this.dAL.setOutsideTouchable(true);
        this.dAL.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                WidthPickerView.this.setSelected(false);
                WidthPickerView.this.postDelayed(new Runnable() {
                    public void run() {
                        WidthPickerView.this.setOnClickListener(WidthPickerView.this);
                    }
                }, 500);
            }
        });
        this.dEy = (RecyclerView) this.dAM.findViewById(R.id.colorsList);
        this.dEz = new b(new com.iqoption.a.b.a() {
            public void a(View view, int i) {
                WidthPickerView.this.gM(i);
                WidthPickerView.this.dAL.dismiss();
            }
        });
        this.dEz.setHasStableIds(true);
        this.dEz.cD(this.dAS);
        this.dEy.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.dEy.setItemAnimator(new DefaultItemAnimator());
        this.dEy.setAdapter(this.dEz);
        setSelected(isSelected());
        setOnClickListener(this);
        setOnTouchListener(new d(0.5f));
    }

    private void aIe() {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        View imageView = new ImageView(getContext());
        if (this.mDirection == 0) {
            bg.setBackground(this, ContextCompat.getDrawable(getContext(), R.drawable.bg_l1_down_color_picker));
            layoutParams.gravity = 85;
            imageView.setImageResource(R.drawable.bg_l2_down_color_picker);
        } else {
            bg.setBackground(this, ContextCompat.getDrawable(getContext(), R.drawable.bg_l1_up_color_picker));
            layoutParams.gravity = 53;
            imageView.setImageResource(R.drawable.bg_l2_up_color_picker);
        }
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
    }

    private void showPopup() {
        this.dAL.showAsDropDown(this, (getWidth() / 2) - (this.dAJ / 2), this.mDirection == 0 ? 0 : ((-this.dAJ) / 4) - getHeight());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        h(canvas);
        canvas.drawLine(this.dEA.left, this.dEA.top, this.dEA.right, this.dEA.bottom, this.mPaint);
    }

    private void h(Canvas canvas) {
        this.dEA.set(((float) (canvas.getWidth() / 2)) - (this.dEB / 2.0f), ((float) (canvas.getHeight() / 2)) - (dEx[this.dAS] / 2.0f), ((float) (canvas.getWidth() / 2)) + (this.dEB / 2.0f), ((float) (canvas.getHeight() / 2)) - (dEx[this.dAS] / 2.0f));
    }

    public void onClick(View view) {
        if (!isSelected()) {
            setSelected(true);
        }
        requestFocus();
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setOnClickListener(null);
            showPopup();
            if (VERSION.SDK_INT >= 21) {
                setElevation((float) getResources().getDimensionPixelSize(R.dimen.dp24));
            }
        } else {
            this.dAL.dismiss();
            if (VERSION.SDK_INT >= 21) {
                setElevation(0.0f);
            }
        }
        setAlpha(0.3f);
        animate().alpha(1.0f).setDuration(400).start();
    }

    public void setSelectedIndex(int i) {
        gM(i);
    }

    private void gM(int i) {
        this.dAS = gN(i);
        this.mPaint.setStrokeWidth(dEx[this.dAS]);
        this.dEz.cD(this.dAS);
        ViewCompat.postInvalidateOnAnimation(this);
        if (this.dEC != null) {
            this.dEC.dl(this.dAS);
        }
    }

    private int gN(int i) {
        return (i < 0 || i >= dEx.length) ? 0 : i;
    }
}
