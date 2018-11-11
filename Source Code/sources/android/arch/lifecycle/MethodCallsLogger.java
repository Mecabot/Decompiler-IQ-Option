package android.arch.lifecycle;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP})
public class MethodCallsLogger {
    private Map<String, Integer> bq = new HashMap();

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean b(String str, int i) {
        Integer num = (Integer) this.bq.get(str);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        if ((intValue & i) != 0) {
            i2 = 1;
        }
        this.bq.put(str, Integer.valueOf(i | intValue));
        return i2 ^ 1;
    }
}
