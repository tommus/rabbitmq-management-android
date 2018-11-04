package co.windly.rabbitmqmanagement.network.model.node;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Application {

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
