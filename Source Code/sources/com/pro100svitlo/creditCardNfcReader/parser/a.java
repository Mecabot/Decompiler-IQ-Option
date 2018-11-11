package com.pro100svitlo.creditCardNfcReader.parser;

import com.pro100svitlo.creditCardNfcReader.a.d;
import com.pro100svitlo.creditCardNfcReader.a.e;
import com.pro100svitlo.creditCardNfcReader.a.f;
import com.pro100svitlo.creditCardNfcReader.enums.CommandEnum;
import com.pro100svitlo.creditCardNfcReader.enums.EmvCardScheme;
import com.pro100svitlo.creditCardNfcReader.enums.SwEnum;
import com.pro100svitlo.creditCardNfcReader.model.EmvCard;
import com.pro100svitlo.creditCardNfcReader.model.EmvTransactionRecord;
import com.pro100svitlo.creditCardNfcReader.model.enums.CurrencyEnum;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.b;
import org.slf4j.c;

/* compiled from: EmvParser */
public class a {
    private static final b egK = c.aa(a.class);
    private static final byte[] egL = "2PAY.SYS.DDF01".getBytes();
    private static final byte[] egM = "1PAY.SYS.DDF01".getBytes();
    private b egN;
    private boolean egO;
    private EmvCard egP = new EmvCard();

    public a(b bVar, boolean z) {
        this.egN = bVar;
        this.egO = z;
    }

    public EmvCard aRU() {
        if (!aRX()) {
            aRY();
        }
        return this.egP;
    }

    protected byte[] aRV() {
        if (egK.isDebugEnabled()) {
            b bVar = egK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Select ");
            stringBuilder.append(this.egO ? "PPSE" : "PSE");
            stringBuilder.append(" Application");
            bVar.debug(stringBuilder.toString());
        }
        return this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.SELECT, this.egO ? egL : egM, 0).aSl());
    }

    protected int aRW() {
        if (egK.isDebugEnabled()) {
            egK.debug("Get Left PIN try");
        }
        byte[] transceive = this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.GET_DATA, 159, 23, 0).aSl());
        if (d.U(transceive)) {
            transceive = e.b(transceive, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.edJ);
            if (transceive != null) {
                return b.a.a.b.X(transceive);
            }
        }
        return -1;
    }

    protected byte[] K(byte[] bArr) {
        byte[] b = e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.ecu);
        if (b != null) {
            int X = b.a.a.b.X(b);
            if (egK.isDebugEnabled()) {
                b bVar = egK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SFI found:");
                stringBuilder.append(X);
                bVar.debug(stringBuilder.toString());
            }
            int i = (X << 3) | 4;
            b = this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.READ_RECORD, X, i, 0).aSl());
            if (d.a(b, SwEnum.SW_6C)) {
                b = this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.READ_RECORD, X, i, b[b.length - 1]).aSl());
            }
            return b;
        }
        if (egK.isDebugEnabled()) {
            egK.debug("(FCI) Issuer Discretionary Data is already present");
        }
        return bArr;
    }

    protected String L(byte[] bArr) {
        if (egK.isDebugEnabled()) {
            egK.debug("Extract Application label");
        }
        bArr = e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.ecm);
        if (bArr != null) {
            return new String(bArr);
        }
        return null;
    }

    protected boolean aRX() {
        if (egK.isDebugEnabled()) {
            egK.debug("Try to read card with Payment System Environment");
        }
        byte[] aRV = aRV();
        boolean z = false;
        if (d.U(aRV)) {
            aRV = K(aRV);
            if (d.U(aRV)) {
                for (byte[] a : M(aRV)) {
                    z = a(a, L(aRV));
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    this.egP.gc(true);
                }
            }
        } else if (egK.isDebugEnabled()) {
            b bVar = egK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.egO ? "PPSE" : "PSE");
            stringBuilder.append(" not found -> Use kown AID");
            bVar.debug(stringBuilder.toString());
        }
        return z;
    }

    protected List<byte[]> M(byte[] bArr) {
        List<byte[]> arrayList = new ArrayList();
        for (com.pro100svitlo.creditCardNfcReader.iso7816emv.d dVar : e.a(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.ecl, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.eeJ)) {
            if (dVar.aRJ() != com.pro100svitlo.creditCardNfcReader.iso7816emv.b.eeJ || arrayList.size() == 0) {
                arrayList.add(dVar.aRK());
            } else {
                arrayList.add(org.apache.commons.lang3.a.b((byte[]) arrayList.get(arrayList.size() - 1), dVar.aRK()));
            }
        }
        return arrayList;
    }

    protected void aRY() {
        if (egK.isDebugEnabled()) {
            egK.debug("Try to read card with AID");
        }
        for (EmvCardScheme emvCardScheme : EmvCardScheme.values()) {
            byte[][] aidByte = emvCardScheme.getAidByte();
            int length = aidByte.length;
            int i = 0;
            while (i < length) {
                if (!a(aidByte[i], emvCardScheme.getName())) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    protected byte[] N(byte[] bArr) {
        if (egK.isDebugEnabled()) {
            b bVar = egK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Select AID: ");
            stringBuilder.append(b.a.a.b.T(bArr));
            bVar.debug(stringBuilder.toString());
        }
        return this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.SELECT, bArr, 0).aSl());
    }

    protected boolean a(byte[] bArr, String str) {
        bArr = N(bArr);
        if (!d.U(bArr)) {
            return false;
        }
        boolean a = a(bArr, this.egN);
        if (!a) {
            return a;
        }
        String Y = b.a.a.b.Y(e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.ect));
        if (egK.isDebugEnabled()) {
            b bVar = egK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Application label:");
            stringBuilder.append(str);
            stringBuilder.append(" with Aid:");
            stringBuilder.append(Y);
            bVar.debug(stringBuilder.toString());
        }
        this.egP.ld(Y);
        this.egP.a(aQ(Y, this.egP.Vg()));
        this.egP.li(str);
        this.egP.io(aRW());
        return a;
    }

    protected EmvCardScheme aQ(String str, String str2) {
        EmvCardScheme cardTypeByAid = EmvCardScheme.getCardTypeByAid(str);
        if (cardTypeByAid == EmvCardScheme.CB) {
            cardTypeByAid = EmvCardScheme.getCardTypeByCardNumber(str2);
            if (cardTypeByAid != null) {
                b bVar = egK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Real type:");
                stringBuilder.append(cardTypeByAid.getName());
                bVar.debug(stringBuilder.toString());
            }
        }
        return cardTypeByAid;
    }

    protected byte[] O(byte[] bArr) {
        return e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.eez, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.eeD);
    }

    protected boolean a(byte[] bArr, b bVar) {
        byte[] O = O(bArr);
        boolean z = true;
        bArr = b(e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.eeg), bVar);
        if (!d.U(bArr)) {
            bArr = b(null, bVar);
            if (!d.U(bArr)) {
                return false;
            }
        }
        if (P(bArr)) {
            this.egP.bK(Q(O));
        } else {
            z = false;
        }
        return z;
    }

    protected boolean P(byte[] bArr) {
        boolean z;
        byte[] b = e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.ecD);
        if (b != null) {
            b = org.apache.commons.lang3.a.r(b, 2, b.length);
            z = false;
        } else {
            z = f.a(this.egP, bArr);
            if (z) {
                S(bArr);
            } else {
                b = e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.ecT);
            }
        }
        if (b != null) {
            for (com.pro100svitlo.creditCardNfcReader.model.a aVar : R(b)) {
                for (int aRO = aVar.aRO(); aRO <= aVar.aRP(); aRO++) {
                    byte[] transceive = this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.READ_RECORD, aRO, (aVar.aRN() << 3) | 4, 0).aSl());
                    if (d.a(transceive, SwEnum.SW_6C)) {
                        transceive = this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.READ_RECORD, aRO, (aVar.aRN() << 3) | 4, transceive[transceive.length - 1]).aSl());
                    }
                    if (d.U(transceive)) {
                        S(transceive);
                        if (f.a(this.egP, transceive)) {
                            return true;
                        }
                    }
                }
            }
        }
        return z;
    }

    protected List<com.pro100svitlo.creditCardNfcReader.iso7816emv.e> aRZ() {
        List<com.pro100svitlo.creditCardNfcReader.iso7816emv.e> arrayList = new ArrayList();
        if (egK.isDebugEnabled()) {
            egK.debug("GET log format");
        }
        byte[] transceive = this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.GET_DATA, 159, 79, 0).aSl());
        if (!d.U(transceive)) {
            return arrayList;
        }
        return e.W(e.b(transceive, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.eeB));
    }

    protected List<EmvTransactionRecord> Q(byte[] bArr) {
        List<EmvTransactionRecord> arrayList = new ArrayList();
        if (bArr != null) {
            List aRZ = aRZ();
            for (byte b = (byte) 1; b <= bArr[1]; b++) {
                byte[] transceive = this.egN.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.READ_RECORD, b, (bArr[0] << 3) | 4, 0).aSl());
                if (!d.U(transceive)) {
                    break;
                }
                EmvTransactionRecord emvTransactionRecord = new EmvTransactionRecord();
                emvTransactionRecord.a(transceive, aRZ);
                if (emvTransactionRecord.aRS().floatValue() >= 1.5E9f) {
                    emvTransactionRecord.a(Float.valueOf(emvTransactionRecord.aRS().floatValue() - 1.5E9f));
                }
                if (!(emvTransactionRecord.aRS() == null || emvTransactionRecord.aRS().floatValue() == 0.0f || emvTransactionRecord == null)) {
                    if (emvTransactionRecord.aRT() == null) {
                        emvTransactionRecord.a(CurrencyEnum.XXX);
                    }
                    arrayList.add(emvTransactionRecord);
                }
            }
        }
        return arrayList;
    }

    protected List<com.pro100svitlo.creditCardNfcReader.model.a> R(byte[] bArr) {
        List<com.pro100svitlo.creditCardNfcReader.model.a> arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (byteArrayInputStream.available() >= 4) {
            com.pro100svitlo.creditCardNfcReader.model.a aVar = new com.pro100svitlo.creditCardNfcReader.model.a();
            aVar.il(byteArrayInputStream.read() >> 3);
            aVar.im(byteArrayInputStream.read());
            aVar.in(byteArrayInputStream.read());
            boolean z = true;
            if (byteArrayInputStream.read() != 1) {
                z = false;
            }
            aVar.gb(z);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    protected void S(byte[] bArr) {
        bArr = e.b(bArr, com.pro100svitlo.creditCardNfcReader.iso7816emv.b.edc);
        if (bArr != null) {
            String[] split = org.apache.commons.lang3.c.split(new String(bArr).trim(), "/");
            if (split != null && split.length == 2) {
                this.egP.lf(org.apache.commons.lang3.c.nh(split[0]));
                this.egP.le(org.apache.commons.lang3.c.nh(split[1]));
            }
        }
    }

    protected byte[] b(byte[] bArr, b bVar) {
        List<com.pro100svitlo.creditCardNfcReader.iso7816emv.e> W = e.W(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(com.pro100svitlo.creditCardNfcReader.iso7816emv.b.ecG.aRI());
            byteArrayOutputStream.write(e.bM(W));
            if (W != null) {
                for (com.pro100svitlo.creditCardNfcReader.iso7816emv.e a : W) {
                    byteArrayOutputStream.write(com.pro100svitlo.creditCardNfcReader.iso7816emv.c.a(a));
                }
            }
        } catch (Throwable e) {
            b bVar2 = egK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Construct GPO Command:");
            stringBuilder.append(e.getMessage());
            bVar2.error(stringBuilder.toString(), e);
        }
        return bVar.transceive(new com.pro100svitlo.creditCardNfcReader.a.b(CommandEnum.GPO, byteArrayOutputStream.toByteArray(), 0).aSl());
    }
}
