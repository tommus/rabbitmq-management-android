package co.windly.rabbitmqmanagement.network;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static co.windly.rabbitmqmanagement.utility.BuildConfig.SERVER_CONNECTION_TIMEOUT;
import static co.windly.rabbitmqmanagement.utility.BuildConfig.SERVER_LOGGING_LEVEL;
import static co.windly.rabbitmqmanagement.utility.BuildConfig.SERVER_READ_TIMEOUT;
import static co.windly.rabbitmqmanagement.utility.BuildConfig.SERVER_WRITE_TIMEOUT;
import static java.util.concurrent.TimeUnit.SECONDS;

@Module
public class NetworkModule {

  //region Api

  // TODO:

  //endregion

  //region Retrofit

  @Provides
  @NonNull
  @Singleton
  Retrofit provideServerRetrofit(Retrofit.Builder builder, String url) {
    return builder
      .baseUrl(url)
      .build();
  }

  @Provides
  @NonNull
  @Singleton
  String provideServerUrl() {
    // TODO: Change url scope.
    // TODO: Use url provided by configuration.
    return "http://";
  }

  //endregion

  //region Retrofit - Builder

  @Provides
  @NonNull
  @Singleton
  Retrofit.Builder provideRetrofitBuilder(
    OkHttpClient client,
    Converter.Factory converterFactory,
    CallAdapter.Factory callAdapterFactory) {
    return new Retrofit.Builder()
      .addConverterFactory(converterFactory)
      .addCallAdapterFactory(callAdapterFactory)
      .client(client);
  }

  //endregion

  //region Retrofit - Factories

  @Provides
  @NonNull
  @Singleton
  Converter.Factory provideConverterFactory() {
    return JacksonConverterFactory.create();
  }

  @Provides
  @NonNull
  @Singleton
  CallAdapter.Factory provideCallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  //endregion

  //region Retrofit - Http

  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
    return builder
      // TODO: Add authorization interceptor.
      .build();
  }

  @Provides
  @NonNull
  @Singleton
  OkHttpClient.Builder provideOkHttpClientBuilder(HttpLoggingInterceptor.Level networkLogLevel) {
    return new OkHttpClient.Builder()
      .connectTimeout(SERVER_CONNECTION_TIMEOUT, SECONDS)
      .readTimeout(SERVER_READ_TIMEOUT, SECONDS)
      .writeTimeout(SERVER_WRITE_TIMEOUT, SECONDS)
      // TODO: Add header user agent interceptor.
      .addInterceptor(new HttpLoggingInterceptor().setLevel(networkLogLevel));
  }

  @Provides
  @NonNull
  @Singleton
  HttpLoggingInterceptor.Level provideLogLevel() {
    return HttpLoggingInterceptor.Level.valueOf(SERVER_LOGGING_LEVEL.trim().toUpperCase());
  }

  //endregion
}
