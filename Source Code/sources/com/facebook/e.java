package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: CallbackManager */
public interface e {

    /* compiled from: CallbackManager */
    public static class a {
        public static e iL() {
            return new CallbackManagerImpl();
        }
    }

    boolean onActivityResult(int i, int i2, Intent intent);
}
