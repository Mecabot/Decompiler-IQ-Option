package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqm extends zzi<zzaqm> {
    private String mName;
    private String zzbwz;
    private String zzbzd;
    private String zzdwr;
    private String zzdws;
    private String zzdwt;
    private String zzdwu;
    private String zzdwv;
    private String zzdww;
    private String zzdwx;

    public final String getContent() {
        return this.zzbwz;
    }

    public final String getId() {
        return this.zzbzd;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getSource() {
        return this.zzdwr;
    }

    public final void setName(String str) {
        this.mName = str;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put(b.SOURCE, this.zzdwr);
        hashMap.put(b.MEDIUM, this.zzdws);
        hashMap.put("keyword", this.zzdwt);
        hashMap.put(b.CONTENT, this.zzbwz);
        hashMap.put("id", this.zzbzd);
        hashMap.put("adNetworkId", this.zzdwu);
        hashMap.put("gclid", this.zzdwv);
        hashMap.put("dclid", this.zzdww);
        hashMap.put(b.ACLID, this.zzdwx);
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqm zzaqm = (zzaqm) zzi;
        if (!TextUtils.isEmpty(this.mName)) {
            zzaqm.mName = this.mName;
        }
        if (!TextUtils.isEmpty(this.zzdwr)) {
            zzaqm.zzdwr = this.zzdwr;
        }
        if (!TextUtils.isEmpty(this.zzdws)) {
            zzaqm.zzdws = this.zzdws;
        }
        if (!TextUtils.isEmpty(this.zzdwt)) {
            zzaqm.zzdwt = this.zzdwt;
        }
        if (!TextUtils.isEmpty(this.zzbwz)) {
            zzaqm.zzbwz = this.zzbwz;
        }
        if (!TextUtils.isEmpty(this.zzbzd)) {
            zzaqm.zzbzd = this.zzbzd;
        }
        if (!TextUtils.isEmpty(this.zzdwu)) {
            zzaqm.zzdwu = this.zzdwu;
        }
        if (!TextUtils.isEmpty(this.zzdwv)) {
            zzaqm.zzdwv = this.zzdwv;
        }
        if (!TextUtils.isEmpty(this.zzdww)) {
            zzaqm.zzdww = this.zzdww;
        }
        if (!TextUtils.isEmpty(this.zzdwx)) {
            zzaqm.zzdwx = this.zzdwx;
        }
    }

    public final void zzdm(String str) {
        this.zzdwr = str;
    }

    public final void zzdn(String str) {
        this.zzdws = str;
    }

    public final void zzdo(String str) {
        this.zzdwt = str;
    }

    public final void zzdp(String str) {
        this.zzbwz = str;
    }

    public final void zzdq(String str) {
        this.zzbzd = str;
    }

    public final void zzdr(String str) {
        this.zzdwu = str;
    }

    public final void zzds(String str) {
        this.zzdwv = str;
    }

    public final void zzdt(String str) {
        this.zzdww = str;
    }

    public final void zzdu(String str) {
        this.zzdwx = str;
    }

    public final String zzwq() {
        return this.zzdws;
    }

    public final String zzwr() {
        return this.zzdwt;
    }

    public final String zzws() {
        return this.zzdwu;
    }

    public final String zzwt() {
        return this.zzdwv;
    }

    public final String zzwu() {
        return this.zzdww;
    }

    public final String zzwv() {
        return this.zzdwx;
    }
}
