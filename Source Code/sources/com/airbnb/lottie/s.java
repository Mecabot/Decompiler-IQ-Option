package com.airbnb.lottie;

import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import com.airbnb.lottie.d.d;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker */
public class s {
    private boolean enabled = false;
    private final Set<a> kl = new ArraySet();
    private final Map<String, d> km = new HashMap();
    private final Comparator<Pair<String, Float>> kn = t.$instance;

    /* compiled from: PerformanceTracker */
    public interface a {
        void d(float f);
    }

    void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void a(String str, float f) {
        if (this.enabled) {
            d dVar = (d) this.km.get(str);
            if (dVar == null) {
                dVar = new d();
                this.km.put(str, dVar);
            }
            dVar.i(f);
            if (str.equals("__container")) {
                for (a d : this.kl) {
                    d.d(f);
                }
            }
        }
    }
}
