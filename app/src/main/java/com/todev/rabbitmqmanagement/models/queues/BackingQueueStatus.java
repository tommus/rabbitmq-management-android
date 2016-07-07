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
package com.todev.rabbitmqmanagement.models.queues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class BackingQueueStatus {

  @JsonProperty("avg_ack_egress_rate") protected float avgAckEgressRate;

  @JsonProperty("avg_ack_ingress_rate") protected float avgAckIngressRate;

  @JsonProperty("avg_egress_rate") protected float avgEgressRate;

  @JsonProperty("avg_ingress_rate") protected float avgIngressRate;

  @JsonProperty("delta") protected List<String> delta = new ArrayList<>();

  @JsonProperty("len") protected int len;

  @JsonProperty("mode") protected String mode;

  @JsonProperty("next_seq_id") protected int nextSeqId;

  @JsonProperty("q1") protected int q1;

  @JsonProperty("q2") protected int q2;

  @JsonProperty("q3") protected int q3;

  @JsonProperty("q4") protected int q4;

  @JsonProperty("target_ram_count") protected String targetRamCount;

  public float getAvgAckEgressRate() {
    return avgAckEgressRate;
  }

  public float getAvgAckIngressRate() {
    return avgAckIngressRate;
  }

  public float getAvgEgressRate() {
    return avgEgressRate;
  }

  public float getAvgIngressRate() {
    return avgIngressRate;
  }

  public List<String> getDelta() {
    return delta;
  }

  public int getLen() {
    return len;
  }

  public String getMode() {
    return mode;
  }

  public int getNextSeqId() {
    return nextSeqId;
  }

  public int getQ1() {
    return q1;
  }

  public int getQ2() {
    return q2;
  }

  public int getQ3() {
    return q3;
  }

  public int getQ4() {
    return q4;
  }

  public String getTargetRamCount() {
    return targetRamCount;
  }
}
