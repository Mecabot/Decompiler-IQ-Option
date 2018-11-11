package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import com.iqoption.quiz.m;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$connectionState$2 extends Lambda implements a<LiveData<Boolean>> {
    public static final TriviaSocketViewModel$connectionState$2 dmN = new TriviaSocketViewModel$connectionState$2();

    TriviaSocketViewModel$connectionState$2() {
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<Boolean> invoke() {
        return LiveDataReactiveStreams.a(m.ayY().azo().DH().d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()));
    }
}
