package com.iqoption.microservice.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B/\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J8\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0006H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "name", "", "questions", "", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getQuestions", "()Ljava/util/List;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycQuestionnaire.kt */
public final class c implements Parcelable {
    public static final Creator<c> CREATOR = new b();
    public static final a cRz = new a();
    @SerializedName("questions")
    private final List<e> cRy;
    @SerializedName("name")
    private final String name;
    @SerializedName("type")
    private final Integer type;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycQuestionnaire.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, aXE = {"com/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycQuestionnaire.kt */
    public static final class b implements Creator<c> {
        b() {
        }

        /* renamed from: O */
        public c createFromParcel(Parcel parcel) {
            h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
            return new c(parcel);
        }

        /* renamed from: fn */
        public c[] newArray(int i) {
            return new c[i];
        }
    }

    public c() {
        this(null, null, null, 7, null);
    }

    public final List<e> ast() {
        return this.cRy;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.cRy, r3.cRy) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.a.a.a.c;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.microservice.a.a.a.c) r3;
        r0 = r2.type;
        r1 = r3.type;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.name;
        r1 = r3.name;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.cRy;
        r3 = r3.cRy;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.a.a.a.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Integer num = this.type;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.name;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.cRy;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycQuestionnaire(type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", questions=");
        stringBuilder.append(this.cRy);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(Integer num, String str, List<e> list) {
        this.type = num;
        this.name = str;
        this.cRy = list;
    }

    public /* synthetic */ c(Integer num, String str, List list, int i, f fVar) {
        if ((i & 1) != 0) {
            num = (Integer) null;
        }
        if ((i & 2) != 0) {
            str = (String) null;
        }
        if ((i & 4) != 0) {
            list = (List) null;
        }
        this(num, str, list);
    }

    public final Integer asr() {
        return this.type;
    }

    public final List<e> ass() {
        return this.cRy;
    }

    public c(Parcel parcel) {
        h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
        this((Integer) parcel.readValue(Integer.TYPE.getClassLoader()), parcel.readString(), parcel.createTypedArrayList(e.CREATOR));
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "dest");
        parcel.writeValue(this.type);
        parcel.writeString(this.name);
        parcel.writeTypedList(this.cRy);
    }
}
