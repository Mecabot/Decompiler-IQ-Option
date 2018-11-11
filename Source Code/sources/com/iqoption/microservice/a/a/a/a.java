package com.iqoption.microservice.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B=\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJF\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000e¨\u0006'"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "answerId", "", "cancelAnswers", "", "answerKey", "", "order", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getAnswerId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnswerKey", "()Ljava/lang/String;", "getCancelAnswers", "()Ljava/util/List;", "getOrder", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycAnswersItem.kt */
public final class a implements Parcelable {
    public static final Creator<a> CREATOR = new b();
    public static final a cRn = new a();
    @SerializedName("answerId")
    private final Integer cRk;
    @SerializedName("cancelAnswers")
    private final List<Integer> cRl;
    @SerializedName("answerKey")
    private final String cRm;
    @SerializedName("order")
    private final Integer order;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycAnswersItem.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, aXE = {"com/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycAnswersItem.kt */
    public static final class b implements Creator<a> {
        b() {
        }

        /* renamed from: N */
        public a createFromParcel(Parcel parcel) {
            h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
            return new a(parcel);
        }

        /* renamed from: fm */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a() {
        this(null, null, null, null, 15, null);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (kotlin.jvm.internal.h.E(r2.order, r3.order) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.a.a.a.a;
        if (r0 == 0) goto L_0x0031;
    L_0x0006:
        r3 = (com.iqoption.microservice.a.a.a.a) r3;
        r0 = r2.cRk;
        r1 = r3.cRk;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0012:
        r0 = r2.cRl;
        r1 = r3.cRl;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x001c:
        r0 = r2.cRm;
        r1 = r3.cRm;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0026:
        r0 = r2.order;
        r3 = r3.order;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        r3 = 0;
        return r3;
    L_0x0033:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.a.a.a.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Integer num = this.cRk;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        List list = this.cRl;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.cRm;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.order;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycAnswersItem(answerId=");
        stringBuilder.append(this.cRk);
        stringBuilder.append(", cancelAnswers=");
        stringBuilder.append(this.cRl);
        stringBuilder.append(", answerKey=");
        stringBuilder.append(this.cRm);
        stringBuilder.append(", order=");
        stringBuilder.append(this.order);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(Integer num, List<Integer> list, String str, Integer num2) {
        this.cRk = num;
        this.cRl = list;
        this.cRm = str;
        this.order = num2;
    }

    public /* synthetic */ a(Integer num, List list, String str, Integer num2, int i, f fVar) {
        if ((i & 1) != 0) {
            num = (Integer) null;
        }
        if ((i & 2) != 0) {
            list = (List) null;
        }
        if ((i & 4) != 0) {
            str = (String) null;
        }
        if ((i & 8) != 0) {
            num2 = (Integer) null;
        }
        this(num, list, str, num2);
    }

    public final Integer ask() {
        return this.cRk;
    }

    public final List<Integer> asl() {
        return this.cRl;
    }

    public final String asm() {
        return this.cRm;
    }

    public final Integer asn() {
        return this.order;
    }

    public a(Parcel parcel) {
        h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
        Integer num = (Integer) parcel.readValue(Integer.TYPE.getClassLoader());
        List arrayList = new ArrayList();
        parcel.readList(arrayList, Integer.TYPE.getClassLoader());
        this(num, arrayList, parcel.readString(), (Integer) parcel.readValue(Integer.TYPE.getClassLoader()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "dest");
        parcel.writeValue(this.cRk);
        parcel.writeList(this.cRl);
        parcel.writeString(this.cRm);
        parcel.writeValue(this.order);
    }
}
