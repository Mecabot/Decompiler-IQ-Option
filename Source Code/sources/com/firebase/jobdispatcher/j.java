package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

@TargetApi(21)
/* compiled from: GooglePlayMessageHandler */
class j extends Handler {
    private final GooglePlayReceiver JY;

    public j(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.JY = googlePlayReceiver;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.JY.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                int i = message.what;
                if (i != 4) {
                    switch (i) {
                        case 1:
                            a(message);
                            break;
                        case 2:
                            b(message);
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unrecognized message received: ");
                            stringBuilder.append(message);
                            Log.e("FJD.GooglePlayReceiver", stringBuilder.toString());
                            break;
                    }
                }
            } catch (SecurityException unused) {
                Log.e("FJD.GooglePlayReceiver", "Message was not sent from GCM.");
            }
        }
    }

    private void a(Message message) {
        Bundle data = message.getData();
        Messenger messenger = message.replyTo;
        String string = data.getString("tag");
        if (messenger == null || string == null) {
            if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
                Log.d("FJD.GooglePlayReceiver", "Invalid start execution message.");
            }
            return;
        }
        this.JY.oE().a(this.JY.a(new k(messenger, string), data));
    }

    private void b(Message message) {
        a D = GooglePlayReceiver.oH().D(message.getData());
        if (D == null) {
            if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
                Log.d("FJD.GooglePlayReceiver", "Invalid stop execution message.");
            }
            return;
        }
        d.a(D.oP(), true);
    }
}
