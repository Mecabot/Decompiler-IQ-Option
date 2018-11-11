package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj);

        abstract void write(JsonWriter jsonWriter, Object obj);

        abstract boolean writeField(Object obj);

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        public T read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = (BoundField) this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void write(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        List<String> arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (Object add : alternate) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        final Gson gson2 = gson;
        final TypeToken typeToken2 = typeToken;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        final Field field2 = field;
        JsonAdapter jsonAdapter = (JsonAdapter) field2.getAnnotation(JsonAdapter.class);
        TypeAdapter typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson2, typeToken2, jsonAdapter) : null;
        final boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson2.getAdapter(typeToken2);
        }
        final TypeAdapter typeAdapter2 = typeAdapter;
        return new BoundField(str, z, z2) {
            void write(JsonWriter jsonWriter, Object obj) {
                TypeAdapter typeAdapter;
                obj = field2.get(obj);
                if (z3) {
                    typeAdapter = typeAdapter2;
                } else {
                    typeAdapter = new TypeAdapterRuntimeTypeWrapper(gson2, typeAdapter2, typeToken2.getType());
                }
                typeAdapter.write(jsonWriter, obj);
            }

            void read(JsonReader jsonReader, Object obj) {
                Object read = typeAdapter2.read(jsonReader);
                if (read != null || !isPrimitive) {
                    field2.set(obj, read);
                }
            }

            public boolean writeField(Object obj) {
                boolean z = false;
                if (!this.serialized) {
                    return false;
                }
                if (field2.get(obj) != obj) {
                    z = true;
                }
                return z;
            }
        };
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Map<String, BoundField> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken typeToken2 = typeToken;
        Class cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                AccessibleObject accessibleObject = declaredFields[i];
                boolean excludeField = reflectiveTypeAdapterFactory.excludeField(accessibleObject, true);
                boolean excludeField2 = reflectiveTypeAdapterFactory.excludeField(accessibleObject, z);
                if (excludeField || excludeField2) {
                    BoundField boundField;
                    reflectiveTypeAdapterFactory.accessor.makeAccessible(accessibleObject);
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls2, accessibleObject.getGenericType());
                    List fieldNames = reflectiveTypeAdapterFactory.getFieldNames(accessibleObject);
                    BoundField boundField2 = null;
                    int size = fieldNames.size();
                    int i2 = 0;
                    while (i2 < size) {
                        String str = (String) fieldNames.get(i2);
                        boolean z2 = i2 != 0 ? false : excludeField;
                        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory2 = reflectiveTypeAdapterFactory;
                        boundField = boundField2;
                        int i3 = i2;
                        int i4 = size;
                        List list = fieldNames;
                        Type type2 = resolve;
                        AccessibleObject accessibleObject2 = accessibleObject;
                        boundField2 = boundField == null ? (BoundField) linkedHashMap.put(str, reflectiveTypeAdapterFactory2.createBoundField(gson, accessibleObject, str, TypeToken.get(resolve), z2, excludeField2)) : boundField;
                        i2 = i3 + 1;
                        excludeField = z2;
                        resolve = type2;
                        size = i4;
                        fieldNames = list;
                        accessibleObject = accessibleObject2;
                        reflectiveTypeAdapterFactory = this;
                    }
                    boundField = boundField2;
                    if (boundField != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(type);
                        stringBuilder.append(" declares multiple JSON fields named ");
                        stringBuilder.append(boundField.name);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                i++;
                reflectiveTypeAdapterFactory = this;
                z = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
        }
        return linkedHashMap;
    }
}
