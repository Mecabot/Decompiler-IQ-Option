package com.neovisionaries.ws.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: WebSocketFrame */
public class aj {
    private boolean ebp;
    private boolean ebq;
    private boolean ebr;
    private boolean ebs;
    private int ebt;
    private boolean ebu;
    private byte[] ebv;

    public boolean aRj() {
        return this.ebp;
    }

    public aj fS(boolean z) {
        this.ebp = z;
        return this;
    }

    public boolean aRk() {
        return this.ebq;
    }

    public aj fT(boolean z) {
        this.ebq = z;
        return this;
    }

    public boolean aRl() {
        return this.ebr;
    }

    public aj fU(boolean z) {
        this.ebr = z;
        return this;
    }

    public boolean aRm() {
        return this.ebs;
    }

    public aj fV(boolean z) {
        this.ebs = z;
        return this;
    }

    public int getOpcode() {
        return this.ebt;
    }

    public aj ik(int i) {
        this.ebt = i;
        return this;
    }

    public boolean aRn() {
        return this.ebt == 0;
    }

    public boolean aRo() {
        return this.ebt == 1;
    }

    public boolean aRp() {
        return this.ebt == 2;
    }

    public boolean aRq() {
        return this.ebt == 8;
    }

    public boolean aRr() {
        return this.ebt == 9;
    }

    public boolean aRs() {
        return this.ebt == 10;
    }

    public boolean aRt() {
        return 8 <= this.ebt && this.ebt <= 15;
    }

    boolean aRu() {
        return this.ebu;
    }

    aj fW(boolean z) {
        this.ebu = z;
        return this;
    }

    public int getPayloadLength() {
        if (this.ebv == null) {
            return 0;
        }
        return this.ebv.length;
    }

    public byte[] getPayload() {
        return this.ebv;
    }

    public String aRv() {
        if (this.ebv == null) {
            return null;
        }
        return p.v(this.ebv);
    }

    public aj C(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        this.ebv = bArr;
        return this;
    }

    public aj kX(String str) {
        if (str == null || str.length() == 0) {
            return C((byte[]) null);
        }
        return C(p.kK(str));
    }

    public aj k(int i, String str) {
        Object obj = new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
        if (str == null || str.length() == 0) {
            return C(obj);
        }
        Object kK = p.kK(str);
        Object obj2 = new byte[(kK.length + 2)];
        System.arraycopy(obj, 0, obj2, 0, 2);
        System.arraycopy(kK, 0, obj2, 2, kK.length);
        return C(obj2);
    }

    public int aRw() {
        return (this.ebv == null || this.ebv.length < 2) ? 1005 : ((this.ebv[0] & 255) << 8) | (this.ebv[1] & 255);
    }

    public String getCloseReason() {
        return (this.ebv == null || this.ebv.length < 3) ? null : p.h(this.ebv, 2, this.ebv.length - 2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebSocketFrame(FIN=");
        stringBuilder.append(this.ebp ? "1" : "0");
        stringBuilder.append(",RSV1=");
        stringBuilder.append(this.ebq ? "1" : "0");
        stringBuilder.append(",RSV2=");
        stringBuilder.append(this.ebr ? "1" : "0");
        stringBuilder.append(",RSV3=");
        stringBuilder.append(this.ebs ? "1" : "0");
        stringBuilder.append(",Opcode=");
        stringBuilder.append(p.ii(this.ebt));
        stringBuilder.append(",Length=");
        stringBuilder.append(getPayloadLength());
        int i = this.ebt;
        if (i != 8) {
            switch (i) {
                case 1:
                    p(stringBuilder);
                    break;
                case 2:
                    r(stringBuilder);
                    break;
            }
        }
        q(stringBuilder);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private boolean o(StringBuilder stringBuilder) {
        stringBuilder.append(",Payload=");
        if (this.ebv == null) {
            stringBuilder.append("null");
            return true;
        } else if (!this.ebq) {
            return false;
        } else {
            stringBuilder.append("compressed");
            return true;
        }
    }

    private void p(StringBuilder stringBuilder) {
        if (!o(stringBuilder)) {
            stringBuilder.append("\"");
            stringBuilder.append(aRv());
            stringBuilder.append("\"");
        }
    }

    private void q(StringBuilder stringBuilder) {
        stringBuilder.append(",CloseCode=");
        stringBuilder.append(aRw());
        stringBuilder.append(",Reason=");
        String closeReason = getCloseReason();
        if (closeReason == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append("\"");
        stringBuilder.append(closeReason);
        stringBuilder.append("\"");
    }

    private void r(StringBuilder stringBuilder) {
        if (!o(stringBuilder)) {
            for (int i = 0; i < this.ebv.length; i++) {
                stringBuilder.append(String.format("%02X ", new Object[]{Integer.valueOf(this.ebv[i] & 255)}));
            }
            if (this.ebv.length != 0) {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
        }
    }

    public static aj aRx() {
        return new aj().ik(0);
    }

    public static aj D(byte[] bArr) {
        return aRx().C(bArr);
    }

    public static aj kY(String str) {
        return new aj().fS(true).ik(1).kX(str);
    }

    public static aj aRy() {
        return new aj().fS(true).ik(8);
    }

    public static aj l(int i, String str) {
        return aRy().k(i, str);
    }

    public static aj aRz() {
        return new aj().fS(true).ik(9);
    }

    public static aj E(byte[] bArr) {
        return aRz().C(bArr);
    }

    public static aj aRA() {
        return new aj().fS(true).ik(10);
    }

    public static aj F(byte[] bArr) {
        return aRA().C(bArr);
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length < 4 || bArr2 == null) {
            return bArr2;
        }
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i % 4]);
        }
        return bArr2;
    }

    static aj a(aj ajVar, s sVar) {
        if (sVar == null) {
            return ajVar;
        }
        if ((!ajVar.aRo() && !ajVar.aRp()) || !ajVar.aRj() || ajVar.aRk()) {
            return ajVar;
        }
        byte[] payload = ajVar.getPayload();
        if (payload == null || payload.length == 0) {
            return ajVar;
        }
        byte[] a = a(payload, sVar);
        if (payload.length <= a.length) {
            return ajVar;
        }
        ajVar.C(a);
        ajVar.fT(true);
        return ajVar;
    }

    private static byte[] a(byte[] bArr, s sVar) {
        try {
            return sVar.t(bArr);
        } catch (WebSocketException unused) {
            return bArr;
        }
    }

    static List<aj> a(aj ajVar, int i, s sVar) {
        if (i == 0 || ajVar.getPayloadLength() <= i) {
            return null;
        }
        if (ajVar.aRp() || ajVar.aRo()) {
            ajVar = a(ajVar, sVar);
            if (ajVar.getPayloadLength() <= i) {
                return null;
            }
        } else if (!ajVar.aRn()) {
            return null;
        }
        return a(ajVar, i);
    }

    private static List<aj> a(aj ajVar, int i) {
        byte[] payload = ajVar.getPayload();
        boolean aRj = ajVar.aRj();
        List<aj> arrayList = new ArrayList();
        ajVar.fS(false).C(Arrays.copyOf(payload, i));
        arrayList.add(ajVar);
        int i2 = i;
        while (i2 < payload.length) {
            int i3 = i2 + i;
            arrayList.add(D(Arrays.copyOfRange(payload, i2, Math.min(i3, payload.length))));
            i2 = i3;
        }
        if (aRj) {
            ((aj) arrayList.get(arrayList.size() - 1)).fS(true);
        }
        return arrayList;
    }
}
