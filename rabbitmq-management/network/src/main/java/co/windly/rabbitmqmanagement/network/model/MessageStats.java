package co.windly.rabbitmqmanagement.network.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MessageStats {

  //region Ack

  @JsonProperty(value = "ack")
  private int ack;

  public int getAck() {
    return ack;
  }

  public void setAck(int ack) {
    this.ack = ack;
  }

  //endregion

  //region Ack Details

  @JsonProperty(value = "ack_details")
  private Details ackDetails;

  public Details getAckDetails() {
    return ackDetails;
  }

  public void setAckDetails(Details ackDetails) {
    this.ackDetails = ackDetails;
  }

  //endregion

  //region Confirm

  @JsonProperty(value = "confirm")
  private int confirm;

  public int getConfirm() {
    return confirm;
  }

  public void setConfirm(int confirm) {
    this.confirm = confirm;
  }

  //endregion

  //region Confirm Details

  @JsonProperty(value = "confirm_details")
  private Details confirmDetails;

  public Details getConfirmDetails() {
    return confirmDetails;
  }

  public void setConfirmDetails(Details confirmDetails) {
    this.confirmDetails = confirmDetails;
  }

  //endregion

  //region Deliver Get

  @JsonProperty(value = "deliver_get")
  private int deliverGet;

  public int getDeliverGet() {
    return deliverGet;
  }

  public void setDeliverGet(int deliverGet) {
    this.deliverGet = deliverGet;
  }

  //endregion

  //region Deliver Get Details

  @JsonProperty(value = "deliver_get_details")
  private Details deliverGetDetails;

  public Details getDeliverGetDetails() {
    return deliverGetDetails;
  }

  public void setDeliverGetDetails(Details deliverGetDetails) {
    this.deliverGetDetails = deliverGetDetails;
  }

  //endregion

  //region Publish

  @JsonProperty(value = "publish")
  private int publish;

  public int getPublish() {
    return publish;
  }

  public void setPublish(int publish) {
    this.publish = publish;
  }

  //endregion

  //region Publish Details

  @JsonProperty(value = "publish_details")
  private Details publishDetails;

  public Details getPublishDetails() {
    return publishDetails;
  }

  public void setPublishDetails(Details publishDetails) {
    this.publishDetails = publishDetails;
  }

  //endregion

  //region Publish In

  @JsonProperty(value = "publish_in")
  private int publishIn;

  public int getPublishIn() {
    return publishIn;
  }

  public void setPublishIn(int publishIn) {
    this.publishIn = publishIn;
  }

  //endregion

  //region Publish In Details

  @JsonProperty(value = "publish_in_details")
  private Details publishInDetails;

  public Details getPublishInDetails() {
    return publishInDetails;
  }

  public void setPublishInDetails(Details publishInDetails) {
    this.publishInDetails = publishInDetails;
  }

  //endregion

  //region Publish Out

  @JsonProperty(value = "publish_out")
  private int publishOut;

  public int getPublishOut() {
    return publishOut;
  }

  public void setPublishOut(int publishOut) {
    this.publishOut = publishOut;
  }

  //endregion

  //region Publish Out Details

  @JsonProperty(value = "publish_out_details")
  private Details publishOutDetails;

  public Details getPublishOutDetails() {
    return publishOutDetails;
  }

  public void setPublishOutDetails(Details publishOutDetails) {
    this.publishOutDetails = publishOutDetails;
  }

  //endregion

  //region Redeliver

  @JsonProperty(value = "redeliver")
  private int redeliver;

  public int getRedeliver() {
    return redeliver;
  }

  public void setRedeliver(int redeliver) {
    this.redeliver = redeliver;
  }

  //endregion

  //region Redeliver Details

  @JsonProperty(value = "redeliver_details")
  private Details redeliverDetails;

  public Details getRedeliverDetails() {
    return redeliverDetails;
  }

  public void setRedeliverDetails(Details redeliverDetails) {
    this.redeliverDetails = redeliverDetails;
  }

  //endregion

  //region Return Unroutable

  @JsonProperty(value = "return_unroutable")
  private int returnUnroutable;

  public int getReturnUnroutable() {
    return returnUnroutable;
  }

  public void setReturnUnroutable(int returnUnroutable) {
    this.returnUnroutable = returnUnroutable;
  }

  //endregion

  //region Return Unroutable Details

  @JsonProperty(value = "return_unroutable_details")
  private Details returnUnroutableDetails;

  public Details getReturnUnroutableDetails() {
    return returnUnroutableDetails;
  }

  public void setReturnUnroutableDetails(Details returnUnroutableDetails) {
    this.returnUnroutableDetails = returnUnroutableDetails;
  }

  //endregion
}
