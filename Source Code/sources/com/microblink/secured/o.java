package com.microblink.secured;

import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFrame;
import java.util.Map;

/* compiled from: line */
public final class o {
    public a dWR;

    /* compiled from: line */
    public class a extends x {
        private Map<byte[], Camera1PreviewFrame> dWS;

        public final void dispose() {
            if (this.dWS != null) {
                for (byte[] bArr : this.dWS.keySet()) {
                    ((Camera1PreviewFrame) this.dWS.get(bArr)).dispose();
                }
                this.dWS.clear();
            }
            this.dWS = null;
        }

        protected final void finalize() {
            dispose();
            super.finalize();
        }
    }
}
