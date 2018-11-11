package io.fabric.sdk.android.services.b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventsFilesManager */
public abstract class b<T> {
    protected final Context context;
    protected final a<T> eob;
    protected final j eoc;
    protected final c eod;
    private final int eoe;
    protected volatile long eog;
    protected final List<d> eoh = new CopyOnWriteArrayList();

    /* compiled from: EventsFilesManager */
    static class a {
        final File file;
        final long timestamp;

        public a(File file, long j) {
            this.file = file;
            this.timestamp = j;
        }
    }

    protected abstract String gI();

    protected int gK() {
        return 8000;
    }

    public b(Context context, a<T> aVar, j jVar, c cVar, int i) {
        this.context = context.getApplicationContext();
        this.eob = aVar;
        this.eod = cVar;
        this.eoc = jVar;
        this.eog = this.eoc.aUE();
        this.eoe = i;
    }

    public void bV(T t) {
        byte[] n = this.eob.n(t);
        iY(n.length);
        this.eod.aa(n);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.eoh.add(dVar);
        }
    }

    public boolean gB() {
        String str;
        boolean z = true;
        if (this.eod.aVl()) {
            str = null;
            z = false;
        } else {
            str = gI();
            this.eod.lI(str);
            CommonUtils.a(this.context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.eog = this.eoc.aUE();
        }
        lG(str);
        return z;
    }

    private void iY(int i) {
        if (!this.eod.aY(i, gK())) {
            CommonUtils.a(this.context, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.eod.aVk()), Integer.valueOf(i), Integer.valueOf(gK())}));
            gB();
        }
    }

    protected int gJ() {
        return this.eoe;
    }

    private void lG(String str) {
        for (d aJ : this.eoh) {
            try {
                aJ.aJ(str);
            } catch (Throwable e) {
                CommonUtils.a(this.context, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> aVh() {
        return this.eod.iZ(1);
    }

    public void bN(List<File> list) {
        this.eod.bO(list);
    }

    public void aVi() {
        this.eod.bO(this.eod.aVm());
        this.eod.aVn();
    }

    public void aVj() {
        List<File> aVm = this.eod.aVm();
        int gJ = gJ();
        if (aVm.size() > gJ) {
            int size = aVm.size() - gJ;
            CommonUtils.H(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(aVm.size()), Integer.valueOf(gJ), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new Comparator<a>() {
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return (int) (aVar.timestamp - aVar2.timestamp);
                }
            });
            for (File file : aVm) {
                treeSet.add(new a(file, lH(file.getName())));
            }
            List aVm2 = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                aVm2.add(((a) it.next()).file);
                if (aVm2.size() == size) {
                    break;
                }
            }
            this.eod.bO(aVm2);
        }
    }

    public long lH(String str) {
        String[] split = str.split("_");
        if (split.length != 3) {
            return 0;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
