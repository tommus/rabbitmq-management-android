package co.windly.rabbitmqmanagement.network.converter;

import co.windly.rabbitmqmanagement.network.model.queue.Action;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class ActionTypeSerializer extends JsonSerializer<Action.Type> {
  @Override
  public void serialize(Action.Type value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    gen.writeString(value.toString().toLowerCase());
  }
}
