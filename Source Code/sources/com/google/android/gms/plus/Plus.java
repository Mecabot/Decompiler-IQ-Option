package com.google.android.gms.plus;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcwa;
import com.google.android.gms.internal.zzcwd;
import com.google.android.gms.internal.zzcwe;
import com.google.android.gms.internal.zzcwf;
import com.google.android.gms.plus.internal.zzh;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class Plus {
    @Deprecated
    public static final Api<PlusOptions> API = new Api("Plus.API", zzegv, zzegu);
    @Deprecated
    public static final Account AccountApi = new zzcwa();
    @Deprecated
    public static final People PeopleApi = new zzcwf();
    @Deprecated
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    @Deprecated
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    @Hide
    public static final zzf<zzh> zzegu = new zzf();
    @Hide
    private static com.google.android.gms.common.api.Api.zza<zzh, PlusOptions> zzegv = new zzc();
    @Hide
    @Deprecated
    private static zzb zzkhi = new zzcwe();
    @Hide
    private static zza zzkhj = new zzcwd();

    @Deprecated
    public static final class PlusOptions implements Optional {
        private String zzkhk;
        final Set<String> zzkhl;

        @Deprecated
        public static final class Builder {
            String zzkhk;
            final Set<String> zzkhl = new HashSet();

            @Deprecated
            public final Builder addActivityTypes(String... strArr) {
                zzbq.checkNotNull(strArr, "activityTypes may not be null.");
                for (Object add : strArr) {
                    this.zzkhl.add(add);
                }
                return this;
            }

            @Deprecated
            public final PlusOptions build() {
                return new PlusOptions(this, null);
            }

            @Deprecated
            public final Builder setServerClientId(String str) {
                this.zzkhk = str;
                return this;
            }
        }

        private PlusOptions() {
            this.zzkhk = null;
            this.zzkhl = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzkhk = builder.zzkhk;
            this.zzkhl = builder.zzkhl;
        }

        /* synthetic */ PlusOptions(Builder builder, zzc zzc) {
            this(builder);
        }

        @Deprecated
        public static Builder builder() {
            return new Builder();
        }
    }

    @Hide
    public static abstract class zza<R extends Result> extends zzm<R, zzh> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzegu, googleApiClient);
        }
    }

    private Plus() {
    }

    @Hide
    public static zzh zzc(GoogleApiClient googleApiClient, boolean z) {
        zzbq.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzbq.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzbq.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zzh) googleApiClient.zza(zzegu) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
