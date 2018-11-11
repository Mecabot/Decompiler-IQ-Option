package com.iqoption.gdpr;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "error", "", "invoke"})
/* compiled from: GdprWarningDialog.kt */
final class GdprWarningDialog$acceptAgreement$2 extends Lambda implements b<Throwable, l> {
    final /* synthetic */ b this$0;

    GdprWarningDialog$acceptAgreement$2(b bVar) {
        this.this$0 = bVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return l.etX;
    }

    public final void q(Throwable th) {
        com.iqoption.core.i.e(b.TAG, "Unable to accept gdpr", th);
        this.this$0.dG(false);
        com.iqoption.app.a.b.FG();
    }
}
