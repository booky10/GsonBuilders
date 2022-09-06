package dev.booky.gson;
// Created by booky10 in GsonBuilders (16:17 06.09.22)

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

public final class ObjectBuilder {

    private final JsonObject object;

    public ObjectBuilder(JsonObject object) {
        this.object = object.deepCopy();
    }

    public ObjectBuilder() {
        this.object = new JsonObject();
    }

    public ObjectBuilder add(String key, JsonElement val) {
        getDirect().add(key, val);
        return this;
    }

    public ObjectBuilder add(String key, @Nullable String val) {
        getDirect().addProperty(key, val);
        return this;
    }

    public ObjectBuilder add(String key, @Nullable Number val) {
        getDirect().addProperty(key, val);
        return this;
    }

    public ObjectBuilder add(String key, @Nullable Boolean val) {
        getDirect().addProperty(key, val);
        return this;
    }

    public ObjectBuilder add(String key, @Nullable Character val) {
        getDirect().addProperty(key, val);
        return this;
    }

    public ObjectBuilder remove(String key) {
        getDirect().remove(key);
        return this;
    }

    public JsonObject get() {
        return getDirect().deepCopy();
    }

    public JsonObject getDirect() {
        return object;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ObjectBuilder that)) return false;
        return object.equals(that.object);
    }

    @Override
    public int hashCode() {
        return object.hashCode();
    }

    @Override
    public String toString() {
        return "ObjectBuilder{object=" + object + '}';
    }
}
