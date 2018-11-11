package com.iqoption.core.feed;

import android.content.Context;
import com.a.a.a;
import com.iqoption.core.f;
import com.iqoption.core.util.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u0005J\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/core/feed/CacheWrapper;", "", "context", "Landroid/content/Context;", "cacheDir", "", "cacheSize", "", "(Landroid/content/Context;Ljava/lang/String;J)V", "cache", "Lcom/jakewharton/disklrucache/DiskLruCache;", "locker", "Lcom/iqoption/core/feed/DiskCacheWriteLocker;", "ensureCache", "", "get", "Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;", "key", "streamToRead", "Ljava/io/FileInputStream;", "write", "writer", "Lkotlin/Function1;", "Ljava/io/OutputStream;", "", "core_release"})
/* compiled from: CacheWrapper.kt */
public final class c {
    private volatile a aQa;
    private final e aQb = new e();
    private final String aQc;
    private final long cacheSize;
    private final Context context;

    public c(Context context, String str, long j) {
        h.e(context, "context");
        h.e(str, "cacheDir");
        this.context = context;
        this.aQc = str;
        this.cacheSize = j;
    }

    public final void d(String str, b<? super OutputStream, Boolean> bVar) {
        h.e(str, "key");
        h.e(bVar, "writer");
        Tp();
        this.aQb.gu(str);
        a.a kB;
        OutputStream hF;
        try {
            a aVar = this.aQa;
            kB = aVar != null ? aVar.kB(str) : null;
            if (kB != null) {
                hF = kB.hF(0);
                h.d(hF, "os");
                if (((Boolean) bVar.invoke(hF)).booleanValue()) {
                    kB.commit();
                }
                e.b(hF);
                kB.abortUnlessCommitted();
            }
            this.aQb.release(str);
        } catch (Throwable th) {
            this.aQb.release(str);
        }
    }

    public final FileInputStream gs(String str) {
        h.e(str, "key");
        com.a.a.a.c gt = gt(str);
        return (FileInputStream) (gt != null ? gt.hI(0) : null);
    }

    private final com.a.a.a.c gt(String str) {
        Tp();
        a aVar = this.aQa;
        return aVar != null ? aVar.gt(str) : null;
    }

    private final void Tp() {
        if (this.aQa == null) {
            synchronized (this) {
                if (this.aQa == null) {
                    this.aQa = a.a(new File(this.context.getCacheDir(), this.aQc), f.RQ().Dp().getVersionCode(), 1, this.cacheSize);
                }
                l lVar = l.etX;
            }
        }
    }
}
