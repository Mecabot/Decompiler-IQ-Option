package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.support.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ClassesInfoCache {
    static ClassesInfoCache ax = new ClassesInfoCache();
    private final Map<Class, CallbackInfo> ay = new HashMap();
    private final Map<Class, Boolean> az = new HashMap();

    static class CallbackInfo {
        final Map<Event, List<MethodReference>> aA = new HashMap();
        final Map<MethodReference, Event> aB;

        CallbackInfo(Map<MethodReference, Event> map) {
            this.aB = map;
            for (Entry entry : map.entrySet()) {
                Event event = (Event) entry.getValue();
                List list = (List) this.aA.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.aA.put(event, list);
                }
                list.add(entry.getKey());
            }
        }

        void a(LifecycleOwner lifecycleOwner, Event event, Object obj) {
            a((List) this.aA.get(event), lifecycleOwner, event, obj);
            a((List) this.aA.get(Event.ON_ANY), lifecycleOwner, event, obj);
        }

        private static void a(List<MethodReference> list, LifecycleOwner lifecycleOwner, Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((MethodReference) list.get(size)).b(lifecycleOwner, event, obj);
                }
            }
        }
    }

    static class MethodReference {
        final int aC;
        final Method mMethod;

        MethodReference(int i, Method method) {
            this.aC = i;
            this.mMethod = method;
            this.mMethod.setAccessible(true);
        }

        void b(LifecycleOwner lifecycleOwner, Event event, Object obj) {
            try {
                switch (this.aC) {
                    case 0:
                        this.mMethod.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.mMethod.invoke(obj, new Object[]{lifecycleOwner});
                        return;
                    case 2:
                        this.mMethod.invoke(obj, new Object[]{lifecycleOwner, event});
                        return;
                    default:
                        return;
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            if (!(this.aC == methodReference.aC && this.mMethod.getName().equals(methodReference.mMethod.getName()))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.aC * 31) + this.mMethod.getName().hashCode();
        }
    }

    ClassesInfoCache() {
    }

    boolean a(Class cls) {
        if (this.az.containsKey(cls)) {
            return ((Boolean) this.az.get(cls)).booleanValue();
        }
        Method[] b = b(cls);
        for (Method annotation : b) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, b);
                return true;
            }
        }
        this.az.put(cls, Boolean.valueOf(false));
        return false;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Throwable e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    CallbackInfo c(Class cls) {
        CallbackInfo callbackInfo = (CallbackInfo) this.ay.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return a(cls, null);
    }

    private void a(Map<MethodReference, Event> map, MethodReference methodReference, Event event, Class cls) {
        Event event2 = (Event) map.get(methodReference);
        if (event2 != null && event != event2) {
            Method method = methodReference.mMethod;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(method.getName());
            stringBuilder.append(" in ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
            stringBuilder.append(event2);
            stringBuilder.append(", new value ");
            stringBuilder.append(event);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    private CallbackInfo a(Class cls, @Nullable Method[] methodArr) {
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            CallbackInfo c = c(superclass);
            if (c != null) {
                hashMap.putAll(c.aB);
            }
        }
        for (Class c2 : cls.getInterfaces()) {
            for (Entry entry : c(c2).aB.entrySet()) {
                a(hashMap, (MethodReference) entry.getKey(), (Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                int i;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Event R = onLifecycleEvent.R();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (R != Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new MethodReference(i, method), R, cls);
                z = true;
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.ay.put(cls, callbackInfo);
        this.az.put(cls, Boolean.valueOf(z));
        return callbackInfo;
    }
}
