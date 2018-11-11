package com.microblink.secured;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: line */
public final class g extends AsyncTask<z, Void, a> {
    private b dVU = null;

    /* compiled from: line */
    public class a {
        d dVV = null;
        Exception dVW = null;

        public a(d dVar) {
            this.dVV = dVar;
        }

        public a(Exception exception) {
            this.dVW = exception;
        }
    }

    /* compiled from: line */
    public interface b {
        void a(d dVar);

        void aPt();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        if (!(aVar == null || this.dVU == null)) {
            if (aVar.dVW != null) {
                this.dVU.aPt();
                return;
            }
            this.dVU.a(aVar.dVV);
        }
    }

    public g(b bVar) {
        this.dVU = bVar;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private a a(z... zVarArr) {
        try {
            if (VERSION.SDK_INT < 8) {
                System.setProperty("https.keepAlive", "false");
            }
            z zVar = zVarArr[0];
            Map treeMap = new TreeMap();
            if (zVar.dXL != null) {
                treeMap.put("product", zVar.dXL);
            }
            if (zVar.dVN != null) {
                treeMap.put("productVersion", zVar.dVN);
            }
            treeMap.put("licensee", zVar.dUh);
            treeMap.put("userId", zVar.dXO);
            treeMap.put("scans", String.valueOf(zVar.dXP));
            treeMap.put("packageName", zVar.mPackageName);
            if (zVar.dXa != null) {
                treeMap.put("device", zVar.dXa);
            }
            if (zVar.dXN != null) {
                treeMap.put("osVersion", zVar.dXN);
            }
            treeMap.put("platform", zVar.dXM);
            if (zVar.dXQ) {
                treeMap.put("refreshKey", String.valueOf(zVar.dXQ));
            }
            IIllIIllll kC = IIllIIllll.kC("https://ping.microblink.com/ping");
            kC.aPy().setConnectTimeout(2000);
            kC.G(treeMap);
            return new a(new d(kC.getResponseCode()));
        } catch (Exception e) {
            return new a(e);
        }
    }
}
