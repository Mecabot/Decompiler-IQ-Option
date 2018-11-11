package jumio.nv.nfc;

import com.jumio.commons.log.Log;
import com.jumio.core.network.DownloadTask;
import com.jumio.core.network.DownloadTask.ProgressListener;
import com.jumio.nv.models.ServerSettingsModel;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jmrtd.d;

/* compiled from: CertificateDatabase */
public class h implements ProgressListener {
    private static Map<String, X509Certificate> a;
    private static final Object c = new Object();
    private CertificateFactory b;
    private ServerSettingsModel d;

    /* compiled from: CertificateDatabase */
    class a extends DownloadTask {
        public a(String str, byte[] bArr) {
            super(str, bArr);
        }

        protected byte[] doInBackground(Void... voidArr) {
            synchronized (h.c) {
                if (h.a != null) {
                    Log.d("CertificateDatabase", "no need to download - skip");
                    return null;
                }
                h.a = new HashMap();
                byte[] doInBackground = super.doInBackground(voidArr);
                return doInBackground;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab A:{SYNTHETIC, Splitter: B:51:0x00ab} */
        /* JADX WARNING: Missing block: B:32:0x005f, code:
            r1 = new java.lang.StringBuilder();
            r1.append("downloaded ");
            r1.append(jumio.nv.nfc.h.b().size());
            r1.append(" certificates");
            com.jumio.commons.log.Log.d("CertificateDatabase", r1.toString());
     */
        /* JADX WARNING: Missing block: B:33:0x0082, code:
            if (r0 == null) goto L_0x00a7;
     */
        /* JADX WARNING: Missing block: B:35:?, code:
            r0.close();
     */
        /* JADX WARNING: Missing block: B:46:0x009f, code:
            r6 = move-exception;
     */
        /* JADX WARNING: Missing block: B:47:0x00a0, code:
            com.jumio.commons.log.Log.e("CertificateDatabase", "", r6);
     */
        protected byte[] processInputStream(java.io.InputStream r6, int r7) {
            /*
            r5 = this;
            r7 = 0;
            r0 = new java.util.zip.ZipInputStream;	 Catch:{ CertificateException -> 0x008d, all -> 0x008a }
            r0.<init>(r6);	 Catch:{ CertificateException -> 0x008d, all -> 0x008a }
        L_0x0006:
            r6 = r0.getNextEntry();	 Catch:{ CertificateException -> 0x0088 }
            if (r6 == 0) goto L_0x005f;
        L_0x000c:
            r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0051 }
            r1.<init>();	 Catch:{ all -> 0x0051 }
            r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r2 = new byte[r2];	 Catch:{ all -> 0x004e }
        L_0x0015:
            r3 = r0.read(r2);	 Catch:{ all -> 0x004e }
            r4 = -1;
            if (r3 == r4) goto L_0x0021;
        L_0x001c:
            r4 = 0;
            r1.write(r2, r4, r3);	 Catch:{ all -> 0x004e }
            goto L_0x0015;
        L_0x0021:
            r2 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x004e }
            r3 = r1.toByteArray();	 Catch:{ all -> 0x004e }
            r2.<init>(r3);	 Catch:{ all -> 0x004e }
            r3 = jumio.nv.nfc.h.this;	 Catch:{ all -> 0x004c }
            r3 = r3.b;	 Catch:{ all -> 0x004c }
            r3 = r3.generateCertificate(r2);	 Catch:{ all -> 0x004c }
            r3 = (java.security.cert.X509Certificate) r3;	 Catch:{ all -> 0x004c }
            r4 = jumio.nv.nfc.h.a;	 Catch:{ all -> 0x004c }
            r6 = r6.getName();	 Catch:{ all -> 0x004c }
            r4.put(r6, r3);	 Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0046;
        L_0x0043:
            r2.close();	 Catch:{ CertificateException -> 0x0088 }
        L_0x0046:
            if (r1 == 0) goto L_0x0006;
        L_0x0048:
            r1.close();	 Catch:{ CertificateException -> 0x0088 }
            goto L_0x0006;
        L_0x004c:
            r6 = move-exception;
            goto L_0x0054;
        L_0x004e:
            r6 = move-exception;
            r2 = r7;
            goto L_0x0054;
        L_0x0051:
            r6 = move-exception;
            r1 = r7;
            r2 = r1;
        L_0x0054:
            if (r2 == 0) goto L_0x0059;
        L_0x0056:
            r2.close();	 Catch:{ CertificateException -> 0x0088 }
        L_0x0059:
            if (r1 == 0) goto L_0x005e;
        L_0x005b:
            r1.close();	 Catch:{ CertificateException -> 0x0088 }
        L_0x005e:
            throw r6;	 Catch:{ CertificateException -> 0x0088 }
        L_0x005f:
            r6 = "CertificateDatabase";
            r1 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x0088 }
            r1.<init>();	 Catch:{ CertificateException -> 0x0088 }
            r2 = "downloaded ";
            r1.append(r2);	 Catch:{ CertificateException -> 0x0088 }
            r2 = jumio.nv.nfc.h.a;	 Catch:{ CertificateException -> 0x0088 }
            r2 = r2.size();	 Catch:{ CertificateException -> 0x0088 }
            r1.append(r2);	 Catch:{ CertificateException -> 0x0088 }
            r2 = " certificates";
            r1.append(r2);	 Catch:{ CertificateException -> 0x0088 }
            r1 = r1.toString();	 Catch:{ CertificateException -> 0x0088 }
            com.jumio.commons.log.Log.d(r6, r1);	 Catch:{ CertificateException -> 0x0088 }
            if (r0 == 0) goto L_0x00a7;
        L_0x0084:
            r0.close();	 Catch:{ IOException -> 0x009f }
            goto L_0x00a7;
        L_0x0088:
            r6 = move-exception;
            goto L_0x008f;
        L_0x008a:
            r6 = move-exception;
            r0 = r7;
            goto L_0x00a9;
        L_0x008d:
            r6 = move-exception;
            r0 = r7;
        L_0x008f:
            jumio.nv.nfc.h.a = r7;	 Catch:{ all -> 0x00a8 }
            r1 = "CertificateDatabase";
            r2 = "error reading certificate files";
            com.jumio.commons.log.Log.e(r1, r2, r6);	 Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00a7;
        L_0x009b:
            r0.close();	 Catch:{ IOException -> 0x009f }
            goto L_0x00a7;
        L_0x009f:
            r6 = move-exception;
            r0 = "CertificateDatabase";
            r1 = "";
            com.jumio.commons.log.Log.e(r0, r1, r6);
        L_0x00a7:
            return r7;
        L_0x00a8:
            r6 = move-exception;
        L_0x00a9:
            if (r0 == 0) goto L_0x00b7;
        L_0x00ab:
            r0.close();	 Catch:{ IOException -> 0x00af }
            goto L_0x00b7;
        L_0x00af:
            r7 = move-exception;
            r0 = "CertificateDatabase";
            r1 = "";
            com.jumio.commons.log.Log.e(r0, r1, r7);
        L_0x00b7:
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.h.a.processInputStream(java.io.InputStream, int):byte[]");
        }
    }

    public void onProgressDone(byte[] bArr) {
    }

    public void onProgressException(Exception exception) {
    }

    public void onProgressUpdate(float f) {
    }

    public h(boolean z, ServerSettingsModel serverSettingsModel) {
        this.d = serverSettingsModel;
        try {
            this.b = CertificateFactory.getInstance("X.509", d.bAA());
        } catch (Exception unused) {
            this.b = CertificateFactory.getInstance("X.509");
        }
        Log.d("CertificateDatabase", "ctor() -> downloadIfNecessary");
        if (z) {
            synchronized (c) {
                a = null;
            }
        }
        a(true);
    }

    public h(ServerSettingsModel serverSettingsModel) {
        this(false, serverSettingsModel);
    }

    public boolean a(String str) {
        Log.d("CertificateDatabase", "contains() -> downloadIfNecessary");
        a(false);
        List b = b(str);
        if (b == null || b.isEmpty()) {
            return false;
        }
        return true;
    }

    public List<X509Certificate> b(String str) {
        Log.d("CertificateDatabase", "get() -> downloadIfNecessary");
        a(false);
        return c(str);
    }

    private List<X509Certificate> c(String str) {
        str = str.toLowerCase();
        List<X509Certificate> arrayList = new ArrayList();
        if (a != null) {
            for (Entry entry : a.entrySet()) {
                String str2 = (String) entry.getKey();
                X509Certificate x509Certificate = (X509Certificate) entry.getValue();
                if (str2.toLowerCase().startsWith(str) && str2.toLowerCase().endsWith(".cer")) {
                    arrayList.add(x509Certificate);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062 A:{Splitter: B:11:0x0058, ExcHandler: java.lang.InterruptedException (r6_5 'e' java.lang.Exception)} */
    /* JADX WARNING: Missing block: B:13:0x0062, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:14:0x0063, code:
            r6.printStackTrace();
     */
    private void a(boolean r6) {
        /*
        r5 = this;
        r0 = "CertificateDatabase";
        r1 = "    starting downloadIfNecessary";
        com.jumio.commons.log.Log.d(r0, r1);
        r0 = a;
        if (r0 == 0) goto L_0x0013;
    L_0x000b:
        r6 = "CertificateDatabase";
        r0 = "    don't download, already there";
        com.jumio.commons.log.Log.d(r6, r0);
        return;
    L_0x0013:
        r0 = r5.d;
        if (r0 == 0) goto L_0x0067;
    L_0x0017:
        r0 = r5.d;
        r0 = r0.isCdnUsable();
        if (r0 != 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0067;
    L_0x0020:
        r0 = new jumio.nv.nfc.h$a;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.jumio.nv.environment.NVEnvironment.CDN_URL;
        r1.append(r2);
        r2 = 36;
        r2 = new byte[r2];
        r2 = {45, -7, 10, 60, 37, -100, -26, -3, 27, -41, -112, 38, -16, -62, 92, 110, 4, 43, -100, -58, 2, 47, -99, -23, 123, -18, -75, 54, -107, 125, 88, 86, -119, -110, 57, 47};
        r3 = -8317973204404190915; // 0x8c909f70ec45413d float:-9.5386586E26 double:-3.714738103556525E-248;
        r2 = com.jumio.commons.obfuscate.StringObfuscater.format(r2, r3);
        r1.append(r2);
        r1 = r1.toString();
        r2 = r5.d;
        r2 = r2.getCdnPublicKey();
        r0.<init>(r1, r2);
        r0.setListener(r5);
        r1 = 0;
        if (r6 == 0) goto L_0x0058;
    L_0x0052:
        r6 = new java.lang.Void[r1];
        r0.execute(r6);
        goto L_0x0066;
    L_0x0058:
        r6 = new java.lang.Void[r1];	 Catch:{ InterruptedException -> 0x0062, InterruptedException -> 0x0062 }
        r6 = r0.execute(r6);	 Catch:{ InterruptedException -> 0x0062, InterruptedException -> 0x0062 }
        r6.get();	 Catch:{ InterruptedException -> 0x0062, InterruptedException -> 0x0062 }
        goto L_0x0066;
    L_0x0062:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0066:
        return;
    L_0x0067:
        r6 = "CertificateDatabase";
        r0 = "    don't download,cdn not usable";
        com.jumio.commons.log.Log.d(r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.h.a(boolean):void");
    }
}
