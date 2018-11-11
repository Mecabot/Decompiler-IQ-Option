package org.jmrtd.lds.icao;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jmrtd.lds.ActiveAuthenticationInfo;
import org.jmrtd.lds.DataGroup;
import org.jmrtd.lds.SecurityInfo;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DLSet;

public class DG14File extends DataGroup {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -3536507558193769953L;
    private Set<SecurityInfo> securityInfos;

    public DG14File(InputStream inputStream) {
        super(110, inputStream);
    }

    protected void r(InputStream inputStream) {
        this.securityInfos = new HashSet();
        ASN1Set aSN1Set = (ASN1Set) new ASN1InputStream(inputStream).readObject();
        for (int i = 0; i < aSN1Set.size(); i++) {
            try {
                SecurityInfo a = SecurityInfo.a(aSN1Set.getObjectAt(i).toASN1Primitive());
                if (a == null) {
                    LOGGER.warning("Skipping this unsupported SecurityInfo");
                } else {
                    this.securityInfos.add(a);
                }
            } catch (Throwable e) {
                LOGGER.log(Level.WARNING, "Skipping Security Info", e);
            }
        }
    }

    protected void g(OutputStream outputStream) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (SecurityInfo bAK : this.securityInfos) {
            aSN1EncodableVector.add(bAK.bAK());
        }
        outputStream.write(new DLSet(aSN1EncodableVector).getEncoded("DER"));
    }

    @Deprecated
    public List<ActiveAuthenticationInfo> bBv() {
        List<ActiveAuthenticationInfo> arrayList = new ArrayList();
        for (SecurityInfo securityInfo : this.securityInfos) {
            if (securityInfo instanceof ActiveAuthenticationInfo) {
                arrayList.add((ActiveAuthenticationInfo) securityInfo);
            }
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DG14File [");
        stringBuilder.append(this.securityInfos.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DG14File dG14File = (DG14File) obj;
        if (this.securityInfos == null) {
            if (dG14File.securityInfos == null) {
                z = true;
            }
            return z;
        } else if (dG14File.securityInfos != null) {
            return this.securityInfos.equals(dG14File.securityInfos);
        } else {
            if (this.securityInfos == null) {
                z = true;
            }
            return z;
        }
    }

    public int hashCode() {
        return (this.securityInfos.hashCode() * 5) + 41;
    }
}
