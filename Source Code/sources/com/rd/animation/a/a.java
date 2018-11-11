package com.rd.animation.a;

import android.support.annotation.NonNull;
import com.rd.draw.data.Orientation;

/* compiled from: AnimationController */
public class a {
    private b ehn;
    private com.rd.animation.a.b.a eho;
    private com.rd.animation.type.a ehp;
    private com.rd.draw.data.a ehq;
    private boolean ehr;
    private float jg;

    public a(@NonNull com.rd.draw.data.a aVar, @NonNull com.rd.animation.a.b.a aVar2) {
        this.ehn = new b(aVar2);
        this.eho = aVar2;
        this.ehq = aVar;
    }

    public void V(float f) {
        this.ehr = true;
        this.jg = f;
        aSx();
    }

    public void aSw() {
        this.ehr = false;
        this.jg = 0.0f;
        aSx();
    }

    public void end() {
        if (this.ehp != null) {
            this.ehp.end();
        }
    }

    private void aSx() {
        switch (this.ehq.aTi()) {
            case NONE:
                this.eho.a(null);
                return;
            case COLOR:
                aSy();
                return;
            case SCALE:
                aSz();
                return;
            case WORM:
                aSA();
                return;
            case FILL:
                aSC();
                return;
            case SLIDE:
                aSB();
                return;
            case THIN_WORM:
                aSD();
                return;
            case DROP:
                aSE();
                return;
            case SWAP:
                aSF();
                return;
            case SCALE_DOWN:
                aSG();
                return;
            default:
                return;
        }
    }

    private void aSy() {
        int selectedColor = this.ehq.getSelectedColor();
        int unselectedColor = this.ehq.getUnselectedColor();
        com.rd.animation.type.a cI = this.ehn.aSH().aM(unselectedColor, selectedColor).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cI.W(this.jg);
        } else {
            cI.start();
        }
        this.ehp = cI;
    }

    private void aSz() {
        int selectedColor = this.ehq.getSelectedColor();
        int unselectedColor = this.ehq.getUnselectedColor();
        int radius = this.ehq.getRadius();
        float scaleFactor = this.ehq.getScaleFactor();
        com.rd.animation.type.a cI = this.ehn.aSI().a(unselectedColor, selectedColor, radius, scaleFactor).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cI.W(this.jg);
        } else {
            cI.start();
        }
        this.ehp = cI;
    }

    private void aSA() {
        int aTe = this.ehq.aTb() ? this.ehq.aTe() : this.ehq.aTg();
        int aTf = this.ehq.aTb() ? this.ehq.aTf() : this.ehq.aTe();
        com.rd.animation.type.a cL = this.ehn.aSJ().a(com.rd.b.a.a(this.ehq, aTe), com.rd.b.a.a(this.ehq, aTf), this.ehq.getRadius(), aTf > aTe).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cL.W(this.jg);
        } else {
            cL.start();
        }
        this.ehp = cL;
    }

    private void aSB() {
        com.rd.animation.type.a cI = this.ehn.aSK().aO(com.rd.b.a.a(this.ehq, this.ehq.aTb() ? this.ehq.aTe() : this.ehq.aTg()), com.rd.b.a.a(this.ehq, this.ehq.aTb() ? this.ehq.aTf() : this.ehq.aTe())).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cI.W(this.jg);
        } else {
            cI.start();
        }
        this.ehp = cI;
    }

    private void aSC() {
        int selectedColor = this.ehq.getSelectedColor();
        int unselectedColor = this.ehq.getUnselectedColor();
        int radius = this.ehq.getRadius();
        int aSS = this.ehq.aSS();
        com.rd.animation.type.a cI = this.ehn.aSL().h(unselectedColor, selectedColor, radius, aSS).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cI.W(this.jg);
        } else {
            cI.start();
        }
        this.ehp = cI;
    }

    private void aSD() {
        int aTe = this.ehq.aTb() ? this.ehq.aTe() : this.ehq.aTg();
        int aTf = this.ehq.aTb() ? this.ehq.aTf() : this.ehq.aTe();
        com.rd.animation.type.a cL = this.ehn.aSM().a(com.rd.b.a.a(this.ehq, aTe), com.rd.b.a.a(this.ehq, aTf), this.ehq.getRadius(), aTf > aTe).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cL.W(this.jg);
        } else {
            cL.start();
        }
        this.ehp = cL;
    }

    private void aSE() {
        int aTe = this.ehq.aTb() ? this.ehq.aTe() : this.ehq.aTg();
        int aTf = this.ehq.aTb() ? this.ehq.aTf() : this.ehq.aTe();
        int a = com.rd.b.a.a(this.ehq, aTe);
        int a2 = com.rd.b.a.a(this.ehq, aTf);
        aTe = this.ehq.getPaddingTop();
        aTf = this.ehq.getPaddingLeft();
        if (this.ehq.aTh() != Orientation.HORIZONTAL) {
            aTe = aTf;
        }
        int radius = this.ehq.getRadius();
        com.rd.animation.type.a b = this.ehn.aSN().cI(this.ehq.getAnimationDuration()).b(a, a2, (radius * 3) + aTe, radius + aTe, radius);
        if (this.ehr) {
            b.W(this.jg);
        } else {
            b.start();
        }
        this.ehp = b;
    }

    private void aSF() {
        com.rd.animation.type.a cI = this.ehn.aSO().aP(com.rd.b.a.a(this.ehq, this.ehq.aTb() ? this.ehq.aTe() : this.ehq.aTg()), com.rd.b.a.a(this.ehq, this.ehq.aTb() ? this.ehq.aTf() : this.ehq.aTe())).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cI.W(this.jg);
        } else {
            cI.start();
        }
        this.ehp = cI;
    }

    private void aSG() {
        int selectedColor = this.ehq.getSelectedColor();
        int unselectedColor = this.ehq.getUnselectedColor();
        int radius = this.ehq.getRadius();
        float scaleFactor = this.ehq.getScaleFactor();
        com.rd.animation.type.a cI = this.ehn.aSP().a(unselectedColor, selectedColor, radius, scaleFactor).cI(this.ehq.getAnimationDuration());
        if (this.ehr) {
            cI.W(this.jg);
        } else {
            cI.start();
        }
        this.ehp = cI;
    }
}
