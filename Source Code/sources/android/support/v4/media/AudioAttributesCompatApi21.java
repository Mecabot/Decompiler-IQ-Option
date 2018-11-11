package android.support.v4.media;

import android.media.AudioAttributes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class AudioAttributesCompatApi21 {
    private static final String TAG = "AudioAttributesCompat";
    private static Method sAudioAttributesToLegacyStreamType;

    static final class Wrapper {
        private AudioAttributes mWrapped;

        private Wrapper(AudioAttributes audioAttributes) {
            this.mWrapped = audioAttributes;
        }

        public static Wrapper wrap(@NonNull AudioAttributes audioAttributes) {
            if (audioAttributes != null) {
                return new Wrapper(audioAttributes);
            }
            throw new IllegalArgumentException("AudioAttributesApi21.Wrapper cannot wrap null");
        }

        public AudioAttributes unwrap() {
            return this.mWrapped;
        }
    }

    AudioAttributesCompatApi21() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002c A:{Splitter: B:1:0x0004, ExcHandler: java.lang.NoSuchMethodException (r6_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002c A:{Splitter: B:1:0x0004, ExcHandler: java.lang.NoSuchMethodException (r6_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002c A:{Splitter: B:1:0x0004, ExcHandler: java.lang.NoSuchMethodException (r6_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:7:0x002c, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x002d, code:
            android.util.Log.w(TAG, "getLegacyStreamType() failed on API21+", r6);
     */
    /* JADX WARNING: Missing block: B:9:0x0035, code:
            return -1;
     */
    public static int toLegacyStreamType(android.support.v4.media.AudioAttributesCompatApi21.Wrapper r6) {
        /*
        r6 = r6.unwrap();
        r0 = sAudioAttributesToLegacyStreamType;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x001a;
    L_0x000a:
        r0 = android.media.AudioAttributes.class;
        r3 = "toLegacyStreamType";
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r5 = android.media.AudioAttributes.class;
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r0 = r0.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        sAudioAttributesToLegacyStreamType = r0;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
    L_0x001a:
        r0 = sAudioAttributesToLegacyStreamType;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r3 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r2[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r6 = r0.invoke(r3, r2);	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r6 = (java.lang.Integer) r6;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r6 = r6.intValue();	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        return r6;
    L_0x002c:
        r6 = move-exception;
        r0 = "AudioAttributesCompat";
        r1 = "getLegacyStreamType() failed on API21+";
        android.util.Log.w(r0, r1, r6);
        r6 = -1;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.AudioAttributesCompatApi21.toLegacyStreamType(android.support.v4.media.AudioAttributesCompatApi21$Wrapper):int");
    }
}
