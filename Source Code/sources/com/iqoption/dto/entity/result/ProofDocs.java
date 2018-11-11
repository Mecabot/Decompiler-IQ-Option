package com.iqoption.dto.entity.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.Doc;
import java.util.ArrayList;

public class ProofDocs implements Parcelable {
    public static final Creator<ProofDocs> CREATOR = new Creator<ProofDocs>() {
        public ProofDocs createFromParcel(Parcel parcel) {
            return new ProofDocs(parcel);
        }

        public ProofDocs[] newArray(int i) {
            return new ProofDocs[i];
        }
    };
    @SerializedName("data")
    public ArrayList<Doc> docs;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProofDocs{docs=");
        stringBuilder.append(this.docs);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.docs);
    }

    protected ProofDocs(Parcel parcel) {
        this.docs = parcel.createTypedArrayList(Doc.CREATOR);
    }
}
