package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.g;
import com.facebook.internal.a;

/* compiled from: ResultProcessor */
public abstract class h {
    private g IX;

    public abstract void a(a aVar, Bundle bundle);

    public h(g gVar) {
        this.IX = gVar;
    }

    public void b(a aVar) {
        if (this.IX != null) {
            this.IX.onCancel();
        }
    }

    public void a(a aVar, FacebookException facebookException) {
        if (this.IX != null) {
            this.IX.b(facebookException);
        }
    }
}
