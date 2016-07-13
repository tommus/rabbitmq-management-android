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
package com.todev.rabbitmqmanagement.service.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.todev.rabbitmqmanagement.models.queues.Action;
import java.io.IOException;

public class ActionTypeDeserializer extends JsonDeserializer<Action.Type> {
  @Override
  public Action.Type deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    String serialized = p.getText().trim();
    try {
      return Action.Type.valueOf(serialized.toUpperCase());
    } catch (IllegalArgumentException e) {
      return Action.Type.SYNC;
    }
  }
}
