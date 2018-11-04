package co.windly.rabbitmqmanagement.network.model.binding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExtendedBinding extends Binding {

  //region Properties Key

  @JsonProperty(value = "properties_key")
  private String propertiesKey;

  public String getPropertiesKey() {
    return propertiesKey;
  }

  public void setPropertiesKey(String propertiesKey) {
    this.propertiesKey = propertiesKey;
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
