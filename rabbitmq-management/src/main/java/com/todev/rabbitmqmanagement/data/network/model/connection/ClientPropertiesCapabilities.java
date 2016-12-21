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
package com.todev.rabbitmqmanagement.data.network.model.connection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
public class ClientPropertiesCapabilities {

  @JsonProperty(value = "authentication_failure_close")
  protected boolean authenticationFailureClose;

  @JsonProperty(value = "basic.nack")
  protected boolean basicNack;

  @JsonProperty(value = "connection.blocked")
  protected boolean connectionBlocked;

  @JsonProperty(value = "consumer_cancel_notify")
  protected boolean consumerCancelNotify;

  @JsonProperty(value = "publisher_confirms")
  protected boolean publisherConfirms;
}