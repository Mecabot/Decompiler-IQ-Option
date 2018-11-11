package com.iqoption.mobbtech.connect.response;

import com.google.common.base.e;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.iqoption.core.i;
import com.iqoption.dto.entity.result.BuybackResult;
import com.iqoption.x.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayBuybackResponse {
    public ArrayList<a> cVt;
    public List<Long> cVu;

    public static class Map extends HashMap<Long, BuybackResult> {
    }

    public static class BuybackResponseDeserializer implements JsonDeserializer<ArrayBuybackResponse> {
        private static final String TAG = "com.iqoption.mobbtech.connect.response.ArrayBuybackResponse$BuybackResponseDeserializer";

        /* renamed from: j */
        public ArrayBuybackResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            ArrayBuybackResponse arrayBuybackResponse = new ArrayBuybackResponse();
            Gson create = new GsonBuilder().create();
            Set<Entry> entrySet = jsonElement.getAsJsonObject().entrySet();
            if (entrySet == null) {
                return null;
            }
            for (Entry value : entrySet) {
                Object obj;
                try {
                    obj = (a) create.fromJson((JsonElement) value.getValue(), a.class);
                } catch (Exception e) {
                    i.e(TAG, e.toString());
                    obj = null;
                }
                if (arrayBuybackResponse.cVt == null) {
                    arrayBuybackResponse.cVt = new ArrayList();
                }
                if (obj != null) {
                    arrayBuybackResponse.cVt.add(obj);
                }
            }
            return arrayBuybackResponse;
        }
    }

    public static class a extends m {
    }

    public static final ArrayBuybackResponse auO() {
        ArrayBuybackResponse arrayBuybackResponse = new ArrayBuybackResponse();
        arrayBuybackResponse.cVt = null;
        arrayBuybackResponse.cVu = new ArrayList();
        return arrayBuybackResponse;
    }

    public String toString() {
        return e.B(this).d("super", super.toString()).n("result", R.id.result).toString();
    }
}
