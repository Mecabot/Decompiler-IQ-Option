package com.iqoption.quiz;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import com.iqoption.quiz.LeaderBoardQuizDelegate.AnonymousClass1;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, aXE = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"})
/* compiled from: LeaderBoardQuizDelegate.kt */
final class LeaderBoardQuizDelegate$1$pagerPosition$2 extends Lambda implements a<Integer> {
    final /* synthetic */ AnonymousClass1 this$0;

    LeaderBoardQuizDelegate$1$pagerPosition$2(AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
        super(0);
    }

    /* renamed from: XY */
    public final Integer invoke() {
        PagerAdapter adapter = ((ViewPager) viewGroup).getAdapter();
        return adapter != null ? Integer.valueOf(adapter.getItemPosition(this.this$0.this$0)) : null;
    }
}
