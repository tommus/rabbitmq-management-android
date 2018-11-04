package co.windly.rabbitmqmanagement.network.model.connection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ClientProperties {

  //region Capabilities

  @JsonProperty(value = "capabilities")
  private ClientPropertiesCapabilities capabilities;

  public ClientPropertiesCapabilities getCapabilities() {
    return capabilities;
  }

  public void setCapabilities(ClientPropertiesCapabilities capabilities) {
    this.capabilities = capabilities;
  }

  //endregion

  //region Information

  @JsonProperty(value = "information")
  private String information;

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }

  //endregion

  //region Platform

  @JsonProperty(value = "platform")
  private String platform;

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  //endregion

  //region Product

  @JsonProperty(value = "product")
  private String product;

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  //endregion

  //region Version

  @JsonProperty(value = "version")
  private String version;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  //endregion
}
