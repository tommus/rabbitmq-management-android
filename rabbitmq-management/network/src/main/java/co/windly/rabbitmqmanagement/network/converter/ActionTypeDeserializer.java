package co.windly.rabbitmqmanagement.network.converter;

import co.windly.rabbitmqmanagement.network.model.queue.Action;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class ActionTypeDeserializer extends JsonDeserializer<Action.Type> {
  @Override
  public Action.Type deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    String serialized = p.getText().trim();
    try {
      return Action.Type.valueOf(serialized.toUpperCase());
    } catch (IllegalArgumentException e) {
      return Action.Type.SYNC;
    }
  }
}
