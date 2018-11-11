package androidx.work.impl.workers;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.Worker;
import androidx.work.Worker.Result;

@RestrictTo({Scope.LIBRARY_GROUP})
public class CombineContinuationsWorker extends Worker {
    @NonNull
    public Result bh() {
        c(bg());
        return Result.SUCCESS;
    }
}
