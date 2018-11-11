package com.iqoption.quiz;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0007J\b\u0010\u0014\u001a\u00020\u000fH\u0007J\b\u0010\u0015\u001a\u00020\u000fH\u0007J\b\u0010\u0016\u001a\u00020\u000fH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, aXE = {"Lcom/iqoption/quiz/QuizDelegate;", "Landroid/arch/lifecycle/LifecycleOwner;", "Landroid/arch/lifecycle/LifecycleObserver;", "f", "Lcom/iqoption/quiz/QuizFragment;", "(Lcom/iqoption/quiz/QuizFragment;)V", "getF", "()Lcom/iqoption/quiz/QuizFragment;", "lifecycle", "Landroid/arch/lifecycle/LifecycleRegistry;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "create", "", "destroy", "getLifecycle", "Landroid/arch/lifecycle/Lifecycle;", "pause", "resume", "start", "stop", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizDelegate.kt */
public abstract class QuizDelegate implements LifecycleObserver, LifecycleOwner {
    public static final a dgu = new a();
    private final LifecycleRegistry dgs = new LifecycleRegistry(this);
    private final QuizFragment dgt;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/quiz/QuizDelegate$Companion;", "", "()V", "showInfo", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizDelegate.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void v(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            com.iqoption.quiz.a.a.did.azV();
            com.iqoption.fragment.dialog.whatsnew.a.d(fragmentActivity, "WHATS_NEW_DIALOG_TYPE_QUIZ");
        }
    }

    public abstract View getView();

    public QuizDelegate(QuizFragment quizFragment) {
        h.e(quizFragment, "f");
        this.dgt = quizFragment;
        this.dgt.getLifecycle().a(this);
    }

    public final QuizFragment azc() {
        return this.dgt;
    }

    public Lifecycle getLifecycle() {
        return this.dgs;
    }

    @OnLifecycleEvent(R = Event.ON_CREATE)
    public final void create() {
        this.dgs.b(Event.ON_CREATE);
    }

    @OnLifecycleEvent(R = Event.ON_START)
    public final void start() {
        this.dgs.b(Event.ON_START);
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    public final void stop() {
        this.dgs.b(Event.ON_STOP);
    }

    @OnLifecycleEvent(R = Event.ON_RESUME)
    public final void resume() {
        this.dgs.b(Event.ON_RESUME);
    }

    @OnLifecycleEvent(R = Event.ON_PAUSE)
    public final void pause() {
        this.dgs.b(Event.ON_PAUSE);
    }

    @OnLifecycleEvent(R = Event.ON_DESTROY)
    public void destroy() {
        this.dgs.b(Event.ON_DESTROY);
        this.dgt.getLifecycle().b(this);
    }
}
