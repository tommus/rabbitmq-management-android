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
import java.util.LinkedHashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Queue {

  @JsonProperty("arguments")
  protected LinkedHashMap<String, String> arguments;

  @JsonProperty("auto_delete")
  protected boolean autoDelete;

  @JsonProperty("durable")
  protected boolean durable;

  @JsonProperty("name")
  protected String name;

  public LinkedHashMap<String, String> getArguments() {
    return arguments;
  }

  public boolean isAutoDelete() {
    return autoDelete;
  }

  public boolean isDurable() {
    return durable;
  }

  public String getName() {
    return name;
  }
}
