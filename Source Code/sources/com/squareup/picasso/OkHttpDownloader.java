package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Downloader.Response;
import com.squareup.picasso.Downloader.ResponseException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpDownloader implements Downloader {
    private final OkHttpClient client;
    private boolean sharedClient;

    private static OkHttpClient defaultOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public OkHttpDownloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public OkHttpDownloader(File file) {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    public OkHttpDownloader(Context context, long j) {
        this(Utils.createDefaultCacheDir(context), j);
    }

    public OkHttpDownloader(File file, long j) {
        this(defaultOkHttpClient());
        this.sharedClient = false;
        this.client.setCache(new Cache(file, j));
    }

    public OkHttpDownloader(OkHttpClient okHttpClient) {
        this.sharedClient = true;
        this.client = okHttpClient;
    }

    protected final OkHttpClient getClient() {
        return this.client;
    }

    public Response load(@NonNull Uri uri, int i) {
        CacheControl cacheControl;
        if (i == 0) {
            cacheControl = null;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            Builder builder = new Builder();
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
        com.squareup.okhttp.Response execute = this.client.newCall(url.build()).execute();
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
        if (!this.sharedClient) {
            Cache cache = this.client.getCache();
            if (cache != null) {
                try {
                    cache.close();
                } catch (IOException unused) {
                }
            }
        }
    }
}
