package com.google.common.d;

import com.google.common.a.a;

/* compiled from: UrlEscapers */
public final class b {
    private static final a Vb = new a("-_.*", true);
    private static final a Vc = new a("-._~!$'()*,;&=@:+", false);
    private static final a Vd = new a("-._~!$'()*,;&=@:+/?", false);

    public static a vo() {
        return Vc;
    }
}
