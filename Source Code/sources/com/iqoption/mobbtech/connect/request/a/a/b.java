package com.iqoption.mobbtech.connect.request.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.google.common.base.Predicates;
import com.google.common.base.i;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.google.gson.stream.JsonReader;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.core.connect.k;
import com.iqoption.core.ext.c;
import com.iqoption.dto.Event.Builder;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.util.ah;
import com.iqoption.util.be;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RequestTask */
public class b<T> {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.a.a.b";
    private kotlin.jvm.a.b<? super JsonReader, ? extends T> anG;
    private final String apiName;
    @Nullable
    private String cPL;
    protected Request cVe;
    protected String cVf;
    protected Builder cVg;
    private Type cVh;
    protected String errorMessage;
    protected int responseCode;
    protected boolean success;
    protected Class<T> type;

    /* compiled from: RequestTask */
    public static class b<T> {
        private final Class<T> anF;
        private HashMap<String, Object> anM;
        private int cVn;
        private HashMap<String, Object> cVo;
        private String cVp;
        private String host;
        private String path;
        private final Type type;
        private String uQ;

        public b(Class<T> cls) {
            this.cVn = 1;
            this.anF = cls;
            this.type = null;
        }

        public b(Type type) {
            this.cVn = 1;
            this.anF = null;
            this.type = type;
        }

        public b<T> iF(String str) {
            this.host = be.jP(str);
            return this;
        }

        public b<T> iG(String str) {
            this.path = str;
            return this;
        }

        public b<T> ft(int i) {
            this.cVn = i;
            return this;
        }

        public b<T> n(String str, Object obj) {
            if (obj != null) {
                if (this.anM == null) {
                    this.anM = new HashMap();
                }
                this.anM.put(str, obj);
            }
            return this;
        }

        public b<T> o(String str, Object obj) {
            if (obj != null) {
                if (this.cVo == null) {
                    this.cVo = new HashMap();
                }
                this.cVo.put(str, obj);
            }
            return this;
        }

        public b<T> iH(String str) {
            this.cVp = str;
            return this;
        }

        public b<T> iI(String str) {
            this.uQ = str;
            return this;
        }

        public s<T> auF() {
            switch (this.cVn) {
                case 1:
                    if (this.cVp != null) {
                        throw new RuntimeException("json is not supported for get request");
                    } else if (this.anF != null) {
                        return RequestManager.a(this.host, this.path, this.cVo, this.anM, IQApp.Dk(), this.anF, this.path);
                    } else {
                        return RequestManager.a(this.host, this.path, this.cVo, this.anM, IQApp.Dk(), this.type, this.path);
                    }
                case 2:
                    if (this.cVp == null) {
                        if (this.anF != null) {
                            return RequestManager.a(this.host, this.path, this.cVo, this.anM, IQApp.Dk(), this.anF);
                        }
                        return RequestManager.a(this.host, this.path, this.cVo, this.anM, IQApp.Dk(), this.type);
                    } else if (this.anF != null) {
                        return RequestManager.a(this.host, this.path, this.cVo, this.cVp, IQApp.Dk(), this.anF, this.uQ);
                    } else {
                        return RequestManager.a(this.host, this.path, this.cVo, this.cVp, IQApp.Dk(), this.type, this.uQ);
                    }
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown requestType: ");
                    stringBuilder.append(this.cVn);
                    return o.m(new IllegalStateException(stringBuilder.toString()));
            }
        }
    }

    /* compiled from: RequestTask */
    public static class a<T> implements k<T> {
        private final Class<T> anF;
        private final kotlin.jvm.a.b<? super JsonReader, ? extends T> anG;
        private HashMap<String, Object> anM;
        private String cPL;
        private String cUR;
        private int cVk;
        private JSONObject cVl;
        private String path;
        private int retryCount;
        private long timeout;
        private final Type type;
        private String version;

        public a(Class<T> cls) {
            this(cls, null, null, null);
        }

        public a(Type type) {
            this(null, type, null, null);
        }

        public a(Class<T> cls, String str) {
            this(cls, null, null, str);
        }

        public a(Type type, String str) {
            this(null, type, null, str);
        }

        public a(kotlin.jvm.a.b<? super JsonReader, ? extends T> bVar, String str) {
            this(null, null, bVar, str);
        }

        private a(Class<T> cls, Type type, kotlin.jvm.a.b<? super JsonReader, ? extends T> bVar, String str) {
            this.cVk = 0;
            this.version = "1.0";
            this.cUR = null;
            this.timeout = 15000;
            this.retryCount = 3;
            this.anF = cls;
            this.type = type;
            this.anG = bVar;
            this.path = str;
        }

        @NonNull
        public k<T> ga(@NonNull String str) {
            this.path = str;
            return this;
        }

        @NonNull
        public k<T> gb(@NonNull String str) {
            this.version = str;
            return this;
        }

        @NonNull
        public k<T> gc(@Nullable String str) {
            this.cUR = str;
            return this;
        }

        @NonNull
        public k<T> cd(boolean z) {
            this.retryCount = z ? 3 : 0;
            return this;
        }

        @NonNull
        public k<T> dF(int i) {
            this.retryCount = i;
            return this;
        }

        @NonNull
        public k<T> m(@NonNull JSONObject jSONObject) {
            this.cVl = jSONObject;
            return this;
        }

        @NonNull
        public k<T> b(@NonNull HashMap<String, Object> hashMap) {
            this.anM = hashMap;
            return this;
        }

        @NonNull
        public k<T> j(@NonNull String str, Object obj) {
            if (obj != null) {
                auN();
                this.anM.put(str, obj);
            }
            return this;
        }

        @NonNull
        public k<T> c(@NonNull String str, @NonNull Iterable<Long> iterable) {
            if (iterable != null) {
                auN();
                JSONArray jSONArray = new JSONArray();
                for (Long l : iterable) {
                    if (l != null) {
                        jSONArray.put(l.longValue());
                    }
                }
                this.anM.put(str, jSONArray);
            }
            return this;
        }

        @NonNull
        public k<T> gd(String str) {
            this.cPL = str;
            return this;
        }

        @NonNull
        public s<T> Sa() {
            boolean z = this.cVl == null || this.anM == null;
            i.checkArgument(z, "two types params are not allowed at the same time");
            return auM();
        }

        @NonNull
        public s<T> auL() {
            boolean z = this.cVl == null || this.anM == null;
            i.checkArgument(z, "two types params are not allowed at the same time");
            return o.b(o.a(WebSocketHandler.aDm().aDv(), 15000, TimeUnit.MILLISECONDS, com.iqoption.core.d.a.aSc), new f(this), com.iqoption.core.d.a.aSd);
        }

        private s<T> auM() {
            if (this.cVk == 1) {
                return new k(this.anF, null, this.path).iE(this.cPL).a(this.path, this.version, this.anM, this.cVl, this.timeout, this.retryCount, this.cUR);
            }
            b bVar;
            if (this.anF != null) {
                bVar = new b(this.anF, null, this.path);
            } else if (this.type != null) {
                bVar = new b(this.type, this.path);
            } else {
                bVar = new b(null, this.path).k(this.anG);
            }
            b bVar2 = bVar;
            bVar2.iE(this.cPL);
            return bVar2.a(this.path, this.version, this.anM, this.cVl, this.timeout, this.retryCount, this.cUR);
        }

        public io.reactivex.o<T> Sb() {
            return c.b(new g(this));
        }

        private void auN() {
            if (this.anM == null) {
                this.anM = new HashMap();
            }
        }
    }

    protected boolean are() {
        return true;
    }

    public static String auB() {
        return UUID.randomUUID().toString();
    }

    public b(Class<T> cls, Request request, String str) {
        this.success = false;
        this.responseCode = -100;
        this.cVe = request;
        this.type = cls;
        this.apiName = str;
    }

    public b(Type type, String str) {
        this(type, null, str);
    }

    public b(Type type, Request request, String str) {
        this.success = false;
        this.responseCode = -100;
        this.cVe = request;
        this.cVh = type;
        this.apiName = str;
    }

    public String auC() {
        return this.apiName;
    }

    public b<T> iE(@Nullable String str) {
        this.cPL = str;
        return this;
    }

    public b<T> k(@Nullable kotlin.jvm.a.b<? super JsonReader, ? extends T> bVar) {
        this.anG = bVar;
        return this;
    }

    @Nullable
    public String auD() {
        return this.cPL;
    }

    private s<T> auE() {
        return com.iqoption.core.d.a.aSc.c(new c(this));
    }

    public s<T> auF() {
        return auE();
    }

    public s<T> auG() {
        String httpUrl = (this.cVe == null || this.cVe.url() == null) ? "null" : this.cVe.url().toString();
        return ag.a(new d(this), Predicates.pQ(), com.iqoption.core.d.a.aSd, 3, -1, httpUrl);
    }

    final /* synthetic */ s auJ() {
        y wb = y.wb();
        WebSocketHandler.aDm().c(com.iqoption.service.websocket.a.b.a(this, wb, 60000));
        return o.a(wb, 60000, TimeUnit.MILLISECONDS, com.iqoption.core.d.a.aSd);
    }

    public s<T> b(String str, HashMap<String, Object> hashMap) {
        return a(str, (HashMap) hashMap, 15000);
    }

    public s<T> a(String str, HashMap<String, Object> hashMap, String str2) {
        return a(str, "1.0", hashMap, null, 15000, 3, str2);
    }

    public s<T> a(String str, HashMap<String, Object> hashMap, long j) {
        return a(str, "1.0", hashMap, null, j, 3, null);
    }

    public s<T> a(String str, String str2, HashMap<String, Object> hashMap, JSONObject jSONObject, long j, int i, @Nullable String str3) {
        boolean z = hashMap == null || jSONObject == null;
        i.checkArgument(z);
        y wb = y.wb();
        if (jSONObject != null) {
            WebSocketHandler.aDm().c(com.iqoption.service.websocket.a.b.a("sendMessage", this, wb, str, jSONObject).jJ(str2).jK(str3));
        } else {
            WebSocketHandler.aDm().c(com.iqoption.service.websocket.a.b.a("sendMessage", this, wb, str, (Map) hashMap).jJ(str2).jK(str3));
        }
        if (i > 0) {
            return ag.a(new e(wb, j), Predicates.pQ(), com.iqoption.core.d.a.aSd, i, -1, str);
        }
        return o.a(wb, j, TimeUnit.MILLISECONDS, com.iqoption.core.d.a.aSd);
    }

    public Request auH() {
        return this.cVe;
    }

    protected T ig(String str) {
        if (this.type != null) {
            return ah.aGg().fromJson(str, this.type);
        }
        if (this.cVh != null) {
            return ah.aGg().fromJson(str, this.cVh);
        }
        if (this.anG != null) {
            return this.anG.invoke(new JsonReader(new StringReader(str)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not parse response of api call ");
        stringBuilder.append(this.apiName);
        throw new RuntimeException(stringBuilder.toString());
    }

    protected Pair<T, String> o(JsonReader jsonReader) {
        if (this.type != null) {
            return new Pair(ah.aGg().fromJson(jsonReader, this.type), null);
        }
        if (this.cVh != null) {
            return new Pair(ah.aGg().fromJson(jsonReader, this.cVh), null);
        }
        if (this.anG != null) {
            return new Pair(this.anG.invoke(jsonReader), null);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not parse response of api call ");
        stringBuilder.append(this.apiName);
        throw new RuntimeException(stringBuilder.toString());
    }

    private T doInBackground() {
        return p(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A:{SYNTHETIC, Splitter: B:26:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061 A:{Catch:{ Exception -> 0x0074 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8 A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8 A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8 A:{Catch:{ all -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d4  */
    public final T p(com.google.gson.stream.JsonReader r13) {
        /*
        r12 = this;
        r0 = 0;
        r12.success = r0;
        r1 = 0;
        r12.errorMessage = r1;
        r12.cVf = r1;
        r2 = 1;
        if (r13 == 0) goto L_0x000d;
    L_0x000b:
        r10 = 1;
        goto L_0x000e;
    L_0x000d:
        r10 = 0;
    L_0x000e:
        r3 = "system";
        r4 = "response_error";
        r3 = com.iqoption.dto.Event.Builder(r3, r4);
        r12.cVg = r3;
        if (r10 != 0) goto L_0x005e;
    L_0x001b:
        r3 = r12.cVe;	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r3 = a(r3);	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        if (r3 == 0) goto L_0x005e;
    L_0x0023:
        r3 = TAG;	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r4.<init>();	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r5 = "requestBase: ";
        r4.append(r5);	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r5 = r12.cVe;	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r4.append(r5);	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        com.iqoption.core.i.v(r3, r4);	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r11 = com.google.common.util.concurrent.y.wb();	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
        r3 = com.iqoption.analytics.f.Br();	 Catch:{ Exception -> 0x0074 }
        r5 = r12.apiName;	 Catch:{ Exception -> 0x0074 }
        r6 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r4 = com.iqoption.service.WebSocketHandler.aDm();	 Catch:{ Exception -> 0x0074 }
        r9 = r4.aDz();	 Catch:{ Exception -> 0x0074 }
        r4 = r11;
        r8 = r10;
        r3.a(r4, r5, r6, r8, r9);	 Catch:{ Exception -> 0x0074 }
        goto L_0x005f;
    L_0x0056:
        r13 = move-exception;
        r11 = r1;
        goto L_0x00df;
    L_0x005a:
        r13 = move-exception;
        r3 = r1;
        r11 = r3;
        goto L_0x009e;
    L_0x005e:
        r11 = r1;
    L_0x005f:
        if (r10 == 0) goto L_0x0077;
    L_0x0061:
        r13 = r12.o(r13);	 Catch:{ Exception -> 0x0074 }
        r3 = r13.first;	 Catch:{ Exception -> 0x0074 }
        r13 = r13.second;	 Catch:{ Exception -> 0x006f }
        r13 = (java.lang.String) r13;	 Catch:{ Exception -> 0x006f }
        r12.cVf = r13;	 Catch:{ Exception -> 0x006f }
        r13 = r3;
        goto L_0x008f;
    L_0x006f:
        r13 = move-exception;
        goto L_0x009e;
    L_0x0071:
        r13 = move-exception;
        goto L_0x00df;
    L_0x0074:
        r13 = move-exception;
        r3 = r1;
        goto L_0x009e;
    L_0x0077:
        r13 = com.iqoption.mobbtech.connect.RequestManager.atO();	 Catch:{ Exception -> 0x0074 }
        r3 = r12.cVe;	 Catch:{ Exception -> 0x0074 }
        r4 = r12.are();	 Catch:{ Exception -> 0x0074 }
        r13 = r13.a(r3, r4);	 Catch:{ Exception -> 0x0074 }
        r13 = r12.b(r13);	 Catch:{ Exception -> 0x0074 }
        r12.cVf = r13;	 Catch:{ Exception -> 0x0074 }
        r13 = r12.ig(r13);	 Catch:{ Exception -> 0x0074 }
    L_0x008f:
        if (r13 == 0) goto L_0x0092;
    L_0x0091:
        goto L_0x0093;
    L_0x0092:
        r2 = 0;
    L_0x0093:
        r12.success = r2;	 Catch:{ Exception -> 0x009b }
        if (r11 == 0) goto L_0x00d8;
    L_0x0097:
        r11.P(r1);
        goto L_0x00d8;
    L_0x009b:
        r2 = move-exception;
        r3 = r13;
        r13 = r2;
    L_0x009e:
        r2 = r12.responseCode;	 Catch:{ all -> 0x0071 }
        if (r2 >= 0) goto L_0x00a8;
    L_0x00a2:
        r2 = r13 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0071 }
        if (r2 == 0) goto L_0x00a8;
    L_0x00a6:
        r12.responseCode = r0;	 Catch:{ all -> 0x0071 }
    L_0x00a8:
        if (r11 == 0) goto L_0x00ae;
    L_0x00aa:
        r11.h(r13);	 Catch:{ all -> 0x0071 }
        r11 = r1;
    L_0x00ae:
        r12.success = r0;	 Catch:{ all -> 0x0071 }
        r0 = r13.getMessage();	 Catch:{ all -> 0x0071 }
        com.iqoption.util.k.log(r0);	 Catch:{ all -> 0x0071 }
        r2 = r12.cVe;	 Catch:{ all -> 0x0071 }
        if (r2 == 0) goto L_0x00c4;
    L_0x00bb:
        r2 = r12.cVe;	 Catch:{ all -> 0x0071 }
        r2 = r2.toString();	 Catch:{ all -> 0x0071 }
        com.iqoption.util.k.log(r2);	 Catch:{ all -> 0x0071 }
    L_0x00c4:
        r2 = r12.cVf;	 Catch:{ all -> 0x0071 }
        if (r2 == 0) goto L_0x00cd;
    L_0x00c8:
        r2 = r12.cVf;	 Catch:{ all -> 0x0071 }
        com.iqoption.util.k.log(r2);	 Catch:{ all -> 0x0071 }
    L_0x00cd:
        r2 = "TAG";
        com.iqoption.core.i.e(r2, r0, r13);	 Catch:{ all -> 0x0071 }
        if (r11 == 0) goto L_0x00d7;
    L_0x00d4:
        r11.P(r1);
    L_0x00d7:
        r13 = r3;
    L_0x00d8:
        r12.bx(r13);
        r12.auI();
        return r13;
    L_0x00df:
        if (r11 == 0) goto L_0x00e4;
    L_0x00e1:
        r11.P(r1);
    L_0x00e4:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.mobbtech.connect.request.a.a.b.p(com.google.gson.stream.JsonReader):T");
    }

    private static boolean a(Request request) {
        if (request == null) {
            return false;
        }
        String str;
        HttpUrl url = request.url();
        if (url == null) {
            str = "";
        } else {
            str = url.toString();
        }
        return str.contains("api/users-stat") ^ 1;
    }

    protected String b(Response response) {
        if (response.isSuccessful()) {
            String string = response.body().string();
            response.close();
            com.iqoption.core.i.d(string);
            return string;
        }
        this.responseCode = response.code();
        response.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected code ");
        stringBuilder.append(response.code());
        stringBuilder.append(" url=");
        stringBuilder.append(this.cVe != null ? this.cVe.toString() : "");
        stringBuilder.append(", response: ");
        stringBuilder.append(response);
        throw new IOException(stringBuilder.toString());
    }

    protected void bx(T t) {
        if (t == null || !this.success) {
            g gVar = new g(this.cVf);
            gVar.by(t);
            throw new MobbErrorException(gVar);
        }
    }

    private void auI() {
        if (!this.success) {
            EventManager Bm = EventManager.Bm();
            Builder technicalLogs = this.cVg.calcDuration().setTechnicalLogs(Boolean.valueOf(true));
            com.iqoption.core.util.i.b l = com.iqoption.core.util.i.ZZ().l("request", this.cVe.toString().replace("\"", "\\\""));
            String str = "responce";
            Object replace = !TextUtils.isEmpty(this.cVf) ? this.cVf.toString().replace("\"", "\\\"") : !TextUtils.isEmpty(this.errorMessage) ? this.errorMessage.toString().replace("\"", "\\\"") : "";
            Bm.a(technicalLogs.setParameters(l.l(str, replace).aab()).build());
        }
    }

    public static <T> a<T> A(Class<T> cls) {
        return new a((Class) cls);
    }

    public static <T> a<T> n(Type type) {
        return new a(type);
    }

    public static <T> a<T> d(Class<T> cls, String str) {
        return new a((Class) cls, str);
    }

    public static <T> a<T> a(Type type, String str) {
        return new a(type, str);
    }

    public static <T> a<T> a(kotlin.jvm.a.b<? super JsonReader, ? extends T> bVar, String str) {
        return new a((kotlin.jvm.a.b) bVar, str);
    }

    public static <T> b<T> B(Class<T> cls) {
        return new b((Class) cls);
    }

    public static <T> b<T> o(Type type) {
        return new b(type);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RequestTask{requestBase=");
        stringBuilder.append(this.cVe);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", success=");
        stringBuilder.append(this.success);
        stringBuilder.append(", errorJson='");
        stringBuilder.append(this.cVf);
        stringBuilder.append('\'');
        stringBuilder.append(", errorMessage='");
        stringBuilder.append(this.errorMessage);
        stringBuilder.append('\'');
        stringBuilder.append(", responseCode=");
        stringBuilder.append(this.responseCode);
        stringBuilder.append(", mEventError=");
        stringBuilder.append(this.cVg);
        stringBuilder.append(", typeOfT=");
        stringBuilder.append(this.cVh);
        stringBuilder.append(", apiName='");
        stringBuilder.append(this.apiName);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
