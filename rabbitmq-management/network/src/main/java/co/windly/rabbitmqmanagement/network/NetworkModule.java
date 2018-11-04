package co.windly.rabbitmqmanagement.network;

import co.windly.rabbitmqmanagement.network.interceptor.HeaderAuthorizationInterceptor;
import co.windly.rabbitmqmanagement.network.interceptor.HeaderUserAgentInterceptor;
import co.windly.rabbitmqmanagement.network.service.UserApi;
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

  @NonNull
  @Provides
  @Singleton
  UserApi provideUserApi(Retrofit retrofit) {
    return retrofit.create(UserApi.class);
  }

  //endregion

  //region Retrofit

  @NonNull
  @Provides
  @Singleton
  Retrofit provideServerRetrofit(Retrofit.Builder builder, String url) {
    return builder
      .baseUrl(url)
      .build();
  }

  @NonNull
  @Provides
  @Singleton
  String provideServerUrl() {
    // TODO: Change url scope.
    // TODO: Use url provided by configuration.
    return "http://192.168.1.102:15672/";
  }

  //endregion

  //region Retrofit - Builder

  @NonNull
  @Provides
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

  @NonNull
  @Provides
  @Singleton
  Converter.Factory provideConverterFactory() {
    return JacksonConverterFactory.create();
  }

  @NonNull
  @Provides
  @Singleton
  CallAdapter.Factory provideCallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  //endregion

  //region Retrofit - Http

  @NonNull
  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
    return builder
      .addInterceptor(new HeaderAuthorizationInterceptor())
      .build();
  }

  @NonNull
  @Provides
  @Singleton
  OkHttpClient.Builder provideOkHttpClientBuilder(HttpLoggingInterceptor.Level networkLogLevel) {
    return new OkHttpClient.Builder()
      .connectTimeout(SERVER_CONNECTION_TIMEOUT, SECONDS)
      .readTimeout(SERVER_READ_TIMEOUT, SECONDS)
      .writeTimeout(SERVER_WRITE_TIMEOUT, SECONDS)
      .addInterceptor(new HeaderUserAgentInterceptor())
      .addInterceptor(new HttpLoggingInterceptor().setLevel(networkLogLevel));
  }

  @NonNull
  @Provides
  @Singleton
  HttpLoggingInterceptor.Level provideLogLevel() {
    return HttpLoggingInterceptor.Level.valueOf(SERVER_LOGGING_LEVEL.trim().toUpperCase());
  }

  //endregion
}
