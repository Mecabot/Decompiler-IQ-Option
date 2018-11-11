package com.iqoption.core.feed;

import com.iqoption.core.feed.MediaDiskCache.MediaType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] aoS = new int[MediaType.values().length];

    static {
        aoS[MediaType.ORIGINAL.ordinal()] = 1;
        aoS[MediaType.THUMBNAIL.ordinal()] = 2;
    }
}
