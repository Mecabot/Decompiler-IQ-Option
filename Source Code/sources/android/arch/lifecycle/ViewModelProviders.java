package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ViewModelProviders {
    private static Application d(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    private static Activity c(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    @MainThread
    @NonNull
    public static ViewModelProvider d(@NonNull Fragment fragment) {
        return a(fragment, null);
    }

    @MainThread
    @NonNull
    public static ViewModelProvider b(@NonNull FragmentActivity fragmentActivity) {
        return a(fragmentActivity, null);
    }

    @MainThread
    @NonNull
    public static ViewModelProvider a(@NonNull Fragment fragment, @Nullable Factory factory) {
        Application d = d(c(fragment));
        if (factory == null) {
            factory = AndroidViewModelFactory.a(d);
        }
        return new ViewModelProvider(ViewModelStores.e(fragment), factory);
    }

    @MainThread
    @NonNull
    public static ViewModelProvider a(@NonNull FragmentActivity fragmentActivity, @Nullable Factory factory) {
        Application d = d((Activity) fragmentActivity);
        if (factory == null) {
            factory = AndroidViewModelFactory.a(d);
        }
        return new ViewModelProvider(ViewModelStores.c(fragmentActivity), factory);
    }
}
