package com.iqoption.system;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat.Builder;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.app.IQApp;
import com.iqoption.core.ext.a;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J0\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/system/Notificator;", "", "()V", "GENERAL_CHANNEL_ID", "", "context", "Lcom/iqoption/app/IQApp;", "kotlin.jvm.PlatformType", "resources", "Landroid/content/res/Resources;", "ensureGeneralChannel", "", "getBuilder", "Landroid/support/v4/app/NotificationCompat$Builder;", "getString", "id", "", "getUploadNotification", "Landroid/app/Notification;", "smallIcon", "largeIcon", "Landroid/graphics/Bitmap;", "title", "", "contentIntent", "Landroid/app/PendingIntent;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Notificator.kt */
public final class c {
    private static final Resources aMx;
    private static final IQApp drR = IQApp.Dk();
    public static final c drS = new c();

    static {
        IQApp iQApp = drR;
        h.d(iQApp, "context");
        aMx = iQApp.getResources();
    }

    private c() {
    }

    private final String getString(int i) {
        return aMx.getString(i);
    }

    private final Builder aEq() {
        if (VERSION.SDK_INT >= 26) {
            aEr();
        }
        return new Builder(drR, "General");
    }

    @RequiresApi(26)
    private final void aEr() {
        IQApp iQApp = drR;
        h.d(iQApp, "context");
        NotificationManager bc = a.bc(iQApp);
        if (bc.getNotificationChannel("General") == null) {
            bc.createNotificationChannel(new NotificationChannel("General", drS.getString(R.string.general), 3));
        }
    }

    public static /* synthetic */ Notification a(c cVar, int i, Bitmap bitmap, CharSequence charSequence, PendingIntent pendingIntent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 17301640;
        }
        if ((i2 & 2) != 0) {
            bitmap = BitmapFactory.decodeResource(aMx, R.drawable.ic_launcher);
        }
        if ((i2 & 4) != 0) {
            String string = aMx.getString(R.string.uploading);
            h.d(string, "resources.getString(R.string.uploading)");
            charSequence = string;
        }
        if ((i2 & 8) != 0) {
            pendingIntent = PendingIntent.getActivity(drR, 0, new Intent(drR, TradeRoomActivity.class).addFlags(536870912), 268435456);
            h.d(pendingIntent, "PendingIntent.getActivit…tent.FLAG_CANCEL_CURRENT)");
        }
        return cVar.a(i, bitmap, charSequence, pendingIntent);
    }

    public final Notification a(int i, Bitmap bitmap, CharSequence charSequence, PendingIntent pendingIntent) {
        h.e(charSequence, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        h.e(pendingIntent, "contentIntent");
        Notification build = aEq().setSmallIcon(i).setLargeIcon(bitmap).setContentTitle(charSequence).setContentIntent(pendingIntent).setProgress(100, 0, true).setOngoing(true).build();
        h.d(build, "getBuilder()\n           …\n                .build()");
        return build;
    }
}
