package co.windly.rabbitmqmanagement.network.model.consumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Consumer {

  //region Ack Required

  @JsonProperty(value = "ack_required")
  private boolean ackRequired;

  public boolean isAckRequired() {
    return ackRequired;
  }

  public void setAckRequired(boolean ackRequired) {
    this.ackRequired = ackRequired;
  }

  //endregion

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

  //region Channel Details

  @JsonProperty(value = "channel_details")
  private ConsumerChannelDetails channelDetails;

  public ConsumerChannelDetails getChannelDetails() {
    return channelDetails;
  }

  public void setChannelDetails(ConsumerChannelDetails channelDetails) {
    this.channelDetails = channelDetails;
  }

  //endregion

  //region Consumer Tag

  @JsonProperty(value = "consumer_tag")
  private String consumerTag;

  public String getConsumerTag() {
    return consumerTag;
  }

  public void setConsumerTag(String consumerTag) {
    this.consumerTag = consumerTag;
  }

  //endregion

  //region Exclusive

  @JsonProperty(value = "exclusive")
  private boolean exclusive;

  public boolean isExclusive() {
    return exclusive;
  }

  public void setExclusive(boolean exclusive) {
    this.exclusive = exclusive;
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

  //region Queue

  @JsonProperty(value = "queue")
  private ConsumerQueue queue;

  public ConsumerQueue getQueue() {
    return queue;
  }

  public void setQueue(ConsumerQueue queue) {
    this.queue = queue;
  }

  //endregion
}
