package com.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath */
public class e {
    private final List<String> keys;
    @Nullable
    private f mo;

    public e(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.keys = new ArrayList(eVar.keys);
        this.mo = eVar.mo;
    }

    @RestrictTo({Scope.LIBRARY})
    @CheckResult
    public e af(String str) {
        e eVar = new e(this);
        eVar.keys.add(str);
        return eVar;
    }

    @RestrictTo({Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.mo = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY})
    public f dU() {
        return this.mo;
    }

    @RestrictTo({Scope.LIBRARY})
    public boolean f(String str, int i) {
        if (ag(str)) {
            return true;
        }
        if (i >= this.keys.size()) {
            return false;
        }
        if (((String) this.keys.get(i)).equals(str) || ((String) this.keys.get(i)).equals("**") || ((String) this.keys.get(i)).equals("*")) {
            return true;
        }
        return false;
    }

    @RestrictTo({Scope.LIBRARY})
    public int g(String str, int i) {
        if (ag(str)) {
            return 0;
        }
        if (!((String) this.keys.get(i)).equals("**")) {
            return 1;
        }
        if (i != this.keys.size() - 1 && ((String) this.keys.get(i + 1)).equals(str)) {
            return 2;
        }
        return 0;
    }

    @RestrictTo({Scope.LIBRARY})
    public boolean h(String str, int i) {
        boolean z = false;
        if (i >= this.keys.size()) {
            return false;
        }
        Object obj = i == this.keys.size() - 1 ? 1 : null;
        String str2 = (String) this.keys.get(i);
        if (str2.equals("**")) {
            Object obj2 = (obj == null && ((String) this.keys.get(i + 1)).equals(str)) ? 1 : null;
            if (obj2 != null) {
                if (i == this.keys.size() - 2 || (i == this.keys.size() - 3 && dV())) {
                    z = true;
                }
                return z;
            } else if (obj != null) {
                return true;
            } else {
                i++;
                if (i < this.keys.size() - 1) {
                    return false;
                }
                return ((String) this.keys.get(i)).equals(str);
            }
        }
        Object obj3 = (str2.equals(str) || str2.equals("*")) ? 1 : null;
        if ((obj != null || (i == this.keys.size() - 2 && dV())) && obj3 != null) {
            z = true;
        }
        return z;
    }

    @RestrictTo({Scope.LIBRARY})
    public boolean i(String str, int i) {
        boolean z = true;
        if (str.equals("__container")) {
            return true;
        }
        if (i >= this.keys.size() - 1 && !((String) this.keys.get(i)).equals("**")) {
            z = false;
        }
        return z;
    }

    private boolean ag(String str) {
        return str.equals("__container");
    }

    private boolean dV() {
        return ((String) this.keys.get(this.keys.size() - 1)).equals("**");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyPath{keys=");
        stringBuilder.append(this.keys);
        stringBuilder.append(",resolved=");
        stringBuilder.append(this.mo != null);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
