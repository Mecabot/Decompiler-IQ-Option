package com.iqoption.settings;

import android.content.Context;
import android.support.annotation.NonNull;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.data.d.d;
import com.iqoption.settings.a.a;
import com.iqoption.settings.a.c;
import com.iqoption.settings.a.e;
import com.iqoption.settings.a.f;
import com.iqoption.settings.a.g;
import com.iqoption.settings.a.h;
import com.iqoption.settings.a.i;
import com.iqoption.settings.a.j;
import com.iqoption.settings.a.k;
import com.iqoption.settings.a.l;
import com.iqoption.settings.a.m;

/* compiled from: SettingsManager */
public final class b {
    private static volatile b dqY;
    private final af dqZ;

    private static b bL(@NonNull Context context) {
        if (dqY == null) {
            synchronized (b.class) {
                if (dqY == null) {
                    dqY = new b(context);
                }
            }
        }
        return dqY;
    }

    public static b aDQ() {
        return bL(IQApp.Dk());
    }

    public b(@NonNull Context context) {
        this.dqZ = af.aR(context);
    }

    public boolean aDR() {
        return this.dqZ.Ft();
    }

    public void eQ(boolean z) {
        this.dqZ.bn(z);
        IQApp.Dn().aE(new com.iqoption.settings.a.b().setValue(Boolean.valueOf(z)));
    }

    public boolean aDS() {
        return this.dqZ.Fr();
    }

    public void eR(boolean z) {
        this.dqZ.bl(z);
        IQApp.Dn().aE(new i().setValue(Boolean.valueOf(z)));
    }

    public boolean aDT() {
        return this.dqZ.Fs();
    }

    public void eS(boolean z) {
        this.dqZ.bm(z);
        IQApp.Dn().aE(new e().setValue(Boolean.valueOf(z)));
    }

    public boolean MU() {
        return d.aOE.SH();
    }

    public void bU(boolean z) {
        d.aOE.ce(z);
        IQApp.Dn().aE(new l().setValue(Boolean.valueOf(z)));
    }

    public boolean MV() {
        return d.aOE.SI();
    }

    public void setLiveDealsEnabled(boolean z) {
        d.aOE.cf(z);
        IQApp.Dn().aE(new f().setValue(Boolean.valueOf(z)));
    }

    public boolean aDU() {
        return this.dqZ.ED();
    }

    public void eT(boolean z) {
        this.dqZ.aX(z);
        IQApp.Dn().aE(new j().setValue(Boolean.valueOf(z)));
    }

    public boolean aDV() {
        return this.dqZ.Fp();
    }

    public void eU(boolean z) {
        this.dqZ.bj(z);
        IQApp.Dn().aE(new k().setValue(Boolean.valueOf(z)));
    }

    public boolean aDW() {
        return this.dqZ.Fu();
    }

    public void dI(boolean z) {
        this.dqZ.bo(z);
        IQApp.Dn().aE(new a.d().setValue(Boolean.valueOf(z)));
    }

    public boolean aDX() {
        return this.dqZ.Em();
    }

    public void eV(boolean z) {
        this.dqZ.aQ(z);
        IQApp.Dn().aE(new a().setValue(Boolean.valueOf(z)));
    }

    public boolean Eo() {
        return this.dqZ.Eo();
    }

    public void aS(boolean z) {
        this.dqZ.aS(z);
        IQApp.Dn().aE(new m().setValue(Boolean.valueOf(z)));
    }

    public boolean En() {
        return this.dqZ.En();
    }

    public void aR(boolean z) {
        if (z) {
            com.iqoption.marginaddon.b.aqO();
        }
        this.dqZ.aR(z);
        IQApp.Dn().aE(new g().setValue(Boolean.valueOf(z)));
    }

    public boolean Fq() {
        return this.dqZ.Fq();
    }

    public void eW(boolean z) {
        this.dqZ.bk(z);
        IQApp.Dn().aE(new h().setValue(Boolean.valueOf(z)));
    }

    public boolean Ep() {
        return this.dqZ.Ep();
    }

    public void aT(boolean z) {
        this.dqZ.aT(z);
        IQApp.Dn().aE(new c().setValue(Boolean.valueOf(z)));
    }
}
