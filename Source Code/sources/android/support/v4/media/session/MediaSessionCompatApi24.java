package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@RequiresApi(24)
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String str, Bundle bundle);

        void onPrepareFromSearch(String str, Bundle bundle);

        void onPrepareFromUri(Uri uri, Bundle bundle);
    }

    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromMediaId(str, bundle);
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromSearch(str, bundle);
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromUri(uri, bundle);
        }
    }

    MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0018 A:{Splitter: B:1:0x0002, ExcHandler: java.lang.NoSuchMethodException (r4_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0018 A:{Splitter: B:1:0x0002, ExcHandler: java.lang.NoSuchMethodException (r4_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:4:0x0018, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0019, code:
            android.util.Log.e(TAG, "Cannot execute MediaSession.getCallingPackage()", r4);
     */
    /* JADX WARNING: Missing block: B:6:0x0021, code:
            return null;
     */
    public static java.lang.String getCallingPackage(java.lang.Object r4) {
        /*
        r4 = (android.media.session.MediaSession) r4;
        r0 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r1 = "getCallingPackage";
        r2 = 0;
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r1 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r4 = r0.invoke(r4, r1);	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r4 = (java.lang.String) r4;	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        return r4;
    L_0x0018:
        r4 = move-exception;
        r0 = "MediaSessionCompatApi24";
        r1 = "Cannot execute MediaSession.getCallingPackage()";
        android.util.Log.e(r0, r1, r4);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompatApi24.getCallingPackage(java.lang.Object):java.lang.String");
    }
}
