package com.google.common.b;

import com.google.common.base.e;
import com.google.common.base.i;
import com.google.common.util.concurrent.MoreExecutors;
import com.iqoption.dto.entity.position.Position;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: EventBus */
public class d {
    private static final Logger logger = Logger.getLogger(d.class.getName());
    private final h TS;
    private final i TU;
    private final c TX;
    private final Executor executor;
    private final String identifier;

    /* compiled from: EventBus */
    static final class a implements h {
        static final a TY = new a();

        a() {
        }

        public void b(Throwable th, g gVar) {
            Logger a = a(gVar);
            if (a.isLoggable(Level.SEVERE)) {
                a.log(Level.SEVERE, b(gVar), th);
            }
        }

        private static Logger a(g gVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.class.getName());
            stringBuilder.append(".");
            stringBuilder.append(gVar.va().uY());
            return Logger.getLogger(stringBuilder.toString());
        }

        private static String b(g gVar) {
            Method vc = gVar.vc();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception thrown by subscriber method ");
            stringBuilder.append(vc.getName());
            stringBuilder.append('(');
            stringBuilder.append(vc.getParameterTypes()[0].getName());
            stringBuilder.append(')');
            stringBuilder.append(" on subscriber ");
            stringBuilder.append(gVar.vb());
            stringBuilder.append(" when dispatching event: ");
            stringBuilder.append(gVar.uV());
            return stringBuilder.toString();
        }
    }

    public d() {
        this(Position.CLOSE_REASON_DEFAULT);
    }

    public d(String str) {
        this(str, MoreExecutors.vV(), c.uW(), a.TY);
    }

    d(String str, Executor executor, c cVar, h hVar) {
        this.TU = new i(this);
        this.identifier = (String) i.checkNotNull(str);
        this.executor = (Executor) i.checkNotNull(executor);
        this.TX = (c) i.checkNotNull(cVar);
        this.TS = (h) i.checkNotNull(hVar);
    }

    public final String uY() {
        return this.identifier;
    }

    final Executor uZ() {
        return this.executor;
    }

    void a(Throwable th, g gVar) {
        i.checkNotNull(th);
        i.checkNotNull(gVar);
        try {
            this.TS.b(th, gVar);
        } catch (Throwable th2) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[]{th2, th}), th2);
        }
    }

    public void aD(Object obj) {
        this.TU.aD(obj);
    }

    public void unregister(Object obj) {
        this.TU.unregister(obj);
    }

    public void aE(Object obj) {
        Iterator aI = this.TU.aI(obj);
        if (aI.hasNext()) {
            this.TX.a(obj, aI);
        } else if (!(obj instanceof b)) {
            aE(new b(this, obj));
        }
    }

    public String toString() {
        return e.B(this).C(this.identifier).toString();
    }
}
