package com.iqoption.core.util;

import android.content.Context;
import com.iqoption.core.connect.http.b;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import java.io.File;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cache;
import okhttp3.OkHttpClient.Builder;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, aXE = {"Lcom/iqoption/core/util/ImageUtil;", "", "()V", "Companion", "core_release"})
/* compiled from: ImageUtil.kt */
public final class g {
    public static final a bgQ = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/core/util/ImageUtil$Companion;", "", "()V", "ICON_IMAGE_CACHE_SIZE", "", "configureMain", "", "context", "Landroid/content/Context;", "configurePicasso", "core_release"})
    /* compiled from: ImageUtil.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void bg(Context context) {
            h.e(context, "context");
            bh(context);
        }

        private final void bh(Context context) {
            Builder newBuilder = b.Sp().newBuilder();
            newBuilder.cache(new Cache(new File(context.getCacheDir(), "icon_cache"), 4194304));
            Downloader okHttp3Downloader = new OkHttp3Downloader(newBuilder.build());
            Picasso.setSingletonInstance(new Picasso.Builder(context).addRequestHandler(new t(okHttp3Downloader)).downloader(okHttp3Downloader).build());
        }
    }

    public static final void bg(Context context) {
        bgQ.bg(context);
    }
}
