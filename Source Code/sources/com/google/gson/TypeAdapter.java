package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T> {
    public abstract T read(JsonReader jsonReader);

    public abstract void write(JsonWriter jsonWriter, T t);

    public final void toJson(Writer writer, T t) {
        write(new JsonWriter(writer), t);
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() {
            public void write(JsonWriter jsonWriter, T t) {
                if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t);
                }
            }

            public T read(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return TypeAdapter.this.read(jsonReader);
                }
                jsonReader.nextNull();
                return null;
            }
        };
    }

    public final String toJson(T t) {
        Writer stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final JsonElement toJsonTree(T t) {
        try {
            JsonWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t);
            return jsonTreeWriter.get();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public final T fromJson(Reader reader) {
        return read(new JsonReader(reader));
    }

    public final T fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new JsonTreeReader(jsonElement));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }
}
