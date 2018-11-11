package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzdkf;
import com.google.android.gms.internal.zzdkh;
import com.google.android.gms.internal.zzdkl;
import com.google.android.gms.internal.zzdkp;
import com.google.android.gms.internal.zzflr;
import com.google.android.gms.internal.zzfls;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

final class zzey implements zzah {
    private final Context mContext;
    private final ExecutorService zzimc = Executors.newSingleThreadExecutor();
    private final String zzknc;
    private zzdi<zzdkf> zzksb;

    zzey(Context context, String str) {
        this.mContext = context;
        this.zzknc = str;
    }

    private static zzdkl zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzdb.zzly(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            zzdj.zzby("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException unused2) {
            zzdj.zzcz("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private final File zzbhn() {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(this.zzknc);
        return new File(this.mContext.getDir("google_tagmanager", 0), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private static zzdkl zzz(byte[] bArr) {
        try {
            zzdkl zza = zzdkh.zza((zzbp) zzfls.zza(new zzbp(), bArr));
            if (zza != null) {
                zzdj.v("The container was successfully loaded from the resource (using binary file)");
            }
            return zza;
        } catch (zzflr unused) {
            zzdj.e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzdkp unused2) {
            zzdj.zzcz("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    public final synchronized void release() {
        this.zzimc.shutdown();
    }

    public final void zza(zzdkf zzdkf) {
        this.zzimc.execute(new zzfa(this, zzdkf));
    }

    public final void zza(zzdi<zzdkf> zzdi) {
        this.zzksb = zzdi;
    }

    /* JADX WARNING: Missing block: B:12:?, code:
            com.google.android.gms.tagmanager.zzdj.zzcz("Error writing resource to disk. Removing resource from disk.");
            r0.delete();
     */
    /* JADX WARNING: Missing block: B:14:?, code:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:15:0x0029, code:
            return false;
     */
    /* JADX WARNING: Missing block: B:16:0x002a, code:
            com.google.android.gms.tagmanager.zzdj.zzcz("error closing stream for writing resource to disk");
     */
    /* JADX WARNING: Missing block: B:17:0x002f, code:
            return false;
     */
    /* JADX WARNING: Missing block: B:19:?, code:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:20:0x0034, code:
            com.google.android.gms.tagmanager.zzdj.zzcz("error closing stream for writing resource to disk");
     */
    final boolean zzb(com.google.android.gms.internal.zzdkf r4) {
        /*
        r3 = this;
        r0 = r3.zzbhn();
        r1 = 0;
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x003a }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x003a }
        r4 = com.google.android.gms.internal.zzfls.zzc(r4);	 Catch:{ IOException -> 0x001e }
        r2.write(r4);	 Catch:{ IOException -> 0x001e }
        r2.close();	 Catch:{ IOException -> 0x0015 }
        goto L_0x001a;
    L_0x0015:
        r4 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzdj.zzcz(r4);
    L_0x001a:
        r4 = 1;
        return r4;
    L_0x001c:
        r4 = move-exception;
        goto L_0x0030;
    L_0x001e:
        r4 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.zzdj.zzcz(r4);	 Catch:{ all -> 0x001c }
        r0.delete();	 Catch:{ all -> 0x001c }
        r2.close();	 Catch:{ IOException -> 0x002a }
        return r1;
    L_0x002a:
        r4 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzdj.zzcz(r4);
        return r1;
    L_0x0030:
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0039;
    L_0x0034:
        r0 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzdj.zzcz(r0);
    L_0x0039:
        throw r4;
    L_0x003a:
        r4 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.zzdj.e(r4);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzey.zzb(com.google.android.gms.internal.zzdkf):boolean");
    }

    public final void zzbfv() {
        this.zzimc.execute(new zzez(this));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.tagmanager.zzey.zzbhm():void, dom blocks: [B:23:0x007e, B:27:0x008e]
        	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
        	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    final void zzbhm() {
        /*
        r3 = this;
        r0 = r3.zzksb;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "Callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.zzksb;
        r0.zzbfu();
        r0 = "Attempting to load resource from disk";
        com.google.android.gms.tagmanager.zzdj.v(r0);
        r0 = com.google.android.gms.tagmanager.zzei.zzbhh();
        r0 = r0.zzbhi();
        r1 = com.google.android.gms.tagmanager.zzei.zza.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.android.gms.tagmanager.zzei.zzbhh();
        r0 = r0.zzbhi();
        r1 = com.google.android.gms.tagmanager.zzei.zza.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.zzknc;
        r1 = com.google.android.gms.tagmanager.zzei.zzbhh();
        r1 = r1.getContainerId();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.zzksb;
        r1 = com.google.android.gms.tagmanager.zzda.zzkqn;
        r0.zzex(r1);
        return;
    L_0x0046:
        r0 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x00b0 }
        r1 = r3.zzbhn();	 Catch:{ FileNotFoundException -> 0x00b0 }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x00b0 }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r1.<init>();	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        com.google.android.gms.internal.zzdkh.zzb(r0, r1);	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r1 = r1.toByteArray();	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r2 = new com.google.android.gms.internal.zzdkf;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r2.<init>();	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r1 = com.google.android.gms.internal.zzfls.zza(r2, r1);	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r1 = (com.google.android.gms.internal.zzdkf) r1;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r2 = r1.zzyi;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        if (r2 != 0) goto L_0x0076;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
    L_0x006a:
        r2 = r1.zzldm;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        if (r2 != 0) goto L_0x0076;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
    L_0x006e:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r2 = "Resource and SupplementedResource are NULL.";	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r1.<init>(r2);	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        throw r1;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
    L_0x0076:
        r2 = r3.zzksb;	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        r2.onSuccess(r1);	 Catch:{ IOException -> 0x008e, IllegalArgumentException -> 0x007e }
        goto L_0x008a;
    L_0x007c:
        r1 = move-exception;
        goto L_0x00a6;
    L_0x007e:
        r1 = r3.zzksb;	 Catch:{ all -> 0x007c }
        r2 = com.google.android.gms.tagmanager.zzda.zzkqo;	 Catch:{ all -> 0x007c }
        r1.zzex(r2);	 Catch:{ all -> 0x007c }
        r1 = "Failed to read the resource from disk. The resource is inconsistent";	 Catch:{ all -> 0x007c }
        com.google.android.gms.tagmanager.zzdj.zzcz(r1);	 Catch:{ all -> 0x007c }
    L_0x008a:
        r0.close();	 Catch:{ IOException -> 0x009b }
        goto L_0x00a0;
    L_0x008e:
        r1 = r3.zzksb;	 Catch:{ all -> 0x007c }
        r2 = com.google.android.gms.tagmanager.zzda.zzkqo;	 Catch:{ all -> 0x007c }
        r1.zzex(r2);	 Catch:{ all -> 0x007c }
        r1 = "Failed to read the resource from disk";	 Catch:{ all -> 0x007c }
        com.google.android.gms.tagmanager.zzdj.zzcz(r1);	 Catch:{ all -> 0x007c }
        goto L_0x008a;
    L_0x009b:
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzdj.zzcz(r0);
    L_0x00a0:
        r0 = "The Disk resource was successfully read.";
        com.google.android.gms.tagmanager.zzdj.v(r0);
        return;
    L_0x00a6:
        r0.close();	 Catch:{ IOException -> 0x00aa }
        goto L_0x00af;
    L_0x00aa:
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzdj.zzcz(r0);
    L_0x00af:
        throw r1;
    L_0x00b0:
        r0 = "Failed to find the resource in the disk";
        com.google.android.gms.tagmanager.zzdj.zzby(r0);
        r0 = r3.zzksb;
        r1 = com.google.android.gms.tagmanager.zzda.zzkqn;
        r0.zzex(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzey.zzbhm():void");
    }

    public final zzdkl zzey(int i) {
        String stringBuilder;
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            String resourceName = this.mContext.getResources().getResourceName(i);
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(resourceName).length() + 66);
            stringBuilder2.append("Attempting to load a container from the resource ID ");
            stringBuilder2.append(i);
            stringBuilder2.append(" (");
            stringBuilder2.append(resourceName);
            stringBuilder2.append(")");
            zzdj.v(stringBuilder2.toString());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzdkh.zzb(openRawResource, byteArrayOutputStream);
                zzdkl zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzz(byteArrayOutputStream.toByteArray());
                }
                zzdj.v("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException unused) {
                String resourceName2 = this.mContext.getResources().getResourceName(i);
                StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(resourceName2).length() + 67);
                stringBuilder3.append("Error reading the default container with resource ID ");
                stringBuilder3.append(i);
                stringBuilder3.append(" (");
                stringBuilder3.append(resourceName2);
                stringBuilder3.append(")");
                stringBuilder = stringBuilder3.toString();
                zzdj.zzcz(stringBuilder);
                return null;
            }
        } catch (NotFoundException unused2) {
            StringBuilder stringBuilder4 = new StringBuilder(98);
            stringBuilder4.append("Failed to load the container. No default container resource found with the resource ID ");
            stringBuilder4.append(i);
            stringBuilder = stringBuilder4.toString();
            zzdj.zzcz(stringBuilder);
            return null;
        }
    }
}
