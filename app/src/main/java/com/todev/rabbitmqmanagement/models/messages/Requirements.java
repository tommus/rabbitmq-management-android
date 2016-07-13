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
package com.todev.rabbitmqmanagement.models.messages;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Requirements {

  @JsonProperty(value = "count")
  protected int count;

  @JsonProperty(value = "requeue")
  protected boolean requeue;

  @JsonProperty(value = "encoding")
  protected String encoding;

  @JsonProperty(value = "truncate")
  protected Long truncate;

  public Requirements(int count, boolean requeue, @NonNull String encoding,
      @Nullable Long truncate) {
    this.count = count;
    this.requeue = requeue;
    this.encoding = encoding;
    this.truncate = truncate;
  }
}
