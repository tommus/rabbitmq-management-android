package co.windly.rabbitmqmanagement.network.model.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Listener {

  //region IP Address

  @JsonProperty(value = "ip_address")
  private String ipAddress;

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  //endregion

  //region Node

  @JsonProperty(value = "node")
  private String node;

  public String getNode() {
    return node;
  }

  public void setNode(String node) {
    this.node = node;
  }

  //endregion

  //region Port

  @JsonProperty(value = "port")
  private Integer port;

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  //endregion

  //region Protocol

  @JsonProperty(value = "protocol")
  private String protocol;

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  //endregion
}
