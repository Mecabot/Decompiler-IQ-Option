package com.iqoption.popup;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.iqoption.core.i;
import java.util.Iterator;
import java.util.PriorityQueue;

/* compiled from: PopupManager */
public class b {
    private static final String TAG = "com.iqoption.popup.b";
    private PriorityQueue<a> cXV = new PriorityQueue(24, a.cXT);

    public void a(Runnable runnable, String str) {
        a(runnable, str, PopupPriority.NORMAL);
    }

    public synchronized void a(Runnable runnable, String str, PopupPriority popupPriority) {
        a aVar = new a(str, popupPriority, SystemClock.elapsedRealtime(), runnable);
        if (this.cXV.isEmpty()) {
            this.cXV.add(aVar);
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show popup ");
            stringBuilder.append(str);
            i.d(str2, stringBuilder.toString());
            runnable.run();
        } else {
            String str3 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("add popup to queue ");
            stringBuilder2.append(str);
            i.d(str3, stringBuilder2.toString());
            if (!hP(str)) {
                this.cXV.add(aVar);
            }
        }
    }

    public synchronized void hO(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("notifyPopupHidden ");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        a iN = iN(str);
        if (iN != null) {
            this.cXV.remove(iN);
        }
        if (!(iN == null || this.cXV.isEmpty())) {
            iN = (a) this.cXV.iterator().next();
            str2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("show next popup ");
            stringBuilder.append(iN.getTag());
            i.d(str2, stringBuilder.toString());
            iN.avG().run();
        }
    }

    public boolean hP(String str) {
        return iN(str) != null;
    }

    public void onStop() {
        if (!this.cXV.isEmpty()) {
            a aVar = (a) this.cXV.iterator().next();
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onStop, displayed popup: ");
            stringBuilder.append(aVar.getTag());
            i.d(str, stringBuilder.toString());
            this.cXV.clear();
            this.cXV.add(aVar);
        }
    }

    public boolean isShowing() {
        return this.cXV.isEmpty() ^ 1;
    }

    @Nullable
    private a iN(@NonNull String str) {
        Iterator it = this.cXV.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.getTag().equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
