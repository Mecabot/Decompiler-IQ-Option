package com.iqoption.activity;

import android.os.Bundle;
import com.iqoption.util.am;
import com.iqoption.util.am.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, aXE = {"Lcom/iqoption/activity/IQFullScreenActivity;", "Lcom/iqoption/activity/IQActivity;", "()V", "systemUiHider", "Lcom/iqoption/util/KeyboardUtil$SystemUiHider;", "getSystemUiHider", "()Lcom/iqoption/util/KeyboardUtil$SystemUiHider;", "setSystemUiHider", "(Lcom/iqoption/util/KeyboardUtil$SystemUiHider;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: IQFullScreenActivity.kt */
public abstract class d extends b {
    public b adL;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b u = am.u(this);
        h.d(u, "KeyboardUtil.newSystemUiHider(this)");
        this.adL = u;
        u = this.adL;
        if (u == null) {
            h.lS("systemUiHider");
        }
        u.aGp();
        u = this.adL;
        if (u == null) {
            h.lS("systemUiHider");
        }
        u.register();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onWindowFocusChanged hasFocus=");
        stringBuilder.append(z);
        com.iqoption.core.i.d(stringBuilder.toString());
        b bVar;
        if (z) {
            bVar = this.adL;
            if (bVar == null) {
                h.lS("systemUiHider");
            }
            bVar.register();
            return;
        }
        bVar = this.adL;
        if (bVar == null) {
            h.lS("systemUiHider");
        }
        bVar.unregister();
    }
}
