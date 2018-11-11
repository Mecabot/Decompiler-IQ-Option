package com.iqoption.deposit.card;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import io.reactivex.o;
import java.util.concurrent.Callable;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r¨\u0006\u0017"}, aXE = {"Lcom/iqoption/deposit/card/NfcCardScanner;", "", "()V", "parseCard", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "isoDep", "Landroid/nfc/tech/IsoDep;", "failCounter", "", "scanCardByNfc", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "intent", "Landroid/content/Intent;", "tryScan", "", "nfcTag", "Landroid/nfc/Tag;", "data", "Landroid/arch/lifecycle/MutableLiveData;", "validNfcIntent", "", "NfcCard", "deposit_release"})
/* compiled from: NfcCardScanner.kt */
public final class d {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, aXE = {"Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "", "cardNumber", "", "expireMonth", "expireYear", "cardHolderName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardHolderName", "()Ljava/lang/String;", "getCardNumber", "getExpireMonth", "getExpireYear", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "deposit_release"})
    /* compiled from: NfcCardScanner.kt */
    public static final class a {
        private final String bWf;
        private final String bWg;
        private final String bWh;
        private final String cardNumber;

        /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (kotlin.jvm.internal.h.E(r2.bWh, r3.bWh) != false) goto L_0x0033;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0033;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.deposit.card.d.a;
            if (r0 == 0) goto L_0x0031;
        L_0x0006:
            r3 = (com.iqoption.deposit.card.d.a) r3;
            r0 = r2.cardNumber;
            r1 = r3.cardNumber;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0031;
        L_0x0012:
            r0 = r2.bWf;
            r1 = r3.bWf;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0031;
        L_0x001c:
            r0 = r2.bWg;
            r1 = r3.bWg;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0031;
        L_0x0026:
            r0 = r2.bWh;
            r3 = r3.bWh;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x0031;
        L_0x0030:
            goto L_0x0033;
        L_0x0031:
            r3 = 0;
            return r3;
        L_0x0033:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.card.d.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.cardNumber;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.bWf;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            str2 = this.bWg;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            str2 = this.bWh;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NfcCard(cardNumber=");
            stringBuilder.append(this.cardNumber);
            stringBuilder.append(", expireMonth=");
            stringBuilder.append(this.bWf);
            stringBuilder.append(", expireYear=");
            stringBuilder.append(this.bWg);
            stringBuilder.append(", cardHolderName=");
            stringBuilder.append(this.bWh);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(String str, String str2, String str3, String str4) {
            h.e(str, "cardNumber");
            this.cardNumber = str;
            this.bWf = str2;
            this.bWg = str3;
            this.bWh = str4;
        }

        public final String Vg() {
            return this.cardNumber;
        }

        public final String abm() {
            return this.bWf;
        }

        public final String abn() {
            return this.bWg;
        }

        public final String abo() {
            return this.bWh;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "call"})
    /* compiled from: NfcCardScanner.kt */
    static final class c<V> implements Callable<T> {
        final /* synthetic */ d bWj;
        final /* synthetic */ IsoDep bWk;

        c(d dVar, IsoDep isoDep) {
            this.bWj = dVar;
            this.bWk = isoDep;
        }

        /* renamed from: abp */
        public final a call() {
            return d.a(this.bWj, this.bWk, 0, 2, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "kotlin.jvm.PlatformType", "pCommand", "transceive"})
    /* compiled from: NfcCardScanner.kt */
    static final class b implements com.pro100svitlo.creditCardNfcReader.parser.b {
        final /* synthetic */ IsoDep bWi;

        b(IsoDep isoDep) {
            this.bWi = isoDep;
        }

        public final byte[] transceive(byte[] bArr) {
            return this.bWi.transceive(bArr);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "result", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: NfcCardScanner.kt */
    static final class d<T> implements io.reactivex.c.e<a> {
        final /* synthetic */ MutableLiveData bWl;

        d(MutableLiveData mutableLiveData) {
            this.bWl = mutableLiveData;
        }

        /* renamed from: c */
        public final void accept(a aVar) {
            this.bWl.setValue(com.iqoption.core.ui.c.baY.bm(aVar));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: NfcCardScanner.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ MutableLiveData bWl;

        e(MutableLiveData mutableLiveData) {
            this.bWl = mutableLiveData;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.bWl.setValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, th, th != null ? th.getMessage() : null, null, 4, null));
        }
    }

    public final boolean s(Intent intent) {
        h.e(intent, "intent");
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        boolean z = false;
        if (tag == null) {
            return false;
        }
        Object techList = tag.getTechList();
        h.d(techList, "techs");
        boolean b = i.b((Object[]) techList, (Object) IsoDep.class.getName());
        boolean b2 = i.b((Object[]) techList, (Object) NfcA.class.getName());
        boolean b3 = i.b((Object[]) techList, (Object) NfcB.class.getName());
        if (b && (b2 || b3)) {
            z = true;
        }
        return z;
    }

    public final LiveData<com.iqoption.core.ui.c<a>> t(Intent intent) {
        h.e(intent, "intent");
        MutableLiveData mutableLiveData = new MutableLiveData();
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        if (tag == null) {
            mutableLiveData.setValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, null, null, null, 7, null));
        } else {
            a(tag, mutableLiveData);
        }
        return mutableLiveData;
    }

    private final void a(Tag tag, MutableLiveData<com.iqoption.core.ui.c<a>> mutableLiveData) {
        IsoDep isoDep = IsoDep.get(tag);
        if (isoDep == null) {
            mutableLiveData.setValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, null, null, null, 7, null));
            return;
        }
        mutableLiveData.setValue(com.iqoption.core.ui.c.a.b(com.iqoption.core.ui.c.baY, null, 1, null));
        o.h((Callable) new c(this, isoDep)).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new d(mutableLiveData), (io.reactivex.c.e) new e(mutableLiveData));
    }

    static /* bridge */ /* synthetic */ a a(d dVar, IsoDep isoDep, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return dVar.a(isoDep, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100 A:{Splitter: B:1:0x000a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:38:0x0100, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:39:0x0101, code:
            r6 = r19;
     */
    /* JADX WARNING: Missing block: B:41:0x0105, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:42:0x0106, code:
            r6 = r19;
     */
    /* JADX WARNING: Missing block: B:43:0x0108, code:
            r4 = r0;
     */
    /* JADX WARNING: Missing block: B:45:?, code:
            throw r4;
     */
    /* JADX WARNING: Missing block: B:46:0x010a, code:
            r0 = th;
     */
    private final com.iqoption.deposit.card.d.a a(android.nfc.tech.IsoDep r20, int r21) {
        /*
        r19 = this;
        r2 = r21;
        r1 = r20;
        r1 = (java.io.Closeable) r1;
        r3 = 0;
        r4 = r3;
        r4 = (java.lang.Throwable) r4;
        r5 = r1;
        r5 = (android.nfc.tech.IsoDep) r5;	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        r6 = 1;
        r5.connect();	 Catch:{ all -> 0x0100 }
        r7 = r5.getTimeout();	 Catch:{ all -> 0x0100 }
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r7 = java.lang.Math.max(r7, r8);	 Catch:{ all -> 0x0100 }
        r5.setTimeout(r7);	 Catch:{ all -> 0x0100 }
        r7 = new com.pro100svitlo.creditCardNfcReader.parser.a;	 Catch:{ all -> 0x0100 }
        r8 = new com.iqoption.deposit.card.d$b;	 Catch:{ all -> 0x0100 }
        r8.<init>(r5);	 Catch:{ all -> 0x0100 }
        r8 = (com.pro100svitlo.creditCardNfcReader.parser.b) r8;	 Catch:{ all -> 0x0100 }
        r7.<init>(r8, r6);	 Catch:{ all -> 0x0100 }
        r7 = r7.aRU();	 Catch:{ all -> 0x0100 }
        r8 = "card";
        kotlin.jvm.internal.h.d(r7, r8);	 Catch:{ all -> 0x0100 }
        r8 = r7.Vg();	 Catch:{ all -> 0x0100 }
        r9 = r8;
        r9 = (java.lang.CharSequence) r9;	 Catch:{ all -> 0x0100 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0100 }
        if (r9 == 0) goto L_0x004a;
    L_0x0040:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x0100 }
        r7 = "Can't read card";
        r3.<init>(r7);	 Catch:{ all -> 0x0100 }
        r3 = (java.lang.Throwable) r3;	 Catch:{ all -> 0x0100 }
        throw r3;	 Catch:{ all -> 0x0100 }
    L_0x004a:
        r9 = r3;
        r9 = (java.lang.String) r9;	 Catch:{ all -> 0x0100 }
        r10 = r3;
        r10 = (java.lang.String) r10;	 Catch:{ all -> 0x0100 }
        r11 = r7.auW();	 Catch:{ all -> 0x0100 }
        r11 = (java.lang.CharSequence) r11;	 Catch:{ all -> 0x0100 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0100 }
        if (r11 != 0) goto L_0x008c;
    L_0x005c:
        r11 = r7.auW();	 Catch:{ all -> 0x0100 }
        r12 = "card.expireDate";
        kotlin.jvm.internal.h.d(r11, r12);	 Catch:{ all -> 0x0100 }
        r13 = r11;
        r13 = (java.lang.CharSequence) r13;	 Catch:{ all -> 0x0100 }
        r14 = new char[r6];	 Catch:{ all -> 0x0100 }
        r11 = 47;
        r12 = 0;
        r14[r12] = r11;	 Catch:{ all -> 0x0100 }
        r15 = 0;
        r16 = 0;
        r17 = 6;
        r18 = 0;
        r11 = kotlin.text.v.b(r13, r14, r15, r16, r17, r18);	 Catch:{ all -> 0x0100 }
        r13 = r11.size();	 Catch:{ all -> 0x0100 }
        if (r13 <= r6) goto L_0x008c;
    L_0x0080:
        r9 = r11.get(r12);	 Catch:{ all -> 0x0100 }
        r9 = (java.lang.String) r9;	 Catch:{ all -> 0x0100 }
        r10 = r11.get(r6);	 Catch:{ all -> 0x0100 }
        r10 = (java.lang.String) r10;	 Catch:{ all -> 0x0100 }
    L_0x008c:
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x0100 }
        r11 = r7.aRR();	 Catch:{ all -> 0x0100 }
        r11 = (java.lang.CharSequence) r11;	 Catch:{ all -> 0x0100 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0100 }
        if (r11 != 0) goto L_0x00c2;
    L_0x009a:
        r11 = r7.aRQ();	 Catch:{ all -> 0x0100 }
        r11 = (java.lang.CharSequence) r11;	 Catch:{ all -> 0x0100 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0100 }
        if (r11 != 0) goto L_0x00c2;
    L_0x00a6:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0100 }
        r3.<init>();	 Catch:{ all -> 0x0100 }
        r11 = r7.aRR();	 Catch:{ all -> 0x0100 }
        r3.append(r11);	 Catch:{ all -> 0x0100 }
        r11 = " ";
        r3.append(r11);	 Catch:{ all -> 0x0100 }
        r7 = r7.aRQ();	 Catch:{ all -> 0x0100 }
        r3.append(r7);	 Catch:{ all -> 0x0100 }
        r3 = r3.toString();	 Catch:{ all -> 0x0100 }
    L_0x00c2:
        r7 = new com.iqoption.deposit.card.d$a;	 Catch:{ all -> 0x0100 }
        r11 = "cardNumber";
        kotlin.jvm.internal.h.d(r8, r11);	 Catch:{ all -> 0x0100 }
        r7.<init>(r8, r9, r10, r3);	 Catch:{ all -> 0x0100 }
        kotlin.c.b.a(r1, r4);	 Catch:{ Throwable -> 0x00d0 }
        return r7;
    L_0x00d0:
        r0 = move-exception;
        r3 = r0;
        r7 = 3;
        if (r2 >= r7) goto L_0x00fb;
    L_0x00d5:
        r7 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        java.lang.Thread.sleep(r7);	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        r3 = "SCHEDULER_ERROR";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        r7.<init>();	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        r8 = "parse ";
        r7.append(r8);	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        r7.append(r2);	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        com.iqoption.core.i.e(r3, r7);	 Catch:{ Throwable -> 0x0105, all -> 0x0100 }
        r2 = r2 + r6;
        r6 = r19;
        r2 = r6.a(r5, r2);	 Catch:{ Throwable -> 0x00fe }
        kotlin.c.b.a(r1, r4);
        return r2;
    L_0x00fb:
        r6 = r19;
        throw r3;	 Catch:{ Throwable -> 0x00fe }
    L_0x00fe:
        r0 = move-exception;
        goto L_0x0108;
    L_0x0100:
        r0 = move-exception;
        r6 = r19;
    L_0x0103:
        r2 = r0;
        goto L_0x010c;
    L_0x0105:
        r0 = move-exception;
        r6 = r19;
    L_0x0108:
        r4 = r0;
        throw r4;	 Catch:{ all -> 0x010a }
    L_0x010a:
        r0 = move-exception;
        goto L_0x0103;
    L_0x010c:
        kotlin.c.b.a(r1, r4);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.card.d.a(android.nfc.tech.IsoDep, int):com.iqoption.deposit.card.d$a");
    }
}
