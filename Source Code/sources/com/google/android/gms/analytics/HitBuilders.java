package com.google.android.gms.analytics;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzatc;
import com.google.android.gms.internal.zzatt;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    public static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> zzduq = new HashMap();
        private ProductAction zzdur;
        private Map<String, List<Product>> zzdus = new HashMap();
        private List<Promotion> zzdut = new ArrayList();
        private List<Product> zzduu = new ArrayList();

        protected HitBuilder() {
        }

        private final T zzh(String str, String str2) {
            if (str2 != null) {
                this.zzduq.put(str, str2);
            }
            return this;
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzatc.zzcz("product should be non-null");
                return this;
            }
            Object str2;
            if (str2 == null) {
                str2 = "";
            }
            if (!this.zzdus.containsKey(str2)) {
                this.zzdus.put(str2, new ArrayList());
            }
            ((List) this.zzdus.get(str2)).add(product);
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzatc.zzcz("product should be non-null");
                return this;
            }
            this.zzduu.add(product);
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzatc.zzcz("promotion should be non-null");
                return this;
            }
            this.zzdut.add(promotion);
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.zzduq);
            if (this.zzdur != null) {
                hashMap.putAll(this.zzdur.build());
            }
            int i = 1;
            for (Promotion zzdx : this.zzdut) {
                hashMap.putAll(zzdx.zzdx(zzd.zzao(i)));
                i++;
            }
            i = 1;
            for (Product zzdx2 : this.zzduu) {
                hashMap.putAll(zzdx2.zzdx(zzd.zzam(i)));
                i++;
            }
            i = 1;
            for (Entry entry : this.zzdus.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzar = zzd.zzar(i);
                int i2 = 1;
                for (Product product : list) {
                    String valueOf = String.valueOf(zzar);
                    String valueOf2 = String.valueOf(zzd.zzaq(i2));
                    hashMap.putAll(product.zzdx(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i2++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    String valueOf3 = String.valueOf(zzar);
                    zzar = String.valueOf("nm");
                    hashMap.put(zzar.length() != 0 ? valueOf3.concat(zzar) : new String(valueOf3), (String) entry.getKey());
                }
                i++;
            }
            return hashMap;
        }

        protected String get(String str) {
            return (String) this.zzduq.get(str);
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.zzduq.put(str, str2);
                return this;
            }
            zzatc.zzcz("HitBuilder.set() called with a null paramName.");
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.zzduq.putAll(new HashMap(map));
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            Object zzep = zzatt.zzep(str);
            if (TextUtils.isEmpty(zzep)) {
                return this;
            }
            Map zzen = zzatt.zzen(zzep);
            zzh("&cc", (String) zzen.get("utm_content"));
            zzh("&cm", (String) zzen.get("utm_medium"));
            zzh("&cn", (String) zzen.get("utm_campaign"));
            zzh("&cs", (String) zzen.get("utm_source"));
            zzh("&ck", (String) zzen.get("utm_term"));
            zzh("&ci", (String) zzen.get("utm_id"));
            zzh("&anid", (String) zzen.get("anid"));
            zzh("&gclid", (String) zzen.get("gclid"));
            zzh("&dclid", (String) zzen.get("dclid"));
            zzh("&aclid", (String) zzen.get(b.ACLID));
            zzh("&gmob_t", (String) zzen.get("gmob_t"));
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzd.zzai(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzd.zzak(i), Float.toString(f));
            return this;
        }

        protected T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zzatt.zzao(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zzdur = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.zzduq.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", "event");
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zzatt.zzao(z));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", NotificationCompat.CATEGORY_SOCIAL);
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
