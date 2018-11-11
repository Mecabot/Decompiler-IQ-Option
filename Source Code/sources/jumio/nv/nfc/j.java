package jumio.nv.nfc;

import android.os.AsyncTask;
import com.jumio.core.mvp.model.PublisherWithUpdate;
import com.jumio.nv.nfc.core.communication.TagAccessSpec;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import net.sf.scuba.smartcards.CardServiceException;

/* compiled from: PassportAuthenticator */
public class j extends PublisherWithUpdate<o, o> implements Serializable {
    private final h a;
    private final String b;
    private final Date c;
    private final Date d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private g f;
    private String g;
    private boolean h;

    /* compiled from: PassportAuthenticator */
    public class a extends AsyncTask<Boolean, o, o> {
        private boolean b;
        private k c;

        /* JADX WARNING: Removed duplicated region for block: B:64:0x023c A:{Splitter: B:1:0x0009, ExcHandler: net.sf.scuba.smartcards.CardServiceException (r10_51 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x023c A:{Splitter: B:1:0x0009, ExcHandler: net.sf.scuba.smartcards.CardServiceException (r10_51 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x01d7 A:{Splitter: B:12:0x0073, ExcHandler: net.sf.scuba.smartcards.CardServiceException (r10_43 'e' net.sf.scuba.smartcards.CardServiceException)} */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x01ce A:{Splitter: B:37:0x017b, ExcHandler: net.sf.scuba.smartcards.CardServiceException (r10_39 'e' net.sf.scuba.smartcards.CardServiceException)} */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0201 A:{PHI: r10 , Splitter: B:10:0x005b, ExcHandler: net.sf.scuba.smartcards.CardServiceException (e net.sf.scuba.smartcards.CardServiceException)} */
        /* JADX WARNING: Missing block: B:50:0x01ce, code:
            r10 = move-exception;
     */
        /* JADX WARNING: Missing block: B:51:0x01cf, code:
            r8 = r0;
            r0 = r10;
            r10 = r8;
     */
        /* JADX WARNING: Missing block: B:54:0x01d7, code:
            r10 = move-exception;
     */
        /* JADX WARNING: Missing block: B:55:0x01d8, code:
            r0 = r10;
            r10 = r1;
     */
        /* JADX WARNING: Missing block: B:58:0x0201, code:
            r0 = e;
     */
        /* JADX WARNING: Missing block: B:59:0x0202, code:
            jumio.nv.nfc.f.a("PassportAuthenticator", "NFC-related exception occurred", r0);
            r10.a(jumio.nv.nfc.q.d, r0);
            jumio.nv.nfc.j.d(r9.a, r10);
     */
        /* JADX WARNING: Missing block: B:64:0x023c, code:
            r10 = move-exception;
     */
        /* JADX WARNING: Missing block: B:65:0x023d, code:
            jumio.nv.nfc.f.b("PassportAuthenticator", "error initializing PassportAuthenticator", r10);
            r0 = new jumio.nv.nfc.o(jumio.nv.nfc.p.a, jumio.nv.nfc.q.d, r10);
            jumio.nv.nfc.j.a(r9.a, r0);
     */
        /* JADX WARNING: Missing block: B:66:0x0252, code:
            return r0;
     */
        /* renamed from: a */
        protected jumio.nv.nfc.o doInBackground(java.lang.Boolean... r10) {
            /*
            r9 = this;
            r0 = 0;
            r10 = r10[r0];
            r10 = r10.booleanValue();
            r9.b = r10;
            r10 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10 = r10.b;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10 = com.jumio.commons.utils.StringUtil.nullOrEmpty(r10);	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r1 = 1;
            if (r10 != 0) goto L_0x0214;
        L_0x0016:
            r10 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10 = r10.c;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            if (r10 == 0) goto L_0x0214;
        L_0x001e:
            r10 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10 = r10.d;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            if (r10 != 0) goto L_0x0028;
        L_0x0026:
            goto L_0x0214;
        L_0x0028:
            r10 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10 = r10.f;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r2 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r2 = r2.b;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r3 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r3 = r3.c;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r4 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r4 = r4.d;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r5 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r5 = r5.g;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10 = r10.a(r2, r3, r4, r5);	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r9.c = r10;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10 = new jumio.nv.nfc.o;
            r10.<init>();
            r2 = jumio.nv.nfc.p.INIT;
            r10.a(r2);
            r2 = jumio.nv.nfc.q.NOT_AVAILABLE;
            r10.a(r2);
            r2 = r9.c;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r2 = r2.a();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r1 = new jumio.nv.nfc.o[r1];	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r1[r0] = r2;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r9.publishProgress(r1);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r1 = jumio.nv.nfc.p.BAC_CHECK;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10.a(r1);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r1 = r9.c;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r1 = r1.b();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10 = r1.e();	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            if (r10 == 0) goto L_0x007f;
        L_0x0079:
            r10 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10.e(r1);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            return r1;
        L_0x007f:
            r10 = new jumio.nv.nfc.o;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r2 = jumio.nv.nfc.p.BAC_CHECK;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r3 = r1.b();	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10.<init>(r2, r3);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r9.b(r10);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10 = jumio.nv.nfc.p.READ_LDS;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r1.a(r10);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10 = r9.c;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r2 = r9.b;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10 = r10.a(r2);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r2 = r1.e();	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            if (r2 == 0) goto L_0x00a6;
        L_0x00a0:
            r10 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10.e(r1);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            return r1;
        L_0x00a6:
            r2 = r1.f();	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            if (r2 != 0) goto L_0x00b5;
        L_0x00ac:
            r2 = r9.c;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r2 = r2.i();	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10.a(r2);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
        L_0x00b5:
            r9.b(r10);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10 = jumio.nv.nfc.p.PASSIVE_AUTH_DSC_CHECK;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r1.a(r10);	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10 = r9.c;	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r10 = r10.d();	 Catch:{ CardServiceException -> 0x01d7, CardServiceException -> 0x01d7, Exception -> 0x01d3 }
            r1 = new jumio.nv.nfc.o;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r1.<init>(r10);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r9.b(r1);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
            java.lang.Thread.sleep(r1);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = jumio.nv.nfc.p.PASSIVE_AUTH_ROOT_CERT_CHECK;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10.a(r3);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = "PassportAuthenticator";
            r4 = new java.lang.StringBuilder;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4.<init>();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r5 = "obtain CSCA for ";
            r4.append(r5);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r5 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r5 = r5.g;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r5 = r5.toUpperCase();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4.append(r5);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4 = r4.toString();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            jumio.nv.nfc.f.a(r3, r4);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = r9.c;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4 = r4.a;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = r3.a(r4);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4 = new jumio.nv.nfc.o;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4.<init>(r3);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r9.b(r4);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            java.lang.Thread.sleep(r1);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = jumio.nv.nfc.p.PASSIVE_AUTH_HASH_CHECK;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10.a(r3);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = r9.c;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = r3.c();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4 = jumio.nv.nfc.q.SUCCESSFUL;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10.a(r4);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4 = jumio.nv.nfc.p.PASSIVE_AUTH_HASH_CHECK;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10.a(r4);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4 = new java.util.TreeMap;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4.<init>();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r3 = r3.iterator();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r5 = 0;
        L_0x012b:
            r6 = r3.hasNext();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            if (r6 == 0) goto L_0x015b;
        L_0x0131:
            r5 = r3.next();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r5 = (jumio.nv.nfc.o) r5;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r6 = r5.g();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            if (r6 != 0) goto L_0x0149;
        L_0x013d:
            r6 = java.lang.Integer.valueOf(r0);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r7 = r5.b();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4.put(r6, r7);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            goto L_0x0156;
        L_0x0149:
            r6 = r5.g();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r6 = (java.lang.Integer) r6;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r7 = r5.b();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r4.put(r6, r7);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
        L_0x0156:
            r5 = r5.e();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            goto L_0x012b;
        L_0x015b:
            if (r5 == 0) goto L_0x0162;
        L_0x015d:
            r0 = jumio.nv.nfc.q.FAILED;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10.a(r0);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
        L_0x0162:
            r10.a(r4);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r0 = new jumio.nv.nfc.o;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r0.<init>(r10);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r9.b(r0);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            java.lang.Thread.sleep(r1);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r0 = jumio.nv.nfc.p.ACTIVE_AUTH_CHECK;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10.a(r0);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r0 = r9.c;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r0 = r0.e();	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r10 = r0.d();	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            if (r10 == 0) goto L_0x0186;
        L_0x0181:
            r10 = r9.c;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10.f();	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
        L_0x0186:
            r10 = new jumio.nv.nfc.o;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10.<init>(r0);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r9.b(r10);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            java.lang.Thread.sleep(r1);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10 = jumio.nv.nfc.p.ADDITIONAL_DATA;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r0.a(r10);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10 = r9.c;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10 = r10.h();	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r3 = new jumio.nv.nfc.o;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r3.<init>(r10);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r9.b(r3);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            java.lang.Thread.sleep(r1);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10 = jumio.nv.nfc.p.FACE_IMAGE;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r0.a(r10);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10 = r9.b;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            if (r10 == 0) goto L_0x01b7;
        L_0x01b0:
            r10 = r9.c;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10 = r10.g();	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            goto L_0x01c0;
        L_0x01b7:
            r10 = jumio.nv.nfc.q.NOT_AVAILABLE;	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r0.a(r10);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            java.lang.Thread.sleep(r1);	 Catch:{ CardServiceException -> 0x01ce, CardServiceException -> 0x01ce, Exception -> 0x01c9 }
            r10 = r0;
        L_0x01c0:
            r0 = new jumio.nv.nfc.o;	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r0.<init>(r10);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            r9.b(r0);	 Catch:{ CardServiceException -> 0x0201, CardServiceException -> 0x0201, Exception -> 0x01db }
            goto L_0x0213;
        L_0x01c9:
            r10 = move-exception;
            r8 = r0;
            r0 = r10;
            r10 = r8;
            goto L_0x01dc;
        L_0x01ce:
            r10 = move-exception;
            r8 = r0;
            r0 = r10;
            r10 = r8;
            goto L_0x0202;
        L_0x01d3:
            r10 = move-exception;
            r0 = r10;
            r10 = r1;
            goto L_0x01dc;
        L_0x01d7:
            r10 = move-exception;
            r0 = r10;
            r10 = r1;
            goto L_0x0202;
        L_0x01db:
            r0 = move-exception;
        L_0x01dc:
            r1 = "PassportAuthenticator";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "general exception occurred: ";
            r2.append(r3);
            r3 = r0.getClass();
            r2.append(r3);
            r2 = r2.toString();
            jumio.nv.nfc.f.a(r1, r2, r0);
            r1 = jumio.nv.nfc.q.ERROR;
            r10.a(r1, r0);
            r0 = jumio.nv.nfc.j.this;
            r0.e(r10);
            goto L_0x0213;
        L_0x0201:
            r0 = move-exception;
        L_0x0202:
            r1 = "PassportAuthenticator";
            r2 = "NFC-related exception occurred";
            jumio.nv.nfc.f.a(r1, r2, r0);
            r1 = jumio.nv.nfc.q.ERROR;
            r10.a(r1, r0);
            r0 = jumio.nv.nfc.j.this;
            r0.e(r10);
        L_0x0213:
            return r10;
        L_0x0214:
            r10 = new java.security.GeneralSecurityException;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r2 = "Invalid BAC credentials! No.=%s, dob=%s, doe=%s ";
            r3 = 3;
            r3 = new java.lang.Object[r3];	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r4 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r4 = r4.b;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r3[r0] = r4;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r0 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r0 = r0.c;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r3[r1] = r0;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r0 = 2;
            r1 = jumio.nv.nfc.j.this;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r1 = r1.d;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r3[r0] = r1;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r0 = java.lang.String.format(r2, r3);	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            r10.<init>(r0);	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
            throw r10;	 Catch:{ CardServiceException -> 0x023c, CardServiceException -> 0x023c, CardServiceException -> 0x023c }
        L_0x023c:
            r10 = move-exception;
            r0 = "PassportAuthenticator";
            r1 = "error initializing PassportAuthenticator";
            jumio.nv.nfc.f.b(r0, r1, r10);
            r0 = new jumio.nv.nfc.o;
            r1 = jumio.nv.nfc.p.INIT;
            r2 = jumio.nv.nfc.q.ERROR;
            r0.<init>(r1, r2, r10);
            r10 = jumio.nv.nfc.j.this;
            r10.e(r0);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.j.a.a(java.lang.Boolean[]):jumio.nv.nfc.o");
        }

        /* renamed from: a */
        protected void onProgressUpdate(o... oVarArr) {
            super.onProgressUpdate(oVarArr);
            j.this.a(oVarArr[0]);
        }

        /* renamed from: a */
        protected void onPostExecute(o oVar) {
            super.onPostExecute(oVar);
            j.this.e.set(false);
            j.this.access$400(oVar);
        }

        private void b(o oVar) {
            publishProgress(new o[]{oVar});
            if (oVar.f()) {
                throw new CardServiceException(oVar.toString());
            }
        }
    }

    public j(h hVar, g gVar, TagAccessSpec tagAccessSpec) {
        this.a = hVar;
        this.f = gVar;
        this.b = tagAccessSpec.getIdNumber();
        this.c = tagAccessSpec.getDateOfBirth();
        this.d = tagAccessSpec.getDateOfExpiry();
        this.g = tagAccessSpec.getCountryIso3();
        this.h = tagAccessSpec.shouldDownloadFaceImage();
    }

    public boolean a() {
        return this.e.get();
    }

    public void b() {
        if (this.e.compareAndSet(false, true)) {
            new a().execute(new Boolean[]{Boolean.valueOf(this.h)});
        }
    }
}
