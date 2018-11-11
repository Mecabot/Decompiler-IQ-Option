package com.facebook.internal;

import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FetchedAppSettings */
public final class l {
    private boolean CJ;
    private String CP;
    private boolean CQ;
    private boolean CS;
    private int CT;
    private EnumSet<SmartLoginOption> Da;
    private Map<String, Map<String, a>> Db;
    private boolean Dc;
    private h Dd;
    private String De;
    private String Df;
    private boolean Dg;
    private boolean Dh;
    private String Di;
    private JSONArray Dj;
    private boolean Dk;
    private boolean Dl;

    /* compiled from: FetchedAppSettings */
    public static class a {
        private String Dm;
        private String Dn;
        private Uri Do;
        private int[] Dp;

        public static a i(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            Uri uri = null;
            if (w.bc(optString)) {
                return null;
            }
            String[] split = optString.split("\\|");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            optString = split[1];
            if (w.bc(str) || w.bc(optString)) {
                return null;
            }
            String optString2 = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
            if (!w.bc(optString2)) {
                uri = Uri.parse(optString2);
            }
            return new a(str, optString, uri, e(jSONObject.optJSONArray("versions")));
        }

        private static int[] e(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                int optInt = jSONArray.optInt(i, -1);
                if (optInt == -1) {
                    String optString = jSONArray.optString(i);
                    if (!w.bc(optString)) {
                        try {
                            optInt = Integer.parseInt(optString);
                        } catch (Exception e) {
                            w.a("FacebookSDK", e);
                            optInt = -1;
                        }
                    }
                }
                iArr[i] = optInt;
            }
            return iArr;
        }

        private a(String str, String str2, Uri uri, int[] iArr) {
            this.Dm = str;
            this.Dn = str2;
            this.Do = uri;
            this.Dp = iArr;
        }

        public String lO() {
            return this.Dm;
        }

        public String getFeatureName() {
            return this.Dn;
        }
    }

    public l(boolean z, String str, boolean z2, boolean z3, int i, EnumSet<SmartLoginOption> enumSet, Map<String, Map<String, a>> map, boolean z4, h hVar, String str2, String str3, boolean z5, boolean z6, JSONArray jSONArray, String str4, boolean z7, boolean z8) {
        this.CJ = z;
        this.CP = str;
        this.CQ = z2;
        this.CS = z3;
        this.Db = map;
        this.Dd = hVar;
        this.CT = i;
        this.Dc = z4;
        this.Da = enumSet;
        this.De = str2;
        this.Df = str3;
        this.Dg = z5;
        this.Dh = z6;
        this.Dj = jSONArray;
        this.Di = str4;
        this.Dk = z7;
        this.Dl = z8;
    }

    public boolean lF() {
        return this.CJ;
    }

    public boolean lG() {
        return this.CS;
    }

    public int kI() {
        return this.CT;
    }

    public boolean lH() {
        return this.Dc;
    }

    public EnumSet<SmartLoginOption> lI() {
        return this.Da;
    }

    public h iW() {
        return this.Dd;
    }

    public boolean lJ() {
        return this.Dg;
    }

    public boolean lK() {
        return this.Dh;
    }

    public boolean lL() {
        return this.Dl;
    }

    public JSONArray lM() {
        return this.Dj;
    }

    public String lN() {
        return this.Di;
    }
}
