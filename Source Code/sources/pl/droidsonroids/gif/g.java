package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: LibraryLoader */
public class g {
    @SuppressLint({"StaticFieldLeak"})
    private static Context fkU;

    private static Context getContext() {
        if (fkU == null) {
            try {
                fkU = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return fkU;
    }

    static void cU(Context context) {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (context == null) {
                context = getContext();
            }
            i.cU(context);
        }
    }
}
