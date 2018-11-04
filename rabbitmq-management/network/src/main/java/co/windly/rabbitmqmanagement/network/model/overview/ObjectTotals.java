package co.windly.rabbitmqmanagement.network.model.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ObjectTotals {

  //region Channels

  @JsonProperty(value = "channels")
  private int channels;

  public int getChannels() {
    return channels;
  }

  public void setChannels(int channels) {
    this.channels = channels;
  }

  //endregion

  //region Connections

  @JsonProperty(value = "connections")
  private int connections;

  public int getConnections() {
    return connections;
  }

  public void setConnections(int connections) {
    this.connections = connections;
  }

  //endregion

  //region Consumers

  @JsonProperty(value = "consumers")
  private int consumers;

  public int getConsumers() {
    return consumers;
  }

  public void setConsumers(int consumers) {
    this.consumers = consumers;
  }

  //endregion

  //region Exchanges

  @JsonProperty(value = "exchanges")
  private int exchanges;

  public int getExchanges() {
    return exchanges;
  }

  public void setExchanges(int exchanges) {
    this.exchanges = exchanges;
  }

  //endregion

  //region Queues

  @JsonProperty(value = "queues")
  private int queues;

  public int getQueues() {
    return queues;
  }

  public void setQueues(int queues) {
    this.queues = queues;
  }

  //endregion
}
