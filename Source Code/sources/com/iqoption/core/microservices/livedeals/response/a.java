package com.iqoption.core.microservices.livedeals.response;

import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0014\u0010!\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0013¨\u0006&"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/response/LiveDeal;", "", "activeId", "", "getActiveId", "()I", "amount", "", "getAmount", "()D", "avatar", "", "getAvatar", "()Ljava/lang/String;", "countryId", "getCountryId", "createdAt", "", "getCreatedAt", "()J", "flag", "getFlag", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "isBig", "", "()Ljava/lang/Boolean;", "isCall", "()Z", "name", "getName", "positionId", "getPositionId", "()Ljava/lang/Integer;", "userId", "getUserId", "core_release"})
/* compiled from: LiveDeal.kt */
public interface a {
    double UO();

    long Wh();

    int Wi();

    String Wj();

    Boolean Wk();

    int getActiveId();

    String getFlag();

    InstrumentType getInstrumentType();

    String getName();

    long getUserId();

    boolean isCall();
}
