package com.iqoption.kyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.core.i;
import com.iqoption.dto.ToastEntity;
import com.iqoption.fragment.MenuFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.kyc.fragment.f.a.a;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.am;
import com.iqoption.view.e;
import com.iqoption.view.f;
import com.iqoption.x.R;

public class KycReportableErrorActivity extends AppCompatActivity implements a, e {
    private static final String TAG = "com.iqoption.kyc.activity.KycReportableErrorActivity";
    private final f aen = new f();

    public static void aG(Context context) {
        context.startActivity(new Intent(context, KycReportableErrorActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_kyc);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add((int) R.id.kycFrame, com.iqoption.kyc.fragment.f.a.ea(true)).commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOptionsItemSelected, id=");
        stringBuilder.append(menuItem.getItemId());
        i.v(str, stringBuilder.toString());
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        am.n(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            supportFragmentManager.popBackStack();
            i.c(getSupportFragmentManager());
        } else {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this);
            Bundle extras = parentActivityIntent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean(TradeRoomActivity.aea, true);
            if (NavUtils.shouldUpRecreateTask(this, parentActivityIntent) || isTaskRoot()) {
                i.v(TAG, "create activity stack");
                TaskStackBuilder.create(this).addNextIntentWithParentStack(parentActivityIntent).startActivities();
            } else {
                parentActivityIntent.setFlags(67108864);
                NavUtils.navigateUpTo(this, parentActivityIntent);
            }
        }
        return true;
    }

    protected void onStart() {
        super.onStart();
        WebSocketHandler.aDm().bE(TAG);
    }

    protected void onStop() {
        super.onStop();
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        PasscodeFragment.bn(this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.aen.onBackPressed()) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                moveTaskToBack(true);
                finish();
            }
            return;
        }
        am.n(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            supportFragmentManager.popBackStack();
        } else {
            i.d(TAG, "finish app");
            moveTaskToBack(true);
            finish();
        }
    }

    public void apo() {
        i.v(TAG, "onReportableErrorContactSupport");
        b(MenuFragment.ahz(), MenuFragment.TAG);
    }

    public void app() {
        i.w(TAG, "clear us reportable flag");
        new com.iqoption.kyc.f(this).dJ(false);
        Intent intent = new Intent(this, TradeRoomActivity.class);
        intent.putExtra(TradeRoomActivity.adX, true);
        intent.putExtra(TradeRoomActivity.aea, true);
        intent.setFlags(32768);
        startActivity(intent);
        finish();
    }

    private void b(Fragment fragment, String str) {
        am.n(this);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, 17432579).add(R.id.kycFrame, fragment, str).addToBackStack(str).commitAllowingStateLoss();
    }

    public void a(@NonNull e.a aVar) {
        this.aen.a(aVar);
    }

    public void b(@NonNull e.a aVar) {
        this.aen.b(aVar);
    }
}
