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
package com.todev.rabbitmqmanagement.model.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.model.MessageStats;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Channel {

  @JsonProperty(value = "acks_uncommitted")
  protected int acksUncommitted;

  @JsonProperty(value = "confirm")
  protected boolean confirm;

  @JsonProperty(value = "connection_details")
  protected ChannelDetails connectionDetails;

  @JsonProperty(value = "consumer_count")
  protected int consumerCount;

  @JsonProperty(value = "global_prefetch_count")
  protected int globalPrefetchCount;

  @JsonProperty(value = "idle_since")
  protected String idleSince;

  @JsonProperty(value = "message_stats")
  protected MessageStats messageStats;

  @JsonProperty(value = "messages_unacknowledged")
  protected int messagesUnacknowledged;

  @JsonProperty(value = "messages_uncommitted")
  protected int messagesUncommitted;

  @JsonProperty(value = "messages_unconfirmed")
  protected int messagesUnconfirmed;

  @JsonProperty(value = "name")
  protected String name;

  @JsonProperty(value = "node")
  protected String node;

  @JsonProperty(value = "number")
  protected int number;

  @JsonProperty(value = "prefetch_count")
  protected int prefetchCount;

  @JsonProperty(value = "state")
  protected String state;

  @JsonProperty(value = "transactional")
  protected boolean transactional;

  @JsonProperty(value = "user")
  protected String user;

  @JsonProperty(value = "vhost")
  protected String vhost;

  public int getAcksUncommitted() {
    return acksUncommitted;
  }

  public boolean isConfirm() {
    return confirm;
  }

  public ChannelDetails getConnectionDetails() {
    return connectionDetails;
  }

  public int getConsumerCount() {
    return consumerCount;
  }

  public int getGlobalPrefetchCount() {
    return globalPrefetchCount;
  }

  public String getIdleSince() {
    return idleSince;
  }

  public MessageStats getMessageStats() {
    return messageStats;
  }

  public int getMessagesUnacknowledged() {
    return messagesUnacknowledged;
  }

  public int getMessagesUncommitted() {
    return messagesUncommitted;
  }

  public int getMessagesUnconfirmed() {
    return messagesUnconfirmed;
  }

  public String getName() {
    return name;
  }

  public String getNode() {
    return node;
  }

  public int getNumber() {
    return number;
  }

  public int getPrefetchCount() {
    return prefetchCount;
  }

  public String getState() {
    return state;
  }

  public boolean isTransactional() {
    return transactional;
  }

  public String getUser() {
    return user;
  }

  public String getVhost() {
    return vhost;
  }
}
