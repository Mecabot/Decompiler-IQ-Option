package org.yaml.snakeyaml.reader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

/* compiled from: UnicodeReader */
public class b extends Reader {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final Charset fjs = Charset.forName("UTF-16BE");
    private static final Charset fjt = Charset.forName("UTF-16LE");
    PushbackInputStream fju;
    InputStreamReader fjv = null;

    public b(InputStream inputStream) {
        this.fju = new PushbackInputStream(inputStream, 3);
    }

    protected void init() {
        if (this.fjv == null) {
            Charset charset;
            int i;
            byte[] bArr = new byte[3];
            int read = this.fju.read(bArr, 0, bArr.length);
            if (bArr[0] == (byte) -17 && bArr[1] == (byte) -69 && bArr[2] == (byte) -65) {
                charset = UTF8;
                i = read - 3;
            } else if (bArr[0] == (byte) -2 && bArr[1] == (byte) -1) {
                charset = fjs;
                i = read - 2;
            } else if (bArr[0] == (byte) -1 && bArr[1] == (byte) -2) {
                charset = fjt;
                i = read - 2;
            } else {
                charset = UTF8;
                i = read;
            }
            if (i > 0) {
                this.fju.unread(bArr, read - i, i);
            }
            this.fjv = new InputStreamReader(this.fju, charset.newDecoder().onUnmappableCharacter(CodingErrorAction.REPORT));
        }
    }

    public void close() {
        init();
        this.fjv.close();
    }

    public int read(char[] cArr, int i, int i2) {
        init();
        return this.fjv.read(cArr, i, i2);
    }
}
