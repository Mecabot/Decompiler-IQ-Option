package com.iqoption.feed.feedlist.b;

import android.support.annotation.NonNull;
import com.iqoption.d.zg;
import com.iqoption.feed.b.c;
import com.iqoption.feed.feedlist.d.a;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.j;
import com.iqoption.feed.feedlist.k;

/* compiled from: YouTubeMicroViewHolder */
public class r extends i implements j {
    private final k cnf;

    r(zg zgVar, c cVar, a aVar) {
        super(zgVar, aVar);
        this.cnf = new k(zgVar.bLo, cVar);
    }

    public void i(@NonNull e eVar) {
        super.i(eVar);
        this.cnf.h(eVar.ags());
    }

    public void recycle() {
        super.recycle();
        agy();
    }

    public void agx() {
        this.cnf.agx();
    }

    public void agy() {
        this.cnf.agy();
    }
}
