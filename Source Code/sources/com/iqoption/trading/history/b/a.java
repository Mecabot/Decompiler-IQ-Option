package com.iqoption.trading.history.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.position.Position;

/* compiled from: HistoryPosition */
public class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        /* renamed from: Y */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: gz */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    @SerializedName("active_id")
    private Integer activeId;
    @SerializedName("buy_avg_price")
    private Double buyAvgPrice;
    @SerializedName("close_reason")
    private String closeReason;
    @SerializedName("commission")
    private Double commission;
    @SerializedName("count")
    private Double count;
    @SerializedName("count_realized")
    private Double countRealized;
    @SerializedName("direction")
    private String direction;
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
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("swap")
    private Double swap;
    @SerializedName("type")
    private String type;

    public int describeContents() {
        return 0;
    }

    public Integer aEM() {
        return this.leverage;
    }

    public Double getCommission() {
        return this.commission;
    }

    public Double getSwap() {
        return this.swap;
    }

    public Double getCountRealized() {
        return this.countRealized;
    }

    public Double getCount() {
        return this.count;
    }

    public Double aEN() {
        return this.buyAvgPrice;
    }

    public InstrumentType getInstrumentType() {
        if (this.instrumentType != null && this.instrumentType != InstrumentType.UNKNOWN) {
            return this.instrumentType;
        }
        InstrumentType fromServerValue = InstrumentType.fromServerValue(this.optionType);
        if (fromServerValue != InstrumentType.UNKNOWN) {
            return fromServerValue;
        }
        return ActiveType.fromServerValue(this.optionType).toInstrumentType();
    }

    public boolean isCall() {
        switch (getInstrumentType()) {
            case BINARY_INSTRUMENT:
            case TURBO_INSTRUMENT:
                return NotificationCompat.CATEGORY_CALL.equalsIgnoreCase(this.direction);
            case DIGITAL_INSTRUMENT:
                return NotificationCompat.CATEGORY_CALL.equalsIgnoreCase(this.instrumentDir);
            case CRYPTO_INSTRUMENT:
            case FOREX_INSTRUMENT:
            case CFD_INSTRUMENT:
                return Position.TYPE_LONG.equalsIgnoreCase(this.type);
            default:
                return true;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HistoryPosition{activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", type='");
        stringBuilder.append(this.type);
        stringBuilder.append('\'');
        stringBuilder.append(", instrumentUderlying='");
        stringBuilder.append(this.instrumentUderlying);
        stringBuilder.append('\'');
        stringBuilder.append(", instrumentActiveId=");
        stringBuilder.append(this.instrumentActiveId);
        stringBuilder.append(", instrumentExpiration=");
        stringBuilder.append(this.instrumentExpiration);
        stringBuilder.append(", direction='");
        stringBuilder.append(this.direction);
        stringBuilder.append('\'');
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
        stringBuilder.append(", optionType='");
        stringBuilder.append(this.optionType);
        stringBuilder.append('\'');
        stringBuilder.append(", instrumentId='");
        stringBuilder.append(this.instrumentId);
        stringBuilder.append('\'');
        stringBuilder.append(", commission=");
        stringBuilder.append(this.commission);
        stringBuilder.append(", closeReason='");
        stringBuilder.append(this.closeReason);
        stringBuilder.append('\'');
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", countRealized=");
        stringBuilder.append(this.countRealized);
        stringBuilder.append(", leverage=");
        stringBuilder.append(this.leverage);
        stringBuilder.append(", swap=");
        stringBuilder.append(this.swap);
        stringBuilder.append(", margin=");
        stringBuilder.append(this.margin);
        stringBuilder.append(", marginCall=");
        stringBuilder.append(this.marginCall);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.activeId);
        parcel.writeString(this.type);
        parcel.writeString(this.instrumentUderlying);
        parcel.writeValue(this.instrumentActiveId);
        parcel.writeValue(this.instrumentExpiration);
        parcel.writeString(this.direction);
        parcel.writeString(this.instrumentDir);
        parcel.writeValue(this.instrumentStrike);
        parcel.writeValue(this.instrumentStrikeValue);
        parcel.writeString(InstrumentType.serverValue(this.instrumentType));
        parcel.writeString(this.optionType);
        parcel.writeString(this.instrumentId);
        parcel.writeValue(this.commission);
        parcel.writeString(this.closeReason);
        parcel.writeValue(this.count);
        parcel.writeValue(this.countRealized);
        parcel.writeValue(this.leverage);
        parcel.writeValue(this.swap);
        parcel.writeValue(this.margin);
        parcel.writeValue(this.marginCall);
    }

    protected a(Parcel parcel) {
        this.activeId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.type = parcel.readString();
        this.instrumentUderlying = parcel.readString();
        this.instrumentActiveId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.instrumentExpiration = (Long) parcel.readValue(Long.class.getClassLoader());
        this.direction = parcel.readString();
        this.instrumentDir = parcel.readString();
        this.instrumentStrike = (Double) parcel.readValue(Double.class.getClassLoader());
        this.instrumentStrikeValue = (Long) parcel.readValue(Long.class.getClassLoader());
        this.instrumentType = InstrumentType.fromServerValueNullable(parcel.readString());
        this.optionType = parcel.readString();
        this.instrumentId = parcel.readString();
        this.commission = (Double) parcel.readValue(Double.class.getClassLoader());
        this.closeReason = parcel.readString();
        this.count = (Double) parcel.readValue(Double.class.getClassLoader());
        this.countRealized = (Double) parcel.readValue(Double.class.getClassLoader());
        this.leverage = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.swap = (Double) parcel.readValue(Double.class.getClassLoader());
        this.margin = (Double) parcel.readValue(Double.class.getClassLoader());
        this.marginCall = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
