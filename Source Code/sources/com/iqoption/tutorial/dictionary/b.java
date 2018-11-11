package com.iqoption.tutorial.dictionary;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, aXE = {"Lcom/iqoption/tutorial/dictionary/TutorialStep;", "", "stepId", "", "action", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "coolDownSec", "", "(Ljava/lang/String;Lcom/iqoption/tutorial/dictionary/TutorialAction;J)V", "getAction", "()Lcom/iqoption/tutorial/dictionary/TutorialAction;", "getCoolDownSec", "()J", "getStepId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialStep.kt */
public final class b {
    @SerializedName("step_id")
    private final String dux;
    @SerializedName("action")
    private final TutorialAction duy;
    @SerializedName("cooldown_sec")
    private final long duz;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.E(this.dux, bVar.dux) && h.E(this.duy, bVar.duy)) {
                if ((this.duz == bVar.duz ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.dux;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        TutorialAction tutorialAction = this.duy;
        if (tutorialAction != null) {
            i = tutorialAction.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        long j = this.duz;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TutorialStep(stepId=");
        stringBuilder.append(this.dux);
        stringBuilder.append(", action=");
        stringBuilder.append(this.duy);
        stringBuilder.append(", coolDownSec=");
        stringBuilder.append(this.duz);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final TutorialAction aFI() {
        return this.duy;
    }

    public final long aFJ() {
        return this.duz;
    }
}
