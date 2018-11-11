package android.arch.lifecycle;

import java.util.HashMap;

public class ViewModelStore {
    private final HashMap<String, ViewModel> bL = new HashMap();

    final void a(String str, ViewModel viewModel) {
        ViewModel viewModel2 = (ViewModel) this.bL.put(str, viewModel);
        if (viewModel2 != null) {
            viewModel2.onCleared();
        }
    }

    final ViewModel g(String str) {
        return (ViewModel) this.bL.get(str);
    }

    public final void clear() {
        for (ViewModel onCleared : this.bL.values()) {
            onCleared.onCleared();
        }
        this.bL.clear();
    }
}
