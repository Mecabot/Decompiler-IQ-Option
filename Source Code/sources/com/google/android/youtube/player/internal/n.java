package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface n extends IInterface {

    public static abstract class a extends Binder implements n {

        private static class a implements n {
            private IBinder Lr;

            a(IBinder iBinder) {
                this.Lr = iBinder;
            }

            public final m a(l lVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.Lr.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    m e = com.google.android.youtube.player.internal.m.a.e(obtain2.readStrongBinder());
                    return e;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    obtain.writeInt(z);
                    this.Lr.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.Lr;
            }

            public final IBinder ph() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    this.Lr.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static n f(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new a(iBinder) : (n) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                IBinder ph;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                        ph = ph();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(ph);
                        return true;
                    case 2:
                        l lVar;
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                        ph = parcel.readStrongBinder();
                        IBinder iBinder = null;
                        if (ph == null) {
                            lVar = null;
                        } else {
                            IInterface queryLocalInterface = ph.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                            lVar = (queryLocalInterface == null || !(queryLocalInterface instanceof l)) ? new a(ph) : (l) queryLocalInterface;
                        }
                        m a = a(lVar);
                        parcel2.writeNoException();
                        if (a != null) {
                            iBinder = a.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                        a(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.google.android.youtube.player.internal.IYouTubeService");
            return true;
        }
    }

    m a(l lVar);

    void a(boolean z);

    IBinder ph();
}
