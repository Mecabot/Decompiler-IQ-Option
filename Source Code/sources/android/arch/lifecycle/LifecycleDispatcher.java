package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

class LifecycleDispatcher {
    private static AtomicBoolean aT = new AtomicBoolean(false);

    @VisibleForTesting
    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        private final FragmentCallback aU = new FragmentCallback();

        DispatcherActivityCallback() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.aU, true);
            }
            ReportFragment.b(activity);
        }

        public void onActivityStopped(Activity activity) {
            if (activity instanceof FragmentActivity) {
                LifecycleDispatcher.a((FragmentActivity) activity, State.CREATED);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            if (activity instanceof FragmentActivity) {
                LifecycleDispatcher.a((FragmentActivity) activity, State.CREATED);
            }
        }
    }

    @VisibleForTesting
    static class FragmentCallback extends FragmentLifecycleCallbacks {
        FragmentCallback() {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            LifecycleDispatcher.a(fragment, Event.ON_CREATE);
            if ((fragment instanceof LifecycleRegistryOwner) && fragment.getChildFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragment.getChildFragmentManager().beginTransaction().add(new DestructionReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            }
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
            LifecycleDispatcher.a(fragment, Event.ON_START);
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
            LifecycleDispatcher.a(fragment, Event.ON_RESUME);
        }
    }

    public static class DestructionReportFragment extends Fragment {
        public void onPause() {
            super.onPause();
            a(Event.ON_PAUSE);
        }

        public void onStop() {
            super.onStop();
            a(Event.ON_STOP);
        }

        public void onDestroy() {
            super.onDestroy();
            a(Event.ON_DESTROY);
        }

        protected void a(Event event) {
            LifecycleDispatcher.a(getParentFragment(), event);
        }
    }

    static void init(Context context) {
        if (!aT.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }

    private static void a(FragmentManager fragmentManager, State state) {
        Collection<Object> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (Object obj : fragments) {
                if (obj != null) {
                    a(obj, state);
                    if (obj.isAdded()) {
                        a(obj.getChildFragmentManager(), state);
                    }
                }
            }
        }
    }

    private static void a(Object obj, State state) {
        if (obj instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) obj).L().a(state);
        }
    }

    private static void a(FragmentActivity fragmentActivity, State state) {
        a((Object) fragmentActivity, state);
        a(fragmentActivity.getSupportFragmentManager(), state);
    }

    private static void a(Fragment fragment, Event event) {
        if (fragment instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) fragment).L().b(event);
        }
    }
}
