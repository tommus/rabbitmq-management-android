package co.windly.rabbitmqmanagement.network.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.List;

public class UserTagsSerializer extends JsonSerializer<List<String>> {
  @Override
  public void serialize(List<String> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

    final StringBuilder builder = new StringBuilder();
    for (String tag : value) {
      builder.append(tag.toLowerCase());
      builder.append(',');
    }

    String result = builder.toString();
    if (result.endsWith(",")) {
      result = result.substring(0, result.length() - 1);
    }

    gen.writeString(result);
  }
}
