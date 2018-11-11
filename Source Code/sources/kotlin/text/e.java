package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.f.f;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.sequences.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012+\u0010\b\u001a'\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n0\t¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0002R3\u0010\b\u001a'\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n0\t¢\u0006\u0002\b\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
/* compiled from: Strings.kt */
final class e implements h<f> {
    private final CharSequence eZm;
    private final m<CharSequence, Integer, Pair<Integer, Integer>> eZn;
    private final int limit;
    private final int startIndex;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, aXE = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    /* compiled from: Strings.kt */
    public static final class a implements Iterator<f>, kotlin.jvm.internal.a.a {
        private int counter;
        private int eYS = -1;
        private int eZo;
        private int eZp;
        private f eZq;
        final /* synthetic */ e eZr;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(e eVar) {
            this.eZr = eVar;
            this.eZo = j.B(eVar.startIndex, 0, eVar.eZm.length());
            this.eZp = this.eZo;
        }

        /* JADX WARNING: Missing block: B:6:0x0025, code:
            if (r6.counter < kotlin.text.e.a(r6.eZr)) goto L_0x0027;
     */
        private final void bAf() {
            /*
            r6 = this;
            r0 = r6.eZp;
            r1 = 0;
            if (r0 >= 0) goto L_0x000e;
        L_0x0005:
            r6.eYS = r1;
            r0 = 0;
            r0 = (kotlin.f.f) r0;
            r6.eZq = r0;
            goto L_0x00a4;
        L_0x000e:
            r0 = r6.eZr;
            r0 = r0.limit;
            r2 = -1;
            r3 = 1;
            if (r0 <= 0) goto L_0x0027;
        L_0x0018:
            r0 = r6.counter;
            r0 = r0 + r3;
            r6.counter = r0;
            r0 = r6.counter;
            r4 = r6.eZr;
            r4 = r4.limit;
            if (r0 >= r4) goto L_0x0035;
        L_0x0027:
            r0 = r6.eZp;
            r4 = r6.eZr;
            r4 = r4.eZm;
            r4 = r4.length();
            if (r0 <= r4) goto L_0x004b;
        L_0x0035:
            r0 = r6.eZo;
            r1 = new kotlin.f.f;
            r4 = r6.eZr;
            r4 = r4.eZm;
            r4 = kotlin.text.v.O(r4);
            r1.<init>(r0, r4);
            r6.eZq = r1;
            r6.eZp = r2;
            goto L_0x00a2;
        L_0x004b:
            r0 = r6.eZr;
            r0 = r0.eZn;
            r4 = r6.eZr;
            r4 = r4.eZm;
            r5 = r6.eZp;
            r5 = java.lang.Integer.valueOf(r5);
            r0 = r0.B(r4, r5);
            r0 = (kotlin.Pair) r0;
            if (r0 != 0) goto L_0x007b;
        L_0x0065:
            r0 = r6.eZo;
            r1 = new kotlin.f.f;
            r4 = r6.eZr;
            r4 = r4.eZm;
            r4 = kotlin.text.v.O(r4);
            r1.<init>(r0, r4);
            r6.eZq = r1;
            r6.eZp = r2;
            goto L_0x00a2;
        L_0x007b:
            r2 = r0.aXG();
            r2 = (java.lang.Number) r2;
            r2 = r2.intValue();
            r0 = r0.aXH();
            r0 = (java.lang.Number) r0;
            r0 = r0.intValue();
            r4 = r6.eZo;
            r4 = kotlin.f.j.bd(r4, r2);
            r6.eZq = r4;
            r2 = r2 + r0;
            r6.eZo = r2;
            r2 = r6.eZo;
            if (r0 != 0) goto L_0x009f;
        L_0x009e:
            r1 = 1;
        L_0x009f:
            r2 = r2 + r1;
            r6.eZp = r2;
        L_0x00a2:
            r6.eYS = r3;
        L_0x00a4:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.bAf():void");
        }

        /* renamed from: bAi */
        public f next() {
            if (this.eYS == -1) {
                bAf();
            }
            if (this.eYS == 0) {
                throw new NoSuchElementException();
            }
            f fVar = this.eZq;
            if (fVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.eZq = (f) null;
            this.eYS = -1;
            return fVar;
        }

        public boolean hasNext() {
            if (this.eYS == -1) {
                bAf();
            }
            return this.eYS == 1;
        }
    }

    public e(CharSequence charSequence, int i, int i2, m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.h.e(charSequence, "input");
        kotlin.jvm.internal.h.e(mVar, "getNextMatch");
        this.eZm = charSequence;
        this.startIndex = i;
        this.limit = i2;
        this.eZn = mVar;
    }

    public Iterator<f> iterator() {
        return new a(this);
    }
}
