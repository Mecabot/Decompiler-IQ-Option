package com.iqoption.portfolio.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.iqoption.activity.b;
import com.iqoption.fragment.base.f;
import com.iqoption.portfolio.a.z;
import com.iqoption.portfolio.m;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.view.e;
import com.iqoption.view.e.a;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;

public final class PortfolioActivity extends b implements e {
    private static final String TAG = "com.iqoption.portfolio.activity.PortfolioActivity";
    private Collection<a> cYQ = new ArrayList();

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        WebSocketHandler.aDm().bE(TAG);
        setContentView((int) R.layout.activity_portfolio);
        if (bundle == null) {
            Fragment ge = z.ge(0);
            ge.a((m) getIntent().getParcelableExtra("com.iqoption.portfolio:portfolioState"));
            getSupportFragmentManager().beginTransaction().add(R.id.portfolioFragment, ge, "PortfolioFragment").commit();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        WebSocketHandler.aDm().m(TAG, 0);
    }

    public void onBackPressed() {
        for (a onBackPressed : this.cYQ) {
            if (onBackPressed.onBackPressed()) {
                return;
            }
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName());
            if (!(findFragmentByTag instanceof f) || !((f) findFragmentByTag).aN()) {
                supportFragmentManager.popBackStack();
                return;
            }
            return;
        }
        if (!awB().onBackPressed()) {
            com.iqoption.util.a.s(this);
        }
    }

    public void onStop() {
        super.onStop();
    }

    private z awB() {
        return (z) getSupportFragmentManager().findFragmentById(R.id.portfolioFragment);
    }

    public void a(@NonNull a aVar) {
        this.cYQ.add(aVar);
    }

    public void b(@NonNull a aVar) {
        this.cYQ.remove(aVar);
    }
}
