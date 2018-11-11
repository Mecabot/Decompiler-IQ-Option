package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.util.VersionUtils;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            return typeToken.getRawType() == Date.class ? new DateTypeAdapter() : null;
        }
    };
    private final List<DateFormat> dateFormats = new ArrayList();

    public DateTypeAdapter() {
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (VersionUtils.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return deserializeToDate(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for R(7:5|6|7|22|8|9|3) */
    /* JADX WARNING: Missing block: B:4:0x000b, code:
            if (r0.hasNext() != false) goto L_0x000d;
     */
    /* JADX WARNING: Missing block: B:9:0x0018, code:
            return ((java.text.DateFormat) r0.next()).parse(r3);
     */
    /* JADX WARNING: Missing block: B:13:0x0024, code:
            return com.google.gson.internal.bind.util.ISO8601Utils.parse(r3, new java.text.ParsePosition(0));
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:17:0x002b, code:
            throw new com.google.gson.JsonSyntaxException(r3, r0);
     */
    private synchronized java.util.Date deserializeToDate(java.lang.String r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.dateFormats;	 Catch:{ all -> 0x002c }
        r0 = r0.iterator();	 Catch:{ all -> 0x002c }
    L_0x0007:
        r1 = r0.hasNext();	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x0019;
    L_0x000d:
        r1 = r0.next();	 Catch:{ all -> 0x002c }
        r1 = (java.text.DateFormat) r1;	 Catch:{ all -> 0x002c }
        r1 = r1.parse(r3);	 Catch:{ ParseException -> 0x0007 }
        monitor-exit(r2);
        return r1;
    L_0x0019:
        r0 = new java.text.ParsePosition;	 Catch:{ ParseException -> 0x0025 }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ ParseException -> 0x0025 }
        r0 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r3, r0);	 Catch:{ ParseException -> 0x0025 }
        monitor-exit(r2);
        return r0;
    L_0x0025:
        r0 = move-exception;
        r1 = new com.google.gson.JsonSyntaxException;	 Catch:{ all -> 0x002c }
        r1.<init>(r3, r0);	 Catch:{ all -> 0x002c }
        throw r1;	 Catch:{ all -> 0x002c }
    L_0x002c:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.DateTypeAdapter.deserializeToDate(java.lang.String):java.util.Date");
    }

    public synchronized void write(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(((DateFormat) this.dateFormats.get(0)).format(date));
        }
    }
}
