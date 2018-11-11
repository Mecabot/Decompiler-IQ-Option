package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: Job */
public final class n implements r {
    private final String Kh;
    private final u Ki;
    private final x Kj;
    private final int Kk;
    private final boolean Kl;
    private final int[] Km;
    private final boolean Kn;
    private final Bundle extras;
    private final String tag;

    /* compiled from: Job */
    public static final class a implements r {
        private final ValidationEnforcer JN;
        private u Ki = y.KT;
        private x Kj = x.KK;
        private int Kk = 1;
        private boolean Kl = false;
        private int[] Km;
        private boolean Kn = false;
        private String Ko;
        private Bundle extras;
        private String tag;

        a(ValidationEnforcer validationEnforcer) {
            this.JN = validationEnforcer;
        }

        a(ValidationEnforcer validationEnforcer, r rVar) {
            this.JN = validationEnforcer;
            this.tag = rVar.getTag();
            this.Ko = rVar.oN();
            this.Ki = rVar.oL();
            this.Kl = rVar.oM();
            this.Kk = rVar.getLifetime();
            this.Km = rVar.oI();
            this.extras = rVar.getExtras();
            this.Kj = rVar.oJ();
        }

        public a V(boolean z) {
            this.Kn = z;
            return this;
        }

        public n oO() {
            this.JN.g(this);
            return new n(this);
        }

        @NonNull
        public String oN() {
            return this.Ko;
        }

        public a k(Class<? extends s> cls) {
            this.Ko = cls == null ? null : cls.getName();
            return this;
        }

        @NonNull
        public String getTag() {
            return this.tag;
        }

        public a cu(String str) {
            this.tag = str;
            return this;
        }

        @NonNull
        public u oL() {
            return this.Ki;
        }

        public a b(u uVar) {
            this.Ki = uVar;
            return this;
        }

        public int getLifetime() {
            return this.Kk;
        }

        public a ar(int i) {
            this.Kk = i;
            return this;
        }

        public boolean oM() {
            return this.Kl;
        }

        public a W(boolean z) {
            this.Kl = z;
            return this;
        }

        public int[] oI() {
            return this.Km == null ? new int[0] : this.Km;
        }

        public a g(int... iArr) {
            this.Km = iArr;
            return this;
        }

        @Nullable
        public Bundle getExtras() {
            return this.extras;
        }

        @NonNull
        public x oJ() {
            return this.Kj;
        }

        public a b(x xVar) {
            this.Kj = xVar;
            return this;
        }

        public boolean oK() {
            return this.Kn;
        }
    }

    private n(a aVar) {
        this.Kh = aVar.Ko;
        this.extras = aVar.extras == null ? null : new Bundle(aVar.extras);
        this.tag = aVar.tag;
        this.Ki = aVar.Ki;
        this.Kj = aVar.Kj;
        this.Kk = aVar.Kk;
        this.Kl = aVar.Kl;
        this.Km = aVar.Km != null ? aVar.Km : new int[0];
        this.Kn = aVar.Kn;
    }

    @NonNull
    public int[] oI() {
        return this.Km;
    }

    @Nullable
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
    public String oN() {
        return this.Kh;
    }
}
