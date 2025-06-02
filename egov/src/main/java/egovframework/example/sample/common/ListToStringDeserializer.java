package egovframework.example.sample.common;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ListToStringDeserializer extends JsonDeserializer<String> {
    private static final ObjectMapper mapper = new ObjectMapper();
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = mapper.readTree(jsonParser);
        return mapper.writeValueAsString(node);
    }
}
