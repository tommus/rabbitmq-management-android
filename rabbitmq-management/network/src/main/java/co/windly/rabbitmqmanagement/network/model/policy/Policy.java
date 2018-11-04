package co.windly.rabbitmqmanagement.network.model.policy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Policy {

  //region Apply To

  @JsonProperty(value = "apply-to")
  private String applyTo;

  public String getApplyTo() {
    return applyTo;
  }

  public void setApplyTo(String applyTo) {
    this.applyTo = applyTo;
  }

  //endregion

  //region Definition

  @JsonProperty(value = "definition")
  private Map<String, String> definition;

  public Map<String, String> getDefinition() {
    return definition;
  }

  public void setDefinition(Map<String, String> definition) {
    this.definition = definition;
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

  //region Pattern

  @JsonProperty(value = "pattern")
  private String pattern;

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  //endregion

  //region Priority

  @JsonProperty(value = "priority")
  private Integer priority;

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
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
