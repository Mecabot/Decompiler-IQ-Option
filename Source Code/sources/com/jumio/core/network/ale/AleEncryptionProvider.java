package com.jumio.core.network.ale;

import android.support.annotation.Nullable;
import com.jumio.alejwt.swig.ALECore;
import com.jumio.alejwt.swig.ALEHeader;
import com.jumio.alejwt.swig.ALEOutputStream;
import com.jumio.alejwt.swig.ALERequest;
import com.jumio.commons.log.Log;
import com.jumio.core.network.EncryptionProvider;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import javax.net.ssl.SSLException;

public class AleEncryptionProvider implements EncryptionProvider {
    static final String TAG = "AleEncryptionProvider";
    private ALERequest aleRequest;
    private ALECore mAleCore;
    private final String mCredentials;

    public AleEncryptionProvider(ALECore aLECore, String str) {
        this.mCredentials = str;
        this.mAleCore = aLECore;
    }

    public OutputStream createRequest(OutputStream outputStream, int i, @Nullable String str) {
        try {
            this.aleRequest = this.mAleCore.createRequest();
            Log.d(TAG, "encrypting plaintext");
            ALEHeader aLEHeader = new ALEHeader();
            if (str != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("multipart/form-data; boundary=");
                stringBuilder.append(str);
                aLEHeader.add("Content-Type", stringBuilder.toString());
            } else {
                aLEHeader.add("Content-Type", "application/json");
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Basic ");
            stringBuilder2.append(this.mCredentials);
            aLEHeader.add("Authorization", stringBuilder2.toString());
            return new ALEOutputStream(new BufferedOutputStream(outputStream), this.aleRequest, aLEHeader, i);
        } catch (Exception e) {
            throw new SSLException(e.getMessage());
        }
    }

    /*  JADX ERROR: NullPointerException in pass: ProcessVariables
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:278)
        	at jadx.core.dex.visitors.regions.ProcessVariables.access$000(ProcessVariables.java:31)
        	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processInsn(ProcessVariables.java:163)
        	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processBlockTraced(ProcessVariables.java:129)
        	at jadx.core.dex.visitors.regions.TracedRegionVisitor.processBlock(TracedRegionVisitor.java:23)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:53)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1080)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
        	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:183)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c5 A:{Catch:{ all -> 0x00df }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0091 A:{Catch:{ all -> 0x00df }} */
    public java.lang.String getResponse(java.io.InputStream r6) {
        /*
        r5 = this;
        r0 = "AleEncryptionProvider";
        r1 = "decrypting response stream";
        com.jumio.commons.log.Log.d(r0, r1);
        r0 = new com.jumio.alejwt.swig.ALEInputStream;
        r1 = new java.io.BufferedInputStream;
        r1.<init>(r6);
        r6 = r5.aleRequest;
        r0.<init>(r1, r6);
        r6 = 0;
        r1 = r5.readPlainInput(r0);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r2 = "Network/ALE";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3.<init>();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = "Response ";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3.append(r4);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = r5.aleRequest;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = r4.isVerified();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        if (r4 == 0) goto L_0x0030;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
    L_0x002c:
        r4 = "valid";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        goto L_0x0032;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
    L_0x0030:
        r4 = "invalid";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
    L_0x0032:
        r3.append(r4);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        com.jumio.commons.log.Log.v(r2, r3);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r2 = "Network/ALE";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3.<init>();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = "Errorcode ";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3.append(r4);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = r5.aleRequest;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = r4.getErrorCode();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3.append(r4);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        com.jumio.commons.log.Log.v(r2, r3);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r2 = "Network/ALE";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3.<init>();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = "KeyUpdate ";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3.append(r4);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = r5.aleRequest;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r4 = r4.isKeyUpdate();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        if (r4 == 0) goto L_0x0070;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
    L_0x006c:
        r4 = "true";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        goto L_0x0072;	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
    L_0x0070:
        r4 = "false";	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
    L_0x0072:
        r3.append(r4);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        com.jumio.commons.log.Log.v(r2, r3);	 Catch:{ IOException -> 0x0085, all -> 0x0080 }
        com.jumio.commons.utils.IOUtils.closeQuietly(r0);
        goto L_0x0089;
    L_0x0080:
        r6 = move-exception;
        com.jumio.commons.utils.IOUtils.closeQuietly(r0);
        throw r6;
    L_0x0085:
        com.jumio.commons.utils.IOUtils.closeQuietly(r0);
        r1 = r6;
    L_0x0089:
        r0 = r5.aleRequest;	 Catch:{ all -> 0x00df }
        r0 = r0.isVerified();	 Catch:{ all -> 0x00df }
        if (r0 != 0) goto L_0x00c5;	 Catch:{ all -> 0x00df }
    L_0x0091:
        r0 = r5.aleRequest;	 Catch:{ all -> 0x00df }
        r0 = r0.getErrorCode();	 Catch:{ all -> 0x00df }
        if (r0 == 0) goto L_0x00bc;	 Catch:{ all -> 0x00df }
    L_0x0099:
        r0 = new com.jumio.commons.remote.exception.UnexpectedResponseException;	 Catch:{ all -> 0x00df }
        r1 = r5.aleRequest;	 Catch:{ all -> 0x00df }
        r1 = r1.getErrorCode();	 Catch:{ all -> 0x00df }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00df }
        r2.<init>();	 Catch:{ all -> 0x00df }
        r3 = "Response returned ";	 Catch:{ all -> 0x00df }
        r2.append(r3);	 Catch:{ all -> 0x00df }
        r3 = r5.aleRequest;	 Catch:{ all -> 0x00df }
        r3 = r3.getErrorCode();	 Catch:{ all -> 0x00df }
        r2.append(r3);	 Catch:{ all -> 0x00df }
        r2 = r2.toString();	 Catch:{ all -> 0x00df }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x00df }
        throw r0;	 Catch:{ all -> 0x00df }
    L_0x00bc:
        r0 = new com.jumio.commons.remote.exception.UnexpectedResponseException;	 Catch:{ all -> 0x00df }
        r1 = 0;	 Catch:{ all -> 0x00df }
        r2 = "Response not verified";	 Catch:{ all -> 0x00df }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x00df }
        throw r0;	 Catch:{ all -> 0x00df }
    L_0x00c5:
        r0 = r5.aleRequest;	 Catch:{ all -> 0x00df }
        r0 = r0.isKeyUpdate();	 Catch:{ all -> 0x00df }
        if (r0 == 0) goto L_0x00d5;	 Catch:{ all -> 0x00df }
    L_0x00cd:
        r0 = new com.jumio.core.network.ale.AleKeyUpdateException;	 Catch:{ all -> 0x00df }
        r1 = "keyupdate - re-execute call!";	 Catch:{ all -> 0x00df }
        r0.<init>(r1);	 Catch:{ all -> 0x00df }
        throw r0;	 Catch:{ all -> 0x00df }
    L_0x00d5:
        r0 = r5.mAleCore;
        r2 = r5.aleRequest;
        r0.destroyRequest(r2);
        r5.aleRequest = r6;
        return r1;
    L_0x00df:
        r0 = move-exception;
        r1 = r5.mAleCore;
        r2 = r5.aleRequest;
        r1.destroyRequest(r2);
        r5.aleRequest = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.ale.AleEncryptionProvider.getResponse(java.io.InputStream):java.lang.String");
    }

    protected String readPlainInput(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        Object stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        try {
            Reader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            return stringWriter.toString();
        } finally {
            inputStream.close();
        }
    }
}
