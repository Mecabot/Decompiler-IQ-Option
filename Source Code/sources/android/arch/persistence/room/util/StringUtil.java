package android.arch.persistence.room.util;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static StringBuilder az() {
        return new StringBuilder();
    }

    public static void a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("?");
            if (i2 < i - 1) {
                stringBuilder.append(",");
            }
        }
    }
}
