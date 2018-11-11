package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Hide
public final class zzaqr extends zzi<zzaqr> {
    private ProductAction zzdur;
    private final Map<String, List<Product>> zzdus = new HashMap();
    private final List<Promotion> zzdut = new ArrayList();
    private final List<Product> zzduu = new ArrayList();

    public final String toString() {
        Map hashMap = new HashMap();
        if (!this.zzduu.isEmpty()) {
            hashMap.put("products", this.zzduu);
        }
        if (!this.zzdut.isEmpty()) {
            hashMap.put("promotions", this.zzdut);
        }
        if (!this.zzdus.isEmpty()) {
            hashMap.put("impressions", this.zzdus);
        }
        hashMap.put("productAction", this.zzdur);
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqr zzaqr = (zzaqr) zzi;
        zzaqr.zzduu.addAll(this.zzduu);
        zzaqr.zzdut.addAll(this.zzdut);
        for (Entry entry : this.zzdus.entrySet()) {
            String str = (String) entry.getKey();
            for (Product product : (List) entry.getValue()) {
                if (product != null) {
                    Object obj = str == null ? "" : str;
                    if (!zzaqr.zzdus.containsKey(obj)) {
                        zzaqr.zzdus.put(obj, new ArrayList());
                    }
                    ((List) zzaqr.zzdus.get(obj)).add(product);
                }
            }
        }
        if (this.zzdur != null) {
            zzaqr.zzdur = this.zzdur;
        }
    }

    public final ProductAction zzwz() {
        return this.zzdur;
    }

    public final List<Product> zzxa() {
        return Collections.unmodifiableList(this.zzduu);
    }

    public final Map<String, List<Product>> zzxb() {
        return this.zzdus;
    }

    public final List<Promotion> zzxc() {
        return Collections.unmodifiableList(this.zzdut);
    }
}
