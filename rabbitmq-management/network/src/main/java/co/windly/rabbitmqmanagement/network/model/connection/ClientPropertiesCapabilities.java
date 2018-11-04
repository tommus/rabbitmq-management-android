package co.windly.rabbitmqmanagement.network.model.connection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ClientPropertiesCapabilities {

  //region Authentication Failure Close

  @JsonProperty(value = "authentication_failure_close")
  private boolean authenticationFailureClose;

  public boolean isAuthenticationFailureClose() {
    return authenticationFailureClose;
  }

  public void setAuthenticationFailureClose(boolean authenticationFailureClose) {
    this.authenticationFailureClose = authenticationFailureClose;
  }

  //endregion

  //region Basic Nack

  @JsonProperty(value = "basic.nack")
  private boolean basicNack;

  public boolean isBasicNack() {
    return basicNack;
  }

  public void setBasicNack(boolean basicNack) {
    this.basicNack = basicNack;
  }

  //endregion

  //region Connection Blocked

  @JsonProperty(value = "connection.blocked")
  private boolean connectionBlocked;

  public boolean isConnectionBlocked() {
    return connectionBlocked;
  }

  public void setConnectionBlocked(boolean connectionBlocked) {
    this.connectionBlocked = connectionBlocked;
  }

  //endregion

  //region Consumer Cancel Notify

  @JsonProperty(value = "consumer_cancel_notify")
  private boolean consumerCancelNotify;

  public boolean isConsumerCancelNotify() {
    return consumerCancelNotify;
  }

  public void setConsumerCancelNotify(boolean consumerCancelNotify) {
    this.consumerCancelNotify = consumerCancelNotify;
  }

  //endregion

  //region Publisher Confirms

  @JsonProperty(value = "publisher_confirms")
  private boolean publisherConfirms;

  public boolean isPublisherConfirms() {
    return publisherConfirms;
  }

  public void setPublisherConfirms(boolean publisherConfirms) {
    this.publisherConfirms = publisherConfirms;
  }

  //endregion
}
