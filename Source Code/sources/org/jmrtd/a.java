package org.jmrtd;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.FileSystemStructured;

/* compiled from: MRTDFileSystem */
class a implements FileSystemStructured {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private short fbM = (short) 0;
    private PassportService fbN;
    private Map<Short, Object> fbO = new HashMap();
    private boolean isSelected = false;

    public a(PassportService passportService) {
        this.fbN = passportService;
    }

    public synchronized void d(short s) {
        if (this.fbM != s) {
            this.fbM = s;
            this.isSelected = false;
        }
    }
}
