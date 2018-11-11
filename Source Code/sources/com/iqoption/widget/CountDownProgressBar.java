package com.iqoption.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CountDownProgressBar extends FrameLayout {
    private static int dou = 100;
    private static final int dov = (1000 / dou);
    private ProgressBar Hw;
    private TextView bKT;
    private CountDownTimer cLO;
    private b dNO;
    private int doA = -1;
    private boolean doB;
    private Drawable doD;
    private View doF;
    private int dox = 30;
    private int doy;
    private int doz = -1;

    private static class a extends CountDownTimer {
        private final WeakReference<CountDownProgressBar> doG;
        private final Animator doH;
        private int doI;

        public a(long j, Animator animator, CountDownProgressBar countDownProgressBar) {
            super(j, (long) CountDownProgressBar.dou);
            this.doG = new WeakReference(countDownProgressBar);
            this.doH = animator;
        }

        public void onTick(long j) {
            CountDownProgressBar countDownProgressBar = (CountDownProgressBar) this.doG.get();
            if (countDownProgressBar != null) {
                countDownProgressBar.Hw.setProgress((int) j);
                int i = this.doI + 1;
                this.doI = i;
                if (i == CountDownProgressBar.dov) {
                    countDownProgressBar.bKT.setText(countDownProgressBar.bA(j));
                    this.doI = 0;
                    if (TimeUnit.MILLISECONDS.toSeconds(j) <= ((long) countDownProgressBar.dox) && !countDownProgressBar.doB) {
                        countDownProgressBar.bKT.setTextColor(countDownProgressBar.doA);
                        this.doH.start();
                        countDownProgressBar.doB = true;
                    }
                }
            }
        }

        public void onFinish() {
            CountDownProgressBar countDownProgressBar = (CountDownProgressBar) this.doG.get();
            if (countDownProgressBar != null) {
                countDownProgressBar.bKT.setText(countDownProgressBar.bA(0));
                countDownProgressBar.Hw.setProgress(0);
                this.doH.end();
                if (countDownProgressBar.dNO != null) {
                    countDownProgressBar.dNO.a(countDownProgressBar);
                }
            }
        }
    }

    public interface b {
        void a(CountDownProgressBar countDownProgressBar);
    }

    private static class c implements b {
        private final View mHostView;
        private Method mMethod;
        private final String mMethodName;

        public c(@NonNull View view, @NonNull String str) {
            this.mHostView = view;
            this.mMethodName = str;
        }

        public void a(@NonNull CountDownProgressBar countDownProgressBar) {
            if (this.mMethod == null) {
                this.mMethod = E(this.mHostView.getContext(), this.mMethodName);
            }
            try {
                this.mMethod.invoke(this.mHostView.getContext(), new Object[]{countDownProgressBar});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        @NonNull
        private Method E(@Nullable Context context, @NonNull String str) {
            String str2;
            while (context != null) {
                try {
                    if (!context.isRestricted()) {
                        return context.getClass().getMethod(this.mMethodName, new Class[]{CountDownProgressBar.class});
                    }
                } catch (NoSuchMethodException unused) {
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
            }
            int id = this.mHostView.getId();
            if (id == -1) {
                str2 = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" with id '");
                stringBuilder.append(this.mHostView.getContext().getResources().getResourceEntryName(id));
                stringBuilder.append("'");
                str2 = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Could not find method ");
            stringBuilder2.append(this.mMethodName);
            stringBuilder2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
            stringBuilder2.append(this.mHostView.getClass());
            stringBuilder2.append(str2);
            throw new IllegalStateException(stringBuilder2.toString());
        }
    }

    public CountDownProgressBar(Context context) {
        super(context);
        e(context, null);
    }

    public CountDownProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }

    public CountDownProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
    }

    @TargetApi(21)
    public CountDownProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        e(context, attributeSet);
    }

    public void setCountDownFinishListener(b bVar) {
        this.dNO = bVar;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.iqoption.b.b.CountDownProgressBar, 0, 0);
        try {
            this.doz = obtainStyledAttributes.getColor(6, this.doz);
            this.doA = obtainStyledAttributes.getColor(5, this.doA);
            this.doy = obtainStyledAttributes.getInt(3, this.doy);
            this.dox = (int) TimeUnit.MILLISECONDS.toSeconds((long) obtainStyledAttributes.getInt(0, this.dox * 1000));
            this.doD = obtainStyledAttributes.getDrawable(2);
            String string = obtainStyledAttributes.getString(1);
            if (string != null) {
                setCountDownFinishListener(new c(this, string));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    private void e(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            b(context, attributeSet);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.count_down_progress_bar, this, true);
        this.Hw = (ProgressBar) inflate.findViewById(R.id.countDownProgressBar);
        this.doF = inflate.findViewById(R.id.countDownTimeLayout);
        this.bKT = (TextView) inflate.findViewById(R.id.countDownTime);
        if (this.doD != null) {
            this.Hw.setProgressDrawable(this.doD);
            this.Hw.setIndeterminateDrawable(this.doD);
        }
        aCU();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @NonNull
    private CountDownTimer bz(long j) {
        return new a(j, aCV(), this);
    }

    private void aCU() {
        this.bKT.setTextColor(this.doz);
        this.bKT.setText(bA((long) this.doy));
        this.Hw.setMax(this.doy);
        this.Hw.setProgress(this.doy);
        this.doB = false;
    }

    public int getStartTimeMs() {
        return this.doy;
    }

    public void gs(int i) {
        reset();
        long j = (long) i;
        this.cLO = bz(j);
        this.bKT.setText(bA(j));
        this.cLO.start();
    }

    public void reset() {
        if (this.cLO != null) {
            this.cLO.cancel();
            this.cLO = null;
        }
        aCU();
    }

    public void stop() {
        if (this.cLO != null) {
            this.cLO.cancel();
        }
    }

    private String bA(long j) {
        return String.format(Locale.US, "%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))});
    }

    private Animator aCV() {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.5f, 0.9f);
        Keyframe ofFloat3 = Keyframe.ofFloat(1.0f, 1.0f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.5f, 0.8f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        View view = this.doF;
        r12 = new PropertyValuesHolder[3];
        r12[0] = PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[]{ofFloat, ofFloat2, ofFloat3});
        r12[1] = PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[]{ofFloat, ofFloat2, ofFloat3});
        r12[2] = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat4, ofFloat5, ofFloat6});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, r12);
        ofPropertyValuesHolder.setDuration(1000);
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setRepeatMode(1);
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofFloat6 = Keyframe.ofFloat(0.0f, 1.0f);
        ofFloat5 = Keyframe.ofFloat(0.5f, 0.0f);
        Keyframe ofFloat7 = Keyframe.ofFloat(1.0f, 1.0f);
        ProgressBar progressBar = this.Hw;
        r12 = new PropertyValuesHolder[1];
        r12[0] = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat6, ofFloat5, ofFloat7});
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(progressBar, r12);
        ofPropertyValuesHolder2.setDuration(1000);
        ofPropertyValuesHolder2.setRepeatCount(-1);
        ofPropertyValuesHolder2.setRepeatMode(1);
        ofPropertyValuesHolder2.setInterpolator(new LinearInterpolator());
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder2});
        return animatorSet;
    }
}
