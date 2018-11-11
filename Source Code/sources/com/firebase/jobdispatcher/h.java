package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: GooglePlayJobCallback */
final class h implements o {
    private final IBinder JW;

    public h(IBinder iBinder) {
        this.JW = iBinder;
    }

    public void an(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
            obtain.writeInt(i);
            this.JW.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            obtain.recycle();
            obtain2.recycle();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
