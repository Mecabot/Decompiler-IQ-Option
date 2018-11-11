package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle.Event;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;

public class ProcessLifecycleOwner implements LifecycleOwner {
    private static final ProcessLifecycleOwner by = new ProcessLifecycleOwner();
    private int br = 0;
    private int bs = 0;
    private boolean bt = true;
    private boolean bu = true;
    private final LifecycleRegistry bv = new LifecycleRegistry(this);
    private Runnable bw = new Runnable() {
        public void run() {
            ProcessLifecycleOwner.this.X();
            ProcessLifecycleOwner.this.Y();
        }
    };
    private ActivityInitializationListener bx = new ActivityInitializationListener() {
        public void onCreate() {
        }

        public void onStart() {
            ProcessLifecycleOwner.this.T();
        }

        public void onResume() {
            ProcessLifecycleOwner.this.U();
        }
    };
    private Handler mHandler;

    public static LifecycleOwner S() {
        return by;
    }

    static void init(Context context) {
        by.attach(context);
    }

    void T() {
        this.br++;
        if (this.br == 1 && this.bu) {
            this.bv.b(Event.ON_START);
            this.bu = false;
        }
    }

    void U() {
        this.bs++;
        if (this.bs != 1) {
            return;
        }
        if (this.bt) {
            this.bv.b(Event.ON_RESUME);
            this.bt = false;
            return;
        }
        this.mHandler.removeCallbacks(this.bw);
    }

    void V() {
        this.bs--;
        if (this.bs == 0) {
            this.mHandler.postDelayed(this.bw, 700);
        }
    }

    void W() {
        this.br--;
        Y();
    }

    private void X() {
        if (this.bs == 0) {
            this.bt = true;
            this.bv.b(Event.ON_PAUSE);
        }
    }

    private void Y() {
        if (this.br == 0 && this.bt) {
            this.bv.b(Event.ON_STOP);
            this.bu = true;
        }
    }

    private ProcessLifecycleOwner() {
    }

    void attach(Context context) {
        this.mHandler = new Handler();
        this.bv.b(Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.c(activity).d(ProcessLifecycleOwner.this.bx);
            }

            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner.this.V();
            }

            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner.this.W();
            }
        });
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.bv;
    }
}
