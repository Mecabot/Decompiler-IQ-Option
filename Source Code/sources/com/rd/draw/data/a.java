package com.rd.draw.data;

import android.support.annotation.NonNull;
import com.rd.animation.type.AnimationType;

/* compiled from: Indicator */
public class a {
    private int count = 3;
    private int dMk;
    private int dxD;
    private int ehF;
    private long ehL;
    private int eiA;
    private boolean eiB;
    private boolean eiC;
    private boolean eiD;
    private int eiE;
    private int eiF;
    private int eiG = -1;
    private Orientation eiH;
    private AnimationType eiI;
    private RtlMode eiJ;
    private float eia;
    private int height;
    private int padding;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int radius;
    private int width;

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int i) {
        this.radius = i;
    }

    public int getPadding() {
        return this.padding;
    }

    public void setPadding(int i) {
        this.padding = i;
    }

    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    public void setPaddingLeft(int i) {
        this.paddingLeft = i;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }

    public void setPaddingTop(int i) {
        this.paddingTop = i;
    }

    public int getPaddingRight() {
        return this.paddingRight;
    }

    public void setPaddingRight(int i) {
        this.paddingRight = i;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public int aSS() {
        return this.ehF;
    }

    public void it(int i) {
        this.ehF = i;
    }

    public float getScaleFactor() {
        return this.eia;
    }

    public void setScaleFactor(float f) {
        this.eia = f;
    }

    public int getUnselectedColor() {
        return this.eiA;
    }

    public void setUnselectedColor(int i) {
        this.eiA = i;
    }

    public int getSelectedColor() {
        return this.dxD;
    }

    public void setSelectedColor(int i) {
        this.dxD = i;
    }

    public boolean aTb() {
        return this.eiB;
    }

    public void setInteractiveAnimation(boolean z) {
        this.eiB = z;
    }

    public boolean aTc() {
        return this.eiC;
    }

    public void setAutoVisibility(boolean z) {
        this.eiC = z;
    }

    public boolean aTd() {
        return this.eiD;
    }

    public void setDynamicCount(boolean z) {
        this.eiD = z;
    }

    public long getAnimationDuration() {
        return this.ehL;
    }

    public void setAnimationDuration(long j) {
        this.ehL = j;
    }

    public int aTe() {
        return this.eiE;
    }

    public void cD(int i) {
        this.eiE = i;
    }

    public int aTf() {
        return this.eiF;
    }

    public void iC(int i) {
        this.eiF = i;
    }

    public int aTg() {
        return this.dMk;
    }

    public void iD(int i) {
        this.dMk = i;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    @NonNull
    public Orientation aTh() {
        if (this.eiH == null) {
            this.eiH = Orientation.HORIZONTAL;
        }
        return this.eiH;
    }

    public void setOrientation(Orientation orientation) {
        this.eiH = orientation;
    }

    @NonNull
    public AnimationType aTi() {
        if (this.eiI == null) {
            this.eiI = AnimationType.NONE;
        }
        return this.eiI;
    }

    public void setAnimationType(AnimationType animationType) {
        this.eiI = animationType;
    }

    @NonNull
    public RtlMode aTj() {
        if (this.eiJ == null) {
            this.eiJ = RtlMode.Off;
        }
        return this.eiJ;
    }

    public void setRtlMode(RtlMode rtlMode) {
        this.eiJ = rtlMode;
    }

    public int aTk() {
        return this.eiG;
    }

    public void iE(int i) {
        this.eiG = i;
    }
}
