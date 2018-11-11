package com.jumio.nv.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.mvp.model.StaticModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

@PersistWith("BackendModel")
public class BackendModel implements StaticModel {
    private HashMap<Class<?>, Serializable> a = new LinkedHashMap();

    public void add(Class<?> cls, Serializable serializable) {
        this.a.put(cls, serializable);
    }

    public boolean has(Class<?> cls) {
        return this.a.containsKey(cls);
    }

    public Object get(Class<?> cls) {
        return this.a.get(cls);
    }

    public void remove(Class<?> cls) {
        this.a.remove(cls);
    }

    public void clear() {
        this.a.clear();
    }
}
