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
package com.todev.rabbitmqmanagement.data.network.model.user;

import android.support.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExtendedUser extends User {

  @JsonProperty(value = "hashing_algorithm") protected String hashingAlgorithm;

  @JsonProperty(value = "password_hash") protected String passwordHash;

  @JsonProperty(value = "password") protected String password;

  protected ExtendedUser() {
    // Jackson requires presence of empty constructor.
  }

  public ExtendedUser(@NonNull String password, @NonNull List<Tag> tags) {
    this.password = password;
    this.tags = tags;
  }

  public String getHashingAlgorithm() {
    return hashingAlgorithm;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public String getPassword() {
    return password;
  }
}
