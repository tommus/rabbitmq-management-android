package co.windly.rabbitmqmanagement.network.model.queue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Queue {

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
  private boolean autoDelete;

  public boolean isAutoDelete() {
    return autoDelete;
  }

  public void setAutoDelete(boolean autoDelete) {
    this.autoDelete = autoDelete;
  }

  //endregion

  //region Durable

  @JsonProperty(value = "durable")
  private boolean durable;

  public boolean isDurable() {
    return durable;
  }

  public void setDurable(boolean durable) {
    this.durable = durable;
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
}
