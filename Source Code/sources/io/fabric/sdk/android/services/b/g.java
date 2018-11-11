package io.fabric.sdk.android.services.b;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GZIPQueueFileEventStorage */
public class g extends h {
    public g(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    public OutputStream y(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
