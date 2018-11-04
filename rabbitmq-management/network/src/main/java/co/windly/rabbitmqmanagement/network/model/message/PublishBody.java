package co.windly.rabbitmqmanagement.network.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PublishBody {

  //region Payload

  @JsonProperty(value = "payload")
  private String payload;

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  //endregion

  //region Payload Encoding

  @JsonProperty(value = "payload_encoding")
  private String payloadEncoding;

  public String getPayloadEncoding() {
    return payloadEncoding;
  }

  public void setPayloadEncoding(String payloadEncoding) {
    this.payloadEncoding = payloadEncoding;
  }

  //endregion

  //region Properties

  @JsonProperty(value = "properties")
  private Map<String, String> properties;

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
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
}
