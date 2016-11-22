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
package com.todev.rabbitmqmanagement.data.network.model.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.data.network.model.Details;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QueueTotals {

  @JsonProperty(value = "messages") protected int messages;

  @JsonProperty(value = "messages_details") protected Details messagesDetails;

  @JsonProperty(value = "messages_ready") protected int messagesReady;

  @JsonProperty(value = "messages_ready_details") protected Details messagesReadyDetails;

  @JsonProperty(value = "messages_unacknowledged") protected int messagesUnacknowledged;

  @JsonProperty(value = "messages_unacknowledged_details") protected Details messagesUnacknowledgedDetails;

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
}
