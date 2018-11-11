package kotlin.text;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, aXE = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"})
/* compiled from: Regex.kt */
public final class f {
    private final kotlin.f.f eZs;
    private final String value;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.eZs, r3.eZs) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof kotlin.text.f;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (kotlin.text.f) r3;
        r0 = r2.value;
        r1 = r3.value;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.eZs;
        r3 = r3.eZs;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001f;
    L_0x001d:
        r3 = 0;
        return r3;
    L_0x001f:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.value;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.f.f fVar = this.eZs;
        if (fVar != null) {
            i = fVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MatchGroup(value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", range=");
        stringBuilder.append(this.eZs);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(String str, kotlin.f.f fVar) {
        h.e(str, b.VALUE);
        h.e(fVar, "range");
        this.value = str;
        this.eZs = fVar;
    }
}
