package com.microblink.secured;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.view.recognition.RecognitionType;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
public final class al {
    a dYH;
    private Handler mHandler;

    /* compiled from: line */
    class a {
        public AtomicBoolean dYN;
        public AtomicBoolean dYO;

        /* synthetic */ a(al alVar, byte b) {
            this();
        }

        private a() {
            this.dYN = new AtomicBoolean(false);
            this.dYO = new AtomicBoolean(false);
        }

        public final void reset() {
            this.dYN.set(false);
            this.dYO.set(false);
        }
    }

    /* compiled from: line */
    public static class b {
        public static final al dYP = new al();
    }

    /* synthetic */ al(byte b) {
        this();
    }

    private al() {
        this.dYH = null;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.dYH = new a(this, (byte) 0);
    }

    public final void a(final Context context, l lVar) {
        if (!this.dYH.dYN.getAndSet(true)) {
            try {
                int i = lVar.dWl == 0 ? 2 : lVar.dWl;
                final c cVar = new c(context);
                long currentTimeMillis = System.currentTimeMillis();
                long j = 0;
                if (cVar.dVK != null) {
                    j = cVar.dVK.getLong("com.microblink.ping.preferences.lastPing", 0);
                }
                if (currentTimeMillis - j < Long.valueOf((long) i).longValue() * 86400000) {
                    this.dYH.reset();
                } else if (!this.dYH.dYO.getAndSet(true)) {
                    String string;
                    String packageName;
                    com.microblink.secured.z.a aVar = new com.microblink.secured.z.a();
                    aVar.dWk = lVar.dWk;
                    aVar.dXR = NativeLibraryInfo.aQa();
                    String str = null;
                    if (cVar.dVK != null) {
                        string = cVar.dVK.getString("com.microblink.ping.preferences.userId", null);
                        if (string == null) {
                            string = UUID.randomUUID().toString();
                            cVar.dVK.edit().putString("com.microblink.ping.preferences.userId", string).commit();
                        }
                        str = string;
                    }
                    aVar.dXO = str;
                    aVar.dXS = Long.valueOf(cVar.aPs());
                    aVar.mPackageName = context.getPackageName();
                    if (lVar.dUh == null) {
                        packageName = context.getPackageName();
                    } else {
                        packageName = lVar.dUh;
                    }
                    aVar.dUh = packageName;
                    aVar.dXQ = false;
                    final z zVar = new z();
                    zVar.mPackageName = aVar.mPackageName;
                    zVar.dWk = aVar.dWk;
                    zVar.dUh = aVar.dUh;
                    zVar.dXO = aVar.dXO;
                    if (aVar.dXS != null) {
                        zVar.dXP = aVar.dXS.longValue();
                    }
                    if (aVar.dXR != null) {
                        zVar.dVN = aVar.dXR.dVN;
                        zVar.dXL = aVar.dXR.dVM.name();
                    }
                    zVar.dXN = VERSION.RELEASE;
                    string = Build.MANUFACTURER;
                    if (string != null) {
                        string = string.toUpperCase();
                    }
                    str = Build.MODEL;
                    if (str != null) {
                        str = str.toUpperCase();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(com.microblink.secured.z.a.kE(string));
                    stringBuilder.append(" - ");
                    stringBuilder.append(com.microblink.secured.z.a.kE(str));
                    zVar.dXa = stringBuilder.toString();
                    zVar.dXQ = aVar.dXQ;
                    Runnable anonymousClass1 = new Runnable() {
                        public final void run() {
                            new g(new com.microblink.secured.g.b() {
                                public final void a(d dVar) {
                                    if (!(dVar == null || context == null || dVar.dVL != 201)) {
                                        c cVar = cVar;
                                        long currentTimeMillis = System.currentTimeMillis();
                                        if (cVar.dVK != null) {
                                            cVar.dVK.edit().putLong("com.microblink.ping.preferences.lastPing", currentTimeMillis).commit();
                                        }
                                        cVar.cD(0);
                                    }
                                    al.this.dYH.reset();
                                }

                                public final void aPt() {
                                    al.this.dYH.reset();
                                }
                            }).execute(new z[]{zVar});
                        }
                    };
                    if (context instanceof Activity) {
                        ((Activity) context).runOnUiThread(anonymousClass1);
                    } else if (Looper.myLooper().equals(Looper.getMainLooper())) {
                        anonymousClass1.run();
                    } else {
                        this.mHandler.post(anonymousClass1);
                    }
                }
            } catch (Exception unused) {
                this.dYH.reset();
            }
        }
    }

    public final void a(RecognitionType recognitionType, Context context) {
        if (!this.dYH.dYO.get() && recognitionType == RecognitionType.SUCCESSFUL) {
            c cVar = new c(context);
            long aPs = cVar.aPs();
            if (aPs < Long.MAX_VALUE) {
                cVar.cD(aPs + 1);
            }
        }
    }
}
