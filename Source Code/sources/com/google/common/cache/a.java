package com.google.common.cache;

/* compiled from: AbstractCache */
public abstract class a<K, V> implements b<K, V> {

    /* compiled from: AbstractCache */
    public interface b {
        void ay(int i);

        void az(int i);

        void qf();

        void y(long j);

        void z(long j);
    }

    /* compiled from: AbstractCache */
    public static final class a implements b {
        private final f NB = LongAddables.rr();
        private final f ND = LongAddables.rr();
        private final f NH = LongAddables.rr();
        private final f NJ = LongAddables.rr();
        private final f NK = LongAddables.rr();
        private final f NM = LongAddables.rr();

        public void ay(int i) {
            this.NB.add((long) i);
        }

        public void az(int i) {
            this.ND.add((long) i);
        }

        public void y(long j) {
            this.NH.increment();
            this.NK.add(j);
        }

        public void z(long j) {
            this.NJ.increment();
            this.NK.add(j);
        }

        public void qf() {
            this.NM.increment();
        }
    }
}
