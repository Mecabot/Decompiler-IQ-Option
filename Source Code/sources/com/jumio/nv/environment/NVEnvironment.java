package com.jumio.nv.environment;

import android.content.Context;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.environment.Environment;
import java.io.File;

public class NVEnvironment extends Environment {
    public static final String BUILD_VERSION = "JMSDK 2.10.0 (0-63)";
    public static final String CDN_URL = StringObfuscater.format(new byte[]{(byte) -102, (byte) -49, (byte) -45, (byte) -82, (byte) -113, (byte) -15, (byte) -66, (byte) -29, (byte) -115, (byte) -78, (byte) -110, (byte) 86, (byte) 60, (byte) -99, (byte) -67, (byte) -53, (byte) 18, (byte) 44, (byte) -76, (byte) 121, (byte) 92, (byte) -31, (byte) 46, (byte) 69, (byte) -112, (byte) -86, (byte) 71, (byte) 17, (byte) -58, (byte) -59, (byte) 117, (byte) -17, (byte) 28, (byte) 116, (byte) 30, (byte) -73, (byte) 59, (byte) -91, (byte) -55, (byte) -35, (byte) -111, (byte) -125, (byte) -6, (byte) 70, (byte) -126, (byte) 95, (byte) 51, (byte) 113, (byte) -20, (byte) 115, (byte) 49, (byte) -126, (byte) 106, (byte) 79, (byte) 54, (byte) 123, (byte) -92}, -8030648480937895131L);
    public static final String CLIENTLIB_VERSION = "1.95.0";
    public static final String OCR_VERSION = "1.102.0";
    private static boolean a = false;

    public static synchronized boolean loadBenchmarkLib() {
        synchronized (NVEnvironment.class) {
            if (!a) {
                System.loadLibrary("nativeBenchmark");
                a = true;
            }
        }
        return true;
    }

    public static String getCardDetectionSettingsPath(Context context) {
        Environment.extractFile(context, NVEnvironment.class, "card_detector/card_detection_engine-by_jumio", "66715acf23836e35c1ccd770b1ccc4d77c9cbc811d766c1680c04120de1495d4", ".json");
        Environment.extractFile(context, NVEnvironment.class, "card_detector/card_detection_engine", "9ef87da4d5737222a284baa8fdbe72c2805334b85a779fb3a5f68cc18420bc3f", ".xml");
        Environment.extractFile(context, NVEnvironment.class, "card_detector/fast_findcard_config", "839c941a7446898b3f2e655850e65d60d8e70d72ac394c36b4b4bf9093042682", ".xml");
        return new File(Environment.getDataDirectory(context), "card_detector/card_detection_engine.xml").getAbsolutePath();
    }
}
