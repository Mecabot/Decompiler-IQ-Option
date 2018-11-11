package com.jumio.nv.ocr.environment;

import android.content.Context;
import com.jumio.core.environment.Environment;
import java.io.File;

public class NVOcrEnvironment extends Environment {
    public static final String BUILD_VERSION = "JMSDK 2.10.0 (0-63)";
    public static final String OCR_VERSION = "1.102.0";
    private static boolean a;

    public static String getCardDetectionSettingsPath(Context context) {
        return new File(Environment.getDataDirectory(context), "card_detector/card_detection_engine.xml").getAbsolutePath();
    }

    public static synchronized boolean loadTemplateMatcherLib() {
        synchronized (NVOcrEnvironment.class) {
            if (!a) {
                System.loadLibrary("jniTemplateMatcher");
                a = true;
            }
        }
        return true;
    }
}
