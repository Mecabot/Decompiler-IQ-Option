package com.iqoption.util;

import android.util.Base64;
import com.iqoption.core.i;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: RsaUtils */
public class bb {
    private static final String TAG = "com.iqoption.util.bb";

    public static String aC(String str, String str2) {
        Throwable e;
        String str3 = "";
        try {
            Key generatePrivate = KeyFactory.getInstance("RSA", "BC").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2.getBytes(), 0)));
            Cipher instance = Cipher.getInstance("RSA", "BC");
            instance.init(2, generatePrivate);
            str2 = new String(instance.doFinal(Base64.decode(str, 0)));
            try {
                str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("decryptedString: ");
                stringBuilder.append(str2);
                i.v(str, stringBuilder.toString());
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str3;
            i.e(TAG, "decryptRSAToString error", e);
            return str2;
        }
        return str2;
    }
}
