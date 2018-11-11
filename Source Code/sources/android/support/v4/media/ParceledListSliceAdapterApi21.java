package android.support.v4.media;

import android.support.annotation.RequiresApi;
import java.lang.reflect.Constructor;

@RequiresApi(21)
class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    ParceledListSliceAdapterApi21() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0015 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.ClassNotFoundException (r0_3 'e' java.lang.ReflectiveOperationException)} */
    /* JADX WARNING: Missing block: B:2:0x0015, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:3:0x0016, code:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:4:?, code:
            return;
     */
    static {
        /*
        r0 = "android.content.pm.ParceledListSlice";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0015, ClassNotFoundException -> 0x0015 }
        r1 = 1;
        r1 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0015, ClassNotFoundException -> 0x0015 }
        r2 = 0;
        r3 = java.util.List.class;
        r1[r2] = r3;	 Catch:{ ClassNotFoundException -> 0x0015, ClassNotFoundException -> 0x0015 }
        r0 = r0.getConstructor(r1);	 Catch:{ ClassNotFoundException -> 0x0015, ClassNotFoundException -> 0x0015 }
        sConstructor = r0;	 Catch:{ ClassNotFoundException -> 0x0015, ClassNotFoundException -> 0x0015 }
        goto L_0x0019;
    L_0x0015:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.ParceledListSliceAdapterApi21.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x000d A:{Splitter: B:0:0x0000, ExcHandler: java.lang.InstantiationException (r3_2 'e' java.lang.ReflectiveOperationException)} */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x000d A:{Splitter: B:0:0x0000, ExcHandler: java.lang.InstantiationException (r3_2 'e' java.lang.ReflectiveOperationException)} */
    /* JADX WARNING: Missing block: B:2:0x000d, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:3:0x000e, code:
            r3.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:4:?, code:
            return null;
     */
    static java.lang.Object newInstance(java.util.List<android.media.browse.MediaBrowser.MediaItem> r3) {
        /*
        r0 = sConstructor;	 Catch:{ InstantiationException -> 0x000d, InstantiationException -> 0x000d, InstantiationException -> 0x000d }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ InstantiationException -> 0x000d, InstantiationException -> 0x000d, InstantiationException -> 0x000d }
        r2 = 0;
        r1[r2] = r3;	 Catch:{ InstantiationException -> 0x000d, InstantiationException -> 0x000d, InstantiationException -> 0x000d }
        r3 = r0.newInstance(r1);	 Catch:{ InstantiationException -> 0x000d, InstantiationException -> 0x000d, InstantiationException -> 0x000d }
        goto L_0x0012;
    L_0x000d:
        r3 = move-exception;
        r3.printStackTrace();
        r3 = 0;
    L_0x0012:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.ParceledListSliceAdapterApi21.newInstance(java.util.List):java.lang.Object");
    }
}
