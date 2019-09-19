package net.zomis.javaforum.jackson.demo.domain.products;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

import java.io.IOException;

public class JacksonProductTypeResolver extends TypeIdResolverBase {

    @Override
    public String idFromValue(Object value) {
        return idFromValueAndType(value, value.getClass());
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> suggestedType) {
        return suggestedType.getSimpleName();
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        switch (id) {
            case "CD":
                return context.constructType(CD.class);
            case "Book":
                return context.constructType(Book.class);
            default:
                throw new IllegalArgumentException("Unknown type id: " + id);
        }
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.NAME;
    }
}
