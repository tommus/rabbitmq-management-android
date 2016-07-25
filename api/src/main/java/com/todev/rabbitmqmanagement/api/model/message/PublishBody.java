package com.todev.rabbitmqmanagement.api.model.message;

import android.support.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class PublishBody {

  @JsonProperty(value = "payload")
  protected String payload;

  @JsonProperty(value = "payload_encoding")
  protected String payloadEncoding;

  @JsonProperty(value = "properties")
  protected Map<String, String> properties;

  @JsonProperty(value = "routing_key")
  protected String routingKey;

  public PublishBody(@NonNull String payload, @NonNull String payloadEncoding, @NonNull Map<String, String> properties,
      @NonNull String routingKey) {
    this.payload = payload;
    this.payloadEncoding = payloadEncoding;
    this.properties = properties;
    this.routingKey = routingKey;
  }
}
