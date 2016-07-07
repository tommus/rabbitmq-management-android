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
package com.todev.rabbitmqmanagement.models.channels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.MessageStats;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class Channel {

  @JsonProperty("acks_uncommitted") protected int acksUncommitted;

  @JsonProperty("confirm") protected boolean confirm;

  @JsonProperty("connection_details") protected ChannelDetails connectionDetails;

  @JsonProperty("consumer_count") protected int consumerCount;

  @JsonProperty("global_prefetch_count") protected int globalPrefetchCount;

  @JsonProperty("idle_since") protected String idleSince;

  @JsonProperty("message_stats") protected MessageStats messageStats;

  @JsonProperty("messages_unacknowledged") protected int messagesUnacknowledged;

  @JsonProperty("messages_uncommitted") protected int messagesUncommitted;

  @JsonProperty("messages_unconfirmed") protected int messagesUnconfirmed;

  @JsonProperty("name") protected String name;

  @JsonProperty("node") protected String node;

  @JsonProperty("number") protected int number;

  @JsonProperty("prefetch_count") protected int prefetchCount;

  @JsonProperty("state") protected String state;

  @JsonProperty("transactional") protected boolean transactional;

  @JsonProperty("user") protected String user;

  @JsonProperty("vhost") protected String vhost;

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
