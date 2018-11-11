package com.iqoption.core.util;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.Uri;
import com.iqoption.core.g.b;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Downloader.Response;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Request;
import com.squareup.picasso.RequestHandler.Result;
import com.squareup.picasso.RequestHandlerProxy;
import java.io.InputStream;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/core/util/WalletImageRequestHandler;", "Lcom/squareup/picasso/RequestHandlerProxy;", "downloader", "Lcom/squareup/picasso/Downloader;", "(Lcom/squareup/picasso/Downloader;)V", "canHandleRequest", "", "data", "Lcom/squareup/picasso/Request;", "getRetryCount", "", "load", "Lcom/squareup/picasso/RequestHandler$Result;", "request", "networkPolicy", "loadResUri", "Landroid/net/Uri;", "imageResId", "", "shouldRetry", "airplaneMode", "info", "Landroid/net/NetworkInfo;", "supportsReplay", "core_release"})
/* compiled from: ImageUtil.kt */
public final class t extends RequestHandlerProxy {
    private final Downloader downloader;

    protected int getRetryCount() {
        return 4;
    }

    protected boolean supportsReplay() {
        return true;
    }

    public t(Downloader downloader) {
        h.e(downloader, "downloader");
        this.downloader = downloader;
    }

    public boolean canHandleRequest(Request request) {
        h.e(request, "data");
        Uri uri = request.uri;
        return h.E("iqoption", uri != null ? uri.getScheme() : null);
    }

    public Result load(Request request, int i) {
        h.e(request, "request");
        Uri uri = request.uri;
        h.d(uri, "request.uri");
        String authority = uri.getAuthority();
        h.d(authority, "request.uri.authority");
        uri = hb(authority);
        if (uri == null) {
            return null;
        }
        Response load = this.downloader.load(uri, i);
        if (load == null) {
            return null;
        }
        h.d(load, "response");
        LoadedFrom loadedFrom = isResponseCached(load) ? LoadedFrom.DISK : LoadedFrom.NETWORK;
        Bitmap bitmap = load.getBitmap();
        if (bitmap != null) {
            return new Result(bitmap, loadedFrom);
        }
        InputStream inputStream = load.getInputStream();
        if (inputStream == null) {
            return null;
        }
        if (loadedFrom == LoadedFrom.DISK && load.getContentLength() == 0) {
            try {
                inputStream.close();
            } catch (Throwable unused) {
                throwContentLengthException("Received response with 0 content-length header.");
            }
        }
        return new Result(inputStream, loadedFrom);
    }

    protected boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    private final Uri hb(String str) {
        str = b.bab.gR(str);
        return str != null ? Uri.parse(str) : null;
    }
}
