package com.google.common.io;

import com.google.common.base.i;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: AppendableWriter */
class a extends Writer {
    private final Appendable Ul;
    private boolean closed;

    a(Appendable appendable) {
        this.Ul = (Appendable) i.checkNotNull(appendable);
    }

    public void write(char[] cArr, int i, int i2) {
        checkNotClosed();
        this.Ul.append(new String(cArr, i, i2));
    }

    public void flush() {
        checkNotClosed();
        if (this.Ul instanceof Flushable) {
            ((Flushable) this.Ul).flush();
        }
    }

    public void close() {
        this.closed = true;
        if (this.Ul instanceof Closeable) {
            ((Closeable) this.Ul).close();
        }
    }

    public void write(int i) {
        checkNotClosed();
        this.Ul.append((char) i);
    }

    public void write(String str) {
        checkNotClosed();
        this.Ul.append(str);
    }

    public void write(String str, int i, int i2) {
        checkNotClosed();
        this.Ul.append(str, i, i2 + i);
    }

    public Writer append(char c) {
        checkNotClosed();
        this.Ul.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        checkNotClosed();
        this.Ul.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        checkNotClosed();
        this.Ul.append(charSequence, i, i2);
        return this;
    }

    private void checkNotClosed() {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }
}
