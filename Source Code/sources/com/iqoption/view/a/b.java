package com.iqoption.view.a;

import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.iqoption.app.managers.af;
import com.iqoption.core.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: GlobalTimer */
public class b {
    private static final n<b> cGv = Suppliers.a(c.ajD);
    private final com.iqoption.system.b dEF = new com.iqoption.system.b(200) {
        public void axw() {
            b.this.dEI = b.this.dEI + 1;
            if (b.this.dEI > b.this.dEH) {
                b.this.dEI = 0;
            }
            long Hw = af.Hu().Hw();
            Map hashMap = new HashMap();
            synchronized (b.this.dEG) {
                hashMap.putAll(b.this.dEG);
            }
            for (Entry entry : hashMap.entrySet()) {
                if (b.this.dEI % ((Integer) entry.getValue()).intValue() == 0) {
                    ((a) entry.getKey()).onTick(Hw);
                }
            }
        }
    };
    private final HashMap<a, Integer> dEG = new HashMap(100);
    private int dEH = 1;
    private int dEI = 0;

    /* compiled from: GlobalTimer */
    public interface a {
        void onTick(long j);
    }

    private b() {
    }

    public static b aIK() {
        return (b) cGv.get();
    }

    private void aIL() {
        this.dEH = this.dEG.isEmpty() ? 0 : ((Integer) Collections.max(this.dEG.values())).intValue();
    }

    public void a(a aVar, Integer num) {
        synchronized (this.dEG) {
            this.dEG.put(aVar, num);
            if (this.dEG.size() == 1) {
                this.dEF.aEn();
            }
        }
        aIL();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GlobalTimer removeListener = ");
        stringBuilder.append(this.dEG.size());
        i.d(stringBuilder.toString());
    }

    public void a(a aVar) {
        a(aVar, Integer.valueOf(1));
    }

    public void b(a aVar) {
        synchronized (this.dEG) {
            this.dEG.remove(aVar);
            if (this.dEG.size() == 0) {
                this.dEF.cancel();
            }
        }
        aIL();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GlobalTimer removeListener = ");
        stringBuilder.append(this.dEG.size());
        i.d(stringBuilder.toString());
    }
}
