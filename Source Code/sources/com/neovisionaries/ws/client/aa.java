package com.neovisionaries.ws.client;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: SNIHelper */
class aa {
    private static Constructor<?> eax;
    private static Method eay;

    static {
        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initialize() {
        eax = p.b("javax.net.ssl.SNIHostName", new Class[]{String.class});
        eay = p.b("javax.net.ssl.SSLParameters", "setServerNames", new Class[]{List.class});
    }

    private static Object kO(String str) {
        return p.a(eax, str);
    }

    private static List<Object> e(String[] strArr) {
        List<Object> arrayList = new ArrayList(strArr.length);
        for (String kO : strArr) {
            arrayList.add(kO(kO));
        }
        return arrayList;
    }

    private static void a(SSLParameters sSLParameters, String[] strArr) {
        p.invoke(eay, sSLParameters, e(strArr));
    }

    static void a(Socket socket, String[] strArr) {
        if ((socket instanceof SSLSocket) && strArr != null) {
            SSLParameters sSLParameters = ((SSLSocket) socket).getSSLParameters();
            if (sSLParameters != null) {
                a(sSLParameters, strArr);
            }
        }
    }
}
