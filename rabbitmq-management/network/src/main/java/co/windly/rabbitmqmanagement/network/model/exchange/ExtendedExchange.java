package co.windly.rabbitmqmanagement.network.model.exchange;

import co.windly.rabbitmqmanagement.network.model.MessageStats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExtendedExchange extends Exchange {

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

  //region Policy

  @JsonProperty(value = "policy")
  private String policy;

  public String getPolicy() {
    return policy;
  }

  public void setPolicy(String policy) {
    this.policy = policy;
  }

  //endregion

  //region Message Stats

  @JsonProperty(value = "message_stats")
  private MessageStats messageStats;

  public MessageStats getMessageStats() {
    return messageStats;
  }

  public void setMessageStats(MessageStats messageStats) {
    this.messageStats = messageStats;
  }
  //endregion
}
