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
package com.todev.rabbitmqmanagement.data.network.model.exchange;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.todev.rabbitmqmanagement.data.network.serialization.ExchangeTypeDeserializer;
import com.todev.rabbitmqmanagement.data.network.serialization.ExchangeTypeSerializer;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Exchange {

  @JsonProperty(value = "arguments") protected Map<String, String> arguments;

  @JsonProperty(value = "auto_delete") protected boolean autoDelete;

  @JsonProperty(value = "durable") protected boolean durable;

  @JsonProperty(value = "internal") protected boolean internal;

  @JsonProperty(value = "name") protected String name;

  @JsonDeserialize(using = ExchangeTypeDeserializer.class) @JsonProperty(value = "type")
  @JsonSerialize(using = ExchangeTypeSerializer.class) protected Type type;

  protected Exchange() {
    // Jackson requires presence of empty constructor.
  }

  public Exchange(@NonNull Type type, boolean autoDelete, boolean durable, boolean internal,
    @Nullable Map<String, String> arguments) {
    this.type = type;
    this.autoDelete = autoDelete;
    this.durable = durable;
    this.internal = internal;
    this.arguments = arguments;
  }

  public Map<String, String> getArguments() {
    return arguments;
  }

  public boolean isAutoDelete() {
    return autoDelete;
  }

  public boolean isDurable() {
    return durable;
  }

  public boolean isInternal() {
    return internal;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  public enum Type {
    DIRECT, FANOUT, HEADERS, TOPIC
  }
}
