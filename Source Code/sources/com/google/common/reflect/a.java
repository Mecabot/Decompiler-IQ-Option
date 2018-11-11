package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

/* compiled from: Element */
class a extends AccessibleObject implements Member {
    private final AccessibleObject Vg;
    private final Member member;

    public TypeToken<?> vr() {
        return TypeToken.t(getDeclaringClass());
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.Vg.isAnnotationPresent(cls);
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.Vg.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.Vg.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.Vg.getDeclaredAnnotations();
    }

    public final void setAccessible(boolean z) {
        this.Vg.setAccessible(z);
    }

    public final boolean isAccessible() {
        return this.Vg.isAccessible();
    }

    public Class<?> getDeclaringClass() {
        return this.member.getDeclaringClass();
    }

    public final String getName() {
        return this.member.getName();
    }

    public final int getModifiers() {
        return this.member.getModifiers();
    }

    public final boolean isSynthetic() {
        return this.member.isSynthetic();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (vr().equals(aVar.vr()) && this.member.equals(aVar.member)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.member.hashCode();
    }

    public String toString() {
        return this.member.toString();
    }
}
