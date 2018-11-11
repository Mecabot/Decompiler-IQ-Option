package com.iqoption.feed.feedlist.a;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.d.ym;
import com.iqoption.d.yu;
import com.iqoption.d.yw;
import com.iqoption.feed.b.c;
import com.iqoption.feed.feedlist.d.a;
import com.iqoption.feed.feedlist.g;
import com.iqoption.feed.feedlist.i;
import com.iqoption.x.R;

/* compiled from: MacroViewHolderProvider */
public class f implements g {
    private c clM;
    private final a cmv;

    public f(c cVar, a aVar) {
        this.clM = cVar;
        this.cmv = aVar;
    }

    public i E(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 1:
                return new n((yw) DataBindingUtil.inflate(from, R.layout.macro_video_feed, viewGroup, false), this.clM, this.cmv);
            case 2:
                return new g((yw) DataBindingUtil.inflate(from, R.layout.macro_video_feed, viewGroup, false), this.cmv);
            case 3:
                return new a((ym) DataBindingUtil.inflate(from, R.layout.macro_article_feed, viewGroup, false), this.cmv);
            case 4:
                return new j((yu) DataBindingUtil.inflate(from, R.layout.macro_tweet_feed, viewGroup, false), this.cmv);
            default:
                return null;
        }
    }
}
