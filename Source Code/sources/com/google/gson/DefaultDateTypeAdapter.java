package com.google.gson;

import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.util.VersionUtils;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final Class<? extends Date> dateType;

    DefaultDateTypeAdapter(Class<? extends Date> cls) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (VersionUtils.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(str));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, int i) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateInstance(i, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(i));
        }
        if (VersionUtils.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(i));
        }
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(Date.class, i, i2);
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (VersionUtils.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }

    private static Class<? extends Date> verifyDateType(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Date type must be one of ");
        stringBuilder.append(Date.class);
        stringBuilder.append(", ");
        stringBuilder.append(Timestamp.class);
        stringBuilder.append(", or ");
        stringBuilder.append(java.sql.Date.class);
        stringBuilder.append(" but was ");
        stringBuilder.append(cls);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void write(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            jsonWriter.value(((DateFormat) this.dateFormats.get(0)).format(date));
        }
    }

    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Date deserializeToDate = deserializeToDate(jsonReader.nextString());
        if (this.dateType == Date.class) {
            return deserializeToDate;
        }
        if (this.dateType == Timestamp.class) {
            return new Timestamp(deserializeToDate.getTime());
        }
        if (this.dateType == java.sql.Date.class) {
            return new java.sql.Date(deserializeToDate.getTime());
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Can't wrap try/catch for R(7:6|7|8|9|10|11|4) */
    /* JADX WARNING: Missing block: B:5:0x000d, code:
            if (r1.hasNext() != false) goto L_0x000f;
     */
    /* JADX WARNING: Missing block: B:11:0x001a, code:
            return ((java.text.DateFormat) r1.next()).parse(r4);
     */
    /* JADX WARNING: Missing block: B:16:0x0026, code:
            return com.google.gson.internal.bind.util.ISO8601Utils.parse(r4, new java.text.ParsePosition(0));
     */
    /* JADX WARNING: Missing block: B:17:0x0027, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:19:0x002d, code:
            throw new com.google.gson.JsonSyntaxException(r4, r1);
     */
    private java.util.Date deserializeToDate(java.lang.String r4) {
        /*
        r3 = this;
        r0 = r3.dateFormats;
        monitor-enter(r0);
        r1 = r3.dateFormats;	 Catch:{ all -> 0x002e }
        r1 = r1.iterator();	 Catch:{ all -> 0x002e }
    L_0x0009:
        r2 = r1.hasNext();	 Catch:{ all -> 0x002e }
        if (r2 == 0) goto L_0x001b;
    L_0x000f:
        r2 = r1.next();	 Catch:{ all -> 0x002e }
        r2 = (java.text.DateFormat) r2;	 Catch:{ all -> 0x002e }
        r2 = r2.parse(r4);	 Catch:{ ParseException -> 0x0009 }
        monitor-exit(r0);	 Catch:{ all -> 0x002e }
        return r2;
    L_0x001b:
        r1 = new java.text.ParsePosition;	 Catch:{ ParseException -> 0x0027 }
        r2 = 0;
        r1.<init>(r2);	 Catch:{ ParseException -> 0x0027 }
        r1 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r4, r1);	 Catch:{ ParseException -> 0x0027 }
        monitor-exit(r0);	 Catch:{ all -> 0x002e }
        return r1;
    L_0x0027:
        r1 = move-exception;
        r2 = new com.google.gson.JsonSyntaxException;	 Catch:{ all -> 0x002e }
        r2.<init>(r4, r1);	 Catch:{ all -> 0x002e }
        throw r2;	 Catch:{ all -> 0x002e }
    L_0x002e:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002e }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.DefaultDateTypeAdapter.deserializeToDate(java.lang.String):java.util.Date");
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.dateFormats.get(0);
        StringBuilder stringBuilder;
        if (dateFormat instanceof SimpleDateFormat) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("DefaultDateTypeAdapter(");
            stringBuilder.append(((SimpleDateFormat) dateFormat).toPattern());
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("DefaultDateTypeAdapter(");
        stringBuilder.append(dateFormat.getClass().getSimpleName());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
