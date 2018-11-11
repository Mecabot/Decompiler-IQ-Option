package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP})
public class HolderFragment extends Fragment implements ViewModelStoreOwner {
    private static final HolderFragmentManager aM = new HolderFragmentManager();
    private ViewModelStore mViewModelStore = new ViewModelStore();

    static class HolderFragmentManager {
        private Map<Activity, HolderFragment> aN = new HashMap();
        private Map<Fragment, HolderFragment> aO = new HashMap();
        private ActivityLifecycleCallbacks aP = new EmptyActivityLifecycleCallbacks() {
            public void onActivityDestroyed(Activity activity) {
                if (((HolderFragment) HolderFragmentManager.this.aN.remove(activity)) != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to save a ViewModel for ");
                    stringBuilder.append(activity);
                    Log.e("ViewModelStores", stringBuilder.toString());
                }
            }
        };
        private boolean aQ = false;
        private FragmentLifecycleCallbacks aR = new FragmentLifecycleCallbacks() {
            public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                super.onFragmentDestroyed(fragmentManager, fragment);
                if (((HolderFragment) HolderFragmentManager.this.aO.remove(fragment)) != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to save a ViewModel for ");
                    stringBuilder.append(fragment);
                    Log.e("ViewModelStores", stringBuilder.toString());
                }
            }
        };

        HolderFragmentManager() {
        }

        void b(Fragment fragment) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                this.aO.remove(parentFragment);
                parentFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.aR);
                return;
            }
            this.aN.remove(fragment.zzakw());
        }

        private static HolderFragment a(FragmentManager fragmentManager) {
            if (fragmentManager.isDestroyed()) {
                throw new IllegalStateException("Can't access ViewModels from onDestroy");
            }
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag("android.arch.lifecycle.state.StateProviderHolderFragment");
            if (findFragmentByTag == null || (findFragmentByTag instanceof HolderFragment)) {
                return (HolderFragment) findFragmentByTag;
            }
            throw new IllegalStateException("Unexpected fragment instance was returned by HOLDER_TAG");
        }

        private static HolderFragment b(FragmentManager fragmentManager) {
            Fragment holderFragment = new HolderFragment();
            fragmentManager.beginTransaction().add(holderFragment, "android.arch.lifecycle.state.StateProviderHolderFragment").commitAllowingStateLoss();
            return holderFragment;
        }

        HolderFragment a(FragmentActivity fragmentActivity) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            HolderFragment a = a(supportFragmentManager);
            if (a != null) {
                return a;
            }
            a = (HolderFragment) this.aN.get(fragmentActivity);
            if (a != null) {
                return a;
            }
            if (!this.aQ) {
                this.aQ = true;
                fragmentActivity.getApplication().registerActivityLifecycleCallbacks(this.aP);
            }
            HolderFragment b = b(supportFragmentManager);
            this.aN.put(fragmentActivity, b);
            return b;
        }

        HolderFragment a(Fragment fragment) {
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            HolderFragment a = a(childFragmentManager);
            if (a != null) {
                return a;
            }
            a = (HolderFragment) this.aO.get(fragment);
            if (a != null) {
                return a;
            }
            fragment.getFragmentManager().registerFragmentLifecycleCallbacks(this.aR, false);
            HolderFragment b = b(childFragmentManager);
            this.aO.put(fragment, b);
            return b;
        }
    }

    public HolderFragment() {
        setRetainInstance(true);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        aM.b((Fragment) this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mViewModelStore.clear();
    }

    @NonNull
    public ViewModelStore getViewModelStore() {
        return this.mViewModelStore;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static HolderFragment a(FragmentActivity fragmentActivity) {
        return aM.a(fragmentActivity);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static HolderFragment a(Fragment fragment) {
        return aM.a(fragment);
    }
}
