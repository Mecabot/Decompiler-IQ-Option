package org.yaml.snakeyaml.error;

import java.io.Serializable;
import org.yaml.snakeyaml.scanner.a;

public final class Mark implements Serializable {
    private int[] buffer;
    private int column;
    private int line;
    private String name;
    private int pointer;

    public Mark(String str, int i, int i2, int[] iArr, int i3) {
        this.name = str;
        this.line = i;
        this.column = i2;
        this.buffer = iArr;
        this.pointer = i3;
    }

    private boolean np(int i) {
        return a.fjS.nu(i);
    }

    public String bx(int i, int i2) {
        if (this.buffer == null) {
            return null;
        }
        int i3;
        float f = (float) ((i2 / 2) - 1);
        int i4 = this.pointer;
        String str = "";
        while (i4 > 0 && !np(this.buffer[i4 - 1])) {
            i4--;
            if (((float) (this.pointer - i4)) > f) {
                str = " ... ";
                i4 += 5;
                break;
            }
        }
        String str2 = "";
        int i5 = this.pointer;
        while (i5 < this.buffer.length && !np(this.buffer[i5])) {
            i5++;
            if (((float) (i5 - this.pointer)) > f) {
                str2 = " ... ";
                i5 -= 5;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (i3 = 0; i3 < i; i3++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(str);
        for (i3 = i4; i3 < i5; i3++) {
            stringBuilder.appendCodePoint(this.buffer[i3]);
        }
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        for (int i6 = 0; i6 < ((this.pointer + i) - i4) + str.length(); i6++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("^");
        return stringBuilder.toString();
    }

    public String bDW() {
        return bx(4, 75);
    }

    public String toString() {
        String bDW = bDW();
        StringBuilder stringBuilder = new StringBuilder(" in ");
        stringBuilder.append(this.name);
        stringBuilder.append(", line ");
        stringBuilder.append(this.line + 1);
        stringBuilder.append(", column ");
        stringBuilder.append(this.column + 1);
        stringBuilder.append(":\n");
        stringBuilder.append(bDW);
        return stringBuilder.toString();
    }

    public String getName() {
        return this.name;
    }

    public int bDX() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }
}
