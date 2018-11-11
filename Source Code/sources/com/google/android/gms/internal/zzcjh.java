package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.iqoption.dto.event.OtnEmissionExecuted;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcjh extends zzcli {
    private static AtomicReference<String[]> zzjkd = new AtomicReference();
    private static AtomicReference<String[]> zzjke = new AtomicReference();
    private static AtomicReference<String[]> zzjkf = new AtomicReference();

    zzcjh(zzckj zzckj) {
        super(zzckj);
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        zzbq.checkNotNull(strArr);
        zzbq.checkNotNull(strArr2);
        zzbq.checkNotNull(atomicReference);
        zzbq.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzcno.zzas(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(strArr2[i]);
                        stringBuilder.append("(");
                        stringBuilder.append(strArr[i]);
                        stringBuilder.append(")");
                        strArr3[i] = stringBuilder.toString();
                    }
                    str = strArr3[i];
                }
                return str;
            }
        }
        return str;
    }

    private static void zza(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private final void zza(StringBuilder stringBuilder, int i, zzcnt zzcnt) {
        if (zzcnt != null) {
            zza(stringBuilder, i);
            stringBuilder.append("filter {\n");
            zza(stringBuilder, i, "complement", zzcnt.zzjtf);
            zza(stringBuilder, i, "param_name", zzjq(zzcnt.zzjtg));
            int i2 = i + 1;
            String str = "string_filter";
            zzcnw zzcnw = zzcnt.zzjtd;
            if (zzcnw != null) {
                zza(stringBuilder, i2);
                stringBuilder.append(str);
                stringBuilder.append(" {\n");
                if (zzcnw.zzjtp != null) {
                    Object obj = "UNKNOWN_MATCH_TYPE";
                    switch (zzcnw.zzjtp.intValue()) {
                        case 1:
                            obj = "REGEXP";
                            break;
                        case 2:
                            obj = "BEGINS_WITH";
                            break;
                        case 3:
                            obj = "ENDS_WITH";
                            break;
                        case 4:
                            obj = "PARTIAL";
                            break;
                        case 5:
                            obj = "EXACT";
                            break;
                        case 6:
                            obj = "IN_LIST";
                            break;
                    }
                    zza(stringBuilder, i2, "match_type", obj);
                }
                zza(stringBuilder, i2, "expression", zzcnw.zzjtq);
                zza(stringBuilder, i2, "case_sensitive", zzcnw.zzjtr);
                if (zzcnw.zzjts.length > 0) {
                    zza(stringBuilder, i2 + 1);
                    stringBuilder.append("expression_list {\n");
                    for (String str2 : zzcnw.zzjts) {
                        zza(stringBuilder, i2 + 2);
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append("}\n");
                }
                zza(stringBuilder, i2);
                stringBuilder.append("}\n");
            }
            zza(stringBuilder, i2, "number_filter", zzcnt.zzjte);
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private final void zza(StringBuilder stringBuilder, int i, String str, zzcnu zzcnu) {
        if (zzcnu != null) {
            zza(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (zzcnu.zzjth != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (zzcnu.zzjth.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = "BETWEEN";
                        break;
                }
                zza(stringBuilder, i, "comparison_type", obj);
            }
            zza(stringBuilder, i, "match_as_float", zzcnu.zzjti);
            zza(stringBuilder, i, "comparison_value", zzcnu.zzjtj);
            zza(stringBuilder, i, "min_comparison_value", zzcnu.zzjtk);
            zza(stringBuilder, i, "max_comparison_value", zzcnu.zzjtl);
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, zzcof zzcof) {
        if (zzcof != null) {
            long[] jArr;
            int length;
            int i2;
            i++;
            zza(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            int i3 = 0;
            if (zzcof.zzjvp != null) {
                zza(stringBuilder, i + 1);
                stringBuilder.append("results: ");
                jArr = zzcof.zzjvp;
                length = jArr.length;
                int i4 = 0;
                i2 = 0;
                while (i4 < length) {
                    Long valueOf = Long.valueOf(jArr[i4]);
                    int i5 = i2 + 1;
                    if (i2 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i4++;
                    i2 = i5;
                }
                stringBuilder.append(10);
            }
            if (zzcof.zzjvo != null) {
                zza(stringBuilder, i + 1);
                stringBuilder.append("status: ");
                jArr = zzcof.zzjvo;
                int length2 = jArr.length;
                length = 0;
                while (i3 < length2) {
                    Long valueOf2 = Long.valueOf(jArr[i3]);
                    i2 = length + 1;
                    if (length != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i3++;
                    length = i2;
                }
                stringBuilder.append(10);
            }
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            zza(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append(10);
        }
    }

    private final void zza(StringBuilder stringBuilder, int i, zzcoa[] zzcoaArr) {
        if (zzcoaArr != null) {
            for (zzcoa zzcoa : zzcoaArr) {
                if (zzcoa != null) {
                    zza(stringBuilder, 2);
                    stringBuilder.append("audience_membership {\n");
                    zza(stringBuilder, 2, "audience_id", zzcoa.zzjst);
                    zza(stringBuilder, 2, "new_audience", zzcoa.zzjug);
                    zza(stringBuilder, 2, "current_data", zzcoa.zzjue);
                    zza(stringBuilder, 2, "previous_data", zzcoa.zzjuf);
                    zza(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final void zza(StringBuilder stringBuilder, int i, zzcob[] zzcobArr) {
        if (zzcobArr != null) {
            for (zzcob zzcob : zzcobArr) {
                if (zzcob != null) {
                    zza(stringBuilder, 2);
                    stringBuilder.append("event {\n");
                    zza(stringBuilder, 2, "name", zzjp(zzcob.name));
                    zza(stringBuilder, 2, "timestamp_millis", zzcob.zzjuj);
                    zza(stringBuilder, 2, "previous_timestamp_millis", zzcob.zzjuk);
                    zza(stringBuilder, 2, OtnEmissionExecuted.COUNT, zzcob.count);
                    zzcoc[] zzcocArr = zzcob.zzjui;
                    if (zzcocArr != null) {
                        for (zzcoc zzcoc : zzcocArr) {
                            if (zzcoc != null) {
                                zza(stringBuilder, 3);
                                stringBuilder.append("param {\n");
                                zza(stringBuilder, 3, "name", zzjq(zzcoc.name));
                                zza(stringBuilder, 3, "string_value", zzcoc.zzgim);
                                zza(stringBuilder, 3, "int_value", zzcoc.zzjum);
                                zza(stringBuilder, 3, "double_value", zzcoc.zzjsl);
                                zza(stringBuilder, 3);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    zza(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final void zza(StringBuilder stringBuilder, int i, zzcog[] zzcogArr) {
        if (zzcogArr != null) {
            for (zzcog zzcog : zzcogArr) {
                if (zzcog != null) {
                    zza(stringBuilder, 2);
                    stringBuilder.append("user_property {\n");
                    zza(stringBuilder, 2, "set_timestamp_millis", zzcog.zzjvr);
                    zza(stringBuilder, 2, "name", zzjr(zzcog.name));
                    zza(stringBuilder, 2, "string_value", zzcog.zzgim);
                    zza(stringBuilder, 2, "int_value", zzcog.zzjum);
                    zza(stringBuilder, 2, "double_value", zzcog.zzjsl);
                    zza(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    @Nullable
    private final String zzb(zzciu zzciu) {
        return zzciu == null ? null : !zzbat() ? zzciu.toString() : zzac(zzciu.zzbao());
    }

    private final boolean zzbat() {
        return this.zzjev.zzayp().zzae(3);
    }

    @Nullable
    protected final String zza(zzcis zzcis) {
        if (zzcis == null) {
            return null;
        }
        if (!zzbat()) {
            return zzcis.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{appId='");
        stringBuilder.append(zzcis.zzcm);
        stringBuilder.append("', name='");
        stringBuilder.append(zzjp(zzcis.name));
        stringBuilder.append("', params=");
        stringBuilder.append(zzb(zzcis.zzjhr));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected final String zza(zzcns zzcns) {
        if (zzcns == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        int i = 0;
        zza(stringBuilder, 0, "filter_id", zzcns.zzjsx);
        zza(stringBuilder, 0, "event_name", zzjp(zzcns.zzjsy));
        zza(stringBuilder, 1, "event_count_filter", zzcns.zzjtb);
        stringBuilder.append("  filters {\n");
        zzcnt[] zzcntArr = zzcns.zzjsz;
        int length = zzcntArr.length;
        while (i < length) {
            zza(stringBuilder, 2, zzcntArr[i]);
            i++;
        }
        zza(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    protected final String zza(zzcnv zzcnv) {
        if (zzcnv == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        zza(stringBuilder, 0, "filter_id", zzcnv.zzjsx);
        zza(stringBuilder, 0, "property_name", zzjr(zzcnv.zzjtn));
        zza(stringBuilder, 1, zzcnv.zzjto);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    protected final String zza(zzcod zzcod) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (zzcod.zzjun != null) {
            for (zzcoe zzcoe : zzcod.zzjun) {
                if (!(zzcoe == null || zzcoe == null)) {
                    zza(stringBuilder, 1);
                    stringBuilder.append("bundle {\n");
                    zza(stringBuilder, 1, "protocol_version", zzcoe.zzjup);
                    zza(stringBuilder, 1, "platform", zzcoe.zzjux);
                    zza(stringBuilder, 1, "gmp_version", zzcoe.zzjva);
                    zza(stringBuilder, 1, "uploading_gmp_version", zzcoe.zzjvb);
                    zza(stringBuilder, 1, "config_version", zzcoe.zzjvm);
                    zza(stringBuilder, 1, "gmp_app_id", zzcoe.zzjfl);
                    zza(stringBuilder, 1, "app_id", zzcoe.zzcm);
                    zza(stringBuilder, 1, "app_version", zzcoe.zzina);
                    zza(stringBuilder, 1, "app_version_major", zzcoe.zzjvi);
                    zza(stringBuilder, 1, "firebase_instance_id", zzcoe.zzjfn);
                    zza(stringBuilder, 1, "dev_cert_hash", zzcoe.zzjve);
                    zza(stringBuilder, 1, "app_store", zzcoe.zzjfs);
                    zza(stringBuilder, 1, "upload_timestamp_millis", zzcoe.zzjus);
                    zza(stringBuilder, 1, "start_timestamp_millis", zzcoe.zzjut);
                    zza(stringBuilder, 1, "end_timestamp_millis", zzcoe.zzjuu);
                    zza(stringBuilder, 1, "previous_bundle_start_timestamp_millis", zzcoe.zzjuv);
                    zza(stringBuilder, 1, "previous_bundle_end_timestamp_millis", zzcoe.zzjuw);
                    zza(stringBuilder, 1, "app_instance_id", zzcoe.zzjfk);
                    zza(stringBuilder, 1, "resettable_device_id", zzcoe.zzjvc);
                    zza(stringBuilder, 1, "device_id", zzcoe.zzjvl);
                    zza(stringBuilder, 1, "limited_ad_tracking", zzcoe.zzjvd);
                    zza(stringBuilder, 1, "os_version", zzcoe.zzda);
                    zza(stringBuilder, 1, "device_model", zzcoe.zzjuy);
                    zza(stringBuilder, 1, "user_default_language", zzcoe.zzjho);
                    zza(stringBuilder, 1, "time_zone_offset_minutes", zzcoe.zzjuz);
                    zza(stringBuilder, 1, "bundle_sequential_index", zzcoe.zzjvf);
                    zza(stringBuilder, 1, "service_upload", zzcoe.zzjvg);
                    zza(stringBuilder, 1, "health_monitor", zzcoe.zzjgi);
                    if (zzcoe.zzfqm.longValue() != 0) {
                        zza(stringBuilder, 1, "android_id", zzcoe.zzfqm);
                    }
                    zza(stringBuilder, 1, zzcoe.zzjur);
                    zza(stringBuilder, 1, zzcoe.zzjvh);
                    zza(stringBuilder, 1, zzcoe.zzjuq);
                    zza(stringBuilder, 1);
                    stringBuilder.append("}\n");
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    @Nullable
    protected final String zzac(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzbat()) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            stringBuilder.append(stringBuilder.length() != 0 ? ", " : "Bundle[{");
            stringBuilder.append(zzjq(str));
            stringBuilder.append("=");
            stringBuilder.append(bundle.get(str));
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    protected final boolean zzazq() {
        return false;
    }

    @Nullable
    protected final String zzb(zzcix zzcix) {
        if (zzcix == null) {
            return null;
        }
        if (!zzbat()) {
            return zzcix.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(zzcix.zzjgm);
        stringBuilder.append(",name=");
        stringBuilder.append(zzjp(zzcix.name));
        stringBuilder.append(",params=");
        stringBuilder.append(zzb(zzcix.zzjhr));
        return stringBuilder.toString();
    }

    @Nullable
    protected final String zzjp(String str) {
        return str == null ? null : !zzbat() ? str : zza(str, Event.zzjex, Event.zzjew, zzjkd);
    }

    @Nullable
    protected final String zzjq(String str) {
        return str == null ? null : !zzbat() ? str : zza(str, Param.zzjez, Param.zzjey, zzjke);
    }

    @Nullable
    protected final String zzjr(String str) {
        if (str == null) {
            return null;
        }
        if (!zzbat()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, UserProperty.zzjfb, UserProperty.zzjfa, zzjkf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experiment_id");
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
