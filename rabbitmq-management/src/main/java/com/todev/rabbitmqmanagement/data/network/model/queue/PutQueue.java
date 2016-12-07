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

import android.support.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PutQueue {

  @JsonProperty(value = "arguments") protected Map<String, String> arguments;

  @JsonProperty(value = "auto_delete") protected Boolean autoDelete;

  @JsonProperty(value = "durable") protected Boolean durable;

  @JsonProperty(value = "node") protected String node;

  public PutQueue(@Nullable Boolean autoDelete, @Nullable Boolean durable, @Nullable Map<String, String> arguments,
    @Nullable String node) {
    this.autoDelete = autoDelete;
    this.durable = durable;
    this.arguments = arguments;
    this.node = node;
  }
}
