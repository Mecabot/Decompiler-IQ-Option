package com.iqoption.view.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.util.ab;
import com.iqoption.x.R;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: RemoteAnimations */
public final class e {
    private static final n<e> cGv = Suppliers.a(g.ajD);
    private final Context context;
    private volatile a dFI;
    private Map<String, b> dFJ = new ConcurrentHashMap();
    private File dFK;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private List<c> nG;

    /* compiled from: RemoteAnimations */
    private static final class a {
        d dFM;
        String name;

        private a() {
        }

        /* synthetic */ a(RemoteAnimations$1 remoteAnimations$1) {
            this();
        }

        void a(String str, d dVar) {
            this.name = str;
            this.dFM = dVar;
        }
    }

    /* compiled from: RemoteAnimations */
    private final class b implements Runnable {
        private volatile boolean cancelled;
        private c dFN;

        b(c cVar) {
            this.dFN = cVar;
        }

        void cancel() {
            this.cancelled = true;
        }

        public void run() {
            try {
                if (!(e.this.dFI == null || e.this.dFI.dFM == null)) {
                    e.this.dFI.dFM.recycle();
                    e.this.dFI.dFM = null;
                }
                Resources resources = IQApp.Dk().getResources();
                d dVar = new d(this.dFN.dFF);
                int i = 0;
                while (!dVar.isCompleted() && !dVar.isRecycled()) {
                    Bitmap ha = ha(i);
                    if (ha != null) {
                        dVar.addFrame(new BitmapDrawable(resources, ha), this.dFN.dFG);
                    } else {
                        i.w("RemoteAnimation", "RemoteAnimationDrawable has not been cached");
                        dVar.recycle();
                    }
                    i++;
                    if (this.cancelled && !dVar.isRecycled()) {
                        dVar.recycle();
                    }
                }
                if (!this.cancelled) {
                    if (e.this.dFI == null) {
                        e.this.dFI = new a();
                    }
                    e.this.dFI.a(this.dFN.name, dVar);
                }
            } catch (Throwable th) {
                e.this.dFJ.remove(this.dFN.name);
            }
            e.this.dFJ.remove(this.dFN.name);
        }

        @Nullable
        private Bitmap ha(int i) {
            String str = this.dFN.frames[i];
            File file = new File(new File(e.this.dFK, this.dFN.name), String.valueOf(str.hashCode()));
            Bitmap kb = file.exists() ? kb(file.getPath()) : null;
            if (kb == null) {
                kb = kc(str);
                if (kb != null) {
                    a(file, kb);
                }
            }
            return kb;
        }

        private void a(@NonNull File file, @NonNull Bitmap bitmap) {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                try {
                    bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(file));
                    return;
                } catch (Throwable e) {
                    i.w("RemoteAnimation", e.getMessage(), e);
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create directory: ");
            stringBuilder.append(file.getParentFile().getPath());
            i.w("RemoteAnimation", stringBuilder.toString());
        }

        private Bitmap kb(@NonNull String str) {
            Bitmap bitmap = null;
            int i = 0;
            while (bitmap == null && i < 3) {
                bitmap = BitmapFactory.decodeFile(str);
                i++;
            }
            return bitmap;
        }

        private Bitmap kc(@NonNull String str) {
            Bitmap bitmap = null;
            int i = 0;
            while (bitmap == null && i < 3) {
                try {
                    bitmap = BitmapFactory.decodeStream(new URL(str).openStream());
                } catch (Throwable e) {
                    i.w("RemoteAnimation", e.getMessage(), e);
                }
                i++;
            }
            return bitmap;
        }
    }

    public static void init() {
        aIY().aIZ();
    }

    public static void jY(@Nullable String str) {
        e aIY = aIY();
        if (str == null) {
            str = "CRYPTO";
        }
        aIY.jZ(str);
    }

    private static e aIY() {
        return (e) cGv.get();
    }

    private e(Context context) {
        this.context = context;
    }

    private void aIZ() {
        this.executor.submit(new f(this));
    }

    final /* synthetic */ void aJa() {
        if (this.nG == null) {
            synchronized (e.class) {
                this.nG = (List) ab.a(this.context, R.raw.remote_animations, new RemoteAnimations$1(this).getType());
                i.i("RemoteAnimation", "Initialized");
            }
        }
    }

    private boolean isInitialized() {
        return this.nG != null;
    }

    private void jZ(@NonNull String str) {
        if (isInitialized()) {
            c ka = ka(str);
            if (ka == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Remote animation with name ");
                stringBuilder.append(str);
                stringBuilder.append(" is absent");
                i.i("RemoteAnimation", stringBuilder.toString());
                return;
            } else if (!this.dFJ.containsKey(ka.name)) {
                if (this.dFJ.size() >= 3) {
                    for (b cancel : this.dFJ.values()) {
                        cancel.cancel();
                    }
                    this.dFJ.clear();
                }
                if (this.dFK == null) {
                    this.dFK = new File(this.context.getFilesDir(), "remote_anim");
                }
                if (this.dFK.exists() || this.dFK.mkdirs()) {
                    Runnable bVar = new b(ka);
                    this.executor.submit(bVar);
                    this.dFJ.put(ka.name, bVar);
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Could not create directory ");
                    stringBuilder2.append(this.dFK.getPath());
                    i.w("RemoteAnimation", stringBuilder2.toString());
                }
                return;
            } else {
                return;
            }
        }
        i.i("RemoteAnimation", "Not initialized");
    }

    @Nullable
    private c ka(@NonNull String str) {
        for (c cVar : this.nG) {
            if (str.equalsIgnoreCase(cVar.name)) {
                return cVar;
            }
        }
        return null;
    }
}
