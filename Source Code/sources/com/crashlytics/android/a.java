package com.crashlytics.android;

import com.crashlytics.android.answers.b;
import com.crashlytics.android.core.k;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* compiled from: Crashlytics */
public class a extends h<Void> implements i {
    public final b rJ;
    public final com.crashlytics.android.a.a rK;
    public final k rL;
    public final Collection<? extends h> rM;

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public String getVersion() {
        return "2.9.4.26";
    }

    /* renamed from: gk */
    protected Void doInBackground() {
        return null;
    }

    public a() {
        this(new b(), new com.crashlytics.android.a.a(), new k());
    }

    a(b bVar, com.crashlytics.android.a.a aVar, k kVar) {
        this.rJ = bVar;
        this.rK = aVar;
        this.rL = kVar;
        this.rM = Collections.unmodifiableCollection(Arrays.asList(new h[]{bVar, aVar, kVar}));
    }

    public Collection<? extends h> gj() {
        return this.rM;
    }

    public static a gl() {
        return (a) c.D(a.class);
    }

    public static void c(Throwable th) {
        gm();
        gl().rL.c(th);
    }

    public static void log(String str) {
        gm();
        gl().rL.log(str);
    }

    public static void aI(String str) {
        gm();
        gl().rL.aI(str);
    }

    private static void gm() {
        if (gl() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
