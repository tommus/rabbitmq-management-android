package co.windly.rabbitmqmanagement.network.converter;

import co.windly.rabbitmqmanagement.network.model.exchange.Exchange;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class ExchangeTypeSerializer extends JsonSerializer<Exchange.Type> {
  @Override
  public void serialize(Exchange.Type value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    gen.writeString(value.toString().toLowerCase());
  }
}
