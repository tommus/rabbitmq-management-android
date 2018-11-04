package co.windly.rabbitmqmanagement.network.model.permission;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Permission {

  //region Configure

  @JsonProperty(value = "configure")
  private String configure;

  public String getConfigure() {
    return configure;
  }

  public void setConfigure(String configure) {
    this.configure = configure;
  }

  //endregion

  //region Read

  @JsonProperty(value = "read")
  private String read;

  public String getRead() {
    return read;
  }

  public void setRead(String read) {
    this.read = read;
  }

  //endregion

  //region User

  @JsonProperty(value = "user")
  private String user;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
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

  //region Write

  @JsonProperty(value = "write")
  private String write;

  public String getWrite() {
    return write;
  }

  public void setWrite(String write) {
    this.write = write;
  }

  //endregion
}
