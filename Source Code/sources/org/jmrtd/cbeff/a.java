package org.jmrtd.cbeff;

import java.io.InputStream;

/* compiled from: BiometricDataBlockDecoder */
public interface a<B extends BiometricDataBlock> {
    B a(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i, int i2);
}
