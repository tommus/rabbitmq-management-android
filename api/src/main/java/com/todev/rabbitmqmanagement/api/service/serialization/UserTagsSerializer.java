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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.todev.rabbitmqmanagement.api.model.user.User;
import java.io.IOException;
import java.util.List;

public class UserTagsSerializer extends JsonSerializer<List<User.Tag>> {
  @Override
  public void serialize(List<User.Tag> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    StringBuilder builder = new StringBuilder();
    for (User.Tag tag : value) {
      builder.append(tag.toString().toLowerCase());
      builder.append(',');
    }
    String result = builder.toString();
    if (result.endsWith(",")) {
      result = result.substring(0, result.length() - 1);
    }
    gen.writeString(result);
  }
}
