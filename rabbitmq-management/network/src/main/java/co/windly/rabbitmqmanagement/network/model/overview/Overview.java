package co.windly.rabbitmqmanagement.network.model.overview;

import co.windly.rabbitmqmanagement.network.model.Description;
import co.windly.rabbitmqmanagement.network.model.MessageStats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Overview {

  //region Cluster Name

  @JsonProperty(value = "cluster_name")
  private String clusterName;

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  //endregion

  //region Contexts

  @JsonProperty(value = "contexts")
  private List<OverviewContext> contexts = new ArrayList<>();

  public List<OverviewContext> getContexts() {
    return contexts;
  }

  public void setContexts(List<OverviewContext> contexts) {
    this.contexts = contexts;
  }

  //endregion

  //region Erlang Full Version

  @JsonProperty(value = "erlang_full_version")
  private String erlangFullVersion;

  public String getErlangFullVersion() {
    return erlangFullVersion;
  }

  public void setErlangFullVersion(String erlangFullVersion) {
    this.erlangFullVersion = erlangFullVersion;
  }

  //endregion

  //region Erlang Version

  @JsonProperty(value = "erlang_version")
  private String erlangVersion;

  public String getErlangVersion() {
    return erlangVersion;
  }

  public void setErlangVersion(String erlangVersion) {
    this.erlangVersion = erlangVersion;
  }

  //endregion

  //region Exchange Types

  @JsonProperty(value = "exchange_types")
  private List<Description> exchangeTypes = new ArrayList<>();

  public List<Description> getExchangeTypes() {
    return exchangeTypes;
  }

  public void setExchangeTypes(List<Description> exchangeTypes) {
    this.exchangeTypes = exchangeTypes;
  }

  //endregion

  //region Listeners

  @JsonProperty(value = "listeners")
  private List<Listener> listeners = new ArrayList<>();

  public List<Listener> getListeners() {
    return listeners;
  }

  public void setListeners(List<Listener> listeners) {
    this.listeners = listeners;
  }

  //endregion

  //region Management Version

  @JsonProperty(value = "management_version")
  private String managementVersion;

  public String getManagementVersion() {
    return managementVersion;
  }

  public void setManagementVersion(String managementVersion) {
    this.managementVersion = managementVersion;
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

  //region Object Totals

  @JsonProperty(value = "object_totals")
  private ObjectTotals objectTotals;

  public ObjectTotals getObjectTotals() {
    return objectTotals;
  }

  public void setObjectTotals(ObjectTotals objectTotals) {
    this.objectTotals = objectTotals;
  }

  //endregion

  //region Queue Totals

  @JsonProperty(value = "queue_totals")
  private QueueTotals queueTotals;

  public QueueTotals getQueueTotals() {
    return queueTotals;
  }

  public void setQueueTotals(QueueTotals queueTotals) {
    this.queueTotals = queueTotals;
  }

  //endregion

  //region RabbitMQ Version

  @JsonProperty(value = "rabbitmq_version")
  private String rabbitmqVersion;

  public String getRabbitmqVersion() {
    return rabbitmqVersion;
  }

  public void setRabbitmqVersion(String rabbitmqVersion) {
    this.rabbitmqVersion = rabbitmqVersion;
  }

  //endregion

  //region Rates Mode

  @JsonProperty(value = "rates_mode")
  private String ratesMode;

  public String getRatesMode() {
    return ratesMode;
  }

  public void setRatesMode(String ratesMode) {
    this.ratesMode = ratesMode;
  }

  //endregion

  //region Statistics Db Event Queue

  @JsonProperty(value = "statistics_db_event_queue")
  private int statisticsDbEventQueue;

  public int getStatisticsDbEventQueue() {
    return statisticsDbEventQueue;
  }

  public void setStatisticsDbEventQueue(int statisticsDbEventQueue) {
    this.statisticsDbEventQueue = statisticsDbEventQueue;
  }

  //endregion

  //region Statistics Db Node

  @JsonProperty(value = "statistics_db_node")
  private String statisticsDbNode;

  public String getStatisticsDbNode() {
    return statisticsDbNode;
  }

  public void setStatisticsDbNode(String statisticsDbNode) {
    this.statisticsDbNode = statisticsDbNode;
  }

  //endregion
}
