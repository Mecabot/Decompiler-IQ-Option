package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzdkj;
import com.google.android.gms.internal.zzdkl;
import com.google.android.gms.internal.zzdkm;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzdb {
    private static Object zzak(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, zzak(jSONObject.get(str)));
            }
            return hashMap;
        }
    }

    public static zzdkl zzly(String str) {
        zzbt zzam = zzgk.zzam(zzak(new JSONObject(str)));
        zzdkm zzbkw = zzdkl.zzbkw();
        for (int i = 0; i < zzam.zzym.length; i++) {
            zzbkw.zzc(zzdkj.zzbku().zzb(zzbi.INSTANCE_NAME.toString(), zzam.zzym[i]).zzb(zzbi.FUNCTION.toString(), zzgk.zzmi(zzt.zzbfj())).zzb(zzt.zzbfk(), zzam.zzyn[i]).zzbkv());
        }
        return zzbkw.zzbky();
    }
}
