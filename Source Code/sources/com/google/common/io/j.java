package com.google.common.io;

import com.google.common.base.i;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: LineReader */
public final class j {
    private final Queue<String> UB = new LinkedList();
    private final h UC = new h() {
        protected void O(String str, String str2) {
            j.this.UB.add(str);
        }
    };
    private final Readable Uy;
    private final CharBuffer Uz = e.vk();
    private final char[] buf = this.Uz.array();
    private final Reader reader;

    public j(Readable readable) {
        this.Uy = (Readable) i.checkNotNull(readable);
        this.reader = readable instanceof Reader ? (Reader) readable : null;
    }

    public String readLine() {
        while (this.UB.peek() == null) {
            int read;
            this.Uz.clear();
            if (this.reader != null) {
                read = this.reader.read(this.buf, 0, this.buf.length);
            } else {
                read = this.Uy.read(this.Uz);
            }
            if (read == -1) {
                this.UC.finish();
                break;
            }
            this.UC.b(this.buf, 0, read);
        }
        return (String) this.UB.poll();
    }
}
