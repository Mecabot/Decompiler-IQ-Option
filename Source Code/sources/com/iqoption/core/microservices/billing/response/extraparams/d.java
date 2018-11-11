package com.iqoption.core.microservices.billing.response.extraparams;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty.PropertyType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006HÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamStringProperty;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "_title", "", "pattern", "maxLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMaxLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPattern", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamStringProperty;", "describeContents", "equals", "", "other", "", "getTitle", "getType", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty$PropertyType;", "getTypeName", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: ExtraParamStringProperty.kt */
public final class d implements ExtraParamProperty {
    public static final Creator CREATOR = new b();
    public static final a aUj = new a();
    private final String _title;
    private final Integer aUi;
    private final String pattern;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamStringProperty$Companion;", "", "()V", "TYPE_NAME", "", "fromJson", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamStringProperty;", "jsonObject", "Lcom/google/gson/JsonObject;", "core_release"})
    /* compiled from: ExtraParamStringProperty.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final d d(JsonObject jsonObject) {
            String asString;
            String asString2;
            d dVar = null;
            if (jsonObject != null && jsonObject.has(Param.TYPE)) {
                JsonElement jsonElement = jsonObject.get(Param.TYPE);
                h.d(jsonElement, "jsonObject.get(\"type\")");
                if (h.E("string", jsonElement.getAsString())) {
                    if (jsonObject.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                        JsonElement jsonElement2 = jsonObject.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                        h.d(jsonElement2, "jsonObject.get(\"title\")");
                        asString = jsonElement2.getAsString();
                    } else {
                        asString = null;
                    }
                    if (jsonObject.has("pattern")) {
                        jsonElement = jsonObject.get("pattern");
                        h.d(jsonElement, "jsonObject.get(\"pattern\")");
                        asString2 = jsonElement.getAsString();
                    } else {
                        asString2 = null;
                    }
                    Integer num = (Integer) null;
                    try {
                        if (jsonObject.has("maxLength")) {
                            JsonElement jsonElement3 = jsonObject.get("maxLength");
                            h.d(jsonElement3, "jsonObject.get(\"maxLength\")");
                            dVar = Integer.valueOf(jsonElement3.getAsInt());
                        }
                        num = dVar;
                    } catch (Exception unused) {
                        return new d(asString, asString2, num);
                    }
                }
            }
            return null;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new d(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        public final Object[] newArray(int i) {
            return new d[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.aUi, r3.aUi) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.billing.response.extraparams.d;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.billing.response.extraparams.d) r3;
        r0 = r2._title;
        r1 = r3._title;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.pattern;
        r1 = r3.pattern;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.aUi;
        r3 = r3.aUi;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.extraparams.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this._title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pattern;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.aUi;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtraParamStringProperty(_title=");
        stringBuilder.append(this._title);
        stringBuilder.append(", pattern=");
        stringBuilder.append(this.pattern);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(this.aUi);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0021 in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    public void writeToParcel(android.os.Parcel r2, int r3) {
        /*
        r1 = this;
        r3 = "parcel";
        kotlin.jvm.internal.h.e(r2, r3);
        r3 = r1._title;
        r2.writeString(r3);
        r3 = r1.pattern;
        r2.writeString(r3);
        r3 = r1.aUi;
        if (r3 == 0) goto L_0x001f;
    L_0x0013:
        r0 = 1;
        r2.writeInt(r0);
        r3 = r3.intValue();
    L_0x001b:
        r2.writeInt(r3);
        return;
    L_0x001f:
        r3 = 0;
        goto L_0x001b;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.extraparams.d.writeToParcel(android.os.Parcel, int):void");
    }

    public d(String str, String str2, Integer num) {
        this._title = str;
        this.pattern = str2;
        this.aUi = num;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final Integer Vm() {
        return this.aUi;
    }

    public PropertyType Vh() {
        return PropertyType.stringType;
    }

    public String getTitle() {
        return this._title;
    }
}
