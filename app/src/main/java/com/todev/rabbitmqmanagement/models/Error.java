package com.todev.rabbitmqmanagement.models;

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

  @JsonProperty("error")
  protected String error;

  @JsonProperty("reason")
  protected String reason;

  public Error() {
    // Jackson requires presence of empty constructor.
  }

  public Error(String error, String reason) {
    this.error = error;
    this.reason = reason;
  }

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

  public String getError() {
    return error;
  }

  public String getReason() {
    return reason;
  }
}
