package com.iqoption.dto.entity.position;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.common.base.Predicates;
import com.google.common.base.f;
import com.google.common.c.a;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.managers.c;
import com.iqoption.app.managers.feature.b;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.Balance;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.mobbtech.connect.response.options.i;
import com.iqoption.util.au;
import com.iqoption.util.l;
import com.iqoption.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.Duration;

public class Position extends e {
    public static final String CLOSE_REASON_DEFAULT = "default";
    public static final String CLOSE_REASON_EXPIRED = "expired";
    public static final String CLOSE_REASON_MARGIN_ERASE = "margin_erase";
    public static final String CLOSE_REASON_OVERNIGHT = "overnight";
    public static final String CLOSE_REASON_STOP_LOSE = "stop_lose";
    public static final String CLOSE_REASON_STOP_LOSS = "stop_loss";
    public static final String CLOSE_REASON_TAKE_PROFIT = "take_profit";
    public static final String CLOSE_REASON_WITHDRAW = "withdraw";
    public static final Creator<Position> CREATOR = new Creator<Position>() {
        public Position createFromParcel(Parcel parcel) {
            return new Position(parcel);
        }

        public Position[] newArray(int i) {
            return new Position[i];
        }
    };
    private static final double MAX_STOP_LOSE_PERCENTE = -95.0d;
    public static final String STATUS_CLOSED = "closed";
    public static final String STATUS_OPEN = "open";
    private static final String TAG = "Position";
    public static final String TYPE_LONG = "long";
    public static final String TYPE_SHORT = "short";
    private static final Pattern mPatternFindExpirationType = Pattern.compile("P(?!$)(\\d+Y)?(\\d+M)?(\\d+W)?(\\d+D)?(T(?=\\d)(\\d+H)?(\\d+M)?(\\d+S)?)?", 2);
    @SerializedName("buy_avg_price")
    private Double buyAvgPrice;
    @SerializedName("buy_avg_price_enrolled")
    private Double buyAvgPriceEnrolled;
    @SerializedName("charge")
    private Double charge;
    @SerializedName("close_at")
    private Long closeAt;
    @SerializedName("close_effect_amount")
    private Double closeEffectAmount;
    private transient i closeOptionKey;
    @SerializedName("close_reason")
    private String closeReason;
    @SerializedName("close_underlying_price")
    private Double closeUnderlyingPrice;
    @SerializedName("commission")
    private Double commission;
    @SerializedName("count")
    private Double count;
    @SerializedName("count_realized")
    private Double countRealized;
    @SerializedName("create_at")
    private Long createAt;
    @SerializedName("currency_rate")
    private Double currencyRate;
    @SerializedName("currency_unit")
    private Double currencyUnit;
    @SerializedName("extra_data")
    private ExtraData extraData;
    @SerializedName("index")
    private long index;
    @SerializedName("instrument_active_id")
    private Integer instrumentActiveId;
    @SerializedName("instrument_dir")
    private String instrumentDir;
    @SerializedName("instrument_expiration")
    private Long instrumentExpiration;
    @SerializedName("instrument_id")
    private String instrumentId;
    @SerializedName("instrument_strike")
    private Double instrumentStrike;
    @SerializedName("instrument_strike_value")
    private Long instrumentStrikeValue;
    @SerializedName("instrument_type")
    private InstrumentType instrumentType;
    @SerializedName("instrument_underlying")
    private String instrumentUderlying;
    @SerializedName("leverage")
    private Integer leverage;
    @SerializedName("margin")
    private Double margin;
    @SerializedName("margin_call")
    private Double marginCall;
    @SerializedName("open_client_platform_id")
    private Integer openClientPlatformId;
    @SerializedName("open_underlying_price")
    private Double openUnderlyingPrice;
    @SerializedName("order_ids")
    private ArrayList<Long> orderIds;
    @SerializedName("pnl_realized")
    private Double pnlRealized;
    @SerializedName("pnl_realized_enrolled")
    private Double pnlRealizedEnrolled;
    @SerializedName("sell_avg_price")
    private Double sellAvgPrice;
    @SerializedName("sell_avg_price_enrolled")
    private Double sellAvgPriceEnrolled;
    @SerializedName("status")
    private String status;
    @SerializedName("stop_lose_order_id")
    private Long stopLoseOrderId;
    @SerializedName("swap")
    private Double swap;
    @SerializedName("take_profit_order_id")
    private Long takeProfitOrderId;
    @SerializedName("update_at")
    private Long updateAt;

    private static class ExtraData implements Parcelable {
        public static final Creator<ExtraData> CREATOR = new Creator<ExtraData>() {
            public ExtraData createFromParcel(Parcel parcel) {
                return new ExtraData(parcel);
            }

            public ExtraData[] newArray(int i) {
                return new ExtraData[i];
            }
        };
        @SerializedName("auto_margin_call")
        private Boolean autoMarginCall;
        @SerializedName("spot_option")
        private Boolean isSpotOption;
        @SerializedName("lower_instrument_strike")
        private Long lowerInstrumentStrike;
        @SerializedName("lower_instrument_id")
        private String spotLowerInstrumentId;
        @SerializedName("upper_instrument_id")
        private String spotUpperInstrumentId;
        @SerializedName("stop_out_threshold")
        private Integer stopOutThreshold;
        @SerializedName("upper_instrument_strike")
        private Long upperInstrumentStrike;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeValue(this.autoMarginCall);
            parcel.writeValue(this.stopOutThreshold);
            parcel.writeValue(this.isSpotOption);
            parcel.writeString(this.spotLowerInstrumentId);
            parcel.writeString(this.spotUpperInstrumentId);
        }

        protected ExtraData(Parcel parcel) {
            this.autoMarginCall = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            this.stopOutThreshold = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.isSpotOption = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            this.spotLowerInstrumentId = parcel.readString();
            this.spotUpperInstrumentId = parcel.readString();
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean isCancelable(long j) {
        return false;
    }

    public List<Long> getOrderIds() {
        if (this.orderIds == null) {
            return Collections.emptyList();
        }
        return this.orderIds;
    }

    public long getIndex() {
        return this.index;
    }

    public Long getStopLoseOrderId() {
        return this.stopLoseOrderId;
    }

    public Long getTakeProfitOrderId() {
        return this.takeProfitOrderId;
    }

    public String getStringStopLoseOrderId() {
        return this.stopLoseOrderId == null ? "" : String.valueOf(this.stopLoseOrderId);
    }

    public String getStringTakeProfitOrderId() {
        return this.takeProfitOrderId == null ? "" : String.valueOf(this.takeProfitOrderId);
    }

    public Double getCommission() {
        return this.commission;
    }

    public Double getSwap() {
        return y.f(this.swap, this.charge);
    }

    public double getSelfSwap() {
        return ((Double) com.google.common.base.e.h(getSwap(), Double.valueOf(0.0d))).doubleValue();
    }

    public Double getMarginCall() {
        return this.marginCall;
    }

    public double getSelfMarginCall() {
        return this.marginCall == null ? 0.0d : this.marginCall.doubleValue();
    }

    @Nullable
    public Double getMarginCallOpt() {
        if (this.marginCall == null || a.b(0.0d, this.marginCall.doubleValue(), 0.001d)) {
            return null;
        }
        return this.marginCall;
    }

    public boolean isAutoMarginCall() {
        return (this.extraData == null || this.extraData.autoMarginCall == null) ? false : this.extraData.autoMarginCall.booleanValue();
    }

    public String spotLowerInstrumentId() {
        return (this.extraData == null || this.extraData.spotLowerInstrumentId == null) ? "" : this.extraData.spotLowerInstrumentId;
    }

    public String spotUpperInstrumentId() {
        return (this.extraData == null || this.extraData.spotUpperInstrumentId == null) ? "" : this.extraData.spotUpperInstrumentId;
    }

    public long spotLowerInstrumentStrike() {
        return (this.extraData == null || this.extraData.lowerInstrumentStrike == null) ? 0 : this.extraData.lowerInstrumentStrike.longValue();
    }

    public long spotUpperInstrumentStrike() {
        return (this.extraData == null || this.extraData.upperInstrumentStrike == null) ? 0 : this.extraData.upperInstrumentStrike.longValue();
    }

    public boolean isSpotStrike() {
        return (this.extraData == null || this.extraData.isSpotOption == null) ? false : this.extraData.isSpotOption.booleanValue();
    }

    public int getGLstopOutThreshold() {
        return (!this.instrumentType.isForexOrCFD() || this.extraData == null || this.extraData.stopOutThreshold == null) ? 0 : this.extraData.stopOutThreshold.intValue();
    }

    public double getStopOutThreshold() {
        return (!this.instrumentType.isForexOrCFD() || this.extraData == null || this.extraData.stopOutThreshold == null) ? MAX_STOP_LOSE_PERCENTE : au.J((double) this.extraData.stopOutThreshold.intValue());
    }

    public Integer getOpenClientPlatformId() {
        return Integer.valueOf(this.openClientPlatformId == null ? 17 : this.openClientPlatformId.intValue());
    }

    public int getViewType() {
        switch (getInstrumentType()) {
            case DIGITAL_INSTRUMENT:
                return 4;
            case FX_INSTRUMENT:
                return 8;
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
                return 6;
            case CRYPTO_INSTRUMENT:
                return 7;
            default:
                return 0;
        }
    }

    public int getActiveId() {
        return this.instrumentActiveId != null ? this.instrumentActiveId.intValue() : -1;
    }

    public String getDir() {
        return this.instrumentDir;
    }

    public int isCallInt() {
        return isCall();
    }

    public boolean isCall() {
        switch (this.instrumentType) {
            case DIGITAL_INSTRUMENT:
            case FX_INSTRUMENT:
                return NotificationCompat.CATEGORY_CALL.equalsIgnoreCase(this.instrumentDir);
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
            case CRYPTO_INSTRUMENT:
                return isLong(this);
            default:
                return true;
        }
    }

    public Long getExpired() {
        if (this.instrumentExpiration == null) {
            return Long.valueOf(-1);
        }
        return Long.valueOf(this.instrumentExpiration.longValue() / 1000);
    }

    public long getExpireTime() {
        if (this.instrumentExpiration == null) {
            return -1;
        }
        return this.instrumentExpiration.longValue();
    }

    public Long getCreated() {
        if (this.createAt == null) {
            return Long.valueOf(0);
        }
        return Long.valueOf(this.createAt.longValue() / 1000);
    }

    public long getUpdated() {
        if (this.updateAt == null) {
            return 0;
        }
        return this.updateAt.longValue() / 1000;
    }

    public long getClosed() {
        if (this.closeAt == null) {
            return 0;
        }
        return this.closeAt.longValue() / 1000;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public boolean isClosed() {
        return f.equal(this.status, STATUS_CLOSED);
    }

    public String getStatus() {
        return this.status;
    }

    public double getBidPrice() {
        Double price = getPrice(true, false);
        return price != null ? price.doubleValue() : 0.0d;
    }

    public double getAskPrice() {
        Double price = getPrice(false, false);
        return price != null ? price.doubleValue() : 0.0d;
    }

    public double getBidPriceEnrolled() {
        Double price = getPrice(true, true);
        return price != null ? price.doubleValue() : 0.0d;
    }

    public double getAskPriceEnrolled() {
        Double price = getPrice(false, true);
        return price != null ? price.doubleValue() : 0.0d;
    }

    public double getSelfPriceEnrolled() {
        Double price = getPrice(isLong(this), true);
        return price != null ? price.doubleValue() : 0.0d;
    }

    public double getUnderlyingPrice() {
        ActiveQuote da = c.Gn().da(this.instrumentActiveId.intValue());
        if (da == null) {
            return 0.0d;
        }
        double bid;
        if (isLong(this)) {
            bid = da.getBid(getInstrumentType(), getLeverage());
        } else {
            bid = da.getAsk(getInstrumentType(), getLeverage());
        }
        return bid;
    }

    @Nullable
    private Double getPrice(boolean z, boolean z2) {
        switch (this.instrumentType) {
            case DIGITAL_INSTRUMENT:
                return isSpotStrike() ? calculatePriceForDigitalSpotOption(z, this) : calculatePriceForDigitalOption(z, z2, this);
            case FX_INSTRUMENT:
                return calculatePriceForFxOption(z, z2, this);
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
            case CRYPTO_INSTRUMENT:
                return calculatePriceForCfd(z, z2, this);
            default:
                return null;
        }
    }

    private Double calculatePriceForFxOption(boolean z, boolean z2, Position position) {
        Quote c = c.Gn().c(position.instrumentId, InstrumentType.FX_INSTRUMENT);
        if (c == null) {
            return null;
        }
        if (z2) {
            return c.bidPrice;
        }
        return Double.valueOf(getConvertedPriceInCurrencyPosition(c.bidPrice, position.getRate()));
    }

    private static Double calculatePriceForCfd(boolean z, boolean z2, Position position) {
        ActiveQuote da = c.Gn().da(position.getActiveId());
        if (da == null) {
            return null;
        }
        return calculatePriceForCfd(z, z2, position, da);
    }

    private static Double calculatePriceForCfd(boolean z, boolean z2, Position position, ActiveQuote activeQuote) {
        double bid;
        if (z2) {
            if (z) {
                bid = activeQuote.getBid(position.getInstrumentType(), position.getLeverage());
            } else {
                bid = activeQuote.getAsk(position.getInstrumentType(), position.getLeverage());
            }
            return Double.valueOf(bid);
        }
        if (z) {
            bid = activeQuote.getBid(position.getInstrumentType(), position.getLeverage());
        } else {
            bid = activeQuote.getAsk(position.getInstrumentType(), position.getLeverage());
        }
        return Double.valueOf(getConvertedPriceInCurrencyPosition(Double.valueOf(bid), position.getRate()));
    }

    private static Double calculatePriceForDigitalOption(boolean z, boolean z2, Position position) {
        Quote c = c.Gn().c(position.instrumentId, InstrumentType.DIGITAL_INSTRUMENT);
        if (c == null) {
            return null;
        }
        return calculatePriceForDigitalOption(z, z2, position, c);
    }

    private static Double calculatePriceForDigitalOption(boolean z, boolean z2, Position position, Quote quote) {
        if (z2) {
            return z ? quote.bidPrice : quote.askPrice;
        }
        return Double.valueOf(getConvertedPriceInCurrencyPosition(z ? quote.bidPrice : quote.askPrice, position.getRate()));
    }

    private static Double calculatePriceForDigitalSpotOption(boolean z, Position position) {
        Quote c = c.Gn().c(position.spotLowerInstrumentId(), InstrumentType.DIGITAL_INSTRUMENT);
        Quote c2 = c.Gn().c(position.spotUpperInstrumentId(), InstrumentType.DIGITAL_INSTRUMENT);
        if (c != null && c2 != null) {
            return calculatePriceForDigitalSpotOption(z, position, c, c2);
        }
        com.iqoption.core.i.w(TAG, "quotes not found for digital spot buyback");
        return null;
    }

    private static Double calculatePriceForDigitalSpotOption(boolean z, Position position, Quote quote, Quote quote2) {
        double longValue = ((double) position.getInstrumentStrikeValue().longValue()) / 1000000.0d;
        double spotLowerInstrumentStrike = ((double) position.spotLowerInstrumentStrike()) / 1000000.0d;
        double spotUpperInstrumentStrike = ((double) position.spotUpperInstrumentStrike()) / 1000000.0d;
        double selfBidPrice = Quote.selfBidPrice(quote);
        double selfBidPrice2 = Quote.selfBidPrice(quote2);
        if (spotLowerInstrumentStrike != longValue) {
            selfBidPrice = z ? selfBidPrice + (((longValue - spotLowerInstrumentStrike) / (spotUpperInstrumentStrike - spotLowerInstrumentStrike)) * (selfBidPrice2 - selfBidPrice)) : selfBidPrice2 + (((spotUpperInstrumentStrike - longValue) / (spotUpperInstrumentStrike - spotLowerInstrumentStrike)) * (selfBidPrice - selfBidPrice2));
        }
        return Double.valueOf(getConvertedPriceInCurrencyPosition(Double.valueOf(selfBidPrice), position.getRate()));
    }

    @Nullable
    public synchronized Double calculateBuybackAmountWithCancelable(long j) {
        Double price = getPrice(isLong(this), false);
        if (price == null) {
            return null;
        }
        return Double.valueOf(price.doubleValue() * getAbsCount().doubleValue());
    }

    private static double getConvertedPriceInCurrencyPosition(Double d, double d2) {
        return d == null ? 0.0d : d.doubleValue() / d2;
    }

    public double getRate() {
        double d = 1.0d;
        double doubleValue = this.currencyRate == null ? 1.0d : this.currencyRate.doubleValue();
        if (this.currencyUnit != null) {
            d = this.currencyUnit.doubleValue();
        }
        return doubleValue / d;
    }

    public Double getValue() {
        switch (getInstrumentType()) {
            case DIGITAL_INSTRUMENT:
            case FX_INSTRUMENT:
                return this.instrumentStrike;
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
            case CRYPTO_INSTRUMENT:
                return getOpenPrice();
            default:
                return Double.valueOf(0.0d);
        }
    }

    public Double getOpenUnderlyingPrice() {
        return this.openUnderlyingPrice;
    }

    public Double getExpValue() {
        return this.closeUnderlyingPrice;
    }

    public double getWinAmount() {
        return getSellPnl() + getInvestSum().doubleValue();
    }

    public Double getCloseInvestSum() {
        return Double.valueOf(getInvestSum().doubleValue() + getSelfSwap());
    }

    public Double getInvestSum() {
        return Double.valueOf((getOpenPrice().doubleValue() * (getAbsCount().doubleValue() + getCountRealized().doubleValue())) / ((double) getLeverage()));
    }

    public Double getInvestSumEnrolled() {
        return Double.valueOf((getOpenPriceEnrolled().doubleValue() * (getAbsCount().doubleValue() + getCountRealized().doubleValue())) / ((double) getLeverage()));
    }

    public Double getTotalSum() {
        return Double.valueOf(getOpenPrice().doubleValue() * (getAbsCount().doubleValue() + getCountRealized().doubleValue()));
    }

    public double getProfitIfWin() {
        return l.w(Double.valueOf(100.0d)).doubleValue() * this.count.doubleValue();
    }

    public Double getOptionCount() {
        return Double.valueOf(this.countRealized.doubleValue() + getAbsCount().doubleValue());
    }

    public Double getOptionOptPrice() {
        return this.buyAvgPrice;
    }

    public boolean isSold() {
        return (this.closeReason == null || CLOSE_REASON_EXPIRED.equals(this.closeReason)) ? false : true;
    }

    public boolean notClose() {
        return TextUtils.isEmpty(this.closeReason);
    }

    public static String getInstrumentIdEscape(String str) {
        return str.replace(".", "_");
    }

    public static String createPositionSplitId(InstrumentType instrumentType, Integer num, Long l, Long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(instrumentType);
        stringBuilder.append("_");
        stringBuilder.append(num);
        stringBuilder.append("_");
        stringBuilder.append(l);
        stringBuilder.append("_");
        stringBuilder.append(l2);
        return stringBuilder.toString();
    }

    public String getPositionSplitId() {
        return createPositionSplitId(getInstrumentType(), Integer.valueOf(getActiveId()), getExpired(), getId());
    }

    public static Object[] parsePositionSplitId(String str) {
        String[] split = str.split("_");
        InstrumentType fromServerValue = InstrumentType.fromServerValue(split[0]);
        Integer cM = Ints.cM(split[1]);
        Long cN = Longs.cN(split[2]);
        Long cN2 = Longs.cN(split[3]);
        i iVar = new i(cN, cM, fromServerValue);
        return new Object[]{cN2, iVar};
    }

    public String createStrikeKey() {
        return Strike.createStrikeKey(getInstrumentType(), getInstrumentUderlying(), getInstrumentExpiration().longValue(), getInstrumentStrikeValue().longValue(), getExpirationPeriod(), isSpotStrike());
    }

    public long getExpirationPeriod() {
        if (!com.iqoption.core.ext.c.b(getInstrumentType(), InstrumentType.DIGITAL_INSTRUMENT, InstrumentType.FX_INSTRUMENT)) {
            return 0;
        }
        Matcher matcher = mPatternFindExpirationType.matcher(getInstrumentId());
        while (matcher.find()) {
            CharSequence group = matcher.group();
            if (group.length() > 2) {
                return Duration.U(group).getSeconds();
            }
        }
        return 60;
    }

    public String getWin() {
        long winAmount = (long) (getWinAmount() * 1000.0d);
        long doubleValue = (long) (getCloseInvestSum().doubleValue() * 1000.0d);
        if (winAmount > doubleValue) {
            return "win";
        }
        return winAmount < doubleValue ? "loose" : "equal";
    }

    public String getCloseStatus() {
        if (isSold()) {
            return "sold";
        }
        return getWin();
    }

    public synchronized Double getCurrentProfitAmount() {
        if (this.currentProfitAmount == null) {
            this.currentProfitAmount = Double.valueOf(getWinAmount());
        }
        if (this.instrumentType == InstrumentType.FX_INSTRUMENT) {
            ActiveQuote da = c.Gn().da(getActiveId());
            if (da != null) {
                boolean equals = NotificationCompat.CATEGORY_CALL.equals(getDir());
                if (this.currentProfitAmount == null || getLastKnowValue() != da.getVal()) {
                    Double valueOf;
                    setLastKnowValue(da.getVal());
                    double val = da.getVal();
                    double doubleValue = getValue().doubleValue();
                    if (equals) {
                        valueOf = Double.valueOf(Math.max(0.0d, val - doubleValue));
                    } else {
                        valueOf = Double.valueOf(Math.max(0.0d, doubleValue - val));
                    }
                    valueOf = Double.valueOf(getConvertedPriceInCurrencyPosition(Double.valueOf(valueOf.doubleValue() * this.count.doubleValue()), getRate()));
                    if (this.currentProfitAmount == null || !this.currentProfitAmount.equals(valueOf)) {
                        this.currentProfitAmount = valueOf;
                    }
                }
            }
            return this.currentProfitAmount;
        }
        return super.getCurrentProfitAmount();
    }

    public String getInstrumentId() {
        return this.instrumentId;
    }

    public Long getInstrumentExpiration() {
        return Long.valueOf(this.instrumentExpiration == null ? 0 : this.instrumentExpiration.longValue());
    }

    public String getInstrumentUderlying() {
        return this.instrumentUderlying == null ? "" : this.instrumentUderlying;
    }

    public Double getInstrumentStrike() {
        return Double.valueOf(this.instrumentStrike == null ? 0.0d : this.instrumentStrike.doubleValue());
    }

    public Long getInstrumentStrikeValue() {
        return Long.valueOf(this.instrumentStrikeValue == null ? 0 : this.instrumentStrikeValue.longValue());
    }

    public int getLeverage() {
        return (this.leverage == null || this.leverage.intValue() == 0) ? 1 : this.leverage.intValue();
    }

    public Double getBuyAvgPrice() {
        return this.buyAvgPrice;
    }

    public Double getSellAvgPrice() {
        return this.sellAvgPrice;
    }

    public Double getBuyAvgPriceEnrolled() {
        return this.buyAvgPriceEnrolled;
    }

    public Double getSellAvgPriceEnrolled() {
        return this.sellAvgPriceEnrolled;
    }

    public Double getAbsCount() {
        if (isLong(this)) {
            return this.count;
        }
        return Double.valueOf(-this.count.doubleValue());
    }

    public Double getCount() {
        return this.count;
    }

    public Double getCountRealized() {
        return this.countRealized;
    }

    public Double getOpenPrice() {
        if (isLong(this)) {
            return this.buyAvgPrice;
        }
        return this.sellAvgPrice;
    }

    public Double getOpenPriceEnrolled() {
        if (isLong(this)) {
            return this.buyAvgPriceEnrolled;
        }
        return this.sellAvgPriceEnrolled;
    }

    public Double getClosePrice() {
        return Double.valueOf(getConvertedPriceInCurrencyPosition(this.closeUnderlyingPrice, getRate()));
    }

    public Double getClosePriceEnrolled() {
        return this.closeUnderlyingPrice;
    }

    @Nullable
    public Double getTakeProfitValue() {
        Order order;
        Long takeProfitOrderId = getTakeProfitOrderId();
        if (takeProfitOrderId == null) {
            order = null;
        } else {
            order = (Order) com.google.common.collect.i.c(c.Gn().i(getId())).e(Predicates.a(Predicates.G(takeProfitOrderId), Order.getOrderId)).pq();
        }
        if (order == null) {
            return null;
        }
        return order.getLimitPrice();
    }

    @Nullable
    public Double getStopLoseValue() {
        Order order;
        Long stopLoseOrderId = getStopLoseOrderId();
        if (stopLoseOrderId == null) {
            order = null;
        } else {
            order = (Order) com.google.common.collect.i.c(c.Gn().i(getId())).e(Predicates.a(Predicates.G(stopLoseOrderId), Order.getOrderId)).pq();
        }
        if (order == null) {
            return null;
        }
        return order.getStopPrice();
    }

    public boolean isTrailingStop() {
        Order order;
        Long stopLoseOrderId = getStopLoseOrderId();
        if (stopLoseOrderId == null) {
            order = null;
        } else {
            order = (Order) com.google.common.collect.i.c(c.Gn().i(getId())).e(Predicates.a(Predicates.G(stopLoseOrderId), Order.getOrderId)).pq();
        }
        return order != null && Order.TRAIL_STOP.equalsIgnoreCase(order.getType());
    }

    public double getTpslPercent(Double d) {
        if (d == null) {
            return 0.0d;
        }
        int i = isLong(this) ? 1 : -1;
        Double openPriceEnrolled = getOpenPriceEnrolled();
        if (openPriceEnrolled == null) {
            return 0.0d;
        }
        return (((((double) i) * 100.0d) * ((double) getLeverage())) * (d.doubleValue() - openPriceEnrolled.doubleValue())) / openPriceEnrolled.doubleValue();
    }

    public double getTpslValue(double d) {
        int i = isLong(this) ? 1 : -1;
        double leverage = (double) getLeverage();
        Double openPriceEnrolled = getOpenPriceEnrolled();
        if (openPriceEnrolled == null) {
            return 0.0d;
        }
        return openPriceEnrolled.doubleValue() * ((((d / leverage) / 100.0d) * ((double) i)) + 1.0d);
    }

    public double getSellPnl() {
        double pnlRealized = getPnlRealized();
        if (isClosed()) {
            return pnlRealized + ((this.closeEffectAmount.doubleValue() - ((getOpenPrice().doubleValue() * getAbsCount().doubleValue()) / ((double) getLeverage()))) - getSelfMarginCall());
        }
        return pnlRealized + calculateSellPnl(getPrice(isLong(this), false), getOpenPrice(), getAbsCount(), isLong(this));
    }

    private static double calculateSellPnl(Double d, Double d2, Double d3, boolean z) {
        if (d == null || d2 == null) {
            return 0.0d;
        }
        if (z) {
            return (d.doubleValue() - d2.doubleValue()) * d3.doubleValue();
        }
        return (d2.doubleValue() - d.doubleValue()) * d3.doubleValue();
    }

    public static boolean isLong(Position position) {
        return TYPE_LONG.equalsIgnoreCase(position.getType());
    }

    public long getCloseTime() {
        if (this.closeAt == null) {
            return 0;
        }
        return this.closeAt.longValue();
    }

    public long getUpdateTime() {
        if (this.updateAt == null) {
            return 0;
        }
        return this.updateAt.longValue();
    }

    public long getCreateTime() {
        if (this.createAt == null) {
            return 0;
        }
        return this.createAt.longValue();
    }

    public i getCloseOptionKey() {
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(getActiveId()), getInstrumentType());
        if (a == null) {
            switch (getInstrumentType()) {
                case CFD_INSTRUMENT:
                case FOREX_INSTRUMENT:
                case CRYPTO_INSTRUMENT:
                    return getCFCCloseOptionKey();
                default:
                    return super.getCloseOptionKey();
            }
        } else if (a.isExpired()) {
            return super.getCloseOptionKey();
        } else {
            return getCFCCloseOptionKey();
        }
    }

    private i getCFCCloseOptionKey() {
        if (this.closeOptionKey == null) {
            synchronized (this) {
                if (this.closeOptionKey == null) {
                    this.closeOptionKey = createCFCCloseOptionKey(this);
                }
            }
        }
        return this.closeOptionKey;
    }

    private static i createCFCCloseOptionKey(Position position) {
        return new i(position.getId(), Long.valueOf(position.getCloseTime() / 1000), Integer.valueOf(position.getActiveId()), position.getInstrumentType());
    }

    public double getPnlRealized() {
        if (this.pnlRealized == null) {
            return 0.0d;
        }
        return this.pnlRealized.doubleValue();
    }

    public boolean isMarginErased() {
        return CLOSE_REASON_MARGIN_ERASE.equalsIgnoreCase(this.closeReason);
    }

    public boolean isExpired() {
        return CLOSE_REASON_EXPIRED.equalsIgnoreCase(this.closeReason);
    }

    public boolean isStopLossPerformed() {
        return CLOSE_REASON_STOP_LOSS.equalsIgnoreCase(this.closeReason) || CLOSE_REASON_STOP_LOSE.equalsIgnoreCase(this.closeReason);
    }

    public boolean isTakeProfitPerformed() {
        return CLOSE_REASON_TAKE_PROFIT.equalsIgnoreCase(this.closeReason);
    }

    public boolean isOvernight() {
        return CLOSE_REASON_OVERNIGHT.equalsIgnoreCase(this.closeReason);
    }

    public boolean isWithdraw() {
        return CLOSE_REASON_WITHDRAW.equalsIgnoreCase(this.closeReason);
    }

    public String getCloseReason() {
        return this.closeReason == null ? "" : this.closeReason;
    }

    public boolean isWithdrawalable() {
        Balance d = com.iqoption.app.a.Cw().d(getUserBalanceId());
        Object obj = (d == null || d.type == null || 1 != d.type.intValue()) ? null : 1;
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(getActiveId()), getInstrumentType());
        if (obj != null && a != null && com.iqoption.util.e.a.F(a) && isLong(this) && ((Integer) com.google.common.base.e.h(Integer.valueOf(getLeverage()), Integer.valueOf(1))).intValue() == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position{instrumentUderlying='");
        stringBuilder.append(this.instrumentUderlying);
        stringBuilder.append('\'');
        stringBuilder.append(", instrumentActiveId=");
        stringBuilder.append(this.instrumentActiveId);
        stringBuilder.append(", instrumentExpiration=");
        stringBuilder.append(this.instrumentExpiration);
        stringBuilder.append(", instrumentDir='");
        stringBuilder.append(this.instrumentDir);
        stringBuilder.append('\'');
        stringBuilder.append(", instrumentStrike=");
        stringBuilder.append(this.instrumentStrike);
        stringBuilder.append(", instrumentStrikeValue=");
        stringBuilder.append(this.instrumentStrikeValue);
        stringBuilder.append(", instrumentType='");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append('\'');
        stringBuilder.append(", instrumentId='");
        stringBuilder.append(this.instrumentId);
        stringBuilder.append('\'');
        stringBuilder.append(", status='");
        stringBuilder.append(this.status);
        stringBuilder.append('\'');
        stringBuilder.append(", closeReason='");
        stringBuilder.append(this.closeReason);
        stringBuilder.append('\'');
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", countRealized=");
        stringBuilder.append(this.countRealized);
        stringBuilder.append(", leverage=");
        stringBuilder.append(this.leverage);
        stringBuilder.append(", buyAvgPrice=");
        stringBuilder.append(this.buyAvgPrice);
        stringBuilder.append(", buyAvgPriceEnrolled=");
        stringBuilder.append(this.buyAvgPriceEnrolled);
        stringBuilder.append(", sellAvgPrice=");
        stringBuilder.append(this.sellAvgPrice);
        stringBuilder.append(", sellAvgPriceEnrolled=");
        stringBuilder.append(this.sellAvgPriceEnrolled);
        stringBuilder.append(", pnlRealized=");
        stringBuilder.append(this.pnlRealized);
        stringBuilder.append(", pnlRealizedEnrolled=");
        stringBuilder.append(this.pnlRealizedEnrolled);
        stringBuilder.append(", closeEffectAmount=");
        stringBuilder.append(this.closeEffectAmount);
        stringBuilder.append(", createAt=");
        stringBuilder.append(this.createAt);
        stringBuilder.append(", updateAt=");
        stringBuilder.append(this.updateAt);
        stringBuilder.append(", closeAt=");
        stringBuilder.append(this.closeAt);
        stringBuilder.append(", closeUnderlyingPrice=");
        stringBuilder.append(this.closeUnderlyingPrice);
        stringBuilder.append(", openUnderlyingPrice=");
        stringBuilder.append(this.openUnderlyingPrice);
        stringBuilder.append(", margin=");
        stringBuilder.append(this.margin);
        stringBuilder.append(", currencyUnit=");
        stringBuilder.append(this.currencyUnit);
        stringBuilder.append(", currencyRate=");
        stringBuilder.append(this.currencyRate);
        stringBuilder.append(", stopLoseOrderId=");
        stringBuilder.append(this.stopLoseOrderId);
        stringBuilder.append(", takeProfitOrderId=");
        stringBuilder.append(this.takeProfitOrderId);
        stringBuilder.append(", closeOptionKey=");
        stringBuilder.append(this.closeOptionKey);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.instrumentUderlying);
        parcel.writeValue(this.instrumentActiveId);
        parcel.writeValue(this.instrumentExpiration);
        parcel.writeString(this.instrumentDir);
        parcel.writeValue(this.instrumentStrike);
        parcel.writeValue(this.instrumentStrikeValue);
        parcel.writeString(this.instrumentType.getServerValue());
        parcel.writeString(this.instrumentId);
        parcel.writeString(this.status);
        parcel.writeValue(this.commission);
        parcel.writeString(this.closeReason);
        parcel.writeValue(this.count);
        parcel.writeValue(this.countRealized);
        parcel.writeValue(this.leverage);
        parcel.writeValue(this.buyAvgPrice);
        parcel.writeValue(this.buyAvgPriceEnrolled);
        parcel.writeValue(this.sellAvgPrice);
        parcel.writeValue(this.sellAvgPriceEnrolled);
        parcel.writeValue(this.pnlRealized);
        parcel.writeValue(this.pnlRealizedEnrolled);
        parcel.writeValue(this.closeEffectAmount);
        parcel.writeValue(this.swap);
        parcel.writeValue(this.openClientPlatformId);
        parcel.writeValue(this.createAt);
        parcel.writeValue(this.updateAt);
        parcel.writeValue(this.closeAt);
        parcel.writeValue(this.closeUnderlyingPrice);
        parcel.writeValue(this.openUnderlyingPrice);
        parcel.writeValue(this.margin);
        parcel.writeValue(this.currencyUnit);
        parcel.writeValue(this.currencyRate);
        parcel.writeValue(this.stopLoseOrderId);
        parcel.writeValue(this.takeProfitOrderId);
        parcel.writeValue(this.marginCall);
        parcel.writeParcelable(this.extraData, i);
    }

    protected Position(Parcel parcel) {
        super(parcel);
        this.instrumentUderlying = parcel.readString();
        this.instrumentActiveId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.instrumentExpiration = (Long) parcel.readValue(Long.class.getClassLoader());
        this.instrumentDir = parcel.readString();
        this.instrumentStrike = (Double) parcel.readValue(Double.class.getClassLoader());
        this.instrumentStrikeValue = (Long) parcel.readValue(Long.class.getClassLoader());
        this.instrumentType = InstrumentType.fromServerValue(parcel.readString());
        this.instrumentId = parcel.readString();
        this.status = parcel.readString();
        this.commission = (Double) parcel.readValue(Double.class.getClassLoader());
        this.closeReason = parcel.readString();
        this.count = (Double) parcel.readValue(Double.class.getClassLoader());
        this.countRealized = (Double) parcel.readValue(Double.class.getClassLoader());
        this.leverage = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.buyAvgPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.buyAvgPriceEnrolled = (Double) parcel.readValue(Double.class.getClassLoader());
        this.sellAvgPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.sellAvgPriceEnrolled = (Double) parcel.readValue(Double.class.getClassLoader());
        this.pnlRealized = (Double) parcel.readValue(Double.class.getClassLoader());
        this.pnlRealizedEnrolled = (Double) parcel.readValue(Double.class.getClassLoader());
        this.closeEffectAmount = (Double) parcel.readValue(Double.class.getClassLoader());
        this.swap = (Double) parcel.readValue(Double.class.getClassLoader());
        this.openClientPlatformId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.createAt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.updateAt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.closeAt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.closeUnderlyingPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.openUnderlyingPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.margin = (Double) parcel.readValue(Double.class.getClassLoader());
        this.currencyUnit = (Double) parcel.readValue(Double.class.getClassLoader());
        this.currencyRate = (Double) parcel.readValue(Double.class.getClassLoader());
        this.stopLoseOrderId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.takeProfitOrderId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.marginCall = (Double) parcel.readValue(Double.class.getClassLoader());
        this.extraData = (ExtraData) parcel.readParcelable(ExtraData.class.getClassLoader());
    }

    public static double getDefaultStopOut(InstrumentType instrumentType, String str) {
        Feature fd = b.HT().fd("default-stop-out");
        if (fd == null || fd.status == null || fd.status.equals("disabled")) {
            return MAX_STOP_LOSE_PERCENTE;
        }
        return au.J(com.iqoption.core.util.i.a(com.iqoption.core.util.i.b(com.iqoption.core.util.i.b(com.iqoption.core.util.i.b(fd.params, instrumentType.toString()), str), com.iqoption.app.a.Cw().Dh() ? "reg" : "nonreg"), (double) MAX_STOP_LOSE_PERCENTE));
    }
}
