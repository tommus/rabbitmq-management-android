package co.windly.rabbitmqmanagement.network.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Details {

  //region Rate

  @JsonProperty(value = "rate")
  private float rate;

  public float getRate() {
    return rate;
  }

  public void setRate(float rate) {
    this.rate = rate;
  }

  //endregion
}
