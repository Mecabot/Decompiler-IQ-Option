package com.iqoption.feed.feedlist.a;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.d.kr;
import com.iqoption.feed.feedlist.b;
import com.iqoption.feed.feedlist.d.a;

/* compiled from: MacroContentViewHolder */
public abstract class e extends b {
    private final kr cmZ;

    public boolean Lg() {
        return false;
    }

    public void agj() {
    }

    e(kr krVar, View view, a aVar) {
        super(view, aVar);
        this.cmZ = krVar;
    }

    @NonNull
    protected ViewGroup agp() {
        return this.cmZ.bvE;
    }

    @NonNull
    protected TextView agq() {
        return this.cmZ.bvG;
    }

    @NonNull
    protected TextView agr() {
        return this.cmZ.bvJ;
    }
}
