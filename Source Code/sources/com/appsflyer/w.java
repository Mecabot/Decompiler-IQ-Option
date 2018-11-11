package com.appsflyer;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics.b;

final class w {

    static final class a {
        static final w qC = new w();
    }

    w() {
    }

    @Nullable
    static Location E(@NonNull Context context) {
        Location location = null;
        try {
            Location lastKnownLocation;
            Location lastKnownLocation2;
            LocationManager locationManager = (LocationManager) context.getSystemService(b.LOCATION);
            String str = "network";
            if (a(context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"})) {
                lastKnownLocation = locationManager.getLastKnownLocation(str);
            } else {
                lastKnownLocation = null;
            }
            String str2 = "gps";
            if (a(context, new String[]{"android.permission.ACCESS_FINE_LOCATION"})) {
                lastKnownLocation2 = locationManager.getLastKnownLocation(str2);
            } else {
                lastKnownLocation2 = null;
            }
            if (lastKnownLocation2 == null && lastKnownLocation == null) {
                lastKnownLocation2 = null;
            } else if ((lastKnownLocation2 == null && lastKnownLocation != null) || ((lastKnownLocation != null || lastKnownLocation2 == null) && 60000 < lastKnownLocation.getTime() - lastKnownLocation2.getTime())) {
                lastKnownLocation2 = lastKnownLocation;
            }
            if (lastKnownLocation2 != null) {
                location = lastKnownLocation2;
            }
        } catch (Throwable unused) {
            return location;
        }
    }

    private static boolean a(@NonNull Context context, @NonNull String[] strArr) {
        for (String j : strArr) {
            if (a.j(context, j)) {
                return true;
            }
        }
        return false;
    }
}
