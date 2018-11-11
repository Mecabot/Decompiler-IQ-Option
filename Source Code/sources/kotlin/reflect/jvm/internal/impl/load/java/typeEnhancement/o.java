package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.h;

/* compiled from: predefinedEnhancementInfo.kt */
public final class o {
    private final Map<Integer, d> map;

    public o(Map<Integer, d> map) {
        h.e(map, "map");
        this.map = map;
    }

    public final Map<Integer, d> aSg() {
        return this.map;
    }
}
