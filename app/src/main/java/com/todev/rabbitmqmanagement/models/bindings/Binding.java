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

package com.todev.rabbitmqmanagement.models.bindings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class Binding {

  @JsonProperty("arguments") protected BindingArguments bindingArguments;

  @JsonProperty("destination") protected String destination;

  @JsonProperty("destination_type") protected String destinationType;

  @JsonProperty("routing_key") protected String routingKey;

  @JsonProperty("source") protected String source;

  public BindingArguments getArguments() {
    return bindingArguments;
  }

  public String getDestination() {
    return destination;
  }

  public String getDestinationType() {
    return destinationType;
  }

  public String getRoutingKey() {
    return routingKey;
  }

  public String getSource() {
    return source;
  }
}
