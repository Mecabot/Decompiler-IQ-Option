package org.jmrtd.lds;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVOutputStream;
import org.jmrtd.cbeff.BiometricDataBlock;

public abstract class CBEFFDataGroup<R extends BiometricDataBlock> extends DataGroup {
    protected static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2702959939408371946L;
    private Random random = new Random();
    private List<R> subRecords;

    protected CBEFFDataGroup(int i, InputStream inputStream) {
        super(i, inputStream);
    }

    public void a(R r) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.add(r);
    }

    public List<R> bAC() {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        return new ArrayList(this.subRecords);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CBEFFDataGroup)) {
            return false;
        }
        try {
            CBEFFDataGroup cBEFFDataGroup = (CBEFFDataGroup) obj;
            List bAC = bAC();
            List bAC2 = cBEFFDataGroup.bAC();
            int size = bAC.size();
            if (size != bAC2.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                BiometricDataBlock biometricDataBlock = (BiometricDataBlock) bAC.get(i);
                BiometricDataBlock biometricDataBlock2 = (BiometricDataBlock) bAC2.get(i);
                if (biometricDataBlock == null) {
                    if (biometricDataBlock2 != null) {
                        return false;
                    }
                } else if (!biometricDataBlock.equals(biometricDataBlock2)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Wrong class", e);
            return false;
        }
    }

    public int hashCode() {
        int i = 1234567891;
        for (BiometricDataBlock biometricDataBlock : bAC()) {
            if (biometricDataBlock == null) {
                i = (i * 3) + 5;
            } else {
                i = ((i + biometricDataBlock.hashCode()) * 5) + 7;
            }
        }
        return (i * 7) + 11;
    }

    protected void h(OutputStream outputStream) {
        if (this.subRecords.isEmpty()) {
            TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
            tLVOutputStream.writeTag(83);
            byte[] bArr = new byte[8];
            this.random.nextBytes(bArr);
            tLVOutputStream.writeValue(bArr);
        }
    }
}
