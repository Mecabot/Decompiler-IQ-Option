package kotlin.reflect.jvm.internal.impl.types;

import com.google.android.gms.plus.PlusShare;
import kotlin.jvm.internal.h;

/* compiled from: Variance.kt */
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    protected Variance(String str, boolean z, boolean z2, int i) {
        h.e(str, PlusShare.KEY_CALL_TO_ACTION_LABEL);
        this.label = str;
        this.allowsInPosition = z;
        this.allowsOutPosition = z2;
        this.superpositionFactor = i;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public String toString() {
        return this.label;
    }
}
