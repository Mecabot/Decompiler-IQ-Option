package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzaq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzcwn;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public final class zzh extends zzab<zzf> {
    private Person zzkht;
    private final zzn zzkhu;

    public zzh(Context context, Looper looper, zzr zzr, zzn zzn, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, zzr, connectionCallbacks, onConnectionFailedListener);
        this.zzkhu = zzn;
    }

    public final String getAccountName() {
        zzalv();
        try {
            return ((zzf) zzalw()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final zzaq zza(zzn<LoadPeopleResult> zzn, int i, String str) {
        zzalv();
        zza zzj = new zzj(zzn);
        try {
            return ((zzf) zzalw()).zza(zzj, 1, i, -1, str);
        } catch (RemoteException unused) {
            zzj.zza(DataHolder.zzbz(8), null);
            return null;
        }
    }

    protected final void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzkht = zzcwn.zzx(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public final void zza(zzn<LoadPeopleResult> zzn, Collection<String> collection) {
        zzalv();
        Object zzj = new zzj(zzn);
        try {
            ((zzf) zzalw()).zza(zzj, new ArrayList(collection));
        } catch (RemoteException unused) {
            zzj.zza(DataHolder.zzbz(8), null);
        }
    }

    protected final Bundle zzabt() {
        Bundle zzbeq = this.zzkhu.zzbeq();
        zzbeq.putStringArray("request_visible_actions", this.zzkhu.zzbeo());
        zzbeq.putString("auth_package", this.zzkhu.zzbep());
        return zzbeq;
    }

    public final boolean zzacc() {
        Set zzc = zzamr().zzc(Plus.API);
        return (zzc == null || zzc.isEmpty()) ? false : (zzc.size() == 1 && zzc.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    public final void zzbem() {
        zzalv();
        try {
            this.zzkht = null;
            ((zzf) zzalw()).zzbem();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final Person zzben() {
        zzalv();
        return this.zzkht;
    }

    public final void zzc(zzn<LoadPeopleResult> zzn, String[] strArr) {
        zza(zzn, Arrays.asList(strArr));
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
        return queryLocalInterface instanceof zzf ? (zzf) queryLocalInterface : new zzg(iBinder);
    }

    protected final String zzhm() {
        return "com.google.android.gms.plus.service.START";
    }

    protected final String zzhn() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public final void zzj(zzn<LoadPeopleResult> zzn) {
        zzalv();
        zza zzj = new zzj(zzn);
        try {
            ((zzf) zzalw()).zza(zzj, 2, 1, -1, null);
        } catch (RemoteException unused) {
            zzj.zza(DataHolder.zzbz(8), null);
        }
    }

    public final void zzk(zzn<Status> zzn) {
        zzalv();
        zzbem();
        Object zzk = new zzk(zzn);
        try {
            ((zzf) zzalw()).zza(zzk);
        } catch (RemoteException unused) {
            zzk.zzk(8, null);
        }
    }
}
