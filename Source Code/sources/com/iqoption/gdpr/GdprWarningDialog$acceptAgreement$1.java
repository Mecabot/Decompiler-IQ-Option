package com.iqoption.gdpr;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
/* compiled from: GdprWarningDialog.kt */
final class GdprWarningDialog$acceptAgreement$1 extends Lambda implements b<Void, l> {
    final /* synthetic */ b this$0;

    GdprWarningDialog$acceptAgreement$1(b bVar) {
        this.this$0 = bVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((Void) obj);
        return l.etX;
    }

    public final void b(Void voidR) {
        com.iqoption.core.i.v(b.TAG, "gdpr accepted");
        if (this.this$0.zzakw() != null) {
            this.this$0.onClose();
        }
    }
}
