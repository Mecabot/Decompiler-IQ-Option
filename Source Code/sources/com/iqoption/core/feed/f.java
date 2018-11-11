package com.iqoption.core.feed;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.load.kotlin.j.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u00060\u0006R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006R\u00020\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/feed/FeedImageLoader;", "", "()V", "currentLoads", "", "Lcom/iqoption/core/feed/Previewable;", "Lcom/iqoption/core/feed/FeedImageLoader$LoadDescriptor;", "downloader", "Lcom/iqoption/core/feed/ImageDownloader;", "acquireLoadDescriptor", "previewable", "loadOriginal", "", "loadThumbnail", "performLoad", "LoadDescriptor", "core_release"})
/* compiled from: FeedImageLoader.kt */
public final class f {
    private final Map<j, a> aQr = new LinkedHashMap();
    private final g aQs = new g();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/feed/FeedImageLoader$LoadDescriptor;", "", "previewable", "Lcom/iqoption/core/feed/Previewable;", "(Lcom/iqoption/core/feed/FeedImageLoader;Lcom/iqoption/core/feed/Previewable;)V", "originalMonitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmType$Object;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "thumbnailMonitor", "acquire", "", "loadOriginal", "loadThumbnail", "release", "core_release"})
    /* compiled from: FeedImageLoader.kt */
    private final class a {
        private final j aPU;
        private final b aQt = new b("thumbnail");
        private final b aQu = new b("original");
        private final AtomicInteger aQv = new AtomicInteger(0);
        final /* synthetic */ f aQw;

        public a(f fVar, j jVar) {
            h.e(jVar, "previewable");
            this.aQw = fVar;
            this.aPU = jVar;
        }

        public final void Tx() {
            acquire();
            try {
                synchronized (this.aQt) {
                    this.aQw.j(this.aPU);
                    l lVar = l.etX;
                }
                release();
            } catch (Throwable th) {
                release();
            }
        }

        public final void Ty() {
            acquire();
            try {
                synchronized (this.aQu) {
                    this.aQw.i(this.aPU);
                    l lVar = l.etX;
                }
                release();
            } catch (Throwable th) {
                release();
            }
        }

        public final void acquire() {
            this.aQv.incrementAndGet();
        }

        public final void release() {
            if (this.aQv.decrementAndGet() == 0) {
                synchronized (this.aQw) {
                    a aVar = (a) this.aQw.aQr.remove(this.aPU);
                }
            }
        }
    }

    public final void g(j jVar) {
        h.e(jVar, "previewable");
        a h = h(jVar);
        try {
            h.Tx();
            h.Ty();
        } finally {
            h.release();
        }
    }

    private final a h(j jVar) {
        a aVar;
        synchronized (this) {
            aVar = (a) this.aQr.get(jVar);
            if (aVar == null) {
                aVar = new a(this, jVar);
                this.aQr.put(jVar, aVar);
            }
            aVar.acquire();
        }
        return aVar;
    }

    private final void i(j jVar) {
        if (!TextUtils.isEmpty(jVar.Tw())) {
            this.aQs.i(jVar);
        }
    }

    private final void j(j jVar) {
        if (!TextUtils.isEmpty(jVar.Tv())) {
            this.aQs.j(jVar);
        }
    }
}
