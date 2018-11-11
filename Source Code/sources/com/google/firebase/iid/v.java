package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class v {
    private final m YH;
    private final Messenger Yt;

    v(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.Yt = new Messenger(iBinder);
            this.YH = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.YH = new m(iBinder);
            this.Yt = null;
        } else {
            String str = "MessengerIpcClient";
            String str2 = "Invalid interface descriptor: ";
            interfaceDescriptor = String.valueOf(interfaceDescriptor);
            Log.w(str, interfaceDescriptor.length() != 0 ? str2.concat(interfaceDescriptor) : new String(str2));
            throw new RemoteException();
        }
    }

    final void send(Message message) {
        if (this.Yt != null) {
            this.Yt.send(message);
        } else if (this.YH != null) {
            this.YH.send(message);
        } else {
            throw new IllegalStateException("Both messengers are null");
        }
    }
}
