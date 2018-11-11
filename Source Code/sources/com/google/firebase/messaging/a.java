package com.google.firebase.messaging;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

public class a {
    private static final Pattern Zb = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static a Zc;
    private final FirebaseInstanceId Zd;

    private a(FirebaseInstanceId firebaseInstanceId) {
        this.Zd = firebaseInstanceId;
    }

    public static synchronized a wR() {
        a aVar;
        synchronized (a.class) {
            if (Zc == null) {
                Zc = new a(FirebaseInstanceId.wj());
            }
            aVar = Zc;
        }
        return aVar;
    }

    public void cZ(String str) {
        Object str2;
        if (str2 != null && str2.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            str2 = str2.substring(8);
        }
        if (str2 == null || !Zb.matcher(str2).matches()) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 78);
            stringBuilder.append("Invalid topic name: ");
            stringBuilder.append(str2);
            stringBuilder.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        FirebaseInstanceId firebaseInstanceId = this.Zd;
        String valueOf = String.valueOf("S!");
        str2 = String.valueOf(str2);
        firebaseInstanceId.cO(str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf));
    }
}
