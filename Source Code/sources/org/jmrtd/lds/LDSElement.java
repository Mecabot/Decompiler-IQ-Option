package org.jmrtd.lds;

import java.io.Serializable;

public interface LDSElement extends Serializable {
    byte[] getEncoded();
}
