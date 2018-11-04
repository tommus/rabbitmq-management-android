package co.windly.rabbitmqmanagement.network.converter;

import co.windly.rabbitmqmanagement.network.model.exchange.Exchange;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class ExchangeTypeDeserializer extends JsonDeserializer<Exchange.Type> {
  @Override
  public Exchange.Type deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    String serialized = p.getText().trim();
    try {
      return Exchange.Type.valueOf(serialized.toUpperCase());
    } catch (IllegalArgumentException e) {
      return Exchange.Type.DIRECT;
    }
  }
}
