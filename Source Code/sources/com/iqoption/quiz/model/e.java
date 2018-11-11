package com.iqoption.quiz.model;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0012R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#¨\u0006%"}, aXE = {"Lcom/iqoption/quiz/model/QuizInsightItem;", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "activeId", "", "optionType", "Lcom/iqoption/core/data/model/InstrumentType;", "timestampBegin", "", "timestampEnd", "description", "", "activeName", "ticker", "price", "dailyChange", "dailyChangeNegative", "", "activeIcon", "(ILcom/iqoption/core/data/model/InstrumentType;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getActiveIcon", "()Ljava/lang/String;", "getActiveId", "()I", "getActiveName", "getDailyChange", "getDailyChangeNegative", "()Z", "getDescription", "id", "getId", "getOptionType", "()Lcom/iqoption/core/data/model/InstrumentType;", "getPrice", "getTicker", "getTimestampBegin", "()J", "getTimestampEnd", "quiz_release"})
/* compiled from: QuizInsightItems.kt */
public final class e extends f {
    private final int activeId;
    private final String activeName;
    private final String description;
    private final long dik;
    private final long dil;
    private final boolean dlA;
    private final String dlB;
    private final String dlx;
    private final String dly;
    private final String dlz;
    private final String id;
    private final InstrumentType optionType;

    public final int getActiveId() {
        return this.activeId;
    }

    public final InstrumentType getOptionType() {
        return this.optionType;
    }

    public final long aAg() {
        return this.dik;
    }

    public final long aAh() {
        return this.dil;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getActiveName() {
        return this.activeName;
    }

    public final String Xg() {
        return this.dlx;
    }

    public final String aBo() {
        return this.dly;
    }

    public final String aBp() {
        return this.dlz;
    }

    public final boolean aBq() {
        return this.dlA;
    }

    public e(int i, InstrumentType instrumentType, long j, long j2, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        h.e(instrumentType, "optionType");
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        h.e(str2, "activeName");
        h.e(str3, "ticker");
        h.e(str4, "price");
        h.e(str5, "dailyChange");
        super();
        this.activeId = i;
        this.optionType = instrumentType;
        this.dik = j;
        this.dil = j2;
        this.description = str;
        this.activeName = str2;
        this.dlx = str3;
        this.dly = str4;
        this.dlz = str5;
        this.dlA = z;
        this.dlB = str6;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.optionType.name());
        stringBuilder.append('_');
        stringBuilder.append(this.activeId);
        this.id = stringBuilder.toString();
    }

    public final String awV() {
        return this.dlB;
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
