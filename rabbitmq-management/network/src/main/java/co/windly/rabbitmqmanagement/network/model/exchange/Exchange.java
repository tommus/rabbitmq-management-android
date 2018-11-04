package co.windly.rabbitmqmanagement.network.model.exchange;

import co.windly.rabbitmqmanagement.network.converter.ExchangeTypeDeserializer;
import co.windly.rabbitmqmanagement.network.converter.ExchangeTypeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Exchange {

  //region Arguments

  @JsonProperty(value = "arguments")
  private Map<String, String> arguments;

  public Map<String, String> getArguments() {
    return arguments;
  }

  public void setArguments(Map<String, String> arguments) {
    this.arguments = arguments;
  }

  //endregion

  //region Auto Delete

  @JsonProperty(value = "auto_delete")
  private boolean autoDelete;

  public boolean isAutoDelete() {
    return autoDelete;
  }

  public void setAutoDelete(boolean autoDelete) {
    this.autoDelete = autoDelete;
  }

  //endregion

  //region Durable

  @JsonProperty(value = "durable")
  private boolean durable;

  public boolean isDurable() {
    return durable;
  }

  public void setDurable(boolean durable) {
    this.durable = durable;
  }

  //endregion

  //region Internal

  @JsonProperty(value = "internal")
  private boolean internal;

  public boolean isInternal() {
    return internal;
  }

  public void setInternal(boolean internal) {
    this.internal = internal;
  }

  //endregion

  //region Name

  @JsonProperty(value = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //endregion

  //region Type

  @JsonDeserialize(using = ExchangeTypeDeserializer.class)
  @JsonProperty(value = "type")
  @JsonSerialize(using = ExchangeTypeSerializer.class)
  private Type type;

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  //endregion

  // TODO: Reimplement type as StringDef

  public enum Type {
    DIRECT, FANOUT, HEADERS, TOPIC
  }
}
