package androidx.work.impl;

import android.net.Network;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.Data;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestrictTo({Scope.LIBRARY_GROUP})
public class Extras {
    @NonNull
    private Set<String> dX;
    @NonNull
    private Data ec;
    @Nullable
    private a ed;
    private int ee;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class a {
        public String[] ef;
        public Uri[] eg;
        @RequiresApi(28)
        public Network eh;
    }

    public Extras(@NonNull Data data, @NonNull List<String> list, @Nullable a aVar, int i) {
        this.ec = data;
        this.dX = new HashSet(list);
        this.ed = aVar;
        this.ee = i;
    }

    @NonNull
    public Data bg() {
        return this.ec;
    }
}
