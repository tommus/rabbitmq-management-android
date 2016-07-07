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
package com.todev.rabbitmqmanagement.services.interceptors;

import android.util.Base64;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {

  private static final String HEADER_AUTHORIZATION = "Authorization";

  private static final String PREFIX_BASIC_AUTH = "Basic ";

  private String token;

  public AuthorizationInterceptor(String username, String password) {
    this.token = generateToken(username, password);
  }

  public AuthorizationInterceptor(String token) {
    this.token = token;
  }

  @Override public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();
    Request intercepted = original.newBuilder().header(HEADER_AUTHORIZATION, token).build();
    return chain.proceed(intercepted);
  }

  private String generateToken(String username, String password) {
    String decoded = String.format("%s:%s", username, password);
    return PREFIX_BASIC_AUTH + Base64.encodeToString(decoded.getBytes(), Base64.NO_WRAP);
  }
}
