package co.windly.rabbitmqmanagement.network.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Context {

  //region Description

  @JsonProperty(value = "description")
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  //endregion

  //region Path

  @JsonProperty(value = "path")
  private String path;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  //endregion

  //region Port

  @JsonProperty(value = "port")
  private String port;

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  //endregion

  //region Ssl

  @JsonProperty(value = "ssl")
  private String ssl;

  public String getSsl() {
    return ssl;
  }

  public void setSsl(String ssl) {
    this.ssl = ssl;
  }

  //endregion
}
