package co.windly.rabbitmqmanagement.network.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Requirements {

  //region Count

  @JsonProperty(value = "count")
  private int count;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  //endregion

  //region Requeue

  @JsonProperty(value = "requeue")
  private boolean requeue;

  public boolean isRequeue() {
    return requeue;
  }

  public void setRequeue(boolean requeue) {
    this.requeue = requeue;
  }

  //endregion

  //region Encoding

  @JsonProperty(value = "encoding")
  private String encoding;

  public String getEncoding() {
    return encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  //endregion

  //region Truncate

  @JsonProperty(value = "truncate")
  private Long truncate;

  public Long getTruncate() {
    return truncate;
  }

  public void setTruncate(Long truncate) {
    this.truncate = truncate;
  }

  //endregion
}
