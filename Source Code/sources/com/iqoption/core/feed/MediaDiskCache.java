package com.iqoption.core.feed;

import android.annotation.SuppressLint;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.core.f;
import com.iqoption.core.util.e;
import java.io.FileInputStream;
import java.io.OutputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import okio.ByteString;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J*\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/core/feed/MediaDiskCache;", "", "()V", "ORIGINALS_CACHE_SIZE", "", "THUMBNAIL_CACHE_SIZE", "originalCache", "Lcom/iqoption/core/feed/CacheWrapper;", "thumbnailCache", "get", "Ljava/io/FileInputStream;", "cacheableObject", "Lcom/iqoption/core/feed/CacheableObject;", "type", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "getCache", "getKey", "", "isCached", "", "notifyPreviewable", "", "write", "writer", "Lkotlin/Function1;", "Ljava/io/OutputStream;", "MediaType", "core_release"})
/* compiled from: MediaDiskCache.kt */
public final class MediaDiskCache {
    public static final MediaDiskCache aQA = new MediaDiskCache();
    @SuppressLint({"StaticFieldLeak"})
    private static final c aQy = new c(f.RQ().getContext(), "thumbnails", 33554432);
    @SuppressLint({"StaticFieldLeak"})
    private static final c aQz = new c(f.RQ().getContext(), "originals", 67108864);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "", "(Ljava/lang/String;I)V", "THUMBNAIL", "ORIGINAL", "core_release"})
    /* compiled from: MediaDiskCache.kt */
    public enum MediaType {
        THUMBNAIL,
        ORIGINAL
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: MediaDiskCache.kt */
    static final class a implements Runnable {
        final /* synthetic */ MediaType aPY;
        final /* synthetic */ d aQB;

        a(d dVar, MediaType mediaType) {
            this.aQB = dVar;
            this.aPY = mediaType;
        }

        public final void run() {
            a.aPQ.a((j) this.aQB, this.aPY);
        }
    }

    private MediaDiskCache() {
    }

    public final boolean a(d dVar, MediaType mediaType) {
        h.e(dVar, "cacheableObject");
        h.e(mediaType, Param.TYPE);
        FileInputStream b = b(dVar, mediaType);
        boolean z = b != null;
        e.b(b);
        return z;
    }

    public final FileInputStream b(d dVar, MediaType mediaType) {
        h.e(dVar, "cacheableObject");
        h.e(mediaType, Param.TYPE);
        String d = d(dVar, mediaType);
        return d != null ? d(mediaType).gs(d) : null;
    }

    public final void a(d dVar, MediaType mediaType, b<? super OutputStream, Boolean> bVar) {
        h.e(dVar, "cacheableObject");
        h.e(mediaType, Param.TYPE);
        h.e(bVar, "writer");
        String d = d(dVar, mediaType);
        if (d != null) {
            d(mediaType).d(d, bVar);
            c(dVar, mediaType);
        }
    }

    private final void c(d dVar, MediaType mediaType) {
        if (dVar instanceof j) {
            com.iqoption.core.d.a.aSe.post(new a(dVar, mediaType));
        }
    }

    public final String d(d dVar, MediaType mediaType) {
        h.e(dVar, "cacheableObject");
        h.e(mediaType, Param.TYPE);
        String c = dVar.c(mediaType);
        return c != null ? ByteString.encodeUtf8(c).md5().hex() : null;
    }

    private final c d(MediaType mediaType) {
        switch (i.aoS[mediaType.ordinal()]) {
            case 1:
                return aQz;
            case 2:
                return aQy;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
