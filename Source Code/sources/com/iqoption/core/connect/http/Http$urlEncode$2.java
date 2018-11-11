package com.iqoption.core.connect.http;

import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010&\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "", "invoke"})
/* compiled from: Http.kt */
final class Http$urlEncode$2 extends Lambda implements b<Entry<? extends String, ? extends Object>, String> {
    public static final Http$urlEncode$2 aNV = new Http$urlEncode$2();

    Http$urlEncode$2() {
        super(1);
    }

    /* renamed from: h */
    public final String invoke(Entry<String, ? extends Object> entry) {
        h.e(entry, "it");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String) entry.getKey());
        stringBuilder.append('=');
        stringBuilder.append(entry.getValue());
        return stringBuilder.toString();
    }
}
