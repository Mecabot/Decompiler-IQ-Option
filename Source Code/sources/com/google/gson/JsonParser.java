package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public JsonElement parse(String str) {
        return parse(new StringReader(str));
    }

    public JsonElement parse(Reader reader) {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (parse.isJsonNull() || jsonReader.peek() == JsonToken.END_DOCUMENT) {
                return parse;
            }
            throw new JsonSyntaxException("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonIOException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        }
    }

    public JsonElement parse(JsonReader jsonReader) {
        StringBuilder stringBuilder;
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            JsonElement parse = Streams.parse(jsonReader);
            jsonReader.setLenient(isLenient);
            return parse;
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed parsing JSON source: ");
            stringBuilder.append(jsonReader);
            stringBuilder.append(" to Json");
            throw new JsonParseException(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed parsing JSON source: ");
            stringBuilder.append(jsonReader);
            stringBuilder.append(" to Json");
            throw new JsonParseException(stringBuilder.toString(), e2);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
        }
    }
}
