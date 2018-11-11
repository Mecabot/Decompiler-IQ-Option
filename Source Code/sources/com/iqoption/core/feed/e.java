package com.iqoption.core.feed;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
final class e {
    private final Map<String, a> aQd = new HashMap();
    private final b aQe = new b();

    /* compiled from: DiskCacheWriteLocker */
    private static class a {
        final Lock aQf;
        int aQg;

        private a() {
            this.aQf = new ReentrantLock();
        }
    }

    /* compiled from: DiskCacheWriteLocker */
    private static class b {
        private final Queue<a> aQh;

        private b() {
            this.aQh = new ArrayDeque();
        }

        a Tq() {
            a aVar;
            synchronized (this.aQh) {
                aVar = (a) this.aQh.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        void a(a aVar) {
            synchronized (this.aQh) {
                if (this.aQh.size() < 10) {
                    this.aQh.offer(aVar);
                }
            }
        }
    }

    e() {
    }

    void gu(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) this.aQd.get(str);
            if (aVar == null) {
                aVar = this.aQe.Tq();
                this.aQd.put(str, aVar);
            }
            aVar.aQg++;
        }
        aVar.aQf.lock();
    }

    void release(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) this.aQd.get(str);
            if (aVar == null || aVar.aQg <= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot release a lock that is not held, key: ");
                stringBuilder.append(str);
                stringBuilder.append(", interestedThreads: ");
                stringBuilder.append(aVar == null ? 0 : aVar.aQg);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            int i = aVar.aQg - 1;
            aVar.aQg = i;
            if (i == 0) {
                a aVar2 = (a) this.aQd.remove(str);
                if (aVar2.equals(aVar)) {
                    this.aQe.a(aVar2);
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Removed the wrong lock, expected to remove: ");
                    stringBuilder2.append(aVar);
                    stringBuilder2.append(", but actually removed: ");
                    stringBuilder2.append(aVar2);
                    stringBuilder2.append(", key: ");
                    stringBuilder2.append(str);
                    throw new IllegalStateException(stringBuilder2.toString());
                }
            }
        }
        aVar.aQf.unlock();
    }
}
