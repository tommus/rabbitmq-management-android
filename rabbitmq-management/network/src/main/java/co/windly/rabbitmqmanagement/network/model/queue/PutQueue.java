package co.windly.rabbitmqmanagement.network.model.queue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PutQueue {

  //region Arguments

  @JsonProperty(value = "arguments")
  private Map<String, String> arguments;

  public Map<String, String> getArguments() {
    return arguments;
  }

  public void setArguments(Map<String, String> arguments) {
    this.arguments = arguments;
  }

  //endregion

  //region Auto Delete

  @JsonProperty(value = "auto_delete")
  private Boolean autoDelete;

  public Boolean getAutoDelete() {
    return autoDelete;
  }

  public void setAutoDelete(Boolean autoDelete) {
    this.autoDelete = autoDelete;
  }

  //endregion

  //region Durable

  @JsonProperty(value = "durable")
  private Boolean durable;

  public Boolean getDurable() {
    return durable;
  }

  public void setDurable(Boolean durable) {
    this.durable = durable;
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
}
