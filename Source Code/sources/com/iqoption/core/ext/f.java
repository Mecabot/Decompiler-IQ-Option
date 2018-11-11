package com.iqoption.core.ext;

import android.os.Parcel;
import c.a.a.a;
import com.google.gson.JsonElement;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/ext/JsonArrayParceler;", "Lkotlinx/android/parcel/Parceler;", "Lcom/google/gson/JsonElement;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "core_release"})
/* compiled from: AndroidExtensions.kt */
public final class f implements a<JsonElement> {
    public static final f aPt = new f();

    private f() {
    }

    /* renamed from: H */
    public JsonElement E(Parcel parcel) {
        h.e(parcel, "parcel");
        if (parcel.readInt() != 1) {
            return null;
        }
        String readString = parcel.readString();
        if (readString == null) {
            h.aXZ();
        }
        return (JsonElement) com.iqoption.core.f.RQ().Dq().fromJson(readString, JsonElement.class);
    }

    public void a(JsonElement jsonElement, Parcel parcel, int i) {
        h.e(parcel, "parcel");
        if (jsonElement != null) {
            parcel.writeInt(1);
            parcel.writeString(jsonElement.toString());
            return;
        }
        parcel.writeInt(0);
    }
}
