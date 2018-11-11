package com.iqoption.dto.entity;

import android.support.v4.app.NotificationCompat;
import android.support.v4.util.Pools.SynchronizedPool;
import com.google.common.base.e;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class Feature {
    private static final SynchronizedPool<Key> sPool = new SynchronizedPool(50);
    @SerializedName("category")
    public String category;
    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("params")
    public JsonElement params;
    @SerializedName("status")
    public String status;
    @SerializedName("version")
    public int version;

    public static class Key {
        public String name;
        public int version;

        public Key(String str, int i) {
            this.name = str;
            this.version = i;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            if (!(this.version == key.version && f.equal(this.name, key.name))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return f.hashCode(this.name, Integer.valueOf(this.version));
        }

        public void recycle() {
            Feature.sPool.release(this);
        }
    }

    public static class Result {
        @SerializedName("features")
        public Feature[] features;
        @SerializedName("identity")
        public String identity;
    }

    public static class UpdateEvent {
        public final ImmutableList<Feature> features;

        public UpdateEvent(ImmutableList<Feature> immutableList) {
            this.features = immutableList;
        }
    }

    public static Feature createDisabledFeature() {
        Feature feature = new Feature();
        feature.status = "disabled";
        return feature;
    }

    public static Feature createFeature(String str, String str2, int i) {
        Feature feature = new Feature();
        feature.name = str;
        feature.category = "android-x";
        feature.status = str2;
        feature.version = i;
        return feature;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Feature feature = (Feature) obj;
        if (!(this.id == feature.id && this.version == feature.version && f.equal(this.name, feature.name))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return f.hashCode(Long.valueOf(this.id), this.name, Integer.valueOf(this.version));
    }

    public String toString() {
        return e.B(this).e("id", this.id).d("name", this.name).d("category", this.category).d(NotificationCompat.CATEGORY_STATUS, this.status).n("version", this.version).toString();
    }

    public String toEventString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Feature{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", category='");
        stringBuilder.append(this.category);
        stringBuilder.append('\'');
        stringBuilder.append(", status='");
        stringBuilder.append(this.status);
        stringBuilder.append('\'');
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", params=");
        stringBuilder.append(this.params);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static Key obtain(String str, int i) {
        Key key = (Key) sPool.acquire();
        if (key == null) {
            return new Key(str, i);
        }
        key.name = str;
        key.version = i;
        return key;
    }
}
