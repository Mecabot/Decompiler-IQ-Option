package com.iqoption.microservice.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bi\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010$\u001a\u0004\u0018\u00010\nHÂ\u0003¢\u0006\u0002\u0010\u001cJ\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÂ\u0003¢\u0006\u0002\u0010\u001aJ\u0013\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0010HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJr\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\nH\u0016J\u0013\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u00020\nH\u0016J\t\u00100\u001a\u00020\u0006HÖ\u0001J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\nH\u0016R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0007\u0010\u001aR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00066"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "questionKey", "", "isRequired", "", "_questionId", "", "answers", "", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycAnswersItem;", "_isMultiChoiceAvailable", "dependsOnAnswers", "", "order", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "getAnswers", "()Ljava/util/List;", "getDependsOnAnswers", "isMultiChoiceAvailable", "()Z", "()Ljava/lang/Boolean;", "getOrder", "()Ljava/lang/Integer;", "questionId", "getQuestionId", "()I", "getQuestionKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;)Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycQuestionsItem.kt */
public final class e implements Parcelable {
    public static final Creator<e> CREATOR = new b();
    public static final a cRH = new a();
    @SerializedName("answers")
    private final List<a> answers;
    @SerializedName("questionKey")
    private final String cRC;
    @SerializedName("isRequired")
    private final Boolean cRD;
    @SerializedName("questionId")
    private final Integer cRE;
    @SerializedName("isMultiChoiceAvailable")
    private final Boolean cRF;
    @SerializedName("dependsOnAnswers")
    private final List<Integer> cRG;
    @SerializedName("order")
    private final Integer order;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycQuestionsItem.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, aXE = {"com/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionsItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycQuestionsItem.kt */
    public static final class b implements Creator<e> {
        b() {
        }

        /* renamed from: P */
        public e createFromParcel(Parcel parcel) {
            h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
            return new e(parcel);
        }

        /* renamed from: fo */
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycQuestionsItem(questionKey=");
        stringBuilder.append(this.cRC);
        stringBuilder.append(", isRequired=");
        stringBuilder.append(this.cRD);
        stringBuilder.append(", _questionId=");
        stringBuilder.append(this.cRE);
        stringBuilder.append(", answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(", _isMultiChoiceAvailable=");
        stringBuilder.append(this.cRF);
        stringBuilder.append(", dependsOnAnswers=");
        stringBuilder.append(this.cRG);
        stringBuilder.append(", order=");
        stringBuilder.append(this.order);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public e(String str, Boolean bool, Integer num, List<a> list, Boolean bool2, List<Integer> list2, Integer num2) {
        this.cRC = str;
        this.cRD = bool;
        this.cRE = num;
        this.answers = list;
        this.cRF = bool2;
        this.cRG = list2;
        this.order = num2;
    }

    public /* synthetic */ e(String str, Boolean bool, Integer num, List list, Boolean bool2, List list2, Integer num2, int i, f fVar) {
        if ((i & 1) != 0) {
            str = (String) null;
        }
        if ((i & 2) != 0) {
            bool = (Boolean) null;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            num = (Integer) null;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            list = (List) null;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            bool2 = (Boolean) null;
        }
        Boolean bool4 = bool2;
        if ((i & 32) != 0) {
            list2 = (List) null;
        }
        List list4 = list2;
        if ((i & 64) != 0) {
            num2 = (Integer) null;
        }
        this(str, bool3, num3, list3, bool4, list4, num2);
    }

    public final String asy() {
        return this.cRC;
    }

    public final Boolean asz() {
        return this.cRD;
    }

    public final List<a> asA() {
        return this.answers;
    }

    public final List<Integer> asB() {
        return this.cRG;
    }

    public final Integer asn() {
        return this.order;
    }

    public e(Parcel parcel) {
        h.e(parcel, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
        String readString = parcel.readString();
        Boolean bool = (Boolean) parcel.readValue(Boolean.TYPE.getClassLoader());
        Integer num = (Integer) parcel.readValue(Integer.TYPE.getClassLoader());
        List arrayList = new ArrayList();
        parcel.readList(arrayList, a.class.getClassLoader());
        Boolean bool2 = (Boolean) parcel.readValue(Boolean.TYPE.getClassLoader());
        List arrayList2 = new ArrayList();
        parcel.readList(arrayList2, Integer.TYPE.getClassLoader());
        this(readString, bool, num, arrayList, bool2, arrayList2, (Integer) parcel.readValue(Integer.TYPE.getClassLoader()));
    }

    public final boolean asw() {
        Boolean bool = this.cRF;
        return bool != null ? bool.booleanValue() : false;
    }

    public final int asx() {
        Integer num = this.cRE;
        return num != null ? num.intValue() : 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "dest");
        parcel.writeString(this.cRC);
        parcel.writeValue(this.cRD);
        parcel.writeValue(this.cRE);
        parcel.writeList(this.answers);
        parcel.writeValue(this.cRF);
        parcel.writeList(this.cRG);
        parcel.writeValue(this.order);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return obj instanceof e ? h.E(this.cRE, ((e) obj).cRE) : false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        Integer num = this.cRE;
        return num != null ? num.hashCode() : 0;
    }
}
