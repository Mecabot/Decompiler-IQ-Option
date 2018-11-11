package org.jmrtd.protocol;

import java.io.Serializable;
import org.jmrtd.BACKeySpec;

public class BACResult implements Serializable {
    private static final long serialVersionUID = -7114911372181772099L;
    private BACKeySpec bacKey;
    private SecureMessagingWrapper wrapper;

    public BACResult(BACKeySpec bACKeySpec, SecureMessagingWrapper secureMessagingWrapper) {
        this.bacKey = bACKeySpec;
        this.wrapper = secureMessagingWrapper;
    }

    public SecureMessagingWrapper bBQ() {
        return this.wrapper;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("BACResult [bacKey: ");
        stringBuilder2.append(this.bacKey);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", wrapper: ");
        stringBuilder2.append(this.wrapper);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (1303377669 + (this.bacKey == null ? 0 : this.bacKey.hashCode())) * 1234567891;
        if (this.wrapper != null) {
            i = this.wrapper.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BACResult bACResult = (BACResult) obj;
        if (this.bacKey == null) {
            if (bACResult.bacKey != null) {
                return false;
            }
        } else if (!this.bacKey.equals(bACResult.bacKey)) {
            return false;
        }
        if (this.wrapper == null) {
            if (bACResult.wrapper != null) {
                return false;
            }
        } else if (!this.wrapper.equals(bACResult.wrapper)) {
            return false;
        }
        return true;
    }
}
