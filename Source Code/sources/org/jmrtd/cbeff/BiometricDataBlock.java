package org.jmrtd.cbeff;

import java.io.Serializable;

public interface BiometricDataBlock extends Serializable {
    StandardBiometricHeader bAB();
}
