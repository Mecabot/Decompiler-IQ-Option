package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.f.b;
import kotlin.reflect.jvm.internal.f.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.l;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImpl$_javaField$1 extends Lambda implements a<Field> {
    final /* synthetic */ s this$0;

    KPropertyImpl$_javaField$1(s sVar) {
        this.this$0 = sVar;
        super(0);
    }

    /* renamed from: aZV */
    public final Field invoke() {
        f d = ac.ewF.d(this.this$0.aYM());
        Field field = null;
        if (d instanceof c) {
            c cVar = (c) d;
            ad aYF = cVar.aYF();
            f.a a = j.eMR.a(cVar.aYG(), cVar.aYI(), cVar.aYJ());
            if (a != null) {
                Class enclosingClass;
                if (l.e(aYF) || j.g(cVar.aYG())) {
                    enclosingClass = this.this$0.aYP().aXV().getEnclosingClass();
                } else {
                    k bbv = aYF.bbv();
                    if (bbv instanceof d) {
                        enclosingClass = ae.a((d) bbv);
                    } else {
                        enclosingClass = this.this$0.aYP().aXV();
                    }
                }
                if (enclosingClass != null) {
                    try {
                        field = enclosingClass.getDeclaredField(a.getName());
                    } catch (NoSuchFieldException unused) {
                        return field;
                    }
                }
            }
        } else if (d instanceof f.a) {
            field = ((f.a) d).getField();
        } else if (!((d instanceof b) || (d instanceof f.d))) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
