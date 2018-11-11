package com.iqoption.fragment.cashbox;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.app.managers.feature.b;
import com.iqoption.dto.entity.Feature;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, aXE = {"<anonymous>", "", "invoke", "()Ljava/lang/Double;"})
/* compiled from: DepositFeatureUtils.kt */
final class DepositFeatureUtils$minDepositFeatureLimitUsd$2 extends Lambda implements a<Double> {
    public static final DepositFeatureUtils$minDepositFeatureLimitUsd$2 cwC = new DepositFeatureUtils$minDepositFeatureLimitUsd$2();

    DepositFeatureUtils$minDepositFeatureLimitUsd$2() {
        super(0);
    }

    /* renamed from: Ji */
    public final Double invoke() {
        Feature fd = b.HT().fd("analytics-presets");
        Double d = null;
        String str = fd != null ? fd.status : null;
        if (str == null || h.E(str, "disabled")) {
            return null;
        }
        JsonElement jsonElement = fd.params;
        if (jsonElement != null) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject != null) {
                jsonElement = asJsonObject.get(str);
                if (jsonElement != null) {
                    d = Double.valueOf(jsonElement.getAsDouble());
                }
            }
        }
        return d;
    }
}
