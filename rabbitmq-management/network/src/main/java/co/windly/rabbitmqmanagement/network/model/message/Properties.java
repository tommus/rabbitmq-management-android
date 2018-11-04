package co.windly.rabbitmqmanagement.network.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Properties {

  //region Delivery Mode

  @JsonProperty(value = "delivery_mode")
  private int deliveryMode;

  public int getDeliveryMode() {
    return deliveryMode;
  }

  public void setDeliveryMode(int deliveryMode) {
    this.deliveryMode = deliveryMode;
  }

  //endregion

  //region Headers

  @JsonProperty(value = "headers")
  private Map<String, String> headers;

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }

  //endregion
}
