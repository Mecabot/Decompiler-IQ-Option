package com.iqoption.mobbtech.connect.response.options;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.managers.af;
import com.iqoption.app.managers.c;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.TopFeedTrader.Option;
import com.iqoption.dto.entity.position.Position;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Option */
public class e implements Parcelable, Comparable<e> {
    public static final int CANCEL_OPTION_TIMEOUT = 3000;
    public static final Creator<e> CREATOR = new Creator<e>() {
        /* renamed from: U */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: fy */
        public e[] newArray(int i) {
            return new e[i];
        }
    };
    public static final int NO_ID = -1;
    public static Ordering<e> ORDERING = orderingByCreatedTime.compound(orderingById);
    public static final d<e, Long> getId = g.$instance;
    public static final d<e, Pair<Long, Long>> getIdAndCreatedTime = h.$instance;
    public static final d<e, String> getIdSplitString = f.$instance;
    public static final Ordering<e> orderingByCreatedTime = new Ordering<e>() {
        /* renamed from: c */
        public int compare(e eVar, e eVar2) {
            return Longs.compare(eVar.getCreated().longValue(), eVar2.getCreated().longValue());
        }
    };
    public static final Ordering<e> orderingById = new Ordering<e>() {
        /* renamed from: c */
        public int compare(e eVar, e eVar2) {
            return Longs.compare(eVar.id.longValue(), eVar2.id.longValue());
        }
    };
    @SerializedName("active_id")
    private Integer activeId;
    public transient String activeNameHistory;
    @Nullable
    @SerializedName("type_name")
    private ActiveType activeType;
    @SerializedName("amount")
    private Long amount;
    @SerializedName("buyback_state")
    private String buybackState;
    @SerializedName("client_platform_id")
    private Integer clientPlatformId;
    @SerializedName("created")
    private Long created;
    @SerializedName("currency")
    private String currency;
    @SerializedName("currency_char")
    private String currencyChar;
    protected volatile Double currentProfitAmount;
    @SerializedName("dir")
    private String dir;
    @SerializedName("exp_time")
    private Long expTime;
    @SerializedName("exp_value")
    private Double expValue;
    @SerializedName("expired")
    protected Long expired;
    @SerializedName("game_state")
    private Integer gameState;
    private transient Integer groupId;
    @SerializedName("id")
    private Long id;
    @SerializedName("is_demo")
    private Boolean isDemo;
    private volatile transient boolean isValueChanged;
    private transient double lastKnownValue;
    @SerializedName("loose_amount")
    private Long looseAmount;
    @SerializedName("now")
    private Long now;
    private volatile transient i optionKey;
    @SerializedName("option_type_id")
    private Integer optionTypeId;
    @SerializedName("profit")
    private Long profit;
    @SerializedName("profit_amount")
    private Double profitAmount;
    @SerializedName("profit_income")
    private Double profitIncome;
    @SerializedName("profit_return")
    private Double profitReturn;
    @SerializedName("re_track")
    private String reTrack;
    @SerializedName("refund")
    private Long refund;
    @SerializedName("site_id")
    private Long siteId;
    @SerializedName("sum")
    private Double sum;
    public Double timeRecieved;
    @SerializedName("type")
    private String type;
    @SerializedName("user_balance_id")
    private Long userBalanceId;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("value")
    private Double value;
    @SerializedName("win")
    private String win;

    public int describeContents() {
        return 0;
    }

    public long getExpirationPeriod() {
        return 0;
    }

    public long getIndex() {
        return 0;
    }

    public double getSelfMarginCall() {
        return 0.0d;
    }

    public int getViewType() {
        return 2;
    }

    static final /* synthetic */ String lambda$static$0$Option(e eVar) {
        return eVar instanceof Position ? ((Position) eVar).getPositionSplitId() : String.valueOf(eVar.id);
    }

    public synchronized void setLastKnowValue(double d) {
        this.lastKnownValue = d;
    }

    public synchronized double getLastKnowValue() {
        return this.lastKnownValue;
    }

    public Double getValue() {
        return this.value;
    }

    public Double getOpenUnderlyingPrice() {
        return this.value;
    }

    public boolean isCall() {
        return NotificationCompat.CATEGORY_CALL.equalsIgnoreCase(this.dir);
    }

    public String getDir() {
        return this.dir;
    }

    public Double getInvestSum() {
        return this.sum;
    }

    public Double getCloseInvestSum() {
        return this.sum;
    }

    public Double getTotalSum() {
        return getInvestSum();
    }

    public boolean isValueChanged() {
        return this.isValueChanged;
    }

    public Long getExpired() {
        return this.expired;
    }

    public long getExpireTime() {
        if (this.expired == null) {
            return 0;
        }
        return this.expired.longValue() * 1000;
    }

    public long getCloseTime() {
        return getExpireTime();
    }

    public long getClosed() {
        return getCloseTime() / 1000;
    }

    public int getActiveId() {
        return this.activeId != null ? this.activeId.intValue() : -1;
    }

    public Long getId() {
        return this.id;
    }

    @Nullable
    public ActiveType getActiveType() {
        return this.activeType;
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        if (this.activeType == null && !TextUtils.isEmpty(this.type)) {
            this.activeType = ActiveType.fromServerValue(this.type);
        }
        return this.activeType != null ? this.activeType.toInstrumentType() : null;
    }

    public String getType() {
        return this.type;
    }

    public Long getCreated() {
        return this.created;
    }

    public long getCreateTime() {
        if (this.created == null) {
            return 0;
        }
        return this.created.longValue() * 1000;
    }

    public Long getUserBalanceId() {
        return this.userBalanceId;
    }

    public Integer getGameState() {
        return this.gameState;
    }

    public Double getExpValue() {
        return this.expValue;
    }

    public String getWin() {
        return this.win;
    }

    public String getCloseStatus() {
        return this.buybackState == null ? this.win : "sold";
    }

    public int getGroupId() {
        return f.hashCode(getExpired(), Integer.valueOf(getActiveId()), getInstrumentType());
    }

    public boolean isSold() {
        return "sold".equals(this.buybackState) || "canceled".equals(this.buybackState);
    }

    public boolean isClosed() {
        return getGameState().intValue() != 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof e) && ((e) obj).getId().equals(getId()));
    }

    public int hashCode() {
        return f.hashCode(Integer.valueOf(getId().hashCode()));
    }

    public String toString() {
        return com.google.common.base.e.B(this).d("activeId", this.activeId).d("amount", this.amount).d("isDemo", this.isDemo).d("created", getCreated()).d("expValue", this.expValue).d(Position.CLOSE_REASON_EXPIRED, this.expired).d("gameState", this.gameState).d(b.VALUE, getValue()).d("sum", this.sum).d("instrumentType", this.activeType).d("profitAmount", this.profitAmount).d("profitIncome", this.profitIncome).d("profitReturn", this.profitReturn).d(NotificationCompat.CATEGORY_STATUS, this.buybackState).d("win", this.win).toString();
    }

    public double getWinAmount() {
        return this.profitAmount.doubleValue();
    }

    public void setProfitAmount(Double d) {
        this.profitAmount = d;
    }

    public double getProfitIfWin() {
        return this.profitIncome != null ? (this.profitIncome.doubleValue() / 100.0d) * getInvestSum().doubleValue() : 0.0d;
    }

    public Double getProfitPercente() {
        return Double.valueOf((getCurrentProfitAmount().doubleValue() * 100.0d) / getInvestSum().doubleValue());
    }

    public synchronized Double getCurrentProfitAmount() {
        if (this.currentProfitAmount == null) {
            this.currentProfitAmount = Double.valueOf(getWinAmount());
        }
        ActiveQuote da = c.Gn().da(getActiveId());
        if (da != null && (this.currentProfitAmount == null || getLastKnowValue() != da.getVal())) {
            Double valueOf;
            setLastKnowValue(da.getVal());
            long val = (long) (da.getVal() * 1000000.0d);
            long doubleValue = (long) (getValue().doubleValue() * 1000000.0d);
            double d = 0.0d;
            if (NotificationCompat.CATEGORY_CALL.equals(getDir())) {
                if (val > doubleValue) {
                    d = getProfitIfWin();
                } else if (val >= doubleValue) {
                    d = getInvestSum().doubleValue();
                }
                valueOf = Double.valueOf(d);
            } else {
                if (val < doubleValue) {
                    d = getProfitIfWin();
                } else if (val <= doubleValue) {
                    d = getInvestSum().doubleValue();
                }
                valueOf = Double.valueOf(d);
            }
            if (this.currentProfitAmount == null || !this.currentProfitAmount.equals(valueOf)) {
                this.currentProfitAmount = valueOf;
            }
        }
        return this.currentProfitAmount;
    }

    public synchronized void setCurrentProfitAmount(Double d) {
        this.currentProfitAmount = d;
    }

    public double getExpPnl() {
        return getCurrentProfitAmount().doubleValue() - getInvestSum().doubleValue();
    }

    public i getOptionKey() {
        return getOptionKeyInternal();
    }

    public i getCloseOptionKey() {
        return getOptionKeyInternal();
    }

    private i getOptionKeyInternal() {
        if (this.optionKey == null) {
            synchronized (this) {
                if (this.optionKey == null) {
                    this.optionKey = createOptionKey(this);
                }
            }
        }
        return this.optionKey;
    }

    public Integer getClientPlatformId() {
        return this.clientPlatformId;
    }

    @Nullable
    private synchronized Double calculateBuybackAmount(com.iqoption.mobbtech.connect.response.b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.a(this, getLastKnowValue(), getProfitIfWin());
    }

    @Nullable
    public synchronized Double calculateBuybackAmountWithCancelable(long j) {
        Double calculateBuybackAmount;
        calculateBuybackAmount = calculateBuybackAmount(c.Gn().a(getExpired(), Integer.valueOf(getActiveId()), getInstrumentType()));
        if (calculateBuybackAmount != null && isCancelable(j)) {
            calculateBuybackAmount = getInvestSum();
        }
        return calculateBuybackAmount;
    }

    public long getCancelTimeLeft(long j) {
        if (!this.isValueChanged) {
            ActiveQuote da = c.Gn().da(getActiveId());
            if (da != null) {
                this.isValueChanged = getValue().equals(Double.valueOf(da.getVal())) ^ 1;
            }
        }
        return this.isValueChanged ? 0 : ((getCreated().longValue() * 1000) + ((long) CANCEL_OPTION_TIMEOUT)) - j;
    }

    public boolean isCancelable(long j) {
        if (!this.isValueChanged) {
            ActiveQuote da = c.Gn().da(getActiveId());
            if (da != null) {
                this.isValueChanged = getValue().equals(Double.valueOf(da.getVal())) ^ true;
            }
        }
        if (this.isValueChanged || getCancelTimeLeft(j) <= 0) {
            return false;
        }
        return true;
    }

    public double getSelfPriceEnrolled() {
        ActiveQuote da = c.Gn().da(this.activeId.intValue());
        if (da == null) {
            return 0.0d;
        }
        return da.getVal();
    }

    public double getUnderlyingPrice() {
        ActiveQuote da = c.Gn().da(this.activeId.intValue());
        if (da == null) {
            return 0.0d;
        }
        return da.getVal();
    }

    public static i createOptionKey(e eVar) {
        return new i(eVar.getExpired(), Integer.valueOf(eVar.getActiveId()), eVar.getInstrumentType());
    }

    @Nullable
    public static e jsonElement2options(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        e eVar = new e();
        eVar.activeId = Integer.valueOf(i.g(asJsonObject.get("active_id")));
        eVar.amount = Long.valueOf(i.f(asJsonObject.get("amount")));
        eVar.clientPlatformId = Integer.valueOf(i.g(asJsonObject.get("client_platform_id")));
        eVar.gameState = Integer.valueOf(i.g(asJsonObject.get("game_state")));
        eVar.expired = Long.valueOf(i.f(asJsonObject.get(Position.CLOSE_REASON_EXPIRED)));
        eVar.expTime = Long.valueOf(i.f(asJsonObject.get(Position.CLOSE_REASON_EXPIRED)));
        eVar.sum = Double.valueOf(i.e(asJsonObject.get("sum")));
        eVar.expValue = Double.valueOf(((double) i.f(asJsonObject.get("exp_value"))) / 1000000.0d);
        eVar.profitAmount = Double.valueOf(i.e(asJsonObject.get("profit_amount")));
        eVar.created = Long.valueOf(i.f(asJsonObject.get("created")));
        eVar.dir = i.i(asJsonObject.get("dir"));
        eVar.value = Double.valueOf(i.e(asJsonObject.get(b.VALUE)));
        eVar.win = i.i(asJsonObject.get("win"));
        eVar.id = Long.valueOf(i.f(asJsonObject.get("id")));
        eVar.type = i.i(asJsonObject.get("type_name"));
        eVar.profitIncome = Double.valueOf(i.e(asJsonObject.get("profit_income")));
        eVar.profitReturn = Double.valueOf(i.e(asJsonObject.get("profit_return")));
        eVar.activeType = ActiveType.fromServerValue(i.i(asJsonObject.get("type_name")));
        eVar.userBalanceId = Long.valueOf(i.f(asJsonObject.get("user_balance_id")));
        eVar.timeRecieved = Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d);
        return eVar;
    }

    public static e json2option(JSONObject jSONObject) {
        e eVar = new e();
        eVar.activeId = Integer.valueOf(jSONObject.optInt("active_id"));
        eVar.amount = Long.valueOf(jSONObject.optLong("amount"));
        eVar.clientPlatformId = Integer.valueOf(jSONObject.optInt("client_platform_id"));
        eVar.gameState = Integer.valueOf(jSONObject.optInt("game_state"));
        eVar.expired = Long.valueOf(jSONObject.optLong(Position.CLOSE_REASON_EXPIRED));
        eVar.expTime = Long.valueOf(jSONObject.optLong(Position.CLOSE_REASON_EXPIRED));
        eVar.sum = Double.valueOf(jSONObject.optDouble("sum"));
        eVar.expValue = Double.valueOf(((double) jSONObject.optLong("exp_value")) / 1000000.0d);
        eVar.profitAmount = Double.valueOf(jSONObject.optDouble("profit_amount"));
        eVar.created = Long.valueOf(jSONObject.optLong("created"));
        eVar.dir = jSONObject.optString("dir");
        eVar.value = Double.valueOf(jSONObject.optDouble(b.VALUE));
        eVar.win = jSONObject.optString("win");
        eVar.id = Long.valueOf(jSONObject.optLong("id"));
        eVar.type = jSONObject.optString("type_name");
        eVar.profitIncome = Double.valueOf(jSONObject.optDouble("profit_income"));
        eVar.profitReturn = Double.valueOf(jSONObject.optDouble("profit_return"));
        eVar.activeType = ActiveType.fromServerValue(jSONObject.optString("type_name"));
        eVar.userBalanceId = Long.valueOf(jSONObject.optLong("user_balance_id"));
        eVar.timeRecieved = Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d);
        return eVar;
    }

    public static ImmutableList<e> json2options(JSONArray jSONArray) {
        a sO = ImmutableList.sO();
        for (int i = 0; i < jSONArray.length(); i++) {
            sO.ae(json2option(jSONArray.getJSONObject(i)));
        }
        return sO.sP();
    }

    public static e betInfo2position(long j, com.iqoption.mobbtech.connect.response.a.b bVar) {
        com.iqoption.mobbtech.connect.response.a.a bG = bVar.bG(j);
        e eVar = new e();
        eVar.id = Long.valueOf(j);
        eVar.amount = Long.valueOf((long) (bG.cVw.doubleValue() * 1000000.0d));
        eVar.dir = bG.direction;
        eVar.expired = bVar.expired;
        eVar.profitAmount = bG.cVx;
        eVar.expValue = bVar.expValue;
        eVar.created = bG.created;
        eVar.win = bG.win;
        eVar.sum = bG.cVw;
        eVar.value = bG.value;
        eVar.clientPlatformId = bG.clientPlatformId;
        eVar.activeType = bG.activeType;
        eVar.timeRecieved = Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d);
        eVar.activeId = bVar.activeId;
        eVar.gameState = Integer.valueOf(1);
        if (bG.buybackState != null) {
            eVar.buybackState = bG.buybackState;
        }
        return eVar;
    }

    public static e history2position(JSONObject jSONObject) {
        e eVar = new e();
        eVar.type = jSONObject.optString(Param.TYPE).toLowerCase();
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(jSONObject.optString("active"), eVar.activeType.toInstrumentType());
        if (a != null) {
            eVar.activeId = Integer.valueOf(a.getActiveId());
        }
        eVar.amount = Long.valueOf(jSONObject.optLong("amount"));
        eVar.dir = jSONObject.optString("direction");
        eVar.expired = Long.valueOf(jSONObject.optLong(Position.CLOSE_REASON_EXPIRED));
        eVar.profitAmount = Double.valueOf(jSONObject.optDouble("win_amount"));
        eVar.expValue = Double.valueOf(jSONObject.optDouble("expired_value"));
        eVar.created = Long.valueOf(jSONObject.optLong("created"));
        eVar.win = jSONObject.optString("win_status");
        eVar.sum = Double.valueOf((double) jSONObject.optInt("enrolled_amount"));
        eVar.value = Double.valueOf(jSONObject.optDouble(b.VALUE));
        eVar.id = Long.valueOf(jSONObject.optLong("id"));
        eVar.clientPlatformId = Integer.valueOf(jSONObject.optInt("client_platform_id"));
        eVar.activeType = ActiveType.fromServerValue(jSONObject.optString(Param.TYPE));
        eVar.activeNameHistory = jSONObject.optString("active");
        eVar.userBalanceId = Long.valueOf(jSONObject.optLong("user_balance_id"));
        eVar.timeRecieved = Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d);
        return eVar;
    }

    public static e option2openoption(Option option, int i, long j, double d) {
        e eVar = new e();
        eVar.dir = option.getDirection();
        eVar.created = option.getCreated();
        eVar.value = option.getValue();
        eVar.sum = option.getAmount();
        eVar.activeId = Integer.valueOf(i);
        eVar.expired = Long.valueOf(j);
        String str = (eVar.dir.equals(NotificationCompat.CATEGORY_CALL) ? eVar.value.doubleValue() >= d : eVar.value.doubleValue() <= d) ? "loose" : "win";
        eVar.win = str;
        eVar.win = eVar.value.doubleValue() == d ? "equal" : eVar.win;
        eVar.profitAmount = Double.valueOf(0.0d);
        return eVar;
    }

    public int compareTo(e eVar) {
        return ORDERING.compare(this, eVar);
    }

    public Double getOptionCount() {
        return Double.valueOf(1.0d);
    }

    public Double getOptionOptPrice() {
        return this.sum;
    }

    public long getStableId() {
        return (long) f.hashCode(getId());
    }

    public double getSellPnl() {
        if (isClosed()) {
            return getWinAmount() - getInvestSum().doubleValue();
        }
        Double calculateBuybackAmountWithCancelable = calculateBuybackAmountWithCancelable(af.Hu().Hw());
        return calculateBuybackAmountWithCancelable != null ? calculateBuybackAmountWithCancelable.doubleValue() - getInvestSum().doubleValue() : 0.0d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.id);
        parcel.writeValue(this.userBalanceId);
        parcel.writeValue(this.userId);
        parcel.writeValue(this.activeId);
        parcel.writeValue(this.amount);
        parcel.writeValue(this.clientPlatformId);
        parcel.writeValue(this.created);
        parcel.writeString(this.currency);
        parcel.writeString(this.currencyChar);
        parcel.writeString(this.dir);
        parcel.writeValue(this.expTime);
        parcel.writeValue(this.expValue);
        parcel.writeValue(this.expired);
        parcel.writeValue(this.gameState);
        parcel.writeValue(this.isDemo);
        parcel.writeValue(this.looseAmount);
        parcel.writeValue(this.now);
        parcel.writeValue(this.optionTypeId);
        parcel.writeValue(this.profit);
        parcel.writeValue(this.profitIncome);
        parcel.writeValue(this.profitReturn);
        parcel.writeString(this.reTrack);
        parcel.writeValue(this.refund);
        parcel.writeValue(this.siteId);
        parcel.writeValue(this.sum);
        parcel.writeString(this.type);
        parcel.writeString(ActiveType.serverValue(this.activeType));
        parcel.writeValue(this.value);
        parcel.writeString(this.win);
        parcel.writeString(this.buybackState);
        parcel.writeValue(this.profitAmount);
        parcel.writeValue(this.timeRecieved);
        parcel.writeValue(this.currentProfitAmount);
    }

    protected e(Parcel parcel) {
        this.id = (Long) parcel.readValue(Long.class.getClassLoader());
        this.userBalanceId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.userId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.activeId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.amount = (Long) parcel.readValue(Long.class.getClassLoader());
        this.clientPlatformId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.created = (Long) parcel.readValue(Long.class.getClassLoader());
        this.currency = parcel.readString();
        this.currencyChar = parcel.readString();
        this.dir = parcel.readString();
        this.expTime = (Long) parcel.readValue(Long.class.getClassLoader());
        this.expValue = (Double) parcel.readValue(Double.class.getClassLoader());
        this.expired = (Long) parcel.readValue(Long.class.getClassLoader());
        this.gameState = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.isDemo = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.looseAmount = (Long) parcel.readValue(Long.class.getClassLoader());
        this.now = (Long) parcel.readValue(Long.class.getClassLoader());
        this.optionTypeId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.profit = (Long) parcel.readValue(Long.class.getClassLoader());
        this.profitIncome = (Double) parcel.readValue(Double.class.getClassLoader());
        this.profitReturn = (Double) parcel.readValue(Double.class.getClassLoader());
        this.reTrack = parcel.readString();
        this.refund = (Long) parcel.readValue(Long.class.getClassLoader());
        this.siteId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.sum = (Double) parcel.readValue(Double.class.getClassLoader());
        this.type = parcel.readString();
        this.activeType = ActiveType.fromServerValueNullable(parcel.readString());
        this.value = (Double) parcel.readValue(Double.class.getClassLoader());
        this.win = parcel.readString();
        this.buybackState = parcel.readString();
        this.profitAmount = (Double) parcel.readValue(Double.class.getClassLoader());
        this.timeRecieved = (Double) parcel.readValue(Double.class.getClassLoader());
        this.currentProfitAmount = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
