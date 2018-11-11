package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IJobCallback */
public interface l extends IInterface {

    /* compiled from: IJobCallback */
    public static abstract class a extends Binder implements l {

        /* compiled from: IJobCallback */
        private static class a implements l {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void a(Bundle bundle, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.firebase.jobdispatcher.IJobCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.firebase.jobdispatcher.IJobCallback");
        }

        public static l a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.firebase.jobdispatcher.IJobCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                return new a(iBinder);
            }
            return (l) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.firebase.jobdispatcher.IJobCallback");
                a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.firebase.jobdispatcher.IJobCallback");
                return true;
            }
        }
    }

    void a(Bundle bundle, int i);
}
