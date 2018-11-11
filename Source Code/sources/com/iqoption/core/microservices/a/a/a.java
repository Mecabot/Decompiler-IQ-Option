package com.iqoption.core.microservices.a.a;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.g;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\r8\u0016XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u00020\r8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\r8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u0006 "}, aXE = {"Lcom/iqoption/core/microservices/auth/response/Profile;", "Lcom/iqoption/core/IQAccount;", "()V", "userId", "", "userGroupId", "email", "", "firstName", "lastName", "countryCode", "countryId", "isRegulated", "", "isTrial", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZ)V", "avatar", "Lcom/iqoption/core/microservices/avatar/Avatar;", "getAvatar", "()Lcom/iqoption/core/microservices/avatar/Avatar;", "getCountryCode", "()Ljava/lang/String;", "getCountryId", "()J", "getEmail", "getFirstName", "isAuthorized", "()Z", "getLastName", "getUserGroupId", "getUserId", "Companion", "core_release"})
/* compiled from: Profile.kt */
public final class a implements g {
    private static final a aSN = new a();
    public static final a aSO = new a();
    @SerializedName("is_regulated")
    private final boolean aMv;
    private final transient boolean aSL;
    @SerializedName("is_trial")
    private final boolean aSM;
    @SerializedName("country_id")
    private final long aki;
    @SerializedName("country_code")
    private final String akj;
    @SerializedName("group_id")
    private final long aqq;
    private final transient com.iqoption.core.microservices.avatar.a avatar;
    @SerializedName("email")
    private final String email;
    @SerializedName("first_name")
    private final String firstName;
    @SerializedName("last_name")
    private final String lastName;
    @SerializedName("id")
    private final long userId;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/auth/response/Profile$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/core/microservices/auth/response/Profile;", "getEMPTY", "()Lcom/iqoption/core/microservices/auth/response/Profile;", "core_release"})
    /* compiled from: Profile.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a Uo() {
            return a.aSN;
        }
    }

    public a(long j, long j2, String str, String str2, String str3, String str4, long j3, boolean z, boolean z2) {
        h.e(str, "email");
        this.userId = j;
        this.aqq = j2;
        this.email = str;
        this.firstName = str2;
        this.lastName = str3;
        this.akj = str4;
        this.aki = j3;
        this.aMv = z;
        this.aSM = z2;
        this.aSL = true;
    }

    public long getUserId() {
        return this.userId;
    }

    public long Dj() {
        return this.aqq;
    }

    public String getEmail() {
        return this.email;
    }

    public /* synthetic */ a(long j, long j2, String str, String str2, String str3, String str4, long j3, boolean z, boolean z2, int i, f fVar) {
        int i2 = i;
        this((i2 & 1) != 0 ? -1 : j, (i2 & 2) != 0 ? -1 : j2, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? (String) null : str2, (i2 & 16) != 0 ? (String) null : str3, (i2 & 32) != 0 ? (String) null : str4, (i2 & 64) != 0 ? -1 : j3, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? false : z2);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCountryCode() {
        return this.akj;
    }

    public long Db() {
        return this.aki;
    }

    public boolean Dh() {
        return this.aMv;
    }

    public com.iqoption.core.microservices.avatar.a getAvatar() {
        return this.avatar;
    }

    public a() {
        this(-1, 0, null, null, null, null, 0, false, false, 510, null);
    }
}
