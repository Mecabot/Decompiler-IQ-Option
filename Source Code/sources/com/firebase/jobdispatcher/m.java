package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IRemoteJobService */
public interface m extends IInterface {

    /* compiled from: IRemoteJobService */
    public static abstract class a extends Binder implements m {

        /* compiled from: IRemoteJobService */
        private static class a implements m {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void a(Bundle bundle, l lVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.firebase.jobdispatcher.IRemoteJobService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(Bundle bundle, boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.firebase.jobdispatcher.IRemoteJobService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.firebase.jobdispatcher.IRemoteJobService");
        }

        public static m b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.firebase.jobdispatcher.IRemoteJobService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof m)) {
                return new a(iBinder);
            }
            return (m) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                Bundle bundle = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.firebase.jobdispatcher.IRemoteJobService");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        a(bundle, com.firebase.jobdispatcher.l.a.a(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.firebase.jobdispatcher.IRemoteJobService");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        a(bundle, parcel.readInt() != 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.firebase.jobdispatcher.IRemoteJobService");
            return true;
        }
    }

    void a(Bundle bundle, l lVar);

    void a(Bundle bundle, boolean z);
}
