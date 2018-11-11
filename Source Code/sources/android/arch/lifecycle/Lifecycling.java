package android.arch.lifecycle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP})
public class Lifecycling {
    private static Map<Class, Integer> bf = new HashMap();
    private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> bg = new HashMap();

    @NonNull
    static GenericLifecycleObserver d(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class cls = obj.getClass();
        if (e(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) bg.get(cls);
        int i = 0;
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        while (i < list.size()) {
            generatedAdapterArr[i] = a((Constructor) list.get(i), obj);
            i++;
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private static GeneratedAdapter a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(new Object[]{obj});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
    }

    @Nullable
    private static Constructor<? extends GeneratedAdapter> d(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            canonicalName = f(canonicalName);
            if (!name.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                stringBuilder.append(".");
                stringBuilder.append(canonicalName);
                canonicalName = stringBuilder.toString();
            }
            Constructor<? extends GeneratedAdapter> declaredConstructor = Class.forName(canonicalName).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static int e(Class<?> cls) {
        if (bf.containsKey(cls)) {
            return ((Integer) bf.get(cls)).intValue();
        }
        int f = f((Class) cls);
        bf.put(cls, Integer.valueOf(f));
        return f;
    }

    private static int f(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor d = d((Class) cls);
        if (d != null) {
            bg.put(cls, Collections.singletonList(d));
            return 2;
        } else if (ClassesInfoCache.ax.a(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            Object obj = null;
            if (g(superclass)) {
                if (e(superclass) == 1) {
                    return 1;
                }
                obj = new ArrayList((Collection) bg.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (g(cls2)) {
                    if (e(cls2) == 1) {
                        return 1;
                    }
                    if (obj == null) {
                        obj = new ArrayList();
                    }
                    obj.addAll((Collection) bg.get(cls2));
                }
            }
            if (obj == null) {
                return 1;
            }
            bg.put(cls, obj);
            return 2;
        }
    }

    private static boolean g(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    public static String f(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.replace(".", "_"));
        stringBuilder.append("_LifecycleAdapter");
        return stringBuilder.toString();
    }
}
