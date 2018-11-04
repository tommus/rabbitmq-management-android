package co.windly.rabbitmqmanagement.network.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PublishResponse {

  //region Routed

  @JsonProperty("routed")
  private boolean routed;

  public boolean isRouted() {
    return routed;
  }

  public void setRouted(boolean routed) {
    this.routed = routed;
  }

  //endregion
}
