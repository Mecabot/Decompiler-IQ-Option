package com.google.android.gms.tagmanager;

import java.util.Map;

final class zzgb implements zzb {
    private /* synthetic */ TagManager zzkud;

    zzgb(TagManager tagManager) {
        this.zzkud = tagManager;
    }

    public final void zzy(Map<String, Object> map) {
        Object obj = map.get("event");
        if (obj != null) {
            this.zzkud.zzme(obj.toString());
        }
    }
}
