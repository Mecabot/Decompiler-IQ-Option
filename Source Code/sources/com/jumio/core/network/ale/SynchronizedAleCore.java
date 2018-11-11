package com.jumio.core.network.ale;

import com.jumio.alejwt.swig.ALECore;
import com.jumio.alejwt.swig.ALERequest;
import com.jumio.alejwt.swig.ALESettings;

public class SynchronizedAleCore extends ALECore {
    private boolean instanceValid = true;
    private final Object lock = new Object();

    protected SynchronizedAleCore(long j, boolean z) {
        super(j, z);
    }

    public SynchronizedAleCore(ALESettings aLESettings) {
        super(aLESettings);
    }

    public synchronized void delete() {
        synchronized (this.lock) {
            this.instanceValid = false;
            super.delete();
        }
    }

    public ALERequest createRequest() {
        ALERequest createRequest;
        synchronized (this.lock) {
            if (this.instanceValid) {
                createRequest = super.createRequest();
            } else {
                throw new Exception("AleCore instance not valid");
            }
        }
        return createRequest;
    }

    public void destroyRequest(ALERequest aLERequest) {
        synchronized (this.lock) {
            if (this.instanceValid) {
                super.destroyRequest(aLERequest);
            } else {
                aLERequest.delete();
            }
            try {
            } catch (Exception unused) {
            }
        }
    }
}
