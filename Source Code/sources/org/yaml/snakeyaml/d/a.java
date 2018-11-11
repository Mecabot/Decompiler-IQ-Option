package org.yaml.snakeyaml.d;

import java.util.ArrayList;

/* compiled from: ArrayStack */
public class a<T> {
    private ArrayList<T> fks;

    public a(int i) {
        this.fks = new ArrayList(i);
    }

    public void push(T t) {
        this.fks.add(t);
    }

    public T pop() {
        return this.fks.remove(this.fks.size() - 1);
    }

    public boolean isEmpty() {
        return this.fks.isEmpty();
    }
}
