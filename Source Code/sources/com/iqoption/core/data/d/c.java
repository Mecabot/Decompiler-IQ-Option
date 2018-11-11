package com.iqoption.core.data.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.iqoption.core.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0016\u0018\u0000 22\u00020\u0001:\u00012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0016J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010H\u0016J(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010H\u0016J(\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u001dH\u0016J(\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0010H\u0016J(\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0012H\u0016J\u001c\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0016J(\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0014H\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0018H\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u001dH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0016J\u001e\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016J\u001e\u0010&\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016J\u001e\u0010'\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0016J\u001e\u0010(\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012H\u0016J\u001e\u0010)\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010H\u0016J\u001e\u0010*\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0016J\u001c\u0010+\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u001e\u0010,\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010H\u0016J\u001e\u0010-\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012H\u0016J\u001c\u0010.\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\u001e\u0010/\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\u001e\u00100\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, aXE = {"Lcom/iqoption/core/data/prefs/SharedPrefs;", "Lcom/iqoption/core/data/prefs/Prefs;", "name", "", "(Ljava/lang/String;)V", "sp", "Landroid/content/SharedPreferences;", "clear", "", "getBool", "", "key", "def", "getDouble", "", "getDoubleList", "", "getDoubleSet", "", "getFloat", "", "getFloatList", "getFloatSet", "getInt", "", "getIntList", "getIntSet", "getKeys", "getLong", "", "getLongList", "getLongSet", "getString", "getStringList", "getStringSet", "put", "v", "putDoubleList", "putDoubleSet", "putFloatList", "putFloatSet", "putIntList", "putIntSet", "putList", "putLongList", "putLongSet", "putSet", "putStringList", "putStringSet", "remove", "Companion", "core_release"})
/* compiled from: SharedPrefs.kt */
public final class c implements b {
    public static final a aOD = new a();
    private final SharedPreferences aOC;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/data/prefs/SharedPrefs$Companion;", "", "()V", "LIST_SEPARATOR", "", "core_release"})
    /* compiled from: SharedPrefs.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(String str) {
        h.e(str, "name");
        SharedPreferences sharedPreferences = f.RR().getApplicationContext().getSharedPreferences(str, 0);
        h.d(sharedPreferences, "appContext.applicationCo…me, Context.MODE_PRIVATE)");
        this.aOC = sharedPreferences;
    }

    public void put(String str, boolean z) {
        h.e(str, "key");
        Editor edit = this.aOC.edit();
        h.d(edit, "edit()");
        Editor putBoolean = edit.putBoolean(str, z);
        h.d(putBoolean, "putBoolean(key, v)");
        putBoolean.apply();
    }

    public void put(String str, long j) {
        h.e(str, "key");
        Editor edit = this.aOC.edit();
        h.d(edit, "edit()");
        Editor putLong = edit.putLong(str, j);
        h.d(putLong, "putLong(key, v)");
        putLong.apply();
    }

    public void put(String str, String str2) {
        h.e(str, "key");
        h.e(str2, "v");
        Editor edit = this.aOC.edit();
        h.d(edit, "edit()");
        Editor putString = edit.putString(str, str2);
        h.d(putString, "putString(key, v)");
        putString.apply();
    }

    public boolean n(String str, boolean z) {
        h.e(str, "key");
        return this.aOC.getBoolean(str, z);
    }

    public long getLong(String str, long j) {
        h.e(str, "key");
        return this.aOC.getLong(str, j);
    }

    public String getString(String str, String str2) {
        h.e(str, "key");
        return this.aOC.getString(str, str2);
    }

    public void remove(String str) {
        h.e(str, "key");
        Editor edit = this.aOC.edit();
        h.d(edit, "edit()");
        Editor remove = edit.remove(str);
        h.d(remove, "remove(key)");
        remove.apply();
    }

    public void clear() {
        Editor edit = this.aOC.edit();
        h.d(edit, "edit()");
        edit = edit.clear();
        h.d(edit, "clear()");
        edit.apply();
    }
}
