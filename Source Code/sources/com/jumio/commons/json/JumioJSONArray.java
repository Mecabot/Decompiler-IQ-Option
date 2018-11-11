package com.jumio.commons.json;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

public class JumioJSONArray extends JSONArray {
    private JSONStringer stringer;

    public String toString() {
        try {
            if (this.stringer != null) {
                this.stringer.clear();
            }
            this.stringer = new JSONStringer();
            writeTo(this.stringer);
            return this.stringer.toString();
        } catch (JSONException unused) {
            return super.toString();
        }
    }

    public String toString(int i) {
        if (this.stringer != null) {
            this.stringer.clear();
        }
        this.stringer = new JSONStringer(i);
        writeTo(this.stringer);
        return this.stringer.toString();
    }

    public void writeTo(JSONStringer jSONStringer) {
        jSONStringer.array();
        for (int i = 0; i < length(); i++) {
            jSONStringer.value(opt(i));
        }
        jSONStringer.endArray();
    }

    public void clear() {
        if (this.stringer != null) {
            this.stringer.clear();
        }
        for (int i = 0; i < length(); i++) {
            Object opt = opt(i);
            if (opt != null) {
                if (opt instanceof StringBuilder) {
                    overwriteStringBuilder((StringBuilder) opt);
                } else if (opt instanceof char[]) {
                    overwriteCharArray((char[]) opt);
                } else if (opt instanceof JumioJSONArray) {
                    ((JumioJSONArray) opt).clear();
                } else if (opt instanceof JumioJSONObject) {
                    ((JumioJSONObject) opt).clear();
                }
            }
        }
    }

    private void overwriteStringBuilder(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            for (int i = 0; i < stringBuilder.length(); i++) {
                stringBuilder.setCharAt(i, 0);
            }
        }
    }

    private void overwriteCharArray(char[] cArr) {
        if (cArr != null) {
            for (int i = 0; i < cArr.length; i++) {
                Arrays.fill(cArr, 0);
            }
        }
    }
}
