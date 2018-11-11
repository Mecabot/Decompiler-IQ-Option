package org.jmrtd.cbeff;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import net.sf.scuba.tlv.TLVOutputStream;

/* compiled from: ISO781611Encoder */
public class f<B extends BiometricDataBlock> {
    private b<B> fcc;

    public f(b<B> bVar) {
        this.fcc = bVar;
    }

    public void a(c cVar, OutputStream outputStream) {
        if (cVar instanceof g) {
            a(Arrays.asList(new c[]{cVar}), outputStream);
        } else if (cVar instanceof d) {
            a(((d) cVar).bAC(), outputStream);
        }
    }

    private void a(List<c> list, OutputStream outputStream) {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(32609);
        tLVOutputStream.writeTag(2);
        int size = list.size();
        byte[] bArr = new byte[1];
        int i = 0;
        bArr[0] = (byte) size;
        tLVOutputStream.writeValue(bArr);
        while (i < size) {
            a(tLVOutputStream, i, (g) list.get(i));
            i++;
        }
        tLVOutputStream.writeValueEnd();
    }

    private void a(TLVOutputStream tLVOutputStream, int i, g<B> gVar) {
        tLVOutputStream.writeTag(32608);
        b(tLVOutputStream, i, gVar);
        a(tLVOutputStream, gVar.bAD());
        tLVOutputStream.writeValueEnd();
    }

    private void b(TLVOutputStream tLVOutputStream, int i, g<B> gVar) {
        tLVOutputStream.writeTag(161);
        for (Entry entry : gVar.bAD().bAB().bAE().entrySet()) {
            tLVOutputStream.writeTag(((Integer) entry.getKey()).intValue());
            tLVOutputStream.writeValue((byte[]) entry.getValue());
        }
        tLVOutputStream.writeValueEnd();
    }

    private void a(TLVOutputStream tLVOutputStream, B b) {
        tLVOutputStream.writeTag(24366);
        this.fcc.a(b, tLVOutputStream);
        tLVOutputStream.writeValueEnd();
    }
}
