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
package com.todev.rabbitmqmanagement.api.service.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.todev.rabbitmqmanagement.api.model.user.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserTagsDeserializer extends JsonDeserializer<List<User.Tag>> {
  @Override
  public List<User.Tag> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    String serialized = p.getText().trim();
    StringTokenizer tokenizer = new StringTokenizer(serialized, ",");
    List<User.Tag> result = new ArrayList<>();
    User.Tag tag = User.Tag.NONE;

    while (tokenizer.hasMoreElements()) {
      String token = tokenizer.nextToken();

      try {
        tag = User.Tag.valueOf(token.toUpperCase());
      } catch (IllegalArgumentException e) {
        // Leave none type as default.
      }

      if (!result.contains(tag)) {
        result.add(tag);
      }
    }

    return result;
  }
}
