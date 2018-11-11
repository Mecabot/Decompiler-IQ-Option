package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.content.k;
import java.util.List;

/* compiled from: ShapeContent */
public class p implements l, a {
    private final h iS;
    @Nullable
    private r kE;
    private boolean kL;
    private final Path kr = new Path();
    private final com.airbnb.lottie.a.b.a<?, Path> lm;
    private final String name;

    public p(h hVar, com.airbnb.lottie.model.layer.a aVar, k kVar) {
        this.name = kVar.getName();
        this.iS = hVar;
        this.lm = kVar.eH().dW();
        aVar.a(this.lm);
        this.lm.b(this);
    }

    public void dp() {
        invalidate();
    }

    private void invalidate() {
        this.kL = false;
        this.iS.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.dy() == Type.Simultaneously) {
                    this.kE = rVar;
                    this.kE.a(this);
                }
            }
        }
    }

    public Path getPath() {
        if (this.kL) {
            return this.kr;
        }
        this.kr.reset();
        this.kr.set((Path) this.lm.getValue());
        this.kr.setFillType(FillType.EVEN_ODD);
        f.a(this.kr, this.kE);
        this.kL = true;
        return this.kr;
    }

    public String getName() {
        return this.name;
    }
}
