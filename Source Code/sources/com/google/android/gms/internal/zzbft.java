package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger.zza;
import com.google.android.gms.phenotype.Phenotype;
import com.google.android.gms.phenotype.PhenotypeFlag;
import com.google.android.gms.phenotype.PhenotypeFlag.Factory;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class zzbft implements zza {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Factory zzfqj = new Factory(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).withGservicePrefix("gms:playlog:service:sampling_").withPhenotypePrefix("LogSampling__");
    private static Map<String, PhenotypeFlag<String>> zzfqk;
    private static Boolean zzfql;
    private static Long zzfqm;
    private final Context zzaiq;

    public zzbft(Context context) {
        this.zzaiq = context;
        if (zzfqk == null) {
            zzfqk = new HashMap();
        }
        if (this.zzaiq != null) {
            PhenotypeFlag.maybeInit(this.zzaiq);
        }
    }

    private static boolean zzcc(Context context) {
        if (zzfql == null) {
            zzfql = Boolean.valueOf(zzbih.zzdd(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzfql.booleanValue();
    }

    private static zzbfu zzge(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        int indexOf = str.indexOf(44);
        int i = 0;
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        String str3 = str2;
        int indexOf2 = str.indexOf(47, i);
        String str4;
        if (indexOf2 <= 0) {
            str2 = "LogSamplerImpl";
            str4 = "Failed to parse the rule: ";
            str = String.valueOf(str);
            Log.e(str2, str.length() != 0 ? str4.concat(str) : new String(str4));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return new zzbfu(str3, parseLong, parseLong2);
            }
            StringBuilder stringBuilder = new StringBuilder(72);
            stringBuilder.append("negative values not supported: ");
            stringBuilder.append(parseLong);
            stringBuilder.append("/");
            stringBuilder.append(parseLong2);
            Log.e("LogSamplerImpl", stringBuilder.toString());
            return null;
        } catch (Throwable e) {
            str4 = "LogSamplerImpl";
            String str5 = "parseLong() failed while parsing: ";
            str = String.valueOf(str);
            Log.e(str4, str.length() != 0 ? str5.concat(str) : new String(str5), e);
            return null;
        }
    }

    public final boolean zzg(String str, int i) {
        String str2 = null;
        String valueOf = (str == null || str.isEmpty()) ? i >= 0 ? String.valueOf(i) : null : str;
        if (valueOf == null) {
            return true;
        }
        if (this.zzaiq != null && zzcc(this.zzaiq)) {
            PhenotypeFlag phenotypeFlag = (PhenotypeFlag) zzfqk.get(valueOf);
            if (phenotypeFlag == null) {
                phenotypeFlag = zzfqj.createFlag(valueOf, null);
                zzfqk.put(valueOf, phenotypeFlag);
            }
            str2 = (String) phenotypeFlag.get();
        }
        zzbfu zzge = zzge(str2);
        if (zzge == null) {
            return true;
        }
        long j;
        byte[] array;
        long j2;
        long j3;
        StringBuilder stringBuilder;
        valueOf = zzge.zzfqn;
        Context context = this.zzaiq;
        if (zzfqm == null) {
            if (context != null) {
                zzfqm = zzcc(context) ? Long.valueOf(zzdnm.getLong(context.getContentResolver(), "android_id", 0)) : Long.valueOf(0);
            } else {
                j = 0;
                if (valueOf != null || valueOf.isEmpty()) {
                    array = ByteBuffer.allocate(8).putLong(j).array();
                } else {
                    array = valueOf.getBytes(UTF_8);
                    ByteBuffer allocate = ByteBuffer.allocate(array.length + 8);
                    allocate.put(array);
                    allocate.putLong(j);
                    array = allocate.array();
                }
                j = zzbfo.zzi(array);
                j2 = zzge.zzfqo;
                j3 = zzge.zzfqp;
                if (j2 >= 0 || j3 < 0) {
                    stringBuilder = new StringBuilder(72);
                    stringBuilder.append("negative values not supported: ");
                    stringBuilder.append(j2);
                    stringBuilder.append("/");
                    stringBuilder.append(j3);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                if (j3 > 0) {
                    if (j < 0) {
                        j = ((Long.MAX_VALUE % j3) + 1) + ((j & Long.MAX_VALUE) % j3);
                    }
                    if (j % j3 < j2) {
                        return true;
                    }
                }
                return false;
            }
        }
        j = zzfqm.longValue();
        if (valueOf != null) {
        }
        array = ByteBuffer.allocate(8).putLong(j).array();
        j = zzbfo.zzi(array);
        j2 = zzge.zzfqo;
        j3 = zzge.zzfqp;
        if (j2 >= 0) {
        }
        stringBuilder = new StringBuilder(72);
        stringBuilder.append("negative values not supported: ");
        stringBuilder.append(j2);
        stringBuilder.append("/");
        stringBuilder.append(j3);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
