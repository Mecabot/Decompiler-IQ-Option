package com.iqoption.feed.feedlist.a;

import android.support.annotation.NonNull;
import com.iqoption.d.yw;
import com.iqoption.feed.b.c;
import com.iqoption.feed.feedlist.d.a;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.j;
import com.iqoption.feed.feedlist.k;

/* compiled from: YouTubeMacroVideoViewHolder */
public class n extends g implements j {
    private final k cnf;

    n(yw ywVar, c cVar, a aVar) {
        super(ywVar, aVar);
        this.cnf = new k(ywVar.bLd, cVar);
    }

    public void i(@NonNull e eVar) {
        super.i(eVar);
        this.cnf.h(eVar.ags());
    }

    public void recycle() {
        super.recycle();
        this.cnf.agy();
    }

    public void agx() {
        this.cnf.agx();
    }

    public void agy() {
        this.cnf.agy();
    }
}
