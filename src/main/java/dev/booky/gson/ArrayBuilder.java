package dev.booky.gson;
// Created by booky10 in GsonBuilders (16:23 06.09.22)

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public final class ArrayBuilder implements Iterable<JsonElement> {

    private final JsonArray array;

    public ArrayBuilder(JsonArray array) {
        this.array = array.deepCopy();
    }

    public ArrayBuilder() {
        this.array = new JsonArray();
    }

    public ArrayBuilder add(@Nullable JsonElement val) {
        getDirect().add(val);
        return this;
    }

    public ArrayBuilder add(@Nullable String val) {
        getDirect().add(val);
        return this;
    }

    public ArrayBuilder add(@Nullable Number val) {
        getDirect().add(val);
        return this;
    }

    public ArrayBuilder add(@Nullable Boolean val) {
        getDirect().add(val);
        return this;
    }

    public ArrayBuilder add(@Nullable Character val) {
        getDirect().add(val);
        return this;
    }

    public ArrayBuilder remove(int index) {
        getDirect().remove(index);
        return this;
    }

    public JsonArray get() {
        return getDirect().deepCopy();
    }

    public JsonArray getDirect() {
        return array;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArrayBuilder that)) return false;
        return array.equals(that.array);
    }

    @Override
    public int hashCode() {
        return array.hashCode();
    }

    @Override
    public String toString() {
        return "ArrayBuilder{object=" + array + '}';
    }

    @Override
    public @NotNull Iterator<JsonElement> iterator() {
        return get().iterator();
    }
}
