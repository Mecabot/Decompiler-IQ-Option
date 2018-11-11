package com.facebook.marketing.internal;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.appevents.codeless.internal.d;
import com.facebook.h;

/* compiled from: ButtonIndexingEventListener */
public class b {
    private static final String TAG = b.class.getCanonicalName();

    /* compiled from: ButtonIndexingEventListener */
    public static class a extends com.facebook.appevents.codeless.a.a {
        private String Hn;
        @Nullable
        private AccessibilityDelegate zE;

        public a(View view, String str) {
            if (view != null) {
                this.zE = d.o(view);
                this.Hn = str;
                this.zG = true;
            }
        }

        public void sendAccessibilityEvent(final View view, int i) {
            if (i == -1) {
                Log.e(b.TAG, "Unsupported action type");
            }
            if (!(this.zE == null || (this.zE instanceof a))) {
                this.zE.sendAccessibilityEvent(view, i);
            }
            final String str = this.Hn;
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    c.a(h.it(), view, str, h.getApplicationContext());
                }
            });
        }
    }

    public static a b(View view, String str) {
        return new a(view, str);
    }
}
