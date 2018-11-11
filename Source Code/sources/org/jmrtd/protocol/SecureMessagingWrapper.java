package org.jmrtd.protocol;

import java.io.Serializable;
import net.sf.scuba.smartcards.APDUWrapper;

public abstract class SecureMessagingWrapper implements Serializable, APDUWrapper {
    private static final long serialVersionUID = 4709645514566992414L;

    public abstract long bBP();
}
