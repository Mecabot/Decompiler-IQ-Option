package com.iqoption.quiz.chat;

import com.iqoption.quiz.c.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J[\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020\u0002HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, aXE = {"Lcom/iqoption/quiz/chat/ChatItem;", "Lcom/iqoption/quiz/util/Identifiable;", "", "id", "userId", "avatar", "initials", "avatarColor", "", "author", "message", "isLarge", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getAuthor", "()Ljava/lang/String;", "getAvatar", "getAvatarColor", "()I", "getId", "getInitials", "()Z", "getMessage", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "quiz_release"})
/* compiled from: ChatItem.kt */
public final class b implements e<String> {
    private static final b djt = new b(null, null, null, null, 0, null, null, false, 255, null);
    public static final a dju = new a();
    private final String aVS;
    private final String aWO;
    private final String dia;
    private final int djr;
    private final boolean djs;
    private final String id;
    private final String message;
    private final String userId;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/quiz/chat/ChatItem$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/quiz/chat/ChatItem;", "getEMPTY", "()Lcom/iqoption/quiz/chat/ChatItem;", "quiz_release"})
    /* compiled from: ChatItem.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b aAY() {
            return b.djt;
        }
    }

    public b() {
        this(null, null, null, null, 0, null, null, false, 255, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.E(Jf(), bVar.Jf()) && h.E(this.userId, bVar.userId) && h.E(this.aWO, bVar.aWO) && h.E(this.dia, bVar.dia)) {
                if ((this.djr == bVar.djr ? 1 : null) != null && h.E(this.aVS, bVar.aVS) && h.E(this.message, bVar.message)) {
                    if ((this.djs == bVar.djs ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String id = Jf();
        int i = 0;
        int hashCode = (id != null ? id.hashCode() : 0) * 31;
        String str = this.userId;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aWO;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.dia;
        hashCode = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.djr) * 31;
        str = this.aVS;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.message;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.djs;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatItem(id=");
        stringBuilder.append(Jf());
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", avatar=");
        stringBuilder.append(this.aWO);
        stringBuilder.append(", initials=");
        stringBuilder.append(this.dia);
        stringBuilder.append(", avatarColor=");
        stringBuilder.append(this.djr);
        stringBuilder.append(", author=");
        stringBuilder.append(this.aVS);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", isLarge=");
        stringBuilder.append(this.djs);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(String str, String str2, String str3, String str4, int i, String str5, String str6, boolean z) {
        h.e(str, "id");
        h.e(str2, "userId");
        h.e(str4, "initials");
        h.e(str5, "author");
        h.e(str6, "message");
        this.id = str;
        this.userId = str2;
        this.aWO = str3;
        this.dia = str4;
        this.djr = i;
        this.aVS = str5;
        this.message = str6;
        this.djs = z;
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, int i, String str5, String str6, boolean z, int i2, f fVar) {
        int i3 = i2;
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? (String) null : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? com.iqoption.quiz.c.a.aCR()[0] : i, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) != 0 ? false : z);
    }

    public final String Wj() {
        return this.aWO;
    }

    public final String getInitials() {
        return this.dia;
    }

    public final int aAV() {
        return this.djr;
    }

    public final String VP() {
        return this.aVS;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean aAW() {
        return this.djs;
    }
}
