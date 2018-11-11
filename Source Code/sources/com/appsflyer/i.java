package com.appsflyer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class i {
    private static i qm = new i();
    private String pk;
    private Map<String, Object> qg = new HashMap();
    private boolean qh;
    private boolean qn;
    private boolean qo = false;

    private i() {
    }

    public static i fF() {
        return qm;
    }

    public void set(String str, String str2) {
        this.qg.put(str, str2);
    }

    public void set(String str, int i) {
        this.qg.put(str, Integer.toString(i));
    }

    public void c(String str, boolean z) {
        this.qg.put(str, Boolean.toString(z));
    }

    public String getString(String str) {
        return (String) this.qg.get(str);
    }

    public boolean getBoolean(String str, boolean z) {
        str = getString(str);
        if (str == null) {
            return z;
        }
        return Boolean.valueOf(str).booleanValue();
    }

    public int getInt(String str, int i) {
        str = getString(str);
        if (str == null) {
            return i;
        }
        return Integer.valueOf(str).intValue();
    }

    protected void fG() {
        this.qn = true;
    }

    protected boolean fH() {
        return this.qh;
    }

    protected void B(boolean z) {
        this.qh = z;
    }

    protected void fI() {
        this.qh = true;
    }

    protected void setReferrer(String str) {
        set("AF_REFERRER", str);
        this.pk = str;
    }

    public String x(Context context) {
        if (this.pk != null) {
            return this.pk;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("appsflyer-data", 0).getString("referrer", null);
    }

    public boolean fJ() {
        return getBoolean("disableLogs", false);
    }

    public boolean fK() {
        return getBoolean("disableOtherSdk", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void b(SharedPreferences sharedPreferences) {
        String jSONObject = new JSONObject(this.qg).toString();
        Editor edit = sharedPreferences.edit();
        edit.putString("savedProperties", jSONObject);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void y(Context context) {
        if (!this.qo) {
            String string = context.getSharedPreferences("appsflyer-data", 0).getString("savedProperties", null);
            if (string != null) {
                AFLogger.am("Loading properties..");
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        if (this.qg.get(str) == null) {
                            this.qg.put(str, jSONObject.getString(str));
                        }
                    }
                    this.qo = true;
                } catch (Throwable e) {
                    AFLogger.a("Failed loading properties", e);
                }
                StringBuilder stringBuilder = new StringBuilder("Done loading properties: ");
                stringBuilder.append(this.qo);
                AFLogger.am(stringBuilder.toString());
            }
        }
    }
}
