package com.iqoption.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.iqoption.app.IQApp;
import com.iqoption.x.R;

/* compiled from: EducationFragment */
public class ay extends fb {
    public static ay Y(Bundle bundle) {
        ay ayVar = new ay();
        ayVar.setArguments(bundle);
        return ayVar;
    }

    public static void a(Context context, FragmentManager fragmentManager, @IdRes int i) {
        Bundle bundle = new Bundle();
        String clusterApi = IQApp.Dl().getClusterApi();
        bundle.putBoolean("EXTRA_IS_POST", false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("mobile/education/");
        bundle.putString("EXTRA_URL", stringBuilder.toString());
        bundle.putString("EXTRA_TITLE", context.getString(R.string.education));
        fragmentManager.beginTransaction().add(i, Y(bundle), "EducationFragment").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("EducationFragment").commit();
    }
}
