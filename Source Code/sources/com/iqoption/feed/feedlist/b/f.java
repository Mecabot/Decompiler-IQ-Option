package com.iqoption.feed.feedlist.b;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.ext.c;
import com.iqoption.core.microservices.feed.response.FeedPriority;
import com.iqoption.d.zc;
import com.iqoption.feed.feedlist.b;
import com.iqoption.feed.feedlist.d.a;

/* compiled from: MicroContentViewHolder */
public abstract class f extends b {
    private final zc cnj;

    f(zc zcVar, View view, a aVar) {
        super(view, aVar);
        this.cnj = zcVar;
    }

    @NonNull
    protected ViewGroup agp() {
        return this.cnj.bLl;
    }

    @NonNull
    protected TextView agq() {
        return this.cnj.bvG;
    }

    @NonNull
    protected TextView agr() {
        return this.cnj.bvJ;
    }

    public boolean Lg() {
        if (this.cmw == null) {
            return true;
        }
        return !c.b(this.cmw.ags().VR(), FeedPriority.PROMOTED, FeedPriority.BREAKING_NEWS);
    }
}
