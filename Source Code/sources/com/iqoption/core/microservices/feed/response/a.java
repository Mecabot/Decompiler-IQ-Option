package com.iqoption.core.microservices.feed.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.feed.MediaDiskCache.MediaType;
import com.iqoption.core.feed.j;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B§\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0013HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0013HÆ\u0003J\t\u00109\u001a\u00020\u0013HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÁ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\t\u0010D\u001a\u00020EHÖ\u0001J\u0013\u0010F\u001a\u00020\u00132\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\u0006\u0010I\u001a\u00020\u0005J\u0012\u0010J\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020LH\u0016J\t\u0010M\u001a\u00020EHÖ\u0001J\n\u0010N\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010O\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010P\u001a\u00020\u0005HÖ\u0001J\u0019\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020EHÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001e\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010*R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0017\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%¨\u0006V"}, aXE = {"Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "Lcom/iqoption/core/microservices/feed/response/FeedItem;", "Lcom/iqoption/core/feed/Previewable;", "Landroid/os/Parcelable;", "title", "", "description", "source", "sourceUrl", "imageUrl", "icons", "", "author", "date", "", "mainTopic", "topics", "lang", "hidden", "", "priority", "Lcom/iqoption/core/microservices/feed/response/FeedPriority;", "like", "showImage", "button", "Lcom/iqoption/core/microservices/feed/response/FeedButton;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;ZLcom/iqoption/core/microservices/feed/response/FeedPriority;ZZLcom/iqoption/core/microservices/feed/response/FeedButton;)V", "getAuthor", "()Ljava/lang/String;", "getButton", "()Lcom/iqoption/core/microservices/feed/response/FeedButton;", "getDate", "()J", "getDescription", "getHidden", "()Z", "getIcons", "()Ljava/util/List;", "getImageUrl", "getLang", "getLike", "setLike", "(Z)V", "getMainTopic", "getPriority", "()Lcom/iqoption/core/microservices/feed/response/FeedPriority;", "getShowImage", "getSource", "getSourceUrl", "getTitle", "getTopics", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "getContentUrl", "getKeyBase", "type", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "hashCode", "originalPreviewUrl", "thumbnailPreviewUrl", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: FeedResponses.kt */
public final class a extends FeedItem implements Parcelable, j {
    public static final Creator CREATOR = new a();
    @SerializedName("date")
    private final long aFN;
    @SerializedName("source_url")
    private final String aVP;
    @SerializedName("image_url")
    private final String aVQ;
    @SerializedName("icons")
    private final List<String> aVR;
    @SerializedName("author")
    private final String aVS;
    @SerializedName("main_topic")
    private final String aVT;
    @SerializedName("topics")
    private final List<String> aVU;
    @SerializedName("lang")
    private final String aVV;
    @SerializedName("priority")
    private final FeedPriority aVW;
    @SerializedName("like")
    private boolean aVX;
    @SerializedName("show_image")
    private final boolean aVY;
    @SerializedName("button")
    private final c aVZ;
    @SerializedName("hidden")
    private final boolean aza;
    @SerializedName("description")
    private final String description;
    @SerializedName("source")
    private final String source;
    @SerializedName("title")
    private final String title;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            h.e(parcel2, "in");
            return new a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? (FeedPriority) Enum.valueOf(FeedPriority.class, parcel.readString()) : null, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel2) : null);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public String Tv() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.title, aVar.title) && h.E(this.description, aVar.description) && h.E(this.source, aVar.source) && h.E(this.aVP, aVar.aVP) && h.E(this.aVQ, aVar.aVQ) && h.E(this.aVR, aVar.aVR) && h.E(this.aVS, aVar.aVS)) {
                if ((this.aFN == aVar.aFN ? 1 : null) != null && h.E(this.aVT, aVar.aVT) && h.E(this.aVU, aVar.aVU) && h.E(this.aVV, aVar.aVV)) {
                    if ((this.aza == aVar.aza ? 1 : null) != null && h.E(this.aVW, aVar.aVW)) {
                        if ((this.aVX == aVar.aVX ? 1 : null) != null) {
                            return (this.aVY == aVar.aVY ? 1 : null) != null && h.E(this.aVZ, aVar.aVZ);
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.source;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.aVP;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.aVQ;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List list = this.aVR;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        str2 = this.aVS;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.aFN;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        str2 = this.aVT;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        list = this.aVU;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        str2 = this.aVV;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.aza;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        FeedPriority feedPriority = this.aVW;
        hashCode = (hashCode + (feedPriority != null ? feedPriority.hashCode() : 0)) * 31;
        i2 = this.aVX;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.aVY;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        c cVar = this.aVZ;
        if (cVar != null) {
            i = cVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommonFeedItem(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", sourceUrl=");
        stringBuilder.append(this.aVP);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.aVQ);
        stringBuilder.append(", icons=");
        stringBuilder.append(this.aVR);
        stringBuilder.append(", author=");
        stringBuilder.append(this.aVS);
        stringBuilder.append(", date=");
        stringBuilder.append(this.aFN);
        stringBuilder.append(", mainTopic=");
        stringBuilder.append(this.aVT);
        stringBuilder.append(", topics=");
        stringBuilder.append(this.aVU);
        stringBuilder.append(", lang=");
        stringBuilder.append(this.aVV);
        stringBuilder.append(", hidden=");
        stringBuilder.append(this.aza);
        stringBuilder.append(", priority=");
        stringBuilder.append(this.aVW);
        stringBuilder.append(", like=");
        stringBuilder.append(this.aVX);
        stringBuilder.append(", showImage=");
        stringBuilder.append(this.aVY);
        stringBuilder.append(", button=");
        stringBuilder.append(this.aVZ);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.source);
        parcel.writeString(this.aVP);
        parcel.writeString(this.aVQ);
        parcel.writeStringList(this.aVR);
        parcel.writeString(this.aVS);
        parcel.writeLong(this.aFN);
        parcel.writeString(this.aVT);
        parcel.writeStringList(this.aVU);
        parcel.writeString(this.aVV);
        parcel.writeInt(this.aza);
        Enum enumR = this.aVW;
        if (enumR != null) {
            parcel.writeInt(1);
            parcel.writeString(enumR.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.aVX);
        parcel.writeInt(this.aVY);
        Parcelable parcelable = this.aVZ;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getSource() {
        return this.source;
    }

    public final String VN() {
        return this.aVP;
    }

    public final List<String> VO() {
        return this.aVR;
    }

    public final String VP() {
        return this.aVS;
    }

    public final long getDate() {
        return this.aFN;
    }

    public final List<String> VQ() {
        return this.aVU;
    }

    public final FeedPriority VR() {
        return this.aVW;
    }

    public final boolean VS() {
        return this.aVX;
    }

    public final void ch(boolean z) {
        this.aVX = z;
    }

    public final c VT() {
        return this.aVZ;
    }

    public a(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, long j, String str7, List<String> list2, String str8, boolean z, FeedPriority feedPriority, boolean z2, boolean z3, c cVar) {
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        List<String> list3 = list;
        List<String> list4 = list2;
        h.e(str9, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        h.e(str10, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        h.e(str11, b.SOURCE);
        h.e(str12, "sourceUrl");
        h.e(list3, "icons");
        h.e(list4, "topics");
        this.title = str9;
        this.description = str10;
        this.source = str11;
        this.aVP = str12;
        this.aVQ = str5;
        this.aVR = list3;
        this.aVS = str6;
        this.aFN = j;
        this.aVT = str7;
        this.aVU = list4;
        this.aVV = str8;
        this.aza = z;
        this.aVW = feedPriority;
        this.aVX = z2;
        this.aVY = z3;
        this.aVZ = cVar;
    }

    public String c(MediaType mediaType) {
        h.e(mediaType, Param.TYPE);
        switch (b.aoS[mediaType.ordinal()]) {
            case 1:
                return Tv();
            case 2:
                return Tw();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public String Tw() {
        return this.aVQ;
    }

    public final String VM() {
        String type = getType();
        if (type.hashCode() == 112202875 && type.equals("video")) {
            return this.aVP;
        }
        return this.aVP;
    }
}
