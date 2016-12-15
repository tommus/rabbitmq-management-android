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
package com.todev.rabbitmqmanagement.data.network.model.queue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.data.network.model.Details;
import com.todev.rabbitmqmanagement.data.network.model.MessageStats;
import com.todev.rabbitmqmanagement.data.network.model.policy.Policy;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
public class ExtendedQueue extends Queue {

  @JsonProperty(value = "backing_queue_status")
  protected BackingQueueStatus backingQueueStatus;

  @JsonProperty(value = "consumer_utilisation")
  protected Object consumerUtilisation;

  @JsonProperty(value = "consumers")
  protected int consumers;

  @JsonProperty(value = "disk_reads")
  protected int diskReads;

  @JsonProperty(value = "disk_writes")
  protected int diskWrites;

  @JsonProperty(value = "exclusive")
  protected boolean exclusive;

  @JsonProperty(value = "exclusive_consumer_tag")
  protected Object exclusiveConsumerTag;

  @JsonProperty(value = "head_message_timestamp")
  protected Object headMessageTimestamp;

  @JsonProperty(value = "idle_since")
  protected String idleSince;

  @JsonProperty(value = "memory")
  protected long memory;

  @JsonProperty(value = "message_bytes")
  protected long messageBytes;

  @JsonProperty(value = "message_bytes_persistent")
  protected long messageBytesPersistent;

  @JsonProperty(value = "message_bytes_ram")
  protected long messageBytesRam;

  @JsonProperty(value = "message_bytes_ready")
  protected long messageBytesReady;

  @JsonProperty(value = "message_bytes_unacknowledged")
  protected long messageBytesUnacknowledged;

  @JsonProperty(value = "message_stats")
  protected MessageStats messageStats;

  @JsonProperty(value = "messages")
  protected int messages;

  @JsonProperty(value = "messages_details")
  protected Details messagesDetails;

  @JsonProperty(value = "messages_persistent")
  protected int messagesPersistent;

  @JsonProperty(value = "messages_ram")
  protected long messagesRam;

  @JsonProperty(value = "messages_ready")
  protected int messagesReady;

  @JsonProperty(value = "messages_ready_details")
  protected Details messagesReadyDetails;

  @JsonProperty(value = "messages_ready_ram")
  protected long messagesReadyRam;

  @JsonProperty(value = "messages_unacknowledged")
  protected int messagesUnacknowledged;

  @JsonProperty(value = "messages_unacknowledged_details")
  protected Details messagesUnacknowledgedDetails;

  @JsonProperty(value = "messages_unacknowledged_ram")
  protected long messagesUnacknowledgedRam;

  @JsonProperty(value = "node")
  protected String node;

  @JsonProperty(value = "policy")
  protected Policy policy;

  @JsonProperty(value = "recoverable_slaves")
  protected Object recoverableSlaves;

  @JsonProperty(value = "state")
  protected String state;

  @JsonProperty(value = "vhost")
  protected String vhost;
}
