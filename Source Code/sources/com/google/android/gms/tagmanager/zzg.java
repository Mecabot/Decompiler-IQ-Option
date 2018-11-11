package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

final class zzg implements zzb {
    private final Context zzaiq;

    public zzg(Context context) {
        this.zzaiq = context;
    }

    public final void zzy(Map<String, Object> map) {
        Object obj = map.get("gtm.url");
        if (obj == null) {
            Object obj2 = map.get("gtm");
            if (obj2 != null && (obj2 instanceof Map)) {
                obj = ((Map) obj2).get(PlusShare.KEY_CALL_TO_ACTION_URL);
            }
        }
        if (obj != null && (obj instanceof String)) {
            String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
            if (queryParameter != null) {
                zzcx.zzag(this.zzaiq, queryParameter);
            }
        }
    }
}
