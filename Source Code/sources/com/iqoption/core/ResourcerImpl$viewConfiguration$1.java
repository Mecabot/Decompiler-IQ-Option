package com.iqoption.core;

import android.view.ViewConfiguration;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: Resourcer.kt */
final class ResourcerImpl$viewConfiguration$1 extends Lambda implements a<ViewConfiguration> {
    final /* synthetic */ l this$0;

    ResourcerImpl$viewConfiguration$1(l lVar) {
        this.this$0 = lVar;
        super(0);
    }

    /* renamed from: RU */
    public final ViewConfiguration invoke() {
        return ViewConfiguration.get(this.this$0.context);
    }
}
