package com.todev.rabbitmqmanagement.data.network.model.queue;

import android.support.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PutQueue {

  @JsonProperty(value = "arguments") protected Map<String, String> arguments;

  @JsonProperty(value = "auto_delete") protected Boolean autoDelete;

  @JsonProperty(value = "durable") protected Boolean durable;

  @JsonProperty(value = "node") protected String node;

  public PutQueue(@Nullable Boolean autoDelete, @Nullable Boolean durable, @Nullable Map<String, String> arguments,
    @Nullable String node) {
    this.autoDelete = autoDelete;
    this.durable = durable;
    this.arguments = arguments;
    this.node = node;
  }
}
