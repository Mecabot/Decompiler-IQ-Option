package a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: AppLinks */
public final class a {
    public static Bundle c(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Uri c(Context context, Intent intent) {
        Bundle c = c(intent);
        if (c != null) {
            String string = c.getString("target_url");
            if (string != null) {
                b.a(context, "al_nav_in", intent, null);
                return Uri.parse(string);
            }
        }
        return null;
    }
}
