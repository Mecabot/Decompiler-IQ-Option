package com.appsflyer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

final class aa {

    static final class a implements IInterface {
        private IBinder qY;

        a(IBinder iBinder) {
            this.qY = iBinder;
        }

        public final IBinder asBinder() {
            return this.qY;
        }

        public final String fv() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.qY.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        final boolean fW() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.qY.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    static final class b {
        private final String pr;
        private final boolean qZ;

        b(String str, boolean z) {
            this.pr = str;
            this.qZ = z;
        }

        public final String fw() {
            return this.pr;
        }

        final boolean fX() {
            return this.qZ;
        }
    }

    static final class c implements ServiceConnection {
        private boolean qn;
        private final LinkedBlockingQueue<IBinder> ra;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private c() {
            this.qn = false;
            this.ra = new LinkedBlockingQueue(1);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.ra.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final IBinder fY() {
            if (this.qn) {
                throw new IllegalStateException();
            }
            this.qn = true;
            return (IBinder) this.ra.take();
        }
    }

    static b H(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnection cVar = new c();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, cVar, 1)) {
                    a aVar = new a(cVar.fY());
                    b bVar = new b(aVar.fv(), aVar.fW());
                    if (context != null) {
                        context.unbindService(cVar);
                    }
                    return bVar;
                }
                if (context != null) {
                    context.unbindService(cVar);
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                if (context != null) {
                    context.unbindService(cVar);
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
