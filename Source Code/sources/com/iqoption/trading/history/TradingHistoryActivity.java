package com.iqoption.trading.history;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.iqoption.activity.d;
import com.iqoption.dto.ToastEntity;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.trading.history.a.c;
import com.iqoption.trading.history.a.c.a;
import com.iqoption.trading.history.fragment.a.f;
import com.iqoption.trading.history.fragment.viewmodel.b;
import com.iqoption.x.R;
import java.util.Set;

public class TradingHistoryActivity extends d implements a, com.iqoption.trading.history.fragment.a.a, f, com.iqoption.trading.history.fragment.viewmodel.a, b {
    private View blp;
    private c dsB;

    public static void l(Activity activity) {
        activity.startActivity(new Intent(activity, TradingHistoryActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public c cc(long j) {
        return this.dsB.cd(j);
    }

    public View aeP() {
        return this.blp;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_trading_history);
        this.blp = findViewById(R.id.outside);
        this.dsB = new c(this);
    }

    protected void onStart() {
        super.onStart();
        WebSocketHandler.aDm().bE("TradingHistoryActivity");
    }

    protected void onStop() {
        super.onStop();
        WebSocketHandler.aDm().m("TradingHistoryActivity", ToastEntity.ACTION_TOAST_DURATION);
    }

    private void aoX() {
        com.iqoption.util.a.t(this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.fade_out_short);
    }

    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName());
            if (findFragmentByTag == null || !(findFragmentByTag instanceof com.iqoption.fragment.base.f) || !((com.iqoption.fragment.base.f) findFragmentByTag).aN()) {
                supportFragmentManager.popBackStack();
                return;
            }
            return;
        }
        aoX();
    }

    public void a(com.iqoption.view.materialcalendar.b bVar, com.iqoption.view.materialcalendar.b bVar2) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.setting);
        if (findFragmentById != null && (findFragmentById instanceof b)) {
            ((b) findFragmentById).a(bVar, bVar2);
        }
    }

    public void i(Set<Integer> set) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.setting);
        if (findFragmentById != null && (findFragmentById instanceof com.iqoption.trading.history.fragment.viewmodel.a)) {
            ((com.iqoption.trading.history.fragment.viewmodel.a) findFragmentById).i(set);
        }
    }

    public void C(Long l) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.setting);
        if (findFragmentById != null && (findFragmentById instanceof f)) {
            ((f) findFragmentById).C(l);
        }
    }
}
