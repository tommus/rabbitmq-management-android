package co.windly.rabbitmqmanagement.network.model.queue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BackingQueueStatus {

  //region Avg Ack Egress Rate

  @JsonProperty(value = "avg_ack_egress_rate")
  private float avgAckEgressRate;

  public float getAvgAckEgressRate() {
    return avgAckEgressRate;
  }

  public void setAvgAckEgressRate(float avgAckEgressRate) {
    this.avgAckEgressRate = avgAckEgressRate;
  }

  //endregion

  //region Avg Ack Ingress Rate

  @JsonProperty(value = "avg_ack_ingress_rate")
  private float avgAckIngressRate;

  public float getAvgAckIngressRate() {
    return avgAckIngressRate;
  }

  public void setAvgAckIngressRate(float avgAckIngressRate) {
    this.avgAckIngressRate = avgAckIngressRate;
  }

  //endregion

  //region Avg Egress Rate

  @JsonProperty(value = "avg_egress_rate")
  private float avgEgressRate;

  public float getAvgEgressRate() {
    return avgEgressRate;
  }

  public void setAvgEgressRate(float avgEgressRate) {
    this.avgEgressRate = avgEgressRate;
  }

  //endregion

  //region Avg Ingress Rate

  @JsonProperty(value = "avg_ingress_rate")
  private float avgIngressRate;

  public float getAvgIngressRate() {
    return avgIngressRate;
  }

  public void setAvgIngressRate(float avgIngressRate) {
    this.avgIngressRate = avgIngressRate;
  }

  //endregion

  //region Delta

  @JsonProperty(value = "delta")
  private List<String> delta = new ArrayList<>();

  public List<String> getDelta() {
    return delta;
  }

  public void setDelta(List<String> delta) {
    this.delta = delta;
  }

  //endregion

  //region Len

  @JsonProperty(value = "len")
  private int len;

  public int getLen() {
    return len;
  }

  public void setLen(int len) {
    this.len = len;
  }

  //endregion

  //region Mode

  @JsonProperty(value = "mode")
  private String mode;

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  //endregion

  //region Next Seq Id

  @JsonProperty(value = "next_seq_id")
  private int nextSeqId;

  public int getNextSeqId() {
    return nextSeqId;
  }

  public void setNextSeqId(int nextSeqId) {
    this.nextSeqId = nextSeqId;
  }

  //endregion

  //region Q1

  @JsonProperty(value = "q1")
  private int q1;

  public int getQ1() {
    return q1;
  }

  public void setQ1(int q1) {
    this.q1 = q1;
  }

  //endregion

  //region Q2

  @JsonProperty(value = "q2")
  private int q2;

  public int getQ2() {
    return q2;
  }

  public void setQ2(int q2) {
    this.q2 = q2;
  }

  //endregion

  //region Q3

  @JsonProperty(value = "q3")
  private int q3;

  public int getQ3() {
    return q3;
  }

  public void setQ3(int q3) {
    this.q3 = q3;
  }

  //endregion

  //region Q4

  @JsonProperty(value = "q4")
  private int q4;

  public int getQ4() {
    return q4;
  }

  public void setQ4(int q4) {
    this.q4 = q4;
  }

  //endregion

  //region Target Ram Count

  @JsonProperty(value = "target_ram_count")
  private String targetRamCount;

  public String getTargetRamCount() {
    return targetRamCount;
  }

  public void setTargetRamCount(String targetRamCount) {
    this.targetRamCount = targetRamCount;
  }

  //endregion
}
