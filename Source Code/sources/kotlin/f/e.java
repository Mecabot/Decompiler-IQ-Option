package kotlin.f;

import java.util.NoSuchElementException;
import kotlin.collections.z;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, aXE = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
/* compiled from: ProgressionIterators.kt */
public final class e extends z {
    private final int euG;
    private boolean euH;
    private int next;
    private final int step;

    public e(int i, int i2, int i3) {
        this.step = i3;
        this.euG = i2;
        boolean z = false;
        if (this.step <= 0 ? i < i2 : i > i2) {
            z = true;
        }
        this.euH = z;
        if (!this.euH) {
            i = this.euG;
        }
        this.next = i;
    }

    public boolean hasNext() {
        return this.euH;
    }

    public int nextInt() {
        int i = this.next;
        if (i != this.euG) {
            this.next += this.step;
        } else if (this.euH) {
            this.euH = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
