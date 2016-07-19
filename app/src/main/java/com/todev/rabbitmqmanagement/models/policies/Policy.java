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
package com.todev.rabbitmqmanagement.models.policies;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Policy {

  @JsonProperty(value = "apply-to")
  protected String applyTo;

  @JsonProperty(value = "definition")
  protected Map<String, String> definition;

  @JsonProperty(value = "name")
  protected String name;

  @JsonProperty(value = "pattern")
  protected String pattern;

  @JsonProperty(value = "priority")
  protected Integer priority;

  @JsonProperty(value = "vhost")
  protected String vhost;

  public Policy() {
    // Jackson requires presence of empty constructor.
  }

  public Policy(@NonNull String pattern, @NonNull Map<String, String> definition, @Nullable Integer priority,
      @Nullable String applyTo) {
    this.pattern = pattern;
    this.definition = definition;
    this.priority = priority;
    this.applyTo = applyTo;
  }

  public String getApplyTo() {
    return applyTo;
  }

  public Map<String, String> getDefinition() {
    return definition;
  }

  public String getName() {
    return name;
  }

  public String getPattern() {
    return pattern;
  }

  public int getPriority() {
    return priority;
  }

  public String getVhost() {
    return vhost;
  }
}
