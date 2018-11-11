package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzem extends zzga {
    private static final String ID = zzbh.REGEX.toString();
    private static final String zzkrx = zzbi.IGNORE_CASE.toString();

    public zzem() {
        super(ID);
    }

    protected final boolean zza(String str, String str2, Map<String, zzbt> map) {
        try {
            return Pattern.compile(str2, zzgk.zzh((zzbt) map.get(zzkrx)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }
}
