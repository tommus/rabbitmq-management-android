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
package com.todev.rabbitmqmanagement.models.vhosts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Details;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedVhost extends Vhost {

  @JsonProperty("messages") protected int messages;

  @JsonProperty("messages_details") protected Details messagesDetails;

  @JsonProperty("messages_ready") protected int messagesReady;

  @JsonProperty("messages_ready_details") protected Details messagesReadyDetails;

  @JsonProperty("messages_unacknowledged") protected int messagesUnacknowledged;

  @JsonProperty("messages_unacknowledged_details") protected Details messagesUnacknowledgedDetails;

  @JsonProperty("tracing") protected boolean tracing;

  public int getMessages() {
    return messages;
  }

  public Details getMessagesDetails() {
    return messagesDetails;
  }

  public int getMessagesReady() {
    return messagesReady;
  }

  public Details getMessagesReadyDetails() {
    return messagesReadyDetails;
  }

  public int getMessagesUnacknowledged() {
    return messagesUnacknowledged;
  }

  public Details getMessagesUnacknowledgedDetails() {
    return messagesUnacknowledgedDetails;
  }

  public boolean isTracing() {
    return tracing;
  }
}
