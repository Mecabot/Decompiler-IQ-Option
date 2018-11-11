package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.squareup.picasso.Downloader.Response;
import com.squareup.picasso.Downloader.ResponseException;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.ResponseBody;

public final class OkHttp3Downloader implements Downloader {
    private final Cache cache;
    private final Factory client;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public OkHttp3Downloader(File file) {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    public OkHttp3Downloader(Context context, long j) {
        this(Utils.createDefaultCacheDir(context), j);
    }

    public OkHttp3Downloader(File file, long j) {
        this(new Builder().cache(new Cache(file, j)).build());
        this.sharedClient = false;
    }

    public OkHttp3Downloader(OkHttpClient okHttpClient) {
        this.sharedClient = true;
        this.client = okHttpClient;
        this.cache = okHttpClient.cache();
    }

    public OkHttp3Downloader(Factory factory) {
        this.sharedClient = true;
        this.client = factory;
        this.cache = null;
    }

    @VisibleForTesting
    Cache getCache() {
        return ((OkHttpClient) this.client).cache();
    }

    public Response load(@NonNull Uri uri, int i) {
        CacheControl cacheControl;
        if (i == 0) {
            cacheControl = null;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        okhttp3.Response execute = this.client.newCall(url.build()).execute();
        int code = execute.code();
        if (code >= 300) {
            execute.body().close();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(code);
            stringBuilder.append(" ");
            stringBuilder.append(execute.message());
            throw new ResponseException(stringBuilder.toString(), i, code);
        }
        boolean z = execute.cacheResponse() != null;
        ResponseBody body = execute.body();
        return new Response(body.byteStream(), z, body.contentLength());
    }

    public void shutdown() {
        if (!(this.sharedClient || this.cache == null)) {
            try {
                this.cache.close();
            } catch (IOException unused) {
            }
        }
    }
}
