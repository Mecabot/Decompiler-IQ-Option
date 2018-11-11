package com.iqoption.gdpr.removal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: PendingRemovalActivity.kt */
final class PendingRemovalActivity$isFullScreen$2 extends Lambda implements a<Boolean> {
    final /* synthetic */ PendingRemovalActivity this$0;

    PendingRemovalActivity$isFullScreen$2(PendingRemovalActivity pendingRemovalActivity) {
        this.this$0 = pendingRemovalActivity;
        super(0);
    }

    public final boolean invoke() {
        return this.this$0.getIntent().getBooleanExtra("ARG_FULL_SCREEN", false);
    }
}
