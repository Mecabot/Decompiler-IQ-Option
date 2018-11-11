package kotlin.reflect.jvm.internal.impl.protobuf;

import java.nio.ByteBuffer;

/* compiled from: Internal */
public class h {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final ByteBuffer eOi = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);

    /* compiled from: Internal */
    public interface a {
        int getNumber();
    }

    /* compiled from: Internal */
    public interface b<T extends a> {
        T jC(int i);
    }

    public static boolean ah(byte[] bArr) {
        return u.ah(bArr);
    }

    public static String ai(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }
}
