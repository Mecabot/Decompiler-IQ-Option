package com.iqoption.dto.entity.position;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;

public class Order implements Parcelable {
    public static final String BUY = "buy";
    public static final Creator<Order> CREATOR = new Creator<Order>() {
        public Order createFromParcel(Parcel parcel) {
            return new Order(parcel);
        }

        public Order[] newArray(int i) {
            return new Order[i];
        }
    };
    public static final String LIMIT = "limit";
    public static final String MARKET = "market";
    public static final String ON_MKT_OPEN = "market-on-open";
    public static Ordering<Order> ORDERING_ORDER = new Ordering<Order>() {
        public int compare(Order order, Order order2) {
            return Longs.compare(order.id.longValue(), order2.id.longValue());
        }
    };
    public static final String ORDER_EXECUTE_STATUS_CANCELED = "canceled";
    public static final String ORDER_EXECUTE_STATUS_NEW = "new";
    public static final String ORDER_EXECUTE_STATUS_PARTIALLY_FILLED = "trade";
    public static final String ORDER_EXECUTE_STATUS_PENDING_CANCEL = "pending_cancel";
    public static final String ORDER_EXECUTE_STATUS_PENDING_NEW = "pending_new";
    public static final String ORDER_EXECUTE_STATUS_REJECTED = "rejected";
    public static final String ORDER_REJECT_STATUS_EXCEEDS_LIMIT = "exceeds_limit";
    public static final String ORDER_REJECT_STATUS_INSTRUMENT_PRICE_NOT_FOUND = "instrument_price_not_found";
    public static final String ORDER_REJECT_STATUS_INTERNAL_BILLING_EXCEPTION = "internal_billing_exception";
    public static final String ORDER_REJECT_STATUS_INTERNAL_BILLING_NOT_ENOUGH_BALANCE = "internal_billing_not_enough_balance";
    public static final String ORDER_REJECT_STATUS_RISK_EXCEPTION = "risk_exception";
    public static final String ORDER_REJECT_STATUS_SYMBOL_FORBIDDEN = "symbol_forbidden";
    public static final String ORDER_REJECT_STATUS_TOO_MUCH_TIME_PASSED = "too_much_time_passed";
    public static final String ORDER_REJECT_STATUS_UNKNOWN = "unknown";
    public static final String ORDER_REJECT_STATUS_USER_BALANCE_NOT_FOUND_OR_WRONG = "user_balance_not_found_or_wrong";
    public static final String ORDER_STATUS_CANCELED = "canceled";
    public static final String ORDER_STATUS_FILLED = "filled";
    public static final String ORDER_STATUS_NEW = "new";
    public static final String ORDER_STATUS_PARTIALLY_FILLED = "partially_filled";
    public static final String ORDER_STATUS_PENDING_CANCEL = "pending_cancel";
    public static final String ORDER_STATUS_PENDING_NEW = "pending_new";
    public static final String ORDER_STATUS_REJECTED = "rejected";
    public static final String SELL = "sell";
    public static final String STOP = "stop";
    public static final String TRAIL_STOP = "trail-stop";
    public static final d<Order, Long> getOrderId = Order$$Lambda$0.$instance;
    @SerializedName("avg_price")
    private Double avgPrice;
    @SerializedName("avg_price_enrolled")
    private Double avgPriceEnrolled;
    @SerializedName("basic_stoplimit_amount")
    private Double basicStopLimitAmount;
    @SerializedName("count")
    private Double count;
    @SerializedName("create_at")
    private Long createAt;
    @SerializedName("execute_at")
    private Long executeAt;
    @SerializedName("execute_status")
    private String executeStatus;
    @SerializedName("id")
    private Long id;
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
    @SerializedName("limit_price")
    private Double limitPrice;
    @SerializedName("margin")
    private Double margin;
    @SerializedName("position_id")
    private Long positionId;
    @SerializedName("reject_status")
    private String rejectStatus;
    @SerializedName("side")
    private String side;
    @SerializedName("status")
    private String status;
    @SerializedName("stop_lose_price")
    private Double stopLosePrice;
    @SerializedName("stop_price")
    private Double stopPrice;
    @SerializedName("take_profit_price")
    private Double takeProfitPrice;
    @SerializedName("type")
    private String type;
    @SerializedName("underlying_price")
    private Double underlyingPrice;
    @SerializedName("update_at")
    private Long updateAt;
    @SerializedName("user_balance_id")
    private Long userBalanceId;
    @SerializedName("user_id")
    private Long userId;

    public String createStrikeKey() {
        return "";
    }

    public int describeContents() {
        return 0;
    }

    static final /* synthetic */ Long lambda$static$0$Order(Order order) {
        return order != null ? order.getId() : null;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Order) && f.equal(this.id, ((Order) obj).id));
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public Long getCreateAt() {
        return Long.valueOf(this.createAt.longValue() / 1000);
    }

    public Long getInstrumentExpiration() {
        if (this.instrumentExpiration == null) {
            return Long.valueOf(-1);
        }
        return Long.valueOf(this.instrumentExpiration.longValue() / 1000);
    }

    public static boolean isMarketOrderFilled(Order order) {
        return order != null && ORDER_STATUS_FILLED.equalsIgnoreCase(order.status) && MARKET.equalsIgnoreCase(order.type);
    }

    public static boolean isTrailStoPOrder(Order order) {
        return (order == null || order.getPositionId() == null || !TRAIL_STOP.equals(order.type)) ? false : true;
    }

    public static boolean isTpslOrder(Order order) {
        return (order == null || order.getPositionId() == null || (!LIMIT.equalsIgnoreCase(order.type) && !STOP.equalsIgnoreCase(order.type) && !TRAIL_STOP.equals(order.type))) ? false : true;
    }

    public static boolean isDeferredOrder(Order order) {
        return order != null && order.getPositionId() == null && (LIMIT.equalsIgnoreCase(order.type) || STOP.equalsIgnoreCase(order.type) || ON_MKT_OPEN.equalsIgnoreCase(order.type));
    }

    public static boolean mktOnOpenExecuting(Order order) {
        return (order == null || order.getPositionId() == null || !ON_MKT_OPEN.equalsIgnoreCase(order.type)) ? false : true;
    }

    public long getIndex() {
        return this.index;
    }

    public Long getId() {
        return this.id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Long getUserBalanceId() {
        return this.userBalanceId;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType == null ? InstrumentType.UNKNOWN : this.instrumentType;
    }

    public String getInstrumentId() {
        return this.instrumentId;
    }

    public Long getPositionId() {
        return this.positionId;
    }

    public String getInstrumentUderlying() {
        return this.instrumentUderlying == null ? "" : this.instrumentUderlying;
    }

    public Integer getInstrumentActiveId() {
        return Integer.valueOf(this.instrumentActiveId == null ? -1 : this.instrumentActiveId.intValue());
    }

    public String getInstrumentDir() {
        return this.instrumentDir == null ? "" : this.instrumentDir;
    }

    public Double getInstrumentStrike() {
        return this.instrumentStrike;
    }

    public Long getInstrumentStrikeValue() {
        return Long.valueOf(this.instrumentStrikeValue == null ? 0 : this.instrumentStrikeValue.longValue());
    }

    public String getStatus() {
        return this.status == null ? "" : this.status;
    }

    public String getExecuteStatus() {
        return this.executeStatus == null ? "" : this.executeStatus;
    }

    public String getRejectStatus() {
        return this.rejectStatus;
    }

    public String getSide() {
        return this.side == null ? "" : this.side;
    }

    public String getType() {
        return this.type == null ? "" : this.type;
    }

    public Double getCountGL() {
        return Double.valueOf(this.count == null ? -1.0d : this.count.doubleValue());
    }

    public Integer getLeverageGL() {
        return Integer.valueOf(this.leverage == null ? -1 : this.leverage.intValue());
    }

    public Long getUpdateAt() {
        return this.updateAt;
    }

    public Long getExecuteAt() {
        return this.executeAt;
    }

    public Double getUnderlyingPrice() {
        return this.underlyingPrice;
    }

    public Double getAvgPriceGL() {
        return Double.valueOf(this.avgPrice == null ? -1.0d : this.avgPrice.doubleValue());
    }

    public Double getAvgPriceEnrolled() {
        return this.avgPriceEnrolled;
    }

    public Double getStopPrice() {
        return this.stopPrice;
    }

    public Double getLimitPrice() {
        return this.limitPrice;
    }

    public long getCreateTime() {
        return this.createAt != null ? this.createAt.longValue() : 0;
    }

    public double getCount() {
        return this.count == null ? 0.0d : this.count.doubleValue();
    }

    public int getLeverage() {
        return this.leverage == null ? 1 : this.leverage.intValue();
    }

    public double getAvgPrice() {
        return this.avgPrice == null ? 0.0d : this.avgPrice.doubleValue();
    }

    public Double getTakeProfitPrice() {
        return this.takeProfitPrice;
    }

    public Double getStopLosePrice() {
        return this.stopLosePrice;
    }

    public double getPendingPrice() {
        Double stopPrice = isStop() ? getStopPrice() : isLimit() ? getLimitPrice() : null;
        if (stopPrice == null) {
            return 0.0d;
        }
        return stopPrice.doubleValue();
    }

    public double getMargin() {
        return this.margin == null ? 0.0d : this.margin.doubleValue();
    }

    public double getInvestment() {
        return this.basicStopLimitAmount == null ? 0.0d : this.basicStopLimitAmount.doubleValue();
    }

    public boolean isStop() {
        return STOP.equalsIgnoreCase(this.type);
    }

    public boolean isLimit() {
        return LIMIT.equalsIgnoreCase(this.type);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.id);
        parcel.writeValue(this.userId);
        parcel.writeValue(this.userBalanceId);
        parcel.writeString(this.instrumentType.getServerValue());
        parcel.writeString(this.instrumentId);
        parcel.writeValue(this.positionId);
        parcel.writeString(this.instrumentUderlying);
        parcel.writeValue(this.instrumentActiveId);
        parcel.writeValue(this.instrumentExpiration);
        parcel.writeString(this.instrumentDir);
        parcel.writeValue(this.instrumentStrike);
        parcel.writeValue(this.instrumentStrikeValue);
        parcel.writeString(this.status);
        parcel.writeString(this.executeStatus);
        parcel.writeString(this.rejectStatus);
        parcel.writeString(this.side);
        parcel.writeString(this.type);
        parcel.writeValue(this.count);
        parcel.writeValue(this.leverage);
        parcel.writeValue(this.createAt);
        parcel.writeValue(this.updateAt);
        parcel.writeValue(this.executeAt);
        parcel.writeValue(this.underlyingPrice);
        parcel.writeValue(this.avgPrice);
        parcel.writeValue(this.avgPriceEnrolled);
        parcel.writeValue(this.stopPrice);
        parcel.writeValue(this.limitPrice);
        parcel.writeValue(this.margin);
        parcel.writeValue(this.basicStopLimitAmount);
        parcel.writeValue(this.takeProfitPrice);
        parcel.writeValue(this.stopLosePrice);
    }

    protected Order(Parcel parcel) {
        this.id = (Long) parcel.readValue(Long.class.getClassLoader());
        this.userId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.userBalanceId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.instrumentType = InstrumentType.fromServerValue(parcel.readString());
        this.instrumentId = parcel.readString();
        this.positionId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.instrumentUderlying = parcel.readString();
        this.instrumentActiveId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.instrumentExpiration = (Long) parcel.readValue(Long.class.getClassLoader());
        this.instrumentDir = parcel.readString();
        this.instrumentStrike = (Double) parcel.readValue(Double.class.getClassLoader());
        this.instrumentStrikeValue = (Long) parcel.readValue(Long.class.getClassLoader());
        this.status = parcel.readString();
        this.executeStatus = parcel.readString();
        this.rejectStatus = parcel.readString();
        this.side = parcel.readString();
        this.type = parcel.readString();
        this.count = (Double) parcel.readValue(Double.class.getClassLoader());
        this.leverage = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.createAt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.updateAt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.executeAt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.underlyingPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.avgPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.avgPriceEnrolled = (Double) parcel.readValue(Double.class.getClassLoader());
        this.stopPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.limitPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.margin = (Double) parcel.readValue(Double.class.getClassLoader());
        this.basicStopLimitAmount = (Double) parcel.readValue(Double.class.getClassLoader());
        this.takeProfitPrice = (Double) parcel.readValue(Double.class.getClassLoader());
        this.stopLosePrice = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
