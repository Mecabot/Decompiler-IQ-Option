package com.iqoption.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.AnimRes;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.CardView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.d.yk;
import com.iqoption.dto.IconSettings;
import com.iqoption.dto.ToastEntity;
import com.iqoption.mobbtech.connect.a.c;
import com.iqoption.util.bg;
import com.iqoption.view.a.a.f;
import com.iqoption.view.d.d;
import com.iqoption.x.R;
import java.util.LinkedList;
import java.util.Queue;

public class LocalToast extends CardView {
    private yk dBY;
    private volatile Queue<ToastEntity> dBZ;
    private GestureDetector dCa;
    private PopupWindow dCb;
    private a dCc;
    private long dCd;
    private c dCe;
    private int dCf;
    private Handler mHandler;

    private class a extends SimpleOnGestureListener {
        private boolean dCl;
        private final c dCm;

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        private a() {
            this.dCl = false;
            this.dCm = new c() {
                public void r(Object... objArr) {
                    LocalToast.this.dCe.r(objArr);
                    if (LocalToast.this.dBY.aam() != null && !TextUtils.isEmpty(LocalToast.this.dBY.aam().getActionText())) {
                        IQApp.Dn().aE(new b(LocalToast.this.dBY.aam().getId()));
                    }
                }
            };
        }

        /* synthetic */ a(LocalToast localToast, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            LocalToast.this.mHandler.removeMessages(1);
            int dimensionPixelOffset = LocalToast.this.getContext().getResources().getDimensionPixelOffset(R.dimen.dp12);
            int i = dimensionPixelOffset * 2;
            LocalToast.this.dCb.setWidth(LocalToast.this.getWidth() + i);
            LocalToast.this.dCb.setHeight(LocalToast.this.getHeight() + i);
            LocalToast.this.dCb.showAsDropDown(LocalToast.this, -dimensionPixelOffset, (-LocalToast.this.getHeight()) - dimensionPixelOffset);
            if (bg.a(motionEvent.getRawX(), motionEvent.getRawY(), LocalToast.this.dBY.bKM)) {
                LocalToast.this.a(LocalToast.this.dCe, true);
            } else {
                LocalToast.this.b(this.dCm, true);
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.dCl = true;
            if (f < 0.0f) {
                LocalToast.this.animate().translationXBy(-f).setDuration(0).start();
            }
            return true;
        }

        public void aIo() {
            if (this.dCl) {
                LocalToast.this.mHandler.removeMessages(1);
                LocalToast.this.a(LocalToast.this.dCe, true);
            }
            this.dCl = false;
        }
    }

    public static class b {
        public final long dCo;

        public b(long j) {
            this.dCo = j;
        }
    }

    public LocalToast(Context context) {
        this(context, null);
    }

    public LocalToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocalToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dBZ = new LinkedList();
        this.mHandler = new Handler() {
            public void handleMessage(Message message) {
                LocalToast.this.b(LocalToast.this.dCe, false);
            }
        };
        this.dCe = new c() {
            public void r(Object... objArr) {
                LocalToast.this.aIn();
            }
        };
        this.dCf = 0;
        aId();
    }

    private void aId() {
        if (!isInEditMode()) {
            this.dBY = yk.O(LayoutInflater.from(getContext()), this, true);
            this.dCc = new a(this, null);
            this.dCa = new GestureDetector(getContext(), this.dCc);
            setOnTouchListener(new d(0.7f));
            View imageView = new ImageView(getContext());
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            imageView.setImageResource(R.drawable.popup_closeposition_small_smoke);
            this.dCb = new PopupWindow(imageView, -2, -2);
            this.dCb.setAnimationStyle(R.style.AnimationSmokePopup);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.dCc.aIo();
        }
        return this.dCa.onTouchEvent(motionEvent);
    }

    public LocalToast a(int i, long j, String str, long j2) {
        if (System.currentTimeMillis() - this.dCd > 300) {
            this.dCd = System.currentTimeMillis();
            this.dBZ.add(new ToastEntity(i, j, str, null, j2));
        }
        return this;
    }

    public LocalToast e(ToastEntity toastEntity) {
        if (System.currentTimeMillis() - this.dCd > 300) {
            this.dCd = System.currentTimeMillis();
            this.dBZ.add(toastEntity);
        }
        return this;
    }

    public LocalToast f(ToastEntity toastEntity) {
        this.dBZ.add(toastEntity);
        return this;
    }

    public LocalToast a(int i, long j, SpannableString spannableString, long j2) {
        this.dBZ.add(new ToastEntity(i, j, spannableString, null, j2));
        return this;
    }

    public LocalToast a(int i, long j, String str, long j2, com.iqoption.a.b.a aVar) {
        this.dBZ.add(new ToastEntity(i, j, str, null, j2, aVar));
        return this;
    }

    public LocalToast a(int i, long j, String str, String str2, long j2) {
        this.dBZ.add(new ToastEntity(i, j, str, str2, j2));
        return this;
    }

    public void aIn() {
        if (!this.dBZ.isEmpty() && (getAnimation() == null || (!getAnimation().hasStarted() && getAnimation().hasEnded()))) {
            if (getVisibility() == 0) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessage(2);
            } else {
                g((ToastEntity) this.dBZ.poll());
            }
        }
    }

    private void a(c cVar, boolean z) {
        a((int) R.anim.appear_from_rigth_to_left_with_alpha_hide, cVar, z);
    }

    private void b(c cVar, boolean z) {
        a((int) R.anim.appear_from_bottom_to_top_with_alpha_hide, cVar, z);
    }

    private void a(@AnimRes int i, final c cVar, final boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setAnimationListener(com.iqoption.view.a.a.a.a.c(new com.iqoption.view.a.a.a.b() {
            public void execute() {
                LocalToast.this.setVisibility(8);
                ToastEntity aam = LocalToast.this.dBY.aam();
                if (aam.getListener() != null) {
                    aam.getListener().a(LocalToast.this, z);
                }
                LocalToast.this.post(new i(this, cVar));
            }

            final /* synthetic */ void a(c cVar) {
                LocalToast.this.clearAnimation();
                LocalToast.this.dCb.dismiss();
                if (cVar != null) {
                    cVar.r(new Object[0]);
                }
            }
        }));
        startAnimation(loadAnimation);
    }

    private void g(ToastEntity toastEntity) {
        if (toastEntity != null) {
            this.dBY.d(toastEntity);
            this.dBY.bKL.setBackgroundResource(toastEntity.getTypeId());
            if (TextUtils.isEmpty(toastEntity.getTitle())) {
                this.dBY.bKK.setVisibility(8);
            } else {
                this.dBY.bKK.setVisibility(0);
            }
            TextView textView = this.dBY.bKJ;
            Integer actionTextAppearance = toastEntity.getActionTextAppearance();
            if (actionTextAppearance != null) {
                TextViewCompat.setTextAppearance(textView, actionTextAppearance.intValue());
            }
            ImageView imageView = this.dBY.bKM;
            if (TextUtils.isEmpty(toastEntity.getActionText())) {
                textView.setVisibility(8);
                imageView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                imageView.setVisibility(0);
                IconSettings iconSettings = toastEntity.getIconSettings();
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), iconSettings.getIcon()));
                Point size = iconSettings.getSize();
                if (size != null) {
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = size.x;
                    layoutParams.height = size.y;
                    imageView.setLayoutParams(layoutParams);
                }
            }
            setVisibility(0);
            setTranslationX(0.0f);
            setTranslationY(0.0f);
            clearAnimation();
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.appear_from_rigth_to_left_with_alpha_show));
            this.mHandler.sendEmptyMessageDelayed(1, toastEntity.getDuration());
        }
    }

    private int gP(int i) {
        if (this.dCf == 0) {
            this.dCf = ef(R.dimen.dp58);
        }
        int i2 = this.dCf + i;
        this.dCf = i2;
        return i2;
    }

    private final int ef(@DimenRes int i) {
        return getResources().getDimensionPixelSize(i);
    }

    public void f(int i, long j) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        i = gP(i);
        if (getVisibility() == 8) {
            marginLayoutParams.topMargin = i;
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{marginLayoutParams.topMargin, i});
        ofInt.addUpdateListener(new f(this));
        ofInt.setDuration(j);
        ofInt.start();
    }
}
