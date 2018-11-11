package com.iqoption.fragment.dialog.whatsnew.depositpage;

import com.google.android.gms.plus.PlusShare;
import com.google.common.hash.HashCode;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import java.util.ArrayList;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0002\u0010\nJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\b\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001d"}, aXE = {"Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "title", "", "url", "paymentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "id", "getId", "()Ljava/lang/Long;", "getPaymentId", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;", "equals", "", "other", "", "hashCode", "", "toString", "List", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BankItem.kt */
public final class BankItem implements d<Long> {
    @SerializedName("payment_method_id")
    private final Long cBV;
    @SerializedName("title")
    private final String title;
    @SerializedName("url")
    private final String url;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, aXE = {"Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem$List;", "Ljava/util/ArrayList;", "Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;", "Lkotlin/collections/ArrayList;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: BankItem.kt */
    public static final class List extends ArrayList<BankItem> {
        public boolean a(BankItem bankItem) {
            return super.contains(bankItem);
        }

        public int b(BankItem bankItem) {
            return super.indexOf(bankItem);
        }

        public int c(BankItem bankItem) {
            return super.lastIndexOf(bankItem);
        }

        public final boolean contains(Object obj) {
            return obj instanceof BankItem ? a((BankItem) obj) : false;
        }

        public boolean d(BankItem bankItem) {
            return super.remove(bankItem);
        }

        public int getSize() {
            return super.size();
        }

        public final int indexOf(Object obj) {
            return obj instanceof BankItem ? b((BankItem) obj) : -1;
        }

        public final int lastIndexOf(Object obj) {
            return obj instanceof BankItem ? c((BankItem) obj) : -1;
        }

        public final boolean remove(Object obj) {
            return obj instanceof BankItem ? d((BankItem) obj) : false;
        }

        public final int size() {
            return getSize();
        }
    }

    public BankItem() {
        this(null, null, null, 7, null);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.cBV, r3.cBV) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.fragment.dialog.whatsnew.depositpage.BankItem;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.fragment.dialog.whatsnew.depositpage.BankItem) r3;
        r0 = r2.title;
        r1 = r3.title;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.url;
        r1 = r3.url;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.cBV;
        r3 = r3.cBV;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.dialog.whatsnew.depositpage.BankItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.cBV;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BankItem(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", paymentId=");
        stringBuilder.append(this.cBV);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public BankItem(String str, String str2, Long l) {
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        h.e(str2, PlusShare.KEY_CALL_TO_ACTION_URL);
        this.title = str;
        this.url = str2;
        this.cBV = l;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ BankItem(String str, String str2, Long l, int i, f fVar) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            l = (Long) null;
        }
        this(str, str2, l);
    }

    public final Long alz() {
        return this.cBV;
    }

    /* renamed from: getId */
    public Long Jf() {
        Long l = this.cBV;
        return Long.valueOf(l != null ? l.longValue() : HashCode.cI(this.title).vf());
    }
}
