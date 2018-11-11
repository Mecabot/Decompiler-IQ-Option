package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzayb;
import com.google.android.gms.tasks.Task;

public abstract class SmsRetrieverClient extends GoogleApi<NoOptions> implements SmsRetrieverApi {
    private static final Api<NoOptions> API = new Api("SmsRetriever.API", zzegv, zzegu);
    private static final zzf<zzayb> zzegu = new zzf();
    private static final zza<zzayb, NoOptions> zzegv = new zza();

    @Hide
    public SmsRetrieverClient(@NonNull Activity activity) {
        super(activity, API, null, new zzg());
    }

    @Hide
    public SmsRetrieverClient(@NonNull Context context) {
        super(context, API, null, new zzg());
    }

    public abstract Task<Void> startSmsRetriever();
}
