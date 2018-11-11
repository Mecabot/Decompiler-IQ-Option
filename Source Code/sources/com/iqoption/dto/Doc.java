package com.iqoption.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.d;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doc implements Parcelable {
    public static final Creator<Doc> CREATOR = new Creator<Doc>() {
        public Doc createFromParcel(Parcel parcel) {
            return new Doc(parcel);
        }

        public Doc[] newArray(int i) {
            return new Doc[i];
        }
    };
    public static final int PROOF_DOCS_STATE_FAIL = -1;
    public static final int PROOF_DOCS_STATE_NONE = -3;
    public static final int PROOF_DOCS_STATE_UPLOADED = 0;
    public static final int PROOF_DOCS_STATE_UPLOADING = -2;
    public static final int PROOF_DOCS_STATE_VERIFIED = 1;
    public static final int PROOF_DOCS_TYPE_ADDRESS = 2;
    public static final int PROOF_DOCS_TYPE_IDENTITY = 1;
    public static d<Doc, String> getComment = new d<Doc, String>() {
        public String apply(Doc doc) {
            return doc.comment == null ? "" : doc.comment;
        }
    };
    public static d<Doc, Integer> getState = new d<Doc, Integer>() {
        public Integer apply(Doc doc) {
            return doc.state;
        }
    };
    public static d<Doc, Integer> getType = new d<Doc, Integer>() {
        public Integer apply(Doc doc) {
            return doc.type;
        }
    };
    @SerializedName("comment")
    public String comment;
    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @Expose(deserialize = false, serialize = false)
    public Integer progress;
    @SerializedName("state")
    public Integer state;
    @SerializedName("type")
    public Integer type;

    public int describeContents() {
        return 0;
    }

    public Doc(String str, int i) {
        this.name = str;
        this.type = Integer.valueOf(i);
        this.state = Integer.valueOf(-2);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Doc) && this.name.equals(((Doc) obj).name);
    }

    public void applyChange(Doc doc) {
        if (doc != null) {
            this.id = doc.id;
            this.state = doc.state;
            this.comment = doc.comment;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Doc{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append(", comment='");
        stringBuilder.append(this.comment);
        stringBuilder.append('\'');
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", progress=");
        stringBuilder.append(this.progress);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.type);
        parcel.writeValue(this.state);
        parcel.writeString(this.comment);
        parcel.writeValue(this.id);
        parcel.writeString(this.name);
        parcel.writeValue(this.progress);
    }

    protected Doc(Parcel parcel) {
        this.type = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.state = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.comment = parcel.readString();
        this.id = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.name = parcel.readString();
        this.progress = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
