package com.iqoption.core.feed;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "os", "Ljava/io/OutputStream;", "invoke"})
/* compiled from: ImageDownloader.kt */
final class ImageDownloader$readImageContent$1 extends Lambda implements b<OutputStream, Boolean> {
    final /* synthetic */ InputStream $byteStream;
    final /* synthetic */ j $previewable;
    final /* synthetic */ g this$0;

    ImageDownloader$readImageContent$1(g gVar, InputStream inputStream, j jVar) {
        this.this$0 = gVar;
        this.$byteStream = inputStream;
        this.$previewable = jVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(c((OutputStream) obj));
    }

    public final boolean c(OutputStream outputStream) {
        h.e(outputStream, "os");
        try {
            this.this$0.copyStream(this.$byteStream, outputStream);
            return true;
        } catch (IOException unused) {
            this.$previewable.Tt();
            return false;
        }
    }
}
