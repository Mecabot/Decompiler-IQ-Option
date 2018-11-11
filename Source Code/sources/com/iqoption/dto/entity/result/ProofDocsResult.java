package com.iqoption.dto.entity.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Predicates;
import com.google.common.collect.i;
import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.Doc;

public class ProofDocsResult implements Parcelable {
    public static final Creator<ProofDocsResult> CREATOR = new Creator<ProofDocsResult>() {
        public ProofDocsResult createFromParcel(Parcel parcel) {
            return new ProofDocsResult(parcel);
        }

        public ProofDocsResult[] newArray(int i) {
            return new ProofDocsResult[i];
        }
    };
    @SerializedName("result")
    public ProofDocs result;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProofDocsResult{result=");
        stringBuilder.append(this.result);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.result, i);
    }

    public boolean isVerified(int i) {
        if (this.result == null || this.result.docs == null || !i.c(this.result.docs).c(Predicates.a(Predicates.G(Integer.valueOf(i)), Doc.getType)).e(Predicates.a(Predicates.G(Integer.valueOf(1)), Doc.getState)).isPresent()) {
            return false;
        }
        return true;
    }

    public boolean isUnderReview(int i) {
        if (this.result == null || this.result.docs == null || !i.c(this.result.docs).c(Predicates.a(Predicates.G(Integer.valueOf(i)), Doc.getType)).e(Predicates.a(Predicates.a(Predicates.G(Integer.valueOf(0)), Predicates.G(Integer.valueOf(-2))), Doc.getState)).isPresent()) {
            return false;
        }
        return true;
    }

    public boolean isDeclined(int i) {
        return (this.result == null || this.result.docs == null || !i.c(this.result.docs).c(Predicates.a(Predicates.G(Integer.valueOf(i)), Doc.getType)).e(Predicates.a(Predicates.G(Integer.valueOf(-1)), Doc.getState)).isPresent()) ? false : true;
    }

    public String getDeclinedComment(int i) {
        return (this.result == null || this.result.docs == null) ? "" : (String) i.c(this.result.docs).c(Predicates.a(Predicates.G(Integer.valueOf(i)), Doc.getType)).e(Predicates.a(Predicates.G(Integer.valueOf(-1)), Doc.getState)).a(Doc.getComment).w("");
    }

    protected ProofDocsResult(Parcel parcel) {
        this.result = (ProofDocs) parcel.readParcelable(ProofDocs.class.getClassLoader());
    }
}
