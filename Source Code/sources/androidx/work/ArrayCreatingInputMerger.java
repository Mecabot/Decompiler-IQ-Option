package androidx.work;

import android.support.annotation.NonNull;
import androidx.work.Data.a;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ArrayCreatingInputMerger extends d {
    @NonNull
    public Data b(@NonNull List<Data> list) {
        a aVar = new a();
        Map hashMap = new HashMap();
        for (Data aQ : list) {
            for (Entry entry : aQ.aQ().entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class cls = value.getClass();
                if (hashMap.containsKey(str)) {
                    Object obj = hashMap.get(str);
                    Class cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        if (cls2.isArray()) {
                            value = concatenateArrays(obj, value);
                        } else {
                            value = b(obj, value);
                        }
                    } else if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                        value = c(obj, value);
                    } else if (cls.isArray() && cls.getComponentType().equals(cls2)) {
                        value = c(value, obj);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (!cls.isArray()) {
                    value = g(value);
                }
                hashMap.put(str, value);
            }
        }
        aVar.b(hashMap);
        return aVar.aR();
    }

    private Object concatenateArrays(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    private Object b(Object obj, Object obj2) {
        Object newInstance = Array.newInstance(obj.getClass(), 2);
        Array.set(newInstance, 0, obj);
        Array.set(newInstance, 1, obj2);
        return newInstance;
    }

    private Object c(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj2.getClass(), length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        return newInstance;
    }

    private Object g(Object obj) {
        Object newInstance = Array.newInstance(obj.getClass(), 1);
        Array.set(newInstance, 0, obj);
        return newInstance;
    }
}
