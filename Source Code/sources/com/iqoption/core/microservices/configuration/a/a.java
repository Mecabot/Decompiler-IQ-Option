package com.iqoption.core.microservices.configuration.a;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.ActiveType;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b?\b\b\u0018\u0000 ^2\u00020\u0001:\u0002^_B\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0019HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0019HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010!HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\tHÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\fHÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\fHÆ\u0003J\u0002\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001J\u0013\u0010Z\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\\\u001a\u00020\u0003H\u0016J\t\u0010]\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0016\u0010\u0014\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00100R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u00100R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u00100R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010.R\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0016\u0010\u001a\u001a\u00020\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00100R\u0018\u0010 \u001a\u0004\u0018\u00010!8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006`"}, aXE = {"Lcom/iqoption/core/microservices/configuration/response/Active;", "", "id", "", "name", "", "groupName", "description", "isVisible", "", "isPaused", "activeGroupId", "", "priority", "quoteProviderId", "quoteProviderName", "topTradersEnabled", "regulationMode", "image", "exchange", "isOtc", "timeFrom", "timeTo", "precision", "spreadPlus", "", "spreadMinus", "expirationDays", "", "startTime", "currencyLeftSide", "currencyRightSide", "type", "Lcom/iqoption/core/data/model/ActiveType;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJIJLjava/lang/String;ZILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IDD[ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iqoption/core/data/model/ActiveType;)V", "getActiveGroupId", "()J", "getCurrencyLeftSide", "()Ljava/lang/String;", "getCurrencyRightSide", "getDescription", "getExchange", "getExpirationDays", "()[I", "getGroupName", "getId", "()I", "getImage", "()Z", "getName", "getPrecision", "getPriority", "getQuoteProviderId", "getQuoteProviderName", "getRegulationMode", "getSpreadMinus", "()D", "getSpreadPlus", "getStartTime", "getTimeFrom", "getTimeTo", "getTopTradersEnabled", "getType", "()Lcom/iqoption/core/data/model/ActiveType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "RegulationMode", "core_release"})
/* compiled from: Active.kt */
public final class a {
    public static final a aVg = new a();
    @SerializedName("group_name")
    private final String aUO;
    @SerializedName("is_paused")
    private final boolean aUP;
    @SerializedName("active_group_id")
    private final long aUQ;
    @SerializedName("quote_provider_id")
    private final long aUR;
    @SerializedName("quote_provider_name")
    private final String aUS;
    @SerializedName("top_traders_enabled")
    private final boolean aUT;
    @SerializedName("regulation_mode")
    private final int aUU;
    @SerializedName("exchange")
    private final String aUV;
    @SerializedName("is_otc")
    private final boolean aUW;
    @SerializedName("time_from")
    private final String aUX;
    @SerializedName("time_to")
    private final String aUY;
    @SerializedName("spread_plus")
    private final double aUZ;
    @SerializedName("spread_minus")
    private final double aVa;
    @SerializedName("expiration_days")
    private final int[] aVb;
    @SerializedName("start_time")
    private final String aVc;
    @SerializedName("currency_left_side")
    private final String aVd;
    @SerializedName("currency_right_side")
    private final String aVe;
    @SerializedName("type")
    private final ActiveType aVf;
    @SerializedName("description")
    private final String description;
    @SerializedName("id")
    private final int id;
    @SerializedName("image")
    private final String image;
    @SerializedName("is_visible")
    private final boolean isVisible;
    @SerializedName("name")
    private final String name;
    @SerializedName("precision")
    private final int precision;
    @SerializedName("priority")
    private final int priority;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/core/microservices/configuration/response/Active$Companion;", "", "()V", "PRECISION_DEFAULT", "", "REGULATION_MODE_ALL", "REGULATION_MODE_NON_REGULATED", "REGULATION_MODE_REGULATED", "core_release"})
    /* compiled from: Active.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public a() {
        this(0, null, null, null, false, false, 0, 0, 0, null, false, 0, null, null, false, null, null, 0, 0.0d, 0.0d, null, null, null, null, null, 33554431, null);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Active(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", groupName=");
        stringBuilder.append(this.aUO);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", isVisible=");
        stringBuilder.append(this.isVisible);
        stringBuilder.append(", isPaused=");
        stringBuilder.append(this.aUP);
        stringBuilder.append(", activeGroupId=");
        stringBuilder.append(this.aUQ);
        stringBuilder.append(", priority=");
        stringBuilder.append(this.priority);
        stringBuilder.append(", quoteProviderId=");
        stringBuilder.append(this.aUR);
        stringBuilder.append(", quoteProviderName=");
        stringBuilder.append(this.aUS);
        stringBuilder.append(", topTradersEnabled=");
        stringBuilder.append(this.aUT);
        stringBuilder.append(", regulationMode=");
        stringBuilder.append(this.aUU);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", exchange=");
        stringBuilder.append(this.aUV);
        stringBuilder.append(", isOtc=");
        stringBuilder.append(this.aUW);
        stringBuilder.append(", timeFrom=");
        stringBuilder.append(this.aUX);
        stringBuilder.append(", timeTo=");
        stringBuilder.append(this.aUY);
        stringBuilder.append(", precision=");
        stringBuilder.append(this.precision);
        stringBuilder.append(", spreadPlus=");
        stringBuilder.append(this.aUZ);
        stringBuilder.append(", spreadMinus=");
        stringBuilder.append(this.aVa);
        stringBuilder.append(", expirationDays=");
        stringBuilder.append(Arrays.toString(this.aVb));
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.aVc);
        stringBuilder.append(", currencyLeftSide=");
        stringBuilder.append(this.aVd);
        stringBuilder.append(", currencyRightSide=");
        stringBuilder.append(this.aVe);
        stringBuilder.append(", type=");
        stringBuilder.append(this.aVf);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(int i, String str, String str2, String str3, boolean z, boolean z2, long j, int i2, long j2, String str4, boolean z3, int i3, String str5, String str6, boolean z4, String str7, String str8, int i4, double d, double d2, int[] iArr, String str9, String str10, String str11, ActiveType activeType) {
        String str12 = str;
        String str13 = str2;
        String str14 = str4;
        String str15 = str5;
        h.e(str12, "name");
        h.e(str13, "groupName");
        h.e(str14, "quoteProviderName");
        h.e(str15, "image");
        this.id = i;
        this.name = str12;
        this.aUO = str13;
        this.description = str3;
        this.isVisible = z;
        this.aUP = z2;
        this.aUQ = j;
        this.priority = i2;
        this.aUR = j2;
        this.aUS = str14;
        this.aUT = z3;
        this.aUU = i3;
        this.image = str15;
        this.aUV = str6;
        this.aUW = z4;
        this.aUX = str7;
        this.aUY = str8;
        this.precision = i4;
        this.aUZ = d;
        this.aVa = d2;
        this.aVb = iArr;
        this.aVc = str9;
        this.aVd = str10;
        this.aVe = str11;
        this.aVf = activeType;
    }

    public /* synthetic */ a(int i, String str, String str2, String str3, boolean z, boolean z2, long j, int i2, long j2, String str4, boolean z3, int i3, String str5, String str6, boolean z4, String str7, String str8, int i4, double d, double d2, int[] iArr, String str9, String str10, String str11, ActiveType activeType, int i5, f fVar) {
        int i6 = i5;
        this((i6 & 1) != 0 ? -1 : i, (i6 & 2) != 0 ? "" : str, (i6 & 4) != 0 ? "" : str2, (i6 & 8) != 0 ? (String) null : str3, (i6 & 16) != 0 ? false : z, (i6 & 32) != 0 ? false : z2, (i6 & 64) != 0 ? -1 : j, (i6 & 128) != 0 ? 0 : i2, (i6 & 256) != 0 ? -1 : j2, (i6 & 512) != 0 ? "" : str4, (i6 & 1024) != 0 ? false : z3, (i6 & 2048) != 0 ? 1 : i3, (i6 & 4096) != 0 ? "" : str5, (i6 & 8192) != 0 ? (String) null : str6, (i6 & 16384) != 0 ? false : z4, (32768 & i6) != 0 ? (String) null : str7, (65536 & i6) != 0 ? (String) null : str8, (131072 & i6) != 0 ? 2 : i4, (262144 & i6) != 0 ? 0.0d : d, (524288 & i6) != 0 ? 0.0d : d2, (1048576 & i6) != 0 ? (int[]) null : iArr, (2097152 & i6) != 0 ? (String) null : str9, (4194304 & i6) != 0 ? (String) null : str10, (8388608 & i6) != 0 ? (String) null : str11, (i6 & 16777216) != 0 ? (ActiveType) null : activeType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.microservices.configuration.response.Active");
        }
        a aVar = (a) obj;
        if (this.id == aVar.id && (h.E(this.name, aVar.name) ^ 1) == 0 && (h.E(this.aUO, aVar.aUO) ^ 1) == 0 && (h.E(this.description, aVar.description) ^ 1) == 0 && this.isVisible == aVar.isVisible && this.aUP == aVar.aUP && this.aUQ == aVar.aUQ && this.priority == aVar.priority && this.aUR == aVar.aUR && (h.E(this.aUS, aVar.aUS) ^ 1) == 0 && this.aUT == aVar.aUT && this.aUU == aVar.aUU && (h.E(this.image, aVar.image) ^ 1) == 0 && (h.E(this.aUV, aVar.aUV) ^ 1) == 0 && this.aUW == aVar.aUW && (h.E(this.aUX, aVar.aUX) ^ 1) == 0 && (h.E(this.aUY, aVar.aUY) ^ 1) == 0 && this.precision == aVar.precision && this.aUZ == aVar.aUZ && this.aVa == aVar.aVa && Arrays.equals(this.aVb, aVar.aVb) && (h.E(this.aVc, aVar.aVc) ^ 1) == 0 && (h.E(this.aVd, aVar.aVd) ^ 1) == 0 && (h.E(this.aVe, aVar.aVe) ^ 1) == 0 && this.aVf == aVar.aVf) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.valueOf(this.id).hashCode() * 31) + this.name.hashCode()) * 31) + this.aUO.hashCode()) * 31;
        String str = this.description;
        int i = 0;
        hashCode = (((((((((((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Boolean.valueOf(this.isVisible).hashCode()) * 31) + Boolean.valueOf(this.aUP).hashCode()) * 31) + Long.valueOf(this.aUQ).hashCode()) * 31) + this.priority) * 31) + Long.valueOf(this.aUR).hashCode()) * 31) + this.aUS.hashCode()) * 31) + Boolean.valueOf(this.aUT).hashCode()) * 31) + this.aUU) * 31) + this.image.hashCode()) * 31;
        str = this.aUV;
        hashCode = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Boolean.valueOf(this.aUW).hashCode()) * 31;
        str = this.aUX;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aUY;
        hashCode = (((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.precision) * 31) + Double.valueOf(this.aUZ).hashCode()) * 31) + Double.valueOf(this.aVa).hashCode()) * 31;
        int[] iArr = this.aVb;
        hashCode = (hashCode + (iArr != null ? Arrays.hashCode(iArr) : 0)) * 31;
        str = this.aVc;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aVd;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aVe;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ActiveType activeType = this.aVf;
        if (activeType != null) {
            i = activeType.hashCode();
        }
        return hashCode + i;
    }
}
