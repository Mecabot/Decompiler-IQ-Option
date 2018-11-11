package androidx.work;

import android.support.annotation.NonNull;
import androidx.work.Data.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OverwritingInputMerger extends d {
    @NonNull
    public Data b(@NonNull List<Data> list) {
        a aVar = new a();
        Map hashMap = new HashMap();
        for (Data aQ : list) {
            hashMap.putAll(aQ.aQ());
        }
        aVar.b(hashMap);
        return aVar.aR();
    }
}
