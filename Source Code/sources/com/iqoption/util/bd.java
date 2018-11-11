package com.iqoption.util;

import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0004J\b\u0010\u0010\u001a\u00020\u0004H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, aXE = {"Lcom/iqoption/util/SparseUiExecutor;", "", "task", "Lkotlin/Function0;", "", "delay", "", "(Lkotlin/jvm/functions/Function0;I)V", "getDelay", "()I", "lastUpdateTime", "", "messageId", "getTask", "()Lkotlin/jvm/functions/Function0;", "execute", "executeInternal", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SparseUiExecutor.kt */
public final class bd {
    public static final a dwA = new a();
    private static final AtomicInteger dwz = new AtomicInteger(512);
    private final int delay;
    private final int dwx = dwz.incrementAndGet();
    private final kotlin.jvm.a.a<l> dwy;
    private long lastUpdateTime;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/util/SparseUiExecutor$Companion;", "", "()V", "messageIdGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SparseUiExecutor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: SparseUiExecutor.kt */
    static final class b implements Runnable {
        final /* synthetic */ bd dwB;

        b(bd bdVar) {
            this.dwB = bdVar;
        }

        public final void run() {
            this.dwB.aGx();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: SparseUiExecutor.kt */
    static final class c implements Runnable {
        final /* synthetic */ bd dwB;

        c(bd bdVar) {
            this.dwB = bdVar;
        }

        public final void run() {
            this.dwB.aGy().invoke();
        }
    }

    public bd(kotlin.jvm.a.a<l> aVar, int i) {
        h.e(aVar, "task");
        this.dwy = aVar;
        this.delay = i;
    }

    public final kotlin.jvm.a.a<l> aGy() {
        return this.dwy;
    }

    public final void execute() {
        if (be.aGz()) {
            aGx();
        } else {
            com.iqoption.core.d.a.aSe.execute(new b(this));
        }
    }

    private final void aGx() {
        if (SystemClock.uptimeMillis() - this.lastUpdateTime < ((long) this.delay)) {
            if (!com.iqoption.core.d.a.aSe.hasMessages(this.dwx)) {
                Message obtain = Message.obtain(com.iqoption.core.d.a.aSe, new c(this));
                obtain.what = this.dwx;
                com.iqoption.core.d.a.aSe.sendMessageDelayed(obtain, Math.max(0, ((long) this.delay) - (SystemClock.uptimeMillis() - this.lastUpdateTime)));
            }
            return;
        }
        this.dwy.invoke();
    }
}
