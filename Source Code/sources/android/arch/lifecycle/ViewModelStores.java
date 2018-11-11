package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ViewModelStores {
    @MainThread
    @NonNull
    public static ViewModelStore c(@NonNull FragmentActivity fragmentActivity) {
        if (fragmentActivity instanceof ViewModelStoreOwner) {
            return fragmentActivity.getViewModelStore();
        }
        return HolderFragment.a(fragmentActivity).getViewModelStore();
    }

    @MainThread
    @NonNull
    public static ViewModelStore e(@NonNull Fragment fragment) {
        if (fragment instanceof ViewModelStoreOwner) {
            return fragment.getViewModelStore();
        }
        return HolderFragment.a(fragment).getViewModelStore();
    }
}
