package co.windly.rabbitmqmanagement.network.converter;

import co.windly.rabbitmqmanagement.network.model.user.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.List;

public class UserTagsSerializer extends JsonSerializer<List<User.Tag>> {
  @Override
  public void serialize(List<User.Tag> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    StringBuilder builder = new StringBuilder();
    for (User.Tag tag : value) {
      builder.append(tag.toString().toLowerCase());
      builder.append(',');
    }
    String result = builder.toString();
    if (result.endsWith(",")) {
      result = result.substring(0, result.length() - 1);
    }
    gen.writeString(result);
  }
}
