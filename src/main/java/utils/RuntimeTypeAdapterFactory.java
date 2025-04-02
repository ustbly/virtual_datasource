package utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.util.HashMap;
import java.util.Map;

public class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final Class<T> baseType;
    private final String typeFieldName;
    private final Map<String, Class<? extends T>> subtypeMap = new HashMap<>();

    private RuntimeTypeAdapterFactory(Class<T> baseType, String typeFieldName) {
        this.baseType = baseType;
        this.typeFieldName = typeFieldName;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType, String typeFieldName) {
        return new RuntimeTypeAdapterFactory<>(baseType, typeFieldName);
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> subtype, String type) {
        subtypeMap.put(type, subtype);
        return this;
    }

    @Override
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
        if (!baseType.isAssignableFrom(type.getRawType())) {
            return null;
        }

        final Map<String, TypeAdapter<?>> typeAdapters = new HashMap<>();
        for (Map.Entry<String, Class<? extends T>> entry : subtypeMap.entrySet()) {
            TypeAdapter<?> adapter = gson.getDelegateAdapter(this, TypeToken.get(entry.getValue()));
            typeAdapters.put(entry.getKey(), adapter);
        }

        return new TypeAdapter<R>() {
            @Override
            public void write(JsonWriter out, R value) throws java.io.IOException {
                Class<?> rawType = value.getClass();
                String typeLabel = null;
                for (Map.Entry<String, Class<? extends T>> entry : subtypeMap.entrySet()) {
                    if (entry.getValue() == rawType) {
                        typeLabel = entry.getKey();
                        break;
                    }
                }
                if (typeLabel == null) {
                    throw new JsonParseException("Unknown type: " + rawType);
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.add(typeFieldName, new JsonPrimitive(typeLabel));
                jsonObject.add("data", gson.toJsonTree(value));
                gson.toJson(jsonObject, out);
            }

            @Override
            public R read(JsonReader in) throws java.io.IOException {
                JsonObject jsonObject = JsonParser.parseReader(in).getAsJsonObject();
                JsonElement typeElement = jsonObject.remove(typeFieldName);
                if (typeElement == null) {
                    throw new JsonParseException("Missing type field: " + typeFieldName);
                }
                String type = typeElement.getAsString();
                TypeAdapter<?> adapter = typeAdapters.get(type);
                if (adapter == null) {
                    throw new JsonParseException("Unknown type: " + type);
                }
                return (R) adapter.fromJsonTree(jsonObject.get("data"));
            }
        }.nullSafe();
    }


}
