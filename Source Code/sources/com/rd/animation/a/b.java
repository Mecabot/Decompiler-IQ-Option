package com.rd.animation.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.rd.animation.type.DropAnimation;
import com.rd.animation.type.c;
import com.rd.animation.type.d;
import com.rd.animation.type.e;
import com.rd.animation.type.f;
import com.rd.animation.type.g;
import com.rd.animation.type.h;
import com.rd.animation.type.i;

/* compiled from: ValueController */
public class b {
    private g ehA;
    private e ehB;
    private a ehC;
    private com.rd.animation.type.b eht;
    private d ehu;
    private i ehv;
    private f ehw;
    private c ehx;
    private h ehy;
    private DropAnimation ehz;

    /* compiled from: ValueController */
    public interface a {
        void a(@Nullable com.rd.animation.b.a aVar);
    }

    public b(@Nullable a aVar) {
        this.ehC = aVar;
    }

    @NonNull
    public com.rd.animation.type.b aSH() {
        if (this.eht == null) {
            this.eht = new com.rd.animation.type.b(this.ehC);
        }
        return this.eht;
    }

    @NonNull
    public d aSI() {
        if (this.ehu == null) {
            this.ehu = new d(this.ehC);
        }
        return this.ehu;
    }

    @NonNull
    public i aSJ() {
        if (this.ehv == null) {
            this.ehv = new i(this.ehC);
        }
        return this.ehv;
    }

    @NonNull
    public f aSK() {
        if (this.ehw == null) {
            this.ehw = new f(this.ehC);
        }
        return this.ehw;
    }

    @NonNull
    public c aSL() {
        if (this.ehx == null) {
            this.ehx = new c(this.ehC);
        }
        return this.ehx;
    }

    @NonNull
    public h aSM() {
        if (this.ehy == null) {
            this.ehy = new h(this.ehC);
        }
        return this.ehy;
    }

    @NonNull
    public DropAnimation aSN() {
        if (this.ehz == null) {
            this.ehz = new DropAnimation(this.ehC);
        }
        return this.ehz;
    }

    @NonNull
    public g aSO() {
        if (this.ehA == null) {
            this.ehA = new g(this.ehC);
        }
        return this.ehA;
    }

    @NonNull
    public e aSP() {
        if (this.ehB == null) {
            this.ehB = new e(this.ehC);
        }
        return this.ehB;
    }
}
