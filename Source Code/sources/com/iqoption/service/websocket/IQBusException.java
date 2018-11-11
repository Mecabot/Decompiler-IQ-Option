package com.iqoption.service.websocket;

import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.iqoption.core.connect.m;
import com.iqoption.util.ah;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Locale;

public class IQBusException extends RuntimeException implements m {
    public final String socketMessage;
    public final int status;

    private static class a {
        @SerializedName("error")
        @Expose
        public String error = "";

        private a() {
        }
    }

    public int getCode() {
        return 0;
    }

    public IQBusException(int i, String str) {
        super(String.format(Locale.US, "IQBus error, status = %d, msg = %s", new Object[]{Integer.valueOf(i), str}));
        this.status = i;
        this.socketMessage = str;
    }

    @NonNull
    public String getMessage() {
        if (this.socketMessage != null) {
            try {
                JsonReader jsonReader = new JsonReader(new StringReader(this.socketMessage));
                jsonReader.setLenient(true);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.nextName().equals(NotificationCompat.CATEGORY_MESSAGE)) {
                        return ((a) ah.aGg().fromJson(jsonReader, (Type) a.class)).error;
                    }
                    jsonReader.skipValue();
                }
            } catch (IOException unused) {
                return "";
            }
        }
    }
}
