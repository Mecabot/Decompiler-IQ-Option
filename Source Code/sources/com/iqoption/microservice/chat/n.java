package com.iqoption.microservice.chat;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.annotations.SerializedName;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b)\b\b\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u0013HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0013HÖ\u0001J\u000e\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0004J\t\u00109\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\b#\u001a\u0004\b\"\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006<"}, aXE = {"Lcom/iqoption/microservice/chat/ChatRoom;", "", "()V", "id", "", "type", "Lcom/iqoption/microservice/chat/ChatRoomType;", "locale", "subject", "name", "localizedName", "icon", "isPublic", "", "isWrite", "isRegulated", "lastReadMessageId", "removed", "onlineUsers", "", "(Ljava/lang/String;Lcom/iqoption/microservice/chat/ChatRoomType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ZI)V", "getIcon", "()Ljava/lang/String;", "getId", "()Z", "getLastReadMessageId", "lastSeenMessageId", "getLastSeenMessageId", "getLocale", "getLocalizedName", "getName", "getOnlineUsers", "()I", "getRemoved", "getSubject", "subject$1", "getType", "()Lcom/iqoption/microservice/chat/ChatRoomType;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "isSeen", "messageId", "toString", "Companion", "Event", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Responses.kt */
public final class n {
    private static final PublishSubject<b> aqp = PublishSubject.aXA();
    private static final Map<String, String> cQq = new LinkedHashMap();
    public static final a cQr = new a();
    @SerializedName("type")
    private final ChatRoomType aHY;
    @SerializedName("is_regulated")
    private final boolean aMv;
    @SerializedName("subject")
    private final String cQk;
    @SerializedName("localized_name")
    private final String cQl;
    @SerializedName("icon")
    private final String cQm;
    @SerializedName("is_write")
    private final boolean cQn;
    @SerializedName("last_read_message_id")
    private final String cQo;
    @SerializedName("online_users")
    private final int cQp;
    @SerializedName("id")
    private final String id;
    @SerializedName("is_public")
    private final boolean isPublic;
    @SerializedName("locale")
    private final String locale;
    @SerializedName("name")
    private final String name;
    @SerializedName("removed")
    private final boolean removed;

    @i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u00050\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/microservice/chat/ChatRoom$Companion;", "", "()V", "events", "Lio/reactivex/Flowable;", "Lcom/iqoption/microservice/chat/ChatRoom$Event;", "getEvents", "()Lio/reactivex/Flowable;", "lastSeenMessages", "", "", "subject", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "getSeen", "roomId", "isSeen", "", "messageId", "see", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Responses.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void am(String str, String str2) {
            h.e(str, "roomId");
            h.e(str2, "messageId");
            n.cQq.put(str, str2);
            n.aqp.e(new b(str, str2));
        }

        public final boolean an(String str, String str2) {
            h.e(str, "roomId");
            h.e(str2, "messageId");
            return h.E((String) n.cQq.get(str), str2);
        }

        public final String im(String str) {
            h.e(str, "roomId");
            return (String) n.cQq.get(str);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/microservice/chat/ChatRoom$Event;", "", "chatRoomId", "", "lastReadMessageId", "(Ljava/lang/String;Ljava/lang/String;)V", "getChatRoomId", "()Ljava/lang/String;", "getLastReadMessageId", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Responses.kt */
    public static final class b {
        private final String cQo;
        private final String cQs;

        public b(String str, String str2) {
            h.e(str, "chatRoomId");
            h.e(str2, "lastReadMessageId");
            this.cQs = str;
            this.cQo = str2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (h.E(this.id, nVar.id) && h.E(this.aHY, nVar.aHY) && h.E(this.locale, nVar.locale) && h.E(this.cQk, nVar.cQk) && h.E(this.name, nVar.name) && h.E(this.cQl, nVar.cQl) && h.E(this.cQm, nVar.cQm)) {
                if ((this.isPublic == nVar.isPublic ? 1 : null) != null) {
                    if ((this.cQn == nVar.cQn ? 1 : null) != null) {
                        if ((this.aMv == nVar.aMv ? 1 : null) != null && h.E(this.cQo, nVar.cQo)) {
                            if ((this.removed == nVar.removed ? 1 : null) != null) {
                                if ((this.cQp == nVar.cQp ? 1 : null) != null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ChatRoomType chatRoomType = this.aHY;
        hashCode = (hashCode + (chatRoomType != null ? chatRoomType.hashCode() : 0)) * 31;
        String str2 = this.locale;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cQk;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cQl;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cQm;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.isPublic;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.cQn;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.aMv;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.cQo;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.removed;
        if (i != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.cQp;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatRoom(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.aHY);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", subject=");
        stringBuilder.append(this.cQk);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", localizedName=");
        stringBuilder.append(this.cQl);
        stringBuilder.append(", icon=");
        stringBuilder.append(this.cQm);
        stringBuilder.append(", isPublic=");
        stringBuilder.append(this.isPublic);
        stringBuilder.append(", isWrite=");
        stringBuilder.append(this.cQn);
        stringBuilder.append(", isRegulated=");
        stringBuilder.append(this.aMv);
        stringBuilder.append(", lastReadMessageId=");
        stringBuilder.append(this.cQo);
        stringBuilder.append(", removed=");
        stringBuilder.append(this.removed);
        stringBuilder.append(", onlineUsers=");
        stringBuilder.append(this.cQp);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public n(String str, ChatRoomType chatRoomType, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7, boolean z4, int i) {
        h.e(str, "id");
        h.e(chatRoomType, Param.TYPE);
        h.e(str4, "name");
        h.e(str7, "lastReadMessageId");
        this.id = str;
        this.aHY = chatRoomType;
        this.locale = str2;
        this.cQk = str3;
        this.name = str4;
        this.cQl = str5;
        this.cQm = str6;
        this.isPublic = z;
        this.cQn = z2;
        this.aMv = z3;
        this.cQo = str7;
        this.removed = z4;
        this.cQp = i;
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ n(String str, ChatRoomType chatRoomType, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7, boolean z4, int i, int i2, f fVar) {
        int i3 = i2;
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? ChatRoomType.GLOBAL : chatRoomType, (i3 & 4) != 0 ? (String) null : str2, (i3 & 8) != 0 ? (String) null : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? (String) null : str5, (i3 & 64) != 0 ? (String) null : str6, (i3 & 128) != 0 ? false : z, (i3 & 256) != 0 ? false : z2, (i3 & 512) != 0 ? false : z3, (i3 & 1024) != 0 ? "" : str7, (i3 & 2048) != 0 ? false : z4, (i3 & 4096) != 0 ? 0 : i);
    }

    public final ChatRoomType Qh() {
        return this.aHY;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getName() {
        return this.name;
    }

    public final String arK() {
        return this.cQm;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean Dh() {
        return this.aMv;
    }

    public final boolean aru() {
        return this.removed;
    }

    public final int arL() {
        return this.cQp;
    }

    public n() {
        this("", null, null, null, null, null, null, false, false, false, null, false, 0, 8190, null);
    }

    public final String arJ() {
        String im = cQr.im(this.id);
        return im != null ? im : this.cQo;
    }

    public final boolean il(String str) {
        h.e(str, "messageId");
        return h.E(str, this.cQo) || cQr.an(this.id, str);
    }
}
