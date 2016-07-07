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
package com.todev.rabbitmqmanagement.models.queues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Details;
import com.todev.rabbitmqmanagement.models.MessageStats;
import com.todev.rabbitmqmanagement.models.definitions.Policy;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedQueue extends Queue {

  @JsonProperty("backing_queue_status") protected BackingQueueStatus backingQueueStatus;

  @JsonProperty("consumer_utilisation") protected Object consumerUtilisation;

  @JsonProperty("consumers") protected int consumers;

  @JsonProperty("disk_reads") protected int diskReads;

  @JsonProperty("disk_writes") protected int diskWrites;

  @JsonProperty("exclusive") protected boolean exclusive;

  @JsonProperty("exclusive_consumer_tag") protected Object exclusiveConsumerTag;

  @JsonProperty("head_message_timestamp") protected Object headMessageTimestamp;

  @JsonProperty("idle_since") protected String idleSince;

  @JsonProperty("memory") protected long memory;

  @JsonProperty("message_bytes") protected long messageBytes;

  @JsonProperty("message_bytes_persistent") protected long messageBytesPersistent;

  @JsonProperty("message_bytes_ram") protected long messageBytesRam;

  @JsonProperty("message_bytes_ready") protected long messageBytesReady;

  @JsonProperty("message_bytes_unacknowledged") protected long messageBytesUnacknowledged;

  @JsonProperty("message_stats") protected MessageStats messageStats;

  @JsonProperty("messages") protected int messages;

  @JsonProperty("messages_details") protected Details messagesDetails;

  @JsonProperty("messages_persistent") protected int messagesPersistent;

  @JsonProperty("messages_ram") protected long messagesRam;

  @JsonProperty("messages_ready") protected int messagesReady;

  @JsonProperty("messages_ready_details") protected Details messagesReadyDetails;

  @JsonProperty("messages_ready_ram") protected long messagesReadyRam;

  @JsonProperty("messages_unacknowledged") protected int messagesUnacknowledged;

  @JsonProperty("messages_unacknowledged_details") protected Details messagesUnacknowledgedDetails;

  @JsonProperty("messages_unacknowledged_ram") protected long messagesUnacknowledgedRam;

  @JsonProperty("node") protected String node;

  @JsonProperty("policy") protected Policy policy;

  @JsonProperty("recoverable_slaves") protected Object recoverableSlaves;

  @JsonProperty("state") protected String state;

  @JsonProperty("vhost") protected String vhost;

  public BackingQueueStatus getBackingQueueStatus() {
    return backingQueueStatus;
  }

  public Object getConsumerUtilisation() {
    return consumerUtilisation;
  }

  public int getConsumers() {
    return consumers;
  }

  public int getDiskReads() {
    return diskReads;
  }

  public int getDiskWrites() {
    return diskWrites;
  }

  public boolean isExclusive() {
    return exclusive;
  }

  public Object getExclusiveConsumerTag() {
    return exclusiveConsumerTag;
  }

  public Object getHeadMessageTimestamp() {
    return headMessageTimestamp;
  }

  public String getIdleSince() {
    return idleSince;
  }

  public long getMemory() {
    return memory;
  }

  public long getMessageBytes() {
    return messageBytes;
  }

  public long getMessageBytesPersistent() {
    return messageBytesPersistent;
  }

  public long getMessageBytesRam() {
    return messageBytesRam;
  }

  public long getMessageBytesReady() {
    return messageBytesReady;
  }

  public long getMessageBytesUnacknowledged() {
    return messageBytesUnacknowledged;
  }

  public MessageStats getMessageStats() {
    return messageStats;
  }

  public int getMessages() {
    return messages;
  }

  public Details getMessagesDetails() {
    return messagesDetails;
  }

  public int getMessagesPersistent() {
    return messagesPersistent;
  }

  public long getMessagesRam() {
    return messagesRam;
  }

  public int getMessagesReady() {
    return messagesReady;
  }

  public Details getMessagesReadyDetails() {
    return messagesReadyDetails;
  }

  public long getMessagesReadyRam() {
    return messagesReadyRam;
  }

  public int getMessagesUnacknowledged() {
    return messagesUnacknowledged;
  }

  public Details getMessagesUnacknowledgedDetails() {
    return messagesUnacknowledgedDetails;
  }

  public long getMessagesUnacknowledgedRam() {
    return messagesUnacknowledgedRam;
  }

  public String getNode() {
    return node;
  }

  public Policy getPolicy() {
    return policy;
  }

  public Object getRecoverableSlaves() {
    return recoverableSlaves;
  }

  public String getState() {
    return state;
  }

  public String getVhost() {
    return vhost;
  }
}
