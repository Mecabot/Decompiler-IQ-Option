package com.iqoption.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import com.iqoption.view.a.a;

/* compiled from: IQAnimationFragment */
public abstract class b extends f {
    private boolean cvI = false;
    private boolean cvJ = false;

    public abstract void ND();

    public abstract void NE();

    public long getAnimationDuration() {
        return 500;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            di(true);
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (z && this.cvI) {
            return null;
        }
        if (!z && this.cvJ) {
            return null;
        }
        Animation aVar = new a();
        if (z) {
            aVar.setDuration(NF() + 16);
            if (getView() != null) {
                getView().setAlpha(0.0f);
                aVar.setAnimationListener(com.iqoption.view.a.a.a.a.d(new c(this)));
            }
        } else {
            aVar.setDuration(NG() + 16);
            aVar.setAnimationListener(com.iqoption.view.a.a.a.a.d(new d(this)));
        }
        return aVar;
    }

    final /* synthetic */ void ajU() {
        ND();
        if (getView() != null) {
            getView().setAlpha(1.0f);
        }
    }

    public void di(boolean z) {
        this.cvI = z;
    }

    public long NF() {
        return getAnimationDuration();
    }

    public long NG() {
        return getAnimationDuration();
    }
}
