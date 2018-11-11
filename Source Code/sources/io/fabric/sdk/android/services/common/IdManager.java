package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class IdManager {
    private static final Pattern enb = Pattern.compile("[^\\p{Alnum}]");
    private static final String enc = Pattern.quote("/");
    private final String emq;
    private final String emr;
    private final ReentrantLock ene = new ReentrantLock();
    private final n enf;
    private final boolean eng;
    private final boolean enh;
    c eni;
    b enj;
    boolean enk;
    m enl;
    private final Context iG;
    private final Collection<h> rM;

    public enum DeviceIdentifierType {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int protobufIndex;

        private DeviceIdentifierType(int i) {
            this.protobufIndex = i;
        }
    }

    public IdManager(Context context, String str, String str2, Collection<h> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.iG = context;
            this.emr = str;
            this.emq = str2;
            this.rM = collection;
            this.enf = new n();
            this.eni = new c(context);
            this.enl = new m();
            this.eng = CommonUtils.b(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.eng) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Device ID collection disabled for ");
                stringBuilder.append(context.getPackageName());
                c.aUg().d("Fabric", stringBuilder.toString());
            }
            this.enh = CommonUtils.b(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.enh) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("User information collection disabled for ");
                stringBuilder2.append(context.getPackageName());
                c.aUg().d("Fabric", stringBuilder2.toString());
            }
        }
    }

    public boolean aUF() {
        return this.enh;
    }

    private String lE(String str) {
        return str == null ? null : enb.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String aUG() {
        String str = this.emq;
        if (str != null) {
            return str;
        }
        SharedPreferences cF = CommonUtils.cF(this.iG);
        d(cF);
        String string = cF.getString("crashlytics.installation.id", null);
        return string == null ? c(cF) : string;
    }

    public String aUH() {
        return this.emr;
    }

    public String aUI() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aUJ());
        stringBuilder.append("/");
        stringBuilder.append(aUK());
        return stringBuilder.toString();
    }

    public String aUJ() {
        return lF(VERSION.RELEASE);
    }

    public String aUK() {
        return lF(VERSION.INCREMENTAL);
    }

    public String aUL() {
        return String.format(Locale.US, "%s/%s", new Object[]{lF(Build.MANUFACTURER), lF(Build.MODEL)});
    }

    private String lF(String str) {
        return str.replaceAll(enc, "");
    }

    @SuppressLint({"CommitPrefEdits"})
    private String c(SharedPreferences sharedPreferences) {
        this.ene.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = lE(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.ene.unlock();
            return string;
        } catch (Throwable th) {
            this.ene.unlock();
        }
    }

    private void d(SharedPreferences sharedPreferences) {
        b aUu = aUu();
        if (aUu != null) {
            d(sharedPreferences, aUu.emJ);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private void d(SharedPreferences sharedPreferences, String str) {
        this.ene.lock();
        try {
            if (!TextUtils.isEmpty(str)) {
                Object string = sharedPreferences.getString("crashlytics.advertising.id", null);
                if (TextUtils.isEmpty(string)) {
                    sharedPreferences.edit().putString("crashlytics.advertising.id", str).commit();
                } else if (!string.equals(str)) {
                    sharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", str).commit();
                }
                this.ene.unlock();
            }
        } finally {
            this.ene.unlock();
        }
    }

    public Map<DeviceIdentifierType, String> gN() {
        Map hashMap = new HashMap();
        for (h hVar : this.rM) {
            if (hVar instanceof k) {
                for (Entry entry : ((k) hVar).gN().entrySet()) {
                    a(hashMap, (DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String getInstallerPackageName() {
        return this.enf.Z(this.iG);
    }

    public Boolean aUM() {
        return aUN() ? aUO() : null;
    }

    private void a(Map<DeviceIdentifierType, String> map, DeviceIdentifierType deviceIdentifierType, String str) {
        if (str != null) {
            map.put(deviceIdentifierType, str);
        }
    }

    protected boolean aUN() {
        return this.eng && !this.enl.cS(this.iG);
    }

    synchronized b aUu() {
        if (!this.enk) {
            this.enj = this.eni.aUu();
            this.enk = true;
        }
        return this.enj;
    }

    private Boolean aUO() {
        b aUu = aUu();
        return aUu != null ? Boolean.valueOf(aUu.emK) : null;
    }
}
