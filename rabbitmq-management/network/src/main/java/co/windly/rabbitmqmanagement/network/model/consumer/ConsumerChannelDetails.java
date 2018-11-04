package co.windly.rabbitmqmanagement.network.model.consumer;

import co.windly.rabbitmqmanagement.network.model.channel.ChannelDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ConsumerChannelDetails extends ChannelDetails {

  //region Connection Name

  @JsonProperty(value = "connection_name")
  private String connectionName;

  public String getConnectionName() {
    return connectionName;
  }

  public void setConnectionName(String connectionName) {
    this.connectionName = connectionName;
  }

  //endregion

  //region Number

  @JsonProperty(value = "number")
  private int number;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  //endregion

  //region UserDto

  @JsonProperty(value = "user")
  private String user;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  //endregion
}
