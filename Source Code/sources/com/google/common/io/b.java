package com.google.common.io;

import com.google.common.base.i;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: ByteSource */
public abstract class b {

    /* compiled from: ByteSource */
    class a extends d {
        final Charset charset;

        a(Charset charset) {
            this.charset = (Charset) i.checkNotNull(charset);
        }

        public Reader vi() {
            return new InputStreamReader(b.this.openStream(), this.charset);
        }

        public String read() {
            return new String(b.this.read(), this.charset);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.this.toString());
            stringBuilder.append(".asCharSource(");
            stringBuilder.append(this.charset);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public abstract InputStream openStream();

    protected b() {
    }

    public d a(Charset charset) {
        return new a(charset);
    }

    public long b(OutputStream outputStream) {
        i.checkNotNull(outputStream);
        g vl = g.vl();
        try {
            long copy = c.copy((InputStream) vl.a(openStream()), outputStream);
            vl.close();
            return copy;
        } catch (Throwable th) {
            vl.close();
        }
    }

    public byte[] read() {
        g vl = g.vl();
        try {
            byte[] toByteArray = c.toByteArray((InputStream) vl.a(openStream()));
            vl.close();
            return toByteArray;
        } catch (Throwable th) {
            vl.close();
        }
    }
}
