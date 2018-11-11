package com.iqoption.core.feed;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.ac;
import com.iqoption.core.feed.MediaDiskCache.MediaType;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.n;
import kotlin.l;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001!\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007QRSTUVWB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\nH\u0002J\u001a\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\u0013JP\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0002J\u001c\u00107\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\n2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J*\u00108\u001a\u00020\u00162\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\u00132\f\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010:\u001a\u00020\u001aH\u0002J@\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00102\u001a\u00020-2\u0006\u00101\u001a\u00020-H\u0002J \u0010>\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u0018\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u000e\u0010B\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\nJ\b\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020&2\u0006\u0010'\u001a\u00020\nH\u0002J \u0010F\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0018\u0010H\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u000e\u0010I\u001a\u00020&2\u0006\u0010'\u001a\u00020\nJ\b\u0010J\u001a\u00020&H\u0002J8\u0010K\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00102\u001a\u00020-2\u0006\u00101\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0002J\u0012\u0010L\u001a\u00020&2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\u0013J\u001e\u0010L\u001a\u00020&2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010M\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010N\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u0016\u0010O\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u001aJ\b\u0010P\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000RN\u0010\u0007\u001aB\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \t*\u0004\u0018\u00010\n0\n \t* \u0012\f\u0012\n \t*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \t*\u0004\u0018\u00010\n0\n\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0018\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130$X\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader;", "", "()V", "NULL_RESULT", "Lcom/iqoption/core/feed/CacheLoader$Result;", "TAG", "", "cacheObjectsByKey", "Lcom/google/common/collect/SetMultimap;", "kotlin.jvm.PlatformType", "Lcom/iqoption/core/feed/Previewable;", "cacheOriginal", "Landroid/support/v4/util/LruCache;", "Lcom/iqoption/core/feed/CacheLoader$ResultWrapper;", "cacheThumbnail", "executor", "Ljava/util/concurrent/ExecutorService;", "handlersToHandlerInfo", "Ljava/util/WeakHashMap;", "Lcom/iqoption/core/feed/CacheLoader$LoadingHandler;", "Lcom/iqoption/core/feed/CacheLoader$HandlerInfo;", "isRunning", "", "loading", "Ljava/util/LinkedHashMap;", "Ljava/util/EnumSet;", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "previewableToLoadingInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/iqoption/core/feed/CacheLoader$LoadingInfo;", "queue", "Ljava/lang/ref/ReferenceQueue;", "stubHandler", "com/iqoption/core/feed/CacheLoader$stubHandler$1", "Lcom/iqoption/core/feed/CacheLoader$stubHandler$1;", "tmpIterationList", "Ljava/util/ArrayList;", "accessCacheObject", "", "previewable", "bind", "handler", "calcPreviewScale", "", "maxWidth", "", "maxHeight", "minWidth", "minHeight", "srcHeight", "srcWidth", "orientation", "outXOffset", "", "outYOffset", "checkCaches", "checkResult", "result", "type", "createScaledBitmap", "Landroid/graphics/Bitmap;", "srcBitmap", "getCache", "getResult", "inputStream", "Ljava/io/FileInputStream;", "isBound", "newPurgeableBitmapOptions", "Landroid/graphics/BitmapFactory$Options;", "notifyError", "notifyLoaded", "bitmapResult", "ping", "preload", "processQueue", "scaleParams", "unbind", "oldInfo", "uncache", "updated", "workingLoop", "HandlerInfo", "ImageResult", "LoadingHandler", "LoadingInfo", "PreviewableWeakReference", "Result", "ResultWrapper", "core_release"})
/* compiled from: CacheLoader.kt */
public final class a {
    private static boolean Fs;
    private static final f aPG = new f();
    private static final k aPH = new k();
    private static final ReferenceQueue<Object> aPI = new ReferenceQueue();
    private static final ConcurrentHashMap<j, d> aPJ = new ConcurrentHashMap();
    private static final WeakHashMap<c<?>, a> aPK = new WeakHashMap();
    private static final ArrayList<c<?>> aPL = new ArrayList();
    private static final LruCache<j, g<?>> aPM = new LruCache(32);
    private static final LruCache<j, g<?>> aPN = new LruCache(16);
    private static final LinkedHashMap<j, EnumSet<MediaType>> aPO = new LinkedHashMap(32, 0.75f, true);
    private static final ac<String, j> aPP = MultimapBuilder.uv().uC().uD();
    public static final a aPQ = new a();
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader$HandlerInfo;", "", "lastRequestedPreviewable", "Lcom/iqoption/core/feed/Previewable;", "lastLoadedType", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "(Lcom/iqoption/core/feed/Previewable;Lcom/iqoption/core/feed/MediaDiskCache$MediaType;)V", "getLastLoadedType", "()Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "setLastLoadedType", "(Lcom/iqoption/core/feed/MediaDiskCache$MediaType;)V", "getLastRequestedPreviewable", "()Lcom/iqoption/core/feed/Previewable;", "setLastRequestedPreviewable", "(Lcom/iqoption/core/feed/Previewable;)V", "core_release"})
    /* compiled from: CacheLoader.kt */
    private static final class a {
        private j aPR;
        private MediaType aPS;

        public a() {
            this(null, null, 3, null);
        }

        public a(j jVar, MediaType mediaType) {
            this.aPR = jVar;
            this.aPS = mediaType;
        }

        public /* synthetic */ a(j jVar, MediaType mediaType, int i, f fVar) {
            if ((i & 1) != 0) {
                jVar = (j) null;
            }
            if ((i & 2) != 0) {
                mediaType = (MediaType) null;
            }
            this(jVar, mediaType);
        }

        public final j Th() {
            return this.aPR;
        }

        public final MediaType Ti() {
            return this.aPS;
        }

        public final void b(MediaType mediaType) {
            this.aPS = mediaType;
        }

        public final void e(j jVar) {
            this.aPR = jVar;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader$LoadingHandler;", "R", "Lcom/iqoption/core/feed/CacheLoader$Result;", "", "onError", "", "onLoaded", "result", "mediaType", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "(Lcom/iqoption/core/feed/CacheLoader$Result;Lcom/iqoption/core/feed/MediaDiskCache$MediaType;)V", "onStart", "core_release"})
    /* compiled from: CacheLoader.kt */
    public interface c<R extends f> {
        void a(R r, MediaType mediaType);

        void onError();

        void onStart();
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\nJ\b\u0010\u0011\u001a\u00020\u000fH\u0002J$\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\nH\u0002J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0012\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R5\u0010\u0007\u001a&\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t0\bj\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader$LoadingInfo;", "", "previewable", "Lcom/iqoption/core/feed/Previewable;", "(Lcom/iqoption/core/feed/Previewable;)V", "getPreviewable", "()Lcom/iqoption/core/feed/Previewable;", "weakHandlers", "Ljava/util/HashSet;", "Lcom/iqoption/core/feed/CacheLoader$PreviewableWeakReference;", "Lcom/iqoption/core/feed/CacheLoader$LoadingHandler;", "Lkotlin/collections/HashSet;", "getWeakHandlers", "()Ljava/util/HashSet;", "add", "", "handler", "copyHandlers", "notifyHandler", "result", "Lcom/iqoption/core/feed/CacheLoader$Result;", "type", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "notifyHandlers", "notifyHandlersError", "remove", "", "core_release"})
    /* compiled from: CacheLoader.kt */
    private static final class d {
        private final HashSet<e<c<?>>> aPT = new HashSet();
        private final j aPU;

        public d(j jVar) {
            kotlin.jvm.internal.h.e(jVar, "previewable");
            this.aPU = jVar;
        }

        public final HashSet<e<c<?>>> Tj() {
            return this.aPT;
        }

        public final void b(c<?> cVar) {
            kotlin.jvm.internal.h.e(cVar, "handler");
            Iterator it = this.aPT.iterator();
            while (it.hasNext()) {
                c<?> cVar2 = (c) ((e) it.next()).get();
                if (cVar2 == null) {
                    it.remove();
                } else if (cVar2 == cVar) {
                    return;
                }
            }
            this.aPT.add(new e(cVar, this.aPU, a.aPI));
        }

        public final boolean c(c<?> cVar) {
            kotlin.jvm.internal.h.e(cVar, "handler");
            Iterator it = this.aPT.iterator();
            Object obj = null;
            while (it.hasNext()) {
                c<?> cVar2 = (c) ((e) it.next()).get();
                if (cVar2 == null) {
                    it.remove();
                } else if (cVar2 == cVar) {
                    it.remove();
                    obj = 1;
                }
            }
            if (obj == null) {
                com.iqoption.core.i.e("CacheLoader", "handler not bound here");
            }
            return this.aPT.isEmpty();
        }

        public final void b(f fVar, MediaType mediaType) {
            kotlin.jvm.internal.h.e(fVar, "result");
            kotlin.jvm.internal.h.e(mediaType, Param.TYPE);
            Tl();
            try {
                Iterator it = a.aPL.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    kotlin.jvm.internal.h.d(cVar, "handler");
                    a(fVar, mediaType, cVar);
                }
            } finally {
                a.aPL.clear();
            }
        }

        public final void Tk() {
            Tl();
            try {
                Iterator it = a.aPL.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onError();
                }
            } finally {
                a.aPL.clear();
            }
        }

        private final void Tl() {
            Iterator it = this.aPT.iterator();
            while (it.hasNext()) {
                c cVar = (c) ((e) it.next()).get();
                if (cVar == null) {
                    it.remove();
                } else {
                    a.aPL.add(cVar);
                }
            }
        }

        private final void a(f fVar, MediaType mediaType, c<?> cVar) {
            a aVar = (a) a.aPK.get(cVar);
            if (aVar != null) {
                MediaType Ti = aVar.Ti();
                if (Ti == null || Ti.ordinal() <= mediaType.ordinal()) {
                    aVar.b(mediaType);
                    if (cVar == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.feed.CacheLoader.LoadingHandler<com.iqoption.core.feed.CacheLoader.Result>");
                    }
                    cVar.a(fVar, mediaType);
                    return;
                }
                return;
            }
            throw new IllegalStateException("No handler info?");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader$PreviewableWeakReference;", "T", "Ljava/lang/ref/WeakReference;", "reference", "previewable", "Lcom/iqoption/core/feed/Previewable;", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "(Ljava/lang/Object;Lcom/iqoption/core/feed/Previewable;Ljava/lang/ref/ReferenceQueue;)V", "getPreviewable", "()Lcom/iqoption/core/feed/Previewable;", "core_release"})
    /* compiled from: CacheLoader.kt */
    private static final class e<T> extends WeakReference<T> {
        private final j aPU;

        public final j Tm() {
            return this.aPU;
        }

        public e(T t, j jVar, ReferenceQueue<? super T> referenceQueue) {
            kotlin.jvm.internal.h.e(jVar, "previewable");
            kotlin.jvm.internal.h.e(referenceQueue, "referenceQueue");
            super(t, referenceQueue);
            this.aPU = jVar;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader$Result;", "", "()V", "core_release"})
    /* compiled from: CacheLoader.kt */
    public static class f {
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader$ResultWrapper;", "R", "Lcom/iqoption/core/feed/CacheLoader$Result;", "", "result", "key", "", "invalid", "", "(Lcom/iqoption/core/feed/CacheLoader$Result;Ljava/lang/String;Z)V", "getInvalid", "()Z", "setInvalid", "(Z)V", "getKey", "()Ljava/lang/String;", "getResult", "()Lcom/iqoption/core/feed/CacheLoader$Result;", "Lcom/iqoption/core/feed/CacheLoader$Result;", "core_release"})
    /* compiled from: CacheLoader.kt */
    private static final class g<R extends f> {
        private final R aPV;
        private boolean aPW;
        private final String key;

        public g(R r, String str, boolean z) {
            kotlin.jvm.internal.h.e(r, "result");
            kotlin.jvm.internal.h.e(str, "key");
            this.aPV = r;
            this.key = str;
            this.aPW = z;
        }

        public /* synthetic */ g(f fVar, String str, boolean z, int i, f fVar2) {
            if ((i & 4) != 0) {
                z = false;
            }
            this(fVar, str, z);
        }

        public final R Tn() {
            return this.aPV;
        }

        public final boolean To() {
            return this.aPW;
        }

        public final void cg(boolean z) {
            this.aPW = z;
        }

        public final String getKey() {
            return this.key;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: CacheLoader.kt */
    static final class h implements Runnable {
        final /* synthetic */ j $previewable;

        h(j jVar) {
            this.$previewable = jVar;
        }

        public final void run() {
            d dVar = (d) a.aPJ.get(this.$previewable);
            if (dVar != null) {
                dVar.Tk();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: CacheLoader.kt */
    static final class i implements Runnable {
        final /* synthetic */ j $previewable;
        final /* synthetic */ f aPX;
        final /* synthetic */ MediaType aPY;

        i(j jVar, f fVar, MediaType mediaType) {
            this.$previewable = jVar;
            this.aPX = fVar;
            this.aPY = mediaType;
        }

        public final void run() {
            d dVar = (d) a.aPJ.get(this.$previewable);
            if (dVar != null) {
                dVar.b(this.aPX, this.aPY);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: CacheLoader.kt */
    static final class j implements Runnable {
        public static final j aPZ = new j();

        j() {
        }

        public final void run() {
            a.aPQ.Te();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/feed/CacheLoader$ImageResult;", "Lcom/iqoption/core/feed/CacheLoader$Result;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "core_release"})
    /* compiled from: CacheLoader.kt */
    public static final class b extends f {
        private final Bitmap bitmap;

        public b(Bitmap bitmap) {
            kotlin.jvm.internal.h.e(bitmap, "bitmap");
            this.bitmap = bitmap;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, aXE = {"com/iqoption/core/feed/CacheLoader$stubHandler$1", "Lcom/iqoption/core/feed/CacheLoader$LoadingHandler;", "Lcom/iqoption/core/feed/CacheLoader$ImageResult;", "onError", "", "onLoaded", "result", "mediaType", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "onStart", "core_release"})
    /* compiled from: CacheLoader.kt */
    public static final class k implements c<b> {
        public void onStart() {
        }

        k() {
        }

        public void a(b bVar, MediaType mediaType) {
            kotlin.jvm.internal.h.e(bVar, "result");
            kotlin.jvm.internal.h.e(mediaType, "mediaType");
            a.aPQ.a((c) this);
        }

        public void onError() {
            a.aPQ.a((c) this);
        }
    }

    private a() {
    }

    public final void a(j jVar, c<?> cVar) {
        kotlin.jvm.internal.h.e(jVar, "previewable");
        kotlin.jvm.internal.h.e(cVar, "handler");
        Tg();
        a aVar = (a) aPK.get(cVar);
        if (aVar == null) {
            aVar = new a(null, null, 3, null);
            aPK.put(cVar, aVar);
        } else if (aVar.Th() != jVar) {
            aVar.b((MediaType) null);
            a((c) cVar, aVar);
        } else {
            return;
        }
        aVar.e(jVar);
        d(jVar);
        d dVar = (d) aPJ.get(jVar);
        if (dVar == null) {
            dVar = new d(jVar);
            aPJ.put(jVar, dVar);
        }
        dVar.b(cVar);
        FeedFetcher.aQo.f(jVar);
        if (!b(jVar, (c) cVar)) {
            b(jVar, MediaType.ORIGINAL);
        }
    }

    public final void a(j jVar) {
        kotlin.jvm.internal.h.e(jVar, "previewable");
        a(jVar, (c) aPH);
    }

    public final void a(c<?> cVar) {
        kotlin.jvm.internal.h.e(cVar, "handler");
        a((c) cVar, (a) aPK.remove(cVar));
    }

    public final boolean b(j jVar) {
        kotlin.jvm.internal.h.e(jVar, "previewable");
        return aPJ.get(jVar) != null;
    }

    public final void a(j jVar, MediaType mediaType) {
        kotlin.jvm.internal.h.e(jVar, "previewable");
        kotlin.jvm.internal.h.e(mediaType, Param.TYPE);
        LruCache a = a(mediaType);
        g gVar = (g) a.get(jVar);
        if (gVar != null) {
            String key = gVar.getKey();
            synchronized (this) {
                for (j jVar2 : aPP.X(key)) {
                    g gVar2 = (g) a.get(jVar2);
                    if (gVar2 != null) {
                        if (gVar2 == null) {
                            kotlin.jvm.internal.h.aXZ();
                        }
                        if (gVar2.Tn() == aPG) {
                            a.remove(jVar2);
                        } else {
                            if (gVar2 == null) {
                                kotlin.jvm.internal.h.aXZ();
                            }
                            gVar2.cg(true);
                        }
                    }
                    a aVar = aPQ;
                    kotlin.jvm.internal.h.d(jVar2, "m");
                    aVar.b(jVar2, mediaType);
                }
                l lVar = l.etX;
            }
        }
    }

    private final boolean b(j jVar, c<?> cVar) {
        g gVar = (g) aPN.get(jVar);
        boolean z = true;
        if (a((c) cVar, gVar, MediaType.ORIGINAL)) {
            return true;
        }
        if (gVar == null || !kotlin.jvm.internal.h.E(gVar.Tn(), aPG)) {
            z = false;
        }
        if (a((c) cVar, (g) aPM.get(jVar), MediaType.THUMBNAIL)) {
            return false;
        }
        return z;
    }

    private final boolean a(c<?> cVar, g<?> gVar, MediaType mediaType) {
        if (gVar == null || gVar.Tn() == aPG) {
            return false;
        }
        a aVar = (a) aPK.get(cVar);
        if (aVar != null) {
            aVar.b(mediaType);
        }
        if (cVar == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.feed.CacheLoader.LoadingHandler<com.iqoption.core.feed.CacheLoader.Result>");
        }
        cVar.a(gVar.Tn(), mediaType);
        return true;
    }

    private final void b(j jVar, MediaType mediaType) {
        synchronized (this) {
            EnumSet enumSet = (EnumSet) aPO.get(jVar);
            if (enumSet == null) {
                Map map = aPO;
                EnumSet of = EnumSet.of(mediaType);
                kotlin.jvm.internal.h.d(of, "EnumSet.of(type)");
                map.put(jVar, of);
            } else {
                enumSet.add(mediaType);
            }
            if (!Fs) {
                Fs = true;
                executor.execute(j.aPZ);
            }
            l lVar = l.etX;
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0038, code:
            if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Missing block: B:12:0x003a, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:14:0x0043, code:
            if (r1.contains(com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL) == false) goto L_0x0068;
     */
    /* JADX WARNING: Missing block: B:15:0x0045, code:
            if (r2 != null) goto L_0x004a;
     */
    /* JADX WARNING: Missing block: B:16:0x0047, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:18:0x0050, code:
            if (c(r2, com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL) == false) goto L_0x0068;
     */
    /* JADX WARNING: Missing block: B:19:0x0052, code:
            if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:20:0x0054, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:21:0x0057, code:
            r1.remove(com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL);
     */
    /* JADX WARNING: Missing block: B:22:0x005c, code:
            if (r1 != null) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:23:0x005e, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:25:0x0065, code:
            if (r1.isEmpty() == false) goto L_0x0068;
     */
    /* JADX WARNING: Missing block: B:27:0x0068, code:
            if (r1 != null) goto L_0x006d;
     */
    /* JADX WARNING: Missing block: B:28:0x006a, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:30:0x0073, code:
            if (r1.contains(com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL) != false) goto L_0x0082;
     */
    /* JADX WARNING: Missing block: B:31:0x0075, code:
            if (r1 != null) goto L_0x007a;
     */
    /* JADX WARNING: Missing block: B:32:0x0077, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:34:0x0080, code:
            if (r1.contains(com.iqoption.core.feed.MediaDiskCache.MediaType.THUMBNAIL) == false) goto L_0x0000;
     */
    /* JADX WARNING: Missing block: B:35:0x0082, code:
            if (r2 != null) goto L_0x0087;
     */
    /* JADX WARNING: Missing block: B:36:0x0084, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:38:0x008d, code:
            if (c(r2, com.iqoption.core.feed.MediaDiskCache.MediaType.THUMBNAIL) == false) goto L_0x0000;
     */
    /* JADX WARNING: Missing block: B:39:0x008f, code:
            if (r1 != null) goto L_0x0094;
     */
    /* JADX WARNING: Missing block: B:40:0x0091, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:41:0x0094, code:
            r1.remove(com.iqoption.core.feed.MediaDiskCache.MediaType.THUMBNAIL);
     */
    private final void Te() {
        /*
        r3 = this;
    L_0x0000:
        r0 = 0;
        r1 = r0;
        r1 = (com.iqoption.core.feed.j) r1;
        r0 = (java.util.EnumSet) r0;
        monitor-enter(r3);
        r0 = aPO;	 Catch:{ all -> 0x009b }
        r0 = r0.entrySet();	 Catch:{ all -> 0x009b }
        r0 = r0.iterator();	 Catch:{ all -> 0x009b }
        r1 = r0.hasNext();	 Catch:{ all -> 0x009b }
        if (r1 != 0) goto L_0x001c;
    L_0x0017:
        r0 = 0;
        Fs = r0;	 Catch:{ all -> 0x009b }
        monitor-exit(r3);
        return;
    L_0x001c:
        r1 = r0.next();	 Catch:{ all -> 0x009b }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ all -> 0x009b }
        r2 = r1.getKey();	 Catch:{ all -> 0x009b }
        r2 = (com.iqoption.core.feed.j) r2;	 Catch:{ all -> 0x009b }
        r1 = r1.getValue();	 Catch:{ all -> 0x009b }
        r1 = (java.util.EnumSet) r1;	 Catch:{ all -> 0x009b }
        r1 = java.util.EnumSet.copyOf(r1);	 Catch:{ all -> 0x009b }
        r0.remove();	 Catch:{ all -> 0x009b }
        r0 = kotlin.l.etX;	 Catch:{ all -> 0x009b }
        monitor-exit(r3);
        if (r1 != 0) goto L_0x003d;
    L_0x003a:
        kotlin.jvm.internal.h.aXZ();
    L_0x003d:
        r0 = com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL;
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x0068;
    L_0x0045:
        if (r2 != 0) goto L_0x004a;
    L_0x0047:
        kotlin.jvm.internal.h.aXZ();
    L_0x004a:
        r0 = com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL;
        r0 = r3.c(r2, r0);
        if (r0 == 0) goto L_0x0068;
    L_0x0052:
        if (r1 != 0) goto L_0x0057;
    L_0x0054:
        kotlin.jvm.internal.h.aXZ();
    L_0x0057:
        r0 = com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL;
        r1.remove(r0);
        if (r1 != 0) goto L_0x0061;
    L_0x005e:
        kotlin.jvm.internal.h.aXZ();
    L_0x0061:
        r0 = r1.isEmpty();
        if (r0 == 0) goto L_0x0068;
    L_0x0067:
        goto L_0x0000;
    L_0x0068:
        if (r1 != 0) goto L_0x006d;
    L_0x006a:
        kotlin.jvm.internal.h.aXZ();
    L_0x006d:
        r0 = com.iqoption.core.feed.MediaDiskCache.MediaType.ORIGINAL;
        r0 = r1.contains(r0);
        if (r0 != 0) goto L_0x0082;
    L_0x0075:
        if (r1 != 0) goto L_0x007a;
    L_0x0077:
        kotlin.jvm.internal.h.aXZ();
    L_0x007a:
        r0 = com.iqoption.core.feed.MediaDiskCache.MediaType.THUMBNAIL;
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x0000;
    L_0x0082:
        if (r2 != 0) goto L_0x0087;
    L_0x0084:
        kotlin.jvm.internal.h.aXZ();
    L_0x0087:
        r0 = com.iqoption.core.feed.MediaDiskCache.MediaType.THUMBNAIL;
        r0 = r3.c(r2, r0);
        if (r0 == 0) goto L_0x0000;
    L_0x008f:
        if (r1 != 0) goto L_0x0094;
    L_0x0091:
        kotlin.jvm.internal.h.aXZ();
    L_0x0094:
        r0 = com.iqoption.core.feed.MediaDiskCache.MediaType.THUMBNAIL;
        r1.remove(r0);
        goto L_0x0000;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.feed.a.Te():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ab  */
    private final boolean c(com.iqoption.core.feed.j r13, com.iqoption.core.feed.MediaDiskCache.MediaType r14) {
        /*
        r12 = this;
        r0 = r12.a(r14);
        r1 = r0.get(r13);
        r1 = (com.iqoption.core.feed.a.g) r1;
        r2 = 1;
        if (r1 == 0) goto L_0x0013;
    L_0x000d:
        r3 = r1.To();
        if (r3 == 0) goto L_0x00a8;
    L_0x0013:
        r3 = 0;
        r3 = (java.io.FileInputStream) r3;
        r4 = com.iqoption.core.feed.MediaDiskCache.aQA;	 Catch:{ IOException -> 0x0094, RuntimeException -> 0x0084 }
        r5 = r13;
        r5 = (com.iqoption.core.feed.d) r5;	 Catch:{ IOException -> 0x0094, RuntimeException -> 0x0084 }
        r8 = r4.d(r5, r14);	 Catch:{ IOException -> 0x0094, RuntimeException -> 0x0084 }
        r4 = com.iqoption.core.feed.MediaDiskCache.aQA;	 Catch:{ IOException -> 0x0094, RuntimeException -> 0x0084 }
        r5 = r13;
        r5 = (com.iqoption.core.feed.d) r5;	 Catch:{ IOException -> 0x0094, RuntimeException -> 0x0084 }
        r4 = r4.b(r5, r14);	 Catch:{ IOException -> 0x0094, RuntimeException -> 0x0084 }
        if (r8 == 0) goto L_0x0040;
    L_0x002a:
        r3 = aPQ;	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        monitor-enter(r3);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r5 = aPP;	 Catch:{ all -> 0x0034 }
        r5.j(r8, r13);	 Catch:{ all -> 0x0034 }
        monitor-exit(r3);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        goto L_0x0040;
    L_0x0034:
        r14 = move-exception;
        monitor-exit(r3);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        throw r14;	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
    L_0x0037:
        r13 = move-exception;
        goto L_0x00ad;
    L_0x003a:
        r14 = move-exception;
        r3 = r4;
        goto L_0x0085;
    L_0x003d:
        r14 = move-exception;
        r3 = r4;
        goto L_0x0095;
    L_0x0040:
        if (r4 == 0) goto L_0x0061;
    L_0x0042:
        r3 = r12.a(r4, r14);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r5 = new com.iqoption.core.feed.a$g;	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        if (r8 != 0) goto L_0x004d;
    L_0x004a:
        kotlin.jvm.internal.h.aXZ();	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
    L_0x004d:
        r9 = 0;
        r10 = 4;
        r11 = 0;
        r6 = r5;
        r7 = r3;
        r6.<init>(r7, r8, r9, r10, r11);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r0.put(r13, r5);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r12.a(r13, r14, r3);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r4 = (java.io.Closeable) r4;
        com.iqoption.core.util.e.b(r4);
        return r2;
    L_0x0061:
        r14 = r13.Tu();	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        if (r14 != 0) goto L_0x006b;
    L_0x0067:
        r12.c(r13);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        goto L_0x007b;
    L_0x006b:
        if (r8 == 0) goto L_0x007b;
    L_0x006d:
        r14 = new com.iqoption.core.feed.a$g;	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r7 = aPG;	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r9 = 0;
        r10 = 4;
        r11 = 0;
        r6 = r14;
        r6.<init>(r7, r8, r9, r10, r11);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
        r0.put(r13, r14);	 Catch:{ IOException -> 0x003d, RuntimeException -> 0x003a, all -> 0x0037 }
    L_0x007b:
        r4 = (java.io.Closeable) r4;
        com.iqoption.core.util.e.b(r4);
        goto L_0x00a8;
    L_0x0081:
        r13 = move-exception;
        r4 = r3;
        goto L_0x00ad;
    L_0x0084:
        r14 = move-exception;
    L_0x0085:
        r12.c(r13);	 Catch:{ all -> 0x0081 }
        r13 = "CacheLoader";
        r0 = r14.getMessage();	 Catch:{ all -> 0x0081 }
        r14 = (java.lang.Throwable) r14;	 Catch:{ all -> 0x0081 }
        com.iqoption.core.i.e(r13, r0, r14);	 Catch:{ all -> 0x0081 }
        goto L_0x00a3;
    L_0x0094:
        r14 = move-exception;
    L_0x0095:
        r12.c(r13);	 Catch:{ all -> 0x0081 }
        r13 = "CacheLoader";
        r0 = r14.getMessage();	 Catch:{ all -> 0x0081 }
        r14 = (java.lang.Throwable) r14;	 Catch:{ all -> 0x0081 }
        com.iqoption.core.i.e(r13, r0, r14);	 Catch:{ all -> 0x0081 }
    L_0x00a3:
        r3 = (java.io.Closeable) r3;
        com.iqoption.core.util.e.b(r3);
    L_0x00a8:
        if (r1 == 0) goto L_0x00ab;
    L_0x00aa:
        goto L_0x00ac;
    L_0x00ab:
        r2 = 0;
    L_0x00ac:
        return r2;
    L_0x00ad:
        r4 = (java.io.Closeable) r4;
        com.iqoption.core.util.e.b(r4);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.feed.a.c(com.iqoption.core.feed.j, com.iqoption.core.feed.MediaDiskCache$MediaType):boolean");
    }

    private final void c(j jVar) {
        com.iqoption.core.d.a.aSe.post(new h(jVar));
    }

    private final void a(j jVar, MediaType mediaType, f fVar) {
        com.iqoption.core.d.a.aSe.post(new i(jVar, fVar, mediaType));
    }

    private final f a(FileInputStream fileInputStream, MediaType mediaType) {
        try {
            Bitmap a;
            if (mediaType == MediaType.ORIGINAL) {
                Resources resources = com.iqoption.core.f.RQ().getContext().getResources();
                kotlin.jvm.internal.h.d(resources, "core.context.resources");
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                Options Tf = Tf();
                Tf.inJustDecodeBounds = true;
                fileInputStream.getChannel().position(0);
                BitmapFactory.decodeStream(fileInputStream, null, Tf);
                Tf.inSampleSize = Math.min(Tf.outHeight / i2, Tf.outWidth / i);
                Tf.inJustDecodeBounds = false;
                Tf.inMutable = true;
                fileInputStream.getChannel().position(0);
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, Tf);
                kotlin.jvm.internal.h.d(decodeStream, "src");
                a = a(decodeStream, i, i2, 1, 1, decodeStream.getWidth(), decodeStream.getHeight());
            } else {
                a = BitmapFactory.decodeStream(fileInputStream);
            }
            if (a != null) {
                return new b(a);
            }
            throw new IOException("file is corrupted");
        } catch (OutOfMemoryError e) {
            throw new IOException(e);
        }
    }

    private final Bitmap a(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        float a = a(i, i2, i3, i4, i6, i5, 0, iArr, iArr2);
        Matrix matrix = new Matrix();
        matrix.postScale(a, a);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, iArr[0], iArr2[0], i5 - (iArr[0] * 2), i6 - (iArr2[0] * 2), matrix, false);
        kotlin.jvm.internal.h.d(createBitmap, "Bitmap.createBitmap(srcB… 2 * y[0], matrix, false)");
        return createBitmap;
    }

    private final float a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        int i8 = i7;
        if ((i5 * i > i2 * i6 ? 1 : null) != null) {
            if (i8 == 90 || i8 == 270) {
                return a(i, i3, i4, i5, i6, iArr2);
            }
            return a(i2, i4, i3, i5, i6, iArr2);
        } else if (i8 == 90 || i8 == 270) {
            return a(i2, i4, i3, i6, i5, iArr);
        } else {
            return a(i, i3, i4, i6, i5, iArr);
        }
    }

    private final float a(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        float f;
        float f2;
        float f3;
        if (i4 > i2) {
            f = (float) i;
            f2 = (float) i4;
            float f4 = f / f2;
            float f5 = (float) i5;
            f3 = (float) i3;
            if (f4 * f5 >= f3) {
                return f4;
            }
            f4 = f3 / f5;
            iArr[0] = (int) ((f2 - (f / f4)) / ((float) 2));
            return f4;
        }
        f2 = ((float) i3) / ((float) i5);
        f3 = ((float) i4) * f2;
        f = (float) i;
        if (f3 > f) {
            iArr[0] = (int) ((f3 - f) / (((float) 2) * f2));
        }
        return f2;
    }

    private final Options Tf() {
        Options options = new Options();
        options.inTempStorage = new byte[16384];
        return options;
    }

    private final LruCache<j, g<?>> a(MediaType mediaType) {
        switch (b.aoS[mediaType.ordinal()]) {
            case 1:
                return aPN;
            case 2:
                return aPM;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void d(j jVar) {
        synchronized (this) {
            EnumSet enumSet = (EnumSet) aPO.get(jVar);
        }
    }

    private final void Tg() {
        for (Reference poll = aPI.poll(); poll != null; poll = aPI.poll()) {
            e eVar = (e) poll;
            d dVar = (d) aPJ.get(eVar.Tm());
            if (dVar != null) {
                HashSet Tj = dVar.Tj();
                if (Tj != null) {
                    Collection collection = Tj;
                    if (collection == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                    n.cx(collection).remove(eVar);
                } else {
                    continue;
                }
            }
        }
    }

    private final void a(c<?> cVar, a aVar) {
        if (aVar != null) {
            j Th = aVar.Th();
            d dVar = (d) aPJ.get(Th);
            if (dVar != null && dVar.c(cVar)) {
                Map map = aPJ;
                if (map == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                }
                n.cB(map).remove(Th);
                synchronized (this) {
                    map = aPO;
                    if (map == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                    }
                    EnumSet enumSet = (EnumSet) n.cB(map).remove(Th);
                }
            }
        }
    }
}
