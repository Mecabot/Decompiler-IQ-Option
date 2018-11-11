package org.yaml.snakeyaml.d;

import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.yaml.snakeyaml.a.b.a.a.a.a.a.a;
import org.yaml.snakeyaml.a.b.a.a.a.a.a.b;
import org.yaml.snakeyaml.error.YAMLException;

/* compiled from: UriEncoder */
public abstract class c {
    private static final CharsetDecoder fku = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT);
    private static final a fkv = new b("-_.!~*'()@:$&,;=[]/", false);

    public static String encode(String str) {
        return fkv.escape(str);
    }

    public static String a(ByteBuffer byteBuffer) {
        return fku.decode(byteBuffer).toString();
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable e) {
            throw new YAMLException(e);
        }
    }
}
