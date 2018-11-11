package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: JobInvocation */
final class q implements r {
    @NonNull
    private final String Kh;
    @NonNull
    private final u Ki;
    private final x Kj;
    private final int Kk;
    private final boolean Kl;
    @NonNull
    private final int[] Km;
    private final boolean Kn;
    private final z Kp;
    @NonNull
    private final Bundle extras;
    @NonNull
    private final String tag;

    /* compiled from: JobInvocation */
    static final class a {
        @NonNull
        private String Kh;
        @NonNull
        private u Ki;
        private x Kj;
        private int Kk;
        private boolean Kl;
        @NonNull
        private int[] Km;
        private boolean Kn;
        private z Kp;
        @NonNull
        private final Bundle extras = new Bundle();
        @NonNull
        private String tag;

        a() {
        }

        q oP() {
            if (this.tag != null && this.Kh != null && this.Ki != null) {
                return new q(this);
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }

        public a cw(@NonNull String str) {
            this.tag = str;
            return this;
        }

        public a cx(@NonNull String str) {
            this.Kh = str;
            return this;
        }

        public a c(@NonNull u uVar) {
            this.Ki = uVar;
            return this;
        }

        public a X(boolean z) {
            this.Kl = z;
            return this;
        }

        public a as(int i) {
            this.Kk = i;
            return this;
        }

        public a h(@NonNull int[] iArr) {
            this.Km = iArr;
            return this;
        }

        public a G(Bundle bundle) {
            if (bundle != null) {
                this.extras.putAll(bundle);
            }
            return this;
        }

        public a c(x xVar) {
            this.Kj = xVar;
            return this;
        }

        public a Y(boolean z) {
            this.Kn = z;
            return this;
        }

        public a a(z zVar) {
            this.Kp = zVar;
            return this;
        }
    }

    private q(a aVar) {
        this.tag = aVar.tag;
        this.Kh = aVar.Kh;
        this.Ki = aVar.Ki;
        this.Kj = aVar.Kj;
        this.Kl = aVar.Kl;
        this.Kk = aVar.Kk;
        this.Km = aVar.Km;
        this.extras = aVar.extras;
        this.Kn = aVar.Kn;
        this.Kp = aVar.Kp;
    }

    @NonNull
    public String oN() {
        return this.Kh;
    }

    @NonNull
    public String getTag() {
        return this.tag;
    }

    @NonNull
    public u oL() {
        return this.Ki;
    }

    public int getLifetime() {
        return this.Kk;
    }

    public boolean oM() {
        return this.Kl;
    }

    @NonNull
    public int[] oI() {
        return this.Km;
    }

    @NonNull
    public Bundle getExtras() {
        return this.extras;
    }

    @NonNull
    public x oJ() {
        return this.Kj;
    }

    public boolean oK() {
        return this.Kn;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        q qVar = (q) obj;
        if (!(this.tag.equals(qVar.tag) && this.Kh.equals(qVar.Kh))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.tag.hashCode() * 31) + this.Kh.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JobInvocation{tag='");
        stringBuilder.append(JSONObject.quote(this.tag));
        stringBuilder.append('\'');
        stringBuilder.append(", service='");
        stringBuilder.append(this.Kh);
        stringBuilder.append('\'');
        stringBuilder.append(", trigger=");
        stringBuilder.append(this.Ki);
        stringBuilder.append(", recurring=");
        stringBuilder.append(this.Kl);
        stringBuilder.append(", lifetime=");
        stringBuilder.append(this.Kk);
        stringBuilder.append(", constraints=");
        stringBuilder.append(Arrays.toString(this.Km));
        stringBuilder.append(", extras=");
        stringBuilder.append(this.extras);
        stringBuilder.append(", retryStrategy=");
        stringBuilder.append(this.Kj);
        stringBuilder.append(", replaceCurrent=");
        stringBuilder.append(this.Kn);
        stringBuilder.append(", triggerReason=");
        stringBuilder.append(this.Kp);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
