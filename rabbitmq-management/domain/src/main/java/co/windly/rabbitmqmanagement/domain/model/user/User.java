package co.windly.rabbitmqmanagement.domain.model.user;

import co.windly.rabbitmqmanagement.domain.definition.Tag;
import io.reactivex.annotations.NonNull;
import java.util.ArrayList;
import java.util.List;

public class User {

  //region Name

  @NonNull
  private String name = "";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //endregion

  //region Tags

  @Tag
  @NonNull
  private List<String> tags = new ArrayList<>();

  @Tag
  public List<String> getTags() {
    return tags;
  }

  public void setTags(@Tag List<String> tags) {
    this.tags = tags;
  }

  //endregion
}
