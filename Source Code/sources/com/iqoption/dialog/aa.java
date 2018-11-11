package com.iqoption.dialog;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.JsonElement;
import com.iqoption.app.managers.feature.b;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.core.util.p;
import com.iqoption.d.jx;
import com.iqoption.dto.entity.Feature;
import com.iqoption.fragment.base.i;
import com.iqoption.x.R;

/* compiled from: WarningDialog */
public final class aa extends i {
    private jx cga;

    public String gF() {
        return "closed-warning-dialog";
    }

    public static void e(FragmentManager fragmentManager) {
        a(fragmentManager, (int) R.id.other_fragment, null);
    }

    public static void h(FragmentManager fragmentManager) {
        fragmentManager.executePendingTransactions();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("WarningDialog");
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commitNow();
        }
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, Bundle bundle) {
        h(fragmentManager);
        fragmentManager.beginTransaction().add(i, U(bundle), "WarningDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    private static aa U(Bundle bundle) {
        aa aaVar = new aa();
        if (bundle != null) {
            aaVar.setArguments(bundle);
        }
        return aaVar;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cga = jx.z(layoutInflater, viewGroup, false);
        return this.cga.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Feature fd = b.HT().fd("platform-troubles");
        if (!(fd == null || fd.status == null || "disabled".equalsIgnoreCase(fd.status))) {
            JsonElement jsonElement = fd.params;
            if (jsonElement != null && jsonElement.isJsonObject()) {
                JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(fd.status);
                if (jsonElement2.isJsonObject()) {
                    Object asString = jsonElement2.getAsJsonObject().get("token").getAsString();
                    if (!TextUtils.isEmpty(asString)) {
                        asString = LocalizationUtil.translate(asString);
                        if (!TextUtils.isEmpty(asString)) {
                            this.cga.buD.setText(p.gZ(asString));
                        }
                    }
                }
            }
        }
        this.cga.blw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                aa.this.onClose();
            }
        });
    }

    public boolean onClose() {
        h(getFragmentManager());
        return true;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
