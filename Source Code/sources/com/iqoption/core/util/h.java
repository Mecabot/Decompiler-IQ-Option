package com.iqoption.core.util;

import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"IQOPTION_IMAGE_SCHEME", "", "RETRY_COUNT", "", "loadResourceImage", "Lcom/squareup/picasso/RequestCreator;", "Lcom/squareup/picasso/Picasso;", "imageResId", "core_release"})
/* compiled from: ImageUtil.kt */
public final class h {
    public static final RequestCreator a(Picasso picasso, String str) {
        kotlin.jvm.internal.h.e(picasso, "$receiver");
        RequestCreator load;
        if (str == null) {
            load = picasso.load(Uri.EMPTY);
            kotlin.jvm.internal.h.d(load, "load(Uri.EMPTY)");
            return load;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("iqoption://");
        stringBuilder.append(str);
        load = picasso.load(Uri.parse(stringBuilder.toString()));
        kotlin.jvm.internal.h.d(load, "load(Uri.parse(IQOPTION_…ME + \"://\" + imageResId))");
        return load;
    }
}
