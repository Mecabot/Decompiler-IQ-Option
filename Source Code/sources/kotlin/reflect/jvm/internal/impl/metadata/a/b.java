package kotlin.reflect.jvm.internal.impl.metadata.a;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;

/* compiled from: Flags */
public class b {
    public static final a eLA = c.a(eLz);
    public static final a eLB = c.a(eLA);
    public static final a eLC = c.a(eLB);
    public static final a eLD = c.a(eLC);
    public static final a eLE = c.a(eLD);
    public static final a eLF = c.a(eLE);
    public static final a eLG = c.a(eLF);
    public static final a eLH = c.a(eLG);
    public static final a eLI = c.a(eLh);
    public static final a eLJ = c.a(eLI);
    public static final a eLK = c.a(eLJ);
    public static final a eLL = c.a(eLj);
    public static final a eLM = c.a(eLL);
    public static final a eLN = c.a(eLM);
    public static final a eLO = c.bre();
    public static final a eLP = c.a(eLO);
    public static final a eLQ = c.bre();
    public static final a eLg = c.bre();
    public static final a eLh = c.bre();
    public static final c<Visibility> eLi = c.a(eLh, Visibility.values());
    public static final c<Modality> eLj = c.a(eLi, Modality.values());
    public static final c<Kind> eLk = c.a(eLj, Kind.values());
    public static final a eLl = c.a(eLk);
    public static final a eLm = c.a(eLl);
    public static final a eLn = c.a(eLm);
    public static final a eLo = c.a(eLn);
    public static final a eLp = c.a(eLo);
    public static final a eLq = c.a(eLi);
    public static final c<MemberKind> eLr = c.a(eLj, MemberKind.values());
    public static final a eLs = c.a(eLr);
    public static final a eLt = c.a(eLs);
    public static final a eLu = c.a(eLt);
    public static final a eLv = c.a(eLu);
    public static final a eLw = c.a(eLv);
    public static final a eLx = c.a(eLw);
    public static final a eLy = c.a(eLx);
    public static final a eLz = c.a(eLr);

    /* compiled from: Flags */
    public static abstract class c<E> {
        public final int eLS;
        public final int offset;

        public abstract E get(int i);

        public static <E extends kotlin.reflect.jvm.internal.impl.protobuf.h.a> c<E> a(c<?> cVar, E[] eArr) {
            return new b(cVar.offset + cVar.eLS, eArr);
        }

        public static a bre() {
            return new a(0);
        }

        public static a a(c<?> cVar) {
            return new a(cVar.offset + cVar.eLS);
        }

        private c(int i, int i2) {
            this.offset = i;
            this.eLS = i2;
        }
    }

    /* compiled from: Flags */
    public static class a extends c<Boolean> {
        public a(int i) {
            super(i, 1);
        }

        /* renamed from: lc */
        public Boolean get(int i) {
            boolean z = true;
            if ((i & (1 << this.offset)) == 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: Flags */
    private static class b<E extends kotlin.reflect.jvm.internal.impl.protobuf.h.a> extends c<E> {
        private final E[] eLR;

        public b(int i, E[] eArr) {
            super(i, O(eArr));
            this.eLR = eArr;
        }

        private static <E> int O(E[] eArr) {
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Empty enum: ");
            stringBuilder.append(eArr.getClass());
            throw new IllegalStateException(stringBuilder.toString());
        }

        /* renamed from: ld */
        public E get(int i) {
            i = (i & (((1 << this.eLS) - 1) << this.offset)) >> this.offset;
            for (E e : this.eLR) {
                if (e.getNumber() == i) {
                    return e;
                }
            }
            return null;
        }
    }
}
