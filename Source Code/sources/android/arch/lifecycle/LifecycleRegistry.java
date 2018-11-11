package android.arch.lifecycle;

import android.arch.core.internal.FastSafeIterableMap;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> aV = new FastSafeIterableMap();
    private State aW;
    private final WeakReference<LifecycleOwner> aX;
    private int aY = 0;
    private boolean aZ = false;
    private boolean ba = false;
    private ArrayList<State> bb = new ArrayList();

    static class ObserverWithState {
        State aW;
        GenericLifecycleObserver bd;

        ObserverWithState(LifecycleObserver lifecycleObserver, State state) {
            this.bd = Lifecycling.d((Object) lifecycleObserver);
            this.aW = state;
        }

        void b(LifecycleOwner lifecycleOwner, Event event) {
            State c = LifecycleRegistry.c(event);
            this.aW = LifecycleRegistry.a(this.aW, c);
            this.bd.a(lifecycleOwner, event);
            this.aW = c;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this.aX = new WeakReference(lifecycleOwner);
        this.aW = State.INITIALIZED;
    }

    @MainThread
    public void a(@NonNull State state) {
        b(state);
    }

    public void b(@NonNull Event event) {
        b(c(event));
    }

    private void b(State state) {
        if (this.aW != state) {
            this.aW = state;
            if (this.aZ || this.aY != 0) {
                this.ba = true;
                return;
            }
            this.aZ = true;
            sync();
            this.aZ = false;
        }
    }

    private boolean J() {
        boolean z = true;
        if (this.aV.size() == 0) {
            return true;
        }
        State state = ((ObserverWithState) this.aV.E().getValue()).aW;
        State state2 = ((ObserverWithState) this.aV.F().getValue()).aW;
        if (!(state == state2 && this.aW == state2)) {
            z = false;
        }
        return z;
    }

    private State c(LifecycleObserver lifecycleObserver) {
        Entry c = this.aV.c(lifecycleObserver);
        State state = null;
        State state2 = c != null ? ((ObserverWithState) c.getValue()).aW : null;
        if (!this.bb.isEmpty()) {
            state = (State) this.bb.get(this.bb.size() - 1);
        }
        return a(a(this.aW, state2), state);
    }

    public void a(@NonNull LifecycleObserver lifecycleObserver) {
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, this.aW == State.DESTROYED ? State.DESTROYED : State.INITIALIZED);
        if (((ObserverWithState) this.aV.putIfAbsent(lifecycleObserver, observerWithState)) == null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) this.aX.get();
            if (lifecycleOwner != null) {
                Object obj = (this.aY != 0 || this.aZ) ? 1 : null;
                Enum c = c(lifecycleObserver);
                this.aY++;
                while (observerWithState.aW.compareTo(c) < 0 && this.aV.contains(lifecycleObserver)) {
                    c(observerWithState.aW);
                    observerWithState.b(lifecycleOwner, e(observerWithState.aW));
                    K();
                    c = c(lifecycleObserver);
                }
                if (obj == null) {
                    sync();
                }
                this.aY--;
            }
        }
    }

    private void K() {
        this.bb.remove(this.bb.size() - 1);
    }

    private void c(State state) {
        this.bb.add(state);
    }

    public void b(@NonNull LifecycleObserver lifecycleObserver) {
        this.aV.remove(lifecycleObserver);
    }

    @NonNull
    public State I() {
        return this.aW;
    }

    static State c(Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return State.STARTED;
            case ON_RESUME:
                return State.RESUMED;
            case ON_DESTROY:
                return State.DESTROYED;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected event value ");
                stringBuilder.append(event);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static Event d(State state) {
        switch (state) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return Event.ON_DESTROY;
            case STARTED:
                return Event.ON_STOP;
            case RESUMED:
                return Event.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(state);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static Event e(State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Event.ON_CREATE;
            case CREATED:
                return Event.ON_START;
            case STARTED:
                return Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(state);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private void g(LifecycleOwner lifecycleOwner) {
        Iterator D = this.aV.D();
        while (D.hasNext() && !this.ba) {
            Entry entry = (Entry) D.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.aW.compareTo(this.aW) < 0 && !this.ba && this.aV.contains(entry.getKey())) {
                c(observerWithState.aW);
                observerWithState.b(lifecycleOwner, e(observerWithState.aW));
                K();
            }
        }
    }

    private void h(LifecycleOwner lifecycleOwner) {
        Iterator descendingIterator = this.aV.descendingIterator();
        while (descendingIterator.hasNext() && !this.ba) {
            Entry entry = (Entry) descendingIterator.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.aW.compareTo(this.aW) > 0 && !this.ba && this.aV.contains(entry.getKey())) {
                Event d = d(observerWithState.aW);
                c(c(d));
                observerWithState.b(lifecycleOwner, d);
                K();
            }
        }
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.aX.get();
        if (lifecycleOwner == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!J()) {
            this.ba = false;
            if (this.aW.compareTo(((ObserverWithState) this.aV.E().getValue()).aW) < 0) {
                h(lifecycleOwner);
            }
            Entry F = this.aV.F();
            if (!(this.ba || F == null || this.aW.compareTo(((ObserverWithState) F.getValue()).aW) <= 0)) {
                g(lifecycleOwner);
            }
        }
        this.ba = false;
    }

    static State a(@NonNull State state, @Nullable State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
