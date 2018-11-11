package com.iqoption.sessions;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog.Builder;
import com.iqoption.core.ext.a;
import com.iqoption.core.microservices.a.a.b;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "sessions", "", "Lcom/iqoption/core/microservices/auth/response/Session;", "all", "", "invoke"})
/* compiled from: ActiveSessionsFragment.kt */
final class ActiveSessionsFragment$onCreateView$2 extends Lambda implements m<List<? extends b>, Boolean, l> {
    final /* synthetic */ b this$0;

    ActiveSessionsFragment$onCreateView$2(b bVar) {
        this.this$0 = bVar;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        c((List) obj, ((Boolean) obj2).booleanValue());
        return l.etX;
    }

    public final void c(final List<b> list, boolean z) {
        h.e(list, "sessions");
        Builder builder = new Builder(a.n(this.this$0), R.style.AppCompatAlertDialogStyle);
        int i = z ? R.string.terminate_sessions : R.string.terminate_session;
        int i2 = z ? R.string.are_you_sure_to_terminate_all_sessions : R.string.are_you_sure_to_terminate_session;
        builder.setTitle(i);
        builder.setMessage(i2);
        builder.setPositiveButton((int) R.string.terminate, (OnClickListener) new OnClickListener(this) {
            final /* synthetic */ ActiveSessionsFragment$onCreateView$2 dqQ;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.dqQ.this$0.bj(list);
            }
        });
        builder.create().show();
    }
}
