package com.iqoption.microservice.quotes.history.response;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.dto.entity.position.Position;
import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.Set;

public class GetFirstCandlesDeserializer implements JsonDeserializer<c> {
    /* renamed from: e */
    public c deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Set<Entry> entrySet = jsonElement.getAsJsonObject().get("candles_by_size").getAsJsonObject().entrySet();
        int size = entrySet.size();
        c cVar = new c(size);
        int i = 0;
        for (Entry entry : entrySet) {
            if (i < size) {
                JsonObject asJsonObject = ((JsonElement) entry.getValue()).getAsJsonObject();
                cVar.cSD[i] = asJsonObject.get("id").getAsInt();
                cVar.cSB[i] = asJsonObject.get("from").getAsLong();
                cVar.cSC[i] = asJsonObject.get("to").getAsLong();
                cVar.cSE[i] = asJsonObject.get(Position.STATUS_OPEN).getAsDouble();
                cVar.cSF[i] = asJsonObject.get("close").getAsDouble();
                cVar.cSG[i] = asJsonObject.get("min").getAsDouble();
                cVar.cSH[i] = asJsonObject.get("max").getAsDouble();
                cVar.cSI[i] = asJsonObject.get("volume").getAsDouble();
            }
            i++;
        }
        return cVar;
    }
}
