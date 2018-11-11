package com.microblink.recognition;

import android.content.Context;
import android.content.res.AssetManager;
import com.microblink.secured.ai;
import com.microblink.secured.i;
import com.microblink.secured.r;
import java.io.File;
import java.util.Map.Entry;

/* compiled from: line */
public class ResourceProvider {
    public static final ResourceProvider dVo = new ResourceProvider();
    long IlIllIlIIl = 0;

    private static native long nativeConstruct(AssetManager assetManager);

    private static native void nativeDestruct(long j);

    static {
        i.aPu();
    }

    public final synchronized void ci(Context context) {
        if (this.IlIllIlIIl == 0) {
            i.aPx();
            this.IlIllIlIIl = nativeConstruct(context.getAssets());
            if (r.dWZ != null) {
                if (r.dWY == null) {
                    throw new NullPointerException("Assets root is nullptr");
                }
                String absolutePath = context.getFilesDir().getAbsolutePath();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(absolutePath);
                stringBuilder.append(File.separator);
                stringBuilder.append(r.dWY);
                ai.v(new File(stringBuilder.toString()));
                AssetManager assets = context.getAssets();
                for (Entry entry : r.dWZ.entrySet()) {
                    String str = (String) entry.getKey();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(absolutePath);
                    stringBuilder2.append(File.separator);
                    stringBuilder2.append((String) entry.getValue());
                    if (!ai.a(assets, str, stringBuilder2.toString())) {
                        StringBuilder stringBuilder3 = new StringBuilder("Cannot load asset ");
                        stringBuilder3.append((String) entry.getKey());
                        throw new RuntimeException(stringBuilder3.toString());
                    }
                }
            }
        }
    }

    public final synchronized void aPc() {
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
            this.IlIllIlIIl = 0;
        }
    }

    protected void finalize() {
        super.finalize();
        aPc();
    }
}
