package jumio.nv.nfc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.jmrtd.lds.CVCAFile;
import org.jmrtd.lds.CardAccessFile;
import org.jmrtd.lds.DataGroup;
import org.jmrtd.lds.LDSFile;
import org.jmrtd.lds.SODFile;
import org.jmrtd.lds.a;
import org.jmrtd.lds.icao.COMFile;
import org.jmrtd.lds.icao.DG11File;
import org.jmrtd.lds.icao.DG12File;
import org.jmrtd.lds.icao.DG14File;
import org.jmrtd.lds.icao.DG15File;
import org.jmrtd.lds.icao.DG1File;
import org.jmrtd.lds.icao.DG2File;

/* compiled from: LDSCompat */
public class c {
    private static final Logger a = Logger.getLogger("org.jmrtd");
    private Map<Short, LDSFile> b = new TreeMap();
    private Map<Short, org.jmrtd.io.c> c = new TreeMap();

    public int a(short s) {
        org.jmrtd.io.c cVar = (org.jmrtd.io.c) this.c.get(Short.valueOf(s));
        if (cVar == null) {
            return 0;
        }
        return cVar.getLength();
    }

    public void a(short s, InputStream inputStream, int i) {
        this.c.put(Short.valueOf(s), new org.jmrtd.io.c(inputStream, i));
    }

    public void a(LDSFile lDSFile) {
        if (lDSFile != null) {
            if (lDSFile instanceof COMFile) {
                a((short) 286, lDSFile);
            } else if (lDSFile instanceof SODFile) {
                a((short) 285, lDSFile);
            } else if (lDSFile instanceof CVCAFile) {
                CVCAFile cVCAFile = (CVCAFile) lDSFile;
                a(cVCAFile.bAO(), cVCAFile);
            } else if (lDSFile instanceof CardAccessFile) {
                a((short) 284, lDSFile);
            } else if (lDSFile instanceof DataGroup) {
                DataGroup dataGroup = (DataGroup) lDSFile;
                a(a.ms(dataGroup.getTag()), dataGroup);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported LDS file ");
                stringBuilder.append(lDSFile.getClass().getCanonicalName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public LDSFile b(short s) {
        LDSFile lDSFile = (LDSFile) this.b.get(Short.valueOf(s));
        if (lDSFile != null) {
            return lDSFile;
        }
        lDSFile = a.a(s, c(s));
        this.b.put(Short.valueOf(s), lDSFile);
        return lDSFile;
    }

    public InputStream c(short s) {
        org.jmrtd.io.c cVar = (org.jmrtd.io.c) this.c.get(Short.valueOf(s));
        if (cVar != null) {
            return cVar.hI(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No stream for ");
        stringBuilder.append(Integer.toHexString(s));
        throw new IOException(stringBuilder.toString());
    }

    public COMFile a() {
        return (COMFile) b((short) 286);
    }

    public SODFile b() {
        return (SODFile) b((short) 285);
    }

    public DG1File c() {
        return (DG1File) b((short) 257);
    }

    public DG2File d() {
        return (DG2File) b((short) 258);
    }

    public DG11File e() {
        return (DG11File) b((short) 267);
    }

    public DG12File f() {
        return (DG12File) b((short) 268);
    }

    public DG14File g() {
        return (DG14File) b((short) 270);
    }

    public DG15File h() {
        return (DG15File) b((short) 271);
    }

    private void a(short s, LDSFile lDSFile) {
        this.b.put(Short.valueOf(s), lDSFile);
        byte[] encoded = lDSFile.getEncoded();
        this.c.put(Short.valueOf(s), new org.jmrtd.io.c(new ByteArrayInputStream(encoded), encoded.length));
    }
}
