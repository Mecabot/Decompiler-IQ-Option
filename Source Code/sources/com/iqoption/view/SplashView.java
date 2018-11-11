package com.iqoption.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.d.ajq;
import com.iqoption.mobbtech.connect.request.h;
import com.iqoption.system.a.e;
import com.iqoption.util.be;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.view.drawable.b;
import com.iqoption.widget.helper.SplashLogHelper;
import com.iqoption.x.R;

public class SplashView extends FrameLayout {
    private static final String TAG = "com.iqoption.view.SplashView";
    private ajq dDO;
    private SplashLogHelper dDP;
    private b dDQ;
    private a dDR;

    public static class a extends e<SplashView> {
        public a(SplashView splashView) {
            super(splashView);
        }

        @com.google.common.b.e
        public void onIsRegulationEvent(final h.e eVar) {
            com.iqoption.core.d.a.aSe.post(new Runnable() {
                public void run() {
                    SplashView splashView = (SplashView) a.this.drU.get();
                    if (splashView != null) {
                        splashView.fk(((Boolean) eVar.getValue()).booleanValue());
                    }
                }
            });
        }
    }

    public void jX(String str) {
    }

    public static float[] a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            float[] floatArray = ((Bundle) parcelable).getFloatArray(NotificationCompat.CATEGORY_PROGRESS);
            if (floatArray != null && floatArray.length == 3) {
                return floatArray;
            }
        }
        return new float[3];
    }

    public static Rect b(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Rect rect = (Rect) ((Bundle) parcelable).getParcelable("globalRect");
            if (rect != null) {
                return rect;
            }
        }
        return new Rect();
    }

    public SplashView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public SplashView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @TargetApi(21)
    public SplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(@NonNull Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        setClickable(true);
        setSoundEffectsEnabled(false);
        this.dDO = (ajq) DataBindingUtil.inflate(from, R.layout.splash, this, true);
        this.dDQ = new b();
        this.dDO.bTu.setImageDrawable(this.dDQ);
        this.dDP = new SplashLogHelper(context, this.dDO.bTw, this.dDO.bTx, this.dDO.bTy, this.dDO.bTz, this.dDO.bTv);
        fk(af.aR(getContext()).Dh());
        this.dDR = new a(this);
        this.dDR.register();
        setBackgroundColor(getResources().getColor(R.color.bg_second_level));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dDR.register();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dDR.unregister();
    }

    public void show() {
        i.v(TAG, "show");
        if (getVisibility() != 0) {
            setAlpha(0.0f);
            animate().alpha(1.0f).setListener(com.iqoption.view.a.a.a.a.d(new com.iqoption.view.a.a.a.b() {
                public void execute() {
                    SplashView.this.setVisibility(0);
                    SplashView.this.dDQ.aIV();
                }
            })).start();
        } else if (!this.dDQ.isRunning()) {
            this.dDQ.aIV();
        }
        this.dDP.show();
    }

    public void hide() {
        i.v(TAG, "hide");
        this.dDP.saveState();
        setVisibility(8);
        aIF();
        this.dDP.hide();
    }

    public void aIF() {
        this.dDQ.stop();
    }

    public void log(final String str) {
        if (be.aGz()) {
            this.dDP.log(str);
        } else {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    SplashView.this.dDP.log(str);
                }
            });
        }
    }

    private void fk(boolean z) {
        if (z) {
            this.dDO.biO.setVisibility(0);
        } else {
            this.dDO.biO.setVisibility(8);
        }
    }

    public Parcelable getSharedState() {
        return new g().a("globalRect", bg.J(this.dDO.bTu)).a(NotificationCompat.CATEGORY_PROGRESS, this.dDQ.aIU()).toBundle();
    }

    public void setSharedState(Parcelable parcelable) {
        this.dDQ.c(a(parcelable));
    }

    public b getSplashLogo() {
        return this.dDQ;
    }
}
