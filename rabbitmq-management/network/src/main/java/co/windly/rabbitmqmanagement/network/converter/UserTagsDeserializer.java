package co.windly.rabbitmqmanagement.network.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserTagsDeserializer extends JsonDeserializer<List<String>> {
  @Override
  public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

    final String serialized = p.getText().trim();
    final StringTokenizer tokenizer = new StringTokenizer(serialized, ",");
    final List<String> result = new ArrayList<>();

    while (tokenizer.hasMoreElements()) {
      final String token = tokenizer.nextToken();
      result.add(token);
    }

    return result;
  }
}
