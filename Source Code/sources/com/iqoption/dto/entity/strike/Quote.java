package com.iqoption.dto.entity.strike;

import android.support.v4.util.Pools.SynchronizedPool;
import com.google.common.base.e;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import java.util.concurrent.TimeUnit;

public class Quote {
    private static final SynchronizedPool<Key> sPool = new SynchronizedPool(50);
    @SerializedName("ask_price")
    public Double askPrice;
    @SerializedName("bid_price")
    public Double bidPrice;
    @SerializedName("instrument_id")
    public String instrumentId;
    @SerializedName("instrument_type")
    public InstrumentType instrumentType;
    public volatile long lastTimeUpdate;

    public static class Key {
        public String instrumentId;
        public InstrumentType instrumentType;

        public Key(String str, InstrumentType instrumentType) {
            this.instrumentId = str;
            this.instrumentType = instrumentType;
        }

        /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (com.google.common.base.f.equal(r2.instrumentType, r3.instrumentType) != false) goto L_0x001f;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r3 == r2) goto L_0x001f;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.dto.entity.strike.Quote.Key;
            if (r0 == 0) goto L_0x001d;
        L_0x0006:
            r0 = r2.instrumentId;
            r3 = (com.iqoption.dto.entity.strike.Quote.Key) r3;
            r1 = r3.instrumentId;
            r0 = com.google.common.base.f.equal(r0, r1);
            if (r0 == 0) goto L_0x001d;
        L_0x0012:
            r0 = r2.instrumentType;
            r3 = r3.instrumentType;
            r3 = com.google.common.base.f.equal(r0, r3);
            if (r3 == 0) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r3 = 0;
            goto L_0x0020;
        L_0x001f:
            r3 = 1;
        L_0x0020:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dto.entity.strike.Quote.Key.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return f.hashCode(this.instrumentId, this.instrumentType);
        }

        public void recycle() {
            Quote.sPool.release(this);
        }
    }

    public Quote(String str, InstrumentType instrumentType, Double d, Double d2) {
        this.instrumentId = str;
        this.instrumentType = instrumentType;
        this.askPrice = d;
        this.bidPrice = d2;
    }

    public double getProfit(double d) {
        return d + ((getProfitPercentDouble() / 100.0d) * d);
    }

    private double getProfitPercentDouble() {
        return ((100.0d - this.askPrice.doubleValue()) * 100.0d) / this.askPrice.doubleValue();
    }

    public int getProfitPercent() {
        return (int) Math.round(getProfitPercentDouble());
    }

    public synchronized boolean isExpired() {
        return System.currentTimeMillis() - this.lastTimeUpdate > TimeUnit.MINUTES.toMillis(10);
    }

    public static Key obtain(String str, InstrumentType instrumentType) {
        Key key = (Key) sPool.acquire();
        if (key == null) {
            return new Key(str, instrumentType);
        }
        key.instrumentId = str;
        key.instrumentType = instrumentType;
        return key;
    }

    public static double selfAskPrice(Quote quote) {
        return quote == null ? 0.0d : ((Double) e.h(quote.askPrice, Double.valueOf(0.0d))).doubleValue();
    }

    public static double selfBidPrice(Quote quote) {
        return quote == null ? 0.0d : ((Double) e.h(quote.bidPrice, Double.valueOf(0.0d))).doubleValue();
    }

    public static boolean isQuoteAvailable(Quote quote) {
        return (quote == null || quote.askPrice == null || quote.getProfitPercent() <= 0) ? false : true;
    }

    public static ImmutableList<Quote> parseQuotesGenerated(JsonObject jsonObject) {
        InstrumentType fromServerValue = InstrumentType.fromServerValue(i.i(jsonObject.get("kind")));
        JsonArray asJsonArray = jsonObject.getAsJsonArray("quotes");
        if (asJsonArray == null || asJsonArray.size() <= 0) {
            return null;
        }
        a sO = ImmutableList.sO();
        int size = asJsonArray.size();
        for (int i = 0; i < size; i++) {
            JsonObject asJsonObject = asJsonArray.get(i).getAsJsonObject();
            if (asJsonObject != null) {
                JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("price");
                JsonArray asJsonArray2 = asJsonObject.getAsJsonArray("symbols");
                if (!(asJsonObject2 == null || asJsonArray2 == null || asJsonArray2.size() <= 0)) {
                    int size2 = asJsonArray2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        sO.ae(new Quote(i.i(asJsonArray2.get(i2)), fromServerValue, i.c(asJsonObject2.get("ask")), i.c(asJsonObject2.get("bid"))));
                    }
                }
            }
        }
        return sO.sP();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Quote{instrumentId='");
        stringBuilder.append(this.instrumentId);
        stringBuilder.append('\'');
        stringBuilder.append(", instrumentType=");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append(", bidPrice=");
        stringBuilder.append(this.bidPrice);
        stringBuilder.append(", askPrice=");
        stringBuilder.append(this.askPrice);
        stringBuilder.append(", lastTimeUpdate=");
        stringBuilder.append(this.lastTimeUpdate);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
