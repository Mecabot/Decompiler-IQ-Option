package com.iqoption.fragment.account.security.sms;

import android.content.Context;
import com.iqoption.x.R;

/* compiled from: ConfirmCodeHelper */
public class a {
    private final int cuU;
    private final int cuV;
    private final int cuW;

    public a(Context context) {
        this.cuU = context.getResources().getInteger(R.integer.confirmation_time_ms);
        this.cuV = context.getResources().getInteger(R.integer.confirmation_time_about_end);
        this.cuW = context.getResources().getInteger(R.integer.confirmation_skip_timeout);
    }

    public int ajB() {
        return this.cuU;
    }

    public long bl(long j) {
        return j == 0 ? 0 : Math.max((j + ((long) this.cuU)) - System.currentTimeMillis(), 0);
    }

    public boolean bk(long j) {
        return j <= 0 || j > ((long) this.cuU);
    }

    public boolean bm(long j) {
        return j >= 0 && System.currentTimeMillis() - j >= ((long) this.cuW);
    }
}
