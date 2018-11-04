package co.windly.rabbitmqmanagement.network.model.user;

import co.windly.rabbitmqmanagement.network.converter.UserTagsDeserializer;
import co.windly.rabbitmqmanagement.network.converter.UserTagsSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDto {

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

  //region Tags

  @JsonDeserialize(using = UserTagsDeserializer.class)
  @JsonProperty(value = "tags")
  @JsonSerialize(using = UserTagsSerializer.class)
  private List<String> tags;

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  //endregion
}
