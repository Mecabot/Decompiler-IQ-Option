package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: TypeProjectionImpl */
public class ar extends aq {
    private final Variance eVh;
    private final w ewu;

    public boolean bze() {
        return false;
    }

    public ar(Variance variance, w wVar) {
        this.eVh = variance;
        this.ewu = wVar;
    }

    public ar(w wVar) {
        this(Variance.INVARIANT, wVar);
    }

    public Variance bzf() {
        return this.eVh;
    }

    public w bai() {
        return this.ewu;
    }
}
