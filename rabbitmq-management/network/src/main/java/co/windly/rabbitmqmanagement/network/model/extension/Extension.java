package co.windly.rabbitmqmanagement.network.model.extension;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Extension {

  //region JavaScript

  @JsonProperty(value = "javascript")
  private String javascript;

  public String getJavascript() {
    return javascript;
  }

  public void setJavascript(String javascript) {
    this.javascript = javascript;
  }

  //endregion
}
