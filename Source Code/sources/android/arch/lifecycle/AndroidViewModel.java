package android.arch.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;

public class AndroidViewModel extends ViewModel {
    @SuppressLint({"StaticFieldLeak"})
    private Application aw;

    public AndroidViewModel(@NonNull Application application) {
        this.aw = application;
    }

    @NonNull
    public <T extends Application> T getApplication() {
        return this.aw;
    }
}
