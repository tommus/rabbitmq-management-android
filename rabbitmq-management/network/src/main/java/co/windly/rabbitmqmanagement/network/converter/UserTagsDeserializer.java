package co.windly.rabbitmqmanagement.network.converter;

import co.windly.rabbitmqmanagement.network.model.user.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserTagsDeserializer extends JsonDeserializer<List<User.Tag>> {
  @Override
  public List<User.Tag> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    String serialized = p.getText().trim();
    StringTokenizer tokenizer = new StringTokenizer(serialized, ",");
    List<User.Tag> result = new ArrayList<>();
    User.Tag tag = User.Tag.NONE;

    while (tokenizer.hasMoreElements()) {
      String token = tokenizer.nextToken();

      try {
        tag = User.Tag.valueOf(token.toUpperCase());
      } catch (IllegalArgumentException e) {
        // Leave none type as default.
      }

      if (!result.contains(tag)) {
        result.add(tag);
      }
    }

    return result;
  }
}
