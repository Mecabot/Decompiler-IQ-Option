package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.j;
import java.util.Collection;

/* compiled from: AppRequestData */
public class d {
    public final String appId;
    public final String eoX;
    public final String eoY;
    public final String eoZ;
    public final int epa;
    public final String epb;
    public final String epc;
    public final n epd;
    public final Collection<j> epe;
    public final String name;
    public final String sO;

    public d(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, n nVar, Collection<j> collection) {
        this.sO = str;
        this.appId = str2;
        this.eoX = str3;
        this.eoY = str4;
        this.eoZ = str5;
        this.name = str6;
        this.epa = i;
        this.epb = str7;
        this.epc = str8;
        this.epd = nVar;
        this.epe = collection;
    }
}
