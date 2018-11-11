package com.iqoption.feed.feedlist.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import com.iqoption.core.feed.MediaDiskCache.MediaType;
import com.iqoption.core.feed.a.b;
import com.iqoption.core.feed.a.c;
import com.iqoption.core.feed.j;
import com.iqoption.d.ym;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.h;

/* compiled from: MacroArticleViewHolder */
public class a extends e {
    private final ym cmV;
    private final c<b> cmW = new c<b>() {
        public void onStart() {
            a.this.cmV.bKO.setImageBitmap(null);
            a.this.cmV.bKO.setVisibility(8);
        }

        public void a(b bVar, MediaType mediaType) {
            a.this.cmV.bKO.setImageBitmap(bVar.getBitmap());
            a.this.cmV.bKO.setVisibility(0);
        }

        public void onError() {
            onStart();
        }
    };
    private final com.iqoption.feed.feedlist.d.a cmv;

    a(ym ymVar, com.iqoption.feed.feedlist.d.a aVar) {
        super(ymVar.bKQ, ymVar.getRoot(), aVar);
        this.cmV = ymVar;
        this.cmv = aVar;
    }

    public void i(@NonNull e eVar) {
        super.i(eVar);
        j ags = eVar.ags();
        Context context = this.itemView.getContext();
        h.a(this.cmV.bKR.bvQ, (com.iqoption.core.microservices.feed.response.a) ags);
        this.cmV.bKR.bvP.setOnClickListener(new b(this, eVar));
        this.cmV.bKR.bvR.setTextSize(0, h.a(context, ags, true));
        this.cmV.bKR.bvR.setText(h.a(context, (com.iqoption.core.microservices.feed.response.a) ags));
        this.cmV.bKP.setText(ags.getTitle());
        this.cmV.bKS.setMaxLines(h.b(context, ags, true));
        this.cmV.bKS.setText(ags.getDescription());
        this.cmV.bKT.setText(DateUtils.getRelativeTimeSpanString(ags.getDate() * 1000));
        e(this.cmV.bKQ.bvI, ags.getRating());
        this.cmV.bKQ.bvK.setText(String.valueOf(ags.VV()));
        this.cmV.bKU.aA(ags.VQ());
        this.cmV.bKU.setTopicClickListener(this.cmv);
        if (!(TextUtils.isEmpty(ags.Tv()) && TextUtils.isEmpty(ags.Tw())) && ags.Tu()) {
            com.iqoption.core.feed.a.aPQ.a(ags, this.cmW);
        } else {
            this.cmW.onError();
            com.iqoption.core.feed.a.aPQ.a(this.cmW);
        }
        this.cmV.getRoot().setOnClickListener(new c(this, ags));
        a(eVar, this.cmV.bKQ.bvH, this.cmV.bKQ.bvI);
        agk();
    }

    final /* synthetic */ void b(@NonNull e eVar, View view) {
        this.cmv.a(view, eVar);
    }

    final /* synthetic */ void a(com.iqoption.core.microservices.feed.response.a aVar, View view) {
        this.cmv.f(aVar);
    }

    public void recycle() {
        com.iqoption.core.feed.a.aPQ.a(this.cmW);
        this.cmW.onStart();
    }
}
