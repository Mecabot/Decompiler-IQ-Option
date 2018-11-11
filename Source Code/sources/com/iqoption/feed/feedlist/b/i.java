package com.iqoption.feed.feedlist.b;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import com.iqoption.core.feed.MediaDiskCache.MediaType;
import com.iqoption.core.feed.a.b;
import com.iqoption.core.feed.a.c;
import com.iqoption.core.feed.j;
import com.iqoption.d.zg;
import com.iqoption.feed.feedlist.a;
import com.iqoption.feed.feedlist.d;
import com.iqoption.feed.feedlist.e;
import com.iqoption.feed.feedlist.h;

/* compiled from: OtherMicroVideoViewHolder */
public class i extends f implements a {
    private final c<b> cmW = new c<b>() {
        public void onStart() {
            i.this.cnk.bLf.setImageBitmap(null);
        }

        public void a(b bVar, MediaType mediaType) {
            i.this.cnk.bLf.setImageBitmap(bVar.getBitmap());
        }

        public void onError() {
            i.this.cnk.bLf.setImageBitmap(null);
        }
    };
    private final d.a cmv;
    private final zg cnk;

    static final /* synthetic */ void aw(View view) {
    }

    i(zg zgVar, d.a aVar) {
        super(zgVar.bLj, zgVar.getRoot(), aVar);
        this.cnk = zgVar;
        this.cmv = aVar;
    }

    public void i(e eVar) {
        super.i(eVar);
        j ags = eVar.ags();
        Context context = this.itemView.getContext();
        h.a(this.cnk.bLk.bvQ, (com.iqoption.core.microservices.feed.response.a) ags);
        this.cnk.bLk.bKW.setTextSize(0, h.a(context, ags, false));
        this.cnk.bLk.bKW.setText(h.a(context, (com.iqoption.core.microservices.feed.response.a) ags));
        if (TextUtils.isEmpty(ags.getTitle())) {
            this.cnk.bLp.setText("");
            this.cnk.bLp.setVisibility(8);
        } else {
            this.cnk.bLp.setText(ags.getTitle());
            this.cnk.bLp.setVisibility(0);
        }
        this.cnk.bLk.bvP.setOnClickListener(new j(this, eVar));
        this.cnk.bKT.setText(DateUtils.getRelativeTimeSpanString(ags.getDate() * 1000));
        e(this.cnk.bLj.bLm, ags.getRating());
        this.cnk.bLj.bvK.setText(String.valueOf(ags.VV()));
        this.cnk.bLj.getRoot().setOnClickListener(k.cni);
        this.cnk.bKU.aA(ags.VQ());
        this.cnk.bKU.setTopicClickListener(this.cmv);
        this.cnk.bLf.setOnClickListener(new l(this, ags));
        com.iqoption.core.feed.a.aPQ.a(ags, this.cmW);
        a(eVar, this.cnk.bLj.bvH, this.cnk.bLj.bLm);
        agk();
    }

    public void recycle() {
        com.iqoption.core.feed.a.aPQ.a(this.cmW);
    }

    public void agj() {
        agl();
    }
}
