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
import com.iqoption.d.yw;
import com.iqoption.feed.feedlist.d.a;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.h;

/* compiled from: OtherMacroVideoViewHolder */
public class g extends e {
    private final c<b> cmW = new c<b>() {
        public void onStart() {
            g.this.cna.bLf.setImageBitmap(null);
        }

        public void a(b bVar, MediaType mediaType) {
            g.this.cna.bLf.setImageBitmap(bVar.getBitmap());
        }

        public void onError() {
            g.this.cna.bLf.setImageBitmap(null);
        }
    };
    private final a cmv;
    private final yw cna;

    g(yw ywVar, a aVar) {
        super(ywVar.bKQ, ywVar.getRoot(), aVar);
        this.cna = ywVar;
        this.cmv = aVar;
    }

    public void i(@NonNull e eVar) {
        super.i(eVar);
        j ags = eVar.ags();
        Context context = this.itemView.getContext();
        h.a(this.cna.bKR.bvQ, (com.iqoption.core.microservices.feed.response.a) ags);
        this.cna.bKR.bvR.setTextSize(0, h.a(context, ags, true));
        this.cna.bKR.bvR.setText(h.a(context, (com.iqoption.core.microservices.feed.response.a) ags));
        if (TextUtils.isEmpty(ags.getTitle())) {
            this.cna.bLg.setVisibility(8);
        } else {
            this.cna.bLg.setText(ags.getTitle());
            this.cna.bLg.setVisibility(0);
        }
        this.cna.bKR.bvP.setOnClickListener(new h(this, eVar));
        this.cna.bLb.setVisibility(8);
        this.cna.bKT.setText(DateUtils.getRelativeTimeSpanString(ags.getDate() * 1000));
        this.cna.bKU.aA(ags.VQ());
        this.cna.bKU.setTopicClickListener(this.cmv);
        this.cna.bKQ.bvK.setText(String.valueOf(ags.VV()));
        e(this.cna.bKQ.bvI, ags.getRating());
        this.cna.bLf.setOnClickListener(new i(this, ags));
        com.iqoption.core.feed.a.aPQ.a(ags, this.cmW);
        a(eVar, this.cna.bKQ.bvH, this.cna.bKQ.bvI);
        agk();
    }

    final /* synthetic */ void c(@NonNull e eVar, View view) {
        this.cmv.a(view, eVar);
    }

    final /* synthetic */ void b(com.iqoption.core.microservices.feed.response.a aVar, View view) {
        this.cmv.f(aVar);
    }

    public void recycle() {
        this.cna.bLf.setImageBitmap(null);
        com.iqoption.core.feed.a.aPQ.a(this.cmW);
    }
}
