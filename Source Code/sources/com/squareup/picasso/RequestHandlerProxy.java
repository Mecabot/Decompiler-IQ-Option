package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Downloader.Response;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0014J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, aXE = {"Lcom/squareup/picasso/RequestHandlerProxy;", "Lcom/squareup/picasso/RequestHandler;", "()V", "getRetryCount", "", "isResponseCached", "", "response", "Lcom/squareup/picasso/Downloader$Response;", "shouldRetry", "airplaneMode", "info", "Landroid/net/NetworkInfo;", "supportsReplay", "throwContentLengthException", "", "message", "", "core_release"})
/* compiled from: RequestHandlerProxy.kt */
public abstract class RequestHandlerProxy extends RequestHandler {
    protected int getRetryCount() {
        return super.getRetryCount();
    }

    protected boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return super.shouldRetry(z, networkInfo);
    }

    protected boolean supportsReplay() {
        return super.supportsReplay();
    }

    public final boolean isResponseCached(Response response) {
        h.e(response, "response");
        return response.cached;
    }

    public final void throwContentLengthException(String str) {
        h.e(str, "message");
        throw new ContentLengthException(str);
    }
}
