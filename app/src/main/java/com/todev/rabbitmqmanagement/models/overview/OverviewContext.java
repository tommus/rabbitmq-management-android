package com.todev.rabbitmqmanagement.models.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Context;

/**
 * @author Tomasz Dzieniak
 * @since 09.06.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class OverviewContext extends Context {

  @JsonProperty("node") protected String node;

  public String getNode() {
    return node;
  }
}
