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
package com.todev.rabbitmqmanagement.models.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectTotals {

  @JsonProperty("channels") protected int channels;

  @JsonProperty("connections") protected int connections;

  @JsonProperty("consumers") protected int consumers;

  @JsonProperty("exchanges") protected int exchanges;

  @JsonProperty("queues") protected int queues;

  public int getChannels() {
    return channels;
  }

  public int getConnections() {
    return connections;
  }

  public int getConsumers() {
    return consumers;
  }

  public int getExchanges() {
    return exchanges;
  }

  public int getQueues() {
    return queues;
  }
}
