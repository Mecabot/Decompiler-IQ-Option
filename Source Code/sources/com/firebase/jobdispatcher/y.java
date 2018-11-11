package com.firebase.jobdispatcher;

import android.support.annotation.NonNull;
import com.firebase.jobdispatcher.u.a;
import com.firebase.jobdispatcher.u.b;
import com.firebase.jobdispatcher.u.c;
import java.util.List;

/* compiled from: Trigger */
public final class y {
    public static final c KT = new c();

    public static b r(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Window start can't be less than 0");
        } else if (i2 >= i) {
            return new b(i, i2);
        } else {
            throw new IllegalArgumentException("Window end can't be less than window start");
        }
    }

    public static a t(@NonNull List<w> list) {
        if (list != null && !list.isEmpty()) {
            return new a(list);
        }
        throw new IllegalArgumentException("Uris must not be null or empty.");
    }
}
