package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.Hide;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

@Hide
public final class zzaqy extends zzari {
    private static boolean zzdyb;
    private Info zzdyc;
    private final zzatp zzdyd;
    private String zzdye;
    private boolean zzdyf = false;
    private final Object zzdyg = new Object();

    zzaqy(zzark zzark) {
        super(zzark);
        this.zzdyd = new zzatp(zzark.zzxx());
    }

    private final boolean zza(Info info, Info info2) {
        Object obj = null;
        CharSequence id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        Object zzzp = zzyg().zzzp();
        synchronized (this.zzdyg) {
            String valueOf;
            String valueOf2;
            boolean zzdz;
            String valueOf3;
            if (!this.zzdyf) {
                this.zzdye = zzxq();
                this.zzdyf = true;
            } else if (TextUtils.isEmpty(this.zzdye)) {
                if (info != null) {
                    obj = info.getId();
                }
                if (obj == null) {
                    valueOf = String.valueOf(id);
                    valueOf2 = String.valueOf(zzzp);
                    zzdz = zzdz(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                    return zzdz;
                }
                valueOf = String.valueOf(obj);
                valueOf3 = String.valueOf(zzzp);
                this.zzdye = zzdy(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
            }
            valueOf = String.valueOf(id);
            valueOf3 = String.valueOf(zzzp);
            Object zzdy = zzdy(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
            if (TextUtils.isEmpty(zzdy)) {
                return false;
            } else if (zzdy.equals(this.zzdye)) {
                return true;
            } else {
                if (!TextUtils.isEmpty(this.zzdye)) {
                    zzea("Resetting the client id because Advertising Id changed.");
                    zzzp = zzyg().zzzq();
                    zza("New client Id", zzzp);
                }
                valueOf = String.valueOf(id);
                valueOf2 = String.valueOf(zzzp);
                zzdz = zzdz(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                return zzdz;
            }
        }
    }

    private static String zzdy(String str) {
        if (zzatt.zzeq("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzatt.zzeq("MD5").digest(str.getBytes()))});
    }

    private final boolean zzdz(String str) {
        try {
            str = zzdy(str);
            zzea("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            this.zzdye = str;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private final synchronized Info zzxo() {
        if (this.zzdyd.zzu(1000)) {
            this.zzdyd.start();
            Info zzxp = zzxp();
            if (!zza(this.zzdyc, zzxp)) {
                zzee("Failed to reset client id on adid change. Not using adid");
                zzxp = new Info("", false);
            }
            this.zzdyc = zzxp;
        }
        return this.zzdyc;
    }

    private final Info zzxp() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException unused) {
            zzed("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Throwable th) {
            if (!zzdyb) {
                zzdyb = true;
                zzd("Error getting advertiser id", th);
            }
            return null;
        }
    }

    private final String zzxq() {
        Object e;
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzed("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzea("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException unused) {
                    return str2;
                } catch (IOException e2) {
                    e = e2;
                    str = str2;
                    zzd("Error reading Hash file, deleting it", e);
                    getContext().deleteFile("gaClientIdData");
                }
            }
        } catch (FileNotFoundException unused2) {
            return str;
        } catch (IOException e3) {
            e = e3;
            zzd("Error reading Hash file, deleting it", e);
            getContext().deleteFile("gaClientIdData");
        }
    }

    protected final void zzwk() {
    }

    public final boolean zzxg() {
        zzyk();
        Info zzxo = zzxo();
        return (zzxo == null || zzxo.isLimitAdTrackingEnabled()) ? false : true;
    }

    public final String zzxn() {
        zzyk();
        Info zzxo = zzxo();
        Object id = zzxo != null ? zzxo.getId() : null;
        return TextUtils.isEmpty(id) ? null : id;
    }
}
