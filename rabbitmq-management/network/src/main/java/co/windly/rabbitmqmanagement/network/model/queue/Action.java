package co.windly.rabbitmqmanagement.network.model.queue;

import co.windly.rabbitmqmanagement.network.converter.ActionTypeDeserializer;
import co.windly.rabbitmqmanagement.network.converter.ActionTypeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Action {

  //region Constructor

  public Action(Type action) {
    this.action = action;
  }

  //endregion

  //region Action

  @JsonDeserialize(using = ActionTypeDeserializer.class)
  @JsonProperty(value = "action")
  @JsonSerialize(using = ActionTypeSerializer.class)
  private Type action;

  public static Action getSYNC() {
    return SYNC;
  }

  //endregion

  // TODO: Reimplement enum with StringDef

  public static final Action SYNC = new Action(Type.SYNC);

  public static final Action CANCEL_SYNC = new Action(Type.CANCEL_SYNC);

  public enum Type {
    SYNC, CANCEL_SYNC
  }
}
