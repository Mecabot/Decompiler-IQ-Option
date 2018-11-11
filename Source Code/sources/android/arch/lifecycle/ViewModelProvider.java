package android.arch.lifecycle;

import android.app.Application;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class ViewModelProvider {
    private final Factory bJ;
    private final ViewModelStore mViewModelStore;

    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    public static class NewInstanceFactory implements Factory {
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            StringBuilder stringBuilder;
            try {
                return (ViewModel) cls.newInstance();
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(cls);
                throw new RuntimeException(stringBuilder.toString(), e);
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(cls);
                throw new RuntimeException(stringBuilder.toString(), e2);
            }
        }
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory bK;
        private Application aw;

        @NonNull
        public static AndroidViewModelFactory a(@NonNull Application application) {
            if (bK == null) {
                bK = new AndroidViewModelFactory(application);
            }
            return bK;
        }

        public AndroidViewModelFactory(@NonNull Application application) {
            this.aw = application;
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            StringBuilder stringBuilder;
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.aw});
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(cls);
                throw new RuntimeException(stringBuilder.toString(), e);
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(cls);
                throw new RuntimeException(stringBuilder.toString(), e2);
            } catch (Throwable e22) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(cls);
                throw new RuntimeException(stringBuilder.toString(), e22);
            } catch (Throwable e222) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create an instance of ");
                stringBuilder.append(cls);
                throw new RuntimeException(stringBuilder.toString(), e222);
            }
        }
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.bJ = factory;
        this.mViewModelStore = viewModelStore;
    }

    @MainThread
    @NonNull
    public <T extends ViewModel> T h(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
        stringBuilder.append(canonicalName);
        return a(stringBuilder.toString(), cls);
    }

    @MainThread
    @NonNull
    public <T extends ViewModel> T a(@NonNull String str, @NonNull Class<T> cls) {
        T g = this.mViewModelStore.g(str);
        if (cls.isInstance(g)) {
            return g;
        }
        T create = this.bJ.create(cls);
        this.mViewModelStore.a(str, create);
        return create;
    }
}
