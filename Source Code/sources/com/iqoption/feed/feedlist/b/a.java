package com.iqoption.feed.feedlist.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.view.View;
import com.iqoption.d.za;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.h;

/* compiled from: MicroArticleViewHolder */
public class a extends f implements com.iqoption.feed.feedlist.a {
    private final com.iqoption.feed.feedlist.d.a cmv;
    private final za cng;

    static final /* synthetic */ void av(View view) {
    }

    a(za zaVar, com.iqoption.feed.feedlist.d.a aVar) {
        super(zaVar.bLj, zaVar.getRoot(), aVar);
        this.cng = zaVar;
        this.cmv = aVar;
    }

    public void i(@NonNull e eVar) {
        super.i(eVar);
        com.iqoption.core.microservices.feed.response.a ags = eVar.ags();
        Context context = this.itemView.getContext();
        h.a(this.cng.bLk.bvQ, ags);
        this.cng.bLk.bvP.setOnClickListener(new b(this, eVar));
        this.cng.bLk.bKW.setTextSize(0, h.a(context, ags, false));
        this.cng.bLk.bKW.setText(h.a(context, ags));
        this.cng.bKP.setText(ags.getTitle());
        this.cng.bKS.setMaxLines(h.b(context, ags, false));
        this.cng.bKS.setText(ags.getDescription());
        this.cng.bKT.setText(DateUtils.getRelativeTimeSpanString(ags.getDate() * 1000));
        e(this.cng.bLj.bLm, ags.getRating());
        this.cng.bLj.bvK.setText(String.valueOf(ags.VV()));
        this.cng.bLj.getRoot().setOnClickListener(c.cni);
        this.cng.bKU.aA(ags.VQ());
        this.cng.bKU.setTopicClickListener(this.cmv);
        this.cng.getRoot().setOnClickListener(new d(this, ags));
        a(eVar, this.cng.bLj.bvH, this.cng.bLj.bLm);
        agk();
    }

    public void agj() {
        agl();
    }
}
