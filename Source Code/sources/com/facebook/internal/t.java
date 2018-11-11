package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* compiled from: PlatformServiceClient */
public abstract class t implements ServiceConnection {
    private final int El;
    private a Em;
    private Messenger En;
    private int Eo;
    private int Ep;
    private final String applicationId;
    private final Context context;
    private final Handler handler;
    private boolean running;

    /* compiled from: PlatformServiceClient */
    public interface a {
        void l(Bundle bundle);
    }

    protected abstract void j(Bundle bundle);

    public t(Context context, int i, int i2, int i3, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.context = context;
        this.Eo = i;
        this.Ep = i2;
        this.applicationId = str;
        this.El = i3;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                t.this.handleMessage(message);
            }
        };
    }

    public void a(a aVar) {
        this.Em = aVar;
    }

    public boolean start() {
        if (this.running || s.P(this.El) == -1) {
            return false;
        }
        Intent ab = s.ab(this.context);
        if (ab == null) {
            return false;
        }
        this.running = true;
        this.context.bindService(ab, this, 1);
        return true;
    }

    public void cancel() {
        this.running = false;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.En = new Messenger(iBinder);
        sendMessage();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.En = null;
        try {
            this.context.unbindService(this);
        } catch (IllegalArgumentException unused) {
            k(null);
        }
    }

    private void sendMessage() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
        j(bundle);
        Message obtain = Message.obtain(null, this.Eo);
        obtain.arg1 = this.El;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.handler);
        try {
            this.En.send(obtain);
        } catch (RemoteException unused) {
            k(null);
        }
    }

    protected void handleMessage(Message message) {
        if (message.what == this.Ep) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                k(null);
            } else {
                k(data);
            }
            try {
                this.context.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    private void k(Bundle bundle) {
        if (this.running) {
            this.running = false;
            a aVar = this.Em;
            if (aVar != null) {
                aVar.l(bundle);
            }
        }
    }
}
