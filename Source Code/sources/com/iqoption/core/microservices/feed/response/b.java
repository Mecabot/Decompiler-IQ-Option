package com.iqoption.core.microservices.feed.response;

import com.iqoption.core.feed.MediaDiskCache.MediaType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] aoS = new int[MediaType.values().length];

    static {
        aoS[MediaType.THUMBNAIL.ordinal()] = 1;
        aoS[MediaType.ORIGINAL.ordinal()] = 2;
    }
}
