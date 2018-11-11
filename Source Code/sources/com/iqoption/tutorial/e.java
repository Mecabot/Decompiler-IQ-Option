package com.iqoption.tutorial;

import android.support.v4.app.FragmentManager;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, aXE = {"Lcom/iqoption/tutorial/TutorialObserver;", "", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "targetProvider", "Lcom/iqoption/tutorial/TutorialTargetProvider;", "opportunityChecker", "Lcom/iqoption/tutorial/TutorialOpportunityChecker;", "nextStepListener", "Lcom/iqoption/tutorial/NextStepListener;", "toastListener", "Lcom/iqoption/tutorial/TutorialToastListener;", "waitCoolDown", "", "(Landroid/support/v4/app/FragmentManager;Lcom/iqoption/tutorial/TutorialTargetProvider;Lcom/iqoption/tutorial/TutorialOpportunityChecker;Lcom/iqoption/tutorial/NextStepListener;Lcom/iqoption/tutorial/TutorialToastListener;Z)V", "getFragmentManager", "()Landroid/support/v4/app/FragmentManager;", "getNextStepListener", "()Lcom/iqoption/tutorial/NextStepListener;", "getOpportunityChecker", "()Lcom/iqoption/tutorial/TutorialOpportunityChecker;", "getTargetProvider", "()Lcom/iqoption/tutorial/TutorialTargetProvider;", "getToastListener", "()Lcom/iqoption/tutorial/TutorialToastListener;", "getWaitCoolDown", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialViewModel.kt */
public final class e {
    private final FragmentManager cKu;
    private final g dud;
    private final f due;
    private final a duf;
    private final h dug;
    private final boolean duh;

    public e(FragmentManager fragmentManager, g gVar, f fVar, a aVar, h hVar) {
        this(fragmentManager, gVar, fVar, aVar, hVar, false, 32, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (h.E(this.cKu, eVar.cKu) && h.E(this.dud, eVar.dud) && h.E(this.due, eVar.due) && h.E(this.duf, eVar.duf) && h.E(this.dug, eVar.dug)) {
                if ((this.duh == eVar.duh ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        FragmentManager fragmentManager = this.cKu;
        int i = 0;
        int hashCode = (fragmentManager != null ? fragmentManager.hashCode() : 0) * 31;
        g gVar = this.dud;
        hashCode = (hashCode + (gVar != null ? gVar.hashCode() : 0)) * 31;
        f fVar = this.due;
        hashCode = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 31;
        a aVar = this.duf;
        hashCode = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        h hVar = this.dug;
        if (hVar != null) {
            i = hVar.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.duh;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TutorialObserver(fragmentManager=");
        stringBuilder.append(this.cKu);
        stringBuilder.append(", targetProvider=");
        stringBuilder.append(this.dud);
        stringBuilder.append(", opportunityChecker=");
        stringBuilder.append(this.due);
        stringBuilder.append(", nextStepListener=");
        stringBuilder.append(this.duf);
        stringBuilder.append(", toastListener=");
        stringBuilder.append(this.dug);
        stringBuilder.append(", waitCoolDown=");
        stringBuilder.append(this.duh);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public e(FragmentManager fragmentManager, g gVar, f fVar, a aVar, h hVar, boolean z) {
        h.e(fragmentManager, "fragmentManager");
        h.e(gVar, "targetProvider");
        h.e(fVar, "opportunityChecker");
        h.e(aVar, "nextStepListener");
        this.cKu = fragmentManager;
        this.dud = gVar;
        this.due = fVar;
        this.duf = aVar;
        this.dug = hVar;
        this.duh = z;
    }

    public final FragmentManager getFragmentManager() {
        return this.cKu;
    }

    public final g aFs() {
        return this.dud;
    }

    public final f aFt() {
        return this.due;
    }

    public final a aFu() {
        return this.duf;
    }

    public final h aFv() {
        return this.dug;
    }

    public /* synthetic */ e(FragmentManager fragmentManager, g gVar, f fVar, a aVar, h hVar, boolean z, int i, f fVar2) {
        this(fragmentManager, gVar, fVar, aVar, hVar, (i & 32) != 0 ? true : z);
    }

    public final boolean aFw() {
        return this.duh;
    }
}
