package com.google.common.io;

import com.google.common.base.e;
import com.google.common.base.i;
import com.google.common.collect.Lists;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public final class Resources {

    private static final class a extends b {
        private final URL url;

        /* synthetic */ a(URL url, AnonymousClass1 anonymousClass1) {
            this(url);
        }

        private a(URL url) {
            this.url = (URL) i.checkNotNull(url);
        }

        public InputStream openStream() {
            return this.url.openStream();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resources.asByteSource(");
            stringBuilder.append(this.url);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private Resources() {
    }

    public static b asByteSource(URL url) {
        return new a(url, null);
    }

    public static d asCharSource(URL url, Charset charset) {
        return asByteSource(url).a(charset);
    }

    public static byte[] toByteArray(URL url) {
        return asByteSource(url).read();
    }

    public static String toString(URL url, Charset charset) {
        return asCharSource(url, charset).read();
    }

    public static <T> T readLines(URL url, Charset charset, i<T> iVar) {
        return asCharSource(url, charset).a(iVar);
    }

    public static List<String> readLines(URL url, Charset charset) {
        return (List) readLines(url, charset, new i<List<String>>() {
            final List<String> result = Lists.tM();

            public boolean cJ(String str) {
                this.result.add(str);
                return true;
            }

            /* renamed from: vn */
            public List<String> getResult() {
                return this.result;
            }
        });
    }

    public static void copy(URL url, OutputStream outputStream) {
        asByteSource(url).b(outputStream);
    }

    public static URL getResource(String str) {
        URL resource = ((ClassLoader) e.h(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
        i.a(resource != null, "resource %s not found.", (Object) str);
        return resource;
    }

    public static URL getResource(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        i.a(resource != null, "resource %s relative to %s not found.", (Object) str, cls.getName());
        return resource;
    }
}
