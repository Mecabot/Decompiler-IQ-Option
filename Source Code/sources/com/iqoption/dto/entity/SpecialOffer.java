package com.iqoption.dto.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;

public class SpecialOffer implements Parcelable {
    public static final Creator<SpecialOffer> CREATOR = new Creator<SpecialOffer>() {
        public SpecialOffer createFromParcel(Parcel parcel) {
            return new SpecialOffer(parcel);
        }

        public SpecialOffer[] newArray(int i) {
            return new SpecialOffer[i];
        }
    };
    private static final String TYPE_PICTURE = "PICTURE";
    @SerializedName("description")
    public String description;
    @SerializedName("end_datatime")
    public Long endDateTime;
    @SerializedName("html")
    public String html;
    @SerializedName("id")
    public Long id;
    @SerializedName("show_countdown")
    public Boolean isShowTimer;
    public boolean isWelcome = false;
    @SerializedName("picture_actions")
    public ArrayList<Actions> pictureActions;
    @SerializedName("picture_url")
    public String pictureUrl;
    @SerializedName("start_datetime")
    public Long startDateTime;
    @SerializedName("title")
    public String title;
    @SerializedName("type")
    public String type;
    @SerializedName("work_time_type")
    public Integer workTimeType;

    public static class Actions implements Parcelable {
        public static final Creator<Actions> CREATOR = new Creator<Actions>() {
            public Actions createFromParcel(Parcel parcel) {
                return new Actions(parcel);
            }

            public Actions[] newArray(int i) {
                return new Actions[i];
            }
        };
        @SerializedName("action")
        public String action;
        @SerializedName("bottom")
        private String bottom;
        @SerializedName("identifier")
        public String identifier;
        @SerializedName("left")
        private String left;
        @SerializedName("right")
        private String right;
        @SerializedName("top")
        private String top;
        @SerializedName("type")
        public String type;

        public int describeContents() {
            return 0;
        }

        public int getLeft() {
            try {
                return Integer.parseInt(this.left);
            } catch (Exception unused) {
                return 0;
            }
        }

        public int getTop() {
            try {
                return Integer.parseInt(this.top);
            } catch (Exception unused) {
                return 0;
            }
        }

        public int getRight() {
            try {
                return Integer.parseInt(this.right);
            } catch (Exception unused) {
                return 0;
            }
        }

        public int getBottom() {
            try {
                return Integer.parseInt(this.bottom);
            } catch (Exception unused) {
                return 0;
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeValue(this.left);
            parcel.writeValue(this.top);
            parcel.writeValue(this.right);
            parcel.writeValue(this.bottom);
            parcel.writeValue(this.type);
            parcel.writeValue(this.identifier);
            parcel.writeValue(this.action);
        }

        public Actions(Parcel parcel) {
            ClassLoader classLoader = getClass().getClassLoader();
            this.left = (String) parcel.readValue(classLoader);
            this.top = (String) parcel.readValue(classLoader);
            this.right = (String) parcel.readValue(classLoader);
            this.bottom = (String) parcel.readValue(classLoader);
            this.type = (String) parcel.readValue(classLoader);
            this.identifier = (String) parcel.readValue(classLoader);
            this.action = (String) parcel.readValue(classLoader);
        }
    }

    public static class List extends ArrayList<SpecialOffer> {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this.id.longValue() == ((SpecialOffer) obj).id.longValue()) {
            z = true;
        }
        return z;
    }

    public boolean isCurrentOffer(long j) {
        return this.startDateTime.longValue() * 1000 <= j + 3000 && j < this.endDateTime.longValue() * 1000 && this.type.equals(TYPE_PICTURE) && !TextUtils.isEmpty(this.pictureUrl);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.title);
        parcel.writeValue(this.description);
        parcel.writeValue(this.pictureUrl);
        parcel.writeParcelableArray((Parcelable[]) this.pictureActions.toArray(new Actions[0]), 0);
        parcel.writeValue(this.id);
        parcel.writeValue(this.type);
        parcel.writeValue(this.html);
        parcel.writeValue(this.startDateTime);
        parcel.writeValue(this.endDateTime);
        parcel.writeValue(this.isShowTimer);
        parcel.writeValue(Boolean.valueOf(this.isWelcome));
    }

    public SpecialOffer(Parcel parcel) {
        ClassLoader classLoader = getClass().getClassLoader();
        this.title = (String) parcel.readValue(classLoader);
        this.description = (String) parcel.readValue(classLoader);
        this.pictureUrl = (String) parcel.readValue(classLoader);
        this.pictureActions = new ArrayList(Arrays.asList((Actions[]) parcel.readParcelableArray(Actions.class.getClassLoader())));
        this.id = (Long) parcel.readValue(classLoader);
        this.type = (String) parcel.readValue(classLoader);
        this.html = (String) parcel.readValue(classLoader);
        this.startDateTime = (Long) parcel.readValue(classLoader);
        this.endDateTime = (Long) parcel.readValue(classLoader);
        this.isShowTimer = (Boolean) parcel.readValue(classLoader);
        this.isWelcome = ((Boolean) parcel.readValue(classLoader)).booleanValue();
    }
}
