package com.todev.rabbitmqmanagement.core.dagger.module;

import android.app.Application;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module(includes = OkHttpModule.class)
public class NetworkModule {

  // 30 MB
  private static final long DISK_CACHE_SIZE = 31_457_280;

  @Provides
  @Singleton
  OkHttpClient.Builder provideOkHttpClientBuilder(Application application) {
    File cacheDir = new File(application.getCacheDir(), "http");
    Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
    return new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
      .readTimeout(20, TimeUnit.SECONDS)
      .writeTimeout(20, TimeUnit.SECONDS)
      .cache(cache);
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
}
