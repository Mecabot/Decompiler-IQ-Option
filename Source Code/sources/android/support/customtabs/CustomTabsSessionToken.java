package android.support.customtabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.customtabs.ICustomTabsCallback.Stub;
import android.support.v4.app.BundleCompat;
import android.util.Log;

public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";
    private final CustomTabsCallback mCallback = new CustomTabsCallback() {
        public void onNavigationEvent(int i, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(i, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void extraCallback(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.extraCallback(str, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void onMessageChannelReady(Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void onPostMessage(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(i, uri, z, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }
    };
    private final ICustomTabsCallback mCallbackBinder;

    static class MockCallback extends Stub {
        public IBinder asBinder() {
            return this;
        }

        public void extraCallback(String str, Bundle bundle) {
        }

        public void onMessageChannelReady(Bundle bundle) {
        }

        public void onNavigationEvent(int i, Bundle bundle) {
        }

        public void onPostMessage(String str, Bundle bundle) {
        }

        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        }

        MockCallback() {
        }
    }

    public static CustomTabsSessionToken getSessionTokenFromIntent(Intent intent) {
        IBinder binder = BundleCompat.getBinder(intent.getExtras(), CustomTabsIntent.EXTRA_SESSION);
        if (binder == null) {
            return null;
        }
        return new CustomTabsSessionToken(Stub.asInterface(binder));
    }

    @NonNull
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback());
    }

    CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback) {
        this.mCallbackBinder = iCustomTabsCallback;
    }

    IBinder getCallbackBinder() {
        return this.mCallbackBinder.asBinder();
    }

    public int hashCode() {
        return getCallbackBinder().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof CustomTabsSessionToken) {
            return ((CustomTabsSessionToken) obj).getCallbackBinder().equals(this.mCallbackBinder.asBinder());
        }
        return false;
    }

    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    public boolean isAssociatedWith(CustomTabsSession customTabsSession) {
        return customTabsSession.getBinder().equals(this.mCallbackBinder);
    }
}
