package com.jumio.analytics;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    private final List<Integer> mBlockedEvents = new ArrayList();

    public Filter disable(int i) {
        this.mBlockedEvents.add(Integer.valueOf(i));
        return this;
    }

    @SuppressLint({"UseValueOf"})
    public Filter enable(int i) {
        this.mBlockedEvents.remove(Integer.valueOf(i));
        return this;
    }

    public boolean contains(int i) {
        return this.mBlockedEvents.contains(Integer.valueOf(i));
    }
}
