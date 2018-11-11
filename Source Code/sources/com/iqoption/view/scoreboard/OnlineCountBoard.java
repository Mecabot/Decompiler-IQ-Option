package com.iqoption.view.scoreboard;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.iqoption.b.b;
import com.iqoption.x.R;
import java.util.Locale;

public class OnlineCountBoard extends TextView {
    private float dDv;
    private float dDy = 1.0f;
    private float dDz = 0.0f;
    private Rect dEW = null;
    private Bitmap dIA = null;
    private String dIB = "%d";
    private int dIn = 0;
    private int dIo = 0;
    private Rect dIp = null;
    private int[] dIq = null;
    private ObjectAnimator dIr = null;
    private TypeEvaluator<int[]> dIs = null;
    private final String dIv = "0\n1\n2\n3\n4\n5\n6\n7\n8\n9";
    private Bitmap dIw = null;
    private Bitmap dIx = null;
    private Bitmap dIy = null;
    private Bitmap dIz = null;
    private TextPaint mTextPaint = null;

    public OnlineCountBoard(Context context) {
        super(context);
        initResource();
    }

    public OnlineCountBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        initResource();
    }

    public OnlineCountBoard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
        initResource();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.dDy = f2;
        this.dDz = f;
    }

    public int[] getOffset() {
        return this.dIq;
    }

    public void setOffset(int[] iArr) {
        this.dIq = iArr;
        invalidate();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.OnlineCountBoard, 0, 0);
        try {
            int i = obtainStyledAttributes.getInt(0, 0);
            if (i > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("%0");
                stringBuilder.append(i);
                stringBuilder.append('d');
                this.dIB = stringBuilder.toString();
            } else {
                this.dIB = "%d";
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    private void initResource() {
        this.dDv = getTextSize();
        this.mTextPaint = new TextPaint(getPaint());
        this.mTextPaint.setColor(getCurrentTextColor());
        this.dIw = BitmapFactory.decodeResource(getResources(), R.drawable.welcom_counter1);
        this.dIx = BitmapFactory.decodeResource(getResources(), R.drawable.welcom_counter2);
        this.dIy = BitmapFactory.decodeResource(getResources(), R.drawable.welcom_counter3);
        this.dIz = BitmapFactory.decodeResource(getResources(), R.drawable.welcom_counter1_5);
        StaticLayout staticLayout = new StaticLayout("0\n1\n2\n3\n4\n5\n6\n7\n8\n9", this.mTextPaint, (int) StaticLayout.getDesiredWidth("0\n1\n2\n3\n4\n5\n6\n7\n8\n9", this.mTextPaint), Alignment.ALIGN_NORMAL, this.dDy, this.dDz, true);
        this.dIA = Bitmap.createBitmap(staticLayout.getWidth(), staticLayout.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(this.dIA);
        if (!isInEditMode()) {
            staticLayout.draw(canvas);
        }
        this.dIn = staticLayout.getHeight() / 10;
        this.dIo = staticLayout.getWidth();
        this.dEW = new Rect(0, 0, this.dIo, this.dIz.getHeight());
        this.dIp = new Rect(0, 0, this.dIo, this.dIz.getHeight());
        this.dIr = new ObjectAnimator();
        this.dIr.setTarget(this);
        this.dIr.setPropertyName("offset");
        this.dIs = new TypeEvaluator<int[]>() {
            public int[] evaluate(float f, int[] iArr, int[] iArr2) {
                if (iArr == null || iArr2 == null) {
                    return null;
                }
                int[] iArr3 = new int[iArr2.length];
                int length = iArr2.length - 1;
                while (length >= 0) {
                    int a = iArr.length >= length + 1 ? iArr[length] : OnlineCountBoard.this.dIn * -1;
                    iArr3[length] = a + ((int) (((float) (iArr2[length] - a)) * f));
                    length--;
                }
                return iArr3;
            }
        };
    }

    protected void onDraw(Canvas canvas) {
        try {
            if (this.dDv != getTextSize() || this.dIA == null) {
                initResource();
            }
            if (this.dIA == null) {
                throw new NumberFormatException();
            } else if (TextUtils.isEmpty(getText())) {
                throw new NumberFormatException();
            } else {
                if (this.dIq == null) {
                    kd(getText().toString());
                }
                int length = this.dIq.length;
                length = (this.dIz.getHeight() - this.dIn) / 2;
                int i = 0;
                for (int i2 = 0; i2 < this.dIq.length; i2++) {
                    Bitmap bitmap;
                    this.dEW.top = this.dIq[i2];
                    this.dEW.bottom = this.dIq[i2] + this.dIn;
                    if (i2 == 0) {
                        bitmap = this.dIw;
                    } else if (i2 == this.dIq.length - 1) {
                        bitmap = this.dIy;
                    } else {
                        bitmap = this.dIx;
                    }
                    int i3 = 0 + i;
                    this.dIp.left = ((bitmap.getWidth() / 2) + i3) - (this.dIo / 2);
                    this.dIp.right = this.dIp.left + this.dIo;
                    this.dIp.top = (canvas.getHeight() - bitmap.getHeight()) + ((bitmap.getHeight() / 2) - (this.dIn / 2));
                    this.dIp.bottom = this.dIp.top + this.dIn;
                    canvas.drawBitmap(bitmap, (float) i3, (float) (canvas.getHeight() - bitmap.getHeight()), null);
                    canvas.drawBitmap(this.dIA, this.dEW, this.dIp, null);
                    if (i2 == this.dIq.length - 1) {
                        canvas.drawBitmap(this.dIz, (float) (i3 + ((bitmap.getWidth() / 2) - (this.dIz.getWidth() / 2))), (float) ((canvas.getHeight() - bitmap.getHeight()) + ((bitmap.getHeight() / 2) - (this.dIz.getHeight() / 2))), null);
                    }
                    i += bitmap.getWidth();
                }
            }
        } catch (NumberFormatException unused) {
            super.onDraw(canvas);
        }
    }

    private void kd(String str) {
        char[] toCharArray = str.toCharArray();
        if (this.dIq == null || this.dIq.length != toCharArray.length) {
            this.dIq = new int[toCharArray.length];
        }
        for (int length = toCharArray.length - 1; length >= 0; length--) {
            this.dIq[length] = Character.getNumericValue(toCharArray[length]) * this.dIn;
        }
    }

    private int[] ke(String str) {
        char[] toCharArray = str.toCharArray();
        int[] iArr = new int[toCharArray.length];
        for (int length = toCharArray.length - 1; length >= 0; length--) {
            iArr[length] = Character.getNumericValue(toCharArray[length]) * this.dIn;
        }
        return iArr;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.dIr == null || !(this.dIr.isRunning() || this.dIr.isStarted())) {
            try {
                kd(charSequence.toString());
                invalidate();
            } catch (Exception unused) {
            }
        }
    }

    public void s(int i, int i2, int i3) {
        c(String.format(Locale.US, this.dIB, new Object[]{Integer.valueOf(i)}), i2, i3);
    }

    private void c(String str, int i, int i2) {
        try {
            if (this.dIq == null) {
                kd(str);
            }
            int[] ke = ke(str);
            this.dIr.setObjectValues(new Object[]{ke});
            this.dIr.setEvaluator(this.dIs);
            this.dIr.setStartDelay((long) i);
            this.dIr.setDuration((long) i2);
            this.dIr.start();
        } catch (Exception unused) {
            setText(str);
        }
    }
}
