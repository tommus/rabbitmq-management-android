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
package com.todev.rabbitmqmanagement.core.dagger.module;

import android.app.Application;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import co.windly.rabbitmqmanagement.network.interceptor.AddressInterceptor;
import co.windly.rabbitmqmanagement.network.interceptor.AuthorizationInterceptor;
import co.windly.rabbitmqmanagement.network.interceptor.ContentTypeInterceptor;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module(includes = OkHttpModule.class)
public class NetworkModule {
  private static final String CONTENT_TYPE = "application/json";
  // 30 MB
  private static final long DISK_CACHE_SIZE = 31_457_280;

  @Provides
  @Singleton
  AuthorizationInterceptor provideAuthorizationInterceptor() {
    return new AuthorizationInterceptor();
  }

  @Provides
  @Singleton
  ContentTypeInterceptor provideContentTypeInterceptor() {
    return new ContentTypeInterceptor(CONTENT_TYPE);
  }

  @Provides
  @Singleton
  AddressInterceptor provideAddressInterceptor() {
    return new AddressInterceptor();
  }

  @Provides
  @Singleton
  OkHttpClient.Builder provideOkHttpClientBuilder(Application application,
      ContentTypeInterceptor contentTypeInterceptor, AuthorizationInterceptor authorizationInterceptor,
      AddressInterceptor addressInterceptor) {
    File cacheDir = new File(application.getCacheDir(), "http");
    Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
    return new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .cache(cache)
        .addInterceptor(contentTypeInterceptor)
        .addInterceptor(authorizationInterceptor)
        .addInterceptor(addressInterceptor);
  }

  @Provides
  @Singleton
  Converter.Factory provideConverterFactory() {
    return JacksonConverterFactory.create();
  }

  @Provides
  @Singleton
  CallAdapter.Factory provideCallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  @Provides
  @Singleton
  RabbitMqService provideRabbitMqService(OkHttpClient okHttpClient, Converter.Factory converterFactory,
      CallAdapter.Factory callAdapterFactory) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:15672/")
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .client(okHttpClient)
        .build();

    return retrofit.create(RabbitMqService.class);
  }
}
