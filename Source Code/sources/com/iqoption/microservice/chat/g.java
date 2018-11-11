package com.iqoption.microservice.chat;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 i2\u00020\u0001:\u0001iB\u0007\b\u0016¢\u0006\u0002\u0010\u0002Bï\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001fJ\t\u0010N\u001a\u00020\u0004HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010S\u001a\u00020\u0015HÆ\u0003J\t\u0010T\u001a\u00020\u0015HÆ\u0003J\t\u0010U\u001a\u00020\u0015HÆ\u0003J\t\u0010V\u001a\u00020\u000eHÆ\u0003J\t\u0010W\u001a\u00020\u0015HÆ\u0003J\t\u0010X\u001a\u00020\u0015HÆ\u0003J\t\u0010Y\u001a\u00020\u0004HÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\\\u001a\u00020\u0004HÆ\u0003J\t\u0010]\u001a\u00020\bHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010`\u001a\u00020\u0004HÆ\u0003J\t\u0010a\u001a\u00020\u000eHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jó\u0001\u0010c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00152\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010d\u001a\u00020\u00152\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020gHÖ\u0001J\t\u0010h\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u001a\u001a\u00020\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8FX\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0016\u0010\u0018\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0016\u001a\u00020\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010#R\u0016\u0010\u0017\u001a\u00020\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010#R\u0011\u0010.\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b.\u0010#R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010#R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u001b\u00102\u001a\u0002038FX\u0002¢\u0006\f\n\u0004\b6\u0010)\u001a\u0004\b4\u00105R\u0016\u0010\u0019\u001a\u00020\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010-R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010-R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u001b\u0010A\u001a\u00020B8FX\u0002¢\u0006\f\n\u0004\bE\u0010)\u001a\u0004\bC\u0010DR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u001b\u0010G\u001a\u00020H8FX\u0002¢\u0006\f\n\u0004\bK\u0010)\u001a\u0004\bI\u0010JR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M¨\u0006j"}, aXE = {"Lcom/iqoption/microservice/chat/ChatMessage;", "", "()V", "id", "", "requestId", "roomId", "type", "Lcom/iqoption/microservice/chat/ChatMessageType;", "text", "options", "Lcom/google/gson/JsonElement;", "sender", "senderId", "", "senderFlag", "senderCountryId", "senderAvatarUrl", "senderAvatar68Url", "senderAvatar110Url", "isSenderVip", "", "isSenderAdmin", "isSenderSystem", "date", "removed", "author_only", "attachments", "", "Lcom/iqoption/microservice/chat/ChatAttachment;", "previousId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iqoption/microservice/chat/ChatMessageType;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZJZZLjava/util/List;Ljava/lang/String;)V", "getAttachments", "()Ljava/util/List;", "getAuthor_only", "()Z", "closedAdapter", "Lcom/iqoption/microservice/chat/ChatMessageClosedAdapter;", "getClosedAdapter", "()Lcom/iqoption/microservice/chat/ChatMessageClosedAdapter;", "closedAdapter$delegate", "Lkotlin/Lazy;", "getDate", "()J", "getId", "()Ljava/lang/String;", "isSenderUser", "getOptions", "()Lcom/google/gson/JsonElement;", "getPreviousId", "rateAdapter", "Lcom/iqoption/microservice/chat/ChatMessageRateAdapter;", "getRateAdapter", "()Lcom/iqoption/microservice/chat/ChatMessageRateAdapter;", "rateAdapter$delegate", "getRemoved", "getRequestId", "getRoomId", "getSender", "getSenderAvatar110Url", "getSenderAvatar68Url", "getSenderAvatarUrl", "getSenderCountryId", "getSenderFlag", "getSenderId", "suggestionsAdapter", "Lcom/iqoption/microservice/chat/ChatMessageSuggestionsAdapter;", "getSuggestionsAdapter", "()Lcom/iqoption/microservice/chat/ChatMessageSuggestionsAdapter;", "suggestionsAdapter$delegate", "getText", "transferAdapter", "Lcom/iqoption/microservice/chat/ChatMessageTransferAdapter;", "getTransferAdapter", "()Lcom/iqoption/microservice/chat/ChatMessageTransferAdapter;", "transferAdapter$delegate", "getType", "()Lcom/iqoption/microservice/chat/ChatMessageType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Responses.kt */
public final class g {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "rateAdapter", "getRateAdapter()Lcom/iqoption/microservice/chat/ChatMessageRateAdapter;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "suggestionsAdapter", "getSuggestionsAdapter()Lcom/iqoption/microservice/chat/ChatMessageSuggestionsAdapter;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "closedAdapter", "getClosedAdapter()Lcom/iqoption/microservice/chat/ChatMessageClosedAdapter;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "transferAdapter", "getTransferAdapter()Lcom/iqoption/microservice/chat/ChatMessageTransferAdapter;"))};
    private static final d cQb = g.f(ChatMessage$Companion$EMPTY$2.cQd);
    public static final a cQc = new a();
    @SerializedName("date")
    private final long aFN;
    @SerializedName("room_id")
    private final String aUv;
    private final d cPH;
    private final d cPI;
    private final d cPJ;
    private final d cPK;
    @SerializedName("request_id")
    private final String cPL;
    @SerializedName("type")
    private final ChatMessageType cPM;
    @SerializedName("options")
    private final JsonElement cPN;
    @SerializedName("sender")
    private final String cPO;
    @SerializedName("sender_id")
    private final long cPP;
    @SerializedName("sender_flag")
    private final String cPQ;
    @SerializedName("sender_country_id")
    private final String cPR;
    @SerializedName("sender_avatar_url")
    private final String cPS;
    @SerializedName("sender_avatar_68_url")
    private final String cPT;
    @SerializedName("sender_avatar_110_url")
    private final String cPU;
    @SerializedName("is_sender_vip")
    private final boolean cPV;
    @SerializedName("is_sender_admin")
    private final boolean cPW;
    @SerializedName("is_sender_system")
    private final boolean cPX;
    @SerializedName("author_only")
    private final boolean cPY;
    @SerializedName("attachments")
    private final List<a> cPZ;
    @SerializedName("previous_id")
    private final String cQa;
    @SerializedName("id")
    private final String id;
    @SerializedName("removed")
    private final boolean removed;
    @SerializedName("text")
    private final String text;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/microservice/chat/ChatMessage$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/microservice/chat/ChatMessage;", "getEMPTY", "()Lcom/iqoption/microservice/chat/ChatMessage;", "EMPTY$delegate", "Lkotlin/Lazy;", "NO_ID", "", "SENDER_ID_SYSTEM", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Responses.kt */
    public static final class a {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "EMPTY", "getEMPTY()Lcom/iqoption/microservice/chat/ChatMessage;"))};

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final i arh() {
        d dVar = this.cPH;
        j jVar = apP[0];
        return (i) dVar.getValue();
    }

    public final j ari() {
        d dVar = this.cPI;
        j jVar = apP[1];
        return (j) dVar.getValue();
    }

    public final h arj() {
        d dVar = this.cPJ;
        j jVar = apP[2];
        return (h) dVar.getValue();
    }

    public final k ark() {
        d dVar = this.cPK;
        j jVar = apP[3];
        return (k) dVar.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (h.E(this.id, gVar.id) && h.E(this.cPL, gVar.cPL) && h.E(this.aUv, gVar.aUv) && h.E(this.cPM, gVar.cPM) && h.E(this.text, gVar.text) && h.E(this.cPN, gVar.cPN) && h.E(this.cPO, gVar.cPO)) {
                if ((this.cPP == gVar.cPP ? 1 : null) != null && h.E(this.cPQ, gVar.cPQ) && h.E(this.cPR, gVar.cPR) && h.E(this.cPS, gVar.cPS) && h.E(this.cPT, gVar.cPT) && h.E(this.cPU, gVar.cPU)) {
                    if ((this.cPV == gVar.cPV ? 1 : null) != null) {
                        if ((this.cPW == gVar.cPW ? 1 : null) != null) {
                            if ((this.cPX == gVar.cPX ? 1 : null) != null) {
                                if ((this.aFN == gVar.aFN ? 1 : null) != null) {
                                    if ((this.removed == gVar.removed ? 1 : null) != null) {
                                        return (this.cPY == gVar.cPY ? 1 : null) != null && h.E(this.cPZ, gVar.cPZ) && h.E(this.cQa, gVar.cQa);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cPL;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.aUv;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ChatMessageType chatMessageType = this.cPM;
        hashCode = (hashCode + (chatMessageType != null ? chatMessageType.hashCode() : 0)) * 31;
        str2 = this.text;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        JsonElement jsonElement = this.cPN;
        hashCode = (hashCode + (jsonElement != null ? jsonElement.hashCode() : 0)) * 31;
        str2 = this.cPO;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.cPP;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        str2 = this.cPQ;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cPR;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cPS;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cPT;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cPU;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.cPV;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.cPW;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.cPX;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        long j2 = this.aFN;
        hashCode = (hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        i2 = this.removed;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.cPY;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        List list = this.cPZ;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        str2 = this.cQa;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatMessage(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", requestId=");
        stringBuilder.append(this.cPL);
        stringBuilder.append(", roomId=");
        stringBuilder.append(this.aUv);
        stringBuilder.append(", type=");
        stringBuilder.append(this.cPM);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", options=");
        stringBuilder.append(this.cPN);
        stringBuilder.append(", sender=");
        stringBuilder.append(this.cPO);
        stringBuilder.append(", senderId=");
        stringBuilder.append(this.cPP);
        stringBuilder.append(", senderFlag=");
        stringBuilder.append(this.cPQ);
        stringBuilder.append(", senderCountryId=");
        stringBuilder.append(this.cPR);
        stringBuilder.append(", senderAvatarUrl=");
        stringBuilder.append(this.cPS);
        stringBuilder.append(", senderAvatar68Url=");
        stringBuilder.append(this.cPT);
        stringBuilder.append(", senderAvatar110Url=");
        stringBuilder.append(this.cPU);
        stringBuilder.append(", isSenderVip=");
        stringBuilder.append(this.cPV);
        stringBuilder.append(", isSenderAdmin=");
        stringBuilder.append(this.cPW);
        stringBuilder.append(", isSenderSystem=");
        stringBuilder.append(this.cPX);
        stringBuilder.append(", date=");
        stringBuilder.append(this.aFN);
        stringBuilder.append(", removed=");
        stringBuilder.append(this.removed);
        stringBuilder.append(", author_only=");
        stringBuilder.append(this.cPY);
        stringBuilder.append(", attachments=");
        stringBuilder.append(this.cPZ);
        stringBuilder.append(", previousId=");
        stringBuilder.append(this.cQa);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public g(String str, String str2, String str3, ChatMessageType chatMessageType, String str4, JsonElement jsonElement, String str5, long j, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, boolean z3, long j2, boolean z4, boolean z5, List<a> list, String str11) {
        String str12 = str;
        String str13 = str2;
        String str14 = str3;
        ChatMessageType chatMessageType2 = chatMessageType;
        String str15 = str5;
        h.e(str12, "id");
        h.e(str13, "requestId");
        h.e(str14, "roomId");
        h.e(chatMessageType2, Param.TYPE);
        h.e(str15, "sender");
        this.id = str12;
        this.cPL = str13;
        this.aUv = str14;
        this.cPM = chatMessageType2;
        this.text = str4;
        this.cPN = jsonElement;
        this.cPO = str15;
        this.cPP = j;
        this.cPQ = str6;
        this.cPR = str7;
        this.cPS = str8;
        this.cPT = str9;
        this.cPU = str10;
        this.cPV = z;
        this.cPW = z2;
        this.cPX = z3;
        this.aFN = j2;
        this.removed = z4;
        this.cPY = z5;
        this.cPZ = list;
        this.cQa = str11;
        this.cPH = g.f(new ChatMessage$rateAdapter$2(this));
        this.cPI = g.f(new ChatMessage$suggestionsAdapter$2(this));
        this.cPJ = g.f(new ChatMessage$closedAdapter$2(this));
        this.cPK = g.f(new ChatMessage$transferAdapter$2(this));
    }

    public final String getId() {
        return this.id;
    }

    public final String Re() {
        return this.aUv;
    }

    public /* synthetic */ g(String str, String str2, String str3, ChatMessageType chatMessageType, String str4, JsonElement jsonElement, String str5, long j, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, boolean z3, long j2, boolean z4, boolean z5, List list, String str11, int i, f fVar) {
        int i2 = i;
        this((i2 & 1) != 0 ? "0" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? ChatMessageType.TEXT : chatMessageType, (i2 & 16) != 0 ? (String) null : str4, (i2 & 32) != 0 ? (JsonElement) null : jsonElement, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? 0 : j, (i2 & 256) != 0 ? (String) null : str6, (i2 & 512) != 0 ? (String) null : str7, (i2 & 1024) != 0 ? (String) null : str8, (i2 & 2048) != 0 ? (String) null : str9, (i2 & 4096) != 0 ? (String) null : str10, (i2 & 8192) != 0 ? false : z, (i2 & 16384) != 0 ? false : z2, (32768 & i2) != 0 ? false : z3, (65536 & i2) != 0 ? 0 : j2, (131072 & i2) != 0 ? false : z4, (262144 & i2) != 0 ? false : z5, (524288 & i2) != 0 ? (List) null : list, (i2 & 1048576) != 0 ? (String) null : str11);
    }

    public final ChatMessageType arl() {
        return this.cPM;
    }

    public final String getText() {
        return this.text;
    }

    public final JsonElement arm() {
        return this.cPN;
    }

    public final String arn() {
        return this.cPO;
    }

    public final long aro() {
        return this.cPP;
    }

    public final String arp() {
        return this.cPQ;
    }

    public final String arq() {
        return this.cPR;
    }

    public final String arr() {
        return this.cPS;
    }

    public final boolean ars() {
        return this.cPW;
    }

    public final boolean art() {
        return this.cPX;
    }

    public final long getDate() {
        return this.aFN;
    }

    public final boolean aru() {
        return this.removed;
    }

    public final boolean arv() {
        return this.cPY;
    }

    public final List<a> getAttachments() {
        return this.cPZ;
    }

    public final String arw() {
        return this.cQa;
    }

    public g() {
        this("0", null, null, null, null, null, null, 0, null, null, null, null, null, false, false, false, 0, false, false, null, null, 2097150, null);
    }

    public final boolean arg() {
        return com.iqoption.app.a.Cw().getUserId() == this.cPP;
    }
}
