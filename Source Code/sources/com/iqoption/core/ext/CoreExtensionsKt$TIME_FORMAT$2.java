package com.iqoption.core.ext;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"})
/* compiled from: CoreExtensions.kt */
final class CoreExtensionsKt$TIME_FORMAT$2 extends Lambda implements a<SimpleDateFormat> {
    public static final CoreExtensionsKt$TIME_FORMAT$2 aPm = new CoreExtensionsKt$TIME_FORMAT$2();

    CoreExtensionsKt$TIME_FORMAT$2() {
        super(0);
    }

    /* renamed from: SV */
    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault());
    }
}
