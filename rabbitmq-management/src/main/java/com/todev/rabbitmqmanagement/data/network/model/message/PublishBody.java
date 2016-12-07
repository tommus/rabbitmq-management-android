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
package com.todev.rabbitmqmanagement.data.network.model.message;

import android.support.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class PublishBody {

  @JsonProperty(value = "payload") protected String payload;

  @JsonProperty(value = "payload_encoding") protected String payloadEncoding;

  @JsonProperty(value = "properties") protected Map<String, String> properties;

  @JsonProperty(value = "routing_key") protected String routingKey;

  public PublishBody(@NonNull String payload, @NonNull String payloadEncoding, @NonNull Map<String, String> properties,
      @NonNull String routingKey) {
    this.payload = payload;
    this.payloadEncoding = payloadEncoding;
    this.properties = properties;
    this.routingKey = routingKey;
  }
}
