package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.t;

@Deprecated
/* compiled from: LikeStatusClient */
final class f extends t {
    private String HL;

    f(Context context, String str, String str2) {
        super(context, 65542, 65543, 20141001, str);
        this.HL = str2;
    }

    protected void j(Bundle bundle) {
        bundle.putString("com.facebook.platform.extra.OBJECT_ID", this.HL);
    }
}
