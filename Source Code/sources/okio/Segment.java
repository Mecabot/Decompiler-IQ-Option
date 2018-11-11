package okio;

final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }

    Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public Segment pop() {
        Segment segment = this.next != this ? this.next : null;
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public Segment split(int i) {
        if (i <= 0 || i > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        Segment sharedCopy;
        if (i >= 1024) {
            sharedCopy = sharedCopy();
        } else {
            sharedCopy = SegmentPool.take();
            System.arraycopy(this.data, this.pos, sharedCopy.data, 0, i);
        }
        sharedCopy.limit = sharedCopy.pos + i;
        this.pos += i;
        this.prev.push(sharedCopy);
        return sharedCopy;
    }

    public void compact() {
        if (this.prev == this) {
            throw new IllegalStateException();
        } else if (this.prev.owner) {
            int i = this.limit - this.pos;
            if (i <= (8192 - this.prev.limit) + (this.prev.shared ? 0 : this.prev.pos)) {
                writeTo(this.prev, i);
                pop();
                SegmentPool.recycle(this);
            }
        }
    }

    public void writeTo(Segment segment, int i) {
        if (segment.owner) {
            if (segment.limit + i > 8192) {
                if (segment.shared) {
                    throw new IllegalArgumentException();
                } else if ((segment.limit + i) - segment.pos > 8192) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(segment.data, segment.pos, segment.data, 0, segment.limit - segment.pos);
                    segment.limit -= segment.pos;
                    segment.pos = 0;
                }
            }
            System.arraycopy(this.data, this.pos, segment.data, segment.limit, i);
            segment.limit += i;
            this.pos += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
