package co.windly.rabbitmqmanagement.network.interceptor;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderAuthorizationInterceptor implements Interceptor {

  //region Constants

  private static final String AUTH_HEADER = "Authorization";

  private static final String TOKEN_FORMAT = "Basic %s";

  //endregion

  //region Interception

  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {

    // Retrieve original request.
    final Request original = chain.request();

    // Load user token.
    // TODO:
    final String token = "dXNlcjpwYXNz";

    // Prepare updated request with added token.
    final Request updated = original
      .newBuilder()
      .addHeader(AUTH_HEADER, String.format(TOKEN_FORMAT, token))
      .build();

    // Proceed with updated token.
    return chain.proceed(updated);
  }

  //endregion
}
