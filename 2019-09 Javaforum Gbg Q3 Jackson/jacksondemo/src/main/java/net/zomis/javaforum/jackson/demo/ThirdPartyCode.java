package net.zomis.javaforum.jackson.demo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.collect.Range;

import java.io.IOException;

public class ThirdPartyCode {

    public static void main(String[] args) {
        Tools.runSteps(new ThirdPartyCode()::problem, new ThirdPartyCode()::solution);
    }

    private void problem() throws JsonProcessingException {
        Range<Integer> range = Range.closed(20, 42);
        System.out.println(new ObjectMapper().writeValueAsString(range));
        System.out.println(range.lowerEndpoint());
        System.out.println(range.upperEndpoint());
    }

    private void solution() throws IOException {
        SimpleModule rangeDeserializerModule = new SimpleModule();
        rangeDeserializerModule.addDeserializer(Range.class, new RangeDeserializer());
        ObjectMapper mapper = new ObjectMapper()
            .addMixIn(Range.class, RangeMixin.class)
            .registerModule(rangeDeserializerModule);

        Range<Integer> range = Range.closed(20, 42);

        System.out.println(mapper.writeValueAsString(range));

        range = mapper.readValue("{ \"lower\": 1000, \"upper\": 9999 }", Range.class);
        System.out.println(range);
    }

    public abstract static class RangeMixin {
        @JsonIgnore
        abstract boolean isEmpty();

        @JsonGetter("lower")
        abstract Integer lowerEndpoint();

        @JsonGetter("upper")
        abstract Integer upperEndpoint();
    }

    public class RangeDeserializer extends StdDeserializer<Range<Integer>> {

        public RangeDeserializer() {
            super((Class<?>) null);
        }

        @Override
        public Range<Integer> deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            int lower = node.get("lower").asInt();
            int upper = node.get("upper").asInt();

            return Range.closed(lower, upper);
        }
    }

}
