package com.iqoption.analytics;

import com.google.common.base.d;
import com.google.common.collect.i;
import com.iqoption.core.microservices.videoeducation.response.a;
import com.iqoption.core.microservices.videoeducation.response.f;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import java.util.List;

/* compiled from: VideoEducationEventHelper */
public final class o {
    private static final d<a, Long> ajl = p.$instance;
    private static final d<f, Long> ajm = q.$instance;

    public static void R(long j) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "video-tutorials_open-section").setValue(Double.valueOf((double) j)).build());
    }

    public static Builder BM() {
        return Event.Builder(Event.CATEGORY_SCREEN_OPENED, "video-tutorials_show-section");
    }

    public static void S(long j) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "video-tutorials_filter-by-tags").setValue(Double.valueOf((double) j)).build());
    }

    public static void T(long j) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "video-tutorials_section-search").setValue(Double.valueOf((double) j)).build());
    }

    public static void Bg() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "video-tutorials_return").build());
    }

    public static void a(long j, List<a> list, List<f> list2) {
        List sA = i.c((Iterable) list).b(ajl).sA();
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "video-tutorials_open-video").setValue(Double.valueOf((double) j)).setParameters(com.iqoption.core.util.i.ZZ().c("section_id", sA).c("tag_id", i.c((Iterable) list2).b(ajm).sA()).aab()).build());
    }

    public static Builder b(long j, List<a> list, List<f> list2) {
        List sA = i.c((Iterable) list).b(ajl).sA();
        return Event.Builder(Event.CATEGORY_SCREEN_OPENED, "video-tutorials_video-show").setValue(Double.valueOf((double) j)).setParameters(com.iqoption.core.util.i.ZZ().c("section_id", sA).c("tag_id", i.c((Iterable) list2).b(ajm).sA()).aab());
    }

    public static void c(Builder builder) {
        if (builder != null) {
            EventManager.Bm().a(builder.calcDuration().build());
        }
    }
}
