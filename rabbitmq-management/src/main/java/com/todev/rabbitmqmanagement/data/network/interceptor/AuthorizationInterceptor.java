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
package com.todev.rabbitmqmanagement.data.network.interceptor;

import android.util.Base64;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {

  private static final String HEADER_AUTHORIZATION = "Authorization";

  private static final String PREFIX_BASIC_AUTH = "Basic ";

  private String token;

  public void setCredentials(String username, String password) {
    token = generateToken(username, password);
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();
    Request.Builder builder = original.newBuilder();
    if (token != null) {
      builder = builder.header(HEADER_AUTHORIZATION, token);
    }
    return chain.proceed(builder.build());
  }

  private String generateToken(String username, String password) {
    String decoded = String.format("%s:%s", username, password);
    return PREFIX_BASIC_AUTH + Base64.encodeToString(decoded.getBytes(), Base64.NO_WRAP);
  }
}
