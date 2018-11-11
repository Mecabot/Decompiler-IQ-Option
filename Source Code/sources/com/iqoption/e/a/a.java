package com.iqoption.e.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: OnClickListener */
public final class a implements OnClickListener {
    final a cIy;
    final int cIz;

    /* compiled from: OnClickListener */
    public interface a {
        void a(int i, View view);
    }

    public a(a aVar, int i) {
        this.cIy = aVar;
        this.cIz = i;
    }

    public void onClick(View view) {
        this.cIy.a(this.cIz, view);
    }
}
