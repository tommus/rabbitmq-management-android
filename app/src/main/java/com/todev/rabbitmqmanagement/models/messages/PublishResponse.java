package com.todev.rabbitmqmanagement.models.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PublishResponse {

  @JsonProperty("routed")
  protected boolean routed;

  public boolean isRouted() {
    return routed;
  }
}
