package com.iqoption.service;

import java.io.StringReader;
import okhttp3.Response;

/* compiled from: WebSocketDelegate */
abstract class d {

    /* compiled from: WebSocketDelegate */
    public static abstract class a {
        public void a(int i, String str, StringReader stringReader) {
        }

        public void a(int i, Throwable th, Response response) {
        }

        public void gw(int i) {
        }

        public void gx(int i) {
        }
    }

    abstract void a(String str, int i, a aVar);

    abstract void aDl();

    abstract void fV(String str);

    d() {
    }
}
