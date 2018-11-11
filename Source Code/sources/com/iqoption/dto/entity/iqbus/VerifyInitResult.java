package com.iqoption.dto.entity.iqbus;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.iqoption.util.ah;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(Deserializer.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, aXE = {"Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;", "Landroid/os/Parcelable;", "config", "", "(Ljava/lang/String;)V", "getConfig", "()Ljava/lang/String;", "component1", "copy", "decrypt", "Lcom/iqoption/dto/entity/iqbus/VerifyInitData;", "describeContents", "", "equals", "", "other", "", "hashCode", "parseConfig", "jsonString", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Deserializer", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyInitResult.kt */
public final class VerifyInitResult implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion();
    private static final String TAG = "com.iqoption.dto.entity.iqbus.VerifyInitResult";
    private final String config;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/dto/entity/iqbus/VerifyInitResult$Companion;", "", "()V", "TAG", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyInitResult.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new VerifyInitResult(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new VerifyInitResult[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/dto/entity/iqbus/VerifyInitResult$Deserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyInitResult.kt */
    public static final class Deserializer implements JsonDeserializer<VerifyInitResult> {
        public VerifyInitResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            h.e(jsonElement, "json");
            h.e(type, "typeOfT");
            h.e(jsonDeserializationContext, "context");
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            if (asJsonArray.size() != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected array size: ");
                stringBuilder.append(asJsonArray);
                throw new IllegalStateException(stringBuilder.toString());
            }
            jsonElement = asJsonArray.get(0);
            h.d(jsonElement, "array[0]");
            String asString = jsonElement.getAsString();
            h.d(asString, "array[0].asString");
            return new VerifyInitResult(asString);
        }
    }

    public static /* synthetic */ VerifyInitResult copy$default(VerifyInitResult verifyInitResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyInitResult.config;
        }
        return verifyInitResult.copy(str);
    }

    public final String component1() {
        return this.config;
    }

    public final VerifyInitResult copy(String str) {
        h.e(str, "config");
        return new VerifyInitResult(str);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.config, ((com.iqoption.dto.entity.iqbus.VerifyInitResult) r2).config) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.dto.entity.iqbus.VerifyInitResult;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.dto.entity.iqbus.VerifyInitResult) r2;
        r0 = r1.config;
        r2 = r2.config;
        r2 = kotlin.jvm.internal.h.E(r0, r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0015;
    L_0x0013:
        r2 = 0;
        return r2;
    L_0x0015:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dto.entity.iqbus.VerifyInitResult.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.config;
        return str != null ? str.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerifyInitResult(config=");
        stringBuilder.append(this.config);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.config);
    }

    public VerifyInitResult(String str) {
        h.e(str, "config");
        this.config = str;
    }

    public final String getConfig() {
        return this.config;
    }

    static {
        if (VerifyInitResult.class.getName() == null) {
            h.aXZ();
        }
    }

    public final VerifyInitData decrypt() {
        String decrypt = VerifyInitUtilsKt.decrypt(this.config);
        CharSequence charSequence = decrypt;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            return null;
        }
        if (decrypt == null) {
            h.aXZ();
        }
        return parseConfig(decrypt);
    }

    private final VerifyInitData parseConfig(String str) {
        try {
            return (VerifyInitData) ah.aGg().fromJson(str, VerifyInitData.class);
        } catch (Exception e) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unable to create VerifyInitData from json string ");
            stringBuilder.append(str);
            com.iqoption.core.i.e(str2, stringBuilder.toString(), e);
            return null;
        }
    }
}
