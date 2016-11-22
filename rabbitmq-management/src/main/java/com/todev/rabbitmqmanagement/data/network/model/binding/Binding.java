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
package com.todev.rabbitmqmanagement.data.network.model.binding;

import android.support.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Binding {

  @JsonProperty(value = "arguments") protected Map<String, String> bindingArguments;

  @JsonProperty(value = "destination") protected String destination;

  @JsonProperty(value = "destination_type") protected String destinationType;

  @JsonProperty(value = "routing_key") protected String routingKey;

  @JsonProperty(value = "source") protected String source;

  public Binding() {
    // Jackson requires presence of empty constructor.
  }

  public Binding(@NonNull String routingKey, @NonNull Map<String, String> bindingArguments) {
    this.routingKey = routingKey;
    this.bindingArguments = bindingArguments;
  }

  public Map<String, String> getArguments() {
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