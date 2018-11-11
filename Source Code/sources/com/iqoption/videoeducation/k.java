package com.iqoption.videoeducation;

import com.iqoption.core.microservices.videoeducation.response.g;
import com.iqoption.videoeducation.b.a;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, aXE = {"Lcom/iqoption/videoeducation/VideoEducationWatched;", "Lcom/iqoption/videoeducation/VideoEducationEvent;", "video", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "catalogs", "", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "(Lcom/iqoption/core/microservices/videoeducation/response/Video;Ljava/util/List;)V", "getVideo", "()Lcom/iqoption/core/microservices/videoeducation/response/Video;", "videoeducation_release"})
/* compiled from: VideoEducationManager.kt */
public final class k extends i {
    private final g ayK;

    public k(g gVar, List<a> list) {
        h.e(gVar, "video");
        h.e(list, "catalogs");
        super(list, null);
        this.ayK = gVar;
    }

    public final g aHM() {
        return this.ayK;
    }
}
