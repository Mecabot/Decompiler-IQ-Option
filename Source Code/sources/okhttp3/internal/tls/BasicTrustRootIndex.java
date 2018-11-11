package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts = new LinkedHashMap();

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = (Set) this.subjectToCaCerts.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.subjectToCaCerts.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for R(6:6|7|8|12|9|4) */
    /* JADX WARNING: Missing block: B:5:0x0018, code:
            if (r0.hasNext() != false) goto L_0x001a;
     */
    /* JADX WARNING: Missing block: B:6:0x001a, code:
            r2 = (java.security.cert.X509Certificate) r0.next();
     */
    /* JADX WARNING: Missing block: B:8:?, code:
            r5.verify(r2.getPublicKey());
     */
    /* JADX WARNING: Missing block: B:9:0x0027, code:
            return r2;
     */
    /* JADX WARNING: Missing block: B:10:0x0028, code:
            return null;
     */
    public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate r5) {
        /*
        r4 = this;
        r0 = r5.getIssuerX500Principal();
        r1 = r4.subjectToCaCerts;
        r0 = r1.get(r0);
        r0 = (java.util.Set) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r0.iterator();
    L_0x0014:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0028;
    L_0x001a:
        r2 = r0.next();
        r2 = (java.security.cert.X509Certificate) r2;
        r3 = r2.getPublicKey();
        r5.verify(r3);	 Catch:{ Exception -> 0x0014 }
        return r2;
    L_0x0028:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.BasicTrustRootIndex.findByIssuerAndSignature(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!((obj instanceof BasicTrustRootIndex) && ((BasicTrustRootIndex) obj).subjectToCaCerts.equals(this.subjectToCaCerts))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
