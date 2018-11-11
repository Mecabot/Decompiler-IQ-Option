package com.iqoption.service;

import android.text.TextUtils;
import com.iqoption.core.f;
import com.iqoption.core.i;
import com.iqoption.service.d.a;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.af;
import com.neovisionaries.ws.client.ag;
import com.neovisionaries.ws.client.ai;
import com.neovisionaries.ws.client.aj;
import io.card.payment.BuildConfig;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: NVWebSocketDelegate */
public class b extends d {
    private static final String TAG = "com.iqoption.service.b";
    private af dpy;

    void a(String str, final int i, final a aVar) {
        try {
            List asList;
            if (TextUtils.isEmpty("")) {
                asList = Arrays.asList(new String[]{"lang", f.getLocale(), "platform", Integer.toString(17), "platform_version", BuildConfig.PRODUCT_VERSION});
            } else {
                asList = Arrays.asList(new String[]{"lang", f.getLocale(), "platform", Integer.toString(17), "platform_version", BuildConfig.PRODUCT_VERSION, "ws_route", ""});
            }
            this.dpy = new ai().ij(60000).fR(false).kU(str).kP("permessage-deflate").b(new ag() {
                public void a(af afVar, String str) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.startsWith("{\"name\":\"question-shown\"")) {
                            i.v(b.TAG, "socket_trace NV onMessage question-shown event");
                            com.iqoption.quiz.a.a.did.gn(-1);
                        } else if (str.startsWith("{\"name\":\"question\"")) {
                            i.v(b.TAG, "socket_trace NV onMessage question");
                            com.iqoption.quiz.a.a.did.gp(-1);
                        }
                        aVar.a(i, str, new StringReader(str));
                    }
                }

                public void a(af afVar, Map<String, List<String>> map) {
                    String access$000 = b.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("socket_trace NV ");
                    stringBuilder.append(i);
                    stringBuilder.append(" socket onConnected");
                    i.i(access$000, stringBuilder.toString());
                    aVar.gw(i);
                }

                public void a(af afVar, aj ajVar, aj ajVar2, boolean z) {
                    String access$000 = b.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("socket_trace NV ");
                    stringBuilder.append(i);
                    stringBuilder.append(" socket onDisconnected");
                    i.i(access$000, stringBuilder.toString());
                    aVar.gx(i);
                }

                public void a(af afVar, WebSocketException webSocketException) {
                    String access$000 = b.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("socket_trace NV ");
                    stringBuilder.append(i);
                    stringBuilder.append(" socket onError ");
                    stringBuilder.append(webSocketException);
                    i.i(access$000, stringBuilder.toString());
                    super.a(afVar, webSocketException);
                }

                public void a(af afVar, WebSocketException webSocketException, List<aj> list) {
                    String access$000 = b.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("socket_trace NV ");
                    stringBuilder.append(i);
                    stringBuilder.append(" socket onMessageError ");
                    stringBuilder.append(webSocketException);
                    i.i(access$000, stringBuilder.toString());
                    super.a(afVar, webSocketException, (List) list);
                }

                public void a(af afVar, WebSocketException webSocketException, aj ajVar) {
                    String access$000 = b.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("socket_trace NV ");
                    stringBuilder.append(i);
                    stringBuilder.append(" socket onSendError ");
                    stringBuilder.append(webSocketException);
                    i.i(access$000, stringBuilder.toString());
                    super.a(afVar, webSocketException, ajVar);
                }

                public void a(af afVar, WebSocketException webSocketException, byte[] bArr) {
                    String access$000 = b.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("socket_trace NV ");
                    stringBuilder.append(i);
                    stringBuilder.append(" socket onTextMessageError ");
                    stringBuilder.append(webSocketException);
                    i.i(access$000, stringBuilder.toString());
                    super.a(afVar, webSocketException, bArr);
                }
            }).aO("Cookie", bi(asList)).aQP();
        } catch (Throwable e) {
            aVar.a(i, e, null);
        }
    }

    private String bi(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append((String) list.get(i));
            if (i % 2 == 0) {
                stringBuilder.append('=');
            } else {
                stringBuilder.append("; ");
            }
        }
        return stringBuilder.toString();
    }

    void fV(String str) {
        if (this.dpy != null) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("socket_trace NV send message: ");
            stringBuilder.append(str);
            i.v(str2, stringBuilder.toString());
            if (str.startsWith("{\"name\":\"subscribeMessage\",\"msg\":{\"name\":\"question-shown\"")) {
                i.v(TAG, "socket_trace NV subscribe on question-shown");
                com.iqoption.quiz.a.a.did.i(com.iqoption.app.a.Cw().Dh(), str);
            } else if (str.startsWith("{\"name\":\"unsubscribeMessage\",\"msg\":{\"name\":\"question-shown\"")) {
                i.v(TAG, "socket_trace NV unsubscribe from question-shown");
                com.iqoption.quiz.a.a.did.aAa();
            }
            this.dpy.kQ(str);
        }
    }

    public void aDl() {
        if (this.dpy != null) {
            try {
                i.v(TAG, "socket_trace NV close socket");
                this.dpy.j(1000, null);
            } catch (Exception e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("close NV socket error ");
                stringBuilder.append(e);
                i.e(str, stringBuilder.toString());
            }
        }
    }
}
