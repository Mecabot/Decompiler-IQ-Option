package com.iqoption.deposit.light;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.view.Window;
import com.iqoption.core.util.q;
import com.iqoption.deposit.pro.b;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.ArrayList;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/deposit/light/LightDepositActivity;", "Lcom/iqoption/deposit/pro/ProDepositActivity;", "()V", "systemUiHider", "Lcom/iqoption/util/KeyboardUtil$SystemUiHider;", "finish", "", "isDarkDeposit", "", "isFullScreen", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "prepareWindow", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LightDepositActivity.kt */
public final class LightDepositActivity extends b {
    public static final a caA = new a();
    private am.b adL;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJE\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, aXE = {"Lcom/iqoption/deposit/light/LightDepositActivity$Companion;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "defaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "returnToParent", "", "paymentMethodId", "", "(Landroid/content/Context;Ljava/util/ArrayList;ZLjava/lang/Long;)Landroid/content/Intent;", "start", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Ljava/util/ArrayList;ZLjava/lang/Long;)V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LightDepositActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* bridge */ /* synthetic */ void a(a aVar, Activity activity, ArrayList arrayList, boolean z, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                l = (Long) null;
            }
            aVar.a(activity, arrayList, z, l);
        }

        public final void a(Activity activity, ArrayList<com.iqoption.core.c.c.a> arrayList, boolean z, Long l) {
            h.e(activity, "activity");
            try {
                activity.startActivity(a((Context) activity, (ArrayList) arrayList, z, l), ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle());
            } catch (Throwable th) {
                com.iqoption.core.i.e("Unable to start deposit", th);
                com.crashlytics.android.a.c(th);
            }
        }

        private final Intent a(Context context, ArrayList<com.iqoption.core.c.c.a> arrayList, boolean z, Long l) {
            Intent intent = new Intent(context, LightDepositActivity.class);
            intent.putExtra("ARG_RETURN_TO_PARENT", z);
            if (l != null) {
                intent.putExtra("ARG_PAYMENT_METHOD_ID", l.longValue());
            }
            intent.putParcelableArrayListExtra("ARG_DEFAULT_PRESET", arrayList);
            return intent;
        }
    }

    protected boolean aci() {
        return false;
    }

    /* JADX WARNING: Missing block: B:3:0x0024, code:
            if (r4 != null) goto L_0x0029;
     */
    protected void onCreate(android.os.Bundle r4) {
        /*
        r3 = this;
        r3.adf();
        super.onCreate(r4);
        r4 = r3.adY();
        r4 = r4.biJ;
        r0 = 2131099887; // 0x7f0600ef float:1.781214E38 double:1.052903242E-314;
        r0 = com.iqoption.core.ext.a.i(r3, r0);
        r4.setBackgroundColor(r0);
        r4 = com.iqoption.app.managers.feature.b.HT();
        r0 = "experimental-deposit-page";
        r4 = r4.fd(r0);
        if (r4 == 0) goto L_0x0027;
    L_0x0022:
        r4 = r4.status;
        if (r4 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r4 = "disabled";
    L_0x0029:
        r0 = r4.hashCode();
        r1 = -2059248520; // 0xffffffff85425c78 float:-9.13882E-36 double:NaN;
        if (r0 == r1) goto L_0x0051;
    L_0x0032:
        r1 = -1619565966; // 0xffffffff9f776272 float:-5.2385717E-20 double:NaN;
        if (r0 == r1) goto L_0x0047;
    L_0x0037:
        r1 = 1631266500; // 0x613b26c4 float:2.157709E20 double:8.05952737E-315;
        if (r0 == r1) goto L_0x003d;
    L_0x003c:
        goto L_0x005e;
    L_0x003d:
        r0 = "light-landscape";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x005e;
    L_0x0045:
        r4 = 6;
        goto L_0x005a;
    L_0x0047:
        r0 = "light-portrait";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x005e;
    L_0x004f:
        r4 = 7;
        goto L_0x005a;
    L_0x0051:
        r0 = "light-both-mode";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x005e;
    L_0x0059:
        r4 = 4;
    L_0x005a:
        r3.setRequestedOrientation(r4);
        return;
    L_0x005e:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected status: ";
        r1.append(r2);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        r0 = (java.lang.Throwable) r0;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.light.LightDepositActivity.onCreate(android.os.Bundle):void");
    }

    private final void adf() {
        Window window;
        View decorView;
        if (isFullScreen()) {
            getWindow().setFlags(1024, 1024);
            window = getWindow();
            h.d(window, "window");
            decorView = window.getDecorView();
            h.d(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1280);
            am.b u = am.u(this);
            u.aGp();
            u.register();
            this.adL = u;
            return;
        }
        getWindow().clearFlags(1024);
        window = getWindow();
        h.d(window, "window");
        decorView = window.getDecorView();
        h.d(decorView, "window.decorView");
        decorView.setSystemUiVisibility(256);
        this.adL = (am.b) null;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        am.b bVar = this.adL;
        if (bVar == null) {
            return;
        }
        if (z) {
            bVar.register();
        } else {
            bVar.unregister();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected boolean isFullScreen() {
        return q.a(getResources());
    }
}
