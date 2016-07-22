package com.todev.rabbitmqmanagement.model.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.model.Context;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OverviewContext extends Context {

  @JsonProperty(value = "node")
  protected String node;

  public String getNode() {
    return node;
  }
}