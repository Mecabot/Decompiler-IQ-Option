package com.iqoption.tutorial.utils;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, aXE = {"Lcom/iqoption/tutorial/utils/AnimDurations;", "", "moving", "", "startDelay", "endDelay", "(JJJ)V", "getEndDelay", "()J", "getMoving", "getStartDelay", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialOptions.kt */
public final class a {
    private final long duD;
    private final long duE;
    private final long duF;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((this.duD == aVar.duD ? 1 : null) != null) {
                if ((this.duE == aVar.duE ? 1 : null) != null) {
                    if ((this.duF == aVar.duF ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.duD;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.duE;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = this.duF;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AnimDurations(moving=");
        stringBuilder.append(this.duD);
        stringBuilder.append(", startDelay=");
        stringBuilder.append(this.duE);
        stringBuilder.append(", endDelay=");
        stringBuilder.append(this.duF);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, long j2, long j3) {
        this.duD = j;
        this.duE = j2;
        this.duF = j3;
    }

    public final long aFR() {
        return this.duD;
    }

    public final long getStartDelay() {
        return this.duE;
    }

    public final long aFS() {
        return this.duF;
    }
}
