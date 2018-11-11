package com.iqoption.util;

import com.google.common.base.n;
import com.google.gson.GsonBuilder;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamPropertyDeserializer;
import com.iqoption.core.util.KotlinGsonAdapterFactory;
import com.iqoption.microservice.quotes.history.response.GetFirstCandlesDeserializer;
import com.iqoption.microservice.quotes.history.response.c;
import com.iqoption.microservice.vip.VipManagerDeserializer;
import com.iqoption.microservice.vip.d;
import com.iqoption.mobbtech.connect.response.ArrayBuybackResponse;
import com.iqoption.mobbtech.connect.response.ArrayBuybackResponse.BuybackResponseDeserializer;
import com.iqoption.mobbtech.connect.response.PayResponseDeserializer;
import com.iqoption.mobbtech.connect.response.ProfileSaveDataResponseDeserializer;
import com.iqoption.mobbtech.connect.response.i;
import com.iqoption.mobbtech.connect.response.j;
import com.iqoption.mobbtech.connect.response.options.OpenOptionGroupDeserializer;
import com.iqoption.mobbtech.connect.response.options.OpenOptionGroupSerializer;
import com.iqoption.mobbtech.connect.response.options.OptionDeserializer;
import com.iqoption.mobbtech.connect.response.options.b;
import com.iqoption.mobbtech.connect.response.options.e;

final /* synthetic */ class ak implements n {
    static final n ajD = new ak();

    private ak() {
    }

    public Object get() {
        return new GsonBuilder().registerTypeAdapterFactory(new KotlinGsonAdapterFactory()).registerTypeAdapter(ArrayBuybackResponse.class, new BuybackResponseDeserializer()).registerTypeAdapter(ExtraParamProperty.class, new ExtraParamPropertyDeserializer()).registerTypeAdapter(i.class, new PayResponseDeserializer()).registerTypeAdapter(j.class, new ProfileSaveDataResponseDeserializer()).registerTypeAdapter(e.class, new OptionDeserializer()).registerTypeAdapter(b.class, new OpenOptionGroupSerializer()).registerTypeAdapter(b.class, new OpenOptionGroupDeserializer()).registerTypeAdapter(c.class, new GetFirstCandlesDeserializer()).registerTypeAdapter(d.class, new VipManagerDeserializer()).create();
    }
}
