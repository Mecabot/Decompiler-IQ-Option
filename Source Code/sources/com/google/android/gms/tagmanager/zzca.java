package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzdyq;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

final class zzca extends Thread implements zzbz {
    private static zzca zzkpy;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean zzcnf = false;
    private final LinkedBlockingQueue<Runnable> zzkpx = new LinkedBlockingQueue();
    private volatile zzcc zzkpz;

    private zzca(Context context) {
        super("GAThread");
        if (context != null) {
            context = context.getApplicationContext();
        }
        this.mContext = context;
        start();
    }

    static zzca zzen(Context context) {
        if (zzkpy == null) {
            zzkpy = new zzca(context);
        }
        return zzkpy;
    }

    public final void run() {
        while (true) {
            boolean z = this.mClosed;
            try {
                Runnable runnable = (Runnable) this.zzkpx.take();
                if (!this.zzcnf) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzdj.zzcy(e.toString());
            } catch (Throwable th) {
                String str = "Error on Google TagManager Thread: ";
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                zzdyq.zza(th, printStream);
                printStream.flush();
                String valueOf = String.valueOf(new String(byteArrayOutputStream.toByteArray()));
                zzdj.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                zzdj.e("Google TagManager is shutting down.");
                this.zzcnf = true;
            }
        }
    }

    public final void zzlw(String str) {
        zzm(new zzcb(this, this, System.currentTimeMillis(), str));
    }

    public final void zzm(Runnable runnable) {
        this.zzkpx.add(runnable);
    }
}
