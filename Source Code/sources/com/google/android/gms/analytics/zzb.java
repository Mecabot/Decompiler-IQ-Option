package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaql;
import com.google.android.gms.internal.zzaqm;
import com.google.android.gms.internal.zzaqn;
import com.google.android.gms.internal.zzaqo;
import com.google.android.gms.internal.zzaqp;
import com.google.android.gms.internal.zzaqq;
import com.google.android.gms.internal.zzaqr;
import com.google.android.gms.internal.zzaqs;
import com.google.android.gms.internal.zzaqt;
import com.google.android.gms.internal.zzaqu;
import com.google.android.gms.internal.zzaqv;
import com.google.android.gms.internal.zzaqw;
import com.google.android.gms.internal.zzaqx;
import com.google.android.gms.internal.zzarh;
import com.google.android.gms.internal.zzarj;
import com.google.android.gms.internal.zzark;
import com.google.android.gms.internal.zzarn;
import com.google.android.gms.internal.zzasy;
import com.google.android.gms.internal.zzatt;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.fragment.cashbox.deppage.a;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Hide
public final class zzb extends zzarh implements zzo {
    private static DecimalFormat zzdua;
    private final zzark zzdtw;
    private final String zzdub;
    private final Uri zzduc;

    public zzb(zzark zzark, String str) {
        this(zzark, str, true, false);
    }

    private zzb(zzark zzark, String str, boolean z, boolean z2) {
        super(zzark);
        zzbq.zzgv(str);
        this.zzdtw = zzark;
        this.zzdub = str;
        this.zzduc = zzdl(this.zzdub);
    }

    private static void zza(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, zzb(d));
        }
    }

    private static void zza(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            StringBuilder stringBuilder = new StringBuilder(23);
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            map.put(str, stringBuilder.toString());
        }
    }

    private static void zza(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void zza(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    @Hide
    private static String zzb(double d) {
        if (zzdua == null) {
            zzdua = new DecimalFormat("0.######");
        }
        return zzdua.format(d);
    }

    @Hide
    private static Map<String, String> zzc(zzg zzg) {
        CharSequence zzaj;
        Map hashMap = new HashMap();
        zzaqp zzaqp = (zzaqp) zzg.zza(zzaqp.class);
        if (zzaqp != null) {
            for (Entry entry : zzaqp.zzwy().entrySet()) {
                Boolean value = entry.getValue();
                Object obj = null;
                if (value != null) {
                    if (value instanceof String) {
                        String str = (String) value;
                        if (!TextUtils.isEmpty(str)) {
                            obj = str;
                        }
                    } else if (value instanceof Double) {
                        Double d = (Double) value;
                        if (d.doubleValue() != 0.0d) {
                            obj = zzb(d.doubleValue());
                        }
                    } else if (!(value instanceof Boolean)) {
                        obj = String.valueOf(value);
                    } else if (value != Boolean.FALSE) {
                        obj = "1";
                    }
                }
                if (obj != null) {
                    hashMap.put((String) entry.getKey(), obj);
                }
            }
        }
        zzaqu zzaqu = (zzaqu) zzg.zza(zzaqu.class);
        if (zzaqu != null) {
            zza(hashMap, "t", zzaqu.zzxd());
            zza(hashMap, "cid", zzaqu.zzxe());
            zza(hashMap, "uid", zzaqu.getUserId());
            zza(hashMap, "sc", zzaqu.zzxh());
            zza(hashMap, "sf", zzaqu.zzxj());
            zza(hashMap, "ni", zzaqu.zzxi());
            zza(hashMap, "adid", zzaqu.zzxf());
            zza(hashMap, "ate", zzaqu.zzxg());
        }
        zzaqv zzaqv = (zzaqv) zzg.zza(zzaqv.class);
        if (zzaqv != null) {
            zza(hashMap, "cd", zzaqv.zzxk());
            zza(hashMap, a.TAG, (double) zzaqv.zzxl());
            zza(hashMap, "dr", zzaqv.zzxm());
        }
        zzaqs zzaqs = (zzaqs) zzg.zza(zzaqs.class);
        if (zzaqs != null) {
            zza(hashMap, "ec", zzaqs.getCategory());
            zza(hashMap, "ea", zzaqs.getAction());
            zza(hashMap, "el", zzaqs.getLabel());
            zza(hashMap, "ev", (double) zzaqs.getValue());
        }
        zzaqm zzaqm = (zzaqm) zzg.zza(zzaqm.class);
        if (zzaqm != null) {
            zza(hashMap, "cn", zzaqm.getName());
            zza(hashMap, "cs", zzaqm.getSource());
            zza(hashMap, "cm", zzaqm.zzwq());
            zza(hashMap, "ck", zzaqm.zzwr());
            zza(hashMap, "cc", zzaqm.getContent());
            zza(hashMap, "ci", zzaqm.getId());
            zza(hashMap, "anid", zzaqm.zzws());
            zza(hashMap, "gclid", zzaqm.zzwt());
            zza(hashMap, "dclid", zzaqm.zzwu());
            zza(hashMap, b.ACLID, zzaqm.zzwv());
        }
        zzaqt zzaqt = (zzaqt) zzg.zza(zzaqt.class);
        if (zzaqt != null) {
            zza(hashMap, "exd", zzaqt.zzdxh);
            zza(hashMap, "exf", zzaqt.zzdxi);
        }
        zzaqw zzaqw = (zzaqw) zzg.zza(zzaqw.class);
        if (zzaqw != null) {
            zza(hashMap, "sn", zzaqw.zzdxw);
            zza(hashMap, "sa", zzaqw.zzdxe);
            zza(hashMap, "st", zzaqw.zzdxx);
        }
        zzaqx zzaqx = (zzaqx) zzg.zza(zzaqx.class);
        if (zzaqx != null) {
            zza(hashMap, "utv", zzaqx.zzdxy);
            zza(hashMap, "utt", (double) zzaqx.zzdxz);
            zza(hashMap, "utc", zzaqx.mCategory);
            zza(hashMap, "utl", zzaqx.zzdxf);
        }
        zzaqn zzaqn = (zzaqn) zzg.zza(zzaqn.class);
        if (zzaqn != null) {
            for (Entry entry2 : zzaqn.zzww().entrySet()) {
                zzaj = zzd.zzaj(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(zzaj)) {
                    hashMap.put(zzaj, (String) entry2.getValue());
                }
            }
        }
        zzaqo zzaqo = (zzaqo) zzg.zza(zzaqo.class);
        if (zzaqo != null) {
            for (Entry entry22 : zzaqo.zzwx().entrySet()) {
                zzaj = zzd.zzal(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(zzaj)) {
                    hashMap.put(zzaj, zzb(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        zzaqr zzaqr = (zzaqr) zzg.zza(zzaqr.class);
        if (zzaqr != null) {
            String str2;
            ProductAction zzwz = zzaqr.zzwz();
            if (zzwz != null) {
                for (Entry entry3 : zzwz.build().entrySet()) {
                    Object str22;
                    if (((String) entry3.getKey()).startsWith("&")) {
                        str22 = ((String) entry3.getKey()).substring(1);
                    } else {
                        str22 = (String) entry3.getKey();
                    }
                    hashMap.put(str22, (String) entry3.getValue());
                }
            }
            int i = 1;
            for (Promotion zzdx : zzaqr.zzxc()) {
                hashMap.putAll(zzdx.zzdx(zzd.zzap(i)));
                i++;
            }
            i = 1;
            for (Product zzdx2 : zzaqr.zzxa()) {
                hashMap.putAll(zzdx2.zzdx(zzd.zzan(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry32 : zzaqr.zzxb().entrySet()) {
                List<Product> list = (List) entry32.getValue();
                String zzas = zzd.zzas(i2);
                int i3 = 1;
                for (Product product : list) {
                    String valueOf = String.valueOf(zzas);
                    String valueOf2 = String.valueOf(zzd.zzaq(i3));
                    hashMap.putAll(product.zzdx(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry32.getKey())) {
                    str22 = String.valueOf(zzas);
                    zzas = String.valueOf("nm");
                    hashMap.put(zzas.length() != 0 ? str22.concat(zzas) : new String(str22), (String) entry32.getKey());
                }
                i2++;
            }
        }
        zzaqq zzaqq = (zzaqq) zzg.zza(zzaqq.class);
        if (zzaqq != null) {
            zza(hashMap, "ul", zzaqq.getLanguage());
            zza(hashMap, "sd", (double) zzaqq.zzdxb);
            zza(hashMap, "sr", zzaqq.zzcly, zzaqq.zzclz);
            zza(hashMap, "vp", zzaqq.zzdxc, zzaqq.zzdxd);
        }
        zzaql zzaql = (zzaql) zzg.zza(zzaql.class);
        if (zzaql != null) {
            zza(hashMap, "an", zzaql.zzwn());
            zza(hashMap, "aid", zzaql.getAppId());
            zza(hashMap, "aiid", zzaql.zzwp());
            zza(hashMap, "av", zzaql.zzwo());
        }
        return hashMap;
    }

    static Uri zzdl(String str) {
        zzbq.zzgv(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    public final void zzb(zzg zzg) {
        zzbq.checkNotNull(zzg);
        zzbq.checkArgument(zzg.zzwb(), "Can't deliver not submitted measurement");
        zzbq.zzgw("deliver should be called on worker thread");
        zzg zzvx = zzg.zzvx();
        zzaqu zzaqu = (zzaqu) zzvx.zzb(zzaqu.class);
        if (TextUtils.isEmpty(zzaqu.zzxd())) {
            zzh().zzf(zzc(zzvx), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzaqu.zzxe())) {
            zzh().zzf(zzc(zzvx), "Ignoring measurement without client id");
        } else if (!this.zzdtw.zzyn().getAppOptOut()) {
            double zzxj = zzaqu.zzxj();
            if (zzatt.zza(zzxj, zzaqu.zzxe())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzxj));
                return;
            }
            Map zzc = zzc(zzvx);
            zzc.put("v", "1");
            zzc.put("_v", zzarj.zzdyr);
            zzc.put("tid", this.zzdub);
            if (this.zzdtw.zzyn().isDryRunEnabled()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Entry entry : zzc.entrySet()) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                }
                zzc("Dry run is enabled. GoogleAnalytics would have sent", stringBuilder.toString());
                return;
            }
            Map hashMap = new HashMap();
            zzatt.zzb(hashMap, "uid", zzaqu.getUserId());
            zzaql zzaql = (zzaql) zzg.zza(zzaql.class);
            if (zzaql != null) {
                zzatt.zzb(hashMap, "an", zzaql.zzwn());
                zzatt.zzb(hashMap, "aid", zzaql.getAppId());
                zzatt.zzb(hashMap, "av", zzaql.zzwo());
                zzatt.zzb(hashMap, "aiid", zzaql.zzwp());
            }
            zzc.put("_s", String.valueOf(zzj().zza(new zzarn(0, zzaqu.zzxe(), this.zzdub, TextUtils.isEmpty(zzaqu.zzxf()) ^ 1, 0, hashMap))));
            zzj().zza(new zzasy(zzh(), zzc, zzg.zzvz(), true));
        }
    }

    public final Uri zzvu() {
        return this.zzduc;
    }
}
