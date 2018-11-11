package com.jumio.sdk.extraction;

import java.util.concurrent.atomic.AtomicInteger;

public class ExtractionUpdateState {
    protected static AtomicInteger id = new AtomicInteger(0);
    public static final int notifyFlash = id.getAndIncrement();
    public static final int notifyFocus = id.getAndIncrement();
    public static final int receiveClickListener = id.getAndIncrement();
    public static final int saveExactImage = id.getAndIncrement();
    public static final int saveImage = id.getAndIncrement();
    public static final int shotTaken = id.getAndIncrement();
}
