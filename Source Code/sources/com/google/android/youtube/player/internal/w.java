package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;

public final class w {

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    private static IBinder a(Class<?> cls, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) {
        String str;
        String valueOf;
        try {
            return (IBinder) cls.getConstructor(new Class[]{IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE}).newInstance(new Object[]{iBinder, iBinder2, iBinder3, Boolean.valueOf(z)});
        } catch (Throwable e) {
            str = "Could not find the right constructor for ";
            valueOf = String.valueOf(cls.getName());
            throw new a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        } catch (Throwable e2) {
            str = "Exception thrown by invoked constructor in ";
            valueOf = String.valueOf(cls.getName());
            throw new a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e2);
        } catch (Throwable e22) {
            str = "Unable to instantiate the dynamic class ";
            valueOf = String.valueOf(cls.getName());
            throw new a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e22);
        } catch (Throwable e222) {
            str = "Unable to call the default constructor of ";
            valueOf = String.valueOf(cls.getName());
            throw new a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e222);
        }
    }

    private static IBinder a(ClassLoader classLoader, String str, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) {
        try {
            return a(classLoader.loadClass(str), iBinder, iBinder2, iBinder3, z);
        } catch (Throwable e) {
            String str2 = "Unable to find dynamic class ";
            str = String.valueOf(str);
            throw new a(str.length() != 0 ? str2.concat(str) : new String(str2), e);
        }
    }

    public static f a(Activity activity, IBinder iBinder, boolean z) {
        b.u(activity);
        b.u(iBinder);
        Context au = aa.au(activity);
        if (au == null) {
            throw new a("Could not create remote context");
        }
        return com.google.android.youtube.player.internal.f.a.c(a(au.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", x.v(au).asBinder(), x.v(activity).asBinder(), iBinder, z));
    }
}
