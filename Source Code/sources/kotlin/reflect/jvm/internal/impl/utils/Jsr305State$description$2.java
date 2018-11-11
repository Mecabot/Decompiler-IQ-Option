package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import kotlin.TypeCastException;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

/* compiled from: Jsr305State.kt */
final class Jsr305State$description$2 extends Lambda implements a<String[]> {
    final /* synthetic */ e this$0;

    Jsr305State$description$2(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    /* renamed from: Mh */
    public final String[] invoke() {
        List arrayList = new ArrayList();
        arrayList.add(this.this$0.bzB().getDescription());
        ReportLevel bzC = this.this$0.bzC();
        if (bzC != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("under-migration:");
            stringBuilder.append(bzC.getDescription());
            arrayList.add(stringBuilder.toString());
        }
        for (Entry entry : this.this$0.bzD().entrySet()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('@');
            stringBuilder2.append((String) entry.getKey());
            stringBuilder2.append(':');
            stringBuilder2.append(((ReportLevel) entry.getValue()).getDescription());
            arrayList.add(stringBuilder2.toString());
        }
        Object[] toArray = arrayList.toArray(new String[0]);
        if (toArray != null) {
            return (String[]) toArray;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
