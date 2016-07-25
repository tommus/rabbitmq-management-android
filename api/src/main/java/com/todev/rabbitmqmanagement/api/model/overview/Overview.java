/*
 * Copyright (c) 2016 to-dev.com.
 *
 * Licensed under the GNU GPL, Version 3 (the "License").
 * You may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *       https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.todev.rabbitmqmanagement.api.model.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.api.model.Description;
import com.todev.rabbitmqmanagement.api.model.MessageStats;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Overview {

  @JsonProperty(value = "cluster_name")
  protected String clusterName;

  @JsonProperty(value = "contexts")
  protected List<OverviewContext> contexts = new ArrayList<>();

  @JsonProperty(value = "erlang_full_version")
  protected String erlangFullVersion;

  @JsonProperty(value = "erlang_version")
  protected String erlangVersion;

  @JsonProperty(value = "exchange_types")
  protected List<Description> exchangeTypes = new ArrayList<>();

  @JsonProperty(value = "listeners")
  protected List<Listener> listeners = new ArrayList<>();

  @JsonProperty(value = "management_version")
  protected String managementVersion;

  @JsonProperty(value = "message_stats")
  protected MessageStats messageStats;

  @JsonProperty(value = "node")
  protected String node;

  @JsonProperty(value = "object_totals")
  protected ObjectTotals objectTotals;

  @JsonProperty(value = "queue_totals")
  protected QueueTotals queueTotals;

  @JsonProperty(value = "rabbitmq_version")
  protected String rabbitmqVersion;

  @JsonProperty(value = "rates_mode")
  protected String ratesMode;

  @JsonProperty(value = "statistics_db_event_queue")
  protected int statisticsDbEventQueue;

  @JsonProperty(value = "statistics_db_node")
  protected String statisticsDbNode;

  public String getClusterName() {
    return clusterName;
  }

  public List<OverviewContext> getContexts() {
    return contexts;
  }

  public String getErlangFullVersion() {
    return erlangFullVersion;
  }

  public String getErlangVersion() {
    return erlangVersion;
  }

  public List<Description> getExchangeTypes() {
    return exchangeTypes;
  }

  public List<Listener> getListeners() {
    return listeners;
  }

  public String getManagementVersion() {
    return managementVersion;
  }

  public MessageStats getMessageStats() {
    return messageStats;
  }

  public String getNode() {
    return node;
  }

  public ObjectTotals getObjectTotals() {
    return objectTotals;
  }

  public QueueTotals getQueueTotals() {
    return queueTotals;
  }

  public String getRabbitmqVersion() {
    return rabbitmqVersion;
  }

  public String getRatesMode() {
    return ratesMode;
  }

  public Integer getStatisticsDbEventQueue() {
    return statisticsDbEventQueue;
  }

  public String getStatisticsDbNode() {
    return statisticsDbNode;
  }
}
