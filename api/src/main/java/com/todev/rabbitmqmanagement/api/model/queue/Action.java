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
package com.todev.rabbitmqmanagement.api.model.queue;

import android.support.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.todev.rabbitmqmanagement.api.service.serialization.ActionTypeDeserializer;
import com.todev.rabbitmqmanagement.api.service.serialization.ActionTypeSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Action {

  public static final Action SYNC = new Action(Type.SYNC);

  public static final Action CANCEL_SYNC = new Action(Type.CANCEL_SYNC);

  @JsonDeserialize(using = ActionTypeDeserializer.class)
  @JsonProperty(value = "action")
  @JsonSerialize(using = ActionTypeSerializer.class)
  protected Type action;

  protected Action(@NonNull Type action) {
    this.action = action;
  }

  public enum Type {
    SYNC, CANCEL_SYNC
  }
}
