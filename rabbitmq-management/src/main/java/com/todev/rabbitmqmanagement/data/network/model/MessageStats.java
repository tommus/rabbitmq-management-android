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
package com.todev.rabbitmqmanagement.data.network.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MessageStats {

  @JsonProperty(value = "ack") protected int ack;

  @JsonProperty(value = "ack_details") protected Details ackDetails;

  @JsonProperty(value = "confirm") protected int confirm;

  @JsonProperty(value = "confirm_details") protected Details confirmDetails;

  @JsonProperty(value = "deliver_get") protected int deliverGet;

  @JsonProperty(value = "deliver_get_details") protected Details deliverGetDetails;

  @JsonProperty(value = "publish") protected int publish;

  @JsonProperty(value = "publish_details") protected Details publishDetails;

  @JsonProperty(value = "publish_in") protected int publishIn;

  @JsonProperty(value = "publish_in_details") protected Details publishInDetails;

  @JsonProperty(value = "publish_out") protected int publishOut;

  @JsonProperty(value = "publish_out_details") protected Details publishOutDetails;

  @JsonProperty(value = "redeliver") protected int redeliver;

  @JsonProperty(value = "redeliver_details") protected Details redeliverDetails;

  @JsonProperty(value = "return_unroutable") protected int returnUnroutable;

  @JsonProperty(value = "return_unroutable_details") protected Details returnUnroutableDetails;

  public int getAck() {
    return ack;
  }

  public Details getAckDetails() {
    return ackDetails;
  }

  public int getConfirm() {
    return confirm;
  }

  public Details getConfirmDetails() {
    return confirmDetails;
  }

  public int getDeliverGet() {
    return deliverGet;
  }

  public Details getDeliverGetDetails() {
    return deliverGetDetails;
  }

  public int getPublish() {
    return publish;
  }

  public Details getPublishDetails() {
    return publishDetails;
  }

  public int getPublishIn() {
    return publishIn;
  }

  public Details getPublishInDetails() {
    return publishInDetails;
  }

  public int getPublishOut() {
    return publishOut;
  }

  public Details getPublishOutDetails() {
    return publishOutDetails;
  }

  public int getRedeliver() {
    return redeliver;
  }

  public Details getRedeliverDetails() {
    return redeliverDetails;
  }

  public int getReturnUnroutable() {
    return returnUnroutable;
  }

  public Details getReturnUnroutableDetails() {
    return returnUnroutableDetails;
  }
}
