package com.iqoption.quiz.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: OnClickDelayView */
public abstract class c implements OnClickListener {
    private long doZ = 300;
    private long dpa;

    public abstract void q(View view);

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.dpa >= this.doZ) {
            this.dpa = System.currentTimeMillis();
            if (view != null) {
                q(view);
            }
        }
    }
}
