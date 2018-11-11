package com.microblink.view.recognition;

import com.microblink.util.Log;

/* compiled from: line */
public enum DetectionStatus {
    SUCCESS,
    FAIL,
    CAMERA_TOO_HIGH,
    PARTIAL_OBJECT,
    CAMERA_AT_ANGLE,
    CAMERA_TOO_NEAR;

    public static DetectionStatus fromNativeDetectionStatus(int i) {
        if (i == 4) {
            return CAMERA_TOO_HIGH;
        }
        if (i != 8) {
            if (i == 16) {
                return PARTIAL_OBJECT;
            }
            if (i == 32) {
                return CAMERA_AT_ANGLE;
            }
            if (i == 64) {
                return CAMERA_TOO_NEAR;
            }
            switch (i) {
                case 1:
                    break;
                case 2:
                    return FAIL;
                default:
                    Log.b(DetectionStatus.class, "Unknown native detection status {}", Integer.valueOf(i));
                    return FAIL;
            }
        }
        return SUCCESS;
    }
}
