package com.iqoption.fragment.base;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.activity.b;
import com.iqoption.activity.d;
import com.iqoption.fragment.cr;
import com.iqoption.util.fragmentstack.e;
import io.reactivex.disposables.a;

/* compiled from: IQFragment */
public abstract class f extends e {
    @NonNull
    private final a bbt = new a();
    protected boolean cvL = false;
    @NonNull
    private final a cvM = new a();
    private long cvN = 0;

    public boolean onClose() {
        return false;
    }

    public b ajV() {
        return (b) zzakw();
    }

    @Nullable
    public TradeRoomActivity getTradeRoomActivity() {
        FragmentActivity activity = zzakw();
        return (activity == null || !(activity instanceof TradeRoomActivity)) ? null : (TradeRoomActivity) zzakw();
    }

    @Nullable
    public cr ajW() {
        TradeRoomActivity tradeRoomActivity = getTradeRoomActivity();
        if (tradeRoomActivity == null) {
            return null;
        }
        return tradeRoomActivity.getTradeFragment();
    }

    @Nullable
    public d ajX() {
        FragmentActivity activity = zzakw();
        return (activity == null || !(activity instanceof d)) ? null : (d) zzakw();
    }

    /* renamed from: onBackPressed */
    public boolean aN() {
        if (!isAdded() || System.currentTimeMillis() - this.cvN < 300) {
            return true;
        }
        this.cvN = System.currentTimeMillis();
        return onClose();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.cvL = true;
        bundle.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(bundle);
    }

    public void onPause() {
        this.cvM.clear();
        super.onPause();
    }

    public void onDestroy() {
        this.bbt.clear();
        super.onDestroy();
    }

    public final int ef(@DimenRes int i) {
        return getResources().getDimensionPixelSize(i);
    }

    public final float eN(@DimenRes int i) {
        return getResources().getDimension(i);
    }

    @ColorInt
    public final int getColor(@ColorRes int i) {
        return ContextCompat.getColor(getContext(), i);
    }

    public Drawable getDrawable(@DrawableRes int i) {
        return ContextCompat.getDrawable(getContext(), i);
    }

    @Deprecated
    public void c(@NonNull io.reactivex.disposables.b bVar) {
        this.cvM.e(bVar);
    }

    @Deprecated
    public void a(@NonNull io.reactivex.disposables.b bVar) {
        this.bbt.e(bVar);
    }
}
