package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.util.UUID;

/* compiled from: SessionInfo */
class h {
    private Long Bl;
    private Long Bm;
    private int Bn;
    private Long Bo;
    private j Bp;
    private UUID Bq;

    public h(Long l, Long l2) {
        this(l, l2, UUID.randomUUID());
    }

    public h(Long l, Long l2, UUID uuid) {
        this.Bl = l;
        this.Bm = l2;
        this.Bq = uuid;
    }

    public static h lg() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.facebook.h.getApplicationContext());
        long j = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0);
        long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0);
        String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (j == 0 || j2 == 0 || string == null) {
            return null;
        }
        h hVar = new h(Long.valueOf(j), Long.valueOf(j2));
        hVar.Bn = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
        hVar.Bp = j.lq();
        hVar.Bo = Long.valueOf(System.currentTimeMillis());
        hVar.Bq = UUID.fromString(string);
        return hVar;
    }

    public static void lh() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(com.facebook.h.getApplicationContext()).edit();
        edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        edit.remove("com.facebook.appevents.SessionInfo.sessionId");
        edit.apply();
        j.lr();
    }

    public Long li() {
        return this.Bm;
    }

    public void a(Long l) {
        this.Bm = l;
    }

    public int lj() {
        return this.Bn;
    }

    public void lk() {
        this.Bn++;
    }

    public long ll() {
        return this.Bo == null ? 0 : this.Bo.longValue();
    }

    public UUID getSessionId() {
        return this.Bq;
    }

    public long lm() {
        return (this.Bl == null || this.Bm == null) ? 0 : this.Bm.longValue() - this.Bl.longValue();
    }

    public j ln() {
        return this.Bp;
    }

    public void lo() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(com.facebook.h.getApplicationContext()).edit();
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.Bl.longValue());
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.Bm.longValue());
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.Bn);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.Bq.toString());
        edit.apply();
        if (this.Bp != null) {
            this.Bp.ls();
        }
    }
}
