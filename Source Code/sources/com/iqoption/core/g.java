package com.iqoption.core;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\tR\u0012\u0010\u0019\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u0012\u0010\u001b\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\r¨\u0006\u001e"}, aXE = {"Lcom/iqoption/core/IQAccount;", "", "avatar", "Lcom/iqoption/core/microservices/avatar/Avatar;", "getAvatar", "()Lcom/iqoption/core/microservices/avatar/Avatar;", "countryCode", "", "getCountryCode", "()Ljava/lang/String;", "countryId", "", "getCountryId", "()J", "email", "getEmail", "firstName", "getFirstName", "isAuthorized", "", "()Z", "isRegulated", "isTrial", "lastName", "getLastName", "userGroupId", "getUserGroupId", "userId", "getUserId", "Companion", "core_release"})
/* compiled from: IQAccount.kt */
public interface g {
    public static final a aMs = a.aMu;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/IQAccount$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/core/IQAccount;", "getEMPTY", "()Lcom/iqoption/core/IQAccount;", "core_release"})
    /* compiled from: IQAccount.kt */
    public static final class a {
        private static final g aMt = new a();
        static final /* synthetic */ a aMu = new a();

        @i(aXC = {1, 1, 11}, aXD = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0014\u0010\u0019\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, aXE = {"com/iqoption/core/IQAccount$Companion$EMPTY$1", "Lcom/iqoption/core/IQAccount;", "avatar", "Lcom/iqoption/core/microservices/avatar/Avatar;", "getAvatar", "()Lcom/iqoption/core/microservices/avatar/Avatar;", "countryCode", "", "getCountryCode", "()Ljava/lang/String;", "countryId", "", "getCountryId", "()J", "email", "getEmail", "firstName", "getFirstName", "isAuthorized", "", "()Z", "isRegulated", "isTrial", "lastName", "getLastName", "userGroupId", "getUserGroupId", "userId", "getUserId", "core_release"})
        /* compiled from: IQAccount.kt */
        public static final class a implements g {
            private final boolean aMv;
            private final long aki = -1;
            private final String akj;
            private final long aqq = -1;
            private final com.iqoption.core.microservices.avatar.a avatar;
            private final String email = "";
            private final String firstName;
            private final String lastName;
            private final long userId = -1;

            a() {
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

            public String getFirstName() {
                return this.firstName;
            }

            public String getLastName() {
                return this.lastName;
            }

            public com.iqoption.core.microservices.avatar.a getAvatar() {
                return this.avatar;
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
        }

        private a() {
        }
    }

    long Db();

    boolean Dh();

    long Dj();

    com.iqoption.core.microservices.avatar.a getAvatar();

    String getCountryCode();

    String getEmail();

    String getFirstName();

    String getLastName();

    long getUserId();
}
