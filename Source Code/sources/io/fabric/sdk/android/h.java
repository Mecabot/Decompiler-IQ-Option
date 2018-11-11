package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.b;
import io.fabric.sdk.android.services.concurrency.i;
import java.io.File;
import java.util.Collection;

/* compiled from: Kit */
public abstract class h<Result> implements Comparable<h> {
    Context context;
    f<Result> emf;
    c emw;
    g<Result> emx = new g(this);
    final b emy = ((b) getClass().getAnnotation(b.class));
    IdManager tl;

    protected abstract Result doInBackground();

    public abstract String getIdentifier();

    public abstract String getVersion();

    protected boolean go() {
        return true;
    }

    protected void onCancelled(Result result) {
    }

    protected void onPostExecute(Result result) {
    }

    void a(Context context, c cVar, f<Result> fVar, IdManager idManager) {
        this.emw = cVar;
        this.context = new d(context, getIdentifier(), getPath());
        this.emf = fVar;
        this.tl = idManager;
    }

    final void initialize() {
        this.emx.a(this.emw.aUf(), (Void) null);
    }

    protected IdManager aUn() {
        return this.tl;
    }

    public Context getContext() {
        return this.context;
    }

    public c aUo() {
        return this.emw;
    }

    public String getPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".Fabric");
        stringBuilder.append(File.separator);
        stringBuilder.append(getIdentifier());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public int compareTo(h hVar) {
        if (b(hVar)) {
            return 1;
        }
        if (hVar.b(this)) {
            return -1;
        }
        if (aUp() && !hVar.aUp()) {
            return 1;
        }
        if (aUp() || !hVar.aUp()) {
            return 0;
        }
        return -1;
    }

    boolean b(h hVar) {
        if (aUp()) {
            for (Class isAssignableFrom : this.emy.value()) {
                if (isAssignableFrom.isAssignableFrom(hVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean aUp() {
        return this.emy != null;
    }

    protected Collection<i> aUq() {
        return this.emx.aUq();
    }
}
