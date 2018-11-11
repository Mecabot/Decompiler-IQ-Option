package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.internal.u.a;
import com.google.android.youtube.player.internal.u.b;

public final class c extends a {
    public final d a(Context context, String str, a aVar, b bVar) {
        return new r(context, str, context.getPackageName(), aa.aw(context), aVar, bVar);
    }

    public final f a(Activity activity, d dVar, boolean z) {
        return w.a(activity, dVar.ph(), z);
    }
}
