package org.jmrtd.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class FragmentBuffer implements Serializable {
    private static final long serialVersionUID = -3510872461790499721L;
    private byte[] buffer;
    private Collection<Fragment> fragments;

    public static class Fragment implements Serializable {
        private static final long serialVersionUID = -3795931618553980328L;
        private int length;
        private int offset;

        private Fragment(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        public static Fragment bl(int i, int i2) {
            return new Fragment(i, i2);
        }

        public int getOffset() {
            return this.offset;
        }

        public int getLength() {
            return this.length;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(this.offset);
            stringBuilder.append(" .. ");
            stringBuilder.append((this.offset + this.length) - 1);
            stringBuilder.append(" (");
            stringBuilder.append(this.length);
            stringBuilder.append(")]");
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!obj.getClass().equals(Fragment.class)) {
                return false;
            }
            Fragment fragment = (Fragment) obj;
            if (fragment.offset == this.offset && fragment.length == this.length) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return ((this.offset * 2) + (this.length * 3)) + 5;
        }
    }

    public FragmentBuffer() {
        this(1024);
    }

    public FragmentBuffer(int i) {
        this.buffer = new byte[i];
        this.fragments = new HashSet();
    }

    public synchronized void a(int i, byte b) {
        b(i, new byte[]{b});
    }

    public synchronized void b(int i, byte[] bArr) {
        g(i, bArr, 0, bArr.length);
    }

    public synchronized void g(int i, byte[] bArr, int i2, int i3) {
        int i4 = i + i3;
        if (i4 > this.buffer.length) {
            setLength(Math.max(i4, this.buffer.length) * 2);
        }
        System.arraycopy(bArr, i2, this.buffer, i, i3);
        for (Fragment fragment : new ArrayList(this.fragments)) {
            if (fragment.getOffset() <= i && i + i3 <= fragment.getOffset() + fragment.getLength()) {
                return;
            }
            if (fragment.getOffset() <= i && i <= fragment.getOffset() + fragment.getLength()) {
                i = (i + i3) - fragment.getOffset();
                i3 = fragment.getOffset();
                this.fragments.remove(fragment);
                int i5 = i3;
                i3 = i;
                i = i5;
            } else if (i <= fragment.getOffset() && fragment.getOffset() + fragment.getLength() <= i + i3) {
                this.fragments.remove(fragment);
            } else if (i <= fragment.getOffset() && fragment.getOffset() <= i + i3) {
                i3 = (fragment.getOffset() + fragment.getLength()) - i;
                this.fragments.remove(fragment);
            }
        }
        this.fragments.add(Fragment.bl(i, i3));
    }

    public synchronized boolean mm(int i) {
        return bj(i, 1);
    }

    public synchronized boolean bj(int i, int i2) {
        for (Fragment fragment : this.fragments) {
            int offset = fragment.getOffset() + fragment.getLength();
            if (fragment.getOffset() <= i && i + i2 <= offset) {
                return true;
            }
        }
        return false;
    }

    public synchronized int mn(int i) {
        int i2 = 0;
        if (i >= this.buffer.length) {
            return 0;
        }
        for (Fragment fragment : this.fragments) {
            int offset = fragment.getOffset() + fragment.getLength();
            if (fragment.getOffset() <= i && i < offset) {
                offset -= i;
                if (offset > i2) {
                    i2 = offset;
                }
            }
        }
        return i2;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getLength() {
        int length;
        synchronized (this) {
            length = this.buffer.length;
        }
        return length;
    }

    public synchronized Fragment bk(int i, int i2) {
        int i3;
        i3 = i2;
        i2 = i;
        for (Fragment fragment : this.fragments) {
            if (fragment.getOffset() <= i2 && i2 + i3 <= fragment.getOffset() + fragment.getLength()) {
                i3 = 0;
                break;
            } else if (fragment.getOffset() <= i2 && i2 < fragment.getOffset() + fragment.getLength()) {
                int offset = fragment.getOffset() + fragment.getLength();
                i3 = (i2 + i3) - offset;
                i2 = offset;
            } else if (i2 > fragment.getOffset() || fragment.getOffset() + fragment.getLength() > i2 + i3) {
                if (i <= fragment.getOffset() && fragment.getOffset() < i2 + i3) {
                    i3 = fragment.getOffset() - i2;
                }
            }
        }
        return Fragment.bl(i2, i3);
    }

    public synchronized String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("FragmentBuffer [");
        stringBuilder.append(this.buffer.length);
        stringBuilder.append(", ");
        stringBuilder.append(this.fragments);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing block: B:49:0x0059, code:
            return r0;
     */
    public synchronized boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        if (r5 != 0) goto L_0x0006;
    L_0x0004:
        monitor-exit(r4);
        return r0;
    L_0x0006:
        r1 = 1;
        if (r5 != r4) goto L_0x000b;
    L_0x0009:
        monitor-exit(r4);
        return r1;
    L_0x000b:
        r2 = r5.getClass();	 Catch:{ all -> 0x005a }
        r3 = org.jmrtd.io.FragmentBuffer.class;
        r2 = r2.equals(r3);	 Catch:{ all -> 0x005a }
        if (r2 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r4);
        return r0;
    L_0x0019:
        r5 = (org.jmrtd.io.FragmentBuffer) r5;	 Catch:{ all -> 0x005a }
        r2 = r5.buffer;	 Catch:{ all -> 0x005a }
        if (r2 != 0) goto L_0x0025;
    L_0x001f:
        r2 = r4.buffer;	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x0025;
    L_0x0023:
        monitor-exit(r4);
        return r0;
    L_0x0025:
        r2 = r5.buffer;	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x002f;
    L_0x0029:
        r2 = r4.buffer;	 Catch:{ all -> 0x005a }
        if (r2 != 0) goto L_0x002f;
    L_0x002d:
        monitor-exit(r4);
        return r0;
    L_0x002f:
        r2 = r5.fragments;	 Catch:{ all -> 0x005a }
        if (r2 != 0) goto L_0x0039;
    L_0x0033:
        r2 = r4.fragments;	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x0039;
    L_0x0037:
        monitor-exit(r4);
        return r0;
    L_0x0039:
        r2 = r5.fragments;	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x0043;
    L_0x003d:
        r2 = r4.fragments;	 Catch:{ all -> 0x005a }
        if (r2 != 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r4);
        return r0;
    L_0x0043:
        r2 = r5.buffer;	 Catch:{ all -> 0x005a }
        r3 = r4.buffer;	 Catch:{ all -> 0x005a }
        r2 = java.util.Arrays.equals(r2, r3);	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r5.fragments;	 Catch:{ all -> 0x005a }
        r2 = r4.fragments;	 Catch:{ all -> 0x005a }
        r5 = r5.equals(r2);	 Catch:{ all -> 0x005a }
        if (r5 == 0) goto L_0x0058;
    L_0x0057:
        r0 = 1;
    L_0x0058:
        monitor-exit(r4);
        return r0;
    L_0x005a:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.io.FragmentBuffer.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.buffer) * 3) + (this.fragments.hashCode() * 2)) + 7;
    }

    private void setLength(int i) {
        synchronized (this) {
            if (i <= this.buffer.length) {
                return;
            }
            Object obj = new byte[i];
            System.arraycopy(this.buffer, 0, obj, 0, this.buffer.length);
            this.buffer = obj;
        }
    }
}
