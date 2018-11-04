package co.windly.rabbitmqmanagement.network.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Message {

  //region Exchange

  @JsonProperty(value = "exchange")
  private String exchange;

  public String getExchange() {
    return exchange;
  }

  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  //endregion

  //region Message Count

  @JsonProperty(value = "message_count")
  private int messageCount;

  public int getMessageCount() {
    return messageCount;
  }

  public void setMessageCount(int messageCount) {
    this.messageCount = messageCount;
  }

  //endregion

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

  //region Payload Bytes

  @JsonProperty(value = "payload_bytes")
  private long payloadBytes;

  public long getPayloadBytes() {
    return payloadBytes;
  }

  public void setPayloadBytes(long payloadBytes) {
    this.payloadBytes = payloadBytes;
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
  private Properties properties;

  public Properties getProperties() {
    return properties;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  //endregion

  //region Redelivered

  @JsonProperty(value = "redelivered")
  private boolean redelivered;

  public boolean isRedelivered() {
    return redelivered;
  }

  public void setRedelivered(boolean redelivered) {
    this.redelivered = redelivered;
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
