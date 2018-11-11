package com.iqoption.sessions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.iqoption.activity.b;
import com.iqoption.dto.ToastEntity;
import com.iqoption.operations.c;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\n"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsActivity;", "Lcom/iqoption/activity/IQActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveSessionsActivity.kt */
public final class ActiveSessionsActivity extends b {
    private static final String TAG = "javaClass";
    public static final a dqA = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsActivity$Companion;", "", "()V", "TAG", "", "startActivity", "", "activity", "Landroid/app/Activity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveSessionsActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void l(Activity activity) {
            h.e(activity, "activity");
            activity.startActivity(new Intent(activity, ActiveSessionsActivity.class));
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.sessions_activity);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new b(), c.cXk.Ll()).commitAllowingStateLoss();
        }
    }

    protected void onStart() {
        super.onStart();
        WebSocketHandler.aDm().bE(TAG);
    }

    protected void onStop() {
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        super.onStop();
    }
}
