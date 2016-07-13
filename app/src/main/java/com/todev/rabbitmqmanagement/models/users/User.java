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
package com.todev.rabbitmqmanagement.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.todev.rabbitmqmanagement.service.serialization.UserTagsDeserializer;
import com.todev.rabbitmqmanagement.service.serialization.UserTagsSerializer;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class User {

  @JsonProperty(value = "name")
  protected String name;

  @JsonDeserialize(using = UserTagsDeserializer.class)
  @JsonProperty(value = "tags")
  @JsonSerialize(using = UserTagsSerializer.class)
  protected List<Tag> tags;

  public String getName() {
    return name;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public enum Tag {
    ADMINISTRATOR, MONITORING, POLICYMAKER, MANAGEMENT, NONE
  }
}
