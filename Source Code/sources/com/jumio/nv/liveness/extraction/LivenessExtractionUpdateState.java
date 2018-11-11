package com.jumio.nv.liveness.extraction;

import com.jumio.nv.extraction.NVExtractionUpdateState;

public class LivenessExtractionUpdateState extends NVExtractionUpdateState {
    public static final int faceAlignmentInvalid = id.getAndIncrement();
    public static final String faceAlignmentInvalid_big = "big";
    public static final String faceAlignmentInvalid_small = "small";
    public static final int faceAlignmentOutOfBounds = id.getAndIncrement();
    public static final int faceAlignmentValid = id.getAndIncrement();
    public static final int faceDetails = id.getAndIncrement();
    public static final int facePosition = id.getAndIncrement();
    public static final int onStartedCaptureLiveness = id.getAndIncrement();
    public static final int validAlignmentFrame = id.getAndIncrement();
}
