package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.a;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.w;
import java.math.BigDecimal;
import java.util.Currency;

/* compiled from: InternalAppEventsLogger */
class g extends AppEventsLogger {
    g(Context context) {
        this(w.ae(context), null, null);
    }

    g(String str, String str2, a aVar) {
        super(str, str2, aVar);
    }

    protected void b(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        super.b(bigDecimal, currency, bundle);
    }

    protected void a(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        super.a(str, bigDecimal, currency, bundle);
    }
}
