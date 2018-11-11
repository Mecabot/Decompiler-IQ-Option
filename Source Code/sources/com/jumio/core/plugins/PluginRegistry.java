package com.jumio.core.plugins;

import java.util.ArrayList;
import java.util.Collection;

public class PluginRegistry {
    private static final String PLUGIN_BAM = "com.jumio.bam.BamPlugin";
    private static String PLUGIN_BARCODE = "com.jumio.nv.barcode.BarcodePlugin";
    private static String PLUGIN_BARCODE_VISION = "com.jumio.nv.barcode.vision.BarcodeVisionPlugin";
    private static String PLUGIN_EYE_TRACKING = "com.jumio.nv.liveness.eyetracking.EyeTrackingPlugin";
    private static final String PLUGIN_LINEFINDER = "com.jumio.nv.linefinder.LineFinderPlugin";
    private static final String PLUGIN_LIVENESS = "com.jumio.nv.liveness.LivenessPlugin";
    private static final String PLUGIN_MANUAL_PICTURE = "com.jumio.sdk.manual.ManualPicturePlugin";
    private static String PLUGIN_MRZ = "com.jumio.nv.mrz.MrzPlugin";
    private static String PLUGIN_NFC = "com.jumio.nv.nfc.NfcPlugin";
    private static String PLUGIN_OCR = "com.jumio.nv.ocr.OcrPlugin";
    private static final Object lock = new Object();

    public enum PluginMode {
        MRZ,
        NFC,
        TEMPLATE_MATCHER,
        BARCODE,
        BARCODE_NATIVE,
        CARD,
        LINE_FINDER,
        MANUAL,
        FACE
    }

    private static String classNameForPlugin(PluginMode pluginMode) {
        switch (pluginMode) {
            case MRZ:
                return PLUGIN_MRZ;
            case NFC:
                return PLUGIN_NFC;
            case TEMPLATE_MATCHER:
                return PLUGIN_OCR;
            case BARCODE:
                return PLUGIN_BARCODE;
            case BARCODE_NATIVE:
                return PLUGIN_BARCODE_VISION;
            case CARD:
                return PLUGIN_BAM;
            case LINE_FINDER:
                return PLUGIN_LINEFINDER;
            case MANUAL:
                return PLUGIN_MANUAL_PICTURE;
            case FACE:
                String str = PLUGIN_EYE_TRACKING;
                if (getClass(str) == null) {
                    return PLUGIN_LIVENESS;
                }
                return str;
            default:
                return null;
        }
    }

    private static Class<?> getClass(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    return Class.forName(str);
                }
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return null;
    }

    public static Collection<Class> getAvailablePlugins() {
        Collection arrayList;
        synchronized (lock) {
            arrayList = new ArrayList();
            if (hasPlugin(PluginMode.MRZ)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.MRZ)));
            }
            if (hasPlugin(PluginMode.NFC)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.NFC)));
            }
            if (hasPlugin(PluginMode.TEMPLATE_MATCHER)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.TEMPLATE_MATCHER)));
            }
            if (hasPlugin(PluginMode.BARCODE)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.BARCODE)));
            }
            if (hasPlugin(PluginMode.BARCODE_NATIVE)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.BARCODE_NATIVE)));
            }
            if (hasPlugin(PluginMode.CARD)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.CARD)));
            }
            if (hasPlugin(PluginMode.LINE_FINDER)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.LINE_FINDER)));
            }
            if (hasPlugin(PluginMode.MANUAL)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.MANUAL)));
            }
            if (hasPlugin(PluginMode.FACE)) {
                arrayList.add(getClass(classNameForPlugin(PluginMode.FACE)));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A:{Splitter: B:9:0x0015, ExcHandler: java.lang.InstantiationException (unused java.lang.InstantiationException)} */
    /* JADX WARNING: Missing block: B:11:0x0016, code:
            return r1;
     */
    public static com.jumio.core.plugins.Plugin getPlugin(com.jumio.core.plugins.PluginRegistry.PluginMode r2) {
        /*
        r0 = lock;
        monitor-enter(r0);
        r2 = classNameForPlugin(r2);	 Catch:{ all -> 0x0017 }
        r2 = getClass(r2);	 Catch:{ all -> 0x0017 }
        r1 = 0;
        if (r2 == 0) goto L_0x0015;
    L_0x000e:
        r2 = r2.newInstance();	 Catch:{ InstantiationException -> 0x0015, InstantiationException -> 0x0015 }
        r2 = (com.jumio.core.plugins.Plugin) r2;	 Catch:{ InstantiationException -> 0x0015, InstantiationException -> 0x0015 }
        r1 = r2;
    L_0x0015:
        monitor-exit(r0);	 Catch:{ all -> 0x0017 }
        return r1;
    L_0x0017:
        r2 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0017 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.plugins.PluginRegistry.getPlugin(com.jumio.core.plugins.PluginRegistry$PluginMode):com.jumio.core.plugins.Plugin");
    }

    public static boolean hasPlugin(PluginMode pluginMode) {
        boolean z;
        synchronized (lock) {
            z = getClass(classNameForPlugin(pluginMode)) != null;
        }
        return z;
    }
}
