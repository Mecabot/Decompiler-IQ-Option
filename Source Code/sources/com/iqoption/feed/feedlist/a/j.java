package com.iqoption.feed.feedlist.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import com.iqoption.d.yu;
import com.iqoption.feed.feedlist.d.a;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.h;
import com.squareup.picasso.Picasso;

/* compiled from: TweetMacroViewHolder */
public class j extends e {
    private final a cmv;
    private final yu cnd;

    j(yu yuVar, a aVar) {
        super(yuVar.bKQ, yuVar.getRoot(), aVar);
        this.cnd = yuVar;
        this.cmv = aVar;
    }

    public void i(@NonNull e eVar) {
        super.i(eVar);
        com.iqoption.core.microservices.feed.response.a ags = eVar.ags();
        h.a(this.cnd.bKR.bvQ, ags);
        String VN = ags.VN();
        Context context = this.itemView.getContext();
        if (TextUtils.isEmpty(VN)) {
            this.cnd.bLa.setImageBitmap(null);
            Picasso.with(context).cancelRequest(this.cnd.bLa);
            this.cnd.bLa.setVisibility(8);
        } else {
            this.cnd.bLa.setVisibility(0);
            Picasso.with(context).load(VN).transform(new com.iqoption.core.ui.picasso.a()).into(this.cnd.bLa);
        }
        this.cnd.bKR.bvR.setTextSize(0, h.a(context, ags, true));
        this.cnd.bKR.bvR.setText(h.a(context, ags));
        this.cnd.bKR.bvP.setOnClickListener(new k(this, eVar));
        this.cnd.bmr.setText(ags.VP());
        this.cnd.bKZ.setText(ags.getDescription());
        this.cnd.bKT.setText(DateUtils.getRelativeTimeSpanString(ags.getDate() * 1000));
        e(this.cnd.bKQ.bvI, ags.getRating());
        this.cnd.bKQ.bvK.setText(String.valueOf(ags.VV()));
        this.cnd.bKU.aA(ags.VQ());
        this.cnd.bKU.setTopicClickListener(this.cmv);
        this.cnd.getRoot().setOnClickListener(new l(this, ags));
        this.cnd.bKZ.setOnClickListener(new m(this, ags));
        a(eVar, this.cnd.bKQ.bvH, this.cnd.bKQ.bvI);
        agk();
    }

    final /* synthetic */ void c(com.iqoption.core.microservices.feed.response.a aVar, View view) {
        this.cmv.f(aVar);
    }
}
