package com.iqoption.system;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.b;
import com.google.firebase.messaging.b.a;
import com.google.gson.reflect.TypeToken;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.dto.entity.iqbus.SignalLegacy;
import com.iqoption.dto.entity.position.PendingOrderWrapper;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.event.OtnEmissionExecuted;
import com.iqoption.util.ah;
import com.iqoption.x.R;
import java.util.List;
import java.util.Map;

public class IQFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "com.iqoption.system.IQFirebaseMessagingService";

    public void a(b bVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FCM From: ");
        stringBuilder.append(bVar.wT());
        Log.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("FCM message received. ");
        stringBuilder.append(bVar);
        i.d(str, stringBuilder.toString());
        final Map data = bVar.getData();
        final a wU = bVar.wU();
        com.iqoption.core.d.a.aSc.execute(new Runnable() {
            /* JADX WARNING: Missing block: B:72:0x0145, code:
            if (r6.ff("margin-add-on") == false) goto L_0x01b9;
     */
            public void run() {
                /*
                r9 = this;
                r0 = r4;
                if (r0 == 0) goto L_0x002c;
            L_0x0004:
                r0 = r4;
                r0 = r0.getBody();
                r1 = r4;
                r1 = r1.getTitle();
                r2 = android.text.TextUtils.isEmpty(r0);
                if (r2 != 0) goto L_0x001e;
            L_0x0016:
                r2 = r0;
                r3 = "text";
                r2.put(r3, r0);
            L_0x001e:
                r0 = android.text.TextUtils.isEmpty(r1);
                if (r0 != 0) goto L_0x002c;
            L_0x0024:
                r0 = r0;
                r2 = "title";
                r0.put(r2, r1);
            L_0x002c:
                r0 = com.iqoption.system.IQFirebaseMessagingService.this;
                r0 = r0.getApplicationContext();
                r1 = "notification";
                r1 = r0.getSystemService(r1);
                r1 = (android.app.NotificationManager) r1;
                r2 = r0;
                if (r2 == 0) goto L_0x01e0;
            L_0x003e:
                r2 = r0;
                r3 = "type";
                r2 = r2.containsKey(r3);
                if (r2 == 0) goto L_0x01e0;
            L_0x0049:
                r2 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r3 = "type";
                r2 = r2.get(r3);	 Catch:{ NumberFormatException -> 0x01e0 }
                r2 = (java.lang.String) r2;	 Catch:{ NumberFormatException -> 0x01e0 }
                r3 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x01e0 }
                r4 = com.iqoption.app.a.aL(r0);	 Catch:{ NumberFormatException -> 0x01e0 }
                r4 = r4.isAuthorized();	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = com.iqoption.app.a.b.FF();	 Catch:{ NumberFormatException -> 0x01e0 }
                r6 = com.iqoption.app.managers.feature.b.HT();	 Catch:{ NumberFormatException -> 0x01e0 }
                r7 = -1;
                r8 = r2.hashCode();	 Catch:{ NumberFormatException -> 0x01e0 }
                switch(r8) {
                    case 49: goto L_0x0122;
                    case 50: goto L_0x0118;
                    case 53: goto L_0x010d;
                    case 1600: goto L_0x0103;
                    case 1601: goto L_0x00f8;
                    case 1602: goto L_0x00ee;
                    case 1603: goto L_0x00e4;
                    case 1604: goto L_0x00da;
                    case 1605: goto L_0x00d0;
                    case 1638: goto L_0x00c5;
                    case 1660: goto L_0x00b9;
                    case 1664: goto L_0x00ad;
                    case 1665: goto L_0x00a1;
                    case 1667: goto L_0x0096;
                    case 1668: goto L_0x008a;
                    case 1691: goto L_0x007e;
                    case 1692: goto L_0x0072;
                    default: goto L_0x0070;
                };	 Catch:{ NumberFormatException -> 0x01e0 }
            L_0x0070:
                goto L_0x012b;
            L_0x0072:
                r8 = "51";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x007a:
                r7 = 9;
                goto L_0x012b;
            L_0x007e:
                r8 = "50";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x0086:
                r7 = 12;
                goto L_0x012b;
            L_0x008a:
                r8 = "48";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x0092:
                r7 = 16;
                goto L_0x012b;
            L_0x0096:
                r8 = "47";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x009e:
                r7 = 5;
                goto L_0x012b;
            L_0x00a1:
                r8 = "45";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00a9:
                r7 = 15;
                goto L_0x012b;
            L_0x00ad:
                r8 = "44";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00b5:
                r7 = 14;
                goto L_0x012b;
            L_0x00b9:
                r8 = "40";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00c1:
                r7 = 11;
                goto L_0x012b;
            L_0x00c5:
                r8 = "39";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00cd:
                r7 = 8;
                goto L_0x012b;
            L_0x00d0:
                r8 = "27";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00d8:
                r7 = 6;
                goto L_0x012b;
            L_0x00da:
                r8 = "26";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00e2:
                r7 = 7;
                goto L_0x012b;
            L_0x00e4:
                r8 = "25";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00ec:
                r7 = 4;
                goto L_0x012b;
            L_0x00ee:
                r8 = "24";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x00f6:
                r7 = 3;
                goto L_0x012b;
            L_0x00f8:
                r8 = "23";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x0100:
                r7 = 10;
                goto L_0x012b;
            L_0x0103:
                r8 = "22";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x010b:
                r7 = 2;
                goto L_0x012b;
            L_0x010d:
                r8 = "5";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x0115:
                r7 = 13;
                goto L_0x012b;
            L_0x0118:
                r8 = "2";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x0120:
                r7 = 1;
                goto L_0x012b;
            L_0x0122:
                r8 = "1";
                r8 = r2.equals(r8);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r8 == 0) goto L_0x012b;
            L_0x012a:
                r7 = 0;
            L_0x012b:
                switch(r7) {
                    case 0: goto L_0x01a0;
                    case 1: goto L_0x01a0;
                    case 2: goto L_0x018a;
                    case 3: goto L_0x0176;
                    case 4: goto L_0x0162;
                    case 5: goto L_0x0152;
                    case 6: goto L_0x013f;
                    case 7: goto L_0x013f;
                    case 8: goto L_0x0149;
                    case 9: goto L_0x0136;
                    default: goto L_0x012e;
                };	 Catch:{ NumberFormatException -> 0x01e0 }
            L_0x012e:
                if (r4 == 0) goto L_0x01b9;
            L_0x0130:
                if (r5 != 0) goto L_0x01b2;
            L_0x0132:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01ac;
            L_0x0136:
                r0 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r1 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r0.E(r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x013f:
                r4 = "margin-add-on";
                r4 = r6.ff(r4);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r4 != 0) goto L_0x0149;
            L_0x0147:
                goto L_0x01b9;
            L_0x0149:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4.a(r0, r3, r5, r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x0152:
                r4 = "market-on-open";
                r4 = r6.ff(r4);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r4 == 0) goto L_0x01b9;
            L_0x015a:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4.b(r0, r3, r5, r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x0162:
                r7 = "pending-order";
                r6 = r6.ff(r7);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r6 == 0) goto L_0x01b9;
            L_0x016a:
                if (r4 == 0) goto L_0x01b9;
            L_0x016c:
                if (r5 != 0) goto L_0x01b9;
            L_0x016e:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4.b(r0, r3, r5, r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x0176:
                r7 = "hide-emission";
                r6 = r6.fg(r7);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r6 != 0) goto L_0x01b9;
            L_0x017e:
                if (r4 == 0) goto L_0x01b9;
            L_0x0180:
                if (r5 != 0) goto L_0x01b9;
            L_0x0182:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4.b(r0, r3, r5, r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x018a:
                if (r5 != 0) goto L_0x01b9;
            L_0x018c:
                if (r4 == 0) goto L_0x01b9;
            L_0x018e:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4 = r4.D(r5);	 Catch:{ NumberFormatException -> 0x01e0 }
                if (r4 == 0) goto L_0x01b9;
            L_0x0198:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4.b(r0, r3, r5, r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x01a0:
                if (r5 != 0) goto L_0x01b9;
            L_0x01a2:
                if (r4 == 0) goto L_0x01b9;
            L_0x01a4:
                r4 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4.b(r0, r3, r5, r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x01ac:
                r5 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r4.b(r0, r3, r5, r1);	 Catch:{ NumberFormatException -> 0x01e0 }
                goto L_0x01b9;
            L_0x01b2:
                r1 = com.iqoption.system.IQFirebaseMessagingService.this;	 Catch:{ NumberFormatException -> 0x01e0 }
                r3 = r0;	 Catch:{ NumberFormatException -> 0x01e0 }
                r1.e(r0, r3);	 Catch:{ NumberFormatException -> 0x01e0 }
            L_0x01b9:
                r0 = new com.google.gson.JsonObject;	 Catch:{ NumberFormatException -> 0x01e0 }
                r0.<init>();	 Catch:{ NumberFormatException -> 0x01e0 }
                r1 = "push_type";
                r3 = new com.google.gson.JsonPrimitive;	 Catch:{ NumberFormatException -> 0x01e0 }
                r3.<init>(r2);	 Catch:{ NumberFormatException -> 0x01e0 }
                r0.add(r1, r3);	 Catch:{ NumberFormatException -> 0x01e0 }
                r1 = com.iqoption.analytics.EventManager.Bm();	 Catch:{ NumberFormatException -> 0x01e0 }
                r2 = "system";
                r3 = "app-received-push";
                r2 = com.iqoption.dto.Event.Builder(r2, r3);	 Catch:{ NumberFormatException -> 0x01e0 }
                r0 = r2.setParameters(r0);	 Catch:{ NumberFormatException -> 0x01e0 }
                r0 = r0.build();	 Catch:{ NumberFormatException -> 0x01e0 }
                r1.a(r0);	 Catch:{ NumberFormatException -> 0x01e0 }
            L_0x01e0:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iqoption.system.IQFirebaseMessagingService.1.run():void");
            }
        });
    }

    private void a(Context context, int i, Map<String, String> map, NotificationManager notificationManager) {
        String str = (String) map.get("text");
        String str2 = (String) map.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        String str3 = (String) map.get("link");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            Builder g = g(context, str, str2);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str3));
            g.setContentIntent(PendingIntent.getActivity(context, i, intent, 268435456));
            notificationManager.notify(i, g.build());
        }
    }

    private boolean D(Map<String, String> map) {
        if (map.containsKey("signal")) {
            SignalLegacy fromJson = SignalLegacy.fromJson((String) map.get("signal"));
            if (fromJson != null) {
                return com.iqoption.fragment.b.b.c(fromJson);
            }
        }
        return false;
    }

    private void e(Context context, Map<String, String> map) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(a(new Intent("com.iqoption.push.broadcast.event"), (Map) map));
    }

    private void b(Context context, int i, Map<String, String> map, NotificationManager notificationManager) {
        String str = (String) map.get("text");
        String str2 = (String) map.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        if (!TextUtils.isEmpty(str)) {
            Builder g = g(context, str, str2);
            Intent a = a(new Intent(context, TradeRoomActivity.class), (Map) map);
            a.setFlags(32768);
            g.setContentIntent(PendingIntent.getActivity(context, i, a, 268435456));
            notificationManager.notify(i, g.build());
        }
    }

    private Builder g(Context context, String str, String str2) {
        CharSequence str22;
        Builder smallIcon = new Builder(context).setSmallIcon(R.drawable.ic_notification);
        if (TextUtils.isEmpty(str22)) {
            str22 = context.getString(R.string.app_name);
        }
        Builder autoCancel = smallIcon.setContentTitle(str22).setContentText(str).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher)).setStyle(new BigTextStyle().bigText(str)).setDefaults(-1).setAutoCancel(true);
        if (VERSION.SDK_INT >= 21) {
            autoCancel.setCategory(NotificationCompat.CATEGORY_PROMO);
            autoCancel.setVisibility(1);
        }
        return autoCancel;
    }

    private Intent a(Intent intent, Map<String, String> map) {
        if (map.containsKey("o_type")) {
            intent.putExtra("o_type", (String) map.get("o_type"));
        }
        if (map.containsKey("a_id")) {
            intent.putExtra("a_id", (String) map.get("a_id"));
        }
        if (map.containsKey("o_id")) {
            intent.putExtra("o_id", (String) map.get("o_id"));
        }
        if (map.containsKey(FirebaseAnalytics.b.GROUP_ID)) {
            intent.putExtra(FirebaseAnalytics.b.GROUP_ID, (String) map.get(FirebaseAnalytics.b.GROUP_ID));
        }
        if (map.containsKey("text")) {
            intent.putExtra("text", (String) map.get("text"));
        }
        if (map.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
            intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, (String) map.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        }
        if (map.containsKey(Param.TYPE)) {
            intent.putExtra(Param.TYPE, (String) map.get(Param.TYPE));
        }
        if (map.containsKey("signal")) {
            intent.putExtra("signal", (String) map.get("signal"));
        }
        if (map.containsKey("invitation_type")) {
            intent.putExtra("invitation_type", (String) map.get("invitation_type"));
        }
        if (map.containsKey(OtnEmissionExecuted.COMMISSION_VOLUME_ENROLLED)) {
            intent.putExtra(OtnEmissionExecuted.COMMISSION_VOLUME_ENROLLED, (String) map.get(OtnEmissionExecuted.COMMISSION_VOLUME_ENROLLED));
        }
        if (map.containsKey(OtnEmissionExecuted.TOTAL_COMMISSIONS_ENROLLED)) {
            intent.putExtra(OtnEmissionExecuted.TOTAL_COMMISSIONS_ENROLLED, (String) map.get(OtnEmissionExecuted.TOTAL_COMMISSIONS_ENROLLED));
        }
        if (map.containsKey(OtnEmissionExecuted.COUNT)) {
            intent.putExtra(OtnEmissionExecuted.COUNT, (String) map.get(OtnEmissionExecuted.COUNT));
        }
        if (map.containsKey("active_id")) {
            intent.putExtra("active_id", (String) map.get("active_id"));
        }
        if (map.containsKey("instrument_type")) {
            intent.putExtra("instrument_type", (String) map.get("instrument_type"));
        }
        if (map.containsKey("price")) {
            intent.putExtra("price", (String) map.get("price"));
        }
        if (map.containsKey(PendingOrderWrapper.SIDE)) {
            intent.putExtra(PendingOrderWrapper.SIDE, (String) map.get(PendingOrderWrapper.SIDE));
        }
        if (map.containsKey(PendingOrderWrapper.POSITION_ID)) {
            intent.putExtra(PendingOrderWrapper.POSITION_ID, (String) map.get(PendingOrderWrapper.POSITION_ID));
        }
        a(intent, (Map) map, "id", "card_number", NotificationCompat.CATEGORY_STATUS, Position.CLOSE_REASON_EXPIRED);
        return intent;
    }

    private void a(Intent intent, Map<String, String> map, String... strArr) {
        for (String str : strArr) {
            if (map.containsKey(str)) {
                intent.putExtra(str, (String) map.get(str));
            }
        }
    }

    private void E(Map<String, String> map) {
        List list = (List) ah.aGg().fromJson((String) map.get("addresses"), new TypeToken<List<String>>() {
        }.getType());
        if (list != null) {
            IQApp.Dl().aP(list);
        }
    }
}
