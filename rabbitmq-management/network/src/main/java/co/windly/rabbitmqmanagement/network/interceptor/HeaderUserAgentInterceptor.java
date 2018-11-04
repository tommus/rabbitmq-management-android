package co.windly.rabbitmqmanagement.network.interceptor;

import io.reactivex.annotations.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderUserAgentInterceptor implements Interceptor {

  //region Constants

  private static final String USER_AGENT_HEADER = "User-Agent";

  private static final String USER_AGENT = "RabbitMQ Management";

  //endregion

  //region Interception

  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {

    final Request original = chain.request();

    // Application name is available - proceed with user agent.
    final Request updated = original
      .newBuilder()
      .removeHeader(USER_AGENT_HEADER)
      .addHeader(USER_AGENT_HEADER, USER_AGENT)
      .build();

    return chain.proceed(updated);
  }

  //endregion
}
