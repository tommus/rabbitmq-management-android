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
package com.todev.rabbitmqmanagement.data.network.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.converter.jackson.JacksonConverterFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Error {

  @JsonProperty("error")
  protected String error;

  @JsonProperty("reason")
  protected String reason;

  public static Error fromBody(ResponseBody body) {
    Converter<ResponseBody, ?> converter =
        JacksonConverterFactory.create().responseBodyConverter(Error.class, null, null);

    Error error;

    try {
      error = (Error) converter.convert(body);
    } catch (IOException e) {
      error = new Error("error_deserialization_error", "Cannot deserialize real error.");
    }

    return error;
  }
}
