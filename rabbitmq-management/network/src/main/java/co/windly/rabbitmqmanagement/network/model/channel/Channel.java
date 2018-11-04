package co.windly.rabbitmqmanagement.network.model.channel;

import co.windly.rabbitmqmanagement.network.model.MessageStats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Channel {

  //region Acks Uncommited

  @JsonProperty(value = "acks_uncommitted")
  private int acksUncommitted;

  public int getAcksUncommitted() {
    return acksUncommitted;
  }

  public void setAcksUncommitted(int acksUncommitted) {
    this.acksUncommitted = acksUncommitted;
  }

  //endregion

  //region Confirm

  @JsonProperty(value = "confirm")
  private boolean confirm;

  public boolean isConfirm() {
    return confirm;
  }

  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }

  //endregion

  //region Connection Details

  @JsonProperty(value = "connection_details")
  private ChannelDetails connectionDetails;

  public ChannelDetails getConnectionDetails() {
    return connectionDetails;
  }

  public void setConnectionDetails(ChannelDetails connectionDetails) {
    this.connectionDetails = connectionDetails;
  }

  //endregion

  //region Consumer Count

  @JsonProperty(value = "consumer_count")
  private int consumerCount;

  public int getConsumerCount() {
    return consumerCount;
  }

  public void setConsumerCount(int consumerCount) {
    this.consumerCount = consumerCount;
  }

  //endregion

  //region Global Prefetch Count

  @JsonProperty(value = "global_prefetch_count")
  private int globalPrefetchCount;

  public int getGlobalPrefetchCount() {
    return globalPrefetchCount;
  }

  public void setGlobalPrefetchCount(int globalPrefetchCount) {
    this.globalPrefetchCount = globalPrefetchCount;
  }

  //endregion

  //region Idle Since

  @JsonProperty(value = "idle_since")
  private String idleSince;

  public String getIdleSince() {
    return idleSince;
  }

  public void setIdleSince(String idleSince) {
    this.idleSince = idleSince;
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

  //region Messages Uncommitted

  @JsonProperty(value = "messages_uncommitted")
  private int messagesUncommitted;

  public int getMessagesUncommitted() {
    return messagesUncommitted;
  }

  public void setMessagesUncommitted(int messagesUncommitted) {
    this.messagesUncommitted = messagesUncommitted;
  }

  //endregion

  //region Messages Unconfirmed

  @JsonProperty(value = "messages_unconfirmed")
  private int messagesUnconfirmed;

  public int getMessagesUnconfirmed() {
    return messagesUnconfirmed;
  }

  public void setMessagesUnconfirmed(int messagesUnconfirmed) {
    this.messagesUnconfirmed = messagesUnconfirmed;
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

  //region Number

  @JsonProperty(value = "number")
  private int number;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  //endregion

  //region Prefetch Count

  @JsonProperty(value = "prefetch_count")
  private int prefetchCount;

  public int getPrefetchCount() {
    return prefetchCount;
  }

  public void setPrefetchCount(int prefetchCount) {
    this.prefetchCount = prefetchCount;
  }

  //endregion

  //region State

  @JsonProperty(value = "state")
  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  //endregion

  //region Transactional

  @JsonProperty(value = "transactional")
  private boolean transactional;

  public boolean isTransactional() {
    return transactional;
  }

  public void setTransactional(boolean transactional) {
    this.transactional = transactional;
  }

  //endregion

  //region UserDto

  @JsonProperty(value = "user")
  private String user;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
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
