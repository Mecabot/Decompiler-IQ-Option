package com.iqoption.tutorial;

import android.content.Context;
import android.content.SharedPreferences;
import com.iqoption.app.af;
import com.iqoption.tutorial.dictionary.TutorialAction;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\r\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J\u0015\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/tutorial/TutorialActionsRepository;", "", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "addPerformedAction", "", "action", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "clearPerformedActions", "", "getPerformedActions", "", "", "getStepTime", "", "()Ljava/lang/Long;", "isTutorialSuitableForUser", "setDepAfterRegistration", "deposit", "setFirstPopupShown", "shown", "setIsTutorialSuitableForUser", "suitable", "updateStepTime", "nextTime", "(Ljava/lang/Long;)V", "wasDepAfterRegistration", "wasFirstPopupShown", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialActionsRepository.kt */
public final class b {
    public static final a dtS = new a();
    private final SharedPreferences alq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/tutorial/TutorialActionsRepository$Companion;", "", "()V", "IS_SHOWING", "", "PREFERENCES_ACTIONS", "", "PREFERENCES_DEPOSIT_AFTER_REGISTRATION", "PREFERENCES_FIRST_POPUP_SHOWN", "PREFERENCES_IS_SUITABLE_FOR_USER", "PREFERENCES_NEXT_STEP_TIME", "newInstance", "Lcom/iqoption/tutorial/TutorialActionsRepository;", "context", "Landroid/content/Context;", "userId", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialActionsRepository.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b bO(Context context) {
            h.e(context, "context");
            return d(context, com.iqoption.app.a.aL(context).getUserId());
        }

        public final b d(Context context, long j) {
            h.e(context, "context");
            SharedPreferences Z = af.aR(context).Z(j);
            h.d(Z, "preferences");
            return new b(Z, null);
        }
    }

    public static final b bO(Context context) {
        return dtS.bO(context);
    }

    private b(SharedPreferences sharedPreferences) {
        this.alq = sharedPreferences;
    }

    public /* synthetic */ b(SharedPreferences sharedPreferences, f fVar) {
        this(sharedPreferences);
    }

    public final void eZ(boolean z) {
        this.alq.edit().putBoolean("IS_SUITABLE_FOR_USER", z).apply();
    }

    public final boolean aFi() {
        return this.alq.getBoolean("IS_SUITABLE_FOR_USER", false);
    }

    public final void fa(boolean z) {
        this.alq.edit().putBoolean("DEPOSIT_AFTER_REGISTRATION", z).apply();
    }

    public final boolean aFj() {
        return this.alq.getBoolean("DEPOSIT_AFTER_REGISTRATION", false);
    }

    public final void fb(boolean z) {
        this.alq.edit().putBoolean("PREFERENCES_FIRST_POPUP_SHOWN", z).apply();
    }

    public final boolean aFk() {
        return this.alq.getBoolean("PREFERENCES_FIRST_POPUP_SHOWN", false);
    }

    public final void D(Long l) {
        if (l != null) {
            this.alq.edit().putLong("NEXT_TIME", l.longValue()).apply();
        } else {
            this.alq.edit().remove("NEXT_TIME").apply();
        }
    }

    public final Long aFl() {
        return this.alq.contains("NEXT_TIME") ? Long.valueOf(this.alq.getLong("NEXT_TIME", 0)) : null;
    }

    public final Set<String> aFm() {
        Set<String> stringSet;
        synchronized (j.F(b.class)) {
            stringSet = this.alq.getStringSet("ACTIONS", new LinkedHashSet());
            h.d(stringSet, "preferences.getStringSet…, mutableSetOf<String>())");
        }
        return stringSet;
    }

    public final boolean b(TutorialAction tutorialAction) {
        boolean add;
        h.e(tutorialAction, "action");
        synchronized (j.F(b.class)) {
            Set aFm = aFm();
            add = aFm.add(tutorialAction.getValue());
            this.alq.edit().putStringSet("ACTIONS", aFm).apply();
        }
        return add;
    }
}
