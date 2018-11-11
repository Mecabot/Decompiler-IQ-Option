package com.iqoption.dto.entity.iqbus;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.core.util.p;
import com.iqoption.util.ah;
import com.iqoption.util.bb;

public class NetverifyConfig implements Parcelable {
    public static final Creator<NetverifyConfig> CREATOR = new Creator<NetverifyConfig>() {
        public NetverifyConfig createFromParcel(Parcel parcel) {
            return new NetverifyConfig(parcel);
        }

        public NetverifyConfig[] newArray(int i) {
            return new NetverifyConfig[i];
        }
    };
    private static final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDOpv11Zf9p4RYm\nn6m+2EelndfXDFRNsnYEVIa0EbalmWw1YA9ibgj5uhixo0vC5MSYvwSL7kfhjnpT\nD1S2W/cW22I+U0bk7NF2Kkyj8wtktx/GvmWqpv9ffVSaBD2H4MENH2zdfN6ay4ec\nDD077KiJJB0Z/hDJzDrmaHXpaGdMb0AIB34U2dm8/i//Hytw4t4guSYYDgbhSFin\nStHwt3CbKFQBsu0b4HxC+m9ZaVK11ZMuxlyibu++toUqTxEz9okDnsd4XgDWmQC3\nwMKXpjfasAPrJ4eRWApQQaVqrMNR+eKW4+KZxPF/O7CPxeE2WfZE3w6y6rBLdQFJ\n/4eoBZmzAgMBAAECggEBAIpKY9k5bagcMeec90o4kBG7xGIr5Qqtv558NjywkerV\n9fzuEL2M50K/D6Fopt2AnDOfuNovljjSUPfejZEPkBXisCcHMa0m8bFC81DP57L5\nfTFR3tVJtiHfzErZRZf1hxtSCVdbJdivFUwPQLcmU06bNUJcrD1vB4eDJk0RSfdy\nU6tavGnonHlUD7ZbPpFT8XOAP7yL6hNRiuXdaKTbIjObOlubhCePYwn9HzLvlpgg\nd4OdBvMEcomIDUXw/9mH1Ayz1eh6ls8pyZbZSmdeyRAF3GAbxSLc8A9IbtMpj4sn\ncQ3ZxRVjsT0I7Gg01MMbKq6kxzZ+6p+zG6Mr7dYxz+ECgYEA6BP+dlt3768PJWld\njJOxyI+Jx8YqeF+zZSFaE3Lz7HBEPWzeYgPruda1E4rBuvMJ4Fpnva4oI4MPOUY8\nMyo6pcUbeKyKVvjTBvHGhvoXeseuyqy7ANWich8h8czsdnBPbbRCtEqL+rDX8vhM\ngeA/F751FhuahllPJ2sKsCsrE+MCgYEA4/QRY+yOgIZf2xLvL5HNSyfKiTxejbME\n16X/CssAkpM9Pr3vq4M+4ciklzYsBeXh6Tg9eWpLriSC95c+VnwM9N0LeSwOIfMc\nSQbIQPJey6aWASSlbmf4GP5DCIUcPLhYQDEMBMh0pTLVmnUFl7k+WsIel0W/9k6N\nMiUBOOi4a/ECgYB2NUDmPj6/ybX4Q0vP/6aNVndCVzBosa4pc6xyvZl6s9A+TUaU\nPBUESlVfB80XkRVVvhabKaruM6I8dQbStM68gsI0XAX2uLScE+gf9iChfDYOq55w\nlWAxqqPaipti1F/QrAFR3aqg3RSRgGFPwc3BJVR0F0lE5xaHKGGAS+ycKwKBgQC0\nn/7vqNA580AdPWGd1fBQLxWDrPxXV5Tss7HmAXlQq68J+kLhKrw2+F/DGb/EZKWf\nwVqkzJ9vO6szOPrCWMWDeWvP9iK0sAinrOIc5HBM+pE+EqWrWGL0mvTO2XrIemIj\naznUyGn1RNSQ8U0fLj/EdrD6uOAk8ZVcOIpBZ9ZKYQKBgEbke+9SQ9s2QEzRGoxc\nTWamO3U6MA2w2Q+w2nlBVBSPREiJ8BrLYJHmqhTAW36HgX83cGmVm0tEYXmnfjRU\nDyFYcCV74tzE21NkJYy5ioZCzzP2vlk37WHgUTsWHWmJTLMP3YILpgIk4+Zv5Xee\nxUe0xIZavLpuwDck9GeRX6Rl";
    private static final String PRIVATE_KEY_DEBUG = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDk4yaOyBvpENj6\n64E2+ihWyTT92YmeKVhA/miExUB91YuOkqr+HaJHTvrpKKp6sRY+O6ddkpkI7ybW\n7U5UIVKhiN+r6O3MtV6GrlUAlcoJqOFUnseNtWydWK7A/DCXX49F/Iq2JDvMPrI+\nK89PGTqw+40+jdrwncog0iv2AHEioZRchwD3KwG47iPOT0Hd7zbWfSceWd2mvSGo\nvSLcQ/M9DO0EVkRt39+A0TlsOrfNfw+VqBRJPFzDu/oZEEqLfcj+0rjIcizcAycK\n3tWCLdV1vqhJMzKbSPdzm0RycrFbcPZzuLb10DK3gajRNlGAW1PBooDYKYC/JswE\nYU+K8mPjAgMBAAECggEBAKGNVpy2z0RcuNm6OfTE8o327Gk0DvdMdVdCeiEkXJW0\nkRErondEEVNFgsHpCxMYRPvd/Q6Ft3Bf5EkVLBEjiAAt7LmY6adwaGylRafpEbZp\ntcmVXIJACI6yln3uQpnFQAoE6x8OSgqqQgKxx1wsEYnzs0jwtRTaOl2aGp9CxpfK\noFW+EJl7wjzRb0R7W/slBPm1v6fWUhea3RwfDYHeRMN82TWx6LuFkVgQ5yHgxHNf\n5mCuRQCEKIDsVhdQ/eLwRwlqMYQUfjlKCfKMjS0MDIIbgkRHqrtph4ipPnu4C2i0\n6D9H4q2QaRSFBUq98hAGaq8J0N3ycZUSk6+BFaiQS1ECgYEA+mtnIpIGxsqzKAzo\nm7dkmPkjuzBU5sgRXR9dG+xw/nFgsq2BMvY1DmV33tljMQ6KDw6/szYLqm5KGpFQ\nUca+AvdQmPAdQs5zwWbytyGXf2TN8j53KB5kwrqGgECGqXmQ7cBj4hbnls5xxHf8\n6IA7iYwYpCmCmW3vt9cUcV7bTAkCgYEA6fzpC0lJEWolJ9pscN0RcUr8OkArrsOM\nMMsIegA2XBsNp8QOeR9ZaeCq4kxE40XnRdisY6ChHscjA888Z13IWKgeLOS2PR5S\nc7jLga5xR++t1o6eAZrY3dEcvZIWq/4Cfw5TV9C1BptEEgTUl8sKxbDNGUdQWCAh\nbhNcvq8cA4sCgYBTkO/T24MjZ5UtslEVVbfeTJWd690JPo580vCRVu/GGTO5rKjG\nxt6htT6xQT4WqtFrgPJ77XcrIq7b+s4g2/+gocNlpgs9tgNu8NniPvV9b7hCNJIy\n8yGQ0gn8VowZlhXFIUSzuA0EiFPyyk+9jr1Pg07dyXRpmwQ6By4tPwhTcQKBgCLh\nyzQdhsEL2+InE8d3jWQgU52zd0+kYz/a5LabVX9BoTWDaszvuXqpPZBi4lonT6T/\n+iMYDSzzburgeBbIylc9KNJ0fh56aLxLrjr08HpS5s13kWKX3QCkbe5s2uhlA6ZB\nUndi67nCZ9Fv2umOIVr7UngUQ4v/rjwksszSehClAoGAFE2b3xtkyjnnQuYjU8Xz\nWJ/uWVskoCSg1ewwDZGczCW3Sn/hRsvO68Bc7MQKj2GXnXiA99T/E/YE763GdnN0\nV5Zi1/B1RiluqPp+tnjb9hC6gKn21d99Jzh9Rvq2+5lQFxK36Z5N4RKMKn2QlYpK\n3HPcXBouSKXAHvorIZ+2T+g=";
    private static final String TAG = "com.iqoption.dto.entity.iqbus.NetverifyConfig";
    @SerializedName("config")
    public String config;

    public static class NetverifyConfigData {
        @SerializedName("callback")
        public String callback;
        @SerializedName("secret")
        public String secret;
        @SerializedName("token")
        public String token;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NetverifyConfig{token='");
            stringBuilder.append(this.token);
            stringBuilder.append('\'');
            stringBuilder.append(", secret='");
            stringBuilder.append(this.secret);
            stringBuilder.append('\'');
            stringBuilder.append(", callback='");
            stringBuilder.append(this.callback);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        @Nullable
        public static NetverifyConfigData fromJson(String str) {
            try {
                return (NetverifyConfigData) ah.aGg().fromJson(str, NetverifyConfigData.class);
            } catch (Throwable e) {
                String access$000 = NetverifyConfig.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unable to create from json string ");
                stringBuilder.append(str);
                i.e(access$000, stringBuilder.toString(), e);
                return null;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public static NetverifyConfig fromJson(String str) {
        try {
            return (NetverifyConfig) ah.aGg().fromJson(str, NetverifyConfig.class);
        } catch (Throwable e) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unable to create from json string ");
            stringBuilder.append(str);
            i.e(str2, stringBuilder.toString(), e);
            return null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetverifyConfig{config='");
        stringBuilder.append(this.config);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Nullable
    public NetverifyConfigData decrypt() {
        Object aC = bb.aC(this.config, IQApp.Dl().arV() ? PRIVATE_KEY : PRIVATE_KEY_DEBUG);
        if (TextUtils.isEmpty(aC)) {
            return null;
        }
        aC = p.ae(aC, "{\"token\"");
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("configJson: ");
        stringBuilder.append(aC);
        i.v(str, stringBuilder.toString());
        if (TextUtils.isEmpty(aC)) {
            return null;
        }
        return NetverifyConfigData.fromJson(aC);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.config);
    }

    protected NetverifyConfig(Parcel parcel) {
        this.config = parcel.readString();
    }
}
