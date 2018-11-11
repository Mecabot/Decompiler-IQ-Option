package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

/* compiled from: GifRenderingExecutor */
final class c extends ScheduledThreadPoolExecutor {

    /* compiled from: GifRenderingExecutor */
    private static final class a {
        private static final c fkN = new c();
    }

    static c bFK() {
        return a.fkN;
    }

    private c() {
        super(1, new DiscardPolicy());
    }
}
