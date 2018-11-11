package com.iqoption.fragment.leftpanel;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: LeftPanelFragment.kt */
final class LeftPanelFragment$onCreateView$2 extends Lambda implements a<Boolean> {
    final /* synthetic */ LeftPanelFragment this$0;

    LeftPanelFragment$onCreateView$2(LeftPanelFragment leftPanelFragment) {
        this.this$0 = leftPanelFragment;
        super(0);
    }

    public final boolean invoke() {
        return this.this$0.onBackPressed();
    }
}
