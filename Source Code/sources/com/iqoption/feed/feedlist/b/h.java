package com.iqoption.feed.feedlist.b;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.d.abg;
import com.iqoption.d.za;
import com.iqoption.d.zg;
import com.iqoption.feed.b.c;
import com.iqoption.feed.feedlist.d.a;
import com.iqoption.feed.feedlist.g;
import com.iqoption.feed.feedlist.i;
import com.iqoption.x.R;

/* compiled from: MicroViewHolderProvider */
public class h implements g {
    private final c clM;
    private final a cmv;

    public h(c cVar, a aVar) {
        this.clM = cVar;
        this.cmv = aVar;
    }

    public i E(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 1:
                return new r((zg) DataBindingUtil.inflate(from, R.layout.micro_other_video_feed, viewGroup, false), this.clM, this.cmv);
            case 2:
                return new i((zg) DataBindingUtil.inflate(from, R.layout.micro_other_video_feed, viewGroup, false), this.cmv);
            case 3:
                return new a((za) DataBindingUtil.inflate(from, R.layout.micro_article_feed, viewGroup, false), this.cmv);
            case 4:
                return new m((abg) DataBindingUtil.inflate(from, R.layout.micro_tweet_feed, viewGroup, false), this.cmv);
            default:
                return null;
        }
    }
}
