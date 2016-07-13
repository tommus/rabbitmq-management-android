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
package com.todev.rabbitmqmanagement.models.consumers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Consumer {
  @JsonProperty(value = "ack_required")
  protected boolean ackRequired;

  @JsonProperty(value = "arguments")
  protected Map<String, String> arguments;

  @JsonProperty(value = "channel_details")
  protected ConsumerChannelDetails channelDetails;

  @JsonProperty(value = "consumer_tag")
  protected String consumerTag;

  @JsonProperty(value = "exclusive")
  protected boolean exclusive;

  @JsonProperty(value = "prefetch_count")
  protected int prefetchCount;

  @JsonProperty(value = "queue")
  protected ConsumerQueue queue;

  public boolean isAckRequired() {
    return ackRequired;
  }

  public Map<String, String> getArguments() {
    return arguments;
  }

  public ConsumerChannelDetails getChannelDetails() {
    return channelDetails;
  }

  public String getConsumerTag() {
    return consumerTag;
  }

  public boolean isExclusive() {
    return exclusive;
  }

  public int getPrefetchCount() {
    return prefetchCount;
  }

  public ConsumerQueue getQueue() {
    return queue;
  }
}
