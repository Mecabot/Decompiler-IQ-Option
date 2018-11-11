package com.google.firebase.iid;

import android.os.Bundle;

final class w extends x<Void> {
    w(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    final void I(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            finish(null);
        } else {
            b(new zzu(4, "Invalid response to one way request"));
        }
    }

    final boolean wI() {
        return true;
    }
}
