package co.windly.rabbitmqmanagement.network.model.binding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Binding {

  //region Arguments

  @JsonProperty(value = "arguments")
  private Map<String, String> bindingArguments;

  public Map<String, String> getBindingArguments() {
    return bindingArguments;
  }

  public void setBindingArguments(Map<String, String> bindingArguments) {
    this.bindingArguments = bindingArguments;
  }

  //endregion

  //region Destination

  @JsonProperty(value = "destination")
  private String destination;

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  //endregion

  //region Destination Type

  @JsonProperty(value = "destination_type")
  private String destinationType;

  public String getDestinationType() {
    return destinationType;
  }

  public void setDestinationType(String destinationType) {
    this.destinationType = destinationType;
  }

  //endregion

  //region Routing Key

  @JsonProperty(value = "routing_key")
  private String routingKey;

  public String getRoutingKey() {
    return routingKey;
  }

  public void setRoutingKey(String routingKey) {
    this.routingKey = routingKey;
  }

  //endregion

  //region Source

  @JsonProperty(value = "source")
  private String source;

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  //endregion
}
