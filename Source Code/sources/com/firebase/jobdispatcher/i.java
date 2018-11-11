package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import com.firebase.jobdispatcher.u.a;
import com.firebase.jobdispatcher.u.b;

/* compiled from: GooglePlayJobWriter */
final class i {
    private final p JX = new p("com.firebase.jobdispatcher.");

    private static int ao(int i) {
        return i != 2 ? 0 : 1;
    }

    private static int ap(int i) {
        int i2 = 2;
        if ((i & 2) == 2) {
            i2 = 0;
        }
        return (i & 1) == 1 ? 1 : i2;
    }

    i() {
    }

    private static void a(r rVar, Bundle bundle, b bVar) {
        bundle.putInt("trigger_type", 1);
        if (rVar.oM()) {
            bundle.putLong("period", (long) bVar.oT());
            bundle.putLong("period_flex", (long) (bVar.oT() - bVar.oS()));
            return;
        }
        bundle.putLong("window_start", (long) bVar.oS());
        bundle.putLong("window_end", (long) bVar.oT());
    }

    private static void B(Bundle bundle) {
        bundle.putInt("trigger_type", 2);
        bundle.putLong("window_start", 0);
        bundle.putLong("window_end", 1);
    }

    private static void a(Bundle bundle, a aVar) {
        bundle.putInt("trigger_type", 3);
        int size = aVar.oR().size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Uri[size];
        for (int i = 0; i < size; i++) {
            w wVar = (w) aVar.oR().get(i);
            iArr[i] = wVar.getFlags();
            parcelableArr[i] = wVar.getUri();
        }
        bundle.putIntArray("content_uri_flags_array", iArr);
        bundle.putParcelableArray("content_uri_array", parcelableArr);
    }

    public Bundle a(r rVar, Bundle bundle) {
        bundle.putString("tag", rVar.getTag());
        bundle.putBoolean("update_current", rVar.oK());
        bundle.putBoolean("persisted", rVar.getLifetime() == 2);
        bundle.putString(NotificationCompat.CATEGORY_SERVICE, GooglePlayReceiver.class.getName());
        c(rVar, bundle);
        d(rVar, bundle);
        b(rVar, bundle);
        Bundle extras = rVar.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        bundle.putBundle("extras", this.JX.e(rVar, extras));
        return bundle;
    }

    private static void b(r rVar, Bundle bundle) {
        x oJ = rVar.oJ();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("retry_policy", ao(oJ.oU()));
        bundle2.putInt("initial_backoff_seconds", oJ.oV());
        bundle2.putInt("maximum_backoff_seconds", oJ.oW());
        bundle.putBundle("retryStrategy", bundle2);
    }

    private static void c(r rVar, Bundle bundle) {
        u oL = rVar.oL();
        if (oL == y.KT) {
            B(bundle);
        } else if (oL instanceof b) {
            a(rVar, bundle, (b) oL);
        } else if (oL instanceof a) {
            a(bundle, (a) oL);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown trigger: ");
            stringBuilder.append(oL.getClass());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static void d(r rVar, Bundle bundle) {
        int f = a.f(rVar.oI());
        boolean z = false;
        bundle.putBoolean("requiresCharging", (f & 4) == 4);
        String str = "requiresIdle";
        if ((f & 8) == 8) {
            z = true;
        }
        bundle.putBoolean(str, z);
        bundle.putInt("requiredNetwork", ap(f));
    }
}
