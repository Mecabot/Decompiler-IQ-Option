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
import com.iqoption.b.b;
import com.iqoption.charttools.model.indicator.i;
import com.iqoption.util.bg;
import com.iqoption.util.f;
import com.iqoption.view.d.d;
import com.iqoption.x.R;

public class ColorPickerView extends FrameLayout implements OnClickListener {
    public static final int[] mF = i.ayf;
    private int dAJ;
    private int dAK;
    private PopupWindow dAL;
    private View dAM;
    private RecyclerView dAN;
    private com.iqoption.a.d.a dAO;
    private RectF dAP;
    private float dAQ = 14.0f;
    private float dAR = 4.0f;
    private int dAS = 0;
    private a dAT;
    private int mDirection = 0;
    private Paint mPaint;

    public interface a {
        void dl(int i);
    }

    public void setOnColorChangeListener(a aVar) {
        this.dAT = aVar;
    }

    public int getSelectedColor() {
        if (this.dAS == -1) {
            return f.dG(this.mPaint.getColor());
        }
        return gL(this.dAS);
    }

    public void setSelectedColor(int i) {
        int i2 = 0;
        while (i2 < mF.length) {
            if (i == f.dG(mF[i2])) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 != -1) {
            gM(i2);
            return;
        }
        this.dAS = -1;
        this.mPaint.setColor(f.dH(i));
        this.dAO.cD(this.dAS);
        ViewCompat.postInvalidateOnAnimation(this);
        if (this.dAT != null) {
            this.dAT.dl(this.dAS);
        }
    }

    public ColorPickerView(Context context) {
        super(context);
        aId();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context, attributeSet);
        aId();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f(context, attributeSet);
        aId();
    }

    public static int gL(int i) {
        return f.dG(mF[i]);
    }

    private void f(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ColorPickerView);
            this.dAQ = obtainStyledAttributes.getDimension(3, 14.0f);
            this.dAR = obtainStyledAttributes.getDimension(2, 4.0f);
            this.dAS = gN(obtainStyledAttributes.getInt(0, 0));
            this.mDirection = obtainStyledAttributes.getInt(1, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private void aId() {
        aIe();
        this.dAP = new RectF(0.0f, 0.0f, this.dAQ, this.dAQ);
        this.mPaint = new Paint(5);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(mF[this.dAS]);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp35);
        int length = mF.length / 5;
        this.dAJ = dimensionPixelSize * 5;
        this.dAK = dimensionPixelSize * length;
        this.dAM = LayoutInflater.from(getContext()).inflate(R.layout.picker_popup, null);
        this.dAL = new PopupWindow(this.dAM, this.dAJ, this.dAK);
        this.dAL.setAnimationStyle(R.style.PickerPopup);
        this.dAL.setSplitTouchEnabled(false);
        this.dAL.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_tools_dialog));
        if (VERSION.SDK_INT >= 21) {
            this.dAL.setElevation((float) getResources().getDimensionPixelOffset(R.dimen.dp12));
        }
        this.dAL.setOutsideTouchable(true);
        this.dAL.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                ColorPickerView.this.setSelected(false);
                ColorPickerView.this.postDelayed(new Runnable() {
                    public void run() {
                        ColorPickerView.this.setOnClickListener(ColorPickerView.this);
                    }
                }, 500);
            }
        });
        this.dAN = (RecyclerView) this.dAM.findViewById(R.id.colorsList);
        this.dAO = new com.iqoption.a.d.a(new com.iqoption.a.b.a() {
            public void a(View view, int i) {
                ColorPickerView.this.gM(i);
                ColorPickerView.this.dAL.dismiss();
            }
        });
        this.dAO.setHasStableIds(true);
        this.dAO.cD(this.dAS);
        this.dAN.setLayoutManager(new GridLayoutManager(getContext(), 5));
        this.dAN.setItemAnimator(new DefaultItemAnimator());
        this.dAN.setAdapter(this.dAO);
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
        this.dAL.showAsDropDown(this, (getWidth() / 2) - (this.dAJ / 2), this.mDirection == 0 ? 0 : (this.dAK * -1) - getHeight());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        h(canvas);
        canvas.drawRoundRect(this.dAP, this.dAR, this.dAR, this.mPaint);
    }

    private void h(Canvas canvas) {
        this.dAP.set(((float) (canvas.getWidth() / 2)) - (this.dAQ / 2.0f), ((float) (canvas.getHeight() / 2)) - (this.dAQ / 2.0f), ((float) (canvas.getWidth() / 2)) + (this.dAQ / 2.0f), ((float) (canvas.getHeight() / 2)) + (this.dAQ / 2.0f));
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
                setElevation((float) getResources().getDimensionPixelSize(R.dimen.dp12));
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
        this.mPaint.setColor(mF[this.dAS]);
        this.dAO.cD(this.dAS);
        ViewCompat.postInvalidateOnAnimation(this);
        if (this.dAT != null) {
            this.dAT.dl(this.dAS);
        }
    }

    private int gN(int i) {
        return (i < 0 || i >= mF.length) ? 0 : i;
    }
}
