package com.google.common.io;

import com.google.common.base.i;
import java.io.Reader;

/* compiled from: CharSource */
public abstract class d {
    public abstract Reader vi();

    protected d() {
    }

    public String read() {
        g vl = g.vl();
        try {
            String a = e.a((Reader) vl.a(vi()));
            vl.close();
            return a;
        } catch (Throwable th) {
            vl.close();
        }
    }

    public <T> T a(i<T> iVar) {
        i.checkNotNull(iVar);
        g vl = g.vl();
        try {
            T a = e.a((Reader) vl.a(vi()), (i) iVar);
            vl.close();
            return a;
        } catch (Throwable th) {
            vl.close();
        }
    }
}
