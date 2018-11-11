package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.EventBinding.ActionType;
import com.facebook.appevents.codeless.internal.d;
import com.facebook.appevents.internal.b;
import com.facebook.h;
import java.lang.ref.WeakReference;

/* compiled from: CodelessLoggingEventListener */
public class a {
    private static final String TAG = a.class.getCanonicalName();

    /* compiled from: CodelessLoggingEventListener */
    public static class a extends AccessibilityDelegate {
        private EventBinding zA;
        private WeakReference<View> zB;
        private WeakReference<View> zC;
        private int zD;
        private AccessibilityDelegate zE;
        private boolean zF = false;
        protected boolean zG = false;

        public a(EventBinding eventBinding, View view, View view2) {
            if (eventBinding != null && view != null && view2 != null) {
                this.zE = d.o(view2);
                this.zA = eventBinding;
                this.zB = new WeakReference(view2);
                this.zC = new WeakReference(view);
                ActionType kE = eventBinding.kE();
                switch (eventBinding.kE()) {
                    case CLICK:
                        this.zD = 1;
                        break;
                    case SELECTED:
                        this.zD = 4;
                        break;
                    case TEXT_CHANGED:
                        this.zD = 16;
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported action type: ");
                        stringBuilder.append(kE.toString());
                        throw new FacebookException(stringBuilder.toString());
                }
                this.zF = true;
            }
        }

        public void sendAccessibilityEvent(View view, int i) {
            if (i == -1) {
                Log.e(a.TAG, "Unsupported action type");
            }
            if (i == this.zD) {
                if (!(this.zE == null || (this.zE instanceof a))) {
                    this.zE.sendAccessibilityEvent(view, i);
                }
                kt();
            }
        }

        private void kt() {
            final String gF = this.zA.gF();
            final Bundle b = b.b(this.zA, (View) this.zC.get(), (View) this.zB.get());
            if (b.containsKey("_valueToSum")) {
                b.putDouble("_valueToSum", b.bv(b.getString("_valueToSum")));
            }
            b.putString("_is_fb_codeless", "1");
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    AppEventsLogger.T(h.getApplicationContext()).logEvent(gF, b);
                }
            });
        }

        public boolean ku() {
            return this.zF;
        }

        public boolean kv() {
            return this.zG;
        }
    }

    public static a a(EventBinding eventBinding, View view, View view2) {
        return new a(eventBinding, view, view2);
    }
}
