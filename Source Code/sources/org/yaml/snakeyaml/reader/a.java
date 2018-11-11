package org.yaml.snakeyaml.reader;

import android.support.v4.view.InputDeviceCompat;
import java.io.Reader;
import java.util.Arrays;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;

/* compiled from: StreamReader */
public class a {
    private char[] buffer;
    private int column = 0;
    private boolean eof;
    private final Reader fjp;
    private int[] fjq = new int[0];
    private int fjr = 0;
    private int index = 0;
    private int line = 0;
    private String name = "'reader'";
    private int pointer = 0;

    public static boolean isPrintable(int i) {
        return (i >= 32 && i <= 126) || i == 9 || i == 10 || i == 13 || i == 133 || ((i >= 160 && i <= 55295) || ((i >= 57344 && i <= 65533) || (i >= 65536 && i <= 1114111)));
    }

    public a(Reader reader) {
        this.fjp = reader;
        this.eof = false;
        this.buffer = new char[InputDeviceCompat.SOURCE_GAMEPAD];
    }

    public Mark bEy() {
        return new Mark(this.name, this.line, this.column, this.fjq, this.pointer);
    }

    public void bEz() {
        nq(1);
    }

    public void nq(int i) {
        for (int i2 = 0; i2 < i && bEA(); i2++) {
            int[] iArr = this.fjq;
            int i3 = this.pointer;
            this.pointer = i3 + 1;
            int i4 = iArr[i3];
            this.index++;
            if (org.yaml.snakeyaml.scanner.a.fjQ.nu(i4) || (i4 == 13 && bEA() && this.fjq[this.pointer] != 10)) {
                this.line++;
                this.column = 0;
            } else if (i4 != 65279) {
                this.column++;
            }
        }
    }

    public int peek() {
        return bEA() ? this.fjq[this.pointer] : 0;
    }

    public int peek(int i) {
        return nt(i) ? this.fjq[this.pointer + i] : 0;
    }

    public String nr(int i) {
        if (i == 0) {
            return "";
        }
        if (nt(i)) {
            return new String(this.fjq, this.pointer, i);
        }
        return new String(this.fjq, this.pointer, Math.min(i, this.fjr - this.pointer));
    }

    public String ns(int i) {
        String nr = nr(i);
        this.pointer += i;
        this.index += i;
        this.column += i;
        return nr;
    }

    private boolean bEA() {
        return nt(0);
    }

    private boolean nt(int i) {
        if (!this.eof && this.pointer + i >= this.fjr) {
            update();
        }
        return this.pointer + i < this.fjr;
    }

    private void update() {
        try {
            int read = this.fjp.read(this.buffer, 0, 1024);
            if (read > 0) {
                int i = this.fjr - this.pointer;
                this.fjq = Arrays.copyOfRange(this.fjq, this.pointer, this.fjr + read);
                if (Character.isHighSurrogate(this.buffer[read - 1])) {
                    if (this.fjp.read(this.buffer, read, 1) == -1) {
                        this.eof = true;
                    } else {
                        read++;
                    }
                }
                int i2 = i;
                i = 0;
                int i3 = 32;
                while (i < read) {
                    int codePointAt = Character.codePointAt(this.buffer, i);
                    this.fjq[i2] = codePointAt;
                    if (isPrintable(codePointAt)) {
                        i += Character.charCount(codePointAt);
                    } else {
                        i = read;
                        i3 = codePointAt;
                    }
                    i2++;
                }
                this.fjr = i2;
                this.pointer = 0;
                if (i3 != 32) {
                    throw new ReaderException(this.name, i2 - 1, i3, "special characters are not allowed");
                }
                return;
            }
            this.eof = true;
        } catch (Throwable e) {
            throw new YAMLException(e);
        }
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }

    public int bDX() {
        return this.line;
    }
}
