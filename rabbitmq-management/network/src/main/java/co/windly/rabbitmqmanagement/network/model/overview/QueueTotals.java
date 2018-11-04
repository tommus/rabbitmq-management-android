package co.windly.rabbitmqmanagement.network.model.overview;

import co.windly.rabbitmqmanagement.network.model.Details;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QueueTotals {

  //region Messages

  @JsonProperty(value = "messages")
  private int messages;

  public int getMessages() {
    return messages;
  }

  public void setMessages(int messages) {
    this.messages = messages;
  }

  //endregion

  //region Messages Details

  @JsonProperty(value = "messages_details")
  private Details messagesDetails;

  public Details getMessagesDetails() {
    return messagesDetails;
  }

  public void setMessagesDetails(Details messagesDetails) {
    this.messagesDetails = messagesDetails;
  }

  //endregion

  //region Messages Ready

  @JsonProperty(value = "messages_ready")
  private int messagesReady;

  public int getMessagesReady() {
    return messagesReady;
  }

  public void setMessagesReady(int messagesReady) {
    this.messagesReady = messagesReady;
  }

  //endregion

  //region Messages Ready Details

  @JsonProperty(value = "messages_ready_details")
  private Details messagesReadyDetails;

  public Details getMessagesReadyDetails() {
    return messagesReadyDetails;
  }

  public void setMessagesReadyDetails(Details messagesReadyDetails) {
    this.messagesReadyDetails = messagesReadyDetails;
  }

  //endregion

  //region Messages Unacknowledged

  @JsonProperty(value = "messages_unacknowledged")
  private int messagesUnacknowledged;

  public int getMessagesUnacknowledged() {
    return messagesUnacknowledged;
  }

  public void setMessagesUnacknowledged(int messagesUnacknowledged) {
    this.messagesUnacknowledged = messagesUnacknowledged;
  }

  //endregion

  //region Messages Unacknowledged Details

  @JsonProperty(value = "messages_unacknowledged_details")
  private Details messagesUnacknowledgedDetails;

  public Details getMessagesUnacknowledgedDetails() {
    return messagesUnacknowledgedDetails;
  }

  public void setMessagesUnacknowledgedDetails(
    Details messagesUnacknowledgedDetails) {
    this.messagesUnacknowledgedDetails = messagesUnacknowledgedDetails;
  }

  //endregion
}
