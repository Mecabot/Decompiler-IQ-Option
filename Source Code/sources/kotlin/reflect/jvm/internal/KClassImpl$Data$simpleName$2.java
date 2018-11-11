package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "T", "", "invoke"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$simpleName$2 extends Lambda implements a<String> {
    final /* synthetic */ i.a this$0;

    KClassImpl$Data$simpleName$2(i.a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: PM */
    public final String invoke() {
        if (i.this.aXV().isAnonymousClass()) {
            return null;
        }
        String a;
        kotlin.reflect.jvm.internal.impl.name.a a2 = i.this.getClassId();
        if (a2.isLocal()) {
            a = this.this$0.I(i.this.aXV());
        } else {
            a = a2.btH().asString();
            h.d(a, "classId.shortClassName.asString()");
        }
        return a;
    }
}
