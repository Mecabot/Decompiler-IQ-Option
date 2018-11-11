package com.iqoption.service;

import android.text.TextUtils;
import com.iqoption.core.i;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.service.d.a;
import java.io.StringReader;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* compiled from: OkHttpWebSocketDelegate */
public class c extends d {
    private static final String TAG = "com.iqoption.service.c";
    private WebSocket dpC;

    void a(String str, final int i, final a aVar) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("socket_trace ");
        stringBuilder.append(i);
        stringBuilder.append(" connect to web socket");
        i.i(str2, stringBuilder.toString());
        RequestManager.atO().atQ().newWebSocket(new Builder().url(str).build(), new WebSocketListener() {
            public void onOpen(WebSocket webSocket, Response response) {
                String access$000 = c.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("socket_trace ");
                stringBuilder.append(i);
                stringBuilder.append(" onOpen, response:");
                stringBuilder.append(response);
                i.i(access$000, stringBuilder.toString());
                c.this.dpC = webSocket;
                aVar.gw(i);
            }

            public void onMessage(WebSocket webSocket, String str) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("{\"name\":\"question-shown\"")) {
                        i.v(c.TAG, "socket_trace onMessage question-shown event");
                        com.iqoption.quiz.a.a.did.gn(-1);
                    } else if (str.startsWith("{\"name\":\"question\"")) {
                        i.v(c.TAG, "socket_trace onMessage question");
                        com.iqoption.quiz.a.a.did.gp(-1);
                    }
                    aVar.a(i, str, new StringReader(str));
                }
            }

            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                String access$000 = c.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("socket_trace ");
                stringBuilder.append(i);
                stringBuilder.append(" onFailure, response:");
                stringBuilder.append(response);
                stringBuilder.append(", error:");
                stringBuilder.append(th);
                i.e(access$000, stringBuilder.toString());
                try {
                    webSocket.cancel();
                } catch (Exception e) {
                    access$000 = c.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("cancel socket error ");
                    stringBuilder.append(e);
                    i.e(access$000, stringBuilder.toString());
                }
                aVar.a(i, th, response);
            }

            public void onClosed(WebSocket webSocket, int i, String str) {
                String access$000 = c.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("socket_trace ");
                stringBuilder.append(i);
                stringBuilder.append(" onClosed, reason:");
                stringBuilder.append(str);
                stringBuilder.append(", code:");
                stringBuilder.append(i);
                i.i(access$000, stringBuilder.toString());
                aVar.gx(i);
            }

            public void onClosing(WebSocket webSocket, int i, String str) {
                String access$000 = c.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("socket_trace ");
                stringBuilder.append(i);
                stringBuilder.append(" onClosing, reason:");
                stringBuilder.append(str);
                stringBuilder.append(", code:");
                stringBuilder.append(i);
                i.i(access$000, stringBuilder.toString());
                super.onClosing(webSocket, i, str);
            }

            public void onMessage(WebSocket webSocket, ByteString byteString) {
                String access$000 = c.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("socket_trace ");
                stringBuilder.append(i);
                stringBuilder.append(" onMessage bytes");
                i.i(access$000, stringBuilder.toString());
                super.onMessage(webSocket, byteString);
            }
        });
    }

    void fV(String str) {
        if (this.dpC != null) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("socket_trace send message: ");
            stringBuilder.append(str);
            i.v(str2, stringBuilder.toString());
            if (str.startsWith("{\"name\":\"subscribeMessage\",\"msg\":{\"name\":\"question-shown\"")) {
                i.v(TAG, "socket_trace subscribe on question-shown");
                com.iqoption.quiz.a.a.did.i(com.iqoption.app.a.Cw().Dh(), str);
            } else if (str.startsWith("{\"name\":\"unsubscribeMessage\",\"msg\":{\"name\":\"question-shown\"")) {
                i.v(TAG, "socket_trace unsubscribe from question-shown");
                com.iqoption.quiz.a.a.did.aAa();
            } else if (str.endsWith("\"get-question\",\"version\":\"1.0\",\"body\":{}}}")) {
                i.v(TAG, "socket_trace request question");
                com.iqoption.quiz.a.a.did.go(-1);
            }
            this.dpC.send(str);
        }
    }

    public void aDl() {
        if (this.dpC != null) {
            try {
                this.dpC.close(1000, "Goodbye, World!");
            } catch (Exception e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("close socket error ");
                stringBuilder.append(e);
                i.e(str, stringBuilder.toString());
            }
        }
    }
}
