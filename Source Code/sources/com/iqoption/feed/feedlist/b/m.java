package com.iqoption.feed.feedlist.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.view.View;
import com.iqoption.d.abg;
import com.iqoption.feed.feedlist.a;
import com.iqoption.feed.feedlist.d;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.h;

/* compiled from: TweetMicroViewHolder */
public class m extends f implements a {
    private final d.a cmv;
    private final abg cnn;

    static final /* synthetic */ void ax(View view) {
    }

    m(abg abg, d.a aVar) {
        super(abg.bLj, abg.getRoot(), aVar);
        this.cnn = abg;
        this.cmv = aVar;
    }

    public void i(@NonNull e eVar) {
        super.i(eVar);
        com.iqoption.core.microservices.feed.response.a ags = eVar.ags();
        Context context = this.itemView.getContext();
        h.a(this.cnn.bLk.bvQ, ags);
        this.cnn.bLk.bvP.setOnClickListener(new n(this, eVar));
        this.cnn.bLk.bKW.setTextSize(0, h.a(context, ags, false));
        this.cnn.bLk.bKW.setText(h.a(context, ags));
        this.cnn.bmr.setText(ags.VP());
        this.cnn.bKS.setText(ags.getDescription());
        this.cnn.bKT.setText(DateUtils.getRelativeTimeSpanString(ags.getDate() * 1000));
        e(this.cnn.bLj.bLm, ags.getRating());
        this.cnn.bLj.bvK.setText(String.valueOf(ags.VV()));
        this.cnn.bLj.getRoot().setOnClickListener(o.cni);
        this.cnn.bKU.aA(ags.VQ());
        this.cnn.bKU.setTopicClickListener(this.cmv);
        this.cnn.bKS.setOnClickListener(new p(this, ags));
        this.cnn.getRoot().setOnClickListener(new q(this, ags));
        a(eVar, this.cnn.bLj.bvH, this.cnn.bLj.bLm);
        agk();
    }

    final /* synthetic */ void h(com.iqoption.core.microservices.feed.response.a aVar, View view) {
        this.cmv.f(aVar);
    }

    public void agj() {
        agl();
    }
}
