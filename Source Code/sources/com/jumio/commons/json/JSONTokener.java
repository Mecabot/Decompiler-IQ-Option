package com.jumio.commons.json;

import java.util.Locale;
import org.json.JSONException;

public class JSONTokener {
    private final StringBuilder in;
    private int pos;

    public static int dehexchar(char c) {
        return (c < '0' || c > '9') ? (c < 'A' || c > 'F') ? (c < 'a' || c > 'f') ? -1 : (c - 97) + 10 : (c - 65) + 10 : c - 48;
    }

    public JSONTokener(StringBuilder stringBuilder) {
        if (stringBuilder != null && stringBuilder.charAt(0) == 65279) {
            stringBuilder = stringBuilder.deleteCharAt(0);
        }
        this.in = stringBuilder;
    }

    public Object nextValue() {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            throw syntaxError("End of input");
        } else if (nextCleanInternal == 34 || nextCleanInternal == 39) {
            return nextString((char) nextCleanInternal);
        } else {
            if (nextCleanInternal == 91) {
                return readArray();
            }
            if (nextCleanInternal == 123) {
                return readObject();
            }
            this.pos--;
            return readLiteral();
        }
    }

    private int nextCleanInternal() {
        while (this.pos < this.in.length()) {
            StringBuilder stringBuilder = this.in;
            int i = this.pos;
            this.pos = i + 1;
            char charAt = stringBuilder.charAt(i);
            if (!(charAt == 13 || charAt == ' ')) {
                if (charAt == '#') {
                    skipToEndOfLine();
                } else if (charAt != '/') {
                    switch (charAt) {
                        case 9:
                        case 10:
                            break;
                        default:
                            return charAt;
                    }
                } else if (this.pos == this.in.length()) {
                    return charAt;
                } else {
                    char charAt2 = this.in.charAt(this.pos);
                    if (charAt2 == '*') {
                        this.pos++;
                        int indexOf = this.in.indexOf("*/", this.pos);
                        if (indexOf == -1) {
                            throw syntaxError("Unterminated comment");
                        }
                        this.pos = indexOf + 2;
                    } else if (charAt2 != '/') {
                        return charAt;
                    } else {
                        this.pos++;
                        skipToEndOfLine();
                    }
                }
            }
        }
        return -1;
    }

    private void skipToEndOfLine() {
        while (this.pos < this.in.length()) {
            char charAt = this.in.charAt(this.pos);
            if (charAt == 13 || charAt == 10) {
                this.pos++;
                return;
            }
            this.pos++;
        }
    }

    public StringBuilder nextString(char c) {
        int i = this.pos;
        StringBuilder stringBuilder = null;
        while (this.pos < this.in.length()) {
            StringBuilder stringBuilder2 = this.in;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char charAt = stringBuilder2.charAt(i2);
            if (charAt == c) {
                if (stringBuilder == null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(this.in, i, this.pos - 1);
                    return stringBuilder3;
                }
                stringBuilder.append(this.in, i, this.pos - 1);
                return stringBuilder;
            } else if (charAt == '\\') {
                if (this.pos == this.in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.in, i, this.pos - 1);
                stringBuilder.append(readEscapeCharacter());
                i = this.pos;
            }
        }
        throw syntaxError("Unterminated string");
    }

    private char readEscapeCharacter() {
        StringBuilder stringBuilder = this.in;
        int i = this.pos;
        this.pos = i + 1;
        char charAt = stringBuilder.charAt(i);
        if (charAt == 'b') {
            return 8;
        }
        if (charAt == 'f') {
            return 12;
        }
        if (charAt == 'n') {
            return 10;
        }
        if (charAt == 'r') {
            return 13;
        }
        switch (charAt) {
            case 't':
                return 9;
            case 'u':
                if (this.pos + 4 > this.in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                String substring = this.in.substring(this.pos, this.pos + 4);
                this.pos += 4;
                return (char) Integer.parseInt(substring, 16);
            default:
                return charAt;
        }
    }

    private boolean equalsIgnoreCase(StringBuilder stringBuilder, String str) {
        if (stringBuilder.length() != str.length()) {
            return false;
        }
        String toUpperCase = str.toUpperCase(Locale.GERMAN);
        String toLowerCase = str.toLowerCase(Locale.GERMAN);
        int i = 0;
        while (i < str.length()) {
            char charAt = stringBuilder.charAt(i);
            if (toUpperCase.charAt(i) != charAt && toLowerCase.charAt(i) != charAt) {
                return false;
            }
            i++;
        }
        return true;
    }

    private int indexOf(StringBuilder stringBuilder, char c) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    private boolean isNumber(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            char charAt = stringBuilder.charAt(i);
            if ((charAt < '0' || charAt > '9') && charAt != '.' && charAt != 'E' && charAt != '-') {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:41:0x009e, code:
            return java.lang.Double.valueOf(r0.toString());
     */
    private java.lang.Object readLiteral() {
        /*
        r6 = this;
        r0 = "{}[]/\\:,=;# \t\f";
        r0 = r6.nextToInternal(r0);
        r1 = r0.length();
        if (r1 != 0) goto L_0x0014;
    L_0x000d:
        r0 = "Expected literal value";
        r0 = r6.syntaxError(r0);
        throw r0;
    L_0x0014:
        r1 = "null";
        r1 = r6.equalsIgnoreCase(r0, r1);
        if (r1 == 0) goto L_0x001f;
    L_0x001c:
        r0 = com.jumio.commons.json.JumioJSONObject.NULL;
        return r0;
    L_0x001f:
        r1 = "true";
        r1 = r6.equalsIgnoreCase(r0, r1);
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r0 = java.lang.Boolean.TRUE;
        return r0;
    L_0x002b:
        r1 = "false";
        r1 = r6.equalsIgnoreCase(r0, r1);
        if (r1 == 0) goto L_0x0036;
    L_0x0033:
        r0 = java.lang.Boolean.FALSE;
        return r0;
    L_0x0036:
        r1 = r6.isNumber(r0);
        if (r1 == 0) goto L_0x009f;
    L_0x003c:
        r1 = 46;
        r1 = r6.indexOf(r0, r1);
        r2 = -1;
        if (r1 != r2) goto L_0x0096;
    L_0x0045:
        r1 = 10;
        r2 = r0.toString();
        r3 = "0x";
        r3 = r2.startsWith(r3);
        if (r3 != 0) goto L_0x0072;
    L_0x0053:
        r3 = "0X";
        r3 = r2.startsWith(r3);
        if (r3 == 0) goto L_0x005c;
    L_0x005b:
        goto L_0x0072;
    L_0x005c:
        r3 = "0";
        r3 = r2.startsWith(r3);
        if (r3 == 0) goto L_0x0079;
    L_0x0064:
        r3 = r2.length();
        r4 = 1;
        if (r3 <= r4) goto L_0x0079;
    L_0x006b:
        r2 = r2.substring(r4);
        r1 = 8;
        goto L_0x0079;
    L_0x0072:
        r1 = 2;
        r2 = r2.substring(r1);
        r1 = 16;
    L_0x0079:
        r1 = java.lang.Long.parseLong(r2, r1);	 Catch:{ NumberFormatException -> 0x0096 }
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 > 0) goto L_0x0091;
    L_0x0084:
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 < 0) goto L_0x0091;
    L_0x008b:
        r1 = (int) r1;	 Catch:{ NumberFormatException -> 0x0096 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x0096 }
        return r1;
    L_0x0091:
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ NumberFormatException -> 0x0096 }
        return r1;
    L_0x0096:
        r1 = r0.toString();	 Catch:{ NumberFormatException -> 0x009f }
        r1 = java.lang.Double.valueOf(r1);	 Catch:{ NumberFormatException -> 0x009f }
        return r1;
    L_0x009f:
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.json.JSONTokener.readLiteral():java.lang.Object");
    }

    private StringBuilder nextToInternal(String str) {
        StringBuilder stringBuilder;
        int i = this.pos;
        while (this.pos < this.in.length()) {
            char charAt = this.in.charAt(this.pos);
            if (charAt == 13 || charAt == 10 || str.indexOf(charAt) != -1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.in, i, this.pos);
                return stringBuilder;
            }
            this.pos++;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.in, i, this.in.length());
        return stringBuilder;
    }

    private JumioJSONObject readObject() {
        JumioJSONObject jumioJSONObject = new JumioJSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == 125) {
            return jumioJSONObject;
        }
        if (nextCleanInternal != -1) {
            this.pos--;
        }
        while (true) {
            Object nextValue = nextValue();
            StringBuilder stringBuilder;
            if (nextValue instanceof StringBuilder) {
                int nextCleanInternal2 = nextCleanInternal();
                if (nextCleanInternal2 == 58 || nextCleanInternal2 == 61) {
                    if (this.pos < this.in.length() && this.in.charAt(this.pos) == '>') {
                        this.pos++;
                    }
                    jumioJSONObject.put(((StringBuilder) nextValue).toString(), nextValue());
                    nextCleanInternal = nextCleanInternal();
                    if (nextCleanInternal != 44 && nextCleanInternal != 59) {
                        if (nextCleanInternal == 125) {
                            return jumioJSONObject;
                        }
                        throw syntaxError("Unterminated object");
                    }
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected ':' after ");
                    stringBuilder.append(nextValue);
                    throw syntaxError(stringBuilder.toString());
                }
            } else if (nextValue == null) {
                throw syntaxError("Names cannot be null");
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Names must be strings, but ");
                stringBuilder.append(nextValue);
                stringBuilder.append(" is of type ");
                stringBuilder.append(nextValue.getClass().getName());
                throw syntaxError(stringBuilder.toString());
            }
        }
    }

    private JumioJSONArray readArray() {
        JumioJSONArray jumioJSONArray = new JumioJSONArray();
        Object obj = null;
        while (true) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal != -1) {
                if (nextCleanInternal == 44 || nextCleanInternal == 59) {
                    jumioJSONArray.put(null);
                } else if (nextCleanInternal != 93) {
                    this.pos--;
                    jumioJSONArray.put(nextValue());
                    int nextCleanInternal2 = nextCleanInternal();
                    if (!(nextCleanInternal2 == 44 || nextCleanInternal2 == 59)) {
                        if (nextCleanInternal2 == 93) {
                            return jumioJSONArray;
                        }
                        throw syntaxError("Unterminated array");
                    }
                } else {
                    if (obj != null) {
                        jumioJSONArray.put(null);
                    }
                    return jumioJSONArray;
                }
                obj = 1;
            } else {
                throw syntaxError("Unterminated array");
            }
        }
    }

    public JSONException syntaxError(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this);
        return new JSONException(stringBuilder.toString());
    }

    public boolean more() {
        return this.pos < this.in.length();
    }

    public char next() {
        if (this.pos >= this.in.length()) {
            return 0;
        }
        StringBuilder stringBuilder = this.in;
        int i = this.pos;
        this.pos = i + 1;
        return stringBuilder.charAt(i);
    }

    public char next(char c) {
        char next = next();
        if (next == c) {
            return next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ");
        stringBuilder.append(c);
        stringBuilder.append(" but was ");
        stringBuilder.append(next);
        throw syntaxError(stringBuilder.toString());
    }

    public char nextClean() {
        int nextCleanInternal = nextCleanInternal();
        return nextCleanInternal == -1 ? 0 : (char) nextCleanInternal;
    }

    public StringBuilder next(int i) {
        StringBuilder stringBuilder;
        if (this.pos + i > this.in.length()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" is out of bounds");
            throw syntaxError(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.in, this.pos, this.pos + i);
        this.pos += i;
        return stringBuilder;
    }

    public StringBuilder nextTo(String str) {
        if (str != null) {
            return nextToInternal(str);
        }
        throw new NullPointerException();
    }

    public StringBuilder nextTo(char c) {
        return nextToInternal(String.valueOf(c));
    }

    public void skipPast(String str) {
        int indexOf = this.in.indexOf(str, this.pos);
        this.pos = indexOf == -1 ? this.in.length() : str.length() + indexOf;
    }

    public char skipTo(char c) {
        int indexOf = this.in.indexOf(String.valueOf(c), this.pos);
        if (indexOf == -1) {
            return 0;
        }
        this.pos = indexOf;
        return c;
    }

    public void back() {
        int i = this.pos - 1;
        this.pos = i;
        if (i == -1) {
            this.pos = 0;
        }
    }

    public void clear() {
        if (this.in != null) {
            for (int i = 0; i < this.in.length(); i++) {
                this.in.setCharAt(i, 0);
            }
        }
    }
}
