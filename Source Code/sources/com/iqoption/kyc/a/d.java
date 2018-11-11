package com.iqoption.kyc.a;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import com.google.common.base.n;
import com.iqoption.dto.Event.Builder;
import com.iqoption.util.ac;

/* compiled from: ScreenEventOnBackStackChangedListener */
public class d implements OnBackStackChangedListener {
    private final boolean aMv;
    private final FragmentManager cKu;
    private final String cKv;
    private final String cKw;
    private n<Builder> cKx;
    private final Context context;
    private Builder cxf;
    private final String tag;

    protected void apV() {
    }

    protected void apW() {
    }

    public d(Context context, Builder builder, FragmentManager fragmentManager, boolean z, String str, String str2, String str3) {
        this.cxf = builder;
        this.aMv = z;
        this.context = context;
        this.cKu = fragmentManager;
        this.cKv = str;
        this.cKw = str2;
        this.tag = str3;
    }

    public void b(n<Builder> nVar) {
        this.cKx = nVar;
    }

    public void onBackStackChanged() {
        if (ac.c(this.cKu, this.tag)) {
            Builder apP;
            if (this.cKx == null) {
                apP = a.apP();
            } else {
                apP = (Builder) this.cKx.get();
            }
            this.cxf = apP;
            apV();
            return;
        }
        apU();
    }

    public void apU() {
        if (this.cxf != null) {
            a.a(this.context, this.cxf, this.cKv, this.cKw, this.aMv);
            this.cxf = null;
            apW();
        }
    }
}
