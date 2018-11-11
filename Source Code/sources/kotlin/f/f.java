package kotlin.f;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, aXE = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
/* compiled from: Ranges.kt */
public final class f extends d implements c<Integer> {
    private static final f euI = new f(1, 0);
    public static final a euJ = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
    /* compiled from: Ranges.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final f aYm() {
            return f.euI;
        }
    }

    public f(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer aYj() {
        return Integer.valueOf(getFirst());
    }

    public Integer aYk() {
        return Integer.valueOf(getLast());
    }

    public boolean contains(int i) {
        return getFirst() <= i && i <= getLast();
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    /* JADX WARNING: Missing block: B:9:0x0027, code:
            if (getLast() == r3.getLast()) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        r0 = r3 instanceof kotlin.f.f;
        if (r0 == 0) goto L_0x002b;
    L_0x0004:
        r0 = r2.isEmpty();
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r3;
        r0 = (kotlin.f.f) r0;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0029;
    L_0x0013:
        r0 = r2.getFirst();
        r3 = (kotlin.f.f) r3;
        r1 = r3.getFirst();
        if (r0 != r1) goto L_0x002b;
    L_0x001f:
        r0 = r2.getLast();
        r3 = r3.getLast();
        if (r0 != r3) goto L_0x002b;
    L_0x0029:
        r3 = 1;
        goto L_0x002c;
    L_0x002b:
        r3 = 0;
    L_0x002c:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.f.f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return isEmpty() ? -1 : (getFirst() * 31) + getLast();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getFirst());
        stringBuilder.append("..");
        stringBuilder.append(getLast());
        return stringBuilder.toString();
    }
}
