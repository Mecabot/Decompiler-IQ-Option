package io.fabric.sdk.android.services.c;

import android.content.Context;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import java.io.File;

/* compiled from: FileStoreImpl */
public class b implements a {
    private final Context context;
    private final String eoL;
    private final String eoM;

    public b(h hVar) {
        if (hVar.getContext() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.context = hVar.getContext();
        this.eoL = hVar.getPath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Android/");
        stringBuilder.append(this.context.getPackageName());
        this.eoM = stringBuilder.toString();
    }

    public File getFilesDir() {
        return z(this.context.getFilesDir());
    }

    File z(File file) {
        if (file == null) {
            c.aUg().d("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            c.aUg().w("Fabric", "Couldn't create file");
        }
        return null;
    }
}
