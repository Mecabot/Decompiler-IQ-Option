package com.iqoption.videoeducation.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.iqoption.analytics.o;
import com.iqoption.core.i;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.j;

/* compiled from: VideoPlayerFragment */
public final class g extends j {
    public static final String TAG = "com.iqoption.videoeducation.fragment.g";
    private Builder dzY;

    public static g a(long j, Rect rect) {
        g gVar = new g();
        gVar.setArguments(new com.iqoption.util.g().j("arg.videoId", j).a("arg.revealRect", (Parcelable) rect).v("arg.allowMediaController", true).toBundle());
        return gVar;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        long WQ = WQ();
        if (WQ == 0) {
            i.w(TAG, "videoId is absent");
            a();
            return;
        }
        com.iqoption.core.microservices.videoeducation.response.g gVar = (com.iqoption.core.microservices.videoeducation.response.g) com.iqoption.videoeducation.j.cq(WQ).aWf();
        if (gVar == null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("video with id: ");
            stringBuilder.append(WQ);
            stringBuilder.append(" has not been found");
            i.w(str, stringBuilder.toString());
            a();
            return;
        }
        Object XU = gVar.XU();
        if (TextUtils.isEmpty(XU)) {
            i.w(TAG, "path is absent");
            a();
            return;
        }
        this.dzY = o.b(gVar.getId(), gVar.Kj(), gVar.XX());
        getArguments().putString("arg.videoPath", XU);
        super.onViewCreated(view, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        o.c(this.dzY);
    }

    protected void akc() {
        super.b();
        com.iqoption.videoeducation.j.cr(WQ()).b(com.iqoption.core.h.i.Yo()).a(h.cqT, i.cpR);
    }

    private long WQ() {
        return getArguments().getLong("arg.videoId");
    }
}
