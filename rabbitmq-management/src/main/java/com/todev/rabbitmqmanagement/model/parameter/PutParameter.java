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
package com.todev.rabbitmqmanagement.model.parameter;

import android.support.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PutParameter {

  @JsonProperty(value = "component")
  protected String component;

  @JsonProperty(value = "name")
  protected String name;

  @JsonProperty(value = "value")
  protected String value;

  @JsonProperty(value = "vhost")
  protected String vhost;

  public PutParameter(@NonNull String vhost, @NonNull String component, @NonNull String name, @NonNull String value) {
    this.vhost = vhost;
    this.component = component;
    this.name = name;
    this.value = value;
  }
}
