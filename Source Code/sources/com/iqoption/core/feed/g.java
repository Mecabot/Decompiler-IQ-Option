package com.iqoption.core.feed;

import android.text.TextUtils;
import com.iqoption.core.connect.http.b;
import com.iqoption.core.feed.MediaDiskCache.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

@i(aXC = {1, 1, 11}, aXD = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/feed/ImageDownloader;", "", "()V", "byteBuffers", "com/iqoption/core/feed/ImageDownloader$byteBuffers$1", "Lcom/iqoption/core/feed/ImageDownloader$byteBuffers$1;", "copyStream", "", "input", "Ljava/io/InputStream;", "out", "Ljava/io/OutputStream;", "loadImage", "previewable", "Lcom/iqoption/core/feed/Previewable;", "mediaType", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "loadOriginal", "loadThumbnail", "readImageContent", "byteStream", "core_release"})
/* compiled from: ImageDownloader.kt */
public final class g {
    private final a aQx = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, aXE = {"com/iqoption/core/feed/ImageDownloader$byteBuffers$1", "Ljava/lang/ThreadLocal;", "", "initialValue", "core_release"})
    /* compiled from: ImageDownloader.kt */
    public static final class a extends ThreadLocal<byte[]> {
        a() {
        }

        /* renamed from: Tz */
        protected byte[] initialValue() {
            return new byte[8092];
        }
    }

    public final void j(j jVar) {
        h.e(jVar, "previewable");
        if (jVar.Tu() && !MediaDiskCache.aQA.a(jVar, MediaType.THUMBNAIL)) {
            d(jVar, MediaType.THUMBNAIL);
        }
    }

    public final void i(j jVar) {
        h.e(jVar, "previewable");
        if (jVar.Tu() && !MediaDiskCache.aQA.a(jVar, MediaType.ORIGINAL)) {
            d(jVar, MediaType.ORIGINAL);
        }
    }

    private final void d(j jVar, MediaType mediaType) {
        String Tw;
        switch (h.aoS[mediaType.ordinal()]) {
            case 1:
                Tw = jVar.Tw();
                break;
            case 2:
                Tw = jVar.Tv();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (TextUtils.isEmpty(Tw)) {
            throw new IOException("empty url");
        }
        OkHttpClient Sp = b.Sp();
        Builder builder = new Builder();
        if (Tw == null) {
            h.aXZ();
        }
        Response execute = Sp.newCall(builder.url(Tw).build()).execute();
        try {
            StringBuilder stringBuilder;
            if (execute.body() == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Empty body for ");
                stringBuilder.append(Tw);
                throw new IOException(stringBuilder.toString());
            }
            int code = execute.code();
            if (200 <= code && 300 >= code) {
                ResponseBody body = execute.body();
                if (body == null) {
                    h.aXZ();
                }
                InputStream byteStream = body.byteStream();
                h.d(byteStream, "response.body()!!.byteStream()");
                a(jVar, byteStream, mediaType);
                return;
            }
            jVar.Tt();
            stringBuilder = new StringBuilder();
            stringBuilder.append("Bad response code for url ");
            stringBuilder.append(Tw);
            throw new IOException(stringBuilder.toString());
        } finally {
            ResponseBody body2 = execute.body();
            if (body2 != null) {
                body2.close();
            }
        }
    }

    private final void a(j jVar, InputStream inputStream, MediaType mediaType) {
        MediaDiskCache.aQA.a(jVar, mediaType, new ImageDownloader$readImageContent$1(this, inputStream, jVar));
    }

    private final void copyStream(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = (byte[]) this.aQx.get();
        int read = inputStream.read(bArr);
        while (read != -1) {
            outputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        outputStream.flush();
    }
}
