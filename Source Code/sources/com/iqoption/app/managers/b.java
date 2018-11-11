package com.iqoption.app.managers;

import java.util.HashSet;
import java.util.Set;

/* compiled from: LockCounter */
public class b {
    private Set<Object> amo = new HashSet();

    public void aY(Object obj) {
        this.amo.add(obj);
    }

    public boolean aZ(Object obj) {
        this.amo.remove(obj);
        return this.amo.isEmpty();
    }

    public boolean isEmpty() {
        return this.amo.isEmpty();
    }

    public void clear() {
        this.amo.clear();
    }

    public long size() {
        return (long) this.amo.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LockCounter{lockTags=");
        stringBuilder.append(this.amo);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
