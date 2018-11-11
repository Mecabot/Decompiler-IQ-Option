package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.KeyEvent;
import java.util.List;

public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        private static class a implements f {
            private IBinder Lr;

            a(IBinder iBinder) {
                this.Lr = iBinder;
            }

            public final boolean H(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    boolean z = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.Lr.transact(40, obtain, obtain2, 0);
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

            public final void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.Lr.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(Configuration configuration) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (configuration != null) {
                        obtain.writeInt(1);
                        configuration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.Lr.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(g gVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.Lr.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(h hVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
                    this.Lr.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(i iVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.Lr.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(j jVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.Lr.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    this.Lr.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.Lr.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.Lr.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(List<String> list, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.Lr.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(z);
                    this.Lr.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(int i, KeyEvent keyEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    boolean z = true;
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.Lr.transact(41, obtain, obtain2, 0);
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

            public final IBinder asBinder() {
                return this.Lr;
            }

            public final void b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.Lr.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.Lr.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(List<String> list, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.Lr.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(z);
                    this.Lr.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean b(int i, KeyEvent keyEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    boolean z = true;
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.Lr.transact(42, obtain, obtain2, 0);
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

            public final void c(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.Lr.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(z);
                    this.Lr.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    boolean z = false;
                    this.Lr.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.Lr.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(z);
                    this.Lr.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    boolean z = false;
                    this.Lr.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void e(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(z);
                    this.Lr.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    boolean z = false;
                    this.Lr.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void l() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void l(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.Lr.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void n() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void o() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void p() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void pi() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle pj() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final v pk() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    v i = com.google.android.youtube.player.internal.v.a.i(obtain2.readStrongBinder());
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void q() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.Lr.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static f c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new a(iBinder) : (f) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                boolean z = false;
                g gVar = null;
                boolean c;
                IBinder readStrongBinder;
                IInterface queryLocalInterface;
                KeyEvent keyEvent;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(z);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        a(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        l(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        a(parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        b(parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        a(parcel.createStringArrayList(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        b(parcel.createStringArrayList(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        c = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        c = d();
                        parcel2.writeNoException();
                        parcel2.writeInt(c);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        c = e();
                        parcel2.writeNoException();
                        parcel2.writeInt(c);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        f();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        g();
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        i = h();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        i = i();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        b(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        b(z);
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        c(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        i = j();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        d(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        c(z);
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        d(z);
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        readStrongBinder = parcel.readStrongBinder();
                        if (readStrongBinder != null) {
                            queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                            gVar = (queryLocalInterface == null || !(queryLocalInterface instanceof g)) ? new a(readStrongBinder) : (g) queryLocalInterface;
                        }
                        a(gVar);
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        j aVar;
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        readStrongBinder = parcel.readStrongBinder();
                        if (readStrongBinder != null) {
                            queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                            aVar = (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new a(readStrongBinder) : (j) queryLocalInterface;
                        }
                        a(aVar);
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        i aVar2;
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        readStrongBinder = parcel.readStrongBinder();
                        if (readStrongBinder != null) {
                            queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                            aVar2 = (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new a(readStrongBinder) : (i) queryLocalInterface;
                        }
                        a(aVar2);
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        h aVar3;
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        readStrongBinder = parcel.readStrongBinder();
                        if (readStrongBinder != null) {
                            queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                            aVar3 = (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new a(readStrongBinder) : (h) queryLocalInterface;
                        }
                        a(aVar3);
                        parcel2.writeNoException();
                        return true;
                    case 30:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        pi();
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        l();
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        Configuration configuration;
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (parcel.readInt() != 0) {
                            configuration = (Configuration) Configuration.CREATOR.createFromParcel(parcel);
                        }
                        a(configuration);
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        m();
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        n();
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        o();
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        p();
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        e(z);
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        q();
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        Bundle pj = pj();
                        parcel2.writeNoException();
                        if (pj != null) {
                            parcel2.writeInt(1);
                            pj.writeToParcel(parcel2, 1);
                            return true;
                        }
                        parcel2.writeInt(0);
                        return true;
                    case 40:
                        Bundle bundle;
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        c = H(bundle);
                        parcel2.writeNoException();
                        parcel2.writeInt(c);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        i = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                        }
                        c = a(i, keyEvent);
                        parcel2.writeNoException();
                        parcel2.writeInt(c);
                        return true;
                    case 42:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        i = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                        }
                        c = b(i, keyEvent);
                        parcel2.writeNoException();
                        parcel2.writeInt(c);
                        return true;
                    case 43:
                        IBinder asBinder;
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        v pk = pk();
                        parcel2.writeNoException();
                        if (pk != null) {
                            asBinder = pk.asBinder();
                        }
                        parcel2.writeStrongBinder(asBinder);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            return true;
        }
    }

    boolean H(Bundle bundle);

    void a();

    void a(int i);

    void a(Configuration configuration);

    void a(g gVar);

    void a(h hVar);

    void a(i iVar);

    void a(j jVar);

    void a(String str);

    void a(String str, int i);

    void a(String str, int i, int i2);

    void a(List<String> list, int i, int i2);

    void a(boolean z);

    boolean a(int i, KeyEvent keyEvent);

    void b();

    void b(int i);

    void b(String str, int i, int i2);

    void b(List<String> list, int i, int i2);

    void b(boolean z);

    boolean b(int i, KeyEvent keyEvent);

    void c(int i);

    void c(boolean z);

    boolean c();

    void d(int i);

    void d(boolean z);

    boolean d();

    void e(boolean z);

    boolean e();

    void f();

    void g();

    int h();

    int i();

    int j();

    void l();

    void l(String str, int i);

    void m();

    void n();

    void o();

    void p();

    void pi();

    Bundle pj();

    v pk();

    void q();
}
