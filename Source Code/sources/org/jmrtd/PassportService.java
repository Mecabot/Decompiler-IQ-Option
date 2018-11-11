package org.jmrtd;

import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardFileInputStream;
import net.sf.scuba.smartcards.CardService;
import org.jmrtd.protocol.AAResult;
import org.jmrtd.protocol.BACResult;
import org.jmrtd.protocol.PACEResult;
import org.jmrtd.protocol.SecureMessagingWrapper;
import org.jmrtd.protocol.a;
import org.jmrtd.protocol.b;
import org.jmrtd.protocol.d;

public class PassportService extends c {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    @Deprecated
    public int fbW;
    private State fbX;
    private boolean fbY;
    private a fbZ;
    private a fca;
    private SecureMessagingWrapper wrapper;

    enum State {
        SESSION_STOPPED_STATE,
        SESSION_STARTED_STATE,
        BAC_AUTHENTICATED_STATE,
        PACE_AUTHENTICATED_STATE,
        AA_EXECUTED_STATE,
        CA_EXECUTED_STATE,
        TA_AUTHENTICATED_STATE
    }

    public PassportService(CardService cardService) {
        this(cardService, 224);
    }

    public PassportService(CardService cardService, int i) {
        super(cardService);
        this.fbW = i;
        this.fbZ = new a(this);
        this.fca = new a(this);
        this.fbY = false;
        this.fbX = State.SESSION_STOPPED_STATE;
        Logger logger = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DEBUG: isExtendedAPDULengthSupported: ");
        stringBuilder.append(isExtendedAPDULengthSupported());
        logger.info(stringBuilder.toString());
    }

    public void open() {
        if (!isOpen()) {
            synchronized (this) {
                super.open();
                this.fbX = State.SESSION_STARTED_STATE;
            }
        }
    }

    public void hr(boolean z) {
        if (this.fbY) {
            LOGGER.info("Re-selecting ICAO applet");
        }
        if (z) {
            a((APDUWrapper) this.wrapper, fbQ);
        } else {
            a(null, fbQ);
        }
        this.fbY = true;
    }

    public boolean isOpen() {
        return this.fbX != State.SESSION_STOPPED_STATE;
    }

    public synchronized BACResult b(BACKeySpec bACKeySpec) {
        BACResult b;
        b = new b(this).b(bACKeySpec);
        this.wrapper = b.bBQ();
        this.fbX = State.BAC_AUTHENTICATED_STATE;
        return b;
    }

    public synchronized PACEResult a(KeySpec keySpec, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        PACEResult a;
        a = new d(this, this.wrapper).a(keySpec, str, algorithmParameterSpec);
        LOGGER.info("DEBUG: Starting secure messaging based on PACE");
        this.wrapper = a.bBQ();
        this.fbX = State.PACE_AUTHENTICATED_STATE;
        return a;
    }

    public AAResult a(PublicKey publicKey, String str, String str2, byte[] bArr) {
        AAResult a = new a(this, this.wrapper).a(publicKey, str, str2, bArr);
        this.fbX = State.AA_EXECUTED_STATE;
        return a;
    }

    public synchronized CardFileInputStream e(short s) {
        CardFileInputStream cardFileInputStream;
        if (this.fbY) {
            synchronized (this.fca) {
                this.fca.d(s);
                cardFileInputStream = new CardFileInputStream(this.fbW, this.fca);
            }
            return cardFileInputStream;
        }
        synchronized (this.fbZ) {
            this.fbZ.d(s);
            cardFileInputStream = new CardFileInputStream(this.fbW, this.fbZ);
        }
        return cardFileInputStream;
    }
}
