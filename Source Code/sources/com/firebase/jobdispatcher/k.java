package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.NonNull;

/* compiled from: GooglePlayMessengerCallback */
class k implements o {
    private final Messenger JZ;
    private final String tag;

    k(Messenger messenger, String str) {
        this.JZ = messenger;
        this.tag = str;
    }

    public void an(int i) {
        try {
            this.JZ.send(aq(i));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    private Message aq(int i) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i;
        Bundle bundle = new Bundle();
        bundle.putString("tag", this.tag);
        obtain.setData(bundle);
        return obtain;
    }
}
