package co.windly.rabbitmqmanagement.network.model.parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PutParameter {

  //region Component

  @JsonProperty(value = "component")
  private String component;

  public String getComponent() {
    return component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  //endregion

  //region Name

  @JsonProperty(value = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //endregion

  //region Value

  @JsonProperty(value = "value")
  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  //endregion

  //region Vhost

  @JsonProperty(value = "vhost")
  private String vhost;

  public String getVhost() {
    return vhost;
  }

  public void setVhost(String vhost) {
    this.vhost = vhost;
  }

  //endregion
}
