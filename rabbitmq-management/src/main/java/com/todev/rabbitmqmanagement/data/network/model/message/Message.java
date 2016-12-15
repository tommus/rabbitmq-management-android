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
package com.todev.rabbitmqmanagement.data.network.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
public class Message {

  @JsonProperty(value = "exchange")
  protected String exchange;

  @JsonProperty(value = "message_count")
  protected int messageCount;

  @JsonProperty(value = "payload")
  protected String payload;

  @JsonProperty(value = "payload_bytes")
  protected long payloadBytes;

  @JsonProperty(value = "payload_encoding")
  protected String payloadEncoding;

  @JsonProperty(value = "properties")
  protected Properties properties;

  @JsonProperty(value = "redelivered")
  protected boolean redelivered;

  @JsonProperty(value = "routing_key")
  protected String routingKey;
}
