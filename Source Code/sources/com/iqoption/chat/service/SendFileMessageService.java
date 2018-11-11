package com.iqoption.chat.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.iqoption.microservice.chat.l;
import com.iqoption.x.R;
import java.io.Closeable;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/service/SendFileMessageService;", "Landroid/app/IntentService;", "()V", "createRequestBody", "Lokhttp3/RequestBody;", "inputStream", "Ljava/io/InputStream;", "getFileName", "", "uri", "Landroid/net/Uri;", "onCreate", "", "onDestroy", "onHandleIntent", "intent", "Landroid/content/Intent;", "uploadFile", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SendFileMessageService.kt */
public final class SendFileMessageService extends IntentService {
    private static final String TAG = "SendFileMessageService";
    private static final d aJU = g.f(SendFileMessageService$Companion$CLIENT$2.aJX);
    private static final SimpleDateFormat aJV = new SimpleDateFormat("'file_'MMddyyyy'_'HHmmss", Locale.US);
    public static final b aJW = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/chat/service/SendFileMessageService$Companion;", "", "()V", "CLIENT", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "getCLIENT", "()Lokhttp3/OkHttpClient;", "CLIENT$delegate", "Lkotlin/Lazy;", "EXTRA_ROOM_ID", "", "EXTRA_URIS", "FILE_NAME_FORMATTER", "Ljava/text/SimpleDateFormat;", "TAG", "getTAG", "()Ljava/lang/String;", "UPLOAD_PATH", "sendFiles", "", "context", "Landroid/content/Context;", "roomId", "uris", "", "Landroid/net/Uri;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SendFileMessageService.kt */
    public static final class b {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "CLIENT", "getCLIENT()Lokhttp3/OkHttpClient;"))};

        private final OkHttpClient Qz() {
            d Qy = SendFileMessageService.aJU;
            j jVar = apP[0];
            return (OkHttpClient) Qy.getValue();
        }

        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final String Ll() {
            return SendFileMessageService.TAG;
        }

        public final void a(Context context, String str, List<? extends Uri> list) {
            h.e(context, "context");
            h.e(str, "roomId");
            h.e(list, "uris");
            Intent intent = new Intent(context, SendFileMessageService.class);
            intent.putExtra("extra.roomId", str);
            intent.putExtra("extra.uris", new ArrayList(list));
            ContextCompat.startForegroundService(context, intent);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/ext/GsonExtensionsKt$fromGson$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<JsonObject> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, aXE = {"com/iqoption/chat/service/SendFileMessageService$createRequestBody$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SendFileMessageService.kt */
    public static final class c extends RequestBody {
        final /* synthetic */ InputStream aJY;

        public MediaType contentType() {
            return null;
        }

        c(InputStream inputStream) {
            this.aJY = inputStream;
        }

        public long contentLength() {
            return (long) this.aJY.available();
        }

        public void writeTo(BufferedSink bufferedSink) {
            Exception e;
            Throwable th;
            h.e(bufferedSink, "sink");
            Source source = (Source) null;
            try {
                Source source2 = Okio.source(this.aJY);
                if (source2 == null) {
                    try {
                        h.aXZ();
                    } catch (Exception e2) {
                        e = e2;
                        source = source2;
                        try {
                            com.iqoption.core.i.w(SendFileMessageService.aJW.Ll(), e.getMessage(), e);
                            Util.closeQuietly((Closeable) source);
                        } catch (Throwable th2) {
                            th = th2;
                            Util.closeQuietly((Closeable) source);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        source = source2;
                        Util.closeQuietly((Closeable) source);
                        throw th;
                    }
                }
                bufferedSink.writeAll(source2);
                Util.closeQuietly((Closeable) source2);
            } catch (Exception e3) {
                e = e3;
                com.iqoption.core.i.w(SendFileMessageService.aJW.Ll(), e.getMessage(), e);
                Util.closeQuietly((Closeable) source);
            }
        }
    }

    public SendFileMessageService() {
        super(TAG);
    }

    protected void onHandleIntent(Intent intent) {
        h.e(intent, "intent");
        ArrayList<Uri> parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra.uris");
        String stringExtra = intent.getStringExtra("extra.roomId");
        if (parcelableArrayListExtra != null && (parcelableArrayListExtra.isEmpty() ^ 1) != 0) {
            Collection arrayList = new ArrayList();
            for (Uri uri : parcelableArrayListExtra) {
                h.d(uri, "it");
                String g = g(uri);
                if (g != null) {
                    arrayList.add(g);
                }
            }
            List list = (List) arrayList;
            if ((list.isEmpty() ^ 1) != 0) {
                try {
                    l lVar = l.cQj;
                    h.d(stringExtra, "roomId");
                    com.iqoption.core.i.d(TAG, ((com.iqoption.microservice.chat.b) l.a(lVar, stringExtra, null, null, list, null, 22, null).get()).toString());
                } catch (Exception e) {
                    com.iqoption.core.i.w(TAG, e.getMessage(), e);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00ad A:{Catch:{ Exception -> 0x00ff, all -> 0x00fd }} */
    private final java.lang.String g(android.net.Uri r7) {
        /*
        r6 = this;
        r0 = r6.getContentResolver();
        r0 = r0.openInputStream(r7);
        r1 = new okhttp3.Request$Builder;
        r1.<init>();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = com.iqoption.app.IQApp.Dl();
        r3 = r3.getChatApi();
        r2.append(r3);
        r3 = "api/v1/file";
        r2.append(r3);
        r2 = r2.toString();
        r1 = r1.url(r2);
        r2 = new okhttp3.MultipartBody$Builder;
        r2.<init>();
        r3 = okhttp3.MultipartBody.FORM;
        r2 = r2.setType(r3);
        r3 = "user_id";
        r4 = com.iqoption.app.a.Cw();
        r4 = r4.getUserId();
        r4 = java.lang.String.valueOf(r4);
        r2 = r2.addFormDataPart(r3, r4);
        r3 = "file";
        r7 = r6.h(r7);
        r4 = "stream";
        kotlin.jvm.internal.h.d(r0, r4);
        r4 = r6.e(r0);
        r7 = r2.addFormDataPart(r3, r7, r4);
        r7 = r7.build();
        r7 = (okhttp3.RequestBody) r7;
        r7 = r1.post(r7);
        r7 = r7.build();
        r1 = 0;
        r2 = aJW;	 Catch:{ Exception -> 0x00ff }
        r2 = r2.Qz();	 Catch:{ Exception -> 0x00ff }
        r7 = r2.newCall(r7);	 Catch:{ Exception -> 0x00ff }
        r7 = r7.execute();	 Catch:{ Exception -> 0x00ff }
        r2 = r7.code();	 Catch:{ Exception -> 0x00ff }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r3) goto L_0x00d1;
    L_0x0081:
        r7 = r7.body();	 Catch:{ Exception -> 0x00ff }
        if (r7 == 0) goto L_0x00aa;
    L_0x0087:
        r7 = r7.string();	 Catch:{ Exception -> 0x00ff }
        if (r7 == 0) goto L_0x00aa;
    L_0x008d:
        r2 = com.iqoption.core.f.RQ();	 Catch:{ Exception -> 0x00ff }
        r2 = r2.Dq();	 Catch:{ Exception -> 0x00ff }
        r3 = new com.iqoption.chat.service.SendFileMessageService$a;	 Catch:{ Exception -> 0x00ff }
        r3.<init>();	 Catch:{ Exception -> 0x00ff }
        r3 = r3.getType();	 Catch:{ Exception -> 0x00ff }
        r4 = "object : TypeToken<T>() {}.type";
        kotlin.jvm.internal.h.d(r3, r4);	 Catch:{ Exception -> 0x00ff }
        r7 = r2.fromJson(r7, r3);	 Catch:{ Exception -> 0x00ff }
        r7 = (com.google.gson.JsonObject) r7;	 Catch:{ Exception -> 0x00ff }
        goto L_0x00ab;
    L_0x00aa:
        r7 = r1;
    L_0x00ab:
        if (r7 == 0) goto L_0x010b;
    L_0x00ad:
        r2 = "result";
        r7 = r7.get(r2);	 Catch:{ Exception -> 0x00ff }
        r2 = "json[\"result\"]";
        kotlin.jvm.internal.h.d(r7, r2);	 Catch:{ Exception -> 0x00ff }
        r7 = r7.getAsJsonObject();	 Catch:{ Exception -> 0x00ff }
        r2 = "id";
        r7 = r7.get(r2);	 Catch:{ Exception -> 0x00ff }
        r2 = "json[\"result\"]\n         …      .asJsonObject[\"id\"]";
        kotlin.jvm.internal.h.d(r7, r2);	 Catch:{ Exception -> 0x00ff }
        r7 = r7.getAsString();	 Catch:{ Exception -> 0x00ff }
        r0 = (java.io.Closeable) r0;
        com.jumio.commons.utils.IOUtils.closeQuietly(r0);
        return r7;
    L_0x00d1:
        r2 = TAG;	 Catch:{ Exception -> 0x00ff }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ff }
        r3.<init>();	 Catch:{ Exception -> 0x00ff }
        r4 = "code: ";
        r3.append(r4);	 Catch:{ Exception -> 0x00ff }
        r4 = r7.code();	 Catch:{ Exception -> 0x00ff }
        r3.append(r4);	 Catch:{ Exception -> 0x00ff }
        r4 = ", message: ";
        r3.append(r4);	 Catch:{ Exception -> 0x00ff }
        r7 = r7.message();	 Catch:{ Exception -> 0x00ff }
        if (r7 == 0) goto L_0x00f0;
    L_0x00ef:
        goto L_0x00f2;
    L_0x00f0:
        r7 = "";
    L_0x00f2:
        r3.append(r7);	 Catch:{ Exception -> 0x00ff }
        r7 = r3.toString();	 Catch:{ Exception -> 0x00ff }
        com.iqoption.core.i.d(r2, r7);	 Catch:{ Exception -> 0x00ff }
        goto L_0x010b;
    L_0x00fd:
        r7 = move-exception;
        goto L_0x0111;
    L_0x00ff:
        r7 = move-exception;
        r2 = TAG;	 Catch:{ all -> 0x00fd }
        r3 = r7.getMessage();	 Catch:{ all -> 0x00fd }
        r7 = (java.lang.Throwable) r7;	 Catch:{ all -> 0x00fd }
        com.iqoption.core.i.w(r2, r3, r7);	 Catch:{ all -> 0x00fd }
    L_0x010b:
        r0 = (java.io.Closeable) r0;
        com.jumio.commons.utils.IOUtils.closeQuietly(r0);
        return r1;
    L_0x0111:
        r0 = (java.io.Closeable) r0;
        com.jumio.commons.utils.IOUtils.closeQuietly(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.service.SendFileMessageService.g(android.net.Uri):java.lang.String");
    }

    private final String h(Uri uri) {
        String string;
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != 3143036) {
                if (hashCode == 951530617 && scheme.equals(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT)) {
                    Cursor query = getContentResolver().query(uri, null, null, null, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            string = query.getString(query.getColumnIndex("_display_name"));
                            h.d(string, "cursor.getString(cursor.…bleColumns.DISPLAY_NAME))");
                            return string;
                        }
                        query.close();
                    }
                    return "unknown";
                }
            } else if (scheme.equals("file")) {
                string = uri.getLastPathSegment();
                h.d(string, "uri.lastPathSegment");
                return string;
            }
        }
        string = aJV.format(Long.valueOf(System.currentTimeMillis()));
        h.d(string, "FILE_NAME_FORMATTER.form…stem.currentTimeMillis())");
        return string;
    }

    private final RequestBody e(InputStream inputStream) {
        return new c(inputStream);
    }

    public void onCreate() {
        super.onCreate();
        startForeground(R.id.notification_send_file_message_service, com.iqoption.system.c.a(com.iqoption.system.c.drS, 0, null, null, null, 15, null));
    }

    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }
}
