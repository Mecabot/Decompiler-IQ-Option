package com.iqoption.feed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.iqoption.activity.b;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.x.R;

public class FeedPortraitActivity extends b {
    private static final String TAG = "com.iqoption.feed.FeedPortraitActivity";
    public static String ckV = "EXTRA_PORTRAIT_CLICKED_BUTTON";

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        WebSocketHandler.aDm().bE(TAG);
        setContentView((int) R.layout.feed_portrait_activity);
        if (getSupportFragmentManager().findFragmentByTag(b.TAG) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.content, new b(), b.TAG).commitAllowingStateLoss();
        }
    }

    protected void onDestroy() {
        WebSocketHandler.aDm().m(TAG, 0);
        super.onDestroy();
    }

    public void onBackPressed() {
        b bVar = (b) getSupportFragmentManager().findFragmentByTag(b.TAG);
        if (bVar == null || !bVar.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
