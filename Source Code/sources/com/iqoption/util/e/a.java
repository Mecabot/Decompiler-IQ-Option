package com.iqoption.util.e;

import android.support.annotation.StringRes;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.k;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.util.at;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007\u001a\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\n\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\n\u001a\f\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\n\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\n\u001a\n\u0010\u000f\u001a\u00020\b*\u00020\n¨\u0006\u0010"}, aXE = {"getActiveTitle", "", "type", "Lcom/iqoption/core/data/model/ActiveType;", "Lcom/iqoption/core/data/model/InstrumentType;", "getActiveTitleResId", "", "isEnabledNow", "", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getName", "getNameForSort", "getShortName", "getTickerName", "isWithdrawalable", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveUtils.kt */
public final class a {
    public static final String O(InstrumentType instrumentType) {
        String string = IQApp.Dk().getString(P(instrumentType));
        h.d(string, "context.getString(getActiveTitleResId(type))");
        return string;
    }

    @StringRes
    public static final int P(InstrumentType instrumentType) {
        int i = R.string.n_a;
        if (instrumentType == null) {
            return R.string.n_a;
        }
        switch (b.aoS[instrumentType.ordinal()]) {
            case 1:
            case 2:
                if (!com.iqoption.app.managers.feature.a.HG()) {
                    i = R.string.binary;
                    break;
                }
            case 3:
                i = R.string.digital;
                break;
            case 4:
                i = R.string.forex;
                break;
            case 5:
                i = R.string.crypto;
                break;
            case 6:
                i = R.string.fx;
                break;
            case 7:
                i = R.string.cfd;
                break;
        }
        return i;
    }

    public static final String e(ActiveType activeType) {
        String string = IQApp.Dk().getString(f(activeType));
        h.d(string, "context.getString(getActiveTitleResId(type))");
        return string;
    }

    @StringRes
    public static final int f(ActiveType activeType) {
        int i = R.string.n_a;
        if (activeType == null) {
            return R.string.n_a;
        }
        switch (b.auk[activeType.ordinal()]) {
            case 1:
            case 2:
                if (!com.iqoption.app.managers.feature.a.HG()) {
                    i = R.string.binary;
                    break;
                }
            case 3:
                i = R.string.digital;
                break;
            case 4:
                i = R.string.forex;
                break;
            case 5:
                i = R.string.crypto;
                break;
            case 6:
                i = R.string.fx;
                break;
            case 7:
                i = R.string.commodities_abbr;
                break;
            case 8:
                i = R.string.stocks;
                break;
            case 9:
                i = R.string.etf;
                break;
            case 10:
                i = R.string.Indices;
                break;
            case 11:
                i = R.string.bonds;
                break;
        }
        return i;
    }

    public static final boolean F(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        h.e(aVar, "$receiver");
        return com.iqoption.withdrawal.crypto.a.aNZ() && h.E("BTCUSD", s(aVar));
    }

    public static final boolean G(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        if (aVar != null) {
            af Hu = af.Hu();
            h.d(Hu, "TimeServerManager.instance()");
            if (aVar.ba(Hu.Hw())) {
                return true;
            }
        }
        return false;
    }

    public static final String s(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        String Xr;
        h.e(aVar, "$receiver");
        if (aVar instanceof com.iqoption.core.microservices.tradingengine.response.active.h) {
            Xr = ((com.iqoption.core.microservices.tradingengine.response.active.h) aVar).Xr();
        } else if (aVar instanceof k) {
            Xr = ((k) aVar).Xg();
        } else {
            at.bJ(aVar);
            throw null;
        }
        Xr = LocalizationUtil.translate(Xr);
        return Xr != null ? Xr : "";
    }

    public static final String H(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        h.e(aVar, "$receiver");
        String s = s(aVar);
        if (s != null) {
            if ((((CharSequence) s).length() > 0 ? 1 : 0) == 1) {
                return s;
            }
        }
        if (aVar instanceof com.iqoption.core.microservices.tradingengine.response.active.h) {
            return aVar.Xf();
        }
        if (aVar instanceof k) {
            return ((k) aVar).Xg();
        }
        at.bJ(aVar);
        throw null;
    }

    public static final String E(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        h.e(aVar, "$receiver");
        if ((aVar instanceof com.iqoption.core.microservices.tradingengine.response.active.h) && aVar.getActiveType() == ActiveType.CRYPTO_ACTIVE) {
            String instrumentId = aVar.getInstrumentId();
            int a = v.a((CharSequence) instrumentId, "USD", 0, false, 6, null);
            if (a != -1) {
                if (instrumentId == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = instrumentId.substring(0, a);
                h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return s(aVar);
    }

    public static final String I(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        String instrumentId;
        h.e(aVar, "$receiver");
        int i = 0;
        if ((aVar instanceof com.iqoption.core.microservices.tradingengine.response.active.h) && aVar.getActiveType() == ActiveType.CRYPTO_ACTIVE) {
            instrumentId = aVar.getInstrumentId();
            int a = v.a((CharSequence) instrumentId, "USD", 0, false, 6, null);
            if (a != -1) {
                if (instrumentId == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = instrumentId.substring(0, a);
                h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        instrumentId = aVar.Xg();
        if (instrumentId == null) {
            instrumentId = aVar.Xf();
        }
        if (instrumentId.length() > 0) {
            i = 1;
        }
        if (i == 0) {
            instrumentId = null;
        }
        if (instrumentId == null) {
            instrumentId = s(aVar);
        }
        return instrumentId;
    }
}
