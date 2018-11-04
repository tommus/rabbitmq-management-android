package co.windly.rabbitmqmanagement.network.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.converter.jackson.JacksonConverterFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Error {

  //region Constructor

  private Error(String error, String reason) {
    this.error = error;
    this.reason = reason;
  }

  //endregion

  //region Error

  @JsonProperty("error")
  private String error;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  //endregion

  //region Reason

  @JsonProperty("reason")
  private String reason;

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  //endregion

  //region Factory Method

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

  //endregion
}
